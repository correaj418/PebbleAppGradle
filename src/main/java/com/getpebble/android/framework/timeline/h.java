package com.getpebble.android.framework.timeline;

import android.content.Context;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.av;
import com.getpebble.android.common.model.v;
import com.getpebble.android.common.model.z;
import com.google.b.a.c;
import com.google.b.g;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import java.lang.reflect.Type;
import java.util.Map;

public class h implements k<h> {
    private static final String ATTRIBUTES_KEY = "attributes";
    private static final String LAYOUTS_KEY = "layouts";
    private static final String RESOURCE_KEY = "resources";
    private static final String TAG = "TimelineMapper";
    private transient AppLayoutsMapper mAppLayoutsMapper;
    @c(a = "attributes")
    private Map<String, a> mAttributeMap;
    @c(a = "layouts")
    private Map<String, Integer> mLayoutNameMap;
    @c(a = "resources")
    private Map<String, Integer> mSystemResourceIdMap;

    enum a {
        BASALT_3_2("default_timeline_mapper_basalt_3.2.json", new v("3.2.0", 0), com.getpebble.android.common.framework.install.app.b.a.BASALT),
        BASALT_3_4("default_timeline_mapper_basalt_3.4.json", new v("3.4.0", 0), com.getpebble.android.common.framework.install.app.b.a.BASALT),
        BASALT_3_5("default_timeline_mapper_basalt_3.5.json", new v("3.5.0", 0), com.getpebble.android.common.framework.install.app.b.a.BASALT),
        BASALT_3_6("default_timeline_mapper_basalt_3.4.json", new v("3.6.0", 0), com.getpebble.android.common.framework.install.app.b.a.BASALT),
        BASALT_3_8("default_timeline_mapper_basalt_3.8.json", new v("3.8.0", 0), com.getpebble.android.common.framework.install.app.b.a.BASALT),
        BASALT_3_12("default_timeline_mapper_basalt_3.12.json", new v("3.12.0", 0), com.getpebble.android.common.framework.install.app.b.a.BASALT),
        BASALT_3_13("default_timeline_mapper_basalt_3.13.json", new v("3.13.0", 0), com.getpebble.android.common.framework.install.app.b.a.BASALT),
        BASALT_4_0("default_timeline_mapper_basalt_4.0.json", new v("4.0.0", 0), com.getpebble.android.common.framework.install.app.b.a.BASALT),
        APLITE_3_13(BASALT_3_13, com.getpebble.android.common.framework.install.app.b.a.APLITE),
        CHALK_3_13(BASALT_3_13, com.getpebble.android.common.framework.install.app.b.a.CHALK),
        DIORITE_3_13(BASALT_3_13, com.getpebble.android.common.framework.install.app.b.a.DIORITE),
        APLITE_4_0(BASALT_4_0, com.getpebble.android.common.framework.install.app.b.a.APLITE),
        CHALK_4_0(BASALT_4_0, com.getpebble.android.common.framework.install.app.b.a.CHALK),
        DIORITE_4_0(BASALT_4_0, com.getpebble.android.common.framework.install.app.b.a.DIORITE);
        
        private static final a FALLBACK = null;
        public final String filename;
        public final v firmwareVersion;
        public final com.getpebble.android.common.framework.install.app.b.a platform;

        static {
            FALLBACK = BASALT_3_2;
        }

        private a(String str, v vVar, com.getpebble.android.common.framework.install.app.b.a aVar) {
            this.filename = str;
            this.firmwareVersion = vVar;
            this.platform = aVar;
        }

        private a(a aVar, com.getpebble.android.common.framework.install.app.b.a aVar2) {
            this.filename = aVar.filename;
            this.firmwareVersion = aVar.firmwareVersion;
            this.platform = aVar2;
        }

        public static a getMapperFor(com.getpebble.android.common.framework.install.app.b.a aVar, v vVar) {
            if (aVar == null) {
                f.a(h.TAG, "Null platform given for getMapperFor(), returning default");
                return FALLBACK;
            } else if (vVar == null) {
                f.a(h.TAG, "Null firmware version given for getMapperFor(), returning default");
                return FALLBACK;
            } else {
                a aVar2 = FALLBACK;
                a aVar3 = aVar2;
                for (a aVar22 : values()) {
                    if (aVar.equals(aVar22.platform) && aVar22.firmwareVersion.compareTo(vVar) <= 0) {
                        aVar3 = aVar22;
                    }
                }
                return aVar3;
            }
        }
    }

    public h deserialize(l lVar, Type type, j jVar) {
        h hVar = new h();
        o l = lVar.l();
        hVar.mAttributeMap = (Map) jVar.a(l.b(ATTRIBUTES_KEY), new com.google.b.c.a<Map<String, a>>() {
        }.getType());
        if (hVar.mAttributeMap == null) {
            throw new p("Attribute map is null");
        }
        hVar.mLayoutNameMap = (Map) jVar.a(l.b(LAYOUTS_KEY), new com.google.b.c.a<Map<String, Integer>>() {
        }.getType());
        if (hVar.mLayoutNameMap == null) {
            throw new p("Layout name map is null");
        }
        hVar.mSystemResourceIdMap = (Map) jVar.a(l.b(RESOURCE_KEY), new com.google.b.c.a<Map<String, Integer>>() {
        }.getType());
        if (hVar.mSystemResourceIdMap == null) {
            throw new p("Resource ID map is null");
        }
        hVar.mAppLayoutsMapper = null;
        return hVar;
    }

    public static h from(String str) {
        return (h) com.getpebble.android.h.p.a(str, h.class, new g().a(h.class, new h()).a(a.class, new a()).c());
    }

    public Map<String, a> getAttributeMap() {
        return this.mAttributeMap;
    }

    public Map<String, Integer> getLayoutNameMap() {
        return this.mLayoutNameMap;
    }

    public Map<String, Integer> getSystemResourceIdMap() {
        return this.mSystemResourceIdMap;
    }

    public AppLayoutsMapper getAppLayoutsMapper() {
        return this.mAppLayoutsMapper;
    }

    public void setAppLayouts(AppLayoutsMapper appLayoutsMapper) {
        if (appLayoutsMapper != null) {
            f.d(TAG, "setAppLayouts(" + appLayoutsMapper + ")");
        }
        this.mAppLayoutsMapper = appLayoutsMapper;
    }

    public static h getMapper(Context context, v vVar, z zVar) {
        try {
            return from(av.b(context.getContentResolver(), zVar, vVar));
        } catch (IllegalStateException e) {
            String str;
            String str2 = TAG;
            String str3 = "No mapper available for FW=<%s> HW=<%s>; falling back to default.";
            Object[] objArr = new Object[2];
            if (vVar == null) {
                str = "null";
            } else {
                str = vVar.toString();
            }
            objArr[0] = str;
            objArr[1] = zVar == null ? "null" : zVar.getName();
            f.d(str2, String.format(str3, objArr));
            return from(getDefaultMapperJson(context, vVar, zVar));
        }
    }

    public static String getDefaultMapperJson(Context context, v vVar, z zVar) {
        if (zVar == null) {
            throw new IllegalArgumentException("Cannot get default mapper with no platform");
        }
        try {
            return com.getpebble.android.common.framework.b.f.a(context, a.getMapperFor(zVar.getPlatformCode(), vVar).filename, false);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String toString() {
        return com.getpebble.android.h.p.a(this);
    }
}
