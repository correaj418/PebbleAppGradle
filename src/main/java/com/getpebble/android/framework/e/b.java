package com.getpebble.android.framework.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.b.a.a.a;
import com.b.a.a.d;
import com.b.a.c.z;
import com.b.a.c.z.c;
import com.b.a.k;
import com.b.a.m;
import com.getpebble.android.bluetooth.h.h;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class b implements a, d, c, e {
    private static b j = null;
    private WeakReference<Context> a;
    private FrameworkState b;
    private c c;
    private boolean d = false;
    private com.getpebble.android.common.a.a e;
    private h f;
    private z g;
    private Handler h;
    private final com.getpebble.android.framework.install.firmware.c i;
    private Handler k = new Handler(Looper.getMainLooper());
    private Runnable l = new Runnable(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public void run() {
            f.d("DeveloperConnectionClient", "Connection timeout");
            this.a.f();
        }
    };

    public static void a(final Context context, final FrameworkState frameworkState, final h hVar, final com.getpebble.android.framework.install.firmware.c cVar) {
        c.a().post(new Runnable() {
            public void run() {
                b.e(context, frameworkState, hVar, cVar);
            }
        });
    }

    private static synchronized void e(Context context, FrameworkState frameworkState, h hVar, com.getpebble.android.framework.install.firmware.c cVar) {
        synchronized (b.class) {
            if (j != null) {
                f.d("DeveloperConnectionClient", "connectToServer; instance already exists");
            } else {
                com.getpebble.android.config.a a = com.getpebble.android.config.a.a(context);
                if (a == null) {
                    f.b("DeveloperConnectionClient", "Bootconfig is null");
                } else {
                    j = new b(URI.create(a.C()), context, frameworkState, hVar, cVar);
                }
            }
        }
    }

    public static void a() {
        c.a().post(new Runnable() {
            public void run() {
                b.c();
            }
        });
    }

    private static synchronized void c() {
        synchronized (b.class) {
            if (j == null) {
                f.d("DeveloperConnectionClient", "disconnectFromServer; instance is null");
            } else {
                j.f();
            }
        }
    }

    public static void b(final Context context, final FrameworkState frameworkState, final h hVar, final com.getpebble.android.framework.install.firmware.c cVar) {
        c.a().post(new Runnable() {
            public void run() {
                b.f(context, frameworkState, hVar, cVar);
            }
        });
    }

    private static synchronized void f(Context context, FrameworkState frameworkState, h hVar, com.getpebble.android.framework.install.firmware.c cVar) {
        synchronized (b.class) {
            if (j == null) {
                f.d("DeveloperConnectionClient", "ping; instance is null: connecting...");
                a(context, frameworkState, hVar, cVar);
            } else {
                j.d();
            }
        }
    }

    private b(URI uri, Context context, FrameworkState frameworkState, h hVar, com.getpebble.android.framework.install.firmware.c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        } else if (uri == null) {
            throw new IllegalArgumentException("'uri' cannot be null!");
        } else if (frameworkState == null) {
            throw new IllegalArgumentException("'frameworkState' cannot be null!");
        } else if (hVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        } else {
            this.a = new WeakReference(context);
            this.b = frameworkState;
            this.d = true;
            this.e = com.getpebble.android.common.a.a.f();
            this.f = hVar;
            this.h = new Handler(Looper.getMainLooper());
            this.i = cVar;
            f.d("DeveloperConnectionClient", "Connecting to " + uri);
            com.b.a.c.a.a().a(uri.toString(), "my-protocol", new com.b.a.c.a.b(this) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public void a(Exception exception, z zVar) {
                    if (exception != null) {
                        f.c("DeveloperConnectionClient", "Error connecting to proxy", exception);
                        return;
                    }
                    this.a.g = zVar;
                    this.a.g.a(this.a);
                    this.a.g.a(this.a);
                    this.a.g.a(this.a);
                    this.a.g.b(this.a);
                    this.a.h.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass5 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            this.a.a.e();
                        }
                    });
                }
            });
        }
    }

    private synchronized void d() {
        f.d("DeveloperConnectionClient", "Starting timeout...");
        this.k.removeCallbacks(this.l);
        this.k.postDelayed(this.l, 600000);
    }

    public void a(final ByteBuffer byteBuffer) {
        c.a().post(new Runnable(this) {
            final /* synthetic */ b b;

            public void run() {
                this.b.b(byteBuffer);
            }
        });
    }

    private void b(ByteBuffer byteBuffer) {
        synchronized (b.class) {
            if (j != null) {
                f.d("DeveloperConnectionClient", "sendMessageToAllConnections bytes: " + com.getpebble.android.bluetooth.b.b.c(byteBuffer.array()));
                this.g.a(byteBuffer.array());
            }
        }
    }

    private void e() {
        f.d("DeveloperConnectionClient", "onOpen");
        String b = this.e.b();
        if (b == null) {
            f.b("DeveloperConnectionClient", "token is null");
            return;
        }
        d();
        ByteBuffer allocate = ByteBuffer.allocate(b.length() + 2);
        allocate.put((byte) 9);
        allocate.put((byte) b.length());
        allocate.put(b.getBytes());
        f.d("DeveloperConnectionClient", "Sending auth");
        this.g.a(allocate.array());
    }

    public void a(String str) {
        f.d("DeveloperConnectionClient", "onMessage (string): '" + str + "'");
    }

    public void a(m mVar, k kVar) {
        final List arrayList = new ArrayList();
        for (Object add : kVar.b()) {
            arrayList.add(add);
        }
        kVar.m();
        this.h.post(new Runnable(this) {
            final /* synthetic */ b b;

            public void run() {
                for (ByteBuffer byteBuffer : arrayList) {
                    f.d("DeveloperConnectionClient", "onMessage (bytes) size = " + byteBuffer.capacity() + " mWaitingForHandshake = " + this.b.d + " bytes: " + com.getpebble.android.bluetooth.b.b.c(byteBuffer.array()));
                    this.b.d();
                    byte b;
                    if (!this.b.d) {
                        byteBuffer.mark();
                        if (byteBuffer.get() == c.c.PROXY_CONNECTION_STATUS.getCode()) {
                            b = byteBuffer.get();
                            if (b == (byte) -1) {
                                f.d("DeveloperConnectionClient", "PROXY_CONNECTED");
                                this.b.b.f(true);
                                if (this.b.c != null) {
                                    this.b.c.f();
                                }
                                Context context = (Context) this.b.a.get();
                                if (context != null) {
                                    this.b.c = new c(context, this.b, this.b.f, this.b.i);
                                } else {
                                    f.d("DeveloperConnectionClient", "context is null");
                                }
                            } else if (b == (byte) 0) {
                                f.d("DeveloperConnectionClient", "PROXY_DISCONNECTED");
                                if (this.b.c != null) {
                                    this.b.c.f();
                                    this.b.c = null;
                                }
                            } else {
                                f.b("DeveloperConnectionClient", "Unknown proxy status: " + b);
                            }
                        } else {
                            byteBuffer.reset();
                            if (this.b.c != null) {
                                this.b.c.a(byteBuffer, this.b.b);
                            }
                        }
                    } else if (byteBuffer.capacity() != 2) {
                        f.b("DeveloperConnectionClient", "Received size = " + byteBuffer.capacity() + " when expecting handshake response");
                        return;
                    } else if (byteBuffer.get() != (byte) 9) {
                        f.b("DeveloperConnectionClient", "expected auth key");
                        return;
                    } else {
                        b = byteBuffer.get();
                        if (b == (byte) 0) {
                            f.d("DeveloperConnectionClient", "AUTH_SUCCESS");
                            this.b.d = false;
                            return;
                        }
                        if (b == (byte) 1) {
                            f.c("DeveloperConnectionClient", "AUTH_FAILURE");
                        } else {
                            f.b("DeveloperConnectionClient", "Unknown response: " + b);
                        }
                        this.b.f();
                    }
                }
            }
        });
    }

    private void f() {
        f.d("DeveloperConnectionClient", "closeConnection");
        if (this.c != null) {
            this.c.f();
            this.c = null;
        }
        if (this.g != null) {
            this.g.d();
        }
        this.k.removeCallbacks(this.l);
        this.b.f(false);
        j = null;
    }

    public synchronized void a(final Exception exception) {
        this.h.post(new Runnable(this) {
            final /* synthetic */ b b;

            public void run() {
                f.d("DeveloperConnectionClient", "onClose", exception);
                this.b.f();
            }
        });
    }
}
