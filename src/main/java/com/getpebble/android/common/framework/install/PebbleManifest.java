package com.getpebble.android.common.framework.install;

import com.google.a.f.e;

public abstract class PebbleManifest {
    private long generatedAt;
    private String generatedBy;
    private int manifestVersion;
    private ResourceInfo resources;
    private String type;

    public enum BundleType {
        FIRMWARE("firmware"),
        APPLICATION("application");
        
        String mTypeName;

        private BundleType(String str) {
            this.mTypeName = str;
        }

        public static BundleType fromName(String str) {
            for (BundleType bundleType : values()) {
                if (bundleType.mTypeName.equals(str)) {
                    return bundleType;
                }
            }
            return null;
        }
    }

    public static class ResourceInfo {
        private long crc;
        private String name;
        private int size;
        private long timestamp;

        protected ResourceInfo() {
        }

        public String getName() {
            return this.name;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public e getCrc() {
            return e.a(this.crc);
        }

        public int getSize() {
            return this.size;
        }
    }

    public int getManifestVersion() {
        return this.manifestVersion;
    }

    public ResourceInfo getResourceInfo() {
        return this.resources;
    }

    public String getGeneratedBy() {
        return this.generatedBy;
    }

    public long getGeneratedAt() {
        return this.generatedAt;
    }

    public BundleType getType() {
        return BundleType.fromName(this.type);
    }
}
