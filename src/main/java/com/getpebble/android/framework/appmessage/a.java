package com.getpebble.android.framework.appmessage;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.appmessage.d.c;
import com.google.a.f.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collection;
import org.json.JSONObject;

public class a extends c {
    public a(c cVar) {
        super(cVar);
    }

    public ByteBuffer a() {
        Collection<d> values = this.a.values();
        int i = 1;
        for (d a : values) {
            i = a(a) + i;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put((byte) values.size());
        for (d a2 : values) {
            allocate.put(b(a2));
        }
        allocate.rewind();
        return allocate;
    }

    public static a a(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        byte b = duplicate.get();
        a aVar = new a();
        for (byte b2 = (byte) 0; b2 < b; b2++) {
            aVar.c(b(duplicate));
        }
        return aVar;
    }

    static int a(d dVar) {
        return dVar.g + 7;
    }

    static d b(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        e c = b.c(duplicate);
        com.getpebble.android.framework.appmessage.d.a aVar = d.a[duplicate.get() & 255];
        int i = duplicate.getShort() & 65535;
        d dVar = null;
        switch (aVar) {
            case BYTES:
                Object obj = new byte[i];
                duplicate.get(obj, 0, i);
                dVar = d.a(c, aVar, c.NONE, obj);
                break;
            case STRING:
                dVar = d.a(c, aVar, c.NONE, b.a(duplicate, i));
                break;
            case INT:
                long j;
                c cVar;
                if (i == 2) {
                    j = (long) duplicate.getShort();
                    cVar = c.SHORT;
                } else if (i == 4) {
                    j = (long) duplicate.getInt();
                    cVar = c.WORD;
                } else {
                    j = (long) duplicate.get();
                    cVar = c.BYTE;
                }
                dVar = d.a(c, aVar, cVar, Long.valueOf(j));
                break;
            case UINT:
                long j2;
                c cVar2;
                if (i == 2) {
                    j2 = (long) (duplicate.getShort() & 65535);
                    cVar2 = c.SHORT;
                } else if (i == 4) {
                    j2 = ((long) duplicate.getInt()) & -1;
                    cVar2 = c.WORD;
                } else {
                    j2 = (long) (duplicate.get() & 255);
                    cVar2 = c.BYTE;
                }
                dVar = d.a(c, aVar, cVar2, Long.valueOf(j2));
                break;
        }
        byteBuffer.position(duplicate.position());
        return dVar;
    }

    static ByteBuffer b(d dVar) {
        ByteBuffer allocate = ByteBuffer.allocate(a(dVar));
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(b.a(dVar.d, ByteOrder.LITTLE_ENDIAN));
        allocate.put(dVar.e.ord);
        allocate.putShort((short) (dVar.g & 65535));
        switch (dVar.e) {
            case BYTES:
                allocate.put((byte[]) dVar.h);
                break;
            case STRING:
                allocate.put(b.a((String) dVar.h, dVar.g));
                break;
            case INT:
            case UINT:
                long longValue = ((Long) dVar.h).longValue();
                switch (dVar.f) {
                    case BYTE:
                        allocate.put((byte) ((int) (longValue & 255)));
                        break;
                    case SHORT:
                        allocate.putShort((short) ((int) (longValue & 65535)));
                        break;
                    case WORD:
                        allocate.putInt((int) (longValue & -1));
                        break;
                    default:
                        break;
                }
        }
        allocate.rewind();
        return allocate;
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            Object b = super.b();
            jSONObject.put("instance", getClass().getSimpleName());
            String str = "contents";
            if (b == null) {
                b = "((null))";
            }
            jSONObject.put(str, b);
            return jSONObject;
        } catch (Throwable e) {
            f.b("BinaryPebbleDictionary", "toJson: ", e);
            return null;
        }
    }
}
