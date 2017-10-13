package com.getpebble.android.framework.firmware;

import android.content.ContentValues;
import android.text.TextUtils;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.a;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.l;
import com.getpebble.android.common.model.v;
import com.getpebble.android.common.model.z;
import com.google.a.f.e;
import com.google.b.a.c;

public class FirmwareManifestBundle {
    public static final String TAG = "FirmwareManifestBundle";
    private FirmwareMetadata m3xMigrationMetadata;
    private z mHardwarePlatform;
    private int mId;
    private FirmwareMetadata mNormalMetadata;
    private FirmwareMetadata mRecoveryMetadata;

    public class FirmwareMetadata {
        private String friendlyVersion;
        private String notes;
        @c(a = "sha-256")
        private String sha256;
        private long timestamp;
        private String url;

        public String getUrl() {
            return this.url;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public String getNotes() {
            return this.notes;
        }

        public v getFriendlyVersion() {
            return new v(this.friendlyVersion, this.timestamp);
        }

        public String getSha256() {
            return this.sha256;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setTimestamp(long j) {
            this.timestamp = j;
        }

        public void setNotes(String str) {
            this.notes = str;
        }

        public void setFriendlyVersion(String str) {
            this.friendlyVersion = str;
        }

        public void setSha256(String str) {
            this.sha256 = str;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof FirmwareMetadata)) {
                return false;
            }
            FirmwareMetadata firmwareMetadata = (FirmwareMetadata) obj;
            if (a.a(this.url, firmwareMetadata.url) && this.timestamp == firmwareMetadata.timestamp && a.a(this.notes, firmwareMetadata.notes) && a.a(this.friendlyVersion, firmwareMetadata.friendlyVersion) && a.a(this.sha256, firmwareMetadata.sha256)) {
                return true;
            }
            return false;
        }

        public boolean isInvalid() {
            return TextUtils.isEmpty(this.url) || TextUtils.isEmpty(this.friendlyVersion) || TextUtils.isEmpty(this.sha256);
        }

        public String toString() {
            return "FirmwareMetadata[ notes = " + this.notes + ", friendlyVersion = " + this.friendlyVersion + ", timestamp = " + this.timestamp + ", sha256 = " + this.sha256 + ", url = " + this.url + "]";
        }
    }

