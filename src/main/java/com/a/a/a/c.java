package com.a.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.json.JSONTokener;

abstract class c {
    private int a = 30000;
    private int b = 2000;
    private int c = 5000;
    private final String d;
    private final String e;
    private final List<String> f;
    private final List<String> g;
    private final DefaultHttpClient h;
    private String i;
    private String j;
    private HashMap<String, String> k;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[g.values().length];

        static {
            b = new int[a.values().length];
            try {
                b[a.DELETE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[a.GET.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[a.POST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[a.PUT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[g.LOG_BUILD.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[g.LOG_QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[g.LOG_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[g.LOG_ALL.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    private enum a {
        GET,
        POST,
        PUT,
        DELETE
    }

    protected c(String str, String str2, List<String> list, boolean z, String str3) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("AlgoliaSearch requires an applicationID.");
        }
        this.d = str;
        if (str2 == null || str2.length() == 0) {
            throw new RuntimeException("AlgoliaSearch requires an apiKey.");
        }
        this.e = str2;
        if (list == null || list.size() == 0) {
            this.f = Arrays.asList(new String[]{str + "-dsn.algolia.net", str + "-1.algolianet.com", str + "-2.algolianet.com", str + "-3.algolianet.com"});
            this.g = Arrays.asList(new String[]{str + ".algolia.net", str + "-1.algolianet.com", str + "-2.algolianet.com", str + "-3.algolianet.com"});
        } else {
            this.g = list;
            this.f = list;
        }
        this.h = new DefaultHttpClient();
        this.k = new HashMap();
    }

    protected JSONObject a(String str, boolean z) {
        return a(a.GET, str, null, this.f, this.b, z ? this.c : this.a);
    }

    private JSONObject a(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        StringBuilder stringBuilder = new StringBuilder();
        char[] cArr = new char[1000];
        for (int i = 0; i >= 0; i = inputStreamReader.read(cArr)) {
            stringBuilder.append(cArr, 0, i);
        }
        JSONObject jSONObject = new JSONObject(new JSONTokener(stringBuilder.toString()));
        inputStreamReader.close();
        return jSONObject;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized org.json.JSONObject a(com.a.a.a.c.a r11, java.lang.String r12, java.lang.String r13, java.util.List<java.lang.String> r14, int r15, int r16) {
        /*
        r10 = this;
        r9 = 2;
        monitor-enter(r10);
        r5 = new java.util.HashMap;	 Catch:{ all -> 0x0041 }
        r5.<init>();	 Catch:{ all -> 0x0041 }
        r6 = r14.iterator();	 Catch:{ all -> 0x0041 }
    L_0x000b:
        r1 = r6.hasNext();	 Catch:{ all -> 0x0041 }
        if (r1 == 0) goto L_0x024d;
    L_0x0011:
        r1 = r6.next();	 Catch:{ all -> 0x0041 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0041 }
        r2 = com.a.a.a.c.AnonymousClass1.b;	 Catch:{ all -> 0x0041 }
        r3 = r11.ordinal();	 Catch:{ all -> 0x0041 }
        r2 = r2[r3];	 Catch:{ all -> 0x0041 }
        switch(r2) {
            case 1: goto L_0x0044;
            case 2: goto L_0x009c;
            case 3: goto L_0x00a2;
            case 4: goto L_0x00a8;
            default: goto L_0x0022;
        };	 Catch:{ all -> 0x0041 }
    L_0x0022:
        r1 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x0041 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r2.<init>();	 Catch:{ all -> 0x0041 }
        r3 = "Method ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0041 }
        r2 = r2.append(r11);	 Catch:{ all -> 0x0041 }
        r3 = " is not supported";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0041 }
        r2 = r2.toString();	 Catch:{ all -> 0x0041 }
        r1.<init>(r2);	 Catch:{ all -> 0x0041 }
        throw r1;	 Catch:{ all -> 0x0041 }
    L_0x0041:
        r1 = move-exception;
        monitor-exit(r10);
        throw r1;
    L_0x0044:
        r4 = new org.apache.http.client.methods.HttpDelete;	 Catch:{ all -> 0x0041 }
        r4.<init>();	 Catch:{ all -> 0x0041 }
    L_0x0049:
        r2 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x00ae }
        r3 = new java.lang.StringBuilder;	 Catch:{ URISyntaxException -> 0x00ae }
        r3.<init>();	 Catch:{ URISyntaxException -> 0x00ae }
        r7 = "https://";
        r3 = r3.append(r7);	 Catch:{ URISyntaxException -> 0x00ae }
        r3 = r3.append(r1);	 Catch:{ URISyntaxException -> 0x00ae }
        r3 = r3.append(r12);	 Catch:{ URISyntaxException -> 0x00ae }
        r3 = r3.toString();	 Catch:{ URISyntaxException -> 0x00ae }
        r2.<init>(r3);	 Catch:{ URISyntaxException -> 0x00ae }
        r4.setURI(r2);	 Catch:{ URISyntaxException -> 0x00ae }
        r2 = "X-Algolia-Application-Id";
        r3 = r10.d;	 Catch:{ all -> 0x0041 }
        r4.setHeader(r2, r3);	 Catch:{ all -> 0x0041 }
        r2 = "X-Algolia-API-Key";
        r3 = r10.e;	 Catch:{ all -> 0x0041 }
        r4.setHeader(r2, r3);	 Catch:{ all -> 0x0041 }
        r2 = r10.k;	 Catch:{ all -> 0x0041 }
        r2 = r2.entrySet();	 Catch:{ all -> 0x0041 }
        r7 = r2.iterator();	 Catch:{ all -> 0x0041 }
    L_0x0080:
        r2 = r7.hasNext();	 Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x00b5;
    L_0x0086:
        r2 = r7.next();	 Catch:{ all -> 0x0041 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ all -> 0x0041 }
        r3 = r2.getKey();	 Catch:{ all -> 0x0041 }
        r3 = (java.lang.String) r3;	 Catch:{ all -> 0x0041 }
        r2 = r2.getValue();	 Catch:{ all -> 0x0041 }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x0041 }
        r4.setHeader(r3, r2);	 Catch:{ all -> 0x0041 }
        goto L_0x0080;
    L_0x009c:
        r4 = new org.apache.http.client.methods.HttpGet;	 Catch:{ all -> 0x0041 }
        r4.<init>();	 Catch:{ all -> 0x0041 }
        goto L_0x0049;
    L_0x00a2:
        r4 = new org.apache.http.client.methods.HttpPost;	 Catch:{ all -> 0x0041 }
        r4.<init>();	 Catch:{ all -> 0x0041 }
        goto L_0x0049;
    L_0x00a8:
        r4 = new org.apache.http.client.methods.HttpPut;	 Catch:{ all -> 0x0041 }
        r4.<init>();	 Catch:{ all -> 0x0041 }
        goto L_0x0049;
    L_0x00ae:
        r1 = move-exception;
        r2 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0041 }
        r2.<init>(r1);	 Catch:{ all -> 0x0041 }
        throw r2;	 Catch:{ all -> 0x0041 }
    L_0x00b5:
        r2 = "User-Agent";
        r3 = "Algolia for Android 2.5.0";
        r4.setHeader(r2, r3);	 Catch:{ all -> 0x0041 }
        r2 = r10.j;	 Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x00c7;
    L_0x00c0:
        r2 = "X-Algolia-UserToken";
        r3 = r10.j;	 Catch:{ all -> 0x0041 }
        r4.setHeader(r2, r3);	 Catch:{ all -> 0x0041 }
    L_0x00c7:
        r2 = r10.i;	 Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x00d2;
    L_0x00cb:
        r2 = "X-Algolia-TagFilters";
        r3 = r10.i;	 Catch:{ all -> 0x0041 }
        r4.setHeader(r2, r3);	 Catch:{ all -> 0x0041 }
    L_0x00d2:
        r2 = "Accept-Encoding";
        r3 = "gzip";
        r4.addHeader(r2, r3);	 Catch:{ all -> 0x0041 }
        if (r13 == 0) goto L_0x011f;
    L_0x00db:
        r2 = r4 instanceof org.apache.http.client.methods.HttpEntityEnclosingRequestBase;	 Catch:{ all -> 0x0041 }
        if (r2 != 0) goto L_0x00fe;
    L_0x00df:
        r1 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x0041 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r2.<init>();	 Catch:{ all -> 0x0041 }
        r3 = "Method ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0041 }
        r2 = r2.append(r11);	 Catch:{ all -> 0x0041 }
        r3 = " cannot enclose entity";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0041 }
        r2 = r2.toString();	 Catch:{ all -> 0x0041 }
        r1.<init>(r2);	 Catch:{ all -> 0x0041 }
        throw r1;	 Catch:{ all -> 0x0041 }
    L_0x00fe:
        r2 = "Content-type";
        r3 = "application/json";
        r4.setHeader(r2, r3);	 Catch:{ all -> 0x0041 }
        r3 = new org.apache.http.entity.StringEntity;	 Catch:{ UnsupportedEncodingException -> 0x0182 }
        r2 = "UTF-8";
        r3.<init>(r13, r2);	 Catch:{ UnsupportedEncodingException -> 0x0182 }
        r2 = new org.apache.http.message.BasicHeader;	 Catch:{ UnsupportedEncodingException -> 0x0182 }
        r7 = "Content-Type";
        r8 = "application/json";
        r2.<init>(r7, r8);	 Catch:{ UnsupportedEncodingException -> 0x0182 }
        r3.setContentEncoding(r2);	 Catch:{ UnsupportedEncodingException -> 0x0182 }
        r0 = r4;
        r0 = (org.apache.http.client.methods.HttpEntityEnclosingRequestBase) r0;	 Catch:{ UnsupportedEncodingException -> 0x0182 }
        r2 = r0;
        r2.setEntity(r3);	 Catch:{ UnsupportedEncodingException -> 0x0182 }
    L_0x011f:
        r2 = r10.h;	 Catch:{ all -> 0x0041 }
        r2 = r2.getParams();	 Catch:{ all -> 0x0041 }
        r3 = "http.socket.timeout";
        r7 = java.lang.Integer.valueOf(r16);	 Catch:{ all -> 0x0041 }
        r2.setParameter(r3, r7);	 Catch:{ all -> 0x0041 }
        r2 = r10.h;	 Catch:{ all -> 0x0041 }
        r2 = r2.getParams();	 Catch:{ all -> 0x0041 }
        r3 = "http.connection.timeout";
        r7 = java.lang.Integer.valueOf(r15);	 Catch:{ all -> 0x0041 }
        r2.setParameter(r3, r7);	 Catch:{ all -> 0x0041 }
        r2 = r10.h;	 Catch:{ IOException -> 0x019c }
        r2 = r2.execute(r4);	 Catch:{ IOException -> 0x019c }
        r3 = r2.getStatusLine();	 Catch:{ all -> 0x0041 }
        r3 = r3.getStatusCode();	 Catch:{ all -> 0x0041 }
        r4 = r3 / 100;
        if (r4 != r9) goto L_0x01bd;
    L_0x014f:
        r1 = r2.getEntity();	 Catch:{ IOException -> 0x0291, JSONException -> 0x022f }
        r1 = r1.getContentEncoding();	 Catch:{ IOException -> 0x0291, JSONException -> 0x022f }
        if (r1 == 0) goto L_0x021e;
    L_0x0159:
        r1 = r2.getEntity();	 Catch:{ IOException -> 0x0291, JSONException -> 0x022f }
        r1 = r1.getContentEncoding();	 Catch:{ IOException -> 0x0291, JSONException -> 0x022f }
        r1 = r1.getValue();	 Catch:{ IOException -> 0x0291, JSONException -> 0x022f }
    L_0x0165:
        if (r1 == 0) goto L_0x0221;
    L_0x0167:
        r3 = "gzip";
        r1 = r1.contains(r3);	 Catch:{ IOException -> 0x0291, JSONException -> 0x022f }
        if (r1 == 0) goto L_0x0221;
    L_0x016f:
        r1 = new java.util.zip.GZIPInputStream;	 Catch:{ IOException -> 0x0291, JSONException -> 0x022f }
        r2 = r2.getEntity();	 Catch:{ IOException -> 0x0291, JSONException -> 0x022f }
        r2 = r2.getContent();	 Catch:{ IOException -> 0x0291, JSONException -> 0x022f }
        r1.<init>(r2);	 Catch:{ IOException -> 0x0291, JSONException -> 0x022f }
        r1 = r10.a(r1);	 Catch:{ IOException -> 0x0291, JSONException -> 0x022f }
    L_0x0180:
        monitor-exit(r10);
        return r1;
    L_0x0182:
        r1 = move-exception;
        r1 = new com.a.a.a.b;	 Catch:{ all -> 0x0041 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r2.<init>();	 Catch:{ all -> 0x0041 }
        r3 = "Invalid JSON Object: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0041 }
        r2 = r2.append(r13);	 Catch:{ all -> 0x0041 }
        r2 = r2.toString();	 Catch:{ all -> 0x0041 }
        r1.<init>(r2);	 Catch:{ all -> 0x0041 }
        throw r1;	 Catch:{ all -> 0x0041 }
    L_0x019c:
        r2 = move-exception;
        r3 = "%s=%s";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0041 }
        r7 = 0;
        r8 = r2.getClass();	 Catch:{ all -> 0x0041 }
        r8 = r8.getName();	 Catch:{ all -> 0x0041 }
        r4[r7] = r8;	 Catch:{ all -> 0x0041 }
        r7 = 1;
        r2 = r2.getMessage();	 Catch:{ all -> 0x0041 }
        r4[r7] = r2;	 Catch:{ all -> 0x0041 }
        r2 = java.lang.String.format(r3, r4);	 Catch:{ all -> 0x0041 }
        r5.put(r1, r2);	 Catch:{ all -> 0x0041 }
        goto L_0x000b;
    L_0x01bd:
        r4 = r3 / 100;
        r7 = 4;
        if (r4 != r7) goto L_0x0201;
    L_0x01c2:
        r1 = "Error detected in backend";
        r1 = r2.getEntity();	 Catch:{ IOException -> 0x0294, JSONException -> 0x01e3 }
        r1 = r1.getContent();	 Catch:{ IOException -> 0x0294, JSONException -> 0x01e3 }
        r1 = r10.a(r1);	 Catch:{ IOException -> 0x0294, JSONException -> 0x01e3 }
        r3 = "message";
        r1 = r1.getString(r3);	 Catch:{ IOException -> 0x0294, JSONException -> 0x01e3 }
        r2 = r2.getEntity();	 Catch:{ all -> 0x0041 }
        r10.a(r2);	 Catch:{ all -> 0x0041 }
        r2 = new com.a.a.a.b;	 Catch:{ all -> 0x0041 }
        r2.<init>(r1);	 Catch:{ all -> 0x0041 }
        throw r2;	 Catch:{ all -> 0x0041 }
    L_0x01e3:
        r1 = move-exception;
        r2 = new com.a.a.a.b;	 Catch:{ all -> 0x0041 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r3.<init>();	 Catch:{ all -> 0x0041 }
        r4 = "JSON decode error:";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0041 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0041 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0041 }
        r1 = r1.toString();	 Catch:{ all -> 0x0041 }
        r2.<init>(r1);	 Catch:{ all -> 0x0041 }
        throw r2;	 Catch:{ all -> 0x0041 }
    L_0x0201:
        r4 = r2.getEntity();	 Catch:{ IOException -> 0x0215 }
        r4 = org.apache.http.util.EntityUtils.toString(r4);	 Catch:{ IOException -> 0x0215 }
        r5.put(r1, r4);	 Catch:{ IOException -> 0x0215 }
    L_0x020c:
        r1 = r2.getEntity();	 Catch:{ all -> 0x0041 }
        r10.a(r1);	 Catch:{ all -> 0x0041 }
        goto L_0x000b;
    L_0x0215:
        r4 = move-exception;
        r3 = java.lang.String.valueOf(r3);	 Catch:{ all -> 0x0041 }
        r5.put(r1, r3);	 Catch:{ all -> 0x0041 }
        goto L_0x020c;
    L_0x021e:
        r1 = 0;
        goto L_0x0165;
    L_0x0221:
        r1 = r2.getEntity();	 Catch:{ IOException -> 0x0291, JSONException -> 0x022f }
        r1 = r1.getContent();	 Catch:{ IOException -> 0x0291, JSONException -> 0x022f }
        r1 = r10.a(r1);	 Catch:{ IOException -> 0x0291, JSONException -> 0x022f }
        goto L_0x0180;
    L_0x022f:
        r1 = move-exception;
        r2 = new com.a.a.a.b;	 Catch:{ all -> 0x0041 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r3.<init>();	 Catch:{ all -> 0x0041 }
        r4 = "JSON decode error:";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0041 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0041 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0041 }
        r1 = r1.toString();	 Catch:{ all -> 0x0041 }
        r2.<init>(r1);	 Catch:{ all -> 0x0041 }
        throw r2;	 Catch:{ all -> 0x0041 }
    L_0x024d:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0041 }
        r1 = "Hosts unreachable: ";
        r3.<init>(r1);	 Catch:{ all -> 0x0041 }
        r1 = 1;
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ all -> 0x0041 }
        r2 = r5.entrySet();	 Catch:{ all -> 0x0041 }
        r4 = r2.iterator();	 Catch:{ all -> 0x0041 }
        r2 = r1;
    L_0x0262:
        r1 = r4.hasNext();	 Catch:{ all -> 0x0041 }
        if (r1 == 0) goto L_0x0287;
    L_0x0268:
        r1 = r4.next();	 Catch:{ all -> 0x0041 }
        r1 = (java.util.Map.Entry) r1;	 Catch:{ all -> 0x0041 }
        r2 = r2.booleanValue();	 Catch:{ all -> 0x0041 }
        if (r2 != 0) goto L_0x0279;
    L_0x0274:
        r2 = ", ";
        r3.append(r2);	 Catch:{ all -> 0x0041 }
    L_0x0279:
        r1 = r1.toString();	 Catch:{ all -> 0x0041 }
        r3.append(r1);	 Catch:{ all -> 0x0041 }
        r1 = 0;
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ all -> 0x0041 }
        r2 = r1;
        goto L_0x0262;
    L_0x0287:
        r1 = new com.a.a.a.b;	 Catch:{ all -> 0x0041 }
        r2 = r3.toString();	 Catch:{ all -> 0x0041 }
        r1.<init>(r2);	 Catch:{ all -> 0x0041 }
        throw r1;	 Catch:{ all -> 0x0041 }
    L_0x0291:
        r1 = move-exception;
        goto L_0x000b;
    L_0x0294:
        r1 = move-exception;
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.c.a(com.a.a.a.c$a, java.lang.String, java.lang.String, java.util.List, int, int):org.json.JSONObject");
    }

    private void a(HttpEntity httpEntity) {
        if (httpEntity != null) {
            try {
                if (httpEntity.isStreaming()) {
                    InputStream content = httpEntity.getContent();
                    if (content != null) {
                        content.close();
                    }
                }
            } catch (IOException e) {
            }
        }
    }
}
