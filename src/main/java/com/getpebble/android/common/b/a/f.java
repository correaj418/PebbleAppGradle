package com.getpebble.android.common.b.a;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;

public class f {

    enum a {
        ERROR,
        WARNING,
        INFO,
        DEBUG,
        DEVELOPER
    }

    public static void a(String str, String str2) {
        a(a.ERROR, str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        a(a.ERROR, str, str2, th);
    }

    public static void b(String str, String str2) {
        a(a.WARNING, str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        a(a.WARNING, str, str2, th);
    }

    public static void c(String str, String str2) {
        a(a.INFO, str, str2, null);
    }

    public static void c(String str, String str2, Throwable th) {
        a(a.INFO, str, str2, th);
    }

    public static void d(String str, String str2) {
        a(a.DEBUG, str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        a(a.DEBUG, str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        a(a.DEVELOPER, str, str2, th);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    private static void a(a aVar, String str, String str2, Throwable th) {
        d.a(aVar, str, str2, th);
    }

    public static void f(String str, String str2) {
        f(str, str2, null);
    }

    public static boolean a() {
        return "prod".equals("dev");
    }

    @SuppressLint({"NewApi"})
    public static void f(String str, String str2, Throwable th) {
        if (!a()) {
            a(str, str2, th);
        } else if (VERSION.SDK_INT < 19 || th == null) {
            throw new AssertionError(str + ": " + str2 + " cause: " + th);
        } else {
            throw new AssertionError(str + ": " + str2, th);
        }
    }
}
