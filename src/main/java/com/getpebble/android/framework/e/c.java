package com.getpebble.android.framework.e;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.h.g;
import com.getpebble.android.bluetooth.h.h;
import com.getpebble.android.bluetooth.h.i;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.g.p;
import com.getpebble.android.framework.jskit.e;
import com.getpebble.android.framework.l.b.l;
import com.getpebble.android.framework.l.b.r;
import com.getpebble.android.framework.timeline.j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.UUID;

public class c implements g, i, p, com.getpebble.android.framework.jskit.b {
    private static Handler d;
    private WeakReference<e> a;
    private WeakReference<Context> b;
    private h c;
    private final com.getpebble.android.framework.install.firmware.c e;

    public enum a {
        SUCCESS((byte) 0),
        FAILED((byte) 1);
        
        private byte mCode;

        private a(byte b) {
            this.mCode = b;
        }

        public byte getCode() {
            return this.mCode;
        }

        public static a fromCode(byte b) {
            for (a aVar : values()) {
                if (aVar.getCode() == b) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public enum b {
        INSERT_PIN((byte) 1),
        DELETE_PIN((byte) 2);
        
        private byte mCode;

        private b(byte b) {
            this.mCode = b;
        }

        public byte getCode() {
            return this.mCode;
        }

        public static b fromCode(byte b) {
            for (b bVar : values()) {
                if (bVar.getCode() == b) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public enum c {
        PEBBLE_PROTOCOL_WATCH_TO_PHONE((byte) 0),
        PEBBLE_PROTOCOL_PHONE_TO_WATCH((byte) 1),
        PHONE_APP_LOG((byte) 2),
        PHONE_SERVER_LOG((byte) 3),
        APP_INSTALL((byte) 4),
        STATUS_CODE((byte) 5),
        PHONE_INFO((byte) 6),
        CONNECTION_STATUS((byte) 7),
        PROXY_CONNECTION_STATUS((byte) 8),
        TIMELINE_PIN_ACTION((byte) 12);
        
        private byte mCode;

        private c(byte b) {
            this.mCode = b;
        }

        public byte getCode() {
            return this.mCode;
        }

        public static c fromCode(byte b) {
            for (c cVar : values()) {
                if (cVar.getCode() == b) {
                    return cVar;
                }
            }
            return null;
        }
    }

    public enum d {
        SUCCESS(0),
        INSTALL_FAILED(1);
        
        private int mCode;

        private d(int i) {
            this.mCode = i;
        }

        public int getCode() {
            return this.mCode;
        }

        public static d fromCode(byte b) {
            for (d dVar : values()) {
                if (dVar.getCode() == b) {
                    return dVar;
                }
            }
            return null;
        }
    }

    static synchronized Handler a() {
        Handler handler;
        synchronized (c.class) {
            if (d == null) {
                f.d("DeveloperConnectionManager", "getHandler: starting developer connection thread..");
                HandlerThread handlerThread = new HandlerThread("developerconnection", 1);
                handlerThread.start();
                d = new Handler(handlerThread.getLooper());
            }
            handler = d;
        }
        return handler;
    }

    public c(Context context, e eVar, h hVar, com.getpebble.android.framework.install.firmware.c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        } else if (eVar == null) {
            throw new IllegalArgumentException("'connection' cannot be null!");
        } else if (hVar == null) {
            throw new IllegalArgumentException("'deviceMessageSender' cannot be null");
        } else {
            this.b = new WeakReference(context);
            this.a = new WeakReference(eVar);
            this.e = cVar;
            this.c = hVar;
            this.c.a((g) this);
            this.c.a((i) this);
            e.a().a((com.getpebble.android.framework.jskit.b) this);
        }
    }

    public Context b() {
        if (this.b != null) {
            return (Context) this.b.get();
        }
        return null;
    }

    public e c() {
        if (this.a != null) {
            return (e) this.a.get();
        }
        return null;
    }

    public h d() {
        return this.c;
    }

    public void a(ByteBuffer byteBuffer, FrameworkState frameworkState) {
        if (byteBuffer.remaining() < 1) {
            f.a("DeveloperConnectionManager", "received websocket message shorter than a header");
            return;
        }
        byte b = byteBuffer.get();
        c fromCode = c.fromCode(b);
        if (fromCode == null) {
            f.b("DeveloperConnectionManager", "unknown command: " + b);
            return;
        }
        f.d("DeveloperConnectionManager", "Got command: " + fromCode.name());
        switch (fromCode) {
            case PEBBLE_PROTOCOL_PHONE_TO_WATCH:
                a(byteBuffer);
                return;
            case APP_INSTALL:
                com.getpebble.android.common.b.a.a.e.a();
                b(byteBuffer, frameworkState);
                return;
            case PHONE_INFO:
                c(byteBuffer);
                return;
            case TIMELINE_PIN_ACTION:
                b(byteBuffer);
                return;
            default:
                f.a("DeveloperConnectionManager", "Unknown web socket command code: " + b);
                return;
        }
    }

    private void a(ByteBuffer byteBuffer) {
        short s = byteBuffer.getShort();
        short s2 = byteBuffer.getShort();
        f.d("DeveloperConnectionManager", "Sending protocol message to endpoint: " + com.getpebble.android.bluetooth.g.a.fromCode(s2));
        if (byteBuffer.remaining() != s) {
            f.a("DeveloperConnectionManager", "Protocol message is invalid length.");
        } else {
            a(new l(s2, byteBuffer));
        }
    }

    private void b(ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        b fromCode = b.fromCode(b);
        j jVar = new j(com.getpebble.android.common.a.K());
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr, 0, bArr.length);
        switch (fromCode) {
            case INSERT_PIN:
                try {
                    jVar.a((com.getpebble.android.common.model.timeline.c) new com.google.b.g().a(com.getpebble.android.common.model.timeline.c.a.class, new com.getpebble.android.common.model.timeline.c.a()).c().a(new String(bArr, "UTF-8"), com.getpebble.android.common.model.timeline.c.class));
                    break;
                } catch (Throwable e) {
                    f.a("DeveloperConnectionManager", "Error in handleTimelinePinAction inserting pin", e);
                    a(a.FAILED);
                    return;
                }
            case DELETE_PIN:
                try {
                    String str = new String(bArr, "UTF-8");
                    com.getpebble.android.common.model.timeline.d dVar = new com.getpebble.android.common.model.timeline.d();
                    dVar.a = str;
                    jVar.a(dVar);
                    break;
                } catch (Throwable e2) {
                    f.a("DeveloperConnectionManager", "Error in handleTimelinePinAction deleting pin", e2);
                    a(a.FAILED);
                    return;
                }
            default:
                f.a("DeveloperConnectionManager", "Unknown timeline pin action command code: " + b);
                a(a.FAILED);
                return;
        }
        a(a.SUCCESS);
    }

    private void a(a aVar) {
        e c = c();
        if (c == null) {
            f.d("DeveloperConnectionManager", "sendStatusCode: connection is null");
            return;
        }
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.put(aVar.getCode());
        f.d("DeveloperConnectionManager", "Sending message = " + allocate.get());
        c.a(allocate);
    }

    private void b(ByteBuffer byteBuffer, FrameworkState frameworkState) {
        Throwable e;
        f.d("DeveloperConnectionManager", "Installing app");
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        FileOutputStream fileOutputStream;
        try {
            final File createTempFile = File.createTempFile("websocket-install", ".pbw");
            fileOutputStream = new FileOutputStream(createTempFile);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                com.getpebble.android.framework.install.a.b.a(Uri.fromFile(createTempFile), com.getpebble.android.common.a.K().getContentResolver(), new com.getpebble.android.framework.install.a.b.a(this) {
                    final /* synthetic */ c b;

                    public void a(boolean z) {
                        if (z) {
                            this.b.a(d.SUCCESS);
                        } else {
                            f.d("DeveloperConnectionManager", "AppInstallResult was not success");
                            this.b.a(d.INSTALL_FAILED);
                        }
                        createTempFile.delete();
                    }
                });
            } catch (IOException e2) {
                e = e2;
                f.a("DeveloperConnectionManager", "unable to install app via websockets", e);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e3) {
                        f.a("DeveloperConnectionManager", "Unable to close output stream", e3);
                    }
                }
                a(d.INSTALL_FAILED);
            }
        } catch (IOException e4) {
            e3 = e4;
            fileOutputStream = null;
            f.a("DeveloperConnectionManager", "unable to install app via websockets", e3);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            a(d.INSTALL_FAILED);
        }
    }

