package com.getpebble.android.onboarding.fragment;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
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
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.core.a;
import com.getpebble.android.onboarding.activity.OnboardingActivity;

public class i extends b implements OnClickListener {
    private TextView a;
    private Button b;
    private Button c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public int c() {
        return R.layout.fragment_warning_migration;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c.e();
        f.d("MigrationAgreementFragment", "Initializing PebbleTimeOnlyFragment");
        this.a = (TextView) viewGroup.findViewById(R.id.onboarding_banner);
        if (!(getActivity() instanceof OnboardingActivity)) {
            this.a.setVisibility(8);
            getActivity().setTitle(R.string.onboarding_migration_agreement_banner);
        }
        this.b = (Button) viewGroup.findViewById(R.id.update_my_pebble_button);
        this.b.setOnClickListener(this);
        this.c = (Button) viewGroup.findViewById(R.id.get_pebble_classic_button);
        this.c.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update_my_pebble_button:
                new Builder(getActivity()).setMessage(R.string.onboarding_migration_agreement_language_warning_msg).setPositiveButton(R.string.onboarding_migration_agreement_continue_text, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ i a;

                    {
                        this.a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.a.a(true);
                        this.a.a();
                    }
                }).setNegativeButton(R.string.onboarding_migration_agreement_cancel_text, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ i a;

                    {
                        this.a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).setCancelable(false).show();
                return;
            case R.id.get_pebble_classic_button:
                c.f();
                a(false);
                if (com.getpebble.android.onboarding.activity.b.g()) {
                    com.getpebble.android.onboarding.activity.b.h();
                } else {
                    com.getpebble.android.onboarding.activity.b.i();
                }
                getActivity().finish();
                return;
            default:
                return;
        }
    }

    private void a() {
        Activity activity = getActivity();
        if (activity instanceof a) {
            ((a) activity).a(new m());
            return;
        }
        throw new IllegalStateException("error MigrationAgreementFragment should always be displayed by OnboardingActivity or FirmwareUpdateActivity");
    }

    private void a(boolean z) {
        com.getpebble.android.onboarding.a.a(z, PebbleApplication.n());
    }
}
