package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.l.b.ap;
import com.getpebble.android.framework.timeline.e;
import com.getpebble.android.framework.timeline.e.c;
import com.getpebble.android.framework.timeline.h;
import com.getpebble.android.h.ab;
import com.getpebble.android.h.p;
import com.google.b.l;
import com.google.b.o;
import com.google.b.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class d extends ai {
    public static final Uri a = com.getpebble.android.common.b.b.b.a("app_glances");

    public static class a implements com.getpebble.android.framework.g.e.b {
        public final UUID a;
        public final long b;
        public final b[] c;
        public final Integer d;
        public final Integer e;
        private final boolean f;
        private final boolean g;

        public a(UUID uuid, long j, b[] bVarArr) {
            this.a = uuid;
            this.b = j;
            if (bVarArr == null) {
                bVarArr = new b[0];
            }
            this.c = bVarArr;
            this.d = null;
            this.e = Integer.valueOf(b());
            this.f = false;
            this.g = false;
        }

        public a(Cursor cursor, boolean z, boolean z2) {
            this.a = UUID.fromString(cursor.getString(cursor.getColumnIndex("app_uuid")));
            this.b = cursor.getLong(cursor.getColumnIndex("creation_time_ms"));
            this.c = (b[]) p.a(cursor.getString(cursor.getColumnIndex("slices_json")), b[].class);
            String string = cursor.getString(cursor.getColumnIndex("record_hashcode"));
            if (string == null || string.equals("removed")) {
                this.e = null;
            } else {
                this.e = Integer.decode(string);
            }
            string = cursor.getString(cursor.getColumnIndex("pebble_sync_hashcode"));
            if (string == null || string.equals("removed")) {
                this.d = null;
            } else {
                this.d = Integer.decode(string);
            }
            this.f = z;
            this.g = z2;
        }

        public ContentValues a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_uuid", this.a.toString());
            contentValues.put("creation_time_ms", Long.valueOf(this.b));
            contentValues.put("slices_json", p.a(this.c));
            contentValues.put("record_hashcode", this.e == null ? "removed" : String.valueOf(this.e));
            return contentValues;
        }

        public int b() {
            return (((this.a.hashCode() * 31) + ((int) (this.b ^ (this.b >>> 32)))) * 31) + Arrays.hashCode(this.c);
        }

        public boolean a(ContentResolver contentResolver, boolean z, com.getpebble.android.common.framework.install.app.b.a aVar) {
            if (!z) {
                f.d("AppGlanceModel", "onPebbleSync: !success");
                return false;
            } else if (this.f || this.g) {
                boolean z2;
                ContentValues contentValues = new ContentValues(1);
                contentValues.put("pebble_sync_hashcode", this.g ? "removed" : String.valueOf(this.e));
                String str = "app_uuid = ?";
                if (contentResolver.update(d.a, contentValues, "app_uuid = ?", new String[]{this.a.toString()}) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                return z2;
            } else {
                f.b("AppGlanceModel", "onPebbleSync: does not need add or remove! " + this);
                return false;
            }
        }

        public boolean a(com.getpebble.android.common.framework.install.app.b.a aVar) {
            return this.f;
        }

        public boolean b(com.getpebble.android.common.framework.install.app.b.a aVar) {
            return this.g;
        }

        public byte[] c() {
            return com.getpebble.android.bluetooth.b.b.a(this.a);
        }

        public Integer d() {
            return this.e;
        }

        public byte[] a(com.getpebble.android.common.framework.install.app.b.a aVar, v vVar, z zVar) {
            return new com.getpebble.android.framework.l.b.a(new ap(), h.getMapper(com.getpebble.android.common.a.K(), vVar, zVar), zVar.getPlatformCode()).a(this);
        }

        public com.getpebble.android.framework.l.b.j.b e() {
            return com.getpebble.android.framework.l.b.j.b.APP_GLANCES;
        }

        public String toString() {
            return "Glance [uuid = " + this.a + ", created = " + this.b + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + this.c.length + " slices]";
        }

        public static a a(com.getpebble.android.common.model.timeline.a aVar) {
            try {
                UUID uuid = aVar.b;
                long toMillis = TimeUnit.SECONDS.toMillis(ab.b(aVar.a));
                com.getpebble.android.common.model.timeline.a.a[] aVarArr = aVar.c;
                b[] bVarArr = new b[aVarArr.length];
                for (int i = 0; i < aVarArr.length; i++) {
                    bVarArr[i] = new b(aVarArr[i]);
                }
                return new a(uuid, toMillis, bVarArr);
            } catch (Throwable e) {
                f.a("AppGlanceModel", "AppGlanceModel.Record.from(AppGlanceSliceCreateEvent): Invalid creation timestamp", e);
                return null;
            } catch (Throwable e2) {
                f.a("AppGlanceModel", "AppGlanceModel.Record.from(AppGlanceSliceCreateEvent): Invalid app UUID", e2);
                return null;
            }
        }
    }

    public static class b {
        public final e[] a;
        public final a b;

        public enum a {
            ICON_AND_SUBTITLE((byte) 0);
            
            public final byte serializedValue;

            private a(byte b) {
                this.serializedValue = b;
            }
        }

        public b(com.getpebble.android.common.model.timeline.a.a aVar) {
            this(a.ICON_AND_SUBTITLE, a(aVar.a, aVar.b));
        }

        public b(com.getpebble.android.framework.jskit.b.a aVar) {
            this(a.ICON_AND_SUBTITLE, a(aVar.a, aVar.b));
        }

        public b(a aVar, e[] eVarArr) {
            this.b = aVar;
            this.a = eVarArr;
        }

        private static e[] a(o oVar, String str) {
            Set<Entry> a = oVar.a();
            int size = a.size();
            if (str != null) {
                size++;
            }
            e[] eVarArr = new e[size];
            if (str != null) {
                size = 1;
                eVarArr[0] = new e(c.TIMESTAMP.getSerializedName(), new r(str));
            } else {
                size = 0;
            }
            int i = size;
            for (Entry entry : a) {
                int i2 = i + 1;
                eVarArr[i] = new e((String) entry.getKey(), (l) entry.getValue());
                i = i2;
            }
            return eVarArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (!Arrays.equals(this.a, bVar.a)) {
                return false;
            }
            if (this.b != bVar.b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.a) * 31) + this.b.hashCode();
        }
    }

    public d() {
        super("app_glances", false, false);
        com.getpebble.android.common.model.ai.a aVar = new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "app_uuid");
        aVar.a(true);
        addColumn(aVar);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "pebble_sync_hashcode"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "record_hashcode"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "slices_json"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "creation_time_ms"));
    }

    public static void a(ContentResolver contentResolver) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("record_hashcode", "removed");
        contentResolver.update(a, contentValues, "NOT EXISTS (SELECT 1 FROM locker_apps WHERE uuid = app_uuid)", null);
        String[] strArr = new String[]{"removed", "removed"};
        contentResolver.delete(a, "pebble_sync_hashcode = ? AND record_hashcode = ?", strArr);
    }

    public static int b(ContentResolver contentResolver) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("pebble_sync_hashcode", "removed");
        return contentResolver.update(a, contentValues, null, null);
    }

    public static List<com.getpebble.android.framework.g.e.b> c(ContentResolver contentResolver) {
        List<com.getpebble.android.framework.g.e.b> arrayList = new ArrayList();
        arrayList.addAll(a(contentResolver, "(record_hashcode != 'removed') AND (record_hashcode != pebble_sync_hashcode) AND EXISTS (SELECT 1 FROM locker_apps WHERE uuid = app_uuid AND pebble_sync_hashcode != 'removed')", null, true));
        arrayList.addAll(a(contentResolver, "(pebble_sync_hashcode != 'removed') AND ((record_hashcode = 'removed') OR NOT EXISTS (SELECT 1 FROM locker_apps WHERE uuid = app_uuid AND pebble_sync_hashcode != 'removed'))", null, false));
        return arrayList;
    }

    private static List<a> a(ContentResolver contentResolver, String str, String[] strArr, boolean z) {
        List<a> arrayList = new ArrayList();
        Cursor query = contentResolver.query(a, null, str, strArr, null);
        if (query == null) {
            f.b("AppGlanceModel", "getRecords: cursor is null!");
            return arrayList;
        }
        while (query.moveToNext()) {
            try {
                arrayList.add(new a(query, z, !z));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private static a a(ContentResolver contentResolver, UUID uuid) {
        List a = a(contentResolver, "app_uuid = ?", new String[]{uuid.toString()}, false);
        if (a.size() > 0) {
            return (a) a.get(0);
        }
        return null;
    }

    public static void a(a aVar, ContentResolver contentResolver) {
        ContentValues a = aVar.a();
        a.put("pebble_sync_hashcode", "removed");
        contentResolver.insert(a, a);
    }

    public static void b(a aVar, ContentResolver contentResolver) {
        String[] strArr = new String[]{aVar.a.toString()};
        ContentValues a = aVar.a();
        contentResolver.update(a, a, "app_uuid = ?", strArr);
    }

    public static void c(a aVar, ContentResolver contentResolver) {
        if (a(contentResolver, aVar.a) == null) {
            a(aVar, contentResolver);
        } else {
            b(aVar, contentResolver);
        }
    }

    public static void a(UUID uuid, b[] bVarArr, ContentResolver contentResolver) {
        a a = a(contentResolver, uuid);
        if (a == null) {
            a(new a(uuid, System.currentTimeMillis(), bVarArr), contentResolver);
        } else {
            b(new a(uuid, a.b, bVarArr), contentResolver);
        }
    }
}
