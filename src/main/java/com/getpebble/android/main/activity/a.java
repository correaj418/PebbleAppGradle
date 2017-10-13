package com.getpebble.android.main.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.ae;
import com.getpebble.android.common.model.z;
import com.getpebble.android.framework.firmware.FirmwareManifestBundle;
import com.getpebble.android.framework.firmware.FirmwareManifestBundle.FirmwareMetadata;
import com.getpebble.android.framework.firmware.b;
import com.getpebble.android.main.sections.support.activity.FirmwareUpdateActivity;
import com.getpebble.android.main.sections.support.activity.SupportHelpdeskActivity;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import com.getpebble.android.onboarding.fragment.e;

public abstract class a extends com.getpebble.android.core.a {
    private Intent a;
    private AlertDialog b;
    private AlertDialog c;
    private com.getpebble.android.c.a d;
    private final Object e = new Object();
    private com.getpebble.android.framework.e.f.a f = new com.getpebble.android.framework.e.f.a(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public void e_() {
            f.e("CheckUpdateActivity", "notifyConnectedDeviceChanged:");
            this.a.runOnUiThread(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.a.a(true);
                }
            });
        }
    };

    public void onResume() {
        super.onResume();
        a(false);
        PebbleApplication.a(this.f);
        b.a((Activity) this);
    }

    protected void onPostResume() {
        super.onPostResume();
        FrameworkState b = com.getpebble.android.framework.b.b();
        if (b != null && b.e().equals(com.getpebble.android.framework.g.r.a.IN_PROGRESS) && this.a != null) {
            f.b("CheckUpdateActivity", "onPostResume: FW install is in progress; jumping to FW install screen");
            a(this.a);
        }
    }

    public void onPause() {
        super.onPause();
        PebbleApplication.b(this.f);
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
    }

    public void onDestroy() {
        this.f = null;
        super.onDestroy();
    }

    private void a(boolean z) {
        if (this instanceof SupportHelpdeskActivity) {
            f.d("CheckUpdateActivity", "Not doing firmware check for SupportHelpdeskActivity");
        } else if (this.c != null || this.a != null) {
            f.e("CheckUpdateActivity", "checkFirmwareStatus: there is a firmware sideloading (or whatever mFirmwareUpdateDialogShowing implies) process going on");
        } else if (b.b()) {
            f.c("CheckUpdateActivity", "checkFirmwareStatus: skipping because user has disabled updates");
        } else if (!e() && !a()) {
            boolean b = c.b((Context) this);
            if (z || b) {
                g();
            } else {
                f.e("CheckUpdateActivity", "checkFirmwareStatus: too soon to check for update");
            }
        }
    }

    public final void a(Intent intent) {
        this.a = intent;
        startActivity(intent);
    }

    private boolean a() {
        if (!b.a() || e.a(PebbleApplication.n()) || com.getpebble.android.onboarding.activity.b.f() == null) {
            return false;
        }
        f.e("CheckUpdateActivity", "startFirmwareUpdateIfMigrationNeeded: force firmware update because watch need migration. device in prf = " + com.getpebble.android.framework.o.b.a.isInPrf());
        startActivity(new Intent(this, OnboardingActivity.class));
        return true;
    }

    private boolean e() {
        if (!com.getpebble.android.framework.o.b.a.isInPrf() || com.getpebble.android.onboarding.activity.b.f() == null) {
            return false;
        }
        f.e("CheckUpdateActivity", "startOnboardingIfIsInPrf: force firmware update because watch in prf");
        startActivity(new Intent(this, OnboardingActivity.class));
        return true;
    }

    private void f() {
        synchronized (this.e) {
            f.d("CheckUpdateActivity", "resetFirmwareUpdateTask:");
            this.d = null;
        }
    }

    private void g() {
        synchronized (this.e) {
            final com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            if (r == null) {
                f.e("CheckUpdateActivity", "checkForFirmwareUpdates: no connectedDeviceRecord.");
            } else if (this.d != null) {
                f.e("CheckUpdateActivity", "checkForFirmwareUpdates: FirmwareUpdate task is already running.");
            } else {
                f.e("CheckUpdateActivity", "checkForFirmwareUpdates:");
                this.d = new com.getpebble.android.c.a(this, r.pebbleDevice, r.getFwVersion(), new com.getpebble.android.c.a.a(this) {
                    final /* synthetic */ a b;

                    public void a(PebbleDevice pebbleDevice, FirmwareManifestBundle firmwareManifestBundle) {
                        if (firmwareManifestBundle == null) {
                            f.d("CheckUpdateActivity", "checkForFirmwareUpdates: No firmware found");
                            this.b.f();
                            return;
                        }
                        final FirmwareMetadata firmwareMetadataToInstall = firmwareManifestBundle.getFirmwareMetadataToInstall();
                        com.getpebble.android.common.b.a.a.c.a(firmwareMetadataToInstall.getFriendlyVersion().getVersionTag(), firmwareMetadataToInstall.getUrl(), String.valueOf(firmwareMetadataToInstall.getTimestamp()));
                        f.c("CheckUpdateActivity", "checkForFirmwareUpdates: Found installable firmware!");
                        final boolean is3xMigrationMetadata = firmwareManifestBundle.is3xMigrationMetadata(firmwareMetadataToInstall);
                        this.b.runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 c;

                            public void run() {
                                if (is3xMigrationMetadata) {
                                    f.e("CheckUpdateActivity", "displayFirmwareUpdateAvailableDialog: it is a migration firmware not need to acknowledge dialog");
                                    this.c.b.b(firmwareMetadataToInstall, is3xMigrationMetadata);
                                    return;
                                }
                                this.c.b.a(firmwareMetadataToInstall, is3xMigrationMetadata);
                            }
                        });
                        this.b.f();
                    }

                    public void a(PebbleDevice pebbleDevice) {
                        f.d("CheckUpdateActivity", "checkForFirmwareUpdates: onInRecoveryMode:");
                        if (!a.b(r.getHwPlatform())) {
                            e.a();
                        }
                        this.b.e();
                        this.b.f();
                    }

                    public void a() {
                        f.d("CheckUpdateActivity", "checkForFirmwareUpdates: onTaskFailed:");
                        this.b.f();
                    }

                    public void b() {
                        f.d("CheckUpdateActivity", "checkForFirmwareUpdates: onCancelled:");
                    }
                });
                this.d.submit();
            }
        }
    }

    private void a(final FirmwareMetadata firmwareMetadata, final boolean z) {
        if (ae.b(com.getpebble.android.common.model.a.FW_UPDATE, getContentResolver())) {
            if (this.b != null) {
                this.b.dismiss();
            }
        } else if (this.b == null) {
            OnClickListener anonymousClass3 = new OnClickListener(this) {
                final /* synthetic */ a c;

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.c.b(firmwareMetadata, z);
                    this.c.b = null;
                }
            };
            this.b = new Builder(this).setTitle(getString(R.string.my_pebble_firmware_update_available)).setMessage(getString(R.string.my_pebble_ask_install_new_firmware)).setPositiveButton(R.string.my_pebble_install, anonymousClass3).setNegativeButton(R.string.text_not_now, new OnClickListener(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    ae.a(new com.getpebble.android.common.model.ae.a(System.currentTimeMillis(), com.getpebble.android.common.model.a.FW_UPDATE), com.getpebble.android.common.a.K().getContentResolver());
                    c.c(this.a);
                    this.a.invalidateOptionsMenu();
                    dialogInterface.dismiss();
                    this.a.b = null;
                }
            }).setCancelable(false).show();
        }
    }

    public void a(final Activity activity, final Uri uri, String str, final String str2) {
        f.e("CheckUpdateActivity", "displayFirmwareSideloadingDialog: ");
        if (activity == null) {
            f.a("CheckUpdateActivity", "displayFirmwareSideloadingDialog: Failed to display firmware sideloading dialog: context was null.");
            return;
        }
        this.c = new Builder(activity).setTitle(getString(R.string.my_pebble_load_untrusted_bundle)).setMessage(String.format(getString(R.string.my_pebble_untrusted_bundle_message), new Object[]{str})).setPositiveButton(R.string.my_pebble_install, new OnClickListener(this) {
            final /* synthetic */ a d;

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent intent = new Intent(activity, FirmwareUpdateActivity.class);
                String str = "";
                long currentTimeMillis = System.currentTimeMillis();
                if (str2 != null) {
                    str = String.format(this.d.getString(R.string.my_pebble_custom_firmware_bundle), new Object[]{str2});
                }
                intent.putExtra("extra_firmware_notes", str);
                intent.putExtra("extra_firmware_url", uri.toString());
                intent.putExtra("extra_fw_update_timestamp", currentTimeMillis);
                f.d("CheckUpdateActivity", "displayFirmwareSideloadingDialog: FirmwareUpdateTimeStamp = " + currentTimeMillis);
                intent.setFlags(335544320);
                this.d.a(intent);
                this.d.c = null;
            }
        }).setNegativeButton(17039360, new OnClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.a.c = null;
            }
        }).setCancelable(false).show();
    }

    private void b(FirmwareMetadata firmwareMetadata, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent(this, FirmwareUpdateActivity.class);
        intent.putExtra("extra_firmware_notes", firmwareMetadata.getNotes());
        intent.putExtra("extra_firmware_url", firmwareMetadata.getUrl());
        intent.putExtra("extra_fw_update_timestamp", currentTimeMillis);
        intent.putExtra("extra_fw_3x_migration", z);
        intent.setFlags(335544320);
        startActivity(intent);
    }

    private static boolean b(z zVar) {
        return false;
    }
}
