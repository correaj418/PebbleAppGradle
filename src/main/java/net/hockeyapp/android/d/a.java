package net.hockeyapp.android.d;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.hockeyapp.android.c.e;

public class a {
    private Queue<b> a;
    private boolean b;

    private static class a {
        public static final a a = new a();
    }

    private static class b {
        private final e a;
        private final net.hockeyapp.android.views.a b;
        private boolean c;
        private int d;

        private b(e eVar, net.hockeyapp.android.views.a aVar) {
            this.a = eVar;
            this.b = aVar;
            this.c = false;
            this.d = 2;
        }

        public e a() {
            return this.a;
        }

        public net.hockeyapp.android.views.a b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        public void a(boolean z) {
            this.c = z;
        }

        public boolean d() {
            return this.d > 0;
        }

        public boolean e() {
            int i = this.d - 1;
            this.d = i;
            return i >= 0;
        }
    }

    private static class c extends AsyncTask<Void, Integer, Boolean> {
        private final b a;
        private final Handler b;
        private File c = net.hockeyapp.android.a.a();
        private Bitmap d = null;
        private int e = 0;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            a((Boolean) obj);
        }

        protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
            a((Integer[]) objArr);
        }

        public c(b bVar, Handler handler) {
            this.a = bVar;
            this.b = handler;
        }

        protected void onPreExecute() {
        }

        protected Boolean a(Void... voidArr) {
            e a = this.a.a();
            if (a.d()) {
                Log.e("HockeyApp", "Cached...");
                a();
                return Boolean.valueOf(true);
            }
            Log.e("HockeyApp", "Downloading...");
            boolean a2 = a(a.b(), a.c());
            if (a2) {
                a();
            }
            return Boolean.valueOf(a2);
        }

        protected void a(Integer... numArr) {
        }

        protected void a(Boolean bool) {
            net.hockeyapp.android.views.a b = this.a.b();
            this.a.a(bool.booleanValue());
            if (bool.booleanValue()) {
                b.a(this.d, this.e);
            } else if (!this.a.d()) {
                b.b();
            }
            this.b.sendEmptyMessage(0);
        }

        private void a() {
            try {
                String c = this.a.a().c();
                net.hockeyapp.android.views.a b = this.a.b();
                this.e = net.hockeyapp.android.e.e.a(new File(this.c, c));
                this.d = net.hockeyapp.android.e.e.a(new File(this.c, c), this.e == 1 ? b.getWidthLandscape() : b.getWidthPortrait(), this.e == 1 ? b.getMaxHeightLandscape() : b.getMaxHeightPortrait());
            } catch (IOException e) {
                e.printStackTrace();
                this.d = null;
            }
        }

        private boolean a(String str, String str2) {
            try {
                URLConnection a = a(new URL(str));
                a.connect();
                int contentLength = a.getContentLength();
                String headerField = a.getHeaderField("Status");
                if (headerField != null && !headerField.startsWith("200")) {
                    return false;
                }
                File file = new File(this.c, str2);
                InputStream bufferedInputStream = new BufferedInputStream(a.getInputStream());
                OutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                long j = 0;
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    j += (long) read;
                    publishProgress(new Integer[]{Integer.valueOf((int) ((100 * j) / ((long) contentLength)))});
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                bufferedInputStream.close();
                return j > 0;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        private URLConnection a(URL url) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.addRequestProperty("User-Agent", "HockeySDK/Android");
            httpURLConnection.setInstanceFollowRedirects(true);
            if (VERSION.SDK_INT <= 9) {
                httpURLConnection.setRequestProperty("connection", "close");
            }
            return httpURLConnection;
        }
    }

    public static a a() {
        return a.a;
    }

    private a() {
        this.a = new LinkedList();
        this.b = false;
    }

    public void a(e eVar, net.hockeyapp.android.views.a aVar) {
        this.a.add(new b(eVar, aVar));
        b();
    }

    private void b() {
        if (!this.b) {
            b bVar = (b) this.a.peek();
            if (bVar != null) {
                AsyncTask cVar = new c(bVar, new Handler(this) {
                    final /* synthetic */ a a;

                    {
                        this.a = r1;
                    }

                    public void handleMessage(Message message) {
                        final b bVar = (b) this.a.a.poll();
                        if (!bVar.c() && bVar.e()) {
                            postDelayed(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 b;

                                public void run() {
                                    this.b.a.a.add(bVar);
                                    this.b.a.b();
                                }
                            }, 3000);
                        }
                        this.a.b = false;
                        this.a.b();
                    }
                });
                this.b = true;
                net.hockeyapp.android.e.a.a(cVar);
            }
        }
    }
}
