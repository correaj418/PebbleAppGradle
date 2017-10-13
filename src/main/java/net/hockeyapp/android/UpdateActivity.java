package net.hockeyapp.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import net.hockeyapp.android.c.c;
import net.hockeyapp.android.d.d;
import net.hockeyapp.android.d.e;
import net.hockeyapp.android.e.a;
import net.hockeyapp.android.e.h;
import net.hockeyapp.android.e.j;
import net.hockeyapp.android.i.b;

public class UpdateActivity extends Activity implements OnClickListener, j {
    protected d a;
    protected j b;
    private c c;
    private Context d;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("App Update");
        setContentView(b());
        this.d = this;
        this.b = new j(this, getIntent().getStringExtra("json"), this);
        c();
        this.a = (d) getLastNonConfigurationInstance();
        if (this.a != null) {
            this.a.a((Context) this);
        }
    }

    public Object onRetainNonConfigurationInstance() {
        if (this.a != null) {
            this.a.a();
        }
        return this.a;
    }

    protected Dialog onCreateDialog(int i) {
        return onCreateDialog(i, null);
    }

    protected Dialog onCreateDialog(int i, Bundle bundle) {
        switch (i) {
            case 0:
                return new Builder(this).setMessage("An error has occured").setCancelable(false).setTitle("Error").setIcon(17301543).setPositiveButton("OK", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ UpdateActivity a;

                    {
                        this.a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.a.c = null;
                        dialogInterface.cancel();
                    }
                }).create();
            default:
                return null;
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        switch (i) {
            case 0:
                AlertDialog alertDialog = (AlertDialog) dialog;
                if (this.c != null) {
                    alertDialog.setMessage(this.c.a());
                    return;
                } else {
                    alertDialog.setMessage("An unknown error has occured.");
                    return;
                }
            default:
                return;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        f();
        if (strArr.length != 0 && iArr.length != 0 && i == 1) {
            if (iArr[0] == 0) {
                h();
                return;
            }
            Log.w("HockeyApp", "User denied write permission, can't continue with updater task.");
            l a = k.a();
            if (a != null) {
                a.c();
            } else {
                new Builder(this.d).setTitle(getString(i.d.hockeyapp_permission_update_title)).setMessage(getString(i.d.hockeyapp_permission_update_message)).setNegativeButton(getString(i.d.hockeyapp_permission_dialog_negative_button), null).setPositiveButton(getString(i.d.hockeyapp_permission_dialog_positive_button), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ UpdateActivity b;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.h();
                    }
                }).create().show();
            }
        }
    }

    public int a() {
        int i = -1;
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 128).versionCode;
        } catch (NameNotFoundException e) {
            return i;
        }
    }

    public ViewGroup b() {
        ViewGroup linearLayout = new LinearLayout(this);
        LayoutInflater.from(this).inflate(i.c.activity_update, linearLayout);
        return linearLayout;
    }

    public void onClick(View view) {
        h();
        view.setEnabled(false);
    }

    protected void c() {
        ((TextView) findViewById(b.label_title)).setText(g());
        final TextView textView = (TextView) findViewById(b.label_version);
        final String str = "Version " + this.b.a();
        final String b = this.b.b();
        String str2 = "Unknown size";
        if (this.b.c() >= 0) {
            str2 = String.format("%.2f", new Object[]{Float.valueOf(((float) r4) / 1048576.0f)}) + " MB";
        } else {
            a.a(new e(this, getIntent().getStringExtra("url"), new net.hockeyapp.android.b.a(this) {
                final /* synthetic */ UpdateActivity d;

                public void a(d dVar) {
                    if (dVar instanceof e) {
                        long c = ((e) dVar).c();
                        textView.setText(str + "\n" + b + " - " + (String.format("%.2f", new Object[]{Float.valueOf(((float) c) / 1048576.0f)}) + " MB"));
                    }
                }
            }));
        }
        textView.setText(str + "\n" + b + " - " + str2);
        ((Button) findViewById(b.button_update)).setOnClickListener(this);
        WebView webView = (WebView) findViewById(b.web_update_details);
        webView.clearCache(true);
        webView.destroyDrawingCache();
        webView.loadDataWithBaseURL("https://sdk.hockeyapp.net/", d(), "text/html", "utf-8", null);
    }

    protected String d() {
        return this.b.a(false);
    }

    protected void e() {
        a(getIntent().getStringExtra("url"));
    }

    protected void a(String str) {
        a(str, new net.hockeyapp.android.b.a(this) {
            final /* synthetic */ UpdateActivity a;

            {
                this.a = r1;
            }

            public void a(d dVar, Boolean bool) {
                if (bool.booleanValue()) {
                    this.a.e();
                } else {
                    this.a.f();
                }
            }

            public void a(d dVar) {
                this.a.f();
            }
        });
        a.a(this.a);
    }

    protected void a(String str, net.hockeyapp.android.b.a aVar) {
        this.a = new d(this, str, aVar);
    }

    public void f() {
        findViewById(b.button_update).setEnabled(true);
    }

    public String g() {
        try {
            PackageManager packageManager = getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(getPackageName(), 0)).toString();
        } catch (NameNotFoundException e) {
            return "";
        }
    }

    private boolean a(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @SuppressLint({"InlinedApi"})
    private boolean i() {
        try {
            if (VERSION.SDK_INT < 17 || VERSION.SDK_INT >= 21) {
                if (Secure.getInt(getContentResolver(), "install_non_market_apps") != 1) {
                    return false;
                }
                return true;
            } else if (Global.getInt(getContentResolver(), "install_non_market_apps") == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SettingNotFoundException e) {
            return true;
        }
    }

    protected void h() {
        if (!h.a(this.d)) {
            this.c = new c();
            this.c.a(getString(i.d.hockeyapp_error_no_network_message));
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ UpdateActivity a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.showDialog(0);
                }
            });
        } else if (a(this.d)) {
            if (i()) {
                e();
                return;
            }
            this.c = new c();
            this.c.a("The installation from unknown sources is not enabled. Please check the device settings.");
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ UpdateActivity a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.showDialog(0);
                }
            });
        } else if (VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        } else {
            this.c = new c();
            this.c.a("The permission to access the external storage permission is not set. Please contact the developer.");
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ UpdateActivity a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.showDialog(0);
                }
            });
        }
    }
}
