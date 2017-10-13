package com.b.a.c.d;

import com.b.a.k;
import com.b.a.p;
import com.b.a.u;
import java.nio.ByteBuffer;

public class c extends u {
    public c(p pVar) {
        super(pVar);
    }

    public k b(k kVar) {
        kVar.b(ByteBuffer.wrap((Integer.toString(kVar.d(), 16) + "\r\n").getBytes()));
        kVar.a(ByteBuffer.wrap("\r\n".getBytes()));
        return kVar;
    }

    public void a() {
        a(Integer.MAX_VALUE);
        a(new k());
        a(0);
    }
}
