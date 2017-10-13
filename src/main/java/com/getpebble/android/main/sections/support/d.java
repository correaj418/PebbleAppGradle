package com.getpebble.android.main.sections.support;

import android.content.Context;
import com.getpebble.android.basalt.R;

public enum d {
    HEALTH(R.string.pebble_health, R.string.health_support_email, R.id.pebble_health),
    CONNECTIVITY(R.string.connection_pairing, R.string.connect_support_email, R.id.connection_pairing),
    BATTERY(R.string.battery_life, R.string.battery_support_email, R.id.battery_life),
    NOTIFICATIONS(R.string.notification, R.string.notification_support_email, R.id.notification),
    OTHER(R.string.other, R.string.support_email, R.id.other);
    
    public final int menuId;
    public final int supportResId;
    public final int titleResId;

    private d(int i, int i2, int i3) {
        this.titleResId = i;
        this.supportResId = i2;
        this.menuId = i3;
    }

    public static d from(int i) {
        for (d dVar : values()) {
            if (dVar.menuId == i) {
                return dVar;
            }
        }
        return OTHER;
    }

    public static d from(Context context, String str) {
        for (d dVar : values()) {
            if (context.getString(dVar.titleResId).matches(str)) {
                return dVar;
            }
        }
        return OTHER;
    }

    public String getTitle(Context context) {
        return context.getString(this.titleResId);
    }

    public String getEmailAddress(Context context) {
        return context.getString(this.supportResId);
    }

    public boolean includeHealthData() {
        return this.titleResId == R.string.pebble_health;
    }
}
