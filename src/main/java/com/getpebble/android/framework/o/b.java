package com.getpebble.android.framework.o;

import android.text.TextUtils;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ab;
import com.getpebble.android.common.model.v;

public class b {
    private static final v GET_BYTES_FILE_SUPPORT = new v("v3.2", 0);
    private static final v HAPPY_MEAL = new v("v1.8.1", 0);
    private static final v HEALTH_ANALYTICS_COLLECTION_REMOVED = new v("v3.14", 0);
    private static final int PEBBLE_FACTORY_LANGUAGE_VERSION = 1;
    private static final String PEBBLE_FACTORY_LOCALE = "en_US";
    private static final v PRE_VERSION_TWO_LANGUAGE_PACK_SUPPORT = new v("v2.7", 0);
    private static final String TAG = "PebbleCapabilities";
    public final boolean[] mCapabilities;
    public final boolean support8kAppMessage;
    public final boolean supportsAppRunStateProtocol;
    public final boolean supportsExtendedMusicProtocol;
    public final boolean supportsFwUpdateAcrossDisconnection;
    public final boolean supportsHealthInsights;
    public final boolean supportsInfiniteLogDump;
    public final boolean supportsLocalization;
    public final boolean supportsRemindersApp;
    public final boolean supportsSendTextApp;
    public final boolean supportsSmoothFwInstallProgressSupport;
    public final boolean supportsTwoWayDismissal;
    public final boolean supportsUnreadCoreDump;
    public final boolean supportsWeatherApp;
    public final boolean supportsWorkoutApp;

    public static class a {
        public static boolean isLanguageSupported() {
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            return r != null && r.capabilities.supportsLocalization;
        }

        public static boolean isLanguageOnboardingRequired() {
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            boolean z = r != null && r.capabilities.supportsLocalization;
            if (z) {
                return b.isPebbleLanguageFactoryDefault(r.getIsoLocale(), r.getLanguageVersion());
            }
            f.d(b.TAG, "isLanguageOnboardingRequired: No, because l10n is not supported");
            return false;
        }

        public static boolean isInPrf() {
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            return r != null && r.isRunningRecoveryFw;
        }

        public static int getSupportedLanguagesCount() {
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            if (r == null) {
                return 0;
            }
            return ab.a(com.getpebble.android.common.a.K().getContentResolver(), r.getFwVersion(), r.hwPlatform);
        }

        public static boolean isSendTextAppSupported() {
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            return r != null && r.capabilities.supportsSendTextApp;
        }

        public static boolean supportsUnreadCoreDump() {
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            return r != null && r.capabilities.supportsUnreadCoreDump;
        }

        public static boolean isWeatherAppSupported() {
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            return r != null && r.capabilities.supportsWeatherApp;
        }

        public static boolean isWorkoutAppSupported() {
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            return r != null && r.capabilities.supportsWorkoutApp;
        }

        public static boolean isSmoothFwInstallProgressSupported() {
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            return r != null && r.capabilities.supportsSmoothFwInstallProgressSupport;
        }

        public static boolean isRemindersAppSupported() {
            return false;
        }
    }

    public b(boolean[] zArr) {
        if (zArr == null) {
            this.mCapabilities = new boolean[64];
        } else {
            this.mCapabilities = zArr;
        }
        this.supportsAppRunStateProtocol = this.mCapabilities[0];
        this.supportsInfiniteLogDump = this.mCapabilities[1];
        this.supportsExtendedMusicProtocol = this.mCapabilities[2];
        this.supportsTwoWayDismissal = this.mCapabilities[3];
        this.supportsLocalization = this.mCapabilities[4];
        this.support8kAppMessage = this.mCapabilities[5];
        this.supportsHealthInsights = this.mCapabilities[6];
        this.supportsSendTextApp = this.mCapabilities[8];
        this.supportsUnreadCoreDump = this.mCapabilities[10];
        this.supportsWeatherApp = this.mCapabilities[11];
        this.supportsRemindersApp = this.mCapabilities[12];
        this.supportsWorkoutApp = this.mCapabilities[13];
        this.supportsFwUpdateAcrossDisconnection = this.mCapabilities[21];
        this.supportsSmoothFwInstallProgressSupport = this.mCapabilities[14];
    }

    public static b from(byte[] bArr) {
        if (bArr == null) {
            return new b(null);
        }
        return new b(com.getpebble.android.bluetooth.b.b.f(bArr));
    }

    public byte[] serialize() {
        return com.getpebble.android.bluetooth.b.b.a(this.mCapabilities);
    }

    public static boolean remoteSendsFirmwareUpdateAck(v vVar) {
        return vVar.compareTo(HAPPY_MEAL) >= 0;
    }

    public static boolean remoteSupportsGetBytes(v vVar) {
        return vVar.compareTo(GET_BYTES_FILE_SUPPORT) >= 0 && !TextUtils.isEmpty(vVar.getSuffix());
    }

    public static boolean remoteCollectsHealthAnalytics(v vVar) {
        return vVar.compareTo(HEALTH_ANALYTICS_COLLECTION_REMOVED) < 0;
    }

    public static boolean remoteSupportsLanguagePackVersionMessageEntry(v vVar) {
        return vVar.compareTo(PRE_VERSION_TWO_LANGUAGE_PACK_SUPPORT) > 0;
    }

    public static boolean isPebbleLanguageFactoryDefault(String str, int i) {
        return PEBBLE_FACTORY_LOCALE.equals(str) && 1 == i;
    }

    public static boolean isHealthSupported() {
        com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
        return p != null && p.capabilities.supportsHealthInsights;
    }
}
