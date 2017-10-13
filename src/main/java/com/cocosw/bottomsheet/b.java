package com.cocosw.bottomsheet;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a;
import android.support.v4.view.d;
import android.support.v4.view.q.e;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

class b implements android.support.v4.c.a.b {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;
    private char h;
    private char i;
    private Drawable j;
    private int k = 0;
    private Context l;
    private OnMenuItemClickListener m;
    private int n = 16;

    public /* synthetic */ MenuItem setActionView(int i) {
        return a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return b(i);
    }

    public b(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.l = context;
        this.a = i2;
        this.b = i;
        this.c = i3;
        this.d = i4;
        this.e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.i;
    }

    public int getGroupId() {
        return this.b;
    }

    public Drawable getIcon() {
        return this.j;
    }

    public Intent getIntent() {
        return this.g;
    }

    public int getItemId() {
        return this.a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.h;
    }

    public int getOrder() {
        return this.d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence getTitleCondensed() {
        return this.f != null ? this.f : this.e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (this.n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.n & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.n = (z ? 1 : 0) | (this.n & -2);
        return this;
    }

    public b a(boolean z) {
        this.n = (z ? 4 : 0) | (this.n & -5);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.n = (z ? 2 : 0) | (this.n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.n = (z ? 16 : 0) | (this.n & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.j = drawable;
        this.k = 0;
        return this;
    }

    public MenuItem setIcon(int i) {
        this.k = i;
        if (i > 0) {
            this.j = a.a(this.l, i);
        }
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.h = c;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.h = c;
        this.i = c2;
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.e = this.l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.n = (z ? 0 : 8) | (this.n & -9);
        return this;
    }

    public boolean b() {
        if (this.m != null && this.m.onMenuItemClick(this)) {
            return true;
        }
        if (this.g == null) {
            return false;
        }
        this.l.startActivity(this.g);
        return true;
    }

    public void setShowAsAction(int i) {
    }

    public android.support.v4.c.a.b a(View view) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public android.support.v4.c.a.b a(int i) {
        throw new UnsupportedOperationException();
    }

    public d a() {
        return null;
    }

    public android.support.v4.c.a.b a(d dVar) {
        throw new UnsupportedOperationException();
    }

    public android.support.v4.c.a.b b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public android.support.v4.c.a.b a(e eVar) {
        return this;
    }
}
