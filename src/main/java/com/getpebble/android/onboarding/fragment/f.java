package com.getpebble.android.onboarding.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.getpebble.android.basalt.R;
import com.getpebble.android.onboarding.DefaultAppsFetcher;
import com.getpebble.android.onboarding.a.a;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import java.util.ArrayList;

public class f extends a {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        DefaultAppsFetcher f = ((OnboardingActivity) getActivity()).f();
        if (f != null) {
            this.d = f.getOnboardingTimelineApps();
        }
        return layoutInflater.inflate(R.layout.grab_apps_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.a == null || this.d == null) {
            a();
            return;
        }
        this.b = new a(getActivity(), this.d, a.a.GRAB_APPS, new ArrayList());
        this.a.setAdapter(this.b);
    }

    protected void a() {
        ((OnboardingActivity) getActivity()).a(new n());
    }
}
