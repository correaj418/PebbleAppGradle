package com.getpebble.android.common.model;

import android.content.ContentValues;
import com.google.b.a.c;

public class aa {
    @c(a = "file")
    private String a;
    @c(a = "name")
    private String b;
    @c(a = "localName")
    private String c;
    @c(a = "hardware")
    private String d;
    @c(a = "ISOLocal")
    private String e;
    @c(a = "firmware")
    private String f;
    @c(a = "version")
    private int g;
    @c(a = "id")
    private String h;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public boolean i() {
        if (a() == null || b() == null || c() == null || d() == null || e() == null || f() == null || g() < 0 || h() == null) {
            return false;
        }
        return true;
    }

    public ContentValues j() {
        ContentValues contentValues = new ContentValues(new ab().a());
        contentValues.put("file_url", a());
        contentValues.put("language_name", b());
        contentValues.put("local_language_name", c());
        contentValues.put(ak.ISO_LOCALE, e());
        contentValues.put(ak.HW_PLATFORM, d());
        contentValues.put(ak.FW_VERSION, f());
        contentValues.put(ak.LANGUAGE_VERSION, Integer.valueOf(g()));
        contentValues.put("language_uid", h());
        contentValues.put("numeric_fw_version", Integer.valueOf(ab.a(new v(f(), 0))));
        return contentValues;
    }
}
