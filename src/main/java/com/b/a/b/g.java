package com.b.a.b;

import java.util.ArrayList;
import java.util.Iterator;

public class g<T> extends i<T> {
    ArrayList<f<T>> a;
    final f<T> b = new f<T>(this) {
        final /* synthetic */ g a;

        {
            this.a = r1;
        }

        public void a(Exception exception, T t) {
            synchronized (this.a) {
                ArrayList arrayList = this.a.a;
                this.a.a = null;
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((f) it.next()).a(exception, t);
                }
            }
        }
    };

    public /* synthetic */ e a(f fVar) {
        return c(fVar);
    }

    public /* synthetic */ i d(f fVar) {
        return c(fVar);
    }

    public g<T> c(f<T> fVar) {
        synchronized (this) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            this.a.add(fVar);
        }
        super.d(this.b);
        return this;
    }
}
