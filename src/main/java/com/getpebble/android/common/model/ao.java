package com.getpebble.android.common.model;

import android.content.ContentResolver;
import com.getpebble.android.common.a;
import com.getpebble.android.h.p;
import com.google.b.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ao implements j {
    public static final String BLOB_DB_KEY = "hrmPreferences";
    @c(a = "hrMonitoringEnabled")
    public boolean hrMonitoringEnabled = true;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.hrMonitoringEnabled != ((ao) obj).hrMonitoringEnabled) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.hrMonitoringEnabled ? 1 : 0;
    }

    public String getKey() {
        return BLOB_DB_KEY;
    }

    public String toJson() {
        return p.a(this);
    }

    public byte[] toBytes() {
        int i = 1;
        ByteBuffer order = ByteBuffer.allocate(1).order(ByteOrder.LITTLE_ENDIAN);
        if (!this.hrMonitoringEnabled) {
            i = 0;
        }
        return order.put((byte) i).array();
    }

    public static boolean isHRMEnabled() {
        return load(a.K().getContentResolver()).hrMonitoringEnabled;
    }

    public static ao load(ContentResolver contentResolver) {
        return (ao) ba.a(BLOB_DB_KEY, new ao(), contentResolver);
    }
}
