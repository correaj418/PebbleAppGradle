package com.getpebble.android.f;

import android.text.TextUtils;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.g.k;
import com.getpebble.android.notifications.b.c;
import com.getpebble.android.notifications.b.c.b;

public class a {
    private static b a = new b();

    private static boolean b(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (c.a(a.h, bVar.h) && a.g.equals(bVar.g) && !TextUtils.isEmpty(bVar.g)) {
            f.d("MusicMetadataProcessor", "Received new metadata from " + bVar.h + " but waiting for new metadata from " + a.h.toString() + "...");
            return false;
        } else if (a.a(bVar)) {
            com.getpebble.android.notifications.b.c.a aVar = a.h;
            com.getpebble.android.notifications.b.c.a aVar2 = bVar.h;
            if (c.a(aVar, aVar2) || aVar == aVar2) {
                f.d("MusicMetadataProcessor", "Received duplicate music metadata: " + bVar.toString());
                return false;
            }
            f.d("MusicMetadataProcessor", "Received duplicate metadata from more reliable source: " + aVar2.toString() + ". [current source = " + aVar.toString() + "]");
            return true;
        } else {
            f.d("MusicMetadataProcessor", "Received new music info: " + bVar.toString());
            return true;
        }
    }

    public static b a() {
        return a;
    }

    public static void a(b bVar) {
        f.d("MusicMetadataProcessor", "Got request to update media metadata from " + bVar.h.toString());
        if (bVar == null) {
            f.d("MusicMetadataProcessor", "Failed to update music info -- new music info was null");
        } else if (b(bVar)) {
            a = bVar;
            f.d("MusicMetadataProcessor", "*** Current Music Metadata: " + a.toString());
            b();
        }
    }

    private static void b() {
        f.d("MusicMetadataProcessor", "Sending new music metadata to watch...");
        k kVar = new k(com.getpebble.android.bluetooth.g.a.MUSIC_CONTROL, com.getpebble.android.framework.g.k.a.UPDATE_MUSIC_NOW_PLAYING);
        for (com.getpebble.android.framework.b.a a : com.getpebble.android.framework.b.a.b()) {
            a.a(kVar, null);
        }
    }
}
