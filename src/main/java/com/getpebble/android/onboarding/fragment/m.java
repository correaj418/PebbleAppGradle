package com.getpebble.android.onboarding.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.core.a;
import com.getpebble.android.onboarding.activity.OnboardingActivity;

public class m extends b {
    private TextView a;
    private Button b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public int c() {
        return R.layout.fragment_plug_in_charger;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.d("PlugInChargerFragment", "Initializing PlugInChargerFragment");
        this.a = (TextView) viewGroup.findViewById(R.id.onboarding_banner);
        if (!(getActivity() instanceof OnboardingActivity)) {
            this.a.setVisibility(8);
            getActivity().setTitle(R.string.plug_in_charger_banner);
        }
        this.b = (Button) viewGroup.findViewById(R.id.continue_btn);
        this.b.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ m a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.a();
            }
        });
    }

    private void a() {
        Activity activity = getActivity();
        if (activity instanceof a) {
            ((a) activity).a(new e());
        }
    }
}
