package android.support.v7.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.ab;
import android.support.v4.app.ac;
import android.support.v4.app.ac.s;
import android.support.v4.media.session.MediaSessionCompat.Token;

public class c extends ac {

    public static class a extends android.support.v4.app.ac.d {
        public a(Context context) {
            super(context);
        }

        protected e c() {
            if (VERSION.SDK_INT >= 21) {
                return new d();
            }
            if (VERSION.SDK_INT >= 16) {
                return new c();
            }
            if (VERSION.SDK_INT >= 14) {
                return new b();
            }
            return super.c();
        }
    }

    private static class b extends e {
        private b() {
        }

        public Notification a(android.support.v4.app.ac.d dVar, ab abVar) {
            c.b(abVar, dVar);
            return abVar.b();
        }
    }

    private static class c extends e {
        private c() {
        }

        public Notification a(android.support.v4.app.ac.d dVar, ab abVar) {
            c.b(abVar, dVar);
            Notification b = abVar.b();
            c.b(b, dVar);
            return b;
        }
    }

    private static class d extends e {
        private d() {
        }

        public Notification a(android.support.v4.app.ac.d dVar, ab abVar) {
            c.d(abVar, dVar.m);
            return abVar.b();
        }
    }

    public static class e extends s {
        int[] a = null;
        Token b;
        boolean c;
        PendingIntent g;
    }

    private static void d(ab abVar, s sVar) {
        if (sVar instanceof e) {
            e eVar = (e) sVar;
            d.a(abVar, eVar.a, eVar.b != null ? eVar.b.a() : null);
        }
    }

    private static void b(ab abVar, android.support.v4.app.ac.d dVar) {
        if (dVar.m instanceof e) {
            e eVar = (e) dVar.m;
            e.a(abVar, dVar.a, dVar.b, dVar.c, dVar.h, dVar.i, dVar.g, dVar.n, dVar.l, dVar.F.when, dVar.v, eVar.a, eVar.c, eVar.g);
        }
    }

    private static void b(Notification notification, android.support.v4.app.ac.d dVar) {
        if (dVar.m instanceof e) {
            e eVar = (e) dVar.m;
            e.a(notification, dVar.a, dVar.b, dVar.c, dVar.h, dVar.i, dVar.g, dVar.n, dVar.l, dVar.F.when, dVar.v, eVar.c, eVar.g);
        }
    }
}
