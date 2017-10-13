package com.getpebble.android.common.framework.install.app;

import com.getpebble.android.common.framework.install.PebbleManifest;
import com.getpebble.android.common.framework.install.PebbleManifest.ResourceInfo;

public class AppManifest extends PebbleManifest {
    private a application;
    @com.google.b.a.c(a = "app_layouts")
    private String layoutFileName;
    private c worker;

    public static abstract class b extends ResourceInfo {
        @com.google.b.a.c(a = "sdk_version")
        private com.getpebble.android.common.d.c a;

        public com.getpebble.android.common.d.c a() {
            return this.a;
        }
    }

    public static class a extends b {
    }

    public static class c extends b {
    }

    public a getAppInfo() {
        return this.application;
    }

    public c getWorker() {
        return this.worker;
    }

    public boolean hasWorker() {
        return getWorker() != null;
    }

    public String getAppLayoutsFilename() {
        return this.layoutFileName;
    }
}
