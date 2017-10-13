package com.getpebble.android.main.sections.a.b;

import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.framework.widget.AsyncImageView;

public class a extends u {
    public AsyncImageView l = ((AsyncImageView) this.a.findViewById(R.id.search_icon_iv));
    public TextView m = ((TextView) this.a.findViewById(R.id.search_title_tv));
    public TextView n = ((TextView) this.a.findViewById(R.id.search_developer_tv));
    public TextView o = ((TextView) this.a.findViewById(R.id.search_add_btn));

    public a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater.inflate(R.layout.view_search_app, viewGroup, false));
    }
}