    private void a(d dVar) {
        e c = c();
        if (c == null) {
            f.d("DeveloperConnectionManager", "sendStatusCode: connection is null");
            return;
        }
        ByteBuffer allocate = ByteBuffer.allocate(5);
        allocate.put(c.STATUS_CODE.getCode());
        allocate.putInt(dVar.getCode());
        allocate.flip();
        f.d("DeveloperConnectionManager", "Sending status code:  " + dVar);
        c.a(allocate);
    }

    private void c(ByteBuffer byteBuffer) {
        if (byteBuffer.get() != (byte) 0) {
            f.a("DeveloperConnectionManager", "invalid protocol byte received in phone info request");
            return;
        }
        String str = "Android," + VERSION.RELEASE + "," + Build.MODEL;
        byte[] bytes = str.getBytes();
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 1);
        allocate.put(c.PHONE_INFO.getCode());
        allocate.put(bytes);
        allocate.flip();
        f.d("DeveloperConnectionManager", "Sending phone info string: " + str);
        e c = c();
        if (c != null) {
            c.a(allocate);
        }
    }

    public void a(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.g.b bVar) {
        a(pebbleDevice, bVar, c.PEBBLE_PROTOCOL_WATCH_TO_PHONE);
    }

    public void b(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.g.b bVar) {
        a(pebbleDevice, bVar, c.PEBBLE_PROTOCOL_PHONE_TO_WATCH);
    }

