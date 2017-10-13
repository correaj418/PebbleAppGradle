package com.getpebble.android.bluetooth.d;

import android.annotation.TargetApi;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings.Builder;
import com.getpebble.android.bluetooth.b.c;
import com.getpebble.android.bluetooth.d.a.a;
import com.getpebble.android.common.b.a.f;
import java.util.List;

@TargetApi(21)
class e extends d {
    private final BluetoothLeScanner b;
    private ScanCallback c;

    e(a aVar, com.getpebble.android.bluetooth.j.a aVar2) {
        super(aVar);
        this.b = aVar2.i();
        if (this.b == null) {
            throw new IllegalStateException("scanner is null!");
        }
    }

    synchronized void a(int i, ScanResult scanResult) {
        if (scanResult.getScanRecord() != null) {
            a(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes());
        }
    }

    synchronized void a(List<ScanResult> list) {
        for (ScanResult scanResult : list) {
            if (scanResult.getScanRecord() == null) {
                break;
            }
            a(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes());
        }
    }

    synchronized void a(int i) {
        f.c("LollipopLeScanner", "onScanFailed: " + i);
        this.c = null;
        this.a.b();
    }

    protected synchronized boolean a() {
        boolean z;
        this.c = new ScanCallback(this) {
            final /* synthetic */ e a;

            {
                this.a = r1;
            }

            public void onScanResult(final int i, final ScanResult scanResult) {
                c.a(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 c;

                    public void run() {
                        this.c.a.a(i, scanResult);
                    }
                });
            }

            public void onBatchScanResults(final List<ScanResult> list) {
                c.a(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 b;

                    public void run() {
                        this.b.a.a(list);
                    }
                });
            }

            public void onScanFailed(final int i) {
                c.a(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 b;

                    public void run() {
                        this.b.a.a(i);
                    }
                });
            }
        };
        try {
            this.b.startScan(null, new Builder().setScanMode(2).build(), this.c);
            z = true;
        } catch (Throwable e) {
            f.a("LollipopLeScanner", "startScanInternal: failed to start scan, exception thrown by OS", e);
            this.c = null;
            z = false;
        }
        return z;
    }

    protected synchronized boolean c() {
        try {
            this.b.stopScan(this.c);
        } catch (Throwable e) {
            f.b("LollipopLeScanner", "stopScanInternal failed, exception thrown by OS", e);
        }
        this.c = null;
        return true;
    }

    protected synchronized boolean b() {
        return this.c != null;
    }
}
