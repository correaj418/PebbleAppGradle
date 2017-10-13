package com.getpebble.android.common.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Resources;
import android.text.TextUtils;
import com.getpebble.android.basalt.R;
import com.getpebble.android.h.p;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class c {
    public static final long a = TimeUnit.DAYS.toMillis(1);
    private final Resources b;
    private SharedPreferences c;

    public enum a {
        VERSION(R.string.pref_key_version),
        DEVELOPER_CONNECTION_ACTIVE(R.string.pref_key_developer_connection_active),
        DEVELOPER_MODE(R.string.pref_key_developer_mode_enable),
        MUSIC_TARGET_PKG(R.string.pref_key_music_target_package),
        MUSIC_TARGET_NAME(R.string.pref_key_music_target_name),
        SYNC_INTERVAL(R.string.pref_key_sync_interval),
        NAGGED_ABOUT_DISCONNECT(R.string.pref_key_nagged_about_disconnect),
        NAGGED_ABOUT_CONNECT_IS_DISCONNECT(R.string.pref_key_nagged_about_connect_is_disconnect),
        CALL_NOTIFICATIONS(R.string.pref_key_call_notifications),
        FIRMWARE_NAG_TIME(R.string.pref_key_firmware_nag_time),
        ALL_APPS(R.string.pref_key_all_apps),
        ALLOW_THIRD_PARTY_NOTIFICATIONS(R.string.pref_key_allow_3rd_party_apps),
        ALWAYS_NOTIFY(R.string.pref_key_always_notify),
        MIGRATED_TO_HOLO(R.string.pref_key_migrated_to_holo),
        ONBOARDING_COMPLETED(R.string.pref_key_has_completed_onboarding),
        ANALYTICS_OPTIN(R.string.pref_key_analytics_optin),
        TUTORIAL_COMPLETED(R.string.pref_key_has_completed_tutorial),
        INSTALLED_PEBBLE_APP_VERSION(R.string.pref_key_installed_pebble_app_version),
        DATALOGGING_DEBUG(R.string.pref_key_datalogging_debug),
        LAST_BOOTCONFIG_SYNC_MILLIS(R.string.pref_key_last_bootconfig_sync_millis),
        NOTIFICATION_ID_SEQUENCE(R.string.pref_key_notification_id_sequence),
        LANGUAGE_PACK_CATEGORY(R.string.pref_key_language_pack),
        FONT_PACK_CATEGORY(R.string.pref_key_font_pack),
        AUTO_APP_UPDATES_WIFI_ONLY(R.string.pref_key_auto_app_updates_wifi_only),
        DONE_NOTIFICATION_PREFS_TO_DB_MIGRATION(R.string.pref_key_done_notification_prefs_to_db_migration),
        VERBOSE_LOGCAT(R.string.pref_key_verbose_logcat),
        HEX_DUMP(R.string.pref_key_hex_dump),
        DISABLE_FORCED_FW_UPDATES(R.string.pref_key_disable_forced_fw_updated),
        USE_HEALTH_CHARTS_MASTER(R.string.pref_key_use_charts_master),
        DONE_NOTIFICATION_PREFS_TO_DB_MIGRATION_WITH_DELETION(R.string.pref_key_done_notification_prefs_to_db_migration_with_deletion),
        RECEIVED_POTENTIAL_WEAR_ENHANCED_NOTIFICATION(R.string.pref_key_received_potential_wear_enhanced_notification),
        BLOB_DB_LAST_SYNC_ADDRESS(R.string.pref_key_blob_db_last_sync_address),
        OBFUSCATE_NOTIFICATIONS(R.string.pref_key_obfuscate_notifications),
        LOG_NOTIFICATIONS(R.string.pref_key_log_notifications),
        WEATHER_UNITS(R.string.pref_weather_units),
        GEO_DATABASE_VERSION(R.string.pref_geo_database_version),
        BOOT_CONFIG_BASE_URL(R.string.pref_key_boot_config_base_url),
        GCM_REGISTRATION_ID(R.string.pref_key_gcm_registration_id),
        GCM_SYNC_VERSION(R.string.pref_key_gcm_sync_version),
        TIMELINE_SYNC_NEXT_URL(R.string.pref_key_timeline_web_sync_next_url),
        VOICE_LANGUAGE(R.string.pref_key_voice_language),
        DEFAULT_APPS_ADDED(R.string.pref_key_default_apps_added),
        COMPLETED_FIRST_LOCKER_CLOUD_SYNC(R.string.pref_key_completed_locker_cloud_sync),
        CLOUD_SYNC_IN_PROGRESS(R.string.pref_key_locker_sync_in_progress),
        LAST_FW_SIDELOAD_TIMESTAMP_MS(R.string.pref_key_previous_firmware_sideload_timestamp),
        LAST_LOCKER_SYNC_ATTEMPT_MILLIS(R.string.pref_key_last_locker_sync_attempt),
        LAST_INCOMING_PHONE_NUMBER(R.string.pref_key_last_incoming_phone_number),
        ANDROID_WEAR_OPTOUT(R.string.pref_key_android_wear_optout),
        ENABLE_FIT_SYNC(R.string.pref_key_enable_fit_sync),
        PRIVACY_POLICY_ACCEPTED(R.string.pref_key_privacy_policy_accepted),
        TRENDING_SEARCHES(R.string.pref_key_trending_searches),
        HEIGHT_UNIT(R.string.pref_key_height_unit),
        WEIGHT_UNIT(R.string.pref_key_weight_unit),
        MMS_LATEST_ID(R.string.pref_key_mms_count),
        LAST_HANDLED_SMS_ID(R.string.pref_key_last_handled_sms),
        DISTANCE_UNIT(R.string.pref_key_distance_units),
        NOTIFICATION_LISTENER_CRASHED(R.string.pref_key_notification_listener_crashed),
        LEGACY_DEVICE_BLUETOOTH_LE_ENABLED(R.string.pref_key_bluetooth_le_enabled),
        LAST_CORE_DUMP(R.string.pref_key_last_core_dump),
        HIDE_PERSISTENT_NOTIFICATION(R.string.pref_key_hide_persistent_notification),
        HOCKEY_LATEST_VERSION(R.string.pref_key_hockey_latest_version),
        REMINDERS_DEFAULT_CALENDAR(R.string.pref_key_reminders_default_calendar),
        HEALTH_SETTINGS_LAST_CLOUD_SYNC_HASHCODE_STRING(R.string.pref_key_health_settings_last_cloud_sync_hashcode),
        HEALTH_ACTIVITY_LAST_SYNC_ROW(R.string.pref_key_health_activity_last_sync_row),
        HEALTH_MLS_LAST_SYNC_ROW(R.string.pref_key_health_steps_last_sync_row),
        HEALTH_LAST_SYNC_TIME_MS(R.string.pref_key_health_last_sync_time_ms),
        VERBOSE_BLE_LOGGING(R.string.pref_key_ble_logging),
        DISABLE_AUTO_CORE_DUMP(R.string.pref_key_disable_auto_core_dump),
        HEALTH_ANALYTICS_OPTIN(R.string.pref_key_health_analytics_optin),
        SNEAK_PEEKS(R.string.pref_key_sneakpeeks_category, true),
        ENABLE_REMINDERS_SNEAKPEEK(R.string.pref_key_sneakpeek_reminders_enabled),
        DISABLE_BUILT_IN_SMS(R.string.pref_key_disable_built_in_sms),
        DISABLE_RESUMED_UPDATES_USER(R.string.pref_key_disable_resumed_updates_user),
        DISABLE_RESUMED_UPDATES_ERROR(R.string.pref_key_disable_resumed_updates_error),
        DONE_JSKIT_INSTALL_FIX(R.string.pref_key_done_jskit_install_fix);
        
        final boolean isCategory;
        final int resId;

        private a(int i, boolean z) {
            this.resId = i;
            this.isCategory = z;
        }

        private a(int i) {
            this(r2, r3, i, false);
        }

        public int getResId() {
            return this.resId;
        }

        public boolean isCategory() {
            return this.isCategory;
        }
    }

    public c(Context context) {
        this.c = a(context);
        this.b = context.getResources();
    }

    public static SharedPreferences a(Context context) {
        if (context != null) {
            return context.getSharedPreferences("PEBBLE_PREFERENCES", 0);
        }
        throw new IllegalArgumentException("Cannot retrieve shared preferences with null context");
    }

    public SharedPreferences a() {
        return this.c;
    }

    public Set<String> a(a aVar, Set<String> set) {
        return this.c.getStringSet(a(aVar), set);
    }

    public void b(a aVar, Set<String> set) {
        this.c.edit().putStringSet(a(aVar), set).apply();
    }

    public String a(a aVar, String str) {
        return this.c.getString(a(aVar), str);
    }

    public void b(a aVar, String str) {
        this.c.edit().putString(a(aVar), str).apply();
    }

    public long a(a aVar, long j) {
        return this.c.getLong(a(aVar), j);
    }

    public void b(a aVar, long j) {
        this.c.edit().putLong(a(aVar), j).apply();
    }

    public boolean a(a aVar, boolean z) {
        return this.c.getBoolean(a(aVar), z);
    }

    public void b(a aVar, boolean z) {
        this.c.edit().putBoolean(a(aVar), z).apply();
    }

    public int a(a aVar, int i) {
        return this.c.getInt(a(aVar), i);
    }

    public void b(a aVar, int i) {
        this.c.edit().putInt(a(aVar), i).apply();
    }

    public void a(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.c.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void b(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.c.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public String a(a aVar) {
        return this.b.getString(aVar.getResId());
    }

    public static final boolean b(Context context) {
        return System.currentTimeMillis() - new c(context).a(a.FIRMWARE_NAG_TIME, 0) > a;
    }

    public static final void c(Context context) {
        new c(context).b(a.FIRMWARE_NAG_TIME, System.currentTimeMillis());
    }

    public static final void a(Map<Integer, String> map) {
        Editor edit = a(com.getpebble.android.common.a.K()).edit();
        edit.putString("canned_response_", p.a(map));
        edit.commit();
    }

    public static Map<Integer, String> b() {
        return (HashMap) p.a(a(com.getpebble.android.common.a.K()).getString("canned_response_", null), new com.google.b.c.a<Map<Integer, String>>() {
        }.getType());
    }

    public static Map<Integer, String> c() {
        Map b = b();
        Map<Integer, String> hashMap = new HashMap();
        if (b != null) {
            for (Integer num : b.keySet()) {
                String str = (String) b.get(num);
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put(num, str);
                }
            }
        }
        return hashMap.isEmpty() ? null : hashMap;
    }
}
