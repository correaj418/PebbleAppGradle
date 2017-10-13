package com.getpebble.android.onboarding.fragment;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.onboarding.activity.OnboardingActivity;

public class o extends b {
    private Handler a;

    public int c() {
        return R.layout.splash_page;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a(getResources().getColor(R.color.orange_statusbar_color));
        b(getResources().getColor(R.color.orange_statusbar_color));
        this.a = new Handler();
    }

    public void onStart() {
        f.d("SplashPage", "onStart()");
        super.onStart();
        this.a.postDelayed(new Runnable(this) {
            final /* synthetic */ o a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.a(this.a.getResources().getColor(R.color.onboarding_status_bar_color));
                this.a.b(this.a.getResources().getColor(R.color.black));
                this.a.a();
            }
        }, 1000);
    }

    public void onStop() {
        f.d("SplashPage", "onStop");
        this.a.removeCallbacksAndMessages(null);
        super.onStop();
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
        if (VERSION.SDK_INT >= 21) {
            Window window = getActivity().getWindow();
            if (window != null) {
                window.setNavigationBarColor(i);
            }
        }
    }

    private void a() {
        Activity activity = getActivity();
        if (activity instanceof OnboardingActivity) {
            ((OnboardingActivity) activity).i();
        }
    }
}
