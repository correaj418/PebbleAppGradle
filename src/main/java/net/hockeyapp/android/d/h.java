package net.hockeyapp.android.d;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.hockeyapp.android.a;
import net.hockeyapp.android.e.d;

public class h extends c<Void, Void, HashMap<String, String>> {
    private Context a;
    private Handler b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private List<Uri> h;
    private String i;
    private boolean j;
    private ProgressDialog k;
    private boolean l = true;
    private int m = -1;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((HashMap) obj);
    }

    public h(Context context, String str, String str2, String str3, String str4, String str5, List<Uri> list, String str6, Handler handler, boolean z) {
        this.a = context;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = list;
        this.i = str6;
        this.b = handler;
        this.j = z;
        if (context != null) {
            a.a(context);
        }
    }

    public void a() {
        this.a = null;
        this.k = null;
    }

    protected void onPreExecute() {
        CharSequence charSequence = "Sending feedback..";
        if (this.j) {
            charSequence = "Retrieving discussions...";
        }
        if ((this.k == null || !this.k.isShowing()) && this.l) {
            this.k = ProgressDialog.show(this.a, "", charSequence, true, false);
        }
    }

    protected HashMap<String, String> a(Void... voidArr) {
        if (this.j && this.i != null) {
            return d();
        }
        if (this.j) {
            return null;
        }
        if (this.h.isEmpty()) {
            return b();
        }
        HashMap<String, String> c = c();
        if (c == null) {
            return c;
        }
        b(c);
        return c;
    }

    private void b(HashMap<String, String> hashMap) {
        String str = (String) hashMap.get("status");
        if (str != null && str.startsWith("2") && this.a != null) {
            File file = new File(this.a.getCacheDir(), "HockeyApp");
            if (file != null && file.exists()) {
                for (File file2 : file.listFiles()) {
                    if (!(file2 == null || Boolean.valueOf(file2.delete()).booleanValue())) {
                        Log.d("SendFeedbackTask", "Error deleting file from temporary folder");
                    }
                }
            }
        }
    }

    protected void a(HashMap<String, String> hashMap) {
        if (this.k != null) {
            try {
                this.k.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.b != null) {
            Message message = new Message();
            Bundle bundle = new Bundle();
            if (hashMap != null) {
                bundle.putString("request_type", (String) hashMap.get("type"));
                bundle.putString("feedback_response", (String) hashMap.get("response"));
                bundle.putString("feedback_status", (String) hashMap.get("status"));
            } else {
                bundle.putString("request_type", "unknown");
            }
            message.setData(bundle);
            this.b.sendMessage(message);
        }
    }

    private HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("type", "send");
        HttpURLConnection httpURLConnection = null;
        try {
            Map hashMap2 = new HashMap();
            hashMap2.put("name", this.d);
            hashMap2.put("email", this.e);
            hashMap2.put("subject", this.f);
            hashMap2.put("text", this.g);
            hashMap2.put("bundle_identifier", a.d);
            hashMap2.put("bundle_short_version", a.c);
            hashMap2.put("bundle_version", a.b);
            hashMap2.put("os_version", a.e);
            hashMap2.put("oem", a.g);
            hashMap2.put("model", a.f);
            if (this.i != null) {
                this.c += this.i + "/";
            }
            httpURLConnection = new d(this.c).a(this.i != null ? "PUT" : "POST").a(hashMap2).a();
            httpURLConnection.connect();
            hashMap.put("status", String.valueOf(httpURLConnection.getResponseCode()));
            hashMap.put("response", c.a(httpURLConnection));
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return hashMap;
    }

    private HashMap<String, String> c() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("type", "send");
        HttpURLConnection httpURLConnection = null;
        try {
            Map hashMap2 = new HashMap();
            hashMap2.put("name", this.d);
            hashMap2.put("email", this.e);
            hashMap2.put("subject", this.f);
            hashMap2.put("text", this.g);
            hashMap2.put("bundle_identifier", a.d);
            hashMap2.put("bundle_short_version", a.c);
            hashMap2.put("bundle_version", a.b);
            hashMap2.put("os_version", a.e);
            hashMap2.put("oem", a.g);
            hashMap2.put("model", a.f);
            if (this.i != null) {
                this.c += this.i + "/";
            }
            httpURLConnection = new d(this.c).a(this.i != null ? "PUT" : "POST").a(hashMap2, this.a, this.h).a();
            httpURLConnection.connect();
            hashMap.put("status", String.valueOf(httpURLConnection.getResponseCode()));
            hashMap.put("response", c.a(httpURLConnection));
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return hashMap;
    }

    private HashMap<String, String> d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c + net.hockeyapp.android.e.h.a(this.i));
        if (this.m != -1) {
            stringBuilder.append("?last_message_id=" + this.m);
        }
        HashMap<String, String> hashMap = new HashMap();
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = new d(stringBuilder.toString()).a();
            hashMap.put("type", "fetch");
            httpURLConnection.connect();
            hashMap.put("status", String.valueOf(httpURLConnection.getResponseCode()));
            hashMap.put("response", c.a(httpURLConnection));
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return hashMap;
    }
}
