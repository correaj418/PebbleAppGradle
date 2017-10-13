package com.getpebble.android.framework.firmware;

import android.app.Activity;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ak.a;

public class b {
    public static boolean a() {
        return a(PebbleApplication.r());
    }

    public static boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        f.e("FirmwareUtil", "doesWatchNeedMigration: pebbleDeviceRecord = " + aVar);
        if (aVar.hwPlatform.getPlatformCode() != com.getpebble.android.common.framework.install.app.b.a.APLITE || aVar.getFwVersion().getMajor() >= 3) {
            return false;
        }
        return true;
    }

    public static boolean b() {
        return false;
    }

    public static void a(Activity activity) {
        if (b()) {
            Toast.makeText(activity, R.string.skipped_firmware_update, 0).show();
        }
    }
}
