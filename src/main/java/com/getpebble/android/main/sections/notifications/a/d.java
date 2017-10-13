package com.getpebble.android.main.sections.notifications.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.u;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.getpebble.android.basalt.R;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class d extends android.support.v7.widget.RecyclerView.a<a> {
    private Map<Integer, String> a;
    private android.support.v7.widget.a.a.a b = new android.support.v7.widget.a.a.a(this) {
        final /* synthetic */ d a;

        {
            this.a = r1;
        }

        public int a(RecyclerView recyclerView, u uVar) {
            return android.support.v7.widget.a.a.a.b(3, 0);
        }

        public void b(u uVar, int i) {
            super.b(uVar, i);
            if (i == 0) {
                this.a.d();
            }
        }

        public boolean b(RecyclerView recyclerView, u uVar, u uVar2) {
            int e = uVar.e();
            int e2 = uVar2.e();
            String str = (String) this.a.a.get(Integer.valueOf(e));
            this.a.a.put(Integer.valueOf(e), this.a.a.get(Integer.valueOf(e2)));
            this.a.a.put(Integer.valueOf(e2), str);
            this.a.a(e, e2);
            return true;
        }

        public void a(u uVar, int i) {
        }

        public boolean b() {
            return false;
        }
    };

    public class a extends u {
        final /* synthetic */ d l;
        private final EditText m;
        private final TextWatcher n = new TextWatcher(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                this.a.l.a.put(Integer.valueOf(this.a.e()), editable.toString());
            }
        };

        public a(d dVar, View view) {
            this.l = dVar;
            super(view);
            this.m = (EditText) view.findViewById(R.id.response);
            this.m.addTextChangedListener(this.n);
        }

        private void c(int i) {
            String str = (String) this.l.a.get(Integer.valueOf(i));
            this.m.setText(str);
            if (this.m.hasFocus()) {
                this.m.setSelection(TextUtils.isEmpty(str) ? 0 : str.length());
            }
            this.m.clearFocus();
        }
    }

    public /* synthetic */ u a(ViewGroup viewGroup, int i) {
        return c(viewGroup, i);
    }

    public d(RecyclerView recyclerView, Map<Integer, String> map) {
        this.a = map;
        new android.support.v7.widget.a.a(this.b).a(recyclerView);
    }

    public void a(Map<Integer, String> map) {
        this.a = map;
        d();
    }

    public boolean e() {
        if (this.a == null) {
            this.a = new HashMap();
        }
        if (this.a.size() >= 10) {
            return false;
        }
        int size = this.a.size();
        this.a.put(Integer.valueOf(size), "");
        d(size);
        return true;
    }

    public HashMap<Integer, String> f() {
        HashMap<Integer, String> hashMap = new HashMap();
        for (Entry entry : this.a.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return hashMap;
    }

    public a c(ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.canned_response_item, viewGroup, false));
    }

    public void a(a aVar, int i) {
        aVar.c(i);
    }

    public int a() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }
}
