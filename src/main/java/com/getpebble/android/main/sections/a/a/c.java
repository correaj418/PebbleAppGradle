package com.getpebble.android.main.sections.a.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.u;
import android.widget.CompoundButton;
import com.getpebble.android.common.model.af.b;

public class c implements d {
    private b a;

    private static class a extends com.getpebble.android.main.sections.notifications.a.c {
        public a(b bVar, Context context) {
            super(bVar, context);
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            com.getpebble.android.common.b.a.a.c.e("SearchNotificationToggle", "MyPebble");
            super.onCheckedChanged(compoundButton, z);
        }
    }

    public c(b bVar) {
        this.a = bVar;
    }

    public void a(u uVar) {
        if (uVar instanceof com.getpebble.android.main.sections.a.b.b) {
            ((com.getpebble.android.main.sections.a.b.b) uVar).a(new a(this.a, uVar.a.getContext()));
        }
    }

    public long d() {
        return (long) this.a.a.hashCode();
    }

    public String a() {
        return this.a.a;
    }
}
