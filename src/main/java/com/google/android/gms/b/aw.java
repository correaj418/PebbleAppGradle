package com.google.android.gms.b;

import com.google.android.gms.b.f.b;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class aw {
    public static final com.google.android.gms.b.f.a A = a("com.google.body.waist.circumference", av.s);
    public static final com.google.android.gms.b.f.a B = a("com.google.body.hip.circumference", av.s);
    public static final com.google.android.gms.b.f.a C = a("com.google.nutrition", av.B, av.z, av.A);
    public static final com.google.android.gms.b.f.a D = a("com.google.activity.exercise", av.I, av.J, av.e, av.L, av.K);
    public static final Set<String> E = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{d.b, f.b, g.b, q.b, e.b, n.b, o.b, C.b, s.b, a.b, y.b})));
    public static final com.google.android.gms.b.f.a F = a("com.google.activity.summary", av.a, av.e, av.M);
    public static final com.google.android.gms.b.f.a G = a("com.google.floor_change.summary", av.g, av.h, av.D, av.E, av.G, av.H);
    public static final com.google.android.gms.b.f.a H = a;
    public static final com.google.android.gms.b.f.a I = q;
    public static final com.google.android.gms.b.f.a J = f;
    public static final com.google.android.gms.b.f.a K = g;
    public static final com.google.android.gms.b.f.a L = a("com.google.heart_rate.summary", av.N, av.O, av.P);
    public static final com.google.android.gms.b.f.a M = a("com.google.location.bounding_box", av.Q, av.R, av.S, av.T);
    public static final com.google.android.gms.b.f.a N = a("com.google.power.summary", av.N, av.O, av.P);
    public static final com.google.android.gms.b.f.a O = a("com.google.speed.summary", av.N, av.O, av.P);
    public static final com.google.android.gms.b.f.a P = a("com.google.weight.summary", av.N, av.O, av.P);
    public static final com.google.android.gms.b.f.a Q = a("com.google.calories.bmr.summary", av.N, av.O, av.P);
    public static final com.google.android.gms.b.f.a R = a("com.google.body.fat.percentage.summary", av.N, av.O, av.P);
    public static final com.google.android.gms.b.f.a S = a("com.google.body.hip.circumference.summary", av.N, av.O, av.P);
    public static final com.google.android.gms.b.f.a T = a("com.google.body.waist.circumference.summary", av.N, av.O, av.P);
    public static final com.google.android.gms.b.f.a U = a("com.google.nutrition.summary", av.B, av.z);
    public static final com.google.android.gms.b.f.a V = a("com.google.internal.session", av.aa, av.a, av.ab, av.ac, av.ad);
    public static final String[] W = new String[]{"com.google.accelerometer", "com.google.activity.exercise", "com.google.activity.sample", "com.google.activity.segment", "com.google.activity.summary", "com.google.body.fat.percentage", "com.google.body.fat.percentage.summary", "com.google.body.hip.circumference", "com.google.body.hip.circumference.summary", "com.google.body.waist.circumference", "com.google.body.waist.circumference.summary", "com.google.calories.bmr", "com.google.calories.bmr.summary", "com.google.calories.consumed", "com.google.calories.expended", "com.google.cycling.pedaling.cadence", "com.google.cycling.pedaling.cumulative", "com.google.cycling.wheel_revolution.cumulative", "com.google.cycling.wheel_revolution.rpm", "com.google.distance.cumulative", "com.google.distance.delta", "com.google.floor_change", "com.google.floor_change.summary", "com.google.heart_rate.bpm", "com.google.heart_rate.summary", "com.google.height", "com.google.internal.goal", "com.google.internal.session", "com.google.location.bounding_box", "com.google.location.sample", "com.google.location.track", "com.google.nutrition", "com.google.nutrition.summary", "com.google.power.sample", "com.google.power.summary", "com.google.sensor.events", "com.google.speed", "com.google.speed.summary", "com.google.step_count.cadence", "com.google.step_count.cumulative", "com.google.step_count.delta", "com.google.weight", "com.google.weight.summary"};
    private static final Map<String, List<com.google.android.gms.b.f.a>> X = a();
    private static final Map<com.google.android.gms.b.f.a, a> Y;
    public static final com.google.android.gms.b.f.a a = a("com.google.step_count.delta", av.d);
    public static final com.google.android.gms.b.f.a b = a("com.google.step_count.cumulative", av.d);
    public static final com.google.android.gms.b.f.a c = a("com.google.step_count.cadence", av.v);
    public static final com.google.android.gms.b.f.a d = a("com.google.activity.segment", av.a);
    public static final com.google.android.gms.b.f.a e = a("com.google.floor_change", av.a, av.b, av.C, av.F);
    public static final com.google.android.gms.b.f.a f = a("com.google.calories.consumed", av.x);
    public static final com.google.android.gms.b.f.a g = a("com.google.calories.expended", av.x);
    public static final com.google.android.gms.b.f.a h = a("com.google.calories.bmr", av.x);
    public static final com.google.android.gms.b.f.a i = a("com.google.power.sample", av.y);
    public static final com.google.android.gms.b.f.a j = a("com.google.activity.sample", av.a, av.b);
    public static final com.google.android.gms.b.f.a k = a("com.google.accelerometer", av.U, av.V, av.W);
    public static final com.google.android.gms.b.f.a l = a("com.google.sensor.events", av.Z, av.X, av.Y);
    public static final com.google.android.gms.b.f.a m = a("com.google.internal.goal", av.o);
    public static final com.google.android.gms.b.f.a n = a("com.google.heart_rate.bpm", av.i);
    public static final com.google.android.gms.b.f.a o = a("com.google.location.sample", av.j, av.k, av.l, av.m);
    public static final com.google.android.gms.b.f.a p = a("com.google.location.track", av.j, av.k, av.l, av.m);
    public static final com.google.android.gms.b.f.a q = a("com.google.distance.delta", av.n);
    public static final com.google.android.gms.b.f.a r = a("com.google.distance.cumulative", av.n);
    public static final com.google.android.gms.b.f.a s = a("com.google.speed", av.u);
    public static final com.google.android.gms.b.f.a t = a("com.google.cycling.wheel_revolution.cumulative", av.w);
    public static final com.google.android.gms.b.f.a u = a("com.google.cycling.wheel_revolution.rpm", av.v);
    public static final com.google.android.gms.b.f.a v = a("com.google.cycling.pedaling.cumulative", av.w);
    public static final com.google.android.gms.b.f.a w = a("com.google.cycling.pedaling.cadence", av.v);
    public static final com.google.android.gms.b.f.a x = a("com.google.height", av.q);
    public static final com.google.android.gms.b.f.a y = a("com.google.weight", av.r);
    public static final com.google.android.gms.b.f.a z = a("com.google.body.fat.percentage", av.t);

    public enum a {
        CUMULATIVE,
        DELTA,
        SAMPLE,
        OTHER
    }

    static {
        Collection hashSet = new HashSet();
        hashSet.add(b);
        hashSet.add(r);
        hashSet.add(v);
        Collection hashSet2 = new HashSet();
        hashSet2.add(q);
        hashSet2.add(a);
        hashSet2.add(g);
        hashSet2.add(f);
        hashSet2.add(e);
        Collection hashSet3 = new HashSet();
        hashSet3.add(z);
        hashSet3.add(B);
        hashSet3.add(A);
        hashSet3.add(C);
        hashSet3.add(x);
        hashSet3.add(y);
        hashSet3.add(n);
        Map hashMap = new HashMap();
        a(hashMap, hashSet, a.CUMULATIVE);
        a(hashMap, hashSet2, a.DELTA);
        a(hashMap, hashSet3, a.SAMPLE);
        Y = Collections.unmodifiableMap(hashMap);
    }

    public static com.google.android.gms.b.f.a a(String str, b... bVarArr) {
        com.google.android.gms.b.f.a aVar = new com.google.android.gms.b.f.a();
        aVar.b = str;
        aVar.c = bVarArr;
        return aVar;
    }

    private static Map<String, List<com.google.android.gms.b.f.a>> a() {
        Map<String, List<com.google.android.gms.b.f.a>> hashMap = new HashMap();
        hashMap.put(d.b, Collections.singletonList(F));
        hashMap.put(f.b, Collections.singletonList(J));
        hashMap.put(g.b, Collections.singletonList(K));
        hashMap.put(q.b, Collections.singletonList(I));
        hashMap.put(e.b, Collections.singletonList(G));
        hashMap.put(o.b, Collections.singletonList(M));
        hashMap.put(i.b, Collections.singletonList(N));
        hashMap.put(n.b, Collections.singletonList(L));
        hashMap.put(s.b, Collections.singletonList(O));
        hashMap.put(a.b, Collections.singletonList(H));
        hashMap.put(y.b, Collections.singletonList(P));
        return hashMap;
    }

    private static void a(Map<com.google.android.gms.b.f.a, a> map, Collection<com.google.android.gms.b.f.a> collection, a aVar) {
        for (com.google.android.gms.b.f.a put : collection) {
            map.put(put, aVar);
        }
    }

    public static boolean a(String str) {
        return Arrays.binarySearch(W, str) >= 0;
    }
}
