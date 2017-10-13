package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.framework.timeline.e;
import com.getpebble.android.h.aa;
import com.getpebble.android.h.i;
import com.getpebble.android.h.x;
import com.google.a.b.ad;
import java.io.PrintStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class av extends ai {
    public static final Uri a = b.a("timeline_mapper");
    private static final String[] b = new String[]{"fw_version_timestamp"};
    private static final Map<String, com.getpebble.android.common.model.ai.a.a> c = new com.google.a.b.af.a().a("fw_version_tag", com.getpebble.android.common.model.ai.a.a.STRING).a("fw_version_timestamp", com.getpebble.android.common.model.ai.a.a.INTEGER).a(ak.HW_PLATFORM, com.getpebble.android.common.model.ai.a.a.INTEGER).a("mapper_json", com.getpebble.android.common.model.ai.a.a.STRING).a("needs_fetch", com.getpebble.android.common.model.ai.a.a.INTEGER).a();

    public static class a {
        public final v a;
        public final z b;
        public final String c;
        public final boolean d;

        public a(v vVar, z zVar, String str, boolean z) {
            this.a = vVar;
            this.b = zVar;
            this.c = str;
            this.d = z;
        }

        public static a a(v vVar, z zVar, String str) {
            return new a(vVar, zVar, str, false);
        }

        public String a() {
            return av.b(this.b.getName(), this.a.getVersionTag());
        }

        public static a a(Cursor cursor) {
            return new a(new v(cursor.getString(cursor.getColumnIndex("fw_version_tag")), cursor.getLong(cursor.getColumnIndex("fw_version_timestamp"))), l.a(cursor.getString(cursor.getColumnIndex(ak.HW_PLATFORM))), cursor.getString(cursor.getColumnIndex("mapper_json")), cursor.getInt(cursor.getColumnIndex("needs_fetch")) > 0);
        }

        public ContentValues b() {
            ContentValues contentValues = new ContentValues(av.c.size());
            contentValues.put("fw_version_tag", this.a.getVersionTag());
            contentValues.put("fw_version_timestamp", Long.valueOf(this.a.getTimestamp()));
            contentValues.put(ak.HW_PLATFORM, this.b.getName());
            contentValues.put("mapper_json", this.c);
            contentValues.put("needs_fetch", Integer.valueOf(this.d ? 1 : 0));
            return contentValues;
        }

        public String toString() {
            return "Record{firmwareVersion=" + this.a + ", hardwarePlatform=" + this.b + ", mapperJson='" + this.c + '\'' + ", isFetchNeeded=" + this.d + '}';
        }
    }

    public av() {
        super("timeline_mapper");
        for (Entry entry : c.entrySet()) {
            addColumn(new com.getpebble.android.common.model.ai.a((com.getpebble.android.common.model.ai.a.a) entry.getValue(), (String) entry.getKey()));
        }
    }

    public static void a(ContentResolver contentResolver, a aVar) {
        String b = x.b(ad.a((Object) "fw_version_tag", ak.HW_PLATFORM));
        String[] strArr = new String[]{aVar.a.getVersionTag(), aVar.b.getName()};
        if (a(contentResolver, b, strArr)) {
            contentResolver.update(a, aVar.b(), b, strArr);
        } else {
            contentResolver.insert(a, aVar.b());
        }
    }

    public static void a(ContentResolver contentResolver, z zVar, v vVar) {
        f.d("TimelineMapperModel", "request(" + zVar.getName() + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + vVar.getVersionTag() + ")");
        if (!a(contentResolver, x.b(ad.a((Object) "fw_version_tag", ak.HW_PLATFORM)), new String[]{vVar.getVersionTag(), zVar.getName()})) {
            f.d("TimelineMapperModel", "No entry found");
            contentResolver.insert(a, new a(vVar, zVar, null, true).b());
        } else if (a(contentResolver).isEmpty()) {
            f.d("TimelineMapperModel", "No records to fetch; not sync'ing");
            return;
        }
        PebbleApplication.v().g();
    }

    public static Collection<a> a(ContentResolver contentResolver) {
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, aa.a(c.keySet()), x.b(ad.a((Object) "needs_fetch")), new String[]{String.valueOf(1)}, null);
        Collection<a> linkedList = new LinkedList();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    linkedList.add(a.a(query));
                } finally {
                    query.close();
                }
            }
        }
        return linkedList;
    }

    public static String b(ContentResolver contentResolver, z zVar, v vVar) {
        String[] strArr = new String[]{"mapper_json"};
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, strArr, x.b(ad.a((Object) "fw_version_tag", ak.HW_PLATFORM)) + " AND needs_fetch != ?", new String[]{vVar.getVersionTag(), zVar.getName(), String.valueOf(1)}, null);
        if (query == null) {
            throw new IllegalStateException("Null cursor");
        }
        try {
            if (query.moveToFirst()) {
                String string = query.getString(query.getColumnIndex("mapper_json"));
                return string;
            }
            throw new IllegalStateException("No entry for FW, HW combination");
        } finally {
            query.close();
        }
    }

    private static boolean a(ContentResolver contentResolver, String str, String[] strArr) {
        Cursor query = contentResolver.query(a, aa.a(c.keySet()), str, strArr, null);
        boolean z = false;
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    z = true;
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        return z;
    }

    private static String b(String str, String str2) {
        return Uri.parse("http://pebblefw.s3.amazonaws.com/pebble/").buildUpon().appendPath(str).appendPath("release-v3").appendPath("layouts").appendPath(str2 + "_layouts.json").build().toString();
    }

    public static void a(ContentResolver contentResolver, PrintStream printStream) {
        ContentResolver contentResolver2 = contentResolver;
        PrintStream printStream2 = printStream;
        i.a(contentResolver2, printStream2, a, "hw_platform ASC, fw_version_tag ASC", new String[0], b);
    }
}
