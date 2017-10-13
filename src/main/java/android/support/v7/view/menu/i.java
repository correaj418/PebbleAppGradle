package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.q.e;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
public class i extends c<android.support.v4.c.a.b> implements MenuItem {
    private Method c;

    class a extends android.support.v4.view.d {
        final ActionProvider a;
        final /* synthetic */ i b;

        public a(i iVar, Context context, ActionProvider actionProvider) {
            this.b = iVar;
            super(context);
            this.a = actionProvider;
        }

        public View a() {
            return this.a.onCreateActionView();
        }

        public boolean d() {
            return this.a.onPerformDefaultAction();
        }

        public boolean e() {
            return this.a.hasSubMenu();
        }

        public void a(SubMenu subMenu) {
            this.a.onPrepareSubMenu(this.b.a(subMenu));
        }
    }

    static class b extends FrameLayout implements android.support.v7.view.b {
        final CollapsibleActionView a;

        b(View view) {
            super(view.getContext());
            this.a = (CollapsibleActionView) view;
            addView(view);
        }

        public void a() {
            this.a.onActionViewExpanded();
        }

        public void b() {
            this.a.onActionViewCollapsed();
        }

        View c() {
            return (View) this.a;
        }
    }

    private class c extends d<OnActionExpandListener> implements e {
        final /* synthetic */ i a;

        c(i iVar, OnActionExpandListener onActionExpandListener) {
            this.a = iVar;
            super(onActionExpandListener);
        }

        public boolean a(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.a.a(menuItem));
        }

        public boolean b(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.a.a(menuItem));
        }
    }

    private class d extends d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ i a;

        d(i iVar, OnMenuItemClickListener onMenuItemClickListener) {
            this.a = iVar;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.a.a(menuItem));
        }
    }

    i(Context context, android.support.v4.c.a.b bVar) {
        super(context, bVar);
    }

    public int getItemId() {
        return ((android.support.v4.c.a.b) this.b).getItemId();
    }

    public int getGroupId() {
        return ((android.support.v4.c.a.b) this.b).getGroupId();
    }

    public int getOrder() {
        return ((android.support.v4.c.a.b) this.b).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((android.support.v4.c.a.b) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((android.support.v4.c.a.b) this.b).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((android.support.v4.c.a.b) this.b).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((android.support.v4.c.a.b) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((android.support.v4.c.a.b) this.b).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((android.support.v4.c.a.b) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((android.support.v4.c.a.b) this.b).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((android.support.v4.c.a.b) this.b).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((android.support.v4.c.a.b) this.b).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((android.support.v4.c.a.b) this.b).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((android.support.v4.c.a.b) this.b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((android.support.v4.c.a.b) this.b).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((android.support.v4.c.a.b) this.b).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((android.support.v4.c.a.b) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((android.support.v4.c.a.b) this.b).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((android.support.v4.c.a.b) this.b).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((android.support.v4.c.a.b) this.b).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((android.support.v4.c.a.b) this.b).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((android.support.v4.c.a.b) this.b).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((android.support.v4.c.a.b) this.b).setVisible(z);
    }

    public boolean isVisible() {
        return ((android.support.v4.c.a.b) this.b).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((android.support.v4.c.a.b) this.b).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((android.support.v4.c.a.b) this.b).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((android.support.v4.c.a.b) this.b).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return a(((android.support.v4.c.a.b) this.b).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((android.support.v4.c.a.b) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((android.support.v4.c.a.b) this.b).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((android.support.v4.c.a.b) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((android.support.v4.c.a.b) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((android.support.v4.c.a.b) this.b).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((android.support.v4.c.a.b) this.b).setActionView(i);
        View actionView = ((android.support.v4.c.a.b) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((android.support.v4.c.a.b) this.b).setActionView(new b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((android.support.v4.c.a.b) this.b).getActionView();
        if (actionView instanceof b) {
            return ((b) actionView).c();
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((android.support.v4.c.a.b) this.b).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        android.support.v4.view.d a = ((android.support.v4.c.a.b) this.b).a();
        if (a instanceof a) {
            return ((a) a).a;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((android.support.v4.c.a.b) this.b).expandActionView();
    }

    public boolean collapseActionView() {
        return ((android.support.v4.c.a.b) this.b).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((android.support.v4.c.a.b) this.b).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((android.support.v4.c.a.b) this.b).a(onActionExpandListener != null ? new c(this, onActionExpandListener) : null);
        return this;
    }

    public void a(boolean z) {
        try {
            if (this.c == null) {
                this.c = ((android.support.v4.c.a.b) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    a a(ActionProvider actionProvider) {
        return new a(this, this.a, actionProvider);
    }
}
