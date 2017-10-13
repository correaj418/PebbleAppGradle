package com.getpebble.jskit.android.a;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class a {
    private static a a;
    private a b;

    public interface a {
        void a(int i, String str, String str2);
    }

    private a(a aVar) {
        this.b = aVar;
    }

    public static void a(a aVar) {
        a = new a(aVar);
    }

    public static void a(a aVar, int i, String str, Throwable th) {
        if (th != null) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.flush();
            str = str + " \n " + stringWriter.toString();
            printWriter.close();
            try {
                stringWriter.close();
            } catch (Throwable e) {
                a(6, "JsKit", "Could not close stringWriter ", e);
            }
        }
        aVar.a(i, "JsKit", str);
    }

    public static void a(int i, Throwable th, Object... objArr) {
        a aVar = null;
        if (a == null || a.b == null) {
            Log.v("JsKit", "logging directly to logcat");
        } else {
            aVar = a.b;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object append : objArr) {
            stringBuilder.append(append).append(" ");
        }
        String stringBuilder2 = stringBuilder.toString();
        if (aVar != null) {
            a(aVar, i, stringBuilder2, th);
        } else {
            a(i, "JsKit", stringBuilder2.toString(), th);
        }
    }

    public static void a(int i, String str, String str2, Throwable th) {
        switch (i) {
            case 2:
                Log.v("JsKit", str2, th);
                return;
            case 3:
                Log.d("JsKit", str2, th);
                return;
            case 4:
                Log.i("JsKit", str2, th);
                return;
            case 5:
                Log.w("JsKit", str2, th);
                return;
            case 6:
                if (th != null) {
                    th.printStackTrace();
                }
                Log.e("JsKit", str2, th);
                return;
            default:
                Log.d("JsKit", str2, th);
                return;
        }
    }
}
