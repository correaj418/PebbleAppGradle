package com.getpebble.android.onboarding.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.onboarding.activity.OnboardingActivity;

public class n extends b {
    public int c() {
        return R.layout.fragment_setup_complete;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c.d("OnboardingDone");
        ((Button) viewGroup.findViewById(R.id.onboarding_done_btn)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ n a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                c.e("done", "OnboardingDone");
                Activity activity = this.a.getActivity();
                if (activity != null && (activity instanceof OnboardingActivity)) {
                    ((OnboardingActivity) activity).i();
                }
            }
        });
    }
}
