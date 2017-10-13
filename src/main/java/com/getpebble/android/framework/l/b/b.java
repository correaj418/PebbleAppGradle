package com.getpebble.android.framework.l.b;

import android.text.TextUtils;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.l.a.z;
import com.getpebble.android.h.aa;
import com.getpebble.android.h.ab;
import com.google.a.f.e;
import java.io.NotSerializableException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.ParseException;
import java.util.TimeZone;

public class b {

    public enum a {
        REMINDER("reminder", z.REMINDER, c.VALUE),
        DATETIME("datetime", z.DATE, c.DATETIME),
        TIME_OF_DAY("time_of_day", null, c.TIME_OF_DAY);
        
        final z attributeType;
        public final String nlpKey;
        final c propertyType;

        private a(String str, z zVar, c cVar) {
            this.nlpKey = str;
            this.attributeType = zVar;
            this.propertyType = cVar;
        }

        public static a from(z zVar) {
            for (a aVar : values()) {
                if (aVar.attributeType != null && aVar.attributeType.equals(zVar)) {
                    return aVar;
                }
            }
            return null;
        }

        public static a from(String str) {
            for (a aVar : values()) {
                if (aVar.nlpKey.equals(str)) {
                    return aVar;
                }
            }
            return null;
        }
    }

    interface b {
        byte[] a(com.getpebble.android.g.a.b.a.a aVar, ByteOrder byteOrder, com.getpebble.android.g.a.b bVar);
    }

    enum c {
        VALUE(new b() {
            public byte[] a(com.getpebble.android.g.a.b.a.a aVar, ByteOrder byteOrder, com.getpebble.android.g.a.b bVar) {
                String str = aVar.b;
                if (!TextUtils.isEmpty(str)) {
                    return aa.a(str).getBytes(com.getpebble.android.bluetooth.b.b.b);
                }
                throw new NotSerializableException("property.value is empty");
            }
        }),
        DATETIME(new b() {
            public byte[] a(com.getpebble.android.g.a.b.a.a aVar, ByteOrder byteOrder, com.getpebble.android.g.a.b bVar) {
                Throwable e;
                String str = null;
                try {
                    switch (aVar.a()) {
                        case INTERVAL:
                            str = aVar.c.b;
                            break;
                        case VALUE:
                            str = aVar.b;
                            break;
                    }
                    if (TextUtils.isEmpty(str)) {
                        throw new IllegalArgumentException("date field is empty, type is " + aVar.a().name());
                    }
                    c.b.a.b a = ab.a(ab.b(str), TimeZone.getDefault());
                    com.getpebble.android.g.a.b.a.a a2 = bVar.a(a.TIME_OF_DAY.nlpKey);
                    if (a2 != null) {
                        a = a.a(a(a2), 0, 0, 0);
                    }
                    return com.getpebble.android.bluetooth.b.b.a(e.a(a.c() / 1000), byteOrder);
                } catch (ParseException e2) {
                    e = e2;
                    f.b("NlpResultSerializer", "Failed to parse NLP datetime string (" + null + ")", e);
                    throw new NotSerializableException("Failed to parse date time string, serialization not possible.");
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    f.b("NlpResultSerializer", "Failed to parse NLP datetime string (" + null + ")", e);
                    throw new NotSerializableException("Failed to parse date time string, serialization not possible.");
                }
            }

            private int a(com.getpebble.android.g.a.b.a.a aVar) {
                if (aVar.b.equals("morning")) {
                    return 9;
                }
                if (aVar.b.equals("afternoon")) {
                    return 14;
                }
                if (aVar.b.equals("evening")) {
                    return 18;
                }
                throw new IllegalArgumentException("No recognizable time of day.");
            }
        }),
        TIME_OF_DAY(null);
        
        final b serializer;

        private c(b bVar) {
            this.serializer = bVar;
        }
    }

    public byte a(com.getpebble.android.g.a.b bVar, ByteBuffer byteBuffer, ByteOrder byteOrder) {
        a[] values = a.values();
        int length = values.length;
        int i = 0;
        byte b = (byte) 0;
        while (i < length) {
            byte b2;
            a aVar = values[i];
            if (a(aVar, bVar, byteBuffer, aVar.propertyType.serializer, byteOrder)) {
                b2 = (byte) (b + 1);
            } else {
                b2 = b;
            }
            i++;
            b = b2;
        }
        return b;
    }

    boolean a(a aVar, com.getpebble.android.g.a.b bVar, ByteBuffer byteBuffer, b bVar2, ByteOrder byteOrder) {
        com.getpebble.android.g.a.b.a.a a = bVar.a(aVar.nlpKey);
        if (a == null) {
            f.c("NlpResultSerializer", "Property " + aVar.name() + " does not exist in input NLP result, cannot serialize");
            return false;
        } else if (bVar2 == null) {
            throw new NotSerializableException("Serializer not found for property " + aVar.name());
        } else if (aVar.attributeType == null) {
            throw new NotSerializableException("No watch attribute for property " + aVar.name());
        } else {
            try {
                byte[] a2 = bVar2.a(a, byteBuffer.order(), bVar);
                byteBuffer.put(aVar.attributeType.toByte());
                byteBuffer.put(com.getpebble.android.bluetooth.b.b.b(e.a((long) a2.length), byteOrder));
                byteBuffer.put(a2);
                return true;
            } catch (NotSerializableException e) {
                f.b("NlpResultSerializer", "Unable to serialize property " + aVar.name());
                return false;
            }
        }
    }
}
