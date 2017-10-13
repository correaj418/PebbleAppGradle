package com.getpebble.android.framework.firmware;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.al;
import com.getpebble.android.common.model.l;
import com.getpebble.android.common.model.r;
import com.getpebble.android.common.model.v;
import com.getpebble.android.common.model.z;
import com.getpebble.android.framework.install.firmware.b;
import com.google.a.f.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {
    private static final Object b = new Object();
    private Context a;

    public a(Context context) {
        this.a = context;
    }

    private Context d() {
        return this.a;
    }

    public boolean a() {
        f.d("FirmwareManifestSync", "Syncing firmware manifest");
        List e = e();
        List<FirmwareManifestBundle> arrayList = new ArrayList();
        List<FirmwareManifestBundle> arrayList2 = new ArrayList();
        Map c = c();
        if (c.isEmpty()) {
            f.c("FirmwareManifestSync", "No devices found.  No firmware will be synced.");
            return false;
        }
        for (z zVar : c.keySet()) {
            f.d("FirmwareManifestSync", "About to sync for: " + zVar.getName());
            FirmwareManifestBundle a = a(zVar);
            if (a != null) {
                FirmwareManifestBundle a2 = a(zVar, e);
                v friendlyVersion = a.getNormalMetadata().getFriendlyVersion();
                v vVar = (v) c.get(zVar);
                f.d("FirmwareManifestSync", "Bundle Firmware Version: " + friendlyVersion + ", Timestamp: " + friendlyVersion.getTimestamp());
                f.d("FirmwareManifestSync", "Oldest Firmware Version: " + vVar + ", Timestamp: " + vVar.getTimestamp());
                if (friendlyVersion.compareTo(vVar) <= 0) {
                    f.d("FirmwareManifestSync", "Firmware is up-to-date.");
                    if (a2 != null) {
                        f.d("FirmwareManifestSync", "Already installed bundle will be deleted.");
                        arrayList2.add(a2);
                    }
                } else if (a2 == null || friendlyVersion.compareTo(a2.getNormalMetadata().getFriendlyVersion()) != 0) {
                    f.d("FirmwareManifestSync", "New bundle will be added");
                    arrayList.add(a);
                    if (a2 != null) {
                        f.d("FirmwareManifestSync", "Out of date bundle will be deleted");
                        arrayList2.add(a2);
                    }
                } else {
                    f.d("FirmwareManifestSync", "Firmware has already been downloaded.");
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        b b = b();
        List arrayList4 = new ArrayList();
        for (FirmwareManifestBundle id : arrayList2) {
            arrayList4.add(String.valueOf(id.getId()));
        }
        if (!arrayList4.isEmpty()) {
            arrayList3.add(al.a(arrayList4));
        }
        for (FirmwareManifestBundle id2 : arrayList) {
            b.a(id2.getNormalMetadata().getUrl());
            arrayList3.add(al.a(id2.getContentValues()));
        }
        try {
            if (!arrayList3.isEmpty()) {
                d().getContentResolver().applyBatch("com.getpebble.android.basalt.internal.provider", arrayList3);
            }
        } catch (Throwable e2) {
            f.a("FirmwareManifestSync", "Failed to update firmware manifests.", e2);
        } catch (Throwable e22) {
            f.a("FirmwareManifestSync", "Failed to update firmware manifests.", e22);
        } catch (Throwable e222) {
            f.a("FirmwareManifestSync", "Failed to update firmware manifests.", e222);
        }
        for (FirmwareManifestBundle id22 : arrayList2) {
            b.b(id22.getNormalMetadata().getUrl());
        }
        f.d("FirmwareManifestSync", "Updating firmware manifests complete!");
        return true;
    }

    public FirmwareManifestBundle a(PebbleDevice pebbleDevice) {
        z c = c(pebbleDevice);
        if (c.equals(r.UNKNOWN)) {
            f.a("FirmwareManifestSync", "Unknown hardware platform: Cannot fetch firmware bundle.");
            return null;
        }
        FirmwareManifestBundle a = a(c, e());
        if (a != null) {
            return a;
        }
        f.d("FirmwareManifestSync", "Downloading latest FirmwareManifestBundle");
        return a(c);
    }

    public String b(PebbleDevice pebbleDevice) {
        FirmwareManifestBundle a = a(pebbleDevice);
        if (a == null) {
            f.c("FirmwareManifestSync", "firmwareManifestBundle is null");
            return null;
        } else if (b.a()) {
            return a.get3xMigrationMetadata().getUrl();
        } else {
            return a.getNormalMetadata().getUrl();
        }
    }

    protected b b() {
        return new b(d());
    }

    protected FirmwareManifestBundle a(z zVar) {
        FirmwareManifestBundle c = new com.getpebble.android.framework.health.c.a(d(), zVar).c();
        if (c != null && c.getNormalMetadata() != null && c.getHardwarePlatform() != null) {
            return c;
        }
        f.b("FirmwareManifestSync", "fetchBundle: Got no bundle or invalid bundle with missing data.");
        return null;
    }

    private z c(PebbleDevice pebbleDevice) {
        return ak.getPebbleDeviceRecord(d().getContentResolver(), pebbleDevice).hwPlatform;
    }

    protected Map<z, v> c() {
        Map<z, v> hashMap = new HashMap();
        String[] strArr = new String[]{ak.HW_PLATFORM, ak.FW_VERSION, ak.FW_TIMESTAMP};
        Cursor query = d().getContentResolver().query(com.getpebble.android.common.b.b.b.a(ak.TABLE_NAME), strArr, "last_connected_time is not NULL", null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    z a = l.a(e.a(query.getInt(query.getColumnIndex(ak.HW_PLATFORM))));
                    f.d("FirmwareManifestSync", "Hardware platform: " + a.toString());
                    if (!a.equals(r.UNKNOWN)) {
                        v vVar;
                        if (hashMap.containsKey(a)) {
                            vVar = (v) hashMap.get(a);
                        } else {
                            vVar = null;
                        }
                        String string = query.getString(query.getColumnIndex(ak.FW_VERSION));
                        long j = query.getLong(query.getColumnIndex(ak.FW_TIMESTAMP));
                        f.d("FirmwareManifestSync", "Firmware version: " + string);
                        v vVar2 = new v(string, j);
                        if (vVar == null || vVar2.compareTo(vVar) < 0) {
                            hashMap.put(a, vVar2);
                        }
                    }
                } finally {
                    query.close();
                }
            }
        }
        return hashMap;
    }

    private List<FirmwareManifestBundle> e() {
        Cursor a = al.a(d().getContentResolver(), null);
        List<FirmwareManifestBundle> arrayList = new ArrayList();
        if (a != null) {
            while (a.moveToNext()) {
                try {
                    ContentValues contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(a, contentValues);
                    arrayList.add(FirmwareManifestBundle.fromContentValues(contentValues));
                } finally {
                    a.close();
                }
            }
        }
        return arrayList;
    }

    private static FirmwareManifestBundle a(z zVar, List<FirmwareManifestBundle> list) {
        for (FirmwareManifestBundle firmwareManifestBundle : list) {
            if (firmwareManifestBundle.getHardwarePlatform().equals(zVar)) {
                return firmwareManifestBundle;
            }
        }
        return null;
    }
}
