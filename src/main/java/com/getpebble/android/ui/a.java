package com.getpebble.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r;
import android.view.View;

public class a extends g {
    private Drawable a;
    private int b;

    public a(Context context, int i, int i2) {
        this.a = new ColorDrawable(context.getResources().getColor(i));
        this.b = context.getResources().getDimensionPixelSize(i2);
    }

    public void b(Canvas canvas, RecyclerView recyclerView, r rVar) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            i iVar = (i) childAt.getLayoutParams();
            int bottom = iVar.bottomMargin + childAt.getBottom();
            this.a.setBounds(paddingLeft, bottom, width, this.b + bottom);
            this.a.draw(canvas);
        }
    }
}
