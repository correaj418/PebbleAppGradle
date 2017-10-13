package com.getpebble.android.notifications.a;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.ac;
import android.support.v4.app.ac.t;
import android.support.v4.app.ar;
import android.text.TextUtils;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.framework.b.n;
import com.getpebble.android.common.model.af;
import com.getpebble.android.framework.m.j;
import com.getpebble.android.notifications.a.a.d;
import com.getpebble.android.notifications.a.a.e;
import com.getpebble.android.notifications.a.a.f;
import com.getpebble.android.notifications.a.a.g;
import com.getpebble.android.notifications.a.a.h;
import com.getpebble.android.notifications.a.a.i;
import com.google.a.b.as;
import com.google.a.b.aw;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;

public class b {
    private static final com.getpebble.android.framework.timeline.e.b a = com.getpebble.android.framework.timeline.e.b.NOTIFICATION_GENERIC;
    private final long b;
    private final String c;
    private final String d;
    private f e;
    private final String f;
    private final List<com.getpebble.android.notifications.a.a.b> g;
    private final int h;
    private final String i;
    private final String j;
    private final Notification k;
    private boolean l;
    private final c m;
    private final String n;
    private final boolean o;
    private final String p;
    private final com.getpebble.android.common.model.af.b q;
    private final a r;
    private final com.getpebble.android.framework.timeline.b.a s;
    private final com.getpebble.android.framework.timeline.e.b t;
    private int u = 0;
    private UUID v;
    private final boolean w;
    private final boolean x;

    public static class a {
        public String b;
        public String c;
        public String d;
        public boolean e = false;
        public String f;
    }

    private enum b {
        GMAIL("com.google.android.gm", "#FF0000", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_GMAIL),
        GOOGLE_SEARCH("com.google.android.googlequicksearchbox", "#0055FF"),
        WHATS_APP("com.whatsapp", "#00AA00", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_WHATSAPP),
        HANGOUTS("com.google.android.talk", "#00AA55", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_GOOGLE_HANGOUTS),
        SMS("", "#00AA00", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_GENERIC_SMS),
        PLAY_STORE("com.android.vending", "#00AA55"),
        FACEBOOK_MESSENGER("com.facebook.orca", "#0055FF", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_FACEBOOK_MESSENGER),
        ANDROID_EMAIL("com.android.email", "#FF5500", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_GENERIC_EMAIL),
        GOOGLE_CALENDAR("com.google.android.calendar", "#0055FF"),
        TELEGRAM("org.telegram.messenger", "#00AAFF", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_TELEGRAM),
        FACEBOOK("com.facebook.katana", "#0055AA", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_FACEBOOK),
        GOOGLE_MESSENGER("com.google.android.apps.messaging", "#00AAFF", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_GOOGLE_MESSENGER),
        HIPCHAT("com.hipchat", "#0055AA", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_HIPCHAT),
        SKYPE("com.skype.raider", "#00AAFF", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_SKYPE),
        TWITTER("com.twitter.android", "#00AAFF", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_TWITTER),
        MAILBOX("com.mailboxapp", "#00AAFF", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_MAILBOX),
        SNAPCHAT("com.snapchat.android", "#FFFF55", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_SNAPCHAT),
        WECHAT("com.tencent.mm", "#55AA00", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_WECHAT),
        VIBER("com.viber.voip", "#AA00FF", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_VIBER),
        INSTAGRAM("com.instagram.android", "#0055AA", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_INSTAGRAM),
        YOUTUBE("com.google.android.youtube", "#FF0000"),
        KIK("kik.android", "#00AA00", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_KIK),
        LINE("jp.naver.line.android", "#00AA00", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_LINE),
        INBOX("com.google.android.apps.inbox", "#0055FF", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_GOOGLE_INBOX),
        BBM("com.bbm", "#555555", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_BLACKBERRY_MESSENGER),
        OUTLOOK("com.microsoft.office.outlook", "#0055FF", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_OUTLOOK),
        YAHOO_MAIL("com.yahoo.mobile.client.android.mail", "#5500AA", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_YAHOO_MAIL),
        KAKAO_TALK("com.kakao.talk", "#FFFF00", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_KAKAOTALK),
        PEBBLE_TIME("com.getpebble.android.basalt", "#FF5500", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_BLACKBERRY_MESSENGER),
        AMAZON("com.amazon.mshop.android.shopping", "#FFAA00", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_AMAZON),
        GOOGLE_MAPS("com.google.android.apps.maps", "#0055FF", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_GOOGLE_MAPS),
        GOOGLE_PHOTOS("com.google.android.apps.photos", "#0055FF", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_GOOGLE_PHOTOS),
        LINKEDIN("com.linkedin.android", "#0055AA", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_LINKEDIN),
        SLACK("com.slack", "#FF0055", com.getpebble.android.framework.timeline.e.b.NOTIFICATION_SLACK);
        
