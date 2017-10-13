package net.hockeyapp.android.d;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import net.hockeyapp.android.b.a;

public class d extends AsyncTask<Void, Integer, Long> {
    protected Context a;
    protected a b;
    protected String c;
    protected String d = (UUID.randomUUID() + ".apk");
    protected String e = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download");
    protected ProgressDialog f;
    private String g;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Long) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        a((Integer[]) objArr);
    }

    public d(Context context, String str, a aVar) {
        this.a = context;
        this.c = str;
        this.b = aVar;
        this.g = null;
    }

    public void a(Context context) {
        this.a = context;
    }

    public void a() {
        this.a = null;
        this.f = null;
    }

    protected Long a(Void... voidArr) {
        InputStream bufferedInputStream;
        IOException e;
        Throwable th;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        OutputStream outputStream2 = null;
        Long valueOf;
        try {
            URLConnection a = a(new URL(b()), 6);
            a.connect();
            int contentLength = a.getContentLength();
            String contentType = a.getContentType();
            if (contentType == null || !contentType.contains("text")) {
                File file = new File(this.e);
                if (file.mkdirs() || file.exists()) {
                    OutputStream fileOutputStream;
                    File file2 = new File(file, this.d);
                    bufferedInputStream = new BufferedInputStream(a.getInputStream());
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (IOException e2) {
                        e = e2;
                        inputStream = bufferedInputStream;
                        try {
                            e.printStackTrace();
                            valueOf = Long.valueOf(0);
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return valueOf;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedInputStream = inputStream;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e32) {
                                    e32.printStackTrace();
                                    throw th;
                                }
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        long j = 0;
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            j += (long) read;
                            publishProgress(new Integer[]{Integer.valueOf(Math.round((((float) j) * 100.0f) / ((float) contentLength)))});
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        valueOf = Long.valueOf(j);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e322) {
                                e322.printStackTrace();
                            }
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (IOException e4) {
                        e = e4;
                        outputStream = fileOutputStream;
                        inputStream = bufferedInputStream;
                        e.printStackTrace();
                        valueOf = Long.valueOf(0);
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return valueOf;
                    } catch (Throwable th4) {
                        th = th4;
                        outputStream = fileOutputStream;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        throw th;
                    }
                    return valueOf;
                }
                throw new IOException("Could not create the dir(s):" + file.getAbsolutePath());
            }
            this.g = "The requested download does not appear to be a file.";
            valueOf = Long.valueOf(0);
            if (null != null) {
                try {
                    outputStream2.close();
                } catch (IOException e3222) {
                    e3222.printStackTrace();
                }
            }
            if (null != null) {
                inputStream.close();
            }
            return valueOf;
        } catch (IOException e5) {
            e = e5;
            inputStream = null;
            e.printStackTrace();
            valueOf = Long.valueOf(0);
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return valueOf;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    protected void a(HttpURLConnection httpURLConnection) {
        httpURLConnection.addRequestProperty("User-Agent", "HockeySDK/Android");
        httpURLConnection.setInstanceFollowRedirects(true);
        if (VERSION.SDK_INT <= 9) {
            httpURLConnection.setRequestProperty("connection", "close");
        }
    }

    protected URLConnection a(URL url, int i) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        a(httpURLConnection);
        int responseCode = httpURLConnection.getResponseCode();
        if ((responseCode != 301 && responseCode != 302 && responseCode != 303) || i == 0) {
            return httpURLConnection;
        }
        URL url2 = new URL(httpURLConnection.getHeaderField("Location"));
        if (url.getProtocol().equals(url2.getProtocol())) {
            return httpURLConnection;
        }
        httpURLConnection.disconnect();
        return a(url2, i - 1);
    }

    protected void a(Integer... numArr) {
        try {
            if (this.f == null) {
                this.f = new ProgressDialog(this.a);
                this.f.setProgressStyle(1);
                this.f.setMessage("Loading...");
                this.f.setCancelable(false);
                this.f.show();
            }
            this.f.setProgress(numArr[0].intValue());
        } catch (Exception e) {
        }
    }

    protected void a(Long l) {
        if (this.f != null) {
            try {
                this.f.dismiss();
            } catch (Exception e) {
            }
        }
        if (l.longValue() > 0) {
            this.b.a(this);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(this.e, this.d)), "application/vnd.android.package-archive");
            intent.setFlags(268435456);
            this.a.startActivity(intent);
            return;
        }
        try {
            CharSequence string;
            Builder builder = new Builder(this.a);
            builder.setTitle(net.hockeyapp.android.i.d.hockeyapp_download_failed_dialog_title);
            if (this.g == null) {
                string = this.a.getString(net.hockeyapp.android.i.d.hockeyapp_download_failed_dialog_message);
            } else {
                string = this.g;
            }
            builder.setMessage(string);
            builder.setNegativeButton(net.hockeyapp.android.i.d.hockeyapp_download_failed_dialog_negative_button, new OnClickListener(this) {
                final /* synthetic */ d a;

                {
                    this.a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.a.b.a(this.a, Boolean.valueOf(false));
                }
            });
            builder.setPositiveButton(net.hockeyapp.android.i.d.hockeyapp_download_failed_dialog_positive_button, new OnClickListener(this) {
                final /* synthetic */ d a;

                {
                    this.a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.a.b.a(this.a, Boolean.valueOf(true));
                }
            });
            builder.create().show();
        } catch (Exception e2) {
        }
    }

    protected String b() {
        return this.c + "&type=apk";
    }
}
