package com.getpebble.android.framework.p;

import android.os.Handler;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.g.aj;
import com.getpebble.android.framework.g.ak;
import com.getpebble.android.framework.g.ak.c;
import com.getpebble.android.framework.g.p;
import com.getpebble.android.framework.l.a.y;
import com.getpebble.android.framework.l.b.w;
import com.getpebble.android.framework.p.n.a;
import com.getpebble.android.framework.p.n.b;
import java.util.UUID;

public class m extends n {
    private final f g;

    public m(short s, Handler handler, a aVar, p pVar, ak akVar, f fVar, b bVar) {
        super(s, handler, aVar, pVar, akVar, bVar);
        this.g = fVar;
    }

    protected boolean b() {
        if (!super.b()) {
            return false;
        }
        this.g.a(new f.a(this) {
            final /* synthetic */ m a;

            {
                this.a = r1;
            }

            public void a(short s, c cVar, com.getpebble.android.g.a.b bVar, aj ajVar, UUID uuid) {
                final short s2 = s;
                final c cVar2 = cVar;
                final com.getpebble.android.g.a.b bVar2 = bVar;
                final aj ajVar2 = ajVar;
                final UUID uuid2 = uuid;
                this.a.e.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 f;

                    public void run() {
                        this.f.a.a.a(new w(s2, cVar2, bVar2, ajVar2, uuid2, new com.getpebble.android.framework.l.b.b()));
                        this.f.a.l();
                    }
                });
            }
        });
        return true;
    }

    protected boolean c() {
        if (!super.c()) {
            return false;
        }
        this.g.a(null);
        return true;
    }

    protected y.b a() {
        return y.b.NLP;
    }

    protected boolean a(c cVar, k kVar) {
        return d(cVar, kVar);
    }

    protected boolean b(c cVar, k kVar) {
        if (this.g.a(d(), this.b.a, this.b.b, null, null, kVar)) {
            return true;
        }
        f.b("WatchNLPSession", "NLP Client failed to process text.");
        this.a.a(new w(d(), c.ERROR_INVALID_RESPONSE, null, this.b.a, this.b.b, new com.getpebble.android.framework.l.b.b()));
        return l();
    }
}
