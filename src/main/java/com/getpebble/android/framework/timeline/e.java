package com.getpebble.android.framework.timeline;

import android.util.SparseArray;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.an;
import com.google.b.i;
import com.google.b.l;
import com.google.b.r;
import java.util.ArrayList;
import java.util.Iterator;

public class e {
    public static final String ATTRIBUTE_ARRAY_VALUE_SEPARATOR = ", ";
    private static final String TAG = "TimelineAttribute";
    public static SparseArray<b> WEATHER_ICON_RESOURCE_MAP = new SparseArray();
    public static SparseArray<d> WEATHER_ICON_TYPE_MAP = new SparseArray();
    @com.google.b.a.c(a = "attribute_name")
    private String attributeName;
    @com.google.b.a.c(a = "attribute_value")
    private l attributeValue;

    public enum a {
        NONE("none", 0),
        RECURRING("recurring", 1);
        
        final int mIntValue;
        final String mStringValue;

        private a(String str, int i) {
            this.mStringValue = str;
            this.mIntValue = i;
        }

        public String getStringValue() {
            return this.mStringValue;
        }

        public int getIntValue() {
            return this.mIntValue;
        }

        public static a from(String str) {
            for (a aVar : values()) {
                if (aVar.getStringValue().equals(str)) {
                    return aVar;
                }
            }
            f.a(e.TAG, "No DisplayRecurring instance found with string value: " + str);
            return null;
        }

        public static a from(int i) {
            for (a aVar : values()) {
                if (aVar.getIntValue() == i) {
                    return aVar;
                }
            }
            f.a(e.TAG, "No DisplayRecurring instance found with int value: " + i);
            return null;
        }

        public static a from(boolean z) {
            return z ? RECURRING : NONE;
        }
    }

    public enum b {
        CALENDAR_ICON("system://images/TIMELINE_CALENDAR"),
        WEATHER_ICON("system://images/TIMELINE_WEATHER"),
        WEATHER_CLOUDY_DAY("system://images/CLOUDY_DAY"),
        WEATHER_PARTLY_CLOUDY("system://images/PARTLY_CLOUDY"),
        WEATHER_LIGHT_SNOW("system://images/LIGHT_SNOW"),
        WEATHER_LIGHT_RAIN("system://images/LIGHT_RAIN"),
        WEATHER_SUN("system://images/TIMELINE_SUN"),
        WEATHER_HEAVY_RAIN("system://images/HEAVY_RAIN"),
        WEATHER_HEAVY_SNOW("system://images/HEAVY_SNOW"),
        ACTION_RESULT_MUTE("system://images/RESULT_MUTE"),
        ACTION_RESULT_UNMUTE("system://images/RESULT_UNMUTE"),
        ACTION_RESULT_DISMISS("system://images/RESULT_DISMISSED"),
        ACTION_RESULT_REMOVED("system://images/RESULT_DELETED"),
        ACTION_RESULT_SENT("system://images/RESULT_SENT"),
        ACTION_RESULT_OPENED_ON_PHONE("system://images/DURING_PHONE_CALL"),
        ACTION_RESULT_DONE("system://images/GENERIC_CONFIRMATION"),
        TIMELINE_MISSED_CALL("system://images/TIMELINE_MISSED_CALL"),
        NOTIFICATION_REMINDER("system://images/NOTIFICATION_REMINDER"),
        NOTIFICATION_GENERIC("system://images/NOTIFICATION_GENERIC"),
        NOTIFICATION_FACEBOOK("system://images/NOTIFICATION_FACEBOOK"),
        NOTIFICATION_FACEBOOK_MESSENGER("system://images/NOTIFICATION_FACEBOOK_MESSENGER"),
        NOTIFICATION_GMAIL("system://images/NOTIFICATION_GMAIL"),
        NOTIFICATION_GOOGLE_HANGOUTS("system://images/NOTIFICATION_GOOGLE_HANGOUTS"),
        NOTIFICATION_GOOGLE_MESSENGER("system://images/NOTIFICATION_GOOGLE_MESSENGER"),
        NOTIFICATION_TELEGRAM("system://images/NOTIFICATION_TELEGRAM"),
        NOTIFICATION_TWITTER("system://images/NOTIFICATION_TWITTER"),
        NOTIFICATION_WHATSAPP("system://images/NOTIFICATION_WHATSAPP"),
        NOTIFICATION_MAILBOX("system://images/NOTIFICATION_MAILBOX"),
        NOTIFICATION_BLACKBERRY_MESSENGER("system://images/NOTIFICATION_BLACKBERRY_MESSENGER"),
        NOTIFICATION_GOOGLE_INBOX("system://images/NOTIFICATION_GOOGLE_INBOX"),
        NOTIFICATION_INSTAGRAM("system://images/NOTIFICATION_INSTAGRAM"),
        NOTIFICATION_HIPCHAT("system://images/NOTIFICATION_HIPCHAT"),
        NOTIFICATION_KIK("system://images/NOTIFICATION_KIK"),
        NOTIFICATION_VIBER("system://images/NOTIFICATION_VIBER"),
        NOTIFICATION_WECHAT("system://images/NOTIFICATION_WECHAT"),
        NOTIFICATION_SNAPCHAT("system://images/NOTIFICATION_SNAPCHAT"),
        NOTIFICATION_SKYPE("system://images/NOTIFICATION_SKYPE"),
        NOTIFICATION_LINE("system://images/NOTIFICATION_LINE"),
        NOTIFICATION_OUTLOOK("system://images/NOTIFICATION_OUTLOOK"),
        NOTIFICATION_KAKAOTALK("system://images/NOTIFICATION_KAKAOTALK"),
        NOTIFICATION_YAHOO_MAIL("system://images/NOTIFICATION_YAHOO_MAIL"),
        NOTIFICATION_GENERIC_EMAIL("system://images/GENERIC_EMAIL"),
        NOTIFICATION_GENERIC_SMS("system://images/GENERIC_SMS"),
        NOTIFICATION_AMAZON("system://images/NOTIFICATION_AMAZON"),
        NOTIFICATION_GOOGLE_MAPS("system://images/NOTIFICATION_GOOGLE_MAPS"),
        NOTIFICATION_GOOGLE_PHOTOS("system://images/NOTIFICATION_GOOGLE_PHOTOS"),
        NOTIFICATION_LINKEDIN("system://images/NOTIFICATION_LINKEDIN"),
        NOTIFICATION_SLACK("system://images/NOTIFICATION_SLACK");
        
