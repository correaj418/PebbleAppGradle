package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.b.a.j;
import android.view.LayoutInflater;

public class c extends ContextWrapper {
    private int a;
    private Theme b;
    private LayoutInflater c;

    public c(Context context, int i) {
        super(context);
        this.a = i;
    }

    public c(Context context, Theme theme) {
        super(context);
        this.b = theme;
    }

    public void setTheme(int i) {
        if (this.a != i) {
            this.a = i;
            a();
        }
    }

    public Theme getTheme() {
        if (this.b != null) {
            return this.b;
        }
        if (this.a == 0) {
            this.a = j.Theme_AppCompat_Light;
        }
        a();
        return this.b;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.c;
    }

    protected void a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    private void a() {
        boolean z = this.b == null;
        if (z) {
            this.b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        a(this.b, this.a, z);
    }
}