    public FirmwareManifestBundle(z zVar) {
        this.mHardwarePlatform = zVar;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setRecoveryMetadata(FirmwareMetadata firmwareMetadata) {
        this.mRecoveryMetadata = firmwareMetadata;
    }

    public void setNormalMetadata(FirmwareMetadata firmwareMetadata) {
        this.mNormalMetadata = firmwareMetadata;
    }

    public void set3xMigrationMetadata(FirmwareMetadata firmwareMetadata) {
        this.m3xMigrationMetadata = firmwareMetadata;
    }

    public int getId() {
        return this.mId;
    }

    public z getHardwarePlatform() {
        return this.mHardwarePlatform;
    }

    public FirmwareMetadata getRecoveryMetadata() {
        return this.mRecoveryMetadata;
    }

    public FirmwareMetadata getNormalMetadata() {
        return this.mNormalMetadata;
    }

    public FirmwareMetadata get3xMigrationMetadata() {
        return this.m3xMigrationMetadata;
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues(18);
        contentValues.put(ak.HW_PLATFORM, Integer.valueOf(getHardwarePlatform().getId()));
        if (getNormalMetadata() != null) {
            contentValues.put("normal_url", getNormalMetadata().getUrl());
            contentValues.put("normal_timestamp", Long.valueOf(getNormalMetadata().getTimestamp()));
            contentValues.put("normal_notes", getNormalMetadata().getNotes());
            if (getNormalMetadata().getFriendlyVersion() != null) {
                contentValues.put("normal_version", getNormalMetadata().getFriendlyVersion().toString());
            }
            contentValues.put("normal_SHA256", getNormalMetadata().getSha256());
        }
        if (getRecoveryMetadata() != null) {
            contentValues.put("recovery_url", getRecoveryMetadata().getUrl());
            contentValues.put("recovery_timestamp", Long.valueOf(getRecoveryMetadata().getTimestamp()));
            contentValues.put("recovery_notes", getRecoveryMetadata().getNotes());
            if (getRecoveryMetadata().getFriendlyVersion() != null) {
                contentValues.put("recovery_version", getRecoveryMetadata().getFriendlyVersion().toString());
            }
            contentValues.put("recovery_SHA256", getRecoveryMetadata().getSha256());
        }
        if (get3xMigrationMetadata() != null) {
            contentValues.put("migration_url", get3xMigrationMetadata().getUrl());
            contentValues.put("migration_timestamp", Long.valueOf(get3xMigrationMetadata().getTimestamp()));
            contentValues.put("migration_notes", get3xMigrationMetadata().getNotes());
            if (get3xMigrationMetadata().getFriendlyVersion() != null) {
                contentValues.put("migration_version", get3xMigrationMetadata().getFriendlyVersion().toString());
            }
            contentValues.put("migration_SHA256", get3xMigrationMetadata().getSha256());
        }
        return contentValues;
    }

    public static FirmwareManifestBundle fromContentValues(ContentValues contentValues) {
        FirmwareManifestBundle firmwareManifestBundle = new FirmwareManifestBundle(l.a(e.a(contentValues.getAsInteger(ak.HW_PLATFORM).intValue())));
        firmwareManifestBundle.getClass();
        FirmwareMetadata firmwareMetadata = new FirmwareMetadata();
        firmwareMetadata.setUrl(contentValues.getAsString("normal_url"));
        firmwareMetadata.setTimestamp(contentValues.getAsLong("normal_timestamp").longValue());
        firmwareMetadata.setNotes(contentValues.getAsString("normal_notes"));
        firmwareMetadata.setFriendlyVersion(contentValues.getAsString("normal_version"));
        firmwareMetadata.setSha256(contentValues.getAsString("normal_SHA256"));
        firmwareManifestBundle.getClass();
        FirmwareMetadata firmwareMetadata2 = new FirmwareMetadata();
        if (contentValues.get("recovery_url") != null) {
            firmwareMetadata2.setUrl(contentValues.getAsString("recovery_url"));
            firmwareMetadata2.setTimestamp(contentValues.getAsLong("recovery_timestamp").longValue());
            firmwareMetadata2.setNotes(contentValues.getAsString("recovery_notes"));
            firmwareMetadata2.setFriendlyVersion(contentValues.getAsString("recovery_version"));
            firmwareMetadata2.setSha256(contentValues.getAsString("recovery_SHA256"));
        }
        firmwareManifestBundle.getClass();
        FirmwareMetadata firmwareMetadata3 = new FirmwareMetadata();
        if (contentValues.get("migration_url") != null) {
            firmwareMetadata3.setUrl(contentValues.getAsString("migration_url"));
            firmwareMetadata3.setTimestamp(contentValues.getAsLong("migration_timestamp").longValue());
            firmwareMetadata3.setNotes(contentValues.getAsString("migration_notes"));
            firmwareMetadata3.setFriendlyVersion(contentValues.getAsString("migration_version"));
            firmwareMetadata3.setSha256(contentValues.getAsString("migration_SHA256"));
        }
        firmwareManifestBundle.setId(contentValues.getAsInteger(ai.COLUMN_ID).intValue());
        firmwareManifestBundle.setNormalMetadata(firmwareMetadata);
        firmwareManifestBundle.setRecoveryMetadata(firmwareMetadata2);
        firmwareManifestBundle.set3xMigrationMetadata(firmwareMetadata3);
        return firmwareManifestBundle;
    }

    public final FirmwareMetadata getFirmwareMetadataToInstall() {
        if (!b.a()) {
            return getNormalMetadata();
        }
        f.e(TAG, "getFirmwareMetadataToInstall: return the 3xMigrationMetadata");
        return get3xMigrationMetadata();
    }

    public final boolean is3xMigrationMetadata(FirmwareMetadata firmwareMetadata) {
        return firmwareMetadata.equals(get3xMigrationMetadata());
    }
}
