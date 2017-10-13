package com.getpebble.android.framework.jskit.a.a;

import com.getpebble.android.framework.appmessage.AppMessage;
import com.getpebble.jskit.android.impl.runtime.model.JsApplicationInfo;
import com.google.a.f.e;
import com.google.b.t;
import java.util.Map;
import java.util.Map.Entry;

public class c implements t<AppMessage> {
    private JsApplicationInfo a;

    public c(JsApplicationInfo jsApplicationInfo) {
        this.a = jsApplicationInfo;
    }

    private String a(e eVar) {
        if (this.a != null) {
            Map j = this.a.j();
            if (j != null) {
                for (Entry entry : j.entrySet()) {
                    if (entry != null && ((e) entry.getValue()).equals(eVar)) {
                        return (String) entry.getKey();
                    }
                }
            }
        }
        return eVar.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.b.l a(com.getpebble.android.framework.appmessage.AppMessage r11, java.lang.reflect.Type r12, com.google.b.s r13) {
        /*
        r10 = this;
        if (r11 != 0) goto L_0x0004;
    L_0x0002:
        r0 = 0;
    L_0x0003:
        return r0;
    L_0x0004:
        r3 = r11.b();
        if (r3 != 0) goto L_0x0010;
    L_0x000a:
        r0 = new com.google.b.o;
        r0.<init>();
        goto L_0x0003;
    L_0x0010:
        r1 = new com.google.b.o;
        r1.<init>();
        r4 = r3.iterator();
    L_0x0019:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x009a;
    L_0x001f:
        r0 = r4.next();
        r0 = (com.getpebble.android.framework.appmessage.d) r0;
        r2 = r0.d;
        r5 = r10.a(r2);
        r2 = r0.e;
        r6 = r0.f;
        if (r0 == 0) goto L_0x0019;
    L_0x0031:
        r6 = com.getpebble.android.framework.jskit.a.a.c.AnonymousClass1.a;	 Catch:{ Exception -> 0x0065 }
        r2 = r2.ordinal();	 Catch:{ Exception -> 0x0065 }
        r2 = r6[r2];	 Catch:{ Exception -> 0x0065 }
        switch(r2) {
            case 1: goto L_0x003d;
            case 2: goto L_0x006e;
            case 3: goto L_0x0076;
            case 4: goto L_0x0088;
            default: goto L_0x003c;
        };	 Catch:{ Exception -> 0x0065 }
    L_0x003c:
        goto L_0x0019;
    L_0x003d:
        r6 = new com.google.b.i;	 Catch:{ Exception -> 0x0065 }
        r6.<init>();	 Catch:{ Exception -> 0x0065 }
        r0 = r0.h;	 Catch:{ Exception -> 0x0065 }
        r0 = (byte[]) r0;	 Catch:{ Exception -> 0x0065 }
        r0 = (byte[]) r0;	 Catch:{ Exception -> 0x0065 }
        r7 = r0.length;	 Catch:{ Exception -> 0x0065 }
        r2 = 0;
    L_0x004a:
        if (r2 >= r7) goto L_0x0061;
    L_0x004c:
        r8 = r0[r2];	 Catch:{ Exception -> 0x0065 }
        r9 = new com.google.b.r;	 Catch:{ Exception -> 0x0065 }
        r8 = com.google.a.f.d.a(r8);	 Catch:{ Exception -> 0x0065 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0065 }
        r9.<init>(r8);	 Catch:{ Exception -> 0x0065 }
        r6.a(r9);	 Catch:{ Exception -> 0x0065 }
        r2 = r2 + 1;
        goto L_0x004a;
    L_0x0061:
        r1.a(r5, r6);	 Catch:{ Exception -> 0x0065 }
        goto L_0x0019;
    L_0x0065:
        r0 = move-exception;
        r2 = "AppMessageSerializer";
        r5 = "serialize: ";
        com.getpebble.android.common.b.a.f.a(r2, r5, r0);
        goto L_0x0019;
    L_0x006e:
        r0 = r0.h;	 Catch:{ Exception -> 0x0065 }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0065 }
        r1.a(r5, r0);	 Catch:{ Exception -> 0x0065 }
        goto L_0x0019;
    L_0x0076:
        r0 = r0.h;	 Catch:{ Exception -> 0x0065 }
        r0 = (java.lang.Number) r0;	 Catch:{ Exception -> 0x0065 }
        r0 = (java.lang.Number) r0;	 Catch:{ Exception -> 0x0065 }
        r6 = r0.longValue();	 Catch:{ Exception -> 0x0065 }
        r0 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x0065 }
        r1.a(r5, r0);	 Catch:{ Exception -> 0x0065 }
        goto L_0x0019;
    L_0x0088:
        r0 = r0.h;	 Catch:{ Exception -> 0x0065 }
        r0 = (java.lang.Number) r0;	 Catch:{ Exception -> 0x0065 }
        r0 = (java.lang.Number) r0;	 Catch:{ Exception -> 0x0065 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0065 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0065 }
        r1.a(r5, r0);	 Catch:{ Exception -> 0x0065 }
        goto L_0x0019;
    L_0x009a:
        r0 = "AppMessageSerializer";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "serialize: pebbleTuples = ";
        r2 = r2.append(r4);
        r2 = r2.append(r3);
        r3 = " jsonObject = ";
        r2 = r2.append(r3);
        r2 = r2.append(r1);
        r2 = r2.toString();
        com.getpebble.android.common.b.a.f.e(r0, r2);
        r0 = r1;
        goto L_0x0003;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.framework.jskit.a.a.c.a(com.getpebble.android.framework.appmessage.AppMessage, java.lang.reflect.Type, com.google.b.s):com.google.b.l");
    }
}
