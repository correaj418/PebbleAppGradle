package net.hockeyapp.android.e;

public class c {

    private static class a {
        public static final c a = new c();
    }

    private c() {
    }

    public static c a() {
        return a.a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.hockeyapp.android.c.g a(java.lang.String r34) {
        /*
        r33 = this;
        r3 = 0;
        if (r34 == 0) goto L_0x0242;
    L_0x0003:
        r7 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x021d }
        r0 = r34;
        r7.<init>(r0);	 Catch:{ JSONException -> 0x021d }
        r2 = "feedback";
        r8 = r7.getJSONObject(r2);	 Catch:{ JSONException -> 0x021d }
        r9 = new net.hockeyapp.android.c.d;	 Catch:{ JSONException -> 0x021d }
        r9.<init>();	 Catch:{ JSONException -> 0x021d }
        r2 = "messages";
        r10 = r8.getJSONArray(r2);	 Catch:{ JSONException -> 0x021d }
        r2 = 0;
        r4 = r10.length();	 Catch:{ JSONException -> 0x021d }
        if (r4 <= 0) goto L_0x01c2;
    L_0x0022:
        r2 = new java.util.ArrayList;	 Catch:{ JSONException -> 0x021d }
        r2.<init>();	 Catch:{ JSONException -> 0x021d }
        r4 = 0;
        r6 = r4;
    L_0x0029:
        r4 = r10.length();	 Catch:{ JSONException -> 0x021d }
        if (r6 >= r4) goto L_0x01c2;
    L_0x002f:
        r4 = r10.getJSONObject(r6);	 Catch:{ JSONException -> 0x021d }
        r5 = "subject";
        r4 = r4.getString(r5);	 Catch:{ JSONException -> 0x021d }
        r11 = r4.toString();	 Catch:{ JSONException -> 0x021d }
        r4 = r10.getJSONObject(r6);	 Catch:{ JSONException -> 0x021d }
        r5 = "text";
        r4 = r4.getString(r5);	 Catch:{ JSONException -> 0x021d }
        r12 = r4.toString();	 Catch:{ JSONException -> 0x021d }
        r4 = r10.getJSONObject(r6);	 Catch:{ JSONException -> 0x021d }
        r5 = "oem";
        r4 = r4.getString(r5);	 Catch:{ JSONException -> 0x021d }
        r13 = r4.toString();	 Catch:{ JSONException -> 0x021d }
        r4 = r10.getJSONObject(r6);	 Catch:{ JSONException -> 0x021d }
        r5 = "model";
        r4 = r4.getString(r5);	 Catch:{ JSONException -> 0x021d }
        r14 = r4.toString();	 Catch:{ JSONException -> 0x021d }
        r4 = r10.getJSONObject(r6);	 Catch:{ JSONException -> 0x021d }
        r5 = "os_version";
        r4 = r4.getString(r5);	 Catch:{ JSONException -> 0x021d }
        r15 = r4.toString();	 Catch:{ JSONException -> 0x021d }
        r4 = r10.getJSONObject(r6);	 Catch:{ JSONException -> 0x021d }
        r5 = "created_at";
        r4 = r4.getString(r5);	 Catch:{ JSONException -> 0x021d }
        r16 = r4.toString();	 Catch:{ JSONException -> 0x021d }
        r4 = r10.getJSONObject(r6);	 Catch:{ JSONException -> 0x021d }
        r5 = "id";
        r17 = r4.getInt(r5);	 Catch:{ JSONException -> 0x021d }
        r4 = r10.getJSONObject(r6);	 Catch:{ JSONException -> 0x021d }
        r5 = "token";
        r4 = r4.getString(r5);	 Catch:{ JSONException -> 0x021d }
        r18 = r4.toString();	 Catch:{ JSONException -> 0x021d }
        r4 = r10.getJSONObject(r6);	 Catch:{ JSONException -> 0x021d }
        r5 = "via";
        r19 = r4.getInt(r5);	 Catch:{ JSONException -> 0x021d }
        r4 = r10.getJSONObject(r6);	 Catch:{ JSONException -> 0x021d }
        r5 = "user_string";
        r4 = r4.getString(r5);	 Catch:{ JSONException -> 0x021d }
        r20 = r4.toString();	 Catch:{ JSONException -> 0x021d }
        r4 = r10.getJSONObject(r6);	 Catch:{ JSONException -> 0x021d }
        r5 = "clean_text";
        r4 = r4.getString(r5);	 Catch:{ JSONException -> 0x021d }
        r21 = r4.toString();	 Catch:{ JSONException -> 0x021d }
        r4 = r10.getJSONObject(r6);	 Catch:{ JSONException -> 0x021d }
        r5 = "name";
        r4 = r4.getString(r5);	 Catch:{ JSONException -> 0x021d }
        r22 = r4.toString();	 Catch:{ JSONException -> 0x021d }
        r4 = r10.getJSONObject(r6);	 Catch:{ JSONException -> 0x021d }
        r5 = "app_id";
        r4 = r4.getString(r5);	 Catch:{ JSONException -> 0x021d }
        r23 = r4.toString();	 Catch:{ JSONException -> 0x021d }
        r4 = r10.getJSONObject(r6);	 Catch:{ JSONException -> 0x021d }
        r5 = "attachments";
        r24 = r4.optJSONArray(r5);	 Catch:{ JSONException -> 0x021d }
        r4 = java.util.Collections.emptyList();	 Catch:{ JSONException -> 0x021d }
        if (r24 == 0) goto L_0x017b;
    L_0x00ed:
        r4 = new java.util.ArrayList;	 Catch:{ JSONException -> 0x021d }
        r4.<init>();	 Catch:{ JSONException -> 0x021d }
        r5 = 0;
    L_0x00f3:
        r25 = r24.length();	 Catch:{ JSONException -> 0x021d }
        r0 = r25;
        if (r5 >= r0) goto L_0x017b;
    L_0x00fb:
        r0 = r24;
        r25 = r0.getJSONObject(r5);	 Catch:{ JSONException -> 0x021d }
        r26 = "id";
        r25 = r25.getInt(r26);	 Catch:{ JSONException -> 0x021d }
        r0 = r24;
        r26 = r0.getJSONObject(r5);	 Catch:{ JSONException -> 0x021d }
        r27 = "feedback_message_id";
        r26 = r26.getInt(r27);	 Catch:{ JSONException -> 0x021d }
        r0 = r24;
        r27 = r0.getJSONObject(r5);	 Catch:{ JSONException -> 0x021d }
        r28 = "file_name";
        r27 = r27.getString(r28);	 Catch:{ JSONException -> 0x021d }
        r0 = r24;
        r28 = r0.getJSONObject(r5);	 Catch:{ JSONException -> 0x021d }
        r29 = "url";
        r28 = r28.getString(r29);	 Catch:{ JSONException -> 0x021d }
        r0 = r24;
        r29 = r0.getJSONObject(r5);	 Catch:{ JSONException -> 0x021d }
        r30 = "created_at";
        r29 = r29.getString(r30);	 Catch:{ JSONException -> 0x021d }
        r0 = r24;
        r30 = r0.getJSONObject(r5);	 Catch:{ JSONException -> 0x021d }
        r31 = "updated_at";
        r30 = r30.getString(r31);	 Catch:{ JSONException -> 0x021d }
        r31 = new net.hockeyapp.android.c.e;	 Catch:{ JSONException -> 0x021d }
        r31.<init>();	 Catch:{ JSONException -> 0x021d }
        r0 = r31;
        r1 = r25;
        r0.a(r1);	 Catch:{ JSONException -> 0x021d }
        r0 = r31;
        r1 = r26;
        r0.b(r1);	 Catch:{ JSONException -> 0x021d }
        r0 = r31;
        r1 = r27;
        r0.a(r1);	 Catch:{ JSONException -> 0x021d }
        r0 = r31;
        r1 = r28;
        r0.b(r1);	 Catch:{ JSONException -> 0x021d }
        r0 = r31;
        r1 = r29;
        r0.c(r1);	 Catch:{ JSONException -> 0x021d }
        r0 = r31;
        r1 = r30;
        r0.d(r1);	 Catch:{ JSONException -> 0x021d }
        r0 = r31;
        r4.add(r0);	 Catch:{ JSONException -> 0x021d }
        r5 = r5 + 1;
        goto L_0x00f3;
    L_0x017b:
        r5 = new net.hockeyapp.android.c.f;	 Catch:{ JSONException -> 0x021d }
        r5.<init>();	 Catch:{ JSONException -> 0x021d }
        r0 = r23;
        r5.k(r0);	 Catch:{ JSONException -> 0x021d }
        r0 = r21;
        r5.i(r0);	 Catch:{ JSONException -> 0x021d }
        r0 = r16;
        r5.f(r0);	 Catch:{ JSONException -> 0x021d }
        r0 = r17;
        r5.a(r0);	 Catch:{ JSONException -> 0x021d }
        r5.d(r14);	 Catch:{ JSONException -> 0x021d }
        r0 = r22;
        r5.j(r0);	 Catch:{ JSONException -> 0x021d }
        r5.c(r13);	 Catch:{ JSONException -> 0x021d }
        r5.e(r15);	 Catch:{ JSONException -> 0x021d }
        r5.a(r11);	 Catch:{ JSONException -> 0x021d }
        r5.b(r12);	 Catch:{ JSONException -> 0x021d }
        r0 = r18;
        r5.g(r0);	 Catch:{ JSONException -> 0x021d }
        r0 = r20;
        r5.h(r0);	 Catch:{ JSONException -> 0x021d }
        r0 = r19;
        r5.b(r0);	 Catch:{ JSONException -> 0x021d }
        r5.a(r4);	 Catch:{ JSONException -> 0x021d }
        r2.add(r5);	 Catch:{ JSONException -> 0x021d }
        r4 = r6 + 1;
        r6 = r4;
        goto L_0x0029;
    L_0x01c2:
        r9.a(r2);	 Catch:{ JSONException -> 0x021d }
        r2 = "name";
        r2 = r8.getString(r2);	 Catch:{ JSONException -> 0x0218 }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x0218 }
        r9.a(r2);	 Catch:{ JSONException -> 0x0218 }
    L_0x01d2:
        r2 = "email";
        r2 = r8.getString(r2);	 Catch:{ JSONException -> 0x0227 }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x0227 }
        r9.b(r2);	 Catch:{ JSONException -> 0x0227 }
    L_0x01df:
        r2 = "id";
        r2 = r8.getInt(r2);	 Catch:{ JSONException -> 0x022c }
        r9.a(r2);	 Catch:{ JSONException -> 0x022c }
    L_0x01e8:
        r2 = "created_at";
        r2 = r8.getString(r2);	 Catch:{ JSONException -> 0x0231 }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x0231 }
        r9.c(r2);	 Catch:{ JSONException -> 0x0231 }
    L_0x01f5:
        r2 = new net.hockeyapp.android.c.g;	 Catch:{ JSONException -> 0x021d }
        r2.<init>();	 Catch:{ JSONException -> 0x021d }
        r2.a(r9);	 Catch:{ JSONException -> 0x023b }
        r3 = "status";
        r3 = r7.getString(r3);	 Catch:{ JSONException -> 0x0236 }
        r3 = r3.toString();	 Catch:{ JSONException -> 0x0236 }
        r2.a(r3);	 Catch:{ JSONException -> 0x0236 }
    L_0x020a:
        r3 = "token";
        r3 = r7.getString(r3);	 Catch:{ JSONException -> 0x023d }
        r3 = r3.toString();	 Catch:{ JSONException -> 0x023d }
        r2.b(r3);	 Catch:{ JSONException -> 0x023d }
    L_0x0217:
        return r2;
    L_0x0218:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ JSONException -> 0x021d }
        goto L_0x01d2;
    L_0x021d:
        r2 = move-exception;
        r32 = r2;
        r2 = r3;
        r3 = r32;
    L_0x0223:
        r3.printStackTrace();
        goto L_0x0217;
    L_0x0227:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ JSONException -> 0x021d }
        goto L_0x01df;
    L_0x022c:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ JSONException -> 0x021d }
        goto L_0x01e8;
    L_0x0231:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ JSONException -> 0x021d }
        goto L_0x01f5;
    L_0x0236:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ JSONException -> 0x023b }
        goto L_0x020a;
    L_0x023b:
        r3 = move-exception;
        goto L_0x0223;
    L_0x023d:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ JSONException -> 0x023b }
        goto L_0x0217;
    L_0x0242:
        r2 = r3;
        goto L_0x0217;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.e.c.a(java.lang.String):net.hockeyapp.android.c.g");
    }
}
