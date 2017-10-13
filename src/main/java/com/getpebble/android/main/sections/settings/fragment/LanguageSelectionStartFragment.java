package com.getpebble.android.main.sections.settings.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.h.aa;
import com.getpebble.android.h.h;
import com.getpebble.android.h.q;
import com.getpebble.android.main.sections.settings.activity.LanguageSelectionActivity;
import com.getpebble.android.onboarding.activity.OnboardingActivity;

public class LanguageSelectionStartFragment extends b {
    private boolean a = false;
    private final OnClickListener b = new OnClickListener(this) {
        final /* synthetic */ LanguageSelectionStartFragment a;

        {
            this.a = r1;
        }

        public void onClick(View view) {
            Activity activity = this.a.getActivity();
            if (activity == null) {
                f.b("LanguageSelectionStartFragment", "Activity is null, dropping click event");
                return;
            }
            boolean a = h.a(activity.getApplicationContext());
            if (this.a.a) {
                OnboardingActivity onboardingActivity = (OnboardingActivity) activity;
                if (a) {
                    onboardingActivity.a(new b());
                } else {
                    onboardingActivity.l();
                }
            } else if (activity instanceof LanguageSelectionActivity) {
                ((LanguageSelectionActivity) activity).a(new b());
            }
        }
    };

    public int c() {
        return R.layout.fragment_language_selection_start;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Activity activity = getActivity();
        if (activity == null) {
            f.b("LanguageSelectionStartFragment", "init() activity is null, not initializing");
            return;
        }
        this.a = activity instanceof OnboardingActivity;
        if (!this.a) {
            viewGroup.findViewById(R.id.onboarding_banner).setVisibility(8);
        }
        ((Button) viewGroup.findViewById(R.id.set_language_button)).setOnClickListener(this.b);
        viewGroup.findViewById(R.id.language_selection_selected_language_layout).setOnClickListener(this.b);
        ((TextView) viewGroup.findViewById(R.id.language_selection_target_language)).setText(aa.a(q.a(PebbleApplication.r())));
    }
}
