package com.getpebble.android.framework.e;

import android.content.Context;
import com.b.a.a.a;
import com.b.a.c.e.a.b;
import com.b.a.c.n;
import com.b.a.c.z;
import com.b.a.k;
import com.b.a.m;
import com.getpebble.android.bluetooth.h.h;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.install.firmware.c;
import com.getpebble.android.framework.m.f;
import com.getpebble.android.h.o;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class d implements a, b, e {
    private FrameworkState a;
    private c b;
    private com.b.a.c.e.a c;
    private List<z> d;
    private f e = null;
    private boolean f = false;
    private Runnable g = new Runnable(this) {
        final /* synthetic */ d a;

        {
            this.a = r1;
        }

        public void run() {
            if (this.a.f) {
                com.getpebble.android.common.b.a.f.d("DeveloperConnectionServer", "Connection timeout");
                this.a.b();
            }
        }
    };
    private final String h = "SOCKETS_LOCK";

    public d(Context context, FrameworkState frameworkState, h hVar, c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        } else if (frameworkState == null) {
            throw new IllegalArgumentException("'frameworkState' cannot be null!");
        } else {
            this.a = frameworkState;
            this.d = new ArrayList();
            this.c = new com.b.a.c.e.a();
            this.b = new c(context, this, hVar, cVar);
        }
    }

    public void a() {
        this.e = new f(this.a);
        c.a().post(new Runnable(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.d();
            }
        });
    }

    private void d() {
        this.f = true;
        this.c.a(".*", (b) this);
        this.c.a(9000);
        this.c.a((a) this);
        com.getpebble.android.common.b.a.f.c("DeveloperConnectionServer", "DeveloperConnectionServer started: " + o.a());
        this.a.a(o.a());
        f();
    }

    public void b() {
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
        c.a().post(new Runnable(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.e();
            }
        });
    }

    private void e() {
        com.getpebble.android.common.b.a.f.c("DeveloperConnectionServer", "DeveloperConnectionServer stopped: " + o.a());
        c.a().removeCallbacks(this.g);
        for (z d : this.d) {
            d.d();
        }
        this.f = false;
        this.c.a();
        this.a.a(null);
        this.b.f();
    }

    public void a(Exception exception) {
        com.getpebble.android.common.b.a.f.a("DeveloperConnectionServer", "Got error on WebSocket", exception);
    }

    public void a(final ByteBuffer byteBuffer) {
        c.a().post(new Runnable(this) {
            final /* synthetic */ d b;

            public void run() {
                this.b.b(byteBuffer);
            }
        });
    }

    private void b(ByteBuffer byteBuffer) {
        for (z a : this.d) {
            a.a(byteBuffer.array());
        }
    }

    public void a(final z zVar, final com.b.a.c.e.b bVar) {
        c.a().post(new Runnable(this) {
            final /* synthetic */ d c;

            public void run() {
                this.c.b(zVar, bVar);
            }
        });
    }

    private void b(final z zVar, com.b.a.c.e.b bVar) {
        n b = bVar.b();
        if (b == null) {
            com.getpebble.android.common.b.a.f.a("DeveloperConnectionServer", "onConnected: request headers were null");
            return;
        }
        f();
        final String a = b.a("Host");
        com.getpebble.android.common.b.a.f.c("DeveloperConnectionServer", "pb-sdk connection opened: " + a);
        synchronized ("SOCKETS_LOCK") {
            this.d.add(zVar);
        }
        com.getpebble.android.common.b.a.f.c("DeveloperConnectionServer", "Num connections: " + this.d.size());
        zVar.a(new a(this) {
            final /* synthetic */ d c;

            public void a(Exception exception) {
                com.getpebble.android.common.b.a.f.c("DeveloperConnectionServer", "pb-sdk connection closed: " + a, exception);
                this.c.a(zVar);
            }
        });
        zVar.a(new z.c(this) {
            final /* synthetic */ d b;

            public void a(String str) {
                com.getpebble.android.common.b.a.f.d("DeveloperConnectionServer", "onMessage: unused message (" + a + "): " + str);
            }
        });
        zVar.a(new com.b.a.a.d(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            public void a(m mVar, k kVar) {
                this.a.f();
                for (final ByteBuffer byteBuffer : kVar.b()) {
                    c.a().post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass10 b;

                        public void run() {
                            this.b.a.b.a(byteBuffer, this.b.a.a);
                        }
                    });
                }
            }
        });
        zVar.b(new a(this) {
            final /* synthetic */ d c;

            public void a(Exception exception) {
                com.getpebble.android.common.b.a.f.c("DeveloperConnectionServer", "pb-sdk connection ended: " + a, exception);
                this.c.a(zVar);
            }
        });
        this.a.e(true);
    }

    private void a(final z zVar) {
        c.a().post(new Runnable(this) {
            final /* synthetic */ d b;

            public void run() {
                this.b.b(zVar);
            }
        });
    }

    private void b(z zVar) {
        synchronized ("SOCKETS_LOCK") {
            this.d.remove(zVar);
            if (this.d.size() == 0) {
                this.a.e(false);
            }
        }
    }

    private synchronized void f() {
        com.getpebble.android.common.b.a.f.d("DeveloperConnectionServer", "Starting timeout...");
        c.a().removeCallbacks(this.g);
        c.a().postDelayed(this.g, 600000);
    }

    public void c() {
        c.a().post(new Runnable(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.g();
            }
        });
    }

    private void g() {
        if (this.f) {
            com.getpebble.android.common.b.a.f.d("DeveloperConnectionServer", "pingInternal: resetting timeout..");
            f();
            return;
        }
        com.getpebble.android.common.b.a.f.d("DeveloperConnectionServer", "pingInternal: starting..");
        a();
    }
}
