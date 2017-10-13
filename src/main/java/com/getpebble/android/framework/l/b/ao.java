package com.getpebble.android.framework.l.b;

import android.text.TextUtils;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.aw.b;
import com.getpebble.android.common.model.aw.c;
import com.getpebble.android.framework.timeline.e;
import com.getpebble.android.framework.timeline.g;
import com.getpebble.android.framework.timeline.h;
import com.getpebble.android.h.p;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public class ao {
    private final h a;

    public static class a {
        public UUID a;
        public UUID b;
        public long c = -1;
        public int d = -1;
        public b e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public com.getpebble.android.common.model.aw.c.a j;
        public String k;
        public String l;

        public a a(UUID uuid) {
            this.a = uuid;
            return this;
        }

        public a b(UUID uuid) {
            this.b = uuid;
            return this;
        }

        public a a(long j) {
            this.c = j;
            return this;
        }

        public a a(int i) {
            this.d = i;
            return this;
        }

        public a a(b bVar) {
            this.e = bVar;
            return this;
        }

        public a a(boolean z) {
            this.f = z;
            return this;
        }

        public a b(boolean z) {
            this.g = z;
            return this;
        }

        public a c(boolean z) {
            this.h = z;
            return this;
        }

        private a d(boolean z) {
            this.i = z;
            return this;
        }

        public a a(com.getpebble.android.common.model.aw.c.a aVar) {
            this.j = aVar;
            return this;
        }

        public a a(String str) {
            this.k = str;
            return this;
        }

        public a b(String str) {
            this.l = str;
            return this;
        }

        public a a(byte b) {
            boolean[] f = com.getpebble.android.bluetooth.b.b.f(new byte[]{b});
            return a(f[com.getpebble.android.framework.l.d.a.IS_VISIBLE.bitIndex]).b(f[com.getpebble.android.framework.l.d.a.IS_FLOATING.bitIndex]).c(f[com.getpebble.android.framework.l.d.a.IS_ALL_DAY.bitIndex]).d(f[com.getpebble.android.framework.l.d.a.PERSIST_QUICK_VIEW.bitIndex]);
        }

        public c a() {
            return new c(this.a, this.b, this.e, this.d, this.c, this.k, this.l, false, this.f, this.g, this.h, this.i, this.j);
        }
    }

    public ao(h hVar) {
        this.a = hVar;
    }

    public c a(byte[] bArr, com.getpebble.android.common.framework.install.app.b.a aVar) {
        f.d("TimelineItemDeserializer", "Deserializing data (size " + bArr.length + ") into Timeline PebbleRecord");
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        try {
            UUID f = com.getpebble.android.bluetooth.b.b.f(wrap);
            UUID f2 = com.getpebble.android.bluetooth.b.b.f(wrap);
            long longValue = com.getpebble.android.bluetooth.b.b.c(wrap).longValue() * 1000;
            int intValue = com.getpebble.android.bluetooth.b.b.b(wrap).intValue();
            b from = b.from(wrap.get());
            byte b = wrap.get();
            com.getpebble.android.common.model.aw.c.a from2 = com.getpebble.android.common.model.aw.c.a.from(wrap.get());
            int intValue2 = com.getpebble.android.bluetooth.b.b.a(wrap).intValue();
            com.getpebble.android.bluetooth.b.b.b(wrap).intValue();
            int intValue3 = com.getpebble.android.bluetooth.b.b.a(wrap).intValue();
            int intValue4 = com.getpebble.android.bluetooth.b.b.a(wrap).intValue();
            g a = a(intValue3, intValue2, wrap, this.a, aVar);
            Object a2 = a(intValue4, wrap, this.a, aVar);
            if (from == b.PIN) {
                this.a.setAppLayouts(am.a(com.getpebble.android.common.a.K().getContentResolver(), f2));
            }
            return new a().a(f).b(f2).a(longValue).a(intValue).a(from).a(from2).a(p.a(a)).b(p.a(a2)).a(b).a();
        } catch (Throwable e) {
            f.f("TimelineItemDeserializer", "deserialize: Buffer underflow, bytes: " + com.getpebble.android.bluetooth.b.b.d(bArr), e);
            return null;
        }
    }

    private com.getpebble.android.framework.timeline.c[] a(int i, ByteBuffer byteBuffer, h hVar, com.getpebble.android.common.framework.install.app.b.a aVar) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            com.getpebble.android.framework.timeline.c a = a(byteBuffer, hVar, aVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return (com.getpebble.android.framework.timeline.c[]) arrayList.toArray(new com.getpebble.android.framework.timeline.c[arrayList.size()]);
    }

    private com.getpebble.android.framework.timeline.c a(ByteBuffer byteBuffer, h hVar, com.getpebble.android.common.framework.install.app.b.a aVar) {
        int intValue = com.getpebble.android.bluetooth.b.b.a(byteBuffer).intValue();
        aj from = aj.from(byteBuffer.get());
        int intValue2 = com.getpebble.android.bluetooth.b.b.a(byteBuffer).intValue();
        com.getpebble.android.framework.timeline.f fVar = new com.getpebble.android.framework.timeline.f();
        for (int i = 0; i < intValue2; i++) {
            a(fVar, byteBuffer, hVar, aVar);
        }
        com.getpebble.android.framework.timeline.c.b from2 = com.getpebble.android.framework.timeline.c.b.from(from);
        if (from2 != com.getpebble.android.framework.timeline.c.b.UNKNOWN) {
            return new com.getpebble.android.framework.timeline.c(from2, fVar.toArray(), intValue);
        }
        f.b("TimelineItemDeserializer", "deserializeTimelineAction: could not find the MobileActionType for " + from);
        return null;
    }

    private g a(int i, int i2, ByteBuffer byteBuffer, h hVar, com.getpebble.android.common.framework.install.app.b.a aVar) {
        com.getpebble.android.framework.timeline.f fVar = new com.getpebble.android.framework.timeline.f();
        for (int i3 = 0; i3 < i; i3++) {
            a(fVar, byteBuffer, hVar, aVar);
        }
        String str = null;
        for (Entry entry : hVar.getLayoutNameMap().entrySet()) {
            String str2;
            if (i2 == ((Integer) entry.getValue()).intValue()) {
                str2 = (String) entry.getKey();
            } else {
                str2 = str;
            }
            str = str2;
        }
        if (TextUtils.isEmpty(str)) {
            f.b("TimelineItemDeserializer", "deserializeAttributes: de layoutName is null");
        }
        return new g(str, fVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.getpebble.android.framework.timeline.f r13, java.nio.ByteBuffer r14, com.getpebble.android.framework.timeline.h r15, com.getpebble.android.common.framework.install.app.b.a r16) {
        /*
        r12 = this;
        r0 = com.getpebble.android.bluetooth.b.b.a(r14);
        r4 = r0.intValue();
        r0 = com.getpebble.android.bluetooth.b.b.b(r14);
        r0 = r0.intValue();
        r5 = new byte[r0];
        r14.get(r5);
        r3 = 0;
        r2 = 0;
        r1 = 0;
        r0 = r15.getAttributeMap();
        r0 = r0.entrySet();
        r6 = r0.iterator();
    L_0x0024:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0047;
    L_0x002a:
        r0 = r6.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getValue();
        r1 = (com.getpebble.android.framework.timeline.a) r1;
        r7 = r1.getId();
        if (r7 != r4) goto L_0x0024;
    L_0x003c:
        r0 = r0.getKey();
        r0 = (java.lang.String) r0;
        r2 = r1.getType();
        r3 = r0;
    L_0x0047:
        if (r2 == 0) goto L_0x004d;
    L_0x0049:
        r0 = com.getpebble.android.framework.l.b.ap.a.UNKNOWN;
        if (r2 != r0) goto L_0x0066;
    L_0x004d:
        r0 = "TimelineItemDeserializer";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "deserializeAttribute: return because serializationType is null for attributeId ";
        r1 = r1.append(r2);
        r1 = r1.append(r4);
        r1 = r1.toString();
        com.getpebble.android.common.b.a.f.b(r0, r1);
    L_0x0065:
        return;
    L_0x0066:
        r0 = com.getpebble.android.framework.l.b.ao.AnonymousClass1.a;
        r4 = r2.ordinal();
        r0 = r0[r4];
        switch(r0) {
            case 1: goto L_0x008e;
            case 2: goto L_0x0096;
            case 3: goto L_0x00b7;
            case 4: goto L_0x00cd;
            case 5: goto L_0x0106;
            case 6: goto L_0x0124;
            case 7: goto L_0x0136;
            default: goto L_0x0071;
        };
    L_0x0071:
        r0 = "TimelineItemDeserializer";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "Failed to deserialize: ";
        r1 = r1.append(r3);
        r2 = r2.name();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.getpebble.android.common.b.a.f.a(r0, r1);
        goto L_0x0065;
    L_0x008e:
        r0 = com.getpebble.android.bluetooth.b.b.a(r5);
        r13.add(r3, r0);
        goto L_0x0065;
    L_0x0096:
        r0 = com.getpebble.android.bluetooth.b.b.b(r5);
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = r0.iterator();
    L_0x00a3:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x00b3;
    L_0x00a9:
        r0 = r2.next();
        r0 = (java.lang.String) r0;
        r1.add(r0);
        goto L_0x00a3;
    L_0x00b3:
        r13.add(r3, r1);
        goto L_0x0065;
    L_0x00b7:
        r0 = java.nio.ByteBuffer.wrap(r5);
        r1 = java.nio.ByteOrder.LITTLE_ENDIAN;
        r0 = r0.order(r1);
        r0 = com.getpebble.android.bluetooth.b.b.c(r0);
        r0 = r0.intValue();
        r13.add(r3, r0);
        goto L_0x0065;
    L_0x00cd:
        r0 = java.nio.ByteBuffer.wrap(r5);
        r0 = com.getpebble.android.bluetooth.b.b.a(r0);
        r0 = r0.intValue();
        r2 = java.lang.Integer.valueOf(r0);
        r0 = r1.getEnumMap();
        r0 = r0.entrySet();
        r1 = r0.iterator();
    L_0x00e9:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0106;
    L_0x00ef:
        r0 = r1.next();
        r0 = (java.util.Map.Entry) r0;
        r4 = r0.getValue();
        if (r4 != r2) goto L_0x00e9;
    L_0x00fb:
        r0 = r0.getKey();
        r0 = (java.lang.String) r0;
        r13.add(r3, r0);
        goto L_0x0065;
    L_0x0106:
        r0 = java.nio.ByteBuffer.wrap(r5);
        r1 = java.nio.ByteOrder.LITTLE_ENDIAN;
        r0 = r0.order(r1);
        r0 = com.getpebble.android.bluetooth.b.b.c(r0);
        r0 = r0.longValue();
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r0 * r4;
        r0 = com.getpebble.android.h.ab.c(r0);
        r13.add(r3, r0);
        goto L_0x0065;
    L_0x0124:
        r0 = com.getpebble.android.framework.timeline.b.a();
        r1 = 0;
        r1 = r5[r1];
        r0 = r0.a(r1);
        r0 = r0.b;
        r13.add(r3, r0);
        goto L_0x0065;
    L_0x0136:
        r0 = java.nio.ByteBuffer.wrap(r5);
        r0 = com.getpebble.android.bluetooth.b.b.c(r0);
        r4 = r0.intValue();
        r0 = 3;
        r1 = r5[r0];
        r1 = r1 & 127;
        r1 = (byte) r1;
        r5[r0] = r1;
        r0 = java.nio.ByteBuffer.wrap(r5);
        r1 = java.nio.ByteOrder.LITTLE_ENDIAN;
        r0 = r0.order(r1);
        r0 = com.getpebble.android.bluetooth.b.b.c(r0);
        r6 = r0.longValue();
        r5 = r15.getAppLayoutsMapper();
        r0 = r15.getSystemResourceIdMap();
        r0 = r0.entrySet();
        r8 = r0.iterator();
    L_0x016c:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x0194;
    L_0x0172:
        r0 = r8.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getValue();
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r10 = (long) r1;
        r9 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r9 == 0) goto L_0x0189;
    L_0x0187:
        if (r1 != r4) goto L_0x016c;
    L_0x0189:
        r0 = r0.getKey();
        r0 = (java.lang.String) r0;
        r13.add(r3, r0);
        goto L_0x0065;
    L_0x0194:
        if (r5 == 0) goto L_0x01cb;
    L_0x0196:
        r0 = r16.getCode();
        r0 = r5.getPlatformResources(r0);
    L_0x019e:
        if (r0 == 0) goto L_0x0071;
    L_0x01a0:
        r0 = r0.entrySet();
        r5 = r0.iterator();
    L_0x01a8:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x0071;
    L_0x01ae:
        r0 = r5.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getValue();
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        if (r1 != r4) goto L_0x01a8;
    L_0x01c0:
        r0 = r0.getKey();
        r0 = (java.lang.String) r0;
        r13.add(r3, r0);
        goto L_0x0065;
    L_0x01cb:
        r0 = 0;
        goto L_0x019e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.framework.l.b.ao.a(com.getpebble.android.framework.timeline.f, java.nio.ByteBuffer, com.getpebble.android.framework.timeline.h, com.getpebble.android.common.framework.install.app.b$a):void");
    }

    public Map<String, String> a(ByteBuffer byteBuffer, com.getpebble.android.common.framework.install.app.b.a aVar) {
        Map<String, String> hashMap = new HashMap();
        if (byteBuffer.hasRemaining()) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            byte b = byteBuffer.get();
            com.getpebble.android.framework.timeline.f fVar = new com.getpebble.android.framework.timeline.f();
            for (byte b2 = (byte) 0; b2 < b; b2++) {
                a(fVar, byteBuffer, this.a, aVar);
            }
            for (e eVar : fVar.getAttributes()) {
                hashMap.put(eVar.getName(), eVar.getValueAsString());
            }
            return hashMap;
        }
        f.d("TimelineItemDeserializer", "deserializeAttributes() bytebuffer is empty");
        return hashMap;
    }
}
