package com.getpebble.android.framework.g;

import android.os.Handler;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.p.e;
import com.getpebble.android.framework.p.g;
import com.getpebble.android.framework.p.j;
import com.getpebble.android.framework.p.k;
import com.getpebble.android.h.ab;
import com.getpebble.android.h.h;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ak {
    static final long a = TimeUnit.SECONDS.toMillis(45);
    private static final long b = TimeUnit.SECONDS.toMillis(35);
    private static final long c = TimeUnit.SECONDS.toMillis(5);
    private Handler d;
    private Handler e;
    private j f;
    private Short g;
    private d h;
    private a i;
    private final Runnable j = new Runnable(this) {
        final /* synthetic */ ak a;

        {
            this.a = r1;
        }

        public void run() {
            f.a("VoiceDictationClient", "Global session timeout");
            this.a.e();
        }
    };
    private final Runnable k = new Runnable(this) {
        final /* synthetic */ ak a;

        {
            this.a = r1;
        }

        public void run() {
            f.a("VoiceDictationClient", "Frame timeout");
            this.a.e();
        }
    };

    public interface a {
        void a(short s, c cVar, aj ajVar);

        void a(short s, c cVar, k kVar, aj ajVar, UUID uuid);
    }

    static class b extends Exception {
        private b(String str) {
            super(str);
        }
    }

    public enum c {
        SUCCESS((byte) 0),
        ERROR_RECOGNIZER_UNAVAILABLE((byte) 1),
        ERROR_TIMEOUT((byte) 2),
        ERROR_RECOGNIZER((byte) 3),
        ERROR_INVALID_RESPONSE((byte) 4),
        ERROR_ANALYTICS_NOT_ENABLED((byte) 5),
        ERROR_UNSUPPORTED_CONFIGURATION((byte) 6);
        
        private final byte mResultCode;

        private c(byte b) {
            this.mResultCode = b;
        }

        public byte toByte() {
            return this.mResultCode;
        }

        static c from(byte b) {
            for (c cVar : values()) {
                if (cVar.mResultCode == b) {
                    return cVar;
                }
            }
            return ERROR_RECOGNIZER;
        }

        static c from(int i) {
            switch (i) {
                case 200:
                    return SUCCESS;
                case 400:
                    return ERROR_TIMEOUT;
                default:
                    return ERROR_RECOGNIZER;
            }
        }
    }

    public enum d {
        IDLE,
        DICTATION,
        FETCHING_RESULTS
    }

    public ak(Handler handler) {
        this.d = new Handler(handler.getLooper());
        this.e = handler;
        this.h = d.IDLE;
        this.f = null;
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    public void a(short s, int i, aj ajVar, UUID uuid, String str, String str2) {
        c cVar;
        boolean z = false;
        f.d("VoiceDictationClient", "startDictation: { session_id: " + s + ", rate: " + i + ", uuid: " + (uuid == null ? null : uuid.toString()) + ", source: " + ajVar.name() + " }");
        if (!c()) {
            cVar = c.ERROR_RECOGNIZER_UNAVAILABLE;
        } else if (d()) {
            cVar = c.SUCCESS;
        } else {
            cVar = c.ERROR_ANALYTICS_NOT_ENABLED;
        }
        if (cVar != c.SUCCESS) {
            a(s, cVar, ajVar);
            return;
        }
        String str3;
        this.d.removeCallbacksAndMessages(null);
        if (this.f != null) {
            a(this.f, false);
            this.f.o();
        }
        com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
        if (r != null) {
            str3 = r.serialNumber;
        } else {
            str3 = null;
        }
        if (ajVar == aj.FIRST_PARTY) {
            z = true;
        }
        this.f = a(g.a(i, str2, uuid, z, str3, str), s);
        this.g = Short.valueOf(s);
        this.h = d.DICTATION;
        this.f.a(this.d);
        this.d.postDelayed(this.j, b);
        this.d.postDelayed(this.k, c);
        a(s, cVar, ajVar);
    }

    public boolean a(List<byte[]> list) {
        this.d.removeCallbacks(this.k);
        if (this.h != d.DICTATION) {
            return false;
        }
        j jVar = this.f;
        if (jVar == null) {
            f.b("VoiceDictationClient", "Dropping frames; client is null");
            return false;
        }
        for (byte[] a : list) {
            jVar.a(a);
        }
        this.d.postDelayed(this.k, c);
        return true;
    }

    public void a() {
        f.d("VoiceDictationClient", "stopDictation()");
        if (this.h != d.DICTATION) {
            f.b("VoiceDictationClient", "Dictation not in progress, not stopping. Current state is: " + this.h);
            return;
        }
        this.d.removeCallbacks(this.k);
        if (this.f == null) {
            f.b("VoiceDictationClient", "Dropping stop dictation message; client is null");
            return;
        }
        f.d("VoiceDictationClient", "Stopping audio streaming; fetching results...");
        this.h = d.FETCHING_RESULTS;
        this.f.b(this.g.shortValue());
    }

    public void b() {
        if (this.f != null) {
            this.f.o();
            this.f = null;
        }
        this.d.removeCallbacksAndMessages(null);
        this.h = d.IDLE;
        this.g = null;
    }

    void a(short s, c cVar, k kVar, aj ajVar, UUID uuid) {
        f.d("VoiceDictationClient", "sendResult(" + s + "," + cVar + ")");
        final short s2 = s;
        final c cVar2 = cVar;
        final k kVar2 = kVar;
        final aj ajVar2 = ajVar;
        final UUID uuid2 = uuid;
        this.e.post(new Runnable(this) {
            final /* synthetic */ ak f;

            public void run() {
                if (this.f.i != null) {
                    this.f.i.a(s2, cVar2, kVar2, ajVar2, uuid2);
                }
            }
        });
    }

    void a(final short s, final c cVar, final aj ajVar) {
        f.d("VoiceDictationClient", "sendDictationStartedResult(" + s + "," + cVar + ")");
        this.e.post(new Runnable(this) {
            final /* synthetic */ ak d;

            public void run() {
                if (this.d.i != null) {
                    this.d.i.a(s, cVar, ajVar);
                }
            }
        });
    }

    j a(final g gVar, short s) {
        return new j(this, s, gVar) {
            final /* synthetic */ ak b;

            protected void a(int i, short s, String str) {
                boolean z = true;
                if (this.b.g == null || s != this.b.g.shortValue()) {
                    f.b("VoiceDictationClient", "ignoring onResponse() for sessionId = " + s + " (expecting " + this.b.g + ")");
                    return;
                }
                f.d("VoiceDictationClient", "onResponse()");
                if (this.b.h != d.FETCHING_RESULTS) {
                    f.b("VoiceDictationClient", "Not handling HTTP client response while in state: " + this.b.h);
                    return;
                }
                c cVar;
                k kVar;
                c from = c.from(i);
                this.b.d.removeCallbacksAndMessages(null);
                try {
                    k kVar2;
                    k b = k.b(str);
                    if (b.d()) {
                        f.b("VoiceDictationClient", String.format("Recognition provider returned code=(%d) prompt=(%s)", new Object[]{Integer.valueOf(b.c()), b.b()}));
                        cVar = c.ERROR_INVALID_RESPONSE;
                        kVar2 = null;
                    } else {
                        z = false;
                        kVar2 = b;
                        cVar = from;
                    }
                    kVar = kVar2;
                } catch (IllegalArgumentException e) {
                    cVar = c.ERROR_INVALID_RESPONSE;
                    kVar = null;
                }
                this.b.a(this.b.f, z);
                this.b.a(s, cVar, kVar, gVar.g() ? aj.FIRST_PARTY : aj.THIRD_PARTY, gVar.f());
                this.b.h = d.IDLE;
                this.b.g = null;
                this.b.f = null;
            }

            protected void a(short s) {
                if (this.b.g == null || s != this.b.g.shortValue()) {
                    f.b("VoiceDictationClient", "ignoring onResponse() for sessionId = " + s + " (expecting " + this.b.g + ")");
                    return;
                }
                f.d("VoiceDictationClient", "onError()");
                if (this.b.h == d.IDLE) {
                    f.b("VoiceDictationClient", "Not handling HTTP client error while idle");
                    return;
                }
                this.b.d.removeCallbacksAndMessages(null);
                this.b.a(this.b.f, false);
                this.b.a(this.b.g.shortValue(), c.ERROR_RECOGNIZER, null, gVar.g() ? aj.FIRST_PARTY : aj.THIRD_PARTY, gVar.f());
                this.b.h = d.IDLE;
                this.b.g = null;
                this.b.f = null;
            }
        };
    }

    boolean c() {
        return h.a(com.getpebble.android.common.a.K());
    }

    boolean d() {
        return PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.ANALYTICS_OPTIN, true);
    }

    void a(e eVar, boolean z) {
        if (eVar.b() > a) {
            a(new b(String.format("Invalid analytics: connection duration: %d, setup latency: %d, bytes sent: %d, is error? " + z, new Object[]{Long.valueOf(eVar.b()), Long.valueOf(eVar.c()), Integer.valueOf(eVar.a())})));
        }
        com.getpebble.android.common.b.a.a.c.a(eVar.b(), eVar.c(), eVar.a(), (long) ab.a(), !eVar.e(), z, eVar.d(), eVar.f(), eVar.h(), eVar.g() == null ? null : eVar.g().toString().toLowerCase(Locale.US), eVar.i(), eVar.j(), eVar.k(), eVar.l(), eVar.m(), eVar.n());
    }

    void a(b bVar) {
        com.getpebble.android.common.a.b(bVar);
    }

    private void e() {
        f.a("VoiceDictationClient", "Timeout in state: " + this.h);
        this.d.removeCallbacksAndMessages(null);
        if (this.h == d.IDLE) {
            f.d("VoiceDictationClient", "Timeout, but currently IDLE.");
            return;
        }
        this.h = d.IDLE;
        if (this.f != null) {
            a(this.f, false);
            this.f.o();
        }
        a(this.g.shortValue(), c.ERROR_TIMEOUT, null, this.f.h() ? aj.FIRST_PARTY : aj.THIRD_PARTY, this.f.g());
        this.g = null;
        this.f = null;
    }
}
