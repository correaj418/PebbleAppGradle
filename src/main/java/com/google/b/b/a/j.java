package com.google.b.b.a;

import com.google.b.c.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.f;
import com.google.b.u;
import com.google.b.w;
import com.google.b.x;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class j extends w<Date> {
    public static final x a = new x() {
        public <T> w<T> a(f fVar, a<T> aVar) {
            return aVar.getRawType() == Date.class ? new j() : null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    public /* synthetic */ Object b(com.google.b.d.a aVar) {
        return a(aVar);
    }

    public synchronized Date a(com.google.b.d.a aVar) {
        Date date;
        if (aVar.f() == b.NULL) {
            aVar.j();
            date = null;
        } else {
            try {
                date = new Date(this.b.parse(aVar.h()).getTime());
            } catch (Throwable e) {
                throw new u(e);
            }
        }
        return date;
    }

    public synchronized void a(c cVar, Date date) {
        cVar.b(date == null ? null : this.b.format(date));
    }
}
