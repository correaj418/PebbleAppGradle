package com.getpebble.android.f;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.g.k;
import com.getpebble.android.notifications.b.c;
import com.getpebble.android.notifications.b.c.a;
import com.getpebble.android.notifications.b.c.d;

public class b {
    private static d a = new d();

    private static boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (c.a(a.f, dVar.f)) {
            f.d("MusicPlaystateProcessor", "Received new playstate from " + dVar.f + " but waiting for new metadata from " + a.f.toString() + "...");
            return false;
        } else if (dVar.a(a)) {
            a aVar = a.f;
            a aVar2 = dVar.f;
            if (c.a(aVar, aVar2) || aVar == aVar2) {
                f.d("MusicPlaystateProcessor", "Received duplicate music playstate: " + dVar.toString());
                return false;
            }
            f.d("MusicPlaystateProcessor", "Received duplicate playstate from more reliable source: " + aVar2.toString() + ". [current source = " + aVar.toString() + "]");
            return true;
        } else {
            f.d("MusicPlaystateProcessor", "Received new playstate info: " + dVar.toString());
            return true;
        }
    }

    public static d a() {
        return a;
    }

    public static void a(d dVar, String str) {
        a(dVar, str, false);
    }

    public static void a(d dVar, String str, boolean z) {
        if (dVar == null) {
            f.b("MusicPlaystateProcessor", "Failed to update music playstate -- new music info was null");
        } else if (z || a(dVar)) {
            a = dVar;
            f.d("MusicPlaystateProcessor", "*** Current Music Playstate: " + a.toString());
            b();
        }
    }

    private static void b() {
        f.d("MusicPlaystateProcessor", "Sending new music playstate to watch...");
        k kVar = new k(com.getpebble.android.bluetooth.g.a.MUSIC_CONTROL, k.a.UPDATE_MUSIC_PLAYSTATE);
        for (com.getpebble.android.framework.b.a a : com.getpebble.android.framework.b.a.b()) {
            a.a(kVar, null);
        }
    }
}
