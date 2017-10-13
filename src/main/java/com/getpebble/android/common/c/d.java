package com.getpebble.android.common.c;

import com.getpebble.android.common.b.a.f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d {
    public static String a() {
        BufferedReader bufferedReader;
        Throwable e;
        Throwable th;
        String str = "";
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -v threadtime -d -t 250").getInputStream()));
            try {
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine);
                    stringBuilder.append(System.getProperty("line.separator"));
                }
                str = stringBuilder.toString();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e2) {
                        f.b("LogcatUtil", "Error closing buffered reader", e2);
                    }
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    f.b("LogcatUtil", "Failed to get logs from logcat", e2);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e22) {
                            f.b("LogcatUtil", "Error closing buffered reader", e22);
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e222) {
                            f.b("LogcatUtil", "Error closing buffered reader", e222);
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e222 = e4;
            bufferedReader = null;
            f.b("LogcatUtil", "Failed to get logs from logcat", e222);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        return str;
    }
}
