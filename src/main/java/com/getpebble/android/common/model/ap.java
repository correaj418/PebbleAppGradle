package com.getpebble.android.common.model;

import android.content.ContentResolver;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.h.p;
import com.google.b.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ap implements j {
    public static final String BLOB_DB_KEY = "activityPreferences";
    @c(a = "activityInsightsEnabled")
    public boolean activityInsightsEnabled;
    @c(a = "ageYears")
    public byte ageYears;
    @c(a = "gender")
    public a gender;
    @c(a = "heightMm")
    public int heightMm;
    @c(a = "sleepInsightsEnabled")
    public boolean sleepInsightsEnabled;
    @c(a = "trackingEnabled")
    public boolean trackingEnabled;
    @c(a = "weightDag")
    public int weightDag;

    public enum a {
        FEMALE(R.string.health_profile_gender_female, (byte) 0, "female"),
        MALE(R.string.health_profile_gender_male, (byte) 1, "male"),
        OTHER(R.string.health_profile_gender_other, (byte) 2, "other");
        
        public final String jsName;
        public final int nameResId;
        public final byte value;

        private a(int i, byte b, String str) {
            this.nameResId = i;
            this.value = b;
            this.jsName = str;
        }

        public static a fromValue(byte b) {
            for (a aVar : values()) {
                if (aVar.value == b) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ap apVar = (ap) obj;
        if (this.trackingEnabled != apVar.trackingEnabled || this.activityInsightsEnabled != apVar.activityInsightsEnabled || this.sleepInsightsEnabled != apVar.sleepInsightsEnabled || this.ageYears != apVar.ageYears || this.heightMm != apVar.heightMm || this.weightDag != apVar.weightDag) {
            return false;
        }
        if (this.gender != apVar.gender) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i;
        int i2 = 1;
        int i3 = 0;
        int i4 = (this.trackingEnabled ? 1 : 0) * 31;
        if (this.activityInsightsEnabled) {
            i = 1;
        } else {
            i = 0;
        }
        i = (i + i4) * 31;
        if (!this.sleepInsightsEnabled) {
            i2 = 0;
        }
        i = (((i + i2) * 31) + this.ageYears) * 31;
        if (this.gender != null) {
            i3 = this.gender.hashCode();
        }
        return ((((i + i3) * 31) + this.heightMm) * 31) + this.weightDag;
    }

    public String getKey() {
        return BLOB_DB_KEY;
    }

    public String toJson() {
        return p.a(this);
    }

    public byte[] toBytes() {
        int i;
        int i2 = 1;
        ByteBuffer put = ByteBuffer.allocate(9).order(ByteOrder.LITTLE_ENDIAN).put(b.a(this.heightMm)).put(b.a(this.weightDag));
        if (this.trackingEnabled) {
            i = 1;
        } else {
            i = 0;
        }
        put = put.put((byte) i);
        if (this.activityInsightsEnabled) {
            i = 1;
        } else {
            i = 0;
        }
        ByteBuffer put2 = put.put((byte) i);
        if (!this.sleepInsightsEnabled) {
            i2 = 0;
        }
        return put2.put((byte) i2).put(this.ageYears).put(this.gender != null ? this.gender.value : a.OTHER.value).array();
    }

    public static boolean isHealthEnabled() {
        return load(com.getpebble.android.common.a.K().getContentResolver()).trackingEnabled;
    }

    public static ap load(ContentResolver contentResolver) {
        return (ap) ba.a(BLOB_DB_KEY, new ap(), contentResolver);
    }
}
