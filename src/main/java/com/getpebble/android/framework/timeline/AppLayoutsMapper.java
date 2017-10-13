package com.getpebble.android.framework.timeline;

import com.getpebble.android.h.p;
import com.google.a.g.g;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AppLayoutsMapper implements k<AppLayoutsMapper> {
    static final String RESOURCES_KEY = "resources";
    private final Map<String, Map<String, Map<String, Integer>>> platformToLayoutMap = new HashMap();

    public static class Builder {
        private final Map<String, String> platformSpecificJson = new HashMap();

        public Builder addPlatformJson(String str, String str2) {
            this.platformSpecificJson.put(str, str2);
            return this;
        }

        public AppLayoutsMapper build() {
            AppLayoutsMapper appLayoutsMapper = new AppLayoutsMapper();
            Type type = new g<Map<String, Map<String, Integer>>>() {
            }.getType();
            for (Entry entry : this.platformSpecificJson.entrySet()) {
                appLayoutsMapper.platformToLayoutMap.put((String) entry.getKey(), (Map) p.a((String) entry.getValue(), type));
            }
            return appLayoutsMapper;
        }
    }

    public Map<String, Integer> getPlatformResources(String str) {
        if (!this.platformToLayoutMap.containsKey(str)) {
            return Collections.EMPTY_MAP;
        }
        Map map = (Map) this.platformToLayoutMap.get(str);
        if (map.containsKey(RESOURCES_KEY)) {
            return (Map) map.get(RESOURCES_KEY);
        }
        return Collections.EMPTY_MAP;
    }

    public AppLayoutsMapper deserialize(l lVar, Type type, j jVar) {
        AppLayoutsMapper appLayoutsMapper = new AppLayoutsMapper();
        appLayoutsMapper.platformToLayoutMap.putAll((Map) jVar.a(lVar, new g<Map<String, Map<String, Map<String, Integer>>>>() {
        }.getType()));
        return appLayoutsMapper;
    }

    public static AppLayoutsMapper from(String str) {
        return (AppLayoutsMapper) p.a(str, AppLayoutsMapper.class, new com.google.b.g().a(AppLayoutsMapper.class, new AppLayoutsMapper()).c());
    }

    public String toString() {
        return p.a(this.platformToLayoutMap);
    }

    Map<String, Map<String, Map<String, Integer>>> getPlatformToLayoutMap() {
        return this.platformToLayoutMap;
    }
}
