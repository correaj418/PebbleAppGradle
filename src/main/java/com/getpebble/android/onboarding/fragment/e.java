package com.getpebble.android.onboarding.fragment;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.FrameworkState.FirmwareInstallData;
import com.getpebble.android.common.model.ae;
import com.getpebble.android.common.model.as;
import com.getpebble.android.common.model.v;
import com.getpebble.android.framework.firmware.FirmwareManifestBundle;
import com.getpebble.android.framework.firmware.FirmwareManifestBundle.FirmwareMetadata;
import com.getpebble.android.main.activity.MainActivity;
import com.getpebble.android.main.sections.support.fragment.SupportFragment;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import com.getpebble.android.widget.PebbleButton;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class e extends b {
    public static final long a = TimeUnit.MINUTES.toMillis(3);
    public static final long b = TimeUnit.SECONDS.toMillis(5);
    private static final long c = TimeUnit.SECONDS.toMillis(10);
    private static String q;
    private Runnable A = new Runnable(this) {
        final /* synthetic */ e a;

        {
            this.a = r1;
        }

        public void run() {
            f.b("FirmwareUpdateFragment", "Running onFirmwareSyncComplete after timeout");
            this.a.u();
        }
    };
    private boolean B = false;
    private Runnable C = new Runnable(this) {
        final /* synthetic */ e a;

        {
            this.a = r1;
        }

        public void run() {
            f.e("FirmwareUpdateFragment", "run: Reboot should be complete, isPrf = " + com.getpebble.android.framework.o.b.a.isInPrf() + ", mIs3xMigration = " + this.a.t);
            this.a.z.removeCallbacks(this.a.D);
            this.a.B = false;
            this.a.o = false;
            Activity activity = this.a.getActivity();
            if (this.a.e()) {
                this.a.w();
            } else if (!this.a.l || activity == null) {
                this.a.a(com.getpebble.android.framework.g.r.a.OK);
                this.a.f();
            } else {
                try {
                    ((OnboardingActivity) activity).e();
                } catch (Throwable e) {
                    f.a("FirmwareUpdateFragment", "Failed to switch to connection manager fragment", e);
                }
            }
        }
    };
    private Runnable D = new Runnable(this) {
        final /* synthetic */ e a;

        {
            this.a = r1;
        }

        public void run() {
            PebbleApplication.x().g();
            this.a.z.postDelayed(this, e.b);
        }
    };
    private com.getpebble.android.framework.b.a E = new com.getpebble.android.framework.b.a(this) {
        final /* synthetic */ e a;

        {
            this.a = r1;
        }

        public void onFrameworkStateChanged(FrameworkState frameworkState) {
            f.e("FirmwareUpdateFragment", "onFrameworkStateChanged: newState = " + frameworkState);
            if (frameworkState != null && frameworkState.a() != null) {
                if (frameworkState.a().equals(com.getpebble.android.common.model.FrameworkState.a.FIRMWARE_INSTALL_PROGRESS_CHANGED)) {
                    f.d("FirmwareUpdateFragment", "onFrameworkStateChanged: Progress: " + frameworkState.d());
                    if (!(this.a.i.getVisibility() == 0 && this.a.o)) {
                        this.a.o = true;
                        f.d("FirmwareUpdateFragment", "onFrameworkStateChanged: got progress but UI was inconsistent; switching to progress view");
                        this.a.a(this.a.w, null);
                    }
                    this.a.i.setProgress(frameworkState.d());
                } else if (frameworkState.a().equals(com.getpebble.android.common.model.FrameworkState.a.FIRMWARE_INSTALL_STATE_CHANGED)) {
                    com.getpebble.android.framework.g.r.a e = frameworkState.e();
                    if (e.equals(com.getpebble.android.framework.g.r.a.OK)) {
                        this.a.B = true;
                        Activity activity = this.a.getActivity();
                        if (activity instanceof OnboardingActivity) {
                            ((OnboardingActivity) activity).a();
                        }
                        this.a.m();
                        this.a.z.postDelayed(this.a.C, e.a);
                        this.a.z.postDelayed(this.a.D, e.b);
                        return;
                    }
                    if (com.getpebble.android.framework.g.r.a.IN_PROGRESS.equals(e)) {
                        this.a.o = true;
                        this.a.a(this.a.w, null);
                    } else {
                        this.a.o = false;
                    }
                    if (!(e.equals(com.getpebble.android.framework.g.r.a.OK) || e.equals(com.getpebble.android.framework.g.r.a.IN_PROGRESS))) {
                        c.g();
                    }
                    this.a.a(e);
                }
            }
        }
    };
    private com.getpebble.android.framework.e.f.a F = new com.getpebble.android.framework.e.f.a(this) {
        final /* synthetic */ e a;

        {
            this.a = r1;
        }

        public void e_() {
            f.e("FirmwareUpdateFragment", "notifyConnectedDeviceChanged: isPrf = " + com.getpebble.android.framework.o.b.a.isInPrf() + ", mIs3xMigration = " + this.a.t);
            if (this.a.B) {
                if (PebbleApplication.n() != null) {
                    this.a.B = false;
                    this.a.d();
                    if (this.a.e()) {
                        this.a.w();
                    } else {
                        this.a.a(new Runnable(this) {
                            final /* synthetic */ AnonymousClass11 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                this.a.a.o = false;
                                this.a.a.a(com.getpebble.android.framework.g.r.a.OK);
                                this.a.a.f();
                                this.a.a.z.removeCallbacks(this.a.a.C);
                                this.a.a.z.removeCallbacks(this.a.a.D);
                            }
                        });
                    }
                }
            } else if (!this.a.l && !this.a.o && com.getpebble.android.framework.o.b.a.isInPrf()) {
                this.a.a(new Runnable(this) {
                    final /* synthetic */ AnonymousClass11 a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        this.a.a.b(null, new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                f.d("FirmwareUpdateFragment", "notifyConnectedDeviceChanged: Connected device was put into PRF mode");
                                this.a.a.a.g();
                                this.a.a.a.y();
                            }
                        });
                    }
                });
            }
        }
    };
    private boolean d = false;
    private com.getpebble.android.common.framework.install.app.b.a e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private ProgressBar i;
    private PebbleButton j;
    private PebbleButton k;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private Intent p = null;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private String u;
    private String v;
    private v w;
    private boolean x = false;
    private boolean y = false;
    private Handler z = new Handler(Looper.getMainLooper());

    private static class a extends com.getpebble.android.bluetooth.b.f {
        private final WeakReference<e> a;

        a(e eVar) {
            this.a = new WeakReference(eVar);
        }

        public boolean doInBackground() {
            new com.getpebble.android.framework.firmware.a(com.getpebble.android.common.a.K()).a();
            return true;
        }

        public void onTaskSuccess() {
            final e eVar = (e) this.a.get();
            if (eVar != null) {
                eVar.a(new Runnable(this) {
                    final /* synthetic */ a b;

                    public void run() {
                        eVar.u();
                    }
                });
            }
        }

        public void onTaskFailed() {
        }
    }

    private void d() {
        f.e("FirmwareUpdateFragment", "sendFwInstallCompleteAnalytics:");
        FrameworkState b = com.getpebble.android.framework.b.b();
        FirmwareInstallData u = b.u();
        if (u != null) {
            c.a(u.a(), u.b(), b.e());
        }
    }

    private void b(PebbleDevice pebbleDevice) {
        if (pebbleDevice != null) {
            q = pebbleDevice.getAddress();
        }
    }

    private boolean e() {
        return com.getpebble.android.framework.o.b.a.isInPrf() && this.t;
    }

    private void f() {
        com.getpebble.android.common.b.b.c cVar = new com.getpebble.android.common.b.b.c(com.getpebble.android.common.a.K());
        if (!this.s || cVar == null) {
            f.d("FirmwareUpdateFragment", "updateFirmwareNagTime: Not updating firmware nag time.");
            return;
        }
        f.d("FirmwareUpdateFragment", "updateFirmwareNagTime: Updating firmware nag time.");
        cVar.b(com.getpebble.android.common.b.b.c.a.FIRMWARE_NAG_TIME, 0);
    }

    public static Fragment a(Activity activity) {
        if (com.getpebble.android.onboarding.a.d(PebbleApplication.n())) {
            return new i();
        }
        if (z()) {
            return new m();
        }
        return new e();
    }

    public int c() {
        return R.layout.fragment_firmware_update;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.d("FirmwareUpdateFragment", "init: Setting up Firmware Update fragment");
        c.d("OnboardingSoftwareUpdate");
        this.u = getString(R.string.onboarding_updating_to_latest_firmware);
        this.f = (TextView) viewGroup.findViewById(R.id.onboarding_banner);
        this.g = (TextView) viewGroup.findViewById(R.id.firmware_update_text);
        this.h = (ImageView) viewGroup.findViewById(R.id.update_icon);
        this.i = (ProgressBar) viewGroup.findViewById(R.id.onboarding_firmware_install_progress);
        this.j = (PebbleButton) viewGroup.findViewById(R.id.fw_update_upper_btn);
        this.k = (PebbleButton) viewGroup.findViewById(R.id.fw_update_lower_btn);
        com.getpebble.android.framework.b.a(this.E);
        PebbleApplication.a(this.F);
        new com.getpebble.android.bluetooth.b.f(this) {
            final /* synthetic */ e a;

            {
                this.a = r1;
            }

            public boolean doInBackground() {
                ae.a(com.getpebble.android.common.model.a.FW_UPDATE, com.getpebble.android.common.a.K().getContentResolver());
                return false;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    private void a(Intent intent) {
        f.d("FirmwareUpdateFragment", "initForIntent()");
        this.m = true;
        this.u = intent.getStringExtra("extra_firmware_notes");
        this.v = intent.getStringExtra("extra_firmware_url");
        this.n = intent.getBooleanExtra("extra_prf_install", false);
        this.t = intent.getBooleanExtra("extra_fw_3x_migration", false);
        if (this.n) {
            g();
            k();
            return;
        }
        l();
        b(null, new Runnable(this) {
            final /* synthetic */ e a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.x();
            }
        });
    }

    public static void a() {
        f.e("FirmwareUpdateFragment", "resetBundleNotFound: ");
        q = null;
    }

    public static boolean a(PebbleDevice pebbleDevice) {
        boolean z = false;
        if (pebbleDevice != null) {
            z = pebbleDevice.getAddress().equalsIgnoreCase(q);
        }
        f.e("FirmwareUpdateFragment", "hadBundleNotFound: return " + z + " for device " + pebbleDevice);
        return z;
    }

    private void g() {
        int i;
        if (com.getpebble.android.framework.firmware.b.a()) {
            i = R.string.onboarding_need_prf_2x_update;
        } else {
            i = R.string.onboarding_need_prf_update;
        }
        this.g.setText(getString(i));
        this.j.setVisibility(8);
        this.k.setVisibility(8);
    }

    public void onResume() {
        boolean z = false;
        super.onResume();
        com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
        if (!(p == null || p.hwPlatform.getPlatformCode().equals(this.e))) {
            this.e = p.hwPlatform.getPlatformCode();
        }
        o();
        Context activity = getActivity();
        if (activity == null) {
            f.a("FirmwareUpdateFragment", "onResume() activity is null");
            return;
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
            f.b("FirmwareUpdateFragment", "onResume() intent is null");
            return;
        }
        if (b()) {
            f.b("FirmwareUpdateFragment", "onResume() Already installing; not starting install");
            Toast.makeText(activity, getString(R.string.firmware_sideload_busy), 0).show();
        } else {
            f.d("FirmwareUpdateFragment", "onResume() Starting Sideload! (or onboarding)");
            if (this.p != null || intent.hasExtra("extra_firmware_url") || intent.hasExtra("extra_prf_install")) {
                z = true;
            }
            this.s = z;
            this.l = activity instanceof OnboardingActivity;
            if (this.s) {
                long longExtra = intent.getLongExtra("extra_fw_update_timestamp", 0);
                long a = PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.LAST_FW_SIDELOAD_TIMESTAMP_MS, 0);
                if (longExtra <= a) {
                    f.d("FirmwareUpdateFragment", "Attempted to sideload an old firmware [timestamp = " + longExtra + ", last install timestamp = " + a + "] -- not handling.");
                    a(com.getpebble.android.framework.g.r.a.OLD_SIDELOAD_REQUEST);
                } else {
                    PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.LAST_FW_SIDELOAD_TIMESTAMP_MS, longExtra);
                    this.p = intent;
                    a(intent);
                    j();
                }
            } else if (this.l || com.getpebble.android.framework.firmware.b.a()) {
                k();
            } else {
                h();
            }
        }
        activity.setIntent(null);
    }

    public void onStop() {
        super.onStop();
        if (!b()) {
            Activity activity = getActivity();
            if (activity == null) {
                f.a("FirmwareUpdateFragment", "onStop: Activity was null");
            } else if (activity.getIntent() == null) {
                f.a("FirmwareUpdateFragment", "onStop: Activity's intent was null");
            } else if (this.s) {
                activity.finish();
            }
        }
    }

    public void onDestroyView() {
        com.getpebble.android.framework.b.b(this.E);
        PebbleApplication.b(this.F);
        this.z.removeCallbacksAndMessages(null);
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        super.onDestroyView();
    }

    private void h() {
        f.d("FirmwareUpdateFragment", "initForNotOnboarding: Not onboarding!");
        this.g.setText(R.string.text_check_if_up_to_date);
        this.j.setVisibility(0);
        this.j.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.j.setVisibility(8);
                this.a.k.setVisibility(8);
                this.a.k();
            }
        });
        this.k.setVisibility(0);
        this.k.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                c.e("notNow", "OnboardingSoftwareUpdate");
                this.a.s();
            }
        });
        i();
    }

    private void i() {
        this.f.setVisibility(getActivity() instanceof OnboardingActivity ? 0 : 8);
    }

    private void j() {
        f.d("FirmwareUpdateFragment", "initForSideload: Sideloading");
        this.f.setVisibility(8);
    }

    private void k() {
        f.d("FirmwareUpdateFragment", "initForChecking()");
        if (com.getpebble.android.framework.o.b.a.isInPrf()) {
            g();
        }
        if (getActivity() != null) {
            c.e("startUpdate", "OnboardingSoftwareUpdate");
            l();
            t();
            a aVar = new a(this);
            this.z.postDelayed(this.A, c);
            aVar.submit();
            i();
        }
    }

    private void a(int i) {
        Activity activity = getActivity();
        if (this.l) {
            if (this.f != null) {
                this.f.setText(i);
            }
        } else if (activity != null) {
            ActionBar actionBar = activity.getActionBar();
            if (actionBar != null) {
                actionBar.setTitle(i);
            }
            this.f.setVisibility(8);
        }
    }

    private void l() {
        a((int) R.string.en_onb_banner_checking_for_updates);
        this.g.setText(R.string.text_fw_checking_in_progress);
    }

    private void a(v vVar, Runnable runnable) {
        f.d("FirmwareUpdateFragment", "showFirmwareProgressUI()");
        a((int) R.string.en_onb_banner_updating);
        o();
        this.g.setText(this.u);
        this.i.setVisibility(0);
        if (vVar != null) {
            this.g.setText(String.format(getString(R.string.text_installing_firmware_version), new Object[]{vVar.toString()}));
        }
        this.k.setVisibility(8);
        this.j.setVisibility(8);
        if (runnable != null) {
            runnable.run();
        }
    }

    private void b(v vVar, Runnable runnable) {
        a(vVar, runnable);
    }

    private void m() {
        this.i.setVisibility(8);
        this.g.setText(R.string.text_reconnecting);
    }

    private void a(com.getpebble.android.framework.g.r.a aVar) {
        boolean z = true;
        if (!com.getpebble.android.framework.g.r.a.IN_PROGRESS.equals(aVar)) {
            int i;
            a((int) R.string.fw_update_failed);
            this.r = !aVar.isSuccess;
            f.d("FirmwareUpdateFragment", "handleFirmwareInstallResult: result: " + aVar);
            switch (aVar) {
                case OK:
                    a((int) R.string.en_onb_banner_update_complete);
                    q();
                    i = R.string.onboarding_pebble_up_to_date;
                    break;
                case WRONG_HW_VERSION:
                    i = R.string.onboarding_firmware_incompatible;
                    break;
                case NO_FIRMWARE_FOR_3X_MIGRATION:
                    a((int) R.string.fw_3x_migration_failed);
                    b(PebbleApplication.n());
                    i = R.string.onboarding_migration_firmware_not_found;
                    break;
                case BUNDLE_NOT_FOUND:
                    if (this.l) {
                        b(PebbleApplication.n());
                    }
                    i = R.string.onboarding_firmware_not_found;
                    break;
                case TIMEOUT:
                    i = R.string.onboarding_firmware_timeout;
                    break;
                case NO_DEVICE_CONNECTED:
                    i = R.string.onboarding_firmware_no_device;
                    break;
                case OLD_SIDELOAD_REQUEST:
                    i = R.string.onboarding_firmware_install_request;
                    break;
                default:
                    i = R.string.update_failed_explanation;
                    break;
            }
            this.g.setText(i);
            this.i.setVisibility(8);
            f.d("FirmwareUpdateFragment", "mFirmwareInstallFailed: " + this.r);
            if (aVar.isSuccess) {
                this.j.setVisibility(8);
                this.k.setVisibility(0);
                this.k.setBackgroundResource(R.drawable.btn_onboarding_red_states);
                this.k.setText(R.string.fw_update_continue);
                this.k.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ e a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        c.e("continue", "OnboardingSoftwareUpdate");
                        this.a.s();
                    }
                });
                return;
            }
            p();
            boolean B = B();
            boolean A = A();
            if (!(aVar.isPrfResetRequired && this.d && (!B || A))) {
                z = false;
            }
            if (z) {
                this.j.setText(R.string.onboarding_banner_reset_your_pebble);
            } else {
                this.j.setText(R.string.retry_update);
            }
            f.d("FirmwareUpdateFragment", "updateUiForInstallResult: resetIntoPRF? " + z + " (isPrfResetRequired=" + aVar.isPrfResetRequired + ", isRetryAttempted=" + this.d + ", isResumedUpdatesSupported=" + B + ", isResumedUpdatesDisabled=" + A + ")");
            this.j.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ e b;

                public void onClick(View view) {
                    if (z) {
                        this.b.r();
                        return;
                    }
                    this.b.o();
                    this.b.j.setVisibility(8);
                    this.b.k.setVisibility(8);
                    if (!this.b.s || this.b.p == null) {
                        this.b.k();
                    } else {
                        this.b.a(this.b.p);
                    }
                    this.b.d = true;
                }
            });
            this.j.setVisibility(0);
            this.k.setText(R.string.support_diag_label);
            this.k.setBackgroundResource(R.drawable.btn_onboarding_gray_states);
            this.k.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ e a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    SupportFragment.a(this.a.getActivity());
                }
            });
            this.k.setVisibility(0);
        }
    }

    private void n() {
        int i;
        if (this.e == com.getpebble.android.common.framework.install.app.b.a.CHALK) {
            i = R.drawable.fu_recovery_s4;
        } else if (this.e == com.getpebble.android.common.framework.install.app.b.a.APLITE) {
            i = R.drawable.fu_tintinprf;
        } else {
            i = R.drawable.fu_recovery;
        }
        this.h.setImageResource(i);
    }

    private void o() {
        int i;
        if (this.e == com.getpebble.android.common.framework.install.app.b.a.CHALK) {
            i = R.drawable.fu_update_s4;
        } else {
            i = R.drawable.fu_update;
        }
        this.h.setImageResource(i);
    }

    private void p() {
        int i;
        if (this.e == com.getpebble.android.common.framework.install.app.b.a.CHALK) {
            i = R.drawable.fu_error_s4;
        } else {
            i = R.drawable.fu_error;
        }
        this.h.setImageResource(i);
    }

    private void q() {
        int i;
        if (this.e == com.getpebble.android.common.framework.install.app.b.a.CHALK) {
            i = R.drawable.fu_ok_s4;
        } else {
            i = R.drawable.fu_ok;
        }
        this.h.setImageResource(i);
    }

    private void r() {
        this.f.setText(R.string.onboarding_banner_reset_your_pebble);
        n();
        this.g.setText(R.string.onboarding_reset_pebble_instructions);
        this.j.setVisibility(8);
        this.k.setBackgroundResource(R.drawable.btn_onboarding_red_states);
        this.k.setText(R.string.onboarding_i_see_loading_screen);
        this.k.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.o();
                this.a.j.setVisibility(8);
                this.a.k.setVisibility(8);
                this.a.k();
            }
        });
    }

    public boolean b() {
        f.d("FirmwareUpdateFragment", "isInstalling: mIsInstalling = " + this.o + " || mIsRebooting = " + this.B);
        return this.o || this.B;
    }

    private void s() {
        f.d("FirmwareUpdateFragment", "goToNextScreen()");
        Context activity = getActivity();
        if (activity == null) {
            f.d("FirmwareUpdateFragment", "goToNextScreen: Unable to continue");
        } else if (this.l) {
            ((OnboardingActivity) activity).i();
        } else if (this.m) {
            f.d("FirmwareUpdateFragment", "goToNextScreen: Finishing activity");
            Intent intent = new Intent(activity, MainActivity.class);
            intent.setFlags(335544320);
            startActivity(intent);
            activity.finish();
        } else {
            activity.finish();
        }
    }

    private synchronized void t() {
        f.d("FirmwareUpdateFragment", "checkForUpdates: Checking for updates");
        if (v()) {
            w();
        } else {
            this.y = true;
        }
    }

    private synchronized void u() {
        f.d("FirmwareUpdateFragment", "onFirmwareSyncComplete: ");
        this.z.removeCallbacks(this.A);
        this.x = true;
        if (this.y) {
            w();
        }
    }

    private synchronized boolean v() {
        return this.x;
    }

    private void a(Runnable runnable) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(runnable);
        }
    }

    private void w() {
        f.d("FirmwareUpdateFragment", "checkForFirmwareUpdate: Checking for firmware update");
        com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
        if (r == null) {
            a(com.getpebble.android.framework.g.r.a.NO_DEVICE_CONNECTED);
        } else {
            new com.getpebble.android.c.a(com.getpebble.android.common.a.K(), r.pebbleDevice, r.getFwVersion(), new com.getpebble.android.c.a.a(this) {
                final /* synthetic */ e a;

                {
                    this.a = r1;
                }

                public void a(PebbleDevice pebbleDevice, final FirmwareManifestBundle firmwareManifestBundle) {
                    if (firmwareManifestBundle != null) {
                        f.d("FirmwareUpdateFragment", "firmwareUpdateCheckTask: onFirmwareUpdateCheckComplete: Found firmware update");
                        this.a.a(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 b;

                            public void run() {
                                FirmwareMetadata firmwareMetadataToInstall = firmwareManifestBundle.getFirmwareMetadataToInstall();
                                this.b.a.v = firmwareMetadataToInstall.getUrl();
                                this.b.a.u = firmwareMetadataToInstall.getNotes();
                                this.b.a.t = firmwareManifestBundle.is3xMigrationMetadata(firmwareMetadataToInstall);
                                this.b.a.w = firmwareMetadataToInstall.getFriendlyVersion();
                                this.b.a.b(this.b.a.w, new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 a;

                                    {
                                        this.a = r1;
                                    }

                                    public void run() {
                                        this.a.b.a.x();
                                    }
                                });
                            }
                        });
                        return;
                    }
                    f.d("FirmwareUpdateFragment", "firmwareUpdateCheckTask: onFirmwareUpdateCheckComplete: No firmware update");
                    this.a.b(PebbleApplication.n());
                    final com.getpebble.android.framework.g.r.a aVar = com.getpebble.android.framework.firmware.b.a() ? com.getpebble.android.framework.g.r.a.NO_FIRMWARE_FOR_3X_MIGRATION : com.getpebble.android.framework.g.r.a.OK;
                    this.a.a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 b;

                        public void run() {
                            this.b.a.a(aVar);
                        }
                    });
                }

                public void a(PebbleDevice pebbleDevice) {
                    if (this.a.B) {
                        f.d("FirmwareUpdateFragment", "firmwareUpdateCheckTask: onInRecoveryMode: there is nothing to do, the watch is rebooting");
                        return;
                    }
                    f.d("FirmwareUpdateFragment", "firmwareUpdateCheckTask: onInRecoveryMode:");
                    this.a.a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            this.a.a.u = this.a.a.getString(R.string.onboarding_updating_to_latest_firmware);
                            this.a.a.b(null, new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 a;

                                {
                                    this.a = r1;
                                }

                                public void run() {
                                    this.a.a.a.g();
                                    this.a.a.a.y();
                                }
                            });
                        }
                    });
                }

                public void a() {
                }

                public void b() {
                }
            }).submit();
        }
    }

    private void x() {
        f.d("FirmwareUpdateFragment", "startFirmwareInstall: Starting firmware install for " + this.v);
        com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
        if (r == null) {
            f.b("FirmwareUpdateFragment", "startFirmwareInstall: deviceRecord is null; not updating");
            a(com.getpebble.android.framework.g.r.a.NO_DEVICE_CONNECTED);
            return;
        }
        this.o = true;
        PebbleApplication.x().a(r.pebbleDevice, Uri.parse(this.v));
    }

    private void y() {
        f.d("FirmwareUpdateFragment", "startFirmwareInstallWhileInPrf: startFirmwareInstallWhileInPrf");
        PebbleDevice n = PebbleApplication.n();
        if (n == null) {
            f.d("FirmwareUpdateFragment", "startFirmwareInstallWhileInPrf: Failed to start install -- connected device was null.");
            a(com.getpebble.android.framework.g.r.a.NO_DEVICE_CONNECTED);
            return;
        }
        this.o = true;
        PebbleApplication.x().c(n);
    }

    private static boolean z() {
        return com.getpebble.android.framework.firmware.b.a();
    }

    private boolean A() {
        if (PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.DISABLE_RESUMED_UPDATES_USER, false)) {
            return true;
        }
        Context K = com.getpebble.android.common.a.K();
        Object a = as.a(K.getContentResolver(), "PEBBLE_PREFERENCES", K.getResources().getString(com.getpebble.android.common.b.b.c.a.DISABLE_RESUMED_UPDATES_ERROR.getResId()), as.b.BOOLEAN);
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        return Boolean.parseBoolean(a);
    }

    private boolean B() {
        com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
        if (p == null) {
            return false;
        }
        return p.capabilities.supportsFwUpdateAcrossDisconnection;
    }
}
