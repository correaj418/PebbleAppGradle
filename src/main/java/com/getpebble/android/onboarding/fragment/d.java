package com.getpebble.android.onboarding.fragment;

import android.app.Activity;
import android.content.Context;
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
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.framework.install.app.b.a;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.notifications.b.f;
import com.getpebble.android.onboarding.activity.OnboardingActivity;

public class d extends b {
    private Button a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private TextView e;
    private boolean f = false;
    private boolean g = false;
    private final com.getpebble.android.notifications.b.d h = new com.getpebble.android.notifications.b.d(OnboardingActivity.class);
    private a i;

    public int c() {
        return R.layout.fragment_enable_notifications;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = (ImageView) viewGroup.findViewById(R.id.enable_notifications_icon);
        this.e = (TextView) viewGroup.findViewById(R.id.enable_notifications_explanation);
        this.a = (Button) viewGroup.findViewById(R.id.onboarding_enable_btn);
        this.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                c.e("enable", "OnboardingMigration");
                this.a.b();
                this.a.f = true;
            }
        });
        this.c = (TextView) viewGroup.findViewById(R.id.enable_notifs_onboarding_banner_layout).findViewById(R.id.enable_notifs_onboarding_banner_text);
        this.b = (TextView) viewGroup.findViewById(R.id.enable_notifs_onboarding_banner_layout).findViewById(R.id.enable_notifs_onboarding_skip_button);
        this.b.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (this.a.g) {
                    this.a.d();
                } else {
                    this.a.a();
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        ak.a p = PebbleApplication.p();
        if (!(p == null || p.hwPlatform.getPlatformCode().equals(this.i))) {
            this.i = p.hwPlatform.getPlatformCode();
        }
        if (f.a(getActivity())) {
            d();
            this.h.b();
        } else if (this.f) {
            a();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.h.b();
    }

    private void a() {
        this.g = true;
        if (this.i == a.CHALK) {
            this.d.setImageResource(R.drawable.fu_wrong_s4);
        } else {
            this.d.setImageDrawable(getResources().getDrawable(R.drawable.fu_wrong));
        }
        this.a.setText(R.string.onboarding_enable_notifs_fix_permission);
        this.e.setText(R.string.onboarding_enable_notifs_explanation_are_you_sure);
        this.c.setText(R.string.onboarding_are_you_sure_banner_text);
    }

    private void b() {
        Context activity = getActivity();
        if (activity != null) {
            f.b(activity);
            this.h.a();
        }
    }

    private void d() {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof OnboardingActivity)) {
            ((OnboardingActivity) activity).i();
        }
    }
}
