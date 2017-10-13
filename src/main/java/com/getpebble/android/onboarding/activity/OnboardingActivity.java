package com.getpebble.android.onboarding.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.ap;
import com.getpebble.android.common.model.ba;
import com.getpebble.android.core.a;
import com.getpebble.android.framework.e.f;
import com.getpebble.android.main.activity.MainActivity;
import com.getpebble.android.main.sections.appstore.fragment.NoConnectivityFragment;
import com.getpebble.android.main.sections.settings.fragment.LanguageSelectionStartFragment;
import com.getpebble.android.onboarding.DefaultAppsFetcher;
import com.getpebble.android.onboarding.activity.a.b;
import com.getpebble.android.onboarding.activity.a.c;
import com.getpebble.android.onboarding.fragment.ChooseVoiceLanguageFragment;
import com.getpebble.android.onboarding.fragment.d;
import com.getpebble.android.onboarding.fragment.j;
import com.getpebble.android.onboarding.fragment.o;
import com.getpebble.android.onboarding.fragment.p;

public class OnboardingActivity extends a {
    private static DefaultAppsFetcher e;
    private int a = 0;
    private b b = b.NEW_USER;
    private Handler c = new Handler(Looper.getMainLooper());
    private Runnable d = null;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private ap i;
    private final f.a j = new f.a(this) {
        final /* synthetic */ OnboardingActivity a;

        {
            this.a = r1;
        }

        public void e_() {
            this.a.c.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 a;

                {
                    this.a = r1;
                }

                public void run() {
                    if (this.a.a.g) {
                        if (PebbleApplication.n() != null) {
                            this.a.a.g = false;
                        }
                    } else if (this.a.a.g() && PebbleApplication.n() == null) {
                        this.a.a.q();
                    }
                }
            });
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        if (e == null) {
            e = new DefaultAppsFetcher();
        }
        this.i = (ap) ba.a(ap.BLOB_DB_KEY, new ap(), getContentResolver());
        b(getResources().getColor(R.color.onboarding_status_bar_color));
        if (bundle != null) {
            this.a = bundle.getInt("extra_onboarding_step", 0);
            com.getpebble.android.common.b.a.f.d("OnboardingActivity", "onCreate: Got onboarding step index from saved instance state: " + this.a);
            this.b = (b) bundle.getSerializable("EXTRA_ONBOARDING_SEQUENCE");
        }
        b f = b.f();
        if (f == null) {
            com.getpebble.android.common.b.a.f.a("OnboardingActivity", "onCreate: Onboarding sequence was null; a race condition may have occurred where Pebble disconnected. Creating a zero-length sequence and bailing out");
            this.b = b.UP_TO_DATE;
            this.h = true;
            return;
        }
        com.getpebble.android.common.b.a.f.d("OnboardingActivity", "onCreate: Got onboarding sequence: " + f.toString());
        if (this.b != f) {
            com.getpebble.android.common.b.a.f.a("OnboardingActivity", "onCreate: Onboarding sequence from saved instance state does not match most recently determined onboarding state. State may have changed while the activity was closed.");
            com.getpebble.android.common.b.a.f.a("OnboardingActivity", "onCreate: Invalidating the onboarding step by setting it to zero and using the recently determined sequence; ignoring the saved instance state.");
            this.a = 0;
            this.b = f;
            com.getpebble.android.common.b.a.f.b("OnboardingActivity", String.format("Using sequence %s", new Object[]{this.b.toString()}));
        }
        Fragment j = j();
        if (j == null) {
            com.getpebble.android.common.b.a.f.d("OnboardingActivity", "onCreate: no fragment to display, exiting onboarding activity.");
            o();
            return;
        }
        b(j);
    }

    public void onStart() {
        super.onStart();
        PebbleApplication.a(true);
    }

    public void onPostResume() {
        super.onPostResume();
        this.f = true;
        if (PebbleApplication.u().h() != null || this.a <= 0) {
            PebbleApplication.a(this.j);
            if (g() && PebbleApplication.n() == null) {
                com.getpebble.android.common.b.a.f.d("OnboardingActivity", "onPostResume: stepRequiresConnectedDevice() && PebbleApp.getConnectedDevice == null");
                if (!this.g) {
                    q();
                    return;
                }
                return;
            } else if (this.h) {
                com.getpebble.android.common.b.a.f.a("OnboardingActivity", "onPostResume: Bailing out of onboarding activity; was in error state");
                o();
                return;
            } else if (this.d != null) {
                com.getpebble.android.common.b.a.f.d("OnboardingActivity", "onPostResume: Running event scheduled for after onPostResume");
                this.c.post(this.d);
                this.d = null;
                return;
            } else {
                return;
            }
        }
        com.getpebble.android.common.b.a.f.d("OnboardingActivity", "Exiting because no user account");
        o();
    }

    public void onSaveInstanceState(Bundle bundle) {
        com.getpebble.android.common.b.a.f.d("OnboardingActivity", "onSaveInstanceState: Saving onboarding step: " + this.a);
        bundle.putInt("extra_onboarding_step", this.a);
        com.getpebble.android.common.b.a.f.d("OnboardingActivity", "onSaveInstanceState: Saving onboarding sequence: " + this.b.toString());
        bundle.putSerializable("EXTRA_ONBOARDING_SEQUENCE", this.b);
        super.onSaveInstanceState(bundle);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        getFragmentManager().findFragmentById(R.id.grp_fragment_container).onActivityResult(i, i2, intent);
    }

    public void onPause() {
        super.onPause();
        this.f = false;
        PebbleApplication.b(this.j);
    }

    public void onStop() {
        super.onStop();
        PebbleApplication.D();
    }

    public void a() {
        this.g = true;
    }

    public void e() {
        if (PebbleApplication.n() == null) {
            q();
        }
    }

    public DefaultAppsFetcher f() {
        return e;
    }

    private void b(int i) {
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(i);
            }
        }
    }

    public boolean g() {
        c p = p();
        if (p == c.UNKNOWN) {
            com.getpebble.android.common.b.a.f.b("OnboardingActivity", "stepRequiresConnectedDevice: Unknown current step.");
            return false;
        } else if (p == c.PEBBLE_LANGUAGE || p == c.FIRMWARE || p == c.NOTIFICATIONS) {
            return true;
        } else {
            return false;
        }
    }

    public void h() {
        this.a--;
        com.getpebble.android.common.b.a.f.e("OnboardingActivity", "goToPreviousScreen: will show screen " + p());
        n();
    }

    public void i() {
        this.a++;
        if (a(p())) {
            com.getpebble.android.common.b.a.f.e("OnboardingActivity", "goToNextScreen: will show screen " + p());
            n();
            return;
        }
        i();
    }

    private void n() {
        this.d = new Runnable(this) {
            final /* synthetic */ OnboardingActivity a;

            {
                this.a = r1;
            }

            public void run() {
                Fragment j = this.a.j();
                if (j == null) {
                    com.getpebble.android.onboarding.a.a(3);
                    this.a.setResult(-1);
                    this.a.o();
                    return;
                }
                this.a.b(j);
            }
        };
        if (this.f) {
            com.getpebble.android.common.b.a.f.d("OnboardingActivity", "showCurrentScreen(): onPostResume has run already");
            this.c.post(this.d);
            this.d = null;
            return;
        }
        com.getpebble.android.common.b.a.f.d("OnboardingActivity", "showCurrentScreen(): onPostResume has not run yet - event scheduled to occur after onPostResume.");
    }

    private void o() {
        e = null;
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(335544320);
        startActivity(intent);
        finish();
    }

    public Fragment j() {
        com.getpebble.android.common.b.a.f.d("OnboardingActivity", "getFragmentByStep: Getting fragment: index = " + this.a + ", step = " + p() + ", sequence = " + this.b.toString());
        c p = p();
        if (a(p)) {
            switch (p) {
                case FIRMWARE:
                    return com.getpebble.android.connection.a.a((Activity) this);
                case NOTIFICATIONS:
                    return new d();
                case VOICE_LANGUAGE:
                    return new ChooseVoiceLanguageFragment();
                case LOGIN:
                    return new com.getpebble.android.core.auth.a.a();
                case PEBBLE_LANGUAGE:
                    return new LanguageSelectionStartFragment();
                case HEALTH:
                    return new com.getpebble.android.onboarding.fragment.b();
                case SPLASH_PAGE:
                    return new o();
                case WATCHFACE_SELECTION:
                    return new p();
                case HEART_RATE_MONITORING:
                    return new j();
                default:
                    return null;
            }
        }
        com.getpebble.android.common.b.a.f.d("OnboardingActivity", "getFragmentByStep: not presenting step, skipping to next one");
        this.a++;
        return j();
    }

    private boolean a(c cVar) {
        if (cVar == c.LOGIN && b.j()) {
            com.getpebble.android.common.b.a.f.e("OnboardingActivity", "goToNextScreen: Onboarding a Pebble with no Log in.");
            return false;
        } else if (cVar == c.PEBBLE_LANGUAGE && !com.getpebble.android.framework.o.b.a.isLanguageOnboardingRequired()) {
            com.getpebble.android.common.b.a.f.d("OnboardingActivity", "goToNextScreen: Language onboarding is not required");
            return false;
        } else if (cVar == c.NOTIFICATIONS && com.getpebble.android.notifications.b.f.a((Context) this)) {
            com.getpebble.android.common.b.a.f.e("OnboardingActivity", "goToNextScreen: Onboarding a Pebble with no 'Enable Notifications' ");
            return false;
        } else if (cVar != c.HEALTH || com.getpebble.android.framework.o.b.isHealthSupported()) {
            if (cVar == c.HEART_RATE_MONITORING) {
                ak.a r = PebbleApplication.r();
                com.getpebble.android.common.b.a.f.e("OnboardingActivity", "goToNextScreen: Onboarding a Pebble with no HRM");
                if (!j.a(r)) {
                    a.a.ZERO.migrationConcluded(PebbleApplication.n());
                    return false;
                }
            }
            return true;
        } else {
            com.getpebble.android.common.b.a.f.d("OnboardingActivity", "Watch doesn't support health - skipping health onboarding");
            return false;
        }
    }

    private c p() {
        if (this.a >= this.b.steps.length) {
            return c.UNKNOWN;
        }
        if (this.a < 0) {
            this.a = 0;
        }
        return this.b.steps[this.a];
    }

    public ap k() {
        return this.i;
    }

    public void a(Fragment fragment) {
        b(fragment);
    }

    public void l() {
        a(new NoConnectivityFragment(), false, false, true);
    }

    private void q() {
        if (c() instanceof com.getpebble.android.connection.a) {
            com.getpebble.android.common.b.a.f.d("OnboardingActivity", "redirectToConnectionManager: Not redirecting to CMF; already there");
            return;
        }
        com.getpebble.android.common.b.a.f.d("OnboardingActivity", "redirectToConnectionManager: Redirecting to CMF");
        Toast.makeText(this, getString(R.string.my_pebble_no_device_connected), 1).show();
        b(new com.getpebble.android.connection.a());
    }

    public static boolean m() {
        return b.f() != null;
    }
}
