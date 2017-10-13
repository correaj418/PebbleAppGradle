package com.getpebble.android.h;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.o.d;
import com.getpebble.android.framework.o.d.a;
import com.getpebble.android.main.fragment.a.b;

public class z {
    private Intent a;
    private String b;
    private Uri c;
    private String d;
    private String e;
    private String f;
    private boolean g = false;
    private Bundle h;
    private b i;

    public z(Context context, Intent intent) {
        this.a = intent;
        if (this.a != null) {
            this.b = this.a.getAction();
            if (this.b != null && this.b.equals("android.intent.action.VIEW")) {
                this.c = this.a.getData();
                if (this.c != null) {
                    this.d = this.c.getScheme();
                    if (this.d != null) {
                        f.d("Sideloading", "uri = " + this.c + " scheme = " + this.d);
                        f.d("Sideloading", "type = " + intent.getType() + " dataString = " + intent.getDataString());
                        if (d.a(this.c)) {
                            this.e = d.a(context.getContentResolver(), this.c);
                        } else if (this.d.equals("http") || this.d.equals("https") || this.d.equals("file")) {
                            this.e = this.c.getPath();
                        }
                        if (this.e != null) {
                            a from = a.from(this.e);
                            if (!from.equals(a.ERROR)) {
                                this.f = from.getFileExtension();
                                this.g = true;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean a() {
        return this.g;
    }

    public b b() {
        if (this.i == null) {
            d();
        }
        return this.i;
    }

    public Bundle c() {
        if (this.h == null) {
            d();
        }
        return this.h;
    }

    private void d() {
        if (a()) {
            this.h = new Bundle();
            this.h.putParcelable("extra_sideloading_uri", this.c);
            this.h.putInt("extra_sideloading_type", a.from(this.f).code());
            this.i = b.MY_PEBBLE;
        }
    }
}