    private void a(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.g.b bVar, c cVar) {
        if (pebbleDevice.equals(e())) {
            ByteBuffer b = bVar.b();
            ByteBuffer allocate = ByteBuffer.allocate(b.remaining() + 5);
            allocate.put(cVar.getCode());
            allocate.putShort((short) bVar.c());
            allocate.putShort(bVar.a());
            allocate.put(b);
            allocate.flip();
            e c = c();
            if (c != null) {
                c.a(allocate);
            }
        }
    }

    public void a(String str) {
        e c = c();
        if (c != null) {
            byte[] bytes = str.getBytes();
            ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 1);
            allocate.put(c.PHONE_APP_LOG.getCode());
            allocate.put(bytes);
            allocate.flip();
            c.a(allocate);
        }
    }

    public void a(PebbleDevice pebbleDevice) {
        f.d("DeveloperConnectionManager", "Message sent to " + pebbleDevice.getName() + " from manager instance: " + toString());
    }

    public void b(PebbleDevice pebbleDevice) {
        f.a("DeveloperConnectionManager", "Failed to send message to: " + pebbleDevice.getName());
    }

    public boolean a(r rVar) {
        com.getpebble.android.bluetooth.g.b a = com.getpebble.android.bluetooth.g.b.a(ByteBuffer.wrap(rVar.c_()));
        PebbleDevice e = e();
        if (e == null) {
            f.c("DeveloperConnectionManager", "device is null; not sending message");
            return false;
        }
        ByteBuffer b = a.b();
        if (com.getpebble.android.bluetooth.g.a.fromCode(a.a()).equals(com.getpebble.android.bluetooth.g.a.BLOBDB_V1) && com.getpebble.android.bluetooth.b.b.a(b).byteValue() == com.getpebble.android.framework.l.b.j.a.DELETE.toByte()) {
            f.d("DeveloperConnectionManager", "Treating as deleteFromCloudAndWatch");
            com.getpebble.android.bluetooth.b.b.b(b);
            com.getpebble.android.bluetooth.b.b.a(b);
            com.getpebble.android.bluetooth.b.b.a(b);
            UUID f = com.getpebble.android.bluetooth.b.b.f(b);
            Context b2 = b();
            if (b2 != null) {
                return com.getpebble.android.common.model.am.c.a(b2, f);
            }
            f.b("DeveloperConnectionManager", "Context is null, not attempting app remove");
            return false;
        } else if (com.getpebble.android.framework.b.b.b(a)) {
            return d().a(e, a);
        } else {
            return false;
        }
    }

    public PebbleDevice e() {
        return PebbleApplication.n();
    }

    public void a(com.getpebble.android.bluetooth.e.a.e eVar) {
    }

    public void f() {
        f.d("DeveloperConnectionManager", "deInit()");
        e.a().a(null);
        this.c.b((g) this);
        this.c.b((i) this);
        e.a().a(null);
    }
}
