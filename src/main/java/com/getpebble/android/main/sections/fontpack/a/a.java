package com.getpebble.android.main.sections.fontpack.a;

import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.model.w;

public class a extends android.support.v7.widget.RecyclerView.a<a> {
    private w[] a;

    public class a extends u {
        final /* synthetic */ a l;
        private TextView m;
        private TextView n;
        private ImageView o;
        private ProgressBar p;
        private w q;

        public a(a aVar, View view) {
            this.l = aVar;
            super(view);
            this.m = (TextView) view.findViewById(R.id.title);
            this.n = (TextView) view.findViewById(R.id.installation_progress);
            this.o = (ImageView) view.findViewById(R.id.checkbox);
            this.p = (ProgressBar) view.findViewById(R.id.progress_bar);
        }

        private void a(w wVar) {
            this.q = wVar;
            this.m.setText(this.q.a());
        }
    }

    public /* synthetic */ u a(ViewGroup viewGroup, int i) {
        return c(viewGroup, i);
    }

    public a(w[] wVarArr) {
        this.a = wVarArr;
    }

    public void a(w[] wVarArr) {
        this.a = wVarArr;
        d();
    }

    public a c(ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.font_pack_item, viewGroup, false));
    }

    public void a(a aVar, int i) {
        aVar.a(this.a[i]);
    }

    public int a() {
        return this.a == null ? 0 : this.a.length;
    }
}
