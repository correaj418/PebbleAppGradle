package com.google.b;

import com.google.b.b.a;
import com.google.b.b.f;
import java.math.BigInteger;

public final class r extends l {
    private static final Class<?>[] a = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object b;

    public r(Boolean bool) {
        a((Object) bool);
    }

    public r(Number number) {
        a((Object) number);
    }

    public r(String str) {
        a((Object) str);
    }

    r(Object obj) {
        a(obj);
    }

    void a(Object obj) {
        if (obj instanceof Character) {
            this.b = String.valueOf(((Character) obj).charValue());
            return;
        }
        boolean z = (obj instanceof Number) || b(obj);
        a.a(z);
        this.b = obj;
    }

    public boolean a() {
        return this.b instanceof Boolean;
    }

    Boolean o() {
        return (Boolean) this.b;
    }

    public boolean g() {
        if (a()) {
            return o().booleanValue();
        }
        return Boolean.parseBoolean(c());
    }

    public boolean p() {
        return this.b instanceof Number;
    }

    public Number b() {
        return this.b instanceof String ? new f((String) this.b) : (Number) this.b;
    }

    public boolean q() {
        return this.b instanceof String;
    }

    public String c() {
        if (p()) {
            return b().toString();
        }
        if (a()) {
            return o().toString();
        }
        return (String) this.b;
    }

    public double d() {
        return p() ? b().doubleValue() : Double.parseDouble(c());
    }

    public long e() {
        return p() ? b().longValue() : Long.parseLong(c());
    }

    public int f() {
        return p() ? b().intValue() : Integer.parseInt(c());
    }

    private static boolean b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class cls = obj.getClass();
        for (Class isAssignableFrom : a) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.b == null) {
            return 31;
        }
        long longValue;
        if (a(this)) {
            longValue = b().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.b instanceof Number)) {
            return this.b.hashCode();
        } else {
            longValue = Double.doubleToLongBits(b().doubleValue());
            return (int) (longValue ^ (longValue >>> 32));
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.b == null) {
            if (rVar.b != null) {
                return false;
            }
            return true;
        } else if (a(this) && a(rVar)) {
            if (b().longValue() != rVar.b().longValue()) {
                return false;
            }
            return true;
        } else if (!(this.b instanceof Number) || !(rVar.b instanceof Number)) {
            return this.b.equals(rVar.b);
        } else {
            double doubleValue = b().doubleValue();
            double doubleValue2 = rVar.b().doubleValue();
            if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                z = true;
            }
            return z;
        }
    }

    private static boolean a(r rVar) {
        if (!(rVar.b instanceof Number)) {
            return false;
        }
        Number number = (Number) rVar.b;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }
}
