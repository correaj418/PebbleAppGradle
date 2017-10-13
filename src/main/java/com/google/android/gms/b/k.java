package com.google.android.gms.b;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.f;
import java.util.concurrent.atomic.AtomicReference;

public class k {

    public interface b<R> {
        void a(R r);
    }

    public static abstract class a<R extends f, A extends c> extends m<R> implements b<R> {
        private final d<A> d;
        private final com.google.android.gms.common.api.a<?> e;
        private AtomicReference<b> f = new AtomicReference();

        @Deprecated
        protected a(d<A> dVar, com.google.android.gms.common.api.c cVar) {
            super((com.google.android.gms.common.api.c) com.google.android.gms.common.internal.b.a((Object) cVar, (Object) "GoogleApiClient must not be null"));
            this.d = (d) com.google.android.gms.common.internal.b.a((Object) dVar);
            this.e = null;
        }

        private void a(RemoteException remoteException) {
            a(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        public void a(b bVar) {
            this.f.set(bVar);
        }

        public final void a(Status status) {
            com.google.android.gms.common.internal.b.b(!status.f(), "Failed result must not be success");
            f b = b(status);
            b(b);
            a(b);
        }

        public final void a(A a) {
            try {
                b(a);
            } catch (RemoteException e) {
                a(e);
                throw e;
            } catch (RemoteException e2) {
                a(e2);
            }
        }

        protected void a(R r) {
        }

        public /* synthetic */ void a(Object obj) {
            super.b((f) obj);
        }

        public final d<A> b() {
            return this.d;
        }

        protected abstract void b(A a);

        public final com.google.android.gms.common.api.a<?> c() {
            return this.e;
        }

        public void d() {
            a(null);
        }

        protected void e() {
            b bVar = (b) this.f.getAndSet(null);
            if (bVar != null) {
                bVar.a(this);
            }
        }
    }
}
