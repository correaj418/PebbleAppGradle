package com.getpebble.android.framework.health.d;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.model.a.t;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.h.k;
import com.getpebble.android.h.l;
import com.google.a.b.am;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Set;

public class a implements com.getpebble.android.framework.health.a.a.a {
    public final int a;
    public final a b;
    public final long c;
    public final long d;
    public final int e;
    public final long f;
    public final long g;
    public final int h;
    public final long i;
    public final long j;
    public final long k;

    public enum a {
        Unknown(0, R.string.sleep_activity_type, "sleep", "unknown"),
        Sleep(1, R.string.sleep_activity_type, "sleep", "sleep"),
        DeepSleep(2, R.string.deep_sleep_activity_type, "sleep.deep", "deepSleep"),
        Nap(3, R.string.nap_activity_type, "sleep", "nap"),
        DeepNap(4, R.string.deep_nap_activity_type, "sleep.deep", "deepNap"),
        Walk(5, R.string.walk_activity_type, "walking", "longWalk"),
        Run(6, R.string.run_activity_type, "running", "run");
        
        private static final Set<a> ACTIVITY_TYPES = null;
        private static final Set<a> SLEEP_TYPES = null;
        public final int activityTypeRes;
        public final String googleFitFitnessActivity;
        public final String jsName;
        public final int num;

        static {
            SLEEP_TYPES = am.a(Sleep, DeepSleep, Nap, DeepNap);
            ACTIVITY_TYPES = am.a(Walk, Run);
        }

        private a(int i, int i2, String str, String str2) {
            this.num = i;
            this.activityTypeRes = i2;
            this.googleFitFitnessActivity = str;
            this.jsName = str2;
        }

        public static a from(int i) {
            for (a aVar : values()) {
                if (aVar.num == i) {
                    return aVar;
                }
            }
            return Unknown;
        }

        public String getName(Context context) {
            return context.getString(this.activityTypeRes);
        }

        public static Set<a> sleepTypes() {
            return SLEEP_TYPES;
        }

        public boolean isSleep() {
            return sleepTypes().contains(this);
        }

        public static Set<a> activityTypes() {
            return ACTIVITY_TYPES;
        }
    }

    public a(int i, a aVar, int i2, long j, long j2, long j3, long j4, int i3, long j5, long j6, long j7) {
        this.a = i;
        this.b = aVar;
        this.e = i2;
        this.c = j;
        this.d = j2;
        this.f = j3;
        this.g = j4;
        this.h = i3;
        this.j = j5;
        this.k = j6;
        this.i = j7;
    }

    public a(int i, a aVar, int i2, long j, long j2, int i3, long j3, long j4, long j5) {
        this(i, aVar, i2, j, j2, j + ((long) i2), j2 + ((long) i2), i3, j3, j4, j5);
    }

    public a(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.e = aVar.e;
        this.c = aVar.c;
        this.d = aVar.d;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.j = aVar.j;
        this.k = aVar.k;
        this.i = aVar.i;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.a != aVar.a || this.c != aVar.c || this.d != aVar.d || this.e != aVar.e || this.f != aVar.f || this.g != aVar.g || this.h != aVar.h || this.i != aVar.i || this.j != aVar.j || this.k != aVar.k) {
            return false;
        }
        if (this.b != aVar.b) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((((((((((((((((this.b != null ? this.b.hashCode() : 0) + (this.a * 31)) * 31) + ((int) (this.c ^ (this.c >>> 32)))) * 31) + ((int) (this.d ^ (this.d >>> 32)))) * 31) + this.e) * 31) + ((int) (this.f ^ (this.f >>> 32)))) * 31) + ((int) (this.g ^ (this.g >>> 32)))) * 31) + this.h) * 31) + ((int) (this.i ^ (this.i >>> 32)))) * 31) + ((int) (this.j ^ (this.j >>> 32)))) * 31) + ((int) (this.k ^ (this.k >>> 32)));
    }

    public static a a(ContentResolver contentResolver, byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        try {
            int intValue = b.b(wrap).intValue();
            if ((intValue & 1) < 1) {
                throw new IllegalArgumentException("Can't parse activity record with bit 0 unset");
            }
            b.b(wrap).intValue();
            short s = wrap.getShort();
            a from = a.from(s);
            if (from == a.Unknown) {
                throw new IllegalArgumentException("Unknown activity type: " + s);
            }
            int i;
            int i2;
            int i3 = wrap.getInt();
            long longValue = b.c(wrap).longValue();
            long longValue2 = b.c(wrap).longValue();
            int i4 = 0;
            int i5 = 0;
            if (intValue < 3 || !(from.equals(a.Walk) || from.equals(a.Run))) {
                i = 0;
                i2 = 0;
            } else {
                i4 = b.b(wrap).intValue();
                int intValue2 = b.b(wrap).intValue();
                int intValue3 = b.b(wrap).intValue();
                i5 = b.b(wrap).intValue();
                i = intValue3;
                i2 = intValue2;
            }
            return new a(t.a(contentResolver, ak.retrieveLastConnectedDeviceSerial()), from, i3, longValue, longValue + longValue2, i4, l.KILO_CALORIES.toGramCalories(i2), l.KILO_CALORIES.toGramCalories(i), k.METRES.toMillimetres((long) i5));
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public ContentValues d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("watch_id", Integer.valueOf(this.a));
        contentValues.put("type", Integer.valueOf(this.b.num));
        contentValues.put("start_utc_secs", Long.valueOf(this.c));
        contentValues.put("end_utc_secs", Long.valueOf(this.d));
        contentValues.put("utc_to_local_secs", Integer.valueOf(this.e));
        contentValues.put("start_local_secs", Long.valueOf(this.f));
        contentValues.put("end_local_secs", Long.valueOf(this.g));
        contentValues.put("step_count", Integer.valueOf(this.h));
        contentValues.put("distance_mm", Long.valueOf(this.i));
        contentValues.put("resting_gcal", Long.valueOf(this.k));
        contentValues.put("active_gcal", Long.valueOf(this.j));
        return contentValues;
    }

    public long a() {
        return this.c;
    }

    public long b() {
        return this.d - this.c;
    }

    public String a(Context context) {
        return this.b.getName(context);
    }

    public String c() {
        return this.b.googleFitFitnessActivity;
    }
}
