package com.getpebble.android.main.sections.mypebble.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import com.getpebble.android.basalt.R;

public class c extends a {
    private final short a;
    private final a b;
    private com.getpebble.android.framework.health.g.a.a c;
    private EditText d;
    private ViewGroup e;
    private EditText f;
    private EditText g;

    public interface a {
        void a(com.getpebble.android.framework.health.g.a.a aVar, short s);
    }

    public c(Context context, short s, com.getpebble.android.framework.health.g.a.a aVar, a aVar2) {
        super(context);
        this.a = s;
        this.c = aVar;
        this.b = aVar2;
    }

    protected void onCreate(Bundle bundle) {
        Context context = getContext();
        setTitle(R.string.height_weight_dialog_title_height);
        View inflate = View.inflate(context, R.layout.height_weight_dialog, null);
        setView(inflate);
        this.d = (EditText) inflate.findViewById(R.id.single_value_input);
        this.e = (ViewGroup) inflate.findViewById(R.id.feet_inches_input_container);
        this.f = (EditText) inflate.findViewById(R.id.feet_input);
        this.g = (EditText) inflate.findViewById(R.id.inches_input);
        final a aVar = new a(this, getContext(), com.getpebble.android.framework.health.g.a.a.values());
        Spinner spinner = (Spinner) inflate.findViewById(R.id.units_spinner);
        spinner.setAdapter(aVar);
        spinner.setSelection(aVar.getPosition(this.c));
        a(this.c == com.getpebble.android.framework.health.g.a.a.INCHES);
        if (this.a != (short) 0 && this.c == com.getpebble.android.framework.health.g.a.a.INCHES) {
            int fromMillimeters = this.c.fromMillimeters(this.a);
            this.f.setText(String.valueOf(fromMillimeters / 12));
            this.g.setText(String.valueOf(fromMillimeters % 12));
        } else if (this.a != (short) 0) {
            this.d.setText(String.valueOf(this.c.fromMillimeters(this.a)));
        }
        spinner.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            final /* synthetic */ c b;

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                this.b.c = (com.getpebble.android.framework.health.g.a.a) aVar.getItem(i);
                this.b.a(this.b.c == com.getpebble.android.framework.health.g.a.a.INCHES);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        super.onCreate(bundle);
    }

    private void a(boolean z) {
        if (z) {
            this.e.setVisibility(0);
            this.d.setVisibility(8);
            return;
        }
        this.e.setVisibility(8);
        this.d.setVisibility(0);
    }

    protected String a() {
        if (this.c == com.getpebble.android.framework.health.g.a.a.INCHES) {
            return a(this.f.getText().toString(), this.g.getText().toString(), getContext());
        }
        return a(this.d.getText().toString(), getContext());
    }

    static String a(String str, String str2, Context context) {
        if (str.isEmpty()) {
            return context.getString(R.string.height_weight_dialog_empty_field);
        }
        if ((str2.isEmpty() ? 0 : Integer.parseInt(str2)) > 11) {
            return context.getString(R.string.height_weight_dialog_invalid_inches);
        }
        return "valid_input";
    }

    static String a(String str, Context context) {
        if (str.isEmpty()) {
            return context.getString(R.string.height_weight_dialog_empty_field);
        }
        return "valid_input";
    }

    protected void b() {
        int toMillimeters;
        if (this.c == com.getpebble.android.framework.health.g.a.a.INCHES) {
            toMillimeters = this.c.toMillimeters((this.g.getText().toString().isEmpty() ? 0 : a.a(this.g)) + (a.a(this.f) * 12));
        } else {
            toMillimeters = this.c.toMillimeters(a.a(this.d));
        }
        this.b.a(this.c, (short) toMillimeters);
    }
}
