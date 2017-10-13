package com.getpebble.android.notifications.a.a;

public class f extends i {
    private final String d;

    public f(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str2;
    }

    public f(i iVar, String str) {
        this.a = iVar.b();
        this.d = iVar.c();
        this.b = str;
        this.c = iVar.c;
    }

    public String a() {
        return this.d;
    }

    public String toString() {
        return "NotificationContent{title='" + this.a + '\'' + ", body='" + this.b + '\'' + ", summary='" + this.c + '\'' + ", rawBody='" + this.d + '\'' + '}';
    }
}