        final String uriString;

        private b(String str) {
            this.uriString = str;
        }

        public String getSerializedName() {
            return this.uriString;
        }

        public static b from(String str) {
            for (b bVar : values()) {
                if (bVar.uriString.equals(str)) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public enum c {
        TITLE_KEY(an.TITLE),
        SUBTITLE_KEY("subtitle"),
        SHORT_TITLE_KEY("shortTitle"),
        BODY_KEY(an.BODY),
        TINY_ICON("tinyIcon"),
        SMALL_ICON("smallIcon"),
        LARGE_ICON("largeIcon"),
        CANNED_RESPONSE("cannedResponse"),
        LOCATION_NAME("locationName"),
        SENDER("sender"),
        LAST_UPDATED("lastUpdated"),
        LAUNCH_CODE("launchCode"),
        BACKGROUND_COLOR("backgroundColor"),
        HEADINGS("headings"),
        PARAGRAPHS("paragraphs"),
        TIMESTAMP("timestamp"),
        DISPLAY_RECURRING("displayRecurring"),
        SUBTITLE_TEMPLATE_STRING("subtitleTemplateString"),
        ICON("icon");
        
        final String serializedName;

        private c(String str) {
            this.serializedName = str;
        }

        public String getSerializedName() {
            return this.serializedName;
        }
    }

    public enum d {
        PARTLY_CLOUDY(0),
        CLOUDY_DAY(1),
        LIGHT_SNOW(2),
        LIGHT_RAIN(3),
        HEAVY_RAIN(4),
        HEAVY_SNOW(5),
        WEATHER_ICON(6),
        SUN(7),
        RAIN_AND_SNOW(8),
        UNKNOWN(255);
        
        private final int value;

        private d(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        public static d from(int i) {
            for (d dVar : values()) {
                if (dVar.value == i) {
                    return dVar;
                }
            }
            return null;
        }
    }

    public e(String str, l lVar) {
        this.attributeName = str;
        this.attributeValue = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.attributeName == null ? eVar.attributeName != null : !this.attributeName.equals(eVar.attributeName)) {
            return false;
        }
        if (this.attributeValue != null) {
            return this.attributeValue.equals(eVar.attributeValue);
        }
        if (eVar.attributeValue != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.attributeName != null) {
            hashCode = this.attributeName.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.attributeValue != null) {
            i = this.attributeValue.hashCode();
        }
        return hashCode + i;
    }

    public void setValue(String str) {
        this.attributeValue = new r(str);
    }

    public String getName() {
        return this.attributeName;
    }

    public l getValue() {
        return this.attributeValue;
    }

    public String toString() {
        return "TimelineAttribute[ attributeName = " + this.attributeName + ", attributeValue = " + this.attributeValue + "]";
    }

    public String getValueAsString() {
        if (this.attributeValue.j()) {
            return this.attributeValue.c();
        }
        if (this.attributeValue.h()) {
            i iVar = (i) this.attributeValue;
            Iterable arrayList = new ArrayList(iVar.a());
            Iterator it = iVar.iterator();
            while (it.hasNext()) {
                arrayList.add(((l) it.next()).c());
            }
            return com.google.a.a.f.a(ATTRIBUTE_ARRAY_VALUE_SEPARATOR).a(arrayList);
        }
        throw new IllegalStateException();
    }

    static {
        WEATHER_ICON_RESOURCE_MAP.put(0, b.WEATHER_HEAVY_RAIN);
        WEATHER_ICON_RESOURCE_MAP.put(1, b.WEATHER_HEAVY_RAIN);
        WEATHER_ICON_RESOURCE_MAP.put(2, b.WEATHER_HEAVY_RAIN);
        WEATHER_ICON_RESOURCE_MAP.put(3, b.WEATHER_HEAVY_RAIN);
        WEATHER_ICON_RESOURCE_MAP.put(4, b.WEATHER_HEAVY_RAIN);
        WEATHER_ICON_RESOURCE_MAP.put(5, b.WEATHER_LIGHT_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(6, b.WEATHER_LIGHT_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(7, b.WEATHER_LIGHT_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(8, b.WEATHER_LIGHT_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(9, b.WEATHER_LIGHT_RAIN);
        WEATHER_ICON_RESOURCE_MAP.put(10, b.WEATHER_LIGHT_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(11, b.WEATHER_LIGHT_RAIN);
        WEATHER_ICON_RESOURCE_MAP.put(12, b.WEATHER_HEAVY_RAIN);
        WEATHER_ICON_RESOURCE_MAP.put(13, b.WEATHER_LIGHT_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(14, b.WEATHER_LIGHT_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(15, b.WEATHER_HEAVY_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(16, b.WEATHER_HEAVY_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(17, b.WEATHER_HEAVY_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(18, b.WEATHER_LIGHT_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(19, b.WEATHER_CLOUDY_DAY);
        WEATHER_ICON_RESOURCE_MAP.put(20, b.WEATHER_CLOUDY_DAY);
        WEATHER_ICON_RESOURCE_MAP.put(21, b.WEATHER_CLOUDY_DAY);
        WEATHER_ICON_RESOURCE_MAP.put(22, b.WEATHER_CLOUDY_DAY);
        WEATHER_ICON_RESOURCE_MAP.put(23, b.WEATHER_ICON);
        WEATHER_ICON_RESOURCE_MAP.put(24, b.WEATHER_ICON);
        WEATHER_ICON_RESOURCE_MAP.put(25, b.WEATHER_ICON);
        WEATHER_ICON_RESOURCE_MAP.put(26, b.WEATHER_CLOUDY_DAY);
        WEATHER_ICON_RESOURCE_MAP.put(27, b.WEATHER_CLOUDY_DAY);
        WEATHER_ICON_RESOURCE_MAP.put(28, b.WEATHER_CLOUDY_DAY);
        WEATHER_ICON_RESOURCE_MAP.put(29, b.WEATHER_PARTLY_CLOUDY);
        WEATHER_ICON_RESOURCE_MAP.put(30, b.WEATHER_PARTLY_CLOUDY);
        WEATHER_ICON_RESOURCE_MAP.put(31, b.WEATHER_SUN);
        WEATHER_ICON_RESOURCE_MAP.put(32, b.WEATHER_SUN);
        WEATHER_ICON_RESOURCE_MAP.put(33, b.WEATHER_SUN);
        WEATHER_ICON_RESOURCE_MAP.put(34, b.WEATHER_SUN);
        WEATHER_ICON_RESOURCE_MAP.put(35, b.WEATHER_LIGHT_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(36, b.WEATHER_SUN);
        WEATHER_ICON_RESOURCE_MAP.put(37, b.WEATHER_HEAVY_RAIN);
        WEATHER_ICON_RESOURCE_MAP.put(38, b.WEATHER_HEAVY_RAIN);
        WEATHER_ICON_RESOURCE_MAP.put(39, b.WEATHER_HEAVY_RAIN);
        WEATHER_ICON_RESOURCE_MAP.put(40, b.WEATHER_HEAVY_RAIN);
        WEATHER_ICON_RESOURCE_MAP.put(41, b.WEATHER_HEAVY_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(42, b.WEATHER_HEAVY_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(43, b.WEATHER_HEAVY_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(44, b.WEATHER_ICON);
        WEATHER_ICON_RESOURCE_MAP.put(45, b.WEATHER_LIGHT_RAIN);
        WEATHER_ICON_RESOURCE_MAP.put(46, b.WEATHER_LIGHT_SNOW);
        WEATHER_ICON_RESOURCE_MAP.put(47, b.WEATHER_HEAVY_RAIN);
        WEATHER_ICON_TYPE_MAP.put(0, d.HEAVY_RAIN);
        WEATHER_ICON_TYPE_MAP.put(1, d.HEAVY_RAIN);
        WEATHER_ICON_TYPE_MAP.put(2, d.HEAVY_RAIN);
        WEATHER_ICON_TYPE_MAP.put(3, d.HEAVY_RAIN);
        WEATHER_ICON_TYPE_MAP.put(4, d.HEAVY_RAIN);
        WEATHER_ICON_TYPE_MAP.put(5, d.LIGHT_SNOW);
        WEATHER_ICON_TYPE_MAP.put(6, d.LIGHT_SNOW);
        WEATHER_ICON_TYPE_MAP.put(7, d.LIGHT_SNOW);
        WEATHER_ICON_TYPE_MAP.put(8, d.LIGHT_SNOW);
        WEATHER_ICON_TYPE_MAP.put(9, d.LIGHT_RAIN);
        WEATHER_ICON_TYPE_MAP.put(10, d.LIGHT_SNOW);
        WEATHER_ICON_TYPE_MAP.put(11, d.LIGHT_RAIN);
        WEATHER_ICON_TYPE_MAP.put(12, d.HEAVY_RAIN);
        WEATHER_ICON_TYPE_MAP.put(13, d.LIGHT_SNOW);
        WEATHER_ICON_TYPE_MAP.put(14, d.LIGHT_SNOW);
        WEATHER_ICON_TYPE_MAP.put(15, d.HEAVY_SNOW);
        WEATHER_ICON_TYPE_MAP.put(16, d.HEAVY_SNOW);
        WEATHER_ICON_TYPE_MAP.put(17, d.HEAVY_SNOW);
        WEATHER_ICON_TYPE_MAP.put(18, d.LIGHT_SNOW);
        WEATHER_ICON_TYPE_MAP.put(19, d.CLOUDY_DAY);
        WEATHER_ICON_TYPE_MAP.put(20, d.CLOUDY_DAY);
        WEATHER_ICON_TYPE_MAP.put(21, d.CLOUDY_DAY);
        WEATHER_ICON_TYPE_MAP.put(22, d.CLOUDY_DAY);
        WEATHER_ICON_TYPE_MAP.put(23, d.WEATHER_ICON);
        WEATHER_ICON_TYPE_MAP.put(24, d.WEATHER_ICON);
        WEATHER_ICON_TYPE_MAP.put(25, d.WEATHER_ICON);
        WEATHER_ICON_TYPE_MAP.put(26, d.CLOUDY_DAY);
        WEATHER_ICON_TYPE_MAP.put(27, d.CLOUDY_DAY);
        WEATHER_ICON_TYPE_MAP.put(28, d.CLOUDY_DAY);
        WEATHER_ICON_TYPE_MAP.put(29, d.PARTLY_CLOUDY);
        WEATHER_ICON_TYPE_MAP.put(30, d.PARTLY_CLOUDY);
        WEATHER_ICON_TYPE_MAP.put(31, d.SUN);
        WEATHER_ICON_TYPE_MAP.put(32, d.SUN);
        WEATHER_ICON_TYPE_MAP.put(33, d.SUN);
        WEATHER_ICON_TYPE_MAP.put(34, d.SUN);
        WEATHER_ICON_TYPE_MAP.put(35, d.LIGHT_SNOW);
        WEATHER_ICON_TYPE_MAP.put(36, d.SUN);
        WEATHER_ICON_TYPE_MAP.put(37, d.HEAVY_RAIN);
        WEATHER_ICON_TYPE_MAP.put(38, d.HEAVY_RAIN);
        WEATHER_ICON_TYPE_MAP.put(39, d.HEAVY_RAIN);
        WEATHER_ICON_TYPE_MAP.put(40, d.HEAVY_RAIN);
        WEATHER_ICON_TYPE_MAP.put(41, d.HEAVY_SNOW);
        WEATHER_ICON_TYPE_MAP.put(42, d.HEAVY_SNOW);
        WEATHER_ICON_TYPE_MAP.put(43, d.HEAVY_SNOW);
        WEATHER_ICON_TYPE_MAP.put(44, d.WEATHER_ICON);
        WEATHER_ICON_TYPE_MAP.put(45, d.LIGHT_RAIN);
        WEATHER_ICON_TYPE_MAP.put(46, d.LIGHT_SNOW);
        WEATHER_ICON_TYPE_MAP.put(47, d.HEAVY_RAIN);
    }
}
