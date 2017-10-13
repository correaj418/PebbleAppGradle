package com.getpebble.android.common.b.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import com.getpebble.android.common.c.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class d {
    private static PrintWriter a;
    private static final SimpleDateFormat b = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    private static HandlerThread c = new HandlerThread("logging", 1);
    private static Handler d = new Handler(c.getLooper());
    private static File e;
    private static int f = 0;
    private static boolean g = false;
    private static String h;
    private static FileChannel i;
    private static FileLock j;
    private static File k;
    private static RandomAccessFile l;
    private static boolean m;
    private static boolean n;
    private static final String[] o = new String[]{"Pbl", "ScanRecord", "BluetoothLeScanner", "Adreno", "cr_LibraryLoader", "GoogleSignatureVerifier", "VideoCapabilities", "cr_BindingManager", "libEGL", "cr_Ime", "OpenGLRenderer", "SpannableStringBuilder", "ConnectivityManager", "ColorDrawable"};
    private static final String[] p = new String[]{"getDevicesMatchingConnectionStates", "getConnectedDevices", "getBluetoothService() called with no BluetoothManagerCallback"};

    private static class a implements Runnable {
        private a() {
        }

        public void run() {
            Process exec;
            BufferedReader bufferedReader;
            Throwable e;
            BufferedReader bufferedReader2 = null;
            StringBuilder stringBuilder = new StringBuilder();
            for (String append : d.o) {
                stringBuilder.append(append).append(":S ");
            }
            String str = "logcat -v threadtime -T 1 " + stringBuilder.toString();
            try {
                f.d("AndroidLogger", "LogcatReader: run: starting Logcat Reader: " + str);
                exec = Runtime.getRuntime().exec(str);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    while (true) {
                        try {
                            str = bufferedReader.readLine();
                            if (str == null) {
                                break;
                            }
                            final String str2 = str + "\n";
                            for (CharSequence contains : d.p) {
                                if (str2.contains(contains)) {
                                    break;
                                }
                            }
                            d.d.post(new Runnable(this) {
                                final /* synthetic */ a b;

                                public void run() {
                                    d.b(str2);
                                }
                            });
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader2 = bufferedReader;
                        } catch (Throwable th) {
                            e = th;
                        }
                    }
                    f.b("AndroidLogger", "LogcatReader: run: input ended");
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e3) {
                            f.d("AndroidLogger", "Error closing reader", e3);
                        }
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                } catch (IOException e4) {
                    e3 = e4;
                    try {
                        f.b("AndroidLogger", "LogcatReader: run: error reading logcat", e3);
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Throwable e32) {
                                f.d("AndroidLogger", "Error closing reader", e32);
                            }
                        }
                        if (exec != null) {
                            exec.destroy();
                        }
                    } catch (Throwable th2) {
                        e32 = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable e5) {
                                f.d("AndroidLogger", "Error closing reader", e5);
                            }
                        }
                        if (exec != null) {
                            exec.destroy();
                        }
                        throw e32;
                    }
                } catch (Throwable th3) {
                    e32 = th3;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                    throw e32;
                }
            } catch (IOException e6) {
                e32 = e6;
                exec = null;
                f.b("AndroidLogger", "LogcatReader: run: error reading logcat", e32);
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (exec != null) {
                    exec.destroy();
                }
            } catch (Throwable th4) {
                e32 = th4;
                exec = null;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (exec != null) {
                    exec.destroy();
                }
                throw e32;
            }
        }
    }

    static {
        c.start();
    }

    public static String a(Context context) {
        return context.getDir("logs", 0) + File.separator + "pebble" + ".debuglog";
    }

    private static String b(Context context, String str) {
        return context.getDir("logs", 0) + File.separator + "pebble_" + str + ".debuglog";
    }

    public static void a(final Context context, String str, final boolean z, boolean z2, boolean z3) {
        h = str;
        m = z2;
        n = z3;
        d.post(new Runnable() {
            public void run() {
                File file = new File(d.b(context, d.h));
                d.e = new File(d.a(context));
                d.k = new File(context.getDir("logs", 0) + File.separator + "log.sLock");
                d.g = z;
                d.j();
                d.d(file);
            }
        });
        if (m) {
            new Thread(new a(), "LogcatReader").start();
        }
    }

    public static void a(Runnable runnable) {
        d.post(runnable);
    }

    static int a() {
        return 3000000;
    }

    public static void a(boolean z) {
        g = z;
    }

    public static HandlerThread b() {
        return c;
    }

    private static void j() {
        f.d("AndroidLogger", "initLogFile: log file = " + e);
        if (a != null) {
            a.close();
        }
        try {
            a = new PrintWriter(new FileWriter(e, true));
        } catch (Throwable e) {
            a("initLogFile: Error opening log file", e);
            a(e);
        }
    }

    private static void d(File file) {
        if (file.exists()) {
            f.d("AndroidLogger", "deleteIfExists:" + file + (file.delete() ? " deleted" : " could not be deleted"));
        } else {
            f.d("AndroidLogger", "deleteIfExists: " + file + " does not exist");
        }
    }

    private static String a(a aVar) {
        switch (aVar) {
            case WARNING:
                return "W";
            case INFO:
                return "I";
            case DEBUG:
                return "D";
            case DEVELOPER:
                return "V";
            default:
                return "E";
        }
    }

    private static void b(a aVar, String str, String str2, Throwable th, Date date, int i, int i2) {
        String format = b.format(date);
        String str3 = "";
        if (th != null) {
            str3 = "\n" + Log.getStackTraceString(th);
        }
        str3 = str2 + str3;
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : str3.split("\n")) {
            stringBuilder.append(format).append(" ").append(i).append(" ").append(i2).append(" ").append(a(aVar)).append(" ").append(str).append(": ").append(append).append("\n");
        }
        b(stringBuilder.toString());
    }

    public static String a(Exception exception, int i) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        String[] split = stringWriter.toString().split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < Math.min(split.length, i); i2++) {
            stringBuilder.append(split[i2]).append("\n");
        }
        String stringBuilder2 = stringBuilder.toString();
        return (stringBuilder2.isEmpty() ? "" : "\n") + stringBuilder2;
    }

    private static void b(String str) {
        if (a == null) {
            c("logToFile: sPrintWriter is null; not logging message: " + str);
        } else if (c()) {
            try {
                a.print(str);
                a.flush();
                f++;
                k();
            } finally {
                d();
            }
        } else {
            c("logToFile: Could not acquire file lock; not logging message: " + str);
            a(new Throwable("could not acquire log file lock! message = " + str));
        }
    }

    private static void k() {
        if (f % 2000 == 0 && n && e.length() > ((long) a())) {
            l();
        }
    }

    private static void l() {
        f.d("AndroidLogger", "truncateFile()");
        a.close();
        File file = new File(e.getPath() + ".tmp");
        if (file.exists() && !file.delete()) {
            f.b("AndroidLogger", "truncateLogFile: error deleting tmp file (before)");
        } else if (e.renameTo(file)) {
            a(file, e, a());
            j();
        } else {
            f.b("AndroidLogger", "truncateLogFile: error renaming log file");
        }
    }

    static void a(File file, File file2, int i) {
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        Throwable e;
        InputStream inputStream = null;
        int length = ((int) file.length()) - i;
        if (length <= 0) {
            f.d("AndroidLogger", "truncateFile: not doing truncation; nothing to skip");
            return;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2, false);
                try {
                    if (fileInputStream.skip((long) length) != ((long) length)) {
                        f.c("AndroidLogger", "truncateFile: skipped != bytesToSkip");
                    }
                    do {
                        length = fileInputStream.read();
                        if (length == 10) {
                            break;
                        }
                    } while (length != -1);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e2) {
                            f.d("AndroidLogger", "Error closing in", e2);
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e22) {
                            f.d("AndroidLogger", "Error closing out", e22);
                        }
                    }
                } catch (IOException e3) {
                    e22 = e3;
                    inputStream = fileInputStream;
                    try {
                        f.d("AndroidLogger", "Error truncating file", e22);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e222) {
                                f.d("AndroidLogger", "Error closing in", e222);
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e2222) {
                                f.d("AndroidLogger", "Error closing out", e2222);
                            }
                        }
                        if (file.exists()) {
                        }
                        return;
                    } catch (Throwable th) {
                        e2222 = th;
                        fileInputStream = inputStream;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e4) {
                                f.d("AndroidLogger", "Error closing in", e4);
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e5) {
                                f.d("AndroidLogger", "Error closing out", e5);
                            }
                        }
                        throw e2222;
                    }
                } catch (Throwable th2) {
                    e2222 = th2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e2222;
                }
            } catch (IOException e6) {
                e2222 = e6;
                fileOutputStream = null;
                inputStream = fileInputStream;
                f.d("AndroidLogger", "Error truncating file", e2222);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (file.exists()) {
                    return;
                }
            } catch (Throwable th3) {
                e2222 = th3;
                fileOutputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e2222;
            }
        } catch (IOException e7) {
            e2222 = e7;
            fileOutputStream = null;
            f.d("AndroidLogger", "Error truncating file", e2222);
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (file.exists()) {
                return;
            }
        } catch (Throwable th4) {
            e2222 = th4;
            fileOutputStream = null;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e2222;
        }
        if (file.exists() && !file.delete()) {
            f.b("AndroidLogger", "truncate: error deleting tmp file (after)");
        }
    }

    public static void a(a aVar, String str, String str2, Throwable th) {
        if (str2 == null || str2.length() < 1) {
            str2 = "No message provided!";
        }
        final String str3 = "[" + str + "] " + str2;
        final Date date = new Date();
        switch (aVar) {
            case WARNING:
                Log.w("Pbl", str3, th);
                break;
            case INFO:
                if (g) {
                    Log.i("Pbl", str3, th);
                    break;
                }
                break;
            case DEBUG:
                if (g) {
                    Log.d("Pbl", str3, th);
                    break;
                }
                break;
            case DEVELOPER:
                if (g) {
                    Log.v("Pbl", str3, th);
                    break;
                }
                break;
            default:
                Log.e("Pbl", str3, th);
                break;
        }
        if (aVar != a.DEVELOPER) {
            final int myPid = Process.myPid();
            final int myTid = Process.myTid();
            final a aVar2 = aVar;
            final Throwable th2 = th;
            d.post(new Runnable() {
                public void run() {
                    d.b(aVar2, "Pbl", str3, th2, date, myPid, myTid);
                }
            });
        }
    }

    public static boolean c() {
        try {
            l = new RandomAccessFile(k, "rw");
            i = l.getChannel();
            j = i.lock();
            return true;
        } catch (Throwable e) {
            a("acquireLogFileLock", e);
            a(e);
            if (j != null) {
                try {
                    j.release();
                } catch (Throwable e2) {
                    a("acquireLogFileLock: error releasing sLock", e2);
                    a(e2);
                }
                j = null;
            }
            if (i != null) {
                try {
                    i.close();
                } catch (Throwable e22) {
                    a("acquireLogFileLock: error closing sLockChannel", e22);
                    a(e22);
                }
                i = null;
            }
            if (l != null) {
                try {
                    l.close();
                } catch (Throwable e222) {
                    a("acquireLogFileLock: error closing sLockRandomAccess", e222);
                    a(e222);
                }
                l = null;
            }
            return false;
        }
    }

    public static void d() {
        if (j == null) {
            c("releaseLogFileLock: no sLock held");
            return;
        }
        try {
            j.release();
        } catch (Throwable e) {
            a("releaseLogFileLock: error releasing sLock", e);
            a(e);
        }
        j = null;
        if (i != null) {
            try {
                i.close();
            } catch (Throwable e2) {
                a("releaseLogFileLock: error closing sLockChannel", e2);
                a(e2);
            }
            i = null;
        }
        if (l != null) {
            try {
                l.close();
            } catch (Throwable e22) {
                a("releaseLogFileLock: error closing sLockRandomAccess", e22);
                a(e22);
            }
            l = null;
        }
    }

    private static void a(Throwable th) {
        if (th != null) {
            String message = th.getMessage();
            if (message != null && message.contains("EMFILE")) {
                e.a(true, true);
            }
        }
    }

    private static void c(String str) {
        a(str, null);
    }

    private static void a(String str, Throwable th) {
        Log.e(str.contains("AndroidLogger") ? "Pbl" : "AndroidLogger", str, th);
    }
}
