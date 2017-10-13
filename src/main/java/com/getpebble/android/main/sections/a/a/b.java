package com.getpebble.android.main.sections.a.a;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.u;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.model.am.c;
import com.getpebble.android.main.activity.MainActivity;
import com.getpebble.android.main.sections.mypebble.a.h;
import com.getpebble.android.main.sections.mypebble.fragment.d;

public class b implements d {
    private Activity a;
    private boolean b;
    private c c;

    private static class a extends h {
        public a(c cVar, boolean z) {
            super(cVar, z);
        }

        protected void a(Activity activity) {
            com.getpebble.android.common.b.a.a.c.e("SearchConfigureSettings", "MyPebble");
            super.a(activity);
        }
    }

    public b(c cVar, boolean z, Activity activity) {
        this.c = cVar;
        this.a = activity;
        this.b = z;
    }

    public void a(u uVar) {
        h aVar = new a(this.c, true);
        if (uVar instanceof com.getpebble.android.main.sections.a.b.c) {
            a(aVar, (com.getpebble.android.main.sections.a.b.c) uVar);
        } else if (uVar instanceof com.getpebble.android.main.sections.a.b.a) {
            a(aVar, (com.getpebble.android.main.sections.a.b.a) uVar);
        }
        uVar.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                com.getpebble.android.common.b.a.a.c.e("SearchItemDetails", "MyPebble");
                if (this.a.a instanceof MainActivity) {
                    d.a(this.a.c, false, this.a.b).show(this.a.a.getFragmentManager(), "app_dialog");
                }
            }
        });
    }

    private void a(h hVar, com.getpebble.android.main.sections.a.b.c cVar) {
        hVar.a(cVar.l);
        a(cVar.m);
    }

    private void a(h hVar, com.getpebble.android.main.sections.a.b.a aVar) {
        hVar.a(aVar.m);
        hVar.b(aVar.n);
        hVar.a(aVar.l);
        a(aVar.o);
    }

    private void a(TextView textView) {
        textView.setEnabled(false);
        textView.setOnClickListener(null);
        textView.setText(R.string.onboarding_grab_apps_added_btn);
        textView.setBackgroundResource(R.drawable.btn_green_selected);
    }

    public long d() {
        return (long) this.c.b.hashCode();
    }

    public String a() {
        return this.c.b.toString();
    }
}
