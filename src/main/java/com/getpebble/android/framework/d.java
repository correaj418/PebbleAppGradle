package com.getpebble.android.framework;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.Transport;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.d.a;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

public class d {
    private final LinkedBlockingQueue<Message> a = new LinkedBlockingQueue(20);
    private Context b = null;
    private Messenger c = null;
    private b d = null;
    private boolean e = false;
    private boolean f = false;
    private final Handler g = new Handler(Looper.getMainLooper());
    private final Runnable h;
    private final a i;
    private final ServiceConnection j = new ServiceConnection(this) {
        final /* synthetic */ d a;

        {
            this.a = r1;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder == null) {
                f.a("PebbleFrameworkInterface", "service binder was null - not binding to framework");
                return;
            }
            f.d("PebbleFrameworkInterface", "onServiceConnected pre");
            synchronized (this.a) {
                this.a.c = new Messenger(iBinder);
                this.a.e = true;
                this.a.f = false;
                this.a.g.removeCallbacks(this.a.h);
                this.a.k();
                if (this.a.a.size() > 0) {
                    for (int i = 0; i < this.a.a.size(); i++) {
                        Message message = (Message) this.a.a.poll();
                        f.d("PebbleFrameworkInterface", "De-queueing message: " + message.what);
                        this.a.a(message);
                    }
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            f.d("PebbleFrameworkInterface", "onServiceDisconnected pre");
            synchronized (this.a) {
                this.a.c = null;
                this.a.e = false;
                this.a.f = false;
                this.a.g.removeCallbacks(this.a.h);
            }
        }
    };

    public d(Context context, a aVar) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        f.d("PebbleFrameworkInterface", "Creating FrameworkEventReceiver");
        this.b = context;
        this.i = aVar;
        if (a.UI.equals(this.i)) {
            this.d = new b();
        }
        this.h = new Runnable(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            public void run() {
                f.c("PebbleFrameworkInterface", "Timed out binding: Unbind");
                synchronized (this.a) {
                    this.a.f = false;
                    this.a.b();
                }
            }
        };
    }

    public synchronized void a() {
        if (!(this.e || this.f)) {
            f.c("PebbleFrameworkInterface", "bindService (not bound)");
            this.f = true;
            this.g.postDelayed(this.h, 1500);
            try {
                this.b.bindService(new Intent(this.b, PebbleFrameworkService.class), this.j, 1);
            } catch (Throwable e) {
                f.a("PebbleFrameworkInterface", "Error binding to framework service", e);
            }
        }
    }

    public synchronized void b() {
        if (this.e && !this.f) {
            f.c("PebbleFrameworkInterface", "unBindService (bound)");
            try {
                this.b.unbindService(this.j);
            } catch (Throwable e) {
                f.c("PebbleFrameworkInterface", "Error unbinding service", e);
            }
        }
    }

