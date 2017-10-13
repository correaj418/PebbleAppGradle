package com.getpebble.android.onboarding.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.am.e;
import com.getpebble.android.main.sections.mypebble.a.c;
import com.getpebble.android.onboarding.DefaultAppsFetcher;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import java.util.List;

public class p extends Fragment {
    private RecyclerView a;
    private c b;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.choose_watchface_fragment, viewGroup, false);
        DefaultAppsFetcher f = ((OnboardingActivity) getActivity()).f();
        if (f == null) {
            f.b("WatchfaceSelectionFragment", "fetcher is null");
            a();
            return inflate;
        }
        List onboardingFaces = f.getOnboardingFaces();
        if (onboardingFaces == null) {
            f.b("WatchfaceSelectionFragment", "faces is null");
            a();
            return inflate;
        }
        onboardingFaces.addAll(0, am.a(a.K(), PebbleApplication.p()));
        ((ImageButton) inflate.findViewById(R.id.choose_watchface_onboarding_layout).findViewById(R.id.choose_watchface_continue_button)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ p a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.a();
            }
        });
        this.a = (RecyclerView) inflate.findViewById(R.id.watchfaces_grid);
        h gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        this.a.setLayoutManager(gridLayoutManager);
        this.b = new c(getActivity(), onboardingFaces, true, this.a, null, gridLayoutManager, 2, e.WATCHFACE);
        this.a.setAdapter(this.b);
        return inflate;
    }

    private void a() {
        ((OnboardingActivity) getActivity()).a(new g());
    }

    public void onDestroy() {
        super.onDestroy();
        PebbleApplication.a((Object) this);
    }
}
