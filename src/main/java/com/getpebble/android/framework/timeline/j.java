package com.getpebble.android.framework.timeline;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.b.b.x;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.a.g;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.au;
import com.getpebble.android.common.model.au.a;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.common.model.timeline.c;
import com.getpebble.android.common.model.timeline.d;
import com.getpebble.android.common.model.timeline.e;
import com.getpebble.android.common.model.timeline.h;
import com.getpebble.android.framework.timeline.c.b;
import com.getpebble.android.h.ab;
import com.google.a.b.af;
import com.google.b.o;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

public class j {
    private final Context a;

    public j(Context context) {
        this.a = context;
    }

    void a(String str) {
        int i = 0;
        while (i < 5) {
            f.d("TimelineWebSync", "Sync number " + i);
            long currentTimeMillis = System.currentTimeMillis();
            boolean f = f(str);
            au.a(a.TIMELINE_WEB_SYNC, this.a.getContentResolver(), System.currentTimeMillis() - currentTimeMillis);
            if (f) {
                i++;
            } else {
                return;
            }
        }
        f.d("TimelineWebSync", "Reached maximum number of consecutive syncs");
    }

    private boolean f(String str) {
        String str2 = "pebble-device-id";
        String a = g.a(e());
        String str3 = "x-request-id";
        String uuid = UUID.randomUUID().toString();
        String str4 = "pebble-push-reason";
        if (str == null) {
            Object obj = "";
        } else {
            String str5 = str;
        }
        try {
            x a2 = com.getpebble.android.d.a.a(e(), b(), 30000, af.a(str2, a, str3, uuid, str4, obj, "pebble-sync-include", "pins, appglances"));
            if (a2 == null) {
                f.a("TimelineWebSync", "Null timeline events response");
                return false;
            }
            int b = a2.d().b();
            if (b != 200) {
                f.a("TimelineWebSync", "Response failed with error: " + b);
                if (b == 401) {
                    e(d());
                }
                return false;
            }
            o oVar = (o) a2.b();
            if (oVar != null) {
                return b(oVar.toString());
            }
            f.a("TimelineWebSync", "Null timeline event response");
            return false;
        } catch (Throwable e) {
            f.a("TimelineWebSync", "Error fetching timeline events", e);
            return false;
        }
    }

    boolean b(String str) {
        boolean z = false;
        f.d("TimelineWebSync", "handleJsonResponse(" + com.getpebble.android.common.b.b.a.a((Object) str) + ")");
        if (TextUtils.isEmpty(str)) {
            f.a("TimelineWebSync", "Empty timeline events response");
            return z;
        }
        try {
            return a(e.a(str));
        } catch (Throwable e) {
            f.a("TimelineWebSync", "Failed to marshall the timeline sync response", e);
            return z;
        }
    }

