package com.getpebble.android.main.sections.a.b;

import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.framework.widget.AsyncImageView;

public class c extends u {
    public AsyncImageView l = ((AsyncImageView) this.a.findViewById(R.id.search_watchface_iv));
    public TextView m = ((TextView) this.a.findViewById(R.id.search_add_btn));

    public c(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater.inflate(R.layout.view_search_watchface, viewGroup, false));
    }
}
