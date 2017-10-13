package com.getpebble.android.main.sections.support;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v4.app.an;
import android.support.v4.content.FileProvider;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.ab;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.al;
import com.getpebble.android.common.model.as;
import com.getpebble.android.common.model.au;
import com.getpebble.android.common.model.av;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.common.model.o;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel;
import com.getpebble.android.framework.g.m;
import com.getpebble.android.h.v;
import com.google.a.b.am;
import com.google.b.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class b {
    private static final Set<String> BAD_BLUETOOTH_APPS = am.a(GOOGLE_GLASS, GARMIN_CONNECT_MOBILE, GASBUDDY);
    private static final String GARMIN_CONNECT_MOBILE = "com.garmin.android.apps.connectmobile";
    private static final String GASBUDDY = "gbis.gbandroid";
    private static final String GOOGLE_GLASS = "com.google.glass.companion";
    private static final long MAX_ANR_TRACES_SIZE_BYTES = 2000000;
    private static final long MAX_AUTO_CORE_DUMP_BYTES = 2000000;
    private static final long MAX_BT_SNOOP_SIZE_BYTES = 4000000;
    private static final String PERM_BLUETOOTH = "android.permission.BLUETOOTH";
    private static final String PERM_BLUETOOTH_ADMIN = "android.permission.BLUETOOTH_ADMIN";
    private static final String SUPPORT_ATTACHMENT_FILE_NAME = "pebble.log.gz";
    private static final String TAG = "SupportEmail";
    private String mAccountId;
    private a mAndroidInfo;
    private Map<String, Long> mAttachmentSizes = new HashMap();
    private com.getpebble.android.config.a mBootConfig;
    private boolean mComplete = false;
    private final Context mContext;
    private String mCoreDumpFilename;
    private int mDirSize;
    Boolean mHasCoreDump = null;
    Boolean mHasLogDump = null;
    private Boolean mHasSupportAttachmentUri = null;
    private boolean mIncludeHealth = false;
    private boolean mIncludeLogs = true;
    private com.getpebble.android.common.model.ak.a mLastDeviceRecord;
    private String mLogDumpFilename;
    private final c mOnComplete;
    private e mPebbleAndroidInfo;
    private Resources mResources;
    private boolean mSent = false;
    private Uri mSupportAttachmentUri;
    private d mTarget;

    public static class a {
        public final String androidOsVersion;
        public final int androidSdkVersion;
        public final String deviceBrand;
        public final String deviceKernel;
        public final String deviceManufacturer;
        public final String deviceModel;

        public a() {
            this.deviceModel = "";
            this.deviceManufacturer = "";
            this.deviceBrand = "";
            this.deviceKernel = "";
            this.androidOsVersion = "";
            this.androidSdkVersion = 0;
        }

        public a(String str, String str2, String str3, String str4, String str5, int i) {
            this.deviceModel = str;
            this.deviceManufacturer = str2;
            this.deviceBrand = str3;
            this.deviceKernel = str4;
            this.androidOsVersion = str5;
            this.androidSdkVersion = i;
        }
    }

    private class b extends f {
        private b() {
        }

        public boolean doInBackground() {
            com.getpebble.android.common.b.a.f.d(f.TAG, "BasicInfoAsyncTask doInBackground()");
            a access$800 = b.this.generateAndroidInfo();
            com.getpebble.android.config.a access$900 = b.this.loadBootConfigInfo();
            com.getpebble.android.common.model.ak.a access$1000 = b.this.loadLastConnectedDeviceRecord();
            Resources resources = b.this.mContext.getResources();
            e generatePebbleAndroidInfo = b.generatePebbleAndroidInfo(b.this.mContext);
            com.getpebble.android.common.a.a u = PebbleApplication.u();
            Account g = u != null ? u.g() : null;
            String b = g != null ? u.b(g) : "";
            synchronized (b.this) {
                b.this.mAndroidInfo = access$800;
                b.this.mBootConfig = access$900;
                b.this.mLastDeviceRecord = access$1000;
                b.this.mResources = resources;
                b.this.mPebbleAndroidInfo = generatePebbleAndroidInfo;
                b.this.mAccountId = b;
                b.this.mComplete = b.this.isComplete();
            }
            return true;
        }

        public void onTaskSuccess() {
            if (b.this.mIncludeLogs) {
                b.this.fetchLogDump();
            } else {
                b.this.onTaskComplete();
            }
        }

        public void onTaskFailed() {
            if (b.this.mIncludeLogs) {
                b.this.fetchLogDump();
            } else {
                b.this.onTaskComplete();
            }
        }
    }

    public static abstract class c {
        public abstract void onComplete(b bVar);

        public abstract void onPing();
    }

    private class d extends f {
        private d() {
        }

        public boolean doInBackground() {
            File createSupportAttachment = b.this.createSupportAttachment(b.this.mContext, b.this.getSummary(), b.this.mIncludeLogs, b.this.mAccountId, b.this.mOnComplete);
            b.this.mAttachmentSizes.put("support", Long.valueOf(createSupportAttachment.length()));
            if (createSupportAttachment == null) {
                return false;
            }
            b.this.mSupportAttachmentUri = b.getFileUri(b.this.mContext, createSupportAttachment);
            return true;
        }

        public void onTaskSuccess() {
            synchronized (b.this) {
                b.this.mHasSupportAttachmentUri = Boolean.valueOf(true);
                b.this.mComplete = b.this.isComplete();
            }
            b.this.onTaskComplete();
        }

        public void onTaskFailed() {
            synchronized (b.this) {
                b.this.mHasSupportAttachmentUri = Boolean.valueOf(false);
                b.this.mComplete = b.this.isComplete();
            }
            b.this.onTaskComplete();
        }
    }

    public static class e {
        public final String appVersion;
        public final boolean areNotificationsEnabled;
        public final boolean arePebbleNotificationsEnabled = an.a(com.getpebble.android.common.a.K()).a();
        public final Boolean batteryOptimisationsIgnoredForPebble = com.getpebble.android.h.a.a(com.getpebble.android.common.a.K());
        public final String buildFlavor;
        public final String buildType;
        public final boolean calendarPermission = v.a(com.getpebble.android.h.v.a.CALENDAR);
        public final boolean contactsPermission = v.a(com.getpebble.android.h.v.a.CONTACTS);
        public final boolean gcmPermission = v.a(com.getpebble.android.h.v.a.GCM);
        public final Boolean isDeviceIdleMode = com.getpebble.android.h.a.b(com.getpebble.android.common.a.K());
        public final Boolean isNotificationListenerServiceCrashed;
        public final boolean locationPermission = v.a(com.getpebble.android.h.v.a.LOCATION);
        public final boolean phonePermission = v.a(com.getpebble.android.h.v.a.TELEPHONE);
        public final boolean smsPermission = v.a(com.getpebble.android.h.v.a.SMS);
        public final boolean storagePermission = v.a(com.getpebble.android.h.v.a.STORAGE);

        public e(String str, boolean z, Boolean bool) {
            this.appVersion = str;
            this.areNotificationsEnabled = z;
            this.buildType = "release";
            this.buildFlavor = "prod";
            this.isNotificationListenerServiceCrashed = bool;
        }
    }

    public b(Context context, boolean z, d dVar, c cVar) {
        boolean z2 = true;
        this.mContext = context;
        this.mIncludeLogs = z;
        this.mOnComplete = cVar;
        this.mTarget = dVar;
        if (dVar != d.HEALTH) {
            z2 = false;
        }
        this.mIncludeHealth = z2;
        com.getpebble.android.framework.d x = PebbleApplication.x();
        if (x != null) {
            x.h();
        }
        PebbleApplication.v().k();
        new b().submit();
    }

    public synchronized Intent generateIntent(d dVar, String str) {
        Intent intent;
        intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setType(com.google.a.e.a.l.toString());
        intent.putExtra("android.intent.extra.EMAIL", new String[]{getEmailAddress(dVar)});
        intent.putExtra("android.intent.extra.SUBJECT", getSubject());
        ArrayList attachmentUris = getAttachmentUris();
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : this.mAttachmentSizes.keySet()) {
            stringBuilder.append(" / ").append(str2).append(" = ").append(this.mAttachmentSizes.get(str2));
        }
        String str22 = getBody(str, this.mTarget) + "\n" + stringBuilder.toString();
        com.getpebble.android.common.b.a.f.d(TAG, "Attachment sizes on disk: " + stringBuilder);
        intent.putExtra("android.intent.extra.TEXT", str22);
        if (this.mSupportAttachmentUri != null && isExternalStorageWritable()) {
            attachmentUris.add(this.mSupportAttachmentUri);
        }
        if (!attachmentUris.isEmpty()) {
            attachmentUris.trimToSize();
            com.getpebble.android.common.b.a.f.d(TAG, "Adding support email attachments, size " + attachmentUris.size());
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", attachmentUris);
        }
        return intent;
    }

    private a generateAndroidInfo() {
        return new a(Build.MODEL, Build.MANUFACTURER, Build.BRAND, System.getProperty("os.version"), VERSION.RELEASE, VERSION.SDK_INT);
    }

    private com.getpebble.android.config.a loadBootConfigInfo() {
        return PebbleApplication.w();
    }

    private com.getpebble.android.common.model.ak.a loadLastConnectedDeviceRecord() {
        com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
        if (r != null) {
            return r;
        }
        com.getpebble.android.common.b.a.f.b(TAG, "No last connected device found");
        return com.getpebble.android.common.model.ak.a.getEmptyRecord();
    }

    public static e generatePebbleAndroidInfo(Context context) {
        String str;
        Throwable e;
        Boolean bool;
        com.getpebble.android.common.b.b.c y;
        if (context != null) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (NameNotFoundException e2) {
                e = e2;
                com.getpebble.android.common.b.a.f.b(TAG, "Failed to find package name", e);
                str = "unknown";
                bool = null;
                y = PebbleApplication.y();
                if (y != null) {
                    bool = Boolean.valueOf(y.a(com.getpebble.android.common.b.b.c.a.NOTIFICATION_LISTENER_CRASHED, false));
                }
                return new e(str, com.getpebble.android.notifications.b.f.a(context), bool);
            } catch (RuntimeException e3) {
                e = e3;
                com.getpebble.android.common.b.a.f.b(TAG, "Failed to find package name", e);
                str = "unknown";
                bool = null;
                y = PebbleApplication.y();
                if (y != null) {
                    bool = Boolean.valueOf(y.a(com.getpebble.android.common.b.b.c.a.NOTIFICATION_LISTENER_CRASHED, false));
                }
                return new e(str, com.getpebble.android.notifications.b.f.a(context), bool);
            }
        }
        com.getpebble.android.common.b.a.f.b(TAG, "Null context");
        str = "unknown";
        bool = null;
        y = PebbleApplication.y();
        if (y != null) {
            bool = Boolean.valueOf(y.a(com.getpebble.android.common.b.b.c.a.NOTIFICATION_LISTENER_CRASHED, false));
        }
        return new e(str, com.getpebble.android.notifications.b.f.a(context), bool);
    }

    private boolean isComplete() {
        return this.mComplete || !(this.mAndroidInfo == null || this.mPebbleAndroidInfo == null || this.mBootConfig == null || this.mLastDeviceRecord == null || this.mResources == null || this.mAccountId == null || this.mHasSupportAttachmentUri == null || ((this.mHasCoreDump == null && this.mIncludeLogs) || (this.mHasLogDump == null && this.mIncludeLogs)));
    }

    private synchronized void onTaskComplete() {
        if (this.mComplete && !this.mSent) {
            this.mOnComplete.onComplete(this);
            this.mSent = true;
        }
    }

    private void sendPing() {
        this.mOnComplete.onPing();
    }

    private String getEmailAddress(d dVar) {
        return "";
    }

    private String getSubject() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.mBootConfig.r() == null) {
            com.getpebble.android.common.b.a.f.b(TAG, "Support email subject not found in boot config, using fallback");
            stringBuilder.append(this.mResources.getString(R.string.support_default_email_subject));
        }
        int i = (this.mLastDeviceRecord == null || this.mLastDeviceRecord.pebbleDevice == null || this.mLastDeviceRecord.pebbleDevice.getName() == null) ? 0 : 1;
        if (i != 0) {
            stringBuilder.append(String.format(" - %s", new Object[]{this.mLastDeviceRecord.pebbleDevice.getName()}));
        }
        return stringBuilder.toString();
    }

    private String getBody(String str, d dVar) {
        return String.format(this.mResources.getString(R.string.support_email_key_account_body), new Object[]{this.mAccountId, dVar.getTitle(this.mContext), getSummary()});
    }

    private String getSummary() {
        StringBuilder stringBuilder = new StringBuilder();
        com.google.b.f c = new g().b().c();
        if (this.mAndroidInfo != null) {
            stringBuilder.append("Android Info:\n\n");
            stringBuilder.append(c.b(this.mAndroidInfo)).append("\n\n");
        }
        if (this.mPebbleAndroidInfo != null) {
            stringBuilder.append("Pebble-Android Info:\n\n");
            stringBuilder.append(c.b(this.mPebbleAndroidInfo)).append("\n\n");
        }
        if (this.mLastDeviceRecord != null) {
            stringBuilder.append("Last connected device info:\n\n");
            stringBuilder.append(c.b(this.mLastDeviceRecord)).append("\n\n");
        }
        stringBuilder.append("Last core dump:\n\n");
        stringBuilder.append(PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.LAST_CORE_DUMP, "")).append("\n\n");
        return stringBuilder.toString();
    }

    static boolean isExternalStorageWritable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    private void fetchCoreDump() {
        com.getpebble.android.framework.d x = PebbleApplication.x();
        com.getpebble.android.common.model.ak.a loadLastConnectedDeviceRecord = loadLastConnectedDeviceRecord();
        if (loadLastConnectedDeviceRecord.isEmpty()) {
            com.getpebble.android.common.b.a.f.a(TAG, "No core dump can be returned, no connected devices");
            synchronized (this) {
                this.mHasCoreDump = Boolean.valueOf(false);
                this.mComplete = isComplete();
            }
            new d().submit();
        } else if (!m.e() || PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.DISABLE_AUTO_CORE_DUMP, false)) {
            boolean equals = com.getpebble.android.framework.g.m.a.fromValue(com.getpebble.android.framework.b.b().l()).equals(com.getpebble.android.framework.g.m.a.IN_PROGRESS);
            boolean equals2 = "core-dump-unencrypted.bin".equals(com.getpebble.android.framework.b.b().n());
            com.getpebble.android.common.b.a.f.d(TAG, "fetchCoreDump: getBytesInProgress = " + equals + " coreDumpInProgress = " + equals2);
            if (!equals || equals2) {
                if (!equals) {
                    x.a(loadLastConnectedDeviceRecord.pebbleDevice, "core-dump-unencrypted.bin");
                }
                com.getpebble.android.framework.b.a(new com.getpebble.android.framework.b.a() {
                    public void onFrameworkStateChanged(FrameworkState frameworkState) {
                        if (frameworkState != null && frameworkState.a() != null) {
                            if (frameworkState.a() == com.getpebble.android.common.model.FrameworkState.a.GET_BYTES_STATE_CHANGED) {
                                if ("core-dump-unencrypted.bin".equals(frameworkState.n())) {
                                    com.getpebble.android.framework.g.m.a fromValue = com.getpebble.android.framework.g.m.a.fromValue(frameworkState.l());
                                    if (!fromValue.equals(com.getpebble.android.framework.g.m.a.IN_PROGRESS)) {
                                        boolean z;
                                        if (fromValue != com.getpebble.android.framework.g.m.a.SUCCESS) {
                                            com.getpebble.android.common.b.a.f.d(b.TAG, "Core dump not returned: " + fromValue);
                                            z = false;
                                        } else {
                                            z = true;
                                            b.this.mCoreDumpFilename = frameworkState.m();
                                        }
                                        com.getpebble.android.framework.b.b(this);
                                        synchronized (b.this) {
                                            b.this.mHasCoreDump = Boolean.valueOf(z);
                                            b.this.mComplete = b.this.isComplete();
                                        }
                                        b.this.sendPing();
                                        new d().submit();
                                    }
                                }
                            } else if (frameworkState.a() == com.getpebble.android.common.model.FrameworkState.a.LOG_CORE_DUMP_PING) {
                                b.this.sendPing();
                            }
                        }
                    }
                });
                return;
            }
            com.getpebble.android.common.b.a.f.a(TAG, "No core dump can be returned because another getBytes is in progress");
            synchronized (this) {
                this.mHasCoreDump = Boolean.valueOf(false);
                this.mComplete = isComplete();
            }
            new d().submit();
        } else {
            com.getpebble.android.common.b.a.f.d(TAG, "Not fetching core dump; auto-upload enabled");
            synchronized (this) {
                this.mHasCoreDump = Boolean.valueOf(false);
                this.mComplete = isComplete();
            }
            new d().submit();
        }
    }

    private void fetchLogDump() {
        com.getpebble.android.common.b.a.f.d(TAG, "fetchLogDump()");
        com.getpebble.android.framework.d x = PebbleApplication.x();
        com.getpebble.android.common.model.ak.a loadLastConnectedDeviceRecord = loadLastConnectedDeviceRecord();
        if (loadLastConnectedDeviceRecord.isEmpty()) {
            com.getpebble.android.common.b.a.f.a(TAG, "No device logs or core dumps can be returned, no connected devices");
            synchronized (this) {
                this.mHasLogDump = Boolean.valueOf(false);
                this.mHasCoreDump = Boolean.valueOf(false);
                this.mComplete = isComplete();
            }
            new d().submit();
            return;
        }
        x.d(loadLastConnectedDeviceRecord.pebbleDevice);
        com.getpebble.android.framework.b.a(new com.getpebble.android.framework.b.a() {
            public void onFrameworkStateChanged(FrameworkState frameworkState) {
                if (frameworkState != null && frameworkState.a() != null) {
                    if (frameworkState.a() == com.getpebble.android.common.model.FrameworkState.a.LOG_DUMP_COMPLETE) {
                        boolean z;
                        com.getpebble.android.common.b.a.f.d(b.TAG, "Log dump complete");
                        com.getpebble.android.framework.g.s.a fromValue = com.getpebble.android.framework.g.s.a.fromValue(frameworkState.o());
                        if (fromValue != com.getpebble.android.framework.g.s.a.SUCCESS) {
                            com.getpebble.android.common.b.a.f.d(b.TAG, "Log dump not returned: " + fromValue);
                            z = false;
                        } else {
                            z = true;
                            b.this.mLogDumpFilename = frameworkState.p();
                        }
                        com.getpebble.android.framework.b.b(this);
                        synchronized (b.this) {
                            b.this.mHasLogDump = Boolean.valueOf(z);
                            b.this.mComplete = b.this.isComplete();
                        }
                        b.this.sendPing();
                        b.this.fetchCoreDump();
                    } else if (frameworkState.a() == com.getpebble.android.common.model.FrameworkState.a.LOG_CORE_DUMP_PING) {
                        b.this.sendPing();
                    }
                }
            }
        });
    }

    public static File getSupportFile(Context context, String str) {
        if (useFileProvider()) {
            return new File(getFileProviderDir(context), str);
        }
        return new File(context.getExternalFilesDir(null), str);
    }

    public static File getFileProviderDir(Context context) {
        File file = new File(context.getFilesDir(), context.getString(R.string.file_provider_path));
        file.mkdirs();
        return file;
    }

    private static boolean useFileProvider() {
        return VERSION.SDK_INT > 22;
    }

    public ArrayList<Uri> getAttachmentUris() {
        File file;
        ArrayList<Uri> arrayList = new ArrayList();
        if (this.mHasCoreDump != null && this.mHasCoreDump.booleanValue()) {
            file = new File(this.mCoreDumpFilename);
            if (file.exists()) {
                arrayList.add(getFileUri(this.mContext, file));
                this.mAttachmentSizes.put("coreDump", Long.valueOf(file.length()));
            } else {
                com.getpebble.android.common.b.a.f.a(TAG, "Could not find core dump file.");
            }
        }
        if (this.mHasLogDump != null && this.mHasLogDump.booleanValue()) {
            file = new File(this.mLogDumpFilename);
            if (file.exists()) {
                arrayList.add(getFileUri(this.mContext, file));
                this.mAttachmentSizes.put("logDump", Long.valueOf(file.length()));
            } else {
                com.getpebble.android.common.b.a.f.a(TAG, "Could not find log dump file");
            }
        }
        arrayList.addAll(a.a(this.mContext, 2000000, this.mAttachmentSizes));
        return arrayList;
    }

    public static Uri getFileUri(Context context, File file) {
        if (useFileProvider()) {
            return FileProvider.a(context, context.getString(R.string.file_provider_authority), file);
        }
        return Uri.fromFile(file);
    }

    File createSupportAttachment(Context context, String str, boolean z, String str2, c cVar) {
        Throwable th;
        Throwable th2;
        PrintStream printStream = null;
        File supportAttachmentFile = getSupportAttachmentFile(context);
        if (supportAttachmentFile.exists() && !com.getpebble.android.common.c.c.a(supportAttachmentFile)) {
            com.getpebble.android.common.b.a.f.a(TAG, "Unable to delete previous support attachment file");
        }
        File supportAttachmentFile2 = getSupportAttachmentFile(context);
        if (isExternalStorageWritable()) {
            try {
                supportAttachmentFile2.deleteOnExit();
                OutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(supportAttachmentFile2));
                PrintStream printStream2 = new PrintStream(zipOutputStream);
                try {
                    File databasePath;
                    zipOutputStream.putNextEntry(new ZipEntry("notifications.log"));
                    com.getpebble.android.common.model.an.catTableToStream(context.getContentResolver(), printStream2);
                    zipOutputStream.closeEntry();
                    zipOutputStream.putNextEntry(new ZipEntry("android-logs.log"));
                    catSupportLogsToStream(printStream2, context, str, z, str2, cVar);
                    zipOutputStream.closeEntry();
                    zipOutputStream.putNextEntry(new ZipEntry("misc.log"));
                    catSupportDumpsToStream(printStream2, context);
                    zipOutputStream.closeEntry();
                    zipOutputStream.putNextEntry(new ZipEntry("locker.log"));
                    com.getpebble.android.common.model.am.a(context.getContentResolver(), printStream2);
                    zipOutputStream.closeEntry();
                    if (this.mIncludeHealth) {
                        zipOutputStream.putNextEntry(new ZipEntry("health.sqlite"));
                        databasePath = context.getDatabasePath("health");
                        this.mAttachmentSizes.put("rawHealthFile", Long.valueOf(databasePath.length()));
                        catFileToStream(databasePath, printStream2);
                        zipOutputStream.closeEntry();
                    }
                    if (PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.DATALOGGING_DEBUG, false)) {
                        zipOutputStream.putNextEntry(new ZipEntry("datalogging.db3"));
                        catFileToStream(this.mContext.getDatabasePath("data_logging"), printStream2);
                        zipOutputStream.closeEntry();
                    }
                    zipOutputStream.putNextEntry(new ZipEntry("timeline.log"));
                    aw.a(context.getContentResolver(), printStream2);
                    printStream2.println("\nCalendars:\n");
                    o.a(context.getContentResolver(), printStream2);
                    printStream2.println("\nMappers:\n");
                    av.a(context.getContentResolver(), printStream2);
                    printStream2.println("\nSaved weather locations:\n");
                    WeatherLocationsModel.catTableToStream(context.getContentResolver(), printStream2);
                    zipOutputStream.closeEntry();
                    zipOutputStream.putNextEntry(new ZipEntry("devices.log"));
                    ak.catTableToStream(context.getContentResolver(), printStream2);
                    printStream2.println("\nManifests:\n");
                    al.a(context.getContentResolver(), printStream2);
                    zipOutputStream.closeEntry();
                    cVar.onPing();
                    databasePath = new File("/data/anr/traces.txt");
                    if (databasePath.exists()) {
                        this.mAttachmentSizes.put("rawTraces", Long.valueOf(databasePath.length()));
                        if (databasePath.length() > 2000000) {
                            com.getpebble.android.common.b.a.f.b(TAG, "Not attaching ANR traces file, as it is too big! (" + databasePath.length() + ")");
                        } else {
                            zipOutputStream.putNextEntry(new ZipEntry("traces.log"));
                            catFileToStream(databasePath, printStream2);
                            zipOutputStream.closeEntry();
                        }
                    }
                    databasePath = new File("/sdcard/btsnoop_hci.log");
                    if (databasePath.exists()) {
                        this.mAttachmentSizes.put("rawHci", Long.valueOf(databasePath.length()));
                        if (databasePath.length() > MAX_BT_SNOOP_SIZE_BYTES) {
                            com.getpebble.android.common.b.a.f.b(TAG, "Not attaching BT snoop file, as it is too big! (" + databasePath.length() + ")");
                        } else {
                            zipOutputStream.putNextEntry(new ZipEntry("hci.log"));
                            catFileToStream(databasePath, printStream2);
                            zipOutputStream.closeEntry();
                        }
                    }
                    if (d.HEALTH.equals(this.mTarget)) {
                        zipOutputStream.putNextEntry(new ZipEntry("activity-chart-data.json"));
                        catFileToStream(com.getpebble.android.common.c.c.a("health-chart-debug", com.getpebble.android.main.sections.mypebble.d.b.c.ACTIVITY.debugJsonDumpFilePath), printStream2);
                        zipOutputStream.closeEntry();
                        zipOutputStream.putNextEntry(new ZipEntry("sleep-chart-data.json"));
                        catFileToStream(com.getpebble.android.common.c.c.a("health-chart-debug", com.getpebble.android.main.sections.mypebble.d.b.c.SLEEP.debugJsonDumpFilePath), printStream2);
                        zipOutputStream.closeEntry();
                        zipOutputStream.putNextEntry(new ZipEntry("heart-chart-data.json"));
                        catFileToStream(com.getpebble.android.common.c.c.a("health-chart-debug", com.getpebble.android.main.sections.mypebble.d.b.c.HEART_RATE.debugJsonDumpFilePath), printStream2);
                        zipOutputStream.closeEntry();
                    }
                    zipOutputStream.putNextEntry(new ZipEntry("health-chart-manifest.json"));
                    printStream2.write(com.getpebble.android.common.framework.b.f.a(context, "manifest.json", false).getBytes());
                    zipOutputStream.closeEntry();
                    com.getpebble.android.framework.jskit.c.c.a(context, zipOutputStream, printStream2);
                    printStream2.flush();
                    com.getpebble.android.common.b.a.f.d(TAG, "zipEntry final written size = " + com.getpebble.android.common.c.f.a(ZipOutputStream.class, zipOutputStream, "written"));
                    if (printStream2 != null) {
                        printStream2.flush();
                        printStream2.close();
                    }
                } catch (Throwable e) {
                    th = e;
                    printStream = printStream2;
                    th2 = th;
                    try {
                        com.getpebble.android.common.b.a.f.a(TAG, "Unhandled exception thrown when creating support attachment", th2);
                        if (printStream != null) {
                            printStream.flush();
                            printStream.close();
                        }
                        return supportAttachmentFile2;
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (printStream != null) {
                            printStream.flush();
                            printStream.close();
                        }
                        throw th2;
                    }
                } catch (Throwable e2) {
                    th = e2;
                    printStream = printStream2;
                    th2 = th;
                    if (printStream != null) {
                        printStream.flush();
                        printStream.close();
                    }
                    throw th2;
                }
            } catch (Exception e3) {
                th2 = e3;
                com.getpebble.android.common.b.a.f.a(TAG, "Unhandled exception thrown when creating support attachment", th2);
                if (printStream != null) {
                    printStream.flush();
                    printStream.close();
                }
                return supportAttachmentFile2;
            }
            return supportAttachmentFile2;
        }
        com.getpebble.android.common.b.a.f.c(TAG, "Unable to get support attachment, external storage not writable");
        return null;
    }

    static void catFileToStream(File file, PrintStream printStream) {
        InputStream fileInputStream;
        Throwable e;
        if (file.exists()) {
            try {
                byte[] bArr = new byte[1024];
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        printStream.write(bArr, 0, read);
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e3) {
                        com.getpebble.android.common.b.a.f.a(TAG, "catFileToStream: ", e3);
                    }
                }
            } catch (IOException e4) {
                e3 = e4;
                fileInputStream = null;
                try {
                    com.getpebble.android.common.b.a.f.a(TAG, "catFileToStream: Unhandled exception thrown when creating support attachment", e3);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e32) {
                            com.getpebble.android.common.b.a.f.a(TAG, "catFileToStream: ", e32);
                        }
                    }
                } catch (Throwable th) {
                    e32 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e5) {
                            com.getpebble.android.common.b.a.f.a(TAG, "catFileToStream: ", e5);
                        }
                    }
                    throw e32;
                }
            } catch (Throwable th2) {
                e32 = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e32;
            }
        }
    }

    static void catSupportLogsToStream(PrintStream printStream, Context context, String str, boolean z, String str2, c cVar) {
        printStream.println("\n# Device info:");
        printStream.println("\nAccount: " + str2);
        printStream.print(str);
        printStream.println("\n# BT Apps:");
        try {
            printStream.print(getInstalledBluetoothApps(context.getPackageManager()));
        } catch (NameNotFoundException e) {
            com.getpebble.android.common.b.a.f.b(TAG, "catSupportLogsToStream: error dumping BT apps");
            if (!z) {
                printStream.println("\n# Phone logs:");
                printStream.println("\nUTC Offset: " + TimeUnit.MILLISECONDS.toMinutes((long) TimeZone.getDefault().getOffset(System.currentTimeMillis())));
                catFileToStream(new File(com.getpebble.android.common.b.a.d.a(context)), printStream);
                cVar.onPing();
            }
        } catch (RuntimeException e2) {
            com.getpebble.android.common.b.a.f.b(TAG, "catSupportLogsToStream: error dumping BT apps");
            if (!z) {
                printStream.println("\n# Phone logs:");
                printStream.println("\nUTC Offset: " + TimeUnit.MILLISECONDS.toMinutes((long) TimeZone.getDefault().getOffset(System.currentTimeMillis())));
                catFileToStream(new File(com.getpebble.android.common.b.a.d.a(context)), printStream);
                cVar.onPing();
            }
        }
        if (!z) {
            printStream.println("\n# Phone logs:");
            printStream.println("\nUTC Offset: " + TimeUnit.MILLISECONDS.toMinutes((long) TimeZone.getDefault().getOffset(System.currentTimeMillis())));
            catFileToStream(new File(com.getpebble.android.common.b.a.d.a(context)), printStream);
            cVar.onPing();
        }
    }

    void catSupportDumpsToStream(PrintStream printStream, Context context) {
        printStream.println("\n# Phone files:");
        catFileListToStream(printStream, context);
        printStream.println("\n# Preferences:");
        as.a(context.getContentResolver(), printStream);
        printStream.println("\n# Language packs:");
        ab.a(context.getContentResolver(), printStream);
        printStream.println("\n# Boot config:");
        com.getpebble.android.config.a w = PebbleApplication.w();
        if (w == null) {
            printStream.println("\n# <not available>");
            com.getpebble.android.common.b.a.f.c(TAG, "bootConfig is null");
        } else {
            w.a(printStream);
        }
        printStream.println("\n# Events");
        au.a(printStream, context.getContentResolver());
    }

    private static File getSupportAttachmentFile(Context context) {
        return getSupportFile(context, SUPPORT_ATTACHMENT_FILE_NAME);
    }

    private static String getInstalledBluetoothApps(PackageManager packageManager) {
        if (packageManager == null) {
            com.getpebble.android.common.b.a.f.d(TAG, "Cannot fetch Bluetooth apps with null package manager");
            return "";
        }
        Object treeSet = new TreeSet();
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(128);
        if (installedApplications == null) {
            com.getpebble.android.common.b.a.f.d(TAG, "ApplicationInfoList is null");
            return "";
        }
        for (ApplicationInfo applicationInfo : installedApplications) {
            try {
                Object obj;
                Object obj2;
                String[] strArr = packageManager.getPackageInfo(applicationInfo.packageName, 4096).requestedPermissions;
                if (strArr != null) {
                    obj = null;
                    obj2 = null;
                    for (Object obj3 : strArr) {
                        if (PERM_BLUETOOTH.equals(obj3)) {
                            obj = 1;
                        } else if (PERM_BLUETOOTH_ADMIN.equals(obj3)) {
                            int i = 1;
                        }
                    }
                } else {
                    obj = null;
                    obj2 = null;
                }
                if (obj != null || obj2 != null) {
                    treeSet.add(applicationInfo.packageName + (obj2 != null ? " (admin)" : "") + (BAD_BLUETOOTH_APPS.contains(applicationInfo.packageName) ? " - KNOWN ISSUES WITH APP! PBL-38975" : ""));
                }
            } catch (Throwable e) {
                com.getpebble.android.common.b.a.f.a(TAG, "Failed to find package", e);
            }
        }
        return new g().b().c().b(treeSet);
    }

    private void catFileListToStream(PrintStream printStream, Context context) {
        printStream.println("Total size for all files: " + ((((((((((((dumpFileUsageToStream(context.getExternalFilesDir(null), printStream) + 0) + dumpFileUsageToStream(context.getFilesDir(), printStream)) + dumpFileUsageToStream(context.getCacheDir(), printStream)) + dumpFileUsageToStream(context.getDir("logs", 0), printStream)) + dumpFileUsageToStream(context.getDir("languages", 0), printStream)) + dumpFileUsageToStream(context.getDir("apps", 0), printStream)) + dumpFileUsageToStream(context.getDir("apps_cache", 0), printStream)) + dumpFileUsageToStream(context.getDir("firmware", 0), printStream)) + dumpFileUsageToStream(context.getDir("appstore", 0), printStream)) + dumpFileUsageToStream(context.getDir(com.getpebble.android.framework.jskit.c.a(), 0), printStream)) + dumpFileUsageToStream(context.getDir("auto_core", 0), printStream)) + dumpFileUsageToStream(context.getDatabasePath("data_logging").getParentFile(), printStream)));
    }

    private int dumpFileUsageToStream(File file, final PrintStream printStream) {
        this.mDirSize = 0;
        if (file == null) {
            com.getpebble.android.common.b.a.f.b(TAG, "null dir to dump");
            return 0;
        } else if (printStream == null) {
            com.getpebble.android.common.b.a.f.b(TAG, "Null output stream");
            return 0;
        } else {
            com.getpebble.android.common.b.a.f.d(TAG, "walking.. " + file.toString());
            try {
                com.getpebble.android.common.c.c.a(file, new com.getpebble.android.common.c.c.a() {
                    public void directoryFound(File file) {
                        printStream.println("Dir: " + file.getAbsoluteFile());
                    }

                    public void fileFound(File file) {
                        String str = "File: " + file.getAbsoluteFile() + " Size: " + file.length() + " Modified: " + DateFormat.getDateTimeInstance().format(new Date(file.lastModified()));
                        b.this.mDirSize = (int) (((long) b.this.mDirSize) + file.length());
                        printStream.println(str);
                    }
                });
            } catch (Throwable e) {
                com.getpebble.android.common.b.a.f.a(TAG, "dumpFileUsageToStream", e);
            }
            printStream.println("Size for dir " + file + ": " + this.mDirSize + "\n");
            return this.mDirSize;
        }
    }
}
