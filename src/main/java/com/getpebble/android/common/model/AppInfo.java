package com.getpebble.android.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.getpebble.android.common.b.a.f;
import com.google.a.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public class AppInfo implements Parcelable {
    private static final String CAPABILITY_CONFIGURABLE = "configurable";
    private static final String CAPABILITY_LOCATION = "location";
    public static final Creator<AppInfo> CREATOR = new Creator<AppInfo>() {
        public AppInfo createFromParcel(Parcel parcel) {
            return new AppInfo(parcel);
        }

        public AppInfo[] newArray(int i) {
            return new AppInfo[i];
        }
    };
    private static final String TAG = "AppInfo";
    private Map<String, e> appKeys;
    private String[] capabilities;
    private String companyName;
    private String longName;
    private String sdkVersion;
    private String shortName;
    private String[] targetPlatforms;
    private UUID uuid;
    private float versionCode;
    private String versionLabel;
    private Watchapp watchapp = new Watchapp();

    public static class Watchapp {
        private boolean hiddenApp;
        private boolean onlyShownOnCommunication;
        private boolean watchface;
    }

    public String getLongName() {
        return this.longName;
    }

    public String getShortName() {
        return this.shortName;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public float getVersionCode() {
        return this.versionCode;
    }

    public String getVersionLabel() {
        return this.versionLabel;
    }

    public String[] getCapabilities() {
        return this.capabilities;
    }

    private boolean hasCapability(String str) {
        if (this.capabilities == null) {
            return false;
        }
        for (Object equals : this.capabilities) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String[] getTargetPlatforms() {
        return this.targetPlatforms;
    }

    public boolean isConfigurable() {
        return hasCapability(CAPABILITY_CONFIGURABLE);
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public boolean isWatchFace() {
        if (this.watchapp != null) {
            return this.watchapp.watchface;
        }
        f.b(TAG, "isWatchFace: watchapp is null");
        return false;
    }

    public boolean isHiddenApp() {
        if (this.watchapp != null) {
            return this.watchapp.hiddenApp;
        }
        f.b(TAG, "isHiddenApp: watchapp is null");
        return false;
    }

    public boolean isOnlyShownOnCommunication() {
        if (this.watchapp != null) {
            return this.watchapp.onlyShownOnCommunication;
        }
        f.b(TAG, "isOnlyShownOnCommunication: watchapp is null");
        return false;
    }

    public Map<String, e> getAppKeys() {
        return this.appKeys;
    }

    static void writeAppKeysToParcel(Parcel parcel, Map<String, e> map) {
        if (map == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(map.size());
        for (Entry entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeLong(((e) entry.getValue()).longValue());
        }
    }

    static Map<String, e> getAppKeysFromParcel(Parcel parcel) {
        Map<String, e> hashMap = new HashMap();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), e.a(parcel.readLong()));
        }
        return hashMap;
    }

    public AppInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.uuid = UUID.fromString(parcel.readString());
        this.shortName = parcel.readString();
        this.longName = parcel.readString();
        this.companyName = parcel.readString();
        this.versionLabel = parcel.readString();
        this.sdkVersion = parcel.readString();
        this.targetPlatforms = parcel.createStringArray();
        this.watchapp.watchface = parcel.readInt() == 1;
        Watchapp watchapp = this.watchapp;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        watchapp.hiddenApp = z;
        Watchapp watchapp2 = this.watchapp;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        watchapp2.onlyShownOnCommunication = z2;
        this.capabilities = parcel.createStringArray();
        this.appKeys = getAppKeysFromParcel(parcel);
        this.versionCode = parcel.readFloat();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.uuid.toString());
        parcel.writeString(this.shortName);
        parcel.writeString(this.longName);
        parcel.writeString(this.companyName);
        parcel.writeString(this.versionLabel);
        parcel.writeString(this.sdkVersion);
        parcel.writeStringArray(this.targetPlatforms);
        if (this.watchapp == null) {
            this.watchapp = new Watchapp();
        }
        parcel.writeInt(this.watchapp.watchface ? 1 : 0);
        if (this.watchapp.hiddenApp) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.watchapp.onlyShownOnCommunication) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeStringArray(this.capabilities);
        writeAppKeysToParcel(parcel, this.appKeys);
        parcel.writeFloat(this.versionCode);
    }
}
