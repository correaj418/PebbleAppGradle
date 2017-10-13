package com.getpebble.android.framework.o;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class d {

    public enum a {
        ERROR(0, ".error", "unknown"),
        FIRMWARE(1, ".pbz", "tmp_firmware"),
        APP(2, ".pbw", "tmp_app_bundle_localdl"),
        LANGUAGE(3, ".pbl", "tmp_lang_bundle_localdl"),
        HEALTH_DB(4, ".pbhdb", "health_db");
        
        private final int code;
        private final String fileExtension;
        private final String tempFileBaseName;

        private a(int i, String str, String str2) {
            this.code = i;
            this.fileExtension = str;
            this.tempFileBaseName = str2;
        }

        public static a from(int i) {
            for (a aVar : values()) {
                if (aVar.code == i) {
                    return aVar;
                }
            }
            return ERROR;
        }

        public int code() {
            return this.code;
        }

        public static a from(String str) {
            for (a aVar : values()) {
                if (str.endsWith(aVar.fileExtension)) {
                    return aVar;
                }
            }
            return ERROR;
        }

        public String getFileExtension() {
            return this.fileExtension;
        }
    }

    public static Uri a(Activity activity, Uri uri, a aVar) {
        return !a(uri) ? uri : Uri.fromFile(a((Context) activity, uri, aVar));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File a(android.content.Context r8, android.net.Uri r9, com.getpebble.android.framework.o.d.a r10) {
        /*
        r1 = 0;
        r0 = r8.getContentResolver();	 Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0083, all -> 0x00b0 }
        r3 = r0.openInputStream(r9);	 Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0083, all -> 0x00b0 }
        r0 = r8.getCacheDir();	 Catch:{ FileNotFoundException -> 0x00eb, IOException -> 0x00e2, all -> 0x00dd }
        r2 = r10.tempFileBaseName;	 Catch:{ FileNotFoundException -> 0x00eb, IOException -> 0x00e2, all -> 0x00dd }
        r4 = r10.fileExtension;	 Catch:{ FileNotFoundException -> 0x00eb, IOException -> 0x00e2, all -> 0x00dd }
        r2 = java.io.File.createTempFile(r2, r4, r0);	 Catch:{ FileNotFoundException -> 0x00eb, IOException -> 0x00e2, all -> 0x00dd }
        r4 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e6, all -> 0x00dd }
        r4.<init>(r2);	 Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00e6, all -> 0x00dd }
        c.a.a.a.e.a(r3, r4);	 Catch:{ FileNotFoundException -> 0x00f4, IOException -> 0x00e9 }
        if (r4 == 0) goto L_0x0029;
    L_0x0023:
        r4.flush();	 Catch:{ IOException -> 0x0032 }
        r4.close();	 Catch:{ IOException -> 0x0032 }
    L_0x0029:
        if (r3 == 0) goto L_0x002e;
    L_0x002b:
        r3.close();	 Catch:{ IOException -> 0x003b }
    L_0x002e:
        r0 = r2;
    L_0x002f:
        if (r0 == 0) goto L_0x00d3;
    L_0x0031:
        return r0;
    L_0x0032:
        r0 = move-exception;
        r4 = "SideloadingUtils";
        r5 = "ioe";
        com.getpebble.android.common.b.a.f.b(r4, r5, r0);
        goto L_0x0029;
    L_0x003b:
        r0 = move-exception;
        r3 = "SideloadingUtils";
        r4 = "ioe";
        com.getpebble.android.common.b.a.f.b(r3, r4, r0);
        r0 = r2;
        goto L_0x002f;
    L_0x0045:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
        r4 = r1;
    L_0x0049:
        r5 = "SideloadingUtils";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e0 }
        r6.<init>();	 Catch:{ all -> 0x00e0 }
        r7 = "Could not download bundle cause couldn't find=";
        r6 = r6.append(r7);	 Catch:{ all -> 0x00e0 }
        r6 = r6.append(r2);	 Catch:{ all -> 0x00e0 }
        r6 = r6.toString();	 Catch:{ all -> 0x00e0 }
        com.getpebble.android.common.b.a.f.b(r5, r6, r0);	 Catch:{ all -> 0x00e0 }
        if (r4 == 0) goto L_0x0069;
    L_0x0063:
        r4.flush();	 Catch:{ IOException -> 0x0070 }
        r4.close();	 Catch:{ IOException -> 0x0070 }
    L_0x0069:
        if (r3 == 0) goto L_0x006e;
    L_0x006b:
        r3.close();	 Catch:{ IOException -> 0x0079 }
    L_0x006e:
        r0 = r2;
        goto L_0x002f;
    L_0x0070:
        r0 = move-exception;
        r4 = "SideloadingUtils";
        r5 = "ioe";
        com.getpebble.android.common.b.a.f.b(r4, r5, r0);
        goto L_0x0069;
    L_0x0079:
        r0 = move-exception;
        r3 = "SideloadingUtils";
        r4 = "ioe";
        com.getpebble.android.common.b.a.f.b(r3, r4, r0);
        r0 = r2;
        goto L_0x002f;
    L_0x0083:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
        r4 = r1;
    L_0x0087:
        r5 = "SideloadingUtils";
        r6 = "Could not download bundle IO issue.";
        com.getpebble.android.common.b.a.f.b(r5, r6, r0);	 Catch:{ all -> 0x00e0 }
        if (r4 == 0) goto L_0x0096;
    L_0x0090:
        r4.flush();	 Catch:{ IOException -> 0x009d }
        r4.close();	 Catch:{ IOException -> 0x009d }
    L_0x0096:
        if (r3 == 0) goto L_0x009b;
    L_0x0098:
        r3.close();	 Catch:{ IOException -> 0x00a6 }
    L_0x009b:
        r0 = r2;
        goto L_0x002f;
    L_0x009d:
        r0 = move-exception;
        r4 = "SideloadingUtils";
        r5 = "ioe";
        com.getpebble.android.common.b.a.f.b(r4, r5, r0);
        goto L_0x0096;
    L_0x00a6:
        r0 = move-exception;
        r3 = "SideloadingUtils";
        r4 = "ioe";
        com.getpebble.android.common.b.a.f.b(r3, r4, r0);
        r0 = r2;
        goto L_0x002f;
    L_0x00b0:
        r0 = move-exception;
        r3 = r1;
        r4 = r1;
    L_0x00b3:
        if (r4 == 0) goto L_0x00bb;
    L_0x00b5:
        r4.flush();	 Catch:{ IOException -> 0x00c1 }
        r4.close();	 Catch:{ IOException -> 0x00c1 }
    L_0x00bb:
        if (r3 == 0) goto L_0x00c0;
    L_0x00bd:
        r3.close();	 Catch:{ IOException -> 0x00ca }
    L_0x00c0:
        throw r0;
    L_0x00c1:
        r1 = move-exception;
        r2 = "SideloadingUtils";
        r4 = "ioe";
        com.getpebble.android.common.b.a.f.b(r2, r4, r1);
        goto L_0x00bb;
    L_0x00ca:
        r1 = move-exception;
        r2 = "SideloadingUtils";
        r3 = "ioe";
        com.getpebble.android.common.b.a.f.b(r2, r3, r1);
        goto L_0x00c0;
    L_0x00d3:
        r0 = "SideloadingUtils";
        r2 = "outputFile == null";
        com.getpebble.android.common.b.a.f.d(r0, r2);
        r0 = r1;
        goto L_0x0031;
    L_0x00dd:
        r0 = move-exception;
        r4 = r1;
        goto L_0x00b3;
    L_0x00e0:
        r0 = move-exception;
        goto L_0x00b3;
    L_0x00e2:
        r0 = move-exception;
        r2 = r1;
        r4 = r1;
        goto L_0x0087;
    L_0x00e6:
        r0 = move-exception;
        r4 = r1;
        goto L_0x0087;
    L_0x00e9:
        r0 = move-exception;
        goto L_0x0087;
    L_0x00eb:
        r0 = move-exception;
        r2 = r1;
        r4 = r1;
        goto L_0x0049;
    L_0x00f0:
        r0 = move-exception;
        r4 = r1;
        goto L_0x0049;
    L_0x00f4:
        r0 = move-exception;
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.framework.o.d.a(android.content.Context, android.net.Uri, com.getpebble.android.framework.o.d$a):java.io.File");
    }

    public static boolean a(Uri uri) {
        return uri.getScheme().equals("content");
    }

    public static String a(ContentResolver contentResolver, Uri uri) {
        String str = null;
        Cursor query = contentResolver.query(uri, new String[]{"_display_name"}, null, null, null);
        if (query != null) {
            try {
                query.moveToFirst();
                if (!query.isAfterLast()) {
                    int columnIndex = query.getColumnIndex("_display_name");
                    if (columnIndex >= 0) {
                        str = query.getString(columnIndex);
                    }
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        return str;
    }
}
