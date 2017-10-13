package com.getpebble.android.onboarding.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.framework.health.a.c.a;
import com.getpebble.android.framework.health.a.d;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import com.google.android.gms.fitness.result.DataReadResult;

public class c extends b implements a {
    private Switch a;
    private com.getpebble.android.framework.health.a.c b;
    private com.getpebble.android.common.b.b.c c;
    private Pair<Double, Double> d;
    private final OnCheckedChangeListener e = new OnCheckedChangeListener(this) {
        final /* synthetic */ c a;

        {
            this.a = r1;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            switch (compoundButton.getId()) {
                case R.id.activity_insights_switch:
                    ((OnboardingActivity) this.a.getActivity()).k().activityInsightsEnabled = z;
                    return;
                case R.id.sleep_insights_switch:
                    ((OnboardingActivity) this.a.getActivity()).k().sleepInsightsEnabled = z;
                    return;
                case R.id.fit_sync_switch:
                    if (z) {
                        this.a.d();
                        return;
                    } else {
                        this.a.c.b(com.getpebble.android.common.b.b.c.a.ENABLE_FIT_SYNC, false);
                        return;
                    }
                default:
                    return;
            }
        }
    };

    public int c() {
        return R.layout.fragment_insights_and_fit_sync;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage(getString(R.string.onboarding_enable_fit_sync_progress_dialog_text));
        getActivity();
        this.b = new com.getpebble.android.framework.health.a.c(com.getpebble.android.common.a.K(), getActivity(), progressDialog, this, true);
        this.c = new com.getpebble.android.common.b.b.c(getActivity());
        this.a = (Switch) viewGroup.findViewById(R.id.fit_sync_switch);
        this.a.setTag(com.getpebble.android.common.b.a.a.a.b.a.GOOGLE_FIT_SYNC);
        ((Switch) viewGroup.findViewById(R.id.activity_insights_switch)).setTag(com.getpebble.android.common.b.a.a.a.b.a.ACTIVITY_INSIGHTS);
        ((Switch) viewGroup.findViewById(R.id.sleep_insights_switch)).setTag(com.getpebble.android.common.b.a.a.a.b.a.SLEEP_INSIGHTS);
        final Switch[] switchArr = new Switch[]{this.a, r0, r1};
        for (Switch switchR : switchArr) {
            switchR.setTypeface(com.getpebble.android.font.a.a(getActivity()));
            switchR.setOnCheckedChangeListener(this.e);
        }
        ((Button) viewGroup.findViewById(R.id.continue_button)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c b;

            public void onClick(View view) {
                com.getpebble.android.common.b.a.a.c.e("continue", "OnboardingHealthInsights");
                for (Switch switchR : switchArr) {
                    com.getpebble.android.common.b.a.a.c.a((com.getpebble.android.common.b.a.a.a.b.a) switchR.getTag(), "OnboardingHealthInsights", switchR.isChecked());
                }
                this.b.a(this.b.d != null ? h.a(((Double) this.b.d.first).doubleValue(), ((Double) this.b.d.second).doubleValue()) : new h());
            }
        });
    }

    private void a(h hVar) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof OnboardingActivity)) {
            ((OnboardingActivity) activity).a((Fragment) hVar);
        }
    }

    private void d() {
        this.b.a();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 123) {
            return;
        }
        if (this.b == null) {
            f.a("EnableInsightsFragment", "Failed to handle fit sync oath request; result=" + i2);
        } else {
            this.b.a(i, i2, intent);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.b != null) {
            this.b.c();
            this.b = null;
        }
    }

    public void a(com.google.android.gms.common.api.c cVar) {
        f.c("EnableInsightsFragment", "onConnectionSuccess");
        com.getpebble.android.framework.health.a.b.a(cVar, new d.a(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void a(DataReadResult dataReadResult) {
                this.a.d = com.getpebble.android.framework.health.a.b.a(dataReadResult);
            }
        });
    }

    public void d_() {
        f.c("EnableInsightsFragment", "onConnectionSuspended");
    }

    public void a() {
        f.c("EnableInsightsFragment", "onConnectionFailed:");
        this.a.setChecked(false);
    }

    public void b() {
        a(new h());
    }
}
