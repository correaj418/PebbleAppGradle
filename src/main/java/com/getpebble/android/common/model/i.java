package com.getpebble.android.common.model;

import android.text.TextUtils;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class i implements Comparable<i> {
    private static final Pattern e = Pattern.compile("^([\\d]+)(?:\\.([\\d]+))?.*");
    private final int a;
    private final int b;
    private final String c;
    private final boolean d;

    public /* synthetic */ int compareTo(Object obj) {
        return a((i) obj);
    }

    public i(String str) {
        if (str == null) {
            str = "";
        }
        this.c = str;
        Matcher matcher = e.matcher(this.c);
        if (matcher.matches()) {
            this.a = Integer.valueOf(matcher.group(1)).intValue();
            Object group = matcher.group(2);
            if (TextUtils.isEmpty(group)) {
                this.b = 0;
            } else {
                this.b = Integer.valueOf(group).intValue();
            }
            this.d = e();
            return;
        }
        this.d = false;
        this.a = 0;
        this.b = 0;
    }

    public i(int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = i + "." + i2;
        this.d = e();
    }

    private boolean e() {
        if (this.a < 0 || this.a > 255) {
            f.b("AppVersion", "major version: " + this.a + " is not valid");
            return false;
        } else if (this.b >= 0 && this.b <= 255) {
            return true;
        } else {
            f.b("AppVersion", "minor version: " + this.b + " is not valid");
            return false;
        }
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.d;
    }

    public String d() {
        return this.c;
    }

    public String toString() {
        return d() + " (" + this.a + " / " + this.b + ") isValidVersion = " + c();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            return a.a(((i) obj).d(), d());
        }
        return false;
    }

    public int hashCode() {
        return this.c != null ? this.c.hashCode() : 0;
    }

    public int a(i iVar) {
        if (iVar == null || !c() || !iVar.c()) {
            return 0;
        }
        if (a() < iVar.a()) {
            return -1;
        }
        if (a() > iVar.a()) {
            return 1;
        }
        if (b() < iVar.b()) {
            return -1;
        }
        if (b() > iVar.b()) {
            return 1;
        }
        return 0;
    }
}
