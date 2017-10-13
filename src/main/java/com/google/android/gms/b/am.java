package com.google.android.gms.b;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.b;
import java.lang.ref.WeakReference;

public class am<R extends f> extends j<R> implements g<R> {
    private i<? super R, ? extends f> a;
    private am<? extends f> b;
    private volatile h<? super R> c;
    private d<R> d;
    private final Object e;
    private Status f;
    private final WeakReference<c> g;
    private final a h;
    private boolean i;

    private final class a extends Handler {
        final /* synthetic */ am a;

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    d dVar = (d) message.obj;
                    synchronized (this.a.e) {
                        if (dVar == null) {
                            this.a.b.a(new Status(13, "Transform returned null"));
                        } else if (dVar instanceof aj) {
                            this.a.b.a(((aj) dVar).b());
                        } else {
                            this.a.b.a(dVar);
                        }
                    }
                    return;
                case 1:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    String str = "TransformedResultImpl";
                    String str2 = "Runtime exception on the transformation worker thread: ";
                    String valueOf = String.valueOf(runtimeException.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
                    return;
            }
        }
    }

    private void a(Status status) {
        synchronized (this.e) {
            this.f = status;
            b(this.f);
        }
    }

    private void b() {
        if (this.a != null || this.c != null) {
            c cVar = (c) this.g.get();
            if (!(this.i || this.a == null || cVar == null)) {
                cVar.a(this);
                this.i = true;
            }
            if (this.f != null) {
                b(this.f);
            } else if (this.d != null) {
                this.d.a(this);
            }
        }
    }

    private void b(Status status) {
        synchronized (this.e) {
            if (this.a != null) {
                Status a = this.a.a(status);
                b.a((Object) a, (Object) "onFailure must not return null");
                this.b.a(a);
            } else if (c()) {
                this.c.a(status);
            }
        }
    }

    private void b(f fVar) {
        if (fVar instanceof e) {
            try {
                ((e) fVar).a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(fVar);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private boolean c() {
        return (this.c == null || ((c) this.g.get()) == null) ? false : true;
    }

    void a() {
        this.c = null;
    }

    public void a(d<?> dVar) {
        synchronized (this.e) {
            this.d = dVar;
            b();
        }
    }

    public void a(final R r) {
        synchronized (this.e) {
            if (!r.a().f()) {
                a(r.a());
                b((f) r);
            } else if (this.a != null) {
                ai.a().submit(new Runnable(this) {
                    final /* synthetic */ am b;

                    public void run() {
                        c cVar;
                        try {
                            m.a.set(Boolean.valueOf(true));
                            this.b.h.sendMessage(this.b.h.obtainMessage(0, this.b.a.a(r)));
                            m.a.set(Boolean.valueOf(false));
                            this.b.b(r);
                            cVar = (c) this.b.g.get();
                            if (cVar != null) {
                                cVar.b(this.b);
                            }
                        } catch (RuntimeException e) {
                            this.b.h.sendMessage(this.b.h.obtainMessage(1, e));
                            m.a.set(Boolean.valueOf(false));
                            this.b.b(r);
                            cVar = (c) this.b.g.get();
                            if (cVar != null) {
                                cVar.b(this.b);
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            m.a.set(Boolean.valueOf(false));
                            this.b.b(r);
                            cVar = (c) this.b.g.get();
                            if (cVar != null) {
                                cVar.b(this.b);
                            }
                        }
                    }
                });
            } else if (c()) {
                this.c.b(r);
            }
        }
    }
}
