package com.google.b;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class a implements k<Date>, t<Date> {
    private final DateFormat a;
    private final DateFormat b;

    public /* synthetic */ Object deserialize(l lVar, Type type, j jVar) {
        return a(lVar, type, jVar);
    }

    a() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    a(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    public a(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    a(DateFormat dateFormat, DateFormat dateFormat2) {
        this.a = dateFormat;
        this.b = dateFormat2;
    }

    public l a(Date date, Type type, s sVar) {
        l rVar;
        synchronized (this.b) {
            rVar = new r(this.a.format(date));
        }
        return rVar;
    }

    public Date a(l lVar, Type type, j jVar) {
        if (lVar instanceof r) {
            Date a = a(lVar);
            if (type == Date.class) {
                return a;
            }
            if (type == Timestamp.class) {
                return new Timestamp(a.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(a.getTime());
            }
            throw new IllegalArgumentException(getClass() + " cannot deserialize to " + type);
        }
        throw new p("The date should be a string value");
    }

    private Date a(l lVar) {
        Date parse;
        synchronized (this.b) {
            try {
                parse = this.b.parse(lVar.c());
            } catch (ParseException e) {
                try {
                    parse = this.a.parse(lVar.c());
                } catch (ParseException e2) {
                    try {
                        parse = com.google.b.b.a.a.a.a(lVar.c(), new ParsePosition(0));
                    } catch (Throwable e3) {
                        throw new u(lVar.c(), e3);
                    }
                }
            }
        }
        return parse;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.class.getSimpleName());
        stringBuilder.append('(').append(this.b.getClass().getSimpleName()).append(')');
        return stringBuilder.toString();
    }
}
