package com.getpebble.android.framework.jskit;

import android.content.Context;
import com.getpebble.jskit.android.impl.b;
import com.getpebble.jskit.android.impl.c.a;
import com.getpebble.jskit.android.impl.c.a.c;
import com.getpebble.jskit.android.impl.c.a.e;
import com.getpebble.jskit.android.impl.c.a.f;
import com.getpebble.jskit.android.impl.runtime.model.JsApplicationInfo;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class d {
    private static final String a = d.class.getSimpleName();
    private static d b;
    private final HashSet<a> c = new HashSet();
    private final b d;
    private boolean e = false;
    private a f = new a(this) {
        final /* synthetic */ d a;

        {
            this.a = r1;
        }

        public void a(c cVar) {
            for (a a : this.a.c()) {
                a.a(cVar);
            }
        }

        public void a(com.getpebble.jskit.android.impl.c.a.b bVar) {
            for (a a : this.a.c()) {
                a.a(bVar);
            }
        }

        public void a(com.getpebble.jskit.android.impl.c.a.d dVar) {
            for (a a : this.a.c()) {
                a.a(dVar);
            }
        }

        public void a(e eVar) {
            for (a a : this.a.c()) {
                a.a(eVar);
            }
        }

        public void a(f fVar) {
            com.getpebble.android.common.b.a.f.d(d.a, "onAppMessageReceived: jsMsgAppMessage = " + fVar);
            for (a a : this.a.c()) {
                a.a(fVar);
            }
        }

        public void a(String str, String str2) {
            for (a a : this.a.c()) {
                a.a(str, str2);
            }
        }

        public void a(String str) {
            com.getpebble.android.common.b.a.f.d(d.a, "IJsListener: onCloseConfigurationScreen: applicationId = " + str);
            for (a a : this.a.c()) {
                a.a(str);
            }
        }
    };

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (b == null) {
                b = new d(new f(), new b(context));
            }
            dVar = b;
        }
        return dVar;
    }

    private d(com.getpebble.jskit.android.impl.b.a aVar, b bVar) {
        this.d = bVar;
        this.d.a(aVar);
    }

    public synchronized void a() {
        com.getpebble.android.common.b.a.f.d(a, "start:");
        if (this.e) {
            com.getpebble.android.common.b.a.f.d(a, "start: already running");
        } else {
            this.e = true;
            g();
        }
    }

    public boolean b() {
        return this.e;
    }

    public synchronized void a(a aVar) {
        this.c.add(aVar);
    }

    public synchronized void b(a aVar) {
        this.c.remove(aVar);
    }

    public synchronized a[] c() {
        return (a[]) this.c.toArray(new a[this.c.size()]);
    }

    public boolean a(JsApplicationInfo jsApplicationInfo, boolean z) {
        com.getpebble.android.common.b.a.f.d(a, "runScript: jsApplicationInfo = " + jsApplicationInfo + " needs configuration? " + z);
        return this.d.e().a(jsApplicationInfo, z);
    }

    public boolean a(String str) {
        com.getpebble.android.common.b.a.f.d(a, "stopScript: appId = " + str);
        return this.d.e().a(str);
    }

    public void d() {
        com.getpebble.android.common.b.a.f.d(a, "stopAllScripts:");
        this.d.e().c();
    }

    public void a(UUID uuid) {
        com.getpebble.android.common.b.a.f.d(a, "stopAndClearLocalStorage: appId = " + uuid);
        this.d.e().a(uuid);
    }

    public JsApplicationInfo b(UUID uuid) {
        com.getpebble.jskit.android.impl.runtime.a.a b = this.d.e().b(uuid.toString());
        return b != null ? b.b() : null;
    }

    public boolean a(String str, String str2) {
        return this.d.e().a(str, str2);
    }

    public boolean b(String str, String str2) {
        return this.d.e().b(str, str2);
    }

    public boolean c(String str, String str2) {
        com.getpebble.android.common.b.a.f.d(a, "onCloseWindowUrlLoaded: appId = " + str + " data = " + str2);
        return this.d.e().d(str, str2);
    }

    public boolean d(String str, String str2) {
        return this.d.e().e(str, str2);
    }

    public boolean e(String str, String str2) {
        com.getpebble.android.common.b.a.f.d(a, "signalTimelineTokenFailure: appId = " + str + " data = " + str2);
        return this.d.e().f(str, str2);
    }

    public void b(String str) {
        this.d.f().a(str);
    }

    public void c(String str) {
        this.d.f().b(str);
    }

    public boolean f(String str, String str2) {
        return this.d.e().c(str, str2);
    }

    public void a(String str, Set<Entry<String, String>> set) {
        com.getpebble.android.common.b.a.f.d(a, "writeAllToLocalStorage: appId = " + str + " data = " + set);
        this.d.g().c().a(str, (Set) set);
    }

    private void g() {
        this.d.d().a(this.f);
    }

    public void e() {
        this.d.e().d();
    }
}