    public boolean a(PebbleDevice pebbleDevice) {
        if (pebbleDevice == null) {
            throw new IllegalArgumentException("'device' cannot be null!");
        }
        Message obtain = Message.obtain(null, 1, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putParcelable("device_extra", pebbleDevice);
        obtain.setData(bundle);
        return a(obtain);
    }

    public boolean b(PebbleDevice pebbleDevice) {
        if (pebbleDevice == null) {
            throw new IllegalArgumentException("'device' cannot be null!");
        }
        Message obtain = Message.obtain(null, 2, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putParcelable("device_extra", pebbleDevice);
        obtain.setData(bundle);
        return a(obtain);
    }

    public boolean a(Transport transport) {
        Message obtain = Message.obtain(null, 4, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putInt("discovery_transport_extra", transport.mCode);
        obtain.setData(bundle);
        return a(obtain);
    }

    public boolean c() {
        return a(5);
    }

    public boolean a(com.getpebble.android.framework.i.a.a aVar) {
        Message obtain = Message.obtain(null, 6, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putSerializable("notification_type_extra", aVar);
        obtain.setData(bundle);
        return a(obtain);
    }

    public boolean a(PebbleDevice pebbleDevice, Uri uri) {
        if (pebbleDevice == null) {
            throw new IllegalArgumentException("'device' cannot be null!");
        } else if (uri == null) {
            throw new IllegalArgumentException("'firmwareUri' cannot be null!");
        } else {
            Message obtain = Message.obtain(null, 7, 0, 0);
            Bundle bundle = new Bundle();
            bundle.putParcelable("device_extra", pebbleDevice);
            bundle.putParcelable("firmware_uri_extra", uri);
            obtain.setData(bundle);
            return a(obtain);
        }
    }

    public boolean c(PebbleDevice pebbleDevice) {
        if (pebbleDevice == null) {
            throw new IllegalArgumentException("'device' cannot be null!");
        }
        Message obtain = Message.obtain(null, 8, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putParcelable("device_extra", pebbleDevice);
        obtain.setData(bundle);
        return a(obtain);
    }

    public boolean a(PebbleDevice pebbleDevice, Uri uri, String str) {
        return a(pebbleDevice, uri, str, null, 0);
    }

    public boolean a(PebbleDevice pebbleDevice, Uri uri, String str, String str2, int i) {
        if (pebbleDevice == null) {
            throw new IllegalArgumentException("'device' cannot be null");
        } else if (uri == null) {
            throw new IllegalArgumentException("'fileuri' cannot be null");
        } else {
            Message obtain = Message.obtain(null, 19, 0, 0);
            Bundle bundle = new Bundle();
            bundle.putParcelable("device_extra", pebbleDevice);
            bundle.putParcelable("uri_extra", uri);
            bundle.putString("file_name_extra", str);
            bundle.putString("iso_locale_extra", str2);
            bundle.putInt("language_version_extra", i);
            obtain.setData(bundle);
            f.d("PebbleFrameworkInterface", "Sending file install message for: " + pebbleDevice);
            return a(obtain);
        }
    }

    public boolean a(Uri uri) {
        if (uri == null) {
            throw new IllegalArgumentException("'appUri' cannot be null");
        }
        Message obtain = Message.obtain(null, 22, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putParcelable("uri_extra", uri);
        obtain.setData(bundle);
        f.d("PebbleFrameworkInterface", "Sending app sideload message for: " + uri);
        return a(obtain);
    }

    public boolean b(Uri uri) {
        Message obtain = Message.obtain(null, 9, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putParcelable("uri_extra", uri);
        obtain.setData(bundle);
        return a(obtain);
    }

    public boolean a(PebbleDevice pebbleDevice, String str) {
        Message obtain = Message.obtain(null, 10, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putParcelable("device_extra", pebbleDevice);
        bundle.putString("file_name_extra", str);
        obtain.setData(bundle);
        f.d("PebbleFrameworkInterface", "sending get bytes request for " + pebbleDevice + ": " + str);
        return a(obtain);
    }

    public boolean d(PebbleDevice pebbleDevice) {
        if (!this.e) {
            return false;
        }
        Message obtain = Message.obtain(null, 11, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putParcelable("device_extra", pebbleDevice);
        obtain.setData(bundle);
        f.d("PebbleFrameworkInterface", "sending log dump request for " + pebbleDevice);
        return a(obtain);
    }

    public boolean d() {
        f.d("PebbleFrameworkInterface", "Sending REQUEST_START_DEVELOPER_CONN");
        return a(12);
    }

    public boolean e() {
        f.d("PebbleFrameworkInterface", "Sending REQUEST_STOP_DEVELOPER_CONN");
        return a(13);
    }

    public boolean f() {
        return a(18);
    }

    public boolean a(boolean z) {
        Message obtain = Message.obtain(null, 20, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putBoolean("logcat_verbose_extra", z);
        obtain.setData(bundle);
        return a(obtain);
    }

    public boolean g() {
        return a(21);
    }

    public boolean a(UUID uuid) {
        Message obtain = Message.obtain(null, 23, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putString("app_uuid_extra", uuid.toString());
        obtain.setData(bundle);
        return a(obtain);
    }

    public boolean b(UUID uuid) {
        Message obtain = Message.obtain(null, 29, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putString("app_uuid_extra", uuid.toString());
        obtain.setData(bundle);
        return a(obtain);
    }

    public boolean c(UUID uuid) {
        Message obtain = Message.obtain(null, 24, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putString("app_uuid_extra", uuid.toString());
        obtain.setData(bundle);
        return a(obtain);
    }

    public boolean d(UUID uuid) {
        Message obtain = Message.obtain(null, 30, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putString("app_uuid_extra", uuid.toString());
        obtain.setData(bundle);
        return a(obtain);
    }

    public boolean h() {
        return a(31);
    }

    public boolean i() {
        return a(26);
    }

    public boolean j() {
        return a(32);
    }

    private boolean k() {
        f.d("PebbleFrameworkInterface", "setReplyMessenger()");
        if (a.UI.equals(this.i)) {
            Message obtain = Message.obtain(null, 3, 0, 0);
            obtain.replyTo = this.d.a();
            return a(obtain);
        }
        f.d("PebbleFrameworkInterface", "Not setting reply messenger; not UI process");
        return false;
    }

    private synchronized boolean a(Message message) {
        boolean z;
        a();
        if (message == null) {
            throw new IllegalArgumentException("'msg' cannot be null!");
        }
        try {
            if (this.c != null) {
                this.c.send(message);
                z = true;
            }
        } catch (Throwable e) {
            f.c("PebbleFrameworkInterface", "Failed to send message.", e);
            this.e = false;
        }
        f.d("PebbleFrameworkInterface", "Queueing message: " + message.what);
        if (this.a.remainingCapacity() == 0) {
            f.d("PebbleFrameworkInterface", ".. queue full; removing " + ((Message) this.a.poll()).what);
        }
        this.a.offer(message);
        b();
        a();
        z = false;
        return z;
    }

    private boolean a(int i) {
        return a(Message.obtain(null, i, 0, 0));
    }
}
