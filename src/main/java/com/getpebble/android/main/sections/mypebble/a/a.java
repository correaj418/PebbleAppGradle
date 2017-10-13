package com.getpebble.android.main.sections.mypebble.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.getpebble.android.basalt.R;
import com.getpebble.android.widget.PebbleTextView;
import java.util.List;
import java.util.Locale;

public abstract class a<T extends a> extends com.c.a.a.a<String, com.getpebble.android.common.model.o.a, b, T> {
    protected List<com.getpebble.android.common.model.o.a> a;

    protected abstract class a extends com.c.a.a.a.a {
        public final PebbleTextView a = ((PebbleTextView) a(R.id.calendar_name));
        public final View b = a(R.id.calendar_colour);
        final /* synthetic */ a c;

        protected a(a aVar, View view) {
            this.c = aVar;
            super(view);
        }

        protected void a(com.getpebble.android.common.model.o.a aVar) {
            this.a.setText(aVar.d);
            this.b.setBackgroundColor(aVar.e);
        }
    }

    public static class b extends com.c.a.a.a.a {
        public final PebbleTextView a;
        public final LinearLayout b;

        public b(View view) {
            super(view);
            this.b = (LinearLayout) view;
            this.a = (PebbleTextView) view.findViewById(R.id.calendar_account_name);
        }
    }

    public abstract void a(View view);

    public a(Context context, int i, List<com.getpebble.android.common.model.o.a> list) {
        super(context, R.layout.fragment_dialog_calendar_settings_header, i, list);
        this.a = list;
    }

    protected String a(com.getpebble.android.common.model.o.a aVar) {
        return aVar.c;
    }

    protected b a(View view, String str) {
        view.setClickable(false);
        return new b(view);
    }

    protected void a(int i, b bVar, ViewGroup viewGroup, String str) {
        if (str.length() > a()) {
            str = str.substring(0, a()) + "…";
        }
        bVar.a.setText(str.toUpperCase(Locale.getDefault()));
    }

    protected void a(int i, int i2, T t, ViewGroup viewGroup, com.getpebble.android.common.model.o.a aVar) {
        if (!TextUtils.isEmpty(aVar.d)) {
            t.a(aVar);
        }
    }

    protected int a() {
        return 40;
    }

    public void a(List<com.getpebble.android.common.model.o.a> list) {
        this.a = list;
        b((List) list);
    }
}
