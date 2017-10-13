package com.getpebble.android.framework.p;

import android.os.Handler;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.g.ak;
import com.getpebble.android.framework.g.ak.c;
import com.getpebble.android.framework.g.p;
import com.getpebble.android.framework.l.a.y;
import com.getpebble.android.framework.l.b.n;
import com.getpebble.android.framework.p.n.a;
import com.getpebble.android.framework.p.n.b;

public class l extends n {
    public l(short s, Handler handler, a aVar, p pVar, ak akVar, b bVar) {
        super(s, handler, aVar, pVar, akVar, bVar);
    }

    protected y.b a() {
        return y.b.DICTATION;
    }

    protected boolean a(c cVar, k kVar) {
        this.a.a(new n(d(), cVar, kVar == null ? (k.a[][]) null : kVar.c, this.b.a, this.b.b));
        return l();
    }

    protected boolean b(c cVar, k kVar) {
        f.f("WatchDictationSession", "Attempting to do post-processing in Dictation session, where that concept is nonexistent.");
        return false;
    }
}
