package com.getpebble.android.onboarding.fragment;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.framework.a.a;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.connection.ConnectionManagerFragment;
import com.getpebble.android.main.sections.support.fragment.SupportFragment;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import com.getpebble.android.widget.PebbleButton;

public class l extends b implements a {
    public int c() {
        return R.layout.pairing_problems_fragment;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ActionBar actionBar = getActivity().getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.onboarding_app_pairing_problems_title);
        }
        ((PebbleButton) viewGroup.findViewById(R.id.pairing_doesnt_seem_to_be_working)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ l a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(PebbleApplication.w().t())));
            }
        });
        ((PebbleButton) viewGroup.findViewById(R.id.retry_pairing_button)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ l a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                ((OnboardingActivity) this.a.getActivity()).a(new com.getpebble.android.connection.a());
            }
        });
        ((PebbleButton) viewGroup.findViewById(R.id.pairing_problems_cant_find_bluetooth_code)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ l a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(PebbleApplication.w().s())));
            }
        });
        ((PebbleButton) viewGroup.findViewById(R.id.pairing_problems_contact_support_button)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ l a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                SupportFragment.a(this.a.getActivity());
            }
        });
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        Activity activity = getActivity();
        if (activity instanceof OnboardingActivity) {
            ((OnboardingActivity) activity).a(new ConnectionManagerFragment());
        }
        return true;
    }
}
