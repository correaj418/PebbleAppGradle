package com.getpebble.android.connection;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.b.d;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.onboarding.DefaultAppsFetcher;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import com.getpebble.android.onboarding.activity.b;
import com.getpebble.android.onboarding.fragment.e;
import com.getpebble.android.onboarding.fragment.l;
import com.getpebble.android.widget.PebbleTextView;
import java.util.concurrent.TimeUnit;

public class a extends ConnectionManagerFragment {
    private static final long f = TimeUnit.SECONDS.toMillis(30);
    private static final long g = TimeUnit.SECONDS.toMillis(15);
    private ProgressBar h;
    private RelativeLayout i;
    private PebbleTextView j;
    private ImageButton k;
    private View l;
    private boolean m = false;
    private Handler n = new Handler(Looper.getMainLooper());
    private Runnable o = new Runnable(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public void run() {
            f.d("OnboardingConnectionFragment", "Setting pairing problems section to visible on timeout firing");
            this.a.l.setVisibility(0);
            this.a.m = false;
            if (this.a.e && b.g()) {
                new Builder(this.a.getActivity()).setTitle(R.string.connection_manager_tintin_dialog_title).setMessage(R.string.connection_manager_tintin_dialog_msg).setPositiveButton(this.a.getString(R.string.my_pebble_ok), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 a;

                    {
                        this.a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).setCancelable(false).show();
            }
        }
    };

    public static final Fragment a(Activity activity) {
        if (PebbleApplication.n() != null) {
            return c(activity);
        }
        return new a();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.l = onCreateView.findViewById(R.id.onboarding_pairing_help);
        TextView textView = (TextView) onCreateView.findViewById(R.id.connection_manager_onboarding_banner_text);
        this.h = (ProgressBar) onCreateView.findViewById(R.id.discovery_progress_bar_onboarding);
        this.i = (RelativeLayout) onCreateView.findViewById(R.id.onboarding_banner_layout);
        this.k = (ImageButton) onCreateView.findViewById(R.id.discovery_button_onboarding);
        this.b.setVisibility(8);
        this.a.setVisibility(8);
        textView.setVisibility(0);
        this.i.setVisibility(0);
        this.j = (PebbleTextView) this.l.findViewById(R.id.pairing_problems_button);
        this.j.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                ((OnboardingActivity) this.a.getActivity()).a(new l());
            }
        });
        return onCreateView;
    }

    protected void c() {
        f.d("OnboardingConnectionFragment", "updateUiForDiscoveryStarted()");
        this.k.setVisibility(4);
        this.k.setOnClickListener(null);
        this.h.setVisibility(0);
    }

    protected void d() {
        f.d("OnboardingConnectionFragment", "updateUiForDiscoveryStopped()");
        this.k.setVisibility(0);
        this.k.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                f.d("OnboardingConnectionFragment", "Starting discovery from onboarding actionbar");
                this.a.e();
            }
        });
        this.h.setVisibility(4);
    }

    protected ProgressBar b() {
        return this.h;
    }

    protected void a() {
        if (this.c != null && this.c.connectionStatus.equals(d.CONNECTED)) {
            h();
        }
    }

    protected boolean f() {
        return false;
    }

    protected boolean g() {
        return false;
    }

    public void onResume() {
        super.onResume();
        if (this.c != null && this.c.connectionStatus.equals(d.CONNECTED)) {
            h();
        } else if (!this.m) {
            this.m = true;
            this.n.postDelayed(this.o, f);
        }
    }

    public void onStop() {
        this.n.removeCallbacks(this.o);
        this.m = false;
        super.onStop();
    }

    private boolean h() {
        return this.n.post(new Runnable(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void run() {
                Activity activity = this.a.getActivity();
                if (activity instanceof OnboardingActivity) {
                    ((OnboardingActivity) activity).a(a.c(activity));
                }
            }
        });
    }

    private static final Fragment c(Activity activity) {
        if (activity instanceof OnboardingActivity) {
            DefaultAppsFetcher f = ((OnboardingActivity) activity).f();
            if (f != null) {
                f.fetchAppsFromCloudAsync();
            } else {
                f.c("OnboardingConnectionFragment", "getNextOnboardingFragment: fetcher is null");
            }
        }
        return e.a(activity);
    }
}
