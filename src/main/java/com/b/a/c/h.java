package com.b.a.c;

import android.net.Uri;
import android.text.TextUtils;
import com.b.a.a.b;
import com.b.a.ac;
import com.b.a.c.b.a;
import com.b.a.d;
import com.b.a.e;
import com.b.a.i;
import com.b.a.p;
import com.b.a.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;

public class h extends i {
    protected SSLContext a;
    protected TrustManager[] b;
    protected HostnameVerifier c;
    protected List<g> d = new ArrayList();

    public h(a aVar) {
        super(aVar, "https", 443);
    }

    public void a(SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public SSLContext a() {
        return this.a != null ? this.a : e.c();
    }

    public void a(HostnameVerifier hostnameVerifier) {
        this.c = hostnameVerifier;
    }

    public void a(g gVar) {
        this.d.add(gVar);
    }

    protected SSLEngine a(a aVar, String str, int i) {
        SSLEngine sSLEngine;
        SSLContext a = a();
        SSLEngine sSLEngine2 = null;
        for (g a2 : this.d) {
            sSLEngine2 = a2.a(a, str, i);
            if (sSLEngine2 != null) {
                sSLEngine = sSLEngine2;
                break;
            }
        }
        sSLEngine = sSLEngine2;
        for (g a22 : this.d) {
            a22.a(sSLEngine, aVar, str, i);
        }
        return sSLEngine;
    }

    protected e.a a(a aVar, final b bVar) {
        return new e.a(this) {
            final /* synthetic */ h b;

            public void a(Exception exception, d dVar) {
                bVar.a(exception, dVar);
            }
        };
    }

    protected void a(i iVar, a aVar, Uri uri, int i, b bVar) {
        e.a(iVar, uri.getHost(), i, a(aVar, uri.getHost(), i), this.b, this.c, true, a(aVar, bVar));
    }

    protected b a(a aVar, Uri uri, int i, boolean z, b bVar) {
        final b bVar2 = bVar;
        final boolean z2 = z;
        final a aVar2 = aVar;
        final Uri uri2 = uri;
        final int i2 = i;
        return new b(this) {
            final /* synthetic */ h f;

            public void a(Exception exception, final i iVar) {
                if (exception != null) {
                    bVar2.a(exception, iVar);
                } else if (z2) {
                    String format = String.format(Locale.ENGLISH, "CONNECT %s:%s HTTP/1.1\r\nHost: %s\r\n\r\n", new Object[]{uri2.getHost(), Integer.valueOf(i2), uri2.getHost()});
                    aVar2.j.b("Proxying: " + format);
                    ac.a((p) iVar, format.getBytes(), new com.b.a.a.a(this) {
                        final /* synthetic */ AnonymousClass2 b;

                        public void a(Exception exception) {
                            if (exception != null) {
                                bVar2.a(exception, iVar);
                                return;
                            }
                            com.b.a.a.d wVar = new w();
                            wVar.a(new w.a(this) {
                                String a;
                                final /* synthetic */ AnonymousClass1 b;

                                {
                                    this.b = r1;
                                }

                                public void a(String str) {
                                    aVar2.j.b(str);
                                    if (this.a == null) {
                                        this.a = str.trim();
                                        if (!this.a.matches("HTTP/1.\\d 2\\d\\d .*")) {
                                            iVar.a(null);
                                            iVar.b(null);
                                            bVar2.a(new IOException("non 2xx status line: " + this.a), iVar);
                                        }
                                    } else if (TextUtils.isEmpty(str.trim())) {
                                        iVar.a(null);
                                        iVar.b(null);
                                        this.b.b.f.a(iVar, aVar2, uri2, i2, bVar2);
                                    }
                                }
                            });
                            iVar.a(wVar);
                            iVar.b(new com.b.a.a.a(this) {
                                final /* synthetic */ AnonymousClass1 a;

                                {
                                    this.a = r1;
                                }

                                public void a(Exception exception) {
                                    if (!iVar.i() && exception == null) {
                                        exception = new IOException("socket closed before proxy connect response");
                                    }
                                    bVar2.a(exception, iVar);
                                }
                            });
                        }
                    });
                } else {
                    this.f.a(iVar, aVar2, uri2, i2, bVar2);
                }
            }
        };
    }
}
