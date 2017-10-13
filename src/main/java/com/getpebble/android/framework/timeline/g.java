package com.getpebble.android.framework.timeline;

import android.text.TextUtils;
import com.getpebble.android.common.model.timeline.c.a;
import com.getpebble.android.h.p;
import com.google.b.a.c;

public class g {
    public static final String CALENDAR_PIN = "calendarPin";
    public static final String COMM_NOTIFICATION = "commNotification";
    public static final String GENERIC_NOTIFICATION = "genericNotification";
    public static final String GENERIC_PIN = "genericPin";
    public static final String GENERIC_REMINDER = "genericReminder";
    public static final String WEATHER_PIN = "weatherPin";
    @c(a = "layout_name")
    private String mLayoutName;
    @c(a = "attributes")
    private e[] mTimelineAttributes;

    public g(String str, f fVar) {
        this.mLayoutName = str;
        this.mTimelineAttributes = fVar.toArray();
    }

    public static g from(a aVar) {
        return new g(aVar.a, f.from(aVar.b));
    }

    public String toJson() {
        return p.a(this);
    }

    public String getLayoutName() {
        return this.mLayoutName;
    }

    public e[] getAttributes() {
        return this.mTimelineAttributes;
    }

    public String toString() {
        return "[TimelineLayout: mLayoutName = " + this.mLayoutName + ", mTimelineAttributes = " + (this.mTimelineAttributes == null ? null : TextUtils.join(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR, this.mTimelineAttributes)) + "]";
    }
}
