package com.getpebble.android.mms;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.framework.timeline.e;
import java.util.ArrayList;
import java.util.List;

public class a implements com.getpebble.android.mms.b.a {
    private ContentResolver a;

    private static class a {
        public List<String> a = new ArrayList();
        public int b = 0;
        public boolean c;
        public boolean d;

        protected void a(String str) {
            this.a.add(str);
        }

        public void a() {
            this.b++;
        }

        public int b() {
            return this.b;
        }
    }

    public a(Context context) {
        this.a = context.getContentResolver();
    }

    public int a() {
        Cursor query;
        Throwable e;
        try {
            int i;
            query = this.a.query(com.getpebble.android.mms.j.a.a, new String[]{ai.COLUMN_ID}, "msg_box = ?", new String[]{String.valueOf(1)}, "_id DESC");
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        i = query.getInt(query.getColumnIndex(ai.COLUMN_ID));
                        if (query != null) {
                            return i;
                        }
                        query.close();
                        return i;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        f.a("AndroidMms", "getLatestId(): Some error occurred retrieving latest mms: ", e);
                        if (query != null) {
                            return 0;
                        }
                        query.close();
                        return 0;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            i = 0;
            if (query != null) {
                return i;
            }
            query.close();
            return i;
        } catch (Exception e3) {
            e = e3;
            query = null;
            f.a("AndroidMms", "getLatestId(): Some error occurred retrieving latest mms: ", e);
            if (query != null) {
                return 0;
            }
            query.close();
            return 0;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    public List<Mms> a(int i) {
        try {
            return a(this.a.query(com.getpebble.android.mms.j.a.a, new String[]{ai.COLUMN_ID, "sub", "m_type"}, "msg_box = ? AND _id > ? ", new String[]{String.valueOf(1), String.valueOf(i)}, "_id DESC"));
        } catch (Throwable e) {
            f.a("AndroidMms", "parseMmsWithIdGreaterThan(): Some error occurred retrieving mms with id greater than  " + i, e);
            return new ArrayList();
        }
    }

    public List<Mms> a(List<Integer> list) {
        try {
            return a(this.a.query(com.getpebble.android.mms.j.a.a, new String[]{ai.COLUMN_ID, "sub", "m_type"}, "msg_box = ? AND _id IN (" + TextUtils.join(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR, list) + ")", new String[]{String.valueOf(1)}, "_id DESC"));
        } catch (Throwable e) {
            f.a("AndroidMms", "parseMmsWithIds(): Some error occurred retrieving mms ids: " + list, e);
            return new ArrayList();
        }
    }

    protected List<Mms> a(Cursor cursor) {
        List arrayList = new ArrayList();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    arrayList.add(b(cursor));
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
        return arrayList;
    }

    private Mms b(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("sub"));
        int i = cursor.getInt(cursor.getColumnIndex(ai.COLUMN_ID));
        boolean c = c(cursor);
        List d = d(String.valueOf(i));
        String c2 = c(String.valueOf(i));
        a a = a(String.valueOf(i));
        return new com.getpebble.android.mms.Mms.a().b(i).c(c).a(a.b()).a(string).a(a.a).a(a.c).b(a.d).b(d).b(c2).a();
    }

    private boolean c(Cursor cursor) {
        return Integer.parseInt(cursor.getString(cursor.getColumnIndex("m_type"))) != 128;
    }

    private a a(String str) {
        Cursor query = this.a.query(com.getpebble.android.mms.j.a.a.a, new String[]{ai.COLUMN_ID, "mid", "cid", "ct", "text", "_data"}, "mid = ? ", new String[]{str}, "_id DESC");
        a aVar = new a();
        if (query == null) {
            f.a("AndroidMms", "Parts query returned nothing!");
        } else {
            while (query.moveToNext()) {
                try {
                    String string = query.getString(query.getColumnIndex("ct"));
                    String string2 = query.getString(query.getColumnIndex("cid"));
                    f.d("AndroidMms", "Content-Type: " + string);
                    if (g.b(string)) {
                        Object b;
                        if (query.getString(query.getColumnIndex("_data")) != null) {
                            b = b(string2);
                        } else {
                            b = d(query);
                        }
                        if (!TextUtils.isEmpty(b)) {
                            aVar.a(b);
                        }
                        f.d("AndroidMms", "ContentType Plaintext string is null or empty for partId: " + str);
                    } else if (g.a(string)) {
                        aVar.a();
                    } else if (g.d(string)) {
                        aVar.d = true;
                    } else if (g.c(string)) {
                        aVar.c = true;
                    } else {
                        f.c("AndroidMms", "Unknown content-type: " + string);
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(java.lang.String r7) {
        /*
        r6 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = com.getpebble.android.mms.j.a.a.a;
        r0 = r0.append(r1);
        r1 = "/";
        r0 = r0.append(r1);
        r0 = r0.append(r7);
        r0 = r0.toString();
        r1 = android.net.Uri.parse(r0);
        r0 = 0;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r6.a;	 Catch:{ IOException -> 0x004f, all -> 0x0070 }
        r0 = r3.openInputStream(r1);	 Catch:{ IOException -> 0x004f, all -> 0x0070 }
        if (r0 == 0) goto L_0x0045;
    L_0x002b:
        r3 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x004f }
        r1 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x004f }
        r4 = "UTF-8";
        r1.<init>(r0, r4);	 Catch:{ IOException -> 0x004f }
        r3.<init>(r1);	 Catch:{ IOException -> 0x004f }
        r1 = r3.readLine();	 Catch:{ IOException -> 0x004f }
    L_0x003b:
        if (r1 == 0) goto L_0x0045;
    L_0x003d:
        r2.append(r1);	 Catch:{ IOException -> 0x004f }
        r1 = r3.readLine();	 Catch:{ IOException -> 0x004f }
        goto L_0x003b;
    L_0x0045:
        if (r0 == 0) goto L_0x004a;
    L_0x0047:
        r0.close();	 Catch:{ IOException -> 0x007a }
    L_0x004a:
        r0 = r2.toString();
        return r0;
    L_0x004f:
        r1 = move-exception;
        r1 = "AndroidMms";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007e }
        r3.<init>();	 Catch:{ all -> 0x007e }
        r4 = "getMessageFromPart() Failed to load _data from partId: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x007e }
        r3 = r3.append(r7);	 Catch:{ all -> 0x007e }
        r3 = r3.toString();	 Catch:{ all -> 0x007e }
        com.getpebble.android.common.b.a.f.d(r1, r3);	 Catch:{ all -> 0x007e }
        if (r0 == 0) goto L_0x004a;
    L_0x006a:
        r0.close();	 Catch:{ IOException -> 0x006e }
        goto L_0x004a;
    L_0x006e:
        r0 = move-exception;
        goto L_0x004a;
    L_0x0070:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x0074:
        if (r1 == 0) goto L_0x0079;
    L_0x0076:
        r1.close();	 Catch:{ IOException -> 0x007c }
    L_0x0079:
        throw r0;
    L_0x007a:
        r0 = move-exception;
        goto L_0x004a;
    L_0x007c:
        r1 = move-exception;
        goto L_0x0079;
    L_0x007e:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0074;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.mms.a.b(java.lang.String):java.lang.String");
    }

    private String d(Cursor cursor) {
        try {
            return cursor.getString(cursor.getColumnIndex("text"));
        } catch (Exception e) {
            return null;
        }
    }

    private String c(String str) {
        Uri build = com.getpebble.android.mms.j.a.a.buildUpon().appendPath(str).appendPath("addr").build();
        Cursor query = this.a.query(build, new String[]{ai.COLUMN_ID, "type", ak.ADDRESS}, "type = ? ", new String[]{String.valueOf(137)}, "_id DESC");
        String str2 = null;
        if (query == null) {
            try {
                f.d("AndroidMms", "No addresses found at content uri: " + build + ". Where type is " + String.valueOf(151));
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        } else {
            while (query.moveToNext()) {
                str2 = query.getString(query.getColumnIndex(ak.ADDRESS));
            }
            if (query != null) {
                query.close();
            }
        }
        return str2;
    }

    private List<String> d(String str) {
        Uri build = com.getpebble.android.mms.j.a.a.buildUpon().appendPath(str).appendPath("addr").build();
        Cursor query = this.a.query(build, new String[]{ai.COLUMN_ID, "type", ak.ADDRESS}, "type = ? ", new String[]{String.valueOf(151)}, "_id DESC");
        List<String> arrayList = new ArrayList();
        if (query == null) {
            try {
                f.d("AndroidMms", "No addresses found at content uri: " + build + ". Where type is " + String.valueOf(151));
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        } else {
            while (query.moveToNext()) {
                arrayList.add(query.getString(query.getColumnIndex(ak.ADDRESS)));
            }
            if (query != null) {
                query.close();
            }
        }
        return arrayList;
    }
}
