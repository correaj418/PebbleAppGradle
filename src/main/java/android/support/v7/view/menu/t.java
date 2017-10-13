package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class t extends p implements SubMenu {
    t(Context context, c cVar) {
        super(context, cVar);
    }

    public c b() {
        return (c) this.b;
    }

    public SubMenu setHeaderTitle(int i) {
        b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        b().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        b().clearHeader();
    }

    public SubMenu setIcon(int i) {
        b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        b().setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return a(b().getItem());
    }
}