        private final String color;
        private final com.getpebble.android.framework.timeline.e.b icon;
        private final String pkg;

        private b(String str, String str2) {
            this(r7, r8, str, str2, b.a);
        }

        private b(String str, String str2, com.getpebble.android.framework.timeline.e.b bVar) {
            this.pkg = str;
            this.color = str2;
            this.icon = bVar;
        }

        private com.getpebble.android.framework.timeline.b.a getColor() {
            return com.getpebble.android.framework.timeline.b.a().b(this.color);
        }

        public static b fromPkg(String str) {
            for (b bVar : values()) {
                if (bVar.pkg.equalsIgnoreCase(str)) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public enum c {
        NOTIFICATION,
        SIDECHANNEL,
        DEMO,
        SMS,
        PEBBLEKIT,
        MMS,
        JSKIT
    }

    public UUID a() {
        return this.v;
    }

    public void a(UUID uuid) {
        this.v = uuid;
    }

    @SuppressLint({"NewApi"})
    public static b a(StatusBarNotification statusBarNotification, c cVar, long j) {
        if (statusBarNotification == null) {
            throw new IllegalArgumentException("'notification' cannot be null!");
        }
        String key;
        if (VERSION.SDK_INT >= 20) {
            key = statusBarNotification.getKey();
        } else {
            key = null;
        }
        return new b(statusBarNotification.getPackageName(), statusBarNotification.getId(), statusBarNotification.getTag(), key, statusBarNotification.getNotification(), cVar, null, j);
    }

    public static b a(Notification notification, String str, c cVar, long j) {
        if (notification == null) {
            throw new IllegalArgumentException("'notification' cannot be null!");
        } else if (str != null) {
            return new b(str, -1, null, null, notification, cVar, null, j);
        } else {
            throw new IllegalArgumentException("'packageName' cannot be null!");
        }
    }

    public static b a(a aVar, c cVar, long j) {
        if (aVar == null) {
            throw new IllegalArgumentException("'content' cannot be null!");
        } else if (cVar != null) {
            return new b(null, -1, null, null, null, cVar, aVar, j);
        } else {
            throw new IllegalArgumentException("'source' cannot be null!");
        }
    }

    public static String a(String str, int i, String str2) {
        return str + "|" + i + "|" + str2;
    }

    private b(String str, int i, String str2, String str3, Notification notification, c cVar, a aVar, long j) {
        boolean z = true;
        this.b = j;
        this.d = str;
        this.q = af.a(this.d, com.getpebble.android.common.a.K().getContentResolver());
        if (this.q == null) {
            this.c = "";
        } else {
            this.c = this.q.b;
        }
        if (notification == null) {
            this.w = false;
            this.x = false;
        } else {
            boolean z2;
            if ((notification.flags & 2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.w = z2;
            if (this.w || (notification.flags & 32) != 0) {
                z = false;
            }
            this.x = z;
        }
        this.h = i;
        this.i = str2;
        if (str3 != null) {
            this.j = str3;
        } else {
            this.j = a(this.d, this.h, this.i);
        }
        this.k = notification;
        this.m = cVar;
        this.r = aVar;
        if (this.k == null) {
            this.n = null;
            this.o = false;
            this.f = null;
            this.p = null;
            this.g = new ArrayList();
            F();
            switch (cVar) {
                case SMS:
                case MMS:
                    this.s = b.SMS.getColor();
                    this.t = b.SMS.icon;
                    return;
                default:
                    this.t = a;
                    this.s = a(this.d);
                    return;
            }
        }
        CharSequence[] charSequenceArr;
        if (this.k.tickerText != null) {
            this.f = this.k.tickerText.toString();
        } else {
            this.f = null;
        }
        this.n = ac.c(notification);
        this.o = ac.d(notification);
        Bundle a = ac.a(this.k);
        if (a == null || !a.containsKey("android.textLines")) {
            charSequenceArr = null;
        } else {
            charSequenceArr = a.getCharSequenceArray("android.textLines");
        }
        if (charSequenceArr == null || charSequenceArr.length <= 0) {
            this.p = null;
        } else {
            this.p = charSequenceArr[charSequenceArr.length - 1].toString();
        }
        this.g = a(this.k);
        b fromPkg = b.fromPkg(this.d);
        if (fromPkg != null) {
            this.s = fromPkg.getColor();
            this.t = fromPkg.icon;
            return;
        }
        if (this.q == null || !this.q.j) {
            this.t = a;
        } else {
            this.t = com.getpebble.android.framework.timeline.e.b.NOTIFICATION_GENERIC_SMS;
        }
        this.s = a(this.d);
    }

    private com.getpebble.android.framework.timeline.b.a a(String str) {
        Drawable drawable = null;
        try {
            drawable = com.getpebble.android.common.a.K().getPackageManager().getApplicationIcon(str);
        } catch (Exception e) {
            com.getpebble.android.common.b.a.f.d("PebbleNotification", "Failed to fetch app icon for application");
        }
        if (drawable == null) {
            return b.SMS.getColor();
        }
        return com.getpebble.android.framework.timeline.b.a().a(new android.support.v7.e.b.a(n.a(drawable)).a().a(com.getpebble.android.common.a.K().getResources().getColor(R.color.default_notification_color)));
    }

    public void a(d dVar) {
        if (dVar != null) {
            d A = A();
            if (A != null) {
                this.g.remove(A);
                this.g.add(dVar);
                dVar.a(A.a());
                return;
            }
            com.getpebble.android.common.b.a.f.e("PebbleNotification", "Adding dismiss action for notification from summary");
            b(dVar);
        }
    }

    public void b() {
        if (!u() || this.r == null) {
            this.e = h.b(this);
        } else {
            this.e = new f(this.r.b, this.r.d, this.r.c);
        }
    }

    private void b(com.getpebble.android.notifications.a.a.b bVar) {
        this.g.add(bVar);
        int i = this.u + 1;
        this.u = i;
        bVar.a(i);
    }

    public void a(com.getpebble.android.notifications.a.a.b bVar) {
        Object obj = null;
        for (com.getpebble.android.notifications.a.a.b b : x()) {
            Object obj2;
            if (b.b().equals(bVar.b())) {
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            obj = obj2;
        }
        if (obj == null) {
            b(bVar);
        }
    }

    private List<com.getpebble.android.notifications.a.a.b> a(Notification notification) {
        int i;
        int i2;
        int i3 = 0;
        List<com.getpebble.android.notifications.a.a.b> arrayList = new ArrayList();
        if (notification.contentIntent != null) {
            CharSequence string = com.getpebble.android.common.a.K().getString(R.string.open_on_phone_action_title);
            PendingIntent pendingIntent = notification.contentIntent;
            int i4 = this.u + 1;
            this.u = i4;
            arrayList.add(new g(string, pendingIntent, i4));
        }
        if (w()) {
            string = com.getpebble.android.common.a.K().getString(R.string.dismiss_action_title);
            int i5 = this.u + 1;
            this.u = i5;
            arrayList.add(new d(string, i5, com.getpebble.android.notifications.a.a.a.a(this)));
        }
        List<android.support.v4.app.ac.a> b = new t(this.k).b();
        int i6 = (!com.getpebble.android.notifications.b.f.b(this.d) || com.getpebble.android.notifications.b.f.b()) ? 0 : 1;
        if (b != null && i6 == 0) {
            for (android.support.v4.app.ac.a aVar : b) {
                if (aVar.d() == null || !aVar.d().containsKey("com.google.android.wearable.preview.extra.REMOTE_INTENT")) {
                    boolean add;
                    ar[] f = aVar.f();
                    if (f != null) {
                        i = 0;
                        while (i < f.length) {
                            ar arVar = f[i];
                            if (arVar.d()) {
                                List arrayList2 = new ArrayList();
                                Map c = com.getpebble.android.common.b.b.c.c();
                                if (c != null) {
                                    for (String add2 : c.values()) {
                                        arrayList2.add(add2);
                                    }
                                }
                                if (arVar.c() != null) {
                                    for (Object add3 : arVar.c()) {
                                        arrayList2.add(add3);
                                    }
                                }
                                CharSequence charSequence = aVar.b;
                                PendingIntent pendingIntent2 = aVar.c;
                                int i7 = this.u + 1;
                                this.u = i7;
                                add = arrayList.add(new a.h(arVar, charSequence, pendingIntent2, i7, arrayList2));
                                if (!add) {
                                    string = aVar.b;
                                    pendingIntent = aVar.c;
                                    i4 = this.u + 1;
                                    this.u = i4;
                                    arrayList.add(new com.getpebble.android.notifications.a.a.c(string, pendingIntent, i4));
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                    add = false;
                    if (!add) {
                        string = aVar.b;
                        pendingIntent = aVar.c;
                        i4 = this.u + 1;
                        this.u = i4;
                        arrayList.add(new com.getpebble.android.notifications.a.a.c(string, pendingIntent, i4));
                    }
                } else {
                    com.getpebble.android.common.b.a.f.d("PebbleNotification", "getActions: skipping action '" + aVar.b() + "' which is a Wear deep-link");
                }
            }
        }
        if (i6 != 0) {
            String str = this.d;
            i = -1;
            switch (str.hashCode()) {
                case -543674259:
                    if (str.equals("com.google.android.gm")) {
                        i = 0;
                        break;
                    }
                    break;
                case 1258973329:
                    if (str.equals("com.google.android.apps.inbox")) {
                        i = 2;
                        break;
                    }
                    break;
                case 1515426419:
                    if (str.equals("com.google.android.talk")) {
                        i = 1;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    i = R.string.enable_gmail_actions_notification;
                    i3 = R.string.enable_actions_success_notification_gmail;
                    i2 = R.string.setup_actions;
                    break;
                case 1:
                    i2 = R.string.setup_replies;
                    i = R.string.enable_hangouts_replies_notification;
                    i3 = R.string.enable_actions_success_notification_hangouts;
                    break;
                case 2:
                    i = R.string.enable_inbox_actions_notification;
                    i3 = R.string.enable_actions_success_notification_inbox;
                    i2 = R.string.setup_actions;
                    break;
                default:
                    i = 0;
                    i2 = 0;
                    break;
            }
            if (i2 != 0) {
                com.getpebble.android.common.b.a.f.d("PebbleNotification", "Adding 'install Android Wear' prompt action");
                string = com.getpebble.android.common.a.K().getString(i2);
                i4 = this.u + 1;
                this.u = i4;
                arrayList.add(new e(string, i4, i, i3));
            }
        }
        i2 = this.u + 1;
        this.u = i2;
        arrayList.add(new a.f(this, i2));
        return arrayList;
    }

    private void F() {
        if (c.SMS.equals(e())) {
            if (this.r instanceof j.d) {
                j.d dVar = (j.d) this.r;
                List list = this.g;
                String str = dVar.a;
                int i = this.u + 1;
                this.u = i;
                list.add(new i(str, i));
            }
        } else if (c.MMS.equals(e())) {
            List list2 = this.g;
            CharSequence string = com.getpebble.android.common.a.K().getString(R.string.dismiss_action_title);
            r4 = this.u + 1;
            this.u = r4;
            list2.add(new d(string, r4, null));
        } else if (this.r.e && !TextUtils.isEmpty(this.r.f)) {
            List list3 = this.g;
            CharSequence charSequence = this.r.f;
            r4 = this.u + 1;
            this.u = r4;
            list3.add(new a.h(null, charSequence, null, r4, new ArrayList()));
        }
    }

    public String toString() {
        return g() + ": " + i();
    }

    public long c() {
        return this.b;
    }

    public long d() {
        TimeZone timeZone = TimeZone.getDefault();
        return ((long) timeZone.getOffset(this.b)) + this.b;
    }

    public c e() {
        return this.m;
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return this.d;
    }

    public String h() {
        return this.p;
    }

    public f i() {
        return this.e;
    }

    public String j() {
        return this.f;
    }

    public int k() {
        return this.h;
    }

    public String l() {
        return this.i;
    }

    public String m() {
        return this.j;
    }

    public Notification n() {
        return this.k;
    }

    public boolean o() {
        return this.w;
    }

    public boolean p() {
        return this.l;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public String q() {
        return this.n;
    }

    public boolean r() {
        return this.o;
    }

    public com.getpebble.android.framework.timeline.b.a s() {
        return this.s;
    }

    public com.getpebble.android.framework.timeline.e.b t() {
        return this.t;
    }

    public boolean u() {
        return c.DEMO.equals(this.m) || c.MMS.equals(this.m) || c.SMS.equals(this.m) || c.JSKIT.equals(this.m) || c.PEBBLEKIT.equals(this.m);
    }

    public com.getpebble.android.common.model.af.b v() {
        return this.q;
    }

    public boolean w() {
        return this.x;
    }

    public List<com.getpebble.android.notifications.a.a.b> x() {
        return this.g;
    }

    public List<a.h> y() {
        return aw.a(as.a(x(), a.h.class));
    }

    public g z() {
        return (g) as.a(x(), com.google.a.a.j.a(g.class), null);
    }

    public d A() {
        return (d) as.a(x(), com.google.a.a.j.a(d.class), null);
    }

    public a.f B() {
        return (a.f) as.a(x(), com.google.a.a.j.a(a.f.class), null);
    }

    public boolean C() {
        return (x() == null || x().isEmpty()) ? false : true;
    }

    public List<com.getpebble.android.notifications.a.a.b> D() {
        List<com.getpebble.android.notifications.a.a.b> arrayList = new ArrayList(x());
        arrayList.removeAll(y());
        arrayList.remove(z());
        arrayList.remove(A());
        arrayList.remove(B());
        return arrayList;
    }
}
