package com.getpebble.android.framework.n;

import android.content.ContentResolver;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.az;
import com.getpebble.android.common.model.o;

public class b implements com.getpebble.android.main.sections.mypebble.a.j.b {
    private final a a;
    private boolean b;
    private final ContentResolver c;

    public static class a {
        private long a = o.a();

        public boolean a(com.getpebble.android.common.model.o.a aVar) {
            return aVar.a == this.a;
        }

        public void b(com.getpebble.android.common.model.o.a aVar) {
            o.a(aVar);
            this.a = aVar.a;
        }

        public boolean a() {
            return this.a != -1;
        }
    }

    public b(ContentResolver contentResolver, a aVar) {
        this.c = contentResolver;
        this.a = aVar;
        a aVar2 = (a) az.a("remindersApp", contentResolver);
        if (aVar2 == null) {
            this.b = false;
        } else {
            this.b = aVar2.a != com.getpebble.android.framework.n.a.a.DISABLED;
        }
    }

    public synchronized boolean a(com.getpebble.android.common.model.o.a aVar) {
        return this.a.a(aVar);
    }

    public synchronized void b(com.getpebble.android.common.model.o.a aVar) {
        this.a.b(aVar);
        a();
    }

    private com.getpebble.android.framework.n.a.a a() {
        com.getpebble.android.framework.n.a.a aVar = this.b ? this.a.a() ? com.getpebble.android.framework.n.a.a.ENABLED_CONFIGURED : com.getpebble.android.framework.n.a.a.ENABLED_NOT_CONFIGURED : com.getpebble.android.framework.n.a.a.DISABLED;
        az.a(new a(aVar), this.c);
        f.d("RemindersConfigurationManager", "New reminders app state: " + aVar.name());
        return aVar;
    }
}
