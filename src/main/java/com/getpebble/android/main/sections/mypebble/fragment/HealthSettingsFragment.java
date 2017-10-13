package com.getpebble.android.main.sections.mypebble.fragment;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.ao;
import com.getpebble.android.common.model.ap;
import com.getpebble.android.common.model.ba;
import com.getpebble.android.h.ac;
import com.google.a.b.am;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.Iterator;

public class HealthSettingsFragment extends b implements com.getpebble.android.framework.health.a.a, com.getpebble.android.framework.health.a.c.a {
    private com.getpebble.android.framework.health.a a;
    private c b;
    private ContentResolver c;
    private com.getpebble.android.framework.health.a.c d;
    private Switch e;
    private Switch f;
    private Switch g;
    private a h;
    private a i;
    private a j;
    private a k;
    private ap l;
    private ao m;
    private am<Switch> n;
    private am<a> o;
    private final OnClickListener p = new OnClickListener(this) {
        final /* synthetic */ HealthSettingsFragment a;

        {
            this.a = r1;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.gender_preference:
                    this.a.a.a();
                    return;
                case R.id.age_preference:
                    this.a.a.b();
                    return;
                case R.id.height_preference:
                    this.a.a.a(this.a.l.heightMm, com.getpebble.android.framework.health.g.b.a());
                    return;
                case R.id.weight_preference:
                    this.a.a.a(this.a.l.weightDag, com.getpebble.android.framework.health.g.b.b());
                    return;
                default:
                    f.c("HealthSettingsFragment", "Unknown preference with id = " + view.getId() + " was unhandled.");
                    return;
            }
        }
    };
    private final OnCheckedChangeListener q = new OnCheckedChangeListener(this) {
        final /* synthetic */ HealthSettingsFragment a;

        {
            this.a = r1;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            com.getpebble.android.common.b.a.a.c.a(com.getpebble.android.common.b.a.a.a.b.a.HEALTH_MASTER_TOGGLE, "HealthSettings", z);
            if (!z) {
                this.a.c(false);
            } else if (this.a.b.a(com.getpebble.android.common.b.b.c.a.PRIVACY_POLICY_ACCEPTED, false)) {
                this.a.c(true);
            } else {
                this.a.h();
            }
        }
    };
    private final OnCheckedChangeListener r = new OnCheckedChangeListener(this) {
        final /* synthetic */ HealthSettingsFragment a;

        {
            this.a = r1;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.a.l.trackingEnabled) {
                switch (compoundButton.getId()) {
                    case R.id.enable_activity_insights_row:
                        this.a.l.activityInsightsEnabled = z;
                        break;
                    case R.id.enable_sleep_insights_row:
                        this.a.l.sleepInsightsEnabled = z;
                        break;
                    default:
                        f.c("HealthSettingsFragment", "Unknown insights switch with id = " + compoundButton.getId() + " was unhandled.");
                        break;
                }
                com.getpebble.android.common.b.a.a.c.a((com.getpebble.android.common.b.a.a.a.b.a) compoundButton.getTag(), "HealthSettings", z);
                ba.a(this.a.l, this.a.c);
            }
        }
    };
    private final OnCheckedChangeListener s = new OnCheckedChangeListener(this) {
        final /* synthetic */ HealthSettingsFragment a;

        {
            this.a = r1;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.a.l.trackingEnabled) {
                this.a.m.hrMonitoringEnabled = z;
                com.getpebble.android.common.b.a.a.c.a((com.getpebble.android.common.b.a.a.a.b.a) compoundButton.getTag(), "HealthSettings", z);
                ba.a(this.a.m, this.a.c);
            }
        }
    };
    private final OnCheckedChangeListener t = new OnCheckedChangeListener(this) {
        final /* synthetic */ HealthSettingsFragment a;

        {
            this.a = r1;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.a.l.trackingEnabled) {
                if (z) {
                    this.a.d.a();
                } else {
                    this.a.b.b(com.getpebble.android.common.b.b.c.a.ENABLE_FIT_SYNC, false);
                }
                com.getpebble.android.common.b.a.a.c.a(com.getpebble.android.common.b.a.a.a.b.a.GOOGLE_FIT_SYNC, "HealthSettings", z);
            }
        }
    };

    private final class a {
        final /* synthetic */ HealthSettingsFragment a;
        private final View b;
        private final TextView c;
        private final TextView d;

        a(HealthSettingsFragment healthSettingsFragment, View view, int i, String str) {
            this.a = healthSettingsFragment;
            this.b = view;
            this.c = (TextView) view.findViewById(R.id.name_view);
            this.d = (TextView) view.findViewById(R.id.value_view);
            this.b.setOnClickListener(healthSettingsFragment.p);
            this.c.setText(i);
            a(str);
        }

        void a(boolean z) {
            this.b.setClickable(z);
            this.d.setVisibility(z ? 0 : 4);
            this.c.setTextColor(this.a.getResources().getColor(z ? R.color.health_settings_preference_text : R.color.health_settings_preference_text_disabled));
        }

        void a(String str) {
            this.d.setText(str);
        }
    }

    public int c() {
        return R.layout.fragment_health_settings;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Resources resources = getResources();
        a(resources.getColor(R.color.orange_statusbar_color));
        b(resources.getColor(R.color.orange_actionbar_color));
        Context activity = getActivity();
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage(getString(R.string.onboarding_enable_fit_sync_progress_dialog_text));
        this.b = new c(activity);
        this.a = new com.getpebble.android.framework.health.a(activity, this);
        this.c = activity.getContentResolver();
        this.d = new com.getpebble.android.framework.health.a.c(com.getpebble.android.common.a.K(), getActivity(), progressDialog, this, false);
        this.l = (ap) ba.a(ap.BLOB_DB_KEY, new ap(), this.c);
        this.m = (ao) ba.a(ao.BLOB_DB_KEY, new ao(), this.c);
        a(viewGroup);
        b(viewGroup);
        a(this.l.trackingEnabled);
        b(this.l.trackingEnabled);
        com.getpebble.android.common.model.am.a(this.c, com.getpebble.android.common.model.am.c, true);
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.d != null) {
            this.d.c();
            this.d = null;
        }
    }

    private void a(ViewGroup viewGroup) {
        this.e = (Switch) viewGroup.findViewById(R.id.enable_health_row);
        a(this.e, (int) R.string.health_settings_enable_button, this.l.trackingEnabled);
        this.e.setOnCheckedChangeListener(this.q);
        Switch switchR = (Switch) viewGroup.findViewById(R.id.enable_activity_insights_row);
        a(switchR, (int) R.string.onboarding_enable_activity_insights_text, this.l.activityInsightsEnabled);
        switchR.setOnCheckedChangeListener(this.r);
        switchR.setTag(com.getpebble.android.common.b.a.a.a.b.a.ACTIVITY_INSIGHTS);
        Switch switchR2 = (Switch) viewGroup.findViewById(R.id.enable_sleep_insights_row);
        a(switchR2, (int) R.string.onboarding_enable_sleep_insights_text, this.l.sleepInsightsEnabled);
        switchR2.setOnCheckedChangeListener(this.r);
        switchR2.setTag(com.getpebble.android.common.b.a.a.a.b.a.SLEEP_INSIGHTS);
        this.f = (Switch) viewGroup.findViewById(R.id.enable_fit_sync_row);
        a(this.f, (int) R.string.onboarding_enable_fit_sync_text, this.b.a(com.getpebble.android.common.b.b.c.a.ENABLE_FIT_SYNC, false));
        this.f.setOnCheckedChangeListener(this.t);
        this.f.setTag(com.getpebble.android.common.b.a.a.a.b.a.GOOGLE_FIT_SYNC);
        this.g = (Switch) viewGroup.findViewById(R.id.enable_hr_monitoring_row);
        a(this.g, (int) R.string.onboarding_enable_heartrate_text, this.m.hrMonitoringEnabled);
        this.g.setOnCheckedChangeListener(this.s);
        this.g.setTag(com.getpebble.android.common.b.a.a.a.b.a.HEART_RATE_MONITORING);
        if (!(ak.getKnownHeartRateCapablePebbles(this.c).size() > 0)) {
            ((ViewGroup) viewGroup.findViewById(R.id.health_settings_heartrate_section)).setVisibility(8);
        }
        this.n = am.a(switchR, switchR2, this.f, this.g);
    }

    private void b(ViewGroup viewGroup) {
        this.h = new a(this, viewGroup.findViewById(R.id.gender_preference), R.string.onboarding_health_profile_sex, d());
        this.i = new a(this, viewGroup.findViewById(R.id.age_preference), R.string.onboarding_health_profile_age, e());
        this.j = new a(this, viewGroup.findViewById(R.id.height_preference), R.string.onboarding_health_profile_height, f());
        this.k = new a(this, viewGroup.findViewById(R.id.weight_preference), R.string.onboarding_health_profile_weight, g());
        this.o = am.a(this.h, this.i, this.j, this.k);
    }

    private void a(boolean z) {
        Iterator j_ = this.n.j_();
        while (j_.hasNext()) {
            Switch switchR = (Switch) j_.next();
            if (z) {
                switchR.setTextColor(getResources().getColor(R.color.health_settings_preference_text));
                switchR.setEnabled(true);
                a(switchR);
            } else {
                switchR.setTextColor(getResources().getColor(R.color.health_settings_preference_text_disabled));
                switchR.setChecked(false);
                switchR.setEnabled(false);
            }
        }
    }

    private void a(Switch switchR) {
        switch (switchR.getId()) {
            case R.id.enable_activity_insights_row:
                switchR.setChecked(this.l.activityInsightsEnabled);
                return;
            case R.id.enable_sleep_insights_row:
                switchR.setChecked(this.l.sleepInsightsEnabled);
                return;
            case R.id.enable_fit_sync_row:
                switchR.setChecked(this.b.a(com.getpebble.android.common.b.b.c.a.ENABLE_FIT_SYNC, false));
                return;
            case R.id.enable_hr_monitoring_row:
                switchR.setChecked(this.m.hrMonitoringEnabled);
                return;
            default:
                f.c("HealthSettingsFragment", "Unknown switch with id = " + switchR.getId() + " was unhandled.");
                return;
        }
    }

    private void b(boolean z) {
        Iterator j_ = this.o.j_();
        while (j_.hasNext()) {
            ((a) j_.next()).a(z);
        }
    }

    private String d() {
        return this.l.gender != null ? getString(this.l.gender.nameResId) : "";
    }

    private String e() {
        return this.l.ageYears != (byte) 0 ? this.a.a(this.l.ageYears) : "";
    }

    private String f() {
        return this.l.heightMm != 0 ? com.getpebble.android.framework.health.g.b.a(com.getpebble.android.framework.health.g.b.a(), this.l.heightMm, getActivity()) : "";
    }

    private String g() {
        com.getpebble.android.framework.health.g.a.b b = com.getpebble.android.framework.health.g.b.b();
        if (this.l.weightDag == 0) {
            return "";
        }
        return getString(b.stringFormatterResourceId(), new Object[]{Integer.valueOf(b.fromDecagrams(this.l.weightDag))});
    }

    public void a(com.getpebble.android.common.model.ap.a aVar) {
        if (aVar != null) {
            this.h.a(getString(aVar.nameResId));
            this.l.gender = aVar;
            ba.a(this.l, this.c);
        }
    }

    public void a(String str, int i) {
        this.i.a(str);
        this.l.ageYears = (byte) i;
        ba.a(this.l, this.c);
    }

    public void a(com.getpebble.android.framework.health.g.a.a aVar, short s) {
        com.getpebble.android.framework.health.g.b.a(aVar);
        this.j.a(com.getpebble.android.framework.health.g.b.a(aVar, s, getActivity()));
        this.l.heightMm = s;
        ba.a(this.l, this.c);
    }

    public void a(com.getpebble.android.framework.health.g.a.b bVar, short s) {
        com.getpebble.android.framework.health.g.b.a(bVar);
        this.k.a(getString(bVar.stringFormatterResourceId(), new Object[]{Integer.valueOf(bVar.fromDecagrams(s))}));
        this.l.weightDag = s;
        ba.a(this.l, this.c);
    }

    private void a(Switch switchR, int i, boolean z) {
        switchR.setText(i);
        switchR.setTypeface(com.getpebble.android.font.a.a(getActivity()));
        switchR.setChecked(z);
    }

    private void a(int i) {
        if (VERSION.SDK_INT >= 21) {
            Window window = getActivity().getWindow();
            if (window != null) {
                window.setStatusBarColor(i);
            }
        }
    }

    private void b(int i) {
        ActionBar actionBar = getActivity().getActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(i));
        }
    }

    private void c(boolean z) {
        this.l.trackingEnabled = z;
        ba.a(this.l, this.c);
        a(z);
        b(z);
    }

    private void h() {
        new Builder(getActivity()).setCancelable(false).setMessage(R.string.onboarding_enable_health_policy_confirm).setNegativeButton(R.string.health_policy_disagree, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ HealthSettingsFragment a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.b.b(com.getpebble.android.common.b.b.c.a.PRIVACY_POLICY_ACCEPTED, false);
                this.a.e.setChecked(false);
            }
        }).setPositiveButton(R.string.health_policy_agree, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ HealthSettingsFragment a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.b.b(com.getpebble.android.common.b.b.c.a.PRIVACY_POLICY_ACCEPTED, true);
                this.a.c(true);
            }
        }).setNeutralButton(R.string.health_policy_review, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ HealthSettingsFragment a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.e.setChecked(false);
                String U = com.getpebble.android.config.a.c().U();
                if (U != null) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(U));
                    this.a.startActivity(intent);
                }
            }
        }).create().show();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        f.d("HealthSettingsFragment", "onActivityResult: resultCode = " + i2);
        if (i == 123 && this.d != null) {
            this.d.a(i, i2, intent);
        }
    }

    public void a(com.google.android.gms.common.api.c cVar) {
        f.c("HealthSettingsFragment", "onConnectionSuccess");
        com.getpebble.android.framework.health.a.b.a(cVar, new com.getpebble.android.framework.health.a.d.a(this) {
            final /* synthetic */ HealthSettingsFragment a;

            {
                this.a = r1;
            }

            public void a(DataReadResult dataReadResult) {
                final Pair a = com.getpebble.android.framework.health.a.b.a(dataReadResult);
                if (a != null) {
                    Activity activity = this.a.getActivity();
                    if (activity != null) {
                        activity.runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass9 b;

                            public void run() {
                                this.b.a.a(a);
                            }
                        });
                    }
                }
            }
        });
    }

    private void a(Pair<Double, Double> pair) {
        double doubleValue = ((Double) pair.first).doubleValue();
        double doubleValue2 = ((Double) pair.second).doubleValue();
        if (doubleValue != 0.0d && f().isEmpty()) {
            a(com.getpebble.android.framework.health.g.a.a.INCHES, (short) ac.b(doubleValue));
        }
        if (doubleValue2 != 0.0d && g().isEmpty()) {
            a(com.getpebble.android.framework.health.g.a.b.POUNDS, (short) ac.c(doubleValue2));
        }
    }

    public void d_() {
        f.c("HealthSettingsFragment", "onConnectionSuspended");
    }

    public void a() {
        f.c("HealthSettingsFragment", "onConnectionFailed:");
        this.f.setChecked(false);
    }

    public void b() {
        this.f.setChecked(false);
    }
}
