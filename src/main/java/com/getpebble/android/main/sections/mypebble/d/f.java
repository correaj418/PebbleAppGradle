package com.getpebble.android.main.sections.mypebble.d;

import android.view.View;
import com.getpebble.android.main.sections.mypebble.d.a.a;
import com.getpebble.android.main.sections.mypebble.d.b.c;

public abstract class f extends a {
    protected View h;

    public f(c cVar, g gVar, a aVar) {
        super(cVar, gVar, aVar);
    }

    public void h() {
        if (k()) {
            this.d.b();
        }
    }

    public void i() {
        if (k()) {
            com.getpebble.android.common.b.a.f.d("HeartRateCard", "show: Attempting to show HR card when it's already visible.");
        } else {
            this.h.setVisibility(0);
        }
    }

    public void j() {
        if (k()) {
            this.h.setVisibility(8);
        } else {
            com.getpebble.android.common.b.a.f.d("HeartRateCard", "hide: Attempting to hide HR card when it's already hidden.");
        }
    }

    public boolean k() {
        return this.h.getVisibility() == 0;
    }
}
