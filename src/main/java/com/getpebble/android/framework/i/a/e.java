package com.getpebble.android.framework.i.a;

import com.getpebble.android.notifications.a.a;
import com.getpebble.android.notifications.a.a.d;
import com.getpebble.android.notifications.a.b;
import java.util.ArrayList;
import java.util.List;

public class e {
    private b a;
    private List<a.b> b = new ArrayList();
    private d c;

    public e(b bVar) {
        this.a = bVar;
        this.c = a(bVar);
        this.b = b(bVar);
    }

    public d a() {
        return this.c;
    }

    public List<a.b> b() {
        return this.b;
    }

    private d a(b bVar) {
        List<a.b> x = bVar.x();
        if (x != null) {
            for (a.b bVar2 : x) {
                if (bVar2 instanceof d) {
                    return (d) bVar2;
                }
            }
        }
        return null;
    }

    private List<a.b> b(b bVar) {
        List<a.b> arrayList = new ArrayList();
        for (a.b bVar2 : bVar.x()) {
            if (bVar2 instanceof d) {
                arrayList.remove(bVar2);
            }
        }
        return arrayList;
    }

    public b c() {
        return this.a;
    }
}
