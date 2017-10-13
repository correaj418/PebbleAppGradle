package com.getpebble.android.notifications.a.a;

public class i {
    protected String a;
    protected String b;
    protected String c;

    public i(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public String b() {
        return this.a;
    }

    void a(String str) {
        this.a = str;
    }

    public String c() {
        return this.b;
    }

    void b(String str) {
        this.b = str;
    }

    public String d() {
        return this.c;
    }

    void c(String str) {
        this.c = str;
    }

    public String toString() {
        return "RawNotificationContent{title='" + this.a + '\'' + ", body='" + this.b + '\'' + ", summary='" + this.c + '\'' + '}';
    }
}
