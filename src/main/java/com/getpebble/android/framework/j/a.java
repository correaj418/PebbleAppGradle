package com.getpebble.android.framework.j;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.g.k;

public class a extends ContentObserver {
    private static int a = -1;

    public a(Handler handler) {
        super(handler);
    }

    public void onChange(boolean z) {
        super.onChange(z);
        int b = b();
        if (a != b) {
            f.d("VolumeObserver", "New Volume Level: " + b + "%.");
            a = b;
            c();
        }
    }

    private static int b() {
        AudioManager audioManager = (AudioManager) com.getpebble.android.common.a.K().getSystemService("audio");
        return Math.round((float) ((audioManager.getStreamVolume(3) * 100) / audioManager.getStreamMaxVolume(3)));
    }

    public static int a() {
        if (a == -1) {
            a = b();
        }
        return a;
    }

    private static void c() {
        f.d("VolumeObserver", "Sending new music volume data to watch...");
        k kVar = new k(com.getpebble.android.bluetooth.g.a.MUSIC_CONTROL, com.getpebble.android.framework.g.k.a.UPDATE_MUSIC_VOLUME_LEVEL);
        for (com.getpebble.android.framework.b.a a : com.getpebble.android.framework.b.a.b()) {
            a.a(kVar, null);
        }
    }
}
