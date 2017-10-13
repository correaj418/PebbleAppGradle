package com.getpebble.android.common.d;

public class c implements Comparable<c> {
    @com.google.b.a.c(a = "major")
    private int a;
    @com.google.b.a.c(a = "minor")
    private int b;

    public /* synthetic */ int compareTo(Object obj) {
        return a((c) obj);
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int a(c cVar) {
        if (a() < cVar.a()) {
            return -1;
        }
        if (a() > cVar.a()) {
            return 1;
        }
        if (b() < cVar.b()) {
            return -1;
        }
        if (b() > cVar.b()) {
            return 1;
        }
        return 0;
    }

    public int hashCode() {
        return (71 * (Integer.valueOf(a()).hashCode() + 923)) + Integer.valueOf(b()).hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!(a() == cVar.a() && b() == cVar.b())) {
            z = false;
        }
        return z;
    }
}
