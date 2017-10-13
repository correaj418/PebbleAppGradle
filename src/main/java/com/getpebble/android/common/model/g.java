package com.getpebble.android.common.model;

import android.net.Uri;
import android.text.TextUtils;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.google.b.a.c;

public class g extends f implements h {
    @c(a = "type")
    private String a;
    @c(a = "author_email")
    private String b;
    @c(a = "uuid")
    private String c;
    @c(a = "hearts")
    private int d;
    @c(a = "icon_image")
    private String e;
    @c(a = "screenshot_images")
    private String[] f;
    @c(a = "android_companion_url")
    private String g;
    @c(a = "asset_collections")
    private a[] h;
    @c(a = "capabilities")
    private String[] i;

    private static class a {
        @c(a = "hardware_platform")
        private String a;
        @c(a = "screenshots")
        private String[] b;

        public com.getpebble.android.common.framework.install.app.b.a a() {
            return com.getpebble.android.common.framework.install.app.b.a.fromString(this.a);
        }

        public String[] b() {
            return this.b;
        }
    }

    public String getType() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String getUUID() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public String[] e() {
        a j = j();
        if (j == null || j.b().length == 0) {
            return this.f;
        }
        return j.b();
    }

    public String f() {
        if (TextUtils.isEmpty(this.g)) {
            return null;
        }
        return Uri.parse(this.g).getQueryParameter("id");
    }

    public boolean g() {
        return this.a.equals("companion-app");
    }

    public boolean h() {
        return this.a.equals("watchface");
    }

    private a j() {
        com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
        if (p == null || p.hwPlatform == null || this.h == null) {
            return null;
        }
        for (a aVar : this.h) {
            if (aVar.a() == p.hwPlatform.getPlatformCode()) {
                return aVar;
            }
        }
        return null;
    }

    public boolean i() {
        if (this.i == null) {
            return false;
        }
        for (String contains : this.i) {
            if (contains.contains(com.getpebble.android.common.a.K().getString(R.string.health))) {
                return true;
            }
        }
        return false;
    }
}
