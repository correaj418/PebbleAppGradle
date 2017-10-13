package com.getpebble.android.framework.g;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.Transport;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.framework.l.a.l;
import com.getpebble.android.framework.l.b.o;
import com.getpebble.android.framework.l.b.r;
import com.getpebble.android.framework.o.b;
import com.google.a.b.am;
import com.google.a.f.e;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class m extends ac {
    public static final String[] a = new String[]{"gap_bonding_db", "pmap", "pindb", "appdb", "reminderdb", "alarms", "wakeup", "notifstr", "notifpref", "shellpref", "dls_storage_173"};
    private static AtomicInteger f = new AtomicInteger(0);
    private static final long m = TimeUnit.MINUTES.toMillis(3);
    private Context b;
    private p c;
    private final boolean d;
    private FrameworkState e;
    private e g;
    private e h;
    private File i;
    private int j;
    private String k;
    private boolean l;
    private Handler n;
    private Runnable o;

    public enum a {
        SUCCESS(0),
        NO_CORE_DUMP(1),
        ERROR_INVALID_TRANSACTION_ID(-1),
        ERROR_INVALID_BYTE_OFFSET(-2),
        ERROR_FILE_WRITE_FAILED(-3),
        ERROR_MALFORMED_REQUEST(-4),
        ERROR_ALREADY_IN_PROGRESS(-5),
        ERROR_CORRUPT(-6),
        ERROR_PRF(-7),
        ERROR_TIMEOUT(-8),
        ERROR_UNKNOWN(-9),
        ERROR_INVALID(-10),
        ERROR_DISCONNECTED(-11),
        IN_PROGRESS(-12);
        
        private int mValue;

        private a(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }

        public static a fromValue(int i) {
            for (a aVar : values()) {
                if (aVar.getValue() == i) {
                    return aVar;
                }
            }
            return ERROR_UNKNOWN;
        }
    }

    public m(Context context, p pVar, boolean z) {
        this(context, pVar, a(context, pVar.e()), z);
    }

    public m(Context context, p pVar, b bVar, boolean z) {
        this.h = e.a(0);
        this.l = false;
        this.o = new Runnable(this) {
            final /* synthetic */ m a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.a(a.ERROR_TIMEOUT);
            }
        };
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        } else if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        } else {
            this.b = context;
            this.c = pVar;
            this.n = new Handler(Looper.getMainLooper());
            this.d = bVar.supportsUnreadCoreDump;
            f.d("GetBytesEndpoint", "GetBytesEndpoint: mSupportsUnreadCoreDump = " + this.d);
            boolean a = PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.DISABLE_AUTO_CORE_DUMP, false);
            if (!z && !a && this.d && f().e().getTransport().equals(Transport.LE)) {
                f.d("GetBytesEndpoint", ".. posting auto core dump request for " + m);
                this.n.postDelayed(new Runnable(this) {
                    final /* synthetic */ m a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        f.d("GetBytesEndpoint", "Fetching auto core dump after delay");
                        this.a.l = true;
                        Bundle bundle = new Bundle();
                        bundle.putString(k.b.FILE_NAME.toString(), "core-dump-unencrypted.bin");
                        this.a.a(new k(com.getpebble.android.bluetooth.g.a.GET_BYTES, com.getpebble.android.framework.g.k.a.REQUEST_GET_BYTES, bundle), null);
                    }
                }, m);
            }
        }
    }

    private static b a(Context context, PebbleDevice pebbleDevice) {
        com.getpebble.android.common.model.ak.a pebbleDeviceRecord = ak.getPebbleDeviceRecord(context.getContentResolver(), pebbleDevice);
        if (pebbleDeviceRecord != null) {
            return pebbleDeviceRecord.capabilities;
        }
        throw new IllegalStateException("connectedDevice cannot be null (for device " + pebbleDevice + ")");
    }

    private p f() {
        return this.c;
    }

    private void a(a aVar) {
        f.d("GetBytesEndpoint", "sendResult: Sending result: " + aVar);
        String str = null;
        if (this.i != null) {
            str = this.i.getAbsolutePath();
        }
        if (this.e != null) {
            this.e.a(aVar.getValue(), str, this.k);
        }
        if (!a.IN_PROGRESS.equals(aVar)) {
            h();
        }
    }

    private void h() {
        this.l = false;
        this.e = null;
        this.g = null;
        this.h = e.a(0);
    }

    public byte c() {
        f.incrementAndGet();
        return f.byteValue();
    }

    public byte d() {
        return f.byteValue();
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        this.e = frameworkState;
        this.k = kVar.b(k.b.FILE_NAME);
        k();
        a(a.IN_PROGRESS);
        return true;
    }

    private void i() {
        this.n.postDelayed(this.o, 5000);
    }

    private void j() {
        this.n.removeCallbacks(this.o);
    }

    private void k() {
        r l;
        File n = n();
        if (n.exists()) {
            if (n.delete()) {
                f.d("GetBytesEndpoint", "sendGetBytesRequest: Removed old get bytes file: " + this.k);
            } else {
                f.a("GetBytesEndpoint", "sendGetBytesRequest: Failed to remove old get bytes file: " + this.k);
            }
        }
        this.i = null;
        this.j = 0;
        f.d("GetBytesEndpoint", "sendGetBytesRequest: Starting get bytes: " + this.k);
        if ("core-dump-unencrypted.bin".equals(this.k)) {
            l = l();
        } else {
            l = o.a(c(), this.k);
        }
        i();
        f().a(l);
    }

    private o l() {
        if (this.d) {
            return o.b(c());
        }
        return o.a(c());
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return am.b(com.getpebble.android.bluetooth.g.a.GET_BYTES);
    }

    boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        j();
        l lVar = new l(bVar);
        if (lVar.d() != d()) {
            a(a.ERROR_INVALID_TRANSACTION_ID);
        } else {
            m();
            if (lVar.c().equals(l.b.IMAGE_INFO)) {
                a(lVar);
            } else {
                b(lVar);
            }
        }
        return true;
    }

    private void a(l lVar) {
        a a = a(lVar.e());
        if (a != null) {
            a(a);
            return;
        }
        this.g = lVar.f();
        i();
    }

    private a a(com.getpebble.android.framework.l.a.l.a aVar) {
        switch (aVar) {
            case MALFORMED_REQUEST:
                return a.ERROR_MALFORMED_REQUEST;
            case ALREADY_IN_PROGRESS:
                return a.ERROR_ALREADY_IN_PROGRESS;
            case IMAGE_DOES_NOT_EXIST:
                return a.NO_CORE_DUMP;
            case IMAGE_CORRUPT:
                return a.ERROR_CORRUPT;
            default:
                return null;
        }
    }

    private void m() {
        if (this.e != null) {
            int i = this.j;
            this.j = i + 1;
            if (i % 50 == 0) {
                this.e.q();
            }
        }
    }

    private void b(l lVar) {
        e g = lVar.g();
        if (this.g == null) {
            f.a("GetBytesEndpoint", "handleImageData: Failed because mNumBytes is null");
            a(a.ERROR_INVALID_BYTE_OFFSET);
        } else if (g.equals(this.h)) {
            a(lVar.h());
            lVar.h().position(0);
            this.h = this.h.a(e.a(lVar.h().remaining()));
            if (this.h.equals(this.g)) {
                f.d("GetBytesEndpoint", "handleImageData: Get bytes is complete");
                if (this.l && this.i != null) {
                    com.getpebble.android.main.sections.support.a.a(this.i.getAbsolutePath(), f().e(), this.b, false);
                }
                a(a.SUCCESS);
                return;
            }
            f.d("GetBytesEndpoint", "handleImageData: Still waiting for " + this.g.b(this.h) + " bytes.");
            i();
        } else {
            a(a.ERROR_INVALID_BYTE_OFFSET);
        }
    }

    private void a(ByteBuffer byteBuffer) {
        FileOutputStream fileOutputStream;
        Throwable e;
        try {
            fileOutputStream = new FileOutputStream(n(), true);
            try {
                fileOutputStream.write(byteBuffer.array(), 0, byteBuffer.remaining());
            } catch (Exception e2) {
                e = e2;
                f.a("GetBytesEndpoint", "writeDataToFile: Unhandled exception writing get bytes to file", e);
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Throwable e3) {
                        f.b("GetBytesEndpoint", "writeDataToFile: Exception thrown when closing file", e3);
                        return;
                    }
                }
            }
        } catch (Exception e4) {
            e3 = e4;
            fileOutputStream = null;
            f.a("GetBytesEndpoint", "writeDataToFile: Unhandled exception writing get bytes to file", e3);
            if (fileOutputStream == null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        if (fileOutputStream == null) {
            fileOutputStream.flush();
            fileOutputStream.close();
        }
    }

    private File n() {
        if (this.i == null) {
            this.i = com.getpebble.android.main.sections.support.b.getSupportFile(this.b, this.k);
        }
        return this.i;
    }

    void b() {
        j();
        this.n.removeCallbacksAndMessages(null);
        if (this.e != null) {
            a(a.ERROR_DISCONNECTED);
        }
    }

    public static boolean a(b bVar) {
        return bVar.supportsUnreadCoreDump;
    }

    public static boolean e() {
        return false;
    }
}
