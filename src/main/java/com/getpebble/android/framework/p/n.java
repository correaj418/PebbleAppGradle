package com.getpebble.android.framework.p;

import android.os.Handler;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.g.aj;
import com.getpebble.android.framework.g.ak;
import com.getpebble.android.framework.g.p;
import com.getpebble.android.framework.l.a.g;
import com.getpebble.android.framework.l.b.ah;
import com.getpebble.android.framework.l.b.i;
import com.getpebble.android.framework.timeline.e;
import com.google.a.b.am;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

public abstract class n {
    final p a;
    final a b;
    final ak c;
    final b d;
    final Handler e;
    c f = c.NONE;
    private final short g;

    public interface b {
        void a(com.getpebble.android.framework.g.ak.c cVar);

        void c();
    }

    public static class a {
        public final aj a;
        public final UUID b;
        public final String c;
        public final String d;

        public a(aj ajVar, UUID uuid, String str, String str2) {
            this.a = ajVar;
            this.b = uuid;
            this.c = str;
            this.d = str2;
        }
    }

    enum c {
        NONE,
        INIT,
        STARTING,
        STARTED,
        LISTENING,
        HANDLING_PACKET,
        WAITING_FOR_DICTATION_RESULT,
        PROCESSING,
        POST_PROCESSING,
        ENDED;
        
        private Set<c> legalNextStates;

        static {
            NONE.legalNextStates = am.a(INIT, ENDED);
            INIT.legalNextStates = am.a(STARTING, ENDED);
            STARTING.legalNextStates = am.a(STARTED, ENDED);
            STARTED.legalNextStates = am.a(LISTENING, ENDED);
            LISTENING.legalNextStates = am.a(WAITING_FOR_DICTATION_RESULT, HANDLING_PACKET, ENDED);
            HANDLING_PACKET.legalNextStates = am.a(LISTENING, ENDED);
            WAITING_FOR_DICTATION_RESULT.legalNextStates = am.a(PROCESSING, ENDED);
            PROCESSING.legalNextStates = am.a(ENDED, POST_PROCESSING);
            POST_PROCESSING.legalNextStates = am.b(ENDED);
            ENDED.legalNextStates = am.h();
        }

        boolean verifyTransition(n nVar, c cVar) {
            if (this.legalNextStates.contains(cVar)) {
                f.c("WatchVoiceSession", "Session " + nVar.g + ": Legal transition from state " + name() + " to state " + cVar.name());
                return true;
            }
            f.b("WatchVoiceSession", "Session " + nVar.g + ": Illegal attempt to transition from state " + name() + " to state " + cVar.name() + ". Stack trace: " + Arrays.toString(Thread.currentThread().getStackTrace()));
            return false;
        }
    }

    protected abstract com.getpebble.android.framework.l.a.y.b a();

    protected abstract boolean a(com.getpebble.android.framework.g.ak.c cVar, k kVar);

    protected abstract boolean b(com.getpebble.android.framework.g.ak.c cVar, k kVar);

    public n(final short s, Handler handler, a aVar, p pVar, ak akVar, b bVar) {
        this.g = s;
        this.b = aVar;
        this.a = pVar;
        this.c = akVar;
        this.d = bVar;
        this.e = handler;
        handler.post(new Runnable(this) {
            final /* synthetic */ n b;

            public void run() {
                c cVar = this.b.f;
                if (!this.b.g()) {
                    f.a("WatchVoiceSession", "Session " + s + ": Failed transition to INIT state from " + cVar.name());
                    this.b.l();
                }
            }
        });
    }

    public short d() {
        return this.g;
    }

    public void a(final int i) {
        this.e.post(new Runnable(this) {
            final /* synthetic */ n b;

            public void run() {
                c cVar = this.b.f;
                if (!this.b.b(i)) {
                    f.a("WatchVoiceSession", "Session " + this.b.g + ": Failed transition to STARTING state from " + cVar.name());
                    this.b.l();
                }
            }
        });
    }

