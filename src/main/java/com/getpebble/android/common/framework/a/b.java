package com.getpebble.android.common.framework.a;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;

public abstract class b extends Fragment {
    private RelativeLayout a = null;

    public abstract void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public abstract int c();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(R.layout.fragment_pebble_base, null);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(c(), frameLayout, false);
        a(layoutInflater, viewGroup2, bundle);
        if (frameLayout == null) {
            throw new IllegalStateException("There is no base layout!");
        }
        if (viewGroup2 != null) {
            frameLayout.addView(viewGroup2);
        }
        this.a = (RelativeLayout) frameLayout.findViewById(R.id.grp_loading_wrapper);
        if (this.a != null) {
            this.a.bringToFront();
        }
        return frameLayout;
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
    }

    public void onDestroy() {
        super.onDestroy();
        PebbleApplication.a((Object) this);
    }
}
