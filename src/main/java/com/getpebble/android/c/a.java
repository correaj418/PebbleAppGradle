package com.getpebble.android.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.model.aj;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.v;
import com.getpebble.android.framework.firmware.FirmwareManifestBundle;
import com.getpebble.android.framework.firmware.FirmwareManifestBundle.FirmwareMetadata;
import java.lang.ref.WeakReference;

public class a extends f {
    private WeakReference<Context> a;
    private PebbleDevice b;
    private v c;
    private boolean d = false;
    private FirmwareManifestBundle e;
    private a f;

    public interface a {
        void a();

        void a(PebbleDevice pebbleDevice);

        void a(PebbleDevice pebbleDevice, FirmwareManifestBundle firmwareManifestBundle);

        void b();
    }

    public a(Context context, PebbleDevice pebbleDevice, v vVar, a aVar) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        } else if (pebbleDevice == null) {
            throw new IllegalArgumentException("'device' cannot be null!");
        } else if (vVar == null) {
            throw new IllegalArgumentException("'deviceFirmwareVersion' cannot be null!");
        } else if (aVar == null) {
            throw new IllegalArgumentException("'listener' cannot be null!");
        } else {
            this.a = new WeakReference(context);
            this.b = pebbleDevice;
            this.c = vVar;
            this.f = aVar;
        }
    }

    private Context a() {
        if (this.a != null) {
            return (Context) this.a.get();
        }
        return null;
    }

    public boolean doInBackground() {
        com.getpebble.android.common.b.a.f.d("FirmwareUpdateCheckFromDatabaseTask", "doInBackground: Starting update check task");
        Context a = a();
        if (a == null) {
            com.getpebble.android.common.b.a.f.a("FirmwareUpdateCheckFromDatabaseTask", "doInBackground: Context is null; failing task");
            return false;
        }
        this.d = a(a);
        this.e = a(a, this.c, this.b);
        return true;
    }

    private boolean a(Context context) {
        com.getpebble.android.common.model.ak.a pebbleDeviceRecord = ak.getPebbleDeviceRecord(context.getContentResolver(), this.b);
        if (pebbleDeviceRecord != null) {
            return pebbleDeviceRecord.isRunningRecoveryFw;
        }
        com.getpebble.android.common.b.a.f.b("FirmwareUpdateCheckFromDatabaseTask", "getIsRecovery: record is null; returning getIsRecovery = false");
        return false;
    }

    public static FirmwareManifestBundle a(Context context, v vVar, PebbleDevice pebbleDevice) {
        FirmwareManifestBundle firmwareManifestBundle = null;
        if (context == null) {
            com.getpebble.android.common.b.a.f.a("FirmwareUpdateCheckFromDatabaseTask", "getInstallableBundle: Context was null");
        } else {
            Cursor a = aj.a(context.getContentResolver(), pebbleDevice);
            if (a == null) {
                com.getpebble.android.common.b.a.f.a("FirmwareUpdateCheckFromDatabaseTask", "getInstallableBundle: cursor is null");
            } else {
                if (a.getCount() == 0) {
                    com.getpebble.android.common.b.a.f.c("FirmwareUpdateCheckFromDatabaseTask", "getInstallableBundle: No firmware found");
                }
                v vVar2 = vVar;
                while (a.moveToNext()) {
                    try {
                        v vVar3;
                        ContentValues contentValues = new ContentValues();
                        DatabaseUtils.cursorRowToContentValues(a, contentValues);
                        FirmwareManifestBundle fromContentValues = FirmwareManifestBundle.fromContentValues(contentValues);
                        FirmwareMetadata firmwareMetadataToInstall = fromContentValues.getFirmwareMetadataToInstall();
                        if (!firmwareMetadataToInstall.isInvalid()) {
                            v friendlyVersion = firmwareMetadataToInstall.getFriendlyVersion();
                            if (vVar2.compareTo(friendlyVersion) < 0) {
                                com.getpebble.android.common.b.a.f.c("FirmwareUpdateCheckFromDatabaseTask", "getInstallableBundle: new update firmwareMetadata = " + firmwareMetadataToInstall);
                                vVar3 = friendlyVersion;
                                vVar2 = vVar3;
                                firmwareManifestBundle = fromContentValues;
                            }
                        }
                        fromContentValues = firmwareManifestBundle;
                        vVar3 = vVar2;
                        vVar2 = vVar3;
                        firmwareManifestBundle = fromContentValues;
                    } finally {
                        a.close();
                    }
                }
            }
        }
        return firmwareManifestBundle;
    }

    public void onTaskSuccess() {
        if (isCancelled()) {
            this.f.b();
        } else if (this.d) {
            this.f.a(this.b);
        } else {
            this.f.a(this.b, this.e);
        }
    }

    public void onTaskFailed() {
        if (isCancelled()) {
            this.f.b();
        } else {
            this.f.a();
        }
    }
}
