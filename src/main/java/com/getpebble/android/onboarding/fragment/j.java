package com.getpebble.android.onboarding.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.ak.a;
import com.getpebble.android.onboarding.activity.OnboardingActivity;

public class j extends b {
    public int c() {
        return R.layout.fragment_onboard_hrm;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ((Button) viewGroup.findViewById(R.id.hrm_onboarding_continue_button)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ j a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                c.e("continue", "OnboardingHeartRateMonitor");
                Fragment kVar = new k();
                Activity activity = this.a.getActivity();
                if (activity != null && (activity instanceof OnboardingActivity)) {
                    ((OnboardingActivity) activity).a(kVar);
                }
            }
        });
    }

    public static boolean a(a aVar) {
        return aVar != null && aVar.capabilities.supportsHealthInsights && aVar.supportsHeartRateMonitoring();
    }
}
