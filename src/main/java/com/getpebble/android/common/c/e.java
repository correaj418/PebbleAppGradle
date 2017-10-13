package com.getpebble.android.common.c;

import android.util.Log;
import com.getpebble.android.common.b.a.f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class e {
    public static void a(boolean z, boolean z2) {
        InputStream inputStream;
        Reader inputStreamReader;
        Throwable e;
        InputStream inputStream2;
        Reader reader;
        Reader reader2;
        Reader reader3 = null;
        a(z2, "dumpOpenFiles()", null);
        Process exec;
        try {
            exec = Runtime.getRuntime().exec("lsof");
            try {
                inputStream = exec.getInputStream();
                try {
                    inputStreamReader = new InputStreamReader(inputStream);
                } catch (IOException e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    reader = null;
                    try {
                        a(z2, "dumpOpenFiles", e);
                        c.a.a.a.e.a(reader);
                        c.a.a.a.e.a(reader3);
                        c.a.a.a.e.a(inputStream2);
                        if (exec == null) {
                            exec.destroy();
                        }
                    } catch (Throwable th) {
                        e = th;
                        reader2 = reader;
                        inputStream = inputStream2;
                        inputStreamReader = reader3;
                        c.a.a.a.e.a(reader2);
                        c.a.a.a.e.a(inputStreamReader);
                        c.a.a.a.e.a(inputStream);
                        if (exec != null) {
                            exec.destroy();
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    inputStreamReader = null;
                    reader2 = null;
                    c.a.a.a.e.a(reader2);
                    c.a.a.a.e.a(inputStreamReader);
                    c.a.a.a.e.a(inputStream);
                    if (exec != null) {
                        exec.destroy();
                    }
                    throw e;
                }
                try {
                    reader2 = new BufferedReader(inputStreamReader);
                    int i = 0;
                    while (true) {
                        try {
                            String readLine = reader2.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.startsWith("COMMAND") || readLine.startsWith("com.getpe") || readLine.startsWith("asalt:fra") || readLine.startsWith("droid.bas")) {
                                if (z) {
                                    a(z2, "> " + readLine, null);
                                }
                                i++;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            reader3 = inputStreamReader;
                            inputStream2 = inputStream;
                            reader = reader2;
                        } catch (Throwable th3) {
                            e = th3;
                        }
                    }
                    a(z2, i + " open file descriptors", null);
                    c.a.a.a.e.a(reader2);
                    c.a.a.a.e.a(inputStreamReader);
                    c.a.a.a.e.a(inputStream);
                    if (exec != null) {
                        exec.destroy();
                    }
                } catch (IOException e4) {
                    e = e4;
                    Reader reader4 = inputStreamReader;
                    inputStream2 = inputStream;
                    reader = null;
                    reader3 = reader4;
                    a(z2, "dumpOpenFiles", e);
                    c.a.a.a.e.a(reader);
                    c.a.a.a.e.a(reader3);
                    c.a.a.a.e.a(inputStream2);
                    if (exec == null) {
                        exec.destroy();
                    }
                } catch (Throwable th4) {
                    e = th4;
                    reader2 = null;
                    c.a.a.a.e.a(reader2);
                    c.a.a.a.e.a(inputStreamReader);
                    c.a.a.a.e.a(inputStream);
                    if (exec != null) {
                        exec.destroy();
                    }
                    throw e;
                }
            } catch (IOException e5) {
                e = e5;
                inputStream2 = null;
                reader = null;
                a(z2, "dumpOpenFiles", e);
                c.a.a.a.e.a(reader);
                c.a.a.a.e.a(reader3);
                c.a.a.a.e.a(inputStream2);
                if (exec == null) {
                    exec.destroy();
                }
            } catch (Throwable th5) {
                e = th5;
                inputStreamReader = null;
                inputStream = null;
                reader2 = null;
                c.a.a.a.e.a(reader2);
                c.a.a.a.e.a(inputStreamReader);
                c.a.a.a.e.a(inputStream);
                if (exec != null) {
                    exec.destroy();
                }
                throw e;
            }
        } catch (IOException e6) {
            e = e6;
            exec = null;
            inputStream2 = null;
            reader = null;
            a(z2, "dumpOpenFiles", e);
            c.a.a.a.e.a(reader);
            c.a.a.a.e.a(reader3);
            c.a.a.a.e.a(inputStream2);
            if (exec == null) {
                exec.destroy();
            }
        } catch (Throwable th6) {
            e = th6;
            exec = null;
            inputStreamReader = null;
            inputStream = null;
            reader2 = null;
            c.a.a.a.e.a(reader2);
            c.a.a.a.e.a(inputStreamReader);
            c.a.a.a.e.a(inputStream);
            if (exec != null) {
                exec.destroy();
            }
            throw e;
        }
    }

    private static void a(boolean z, String str, Throwable th) {
        if (z) {
            Log.w("OpenFileUtil", str, th);
        } else {
            f.b("OpenFileUtil", str, th);
        }
    }
}
