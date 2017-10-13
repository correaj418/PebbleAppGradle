package com.getpebble.android.bluetooth;

import android.annotation.SuppressLint;
import android.content.Context;
import com.getpebble.android.bluetooth.a.b;
import com.getpebble.android.bluetooth.e.g;
import com.getpebble.android.bluetooth.e.h;
import com.getpebble.android.bluetooth.e.m;
import com.getpebble.android.bluetooth.i.d;
import com.getpebble.android.bluetooth.j.a;

public enum Transport {
    CLASSIC(1) {
        public g getDeviceConnector(PebbleDevice pebbleDevice, e eVar, Context context, a aVar, com.getpebble.android.bluetooth.d.a aVar2, m mVar, i iVar, h hVar, String str) {
            return b.a(pebbleDevice, eVar, context, aVar, aVar2);
        }
    },
    LE(2) {
        @SuppressLint({"NewApi"})
        public g getDeviceConnector(PebbleDevice pebbleDevice, e eVar, Context context, a aVar, com.getpebble.android.bluetooth.d.a aVar2, m mVar, i iVar, h hVar, String str) {
            return g.a(pebbleDevice, eVar, context, aVar, aVar2, mVar, iVar, hVar, str);
        }
    },
    QEMU(3) {
        public g getDeviceConnector(PebbleDevice pebbleDevice, e eVar, Context context, a aVar, com.getpebble.android.bluetooth.d.a aVar2, m mVar, i iVar, h hVar, String str) {
            return new d(pebbleDevice, eVar, context);
        }
    },
    QEMU_SERVER(4) {
        public g getDeviceConnector(PebbleDevice pebbleDevice, e eVar, Context context, a aVar, com.getpebble.android.bluetooth.d.a aVar2, m mVar, i iVar, h hVar, String str) {
            return new d(pebbleDevice, eVar, context, true);
        }
    };
    
    public final int mCode;

    public abstract g getDeviceConnector(PebbleDevice pebbleDevice, e eVar, Context context, a aVar, com.getpebble.android.bluetooth.d.a aVar2, m mVar, i iVar, h hVar, String str);

    private Transport(int i) {
        this.mCode = i;
    }

    public static Transport from(int i) {
        for (Transport transport : values()) {
            if (transport.mCode == i) {
                return transport;
            }
        }
        return null;
    }
}
