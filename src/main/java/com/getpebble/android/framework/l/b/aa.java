package com.getpebble.android.framework.l.b;

import android.text.TextUtils;
import com.getpebble.android.common.framework.install.b;
import com.google.a.f.e;
import java.nio.ByteOrder;
import java.util.Arrays;

public class aa extends r {
    private a a;
    private e e;
    private e f;
    private e g;
    private b h;
    private int i;
    private String j;
    private byte[] k;
    private e l;
    private e m;

    public enum a {
        INIT((byte) 1),
        PUT((byte) 2),
        COMMIT((byte) 3),
        ABORT((byte) 4),
        INSTALL((byte) 5);
        
        private final byte mId;

        private a(byte b) {
            this.mId = b;
        }

        public byte getId() {
            return this.mId;
        }

        public static a fromId(byte b) {
            for (a aVar : values()) {
                if (aVar.getId() == b) {
                    return aVar;
                }
            }
            return null;
        }
    }

    private aa(a aVar, e eVar) {
        super(com.getpebble.android.bluetooth.g.a.PUT_BYTES);
        this.a = aVar;
        this.e = eVar;
    }

    private void c(e eVar) {
        this.f = eVar;
    }

    private void d(e eVar) {
        this.g = eVar;
    }

    private void a(b bVar) {
        this.h = bVar;
    }

    private void a(int i) {
        this.i = i;
    }

    private void a(String str) {
        this.j = str;
    }

    private void b(byte[] bArr) {
        this.k = bArr;
    }

    private void e(e eVar) {
        this.l = eVar;
    }

    private void f(e eVar) {
        this.m = eVar;
    }

    public static aa a(e eVar, b bVar, int i, String str, e eVar2) {
        return a(eVar, bVar, i, str, eVar2, null);
    }

    public static aa a(e eVar, b bVar, int i, String str, e eVar2, e eVar3) {
        aa aaVar = new aa(a.INIT, null);
        aaVar.c(eVar);
        aaVar.a(bVar);
        aaVar.a(i);
        aaVar.a(str);
        aaVar.f(eVar2);
        aaVar.d(eVar3);
        return aaVar;
    }

    private static boolean b(b bVar) {
        switch (bVar) {
            case APP:
            case APP_RESOURCES:
            case WORKER:
                return true;
            default:
                return false;
        }
    }

    private void b() {
        a(Byte.valueOf(this.a.getId()));
        a(com.getpebble.android.bluetooth.b.b.a(this.f));
        byte id = this.h.getId();
        int i = (!b(this.h) || this.m == null) ? 0 : 1;
        if (i != 0) {
            id = (byte) (id | 128);
        }
        a(Byte.valueOf(id));
        if (i != 0) {
            a(com.getpebble.android.bluetooth.b.b.a(this.m, ByteOrder.BIG_ENDIAN));
        } else {
            a(Byte.valueOf((byte) this.i));
            if (!TextUtils.isEmpty(this.j)) {
                com.getpebble.android.bluetooth.b.b.a((com.getpebble.android.bluetooth.b.b.a) this, this.j);
            }
        }
        if (this.g != null) {
            a(Byte.valueOf((byte) -66));
            a(Byte.valueOf((byte) 67));
            a(Byte.valueOf((byte) 84));
            a(Byte.valueOf((byte) -17));
            a(com.getpebble.android.bluetooth.b.b.a(this.g));
        }
    }

    public static aa a(e eVar, e eVar2, byte[] bArr) {
        aa aaVar = new aa(a.PUT, eVar);
        aaVar.c(eVar2);
        aaVar.b(bArr);
        return aaVar;
    }

    private void h() {
        a(Byte.valueOf(this.a.getId()));
        a(com.getpebble.android.bluetooth.b.b.a(this.e));
        a(com.getpebble.android.bluetooth.b.b.a(this.f));
        if (this.f.intValue() >= this.k.length) {
            a(this.k);
        } else {
            a(Arrays.copyOf(this.k, this.f.intValue()));
        }
    }

    public static aa a(e eVar, e eVar2) {
        aa aaVar = new aa(a.COMMIT, eVar);
        aaVar.e(eVar2);
        return aaVar;
    }

    private void i() {
        a(Byte.valueOf(this.a.getId()));
        a(com.getpebble.android.bluetooth.b.b.a(this.e));
        a(com.getpebble.android.bluetooth.b.b.a(this.l));
    }

    public static aa a(e eVar) {
        return new aa(a.ABORT, eVar);
    }

    public static aa b(e eVar) {
        return new aa(a.INSTALL, eVar);
    }

    private void j() {
        a(Byte.valueOf(this.a.getId()));
        a(com.getpebble.android.bluetooth.b.b.a(this.e));
    }

    public synchronized byte[] c_() {
        if (!d()) {
            switch (this.a) {
                case INIT:
                    b();
                    break;
                case PUT:
                    h();
                    break;
                case COMMIT:
                    i();
                    break;
                case ABORT:
                case INSTALL:
                    j();
                    break;
            }
        }
        return super.c_();
    }
}
