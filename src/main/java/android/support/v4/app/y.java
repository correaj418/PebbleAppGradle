package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class y {
    public static Intent a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static void a(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }

    public static String a(ActivityInfo activityInfo) {
        return activityInfo.parentActivityName;
    }
}
