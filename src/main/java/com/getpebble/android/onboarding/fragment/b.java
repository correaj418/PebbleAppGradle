package com.getpebble.android.onboarding.fragment;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.onboarding.activity.OnboardingActivity;

public class b extends com.getpebble.android.common.framework.a.b {
    private c a;

    public int c() {
        return R.layout.fragment_enable_health;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = new c(getActivity());
        ((TextView) viewGroup.findViewById(R.id.health_onboarding_skip_button)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                a.c.e("skip", "OnboardingPebbleHealth");
                com.getpebble.android.onboarding.a.b(PebbleApplication.n(), 3);
                this.a.e();
            }
        });
        ((Button) viewGroup.findViewById(R.id.activity_tracking_enable_button)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                a.c.e("enable_pebble_health", "OnboardingPebbleHealth");
                if (this.a.a.a(c.a.PRIVACY_POLICY_ACCEPTED, false)) {
                    this.a.b();
                } else {
                    this.a.d();
                }
            }
        });
        if (this.a.a(c.a.PRIVACY_POLICY_ACCEPTED, false)) {
            String string = getString(R.string.onboarding_enable_health_privacy_policy, new Object[]{com.getpebble.android.config.a.c().U()});
            TextView textView = (TextView) viewGroup.findViewById(R.id.enable_health_privacy_policy);
            textView.setVisibility(0);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(Html.fromHtml(string));
        }
    }

    private void a() {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof OnboardingActivity)) {
            ((OnboardingActivity) activity).a(new c());
        }
    }

    private void b() {
        ((OnboardingActivity) getActivity()).k().trackingEnabled = true;
        a();
    }

    private void d() {
        new Builder(getActivity()).setMessage(R.string.onboarding_enable_health_policy_confirm).setNegativeButton(R.string.health_policy_disagree, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.a.b(c.a.PRIVACY_POLICY_ACCEPTED, false);
                a.c.c(false);
                dialogInterface.dismiss();
            }
        }).setPositiveButton(R.string.health_policy_agree, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.a.b(c.a.PRIVACY_POLICY_ACCEPTED, true);
                a.c.c(true);
                this.a.b();
            }
        }).setNeutralButton(R.string.health_policy_review, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                String U = com.getpebble.android.config.a.c().U();
                if (U != null) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(U));
                    this.a.startActivity(intent);
                }
            }
        }).create().show();
    }

    private void e() {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof OnboardingActivity)) {
            ((OnboardingActivity) activity).i();
        }
    }
}
