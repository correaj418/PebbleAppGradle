package com.getpebble.android.framework.d;

import android.content.ContentValues;
import android.database.Cursor;
import com.getpebble.android.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.analytics.WatchAnalytics;
import com.getpebble.android.framework.l.a.k;
import com.getpebble.android.framework.l.a.k.c;
import com.getpebble.android.framework.pebblekit.a;
import com.google.a.f.e;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class d {
    private final e a;
    private final UUID b;
    private final e c;
    private final e d;
    private final com.getpebble.android.framework.l.a.k.d e;
    private final e f;
    private final UUID g;
    private boolean h;
    private int i;
    private final b j;
    private final a k;

    d(k kVar, b bVar, a aVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("database cannot be null");
        } else if (kVar == null) {
            throw new IllegalArgumentException("message cannot be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("pebbleKit cannot be null");
        } else {
            this.a = kVar.d();
            this.b = kVar.e();
            this.c = kVar.f();
            this.d = kVar.g();
            this.e = kVar.h();
            this.f = kVar.i();
            this.g = UUID.randomUUID();
            this.h = false;
            this.j = bVar;
            this.k = aVar;
            this.i = 1;
            a("DataloggingSession() from message");
            this.j.b(this);
        }
    }

    d(Cursor cursor, b bVar, a aVar) {
        boolean z = true;
        if (bVar == null) {
            throw new IllegalArgumentException("database cannot be null");
        } else if (cursor == null) {
            throw new IllegalArgumentException("cursor cannot be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("pebbleKit cannot be null");
        } else {
            this.a = e.a(cursor.getLong(cursor.getColumnIndex("session_id")));
            this.b = UUID.fromString(cursor.getString(cursor.getColumnIndex("uuid")));
            this.c = e.a(cursor.getLong(cursor.getColumnIndex("timestamp")));
            this.d = e.a(cursor.getLong(cursor.getColumnIndex("app_log_tag")));
            this.e = com.getpebble.android.framework.l.a.k.d.fromCode((byte) cursor.getInt(cursor.getColumnIndex("data_type")));
            this.f = e.a(cursor.getLong(cursor.getColumnIndex("item_size")));
            this.g = UUID.fromString(cursor.getString(cursor.getColumnIndex("local_session_uuid")));
            if (cursor.getInt(cursor.getColumnIndex("is_finished")) != 1) {
                z = false;
            }
            this.h = z;
            this.i = cursor.getInt(cursor.getColumnIndex("next_data_id_sequence"));
            this.j = bVar;
            this.k = aVar;
            a("DataloggingSession() from cursor");
        }
    }

    void a() {
        a("close()");
        this.h = true;
        n();
        b();
    }

    boolean b() {
        if (!this.h || this.j.a(this).size() != 0) {
            return false;
        }
        a("Session complete (empty + no items)");
        this.k.a(this);
        return true;
    }

    List<c> a(List<c> list) {
        a("addData() size = " + list.size());
        List<c> linkedList = new LinkedList();
        if (b.a() == b.a.OFF && f().equals(WatchAnalytics.a)) {
            a("Ignoring watch analytics message");
            return linkedList;
        }
        Object obj = null;
        for (c cVar : list) {
            int l = l();
            if (l >= 2147478647) {
                obj = 1;
            }
            linkedList.add(a(cVar, l));
        }
        if (obj != null) {
            a("Session reached max data item sequence; closing");
            a();
        }
        return linkedList;
    }

    protected c a(c cVar, int i) {
        return new c(this, cVar, this.j, this.k, i);
    }

    void a(int i) {
        a("ackItem() dataId = " + i);
        c a = this.j.a(this, i);
        if (a == null) {
            a("ackItem() item not found with dataId = " + i);
            return;
        }
        a.a();
        b();
    }

    void c() {
        a("broadcastData()");
        for (c b : this.j.a(this)) {
            b.b();
        }
    }

    private void n() {
        this.j.c(this);
    }

    ContentValues d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", Long.valueOf(this.a.longValue()));
        contentValues.put("uuid", this.b.toString());
        contentValues.put("timestamp", Long.valueOf(this.c.longValue()));
        contentValues.put("app_log_tag", Long.valueOf(this.d.longValue()));
        contentValues.put("data_type", Integer.valueOf(this.e.getCode()));
        contentValues.put("item_size", Long.valueOf(this.f.longValue()));
        contentValues.put("local_session_uuid", this.g.toString());
        contentValues.put("is_finished", Integer.valueOf(this.h ? 1 : 0));
        contentValues.put("next_data_id_sequence", Integer.valueOf(this.i));
        return contentValues;
    }

    public UUID e() {
        return this.g;
    }

    public UUID f() {
        return this.b;
    }

    public e g() {
        return this.c;
    }

    public e h() {
        return this.d;
    }

    e i() {
        return this.a;
    }

    e j() {
        return this.f;
    }

    public com.getpebble.android.framework.l.a.k.d k() {
        return this.e;
    }

    int l() {
        int i = this.i;
        this.i = i + 1;
        n();
        return i;
    }

    boolean m() {
        return this.h;
    }

    boolean a(k kVar) {
        if (!i().equals(kVar.d())) {
            a("session id mismatch: " + i() + " != " + kVar.d());
            return false;
        } else if (!f().equals(kVar.e())) {
            a("app uuid mismatch: " + f() + " != " + kVar.e());
            return false;
        } else if (!g().equals(kVar.f())) {
            a("timestamp mismatch: " + g() + " != " + kVar.f());
            return false;
        } else if (!h().equals(kVar.g())) {
            a("app log tag mismatch: " + h() + " != " + kVar.g());
            return false;
        } else if (!k().equals(kVar.h())) {
            a("data type mismatch: " + k() + " != " + kVar.h());
            return false;
        } else if (j().equals(kVar.i())) {
            return true;
        } else {
            a("item size mismatch: " + j() + " != " + kVar.i());
            return false;
        }
    }

    public String toString() {
        return "[sessionId = " + i() + "; appUuid = " + f() + "; timestamp = " + g() + "; appLogTag = " + h() + "; dataType = " + k() + "; itemSize = " + j() + "; localSessionUuid = " + e() + "; isFinished = " + m();
    }

    private void a(String str) {
        f.d("DataloggingSession", i() + " / " + e() + ": " + str + " app log tag: " + h());
    }
}
