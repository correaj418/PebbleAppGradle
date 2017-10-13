package com.getpebble.android.main.sections.a.b;

import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.framework.widget.AsyncImageView;
import com.getpebble.android.main.sections.notifications.a.c;
import com.getpebble.android.widget.PebbleTextView;

public class b extends u {
    AsyncImageView l = ((AsyncImageView) this.a.findViewById(R.id.icon));
    CompoundButton m = ((CompoundButton) this.a.findViewById(R.id.app_switch));
    View n = this.a.findViewById(R.id.actions);
    TextView o = ((PebbleTextView) this.a.findViewById(R.id.name));
    TextView p = ((PebbleTextView) this.a.findViewById(R.id.subtext));

    public b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater.inflate(R.layout.view_search_notification, viewGroup, false));
    }

    public void a(c cVar) {
        this.l.a();
        this.n.setOnClickListener(null);
        this.m.setOnCheckedChangeListener(null);
        cVar.a(this.o);
        cVar.b(this.p);
        cVar.a(this.l);
        cVar.a(this.n);
        cVar.a(this.m);
    }
}
