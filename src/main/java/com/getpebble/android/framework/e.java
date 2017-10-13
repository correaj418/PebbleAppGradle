package com.getpebble.android.framework;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.System;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.Transport;
import com.getpebble.android.bluetooth.h;
import com.getpebble.android.bluetooth.h.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.s;
import com.getpebble.android.framework.e.d;
import com.getpebble.android.framework.g.k;
import com.getpebble.android.framework.g.q;
import com.getpebble.android.framework.i.b;
import com.getpebble.android.framework.location.PebbleLocationService;
import com.getpebble.android.framework.m.i;
import com.getpebble.android.h.v;
import java.lang.ref.WeakReference;
import java.util.UUID;

public class e implements c {
    private static String a = "PebbleFrameworkManager";
    private static HandlerThread x;
    private b A;
    private final WeakReference<Context> b;
    private c c;
    private a d;
    private com.getpebble.android.b.c e;
    private h.c f;
    private a g;
    private h.h h;
    private com.getpebble.android.bluetooth.h.e i;
    private com.getpebble.android.framework.f.a j;
    private h.b k;
    private FrameworkState l;
    private com.getpebble.android.framework.install.firmware.c m;
    private com.getpebble.android.framework.i.a n;
    private d o;
    private com.getpebble.android.notifications.b.a p;
    private com.getpebble.android.framework.a.c q;
    private com.getpebble.android.framework.k.a r;
    private com.getpebble.android.framework.j.a s;
    private com.getpebble.android.framework.m.h t;
    private com.getpebble.android.mms.c u = null;
    private s.a v;
    private final i w;
    private HandlerThread y;
    private com.getpebble.android.framework.pebblekit.a z;

    public static synchronized HandlerThread b() {
        HandlerThread handlerThread;
        synchronized (e.class) {
            if (x == null) {
                x = new HandlerThread("lowLatencyWorkerThread", -1);
                x.start();
            }
            handlerThread = x;
        }
        return handlerThread;
    }

    private e(Context context) {
        this.b = new WeakReference(context);
        if (context == null) {
            throw new IllegalArgumentException("Cannot create framework with null context");
        }
        Object a = com.getpebble.android.bluetooth.d.a(context);
        this.g = a;
        this.f = a;
        this.h = a;
        this.i = a;
        PebbleLocationService.a();
        this.y = new HandlerThread("mediumFrameworkThread", 10);
        this.y.start();
        com.getpebble.android.framework.d.a.a(context, this.y);
        this.e = new com.getpebble.android.framework.c.a(context.getMainLooper(), context, this.f, this.g, this.h, new com.getpebble.android.framework.c.a.b(context.getContentResolver()));
        this.c = new c(context);
        this.d = new a();
        boolean e = this.g.e();
        f.d(a, "Initialising FrameworkState with isDiscovering = false adapterEnabled = " + e);
        this.l = new FrameworkState(false, e, new FrameworkState.b(this) {
            final /* synthetic */ e a;

            {
                this.a = r1;
            }

            public void a() {
                FrameworkState a = this.a.l;
                if (a == null) {
                    f.b(e.a, "stateToCopy is null; not sending to UI");
                } else {
                    this.a.d.a(new FrameworkState(a));
                }
            }
        });
        this.k = new h.b(this) {
            final /* synthetic */ e a;

            {
                this.a = r1;
            }

            public void a(boolean z) {
                this.a.l.b(z);
            }

            public void a() {
                f.b(e.a, "onAdapterError()");
            }
        };
        this.j = new com.getpebble.android.framework.f.a(context, this.i, this);
        this.g.a(this.k);
        this.m = new com.getpebble.android.framework.install.firmware.c(context);
        this.n = new com.getpebble.android.framework.i.a(context, this.l);
        this.s = new com.getpebble.android.framework.j.a(new Handler());
        com.getpebble.android.common.a.K().getContentResolver().registerContentObserver(System.CONTENT_URI, true, this.s);
        this.z = com.getpebble.android.framework.pebblekit.a.a(context);
        this.A = new b(this.c, context.getContentResolver(), this.e);
        this.p = new com.getpebble.android.notifications.b.a();
        if (VERSION.SDK_INT >= 21) {
            com.getpebble.android.f.d.a();
        }
        com.getpebble.android.framework.m.h.a(this.e);
        com.getpebble.android.framework.pebblekit.b.setCsm(this.e);
        this.w = new i(context);
        com.getpebble.android.framework.e.a.a(context, this.l, this.g);
        context.registerReceiver(this.t, new IntentFilter("android.intent.action.PHONE_STATE"));
        b(context);
    }

