package com.getpebble.android.framework.k;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.CallLog.Calls;
import android.util.Pair;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.am.d;
import com.getpebble.android.common.model.an;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.common.model.aw.b;
import com.getpebble.android.framework.l.a.w;
import com.getpebble.android.framework.m.j;
import com.getpebble.android.framework.o.c;
import com.getpebble.android.framework.timeline.e;
import com.getpebble.android.framework.timeline.g;
import com.getpebble.android.h.ab;
import com.getpebble.android.h.v;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class a {
    private static final long a = TimeUnit.MINUTES.toMillis(3);
    private final ContentObserver b;
    private final ContentResolver c;

    public a(ContentResolver contentResolver, Looper looper) {
        this.c = contentResolver;
        this.b = new ContentObserver(this, new Handler(looper)) {
            final /* synthetic */ a a;

            public boolean deliverSelfNotifications() {
                return super.deliverSelfNotifications();
            }

            public void onChange(boolean z) {
                onChange(z, null);
            }

            public void onChange(boolean z, Uri uri) {
                f.d("MissedCallSync", "onChange() uri = " + uri);
                this.a.a();
            }
        };
        this.c.registerContentObserver(Calls.CONTENT_URI, false, this.b);
        a();
    }

    private void a() {
        if (v.a(com.getpebble.android.h.v.a.TELEPHONE)) {
            String[] strArr = new String[]{"type", an.NUMBER, "name", "date", "duration"};
            String str = "type = ? AND date > ?";
            long windowStartUtcMs = b.PIN.getWindowStartUtcMs(System.currentTimeMillis());
            try {
                Cursor query = this.c.query(Calls.CONTENT_URI, strArr, "type = ? AND date > ?", new String[]{String.valueOf(3), String.valueOf(windowStartUtcMs)}, null);
                if (query == null) {
                    f.b("MissedCallSync", "Cursor is null");
                    return;
                }
                try {
                    Resources resources = com.getpebble.android.common.a.K().getResources();
                    while (query.moveToNext()) {
                        Pair a = c.a(query.getString(query.getColumnIndex("name")), query.getString(query.getColumnIndex(an.NUMBER)), resources);
                        String str2 = (String) a.first;
                        String str3 = (String) a.second;
                        long j = query.getLong(query.getColumnIndex("date"));
                        long j2 = query.getLong(query.getColumnIndex("duration"));
                        if (aw.a(this.c, d.MISSED_CALLS.getUuid(), j).isEmpty()) {
                            f.d("MissedCallSync", "Existing record not found; inserting...");
                            aw.c cVar = new aw.c(UUID.randomUUID(), d.MISSED_CALLS.getUuid(), b.PIN, ab.b(j2), j, new g(g.GENERIC_PIN, new com.getpebble.android.framework.timeline.f().add(e.c.TITLE_KEY, resources.getString(R.string.timeline_title_missed_call)).add(e.c.TINY_ICON, e.b.TIMELINE_MISSED_CALL).add(e.c.SUBTITLE_KEY, str2).add(e.c.BODY_KEY, resources.getString(R.string.timeline_body_missed_call) + str3)).toJson(), com.getpebble.android.framework.timeline.d.getMissedCallPinActions().toJson(), false, true, false, false, false, com.getpebble.android.common.model.aw.c.a.EMPTY);
                            aw.d dVar = new aw.d(cVar, j, j, aw.e.PHONE_CALL, d.MISSED_CALLS.getUuid());
                            aw.a(this.c, dVar);
                            if (com.getpebble.android.notifications.b.b.a()) {
                                if ((System.currentTimeMillis() - j > a ? 1 : null) != null) {
                                    f.d("MissedCallSync", "Missed call is stale; not generating notification");
                                } else {
                                    aw.a(this.c, new aw.d(new aw.c(UUID.randomUUID(), cVar.a, b.NOTIFICATION, 0, dVar.c, new g(g.GENERIC_NOTIFICATION, new com.getpebble.android.framework.timeline.f().add(e.c.TITLE_KEY, resources.getString(R.string.timeline_title_missed_call)).add(e.c.BODY_KEY, str2).add(e.c.TINY_ICON, e.b.TIMELINE_MISSED_CALL)).toJson(), com.getpebble.android.framework.timeline.d.getMissedCallNotificationActions().toJson(), cVar.h, cVar.i, cVar.j, false, cVar.l, com.getpebble.android.common.model.aw.c.a.EMPTY), dVar.c, dVar.d, dVar.h, d.MISSED_CALLS.getUuid()));
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    return;
                } finally {
                    query.close();
                }
            } catch (Throwable e) {
                f.a("MissedCallSync", "processMissedCalls: error querying database", e);
                return;
            }
        }
        v.a("MissedCallSync", com.getpebble.android.h.v.a.TELEPHONE, "processMissedCalls");
    }

    private static String a(long j, ContentResolver contentResolver) {
        String str = null;
        if (v.a(com.getpebble.android.h.v.a.TELEPHONE)) {
            String str2 = "type IN (?, ?) AND date = ?";
            ContentResolver contentResolver2 = contentResolver;
            Cursor query = contentResolver2.query(Calls.CONTENT_URI, new String[]{an.NUMBER}, "type IN (?, ?) AND date = ?", new String[]{String.valueOf(3), String.valueOf(1), String.valueOf(j)}, str);
            if (query == null) {
                f.b("MissedCallSync", "getNumberFromMissedCallDb: cursor is null");
            } else {
                try {
                    if (query.moveToNext()) {
                        str = query.getString(query.getColumnIndex(an.NUMBER));
                        query.close();
                    } else {
                        f.d("MissedCallSync", "getNumberFromMissedCallDb: Number not found for missed call @ " + j);
                    }
                } finally {
                    query.close();
                }
            }
        } else {
            v.a("MissedCallSync", com.getpebble.android.h.v.a.TELEPHONE, "getNumberFromMissedCallDb");
        }
        return str;
    }

    public static void a(w wVar, aw.c cVar, ContentResolver contentResolver, final com.getpebble.android.framework.g.ag.a aVar) {
        Map e = wVar.e();
        if (e == null) {
            f.b("MissedCallSync", "processSmsAction() attributes is null");
            aVar.a(false, null, null);
            return;
        }
        String str = (String) e.get(e.c.TITLE_KEY.getSerializedName());
        if (str == null) {
            f.b("MissedCallSync", "processSmsAction() reply is null");
            aVar.a(false, null, null);
            return;
        }
        String a = a(cVar.e, contentResolver);
        if (a == null) {
            f.b("MissedCallSync", "processSmsAction() could not fetch number");
            aVar.a(false, null, null);
            return;
        }
        j.a(str, a, new j.e() {
            public void b() {
                com.getpebble.android.framework.timeline.f fVar = new com.getpebble.android.framework.timeline.f();
                fVar.add(e.c.SUBTITLE_KEY, com.getpebble.android.common.a.K().getString(R.string.action_sent));
                fVar.add(e.c.LARGE_ICON, e.b.ACTION_RESULT_SENT);
                aVar.a(true, fVar, null);
            }

            public void a() {
                aVar.a(false, null, null);
            }
        });
    }

    public static boolean a(aw.c cVar, Context context, com.getpebble.android.framework.g.ag.a aVar) {
        String a = a(cVar.e, context.getContentResolver());
        if (a == null) {
            f.b("MissedCallSync", "processCallAction: null number");
            aVar.a(false, null, null);
            return false;
        }
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + a));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Throwable e) {
            f.a("MissedCallSync", "processCallAction: could not start call for " + a, e);
            return false;
        }
    }
}
