package com.getpebble.android.framework.i;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.model.af;
import com.getpebble.android.common.model.an;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.common.model.aw.d;
import com.getpebble.android.framework.m.j.e;
import com.getpebble.android.framework.timeline.f;
import com.getpebble.android.framework.timeline.g;
import com.getpebble.android.h.y;
import com.getpebble.android.notifications.PblNotificationService;
import com.getpebble.android.notifications.a.a.h;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class b {
    private static b e = null;
    private final c a;
    private final ContentResolver b;
    private final com.getpebble.android.b.b.a c;
    private com.getpebble.android.framework.i.a.c d;
    private Map<UUID, List<com.getpebble.android.notifications.a.a.b>> f = new HashMap();

    public static class a implements e {
        private final com.getpebble.android.framework.g.ag.a a;
        private f b;
        private com.getpebble.android.common.model.an.a c;

        private a(com.getpebble.android.framework.g.ag.a aVar) {
            this.a = aVar;
        }

        private void a(f fVar) {
            this.b = fVar;
        }

        private void a(com.getpebble.android.common.model.an.a aVar) {
            this.c = aVar;
        }

        public void a() {
            this.a.a(false, null, null);
        }

        public void b() {
            this.a.a(true, this.b, null);
            if (this.c != null) {
                PblNotificationService.a(com.getpebble.android.notifications.a.a.a.a(this.c));
            }
        }
    }

    public b(c cVar, ContentResolver contentResolver, com.getpebble.android.b.b.a aVar) {
        this.a = cVar;
        this.b = contentResolver;
        this.c = aVar;
        an.purgeNotificationsForAllPackages(this.b);
        e = this;
        this.d = new com.getpebble.android.framework.i.a.c(e);
    }

    public static void a(com.getpebble.android.notifications.a.b bVar) {
        b bVar2 = e;
        if (bVar2 != null) {
            bVar2.b(bVar);
        }
    }

    protected void a(com.getpebble.android.notifications.a.b bVar, boolean z) {
        com.getpebble.android.notifications.b.f.a(bVar, z);
    }

    protected boolean a(com.getpebble.android.common.model.af.b bVar) {
        return bVar != null && bVar.d;
    }

    protected boolean b(com.getpebble.android.common.model.af.b bVar) {
        return bVar != null && bVar.a().contains(Calendar.getInstance().get(7));
    }

    protected boolean c(com.getpebble.android.common.model.af.b bVar) {
        return bVar == null;
    }

    synchronized void b(com.getpebble.android.notifications.a.b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("'notification' cannot be null!");
        }
        com.getpebble.android.common.model.af.b a = af.a(bVar.g(), this.b);
        String str = "Notification received: " + bVar.m();
        if (bVar.u() || !c(a)) {
            com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", str);
        } else {
            com.getpebble.android.common.b.a.f.e("PebbleNotificationProcessor", str);
        }
        if (this.a.a(com.getpebble.android.common.b.b.c.a.LOG_NOTIFICATIONS, false)) {
            com.getpebble.android.notifications.b.f.b(bVar);
        }
        if (bVar.o()) {
            if (com.getpebble.android.notifications.b.c.a(bVar.g())) {
                com.getpebble.android.notifications.b.c.d(bVar.g());
            }
            if (com.getpebble.android.notifications.b.c.b(bVar.g())) {
                com.getpebble.android.f.c.a(bVar);
            }
        } else if (bVar.u() || !c(a)) {
            bVar.b();
            com.getpebble.android.common.model.an.a parseRecordFrom = an.parseRecordFrom(bVar);
            bVar.a(parseRecordFrom.notificationUuid);
            a(parseRecordFrom);
            if (!a(a) && !bVar.u()) {
                com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "Notification package not selected by user; skipping");
                a(bVar, false);
            } else if (b(a) && !bVar.u()) {
                com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", bVar.g() + " is muted today.");
                a(bVar, false);
            } else if (com.getpebble.android.framework.m.j.b.a(a) || bVar.u()) {
                this.c.b(true);
                if (com.getpebble.android.notifications.b.f.b(bVar.g()) && !this.a.a(com.getpebble.android.common.b.b.c.a.RECEIVED_POTENTIAL_WEAR_ENHANCED_NOTIFICATION, false)) {
                    this.a.b(com.getpebble.android.common.b.b.c.a.RECEIVED_POTENTIAL_WEAR_ENHANCED_NOTIFICATION, true);
                }
                if (bVar.q() != null) {
                    c(bVar);
                } else {
                    d(bVar);
                }
            } else {
                com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "Notification package does not have good SMS notifications; SMSReceiver should handle this; skipping");
                a(bVar, false);
            }
        } else {
            com.getpebble.android.common.b.a.f.e("PebbleNotificationProcessor", "... isSystemApp, skipping.");
        }
    }

    protected void c(com.getpebble.android.notifications.a.b bVar) {
        this.d.a(bVar);
    }

    public synchronized void d(com.getpebble.android.notifications.a.b bVar) {
        com.getpebble.android.notifications.a.a.f i = bVar.i();
        if (i == null || TextUtils.isEmpty(i.b()) || TextUtils.isEmpty(i.c())) {
            com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "Notification has null title/body or is null");
            a(bVar, false);
        } else {
            boolean equals = bVar.e().equals(com.getpebble.android.notifications.a.b.c.DEMO);
            boolean a = this.a.a(com.getpebble.android.common.b.b.c.a.ALWAYS_NOTIFY, true);
            if (equals || a || y.b() || !y.a()) {
                bVar.a(h.a(bVar));
                com.getpebble.android.common.model.an.a parseRecordFrom = an.parseRecordFrom(bVar);
                d a2 = a(a(bVar, parseRecordFrom.notificationUuid));
                if (bVar.p()) {
                    com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "Notification is duplicate; skipping");
                    an.markAsDup(com.getpebble.android.common.a.K().getContentResolver(), parseRecordFrom.notificationUuid);
                    a(bVar, false);
                } else if (com.getpebble.android.notifications.b.f.a(bVar)) {
                    com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "Notification is calendar invite via gmail; not sending notification");
                    a(bVar, false);
                } else if (a(a2)) {
                    b(parseRecordFrom);
                    a(bVar, parseRecordFrom);
                    a(bVar, true);
                } else {
                    a(bVar, false);
                }
            } else {
                com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "Screen is on and unlocked; not sending notification");
            }
        }
    }

    private void a(com.getpebble.android.common.model.an.a aVar) {
        an.insert(this.b, aVar);
    }

    private void b(com.getpebble.android.common.model.an.a aVar) {
        an.markNotificationAsSent(this.b, aVar);
    }

    private void a(com.getpebble.android.notifications.a.b bVar, com.getpebble.android.common.model.an.a aVar) {
        if (bVar.C()) {
            this.f.put(aVar.notificationUuid, bVar.x());
        }
    }

    private d a(aw.c cVar) {
        return new d(cVar, System.currentTimeMillis(), System.currentTimeMillis(), aw.e.ANDROID_NOTIFICATION, aw.d);
    }

    private aw.c a(com.getpebble.android.notifications.a.b bVar, UUID uuid) {
        f add = new f().add(com.getpebble.android.framework.timeline.e.c.TITLE_KEY, bVar.i().b()).add(com.getpebble.android.framework.timeline.e.c.BODY_KEY, bVar.i().c()).add(com.getpebble.android.framework.timeline.e.c.TINY_ICON, bVar.t());
        if (bVar.s() != null) {
            add.add(com.getpebble.android.framework.timeline.e.c.BACKGROUND_COLOR, bVar.s().b);
        }
        g gVar = new g(g.GENERIC_NOTIFICATION, add);
        return new aw.c(uuid, aw.d, com.getpebble.android.common.model.aw.b.NOTIFICATION, 0, bVar.c(), gVar.toJson(), com.getpebble.android.framework.timeline.d.from(bVar).toJson());
    }

    private void b(UUID uuid) {
        com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "removeFailedNotification() uuid = " + uuid);
        an.deleteNotificationRecord(this.b, uuid);
        this.f.remove(uuid);
    }

    public static void a(UUID uuid) {
        b bVar = e;
        if (bVar != null) {
            bVar.b(uuid);
        }
    }

    public static void a(int i, String str, String str2, String str3, long j) {
        b bVar = e;
        if (bVar != null) {
            bVar.b(i, str, str2, str3, j);
        }
    }

    public static void a(String str, long j) {
        b bVar = e;
        if (bVar != null) {
            bVar.b(str, j);
        }
    }

    protected boolean a(d dVar) {
        return PebbleApplication.o() && aw.a(this.b, dVar);
    }

    void b(int i, String str, String str2, String str3, long j) {
        if (str3 == null) {
            str3 = com.getpebble.android.notifications.a.b.a(str2, i, str);
        }
        com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", String.format("Removing notification with id=<%s> tag=<%s> package=<%s> key=<%s>", new Object[]{String.valueOf(i), str, str2, str3}));
        for (com.getpebble.android.common.model.an.a a : an.findNonRemovedNotifications(str2, i, str, str3, this.b)) {
            a(a, j);
        }
    }

    private void b(String str, long j) {
        com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", String.format("Removing notification with package=<%s>", new Object[]{str}));
        this.d.a();
        try {
            List<com.getpebble.android.common.model.an.a> findNonRemovedNotifications = an.findNonRemovedNotifications(str, this.b);
            if (findNonRemovedNotifications == null) {
                com.getpebble.android.common.b.a.f.c("PebbleNotificationProcessor", "records is null");
                return;
            }
            for (com.getpebble.android.common.model.an.a a : findNonRemovedNotifications) {
                a(a, j);
            }
            this.d.b();
        } finally {
            this.d.b();
        }
    }

    private void a(com.getpebble.android.common.model.an.a aVar, long j) {
        if (aVar == null) {
            com.getpebble.android.common.b.a.f.b("PebbleNotificationProcessor", "Could not find matching notification");
            return;
        }
        this.f.remove(aVar.notificationUuid);
        an.markRemovedNotificationForUuid(com.getpebble.android.common.a.K().getContentResolver(), aVar.notificationUuid, j);
        if (!aVar.dismissedFromWatch && aVar.sentToWatch) {
            an.markItemAsDismissed(com.getpebble.android.common.a.K().getContentResolver(), aVar.notificationUuid);
            aw.b(this.b, aVar.notificationUuid);
        }
    }

    public static void a() {
        b bVar = e;
    }

    public static b b() {
        return e;
    }

    public void a(UUID uuid, int i, Map<String, String> map, Context context, com.getpebble.android.framework.g.ag.a aVar) {
        a aVar2 = new a(aVar);
        List<com.getpebble.android.notifications.a.a.b> list = (List) this.f.get(uuid);
        if (list == null) {
            com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "Actions not found for notification ID: " + uuid);
            aVar.a(false, null, null);
            return;
        }
        com.getpebble.android.common.model.an.a findNotification = an.findNotification(uuid, context.getContentResolver());
        aVar2.a(findNotification);
        for (com.getpebble.android.notifications.a.a.b bVar : list) {
            if (bVar.a() == i) {
                break;
            }
        }
        com.getpebble.android.notifications.a.a.b bVar2 = null;
        if (bVar2 == null) {
            com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "invokeAction: action not found for ID: " + i);
            aVar2.a();
            return;
        }
        a(bVar2, findNotification, map);
        if (bVar2 instanceof com.getpebble.android.notifications.a.a.d) {
            com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "PebbleNotificationDismissAction; dismissing...");
            ((com.getpebble.android.notifications.a.a.d) bVar2).d();
            f fVar = new f();
            fVar.add(com.getpebble.android.framework.timeline.e.c.LARGE_ICON, com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_DISMISS);
            fVar.add(com.getpebble.android.framework.timeline.e.c.SUBTITLE_KEY, a((int) R.string.action_dismissed));
            aVar2.a(fVar);
            aVar2.b();
        } else if (bVar2 instanceof com.getpebble.android.notifications.a.a.c) {
            int i2;
            com.getpebble.android.framework.timeline.e.b bVar3;
            com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "PebbleNotificationAndroidAction; sending Intent");
            com.getpebble.android.notifications.a.a.c cVar = (com.getpebble.android.notifications.a.a.c) bVar2;
            f fVar2 = new f();
            if (bVar2 instanceof com.getpebble.android.notifications.a.a.g) {
                i2 = R.string.action_opened_on_phone;
                bVar3 = com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_OPENED_ON_PHONE;
            } else {
                i2 = R.string.action_done;
                bVar3 = com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_DONE;
            }
            fVar2.add(com.getpebble.android.framework.timeline.e.c.SUBTITLE_KEY, a(i2));
            fVar2.add(com.getpebble.android.framework.timeline.e.c.LARGE_ICON, bVar3);
            aVar2.a(fVar2);
            if (cVar.d()) {
                aVar2.b();
            } else {
                aVar2.a();
            }
        } else if (bVar2 instanceof com.getpebble.android.notifications.a.a.f) {
            com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "PebbleNotificationMuteAction; invoking");
            com.getpebble.android.notifications.a.a.f fVar3 = (com.getpebble.android.notifications.a.a.f) bVar2;
            f fVar4 = new f();
            fVar4.add(com.getpebble.android.framework.timeline.e.c.SUBTITLE_KEY, a((int) R.string.action_muted));
            fVar4.add(com.getpebble.android.framework.timeline.e.c.LARGE_ICON, com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_MUTE);
            aVar2.a(fVar4);
            fVar3.a(aVar2);
        } else if (bVar2 instanceof com.getpebble.android.notifications.a.a.h) {
            com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "PebbleNotificationReplyAction; sending Intent");
            com.getpebble.android.notifications.a.a.h hVar = (com.getpebble.android.notifications.a.a.h) bVar2;
            if (map == null) {
                com.getpebble.android.common.b.a.f.a("PebbleNotificationProcessor", "Tried to send reply, but attributes are null");
                aVar2.a();
            } else if (map.containsKey(com.getpebble.android.framework.timeline.e.c.TITLE_KEY.getSerializedName())) {
                Object obj = (String) map.get(com.getpebble.android.framework.timeline.e.c.TITLE_KEY.getSerializedName());
                com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "Sending reply: " + com.getpebble.android.common.b.b.a.a(obj));
                f fVar5 = new f();
                fVar5.add(com.getpebble.android.framework.timeline.e.c.SUBTITLE_KEY, a((int) R.string.action_sent));
                fVar5.add(com.getpebble.android.framework.timeline.e.c.LARGE_ICON, com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_SENT);
                aVar2.a(fVar5);
                hVar.a(obj, context, aVar2);
            } else {
                com.getpebble.android.common.b.a.f.a("PebbleNotificationProcessor", "Tried to send reply, but attributes do not contain title");
                aVar2.a();
            }
        } else {
            com.getpebble.android.common.b.a.f.d("PebbleNotificationProcessor", "invokeAction: not valid action type found for ID: " + i);
            aVar2.a();
        }
    }

    public static void a(com.getpebble.android.notifications.a.a.b bVar, com.getpebble.android.common.model.an.a aVar, Map<String, String> map) {
        Object obj;
        Map hashMap = new HashMap();
        hashMap.put("action_type", bVar.c());
        hashMap.put("action_title", bVar.b());
        hashMap.put("package_name", aVar == null ? "unknown" : aVar.androidPackageName);
        com.getpebble.android.common.model.af.b bVar2 = null;
        if (aVar != null) {
            bVar2 = af.a(aVar.androidPackageName, com.getpebble.android.common.a.K().getContentResolver());
        }
        if (bVar2 == null) {
            obj = "unknown";
        } else {
            obj = bVar2.b;
        }
        hashMap.put("app_name", obj);
        com.getpebble.android.common.b.a.a.c.b(hashMap);
    }

    private String a(int i) {
        return com.getpebble.android.common.a.K().getString(i);
    }
}
