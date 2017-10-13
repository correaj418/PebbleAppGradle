package com.getpebble.android.common.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.h.s;
import com.getpebble.android.main.activity.MainActivity;
import com.getpebble.android.main.sections.support.activity.FirmwareUpdateActivity;
import com.getpebble.android.notifications.b.d;
import com.getpebble.android.notifications.b.f;

public enum a {
    NOTIFICATION_LISTENER(1, 1, R.string.enable_now, NO_ID, R.string.enable_notifications_dialog_title, R.string.enable_notifications_dialog_text) {
        public void enable(Context context) {
            new d(MainActivity.class).a();
            f.b(context);
        }
    },
    ANDROID_WEAR(2, 2, R.string.install_now, R.string.ignore_android_wear, R.string.pref_title_install_wear, R.string.pref_summary_install_wear) {
        public void enable(Context context) {
            openAppOnGooglePlay(context, "com.google.android.wearable.app");
        }

        public void disable(Context context) {
            new c(context).b(com.getpebble.android.common.b.b.c.a.ANDROID_WEAR_OPTOUT, true);
        }
    },
    FW_UPDATE(3, 3, R.string.update_now, NO_ID, R.string.my_pebble_firmware_update_available, R.string.my_pebble_ask_install_new_firmware) {
        public void enable(Context context) {
            performFwUpdate(context);
        }
    },
    APP_UPDATE(4, 4, R.string.update_now, NO_ID, R.string.app_update_available, R.string.app_update_available) {
        public void enable(Context context) {
            s.a();
        }
    },
    UNKNOWN(0, NO_ID, NO_ID, NO_ID, NO_ID, NO_ID) {
        public void enable(Context context) {
        }
    };
    
    private static final int NO_ID = -1;
    private static final String TAG = "AlertType";
    public final int descriptionResId;
    public final int id;
    public final int negButtonResId;
    public final int posButtonResId;
    public final int priority;
    public final int titleResId;

    public abstract void enable(Context context);

    private a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.id = i;
        this.priority = i2;
        this.posButtonResId = i3;
        this.negButtonResId = i4;
        this.titleResId = i5;
        this.descriptionResId = i6;
    }

    public int getActionIdPositive() {
        return this.posButtonResId;
    }

    public boolean hasNegativeAction() {
        return this.negButtonResId != NO_ID;
    }

    public int getActionIdNegative() {
        if (hasNegativeAction()) {
            return this.negButtonResId;
        }
        throw new UnsupportedOperationException("AlertType: " + name() + " does not have negative action string.");
    }

    public static a from(int i) {
        for (a aVar : values()) {
            if (aVar.id == i) {
                return aVar;
            }
        }
        return UNKNOWN;
    }

    void openAppOnGooglePlay(Context context, String str) {
        boolean z = false;
        try {
            z = launchGooglePlayApp(context, str);
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.b(TAG, "openAppOnGooglePlay", e);
        }
        if (!z) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
            intent.setFlags(335544320);
            context.startActivity(intent);
        }
    }

    private boolean launchGooglePlayApp(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.applicationInfo.packageName.equals("com.android.vending")) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent.setFlags(335544320);
                intent.setComponent(componentName);
                context.startActivity(intent);
                return true;
            }
        }
        return false;
    }

    void performFwUpdate(Context context) {
        Intent intent = new Intent(context, FirmwareUpdateActivity.class);
        intent.setFlags(335544320);
        context.startActivity(intent);
    }

    public void disable(Context context) {
    }
}
