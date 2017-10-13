package com.getpebble.android.framework.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.l.a.n;
import com.getpebble.android.framework.l.b.q;
import com.google.a.b.am;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;

public class s extends ac {
    private final Context a;
    private final p b;
    private final Handler c;
    private final Runnable d = new Runnable(this) {
        final /* synthetic */ s a;

        {
            this.a = r1;
        }

        public void run() {
            f.b("LogDumpEndpoint", "Timeout!");
            synchronized (this.a) {
                this.a.m();
            }
        }
    };
    private b e;
    private File f;
    private FrameworkState g;
    private AtomicInteger h;
    private byte[] i;
    private StringBuilder j;
    private int k;

    public enum a {
        SUCCESS(1),
        ERROR_UNKNOWN(0),
        ERROR_FILE_WRITE_FAILED(-1),
        ERROR_SEND_FAILURE(-2),
        ERROR_INVALID_MESSAGE(-3),
        ERROR_ALREADY_IN_PROGRESS(-4),
        ERROR_PRF(-5),
        ERROR_TIMEOUT(-6);
        
        private final int mValue;

        private a(int i) {
            this.mValue = i;
        }

        public static a fromValue(int i) {
            for (a aVar : values()) {
                if (aVar.getValue() == i) {
                    return aVar;
                }
            }
            return ERROR_UNKNOWN;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    private enum b {
        INIT,
        FETCHING
    }

    public s(Context context, p pVar) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        } else if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        } else {
            this.a = context;
            this.b = pVar;
            this.c = new Handler(Looper.getMainLooper());
            this.e = b.INIT;
        }
    }

    private boolean e() {
        com.getpebble.android.common.model.ak.a c = c();
        if (c == null || c.capabilities == null) {
            return false;
        }
        return c.capabilities.supportsInfiniteLogDump;
    }

    protected com.getpebble.android.common.model.ak.a c() {
        return PebbleApplication.r();
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        if (!b(kVar)) {
            return false;
        }
        this.g = frameworkState;
        d();
        return true;
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return am.b(com.getpebble.android.bluetooth.g.a.LOG_DUMP);
    }

    boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        synchronized (this) {
            if (bVar == null) {
                f.a("LogDumpEndpoint", "onReceive: Got null protocol message");
                a(a.ERROR_INVALID_MESSAGE);
                i();
                return false;
            } else if (!a().contains(com.getpebble.android.bluetooth.g.a.fromCode(bVar.a()))) {
                f.b("LogDumpEndpoint", "onReceive: Unsupported endpoint: " + bVar.a());
                return false;
            } else if (this.i == null) {
                f.a("LogDumpEndpoint", "onReceive: Received log dump message but no cookie was set");
                i();
                return true;
            } else {
                try {
                    n nVar = new n(bVar);
                    if (Arrays.equals(this.i, nVar.d())) {
                        switch (nVar.c()) {
                            case DONE:
                                f.d("LogDumpEndpoint", "onReceive: Completed generation, cancelling timeout");
                                k();
                                boolean n = n();
                                return n;
                            case LOG:
                                this.j.append(nVar.e().a()).append("\n");
                                l();
                                k();
                                j();
                                return true;
                            case NO_LOGS:
                                f.d("LogDumpEndpoint", "onReceive: No logs for generation; terminating log dump");
                                k();
                                m();
                                return true;
                            case STATS_DUMP_DONE:
                                f.b("LogDumpEndpoint", "onReceive: Ignoring 'stats dump done' message");
                                return true;
                            default:
                                f.a("LogDumpEndpoint", "onReceive: Received unknown response type: " + nVar.c());
                                a(a.ERROR_INVALID_MESSAGE);
                                i();
                                return true;
                        }
                    }
                    f.a("LogDumpEndpoint", String.format("onReceive: Expected cookie <%s> got <%s>; dropping message", new Object[]{com.getpebble.android.bluetooth.b.a.a(this.i, this.i.length), com.getpebble.android.bluetooth.b.a.a(nVar.d(), nVar.d().length)}));
                    a(a.ERROR_INVALID_MESSAGE);
                    i();
                    return true;
                } catch (Throwable e) {
                    f.b("LogDumpEndpoint", "onReceive: Failed to handle log message", e);
                    a(a.ERROR_INVALID_MESSAGE);
                    i();
                    return true;
                }
            }
        }
    }

    void b() {
    }

    public boolean d() {
        boolean z = false;
        if (this.e != b.INIT) {
            f.b("LogDumpEndpoint", "startLogDump: Log dump busy; current state: " + this.e);
            a(a.ERROR_ALREADY_IN_PROGRESS);
        } else {
            f.d("LogDumpEndpoint", "startLogDump: Starting log dump..");
            synchronized (this) {
                this.e = b.FETCHING;
                this.k = 0;
                File f = f();
                if (f.exists()) {
                    if (f.delete()) {
                        f.d("LogDumpEndpoint", "startLogDump: Removed old log dump file");
                    } else {
                        f.a("LogDumpEndpoint", "startLogDump: Old log dump file exists, but could not be removed");
                    }
                }
                this.f = null;
                this.j = new StringBuilder();
                this.h = new AtomicInteger(0);
                z = n();
            }
        }
        return z;
    }

    private File f() {
        if (this.f == null) {
            this.f = com.getpebble.android.main.sections.support.b.getSupportFile(this.a, "device-logs.log.gz");
        }
        return this.f;
    }

    private p h() {
        return this.b;
    }

    private void i() {
        f.d("LogDumpEndpoint", "cleanup: Cleaning up");
        k();
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        synchronized (this) {
            this.e = b.INIT;
        }
    }

    private void j() {
        this.c.postDelayed(this.d, 3000);
    }

    private void k() {
        this.c.removeCallbacks(this.d);
    }

    private void a(a aVar) {
        f.d("LogDumpEndpoint", "sendResult: Sending result: " + aVar);
        String str = null;
        if (this.f != null) {
            str = this.f.getAbsolutePath();
        }
        this.g.a(aVar.getValue(), str);
    }

    private void l() {
        int i = this.k;
        this.k = i + 1;
        if (i % 250 == 0) {
            this.g.q();
        }
    }

    private void m() {
        PrintStream printStream;
        Throwable e;
        int i;
        f.d("LogDumpEndpoint", "finish: Writing logs to file; count = " + this.k);
        Object obj = null;
        try {
            printStream = new PrintStream(new GZIPOutputStream(new FileOutputStream(f(), true)));
            try {
                printStream.println("# Device logs:");
                printStream.print(this.j.toString());
                if (printStream != null) {
                    printStream.flush();
                    printStream.close();
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    f.a("LogDumpEndpoint", "finish: Uncaught exception writing logs to file", e);
                    if (printStream == null) {
                        printStream.flush();
                        printStream.close();
                        i = 1;
                    } else {
                        i = 1;
                    }
                    if (obj == null) {
                    }
                    a(a.ERROR_FILE_WRITE_FAILED);
                    i();
                } catch (Throwable th) {
                    e = th;
                    if (printStream != null) {
                        printStream.flush();
                        printStream.close();
                    }
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            printStream = null;
            f.a("LogDumpEndpoint", "finish: Uncaught exception writing logs to file", e);
            if (printStream == null) {
                i = 1;
            } else {
                printStream.flush();
                printStream.close();
                i = 1;
            }
            if (obj == null) {
            }
            a(a.ERROR_FILE_WRITE_FAILED);
            i();
        } catch (Throwable th2) {
            e = th2;
            printStream = null;
            if (printStream != null) {
                printStream.flush();
                printStream.close();
            }
            throw e;
        }
        if (obj == null || r1.checkError()) {
            a(a.ERROR_FILE_WRITE_FAILED);
        } else {
            a(a.SUCCESS);
        }
        i();
    }

    private boolean n() {
        if (this.e != b.FETCHING) {
            f.a("LogDumpEndpoint", "fetchNextGen: Not properly initialized");
            a(a.ERROR_ALREADY_IN_PROGRESS);
            i();
            return false;
        }
        boolean e = e();
        f.d("LogDumpEndpoint", "fetchNextGen: Is infinite log dump supported? " + e);
        if (e || this.h.get() != 4) {
            byte byteValue = this.h.byteValue();
            this.j.append("=== Generation: ").append(this.h.get()).append(" ===").append("\n");
            this.h.incrementAndGet();
            byte[] a = com.getpebble.android.bluetooth.b.b.a();
            if (h().a(new q(byteValue, a))) {
                f.d("LogDumpEndpoint", "fetchNextGen: Log dump sent successfully for generation: " + byteValue);
                j();
                this.i = a;
                return true;
            }
            f.a("LogDumpEndpoint", "fetchNextGen: Failed to send log dump for generation: " + byteValue);
            a(a.ERROR_SEND_FAILURE);
            i();
            return false;
        }
        f.d("LogDumpEndpoint", "fetchNextGen: Done fetching logs");
        m();
        return false;
    }
}
