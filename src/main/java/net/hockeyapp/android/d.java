package net.hockeyapp.android;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Date;
import java.util.UUID;

public class d implements UncaughtExceptionHandler {
    private boolean a = false;
    private c b;
    private UncaughtExceptionHandler c;

    public d(UncaughtExceptionHandler uncaughtExceptionHandler, c cVar, boolean z) {
        this.c = uncaughtExceptionHandler;
        this.a = z;
        this.b = cVar;
    }

    public void a(c cVar) {
        this.b = cVar;
    }

    @Deprecated
    public static void a(Throwable th, c cVar) {
        a(th, null, cVar);
    }

    public static void a(Throwable th, Thread thread, c cVar) {
        BufferedWriter bufferedWriter;
        Throwable e;
        Date date = new Date();
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        try {
            String uuid = UUID.randomUUID().toString();
            String str = a.a + "/" + uuid + ".stacktrace";
            Log.d("HockeyApp", "Writing unhandled exception to: " + str);
            bufferedWriter = new BufferedWriter(new FileWriter(str));
            try {
                bufferedWriter.write("Package: " + a.d + "\n");
                bufferedWriter.write("Version Code: " + a.b + "\n");
                bufferedWriter.write("Version Name: " + a.c + "\n");
                if (cVar == null || cVar.d()) {
                    bufferedWriter.write("Android: " + a.e + "\n");
                    bufferedWriter.write("Manufacturer: " + a.g + "\n");
                    bufferedWriter.write("Model: " + a.f + "\n");
                }
                if (thread != null && (cVar == null || cVar.g())) {
                    bufferedWriter.write("Thread: " + thread.getName() + "-" + thread.getId() + "\n");
                }
                if (a.h != null && (cVar == null || cVar.f())) {
                    bufferedWriter.write("CrashReporter Key: " + a.h + "\n");
                }
                bufferedWriter.write("Date: " + date + "\n");
                bufferedWriter.write("\n");
                bufferedWriter.write(stringWriter.toString());
                bufferedWriter.flush();
                if (cVar != null) {
                    a(a(cVar.b()), uuid + ".user");
                    a(a(cVar.h()), uuid + ".contact");
                    a(cVar.c(), uuid + ".description");
                }
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (Throwable e2) {
                        Log.e("HockeyApp", "Error saving exception stacktrace!\n", e2);
                        e2.printStackTrace();
                    }
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    Log.e("HockeyApp", "Error saving exception stacktrace!\n", e2);
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Throwable e22) {
                            Log.e("HockeyApp", "Error saving exception stacktrace!\n", e22);
                            e22.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    e22 = th2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Throwable e4) {
                            Log.e("HockeyApp", "Error saving exception stacktrace!\n", e4);
                            e4.printStackTrace();
                        }
                    }
                    throw e22;
                }
            }
        } catch (IOException e5) {
            e22 = e5;
            bufferedWriter = null;
            Log.e("HockeyApp", "Error saving exception stacktrace!\n", e22);
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (Throwable th3) {
            e22 = th3;
            bufferedWriter = null;
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            throw e22;
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (a.a == null) {
            this.c.uncaughtException(thread, th);
            return;
        }
        a(th, thread, this.b);
        if (this.a) {
            Process.killProcess(Process.myPid());
            System.exit(10);
            return;
        }
        this.c.uncaughtException(thread, th);
    }

    private static void a(String str, String str2) {
        BufferedWriter bufferedWriter;
        Throwable th;
        if (!TextUtils.isEmpty(str)) {
            BufferedWriter bufferedWriter2 = null;
            try {
                String str3 = a.a + "/" + str2;
                if (str.trim().length() > 0) {
                    bufferedWriter = new BufferedWriter(new FileWriter(str3));
                    try {
                        bufferedWriter.write(str);
                        bufferedWriter.flush();
                    } catch (IOException e) {
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        bufferedWriter2 = bufferedWriter;
                        th = th3;
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.close();
                        }
                        throw th;
                    }
                }
                bufferedWriter = null;
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e2) {
                bufferedWriter = null;
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (Throwable th4) {
                th = th4;
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
                throw th;
            }
        }
    }

    private static String a(String str) {
        if (str == null || str.length() <= 255) {
            return str;
        }
        return str.substring(0, 255);
    }
}
