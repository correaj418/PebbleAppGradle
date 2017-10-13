package net.hockeyapp.android.d;

import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

public abstract class c<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    protected static String a(HttpURLConnection httpURLConnection) {
        InputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        String a = a(bufferedInputStream);
        bufferedInputStream.close();
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.io.InputStream r4) {
        /*
        r0 = new java.io.BufferedReader;
        r1 = new java.io.InputStreamReader;
        r1.<init>(r4);
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0.<init>(r1, r2);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
    L_0x0011:
        r2 = r0.readLine();	 Catch:{ IOException -> 0x002e }
        if (r2 == 0) goto L_0x003a;
    L_0x0017:
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x002e }
        r3.<init>();	 Catch:{ IOException -> 0x002e }
        r2 = r3.append(r2);	 Catch:{ IOException -> 0x002e }
        r3 = "\n";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x002e }
        r2 = r2.toString();	 Catch:{ IOException -> 0x002e }
        r1.append(r2);	 Catch:{ IOException -> 0x002e }
        goto L_0x0011;
    L_0x002e:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0048 }
        r4.close();	 Catch:{ IOException -> 0x0043 }
    L_0x0035:
        r0 = r1.toString();
        return r0;
    L_0x003a:
        r4.close();	 Catch:{ IOException -> 0x003e }
        goto L_0x0035;
    L_0x003e:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0035;
    L_0x0043:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0035;
    L_0x0048:
        r0 = move-exception;
        r4.close();	 Catch:{ IOException -> 0x004d }
    L_0x004c:
        throw r0;
    L_0x004d:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.d.c.a(java.io.InputStream):java.lang.String");
    }
}
