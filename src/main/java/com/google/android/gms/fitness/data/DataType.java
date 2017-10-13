package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.a.b;
import com.google.android.gms.common.a.e;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class DataType extends AbstractSafeParcelable {
    public static final Set<DataType> A = e.a(a, n, c, d, o, k, u, l, e, f, v, x, w, y);
    public static final DataType B = new DataType("com.google.activity.summary", Field.a, Field.e, Field.K);
    public static final DataType C = new DataType("com.google.floor_change.summary", Field.g, Field.h, Field.B, Field.C, Field.E, Field.F);
    public static final Creator<DataType> CREATOR = new g();
    public static final DataType D = new DataType("com.google.calories.bmr.summary", Field.L, Field.M, Field.N);
    public static final DataType E = a;
    public static final DataType F = n;
    @Deprecated
    public static final DataType G = e;
    public static final DataType H = f;
    public static final DataType I = new DataType("com.google.heart_rate.summary", Field.L, Field.M, Field.N);
    public static final DataType J = new DataType("com.google.location.bounding_box", Field.O, Field.P, Field.Q, Field.R);
    public static final DataType K = new DataType("com.google.power.summary", Field.L, Field.M, Field.N);
    public static final DataType L = new DataType("com.google.speed.summary", Field.L, Field.M, Field.N);
    public static final DataType M = new DataType("com.google.body.fat.percentage.summary", Field.L, Field.M, Field.N);
    public static final DataType N = new DataType("com.google.body.hip.circumference.summary", Field.L, Field.M, Field.N);
    public static final DataType O = new DataType("com.google.body.waist.circumference.summary", Field.L, Field.M, Field.N);
    public static final DataType P = new DataType("com.google.weight.summary", Field.L, Field.M, Field.N);
    public static final DataType Q = new DataType("com.google.nutrition.summary", Field.z, Field.x);
    public static final DataType[] R = new DataType[]{j, z, i, c, B, v, M, x, N, w, O, g, D, e, f, s, r, p, q, TYPE_DISTANCE_CUMULATIVE, n, d, C, k, I, t, J, l, m, y, Q, h, K, o, L, b, TYPE_STEP_COUNT_CUMULATIVE, a, u, P};
    private static final Map<DataType, List<DataType>> S = new HashMap();
    @KeepName
    public static final DataType TYPE_DISTANCE_CUMULATIVE = new DataType("com.google.distance.cumulative", Field.n);
    @KeepName
    public static final DataType TYPE_STEP_COUNT_CUMULATIVE = new DataType("com.google.step_count.cumulative", Field.d);
    public static final DataType a = new DataType("com.google.step_count.delta", Field.d);
    public static final DataType b = new DataType("com.google.step_count.cadence", Field.t);
    public static final DataType c = new DataType("com.google.activity.segment", Field.a);
    public static final DataType d = new DataType("com.google.floor_change", Field.a, Field.b, Field.A, Field.D);
    @Deprecated
    public static final DataType e = new DataType("com.google.calories.consumed", Field.v);
    public static final DataType f = new DataType("com.google.calories.expended", Field.v);
    public static final DataType g = new DataType("com.google.calories.bmr", Field.v);
    public static final DataType h = new DataType("com.google.power.sample", Field.w);
    public static final DataType i = new DataType("com.google.activity.sample", Field.a, Field.b);
    public static final DataType j = new DataType("com.google.accelerometer", Field.S, Field.T, Field.U);
    public static final DataType k = new DataType("com.google.heart_rate.bpm", Field.i);
    public static final DataType l = new DataType("com.google.location.sample", Field.j, Field.k, Field.l, Field.m);
    public static final DataType m = new DataType("com.google.location.track", Field.j, Field.k, Field.l, Field.m);
    public static final DataType n = new DataType("com.google.distance.delta", Field.n);
    public static final DataType o = new DataType("com.google.speed", Field.s);
    public static final DataType p = new DataType("com.google.cycling.wheel_revolution.cumulative", Field.u);
    public static final DataType q = new DataType("com.google.cycling.wheel_revolution.rpm", Field.t);
    public static final DataType r = new DataType("com.google.cycling.pedaling.cumulative", Field.u);
    public static final DataType s = new DataType("com.google.cycling.pedaling.cadence", Field.t);
    public static final DataType t = new DataType("com.google.height", Field.o);
    public static final DataType u = new DataType("com.google.weight", Field.p);
    public static final DataType v = new DataType("com.google.body.fat.percentage", Field.r);
    public static final DataType w = new DataType("com.google.body.waist.circumference", Field.q);
    public static final DataType x = new DataType("com.google.body.hip.circumference", Field.q);
    public static final DataType y = new DataType("com.google.nutrition", Field.z, Field.x, Field.y);
    public static final DataType z = new DataType("com.google.activity.exercise", Field.G, Field.H, Field.e, Field.J, Field.I);
    private final int T;
    private final String U;
    private final List<Field> V;

    static {
        S.put(c, Collections.singletonList(B));
        S.put(g, Collections.singletonList(D));
        S.put(v, Collections.singletonList(M));
        S.put(x, Collections.singletonList(N));
        S.put(w, Collections.singletonList(O));
        S.put(e, Collections.singletonList(G));
        S.put(f, Collections.singletonList(H));
        S.put(n, Collections.singletonList(F));
        S.put(d, Collections.singletonList(C));
        S.put(l, Collections.singletonList(J));
        S.put(y, Collections.singletonList(Q));
        S.put(h, Collections.singletonList(K));
        S.put(k, Collections.singletonList(I));
        S.put(o, Collections.singletonList(L));
        S.put(a, Collections.singletonList(E));
        S.put(u, Collections.singletonList(P));
    }

    DataType(int i, String str, List<Field> list) {
        this.T = i;
        this.U = str;
        this.V = Collections.unmodifiableList(list);
    }

    public DataType(String str, Field... fieldArr) {
        this(1, str, b.a(fieldArr));
    }

    private boolean a(DataType dataType) {
        return this.U.equals(dataType.U) && this.V.equals(dataType.V);
    }

    public int a(Field field) {
        int indexOf = this.V.indexOf(field);
        if (indexOf >= 0) {
            return indexOf;
        }
        throw new IllegalArgumentException(String.format("%s not a field of %s", new Object[]{field, this}));
    }

    public String a() {
        return this.U;
    }

    public List<Field> b() {
        return this.V;
    }

    public String c() {
        return this.U.startsWith("com.google.") ? this.U.substring(11) : this.U;
    }

    int d() {
        return this.T;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataType) && a((DataType) obj));
    }

    public int hashCode() {
        return this.U.hashCode();
    }

    public String toString() {
        return String.format("DataType{%s%s}", new Object[]{this.U, this.V});
    }

    public void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel, i);
    }
}
