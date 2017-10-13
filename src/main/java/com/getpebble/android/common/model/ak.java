package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.b.d;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.Transport;
import com.getpebble.android.bluetooth.d.g;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.timeline.e;
import com.getpebble.android.h.i;
import com.getpebble.android.h.x;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ak extends ai {
    public static final String ADDRESS = "address";
    public static final String[] ALL_FIELDS_PROJECTION = new String[]{ai.COLUMN_ID, FRIENDLY_NAME, ADDRESS, SERIAL_NUMBER, HW_REVISION, FW_VERSION, FW_TIMESTAMP, HW_PLATFORM, RECOVERY_FW_VERSION, IS_RUNNING_RECOVERY_FW, CAPABILITIES, CONNECTION_STATUS, LAST_CONNECTED_TIME, CURRENT_RUNNING_APP, "color", CONNECTION_GOAL, RSSI, ISO_LOCALE, LANGUAGE_VERSION, HEALTH_INSIGHTS_VERSION, TRANSPORT, EXTRA_UI_STATUS};
    private static final String[] ARGS_CONNECTION_GOAL_CONNECT = new String[]{String.valueOf(com.getpebble.android.b.a.CONNECT.getIntValue())};
    public static final String CAPABILITIES = "capabilities";
    private static final String CLAUSE_CONNECTION_GOAL_CONNECT = "connection_goal = ?";
    private static final String CLAUSE_LAST_CONNECTED_OR_CONNECTING = ("last_connected_time is NOT NULL OR connection_status = " + d.CONNECTING.getIntValue());
    public static final String COLOR = "color";
    public static final String CONNECTION_GOAL = "connection_goal";
    public static final String CONNECTION_STATUS = "connection_status";
    public static final String CURRENT_RUNNING_APP = "current_running_app";
    private static final String[] DATE_COLUMNS = new String[]{LAST_CONNECTED_TIME};
    public static final String DROP_DUPE_SERIAL_SQL = "DELETE FROM devices WHERE rowid IN (SELECT a.rowid FROM devices a WHERE exists  (SELECT b.rowid FROM devices b WHERE a.serial_number = b.serial_number AND a.rowid > b.rowid  ) );";
    public static final String EXTRA_UI_STATUS = "extra_ui_status";
    public static final String FRIENDLY_NAME = "friendly_name";
    public static final String FW_TIMESTAMP = "fw_timestamp";
    public static final String FW_VERSION = "fw_version";
    public static final String HEALTH_INSIGHTS_VERSION = "health_insights_version";
    public static final String HW_PLATFORM = "hw_platform";
    public static final String HW_REVISION = "hw_revision";
    public static final String ISO_LOCALE = "iso_locale";
    public static final String IS_RUNNING_RECOVERY_FW = "is_recovery";
    public static final String LANGUAGE_VERSION = "language_version";
    public static final String LAST_CONNECTED_TIME = "last_connected_time";
    public static final String RECOVERY_FW_VERSION = "recovery_fw_version";
    public static final String RSSI = "rssi";
    public static final String SERIAL_NUMBER = "serial_number";
    private static final String SORT_LAST_CONNECTED_OR_CONNECTING = "connection_status DESC, last_connected_time DESC";
    public static final String TABLE_NAME = "devices";
    public static final Uri TABLE_URI = com.getpebble.android.common.b.b.b.a(TABLE_NAME);
    private static final String TAG = "PebbleDeviceModel";
    public static final String TRANSPORT = "transport";
    public static final String UNIQUE_SERIAL_INDEX = " CREATE UNIQUE INDEX IF NOT EXISTS unique_serial_device ON devices(serial_number);";

    public static class a {
        public final Transport activeTransport;
        public final com.getpebble.android.framework.o.b capabilities;
        public final ah color;
        public final com.getpebble.android.b.a connectionGoal;
        public final d connectionStatus;
        public final UUID currentRunningApp;
        public final String extraUiStatus;
        private final v fwVersion;
        public final int healthInsightsVersion;
        public final z hwPlatform;
        public final String hwRevision;
        public final boolean isRunningRecoveryFw;
        public final String isoLocale;
        public final int languageVersion;
        public final long lastConnectedTimeMillis;
        public final PebbleDevice pebbleDevice;
        public final v recoveryFwVersion;
        public final String serialNumber;

        public String toString() {
            return "PebbleDeviceRecord[serialNumber = " + this.serialNumber + ", pebbleDevice = " + this.pebbleDevice + ", hwPlatform = " + this.hwPlatform + ", version = " + getFwVersion() + ", state = " + this.connectionStatus + "]";
        }

        public a(PebbleDevice pebbleDevice, String str, String str2, v vVar, z zVar, v vVar2, boolean z, d dVar, long j, UUID uuid, ah ahVar, com.getpebble.android.b.a aVar, String str3, int i, com.getpebble.android.framework.o.b bVar, int i2, Transport transport, String str4) {
            this.pebbleDevice = pebbleDevice;
            this.serialNumber = str;
            this.hwRevision = str2;
            this.fwVersion = vVar;
            this.hwPlatform = zVar;
            this.recoveryFwVersion = vVar2;
            this.isRunningRecoveryFw = z;
            this.connectionStatus = dVar;
            this.lastConnectedTimeMillis = j;
            this.currentRunningApp = uuid;
            this.color = ahVar;
            this.connectionGoal = aVar;
            this.isoLocale = str3;
            this.languageVersion = i;
            this.capabilities = bVar;
            this.healthInsightsVersion = i2;
            this.activeTransport = transport;
            this.extraUiStatus = str4;
        }

        public static a getEmptyRecord() {
            return new a(null, null, null, null, null, null, false, null, 0, null, null, null, null, 0, null, 0, null, null);
        }

        public boolean isEmpty() {
            return com.getpebble.android.common.b.b.a.a(this, getEmptyRecord());
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                return com.getpebble.android.common.b.b.a.a(this.pebbleDevice, ((a) obj).pebbleDevice);
            }
            return false;
        }

        public int hashCode() {
            return this.pebbleDevice.hashCode() + 355;
        }

        public String getIsoLocale() {
            return this.isoLocale;
        }

        public int getLanguageVersion() {
            return this.languageVersion;
        }

        public z getHwPlatform() {
            return this.hwPlatform;
        }

        public boolean supportsHeartRateMonitoring() {
            return this.color.hardwareSupports(y.HEART_RATE_MONITORING);
        }

        public v getFwVersion() {
            return this.fwVersion;
        }
    }

    public enum b {
        CONNECTION_GOAL_CONNECT,
        LAST_CONNECTED_OR_CONNECTING
    }

    public ak() {
        super(TABLE_NAME);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, FRIENDLY_NAME));
        com.getpebble.android.common.model.ai.a aVar = new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, ADDRESS);
        aVar.a(true);
        addColumn(aVar);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, HW_REVISION));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, FW_VERSION));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.TIMESTAMP, FW_TIMESTAMP));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, HW_PLATFORM));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, SERIAL_NUMBER));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, RECOVERY_FW_VERSION));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.BLOB, CAPABILITIES));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, IS_RUNNING_RECOVERY_FW));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, CONNECTION_STATUS));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.TIMESTAMP, LAST_CONNECTED_TIME));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, CURRENT_RUNNING_APP));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "color"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, CONNECTION_GOAL));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, RSSI));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, ISO_LOCALE));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, LANGUAGE_VERSION));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, HEALTH_INSIGHTS_VERSION));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, TRANSPORT));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, EXTRA_UI_STATUS));
    }

    public static void addTransportColumn(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(x.a(TABLE_NAME, new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, TRANSPORT)));
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(TRANSPORT, Integer.valueOf(Transport.CLASSIC.mCode));
        sQLiteDatabase.update(TABLE_NAME, contentValues, null, null);
    }

    public static boolean purgeUnknownDevices(ContentResolver contentResolver) {
        if (contentResolver == null) {
            f.a(TAG, "Cannot purge devices with null contentresolver");
            return false;
        }
        f.d(TAG, "Removed " + contentResolver.delete(TABLE_URI, "last_connected_time is NULL AND (connection_goal is NULL OR connection_goal != " + com.getpebble.android.b.a.CONNECT.getIntValue() + ") AND " + FRIENDLY_NAME + " != ?", new String[]{"QEMU"}) + " unknown devices");
        return true;
    }

    public static boolean setAllDevicesDisconnected(ContentResolver contentResolver) {
        if (contentResolver == null) {
            f.a(TAG, "Cannot mark devices disconnected with null contentresolver");
            return false;
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(CONNECTION_STATUS, Integer.valueOf(d.DISCONNECTED.getIntValue()));
        contentResolver.update(TABLE_URI, contentValues, null, null);
        return true;
    }

    public static boolean updateOrInsertDeviceWithLeLogic(ContentResolver contentResolver, PebbleDevice pebbleDevice, g gVar) {
        if (pebbleDevice.getTransport().equals(Transport.LE)) {
            return handleLeScanResult(contentResolver, pebbleDevice, gVar);
        }
        return handleDiscoveredNonLeDevice(contentResolver, pebbleDevice);
    }

    static boolean handleDiscoveredNonLeDevice(ContentResolver contentResolver, PebbleDevice pebbleDevice) {
        ContentValues toContentValues = toContentValues(pebbleDevice);
        if (updateDevice(contentResolver, pebbleDevice, toContentValues)) {
            f.d(TAG, "handleDiscoveredNonLeDevice: Updated non-LE device: " + toContentValues);
        } else {
            f.d(TAG, "handleDiscoveredNonLeDevice: inserting non-LE device if no conflicts");
            insertWithOnConflict(contentResolver, toContentValues, 4);
        }
        return true;
    }

    static boolean handleLeScanResult(ContentResolver contentResolver, PebbleDevice pebbleDevice, g gVar) {
        Cursor cursor;
        if (!pebbleDevice.getTransport().equals(Transport.LE)) {
            f.f(TAG, "handleLeScanResult: Attempted to insert non-LE device " + pebbleDevice);
            return false;
        } else if (gVar == null || gVar.e == null) {
            f.c(TAG, "handleLeScanResult: scanData is null");
            return false;
        } else {
            ContentValues toContentValues = toContentValues(pebbleDevice);
            toContentValues.put(SERIAL_NUMBER, gVar.d);
            toContentValues.put("color", Byte.valueOf(gVar.e.b));
            toContentValues.put(HW_PLATFORM, Integer.valueOf(gVar.e.a));
            toContentValues.put(FW_VERSION, gVar.e.c + "." + gVar.e.d + "." + gVar.e.e);
            try {
                if (updateBySerialIfDisconnected(contentResolver, toContentValues, gVar.d)) {
                    f.d(TAG, "handleLeScanResult: updated an LE entry with matching serial " + toContentValues);
                    return true;
                }
                f.d(TAG, "handleLeScanResult: inserting LE device if no conflicts");
                insertWithOnConflict(contentResolver, toContentValues, 4);
                return true;
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                cursor = null;
                cursor = getDevicesMatchingSerialOrAddress(contentResolver, gVar.d, pebbleDevice.getAddress());
                while (cursor.moveToNext()) {
                    stringBuilder.append("> ").append(getPebbleDeviceRecordFromCursor(cursor));
                }
                f.a(TAG, "PBL-41739 dupe devices: " + stringBuilder.toString());
                throw new IllegalStateException("PBL-41739 Multiple devices matching serial=" + gVar.d + " address=" + pebbleDevice.getAddress(), e);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    private static Cursor getDevicesMatchingSerialOrAddress(ContentResolver contentResolver, String str, String str2) {
        String[] strArr = new String[]{str, str2};
        return contentResolver.query(TABLE_URI, null, "serial_number = ? OR address = ?", strArr, null);
    }

    private static ContentValues toContentValues(PebbleDevice pebbleDevice) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FRIENDLY_NAME, pebbleDevice.getName());
        contentValues.put(ADDRESS, pebbleDevice.getAddress());
        contentValues.put(TRANSPORT, Integer.valueOf(pebbleDevice.getTransport().mCode));
        contentValues.put(RSSI, Short.valueOf(pebbleDevice.getRSSI()));
        return contentValues;
    }

    public static boolean updateDevice(ContentResolver contentResolver, PebbleDevice pebbleDevice, ContentValues contentValues) {
        String str = "address = ?";
        if (contentResolver.update(TABLE_URI, contentValues, "address = ?", new String[]{pebbleDevice.getAddress()}) > 0) {
            return true;
        }
        return false;
    }

    static boolean updateBySerialIfDisconnected(ContentResolver contentResolver, ContentValues contentValues, String str) {
        if (contentResolver.update(TABLE_URI, contentValues, "serial_number = ? AND (connection_status IN (" + d.DISCONNECTED.getIntValue() + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + d.UNKNOWN.getIntValue() + ") OR " + CONNECTION_STATUS + " IS NULL)", new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    private static void insertWithOnConflict(ContentResolver contentResolver, ContentValues contentValues, int i) {
        contentResolver.insert(x.a(TABLE_URI, i), contentValues);
    }

    public static String retrieveLastConnectedDeviceSerial() {
        a p = PebbleApplication.p();
        if (p == null || TextUtils.isEmpty(p.serialNumber)) {
            return "";
        }
        return p.serialNumber;
    }

    public static a getPebbleDeviceRecordFromCursor(Cursor cursor) {
        try {
            v vVar;
            v vVar2;
            String string = cursor.getString(cursor.getColumnIndex(FRIENDLY_NAME));
            String string2 = cursor.getString(cursor.getColumnIndex(ADDRESS));
            Transport from = Transport.from(cursor.getInt(cursor.getColumnIndex(TRANSPORT)));
            short s = cursor.getShort(cursor.getColumnIndex(RSSI));
            Object string3 = cursor.getString(cursor.getColumnIndex(FW_VERSION));
            long j = cursor.getLong(cursor.getColumnIndex(FW_TIMESTAMP));
            if (TextUtils.isEmpty(string3)) {
                vVar = null;
            } else {
                vVar = new v(string3, j);
            }
            string3 = cursor.getString(cursor.getColumnIndex(RECOVERY_FW_VERSION));
            if (TextUtils.isEmpty(string3)) {
                vVar2 = null;
            } else {
                vVar2 = new v(string3, 0);
            }
            String string4 = cursor.getString(cursor.getColumnIndex(ISO_LOCALE));
            int i = cursor.getInt(cursor.getColumnIndex(LANGUAGE_VERSION));
            String string5 = cursor.getString(cursor.getColumnIndex(CURRENT_RUNNING_APP));
            UUID uuid = null;
            if (string5 != null) {
                uuid = UUID.fromString(string5);
            }
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(CAPABILITIES));
            return new a(new PebbleDevice(string, string2, from, s), cursor.getString(cursor.getColumnIndex(SERIAL_NUMBER)), cursor.getString(cursor.getColumnIndex(HW_REVISION)), vVar, l.a(com.google.a.f.e.a((long) cursor.getInt(cursor.getColumnIndex(HW_PLATFORM)))), vVar2, cursor.getInt(cursor.getColumnIndex(IS_RUNNING_RECOVERY_FW)) != 0, d.fromInt(cursor.getInt(cursor.getColumnIndex(CONNECTION_STATUS))), cursor.getLong(cursor.getColumnIndex(LAST_CONNECTED_TIME)), uuid, ah.fromInt(cursor.getInt(cursor.getColumnIndex("color"))), com.getpebble.android.b.a.fromInt(cursor.getInt(cursor.getColumnIndex(CONNECTION_GOAL))), string4, i, com.getpebble.android.framework.o.b.from(blob), cursor.getInt(cursor.getColumnIndex(HEALTH_INSIGHTS_VERSION)), from, cursor.getString(cursor.getColumnIndex(EXTRA_UI_STATUS)));
        } catch (Throwable e) {
            f.a(TAG, "Error loading PebbleDeviceRecord from cursor", e);
            return null;
        }
    }

    public static a getPebbleDeviceRecord(ContentResolver contentResolver, PebbleDevice pebbleDevice) {
        a aVar = null;
        Cursor cursorForDevice = getCursorForDevice(contentResolver, pebbleDevice);
        if (cursorForDevice != null) {
            try {
                if (cursorForDevice.moveToFirst()) {
                    aVar = getPebbleDeviceRecordFromCursor(cursorForDevice);
                }
                cursorForDevice.close();
            } catch (Throwable th) {
                cursorForDevice.close();
            }
        }
        return aVar;
    }

    public static List<a> getPebbleDeviceRecords(ContentResolver contentResolver, b bVar) {
        List<a> arrayList = new ArrayList();
        Cursor cursorForDevices = getCursorForDevices(contentResolver, bVar);
        if (cursorForDevices != null) {
            while (cursorForDevices.moveToNext()) {
                try {
                    a pebbleDeviceRecordFromCursor = getPebbleDeviceRecordFromCursor(cursorForDevices);
                    if (pebbleDeviceRecordFromCursor != null) {
                        arrayList.add(pebbleDeviceRecordFromCursor);
                    }
                } finally {
                    cursorForDevices.close();
                }
            }
        }
        return arrayList;
    }

    public static List<a> getKnownHeartRateCapablePebbles(ContentResolver contentResolver) {
        b bVar = b.LAST_CONNECTED_OR_CONNECTING;
        List<a> linkedList = new LinkedList();
        Cursor cursor = null;
        try {
            cursor = getCursorForDevices(contentResolver, bVar);
            while (cursor.moveToNext()) {
                a pebbleDeviceRecordFromCursor = getPebbleDeviceRecordFromCursor(cursor);
                if (pebbleDeviceRecordFromCursor != null && pebbleDeviceRecordFromCursor.supportsHeartRateMonitoring()) {
                    linkedList.add(pebbleDeviceRecordFromCursor);
                }
            }
            return linkedList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static Cursor getCursorForDevice(ContentResolver contentResolver, PebbleDevice pebbleDevice) {
        String str = "address = ?";
        return contentResolver.query(TABLE_URI, ALL_FIELDS_PROJECTION, "address = ?", new String[]{pebbleDevice.getAddress()}, null);
    }

    private static Cursor getCursorForDevices(ContentResolver contentResolver, b bVar) {
        String str;
        String[] strArr;
        String str2 = null;
        switch (bVar) {
            case CONNECTION_GOAL_CONNECT:
                str = CLAUSE_CONNECTION_GOAL_CONNECT;
                strArr = ARGS_CONNECTION_GOAL_CONNECT;
                break;
            case LAST_CONNECTED_OR_CONNECTING:
                str = CLAUSE_LAST_CONNECTED_OR_CONNECTING;
                strArr = null;
                str2 = SORT_LAST_CONNECTED_OR_CONNECTING;
                break;
            default:
                strArr = null;
                str = null;
                break;
        }
        return contentResolver.query(TABLE_URI, ALL_FIELDS_PROJECTION, str, strArr, str2);
    }

    public static boolean updateLanguageInfo(ContentResolver contentResolver, PebbleDevice pebbleDevice, String str, int i) {
        ContentValues contentValues = new ContentValues(2);
        contentValues.put(ISO_LOCALE, str);
        contentValues.put(LANGUAGE_VERSION, Integer.valueOf(i));
        return updateDevice(contentResolver, pebbleDevice, contentValues);
    }

    public static boolean updateHealthInsightsVersion(ContentResolver contentResolver, PebbleDevice pebbleDevice, int i) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(HEALTH_INSIGHTS_VERSION, Integer.valueOf(i));
        return updateDevice(contentResolver, pebbleDevice, contentValues);
    }

    public static void catTableToStream(ContentResolver contentResolver, PrintStream printStream) {
        ContentResolver contentResolver2 = contentResolver;
        PrintStream printStream2 = printStream;
        i.a(contentResolver2, printStream2, TABLE_URI, "friendly_name ASC", new String[0], DATE_COLUMNS);
    }

    public static void insertOrUpdateQemuDevice(ContentResolver contentResolver, String str) {
        ContentValues contentValues = new ContentValues(3);
        contentValues.put(FRIENDLY_NAME, "QEMU");
        contentValues.put(ADDRESS, str);
        contentValues.put(TRANSPORT, Integer.valueOf(Transport.QEMU.mCode));
        String str2 = "friendly_name = ?";
        String[] strArr = new String[]{"QEMU"};
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(TABLE_URI, new String[]{FRIENDLY_NAME}, "friendly_name = ?", strArr, null);
        if (query == null) {
            try {
                f.f(TAG, "insertOrUpdateQemuDevice: cur is null");
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        } else if (query.moveToFirst()) {
            f.d(TAG, "Updating QEMU record with address: " + str);
            contentResolver.update(TABLE_URI, contentValues, "friendly_name = ?", strArr);
            if (query != null) {
                query.close();
            }
        } else {
            f.d(TAG, "Inserting QEMU record with address: " + str);
            contentResolver.insert(TABLE_URI, contentValues);
            if (query != null) {
                query.close();
            }
        }
    }

    public static void deleteQemuDevice(ContentResolver contentResolver) {
        f.d(TAG, "deleteQemuDevice()");
        String str = "transport = ?";
        contentResolver.delete(TABLE_URI, "transport = ?", new String[]{String.valueOf(Transport.QEMU.mCode)});
    }

    public static void setExtraUiStatus(ContentResolver contentResolver, PebbleDevice pebbleDevice, String str) {
    }

    public static void deleteAllLeDevices(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete(TABLE_NAME, "transport = ?", new String[]{String.valueOf(Transport.LE.mCode)});
    }

    public static boolean hasDeviceEverConnected(ContentResolver contentResolver, PebbleDevice pebbleDevice) {
        a pebbleDeviceRecord = getPebbleDeviceRecord(contentResolver, pebbleDevice);
        return pebbleDeviceRecord != null && pebbleDeviceRecord.lastConnectedTimeMillis > 0;
    }
}
