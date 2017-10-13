package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.view.q;
import android.support.v7.b.a.k;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.i;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class d extends MenuInflater {
    private static final Class<?>[] a = new Class[]{Context.class};
    private static final Class<?>[] b = a;
    private final Object[] c;
    private final Object[] d = this.c;
    private Context e;
    private Object f;

    private static class a implements OnMenuItemClickListener {
        private static final Class<?>[] a = new Class[]{MenuItem.class};
        private Object b;
        private Method c;

        public a(Object obj, String str) {
            this.b = obj;
            Class cls = obj.getClass();
            try {
                this.c = cls.getMethod(str, a);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.c.invoke(this.b, new Object[]{menuItem})).booleanValue();
                }
                this.c.invoke(this.b, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class b {
        final /* synthetic */ d a;
        private Menu b;
        private int c;
        private int d;
        private int e;
        private int f;
        private boolean g;
        private boolean h;
        private boolean i;
        private int j;
        private int k;
        private CharSequence l;
        private CharSequence m;
        private int n;
        private char o;
        private char p;
        private int q;
        private boolean r;
        private boolean s;
        private boolean t;
        private int u;
        private int v;
        private String w;
        private String x;
        private String y;
        private android.support.v4.view.d z;

        public b(d dVar, Menu menu) {
            this.a = dVar;
            this.b = menu;
            a();
        }

        public void a() {
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = true;
            this.h = true;
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = this.a.e.obtainStyledAttributes(attributeSet, k.MenuGroup);
            this.c = obtainStyledAttributes.getResourceId(k.MenuGroup_android_id, 0);
            this.d = obtainStyledAttributes.getInt(k.MenuGroup_android_menuCategory, 0);
            this.e = obtainStyledAttributes.getInt(k.MenuGroup_android_orderInCategory, 0);
            this.f = obtainStyledAttributes.getInt(k.MenuGroup_android_checkableBehavior, 0);
            this.g = obtainStyledAttributes.getBoolean(k.MenuGroup_android_visible, true);
            this.h = obtainStyledAttributes.getBoolean(k.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = this.a.e.obtainStyledAttributes(attributeSet, k.MenuItem);
            this.j = obtainStyledAttributes.getResourceId(k.MenuItem_android_id, 0);
            this.k = (obtainStyledAttributes.getInt(k.MenuItem_android_menuCategory, this.d) & -65536) | (obtainStyledAttributes.getInt(k.MenuItem_android_orderInCategory, this.e) & 65535);
            this.l = obtainStyledAttributes.getText(k.MenuItem_android_title);
            this.m = obtainStyledAttributes.getText(k.MenuItem_android_titleCondensed);
            this.n = obtainStyledAttributes.getResourceId(k.MenuItem_android_icon, 0);
            this.o = a(obtainStyledAttributes.getString(k.MenuItem_android_alphabeticShortcut));
            this.p = a(obtainStyledAttributes.getString(k.MenuItem_android_numericShortcut));
            if (obtainStyledAttributes.hasValue(k.MenuItem_android_checkable)) {
                this.q = obtainStyledAttributes.getBoolean(k.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.q = this.f;
            }
            this.r = obtainStyledAttributes.getBoolean(k.MenuItem_android_checked, false);
            this.s = obtainStyledAttributes.getBoolean(k.MenuItem_android_visible, this.g);
            this.t = obtainStyledAttributes.getBoolean(k.MenuItem_android_enabled, this.h);
            this.u = obtainStyledAttributes.getInt(k.MenuItem_showAsAction, -1);
            this.y = obtainStyledAttributes.getString(k.MenuItem_android_onClick);
            this.v = obtainStyledAttributes.getResourceId(k.MenuItem_actionLayout, 0);
            this.w = obtainStyledAttributes.getString(k.MenuItem_actionViewClass);
            this.x = obtainStyledAttributes.getString(k.MenuItem_actionProviderClass);
            if (this.x == null) {
                z = false;
            }
            if (z && this.v == 0 && this.w == null) {
                this.z = (android.support.v4.view.d) a(this.x, d.b, this.a.d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.z = null;
            }
            obtainStyledAttributes.recycle();
            this.i = false;
        }

        private char a(String str) {
            if (str == null) {
                return '\u0000';
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.r).setVisible(this.s).setEnabled(this.t).setCheckable(this.q >= 1).setTitleCondensed(this.m).setIcon(this.n).setAlphabeticShortcut(this.o).setNumericShortcut(this.p);
            if (this.u >= 0) {
                q.a(menuItem, this.u);
            }
            if (this.y != null) {
                if (this.a.e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(this.a.c(), this.y));
            }
            if (menuItem instanceof h) {
                h hVar = (h) menuItem;
            }
            if (this.q >= 2) {
                if (menuItem instanceof h) {
                    ((h) menuItem).a(true);
                } else if (menuItem instanceof i) {
                    ((i) menuItem).a(true);
                }
            }
            if (this.w != null) {
                q.a(menuItem, (View) a(this.w, d.a, this.a.c));
            } else {
                z = false;
            }
            if (this.v > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    q.b(menuItem, this.v);
                }
            }
            if (this.z != null) {
                q.a(menuItem, this.z);
            }
        }

        public void b() {
            this.i = true;
            a(this.b.add(this.c, this.j, this.k, this.l));
        }

        public SubMenu c() {
            this.i = true;
            SubMenu addSubMenu = this.b.addSubMenu(this.c, this.j, this.k, this.l);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.i;
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = this.a.e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Throwable e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }

    public d(Context context) {
        super(context);
        this.e = context;
        this.c = new Object[]{context};
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof android.support.v4.c.a.a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.e.getResources().getLayout(i);
                a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
        r10 = this;
        r4 = 0;
        r1 = 1;
        r6 = 0;
        r7 = new android.support.v7.view.d$b;
        r7.<init>(r10, r13);
        r0 = r11.getEventType();
    L_0x000c:
        r2 = 2;
        if (r0 != r2) goto L_0x004a;
    L_0x000f:
        r0 = r11.getName();
        r2 = "menu";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0031;
    L_0x001b:
        r0 = r11.next();
    L_0x001f:
        r2 = r4;
        r5 = r6;
        r3 = r0;
        r0 = r6;
    L_0x0023:
        if (r0 != 0) goto L_0x00e1;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x00d9;
            case 2: goto L_0x0051;
            case 3: goto L_0x0087;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r5;
    L_0x0029:
        r5 = r11.next();
        r9 = r3;
        r3 = r5;
        r5 = r9;
        goto L_0x0023;
    L_0x0031:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Expecting menu, got ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x004a:
        r0 = r11.next();
        if (r0 != r1) goto L_0x000c;
    L_0x0050:
        goto L_0x001f;
    L_0x0051:
        if (r5 == 0) goto L_0x0055;
    L_0x0053:
        r3 = r5;
        goto L_0x0029;
    L_0x0055:
        r3 = r11.getName();
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0066;
    L_0x0061:
        r7.a(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0066:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0073;
    L_0x006e:
        r7.b(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0073:
        r8 = "menu";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0084;
    L_0x007b:
        r3 = r7.c();
        r10.a(r11, r12, r3);
        r3 = r5;
        goto L_0x0029;
    L_0x0084:
        r2 = r3;
        r3 = r1;
        goto L_0x0029;
    L_0x0087:
        r3 = r11.getName();
        if (r5 == 0) goto L_0x0096;
    L_0x008d:
        r8 = r3.equals(r2);
        if (r8 == 0) goto L_0x0096;
    L_0x0093:
        r2 = r4;
        r3 = r6;
        goto L_0x0029;
    L_0x0096:
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00a3;
    L_0x009e:
        r7.a();
        r3 = r5;
        goto L_0x0029;
    L_0x00a3:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00cd;
    L_0x00ab:
        r3 = r7.d();
        if (r3 != 0) goto L_0x0028;
    L_0x00b1:
        r3 = r7.z;
        if (r3 == 0) goto L_0x00c7;
    L_0x00b7:
        r3 = r7.z;
        r3 = r3.e();
        if (r3 == 0) goto L_0x00c7;
    L_0x00c1:
        r7.c();
        r3 = r5;
        goto L_0x0029;
    L_0x00c7:
        r7.b();
        r3 = r5;
        goto L_0x0029;
    L_0x00cd:
        r8 = "menu";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x0028;
    L_0x00d5:
        r0 = r1;
        r3 = r5;
        goto L_0x0029;
    L_0x00d9:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x00e1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.d.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    private Object c() {
        if (this.f == null) {
            this.f = a(this.e);
        }
        return this.f;
    }

    private Object a(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }
}
