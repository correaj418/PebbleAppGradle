package com.cocosw.bottomsheet;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class a implements android.support.v4.c.a.a {
    private static final int[] a = new int[]{1, 4, 5, 3, 2, 0};
    private Context b;
    private boolean c;
    private ArrayList<b> d = new ArrayList();

    public a(Context context) {
        this.b = context;
    }

    private static int a(ArrayList<b> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((b) arrayList.get(size)).getOrder() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private static int b(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < a.length) {
            return (a[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public Context a() {
        return this.b;
    }

    public MenuItem add(CharSequence charSequence) {
        return add(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return add(0, 0, 0, i);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return add(i, i2, i3, this.b.getResources().getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        MenuItem bVar = new b(a(), i, i2, 0, i3, charSequence);
        this.d.add(a(this.d, b(i3)), bVar);
        return bVar;
    }

    MenuItem a(b bVar) {
        this.d.add(a(this.d, b(bVar.getOrder())), bVar);
        return bVar;
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.b.getPackageManager();
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

    public SubMenu addSubMenu(CharSequence charSequence) {
        return null;
    }

    public SubMenu addSubMenu(int i) {
        return null;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return null;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return null;
    }

    public void clear() {
        this.d.clear();
    }

    public void close() {
    }

    private int c(int i) {
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((b) arrayList.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public MenuItem findItem(int i) {
        int c = c(i);
        if (c < 0) {
            return null;
        }
        return (MenuItem) this.d.get(c);
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.d.get(i);
    }

    public boolean hasVisibleItems() {
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((b) arrayList.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    private b a(int i, KeyEvent keyEvent) {
        boolean z = this.c;
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) arrayList.get(i2);
            if (i == (z ? bVar.getAlphabeticShortcut() : bVar.getNumericShortcut())) {
                return bVar;
            }
        }
        return null;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        int c = c(i);
        if (c < 0) {
            return false;
        }
        return ((b) this.d.get(c)).b();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        b a = a(i, keyEvent);
        if (a == null) {
            return false;
        }
        return a.b();
    }

    public void removeGroup(int i) {
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            if (((b) arrayList.get(i2)).getGroupId() == i) {
                arrayList.remove(i2);
                size--;
            } else {
                i2++;
            }
        }
    }

    public void removeItem(int i) {
        int c = c(i);
        if (c >= 0) {
            this.d.remove(c);
        }
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) arrayList.get(i2);
            if (bVar.getGroupId() == i) {
                bVar.setCheckable(z);
                bVar.a(z2);
            }
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) arrayList.get(i2);
            if (bVar.getGroupId() == i) {
                bVar.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) arrayList.get(i2);
            if (bVar.getGroupId() == i) {
                bVar.setVisible(z);
            }
        }
    }

    public void setQwertyMode(boolean z) {
        this.c = z;
    }

    public int size() {
        return this.d.size();
    }

    a a(int i) {
        a aVar = new a(a());
        aVar.d = new ArrayList(this.d.subList(0, i));
        return aVar;
    }

    void b() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            if (!((b) it.next()).isVisible()) {
                it.remove();
            }
        }
    }
}
