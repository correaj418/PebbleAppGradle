package com.google.b.b.a;

import com.google.b.c.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.u;
import com.google.b.w;
import com.google.b.x;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class k extends w<Time> {
    public static final x a = new x() {
        public <T> w<T> a(f fVar, a<T> aVar) {
            return aVar.getRawType() == Time.class ? new k() : null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    public /* synthetic */ Object b(com.google.b.d.a aVar) {
        return a(aVar);
    }

    public synchronized Time a(com.google.b.d.a aVar) {
        Time time;
        if (aVar.f() == b.NULL) {
            aVar.j();
            time = null;
        } else {
            try {
                time = new Time(this.b.parse(aVar.h()).getTime());
            } catch (Throwable e) {
                throw new u(e);
            }
        }
        return time;
    }

    public synchronized void a(c cVar, Time time) {
        cVar.b(time == null ? null : this.b.format(time));
    }
}
