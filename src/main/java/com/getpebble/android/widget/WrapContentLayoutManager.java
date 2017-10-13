package com.getpebble.android.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.r;
import android.view.View.MeasureSpec;

public class WrapContentLayoutManager extends LinearLayoutManager {
    int a;

    public WrapContentLayoutManager(Context context, int i) {
        super(context);
        this.a = context.getResources().getDimensionPixelSize(i);
    }

    public boolean e() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public void a(n nVar, r rVar, int i, int i2) {
        e(MeasureSpec.getSize(i), this.a * rVar.e());
    }
}
