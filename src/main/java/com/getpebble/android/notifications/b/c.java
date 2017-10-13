package com.getpebble.android.notifications.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.g.k;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class c {

    public enum a {
        BROADCAST_RECEIVER,
        NOTIFICATION_PARSE,
        MEDIACONTROLLER,
        UNKNOWN
    }

    public static class b {
        public String a = "";
        public String b = "";
        public String c = "";
        public long d = 0;
        public int e = 0;
        public int f = 0;
        public String g = "";
        public a h = a.UNKNOWN;

        public String toString() {
            return "Artist: " + this.a + ", Album: " + this.b + ", Track: " + this.c + ", Source: " + this.h.toString() + ", Length: " + c.b(this.d) + ", Package: " + this.g;
        }

        public boolean a(b bVar) {
            if (this == bVar) {
                return true;
            }
            if (com.getpebble.android.common.b.b.a.a(this.a, bVar.a) && com.getpebble.android.common.b.b.a.a(this.b, bVar.b) && com.getpebble.android.common.b.b.a.a(this.c, bVar.c)) {
                return true;
            }
            return false;
        }
    }

    public enum c {
        PAUSED((byte) 0),
        PLAYING((byte) 1),
        REWINDING((byte) 2),
        FORWARDING((byte) 3),
        UNKNOWN((byte) 4);
        
        private byte mState;

        private c(byte b) {
            this.mState = b;
        }

        public byte getState() {
            return this.mState;
        }

        public static c fromByte(byte b) {
            for (c cVar : values()) {
                if (cVar.mState == b) {
                    return cVar;
                }
            }
            return UNKNOWN;
        }
    }

    public static class d {
        public c a = c.UNKNOWN;
        public long b = 0;
        public int c = 100;
        public com.getpebble.android.framework.l.b.u.b d = com.getpebble.android.framework.l.b.u.b.UNKNOWN;
        public com.getpebble.android.framework.l.b.u.a e = com.getpebble.android.framework.l.b.u.a.UNKNOWN;
        public a f = a.UNKNOWN;
        public long g;

        public String toString() {
            return "PlayState: " + this.a.toString() + ", Track Position: " + c.b(this.b) + ", Play Rate: " + this.c + ", Source: " + this.f.toString();
        }

        public boolean a(d dVar) {
            if (this == dVar) {
                return true;
            }
            long j = this.g - dVar.g;
            if (Math.abs((((j * ((long) dVar.c)) / 100) + dVar.b) - this.b) > 2000) {
                return false;
            }
            if (com.getpebble.android.common.b.b.a.a(this.a, dVar.a) && com.getpebble.android.common.b.b.a.a(Integer.valueOf(this.c), Integer.valueOf(dVar.c)) && com.getpebble.android.common.b.b.a.a(this.d, dVar.d) && com.getpebble.android.common.b.b.a.a(this.e, dVar.e)) {
                return true;
            }
            return false;
        }
    }

    public static boolean a(String str) {
        try {
            List<ResolveInfo> a = a(com.getpebble.android.common.a.K().getPackageManager());
            if (TextUtils.isEmpty(str) || b.d.contains(str)) {
                return false;
            }
            for (ResolveInfo resolveInfo : a) {
                if (str.equals(resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            f.b("MusicUtil", "isMusicApp", e);
            return false;
        }
    }

    public static boolean b(String str) {
        return str != null && b.c.contains(str);
    }

    public static List<ResolveInfo> a(PackageManager packageManager) {
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(new Intent("android.intent.action.MEDIA_BUTTON"), 64);
        Iterator it = queryBroadcastReceivers.iterator();
        while (it.hasNext()) {
            if (b.d.contains(((ResolveInfo) it.next()).activityInfo.packageName)) {
                it.remove();
            }
        }
        return queryBroadcastReceivers;
    }

    public static ResolveInfo a(Context context, com.getpebble.android.common.b.b.c cVar) {
        String a = cVar.a(com.getpebble.android.common.b.b.c.a.MUSIC_TARGET_PKG, "com.google.android.music");
        try {
            List<ResolveInfo> a2 = a(context.getPackageManager());
            if (a2.isEmpty()) {
                f.b("MusicUtil", "getPreferredMusicPlayer: No media receivers found");
                return null;
            } else if (a.isEmpty()) {
                f.b("MusicUtil", "getPreferredMusicPlayer: Unknown music target, using fallback");
                return (ResolveInfo) a2.get(0);
            } else {
                for (ResolveInfo resolveInfo : a2) {
                    if (resolveInfo.activityInfo.packageName.equals(a)) {
                        return resolveInfo;
                    }
                }
                f.a("MusicUtil", "Failed to find package: " + a + "; using " + ((ResolveInfo) a2.get(0)).activityInfo.packageName + " fallback");
                return (ResolveInfo) a2.get(0);
            }
        } catch (Throwable e) {
            f.b("MusicUtil", "getPreferredMusicPlayer", e);
            return null;
        }
    }

    public static boolean c(String str) {
        return com.getpebble.android.common.b.b.a.a(str, a());
    }

    public static String a() {
        return PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.MUSIC_TARGET_PKG, "com.google.android.music");
    }

    public static void d(String str) {
        String a = PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.MUSIC_TARGET_PKG, null);
        if (str != null && a(str) && !str.equals(a)) {
            a = g.a(str);
            f.d("MusicUtil", "Updating Current Music Application to " + str + " (" + a + ").");
            PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.MUSIC_TARGET_PKG, str);
            PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.MUSIC_TARGET_NAME, a);
            b();
        }
    }

    private static void b() {
        f.d("MusicUtil", "Sending new music player data to watch...");
        k kVar = new k(com.getpebble.android.bluetooth.g.a.MUSIC_CONTROL, com.getpebble.android.framework.g.k.a.UPDATE_MUSIC_PLAYER_INFO);
        for (com.getpebble.android.framework.b.a a : com.getpebble.android.framework.b.a.b()) {
            a.a(kVar, null);
        }
    }

    private static String b(long j) {
        if (j < 0) {
            return "Unknown";
        }
        long j2 = (j / 1000) % 60;
        long j3 = (j / 60000) % 60;
        long j4 = (j / 3600000) % 24;
        return String.format(Locale.US, "%02d:%02d:%02d", new Object[]{Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)});
    }

    public static boolean a(a aVar, a aVar2) {
        if (aVar == aVar2) {
            return false;
        }
        if (aVar.equals(a.MEDIACONTROLLER)) {
            return true;
        }
        if (aVar.equals(a.BROADCAST_RECEIVER)) {
            return aVar2.equals(a.NOTIFICATION_PARSE);
        }
        return false;
    }
}
