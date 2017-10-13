package net.hockeyapp.android.e;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d {
    private final String a;
    private String b;
    private String c;
    private g d;
    private int e = 120000;
    private final Map<String, String> f;

    public d(String str) {
        this.a = str;
        this.f = new HashMap();
    }

    public d a(String str) {
        this.b = str;
        return this;
    }

    public d b(String str) {
        this.c = str;
        return this;
    }

    public d a(Map<String, String> map) {
        try {
            String a = a((Map) map, "UTF-8");
            a("Content-Type", "application/x-www-form-urlencoded");
            b(a);
            return this;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public d a(Map<String, String> map, Context context, List<Uri> list) {
        try {
            this.d = new g();
            this.d.b();
            for (String str : map.keySet()) {
                this.d.a(str, (String) map.get(str));
            }
            for (int i = 0; i < list.size(); i++) {
                boolean z;
                Uri uri = (Uri) list.get(i);
                if (i == list.size() - 1) {
                    z = true;
                } else {
                    z = false;
                }
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                this.d.a("attachment" + i, uri.getLastPathSegment(), openInputStream, z);
            }
            this.d.c();
            a("Content-Type", "multipart/form-data; boundary=" + this.d.a());
            return this;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public d a(String str, String str2) {
        this.f.put(str, str2);
        return this;
    }

    public d b(String str, String str2) {
        a("Authorization", "Basic " + b.a((str + ":" + str2).getBytes(), 2));
        return this;
    }

    public HttpURLConnection a() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
            httpURLConnection.setConnectTimeout(this.e);
            httpURLConnection.setReadTimeout(this.e);
            if (VERSION.SDK_INT <= 9) {
                httpURLConnection.setRequestProperty("Connection", "close");
            }
            if (!TextUtils.isEmpty(this.b)) {
                httpURLConnection.setRequestMethod(this.b);
                if (!TextUtils.isEmpty(this.c) || this.b.equalsIgnoreCase("POST") || this.b.equalsIgnoreCase("PUT")) {
                    httpURLConnection.setDoOutput(true);
                }
            }
            for (String str : this.f.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) this.f.get(str));
            }
            if (!TextUtils.isEmpty(this.c)) {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(this.c);
                bufferedWriter.flush();
                bufferedWriter.close();
            }
            if (this.d != null) {
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(this.d.d()));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(this.d.e().toByteArray());
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            }
            return httpURLConnection;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static String a(Map<String, String> map, String str) {
        Iterable arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            String str3 = (String) map.get(str2);
            String str22 = URLEncoder.encode(str22, str);
            arrayList.add(str22 + "=" + URLEncoder.encode(str3, str));
        }
        return TextUtils.join("&", arrayList);
    }
}
