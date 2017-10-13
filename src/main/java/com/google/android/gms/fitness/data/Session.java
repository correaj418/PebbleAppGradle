package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.d;
import java.util.concurrent.TimeUnit;

public class Session extends AbstractSafeParcelable {
    public static final Creator<Session> CREATOR = new o();
    private final int a;
    private final long b;
    private final long c;
    private final String d;
    private final String e;
    private final String f;
    private final int g;
    private final Application h;
    private final Long i;

    public static class a {
        private long a = 0;
        private long b = 0;
        private String c = null;
        private String d;
        private String e;
        private int f = 4;
        private Long g;

        public a a(int i) {
            this.f = i;
            return this;
        }

        public a a(long j, TimeUnit timeUnit) {
            b.a(j > 0, (Object) "Start time should be positive.");
            this.a = timeUnit.toMillis(j);
            return this;
        }

        public a a(String str) {
            b.b(str.length() <= 100, "Session name cannot exceed %d characters", Integer.valueOf(100));
            this.c = str;
            return this;
        }

        public Session a() {
            boolean z = false;
            b.a(this.a > 0, (Object) "Start time should be specified.");
            if (this.b == 0 || this.b > this.a) {
                z = true;
            }
            b.a(z, (Object) "End time should be later than start time.");
            if (this.d == null) {
                String str = this.c == null ? "" : this.c;
                this.d = new StringBuilder(String.valueOf(str).length() + 20).append(str).append(this.a).toString();
            }
            return new Session();
        }

        public a b(long j, TimeUnit timeUnit) {
            b.a(j >= 0, (Object) "End time should be positive.");
            this.b = timeUnit.toMillis(j);
            return this;
        }

        public a b(String str) {
            return a(d.a(str));
        }

        public a c(long j, TimeUnit timeUnit) {
            this.g = Long.valueOf(timeUnit.toMillis(j));
            return this;
        }
    }

    Session(int i, long j, long j2, String str, String str2, String str3, int i2, Application application, Long l) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = i2;
        this.h = application;
        this.i = l;
    }

    public Session(long j, long j2, String str, String str2, String str3, int i, Application application, Long l) {
        this(3, j, j2, str, str2, str3, i, application, l);
    }

    private Session(a aVar) {
        this(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, null, aVar.g);
    }

    private boolean a(Session session) {
        return this.b == session.b && this.c == session.c && ab.a(this.d, session.d) && ab.a(this.e, session.e) && ab.a(this.f, session.f) && ab.a(this.h, session.h) && this.g == session.g;
    }

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(this.b, TimeUnit.MILLISECONDS);
    }

    public String a() {
        return this.d;
    }

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(this.c, TimeUnit.MILLISECONDS);
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public int d() {
        return this.g;
    }

    public Application e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Session) && a((Session) obj));
    }

    int f() {
        return this.a;
    }

    public long g() {
        return this.b;
    }

    public long h() {
        return this.c;
    }

    public int hashCode() {
        return ab.a(Long.valueOf(this.b), Long.valueOf(this.c), this.e);
    }

    public Long i() {
        return this.i;
    }

    public String toString() {
        return ab.a((Object) this).a("startTime", Long.valueOf(this.b)).a("endTime", Long.valueOf(this.c)).a("name", this.d).a("identifier", this.e).a("description", this.f).a("activity", Integer.valueOf(this.g)).a("application", this.h).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        o.a(this, parcel, i);
    }
}
