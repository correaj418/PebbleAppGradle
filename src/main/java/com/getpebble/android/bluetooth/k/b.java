package com.getpebble.android.bluetooth.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.timeline.e;

public class b extends BroadcastReceiver {
    public b(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.BLE_ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.adapter.action.BLE_ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.LOCAL_NAME_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.REQUEST_DISCOVERABLE");
        intentFilter.addAction("android.bluetooth.adapter.action.REQUEST_ENABLE");
        intentFilter.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.AVRCP_CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        context.registerReceiver(this, intentFilter);
    }

    public void onReceive(Context context, Intent intent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onReceive: action = ");
        stringBuilder.append(intent.getAction());
        stringBuilder.append(" extras: ");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            stringBuilder.append("<null>");
        } else {
            for (String str : extras.keySet()) {
                stringBuilder.append(str);
                stringBuilder.append(" = ");
                stringBuilder.append(extras.get(str));
                stringBuilder.append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            }
        }
        f.d("BluetoothReceiver", stringBuilder.toString());
    }
}
