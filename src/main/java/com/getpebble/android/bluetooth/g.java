package com.getpebble.android.bluetooth;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.bluetooth.b.d;

public abstract class g {
    private final Handler a = new Handler(Looper.getMainLooper());
    protected final PebbleDevice d;
    protected final e e;
    protected final Context f;

    public static class a {
        public final a a;
        public final d b;
        public final String c;
        public final int d;
        public final com.getpebble.android.bluetooth.e.g.a e;
        public final Boolean f;

        public enum a {
            SUCCESS,
            NOT_AVAILABLE,
            NOT_BONDED,
            TIMEOUT
        }

        public a(a aVar, d dVar) {
            this(aVar, dVar, null, 99999, null, null);
        }

        public a(a aVar, d dVar, String str, int i, com.getpebble.android.bluetooth.e.g.a aVar2, Boolean bool) {
            this.a = aVar;
            this.b = dVar;
            this.c = str;
            this.d = i;
            this.e = aVar2;
            this.f = bool;
        }

        public String toString() {
            return "[result = " + this.a + ", reason = " + this.b + ", newAddress = " + this.c + ", failingGattStatus = " + this.d + ", failingState = " + this.e + "]";
        }
    }

    protected abstract void e();

    public abstract void f();

    public abstract void g();

    protected g(PebbleDevice pebbleDevice, e eVar, Context context) {
        this.f = context;
        this.d = pebbleDevice;
        this.e = eVar;
    }

    protected void a() {
        e();
    }

    protected void a(final f fVar) {
        this.a.post(new Runnable(this) {
            final /* synthetic */ g b;

            public void run() {
                this.b.e.a(this.b.d, fVar);
            }
        });
    }

    protected void a(final a aVar) {
        a();
        this.a.post(new Runnable(this) {
            final /* synthetic */ g b;

            public void run() {
                this.b.e.a(this.b.d, aVar);
            }
        });
    }

    protected int h() {
        return VERSION.SDK_INT;
    }
}
