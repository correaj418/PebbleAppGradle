package com.getpebble.android.main.sections.mypebble.a;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import com.getpebble.android.basalt.R;
import java.util.List;

public class j extends a<a> {
    protected static String b = "RemindersSettingsAdapter";
    private b d;
    private a e;

    public interface b {
        boolean a(com.getpebble.android.common.model.o.a aVar);

        void b(com.getpebble.android.common.model.o.a aVar);
    }

    public class a extends a {
        public final RadioButton d = ((RadioButton) a(R.id.reminders_radio));
        final /* synthetic */ j e;

        public a(j jVar, View view) {
            this.e = jVar;
            super(jVar, view);
        }

        protected void a(final com.getpebble.android.common.model.o.a aVar) {
            super.a(aVar);
            boolean a = this.e.d.a(aVar);
            this.d.setOnCheckedChangeListener(null);
            this.d.setChecked(a);
            this.d.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
                final /* synthetic */ a b;

                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        this.b.e.a(this.b);
                        this.b.e.d.b(aVar);
                    }
                }
            });
            if (a) {
                this.e.a(this);
            }
        }
    }

    public j(Context context, List<com.getpebble.android.common.model.o.a> list, b bVar) {
        super(context, R.layout.fragment_dialog_reminders_settings_row, list);
        this.d = bVar;
    }

    private void a(a aVar) {
        if (!aVar.equals(this.e)) {
            if (this.e != null) {
                this.e.d.setChecked(false);
            }
            this.e = aVar;
        }
    }

    protected a a(int i, View view, com.getpebble.android.common.model.o.a aVar) {
        return new a(this, view);
    }

    public void a(View view) {
        ((RadioButton) view.findViewById(R.id.reminders_radio)).setChecked(true);
    }
}
