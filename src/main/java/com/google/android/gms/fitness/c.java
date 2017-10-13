package com.google.android.gms.fitness;

import android.os.Build.VERSION;
import com.google.android.gms.b.bb;
import com.google.android.gms.b.bc;
import com.google.android.gms.b.bd;
import com.google.android.gms.b.be;
import com.google.android.gms.b.bf;
import com.google.android.gms.b.bg;
import com.google.android.gms.b.bh;
import com.google.android.gms.b.ca;
import com.google.android.gms.b.cc;
import com.google.android.gms.b.cd;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.cf;
import com.google.android.gms.b.cg;
import com.google.android.gms.b.ch;
import com.google.android.gms.b.ci;
import com.google.android.gms.b.ck;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.a.b;
import com.google.android.gms.common.api.a.g;

public class c {
    public static final Scope A = new Scope("https://www.googleapis.com/auth/fitness.body.read");
    public static final Scope B = new Scope("https://www.googleapis.com/auth/fitness.body.write");
    public static final Scope C = new Scope("https://www.googleapis.com/auth/fitness.nutrition.read");
    public static final Scope D = new Scope("https://www.googleapis.com/auth/fitness.nutrition.write");
    public static final g<bb> a = new g();
    public static final g<bc> b = new g();
    public static final g<bd> c = new g();
    public static final g<be> d = new g();
    public static final g<bf> e = new g();
    public static final g<bg> f = new g();
    public static final g<bh> g = new g();
    @Deprecated
    public static final Void h = null;
    public static final a<b> i = new a("Fitness.SENSORS_API", new bg.a(), f);
    public static final g j = new ch();
    public static final a<b> k = new a("Fitness.RECORDING_API", new bf.a(), e);
    public static final f l = new cg();
    public static final a<b> m = new a("Fitness.SESSIONS_API", new bh.b(), g);
    public static final h n = new ci();
    public static final a<b> o = new a("Fitness.HISTORY_API", new bd.b(), c);
    public static final e p = new ce();
    public static final a<b> q = new a("Fitness.CONFIG_API", new bc.a(), b);
    public static final b r = new cd();
    public static final a<b> s = new a("Fitness.BLE_API", new bb.a(), a);
    public static final a t = a();
    public static final a<b> u = new a("Fitness.INTERNAL_API", new be.a(), d);
    public static final ca v = new cf();
    public static final Scope w = new Scope("https://www.googleapis.com/auth/fitness.activity.read");
    public static final Scope x = new Scope("https://www.googleapis.com/auth/fitness.activity.write");
    public static final Scope y = new Scope("https://www.googleapis.com/auth/fitness.location.read");
    public static final Scope z = new Scope("https://www.googleapis.com/auth/fitness.location.write");

    private static a a() {
        return VERSION.SDK_INT >= 18 ? new cc() : new ck();
    }
}
