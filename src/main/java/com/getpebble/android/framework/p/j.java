package com.getpebble.android.framework.p;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import c.a.a.a.e;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.a;
import com.getpebble.android.d.c;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;

public abstract class j implements e {
    private static final d a = new d();
    private final g b;
    private HttpsURLConnection c;
    private DataOutputStream d;
    private boolean e = false;
    private Handler f = null;
    private Handler g = null;
    private HandlerThread h = null;
    private long i = 0;
    private long j = 0;
    private long k = 0;
    private int l = 0;
    private int m = 0;
    private boolean n = false;
    private int o = -1;
    private final String p = g.j();
    private String q = "";
    private String r = "";
    private short s;

    protected abstract void a(int i, short s, String str);

    protected abstract void a(short s);

    public j(g gVar, short s) {
        this.b = gVar;
        this.s = s;
    }

    public void a(Handler handler) {
        synchronized (this) {
            if (this.g != null) {
                f.b("StreamingMultiPartHttpClient", "Last connection may not have been cleaned up");
                t();
            }
            p();
            this.f = handler;
        }
        Handler handler2 = this.g;
        if (handler2 != null) {
            handler2.post(new Runnable(this) {
                final /* synthetic */ j a;

                {
                    this.a = r1;
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                    r7 = this;
                    r6 = 1;
                    r0 = "StreamingMultiPartHttpClient";
                    r1 = "executing start runnable";
                    com.getpebble.android.common.b.a.f.d(r0, r1);
                    r0 = r7.a;	 Catch:{ IOException -> 0x00a5 }
                    r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ IOException -> 0x00a5 }
                    r0.j = r2;	 Catch:{ IOException -> 0x00a5 }
                    r0 = com.getpebble.android.framework.p.j.a;	 Catch:{ IOException -> 0x00a5 }
                    r1 = r7.a;	 Catch:{ IOException -> 0x00a5 }
                    r1 = r1.b;	 Catch:{ IOException -> 0x00a5 }
                    r1 = r1.c();	 Catch:{ IOException -> 0x00a5 }
                    r0 = r0.a(r1);	 Catch:{ IOException -> 0x00a5 }
                    r1 = "StreamingMultiPartHttpClient";
                    r2 = "Acquiring lock to assign connection";
                    com.getpebble.android.common.b.a.f.d(r1, r2);	 Catch:{ IOException -> 0x00a5 }
                    r1 = r7.a;	 Catch:{ IOException -> 0x00a5 }
                    monitor-enter(r1);	 Catch:{ IOException -> 0x00a5 }
                    r2 = r7.a;	 Catch:{ all -> 0x00b3 }
                    r2 = r2.e;	 Catch:{ all -> 0x00b3 }
                    if (r2 == 0) goto L_0x0046;
                L_0x0035:
                    r2 = "StreamingMultiPartHttpClient";
                    r3 = "Opened a connection immediately after receiving cancel signal. Disconnecting.";
                    com.getpebble.android.common.b.a.f.b(r2, r3);	 Catch:{ all -> 0x00b3 }
                    r0.disconnect();	 Catch:{ all -> 0x00b3 }
                    r0 = r7.a;	 Catch:{ all -> 0x00b3 }
                    r0.t();	 Catch:{ all -> 0x00b3 }
                    monitor-exit(r1);	 Catch:{ all -> 0x00b3 }
                L_0x0045:
                    return;
                L_0x0046:
                    r2 = r7.a;	 Catch:{ all -> 0x00b3 }
                    r2.c = r0;	 Catch:{ all -> 0x00b3 }
                    monitor-exit(r1);	 Catch:{ all -> 0x00b3 }
                    r1 = "StreamingMultiPartHttpClient";
                    r2 = "Released lock";
                    com.getpebble.android.common.b.a.f.d(r1, r2);	 Catch:{ IOException -> 0x00a5 }
                    r1 = 1;
                    r0.setDoOutput(r1);	 Catch:{ IOException -> 0x00a5 }
                    r1 = 1;
                    r0.setDoInput(r1);	 Catch:{ IOException -> 0x00a5 }
                    r1 = 0;
                    r0.setUseCaches(r1);	 Catch:{ IOException -> 0x00a5 }
                    r1 = "POST";
                    r0.setRequestMethod(r1);	 Catch:{ IOException -> 0x00a5 }
                    r1 = "Connection";
                    r2 = "Keep-Alive";
                    r0.setRequestProperty(r1, r2);	 Catch:{ IOException -> 0x00a5 }
                    r1 = "Content-Type";
                    r2 = "multipart/form-data; boundary=*****";
                    r0.setRequestProperty(r1, r2);	 Catch:{ IOException -> 0x00a5 }
                    r1 = 0;
                    r0.setChunkedStreamingMode(r1);	 Catch:{ IOException -> 0x00a5 }
                    r1 = "StreamingMultiPartHttpClient";
                    r2 = "Acquiring lock to assign output stream";
                    com.getpebble.android.common.b.a.f.d(r1, r2);	 Catch:{ IOException -> 0x00a5 }
                    r1 = new java.io.DataOutputStream;	 Catch:{ IOException -> 0x00a5 }
                    r0 = r0.getOutputStream();	 Catch:{ IOException -> 0x00a5 }
                    r1.<init>(r0);	 Catch:{ IOException -> 0x00a5 }
                    r2 = r7.a;	 Catch:{ IOException -> 0x00a5 }
                    monitor-enter(r2);	 Catch:{ IOException -> 0x00a5 }
                    r0 = r7.a;	 Catch:{ all -> 0x00a2 }
                    r0 = r0.e;	 Catch:{ all -> 0x00a2 }
                    if (r0 == 0) goto L_0x00b6;
                L_0x0091:
                    r0 = "StreamingMultiPartHttpClient";
                    r3 = "Opened data output stream immediately after receiving cancel signal. Tearing down connection.";
                    com.getpebble.android.common.b.a.f.b(r0, r3);	 Catch:{ all -> 0x00a2 }
                    r1.close();	 Catch:{ all -> 0x00a2 }
                    r0 = r7.a;	 Catch:{ all -> 0x00a2 }
                    r0.t();	 Catch:{ all -> 0x00a2 }
                    monitor-exit(r2);	 Catch:{ all -> 0x00a2 }
                    goto L_0x0045;
                L_0x00a2:
                    r0 = move-exception;
                    monitor-exit(r2);	 Catch:{ all -> 0x00a2 }
                    throw r0;	 Catch:{ IOException -> 0x00a5 }
                L_0x00a5:
                    r0 = move-exception;
                    r1 = "StreamingMultiPartHttpClient";
                    r2 = "start: Exception throw when connecting to ASR";
                    com.getpebble.android.common.b.a.f.d(r1, r2, r0);
                    r0 = r7.a;
                    r0.s();
                    goto L_0x0045;
                L_0x00b3:
                    r0 = move-exception;
                    monitor-exit(r1);	 Catch:{ all -> 0x00b3 }
                    throw r0;	 Catch:{ IOException -> 0x00a5 }
                L_0x00b6:
                    r0 = r7.a;	 Catch:{ all -> 0x00a2 }
                    r0.d = r1;	 Catch:{ all -> 0x00a2 }
                    monitor-exit(r2);	 Catch:{ all -> 0x00a2 }
                    r0 = "StreamingMultiPartHttpClient";
                    r2 = "Released lock";
                    com.getpebble.android.common.b.a.f.d(r0, r2);	 Catch:{ IOException -> 0x00a5 }
                    r0 = r7.a;	 Catch:{ IOException -> 0x00a5 }
                    r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ IOException -> 0x00a5 }
                    r0.k = r2;	 Catch:{ IOException -> 0x00a5 }
                    r0 = r7.a;	 Catch:{ IOException -> 0x00a5 }
                    r0 = r0.b;	 Catch:{ IOException -> 0x00a5 }
                    r0 = r0.b();	 Catch:{ IOException -> 0x00a5 }
                    r0 = com.getpebble.android.h.p.a(r0);	 Catch:{ IOException -> 0x00a5 }
                    r2 = r7.a;	 Catch:{ IOException -> 0x00a5 }
                    r2 = r2.b;	 Catch:{ IOException -> 0x00a5 }
                    r2 = r2.a();	 Catch:{ IOException -> 0x00a5 }
                    r2 = com.getpebble.android.h.p.a(r2);	 Catch:{ IOException -> 0x00a5 }
                    r3 = "StreamingMultiPartHttpClient";
                    r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00a5 }
                    r4.<init>();	 Catch:{ IOException -> 0x00a5 }
                    r5 = "start: configuring stream with config: ";
                    r4 = r4.append(r5);	 Catch:{ IOException -> 0x00a5 }
                    r5 = r7.a;	 Catch:{ IOException -> 0x00a5 }
                    r5 = r5.b;	 Catch:{ IOException -> 0x00a5 }
                    r5 = r5.toString();	 Catch:{ IOException -> 0x00a5 }
                    r4 = r4.append(r5);	 Catch:{ IOException -> 0x00a5 }
                    r4 = r4.toString();	 Catch:{ IOException -> 0x00a5 }
                    com.getpebble.android.common.b.a.f.d(r3, r4);	 Catch:{ IOException -> 0x00a5 }
                    r3 = "RequestData";
                    r4 = 0;
                    com.getpebble.android.framework.p.j.b(r1, r3, r4, r0);	 Catch:{ IOException -> 0x00a5 }
                    r0 = "DictParameter";
                    r3 = "REQUEST_INFO";
                    com.getpebble.android.framework.p.j.b(r1, r0, r3, r2);	 Catch:{ IOException -> 0x00a5 }
                    r0 = r7.a;
                    r0.n = r6;
                    goto L_0x0045;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.framework.p.j.1.run():void");
                }
            });
        }
    }

    public void a(final byte[] bArr) {
        Handler handler = this.g;
        if (handler == null) {
            f.a("StreamingMultiPartHttpClient", "Cannot post write message; handler is null");
        } else {
            handler.post(new Runnable(this) {
                final /* synthetic */ j b;

                public void run() {
                    DataOutputStream e = this.b.d;
                    if (e == null) {
                        f.a("StreamingMultiPartHttpClient", "Write failed, outputstream is null");
                        this.b.s();
                        return;
                    }
                    try {
                        j.b(e, this.b.b.d(), bArr);
                        e.flush();
                        this.b.l = this.b.l + bArr.length;
                    } catch (Throwable e2) {
                        f.a("StreamingMultiPartHttpClient", "Unable to write buffer to stream", e2);
                        this.b.s();
                    }
                }
            });
        }
    }

    public void b(final short s) {
        f.d("StreamingMultiPartHttpClient", "stop()");
        if (this.i <= 0) {
            this.i = SystemClock.elapsedRealtime();
        }
        Handler handler = this.g;
        if (handler == null) {
            f.a("StreamingMultiPartHttpClient", "Cannot post stop message; handler is null");
        } else {
            handler.post(new Runnable(this) {
                final /* synthetic */ j b;

                public void run() {
                    f.d("StreamingMultiPartHttpClient", "Running stop callback");
                    DataOutputStream e = this.b.d;
                    if (e == null) {
                        f.d("StreamingMultiPartHttpClient", "Output stream is null, cannot stop gracefully");
                        this.b.s();
                        return;
                    }
                    try {
                        f.d("StreamingMultiPartHttpClient", "Writing closing boundary.");
                        e.writeBytes("--*****--\r\n");
                        e.flush();
                        HttpURLConnection g = this.b.c;
                        if (g == null) {
                            f.a("StreamingMultiPartHttpClient", "Connection is null");
                            return;
                        }
                        InputStream inputStream;
                        int responseCode = g.getResponseCode();
                        this.b.q = c.a(g.getHeaderFields(), "Nuance-SessionId");
                        f.d("StreamingMultiPartHttpClient", "stop: Received session ID: <" + this.b.q + ">");
                        this.b.r = c.a(g.getHeaderFields(), "Nuance-Context");
                        f.d("StreamingMultiPartHttpClient", "stop: Received nuance context: <" + this.b.r + ">");
                        this.b.o = responseCode;
                        String responseMessage = g.getResponseMessage();
                        if ((responseCode == 200 ? 1 : null) != null) {
                            f.d("StreamingMultiPartHttpClient", "Success");
                            inputStream = g.getInputStream();
                        } else {
                            f.a("StreamingMultiPartHttpClient", "Error");
                            inputStream = g.getErrorStream();
                        }
                        if (inputStream == null) {
                            f.a("StreamingMultiPartHttpClient", "Failed to get stream; code=" + responseCode);
                            e.a(inputStream);
                            this.b.t();
                            return;
                        }
                        this.b.a(responseCode, responseMessage, s, e.b(inputStream));
                        e.a(inputStream);
                        this.b.t();
                    } catch (Throwable e2) {
                        f.a("StreamingMultiPartHttpClient", "Stop failed with exception", e2);
                        this.b.s();
                    } finally {
                        e.a(null);
                        this.b.t();
                    }
                }
            });
        }
    }

    private void a(final int i, String str, final short s, final String str2) {
        f.d("StreamingMultiPartHttpClient", "handleResponse: Server response code: " + i + " status: " + str + " for session ID: " + s);
        f.d("StreamingMultiPartHttpClient", "Raw response: " + a.a((Object) str2));
        if (!TextUtils.isEmpty(str2)) {
            this.m += str2.getBytes().length;
        }
        this.f.post(new Runnable(this) {
            final /* synthetic */ j d;

            public void run() {
                this.d.a(i, s, str2);
            }
        });
    }

    private static void b(DataOutputStream dataOutputStream, int i, byte[] bArr) {
        a(dataOutputStream, "ConcludingAudioParameter", "AUDIO_INFO", "audio/x-wav;codec=pcm;bit=16;rate=" + i, bArr);
    }

    private static void b(DataOutputStream dataOutputStream, String str, String str2, String str3) {
        a(dataOutputStream, str, str2, "application/json; charset=utf-8", str3.getBytes());
    }

    private static void a(DataOutputStream dataOutputStream, String str, String str2, String str3, byte[] bArr) {
        dataOutputStream.writeBytes("--*****\r\n");
        dataOutputStream.writeBytes("Content-Disposition: form-data; name=" + str + (TextUtils.isEmpty(str2) ? "" : "; paramName=" + str2));
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("Content-Type: " + str3);
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("Content-Transfer-Encoding: 8bit");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.write(bArr);
        dataOutputStream.writeBytes("\r\n");
    }

    private void s() {
        f.d("StreamingMultiPartHttpClient", "sendErrorAndCleanup");
        if (this.i <= 0) {
            this.i = SystemClock.elapsedRealtime();
        }
        Handler handler = this.f;
        if (handler == null) {
            f.b("StreamingMultiPartHttpClient", "Result handler is null; already cleaned up.");
        } else if (this.e) {
            f.d("StreamingMultiPartHttpClient", "Received cancel signal; not sending error");
        } else {
            f.d("StreamingMultiPartHttpClient", "Sending error");
            handler.post(new Runnable(this) {
                final /* synthetic */ j a;

                {
                    this.a = r1;
                }

                public void run() {
                    if (this.a.e) {
                        f.d("StreamingMultiPartHttpClient", "Not executing callback; client was cancelled");
                    } else {
                        this.a.a(this.a.s);
                    }
                }
            });
            f.d("StreamingMultiPartHttpClient", "Calling cleanup");
            t();
        }
    }

    private synchronized void t() {
        f.d("StreamingMultiPartHttpClient", "cleanup()");
        HttpURLConnection httpURLConnection = this.c;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.c = null;
        }
        DataOutputStream dataOutputStream = this.d;
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (Throwable e) {
                f.d("StreamingMultiPartHttpClient", "Exception when closing outputStream", e);
            }
            this.d = null;
        }
        q();
        f.d("StreamingMultiPartHttpClient", "cleanup complete");
    }

    public synchronized void o() {
        f.d("StreamingMultiPartHttpClient", "cancel()");
        this.e = true;
        if (this.i <= 0) {
            this.i = SystemClock.elapsedRealtime();
        }
        new com.getpebble.android.bluetooth.b.f(this) {
            final /* synthetic */ j a;

            {
                this.a = r1;
            }

            public boolean doInBackground() {
                this.a.t();
                return false;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.execute(new Void[0]);
    }

    void p() {
        f.d("StreamingMultiPartHttpClient", "setupBackgroundHandler()");
        this.h = new HandlerThread("nuance-connection");
        this.h.start();
        this.g = new Handler(this.h.getLooper());
    }

    void q() {
        f.d("StreamingMultiPartHttpClient", "teardownBackgroundHandler()");
        if (this.g != null) {
            this.g.removeCallbacksAndMessages(null);
            this.g = null;
        }
        this.f = null;
        if (this.h != null) {
            this.h.quit();
            this.h = null;
        }
    }

    public int a() {
        return this.l;
    }

    public long b() {
        if (this.k == 0) {
            return 0;
        }
        return Math.max(this.i - this.k, 0);
    }

    public long c() {
        if (this.j == 0) {
            return 0;
        }
        return Math.max(this.k - this.j, 0);
    }

    public int d() {
        return this.m;
    }

    public boolean e() {
        return this.n;
    }

    public String f() {
        return this.b.e();
    }

    public UUID g() {
        return this.b.f();
    }

    public boolean h() {
        return this.b.g();
    }

    public String i() {
        return this.b.h();
    }

    public int j() {
        return this.o;
    }

    public String k() {
        return this.p;
    }

    public String l() {
        return this.q;
    }

    public String m() {
        return this.r;
    }

    public String n() {
        return g.i();
    }
}