    boolean a(e eVar) {
        if (eVar.d) {
            f.d("TimelineWebSync", "handleSyncResponse: Must re-sync; removing all web data");
            a();
            e(eVar.b);
            return true;
        }
        int i;
        com.getpebble.android.common.model.timeline.f[] fVarArr = eVar.a;
        if (fVarArr != null) {
            if (fVarArr.length > 0) {
                f.d("TimelineWebSync", String.format("handleSyncResponse: Received %d updates", new Object[]{Integer.valueOf(fVarArr.length)}));
            }
            for (com.getpebble.android.common.model.timeline.f fVar : fVarArr) {
                if (!(fVar instanceof h)) {
                    a(fVar);
                } else if (b().contains("syncKey=0")) {
                    f.d("TimelineWebSync", "handleSyncResponse: Already doing full re-sync; dropping update event");
                } else {
                    a((h) fVar);
                    return true;
                }
            }
        } else {
            f.d("TimelineWebSync", "handleSyncResponse: Timeline updates array is null");
        }
        if (eVar.b != null) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            e(eVar.b);
            return false;
        }
        e(eVar.c);
        return true;
    }

    void a() {
        aw.a(f(), aw.e.WEB);
    }

    void a(com.getpebble.android.common.model.timeline.f fVar) {
        f.d("TimelineWebSync", "handleUpdate()");
        if (fVar instanceof c) {
            a((c) fVar);
        } else if (fVar instanceof d) {
            a((d) fVar);
        } else if (fVar instanceof com.getpebble.android.common.model.timeline.g) {
            a((com.getpebble.android.common.model.timeline.g) fVar);
        } else if (fVar instanceof h) {
            a((h) fVar);
        } else if (fVar instanceof com.getpebble.android.common.model.timeline.a) {
            a((com.getpebble.android.common.model.timeline.a) fVar);
        } else {
            f.a("TimelineWebSync", "Unable to handle update: " + (fVar == null ? "null" : fVar.getClass().getSimpleName()));
        }
    }

    private void a(com.getpebble.android.common.model.timeline.a aVar) {
        f.d("TimelineWebSync", "handleAppGlanceSliceCreation()");
        com.getpebble.android.common.model.d.c(com.getpebble.android.common.model.d.a.a(aVar), f());
    }

    public void a(d dVar) {
        f.d("TimelineWebSync", "handlePinDeleteEvent()");
        try {
            e(UUID.fromString(dVar.a));
        } catch (Throwable e) {
            f.a("TimelineWebSync", "Failed to parse pin UUID", e);
        }
    }

    public void a(c cVar) {
        f.d("TimelineWebSync", "handlePinCreateEvent: pinCreateEvent.layoutAttributes = " + cVar.i.b);
        try {
            UUID fromString = UUID.fromString(cVar.a);
            try {
                UUID d = d(cVar.e);
                boolean g = g(cVar.e);
                try {
                    long c = c(cVar.f);
                    try {
                        long c2 = c(cVar.c);
                        try {
                            long c3 = c(cVar.d);
                            if (cVar.i == null) {
                                f.a("TimelineWebSync", "Layout is null; dropping event");
                                return;
                            }
                            String str;
                            int i;
                            aw.d dVar;
                            g from = g.from(cVar.i);
                            int i2 = cVar.g;
                            aw.d b = b(fromString);
                            Object obj = b == null ? 1 : null;
                            Object obj2 = (obj == null && b.d() == null) ? 1 : null;
                            Object obj3 = (obj == null && b.d == c3) ? 1 : null;
                            if (obj2 != null) {
                                f.d("TimelineWebSync", "Received pin create event for pin that is marked removed. Updating pin. " + b.c());
                            } else if (obj3 != null) {
                                f.b("TimelineWebSync", String.format("Received new pin, but updated timestamp %d equals local updated timestamp %d. Dropping", new Object[]{Long.valueOf(c3), Long.valueOf(b.d)}));
                                return;
                            }
                            am.c a = am.a(d, f(), false);
                            String str2 = "";
                            if (a != null) {
                                str = a.c;
                            } else {
                                str = str2;
                            }
                            d dVar2 = new d();
                            int i3 = 0;
                            if (cVar.j != null) {
                                c.a[] aVarArr = cVar.j;
                                int length = aVarArr.length;
                                int i4 = 0;
                                while (i4 < length) {
                                    c.a aVar = aVarArr[i4];
                                    i = i3 + 1;
                                    dVar2.add(b.from(aVar.a), i3, f.from(aVar.b));
                                    i4++;
                                    i3 = i;
                                }
                            }
                            aw.d dVar3 = new aw.d(new aw.c(fromString, d, aw.b.PIN, i2, c, from.toJson(), d.getPinActions(dVar2, d).toJson(), g, true, cVar.h, false, cVar.b, aw.c.a.EMPTY), c2, c3, aw.e.WEB, d);
                            f.d("TimelineWebSync", "handlePinCreateEvent: record = " + dVar3);
                            if (obj != null) {
                                a(dVar3);
                            } else {
                                b(dVar3);
                            }
                            List<aw.d> c4 = c(fromString);
                            if ((cVar.k == null ? 0 : cVar.k.length) > 0) {
                                com.google.b.f fVar = new com.google.b.f();
                                for (c.c cVar2 : cVar.k) {
                                    try {
                                        long c5 = c(cVar2.a);
                                        obj2 = null;
                                        g from2 = g.from(cVar2.b);
                                        for (aw.d dVar4 : c4) {
                                            if (dVar4.b.e == c5 && fVar.a(dVar4.b.f).equals(fVar.a((Object) from2.toJson()))) {
                                                obj2 = dVar4;
                                                break;
                                            }
                                        }
                                        if ((obj2 != null ? 1 : null) != null) {
                                            c4.remove(obj2);
                                        } else {
                                            a(new aw.d(new aw.c(UUID.randomUUID(), fromString, aw.b.REMINDER, 0, c5, from2.toJson(), d.getReminderActions(d).toJson(), g, true, false, false, false, aw.c.a.EMPTY), c2, c3, aw.e.WEB, d));
                                        }
                                    } catch (IllegalArgumentException e) {
                                        f.a("TimelineWebSync", "Failed to parse reminder time; skipping" + cVar2.a);
                                    }
                                }
                                for (aw.d dVar42 : c4) {
                                    a(dVar42.b.a);
                                }
                            }
                            obj2 = cVar.l != null ? 1 : null;
                            Object obj4 = cVar.m != null ? 1 : null;
                            obj3 = (obj2 == null && obj4 == null) ? null : 1;
                            if (obj3 == null) {
                                f.d("TimelineWebSync", "No notification found.");
                                return;
                            }
                            List<aw.d> d2 = d(fromString);
                            if (obj != null) {
                                if (!d2.isEmpty()) {
                                    f.a("TimelineWebSync", "Pin " + fromString.toString() + " has existing notifications but it is a new pin. Deleting old notifications.");
                                    for (aw.d dVar422 : d2) {
                                        a(com.getpebble.android.bluetooth.b.b.f(ByteBuffer.wrap(dVar422.c())));
                                    }
                                }
                                if (obj2 != null) {
                                    a(cVar.l, dVar3, str);
                                } else {
                                    a(cVar.m, dVar3, str);
                                }
                            } else if (obj4 == null) {
                            } else {
                                if (d2.isEmpty()) {
                                    a(cVar.m, dVar3, str);
                                } else if (d2.size() != 1) {
                                    f.a("TimelineWebSync", "Pin " + fromString.toString() + " has multiple notifications; cannot disambiguate.");
                                    for (aw.d dVar4222 : d2) {
                                        a(com.getpebble.android.bluetooth.b.b.f(ByteBuffer.wrap(dVar4222.c())));
                                    }
                                    a(cVar.m, dVar3, str);
                                } else {
                                    dVar4222 = (aw.d) d2.iterator().next();
                                    try {
                                        if ((dVar4222.b.e >= c(cVar.m.b) ? 1 : null) != null) {
                                            f.d("TimelineWebSync", "Notification is up-to-date");
                                            return;
                                        }
                                        f.d("TimelineWebSync", "Inserting updateNotification");
                                        a(com.getpebble.android.bluetooth.b.b.f(ByteBuffer.wrap(dVar4222.c())));
                                        a(cVar.m, dVar3, str);
                                    } catch (Throwable e2) {
                                        f.b("TimelineWebSync", "Failed to parse the update notification timestamp. Dropping notification", e2);
                                    }
                                }
                            }
                        } catch (Throwable e22) {
                            f.a("TimelineWebSync", "Failed to parse updateTime; dropping event", e22);
                        }
                    } catch (Throwable e222) {
                        f.a("TimelineWebSync", "Failed to parse createTime; dropping event", e222);
                    }
                } catch (Throwable e2222) {
                    f.a("TimelineWebSync", "Failed to parse timestamp; dropping event", e2222);
                }
            } catch (Throwable e22222) {
                f.a("TimelineWebSync", "Invalid data source; dropping event. Source=" + cVar.e, e22222);
            }
        } catch (Throwable e222222) {
            f.a("TimelineWebSync", "Failed to parse pin UUID", e222222);
        }
    }

    boolean a(aw.d dVar) {
        return aw.a(f(), dVar);
    }

    boolean b(aw.d dVar) {
        return aw.b(f(), dVar);
    }

    void a(UUID uuid) {
        aw.c(f(), uuid);
    }

    aw.d b(UUID uuid) {
        return aw.g(f(), uuid);
    }

    List<aw.d> c(UUID uuid) {
        return aw.f(f(), uuid);
    }

    List<aw.d> d(UUID uuid) {
        return aw.i(f(), uuid);
    }

    void a(com.getpebble.android.common.model.timeline.g gVar) {
        f.d("TimelineWebSync", "handleSubscription(" + gVar.a + ")");
    }

    void a(h hVar) {
        f.d("TimelineWebSync", "handleUnsubscription(" + hVar.a + ")");
        f.b("TimelineWebSync", "PBL-17597 Re-syncing all user timeline web data.");
        a();
        e(d());
    }

    long c(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Invalid timestamp: " + str);
        }
        try {
            return ab.a(str).getTime().getTime();
        } catch (Throwable e) {
            f.a("TimelineWebSync", "Invalid timestamp: " + str);
            throw new IllegalArgumentException(e);
        } catch (Throwable e2) {
            f.a("TimelineWebSync", "Invalid timestamp: " + str);
            throw new IllegalArgumentException(e2);
        } catch (Throwable e22) {
            f.a("TimelineWebSync", "Invalid timestamp: " + str);
            throw new IllegalArgumentException(e22);
        }
    }

    @Deprecated
    UUID d(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        String substring;
        if (str.startsWith("uuid:")) {
            substring = str.substring("uuid:".length(), str.length());
        } else if (str.startsWith("sandbox-")) {
            substring = str.substring("sandbox-".length() + "uuid:".length(), str.length());
        } else {
            throw new IllegalArgumentException();
        }
        return UUID.fromString(substring);
    }

    String b() {
        String a = c().a(com.getpebble.android.common.b.b.c.a.TIMELINE_SYNC_NEXT_URL, d());
        if (TextUtils.isEmpty(a)) {
            a = d();
        }
        return Uri.parse(a).buildUpon().appendQueryParameter("syncPinsPageSize", String.valueOf(200)).toString();
    }

    void e(String str) {
        f.d("TimelineWebSync", "setNextUrl(" + str + ")");
        c().b(com.getpebble.android.common.b.b.c.a.TIMELINE_SYNC_NEXT_URL, str);
    }

    com.getpebble.android.common.b.b.c c() {
        return PebbleApplication.y();
    }

    String d() {
        return Uri.parse(PebbleApplication.w().H()).buildUpon().appendQueryParameter("syncKey", String.valueOf(0)).build().toString();
    }

    void e(UUID uuid) {
        aw.e(f(), uuid);
        aw.c(f(), uuid);
    }

    private boolean a(c.b bVar, aw.d dVar, String str) {
        Long valueOf;
        g from = g.from(bVar.a);
        d webNotificationActions = d.getWebNotificationActions(str, dVar.g);
        aw.c cVar = dVar.b;
        if (bVar.b != null) {
            try {
                valueOf = Long.valueOf(c(bVar.b));
            } catch (Throwable e) {
                f.c("TimelineWebSync", "Error parsing notification timestamp: '" + bVar.b + "'", e);
            }
            if (valueOf == null) {
                valueOf = Long.valueOf(cVar.e);
            }
            return a(new aw.d(new aw.c(UUID.randomUUID(), cVar.a, aw.b.NOTIFICATION, 0, valueOf.longValue(), from.toJson(), webNotificationActions.toJson(), cVar.h, cVar.i, cVar.j, false, cVar.l, aw.c.a.EMPTY), dVar.c, dVar.d, dVar.h, dVar.g));
        }
        valueOf = null;
        if (valueOf == null) {
            valueOf = Long.valueOf(cVar.e);
        }
        return a(new aw.d(new aw.c(UUID.randomUUID(), cVar.a, aw.b.NOTIFICATION, 0, valueOf.longValue(), from.toJson(), webNotificationActions.toJson(), cVar.h, cVar.i, cVar.j, false, cVar.l, aw.c.a.EMPTY), dVar.c, dVar.d, dVar.h, dVar.g));
    }

    private boolean g(String str) {
        return str.startsWith("sandbox-");
    }

    private Context e() {
        return this.a;
    }

    private ContentResolver f() {
        return e().getContentResolver();
    }
}