    private void b(final Context context) {
        new com.getpebble.android.bluetooth.b.f(this) {
            final /* synthetic */ e b;
            private final String c = e.a;

            public boolean doInBackground() {
                long currentTimeMillis = System.currentTimeMillis();
                com.getpebble.android.h.s.b();
                this.b.q = new com.getpebble.android.framework.a.c(context.getContentResolver(), this.b.e);
                this.b.r = new com.getpebble.android.framework.k.a(context.getContentResolver(), this.b.y.getLooper());
                if (v.a(v.a.SMS)) {
                    this.b.u = new com.getpebble.android.mms.c(context);
                    this.b.u.a(context);
                } else {
                    v.a(this.c, v.a.SMS, "Couldn't start MMS monitoring");
                }
                this.b.v = new s.a(new Handler(this.b.y.getLooper()));
                context.getContentResolver().registerContentObserver(s.a.a, true, this.b.v);
                s.c(context.getContentResolver());
                com.getpebble.android.common.c.c.a(context);
                f.d(this.c, "doAsyncInit: took " + (System.currentTimeMillis() - currentTimeMillis));
                return false;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    public static e a(Context context) {
        if (context != null) {
            return new e(context);
        }
        throw new IllegalArgumentException("'context' cannot be null");
    }

    public Handler a(Looper looper) {
        return new Handler(this, looper) {
            final /* synthetic */ e a;

            public void handleMessage(Message message) {
                a(message);
            }

            private void a(Message message) {
                Bundle data;
                PebbleDevice pebbleDevice;
                Context context;
                Bundle data2;
                Uri uri;
                Uri uri2;
                Bundle bundle;
                switch (message.what) {
                    case 1:
                        f.d(e.a, "Request to connect to a device");
                        data = message.getData();
                        if (data == null) {
                            f.b(e.a, "Null bundle");
                            return;
                        }
                        data.setClassLoader(PebbleDevice.class.getClassLoader());
                        pebbleDevice = (PebbleDevice) data.getParcelable("device_extra");
                        if (pebbleDevice == null) {
                            f.b(e.a, "Null device");
                            return;
                        } else {
                            this.a.e.e(pebbleDevice);
                            return;
                        }
                    case 2:
                        f.d(e.a, "Request to disconnect from a device");
                        data = message.getData();
                        if (data == null) {
                            f.b(e.a, "Null bundle");
                            return;
                        }
                        data.setClassLoader(PebbleDevice.class.getClassLoader());
                        pebbleDevice = (PebbleDevice) data.getParcelable("device_extra");
                        if (pebbleDevice == null) {
                            f.b(e.a, "Null device");
                            return;
                        } else {
                            this.a.e.f(pebbleDevice);
                            return;
                        }
                    case 3:
                        f.d(e.a, "Set reply messenger");
                        this.a.d.a(message.replyTo);
                        this.a.d.a(new FrameworkState(this.a.l));
                        return;
                    case 4:
                        f.d(e.a, "Received request to start discovery");
                        context = (Context) this.a.b.get();
                        if (context == null) {
                            f.d(e.a, "Failed to purge unknown devices due to null context");
                            return;
                        }
                        ak.purgeUnknownDevices(context.getContentResolver());
                        this.a.j.c();
                        this.a.g.a(Transport.from(message.getData().getInt("discovery_transport_extra")));
                        return;
                    case 5:
                        f.d(e.a, "Received request to stop discovery");
                        this.a.g.d();
                        return;
                    case 6:
                        f.d(e.a, "Received request to send demo notification");
                        data = message.getData();
                        if (data == null) {
                            f.b(e.a, "Null bundle");
                            return;
                        }
                        com.getpebble.android.framework.i.a.a aVar = (com.getpebble.android.framework.i.a.a) data.getSerializable("notification_type_extra");
                        if (aVar == null) {
                            f.b(e.a, "Null demo type");
                            return;
                        } else {
                            this.a.n.a(aVar);
                            return;
                        }
                    case 7:
                        f.d(e.a, "Received request to update firmware");
                        data2 = message.getData();
                        if (data2 == null) {
                            f.b(e.a, "Null bundle");
                            return;
                        }
                        data2.setClassLoader(PebbleDevice.class.getClassLoader());
                        pebbleDevice = (PebbleDevice) data2.getParcelable("device_extra");
                        if (pebbleDevice == null) {
                            f.b(e.a, "Null device");
                            return;
                        }
                        uri = (Uri) data2.getParcelable("firmware_uri_extra");
                        if (uri == null) {
                            f.b(e.a, "Null firmware uri");
                            return;
                        } else if (((Context) this.a.b.get()) == null) {
                            f.d(e.a, "Failed to install firmware due to null context");
                            return;
                        } else {
                            this.a.m.a(com.getpebble.android.framework.b.a.a(this.a.h, pebbleDevice), uri, this.a.l);
                            return;
                        }
                    case 8:
                        f.d(e.a, "Received request to update to latest available firmware");
                        data = message.getData();
                        if (data == null) {
                            f.b(e.a, "Null bundle");
                            return;
                        }
                        data.setClassLoader(PebbleDevice.class.getClassLoader());
                        pebbleDevice = (PebbleDevice) data.getParcelable("device_extra");
                        if (pebbleDevice == null) {
                            f.b(e.a, "Null device");
                            return;
                        } else if (((Context) this.a.b.get()) == null) {
                            f.d(e.a, "Failed to install firmware due to null context");
                            return;
                        } else {
                            this.a.m.a(com.getpebble.android.framework.b.a.a(this.a.h, pebbleDevice), this.a.l);
                            return;
                        }
                    case 9:
                        f.d(e.a, "Received request to fetch app info from uri");
                        data = message.getData();
                        if (data == null) {
                            f.b(e.a, "Null bundle");
                            return;
                        }
                        uri2 = (Uri) data.getParcelable("uri_extra");
                        if (uri2 == null) {
                            f.b(e.a, "Null uri");
                            return;
                        }
                        Context context2 = (Context) this.a.b.get();
                        if (context2 == null) {
                            f.b(e.a, "Null context");
                            return;
                        } else {
                            new com.getpebble.android.framework.install.a.a(context2).a(uri2, this.a.l);
                            return;
                        }
                    case 10:
                        data2 = message.getData();
                        if (data2 == null) {
                            f.b(e.a, "Null bundle");
                            return;
                        }
                        data2.setClassLoader(PebbleDevice.class.getClassLoader());
                        pebbleDevice = (PebbleDevice) data2.getParcelable("device_extra");
                        if (pebbleDevice == null) {
                            f.b(e.a, "Null device");
                            return;
                        }
                        String string = data2.getString("file_name_extra");
                        bundle = new Bundle();
                        bundle.putString(k.b.FILE_NAME.toString(), string);
                        this.a.a(new k(com.getpebble.android.bluetooth.g.a.GET_BYTES, k.a.REQUEST_GET_BYTES, bundle), pebbleDevice);
                        return;
                    case 11:
                        f.d(e.a, "Received request for log dump");
                        data = message.getData();
                        if (data == null) {
                            f.b(e.a, "Null bundle");
                            return;
                        }
                        PebbleFrameworkService.a().e();
                        data.setClassLoader(PebbleDevice.class.getClassLoader());
                        pebbleDevice = (PebbleDevice) data.getParcelable("device_extra");
                        if (pebbleDevice == null) {
                            f.b(e.a, "Null device");
                            return;
                        }
                        if (!this.a.a(new k(com.getpebble.android.bluetooth.g.a.LOG_DUMP, k.a.REQUEST_LOG_DUMP), pebbleDevice)) {
                            f.c(e.a, "Log dump request failed");
                            this.a.l.a(com.getpebble.android.framework.g.s.a.ERROR_UNKNOWN.getValue(), null);
                            return;
                        }
                        return;
                    case 12:
                        f.d(e.a, "Received request to start developer connection");
                        context = (Context) this.a.b.get();
                        if (context == null) {
                            f.b(e.a, "Null context");
                            return;
                        } else if (this.a.o != null) {
                            f.d(e.a, "Developer connection server was not previously stopped; dropping request to start server");
                            return;
                        } else {
                            this.a.o = new d(context, this.a.l, this.a.h, this.a.m);
                            this.a.o.a();
                            com.getpebble.android.framework.e.b.a(context, this.a.l, this.a.h, this.a.m);
                            this.a.c.b(c.a.DEVELOPER_CONNECTION_ACTIVE, true);
                            return;
                        }
                    case 13:
                        f.d(e.a, "Received request to stop developer connection");
                        if (this.a.o != null) {
                            this.a.o.b();
                            this.a.o = null;
                        }
                        com.getpebble.android.framework.e.b.a();
                        this.a.c.b(c.a.DEVELOPER_CONNECTION_ACTIVE, false);
                        return;
                    case 18:
                        if (this.a.c.a(c.a.DEVELOPER_CONNECTION_ACTIVE, false)) {
                            f.d(e.a, "Received request to ping the developer connection proxy");
                            context = (Context) this.a.b.get();
                            if (context == null) {
                                f.b(e.a, "Null context");
                                return;
                            }
                            com.getpebble.android.framework.e.b.b(context, this.a.l, this.a.h, this.a.m);
                            if (this.a.o != null) {
                                this.a.o.c();
                                return;
                            }
                            return;
                        }
                        return;
                    case 19:
                        f.d(e.a, "Received request to install a file on Pebble");
                        bundle = message.getData();
                        if (bundle == null) {
                            f.b(e.a, "Null bundle");
                            return;
                        }
                        bundle.setClassLoader(PebbleDevice.class.getClassLoader());
                        pebbleDevice = (PebbleDevice) bundle.getParcelable("device_extra");
                        if (pebbleDevice == null) {
                            f.b(e.a, "Null device");
                            return;
                        }
                        uri = (Uri) bundle.getParcelable("uri_extra");
                        if (uri == null) {
                            f.b(e.a, "Null file uri");
                            return;
                        }
                        String string2 = bundle.getString("file_name_extra");
                        String string3 = bundle.getString("iso_locale_extra");
                        int i = bundle.getInt("language_version_extra");
                        if (((Context) this.a.b.get()) == null) {
                            f.d(e.a, "Failed to install file due to null context");
                            return;
                        }
                        bundle = new Bundle();
                        bundle.putParcelable(k.b.URI.toString(), uri);
                        bundle.putString(k.b.FILE_NAME.toString(), string2);
                        bundle.putString(k.b.ISO_LOCALE.toString(), string3);
                        bundle.putInt(k.b.LANGUAGE_VERSION.toString(), i);
                        if (!this.a.a(new k(com.getpebble.android.bluetooth.g.a.FILE_INSTALL_MANAGER, k.a.ADD_FILE, bundle), pebbleDevice)) {
                            this.a.l.a(q.a.ERROR_PRF.getValue(), uri);
                            return;
                        }
                        return;
                    case 20:
                        data = message.getData();
                        if (data == null) {
                            f.b(e.a, "Null bundle");
                            return;
                        } else {
                            com.getpebble.android.common.b.a.e.a(data.getBoolean("logcat_verbose_extra", false));
                            return;
                        }
                    case 21:
                        f.d(e.a, "Received request to do connection state processing");
                        this.a.e.b(true);
                        return;
                    case 22:
                        f.d(e.a, "Received request to fetch app info from uri");
                        data = message.getData();
                        if (data == null) {
                            f.b(e.a, "Null bundle");
                            return;
                        }
                        uri2 = (Uri) data.getParcelable("uri_extra");
                        if (uri2 == null) {
                            f.b(e.a, "Null uri");
                            return;
                        } else if (((Context) this.a.b.get()) == null) {
                            f.b(e.a, "Null context");
                            return;
                        } else {
                            com.getpebble.android.framework.install.a.b.a(uri2, com.getpebble.android.common.a.K().getContentResolver(), new com.getpebble.android.framework.install.a.b.a(this) {
                                final /* synthetic */ AnonymousClass4 a;

                                {
                                    this.a = r1;
                                }

                                public void a(boolean z) {
                                    this.a.a.l.d(z);
                                }
                            });
                            return;
                        }
                    case 23:
                        data = message.getData();
                        if (data == null) {
                            f.b(e.a, "Null bundle");
                            return;
                        }
                        String string4 = data.getString("app_uuid_extra");
                        data2 = new Bundle();
                        data2.putString(k.b.UUID.toString(), string4);
                        this.a.a(new k(com.getpebble.android.bluetooth.g.a.APP_RUN_STATE, k.a.START_APP, data2));
                        return;
                    case 24:
                        data = message.getData();
                        if (data == null) {
                            f.b(e.a, "Null bundle");
                            return;
                        }
                        UUID fromString = UUID.fromString(data.getString("app_uuid_extra"));
                        com.getpebble.android.framework.jskit.c.a(com.getpebble.android.common.a.K()).j(fromString);
                        am.a(fromString);
                        return;
                    case 25:
                        this.a.a(new k(com.getpebble.android.bluetooth.g.a.BLOBDB_V1, k.a.CLEAR_BLOB_DB));
                        return;
                    case 26:
                        this.a.a(new k(com.getpebble.android.bluetooth.g.a.APP_REORDER, k.a.SEND_APP_ORDER));
                        return;
                    case 27:
                        this.a.a(new k(com.getpebble.android.bluetooth.g.a.RESET, k.a.FORCE_CORE_DUMP));
                        return;
                    case 28:
                        this.a.a(new k(com.getpebble.android.bluetooth.g.a.RESET, k.a.RESET_INTO_PRF));
                        return;
                    case 29:
                        com.getpebble.android.framework.jskit.c.a(com.getpebble.android.common.a.K()).d(UUID.fromString(message.getData().getString("app_uuid_extra")), new Handler(Looper.getMainLooper()));
                        return;
                    case 30:
                        com.getpebble.android.framework.jskit.c.a(com.getpebble.android.common.a.K()).b(UUID.fromString(message.getData().getString("app_uuid_extra")), new Handler(Looper.getMainLooper()));
                        return;
                    case 31:
                        f.d(e.a, "Received request to do bluetooth device dump");
                        this.a.g.g();
                        return;
                    case 32:
                        f.d(e.a, "Received request to do health sync");
                        this.a.a(new k(com.getpebble.android.bluetooth.g.a.HEALTH_SYNC, k.a.SYNC_HEALTH));
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        };
    }

    void a(PebbleDevice pebbleDevice) {
        this.m.b(com.getpebble.android.framework.b.a.a(this.h, pebbleDevice), this.l);
    }

    private boolean a(k kVar, PebbleDevice pebbleDevice) {
        return com.getpebble.android.framework.b.a.a(this.h, pebbleDevice).a(kVar, this.l);
    }

    private boolean a(k kVar) {
        PebbleDevice n = PebbleApplication.n();
        if (n != null) {
            return a(kVar, n);
        }
        f.b(a, "Could not send request, connected device was null!");
        return false;
    }

    public FrameworkState a() {
        return this.l;
    }
}
