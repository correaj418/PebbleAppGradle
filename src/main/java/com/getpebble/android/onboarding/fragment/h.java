package com.getpebble.android.onboarding.fragment;

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
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.ap;
import com.getpebble.android.common.model.ba;
import com.getpebble.android.framework.health.a.a;
import com.getpebble.android.h.ac;
import com.getpebble.android.onboarding.activity.OnboardingActivity;

public class h extends b implements a {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private com.getpebble.android.framework.health.a e;
    private final OnClickListener f = new OnClickListener(this) {
        final /* synthetic */ h a;

        {
            this.a = r1;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.gender_button:
                    this.a.e.a();
                    return;
                case R.id.height_button:
                    this.a.e.a(((OnboardingActivity) this.a.getActivity()).k().heightMm, com.getpebble.android.framework.health.g.b.a());
                    return;
                case R.id.age_button:
                    this.a.e.b();
                    return;
                case R.id.weight_button:
                    this.a.e.a(((OnboardingActivity) this.a.getActivity()).k().weightDag, com.getpebble.android.framework.health.g.b.b());
                    return;
                default:
                    return;
            }
        }
    };

    public static h a(double d, double d2) {
        Bundle bundle = new Bundle();
        bundle.putDouble("key_height", d);
        bundle.putDouble("key_weight", d2);
        h hVar = new h();
        hVar.setArguments(bundle);
        return hVar;
    }

    public int c() {
        return R.layout.fragment_health_profile;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = new com.getpebble.android.framework.health.a(getActivity(), this);
        ((Button) viewGroup.findViewById(R.id.health_profile_continue_button)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ h a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                c.e("complete", "OnboardingHealthProfile");
                ba.a(((OnboardingActivity) this.a.getActivity()).k(), this.a.getActivity().getContentResolver());
                com.getpebble.android.onboarding.a.b(PebbleApplication.n(), 3);
                am.a(this.a.getActivity().getContentResolver(), am.c, true);
                this.a.a();
            }
        });
        this.b = (TextView) viewGroup.findViewById(R.id.gender_button);
        this.a = (TextView) viewGroup.findViewById(R.id.age_button);
        this.c = (TextView) viewGroup.findViewById(R.id.height_button);
        this.d = (TextView) viewGroup.findViewById(R.id.weight_button);
        this.b.setOnClickListener(this.f);
        this.a.setOnClickListener(this.f);
        this.c.setOnClickListener(this.f);
        this.d.setOnClickListener(this.f);
        Bundle arguments = getArguments();
        if (arguments != null) {
            a(arguments);
        }
    }

    private void a(Bundle bundle) {
        double d = bundle.getDouble("key_height");
        double d2 = bundle.getDouble("key_weight");
        if (d != 0.0d) {
            a(com.getpebble.android.framework.health.g.a.a.INCHES, (short) ac.b(d));
        }
        if (d2 != 0.0d) {
            a(com.getpebble.android.framework.health.g.a.b.POUNDS, (short) ac.c(d2));
        }
    }

    public void a(ap.a aVar) {
        if (aVar != null) {
            this.b.setText(getString(aVar.nameResId));
            ((OnboardingActivity) getActivity()).k().gender = aVar;
        }
    }

    public void a(String str, int i) {
        this.a.setText(str);
        ((OnboardingActivity) getActivity()).k().ageYears = (byte) i;
    }

    public void a(com.getpebble.android.framework.health.g.a.a aVar, short s) {
        com.getpebble.android.framework.health.g.b.a(aVar);
        this.c.setText(com.getpebble.android.framework.health.g.b.a(aVar, s, getActivity()));
        ((OnboardingActivity) getActivity()).k().heightMm = s;
    }

    public void a(com.getpebble.android.framework.health.g.a.b bVar, short s) {
        com.getpebble.android.framework.health.g.b.a(bVar);
        this.d.setText(getString(bVar.stringFormatterResourceId(), new Object[]{Integer.valueOf(bVar.fromDecagrams(s))}));
        ((OnboardingActivity) getActivity()).k().weightDag = s;
    }

    private void a() {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof OnboardingActivity)) {
            ((OnboardingActivity) activity).i();
        }
    }
}
