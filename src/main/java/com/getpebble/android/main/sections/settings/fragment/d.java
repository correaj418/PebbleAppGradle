package com.getpebble.android.main.sections.settings.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.onboarding.a;
import com.getpebble.android.onboarding.activity.OnboardingActivity;

public class d extends b {
    private boolean a = false;
    private String b;
    private boolean c;
    private TextView d;
    private TextView e;
    private TextView f;
    private ImageView g;
    private Button h;

    public int c() {
        return R.layout.fragment_language_install_complete;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final Activity activity = getActivity();
        if (activity == null) {
            f.b("LanguageSelectionCompleteFragment", "init() activity is null, not initializing");
            return;
        }
        this.a = activity instanceof OnboardingActivity;
        this.d = (TextView) viewGroup.findViewById(R.id.onboarding_banner);
        this.e = (TextView) viewGroup.findViewById(R.id.onboarding_language_install_complete_subtitle);
        this.f = (TextView) viewGroup.findViewById(R.id.onboarding_language_install_complete_desc);
        this.g = (ImageView) viewGroup.findViewById(R.id.onboarding_language_install_image);
        this.h = (Button) viewGroup.findViewById(R.id.language_setting_complete_button);
        if (!this.a) {
            this.d.setVisibility(8);
        }
        this.h.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ d b;

            public void onClick(View view) {
                if (this.b.getActivity() == null) {
                    f.d("LanguageSelectionCompleteFragment", "Null activity in onClick(); dropping");
                } else if (this.b.a) {
                    a.a(PebbleApplication.n(), 3);
                    ((OnboardingActivity) activity).i();
                } else {
                    activity.finish();
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        Activity activity = getActivity();
        if (activity == null) {
            f.a("LanguageSelectionCompleteFragment", "Activity is null; short-circuiting onResume");
            return;
        }
        a();
        if (this.c) {
            f.d("LanguageSelectionCompleteFragment", String.format("Set up language install fragment; language=<%s>", new Object[]{this.b}));
            this.f.setText(String.format(activity.getResources().getString(R.string.language_set_successfully_description), new Object[]{this.b}));
            return;
        }
        f.d("LanguageSelectionCompleteFragment", "Set up language install fragment; success failed");
        this.d.setText(R.string.language_selection_failed_title);
        this.f.setText(R.string.language_selection_failed_desc);
        this.h.setText(R.string.onboarding_continue_button_text);
        this.g.setImageResource(R.drawable.fu_error);
        this.e.setVisibility(4);
    }

    private void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.c = arguments.getBoolean("extra_install_successful", false);
            this.b = arguments.getString("extra_install_language_name", null);
            return;
        }
        f.a("LanguageSelectionCompleteFragment", "Cannot install language; no arguments provided to fragment");
        this.c = false;
    }
}
