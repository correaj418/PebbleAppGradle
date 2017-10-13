package com.getpebble.android.main.sections.mypebble.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import com.getpebble.android.basalt.R;
import com.getpebble.android.framework.health.g.a.b;

public class d extends a {
    private final short a;
    private final a b;
    private b c;
    private EditText d;

    public interface a {
        void a(b bVar, short s);
    }

    public d(Context context, short s, b bVar, a aVar) {
        super(context);
        this.a = s;
        this.c = bVar;
        this.b = aVar;
    }

    protected void onCreate(Bundle bundle) {
        Context context = getContext();
        setTitle(R.string.height_weight_dialog_title_weight);
        View inflate = View.inflate(context, R.layout.height_weight_dialog, null);
        setView(inflate);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.units_spinner);
        this.d = (EditText) inflate.findViewById(R.id.single_value_input);
        final a aVar = new a(this, getContext(), b.values());
        spinner.setAdapter(aVar);
        spinner.setSelection(aVar.getPosition(this.c));
        if (this.a != (short) 0) {
            this.d.setText(String.valueOf(this.c.fromDecagrams(this.a)));
        }
        spinner.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            final /* synthetic */ d b;

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                this.b.c = (b) aVar.getItem(i);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        super.onCreate(bundle);
    }

    protected String a() {
        return a(this.d.getText().toString(), this.c, getContext());
    }

    static String a(String str, b bVar, Context context) {
        if (str.isEmpty()) {
            return context.getString(R.string.height_weight_dialog_empty_field);
        }
        if (bVar.toDecagrams(Integer.parseInt(str)) > 32767) {
            return context.getString(R.string.height_weight_dialog_invalid_weight);
        }
        return "valid_input";
    }

    protected void b() {
        this.b.a(this.c, (short) this.c.toDecagrams(a.a(this.d)));
    }
}
