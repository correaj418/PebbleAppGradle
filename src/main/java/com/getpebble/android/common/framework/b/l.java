package com.getpebble.android.common.framework.b;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ac;
import android.support.v4.app.ac.t;
import android.support.v7.a.c;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.v;
import com.getpebble.android.framework.firmware.FirmwareManifestBundle;
import com.getpebble.android.main.sections.support.activity.FirmwareUpdateActivity;

public class l {
    private final PebbleDevice a;
    private final v b;
    private FirmwareManifestBundle c;

    public l(PebbleDevice pebbleDevice, v vVar) {
        this.a = pebbleDevice;
        this.b = vVar;
    }

    public boolean a() {
        return false;
    }

    public void b() {
        if (this.c == null) {
            f.d("FirmwareUpdateNotification", "show(): Short-circuiting because there is no FW bundle.");
            return;
        }
        Context K = a.K();
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent(K, FirmwareUpdateActivity.class);
        intent.putExtra("extra_firmware_notes", this.c.getNormalMetadata().getNotes());
        intent.putExtra("extra_firmware_url", this.c.getNormalMetadata().getUrl());
        intent.putExtra("extra_fw_update_timestamp", currentTimeMillis);
        intent.putExtra("extra_fw_3x_migration", false);
        PendingIntent activity = PendingIntent.getActivity(K, 0, intent, 134217728);
        ((NotificationManager) a.K().getSystemService("notification")).notify(0, new c.a(a.K()).a((int) R.drawable.connected_status_bar).a(K.getString(R.string.my_pebble_firmware_update_available) + " (" + this.c.getNormalMetadata().getFriendlyVersion() + ")").b(this.c.getNormalMetadata().getNotes()).a(activity).c(true).a(new t().a(new ac.a.a(R.drawable.ic_action_refresh, K.getString(R.string.my_pebble_install), activity).a())).b());
    }
}
