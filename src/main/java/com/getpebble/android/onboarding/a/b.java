package com.getpebble.android.onboarding.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.getpebble.android.basalt.R;
import com.getpebble.android.widget.PebbleTextView;
import java.util.ArrayList;
import java.util.List;

public class b extends ArrayAdapter<String> {
    List<String> a = new ArrayList();

    static class a {
        PebbleTextView a;
        View b;

        a() {
        }
    }

    static class b {
        PebbleTextView a;

        b() {
        }
    }

    public b(Context context, int i, int i2, List<String> list) {
        super(context, i, i2, list);
        this.a = list;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getApplicationContext().getSystemService("layout_inflater");
        if (view == null) {
            b bVar2 = new b();
            view = layoutInflater.inflate(R.layout.spinner_item_layout, viewGroup, false);
            bVar2.a = (PebbleTextView) view.findViewById(R.id.spinner_item);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.a.setText((CharSequence) this.a.get(i));
        return view;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getApplicationContext().getSystemService("layout_inflater");
        if (view == null || !(view.getTag() instanceof a)) {
            aVar = new a();
            view = layoutInflater.inflate(R.layout.spinner_dropdown_item, viewGroup, false);
            aVar.a = (PebbleTextView) view.findViewById(R.id.dropdown_item_text);
            aVar.b = view.findViewById(R.id.dropdown_separator);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.a.setText((CharSequence) this.a.get(i));
        if (i == this.a.size() - 1) {
            aVar.b.setVisibility(8);
        } else {
            aVar.b.setVisibility(0);
        }
        return view;
    }
}
