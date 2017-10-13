package net.hockeyapp.android.d;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import net.hockeyapp.android.a;
import net.hockeyapp.android.e.i;
import net.hockeyapp.android.e.j;
import net.hockeyapp.android.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends AsyncTask<Void, String, JSONArray> {
    protected String a;
    protected String b;
    protected Boolean c;
    protected l d;
    private Context e;
    private long f;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((JSONArray) obj);
    }

    protected int a() {
        return Integer.parseInt(a.b);
    }

    protected JSONArray a(Void... voidArr) {
        Exception e;
        try {
            int a = a();
            JSONArray jSONArray = new JSONArray(i.a(this.e));
            if (b() && a(jSONArray, a)) {
                return jSONArray;
            }
            URLConnection a2 = a(new URL(a("json")));
            a2.connect();
            InputStream bufferedInputStream = new BufferedInputStream(a2.getInputStream());
            String a3 = a(bufferedInputStream);
            bufferedInputStream.close();
            JSONArray jSONArray2 = new JSONArray(a3);
            if (a(jSONArray2, a)) {
                return b(jSONArray2);
            }
            return null;
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            return null;
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
            return null;
        }
    }

    protected URLConnection a(URL url) {
        URLConnection openConnection = url.openConnection();
        openConnection.addRequestProperty("User-Agent", "HockeySDK/Android");
        if (VERSION.SDK_INT <= 9) {
            openConnection.setRequestProperty("connection", "close");
        }
        return openConnection;
    }

    private boolean a(JSONArray jSONArray, int i) {
        int i2 = 0;
        boolean z = false;
        while (i2 < jSONArray.length()) {
            try {
                Object obj;
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject.getInt("version") > i) {
                    obj = 1;
                } else {
                    obj = null;
                }
                Object obj2;
                if (jSONObject.getInt("version") == i && j.a(this.e, jSONObject.getLong("timestamp"))) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                Object obj3;
                if (j.a(jSONObject.getString("minimum_os_version"), j.a(VERSION.RELEASE)) <= 0) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (!((obj == null && r4 == null) || r3 == null)) {
                    if (jSONObject.has("mandatory")) {
                        this.c = Boolean.valueOf(this.c.booleanValue() | jSONObject.getBoolean("mandatory"));
                    }
                    z = true;
                }
                i2++;
            } catch (JSONException e) {
                return false;
            }
        }
        return z;
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < Math.min(jSONArray.length(), 25); i++) {
            try {
                jSONArray2.put(jSONArray.get(i));
            } catch (JSONException e) {
            }
        }
        return jSONArray2;
    }

    protected void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            if (this.d != null) {
                this.d.a(jSONArray, a("apk"));
            }
        } else if (this.d != null) {
            this.d.a();
        }
    }

    protected String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("api/2/apps/");
        stringBuilder.append(this.b != null ? this.b : this.e.getPackageName());
        stringBuilder.append("?format=" + str);
        if (Secure.getString(this.e.getContentResolver(), "android_id") != null) {
            stringBuilder.append("&udid=" + b(Secure.getString(this.e.getContentResolver(), "android_id")));
        }
        stringBuilder.append("&os=Android");
        stringBuilder.append("&os_version=" + b(a.e));
        stringBuilder.append("&device=" + b(a.f));
        stringBuilder.append("&oem=" + b(a.g));
        stringBuilder.append("&app_version=" + b(a.b));
        stringBuilder.append("&sdk=" + b("HockeySDK"));
        stringBuilder.append("&sdk_version=" + b("3.7.0"));
        stringBuilder.append("&lang=" + b(Locale.getDefault().getLanguage()));
        stringBuilder.append("&usage_time=" + this.f);
        return stringBuilder.toString();
    }

    private String b(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    protected boolean b() {
        return true;
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
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.d.b.a(java.io.InputStream):java.lang.String");
    }
}
