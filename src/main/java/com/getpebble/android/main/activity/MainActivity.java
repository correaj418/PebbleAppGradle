package com.getpebble.android.main.activity;

import android.app.ActionBar;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager.OnBackStackChangedListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.model.ae;
import com.getpebble.android.common.model.ap;
import com.getpebble.android.font.CustomTypefaceSpan;
import com.getpebble.android.framework.e.f.a;
import com.getpebble.android.h.h;
import com.getpebble.android.h.j;
import com.getpebble.android.h.z;
import com.getpebble.android.main.fragment.a.b;
import com.getpebble.android.notifications.b.d;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends b {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private CharSequence b;
    private int c = R.drawable.ic_drawer_mypebble;
    private int d = R.color.actionbar_bg;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private b h;
    private boolean i = false;
    private final d j = new d(MainActivity.class);
    private int k = -1;
    private boolean l = false;
    private ReentrantLock m = new ReentrantLock();
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private a r = new a(this) {
        final /* synthetic */ MainActivity a;

        {
            this.a = r1;
        }

        public void e_() {
            this.a.runOnUiThread(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 a;

                {
                    this.a = r1;
                }

                public void run() {
                    if (this.a.a.q && this.a.a.m.tryLock()) {
                        try {
                            this.a.a.i();
                        } finally {
                            this.a.a.m.unlock();
                        }
                    }
                }
            });
        }
    };
    private OnBackStackChangedListener s = new OnBackStackChangedListener(this) {
        final /* synthetic */ MainActivity a;

        {
            this.a = r1;
        }

        public void onBackStackChanged() {
            if (this.a.c() == null) {
                f.d("MainActivity", "addOnBackStackChangedListener: Current fragment: " + null + ", allow null stack: " + this.a.l);
                if (!this.a.l) {
                    this.a.finish();
                    return;
                }
                return;
            }
            this.a.h = com.getpebble.android.main.fragment.a.a(this.a.c());
            this.a.a(this.a.h);
            this.a.g();
            this.a.h();
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        try {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
            Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.setBoolean(viewConfiguration, false);
            }
        } catch (Exception e) {
            f.d("MainActivity", "Error showing overflow menu icon");
        }
        this.p = PebbleApplication.w().Q();
        if (this.p) {
            f.d("MainActivity", "Showing KillSwitchDialogFragment");
            com.getpebble.android.main.fragment.b bVar = new com.getpebble.android.main.fragment.b();
            bVar.setStyle(1, 0);
            bVar.setCancelable(false);
            bVar.show(getFragmentManager(), "MainActivity");
            return;
        }
        a();
        getFragmentManager().addOnBackStackChangedListener(this.s);
        if (c() == null) {
            a(this.c);
        } else {
            h();
        }
        PebbleApplication.a(this.r);
        this.o = ap.isHealthEnabled();
    }

    private void h() {
        if (c() != null) {
            b a = com.getpebble.android.main.fragment.a.a(c());
            f.d("MainActivity", "Current fragment: " + c().getClass());
            if (a != null) {
                b(com.getpebble.android.main.fragment.a.a(a));
            }
        }
    }

    protected void a() {
        PebbleApplication.s();
    }

    private void a(b bVar) {
        if (bVar != null) {
            com.getpebble.android.main.fragment.a.a a = com.getpebble.android.main.fragment.a.a(bVar);
            f.d("MainActivity", "Current fragment: " + c().getClass());
            if (bVar == null || a == null) {
                f.a("MainActivity", "Could not retrieve style for fragment, using AppTheme");
                return;
            }
            b(a);
            a(a);
        }
    }

    private void a(com.getpebble.android.main.fragment.a.a aVar) {
        if (aVar == null) {
            f.a("MainActivity", "Failed to set statusbar color: fragment data was null");
        } else if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(getResources().getColor(aVar.b()));
            }
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    private void b(Intent intent) {
        j jVar = new j(intent, getApplicationContext());
        this.n = jVar.f();
        try {
            z zVar = new z(this, intent);
            if (jVar.b()) {
                try {
                    a(jVar);
                } catch (Throwable e) {
                    f.a("MainActivity", "Failed to handle deep link.", e);
                }
            } else if (zVar.a()) {
                try {
                    this.n = true;
                    a(zVar);
                } catch (Throwable e2) {
                    f.a("MainActivity", "Failed to handle sideloading intent.", e2);
                }
            }
            if (intent != null && intent.getBooleanExtra("show_cmf", false)) {
                this.f = false;
            }
        } catch (Throwable e22) {
            f.a("MainActivity", "Failed to load sideload file", e22);
            Toast.makeText(this, R.string.sideloading_cant_load_file, 0).show();
        }
    }

    private void a(j jVar) {
        if (jVar.c()) {
            b d = jVar.d();
            if (d != null) {
                setIntent(null);
                f.d("MainActivity", "handleDeepLink: switching fragment");
                a(d, jVar.e());
                this.e = true;
                return;
            }
            f.a("MainActivity", "DeepLink needs fragment switch, but no fragment type found.");
        } else if (jVar.b()) {
            jVar.a();
        }
    }

    private void a(z zVar) {
        b b = zVar.b();
        if (b != null) {
            c.c(this);
            setIntent(null);
            f.d("MainActivity", "handleSideloadingIntent: switching fragment");
            a(b, zVar.c());
            this.e = true;
            return;
        }
        f.a("MainActivity", "Sideloading needs fragment switch, but no fragment type found.");
    }

    private void b(b bVar) {
        a(bVar, null);
    }

    public void onDestroy() {
        getFragmentManager().removeOnBackStackChangedListener(this.s);
        this.s = null;
        a.removeCallbacks(null);
        PebbleApplication.b(this.r);
        this.r = null;
        this.j.b();
        super.onDestroy();
    }

    public void a(b bVar, Bundle bundle) {
        com.getpebble.android.main.fragment.a.a a = com.getpebble.android.main.fragment.a.a(bVar);
        if (a == null) {
            f.a("MainActivity", "No fragment data!");
        } else if (isFinishing() || d()) {
            f.c("MainActivity", "Activity destroyed; not switching fragment");
        } else {
            int i;
            this.b = null;
            if (a.c() && !h.a(this)) {
                f.c("MainActivity", "Fragment: " + bVar + " requested, but needs internet connection which is not available...");
                bVar = b.NO_NETWORK_CONNECTION;
                a = com.getpebble.android.main.fragment.a.a(bVar);
                if (a == null) {
                    f.a("MainActivity", "No fragment data! (NO_NETWORK_CONNECTION)");
                    return;
                }
            }
            Fragment b = a.b(bundle);
            if (c(bVar)) {
                this.l = true;
                i = 1;
            } else {
                i = 0;
            }
            if (this.k >= 0) {
                getFragmentManager().popBackStack(this.k, i);
            }
            if (c(bVar)) {
                boolean z;
                if (this.k >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                i = a(b, true, z, true);
                this.l = false;
                if (i >= 0) {
                    this.k = i;
                    return;
                }
                return;
            }
            a(b, true, false, true);
        }
    }

    private boolean c(b bVar) {
        return bVar.equals(b.MY_PEBBLE);
    }

    private void b(com.getpebble.android.main.fragment.a.a aVar) {
        this.d = aVar.a();
        f();
    }

    public void onStart() {
        super.onStart();
        PebbleApplication.a(true);
    }

    public void onStop() {
        super.onStop();
        PebbleApplication.D();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                j();
                return;
            case 2:
                b(b.MY_PEBBLE);
                return;
            default:
                return;
        }
    }

    public void onPostResume() {
        f.d("MainActivity", "onPostResume: ");
        super.onPostResume();
        if (!this.p) {
            this.e = false;
            com.getpebble.android.framework.d x = PebbleApplication.x();
            if (x != null) {
                x.g();
            } else {
                f.b("MainActivity", "onPostResume: frameworkInterface is null");
            }
            com.getpebble.android.config.b.a(getApplicationContext(), null, false);
            a(this.h);
            Intent intent = getIntent();
            if (intent != null) {
                b(intent);
                setIntent(null);
            }
            if (i()) {
                f.d("MainActivity", "onPostResume: Running Onboarding");
                return;
            }
            this.q = true;
            j();
        }
    }

    private boolean i() {
        if (!e()) {
            return false;
        }
        a.post(new Runnable(this) {
            final /* synthetic */ MainActivity a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.startActivityForResult(new Intent(this.a, OnboardingActivity.class), 2);
                this.a.finish();
            }
        });
        return true;
    }

    public boolean e() {
        if (!this.n) {
            return OnboardingActivity.m();
        }
        f.e("MainActivity", "needsOnboarding: return false because mForceSkipOnboarding is true");
        return false;
    }

    private void j() {
        if (com.getpebble.android.h.d.a(getApplication()) || this.g) {
            if (!this.e && c() == null) {
                b(b.MY_PEBBLE);
            }
            c cVar = new c(getApplicationContext());
            if (!(this.i || com.getpebble.android.notifications.b.f.a((Context) this) || ae.b(com.getpebble.android.common.model.a.NOTIFICATION_LISTENER, com.getpebble.android.common.a.K().getContentResolver()))) {
                l();
            }
            this.j.b();
            if (k()) {
                b(b.MY_PEBBLE);
                return;
            }
            return;
        }
        this.g = true;
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
    }

    private boolean k() {
        f.e("MainActivity", "isHealthStateChanged()");
        boolean isHealthEnabled = ap.isHealthEnabled();
        boolean z = this.o != isHealthEnabled;
        this.o = isHealthEnabled;
        return z;
    }

    private void l() {
        this.i = true;
        c cVar = new c(getApplicationContext());
        new Builder(this).setTitle(getString(R.string.enable_notifications_dialog_title)).setMessage(getString(R.string.enable_notifications_dialog_text)).setPositiveButton(getString(R.string.enable_notifications_service_dialog_btn_positive), new OnClickListener(this) {
            final /* synthetic */ MainActivity a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                com.getpebble.android.notifications.b.f.b(this.a);
                this.a.j.a();
                this.a.i = false;
            }
        }).setNegativeButton(getResources().getString(R.string.enable_notifications_service_dialog_btn_negative), new OnClickListener(this) {
            final /* synthetic */ MainActivity a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.i = false;
                ae.a(new ae.a(System.currentTimeMillis(), com.getpebble.android.common.model.a.NOTIFICATION_LISTENER), com.getpebble.android.common.a.K().getContentResolver());
                this.a.invalidateOptionsMenu();
            }
        }).setCancelable(false).show();
    }

    public void onPause() {
        this.q = false;
        super.onPause();
    }

    public void f() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setNavigationMode(0);
            actionBar.setDisplayShowTitleEnabled(true);
            if (this.b != null) {
                actionBar.setTitle(this.b);
            }
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(this.d)));
        }
    }

    public void a(String str) {
        if (str != null) {
            CharSequence spannableString = new SpannableString(str.toUpperCase(Locale.getDefault()));
            spannableString.setSpan(new CustomTypefaceSpan(com.getpebble.android.font.a.a(this)), 0, str.length(), 17);
            this.b = spannableString;
        } else {
            this.b = null;
        }
        f();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                Fragment c = c();
                if (!(c == null || (c instanceof com.getpebble.android.main.sections.mypebble.fragment.f))) {
                    onBackPressed();
                }
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
