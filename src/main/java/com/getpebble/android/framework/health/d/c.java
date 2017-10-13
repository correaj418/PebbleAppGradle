package com.getpebble.android.framework.health.d;

import com.getpebble.android.common.model.u;
import com.google.a.b.am;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class c {
    private final a a;
    private final b[] b;

    public static class a {
        public final int a;
        public final long b;
        public final int c;
        public final int d;
        public final int e;

        public a(int i, long j, int i2, int i3, int i4) {
            this.a = i;
            this.b = j;
            this.c = (int) (TimeUnit.MINUTES.toSeconds(15) * ((long) i2));
            this.d = i3;
            this.e = i4;
        }

        public String toString() {
            return String.format("version = %s, timeUtcSeconds = %s, utcOffsetSeconds = %s, sampleSize = %s, numSamples = %s", new Object[]{Integer.valueOf(this.a), Long.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e)});
        }
    }

    public static class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final Integer j;
        public final Byte k;

        public b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Integer num, Byte b) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = i9;
            this.j = num;
            this.k = b;
        }

        public boolean a() {
            return (this.e & 1) > 0;
        }

        public boolean b() {
            return (this.e & 2) > 0;
        }

        public String toString() {
            return "Sample{steps=" + this.a + ", orientation=" + this.b + ", vmc=" + this.c + ", light=" + this.d + ", flags=" + this.e + ", restingGramCalories=" + this.f + ", activeGramCalories=" + this.g + ", distanceCm=" + this.h + ", heartRate=" + this.i + ", heartRateWeight=" + this.j + ", heartRateZone=" + this.k + '}';
        }
    }

    public enum c {
        VERSION_FW_3_10_AND_UNDER(5, 6),
        VERSION_FW_3_11(6, 12),
        VERSION_FW_4_0(7, 13),
        VERSION_FW_4_1(8, 15),
        VERSION_FW_4_3(13, 16);
        
        public static final c LATEST = null;
        public final int number;
        public final int payloadSize;

        static {
            LATEST = VERSION_FW_4_3;
        }

        private c(int i, int i2) {
            this.number = i;
            this.payloadSize = i2;
        }

        public static c from(int i) {
            for (c cVar : values()) {
                if (cVar.number == i) {
                    return cVar;
                }
            }
            return LATEST;
        }
    }

    public c(a aVar, b[] bVarArr) {
        this.a = aVar;
        this.b = bVarArr;
    }

    public a a() {
        return this.a;
    }

    public Set<u> b() {
        if (this.b.length == 0) {
            return am.h();
        }
        Set<u> hashSet = new HashSet();
        long toSeconds = this.a.b + (((long) this.a.e) * TimeUnit.MINUTES.toSeconds(1));
        hashSet.add(u.from(this.a.b, this.a.c));
        hashSet.add(u.from(toSeconds, this.a.c));
        return hashSet;
    }

    public b[] c() {
        return this.b;
    }

    public String toString() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder("MinuteLevelSamplesRecord: ");
        stringBuilder.append(String.format("Header: %s ", new Object[]{this.a.toString()}));
        while (i < c().length) {
            stringBuilder.append(c()[i].toString());
            i++;
        }
        return stringBuilder.toString();
    }
}
