package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.ab;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.Subscription;
import java.util.List;

public class ListSubscriptionsResult extends AbstractSafeParcelable implements f {
    public static final Creator<ListSubscriptionsResult> CREATOR = new h();
    private final int a;
    private final List<Subscription> b;
    private final Status c;

    ListSubscriptionsResult(int i, List<Subscription> list, Status status) {
        this.a = i;
        this.b = list;
        this.c = status;
    }

    private boolean a(ListSubscriptionsResult listSubscriptionsResult) {
        return this.c.equals(listSubscriptionsResult.c) && ab.a(this.b, listSubscriptionsResult.b);
    }

    public Status a() {
        return this.c;
    }

    public List<Subscription> b() {
        return this.b;
    }

    int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ListSubscriptionsResult) && a((ListSubscriptionsResult) obj));
    }

    public int hashCode() {
        return ab.a(this.c, this.b);
    }

    public String toString() {
        return ab.a((Object) this).a("status", this.c).a("subscriptions", this.b).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.a(this, parcel, i);
    }
}
