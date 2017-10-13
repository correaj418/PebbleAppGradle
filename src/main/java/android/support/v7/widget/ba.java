package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a.a;
import android.support.v7.b.a.e;
import android.support.v7.b.a.i;
import android.support.v7.b.a.k;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class ba implements w {
    private Toolbar a;
    private int b;
    private View c;
    private Drawable d;
    private Drawable e;
    private Drawable f;
    private boolean g;
    private CharSequence h;
    private CharSequence i;
    private CharSequence j;
    private Callback k;
    private boolean l;
    private int m;
    private final i n;
    private int o;
    private Drawable p;

    public ba(Toolbar toolbar, boolean z) {
        this(toolbar, z, i.abc_action_bar_up_description, e.abc_ic_ab_back_material);
    }

    public ba(Toolbar toolbar, boolean z, int i, int i2) {
        this.m = 0;
        this.o = 0;
        this.a = toolbar;
        this.h = toolbar.getTitle();
        this.i = toolbar.getSubtitle();
        this.g = this.h != null;
        this.f = toolbar.getNavigationIcon();
        az a = az.a(toolbar.getContext(), null, k.ActionBar, a.actionBarStyle, 0);
        this.p = a.a(k.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence b = a.b(k.ActionBar_title);
            if (!TextUtils.isEmpty(b)) {
                b(b);
            }
            b = a.b(k.ActionBar_subtitle);
            if (!TextUtils.isEmpty(b)) {
                c(b);
            }
            Drawable a2 = a.a(k.ActionBar_logo);
            if (a2 != null) {
                b(a2);
            }
            a2 = a.a(k.ActionBar_icon);
            if (a2 != null) {
                a(a2);
            }
            if (this.f == null && this.p != null) {
                c(this.p);
            }
            d(a.a(k.ActionBar_displayOptions, 0));
            int g = a.g(k.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                a(LayoutInflater.from(this.a.getContext()).inflate(g, this.a, false));
                d(this.b | 16);
            }
            g = a.f(k.ActionBar_height, 0);
            if (g > 0) {
                LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = g;
                this.a.setLayoutParams(layoutParams);
            }
            g = a.d(k.ActionBar_contentInsetStart, -1);
            int d = a.d(k.ActionBar_contentInsetEnd, -1);
            if (g >= 0 || d >= 0) {
                this.a.a(Math.max(g, 0), Math.max(d, 0));
            }
            g = a.g(k.ActionBar_titleTextStyle, 0);
            if (g != 0) {
                this.a.a(this.a.getContext(), g);
            }
            g = a.g(k.ActionBar_subtitleTextStyle, 0);
            if (g != 0) {
                this.a.b(this.a.getContext(), g);
            }
            int g2 = a.g(k.ActionBar_popupTheme, 0);
            if (g2 != 0) {
                this.a.setPopupTheme(g2);
            }
        } else {
            this.b = c();
        }
        a.a();
        this.n = i.a();
        c(i);
        this.j = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new OnClickListener(this) {
            final android.support.v7.view.menu.a a = new android.support.v7.view.menu.a(this.b.a.getContext(), 0, 16908332, 0, 0, this.b.h);
            final /* synthetic */ ba b;

            {
                this.b = r8;
            }

            public void onClick(View view) {
                if (this.b.k != null && this.b.l) {
                    this.b.k.onMenuItemSelected(0, this.a);
                }
            }
        });
    }

    public void c(int i) {
        if (i != this.o) {
            this.o = i;
            if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
                e(this.o);
            }
        }
    }

    private int c() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        this.p = this.a.getNavigationIcon();
        return 15;
    }

    public Context b() {
        return this.a.getContext();
    }

    public void a(Callback callback) {
        this.k = callback;
    }

    public void a(CharSequence charSequence) {
        if (!this.g) {
            e(charSequence);
        }
    }

    public CharSequence a() {
        return this.a.getTitle();
    }

    public void b(CharSequence charSequence) {
        this.g = true;
        e(charSequence);
    }

    private void e(CharSequence charSequence) {
        this.h = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    public void c(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    public void a(int i) {
        a(i != 0 ? this.n.a(b(), i) : null);
    }

    public void a(Drawable drawable) {
        this.d = drawable;
        d();
    }

    public void b(int i) {
        b(i != 0 ? this.n.a(b(), i) : null);
    }

    public void b(Drawable drawable) {
        this.e = drawable;
        d();
    }

    private void d() {
        Drawable drawable = null;
        if ((this.b & 2) != 0) {
            drawable = (this.b & 1) != 0 ? this.e != null ? this.e : this.d : this.d;
        }
        this.a.setLogo(drawable);
    }

    public void d(int i) {
        int i2 = this.b ^ i;
        this.b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    f();
                }
                e();
            }
            if ((i2 & 3) != 0) {
                d();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.h);
                    this.a.setSubtitle(this.i);
                } else {
                    this.a.setTitle(null);
                    this.a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.c != null) {
                if ((i & 16) != 0) {
                    this.a.addView(this.c);
                } else {
                    this.a.removeView(this.c);
                }
            }
        }
    }

    public void a(View view) {
        if (!(this.c == null || (this.b & 16) == 0)) {
            this.a.removeView(this.c);
        }
        this.c = view;
        if (view != null && (this.b & 16) != 0) {
            this.a.addView(this.c);
        }
    }

    public void c(Drawable drawable) {
        this.f = drawable;
        e();
    }

    private void e() {
        if ((this.b & 4) != 0) {
            this.a.setNavigationIcon(this.f != null ? this.f : this.p);
        } else {
            this.a.setNavigationIcon(null);
        }
    }

    public void d(CharSequence charSequence) {
        this.j = charSequence;
        f();
    }

    public void e(int i) {
        d(i == 0 ? null : b().getString(i));
    }

    private void f() {
        if ((this.b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.j)) {
            this.a.setNavigationContentDescription(this.o);
        } else {
            this.a.setNavigationContentDescription(this.j);
        }
    }
}
