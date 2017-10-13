package com.getpebble.android.main.sections.mypebble.a;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.model.o;
import java.util.List;

public class e extends a<a> {
    protected static String b = "CalendarSettingsAdapter";
    private c d;

    public class a extends a {
        public final CheckBox d = ((CheckBox) a(R.id.calendar_checkbox));
        final /* synthetic */ e e;

        public a(e eVar, View view) {
            this.e = eVar;
            super(eVar, view);
        }

        protected void a(final com.getpebble.android.common.model.o.a aVar) {
            super.a(aVar);
            this.d.setOnCheckedChangeListener(null);
            this.d.setChecked(aVar.h);
            this.d.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
                final /* synthetic */ a b;

                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z != aVar.h) {
                        aVar.h = z;
                        o.b(com.getpebble.android.common.a.K().getContentResolver(), aVar);
                        int b = this.b.e.b();
                        this.b.e.d.a(b);
                        com.getpebble.android.common.b.a.a.c.a(this.b.e.a.size(), b);
                    }
                }
            });
        }
    }

    public static class b extends AsyncTask<Void, Void, Boolean> {
        private boolean a = false;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((Void[]) objArr);
        }

        public b(boolean z) {
            this.a = z;
        }

        protected Boolean a(Void... voidArr) {
            return Boolean.valueOf(o.a(com.getpebble.android.common.a.K().getContentResolver(), this.a));
        }
    }

    public interface c {
        void a(int i);
    }

    public e(Context context, List<com.getpebble.android.common.model.o.a> list, c cVar) {
        super(context, R.layout.fragment_dialog_calendar_settings_row, list);
        this.d = cVar;
    }

    protected a a(int i, View view, com.getpebble.android.common.model.o.a aVar) {
        return new a(this, view);
    }

    public int b() {
        int i = 0;
        for (com.getpebble.android.common.model.o.a aVar : this.a) {
            int i2;
            if (aVar.h) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    public void a(View view) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.calendar_checkbox);
        checkBox.setChecked(!checkBox.isChecked());
    }
}
