package com.b.a;

import android.os.Build.VERSION;
import com.b.a.a.d;
import com.b.a.a.f;
import java.nio.ByteBuffer;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLEngineResult.Status;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class e implements d, com.b.a.g.a {
    static SSLContext a;
    static final /* synthetic */ boolean t;
    i b;
    j c;
    boolean d;
    SSLEngine e;
    boolean f;
    HostnameVerifier g;
    a h;
    X509Certificate[] i;
    f j;
    d k;
    TrustManager[] l;
    boolean m;
    boolean n;
    Exception o;
    final k p = new k();
    final d q = new d(this) {
        final com.b.a.f.a a = new com.b.a.f.a().c(8192);
        final k b = new k();
        final /* synthetic */ e c;

        {
            this.c = r3;
        }

        public void a(m mVar, k kVar) {
            if (!this.c.d) {
                try {
                    this.c.d = true;
                    kVar.a(this.b);
                    if (this.b.e()) {
                        this.b.a(this.b.k());
                    }
                    ByteBuffer byteBuffer = k.g;
                    while (true) {
                        if (byteBuffer.remaining() == 0 && this.b.o() > 0) {
                            byteBuffer = this.b.n();
                        }
                        int remaining = byteBuffer.remaining();
                        int d = this.c.p.d();
                        ByteBuffer a = this.a.a();
                        SSLEngineResult unwrap = this.c.e.unwrap(byteBuffer, a);
                        this.c.a(this.c.p, a);
                        this.a.a((long) (this.c.p.d() - d));
                        if (unwrap.getStatus() != Status.BUFFER_OVERFLOW) {
                            if (unwrap.getStatus() == Status.BUFFER_UNDERFLOW) {
                                this.b.b(byteBuffer);
                                if (this.b.o() <= 1) {
                                    break;
                                }
                                this.b.b(this.b.k());
                                byteBuffer = k.g;
                                remaining = -1;
                            }
                        } else {
                            this.a.c(this.a.b() * 2);
                            remaining = -1;
                        }
                        this.c.a(unwrap.getHandshakeStatus());
                        if (byteBuffer.remaining() == remaining && d == this.c.p.d()) {
                            break;
                        }
                    }
                    this.b.b(byteBuffer);
                    this.c.e();
                } catch (Exception e) {
                    e.printStackTrace();
                    this.c.a(e);
                } finally {
                    this.c.d = false;
                }
            }
        }
    };
    k r = new k();
    com.b.a.a.a s;
    private int u;
    private String v;
    private boolean w;

    public interface a {
        void a(Exception exception, d dVar);
    }

    static {
        boolean z = true;
        if (e.class.desiredAssertionStatus()) {
            z = false;
        }
        t = z;
        try {
            if (VERSION.SDK_INT <= 15) {
                throw new Exception();
            }
            a = SSLContext.getInstance("Default");
        } catch (Exception e) {
            try {
                a = SSLContext.getInstance("TLS");
                a.init(null, new TrustManager[]{new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }

                    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                    }

                    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                        for (X509Certificate x509Certificate : x509CertificateArr) {
                            if (!(x509Certificate == null || x509Certificate.getCriticalExtensionOIDs() == null)) {
                                x509Certificate.getCriticalExtensionOIDs().remove("2.5.29.15");
                            }
                        }
                    }
                }}, null);
            } catch (Exception e2) {
                e.printStackTrace();
                e2.printStackTrace();
            }
        }
    }

    public static SSLContext c() {
        return a;
    }

    public static void a(i iVar, String str, int i, SSLEngine sSLEngine, TrustManager[] trustManagerArr, HostnameVerifier hostnameVerifier, boolean z, final a aVar) {
        e eVar = new e(iVar, str, i, sSLEngine, trustManagerArr, hostnameVerifier, z);
        eVar.h = aVar;
        iVar.a(new com.b.a.a.a() {
            public void a(Exception exception) {
                if (exception != null) {
                    aVar.a(exception, null);
                } else {
                    aVar.a(new SSLException("socket closed during handshake"), null);
                }
            }
        });
        try {
            eVar.e.beginHandshake();
            eVar.a(eVar.e.getHandshakeStatus());
        } catch (Exception e) {
            eVar.a(e);
        }
    }

    private e(i iVar, String str, int i, SSLEngine sSLEngine, TrustManager[] trustManagerArr, HostnameVerifier hostnameVerifier, boolean z) {
        this.b = iVar;
        this.g = hostnameVerifier;
        this.m = z;
        this.l = trustManagerArr;
        this.e = sSLEngine;
        this.v = str;
        this.u = i;
        this.e.setUseClientMode(z);
        this.c = new j(iVar);
        this.c.a(new f(this) {
            final /* synthetic */ e a;

            {
                this.a = r1;
            }

            public void a() {
                if (this.a.j != null) {
                    this.a.j.a();
                }
            }
        });
        this.b.b(new com.b.a.a.a(this) {
            final /* synthetic */ e a;

            {
                this.a = r1;
            }

            public void a(Exception exception) {
                if (!this.a.n) {
                    this.a.n = true;
                    this.a.o = exception;
                    if (!this.a.p.e() && this.a.s != null) {
                        this.a.s.a(exception);
                    }
                }
            }
        });
        this.b.a(this.q);
    }

    public void e() {
        ac.a((m) this, this.p);
        if (this.n && !this.p.e() && this.s != null) {
            this.s.a(this.o);
        }
    }

    public SSLEngine b() {
        return this.e;
    }

    void a(k kVar, ByteBuffer byteBuffer) {
        byteBuffer.flip();
        if (byteBuffer.hasRemaining()) {
            kVar.a(byteBuffer);
        } else {
            k.c(byteBuffer);
        }
    }

    public void a() {
        this.b.a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(javax.net.ssl.SSLEngineResult.HandshakeStatus r12) {
        /*
        r11 = this;
        r2 = 1;
        r3 = 0;
        r1 = 0;
        r0 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_TASK;
        if (r12 != r0) goto L_0x0010;
    L_0x0007:
        r0 = r11.e;
        r0 = r0.getDelegatedTask();
        r0.run();
    L_0x0010:
        r0 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP;
        if (r12 != r0) goto L_0x0019;
    L_0x0014:
        r0 = r11.r;
        r11.a(r0);
    L_0x0019:
        r0 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        if (r12 != r0) goto L_0x0027;
    L_0x001d:
        r0 = r11.q;
        r4 = new com.b.a.k;
        r4.<init>();
        r0.a(r11, r4);
    L_0x0027:
        r0 = r11.f;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        if (r0 != 0) goto L_0x0113;
    L_0x002b:
        r0 = r11.e;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r0 = r0.getHandshakeStatus();	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r4 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        if (r0 == r4) goto L_0x003f;
    L_0x0035:
        r0 = r11.e;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r0 = r0.getHandshakeStatus();	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r4 = javax.net.ssl.SSLEngineResult.HandshakeStatus.FINISHED;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        if (r0 != r4) goto L_0x0113;
    L_0x003f:
        r0 = r11.m;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        if (r0 == 0) goto L_0x00f2;
    L_0x0043:
        r0 = r11.l;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        if (r0 != 0) goto L_0x0123;
    L_0x0047:
        r0 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm();	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r4 = javax.net.ssl.TrustManagerFactory.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r0 = 0;
        r0 = (java.security.KeyStore) r0;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r4.init(r0);	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r0 = r4.getTrustManagers();	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r6 = r0;
    L_0x005a:
        r7 = r6.length;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r4 = r3;
        r5 = r1;
    L_0x005d:
        if (r4 >= r7) goto L_0x0120;
    L_0x005f:
        r0 = r6[r4];	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r0 = (javax.net.ssl.X509TrustManager) r0;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r1 = r11.e;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r1 = r1.getSession();	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r1 = r1.getPeerCertificates();	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r1 = (java.security.cert.X509Certificate[]) r1;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r1 = (java.security.cert.X509Certificate[]) r1;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r11.i = r1;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r1 = r11.i;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r8 = "SSL";
        r0.checkServerTrusted(r1, r8);	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r0 = r11.v;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        if (r0 == 0) goto L_0x009e;
    L_0x007e:
        r0 = r11.g;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        if (r0 != 0) goto L_0x00ba;
    L_0x0082:
        r0 = new org.apache.http.conn.ssl.StrictHostnameVerifier;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r0.<init>();	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r1 = r11.v;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r8 = r11.i;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r9 = 0;
        r8 = r8[r9];	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r8 = org.apache.http.conn.ssl.StrictHostnameVerifier.getCNs(r8);	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r9 = r11.i;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r10 = 0;
        r9 = r9[r10];	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r9 = org.apache.http.conn.ssl.StrictHostnameVerifier.getDNSSubjectAlts(r9);	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r0.verify(r1, r8, r9);	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
    L_0x009e:
        r0 = r2;
    L_0x009f:
        r1 = 1;
        r11.f = r1;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        if (r0 != 0) goto L_0x00f5;
    L_0x00a4:
        r0 = new com.b.a.c;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r0.<init>(r5);	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r11.a(r0);	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r1 = r0.a();	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        if (r1 != 0) goto L_0x00f5;
    L_0x00b2:
        throw r0;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
    L_0x00b3:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r1.<init>(r0);
        throw r1;
    L_0x00ba:
        r0 = r11.g;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r1 = r11.v;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r8 = r11.e;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r8 = r8.getSession();	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r0 = r0.verify(r1, r8);	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        if (r0 != 0) goto L_0x009e;
    L_0x00ca:
        r0 = new javax.net.ssl.SSLException;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r1 = new java.lang.StringBuilder;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r1.<init>();	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r5 = "hostname <";
        r1 = r1.append(r5);	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r5 = r11.v;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r1 = r1.append(r5);	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r5 = "> has been denied";
        r1 = r1.append(r5);	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r1 = r1.toString();	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        r0.<init>(r1);	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
        throw r0;	 Catch:{ GeneralSecurityException -> 0x00eb, SSLException -> 0x011e, NoSuchAlgorithmException -> 0x00b3, c -> 0x0119 }
    L_0x00eb:
        r0 = move-exception;
    L_0x00ec:
        r1 = r4 + 1;
        r4 = r1;
        r5 = r0;
        goto L_0x005d;
    L_0x00f2:
        r0 = 1;
        r11.f = r0;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
    L_0x00f5:
        r0 = r11.h;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r1 = 0;
        r0.a(r1, r11);	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r0 = 0;
        r11.h = r0;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r0 = r11.b;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r1 = 0;
        r0.a(r1);	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r0 = r11.m();	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r1 = new com.b.a.e$6;	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r1.<init>(r11);	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r0.a(r1);	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
        r11.e();	 Catch:{ NoSuchAlgorithmException -> 0x00b3, GeneralSecurityException -> 0x0114, c -> 0x0119 }
    L_0x0113:
        return;
    L_0x0114:
        r0 = move-exception;
        r11.a(r0);
        goto L_0x0113;
    L_0x0119:
        r0 = move-exception;
        r11.a(r0);
        goto L_0x0113;
    L_0x011e:
        r0 = move-exception;
        goto L_0x00ec;
    L_0x0120:
        r0 = r3;
        goto L_0x009f;
    L_0x0123:
        r6 = r0;
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.e.a(javax.net.ssl.SSLEngineResult$HandshakeStatus):void");
    }

    int a(int i) {
        int i2 = (i * 3) / 2;
        if (i2 == 0) {
            return 8192;
        }
        return i2;
    }

    public void a(k kVar) {
        SSLEngineResult sSLEngineResult;
        SSLEngineResult sSLEngineResult2;
        Exception exception;
        if (!this.w && this.c.c() <= 0) {
            this.w = true;
            ByteBuffer c = k.c(a(kVar.d()));
            SSLEngineResult sSLEngineResult3 = null;
            while (true) {
                if (this.f && kVar.d() == 0) {
                    break;
                }
                int d = kVar.d();
                int i;
                try {
                    ByteBuffer[] b = kVar.b();
                    sSLEngineResult3 = this.e.wrap(b, c);
                    kVar.a(b);
                    c.flip();
                    this.r.a(c);
                    if (t || !this.r.e()) {
                        if (this.r.d() > 0) {
                            this.c.a(this.r);
                        }
                        int capacity = c.capacity();
                        try {
                            if (sSLEngineResult3.getStatus() == Status.BUFFER_OVERFLOW) {
                                c = k.c(capacity * 2);
                                d = -1;
                            } else {
                                c = k.c(a(kVar.d()));
                                a(sSLEngineResult3.getHandshakeStatus());
                            }
                            sSLEngineResult = sSLEngineResult3;
                            i = d;
                            sSLEngineResult2 = sSLEngineResult;
                        } catch (Exception e) {
                            exception = e;
                            c = null;
                            a(exception);
                            sSLEngineResult = sSLEngineResult3;
                            i = d;
                            sSLEngineResult2 = sSLEngineResult;
                            sSLEngineResult3 = sSLEngineResult2;
                        }
                        if ((i == kVar.d() && (sSLEngineResult2 == null || sSLEngineResult2.getHandshakeStatus() != HandshakeStatus.NEED_WRAP)) || this.c.c() != 0) {
                            break;
                        }
                        sSLEngineResult3 = sSLEngineResult2;
                    } else {
                        throw new AssertionError();
                    }
                } catch (SSLException e2) {
                    exception = e2;
                    a(exception);
                    sSLEngineResult = sSLEngineResult3;
                    i = d;
                    sSLEngineResult2 = sSLEngineResult;
                    sSLEngineResult3 = sSLEngineResult2;
                }
            }
            this.w = false;
            k.c(c);
        }
    }

    public void a(f fVar) {
        this.j = fVar;
    }

    public f g() {
        return this.j;
    }

    private void a(Exception exception) {
        a aVar = this.h;
        if (aVar != null) {
            this.h = null;
            this.b.a(new com.b.a.a.d.a());
            this.b.a();
            this.b.a(null);
            this.b.d();
            aVar.a(exception, null);
            return;
        }
        com.b.a.a.a h = h();
        if (h != null) {
            h.a(exception);
        }
    }

    public void a(d dVar) {
        this.k = dVar;
    }

    public d f() {
        return this.k;
    }

    public boolean i() {
        return this.b.i();
    }

    public void d() {
        this.b.d();
    }

    public void a(com.b.a.a.a aVar) {
        this.b.a(aVar);
    }

    public void b(com.b.a.a.a aVar) {
        this.s = aVar;
    }

    public com.b.a.a.a h() {
        return this.s;
    }

    public void n_() {
        this.b.n_();
    }

    public void o_() {
        this.b.o_();
        e();
    }

    public boolean l() {
        return this.b.l();
    }

    public g m() {
        return this.b.m();
    }

    public i o() {
        return this.b;
    }

    public String n() {
        return null;
    }
}
