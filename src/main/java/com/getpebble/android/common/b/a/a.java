package com.getpebble.android.common.b.a;

import android.text.TextUtils;
import android.util.Log;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.Transport;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel.Record;
import com.getpebble.android.common.model.v;
import com.getpebble.android.h.ab;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class a {

    public static class a {

        public static class a {

            public enum a {
                ;
                
                public final String nameValue;

                private a(java.lang.String r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                    /*
                    r0 = this;
                    r0.<init>(r1, r2);
                    r0.nameValue = r3;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.common.b.a.a.a.a.a.<init>(java.lang.String, int, java.lang.String):void");
                }
            }
        }

        public static class b {

            public enum a {
                ;
                
                final String id;

                private a(java.lang.String r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                    /*
                    r0 = this;
                    r0.<init>(r1, r2);
                    r0.id = r3;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.common.b.a.a.a.b.a.<init>(java.lang.String, int, java.lang.String):void");
                }
            }
        }

        public static class c {

            public enum a {
            }
        }
    }

    public static class b {

        public enum a {
            PIN_ACTIVE_NOTIFICATION_MUTED,
            PIN_ACTIVE_NOTIFICATION_UNMUTED,
            PIN_INACTIVE
        }
    }

    public static class c {

        public enum a {
            INCOMING_CALL("incoming_call_custom_responses_configured"),
            CANNED_RESPONSES("custom_responses_configured"),
            SEND_TEXT("send_text_messages_configured");
            
            private final String eventType;

            private a(String str) {
                this.eventType = str;
            }

            public String getEventType() {
                return this.eventType;
            }
        }

        public static void a(String str, String str2) {
            Map hashMap = new HashMap();
            hashMap.put("font_url_boot", str);
            hashMap.put("font_url_request", str2);
            a.b("mobile-app-behavior", "font_pack_request", hashMap);
        }

        public static void a(int i) {
            Map hashMap = new HashMap();
            hashMap.put("font_response_count", Integer.valueOf(i));
            a.b("mobile-app-behavior", "font_pack_response", hashMap);
        }

        public static void b(int i) {
            Map hashMap = new HashMap();
            hashMap.put("language_displayed_count", Integer.valueOf(i));
            a.b("mobile-app-behavior", "language_packs_displayed", hashMap);
        }

        public static void a() {
            a.b("mobile-app-behavior", "language_settings_opened", null);
        }

        public static void a(String str) {
            Map hashMap = new HashMap();
            hashMap.put(ak.ISO_LOCALE, str);
            a.b("mobile-app-behavior", "language_pack_install_success", hashMap);
        }

        public static void b(String str) {
            Map hashMap = new HashMap();
            hashMap.put(ak.ISO_LOCALE, str);
            a.b("mobile-app-behavior", "language_pack_install_failed", hashMap);
        }

        public static void a(com.getpebble.android.common.model.e eVar) {
            if (eVar != null && eVar.uuid != null) {
                b(eVar.title, eVar.uuid.toLowerCase(Locale.US));
            }
        }

        public static void b(String str, String str2) {
            if (!a.a(str) && !a.b(str2)) {
                Map hashMap = new HashMap();
                hashMap.put("name", str);
                hashMap.put("uuid", str2.toLowerCase(Locale.US));
                Map hashMap2 = new HashMap();
                hashMap2.put("app", hashMap);
                a.b("mobile-app-behavior", "add_to_locker_from_webview_requested", hashMap2);
            }
        }

        public static void c(String str, String str2) {
            if (!a.a(str) && !a.b(str2)) {
                Map hashMap = new HashMap();
                hashMap.put("name", str);
                hashMap.put("uuid", str2.toLowerCase(Locale.US));
                Map hashMap2 = new HashMap();
                hashMap2.put("app", hashMap);
                a.b("mobile-app-behavior", "add_to_locker_from_search_requested", hashMap2);
            }
        }

        public static void d(String str, String str2) {
            if (!a.a(str) && !a.b(str2)) {
                Map hashMap = new HashMap();
                hashMap.put("name", str);
                hashMap.put("id", str2);
                Map hashMap2 = new HashMap();
                hashMap2.put("app", hashMap);
                a.b("mobile-app-behavior", "get_companion_app_from_search_requested", hashMap2);
            }
        }

        public static void e(String str, String str2) {
            if (!a.a(str) && !a.a(str2)) {
                Map hashMap = new HashMap();
                hashMap.put("button_id", str);
                hashMap.put("screen", str2);
                a.b("mobile-app-behavior", "button_tapped", hashMap);
            }
        }

        public static void b() {
            a.b("mobile-app-behavior", "developer_mode_on", null);
        }

        public static void c() {
            a.b("mobile-app-behavior", "developer_mode_off", null);
        }

        public static void a(String str, String str2, String str3) {
            if (!a.a(str) && !a.a(str2) && !a.a(str3)) {
                Map hashMap = new HashMap();
                hashMap.put(ak.FW_VERSION, str);
                hashMap.put("fw_version_shortname", str2);
                hashMap.put("fw_version_timestamp", str3);
                Map hashMap2 = new HashMap();
                hashMap2.put("firmware", hashMap);
                a.b("mobile-app-behavior", "fw_update_available", hashMap2);
            }
        }

        public static void c(String str) {
            Map hashMap = new HashMap();
            hashMap.put(ak.FW_VERSION, str);
            Map hashMap2 = new HashMap();
            hashMap2.put("firmware", hashMap);
            a.b("mobile-app-behavior", "fw_no_update_found", hashMap2);
        }

        public static void d() {
            a.b("mobile-app-behavior", "fw_update_server_unreachable", null);
        }

        public static void f(String str, String str2) {
            f.e("Analytics", "logFwInstallStart: fwVersion = " + str + ", fwType = " + str2);
            Map hashMap = new HashMap();
            hashMap.put(ak.FW_VERSION, str);
            hashMap.put("fw_type", str2);
            Map hashMap2 = new HashMap();
            hashMap2.put("firmware", hashMap);
            a.b("mobile-app-behavior", "fw_install_start", hashMap2);
        }

        public static void g(String str, String str2) {
            f.e("Analytics", "logFwInstallStart: fwVersion = " + str + ", fwType = " + str2);
            Map hashMap = new HashMap();
            hashMap.put(ak.FW_VERSION, str);
            hashMap.put("fw_type", str2);
            Map hashMap2 = new HashMap();
            hashMap2.put("firmware", hashMap);
            a.b("mobile-app-behavior", "fw_install_auto_restart", hashMap2);
        }

        private static String p() {
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            return r != null ? r.getFwVersion().getVersionTag() : null;
        }

        private static a a(String str, com.getpebble.android.framework.g.r.a aVar) {
            if (aVar.equals(com.getpebble.android.framework.g.r.a.OK)) {
                String p = p();
                if (!TextUtils.isEmpty(p)) {
                    v vVar = new v(p, 0);
                    v vVar2 = new v(str, 0);
                    if (!(vVar.getMajor() == vVar2.getMajor() && vVar.getMinor() == vVar2.getMinor() && vVar.getPoint() == vVar2.getPoint())) {
                        f.b("Analytics", "getAnalyticsResult: the watch has an unexpected fw version " + p + ", we expect " + str);
                        return a.FAILED_WRONG_VERSION;
                    }
                }
                return a.SUCCESS;
            } else if (aVar.equals(com.getpebble.android.framework.g.r.a.TIMEOUT)) {
                return a.FAILED_TIMEOUT;
            } else {
                if (aVar.equals(com.getpebble.android.framework.g.r.a.WRONG_HW_VERSION)) {
                    return a.FAILED_INCOMPATIBLE_FIRMWARE;
                }
                if (aVar.equals(com.getpebble.android.framework.g.r.a.INVALID_FIRMWARE_CRC) || aVar.equals(com.getpebble.android.framework.g.r.a.INVALID_RESOURCE_CRC) || aVar.equals(com.getpebble.android.framework.g.r.a.FIRMWARE_LOAD_FAILED) || aVar.equals(com.getpebble.android.framework.g.r.a.RESOURCE_LOAD_FAILED) || aVar.equals(com.getpebble.android.framework.g.r.a.FIRMWARE_START_FAILED)) {
                    return a.FAILED_WATCH_REJECTED;
                }
                return null;
            }
        }

        public static void a(String str, String str2, com.getpebble.android.framework.g.r.a aVar) {
            a a = a(str, aVar);
            f.e("Analytics", "logFwUpdateComplete: fwVersion = " + str + ", fwType = " + str2 + ", fwInstallResult = " + a);
            Map hashMap = new HashMap();
            hashMap.put(ak.FW_VERSION, str);
            hashMap.put("fw_type", str2);
            Map hashMap2 = new HashMap();
            hashMap2.put("firmware", hashMap);
            hashMap2.put("update_result", a == null ? null : a.nameValue);
            a.b("mobile-app-behavior", "fw_update_complete", hashMap2);
        }

        public static void e() {
            f.e("Analytics", "logFwMigrationStart: ");
            a.b("mobile-app-behavior", "fw_migration_start", null);
        }

        public static void f() {
            f.e("Analytics", "logFwMigrationAbort: ");
            a.b("mobile-app-behavior", "fw_migration_abort", null);
        }

        public static void g() {
            f.e("Analytics", "logFwUpdateFailed: ");
            a.b("mobile-app-behavior", "fw_update_failed", null);
        }

        public static void a(boolean z) {
            HashMap hashMap = new HashMap();
            a.b("mobile-app-behavior", z ? "logging_enabled" : "logging_disabled");
        }

        public static void h() {
            a.b("mobile-app-behavior", "mobile_app_backgrounded", null);
        }

        public static void i() {
            a.b("mobile-app-behavior", "mobile_app_foregrounded", null);
        }

        public static void d(String str) {
            if (!a.a(str)) {
                Map hashMap = new HashMap();
                hashMap.put("screen", str);
                a.b("mobile-app-behavior", "screen_appeared", hashMap);
            }
        }

        public static void j() {
            a.b("mobile-app-behavior", "mobile_alert_menu_tapped", new HashMap());
        }

        public static void k() {
            a.b("mobile-app-behavior", "my_pbl_search_tapped", new HashMap());
        }

        public static void l() {
            a.b("mobile-app-behavior", "search_tapped", new HashMap());
        }

        public static void m() {
            a.b("mobile-app-behavior", "share_tapped", new HashMap());
        }

        public static void n() {
            a.b("mobile-app-behavior", "settings_drawer_item_tapped", new HashMap());
        }

        public static void a(com.getpebble.android.common.model.af.b bVar, boolean z) {
            Map hashMap = new HashMap();
            hashMap.put("package_name", bVar.a);
            hashMap.put("app_name", bVar.b);
            hashMap.put("app_version", bVar.c);
            hashMap.put("notifications_enabled", Boolean.valueOf(z));
            a.b("mobile-app-behavior", "notifications_toggled_event", hashMap);
        }

        public static void a(Map<String, Object> map) {
            a.b("mobile-app-behavior", "notification_received", map);
        }

        public static void b(Map<String, Object> map) {
            f.d("Analytics", "logNotificationActionInvoked: '" + map + "'");
            a.b("mobile-app-behavior", "notification_action_invoked", map);
        }

        public static void a(String str, boolean z, Throwable th) {
            f.d("Analytics", "logNotificationServiceError: '" + str + "'");
            Map hashMap = new HashMap();
            hashMap.put("service_type", str);
            hashMap.put("is_error", Boolean.valueOf(z));
            hashMap.put("throwable", Log.getStackTraceString(th));
            a.b("mobile-app-behavior", "notification_service_error", hashMap);
        }

        public static void c(Map<String, Object> map) {
            a.b("mobile-app-behavior", "datalogging_crc_error", map);
        }

        public static void a(com.getpebble.android.common.model.am.c cVar, int i, int i2) {
            Map hashMap = new HashMap();
            hashMap.put("app_uuid", cVar.b.toString().toUpperCase(Locale.US));
            hashMap.put("app_name", cVar.c);
            hashMap.put("origin_position", Integer.valueOf(i));
            hashMap.put("destination_position", Integer.valueOf(i2));
            a.b("mobile-app-behavior", "app_reordered", hashMap);
        }

        public static void a(Record record, int i, boolean z, boolean z2) {
            Map hashMap = new HashMap();
            hashMap.put("weather_location_name", record.locationName);
            hashMap.put("weather_is_current_location", Boolean.valueOf(record.isDynamic));
            hashMap.put("weather_location_latitude", Double.valueOf(record.latitude));
            hashMap.put("weather_location_longitude", Double.valueOf(record.longitude));
            hashMap.put("weather_is_timeline_source", Boolean.valueOf(record.isTimelineSource));
            hashMap.put("weather_location_added_timestamp", Integer.valueOf(ab.a()));
            if (z2) {
                a.b("mobile-app-behavior", "weather_primary_location_changed", hashMap);
                return;
            }
            hashMap.put("num_locations", Integer.valueOf(i));
            if (z) {
                a.b("mobile-app-behavior", "weather_location_added", hashMap);
            } else {
                a.b("mobile-app-behavior", "weather_location_removed", hashMap);
            }
        }

        public static void b(boolean z) {
            Map hashMap = new HashMap();
            hashMap.put("location_permission_enabled", Boolean.valueOf(z));
            hashMap.put("weather_location_added_timestamp", Integer.valueOf(ab.a()));
            a.b("mobile-app-behavior", "weather_location_permission_changed", hashMap);
        }

        public static void a(int i, int i2) {
            Map hashMap = new HashMap();
            hashMap.put("total_num_calendars", Integer.valueOf(i));
            hashMap.put("num_checked_calendars", Integer.valueOf(i2));
            a.b("mobile-app-behavior", "calendar_selection_change", hashMap);
        }

        public static void a(a aVar, String str, String str2) {
            Map hashMap = new HashMap();
            hashMap.put("uuid", str);
            hashMap.put("triggered_by", str2);
            a.b("mobile-app-behavior", aVar.name().toLowerCase(Locale.US), hashMap);
        }

        public static void a(a aVar, Map<String, Object> map) {
            a.b("mobile-app-behavior", aVar.getEventType(), map);
        }

        public static void e(String str) {
            Map hashMap = new HashMap();
            hashMap.put("uuid", str);
            a.b("mobile-app-behavior", "watchface_changed", hashMap);
        }

        public static void a(a aVar) {
            Map hashMap = new HashMap();
            hashMap.put("unfaithful_reason", aVar.toString());
            a.b("mobile-app-behavior", "unfaithful", hashMap);
        }

        public static void a(com.getpebble.android.common.model.a aVar) {
            Map hashMap = new HashMap();
            hashMap.put("type_of_mobile_alert_invoked", aVar.name());
            a.b("mobile-app-behavior", "unfaithful", hashMap);
        }

        public static void a(long j, long j2, int i, long j3, boolean z, boolean z2, int i2, String str, boolean z3, String str2, String str3, int i3, String str4, String str5, String str6, String str7) {
            Map hashMap = new HashMap();
            hashMap.put("audio_duration_ms", Long.valueOf(j));
            hashMap.put("latency_ms", Long.valueOf(j2));
            hashMap.put("data_volume_bytes", Integer.valueOf(i));
            hashMap.put("speech_sent_timestamp_secs", Long.valueOf(j3));
            hashMap.put("failed_to_connect", Boolean.valueOf(z));
            hashMap.put("error_returned", Boolean.valueOf(z2));
            hashMap.put("transcription_length_bytes", Integer.valueOf(i2));
            hashMap.put("application_name", str);
            hashMap.put("application_uuid", str2);
            hashMap.put("is_first_party_app", Boolean.valueOf(z3));
            hashMap.put("watch_serial_number", str3);
            hashMap.put("voice_dictation_http_code", Integer.valueOf(i3));
            hashMap.put("voice_language", str4);
            hashMap.put("nuance_session_id", str5);
            hashMap.put("nuance_context", str6);
            hashMap.put("nuance_host", str7);
            a.b("mobile-app-behavior", "speech_recognition", hashMap);
        }

        public static void a(short s, String str, com.getpebble.android.g.a.b bVar, UUID uuid) {
            boolean z = str == null;
            Map hashMap = new HashMap();
            hashMap.put("voice_session_id", Short.valueOf(s));
            hashMap.put("application_uuid", uuid);
            hashMap.put("nlp_success", Boolean.valueOf(z));
            if (!z) {
                hashMap.put("nlp_failure_reason", str);
            }
            if (bVar != null) {
                com.getpebble.android.g.a.b.a.a a = bVar.a(com.getpebble.android.framework.l.b.b.a.TIME_OF_DAY.nlpKey);
                if (a != null) {
                    hashMap.put("nlp_verbal_time_of_day", a.b);
                }
            }
            a.b("mobile-app-behavior", "nlp", hashMap);
        }

        public static void c(boolean z) {
            Map hashMap = new HashMap();
            hashMap.put("accepted", Boolean.valueOf(z));
            a.b("mobile-app-behavior", "health_privacy_policy_accepted", hashMap);
        }

        public static void a(a aVar, String str, boolean z) {
            Map hashMap = new HashMap();
            hashMap.put("switch_id", aVar.id);
            hashMap.put("screen", str);
            hashMap.put("enabled", Boolean.valueOf(z));
            a.b("mobile-app-behavior", "switch_toggled", hashMap);
        }

        public static void a(boolean z, int i) {
            Map hashMap = new HashMap();
            hashMap.put("character_count", Integer.valueOf(i));
            hashMap.put("success", Boolean.valueOf(z));
            a.b("mobile-app-behavior", "send_text_sent", hashMap);
        }

        public static void c(int i) {
            Map hashMap = new HashMap();
            hashMap.put("favorite_count", Integer.valueOf(i));
            hashMap.put("screen", "SendTextSettings");
            a.b("mobile-app-behavior", "send_text_add_favorite", hashMap);
        }

        public static void o() {
            Map hashMap = new HashMap();
            hashMap.put("screen", "SendTextSettings");
            a.b("mobile-app-behavior", "send_text_remove_favorite", hashMap);
        }

        public static void a(com.getpebble.android.common.model.aw.b bVar, long j) {
            Map hashMap = new HashMap();
            hashMap.put("reminder_action", com.getpebble.android.framework.timeline.c.b.REMOTE_REMOVE.getSerializedName());
            hashMap.put("reminder_action_item_type", bVar.getAnalyticsName());
            hashMap.put("reminder_timestamp", Long.valueOf(j));
            a.b("mobile-app-behavior", "reminder_app_action", hashMap);
        }

        public static void b(com.getpebble.android.common.model.aw.b bVar, long j) {
            Map hashMap = new HashMap();
            hashMap.put("reminder_action", com.getpebble.android.framework.timeline.c.b.COMPLETE.getSerializedName());
            hashMap.put("reminder_action_item_type", bVar.getAnalyticsName());
            hashMap.put("reminder_timestamp", Long.valueOf(j));
            a.b("mobile-app-behavior", "reminder_app_action", hashMap);
        }

        public static void a(com.getpebble.android.common.model.aw.b bVar, long j, long j2) {
            Map hashMap = new HashMap();
            hashMap.put("reminder_action", com.getpebble.android.framework.timeline.c.b.POSTPONE.getSerializedName());
            hashMap.put("reminder_action_item_type", bVar.getAnalyticsName());
            hashMap.put("reminder_timestamp", Long.valueOf(j2));
            hashMap.put("reminder_old_timestamp", Long.valueOf(j));
            a.b("mobile-app-behavior", "reminder_app_action", hashMap);
        }
    }

    public static class d {
        public static void a() {
            a.b("mobile-app-behavior", "onboarding_login_failed", null);
        }

        public static void a(String str) {
            if (!a.a(str)) {
                Map hashMap = new HashMap();
                hashMap.put("token", str);
                a.b("mobile-app-behavior", "onboarding_login_succeeded", hashMap);
            }
        }
    }

    public static class e {
        public static void a() {
            a.b("remote-app-behavior", "sdk_app_installed", null);
            a.b("remote-device-interface", "sdk_app_installed", null);
        }

        public static void a(String str) {
            Map hashMap = new HashMap();
            hashMap.put("id", str);
            Map hashMap2 = new HashMap();
            hashMap2.put("app", hashMap);
            a.b("remote-app-behavior", "url_received_app_store_page", hashMap2);
        }
    }

    public static class f {
        private static String a(PebbleDevice pebbleDevice) {
            com.getpebble.android.common.model.ak.a pebbleDeviceRecord = ak.getPebbleDeviceRecord(com.getpebble.android.common.a.K().getContentResolver(), pebbleDevice);
            if (pebbleDeviceRecord == null) {
                return "";
            }
            return pebbleDeviceRecord.serialNumber;
        }

        public static void a(PebbleDevice pebbleDevice, boolean z) {
            Map hashMap = new HashMap();
            hashMap.put("bt_address", pebbleDevice.getAddress());
            hashMap.put("serial", a(pebbleDevice));
            hashMap.put("adapter_enabled", Boolean.valueOf(z));
            hashMap.put(ak.TRANSPORT, pebbleDevice.getTransport());
            a.b("remote-device-interface", "remote_device_disconnected", hashMap);
        }

        public static void a(PebbleDevice pebbleDevice, int i) {
            Map hashMap = new HashMap();
            hashMap.put("bt_address", pebbleDevice.getAddress());
            hashMap.put("serial", a(pebbleDevice));
            hashMap.put("attempt_count", Integer.valueOf(i));
            hashMap.put(ak.TRANSPORT, pebbleDevice.getTransport());
            a.b("remote-device-interface", "remote_device_connected", hashMap);
        }

        public static void a(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.b.d dVar, int i, boolean z, long j, boolean z2, boolean z3, int i2, com.getpebble.android.bluetooth.e.g.a aVar, Boolean bool) {
            Map hashMap = new HashMap();
            hashMap.put("bt_address", pebbleDevice.getAddress());
            hashMap.put("serial", a(pebbleDevice));
            hashMap.put("reason", dVar != null ? dVar.name() : "unknown");
            hashMap.put("attempt_count", Integer.valueOf(i));
            hashMap.put("adapter_enabled", Boolean.valueOf(z));
            hashMap.put("secs_since_adapter_enabled", Long.valueOf(j));
            hashMap.put("set_goal_disconnect", Boolean.valueOf(z2));
            hashMap.put(ak.TRANSPORT, pebbleDevice.getTransport());
            hashMap.put("has_ever_connected", Boolean.valueOf(z3));
            hashMap.put("failing_gatt_status", Integer.valueOf(i2));
            hashMap.put("failing_state", aVar != null ? aVar.name() : "unknown");
            String str = "is_already_connected";
            int i3 = bool == null ? -1 : bool.booleanValue() ? 1 : 0;
            hashMap.put(str, Integer.valueOf(i3));
            a.b("remote-device-interface", "remote_device_connection_failure", hashMap);
        }

        public static void b(PebbleDevice pebbleDevice, boolean z) {
            Map hashMap = new HashMap();
            hashMap.put("bt_address", pebbleDevice.getAddress());
            hashMap.put("serial", a(pebbleDevice));
            hashMap.put("did_unpairing", Boolean.valueOf(z));
            hashMap.put(ak.TRANSPORT, pebbleDevice.getTransport());
            a.b("remote-device-interface", "dodgy_pairing_detected", hashMap);
        }

        public static void a(PebbleDevice pebbleDevice, com.getpebble.android.bluetooth.a.a aVar, boolean z, com.getpebble.android.bluetooth.b.d dVar) {
            Map hashMap = new HashMap();
            hashMap.put("bt_address", pebbleDevice.getAddress());
            hashMap.put("serial", a(pebbleDevice));
            hashMap.put("did_reset", Boolean.valueOf(z));
            hashMap.put(ak.TRANSPORT, pebbleDevice.getTransport());
            hashMap.put("mode", aVar);
            hashMap.put("reason", dVar != null ? dVar.name() : "unknown");
            a.b("remote-device-interface", "bt_reset_requested", hashMap);
        }

        public static void a(com.getpebble.android.bluetooth.a.a aVar, boolean z) {
            Map hashMap = new HashMap();
            hashMap.put("did_reset", Boolean.valueOf(z));
            hashMap.put(ak.TRANSPORT, Transport.LE);
            hashMap.put("mode", aVar);
            hashMap.put("reason", "scan_failed");
            a.b("remote-device-interface", "bt_reset_requested", hashMap);
        }

        public static void a(PebbleDevice pebbleDevice, int i, int i2, Boolean bool) {
            Map hashMap = new HashMap();
            hashMap.put("bt_address", pebbleDevice.getAddress());
            hashMap.put("serial", a(pebbleDevice));
            hashMap.put(ak.TRANSPORT, pebbleDevice.getTransport());
            hashMap.put("max_sent_packet_size", Integer.valueOf(i));
            hashMap.put("failed_packet_size", Integer.valueOf(i2));
            String str = "is_already_connected";
            int i3 = bool == null ? -1 : bool.booleanValue() ? 1 : 0;
            hashMap.put(str, Integer.valueOf(i3));
            a.b("remote-device-interface", "ppog_packet_timeout", hashMap);
        }

        public static void a(String str, String str2, String str3) {
            if (!a.a(str) && !a.a(str2)) {
                Map hashMap = new HashMap();
                hashMap.put(ak.FW_VERSION, str);
                hashMap.put("fw_version_timestamp", str2);
                Map hashMap2 = new HashMap();
                hashMap2.put("firmware", hashMap);
                hashMap2.put("serial", str3);
                a.b("remote-device-interface", "prf_detected", hashMap2);
            }
        }
    }

    public static class g {
        public static void a() {
            a.b("support", "support_community_tapped", null);
        }

        public static void b() {
            a.b("support", "support_drawer_item_tapped", null);
        }

        public static void c() {
            a.b("support", "support_faq_tapped", null);
        }

        public static void d() {
            a.b("support", "support_getting_started_tapped", null);
        }

        public static void e() {
            a.b("support", "support_suggest_something_tapped", null);
        }

        public static void f() {
            a.b("support", "support_test_notifications_tapped", null);
        }

        public static void g() {
            a.b("mobile-app-behavior", "url_received_support_email", null);
        }

        public static void h() {
            a.b("mobile-app-behavior", "url_received_support_email_no_logs", null);
        }
    }

    static boolean a(String str) {
        return str != null && str.length() < 1;
    }

    static boolean b(String str) {
        if (str == null) {
            return true;
        }
        try {
            UUID.fromString(str);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    private static void b(String str, String str2) {
        b(str, str2, null);
    }

    private static void b(String str, String str2, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap();
        }
        com.getpebble.android.a.c.a(str, str2, map);
    }
}
