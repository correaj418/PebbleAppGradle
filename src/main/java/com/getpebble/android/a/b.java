package com.getpebble.android.a;

import android.content.Context;
import com.getpebble.android.common.a;
import com.getpebble.android.common.b.a.c;
import com.getpebble.android.common.b.a.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum b {
    INSTANCE;
    
    private com.getpebble.android.common.b.a.b mDeviceObserver;
    private Map<String, Object> mGlobalEventProperties;
    private boolean mInitalised;
    private h mUserObserver;

    public static void initialise() {
        if (INSTANCE.mInitalised) {
            throw new IllegalStateException("Cannot call initialize() more than once");
        }
        INSTANCE.mInitalised = true;
        INSTANCE.mGlobalEventProperties = new ConcurrentHashMap();
    }

    public static boolean isInitialised() {
        return INSTANCE.mInitalised;
    }

    public static void uninitialise() {
        INSTANCE.mInitalised = false;
        INSTANCE.mGlobalEventProperties = null;
    }

    public static Map<String, Object> getGlobalEventProperties() {
        if (INSTANCE.mInitalised) {
            return INSTANCE.mGlobalEventProperties;
        }
        throw new IllegalStateException("Cannot call getGlobalEventProperties() before calling initialise()");
    }

    public static void addDefaultProperties() {
        Context K = a.K();
        INSTANCE.mDeviceObserver = new com.getpebble.android.common.b.a.b();
        INSTANCE.mUserObserver = new h(K);
        c.a(a.K());
        Map orCreateChildMap = getOrCreateChildMap(getGlobalEventProperties(), "app");
        orCreateChildMap.put("version", "4.4.1-1404-01abd2f76-endframe");
        orCreateChildMap.put("version_code", Integer.valueOf(1404));
    }

    public static Map<String, Object> getOrCreateChildMap(Map<String, Object> map, String str) {
        if (map.containsKey(str)) {
            return (Map) map.get(str);
        }
        Map<String, Object> concurrentHashMap = new ConcurrentHashMap();
        map.put(str, concurrentHashMap);
        return concurrentHashMap;
    }
}
