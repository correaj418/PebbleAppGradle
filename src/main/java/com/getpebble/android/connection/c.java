package com.getpebble.android.connection;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.Transport;

public class c extends DialogFragment {
    private RecyclerView a;
    private a b;

    private class a extends android.support.v7.widget.RecyclerView.a<b> {
        final /* synthetic */ c a;

        private a(c cVar) {
            this.a = cVar;
        }

        public /* synthetic */ u a(ViewGroup viewGroup, int i) {
            return c(viewGroup, i);
        }

        public b c(ViewGroup viewGroup, int i) {
            return new b(this.a, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.watch_selector_list_item, viewGroup, false));
        }

        public void a(b bVar, int i) {
            bVar.c(i);
        }

        public int a() {
            return c.values().length;
        }
    }

    private class b extends u {
        final /* synthetic */ c l;
        private final View m;
        private final ImageView n;
        private final TextView o;

        public b(c cVar, View view) {
            this.l = cVar;
            super(view);
            this.m = view;
            this.n = (ImageView) view.findViewById(R.id.watch_image);
            this.o = (TextView) view.findViewById(R.id.watch_name);
        }

        private void c(int i) {
            final c cVar = c.values()[i];
            this.n.setImageResource(cVar.image);
            this.o.setText(cVar.name);
            this.m.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b b;

                public void onClick(View view) {
                    this.b.l.dismiss();
                    this.b.l.getTargetFragment().onActivityResult(98765, cVar.transport.mCode, null);
                }
            });
        }
    }

    public enum c {
        SILK(R.drawable.pebble_2, R.string.model_pebble_2, Transport.LE),
        S4(R.drawable.pebble_time_round, R.string.model_pebble_time_round, Transport.CLASSIC),
        BOBBY(R.drawable.pebble_time_steel, R.string.model_pebble_time_steel, Transport.CLASSIC),
        SNOWY(R.drawable.pebble_time, R.string.model_pebble_time, Transport.CLASSIC),
        BIANCA(R.drawable.pebble_steel, R.string.model_pebble_steel, Transport.CLASSIC),
        TINTIN(R.drawable.pebble_classic, R.string.model_pebble, Transport.CLASSIC);
        
        public final int image;
        public final int name;
        public final Transport transport;

        private c(int i, int i2, Transport transport) {
            this.image = i;
            this.name = i2;
            this.transport = transport;
        }
    }

    public static c a() {
        c cVar = new c();
        cVar.setStyle(2, 0);
        return cVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.watch_selector_dialog, viewGroup, false);
        this.a = (RecyclerView) inflate.findViewById(R.id.watch_selector);
        this.a.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        this.b = new a();
        this.a.setAdapter(this.b);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(-1, -1);
        }
    }
}
