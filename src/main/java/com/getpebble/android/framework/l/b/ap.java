package com.getpebble.android.framework.l.b;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.aw.d;
import com.getpebble.android.framework.timeline.AppLayoutsMapper;
import com.getpebble.android.framework.timeline.c;
import com.getpebble.android.framework.timeline.g;
import com.getpebble.android.framework.timeline.h;
import com.getpebble.android.h.ab;
import com.getpebble.android.h.p;
import com.google.a.b.ad;
import com.google.a.f.e;
import com.google.b.i;
import com.google.b.l;
import com.google.b.r;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ap {
    private static final String TAG = "TimelineItemSerializer";

    public enum a {
        STRING_TO_STRING,
        URI_TO_RESOURCE,
        NUMBER_UINT32,
        STRING_ARRAY_TO_STRING_ARRAY,
        ENUM_UINT8,
        ISODATE_UNIXTIME,
        COLOR_UINT8,
        UNKNOWN;

        public static a from(String str) {
            for (a aVar : values()) {
                if (aVar.toString().equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
            f.a(ap.TAG, "Unknown serialization type: " + str);
            return UNKNOWN;
        }

        public String toString() {
            return ((r) p.a(p.a(this), r.class)).c();
        }
    }

    public byte[] serialize(d dVar, h hVar, com.getpebble.android.common.framework.install.app.b.a aVar) {
        Throwable e;
        ByteBuffer allocate = ByteBuffer.allocate(j.b());
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        try {
            int i;
            allocate.put(b.a(dVar.b.a));
            allocate.put(b.a(dVar.b.b));
            allocate.put(b.c(e.a((long) ab.a(dVar.b.e))));
            allocate.put(b.a(dVar.b.d));
            allocate.put(dVar.b.c.toByte());
            allocate.put(serializeFlags(dVar.b.i, dVar.b.j, dVar.b.k, dVar.b.l));
            if (dVar.b.m == com.getpebble.android.common.model.aw.c.a.EMPTY) {
                i = 0;
            } else {
                i = 1 << dVar.b.m.getLeftShift();
            }
            allocate.put((byte) i);
            f.e(TAG, "serializing with status bit: " + dVar.b.m.name());
            Map layoutNameMap = hVar.getLayoutNameMap();
            g gVar = (g) p.a(dVar.b.f, g.class);
            String layoutName = gVar.getLayoutName();
            if (layoutNameMap.containsKey(layoutName)) {
                allocate.put(com.google.a.f.d.a((long) ((Integer) layoutNameMap.get(layoutName)).intValue()));
                int position = allocate.position();
                allocate.mark();
                allocate.position(position + 4);
                position = allocate.position();
                i = serializeAttributes(allocate, gVar.getAttributes(), hVar, aVar);
                int position2 = allocate.position();
                int serializeActions = serializeActions(allocate, dVar.f(), hVar, aVar);
                int position3 = allocate.position();
                allocate.reset();
                allocate.put(b.a((position2 - position) + (position3 - position2)));
                allocate.put(com.google.a.f.d.a((long) i));
                allocate.put(com.google.a.f.d.a((long) serializeActions));
                allocate.position(position3);
                return Arrays.copyOf(allocate.array(), allocate.position());
            }
            throw new IllegalArgumentException("Failed to find layout name: " + layoutName);
        } catch (BufferOverflowException e2) {
            e = e2;
            throw new IllegalArgumentException(e);
        } catch (IllegalStateException e3) {
            e = e3;
            throw new IllegalArgumentException(e);
        }
    }

    public int serializeActions(ByteBuffer byteBuffer, c[] cVarArr, h hVar, com.getpebble.android.common.framework.install.app.b.a aVar) {
        if (cVarArr == null || cVarArr.length == 0) {
            return 0;
        }
        int i = 0;
        for (c cVar : orderActions(cVarArr)) {
            c.b actionType = cVar.getActionType();
            aj protocolActionType = actionType.getProtocolActionType();
            if (protocolActionType == aj.UNKNOWN) {
                f.a(TAG, "Mobile action has unknown wire format: " + actionType.name());
            } else {
                byteBuffer.put(com.google.a.f.d.a((long) cVar.getNotificationProcessorId()));
                byteBuffer.put(protocolActionType.mByte);
                int position = byteBuffer.position();
                byteBuffer.position(position + 1);
                int serializeAttributes = serializeAttributes(byteBuffer, cVar.getAttributes(), hVar, aVar);
                int position2 = byteBuffer.position();
                byteBuffer.position(position);
                byteBuffer.put(com.google.a.f.d.a((long) serializeAttributes));
                byteBuffer.position(position2);
                i++;
            }
        }
        return i;
    }

    List<c> orderActions(c[] cVarArr) {
        return ad.a((Object[]) cVarArr);
    }

    public int serializeAttributes(ByteBuffer byteBuffer, com.getpebble.android.framework.timeline.e[] eVarArr, h hVar, com.getpebble.android.common.framework.install.app.b.a aVar) {
        int i = 0;
        for (com.getpebble.android.framework.timeline.e serializeAttribute : eVarArr) {
            if (serializeAttribute(byteBuffer, hVar, serializeAttribute, aVar)) {
                i++;
            }
        }
        return i;
    }

    byte[] serializeFlags(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean[] zArr = new boolean[8];
        zArr[com.getpebble.android.framework.l.d.a.IS_VISIBLE.bitIndex] = z;
        zArr[com.getpebble.android.framework.l.d.a.IS_FLOATING.bitIndex] = z2;
        zArr[com.getpebble.android.framework.l.d.a.IS_ALL_DAY.bitIndex] = z3;
        zArr[com.getpebble.android.framework.l.d.a.PERSIST_QUICK_VIEW.bitIndex] = z4;
        return b.a(zArr);
    }

    boolean serializeAttribute(ByteBuffer byteBuffer, h hVar, com.getpebble.android.framework.timeline.e eVar, com.getpebble.android.common.framework.install.app.b.a aVar) {
        Map attributeMap = hVar.getAttributeMap();
        Map systemResourceIdMap = hVar.getSystemResourceIdMap();
        l value = eVar.getValue();
        com.getpebble.android.framework.timeline.a aVar2 = (com.getpebble.android.framework.timeline.a) attributeMap.get(eVar.getName());
        if (aVar2 == null) {
            f.a(TAG, "Failed to get attribute: " + eVar.getName());
            return false;
        }
        byte[] b;
        int id = aVar2.getId();
        a type = aVar2.getType();
        String c;
        switch (type) {
            case STRING_TO_STRING:
                b = b.b(value.c(), aVar2.getMaxLength());
                break;
            case NUMBER_UINT32:
                b = b.c(e.a((long) value.f()));
                break;
            case STRING_ARRAY_TO_STRING_ARRAY:
                i m = value.m();
                int maxLength = aVar2.getMaxLength();
                List linkedList = new LinkedList();
                Iterator it = m.iterator();
                while (it.hasNext()) {
                    linkedList.add(((l) it.next()).c());
                }
                b = b.b(linkedList, maxLength);
                break;
            case URI_TO_RESOURCE:
                c = value.c();
                AppLayoutsMapper appLayoutsMapper = hVar.getAppLayoutsMapper();
                Map platformResources = appLayoutsMapper == null ? null : appLayoutsMapper.getPlatformResources(aVar.getCode());
                if (!systemResourceIdMap.containsKey(c)) {
                    if (platformResources != null && platformResources.containsKey(c)) {
                        b = b.c(e.a((long) ((Integer) platformResources.get(c)).intValue()));
                        break;
                    }
                    f.a(TAG, "Failed to serialize: " + c);
                    return false;
                }
                b = b.c(e.a((long) ((Integer) systemResourceIdMap.get(c)).intValue()));
                b[3] = (byte) (b[3] | -128);
                break;
            case ENUM_UINT8:
                String c2 = value.c();
                if (((Integer) aVar2.getEnumMap().get(c2)) != null) {
                    b = new byte[]{com.google.a.f.d.a(((Integer) aVar2.getEnumMap().get(c2)).longValue())};
                    break;
                }
                f.d(TAG, "Could not serialize enum value: '" + c2 + "'");
                return false;
            case ISODATE_UNIXTIME:
                String c3 = value.c();
                try {
                    b = b.a(e.a(ab.a(c3).getTime().getTime() / 1000), ByteOrder.LITTLE_ENDIAN);
                    break;
                } catch (ParseException e) {
                    f.c(TAG, "Could not deserialize isoDate: '" + c3 + "'");
                    return false;
                }
            case COLOR_UINT8:
                c = value.c();
                try {
                    com.getpebble.android.framework.timeline.b.a b2;
                    com.getpebble.android.framework.timeline.b a = com.getpebble.android.framework.timeline.b.a();
                    com.getpebble.android.framework.timeline.b.a a2 = a.a(c);
                    if (a2 == null) {
                        b2 = a.b(c);
                    } else {
                        b2 = a2;
                    }
                    if (b2 != null) {
                        b = new byte[]{b2.a()};
                        break;
                    }
                    f.c(TAG, "Could not serialize color: " + c);
                    return false;
                } catch (Throwable e2) {
                    f.c(TAG, "Could not serialize color: " + c, e2);
                    return false;
                }
            default:
                f.a(TAG, "Unknown serialization type: " + type.name());
                return false;
        }
        f.e(TAG, "serializeAttribute: attributeId = " + id + ", serializationType = " + type + ", attributeName = " + eVar.getName() + ", attributeValue = " + value + ", maxLength = " + aVar2.getMaxLength() + ", serializedValue.length = " + b.length);
        byteBuffer.put(com.google.a.f.d.a((long) id));
        byteBuffer.put(b.a(b.length));
        byteBuffer.put(b);
        return true;
    }
}
