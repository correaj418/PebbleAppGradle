package com.getpebble.android.framework.i.a;

public class b {
    private final String a;
    private final String b;

    public String a() {
        return this.a;
    }

    public String toString() {
        return "GroupKey{pkg='" + this.a + '\'' + ", groupKey='" + this.b + '\'' + '}';
    }

    private b(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static b a(com.getpebble.android.notifications.a.b bVar) {
        return new b(bVar.g(), bVar.q());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.b == null ? bVar.b != null : !this.b.equals(bVar.b)) {
            return false;
        }
        if (this.a != null) {
            if (this.a.equals(bVar.a)) {
                return true;
            }
        } else if (bVar.a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.a != null) {
            hashCode = this.a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.b != null) {
            i = this.b.hashCode();
        }
        return hashCode + i;
    }
}
