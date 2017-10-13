package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.g.a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class s extends g implements SubMenu {
    private g d;
    private h e;

    public s(Context context, g gVar, h hVar) {
        super(context);
        this.d = gVar;
        this.e = hVar;
    }

    public void setQwertyMode(boolean z) {
        this.d.setQwertyMode(z);
    }

    public boolean a() {
        return this.d.a();
    }

    public boolean b() {
        return this.d.b();
    }

    public Menu p() {
        return this.d;
    }

    public MenuItem getItem() {
        return this.e;
    }

    public void a(a aVar) {
        this.d.a(aVar);
    }

    public g m() {
        return this.d.m();
    }

    boolean a(g gVar, MenuItem menuItem) {
        return super.a(gVar, menuItem) || this.d.a(gVar, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.a(drawable);
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.d(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.a(charSequence);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.c(i);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.a(view);
    }

    public boolean c(h hVar) {
        return this.d.c(hVar);
    }

    public boolean d(h hVar) {
        return this.d.d(hVar);
    }
}
