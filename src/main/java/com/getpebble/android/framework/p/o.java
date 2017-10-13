package com.getpebble.android.framework.p;

import android.os.Handler;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.am.c;
import com.getpebble.android.framework.g.aj;
import com.getpebble.android.framework.g.ak;
import com.getpebble.android.framework.g.p;
import com.getpebble.android.framework.l.a.y;
import com.getpebble.android.framework.p.n.a;
import com.getpebble.android.framework.p.n.b;
import com.getpebble.android.h.ae;
import java.util.UUID;

public class o {
    static final UUID a = new UUID(0, 0);
    private final p b;
    private final ak c;
    private final f d;

    public o(p pVar, ak akVar, f fVar) {
        this.b = pVar;
        this.c = akVar;
        this.d = fVar;
    }

    public n a(y yVar, b bVar, Handler handler) {
        y.b from = y.b.from(yVar.g());
        short c = yVar.c();
        aj f = yVar.f();
        UUID a = a(yVar);
        c b = b(a);
        a aVar = new a(f, a, a(b, f), b(b, f));
        switch (from) {
            case DICTATION:
                return new l(c, handler, aVar, a(), b(), bVar);
            case NLP:
                return new m(c, handler, aVar, a(), b(), c(), bVar);
            default:
                f.b("WatchVoiceSessionFactory", "Unknown session type in voice setup message for session " + yVar.c());
                return null;
        }
    }

    private String a(c cVar, aj ajVar) {
        if (ajVar != aj.THIRD_PARTY) {
            return null;
        }
        if (cVar != null && !cVar.F) {
            return cVar.z ? ae.a() : cVar.j;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private String b(c cVar, aj ajVar) {
        String str = "com.getpebble.android.basalt";
        if (ajVar != aj.THIRD_PARTY) {
            return str;
        }
        if (cVar != null) {
            return cVar.c;
        }
        throw new IllegalArgumentException();
    }

    private UUID a(y yVar) {
        if (yVar.f() == aj.THIRD_PARTY) {
            return yVar.e();
        }
        return a;
    }

    private c b(UUID uuid) {
        try {
            return a(uuid);
        } catch (Exception e) {
            f.a("WatchVoiceSessionFactory", "handleVoiceControlMessage: Failed to fetch record for app with UUID " + uuid.toString());
            return null;
        }
    }

    c a(UUID uuid) {
        return am.a(uuid, com.getpebble.android.common.a.K().getContentResolver(), false);
    }

    p a() {
        return this.b;
    }

    ak b() {
        return this.c;
    }

    f c() {
        return this.d;
    }
}
