package com.cocosw.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

class PinnedSectionGridView extends GridView {
    private int a;
    private int b;
    private int c;
    private int d;

    public PinnedSectionGridView(Context context) {
        super(context);
    }

    public PinnedSectionGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PinnedSectionGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getNumColumns() {
        return this.a;
    }

    public void setNumColumns(int i) {
        this.a = i;
        super.setNumColumns(i);
    }

    public int getHorizontalSpacing() {
        return this.b;
    }

    public void setHorizontalSpacing(int i) {
        this.b = i;
        super.setHorizontalSpacing(i);
    }

    public int getColumnWidth() {
        return this.c;
    }

    public void setColumnWidth(int i) {
        this.c = i;
        super.setColumnWidth(i);
    }

    public int a() {
        return this.d != 0 ? this.d : getWidth();
    }
}
