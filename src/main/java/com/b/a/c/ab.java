package com.b.a.c;

import android.text.TextUtils;
import android.util.Base64;
import com.b.a.a.a;
import com.b.a.a.d;
import com.b.a.a.f;
import com.b.a.ac;
import com.b.a.c.z.b;
import com.b.a.c.z.c;
import com.b.a.g;
import com.b.a.i;
import com.b.a.j;
import com.b.a.k;
import com.b.a.m;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.LinkedList;
import java.util.UUID;

public class ab implements z {
    j a;
    r b;
    a c;
    private LinkedList<k> d;
    private i e;
    private c f;
    private d g;
    private z.a h;
    private b i;

    public void a() {
        this.e.a();
    }

    private static byte[] a(UUID uuid) {
        byte[] bArr = new byte[16];
        ByteBuffer.wrap(bArr).asLongBuffer().put(new long[]{uuid.getMostSignificantBits(), uuid.getLeastSignificantBits()});
        return bArr;
    }

    private static String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes("iso-8859-1"), 0, str.length());
            return Base64.encodeToString(instance.digest(), 2);
        } catch (Exception e) {
            return null;
        }
    }

    private void b(k kVar) {
        if (this.d == null) {
            ac.a((m) this, kVar);
            if (kVar.d() > 0) {
                this.d = new LinkedList();
                this.d.add(kVar);
                return;
            }
            return;
        }
        while (!l()) {
            k kVar2 = (k) this.d.remove();
            ac.a((m) this, kVar2);
            if (kVar2.d() > 0) {
                this.d.add(0, kVar2);
            }
        }
        if (this.d.size() == 0) {
            this.d = null;
        }
    }

    private void a(boolean z, boolean z2) {
        this.b = new r(this, this.e) {
            final /* synthetic */ ab f;

            protected void a(Exception exception) {
                if (this.f.c != null) {
                    this.f.c.a(exception);
                }
            }

            protected void b(byte[] bArr) {
                this.f.b(new k(bArr));
            }

            protected void a(String str) {
                if (this.f.f != null) {
                    this.f.f.a(str);
                }
            }

            protected void a(int i, String str) {
                this.f.e.d();
            }

            protected void c(byte[] bArr) {
                this.f.a.a(new k(bArr));
            }

            protected void c(String str) {
                if (this.f.h != null) {
                    this.f.h.a(str);
                }
            }

            protected void b(String str) {
                if (this.f.i != null) {
                    this.f.i.a(str);
                }
            }
        };
        this.b.a(z);
        this.b.b(z2);
        if (this.e.l()) {
            this.e.o_();
        }
    }

    public ab(com.b.a.c.e.b bVar, com.b.a.c.e.d dVar) {
        this(bVar.c());
        String a = a(bVar.b().a("Sec-WebSocket-Key") + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        bVar.b().a("Origin");
        dVar.a(101);
        dVar.c().a("Upgrade", "WebSocket");
        dVar.c().a("Connection", "Upgrade");
        dVar.c().a("Sec-WebSocket-Accept", a);
        a = bVar.b().a("Sec-WebSocket-Protocol");
        if (!TextUtils.isEmpty(a)) {
            dVar.c().a("Sec-WebSocket-Protocol", a);
        }
        dVar.d();
        a(false, false);
    }

    public static void a(d dVar, String str) {
        n e = dVar.e();
        String encodeToString = Base64.encodeToString(a(UUID.randomUUID()), 2);
        e.a("Sec-WebSocket-Version", "13");
        e.a("Sec-WebSocket-Key", encodeToString);
        e.a("Sec-WebSocket-Extensions", "x-webkit-deflate-frame");
        e.a("Connection", "Upgrade");
        e.a("Upgrade", "websocket");
        if (str != null) {
            e.a("Sec-WebSocket-Protocol", str);
        }
        e.a("Pragma", "no-cache");
        e.a("Cache-Control", "no-cache");
        if (TextUtils.isEmpty(dVar.e().a("User-Agent"))) {
            dVar.e().a("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.15 Safari/537.36");
        }
    }

    public ab(i iVar) {
        this.e = iVar;
        this.a = new j(this.e);
    }

    public static z a(n nVar, e eVar) {
        if (eVar == null || eVar.j() != 101 || !"websocket".equalsIgnoreCase(eVar.k().a("Upgrade"))) {
            return null;
        }
        String a = eVar.k().a("Sec-WebSocket-Accept");
        if (a == null) {
            return null;
        }
        String a2 = nVar.a("Sec-WebSocket-Key");
        if (a2 == null || !a.equalsIgnoreCase(a(a2 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").trim())) {
            return null;
        }
        a = nVar.a("Sec-WebSocket-Extensions");
        boolean z = false;
        if (a != null && a.equals("x-webkit-deflate-frame")) {
            z = true;
        }
        ab abVar = new ab(eVar.c());
        abVar.a(true, z);
        return abVar;
    }

    public void d() {
        this.e.d();
    }

    public void a(a aVar) {
        this.e.a(aVar);
    }

    public void b(a aVar) {
        this.c = aVar;
    }

    public a h() {
        return this.c;
    }

    public void a(byte[] bArr) {
        this.a.a(new k(this.b.a(bArr)));
    }

    public void a(c cVar) {
        this.f = cVar;
    }

    public void a(d dVar) {
        this.g = dVar;
    }

    public d f() {
        return this.g;
    }

    public boolean i() {
        return this.e.i();
    }

    public void a(k kVar) {
        a(kVar.a());
    }

    public void a(f fVar) {
        this.a.a(fVar);
    }

    public f g() {
        return this.a.g();
    }

    public g m() {
        return this.e.m();
    }

    public void n_() {
        this.e.n_();
    }

    public void o_() {
        this.e.o_();
    }

    public boolean l() {
        return this.e.l();
    }

    public String n() {
        return null;
    }
}
