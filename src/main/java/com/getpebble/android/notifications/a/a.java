package com.getpebble.android.notifications.a;

import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ar;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.model.af;
import com.getpebble.android.framework.m.j;
import com.getpebble.android.h.m;
import com.getpebble.android.notifications.PblNotificationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class a {

    public static class a {
        public final int a;
        public final String b;
        public final String c;
        public final String d;

        private a(int i, String str, String str2, String str3) {
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        public static a a(b bVar) {
            return new a(bVar.k(), bVar.l(), bVar.g(), bVar.m());
        }

        public static a a(com.getpebble.android.common.model.an.a aVar) {
            return new a(aVar.androidNotificationId, aVar.androidNotificationTag, aVar.androidPackageName, aVar.androidNotificationKey);
        }
    }

    public static abstract class b {
        private int a;
        private CharSequence b;

        public abstract String c();

        private b(CharSequence charSequence, int i) {
            this.a = i;
            this.b = charSequence;
        }

        public int a() {
            return this.a;
        }

        public CharSequence b() {
            return this.b;
        }

        public void a(int i) {
            this.a = i;
        }
    }

    public static class c extends b {
        private PendingIntent a;

        public c(CharSequence charSequence, PendingIntent pendingIntent, int i) {
            super(charSequence, i);
            this.a = pendingIntent;
            com.getpebble.android.common.b.a.f.e("Actions", "Adding " + c() + " id = " + a() + " title = " + charSequence);
        }

        public boolean d() {
            if (this.a == null) {
                com.getpebble.android.common.b.a.f.b("Actions", "Intent is null");
                return false;
            }
            try {
                this.a.send(0, new OnFinished(this) {
                    final /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
                        com.getpebble.android.common.b.a.f.d("Actions", "PebbleNotificationAndroidAction onSendFinished pendingIntent = " + pendingIntent + " intent = " + intent + " resultCode = " + i + " resultData = " + str + " resultExtras = " + bundle);
                    }
                }, null);
                return true;
            } catch (Throwable e) {
                com.getpebble.android.common.b.a.f.b("Actions", "Error sending notification action", e);
                return false;
            }
        }

        public String c() {
            return "PblNotificationAndroidAction";
        }
    }

    public static class d extends b {
        a a;

        public d(CharSequence charSequence, int i, a aVar) {
            super(charSequence, i);
            this.a = aVar;
        }

        public void d() {
            PblNotificationService.a(this.a);
        }

        public String c() {
            return "PblNotificationDismissAction";
        }
    }

    public static class e extends c {
        private final int a;
        private final int b;

        public e(CharSequence charSequence, int i, int i2, int i3) {
            super(charSequence, null, i);
            this.a = i2;
            this.b = i3;
        }

        public boolean d() {
            final Context K = com.getpebble.android.common.a.K();
            m.a(K, "com.google.android.wearable.app");
            com.getpebble.android.notifications.a.b.a aVar = new com.getpebble.android.notifications.a.b.a();
            aVar.b = K.getString(R.string.enable_actions_notification_title);
            aVar.d = K.getString(this.a);
            com.getpebble.android.framework.i.b.a(b.a(aVar, com.getpebble.android.notifications.a.b.c.DEMO, System.currentTimeMillis()));
            com.getpebble.android.notifications.b.a.a(new com.getpebble.android.notifications.b.a.a(this) {
                final /* synthetic */ e b;

                public void a() {
                    com.getpebble.android.notifications.a.b.a aVar = new com.getpebble.android.notifications.a.b.a();
                    aVar.b = K.getString(R.string.enable_actions_success_notification_title);
                    aVar.d = K.getString(this.b.b);
                    com.getpebble.android.framework.i.b.a(b.a(aVar, com.getpebble.android.notifications.a.b.c.DEMO, System.currentTimeMillis()));
                }
            });
            return true;
        }
    }

    public static class f extends b {
        private final String a;

        public f(b bVar, int i) {
            super(String.format(com.getpebble.android.common.a.K().getString(R.string.mute_notifications_action_title), new Object[]{bVar.f()}), i);
            this.a = bVar.g();
        }

        public void a(com.getpebble.android.framework.i.b.a aVar) {
            com.getpebble.android.common.b.a.f.d("Actions", "PebbleNotificationMuteAction: setting notifications disabled for " + this.a);
            af.a(this.a, false, com.getpebble.android.common.a.K().getContentResolver());
            aVar.b();
        }

        public String c() {
            return "PblNotificationMuteAction";
        }
    }

    public static class g extends c {
        public g(CharSequence charSequence, PendingIntent pendingIntent, int i) {
            super(charSequence, pendingIntent, i);
        }

        public String c() {
            return "PblNotificationOpenOnPhoneAction";
        }
    }

    public static class h extends b {
        private final ar a;
        private final PendingIntent b;
        private final List<CharSequence> c;

        public h(ar arVar, CharSequence charSequence, PendingIntent pendingIntent, int i, List<CharSequence> list) {
            super(charSequence, i);
            this.a = arVar;
            this.b = pendingIntent;
            this.c = list;
        }

        public void a(String str, Context context, com.getpebble.android.framework.i.b.a aVar) {
            com.getpebble.android.common.b.a.f.d("Actions", "PebbleNotificationReplyAction: sendReply");
            if (this.b == null) {
                com.getpebble.android.common.b.a.f.d("Actions", "Intent is null, cannot send reply");
                aVar.a();
            } else if (context == null) {
                com.getpebble.android.common.b.a.f.d("Actions", "context is null, cannot send reply");
                aVar.a();
            } else {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString(this.a.a(), str);
                ar.a(new ar[]{this.a}, intent, bundle);
                try {
                    this.b.send(context, 0, intent, new OnFinished(this) {
                        final /* synthetic */ h a;

                        {
                            this.a = r1;
                        }

                        public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
                            com.getpebble.android.common.b.a.f.d("Actions", "PebbleNotificationReplyAction onSendFinished pendingIntent = " + pendingIntent + " intent = " + intent + " resultCode = " + i + " resultData = " + str + " resultExtras = " + bundle);
                        }
                    }, null);
                    aVar.b();
                } catch (Throwable e) {
                    com.getpebble.android.common.b.a.f.b("Actions", "Error sending notification action", e);
                    aVar.a();
                }
            }
        }

        public List<CharSequence> d() {
            return this.c;
        }

        public String c() {
            return "PblNotificationReplyAction";
        }
    }

    public static class i extends h {
        private final String a;

        private static List<CharSequence> e() {
            List arrayList = new ArrayList();
            Map c = com.getpebble.android.common.b.b.c.c();
            if (c != null) {
                for (String add : c.values()) {
                    arrayList.add(add);
                }
            }
            return arrayList;
        }

        public i(String str, int i) {
            super(null, com.getpebble.android.common.a.K().getString(R.string.reply_with_text), null, i, e());
            this.a = str;
        }

        public void a(String str, Context context, com.getpebble.android.framework.i.b.a aVar) {
            com.getpebble.android.common.b.a.f.d("Actions", "PebbleNotificationSMSReplyAction: sendReply");
            j.a(str, this.a, (com.getpebble.android.framework.m.j.e) aVar);
        }

        public String c() {
            return "PblNotificationSMSReplyAction";
        }
    }
}
