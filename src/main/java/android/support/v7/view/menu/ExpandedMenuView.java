package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.g.b;
import android.support.v7.widget.az;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements b, n, OnItemClickListener {
    private static final int[] a = new int[]{16842964, 16843049};
    private g b;
    private int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        az a = az.a(context, attributeSet, a, i, 0);
        if (a.f(0)) {
            setBackgroundDrawable(a.a(0));
        }
        if (a.f(1)) {
            setDivider(a.a(1));
        }
        a.a();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public boolean a(h hVar) {
        return this.b.a((MenuItem) hVar, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((h) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.c;
    }
}
