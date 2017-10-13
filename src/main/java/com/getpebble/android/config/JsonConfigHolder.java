package com.getpebble.android.config;

import com.getpebble.android.framework.timeline.e;
import com.getpebble.android.h.p;
import com.google.b.a.c;
import java.util.Arrays;

public class JsonConfigHolder {
    public Config config;

    public static class Algolia {
        public String api_key;
        public String app_id;
        public String index;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{ ").append("api_key:").append(this.api_key).append(",");
            stringBuilder.append("app_id:").append(this.app_id).append(",");
            stringBuilder.append("index:").append(this.index).append(" }");
            return stringBuilder.toString();
        }
    }

    public static class AppMeta {
        public boolean force_3x_app_migration;
        public String gcm_environment;
        public String gcm_sender_id;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{ ").append("force_3x_app_migration:").append(this.force_3x_app_migration).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("gcm_sender_id").append(this.gcm_sender_id).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("gcm_environment").append(this.gcm_environment).append(" }");
            return stringBuilder.toString();
        }
    }

    public static class Authentication {
        public DebugAccessTokenCookie debug_access_token_cookie;
        public String method;
        public String refresh_token;
        public String sign_in;
        public String sign_up;

        public static class DebugAccessTokenCookie {
            public String domain;
            public boolean secure;

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("{ ").append("domain:").append(this.domain).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
                stringBuilder.append("secure:").append(this.secure).append(" }");
                return stringBuilder.toString();
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{ ").append("method:").append(this.method).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("sign_in:").append(this.sign_in).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("sign_up:").append(this.sign_up).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("refresh_token:").append(this.refresh_token).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("debug_access_token_cookie:").append(this.debug_access_token_cookie).append(" }");
            return stringBuilder.toString();
        }
    }

    public static class Cohorts {
        public String endpoint;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{ ").append("endpoint:").append(this.endpoint).append(" }");
            return stringBuilder.toString();
        }
    }

    public static class Config {
        public Algolia algolia;
        public AppMeta app_meta;
        public Authentication authentication;
        public Cohorts cohorts;
        public Developer developer;
        @c(a = "health")
        public Health health;
        public Links links;
        public Locker locker;
        public SupportRequest support_request;
        public Timeline timeline;
        public TreasureData treasure_data;
        public Voice voice;
        public Weather weather;
        public WebViews webviews;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{ ").append("links:").append(this.links).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("locker:").append(this.locker).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("authentication:").append(this.authentication).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("webviews:").append(this.webviews).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("support_request:").append(this.support_request).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("developer:").append(this.developer).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("treasure_data:").append(this.treasure_data).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("timeline:").append(this.timeline).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("cohorts:").append(this.cohorts).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("voice:").append(this.voice).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("app_meta:").append(this.app_meta).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("algolia:").append(this.algolia).append(" }");
            stringBuilder.append("health:").append(this.health).append(" }");
            return stringBuilder.toString();
        }
    }

    public static class Developer {
        public String ws_proxy_url;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{ ").append("ws_proxy_url:").append(this.ws_proxy_url).append(" }");
            return stringBuilder.toString();
        }
    }

    public static class Health {
        @c(a = "post_activity_endpoint")
        public String activityEndpoint;
        @c(a = "post_settings_endpoint")
        public String settingsEndpoint;

        public String toString() {
            return p.a(this);
        }
    }

    public static class Links {
        @c(a = "authentication/me")
        public String authentication_me;
        @c(a = "authentication/push_tokens")
        public String authentication_push_tokens;
        @c(a = "i18n/font_packs")
        public String i18n_font_packs;
        @c(a = "i18n/language_packs")
        public String i18n_language_packs;
        @c(a = "remote_device_analytics")
        public String remote_device_analytics;
        @c(a = "trending_searches")
        public String trending_searches;
        @c(a = "diagnostics")
        public String users_diagnostics;
        @c(a = "users/me")
        public String users_me;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{ ").append("authentication_me:").append(this.authentication_me).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("users_me:").append(this.users_me).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("remote_device_analytics:").append(this.remote_device_analytics).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("trending_searches:").append(this.trending_searches).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("i18n/font_packs:").append(this.i18n_font_packs).append(" }");
            return stringBuilder.toString();
        }
    }

    public static class Locker {
        public String add_endpoint;
        public String get_endpoint;
        public String onboarding_data;
        public String remove_endpoint;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{ ").append("get_endpoint:").append(this.get_endpoint).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("add_endpoint").append(this.add_endpoint).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("remove_endpoint").append(this.remove_endpoint).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("default_apps").append(this.onboarding_data).append(" }");
            return stringBuilder.toString();
        }
    }

    public static class SupportRequest {
        public String email;
        public String subject;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{ ").append("email:").append(this.email).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("subject:").append(this.subject).append(" }");
            return stringBuilder.toString();
        }
    }

    public static class Timeline {
        public String gcm_sender_id;
        public int pin_ttl_secs;
        public String sandbox_user_token;
        public String sync_endpoint;
        public int sync_policy_minutes;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{ ").append("pin_ttl_secs:").append(this.pin_ttl_secs).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("sync_policy_minutes").append(this.sync_policy_minutes).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("sync_endpoint").append(this.sync_endpoint).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("sandbox_user_token").append(this.sandbox_user_token).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("gcm_sender_id").append(this.gcm_sender_id).append(" }");
            return stringBuilder.toString();
        }
    }

    public static class TreasureData {
        public String endpoint;
        public String write_key;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{ ").append("endpoint_url").append(this.endpoint).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("write_key").append(this.write_key).append(" }");
            return stringBuilder.toString();
        }
    }

    public static class Voice {
        public String[] first_party_uuids;
        public Language[] languages;

        public static class Language {
            @c(a = "endpoint")
            public String endpoint;
            @c(a = "four_char_locale")
            public String fourCharLocale;
            @c(a = "six_char_locale")
            public String sixCharLocale;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("first_party_uuids: [ ");
            if (this.first_party_uuids == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(Arrays.toString(this.first_party_uuids));
            }
            stringBuilder.append(" ], \n");
            stringBuilder.append("languages: [ ");
            if (this.languages == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(Arrays.toString(this.languages));
            }
            stringBuilder.append(" ]");
            return stringBuilder.toString();
        }
    }

    public static class Weather {
        @c(a = "url")
        public String url;
    }

    public static class WebViews {
        @c(a = "appstore/application")
        public String appstore_application;
        @c(a = "appstore/application_share")
        public String appstore_application_share;
        @c(a = "appstore/developer_apps")
        public String appstore_developer_apps;
        @c(a = "appstore/search/query")
        public String appstore_search_query;
        @c(a = "appstore/watchapps")
        public String appstore_watchapps;
        @c(a = "appstore/watchfaces")
        public String appstore_watchfaces;
        @c(a = "authentication/sign_in")
        public String authentication_sign_in;
        @c(a = "authentication/sign_up")
        public String authentication_sign_up;
        @c(a = "loading/buy_a_pebble")
        public String loading_buy_a_pebble;
        @c(a = "onboarding/privacy_policy")
        public String onboarding_privacy_policy;
        @c(a = "support/android-actionable-notifications")
        public String support_actionable_notifications;
        @c(a = "support/bt_findcode_help")
        public String support_bluetooth_find_code;
        @c(a = "support/bt_pairing_help")
        public String support_bt_pairing_help;
        @c(a = "support/community")
        public String support_community;
        @c(a = "support/faq")
        public String support_faq;
        @c(a = "support/getting_started")
        public String support_getting_started;
        @c(a = "support/suggest_something")
        public String support_suggest_something;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{ ").append("loading_buy_a_pebble:").append(this.loading_buy_a_pebble).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("authentication_sign_in:").append(this.authentication_sign_in).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("authentication_sign_up:").append(this.authentication_sign_up).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("appstore_watchapps:").append(this.appstore_watchapps).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("appstore_watchfaces:").append(this.appstore_watchfaces).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("appstore_developer_apps:").append(this.appstore_developer_apps).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("appstore_application:").append(this.appstore_application).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("appstore_application_share:").append(this.appstore_application_share).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("appstore_search_query:").append(this.appstore_search_query).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("support_getting_started:").append(this.support_getting_started).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("support_faq:").append(this.support_faq).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("support_community:").append(this.support_community).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("support_suggest_something").append(this.support_suggest_something).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("support_actionable_notifications").append(this.support_actionable_notifications).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("support_bluetooth_find_code").append(this.support_bluetooth_find_code).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("support_bt_pairing_help").append(this.support_bt_pairing_help).append(e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            stringBuilder.append("onboarding_privacy_policy").append(this.onboarding_privacy_policy).append(" }");
            return stringBuilder.toString();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ").append("config:").append(this.config).append(" }");
        return stringBuilder.toString();
    }
}
