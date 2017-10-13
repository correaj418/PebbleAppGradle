package com.getpebble.android.common.b.a;

import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.framework.e.f.a;
import java.util.Map;

public class b implements a {
    ak.a a;

    public b() {
        a(null);
        PebbleApplication.F().a((a) this);
        a(PebbleApplication.r());
    }

    private void a(ak.a aVar) {
        this.a = aVar;
        synchronized (com.getpebble.android.a.b.class) {
            Object obj;
            Map globalEventProperties = com.getpebble.android.a.b.getGlobalEventProperties();
            Map orCreateChildMap = com.getpebble.android.a.b.getOrCreateChildMap(com.getpebble.android.a.b.getOrCreateChildMap(globalEventProperties, "device"), "remote_device");
            orCreateChildMap.put("bt_address", a(this.a != null ? this.a.pebbleDevice.getAddress() : ""));
            Map orCreateChildMap2 = com.getpebble.android.a.b.getOrCreateChildMap(com.getpebble.android.a.b.getOrCreateChildMap(com.getpebble.android.a.b.getOrCreateChildMap(orCreateChildMap, "firmware_description"), "version"), "firmware");
            orCreateChildMap2.put(ak.FW_VERSION, this.a != null ? this.a.getFwVersion().toString() : "");
            Object obj2 = "";
            if (!(this.a == null || this.a.recoveryFwVersion == null)) {
                obj2 = this.a.recoveryFwVersion.toString();
            }
            orCreateChildMap2.put(ak.RECOVERY_FW_VERSION, obj2);
            orCreateChildMap.put("hw_version", this.a != null ? this.a.hwRevision : "");
            if (this.a != null) {
                obj = this.a.serialNumber;
            } else {
                String str = "";
            }
            orCreateChildMap.put(ak.SERIAL_NUMBER, obj);
            orCreateChildMap.put(ak.TRANSPORT, this.a != null ? this.a.pebbleDevice.getTransport() : "");
            orCreateChildMap.put("type", "watch");
            com.getpebble.android.a.b.getOrCreateChildMap(globalEventProperties, "identity").put(ak.SERIAL_NUMBER, obj);
        }
    }

    private String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != ':') {
                stringBuilder.append(Character.toUpperCase(c));
            }
        }
        return stringBuilder.toString();
    }

    public void e_() {
        a(PebbleApplication.r());
    }
}
