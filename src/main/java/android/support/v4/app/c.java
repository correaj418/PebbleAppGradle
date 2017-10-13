package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

class c {
    public static void a(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }
}
