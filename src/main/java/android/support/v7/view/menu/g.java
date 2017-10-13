package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.d;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class g implements android.support.v4.c.a.a {
    private static final int[] d = new int[]{1, 4, 5, 3, 2, 0};
    CharSequence a;
    Drawable b;
    View c;
    private final Context e;
    private final Resources f;
    private boolean g;
    private boolean h;
    private a i;
    private ArrayList<h> j;
    private ArrayList<h> k;
    private boolean l;
    private ArrayList<h> m;
    private ArrayList<h> n;
    private boolean o;
    private int p = 0;
    private ContextMenuInfo q;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private ArrayList<h> v = new ArrayList();
    private CopyOnWriteArrayList<WeakReference<m>> w = new CopyOnWriteArrayList();
    private h x;
    private boolean y;

    public interface b {
        boolean a(h hVar);
    }

    public interface a {
        void a(g gVar);

        boolean a(g gVar, MenuItem menuItem);
    }

    public g(Context context) {
        this.e = context;
        this.f = context.getResources();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = true;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = true;
        d(true);
    }

    public void a(m mVar, Context context) {
        this.w.add(new WeakReference(mVar));
        mVar.a(context, this);
        this.o = true;
    }

    public void a(m mVar) {
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            m mVar2 = (m) weakReference.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.w.remove(weakReference);
            }
        }
    }

    private void c(boolean z) {
        if (!this.w.isEmpty()) {
            f();
            Iterator it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                m mVar = (m) weakReference.get();
                if (mVar == null) {
                    this.w.remove(weakReference);
                } else {
                    mVar.b(z);
                }
            }
            g();
        }
    }

    private boolean a(s sVar, m mVar) {
        boolean z = false;
        if (this.w.isEmpty()) {
            return false;
        }
        if (mVar != null) {
            z = mVar.a(sVar);
        }
        Iterator it = this.w.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            m mVar2 = (m) weakReference.get();
            if (mVar2 == null) {
                this.w.remove(weakReference);
                z = z2;
            } else if (z2) {
                z = z2;
            } else {
                z = mVar2.a(sVar);
            }
            z2 = z;
        }
        return z2;
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int e = e(i3);
        MenuItem a = a(i, i2, i3, e, charSequence, this.p);
        if (this.q != null) {
            a.a(this.q);
        }
        this.j.add(a(this.j, e), a);
        b(true);
        return a;
    }

    private h a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new h(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return a(0, 0, 0, this.f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.f.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        h hVar = (h) a(i, i2, i3, charSequence);
        s sVar = new s(this.e, this, hVar);
        hVar.a(sVar);
        return sVar;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        a(a(i), true);
    }

    public void removeGroup(int i) {
        int b = b(i);
        if (b >= 0) {
            int size = this.j.size() - b;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((h) this.j.get(b)).getGroupId() != i) {
                    b(true);
                } else {
                    a(b, false);
                    i2 = i3;
                }
            }
            b(true);
        }
    }

    private void a(int i, boolean z) {
        if (i >= 0 && i < this.j.size()) {
            this.j.remove(i);
            if (z) {
                b(true);
            }
        }
    }

    public void clear() {
        if (this.x != null) {
            d(this.x);
        }
        this.j.clear();
        b(true);
    }

    void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (h) this.j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.g() && menuItem2.isCheckable()) {
                menuItem2.b(menuItem2 == menuItem);
            }
        }
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.j.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.a(z2);
                hVar.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            h hVar = (h) this.j.get(i2);
            if (hVar.getGroupId() == i && hVar.c(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            b(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.j.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((h) this.j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.j.get(i2);
            if (hVar.getItemId() == i) {
                return hVar;
            }
            if (hVar.hasSubMenu()) {
                MenuItem findItem = hVar.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int a(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((h) this.j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int b(int i) {
        return a(i, 0);
    }

    public int a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((h) this.j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public int size() {
        return this.j.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.j.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.g = z;
        b(false);
    }

    private static int e(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < d.length) {
            return (d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    boolean a() {
        return this.g;
    }

    private void d(boolean z) {
        boolean z2 = true;
        if (!(z && this.f.getConfiguration().keyboard != 1 && this.f.getBoolean(android.support.v7.b.a.b.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.h = z2;
    }

    public boolean b() {
        return this.h;
    }

    Resources c() {
        return this.f;
    }

    public Context d() {
        return this.e;
    }

    boolean a(g gVar, MenuItem menuItem) {
        return this.i != null && this.i.a(gVar, menuItem);
    }

    public void e() {
        if (this.i != null) {
            this.i.a(this);
        }
    }

    private static int a(ArrayList<h> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((h) arrayList.get(size)).c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = a(a, i2);
        }
        if ((i2 & 2) != 0) {
            a(true);
        }
        return z;
    }

    void a(List<h> list, int i, KeyEvent keyEvent) {
        boolean a = a();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.j.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = (h) this.j.get(i2);
                if (hVar.hasSubMenu()) {
                    ((g) hVar.getSubMenu()).a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = a ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (a && alphabeticShortcut == '\b' && i == 67)) && hVar.isEnabled())) {
                    list.add(hVar);
                }
            }
        }
    }

    h a(int i, KeyEvent keyEvent) {
        List list = this.v;
        list.clear();
        a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (h) list.get(0);
        }
        boolean a = a();
        for (int i2 = 0; i2 < size; i2++) {
            char alphabeticShortcut;
            h hVar = (h) list.get(i2);
            if (a) {
                alphabeticShortcut = hVar.getAlphabeticShortcut();
            } else {
                alphabeticShortcut = hVar.getNumericShortcut();
            }
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return hVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return hVar;
            }
            if (a && alphabeticShortcut == '\b' && i == 67) {
                return hVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), i2);
    }

    public boolean a(MenuItem menuItem, int i) {
        return a(menuItem, null, i);
    }

    public boolean a(MenuItem menuItem, m mVar, int i) {
        h hVar = (h) menuItem;
        if (hVar == null || !hVar.isEnabled()) {
            return false;
        }
        boolean z;
        boolean b = hVar.b();
        d a = hVar.a();
        if (a == null || !a.e()) {
            z = false;
        } else {
            z = true;
        }
        boolean expandActionView;
        if (hVar.n()) {
            expandActionView = hVar.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            a(true);
            return expandActionView;
        } else if (hVar.hasSubMenu() || z) {
            if (!hVar.hasSubMenu()) {
                hVar.a(new s(d(), this, hVar));
            }
            s sVar = (s) hVar.getSubMenu();
            if (z) {
                a.a((SubMenu) sVar);
            }
            expandActionView = a(sVar, mVar) | b;
            if (expandActionView) {
                return expandActionView;
            }
            a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                a(true);
            }
            return b;
        }
    }

    public final void a(boolean z) {
        if (!this.u) {
            this.u = true;
            Iterator it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                m mVar = (m) weakReference.get();
                if (mVar == null) {
                    this.w.remove(weakReference);
                } else {
                    mVar.a(this, z);
                }
            }
            this.u = false;
        }
    }

    public void close() {
        a(true);
    }

    public void b(boolean z) {
        if (this.r) {
            this.s = true;
            return;
        }
        if (z) {
            this.l = true;
            this.o = true;
        }
        c(z);
    }

    public void f() {
        if (!this.r) {
            this.r = true;
            this.s = false;
        }
    }

    public void g() {
        this.r = false;
        if (this.s) {
            this.s = false;
            b(true);
        }
    }

    void a(h hVar) {
        this.l = true;
        b(true);
    }

    void b(h hVar) {
        this.o = true;
        b(true);
    }

    public ArrayList<h> h() {
        if (!this.l) {
            return this.k;
        }
        this.k.clear();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) this.j.get(i);
            if (hVar.isVisible()) {
                this.k.add(hVar);
            }
        }
        this.l = false;
        this.o = true;
        return this.k;
    }

    public void i() {
        ArrayList h = h();
        if (this.o) {
            Iterator it = this.w.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                WeakReference weakReference = (WeakReference) it.next();
                m mVar = (m) weakReference.get();
                if (mVar == null) {
                    this.w.remove(weakReference);
                    i2 = i;
                } else {
                    i2 = mVar.b() | i;
                }
                i = i2;
            }
            if (i != 0) {
                this.m.clear();
                this.n.clear();
                i = h.size();
                for (int i3 = 0; i3 < i; i3++) {
                    h hVar = (h) h.get(i3);
                    if (hVar.j()) {
                        this.m.add(hVar);
                    } else {
                        this.n.add(hVar);
                    }
                }
            } else {
                this.m.clear();
                this.n.clear();
                this.n.addAll(h());
            }
            this.o = false;
        }
    }

    public ArrayList<h> j() {
        i();
        return this.m;
    }

    public ArrayList<h> k() {
        i();
        return this.n;
    }

    public void clearHeader() {
        this.b = null;
        this.a = null;
        this.c = null;
        b(false);
    }

    private void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources c = c();
        if (view != null) {
            this.c = view;
            this.a = null;
            this.b = null;
        } else {
            if (i > 0) {
                this.a = c.getText(i);
            } else if (charSequence != null) {
                this.a = charSequence;
            }
            if (i2 > 0) {
                this.b = android.support.v4.content.a.a(d(), i2);
            } else if (drawable != null) {
                this.b = drawable;
            }
            this.c = null;
        }
        b(false);
    }

    protected g a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    protected g c(int i) {
        a(i, null, 0, null, null);
        return this;
    }

    protected g a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    protected g d(int i) {
        a(0, null, i, null, null);
        return this;
    }

    protected g a(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    public CharSequence l() {
        return this.a;
    }

    public g m() {
        return this;
    }

    boolean n() {
        return this.t;
    }

    public boolean c(h hVar) {
        boolean z = false;
        if (!this.w.isEmpty()) {
            f();
            Iterator it = this.w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                m mVar = (m) weakReference.get();
                if (mVar == null) {
                    this.w.remove(weakReference);
                    z = z2;
                } else {
                    z = mVar.a(this, hVar);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            g();
            if (z) {
                this.x = hVar;
            }
        }
        return z;
    }

    public boolean d(h hVar) {
        boolean z = false;
        if (!this.w.isEmpty() && this.x == hVar) {
            f();
            Iterator it = this.w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                m mVar = (m) weakReference.get();
                if (mVar == null) {
                    this.w.remove(weakReference);
                    z = z2;
                } else {
                    z = mVar.b(this, hVar);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            g();
            if (z) {
                this.x = null;
            }
        }
        return z;
    }

    public h o() {
        return this.x;
    }
}