    public void e() {
        this.e.post(new Runnable(this) {
            final /* synthetic */ n a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.l();
            }
        });
    }

    public void f() {
        this.e.post(new Runnable(this) {
            final /* synthetic */ n a;

            {
                this.a = r1;
            }

            public void run() {
                c cVar = this.a.f;
                if (!this.a.j()) {
                    f.a("WatchVoiceSession", "Session " + this.a.g + ": Failed transition to WAITING_FOR_DICTATION_RESULT state from " + cVar.name());
                    this.a.l();
                }
            }
        });
    }

    public void a(final g gVar) {
        this.e.post(new Runnable(this) {
            final /* synthetic */ n b;

            public void run() {
                c cVar = this.b.f;
                if (!this.b.b(gVar)) {
                    f.a("WatchVoiceSession", "Session " + this.b.g + ": Failed transition to HANDLING_PACKET state from " + cVar.name());
                    this.b.l();
                }
            }
        });
    }

    protected final boolean g() {
        if (!this.f.verifyTransition(this, c.INIT)) {
            return false;
        }
        this.f = c.INIT;
        return b();
    }

    protected boolean b() {
        this.c.a(new com.getpebble.android.framework.g.ak.a(this) {
            final /* synthetic */ n a;

            {
                this.a = r1;
            }

            public void a(final short s, final com.getpebble.android.framework.g.ak.c cVar, final aj ajVar) {
                if (a(s)) {
                    f.b("WatchVoiceSession", "ignoring onDictationStarted() for sessionId = " + s + " (expecting " + this.a.g + ")");
                    return;
                }
                f.d("WatchVoiceSession", "onDictationStarted(" + s + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + cVar + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + ajVar.name() + ")");
                this.a.e.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass6 d;

                    public void run() {
                        c cVar = this.d.a.f;
                        if (!this.d.a.a(cVar, ajVar)) {
                            f.a("WatchVoiceSession", "Session " + s + ": Failed transition to STARTED state from " + cVar.name());
                            this.d.a.l();
                        }
                    }
                });
            }

            private boolean a(short s) {
                return this.a.g != s;
            }

            public void a(final short s, final com.getpebble.android.framework.g.ak.c cVar, final k kVar, aj ajVar, UUID uuid) {
                if (a(s)) {
                    f.b("WatchVoiceSession", "ignoring onDictationResult() for sessionId = " + s + " (expecting " + this.a.g + ")");
                    return;
                }
                f.d("WatchVoiceSession", "onDictationResult( " + s + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + cVar + ", , " + kVar + ")");
                this.a.e.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass6 d;

                    public void run() {
                        c cVar = this.d.a.f;
                        if (!this.d.a.c(cVar, kVar)) {
                            f.a("WatchVoiceSession", "Session " + s + ": Failed transition to PROCESSING state from " + cVar.name());
                            this.d.a.l();
                        }
                    }
                });
            }
        });
        return true;
    }

    protected final boolean b(int i) {
        if (!this.f.verifyTransition(this, c.STARTING)) {
            return false;
        }
        this.f = c.STARTING;
        return c(i);
    }

    protected boolean c(int i) {
        this.c.a(this.g, i, this.b.a, this.b.b, this.b.c, this.b.d);
        return true;
    }

    protected final boolean a(com.getpebble.android.framework.g.ak.c cVar, aj ajVar) {
        if (!this.f.verifyTransition(this, c.STARTED)) {
            return false;
        }
        this.f = c.STARTED;
        return b(cVar, ajVar);
    }

    protected boolean b(com.getpebble.android.framework.g.ak.c cVar, aj ajVar) {
        this.a.a(new ah(a(), cVar, ajVar));
        this.d.a(cVar);
        return h();
    }

    protected final boolean h() {
        if (!this.f.verifyTransition(this, c.LISTENING)) {
            return false;
        }
        this.f = c.LISTENING;
        return i();
    }

    protected boolean i() {
        return true;
    }

    protected final boolean j() {
        if (!this.f.verifyTransition(this, c.WAITING_FOR_DICTATION_RESULT)) {
            return false;
        }
        this.f = c.WAITING_FOR_DICTATION_RESULT;
        return k();
    }

    protected boolean k() {
        this.c.a();
        return true;
    }

    protected final boolean b(g gVar) {
        if (!this.f.verifyTransition(this, c.HANDLING_PACKET)) {
            return false;
        }
        this.f = c.HANDLING_PACKET;
        return c(gVar);
    }

    protected boolean c(g gVar) {
        if (this.c.a(gVar.c())) {
            return h();
        }
        a(gVar.d());
        return false;
    }

    protected final boolean c(com.getpebble.android.framework.g.ak.c cVar, k kVar) {
        if (!this.f.verifyTransition(this, c.PROCESSING)) {
            return false;
        }
        this.f = c.PROCESSING;
        return a(cVar, kVar);
    }

    protected final boolean d(com.getpebble.android.framework.g.ak.c cVar, k kVar) {
        if (!this.f.verifyTransition(this, c.POST_PROCESSING)) {
            return false;
        }
        this.f = c.POST_PROCESSING;
        return b(cVar, kVar);
    }

    protected final boolean l() {
        if (!this.f.verifyTransition(this, c.ENDED)) {
            return false;
        }
        this.f = c.ENDED;
        return c();
    }

    protected boolean c() {
        if (this.f == c.LISTENING) {
            a(this.g);
        }
        this.c.a(null);
        this.d.c();
        return true;
    }

    private void a(short s) {
        this.a.a(new i(s));
    }
}
