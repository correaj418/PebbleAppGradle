package com.getpebble.jskit.android.impl.runtime;

import com.getpebble.jskit.android.a.b;
import com.getpebble.jskit.android.impl.c;
import com.getpebble.jskit.android.impl.runtime.model.JsApplicationInfo;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class a extends c implements b {
    private final Map<String, com.getpebble.jskit.android.impl.runtime.a.a> a = new ConcurrentHashMap();
    private final com.getpebble.jskit.android.impl.b b;

    public a(com.getpebble.jskit.android.impl.b bVar) {
        this.b = bVar;
    }

    protected void b() {
        com.getpebble.jskit.android.a.a.a(3, null, "JsRuntimeManager", "onStart:");
    }

    public boolean a(JsApplicationInfo jsApplicationInfo, boolean z) {
        com.getpebble.jskit.android.a.a.a(4, null, "JsRuntimeManager", "runScript: needToShowConfiguration = ", Boolean.valueOf(z), ", script module running : ", jsApplicationInfo.toString());
        if (c(jsApplicationInfo.a())) {
            com.getpebble.jskit.android.a.a.a(2, null, "JsRuntimeManager", "runScript: object already running, maybe need to show configuration ? ", Boolean.valueOf(z));
            if (z) {
                ((com.getpebble.jskit.android.impl.runtime.a.a) this.a.get(jsApplicationInfo.a())).h("{}");
            }
            return false;
        }
        com.getpebble.jskit.android.impl.runtime.a.a a = com.getpebble.jskit.android.impl.runtime.a.b.a(this.b, jsApplicationInfo, z);
        this.a.put(jsApplicationInfo.a(), a);
        com.getpebble.jskit.android.a.a.a(3, null, "JsRuntimeManager", "runScript: jsApplicationInfo = ", jsApplicationInfo, " jsRunner = ", a);
        a.d();
        return true;
    }

    public boolean a(String str) {
        if (c(str)) {
            com.getpebble.jskit.android.a.a.a(3, null, "JsRuntimeManager", "stopScript: appUuidString = ", str);
            if (!((com.getpebble.jskit.android.impl.runtime.a.a) this.a.remove(str)).e()) {
                com.getpebble.jskit.android.a.a.a(7, null, "JsRuntimeManager", "error stopping script! " + ((com.getpebble.jskit.android.impl.runtime.a.a) this.a.remove(str)).b());
            }
            return true;
        }
        com.getpebble.jskit.android.a.a.a(5, null, "JsRuntimeManager", "stopScript: object not found : appUuidString = ", str);
        return false;
    }

    public void c() {
        com.getpebble.jskit.android.a.a.a(2, null, "JsRuntimeManager", "stopAllScripts:");
        Object[] toArray = this.a.values().toArray();
        if (toArray.length > 0) {
            this.a.values().removeAll(Arrays.asList(toArray));
            for (Object obj : toArray) {
                if (!((com.getpebble.jskit.android.impl.runtime.a.a) obj).e()) {
                    com.getpebble.jskit.android.a.a.a(7, null, "JsRuntimeManager", "error stopping script! " + ((com.getpebble.jskit.android.impl.runtime.a.a) obj).b());
                }
            }
        }
        com.getpebble.jskit.android.a.a.a(2, null, "JsRuntimeManager", "stopAllScripts: jsRunners = ", Integer.valueOf(toArray.length), ", mAppUuidRunnerMap = ", Integer.valueOf(this.a.values().size()));
    }

    public void a(UUID uuid) {
        com.getpebble.jskit.android.a.a.a(2, null, "JsRuntimeManager", "stopAndClearLocalStorage: appUUID = " + uuid);
        a(uuid.toString());
        this.b.g().c().b(uuid.toString());
    }

    public boolean a(String str, String str2) {
        if (c(str)) {
            return ((com.getpebble.jskit.android.impl.runtime.a.a) this.a.get(str)).b(str2);
        }
        com.getpebble.jskit.android.a.a.a(3, null, "JsRuntimeManager", "signalNewAppMessageData: object not found : appUuidString = ", str);
        return false;
    }

    public boolean b(String str, String str2) {
        com.getpebble.jskit.android.impl.runtime.a.a b = b(str);
        if (b != null) {
            return b.c(str2);
        }
        com.getpebble.jskit.android.a.a.a(5, null, "JsRuntimeManager", "signalAppMessageAck: object not found : appUuidString = ", str);
        return false;
    }

    public boolean c(String str, String str2) {
        com.getpebble.jskit.android.impl.runtime.a.a b = b(str);
        if (b != null) {
            return b.d(str2);
        }
        com.getpebble.jskit.android.a.a.a(5, null, "JsRuntimeManager", "signalAppMessageNack: object not found : appUuidString = ", str);
        return false;
    }

    public boolean d(String str, String str2) {
        com.getpebble.jskit.android.impl.runtime.a.a b = b(str);
        if (b != null) {
            return b.e(str2);
        }
        com.getpebble.jskit.android.a.a.a(5, null, "JsRuntimeManager", "signalAppMessageNack: object not found : appUuidString = ", str);
        return false;
    }

    public boolean e(String str, String str2) {
        com.getpebble.jskit.android.impl.runtime.a.a b = b(str);
        if (b != null) {
            return b.f(str2);
        }
        com.getpebble.jskit.android.a.a.a(5, null, "JsRuntimeManager", "signalTimelineTokenSuccess: object not found : appUuidString = ", str);
        return false;
    }

    public boolean f(String str, String str2) {
        com.getpebble.jskit.android.impl.runtime.a.a b = b(str);
        if (b != null) {
            return b.g(str2);
        }
        com.getpebble.jskit.android.a.a.a(5, null, "JsRuntimeManager", "signalTimelineTokenFailure: object not found : appUuidString = ", str);
        return false;
    }

    public com.getpebble.jskit.android.impl.runtime.a.a b(String str) {
        if (c(str)) {
            return (com.getpebble.jskit.android.impl.runtime.a.a) this.a.get(str);
        }
        return null;
    }

    public void a(com.getpebble.jskit.android.a aVar, com.getpebble.jskit.android.a.a aVar2) {
        com.getpebble.jskit.android.a.a.a(4, null, "JsRuntimeManager", "Threshold met for " + aVar2 + " from " + aVar.a());
    }

    private boolean c(String str) {
        return this.a.containsKey(str);
    }

    public void d() {
        com.getpebble.jskit.android.a.a.a(3, null, "JsRuntimeManager", "Dump active runners. Size = " + this.a.size() + ":");
        for (com.getpebble.jskit.android.impl.runtime.a.a aVar : this.a.values()) {
            com.getpebble.jskit.android.a.a.a(3, null, "JsRuntimeManager", "> active runner: " + aVar.b());
        }
    }
}
