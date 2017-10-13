package com.getpebble.android.common.framework.install.app;

import android.net.Uri;
import android.text.TextUtils;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.d;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.install.PebbleManifest;
import com.getpebble.android.common.model.AppInfo;
import com.getpebble.android.common.model.ah;
import com.getpebble.android.framework.timeline.AppLayoutsMapper;
import com.getpebble.android.framework.timeline.AppLayoutsMapper.Builder;
import com.google.a.f.e;
import com.google.b.g;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class b extends com.getpebble.android.common.framework.install.a<AppManifest> {
    private AppInfo a;
    private Map<a, AppManifest> b = new HashMap();
    private List<com.getpebble.android.common.framework.install.b> c;
    private Map<a, a> d = new HashMap();
    private final AppLayoutsMapper e;

    public enum a {
        APLITE("", "aplite/", "aplite", null, b.SQUARE, R.drawable.popup_pebble_original_black, R.drawable.pebble_model_black_connection, false, ah.COLOR_BLACK),
        BASALT(null, "basalt/", "basalt", APLITE, b.ROUND_RECT, R.drawable.popup_pebble_time_black, R.drawable.pebble_time_black_connection, false, ah.COLOR_SNOWY_BLACK),
        CHALK(null, "chalk/", "chalk", null, b.CIRCLE, R.drawable.popup_pebble_round_black14mm, R.drawable.pebble_time_round_black_14_connection, false, ah.COLOR_SPALDING_BLACK_14),
        DIORITE(null, "diorite/", "diorite", APLITE, b.SQUARE, R.drawable.popup_pebble_original_white, R.drawable.pebble_model_white_connection, true, ah.COLOR_SILK_HR_BLACK),
        EMERY(null, "emery/", "emery", BASALT, b.ROUND_RECT, R.drawable.popup_pebble_original_gray, R.drawable.pebble_model_gray_connection, true, ah.COLOR_ROBERT_BLACK);
        
        private final String code;
        public final ah defaultColor;
        private final int defaultConnectionResource;
        private final int defaultMyPebbleResource;
        private final a fallback;
        private final String legacyPath;
        private final String path;
        private final b shape;
        public final boolean useBle;

        private a(String str, String str2, String str3, a aVar, b bVar, int i, int i2, boolean z, ah ahVar) {
            this.legacyPath = str;
            this.path = str2;
            this.code = str3;
            this.fallback = aVar;
            this.shape = bVar;
            this.defaultMyPebbleResource = i;
            this.defaultConnectionResource = i2;
            this.useBle = z;
            this.defaultColor = ahVar;
        }

        public String getLegacyPath() {
            return this.legacyPath;
        }

        public String getPath() {
            return this.path;
        }

        public String getCode() {
            return this.code;
        }

        public a getFallback() {
            return this.fallback;
        }

        public b getShape() {
            return this.shape;
        }

        public int getDefaultMyPebbleResource() {
            return this.defaultMyPebbleResource;
        }

        public int getDefaultConnectionResource() {
            return this.defaultConnectionResource;
        }

        public static a fromString(String str) {
            for (a aVar : values()) {
                if (aVar.getCode().equals(str)) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public enum b {
        SQUARE,
        ROUND_RECT,
        CIRCLE
    }

    public static class c implements k<e> {
        public /* synthetic */ Object deserialize(l lVar, Type type, j jVar) {
            return a(lVar, type, jVar);
        }

        public e a(l lVar, Type type, j jVar) {
            return e.a(lVar.e());
        }
    }

    public /* synthetic */ PebbleManifest c() {
        return g();
    }

    public b(ZipFile zipFile, Map<String, ZipEntry> map) {
        super(zipFile, map);
        for (a aVar : a.values()) {
            AppManifest appManifest = (AppManifest) a(AppManifest.class, aVar.getPath());
            if (appManifest != null) {
                this.b.put(aVar, appManifest);
            }
            try {
                this.d.put(aVar, new a(this, aVar));
            } catch (IllegalArgumentException e) {
            } catch (NullPointerException e2) {
            }
        }
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No manifests found!");
        } else if (this.d.isEmpty()) {
            throw new IllegalStateException("No binary info found!");
        } else {
            j();
            Builder builder = new Builder();
            for (Entry entry : this.b.entrySet()) {
                a aVar2 = (a) entry.getKey();
                Object a = a(aVar2.getPath(), ((AppManifest) entry.getValue()).getAppLayoutsFilename());
                if (TextUtils.isEmpty(a)) {
                    f.d("AppBundle", "App layout empty in platform: " + aVar2.getCode());
                } else {
                    builder.addPlatformJson(aVar2.code, a);
                }
            }
            this.e = builder.build();
            return;
        }
        f.d("AppBundle", "No binary info for platform: " + aVar);
    }

    String a(String str, String str2) {
        InputStream a;
        Exception e;
        Throwable th;
        String str3 = null;
        if (!TextUtils.isEmpty(str2)) {
            try {
                a = super.a(str + str2);
                try {
                    str3 = c.a.a.a.e.b(a);
                    if (a != null) {
                        try {
                            a.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        f.d("AppBundle", "getAppLayouts: IOException reading app layout" + d.a(e, 3));
                        if (a != null) {
                            try {
                                a.close();
                            } catch (IOException e4) {
                            }
                        }
                        return str3;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            try {
                                a.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                a = str3;
                f.d("AppBundle", "getAppLayouts: IOException reading app layout" + d.a(e, 3));
                if (a != null) {
                    a.close();
                }
                return str3;
            } catch (Throwable th3) {
                a = str3;
                th = th3;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        }
        return str3;
    }

    private void j() {
        if (a().containsKey("appinfo.json")) {
            InputStream a = a("appinfo.json");
            Reader bufferedReader = new BufferedReader(new InputStreamReader(a));
            g gVar = new g();
            gVar.a(e.class, new c());
            this.a = (AppInfo) gVar.c().a(bufferedReader, AppInfo.class);
            a.close();
            return;
        }
        f.a("AppBundle", "No app info found.");
        throw new IOException("Components do not contain app info");
    }

    public a a(a aVar) {
        a aVar2 = (a) this.d.get(aVar);
        if (aVar2 != null || aVar.getFallback() == null) {
            return aVar2;
        }
        f.d("AppBundle", "Binary info not found for platform " + aVar + "; defaulting to " + aVar.getFallback());
        return (a) this.d.get(aVar.getFallback());
    }

    public List<com.getpebble.android.common.framework.install.b> b(a aVar) {
        if (this.c == null) {
            this.c = new ArrayList();
            if (d(aVar)) {
                this.c.add(com.getpebble.android.common.framework.install.b.APP_RESOURCES);
            }
            if (c(aVar)) {
                this.c.add(com.getpebble.android.common.framework.install.b.WORKER);
            }
            this.c.add(com.getpebble.android.common.framework.install.b.APP);
        }
        return this.c;
    }

    public boolean f() {
        return a().containsKey("pebble-js-app.js");
    }

    public boolean c(a aVar) {
        return e(aVar).hasWorker();
    }

    public boolean d() {
        throw new IllegalStateException("hasResources() must be requested by platform for App bundles");
    }

    public boolean d(a aVar) {
        AppManifest e = e(aVar);
        return (e == null || e.getResourceInfo() == null) ? false : true;
    }

    public AppManifest g() {
        throw new IllegalStateException("Manifest must be requested by platform for App bundles");
    }

    public AppLayoutsMapper h() {
        return this.e;
    }

    public AppManifest e(a aVar) {
        AppManifest appManifest = (AppManifest) this.b.get(aVar);
        if (appManifest != null || aVar.getFallback() == null) {
            return appManifest;
        }
        return (AppManifest) this.b.get(aVar.getFallback());
    }

    public AppInfo i() {
        return this.a;
    }

    public InputStream a(String str) {
        f.e("AppBundle", "getInputStreamForComponent: componentName = " + str);
        for (a aVar : a.values()) {
            if (str.startsWith(aVar.getPath())) {
                return a(str, aVar);
            }
        }
        return super.a(str);
    }

    public InputStream a(String str, a aVar) {
        f.e("AppBundle", "getInputStreamForComponent: componentName = " + str + " platform = " + aVar + " path = " + aVar.getPath());
        try {
            InputStream a;
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            try {
                a = super.a(aVar.getPath() + lastPathSegment);
            } catch (FileNotFoundException e) {
                a = null;
            }
            if (a == null) {
                try {
                    if (aVar.getLegacyPath() != null) {
                        a = super.a(aVar.getLegacyPath() + lastPathSegment);
                    }
                } catch (FileNotFoundException e2) {
                }
            }
            if (a != null) {
                return a;
            }
            if (aVar.getFallback() == null) {
                return null;
            }
            f.e("AppBundle", "getInputStreamForComponent: File '" + str + "' not found for platform " + aVar + "; defaulting to " + aVar.getFallback() + " file = " + aVar.getFallback().getPath() + str);
            return a(str, aVar.getFallback());
        } catch (NullPointerException e3) {
            return null;
        }
    }
}
