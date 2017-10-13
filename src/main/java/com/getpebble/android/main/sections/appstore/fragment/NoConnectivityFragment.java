package com.getpebble.android.main.sections.appstore.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.h.h;

public class NoConnectivityFragment extends b {
    private LinearLayout a;
    private ImageView b;
    private RotateAnimation c;
    private a d;

    public interface a {
        void a();
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c.d("NoNetworkConnection");
        this.b = (ImageView) viewGroup.findViewById(R.id.refreshImage);
        this.a = (LinearLayout) viewGroup.findViewById(R.id.refreshLayout);
        this.c = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.c.setDuration(2000);
        this.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NoConnectivityFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                Context activity = this.a.getActivity();
                if (activity == null) {
                    f.a("NoConnectivityFragment", "NoConnectivityFragment: Activity was null.");
                } else if (!h.a(activity)) {
                    this.a.b.startAnimation(this.a.c);
                } else if (this.a.d != null) {
                    this.a.d.a();
                } else {
                    activity.onBackPressed();
                }
            }
        });
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public int c() {
        return R.layout.fragment_internet_connection_error;
    }
}
