package com.getpebble.android.config;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.config.JsonConfigHolder.Voice.Language;
import com.getpebble.android.h.q;
import java.io.PrintStream;
import java.lang.ref.WeakReference;

public class a {
    private static a d = null;
    WeakReference<Context> a = null;
    JsonConfigHolder b = null;
    ContentObserver c = new ContentObserver(this, null) {
        final /* synthetic */ a a;

        public void onChange(boolean z) {
            onChange(z, null);
        }

        public void onChange(boolean z, Uri uri) {
            new f(this) {
                final /* synthetic */ AnonymousClass1 a;

                {
                    this.a = r1;
                }

                public boolean doInBackground() {
                    this.a.a.b();
                    return false;
                }

                public void onTaskSuccess() {
                }

                public void onTaskFailed() {
                }
            }.submit();
        }
    };

    String a() {
        try {
            Context context = (Context) this.a.get();
            if (context != null) {
                return com.getpebble.android.common.framework.b.f.a(context, "default_boot_config.json", false);
            }
            com.getpebble.android.common.b.a.f.b("BootConfig", "handleChange: context is null");
            return null;
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.a("BootConfig", "Error loading default boot config from file", e);
            return null;
        }
    }

    void b() {
        com.getpebble.android.common.b.a.f.d("BootConfig", "handleChange()");
        String a = a();
        Context context = (Context) this.a.get();
        if (context == null) {
            com.getpebble.android.common.b.a.f.b("BootConfig", "handleChange: context is null");
            return;
        }
        String string;
        com.google.b.f fVar;
        com.getpebble.android.common.a.a u;
        Cursor query = context.getContentResolver().query(b.a("boot_config"), null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    string = query.getString(query.getColumnIndex("config_json"));
                    if (query != null) {
                        query.close();
                    }
                    if (string != null) {
                        fVar = new com.google.b.f();
                        try {
                            this.b = (JsonConfigHolder) fVar.a(string, JsonConfigHolder.class);
                        } catch (Throwable e) {
                            com.getpebble.android.common.b.a.f.a("BootConfig", "Failed to marshall the boot config; defaulting", e);
                            this.b = (JsonConfigHolder) fVar.a(a(), JsonConfigHolder.class);
                        }
                    }
                    u = PebbleApplication.u();
                    if (u != null) {
                        u.i();
                    }
                }
            } catch (Throwable e2) {
                com.getpebble.android.common.b.a.f.a("BootConfig", e2.getMessage(), e2);
                string = a;
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
            }
        }
        com.getpebble.android.common.b.a.f.a("BootConfig", "Failed to query data, defaulting!");
        string = a;
        if (query != null) {
            query.close();
        }
        if (string != null) {
            fVar = new com.google.b.f();
            this.b = (JsonConfigHolder) fVar.a(string, JsonConfigHolder.class);
        }
        u = PebbleApplication.u();
        if (u != null) {
            u.i();
        }
    }

    private a(Context context) {
        this.a = new WeakReference(context);
        b();
        context.getContentResolver().registerContentObserver(b.a("boot_config"), true, this.c);
    }

    public static a a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        }
        if (d == null) {
            d = new a(context);
        }
        return d;
    }

    public static a c() {
        if (d != null) {
            return d;
        }
        com.getpebble.android.common.b.a.f.a("BootConfig", "Failed to fetch instance!");
        throw new IllegalStateException("'sInstance' is null!  Please create it first.");
    }

    public String d() {
        if (this.b != null) {
            return this.b.config.webviews.appstore_watchapps;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String e() {
        if (this.b != null) {
            return this.b.config.webviews.appstore_watchfaces;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String f() {
        if (this.b != null) {
            return this.b.config.webviews.authentication_sign_in;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String g() {
        if (this.b != null) {
            return this.b.config.webviews.appstore_application;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String h() {
        if (this.b != null) {
            return this.b.config.webviews.appstore_application_share;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String i() {
        if (this.b != null) {
            return this.b.config.webviews.appstore_developer_apps;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String j() {
        if (this.b != null) {
            return this.b.config.webviews.appstore_search_query;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String k() {
        if (this.b != null) {
            return this.b.config.webviews.support_faq;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String l() {
        if (this.b != null) {
            return this.b.config.webviews.support_suggest_something;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String m() {
        if (this.b != null) {
            return this.b.config.webviews.support_actionable_notifications;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String n() {
        if (this.b != null) {
            return this.b.config.webviews.support_community;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String o() {
        if (this.b != null) {
            return this.b.config.webviews.support_getting_started;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String p() {
        if (this.b != null) {
            return this.b.config.links.i18n_language_packs;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String q() {
        if (this.b != null) {
            return this.b.config.links.i18n_font_packs;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String r() {
        if (this.b == null) {
            throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
        } else if (this.b.config == null || this.b.config.support_request == null) {
            return null;
        } else {
            return this.b.config.support_request.subject;
        }
    }

    public String s() {
        if (this.b != null) {
            return this.b.config.webviews.support_bluetooth_find_code;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String t() {
        if (this.b != null) {
            return this.b.config.webviews.support_bt_pairing_help;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String u() {
        com.getpebble.android.common.b.a.f.d("BootConfig", "getBootConfigUrl()");
        String v = v();
        if ("offline_boot_config.json".equals(v)) {
            return v;
        }
        Builder buildUpon = Uri.parse(v).buildUpon();
        buildUpon.appendPath("android");
        buildUpon.appendPath("v3");
        buildUpon.appendPath(String.valueOf(1404));
        buildUpon.appendQueryParameter("locale", q.a());
        buildUpon.appendQueryParameter("app_version", "4.4.1-1404-01abd2f76-endframe");
        return buildUpon.toString();
    }

    public String v() {
        return PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.BOOT_CONFIG_BASE_URL, "https://boot.getpebble.com/api/config");
    }

    public String w() {
        if (this.b != null) {
            return this.b.config.links.authentication_me;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String x() {
        if (this.b != null) {
            return this.b.config.links.users_me;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String y() {
        if (this.b != null) {
            return this.b.config.links.users_diagnostics;
        }
        throw new IllegalStateException("There is not config holder! [mConfigHolder=null]");
    }

    public String z() {
        if (this.b != null) {
            return this.b.config.links.trending_searches;
        }
        throw new IllegalStateException("There is not config holder! [mConfigHolder=null]");
    }

    public String A() {
        if (this.b == null) {
            throw new IllegalStateException("There is not config holder! [mConfigHolder=null]");
        } else if (B()) {
            return this.b.config.weather.url;
        } else {
            return null;
        }
    }

    public boolean B() {
        return this.b.config.weather != null;
    }

    public String C() {
        if (this.b != null) {
            return this.b.config.developer.ws_proxy_url;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String D() {
        if (this.b == null) {
            throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
        } else if (this.b.config.treasure_data == null) {
            return null;
        } else {
            return this.b.config.treasure_data.endpoint;
        }
    }

    public boolean E() {
        return this.b.config.treasure_data != null;
    }

    public String F() {
        if (this.b == null) {
            throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
        } else if (this.b.config.treasure_data == null) {
            return null;
        } else {
            return this.b.config.treasure_data.write_key;
        }
    }

    public String G() {
        return this.b.config.links.authentication_push_tokens;
    }

    public void a(PrintStream printStream) {
        printStream.println(this.b);
    }

    public String H() {
        if (this.b != null) {
            return this.b.config.timeline.sync_endpoint;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public int I() {
        if (this.b != null) {
            return this.b.config.timeline.sync_policy_minutes;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String J() {
        if (this.b != null) {
            return this.b.config.cohorts.endpoint;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String K() {
        if (this.b != null) {
            return this.b.config.timeline.sandbox_user_token;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String L() {
        if (this.b != null) {
            return this.b.config.locker.get_endpoint;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String M() {
        if (this.b != null) {
            return this.b.config.locker.add_endpoint;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String N() {
        if (this.b != null) {
            return this.b.config.locker.remove_endpoint;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String[] O() {
        if (this.b == null) {
            throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
        } else if (this.b.config.voice != null) {
            return this.b.config.voice.first_party_uuids;
        } else {
            throw new IllegalStateException("There is no voice section! [mConfigHolder.config.voice=null");
        }
    }

    public Language[] P() {
        if (this.b == null) {
            throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
        } else if (this.b.config.voice != null) {
            return this.b.config.voice.languages;
        } else {
            throw new IllegalStateException("There is no voice section! [mConfigHolder.config.voice=null");
        }
    }

    public boolean Q() {
        if (this.b != null) {
            return this.b.config.app_meta.force_3x_app_migration;
        }
        throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
    }

    public String R() {
        if (this.b == null) {
            throw new IllegalStateException("There is no config holder! [mConfigHolder=null]");
        } else if (this.b.config.locker != null) {
            return this.b.config.locker.onboarding_data;
        } else {
            throw new IllegalStateException("There is no locker section! [mConfigHolder.config.locker=null");
        }
    }

    public String S() {
        if (this.b == null || this.b.config == null || this.b.config.app_meta == null) {
            return null;
        }
        return this.b.config.app_meta.gcm_environment;
    }

    public String T() {
        if (this.b == null || this.b.config == null || this.b.config.app_meta == null) {
            return null;
        }
        return this.b.config.app_meta.gcm_sender_id;
    }

    public String U() {
        if (this.b == null || this.b.config == null || this.b.config.webviews == null) {
            return null;
        }
        return this.b.config.webviews.onboarding_privacy_policy;
    }

    public String V() {
        if (this.b == null || this.b.config == null || this.b.config.algolia == null) {
            return null;
        }
        return this.b.config.algolia.api_key;
    }

    public String W() {
        if (this.b == null || this.b.config == null || this.b.config.algolia == null) {
            return null;
        }
        return this.b.config.algolia.app_id;
    }

    public String X() {
        if (this.b == null || this.b.config == null || this.b.config.algolia == null) {
            return null;
        }
        return this.b.config.algolia.index;
    }

    public String Y() {
        if (this.b == null || this.b.config == null || this.b.config.health == null) {
            return null;
        }
        return this.b.config.health.activityEndpoint;
    }

    public String Z() {
        if (this.b == null || this.b.config == null || this.b.config.health == null) {
            return null;
        }
        return this.b.config.health.settingsEndpoint;
    }
}
