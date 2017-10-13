package com.getpebble.android.onboarding.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import com.getpebble.android.onboarding.activity.a.a;

public class k extends b {
    public int c() {
        return R.layout.fragment_onboard_hrm_howto;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ((Button) viewGroup.findViewById(R.id.hrm_onboarding_continue_button)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ k a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                c.e("continue", "OnboardingHeartRateMonitorHowTo");
                a.ZERO.migrationConcluded(PebbleApplication.n());
                Activity activity = this.a.getActivity();
                if (activity != null && (activity instanceof OnboardingActivity)) {
                    ((OnboardingActivity) activity).i();
                }
            }
        });
    }
}
