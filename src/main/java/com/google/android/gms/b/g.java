package com.google.android.gms.b;

import android.util.SparseArray;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.api.f;

public abstract class g {
    public final int a;
    public final int b;

    public static final class a extends g {
        public final com.google.android.gms.b.k.a<? extends f, c> c;

        public void a(SparseArray<an> sparseArray) {
            an anVar = (an) sparseArray.get(this.a);
            if (anVar != null) {
                anVar.a(this.c);
            }
        }

        public void a(Status status) {
            this.c.a(status);
        }

        public void a(c cVar) {
            this.c.a(cVar);
        }

        public boolean a() {
            return this.c.h();
        }
    }

    public void a(SparseArray<an> sparseArray) {
    }

    public abstract void a(Status status);

    public abstract void a(c cVar);

    public boolean a() {
        return true;
    }
}
