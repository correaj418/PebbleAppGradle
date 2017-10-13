package com.c.a.a.a;

import android.view.View;

public abstract class a {
    public final View f;

    public a(View view) {
        this.f = view;
    }

    protected final <T extends View> T a(int i) {
        return this.f.findViewById(i);
    }
}
