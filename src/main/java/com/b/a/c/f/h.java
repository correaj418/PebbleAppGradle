package com.b.a.c.f;

import com.b.a.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

class h {
    Inflater a = new Inflater(this) {
        final /* synthetic */ h a;

        {
            this.a = r1;
        }

        public int inflate(byte[] bArr, int i, int i2) {
            int inflate = super.inflate(bArr, i, i2);
            if (inflate != 0 || !needsDictionary()) {
                return inflate;
            }
            setDictionary(o.a);
            return super.inflate(bArr, i, i2);
        }
    };

    public List<g> a(k kVar, int i) {
        byte[] bArr = new byte[i];
        kVar.a(bArr);
        this.a.setInput(bArr);
        k a = new k().a(ByteOrder.BIG_ENDIAN);
        while (!this.a.needsInput()) {
            ByteBuffer c = k.c(8192);
            try {
                c.limit(this.a.inflate(c.array()));
                a.a(c);
            } catch (Throwable e) {
                throw new IOException(e);
            }
        }
        int f = a.f();
        List<g> arrayList = new ArrayList(f);
        for (int i2 = 0; i2 < f; i2++) {
            c c2 = a(a).c();
            c a2 = a(a);
            if (c2.d() == 0) {
                throw new IOException("name.size == 0");
            }
            arrayList.add(new g(c2, a2));
        }
        return arrayList;
    }

    private static c a(k kVar) {
        return c.a(kVar.a(kVar.f()));
    }
}
