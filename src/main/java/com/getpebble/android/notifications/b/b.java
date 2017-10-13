package com.getpebble.android.notifications.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.getpebble.android.common.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.af;
import com.google.a.b.am;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class b {
    public static final String[] a = new String[]{"com.google.android.gm", "com.android.email", "com.sec.android.email", "com.htc.android.mail", "com.lge.email", "com.Motorola.motoemail", "com.motorola.blur.email"};
    static final String[] b = new String[]{"com.google.android.googlequicksearchbox", "de.itgecko.sharedownloader", "com.android.vending", "com.android.settings", "com.google.android.gms", "com.google.android.music", "com.android.chrome", "com.htc.vowifi", "com.android.providers.downloads", "org.mozilla.firefox", "com.htc.album", "com.dropbox.android", "com.lookout", "com.lastpass.lpandroid"};
    public static final ArrayList<String> c = new ArrayList(Arrays.asList(new String[]{"com.ad60.songza", "com.beatsmusic.android.client", "com.spotify.music", "com.pandora.android", "tunein.player", "com.slacker.radio", "com.clearchannel.iheartradio.controller", "com.jrtstudio.AnotherMusicPlayer"}));
    public static final ArrayList<String> d = new ArrayList(Arrays.asList(new String[]{"com.google.android.apps.magazines", "com.netflix.mediaclient", "com.amazon.kindle", "net.flixster.android", "air.com.vudu.air.DownloaderTablet", "com.espn.score_center", "org.coursera.android", "com.nbaimd.gametime.nba2011", "com.koushikdutta.cast", "ca.rebootsramblings.musicboss", "com.bbm"}));
    public static final Set<String> e = am.b("se.jays.headsetcontrol");
    private static final ArrayList<String> f = new ArrayList(Arrays.asList(new String[]{"com.google.android.gm"}));
    private static final ArrayList<String> g = new ArrayList(Arrays.asList(new String[]{"com.google.android.dialer"}));
    private static final ArrayList<String> h = new ArrayList(Arrays.asList(new String[]{"com.google.android.calendar", "com.google.calendar", "com.anydo.cal", "com.android.calendar"}));

    public static boolean a() {
        return af.a();
    }

    private static boolean b() {
        return true;
    }

    public static void a(Context context) {
        if (context == null) {
            f.b("CoreNotifications", "Dropping request to disable notifications for native apps due to null context.");
            return;
        }
        Iterator it;
        if (a() && a(context, g)) {
            f.d("CoreNotifications", "phone native notifications enabled; disabling phone packages");
            it = g.iterator();
            while (it.hasNext()) {
                af.a((String) it.next(), false, a.K().getContentResolver());
            }
        }
        if (b() && a(context, h)) {
            f.d("CoreNotifications", "calendar native notifications enabled; disabling calendar packages");
            it = h.iterator();
            while (it.hasNext()) {
                af.a((String) it.next(), false, a.K().getContentResolver());
            }
        }
    }

    public static void b(Context context) {
        if (context == null) {
            f.b("CoreNotifications", "Dropping request to disallow notifications for native apps due to null context.");
            return;
        }
        boolean a = a();
        Iterator it = g.iterator();
        while (it.hasNext()) {
            af.b((String) it.next(), !a, a.K().getContentResolver());
        }
        a = b();
        it = h.iterator();
        while (it.hasNext()) {
            af.b((String) it.next(), !a, a.K().getContentResolver());
        }
    }

    private static boolean a(Context context, ArrayList<String> arrayList) {
        if (context == null) {
            f.a("CoreNotifications", "getPrefsForList: Context was null!");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.getpebble.android.common.model.af.b a = af.a((String) it.next(), a.K().getContentResolver());
            if (a != null && a.d) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, Context context) {
        if (str == null) {
            f.b("CoreNotifications", "packageName is null");
            return false;
        } else if (g.contains(str)) {
            if (a()) {
                return false;
            }
            return true;
        } else if (h.contains(str) && b()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || !a(str, a.K())) {
            return false;
        }
        for (CharSequence contains : b) {
            if (str.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public static HashSet<String> a(PackageManager packageManager) {
        HashSet<String> hashSet = new HashSet();
        hashSet.add("com.android.mms");
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(new Intent("android.provider.Telephony.SMS_DELIVER"), 0)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null && "android.permission.BROADCAST_SMS".equals(activityInfo.permission)) {
                hashSet.add(activityInfo.packageName);
            }
        }
        return hashSet;
    }
}
