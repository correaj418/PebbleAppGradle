package com.getpebble.android.main.sections.settings.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.TwoStatePreference;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.model.ba;
import com.getpebble.android.framework.o.b;
import com.getpebble.android.h.aa;
import com.getpebble.android.h.q;
import com.getpebble.android.notifications.b.f;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import com.getpebble.android.onboarding.fragment.ChooseVoiceLanguageFragment;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SettingsFragment extends PreferenceFragment implements OnPreferenceChangeListener, com.getpebble.android.framework.e.f.a {
    private static final long b = TimeUnit.SECONDS.toMillis(30);
    private Handler a;
    private c c = null;
    private Preference d = null;
    private Preference e = null;
    private Preference f = null;
    private Preference g = null;
    private Preference h = null;
    private Preference i = null;
    private Preference j = null;
    private Preference k = null;
    private Preference l;
    private AlertDialog m;

    public static class a {
        @com.google.b.a.c(a = "diagnostics_disabled")
        private final boolean a;

        public a(boolean z) {
            this.a = z;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        PebbleApplication.b(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new Handler();
        getPreferenceManager().setSharedPreferencesName("PEBBLE_PREFERENCES");
        addPreferencesFromResource(R.xml.main_settings);
        com.getpebble.android.main.sections.settings.a.a((PreferenceFragment) this);
        this.c = new c(com.getpebble.android.common.a.K());
        this.d = findPreference(this.c.a(com.getpebble.android.common.b.b.c.a.VERSION));
        this.e = findPreference(this.c.a(com.getpebble.android.common.b.b.c.a.SYNC_INTERVAL));
        this.f = findPreference(this.c.a(com.getpebble.android.common.b.b.c.a.ANALYTICS_OPTIN));
        this.g = findPreference(this.c.a(com.getpebble.android.common.b.b.c.a.HEALTH_ANALYTICS_OPTIN));
        this.h = findPreference(this.c.a(com.getpebble.android.common.b.b.c.a.LANGUAGE_PACK_CATEGORY));
        this.h.setShouldDisableView(true);
        this.i = findPreference(this.c.a(com.getpebble.android.common.b.b.c.a.VOICE_LANGUAGE));
        this.j = findPreference(this.c.a(com.getpebble.android.common.b.b.c.a.DISTANCE_UNIT));
        this.j.setOnPreferenceChangeListener(this);
        this.k = findPreference(this.c.a(com.getpebble.android.common.b.b.c.a.FONT_PACK_CATEGORY));
        this.l = findPreference(getString(R.string.pref_key_account));
        ((PreferenceCategory) findPreference(getString(R.string.pref_key_category_general))).removePreference(this.k);
        g();
        h();
        i();
        d();
        e();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setBackgroundColor(getResources().getColor(R.color.preferences_background_color));
        return onCreateView;
    }

    public void onResume() {
        super.onResume();
        j();
        k();
        l();
        c();
        PebbleApplication.a((com.getpebble.android.framework.e.f.a) this);
        o();
    }

    public void onPause() {
        PebbleApplication.b(this);
        super.onPause();
    }

    private void c() {
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference(getString(R.string.pref_key_notifications));
        Preference findPreference = findPreference(getString(R.string.pref_key_install_wear));
        if ((f.b() || !this.c.a(com.getpebble.android.common.b.b.c.a.RECEIVED_POTENTIAL_WEAR_ENHANCED_NOTIFICATION, false)) && preferenceCategory != null && findPreference != null) {
            com.getpebble.android.common.b.a.f.d("SettingsFragment", "Hiding Wear app install preference");
            preferenceCategory.removePreference(findPreference);
        }
    }

    private void d() {
        if (this.f != null) {
            this.f.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
                final /* synthetic */ SettingsFragment a;

                {
                    this.a = r1;
                }

                public boolean onPreferenceChange(Preference preference, Object obj) {
                    Boolean bool = (Boolean) obj;
                    boolean z = this.a.m != null;
                    boolean z2;
                    if (bool.booleanValue()) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z || !r3) {
                        if (bool.booleanValue()) {
                            this.a.c.b(com.getpebble.android.common.b.b.c.a.ANALYTICS_OPTIN, bool.booleanValue());
                            com.getpebble.android.common.b.a.a.c.a(bool.booleanValue());
                        } else {
                            com.getpebble.android.common.b.a.a.c.a(bool.booleanValue());
                            this.a.c.b(com.getpebble.android.common.b.b.c.a.ANALYTICS_OPTIN, bool.booleanValue());
                        }
                        SettingsFragment.b(bool.booleanValue());
                        return true;
                    }
                    this.a.m();
                    return false;
                }
            });
        }
    }

    private void e() {
        if (this.g != null) {
            this.g.setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
                final /* synthetic */ SettingsFragment a;

                {
                    this.a = r1;
                }

                public boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean z = false;
                    Boolean bool = (Boolean) obj;
                    boolean z2 = this.a.m != null;
                    if (!bool.booleanValue()) {
                        z = true;
                    }
                    if (!z2 && r2 && this.a.f()) {
                        this.a.n();
                    }
                    this.a.c.b(com.getpebble.android.common.b.b.c.a.HEALTH_ANALYTICS_OPTIN, bool.booleanValue());
                    return true;
                }
            });
        }
    }

    private boolean f() {
        com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
        if (p == null) {
            return false;
        }
        return b.remoteCollectsHealthAnalytics(p.getFwVersion());
    }

    private static void b(final boolean z) {
        new com.getpebble.android.bluetooth.b.f() {
            private final boolean b = z;

            public boolean doInBackground() {
                try {
                    int b = com.getpebble.android.d.a.a(com.getpebble.android.common.a.K(), PebbleApplication.w().y(), new a(this.b), SettingsFragment.b).d().b();
                    if (b != 200) {
                        com.getpebble.android.common.b.a.f.a(com.getpebble.android.bluetooth.b.f.TAG, "sendDiagnosticsSettings: responseCode = Error sending diagnostics setting, response code: " + b);
                    } else {
                        com.getpebble.android.common.b.a.f.e(com.getpebble.android.bluetooth.b.f.TAG, "sendDiagnosticsSettings: responseCode = " + b);
                    }
                    return true;
                } catch (Throwable e) {
                    com.getpebble.android.common.b.a.f.a(com.getpebble.android.bluetooth.b.f.TAG, "sendDiagnosticsSettings: error = ", e);
                    return false;
                }
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    private void g() {
        if (this.d != null) {
            this.d.setSummary("4.4.1-1404-01abd2f76-endframe");
        }
    }

    private void h() {
        com.getpebble.android.main.sections.settings.a.a(this.e, this.c, getResources());
    }

    private void i() {
        if (this.e != null) {
            this.e.setOnPreferenceChangeListener(this);
        }
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        String key = preference.getKey();
        if (key == null) {
            return false;
        }
        if (key.equalsIgnoreCase(this.c.a(com.getpebble.android.common.b.b.c.a.SYNC_INTERVAL))) {
            PebbleApplication.v().j();
            this.a.post(new Runnable(this) {
                final /* synthetic */ SettingsFragment a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.h();
                }
            });
            return true;
        } else if (!key.equalsIgnoreCase(this.c.a(com.getpebble.android.common.b.b.c.a.DISTANCE_UNIT))) {
            return false;
        } else {
            ba.a(new com.getpebble.android.framework.health.b(((Boolean) obj).booleanValue()), com.getpebble.android.common.a.K().getContentResolver());
            return true;
        }
    }

    public void e_() {
        com.getpebble.android.common.b.a.f.d("SettingsFragment", "notifyConnectedDeviceChanged()");
        this.a.post(new Runnable(this) {
            final /* synthetic */ SettingsFragment a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.k();
                this.a.j();
            }
        });
    }

    private void j() {
        com.getpebble.android.common.b.a.f.d("SettingsFragment", "updateFontPreference()");
        this.k.setSummary(getString(R.string.additional_font_pack_none));
    }

    private void k() {
        com.getpebble.android.common.b.a.f.d("SettingsFragment", "updateLanguagePreference()");
        if (isResumed()) {
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            boolean z = r != null && r.capabilities.supportsLocalization;
            this.h.setEnabled(z);
            if (z) {
                String a = q.a(r);
                Activity activity = getActivity();
                if (activity == null) {
                    com.getpebble.android.common.b.a.f.d("SettingsFragment", "Cannot set preference with null parent activity");
                    return;
                } else {
                    this.h.setSummary(activity.getResources().getString(R.string.language_selection_selected_language) + ": " + aa.a(a));
                    return;
                }
            }
            this.h.setSummary("");
            return;
        }
        com.getpebble.android.common.b.a.f.d("SettingsFragment", "SettingsFragment not resumed; not updating language preference");
    }

    private void l() {
        String string = getString(R.string.onboarding_default_language_code);
        String str = (String) ChooseVoiceLanguageFragment.a().get(PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.VOICE_LANGUAGE, string));
        if (TextUtils.isEmpty(str)) {
            str = string;
        }
        Locale a = q.a(str);
        str = a.getDisplayName(a);
        this.i.setSummary(getActivity().getResources().getString(R.string.language_selection_selected_language) + ": " + aa.a(str));
    }

    private void m() {
        Context activity = getActivity();
        if (activity == null) {
            com.getpebble.android.common.b.a.f.b("SettingsFragment", "Cannot display dictation disabled warning; activity is null");
        } else {
            this.m = new Builder(activity).setTitle(activity.getString(R.string.settings_voice_dictation_warning_title)).setMessage(activity.getString(R.string.settings_voice_dictation_warning_message)).setPositiveButton(activity.getString(R.string.settings_voice_dictation_warning_positive_button), new OnClickListener(this) {
                final /* synthetic */ SettingsFragment a;

                {
                    this.a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    ((TwoStatePreference) this.a.f).setChecked(false);
                    dialogInterface.dismiss();
                    this.a.m = null;
                    SettingsFragment.b(false);
                }
            }).setNegativeButton(activity.getString(R.string.settings_voice_dictation_warning_negative_button), new OnClickListener(this) {
                final /* synthetic */ SettingsFragment a;

                {
                    this.a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.a.m = null;
                }
            }).setCancelable(false).show();
        }
    }

    private void n() {
        Context activity = getActivity();
        if (activity == null) {
            com.getpebble.android.common.b.a.f.b("SettingsFragment", "Cannot display health analytics upgrade firmware warning; activity is null");
        } else {
            this.m = new Builder(activity).setTitle(activity.getString(R.string.settings_health_analytics_warning_title)).setMessage(activity.getString(R.string.settings_health_analytics_warning_message)).setPositiveButton(activity.getString(R.string.settings_health_analytics_positive_button), new OnClickListener(this) {
                final /* synthetic */ SettingsFragment a;

                {
                    this.a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    ((TwoStatePreference) this.a.g).setChecked(false);
                    dialogInterface.dismiss();
                    this.a.m = null;
                }
            }).setCancelable(false).show();
        }
    }

    private void o() {
        boolean z = false;
        com.getpebble.android.common.a.a u = PebbleApplication.u();
        boolean z2 = u.b() != null;
        if (z2) {
            z = u.d();
        }
        if (!z2 || r0) {
            this.l.setTitle(R.string.no_account);
            this.l.setSummary(R.string.click_to_log_in);
            this.l.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
                final /* synthetic */ SettingsFragment a;

                {
                    this.a = r1;
                }

                public boolean onPreferenceClick(Preference preference) {
                    com.getpebble.android.common.b.a.f.d("SettingsFragment", "Logging in (after removing dummy account)");
                    PebbleApplication.u().e();
                    this.a.getActivity().startActivity(new Intent(this.a.getActivity(), OnboardingActivity.class));
                    return true;
                }
            });
            return;
        }
        this.l.setTitle(R.string.logged_in);
        this.l.setSummary(PebbleApplication.u().g().name + " " + getString(R.string.click_to_log_out));
        this.l.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ SettingsFragment a;

            {
                this.a = r1;
            }

            public boolean onPreferenceClick(Preference preference) {
                new Builder(this.a.getActivity()).setTitle(this.a.getString(R.string.log_out)).setMessage(this.a.getString(R.string.log_out_message)).setPositiveButton(this.a.getString(R.string.log_out), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass10 a;

                    {
                        this.a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.getpebble.android.common.b.a.f.d("SettingsFragment", "Logging out (removing account, creating dummy account)");
                        PebbleApplication.u().e();
                        PebbleApplication.u().c();
                        com.getpebble.android.core.auth.a.a.d();
                        dialogInterface.dismiss();
                        this.a.a.getActivity().finish();
                    }
                }).setNegativeButton(this.a.getString(R.string.cancel), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass10 a;

                    {
                        this.a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).setCancelable(true).show();
                return true;
            }
        });
    }
}
