package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent extends AbstractSafeParcelable {
    public abstract long a();

    public abstract int b();

    public abstract long i();

    public abstract String l();

    public String toString() {
        long a = a();
        String valueOf = String.valueOf("\t");
        int b = b();
        String valueOf2 = String.valueOf("\t");
        long i = i();
        String valueOf3 = String.valueOf(l());
        return new StringBuilder(((String.valueOf(valueOf).length() + 51) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(a).append(valueOf).append(b).append(valueOf2).append(i).append(valueOf3).toString();
    }
}
