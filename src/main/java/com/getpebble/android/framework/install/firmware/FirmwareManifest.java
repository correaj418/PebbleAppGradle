package com.getpebble.android.framework.install.firmware;

import com.getpebble.android.common.framework.install.PebbleManifest;
import com.getpebble.android.common.framework.install.PebbleManifest.ResourceInfo;
import com.getpebble.android.common.model.l;
import com.getpebble.android.common.model.z;
import com.google.b.a.c;

public class FirmwareManifest extends PebbleManifest {
    private FirmwareInfo firmware;

    public static class FirmwareInfo extends ResourceInfo {
        @c(a = "hwrev")
        private String hardwareRevision;
        private String type;
        @c(a = "versionTag")
        private String versionTag;

        protected FirmwareInfo() {
        }

        public z getHardwareRevision() {
            return l.a(this.hardwareRevision);
        }

        public FirmwareType getType() {
            return FirmwareType.fromName(this.type);
        }

        public String getVersionTag() {
            return this.versionTag;
        }
    }

    public enum FirmwareType {
        NORMAL("normal"),
        RECOVERY("recovery"),
        SAFE("safe"),
        MIGRATION_3X("3.x-migration");
        
        public final String mTypeName;

        private FirmwareType(String str) {
            this.mTypeName = str;
        }

        public static FirmwareType fromName(String str) {
            for (FirmwareType firmwareType : values()) {
                if (firmwareType.mTypeName.equals(str)) {
                    return firmwareType;
                }
            }
            return null;
        }
    }

    protected FirmwareManifest() {
    }

    public FirmwareInfo getFirmware() {
        return this.firmware;
    }
}
