package com.b.a.c;

import android.text.TextUtils;

public class j implements t, Cloneable {
    private final String a;
    private final String b;

    public j(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String toString() {
        return this.a + "=" + this.b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        j jVar = (j) obj;
        if (!(this.a.equals(jVar.a) && TextUtils.equals(this.b, jVar.b))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public Object clone() {
        return super.clone();
    }
}
