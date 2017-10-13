package com.getpebble.android.framework.d;

import android.content.ContentValues;
import android.database.Cursor;
import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.l.a.k;
import com.getpebble.android.framework.l.a.k.g;
import com.getpebble.android.framework.pebblekit.a;
import com.google.a.f.e;
import java.nio.ByteBuffer;

public class c {
    private final d a;
    private final int b;
    private final com.getpebble.android.framework.l.a.k.c c;
    private final b d;
    private final a e;

    c(d dVar, com.getpebble.android.framework.l.a.k.c cVar, b bVar, a aVar, int i) {
        if (bVar == null) {
            throw new IllegalArgumentException("database cannot be null");
        } else if (dVar == null) {
            throw new IllegalArgumentException("session cannot be null");
        } else if (cVar == null) {
            throw new IllegalArgumentException("item cannot be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("pebbleKit cannot be null");
        } else {
            this.a = dVar;
            this.b = i;
            this.c = cVar;
            this.d = bVar;
            this.e = aVar;
            f.e("DataloggingItem", "DataloggingItem() from message: session = " + this.a.i() + " dataId = " + this.b + " size = " + dVar.j());
            this.d.a(this);
        }
    }

    private static e a(byte[] bArr, d dVar) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        switch (dVar.j().intValue()) {
            case 1:
                return b.a(wrap);
            case 2:
                return b.b(wrap);
            default:
                return b.c(wrap);
        }
    }

    private static int b(byte[] bArr, d dVar) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        switch (dVar.j().intValue()) {
            case 1:
                return wrap.get();
            case 2:
                return wrap.getShort();
            default:
                return wrap.getInt();
        }
    }

    c(Cursor cursor, d dVar, b bVar, a aVar) {
        if (cursor == null) {
            throw new IllegalArgumentException("cursor cannot be null");
        } else if (dVar == null) {
            throw new IllegalArgumentException("session cannot be null");
        } else if (bVar == null) {
            throw new IllegalArgumentException("database cannot be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("pebbleKit cannot be null");
        } else {
            this.a = dVar;
            this.d = bVar;
            this.e = aVar;
            this.b = cursor.getInt(cursor.getColumnIndex("data_id"));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("data_object"));
            switch (dVar.k()) {
                case BYTE_ARRAY:
                    this.c = new k.a(blob);
                    return;
                case UNSIGNED_INTEGER:
                    this.c = new g(a(blob, this.a), this.a.j());
                    return;
                case SIGNED_INTEGER:
                    this.c = new k.f(b(blob, this.a), this.a.j());
                    return;
                default:
                    f.b("DataloggingItem", "unknown datatype: " + dVar.k());
                    this.c = null;
                    return;
            }
        }
    }

    void a() {
        this.d.b(this);
    }

    void b() {
        this.e.a(this);
    }

    public d c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public com.getpebble.android.framework.l.a.k.c e() {
        return this.c;
    }

    ContentValues f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("local_session_uuid", this.a.e().toString());
        contentValues.put("data_id", Integer.valueOf(this.b));
        contentValues.put("data_object", this.c.a());
        return contentValues;
    }
}
