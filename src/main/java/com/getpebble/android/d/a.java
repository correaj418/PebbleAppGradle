package com.getpebble.android.d;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.b.b.b.c.a.e;
import com.b.b.h;
import com.b.b.j;
import com.b.b.x;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.h.q;
import com.google.a.b.ad;
import com.google.b.o;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class a {
    public static final long a = TimeUnit.MINUTES.toMillis(2);

    public static abstract class b implements Runnable {
        private int a = 0;
        public int e = 0;

        public int a() {
            return this.e;
        }
    }

    public static class a extends RuntimeException {
        public a(Throwable th) {
            super(th);
        }
    }

    public static x<o> a(Context context, int i, String str) {
        f.d("HttpRequestUtil", "fetchBootConfig: " + str);
        return d(context, str, (long) i);
    }

    public static void a(Context context, boolean z, String str, com.b.a.b.f<x<o>> fVar, int i) {
        String w;
        Thread.currentThread().setContextClassLoader(a.class.getClassLoader());
        if (z) {
            w = PebbleApplication.w().w();
        } else {
            w = PebbleApplication.w().x();
        }
        f.d("HttpRequestUtil", "fetchMeData: url = " + w + ", uuid = " + UUID.randomUUID().toString());
        ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(context).d(w)).d("Authorization", "Bearer " + str)).b(i)).a().n().a(fVar);
    }

    public static x<o> a(Context context, String str, String str2, int i) {
        Builder appendQueryParameter = Uri.parse(PebbleApplication.w().p()).buildUpon().appendQueryParameter("isoLocal", q.a()).appendQueryParameter("mobileVersion", "4.4.1-1404-01abd2f76-endframe").appendQueryParameter("mobilePlatform", "android");
        if (str != null) {
            appendQueryParameter.appendQueryParameter("hardware", str);
        }
        if (str2 != null) {
            appendQueryParameter.appendQueryParameter("firmware", str2);
        }
        String uri = appendQueryParameter.build().toString();
        f.d("HttpRequestUtil", "Fetching language packs from: " + uri);
        return d(context, uri, (long) i);
    }

    public static x<o> a(Context context, String str, String str2, long j) {
        String q = PebbleApplication.w().q();
        Builder appendQueryParameter = Uri.parse(q).buildUpon().appendQueryParameter("isoLocal", q.a()).appendQueryParameter("mobileVersion", "4.4.1-1404-01abd2f76-endframe").appendQueryParameter("mobilePlatform", "android");
        if (str != null) {
            appendQueryParameter.appendQueryParameter("hardware", str);
        }
        if (str2 != null) {
            appendQueryParameter.appendQueryParameter("firmware", str2);
        }
        String uri = appendQueryParameter.build().toString();
        f.d("HttpRequestUtil", "fetchFonts: fetching font packs from: " + uri);
        c.a(q, uri);
        return d(context, uri, j);
    }

    public static x<o> a(Context context, String str, Object obj, long j) {
        com.b.b.b.c.a.a aVar = (com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(context).d(str)).d("Authorization", "Bearer " + PebbleApplication.u().b())).b((int) j);
        f.d("HttpRequestUtil", "post: url = " + str + ", uuid = " + UUID.randomUUID().toString());
        return a(((com.b.b.b.c.a.c) aVar.b(obj)).a().n());
    }

    public static x<o> a(Context context, String str, o oVar, long j) {
        com.b.b.b.c.a.a aVar = (com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(context).d(str)).d("Authorization", "Bearer " + PebbleApplication.u().b())).b((int) j);
        f.d("HttpRequestUtil", "post: url = " + str + ", uuid = " + UUID.randomUUID().toString());
        return a(((com.b.b.b.c.a.c) aVar.b(oVar)).a().n());
    }

    public static x<o> a(Context context, String str, long j) {
        com.b.b.b.c.a.a aVar = (com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(context).f("PUT", str)).d("Authorization", "Bearer " + PebbleApplication.u().b())).b((int) j);
        f.d("HttpRequestUtil", "put: url = " + str + ", uuid = " + UUID.randomUUID().toString());
        return a(aVar.a().n());
    }

    public static x<o> b(Context context, String str, long j) {
        com.b.b.b.c.a.a aVar = (com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(context).f("DELETE", str)).d("Authorization", "Bearer " + PebbleApplication.u().b())).b((int) j);
        f.d("HttpRequestUtil", "delete: url = " + str + ", uuid = " + UUID.randomUUID().toString());
        return a(aVar.a().n());
    }

    public static x<o> c(Context context, String str, long j) {
        return a(context, str, j, null);
    }

    public static x<o> a(Context context, String str, long j, Map<String, String> map) {
        f.d("HttpRequestUtil", "Performing request to: " + str);
        com.b.b.b.c.a.a aVar = (com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(context).d(str)).d("Authorization", "Bearer " + PebbleApplication.u().b());
        if (!(map == null || map.isEmpty())) {
            aVar.b(a((Map) map));
        }
        f.d("HttpRequestUtil", "authenticatedRequest: url = " + str + ", uuid = " + UUID.randomUUID().toString());
        return a(((com.b.b.b.c.a.a) aVar.b((int) j)).a().n());
    }

    private static x<o> d(Context context, String str, long j) {
        com.b.b.b.c.a.a aVar = (com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(context).d(str)).b((int) j);
        f.d("HttpRequestUtil", "request: url = " + str + ", uuid = " + UUID.randomUUID().toString());
        return a(aVar.a().n());
    }

    private static void b(Context context, com.getpebble.android.common.model.timeline.b bVar, b bVar2, int i, Map<String, List<String>> map) {
        if (map.isEmpty()) {
            Map c = bVar.c();
            if (!(c == null || c.isEmpty())) {
                for (Entry entry : c.entrySet()) {
                    map.put(entry.getKey(), ad.a(entry.getValue()));
                }
            }
        }
        String uuid = UUID.randomUUID().toString();
        final b bVar3 = bVar2;
        final com.getpebble.android.common.model.timeline.b bVar4 = bVar;
        final Context context2 = context;
        final int i2 = i;
        final Map<String, List<String>> map2 = map;
        com.b.a.b.f anonymousClass1 = new com.b.a.b.f<x<String>>() {
            public void a(Exception exception, x<String> xVar) {
                if (exception != null || xVar.d() == null) {
                    bVar3.e = 1;
                } else if (xVar.d().b() >= 300 && xVar.d().b() < 400) {
                    bVar3.a = bVar3.a + 1;
                    if (bVar3.a > 5) {
                        bVar3.e = 1;
                    } else {
                        bVar4.a(xVar.d().a().a("Location"));
                        if (bVar4.a() == null) {
                            bVar3.e = 1;
                        } else {
                            a.b(context2, bVar4, bVar3, i2, map2);
                            return;
                        }
                    }
                } else if (xVar.d().b() < 200 || xVar.d().b() >= 400) {
                    bVar3.e = 1;
                } else {
                    bVar3.e = 2;
                }
                bVar3.run();
            }
        };
        String uri = Uri.parse(bVar.a()).buildUpon().encodedQuery(bVar.d()).build().toString();
        f.d("HttpRequestUtil", "request: url = " + uri + ", uuid = " + uuid);
        o e = bVar.e();
        if (e != null) {
            ((com.b.b.b.c.a.c) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(context).f(bVar.b(), uri)).b((Map) map)).b(i)).b(false)).b(e)).b().n().a(anonymousClass1);
        } else {
            ((com.b.b.b.c.a.c) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(context).f(bVar.b(), bVar.a())).b((Map) map)).b(i)).b(false)).c(bVar.d())).b().n().a(anonymousClass1);
        }
    }

    public static void a(Context context, com.getpebble.android.common.model.timeline.b bVar, b bVar2, int i) {
        b(context, bVar, bVar2, i, new HashMap());
    }

    public static <T> x<T> a(Context context, String str, long j, Class<T> cls) {
        f.d("HttpRequestUtil", "request(" + str + ")");
        return a(((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(context).d(str)).b((int) j)).a(cls).n());
    }

    public static <T> x<T> a(Future<x<T>> future) {
        Thread.currentThread().setContextClassLoader(a.class.getClassLoader());
        try {
            x<T> xVar = (x) future.get();
            b(xVar);
            return xVar;
        } catch (Throwable e) {
            throw new a(e);
        } catch (Throwable e2) {
            throw new a(e2);
        }
    }

    private static void b(x xVar) {
        if (xVar == null) {
            f.d("HttpRequestUtil", "printResponse: response is null");
            return;
        }
        h d = xVar.d();
        f.d("HttpRequestUtil", "printResponse: status code = " + d.b() + ", message = " + d.c());
    }

    public static <T> boolean a(x<T> xVar) {
        if (xVar == null) {
            f.d("HttpRequestUtil", "response is null");
            return false;
        } else if (xVar.d() == null) {
            f.d("HttpRequestUtil", "response.getHeaders() is null");
            return false;
        } else {
            int b = xVar.d().b();
            if (b < 200 || b >= 300) {
                return false;
            }
            return true;
        }
    }

    private static Map<String, List<String>> a(Map<String, String> map) {
        Map<String, List<String>> hashMap = new HashMap();
        if (!(map == null || map.isEmpty())) {
            for (Entry entry : map.entrySet()) {
                hashMap.put(entry.getKey(), ad.a(entry.getValue()));
            }
        }
        return hashMap;
    }

    public static x<o> a(Context context, String str, File file, long j) {
        f.e("HttpRequestUtil", "postFileBlockingUnauthenticated: " + str + " / " + file);
        return a(((e) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(context).f("POST", str)).b((int) j)).b("file", file)).a().n());
    }

    public static x<o> b(Context context, String str, Object obj, long j) {
        f.e("HttpRequestUtil", "postBlockingUnauthenticated: " + str);
        return a(((com.b.b.b.c.a.c) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(context).f("POST", str)).b((int) j)).b(obj)).a().n());
    }
}
