package com.getpebble.android.framework.jskit.a.a;

import com.getpebble.android.common.model.v;
import com.getpebble.android.h.p;
import com.google.b.a.c;

public class d {
    @c(a = "platform")
    final String a;
    @c(a = "model")
    final String b;
    @c(a = "language")
    final String c;
    @c(a = "firmware")
    final a d;

    static class a {
        @c(a = "major")
        final int a;
        @c(a = "minor")
        final int b;
        @c(a = "patch")
        final int c;
        @c(a = "suffix")
        final String d;

        public a(int i, int i2, int i3, String str) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = str;
        }

        public static a a(v vVar) {
            String suffix = vVar.getSuffix();
            if (suffix == null) {
                suffix = "";
            } else if (suffix.indexOf(45) == 0) {
                suffix = suffix.substring(1);
            }
            return new a(vVar.getMajor(), vVar.getMinor(), vVar.getPoint(), suffix);
        }
    }

    public d(String str, String str2, String str3, a aVar) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = aVar;
    }

    public static d a(com.getpebble.android.common.model.ak.a aVar) {
        return new d(aVar.hwPlatform.getPlatformCode().getCode(), aVar.color.getJsFriendlyName(), aVar.isoLocale, a.a(aVar.getFwVersion()));
    }

    public static d a(com.getpebble.android.common.model.ak.a aVar, com.getpebble.android.common.framework.install.app.b.a aVar2) {
        return new d(aVar2.getCode(), aVar2.defaultColor.getJsFriendlyName(), aVar.isoLocale, a.a(aVar.getFwVersion()));
    }

    public final String a() {
        return p.a(this);
    }
}
