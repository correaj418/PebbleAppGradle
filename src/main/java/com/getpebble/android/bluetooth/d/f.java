package com.getpebble.android.bluetooth.d;

import android.annotation.TargetApi;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.bluetooth.le.ScanSettings.Builder;
import android.os.Build.VERSION;
import com.getpebble.android.bluetooth.PebbleDevice;
import java.util.ArrayList;
import java.util.List;

@TargetApi(21)
public class f {
    private final com.getpebble.android.bluetooth.j.a a;
    private final a b;
    private ScanCallback c;
    private PebbleDevice d;

    public interface a {
        void j(PebbleDevice pebbleDevice);
    }

    public f(com.getpebble.android.bluetooth.j.a aVar, a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    public synchronized void a(PebbleDevice pebbleDevice) {
        a();
        com.getpebble.android.common.b.a.f.d("LollipopReconnectScanner", "startScan() for device: (" + pebbleDevice.toString() + ")");
        ScanSettings build = new Builder().setScanMode(0).build();
        ScanFilter build2 = new ScanFilter.Builder().setDeviceAddress(pebbleDevice.getAddress()).build();
        List arrayList = new ArrayList();
        arrayList.add(build2);
        BluetoothLeScanner i = this.a.i();
        if (i == null) {
            com.getpebble.android.common.b.a.f.b("LollipopReconnectScanner", "startScan: failed, scanner is null");
        } else {
            this.d = pebbleDevice;
            this.c = new ScanCallback(this) {
                final /* synthetic */ f a;

                {
                    this.a = r1;
                }

                public void onScanResult(int i, ScanResult scanResult) {
                    com.getpebble.android.common.b.a.f.d("LollipopReconnectScanner", "onScanResult: (0==success) " + scanResult);
                    if (scanResult.getDevice().getAddress().equals(this.a.d.getAddress())) {
                        this.a.b.j(this.a.d);
                    }
                    this.a.a();
                }

                public void onBatchScanResults(List<ScanResult> list) {
                    for (ScanResult onScanResult : list) {
                        onScanResult(0, onScanResult);
                    }
                }

                public void onScanFailed(int i) {
                    com.getpebble.android.common.b.a.f.c("LollipopReconnectScanner", "onScanFailed: " + i);
                    this.a.a();
                }
            };
            try {
                i.startScan(arrayList, build, this.c);
            } catch (Throwable e) {
                com.getpebble.android.common.b.a.f.b("LollipopReconnectScanner", "startScan failed, adapter may be turned off", e);
            }
        }
    }

    public synchronized void a() {
        if (this.c != null) {
            com.getpebble.android.common.b.a.f.d("LollipopReconnectScanner", "stopScan()");
            BluetoothLeScanner i = this.a.i();
            if (i == null) {
                com.getpebble.android.common.b.a.f.b("LollipopReconnectScanner", "stopScan: failed, scanner is null");
                this.c = null;
            } else {
                try {
                    i.stopScan(this.c);
                } catch (Throwable e) {
                    com.getpebble.android.common.b.a.f.b("LollipopReconnectScanner", "stopScan failed, adapter may be turned off", e);
                }
                this.c = null;
            }
        }
    }

    public static boolean b() {
        return VERSION.SDK_INT >= 21;
    }
}
