package com.getpebble.android.main.sections.support.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.b.a;
import com.getpebble.android.framework.d;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import com.getpebble.android.onboarding.fragment.n;

public class NotificationDemoFragment extends b {
    private TextView a;
    private Button b;
    private Button c;
    private Button d;
    private Button e;
    private d f;
    private a g;
    private boolean h = false;

    public int c() {
        return R.layout.fragment_notification_demo;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c.d("NotificationDemo");
        this.a = (TextView) viewGroup.findViewById(R.id.onboarding_banner);
        this.b = (Button) viewGroup.findViewById(R.id.btn_demo_sms);
        this.c = (Button) viewGroup.findViewById(R.id.btn_demo_phone);
        this.d = (Button) viewGroup.findViewById(R.id.btn_demo_email);
        this.e = (Button) viewGroup.findViewById(R.id.btn_continue);
        PebbleApplication.s();
        this.f = PebbleApplication.x();
        this.b.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NotificationDemoFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                c.e("text", "NotificationDemo");
                this.a.a(com.getpebble.android.framework.i.a.a.SMS);
            }
        });
        this.c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NotificationDemoFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                c.e("phone", "NotificationDemo");
                this.a.a(com.getpebble.android.framework.i.a.a.PHONE_CALL);
            }
        });
        this.d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NotificationDemoFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                c.e("email", "NotificationDemo");
                this.a.a(com.getpebble.android.framework.i.a.a.EMAIL);
            }
        });
        this.g = new a(this) {
            final /* synthetic */ NotificationDemoFragment a;

            {
                this.a = r1;
            }

            public void onFrameworkStateChanged(FrameworkState frameworkState) {
                if (frameworkState.a() != null && frameworkState.a().equals(FrameworkState.a.NOTIFICATION_DEMO_COMPLETE)) {
                    Context activity = this.a.getActivity();
                    if (!frameworkState.f()) {
                        Toast.makeText(activity, "Notification failed to send.", 1).show();
                    } else if (activity != null) {
                        Toast.makeText(activity, R.string.notification_sent, 1).show();
                    }
                }
            }
        };
        com.getpebble.android.framework.b.a(this.g);
    }

    public void onResume() {
        super.onResume();
        a();
        if (this.h) {
            this.a.setVisibility(0);
            this.e.setVisibility(0);
            this.e.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NotificationDemoFragment a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    c.e("continue", "NotificationDemo");
                    this.a.b();
                }
            });
        }
    }

    private void b() {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof OnboardingActivity)) {
            ((OnboardingActivity) activity).a(new n());
        }
    }

    public void a() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("extra_is_onboarding")) {
            this.h = arguments.getBoolean("extra_is_onboarding");
        }
    }

    public void onDestroyView() {
        com.getpebble.android.framework.b.b(this.g);
        super.onDestroyView();
    }

    private void a(com.getpebble.android.framework.i.a.a aVar) {
        this.f.a(aVar);
    }
}
