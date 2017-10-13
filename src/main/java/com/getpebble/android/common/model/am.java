package com.getpebble.android.common.model;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.install.app.AppManifest;
import com.getpebble.android.common.model.LockerAppJson.Application;
import com.getpebble.android.common.model.LockerAppJson.Application.HardwarePlatform;
import com.getpebble.android.framework.g.k;
import com.getpebble.android.framework.l.b.ak;
import com.getpebble.android.framework.timeline.AppLayoutsMapper;
import com.getpebble.android.h.i;
import com.getpebble.android.h.x;
import com.google.a.b.ad;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class am extends ai {
    public static final Uri a = com.getpebble.android.common.b.b.b.a("locker_apps");
    public static final UUID b = UUID.fromString("6bf6215b-c97f-409e-8c31-4f55657222b4");
    public static final UUID c = UUID.fromString("36d8c6ed-4c83-4fa1-a9e2-8f12dc941f8c");
    public static final UUID d = UUID.fromString("0863fc6a-66c5-4f62-ab8a-82ed00a98b5d");
    public static final UUID e = UUID.fromString("fef82c82-7176-4e22-88de-35a3fc18d43f");

    public enum a {
        PINS("data_source_pins_enabled"),
        REMINDERS_AND_NOTIFICATIONS("data_source_reminders_notifications_enabled");
        
        final String targetColumn;

        private a(String str) {
            this.targetColumn = str;
        }
    }

    public static class b {
        private final Map<com.getpebble.android.common.framework.install.app.b.a, a> a;

        public static class a {
            public final com.getpebble.android.common.framework.install.app.b.a a;
            public final com.google.a.f.e b;
            public final i c;
            public final String d;
            public final String e;
            public final String f;
            public final String g;
            public final boolean h;

            a(com.getpebble.android.common.framework.install.app.b.a aVar, com.google.a.f.e eVar, i iVar, String str, String str2, String str3, String str4, boolean z) {
                this.a = aVar;
                this.b = eVar;
                this.c = iVar;
                this.d = str;
                this.e = str2;
                this.f = str3;
                this.g = str4;
                this.h = z;
            }

            a(com.getpebble.android.common.framework.install.app.b.a aVar, boolean z) {
                this(aVar, com.google.a.f.e.a(0), new i(""), "", "", "", "", z);
            }

            public String a() {
                if (!TextUtils.isEmpty(this.f)) {
                    return this.f;
                }
                if (TextUtils.isEmpty(this.e)) {
                    return "";
                }
                return this.e;
            }

            public int b() {
                return (this.h ? 1 : 0) + (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31);
            }

            public String toString() {
                return "PlatformDependentData[ platform = " + this.a + ", supported = " + this.h + ", screenshotUrl = " + this.g + ", platform = " + this.a + "]";
            }
        }

        b(Map<com.getpebble.android.common.framework.install.app.b.a, a> map) {
            this.a = map;
        }

        public a a(com.getpebble.android.common.framework.install.app.b.a aVar) {
            a aVar2 = (a) this.a.get(aVar);
            if (aVar2 != null || aVar.getFallback() == null) {
                return aVar2;
            }
            return (a) this.a.get(aVar.getFallback());
        }

        public boolean b(com.getpebble.android.common.framework.install.app.b.a aVar) {
            a a = a(aVar);
            if (a == null) {
                return false;
            }
            return a.h;
        }

        private static boolean a(com.getpebble.android.common.framework.install.app.b.a aVar, Application application) {
            switch (aVar) {
                case APLITE:
                    if (application.compatibility.aplite == null || !application.compatibility.aplite.supported) {
                        return false;
                    }
                    return true;
                case BASALT:
                    if (application.compatibility.basalt == null || !application.compatibility.basalt.supported) {
                        return false;
                    }
                    return true;
                case CHALK:
                    if (application.compatibility.chalk == null || !application.compatibility.chalk.supported) {
                        return false;
                    }
                    return true;
                case DIORITE:
                    return application.compatibility.diorite != null && application.compatibility.diorite.supported;
                default:
                    return false;
            }
        }

        static b a(Application application) {
            Map linkedHashMap = new LinkedHashMap();
            for (com.getpebble.android.common.framework.install.app.b.a aVar : com.getpebble.android.common.framework.install.app.b.a.values()) {
                HardwarePlatform hardwarePlatform;
                Object aVar2;
                for (HardwarePlatform hardwarePlatform2 : application.hardware_platforms) {
                    if (hardwarePlatform2.name.equals(aVar.getCode())) {
                        hardwarePlatform = hardwarePlatform2;
                        break;
                    }
                }
                hardwarePlatform = null;
                boolean a = a(aVar, application);
                if (!(a || aVar.getFallback() == null)) {
                    a = a(aVar.getFallback(), application);
                }
                if (hardwarePlatform != null) {
                    aVar2 = new a(aVar, com.google.a.f.e.a((long) hardwarePlatform.pebble_process_info_flags), new i(hardwarePlatform.sdk_version), hardwarePlatform.description, hardwarePlatform.images.icon, hardwarePlatform.images.list, hardwarePlatform.images.screenshot, a);
                } else if (a) {
                    aVar2 = null;
                } else {
                    aVar2 = new a(aVar, false);
                }
                if (aVar2 != null) {
                    linkedHashMap.put(aVar, aVar2);
                }
            }
            return new b(linkedHashMap);
        }

        static b a(String str) {
            Map linkedHashMap = new LinkedHashMap();
            if (TextUtils.isEmpty(str)) {
                return new b(linkedHashMap);
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    com.getpebble.android.common.framework.install.app.b.a fromString = com.getpebble.android.common.framework.install.app.b.a.fromString(jSONObject.getString("platform"));
                    if (fromString == null) {
                        f.b("PebbleLockerAppDataModel", "PlatformDependentData from json: platform is null");
                        return null;
                    }
                    linkedHashMap.put(fromString, new a(fromString, com.google.a.f.e.a(jSONObject.getLong("process_info_flags")), new i(jSONObject.getString("sdk_version")), jSONObject.optString("description"), jSONObject.optString("icon"), jSONObject.optString("icon_list"), jSONObject.optString("screenshot"), jSONObject.getBoolean("supported")));
                }
                return new b(linkedHashMap);
            } catch (Throwable e) {
                f.b("PebbleLockerAppDataModel", "Error deserialising platform-specific item: " + str, e);
                return new b(linkedHashMap);
            }
        }

        static b a(com.getpebble.android.common.framework.install.app.b bVar) {
            Map linkedHashMap = new LinkedHashMap();
            for (com.getpebble.android.common.framework.install.app.b.a aVar : com.getpebble.android.common.framework.install.app.b.a.values()) {
                AppManifest e = bVar.e(aVar);
                com.getpebble.android.common.framework.install.app.a a = bVar.a(aVar);
                if (!(e == null || a == null)) {
                    com.getpebble.android.common.d.c a2 = e.getAppInfo().a();
                    linkedHashMap.put(aVar, new a(aVar, a.a(), new i(a2.a(), a2.b()), bVar.i().getShortName(), null, null, null, true));
                }
            }
            if (!linkedHashMap.isEmpty()) {
                return new b(linkedHashMap);
            }
            throw new IllegalStateException("platformDependentData is empty");
        }

        String a() {
            JSONArray jSONArray = new JSONArray();
            for (a aVar : this.a.values()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("platform", aVar.a.getCode());
                    jSONObject.put("sdk_version", aVar.c == null ? null : aVar.c.d());
                    jSONObject.put("process_info_flags", aVar.b == null ? null : Long.valueOf(aVar.b.longValue()));
                    jSONObject.put("description", aVar.d);
                    jSONObject.put("icon", aVar.e == null ? "" : aVar.e);
                    jSONObject.put("icon_list", aVar.f == null ? "" : aVar.f);
                    jSONObject.put("screenshot", aVar.g);
                    jSONObject.put("supported", aVar.h);
                } catch (Throwable e) {
                    f.b("PebbleLockerAppDataModel", "Error serialising platform-dependent item: " + aVar.a, e);
                }
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        }

        public boolean a(b bVar) {
            return a().equals(bVar.a());
        }

        public int b() {
            int i = 3;
            for (a b : this.a.values()) {
                i = b.b() + (i * 31);
            }
            return i;
        }

        public String toString() {
            return a();
        }
    }

    public static class c implements com.getpebble.android.framework.g.e.b {
        public final Integer A;
        public final Integer B;
        public final Integer C;
        public final Integer D;
        public final com.google.a.f.e E;
        public final boolean F;
        public final boolean G;
        public final b H;
        public final boolean I;
        public final String J;
        public final String a;
        public final UUID b;
        public final String c;
        public final e d;
        public final String e;
        public final String f;
        public final String g;
        public final String h;
        public final String i;
        public final String j;
        public final String k;
        public final i l;
        public final String m;
        public final String n;
        public final String o;
        public final String p;
        public final boolean q;
        public final String r;
        public final int s;
        public final boolean t;
        public final boolean u;
        public final boolean v;
        public final String w;
        public final boolean x;
        public final boolean y;
        public final boolean z;

        public boolean a() {
            return this.m != null;
        }

        public String b() {
            Matcher matcher = Pattern.compile("id=([A-Za-z]+\\.[A-Za-z0-9_]+[\\.[A-Za-z0-9_]]*)").matcher(this.p);
            while (matcher.find()) {
                f.d("PebbleLockerAppDataModel", "MATCHER GROUP: " + matcher.group(1));
                if (matcher.group(1) != null) {
                    return matcher.group(1);
                }
            }
            return null;
        }

        public c(Application application) {
            boolean z;
            this.a = application.id;
            this.e = application.pbw.release_id;
            this.c = application.title;
            this.b = UUID.fromString(application.uuid);
            this.d = e.fromString(application.type);
            this.f = application.pbw.file;
            this.g = application.links.href;
            this.h = application.links.share;
            this.i = application.developer.name;
            this.j = application.developer.id;
            this.k = application.developer.contact_email;
            this.l = new i(application.version);
            this.m = application.companions.android == null ? null : application.companions.android.id;
            this.n = application.companions.android == null ? null : application.companions.android.name;
            this.o = application.companions.android == null ? null : application.companions.android.icon;
            this.p = application.companions.android == null ? null : application.companions.android.url;
            if (application.companions.android == null || !application.companions.android.required) {
                z = false;
            } else {
                z = true;
            }
            this.q = z;
            this.r = application.user_token;
            this.s = application.hearts;
            this.t = application.is_timeline_enabled;
            this.w = application.category;
            this.x = application.is_configurable;
            this.u = true;
            this.v = true;
            this.B = null;
            this.A = null;
            this.y = false;
            this.z = false;
            this.H = b.a(application);
            this.E = com.google.a.f.e.a((long) application.pbw.icon_resource_id);
            this.D = null;
            this.F = false;
            this.G = false;
            this.C = Integer.valueOf(k());
            this.I = true;
            this.J = null;
        }

        public c(com.getpebble.android.common.framework.install.app.b bVar) {
            com.google.a.f.e b;
            this.a = null;
            this.e = null;
            this.c = bVar.i().getShortName();
            this.b = bVar.i().getUuid();
            this.d = bVar.i().isWatchFace() ? e.WATCHFACE : e.APP;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = bVar.i().getCompanyName();
            this.j = null;
            this.k = null;
            this.l = new i(bVar.i().getVersionLabel());
            this.m = null;
            this.n = null;
            this.o = null;
            this.p = null;
            this.q = false;
            this.r = null;
            this.s = 0;
            this.t = true;
            this.w = null;
            this.x = bVar.i().isConfigurable();
            this.u = true;
            this.v = true;
            this.B = null;
            this.A = null;
            this.y = false;
            this.z = true;
            this.H = b.a(bVar);
            this.C = Integer.valueOf(k());
            for (com.getpebble.android.common.framework.install.app.b.a a : com.getpebble.android.common.framework.install.app.b.a.values()) {
                com.getpebble.android.common.framework.install.app.a a2 = bVar.a(a);
                if (a2 != null) {
                    b = a2.b();
                    break;
                }
            }
            b = null;
            if (b == null) {
                throw new IllegalStateException("No icon resource id!");
            }
            this.E = b;
            this.D = Integer.valueOf(this.d.equals(e.WATCHFACE) ? 0 : this.d.getMaxNumToSync() - 1);
            this.F = false;
            this.G = false;
            this.I = true;
            this.J = bVar.h().toString();
        }

        public c(Cursor cursor) {
            boolean z;
            boolean z2 = true;
            this.a = cursor.getString(cursor.getColumnIndex("app_id"));
            this.e = cursor.getString(cursor.getColumnIndex("release_id"));
            this.c = cursor.getString(cursor.getColumnIndex(an.TITLE));
            this.b = UUID.fromString(cursor.getString(cursor.getColumnIndex("uuid")));
            this.d = e.fromString(cursor.getString(cursor.getColumnIndex("type")));
            this.f = cursor.getString(cursor.getColumnIndex("pbw_file"));
            this.g = cursor.getString(cursor.getColumnIndex("href"));
            this.h = cursor.getString(cursor.getColumnIndex("share"));
            this.i = cursor.getString(cursor.getColumnIndex("developer_name"));
            this.j = cursor.getString(cursor.getColumnIndex("developer_id"));
            this.k = cursor.getString(cursor.getColumnIndex("developer_email"));
            this.l = new i(cursor.getString(cursor.getColumnIndex("version")));
            this.m = cursor.getString(cursor.getColumnIndex("companion_id"));
            this.n = cursor.getString(cursor.getColumnIndex("companion_name"));
            this.o = cursor.getString(cursor.getColumnIndex("companion_icon"));
            this.p = cursor.getString(cursor.getColumnIndex("companion_url"));
            this.q = cursor.getInt(cursor.getColumnIndex("companion_required")) == 1;
            this.r = cursor.getString(cursor.getColumnIndex("user_token"));
            this.s = cursor.getInt(cursor.getColumnIndex("hearts"));
            if (cursor.getInt(cursor.getColumnIndex("has_data_source")) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.t = z;
            if (cursor.getInt(cursor.getColumnIndex("data_source_pins_enabled")) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.u = z;
            if (cursor.getInt(cursor.getColumnIndex("data_source_reminders_notifications_enabled")) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.v = z;
            this.w = cursor.getString(cursor.getColumnIndex("store_category"));
            if (cursor.getInt(cursor.getColumnIndex("is_configurable")) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.x = z;
            String string = cursor.getString(cursor.getColumnIndex("record_hashcode"));
            if (string == null || string.equals("removed")) {
                this.C = null;
            } else {
                this.C = Integer.decode(string);
            }
            string = cursor.getString(cursor.getColumnIndex("pebble_sync_hashcode"));
            if (string == null || string.equals("removed")) {
                this.B = null;
            } else {
                this.B = Integer.decode(string);
            }
            string = cursor.getString(cursor.getColumnIndex("cloud_sync_hashcode"));
            if (string == null || string.equals("removed")) {
                this.A = null;
            } else {
                this.A = Integer.decode(string);
            }
            if (cursor.getInt(cursor.getColumnIndex("is_active_watchface")) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.y = z;
            if (cursor.getInt(cursor.getColumnIndex("is_sideloaded")) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.z = z;
            int columnIndex = cursor.getColumnIndex("locker_order");
            if (cursor.isNull(columnIndex)) {
                this.D = null;
            } else {
                this.D = Integer.valueOf(cursor.getInt(columnIndex));
            }
            this.H = b.a(cursor.getString(cursor.getColumnIndex("platform_dependent_data")));
            if (this.H == null) {
                throw new IllegalArgumentException("platformDependentData is null");
            }
            this.E = com.google.a.f.e.a(cursor.getLong(cursor.getColumnIndex("icon_resource_id")));
            if (cursor.getInt(cursor.getColumnIndex("is_system_app")) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.F = z;
            if (cursor.getInt(cursor.getColumnIndex("has_been_configured")) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.G = z;
            if (cursor.getInt(cursor.getColumnIndex("is_reorderable")) != 1) {
                z2 = false;
            }
            this.I = z2;
            this.J = cursor.getString(cursor.getColumnIndex("resource_map_json"));
        }

        public c(d dVar, Resources resources) {
            this.a = null;
            this.e = null;
            this.c = resources.getString(dVar.mTitle);
            this.b = dVar.mUuid;
            this.d = dVar.mType;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = resources.getString(dVar.mAuthor);
            this.j = null;
            this.k = null;
            this.l = new i("1.0");
            this.m = null;
            this.n = null;
            this.o = null;
            this.p = null;
            this.q = false;
            this.r = null;
            this.s = 0;
            this.t = dVar.mHasDataSource;
            this.w = null;
            this.x = dVar.mHasSettings;
            this.u = true;
            this.v = true;
            this.B = null;
            this.A = null;
            this.y = false;
            this.z = false;
            this.H = null;
            this.C = Integer.valueOf(0);
            this.E = com.google.a.f.e.a(0);
            this.D = Integer.valueOf(dVar.mOrder);
            this.F = true;
            this.G = false;
            this.I = dVar.mIsReorderable;
            this.J = null;
        }

        public c(Parcelable parcelable) {
            this((ContentValues) parcelable);
        }

        public c(ContentValues contentValues) {
            if (contentValues == null) {
                throw new IllegalArgumentException("ContentValues is null");
            }
            Integer valueOf = Integer.valueOf(1);
            this.a = contentValues.getAsString("app_id");
            this.b = UUID.fromString(contentValues.getAsString("uuid"));
            this.c = contentValues.getAsString(an.TITLE);
            this.d = e.fromString(contentValues.getAsString("type"));
            this.e = contentValues.getAsString("release_id");
            this.f = contentValues.getAsString("pbw_file");
            this.g = contentValues.getAsString("href");
            this.h = contentValues.getAsString("share");
            this.i = contentValues.getAsString("developer_name");
            this.j = contentValues.getAsString("developer_id");
            this.k = contentValues.getAsString("developer_email");
            this.l = new i(contentValues.getAsString("version"));
            this.m = contentValues.getAsString("companion_id");
            this.n = contentValues.getAsString("companion_name");
            this.o = contentValues.getAsString("companion_icon");
            this.p = contentValues.getAsString("companion_url");
            this.q = valueOf.equals(contentValues.getAsInteger("companion_required"));
            this.r = contentValues.getAsString("user_token");
            Integer asInteger = contentValues.getAsInteger("hearts");
            this.s = asInteger == null ? 0 : asInteger.intValue();
            this.t = valueOf.equals(contentValues.getAsInteger("has_data_source"));
            this.u = valueOf.equals(contentValues.getAsInteger("data_source_pins_enabled"));
            this.v = valueOf.equals(contentValues.getAsInteger("data_source_reminders_notifications_enabled"));
            this.w = contentValues.getAsString("store_category");
            this.x = valueOf.equals(contentValues.getAsInteger("is_configurable"));
            this.y = valueOf.equals(contentValues.getAsInteger("is_active_watchface"));
            this.z = valueOf.equals(contentValues.getAsInteger("is_sideloaded"));
            this.D = contentValues.getAsInteger("locker_order");
            Long asLong = contentValues.getAsLong("icon_resource_id");
            this.E = asLong == null ? null : com.google.a.f.e.a(asLong.longValue());
            this.F = valueOf.equals(contentValues.getAsInteger("is_system_app"));
            this.G = valueOf.equals(contentValues.getAsInteger("has_been_configured"));
            this.I = valueOf.equals(contentValues.getAsInteger("is_reorderable"));
            this.J = contentValues.getAsString("resource_map_json");
            this.H = b.a(contentValues.getAsString("platform_dependent_data"));
            if (this.H == null) {
                throw new IllegalArgumentException("platformDependentData is null");
            }
            String asString = contentValues.getAsString("record_hashcode");
            if (asString == null || asString.equals("removed")) {
                this.C = null;
            } else {
                this.C = Integer.decode(asString);
            }
            asString = contentValues.getAsString("pebble_sync_hashcode");
            if (asString == null || asString.equals("removed")) {
                this.B = null;
            } else {
                this.B = Integer.decode(asString);
            }
            asString = contentValues.getAsString("cloud_sync_hashcode");
            if (asString == null || asString.equals("removed")) {
                this.A = null;
            } else {
                this.A = Integer.decode(asString);
            }
        }

        public Parcelable f() {
            Parcelable g = g();
            g.put("cloud_sync_hashcode", this.A);
            g.put("pebble_sync_hashcode", this.B);
            return g;
        }

        public ContentValues g() {
            String str;
            int i;
            int i2 = 1;
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", this.a);
            contentValues.put("uuid", this.b.toString());
            contentValues.put(an.TITLE, this.c);
            String str2 = "type";
            if (this.d == null) {
                str = "";
            } else {
                str = this.d.getCode();
            }
            contentValues.put(str2, str);
            contentValues.put("release_id", this.e);
            contentValues.put("pbw_file", this.f);
            contentValues.put("href", this.g);
            contentValues.put("share", this.h);
            contentValues.put("developer_name", this.i);
            contentValues.put("developer_id", this.j);
            contentValues.put("developer_email", this.k);
            contentValues.put("version", this.l.d());
            contentValues.put("companion_id", this.m);
            contentValues.put("companion_name", this.n);
            contentValues.put("companion_icon", this.o);
            contentValues.put("companion_url", this.p);
            contentValues.put("companion_required", Integer.valueOf(this.q ? 1 : 0));
            contentValues.put("user_token", this.r);
            contentValues.put("hearts", Integer.valueOf(this.s));
            str2 = "has_data_source";
            if (this.t) {
                i = 1;
            } else {
                i = 0;
            }
            contentValues.put(str2, Integer.valueOf(i));
            str2 = "data_source_pins_enabled";
            if (this.u) {
                i = 1;
            } else {
                i = 0;
            }
            contentValues.put(str2, Integer.valueOf(i));
            str2 = "data_source_reminders_notifications_enabled";
            if (this.v) {
                i = 1;
            } else {
                i = 0;
            }
            contentValues.put(str2, Integer.valueOf(i));
            contentValues.put("store_category", this.w);
            str2 = "is_configurable";
            if (this.x) {
                i = 1;
            } else {
                i = 0;
            }
            contentValues.put(str2, Integer.valueOf(i));
            str2 = "is_active_watchface";
            if (this.y) {
                i = 1;
            } else {
                i = 0;
            }
            contentValues.put(str2, Integer.valueOf(i));
            str2 = "is_sideloaded";
            if (this.z) {
                i = 1;
            } else {
                i = 0;
            }
            contentValues.put(str2, Integer.valueOf(i));
            if (this.D != null) {
                contentValues.put("locker_order", this.D);
            }
            contentValues.put("record_hashcode", this.C);
            contentValues.put("icon_resource_id", this.E == null ? null : Long.valueOf(this.E.longValue()));
            str2 = "is_system_app";
            if (this.F) {
                i = 1;
            } else {
                i = 0;
            }
            contentValues.put(str2, Integer.valueOf(i));
            str2 = "has_been_configured";
            if (this.G) {
                i = 1;
            } else {
                i = 0;
            }
            contentValues.put(str2, Integer.valueOf(i));
            if (this.H != null) {
                contentValues.put("platform_dependent_data", this.H.a());
            }
            str = "is_reorderable";
            if (!this.I) {
                i2 = 0;
            }
            contentValues.put(str, Integer.valueOf(i2));
            contentValues.put("resource_map_json", this.J);
            return contentValues;
        }

        public boolean h() {
            return this.l.c();
        }

        public boolean i() {
            return this.d.getArchiveHeaderUuid().equals(this.b);
        }

        public boolean j() {
            return this.d.getNotSupportedHeaderUuid().equals(this.b);
        }

        public boolean a(ContentResolver contentResolver, boolean z, com.getpebble.android.common.framework.install.app.b.a aVar) {
            if (!z) {
                return true;
            }
            String str = "uuid = ?";
            String[] strArr = new String[]{this.b.toString()};
            ContentValues contentValues = new ContentValues(1);
            str = this.C == null ? "removed" : String.valueOf(this.C);
            if (b(aVar)) {
                if (this.z && this.C == null) {
                    boolean z2;
                    if (contentResolver.delete(am.a, "uuid = ?", strArr) > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    return z2;
                }
                str = "removed";
            }
            contentValues.put("pebble_sync_hashcode", str);
            if (contentResolver.update(am.a, contentValues, "uuid = ?", strArr) <= 0) {
                return false;
            }
            return true;
        }

        public boolean a(com.getpebble.android.common.framework.install.app.b.a aVar) {
            return (this.C == null || this.C.equals(this.B) || this.D == null || !o() || this.F || !this.H.b(aVar)) ? false : true;
        }

        public boolean b(com.getpebble.android.common.framework.install.app.b.a aVar) {
            return (this.C == null || this.D == null || !o() || !this.H.b(aVar)) && this.B != null;
        }

        private boolean o() {
            if (this.D == null || this.d == null || this.D.intValue() >= am.a(this.d, com.getpebble.android.common.a.K().getContentResolver())) {
                return false;
            }
            return true;
        }

        public byte[] c() {
            return com.getpebble.android.bluetooth.b.b.a(this.b);
        }

        public Integer d() {
            return this.C;
        }

        public byte[] a(com.getpebble.android.common.framework.install.app.b.a aVar, v vVar, z zVar) {
            ak a = ak.a(this, aVar);
            if (a != null) {
                return a.a();
            }
            throw new IllegalArgumentException("appItem cannot be null");
        }

        public com.getpebble.android.framework.l.b.j.b e() {
            return com.getpebble.android.framework.l.b.j.b.APPS;
        }

        public boolean a(c cVar) {
            if (this == cVar) {
                return true;
            }
            if (cVar == null) {
                return false;
            }
            if (this.a == null ? cVar.a != null : !this.a.equals(cVar.a)) {
                return false;
            }
            if (!this.b.equals(cVar.b)) {
                return false;
            }
            if (!this.c.equals(cVar.c)) {
                return false;
            }
            if (this.d != cVar.d) {
                return false;
            }
            if (this.e == null ? cVar.e != null : !this.e.equals(cVar.e)) {
                return false;
            }
            if (this.f == null ? cVar.f != null : !this.f.equals(cVar.f)) {
                return false;
            }
            if (this.g == null ? cVar.g != null : !this.g.equals(cVar.g)) {
                return false;
            }
            if (this.h == null ? cVar.h != null : !this.h.equals(cVar.h)) {
                return false;
            }
            if (this.i == null ? cVar.i != null : !this.i.equals(cVar.i)) {
                return false;
            }
            if (this.j == null ? cVar.j != null : !this.j.equals(cVar.j)) {
                return false;
            }
            if (this.k == null ? cVar.k != null : !this.k.equals(cVar.k)) {
                return false;
            }
            if (this.l == null ? cVar.l != null : !this.l.equals(cVar.l)) {
                return false;
            }
            if (this.m == null ? cVar.m != null : !this.m.equals(cVar.m)) {
                return false;
            }
            if (this.n == null ? cVar.n != null : !this.n.equals(cVar.n)) {
                return false;
            }
            if (this.o == null ? cVar.o != null : !this.o.equals(cVar.o)) {
                return false;
            }
            if (this.p == null ? cVar.p != null : !this.p.equals(cVar.p)) {
                return false;
            }
            if (this.q != cVar.q) {
                return false;
            }
            if (this.r == null ? cVar.r != null : !this.r.equals(cVar.r)) {
                return false;
            }
            if (this.s != cVar.s) {
                return false;
            }
            if (this.t != cVar.t) {
                return false;
            }
            if (this.w == null ? cVar.w != null : !this.w.equals(cVar.w)) {
                return false;
            }
            if (this.x != cVar.x) {
                return false;
            }
            if (this.z != cVar.z) {
                return false;
            }
            if (this.E == null ? cVar.E != null : !this.E.equals(cVar.E)) {
                return false;
            }
            if (this.g == null ? cVar.g != null : !this.g.equals(cVar.g)) {
                return false;
            }
            if (this.H.a(cVar.H)) {
                return true;
            }
            return false;
        }

        public int k() {
            return (this.E == null ? 0 : this.E.hashCode()) + (((((((this.c.hashCode() * 31) + this.b.hashCode()) * 31) + this.l.hashCode()) * 31) + this.H.b()) * 31);
        }

        public ContentProviderOperation l() {
            return a("removed");
        }

        public boolean a(Context context) {
            return a(context, this.b);
        }

        public static boolean a(Context context, UUID uuid) {
            try {
                am.a(uuid, com.getpebble.android.common.a.K().getContentResolver(), true);
            } catch (Exception e) {
                f.d("PebbleLockerAppDataModel", "deleteFromCloudAndWatch: failed to determine if app was sideloaded");
            }
            String[] strArr = new String[]{uuid.toString()};
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("record_hashcode", "removed");
            int update = context.getContentResolver().update(am.a, contentValues, "uuid = ?", strArr);
            if (update != 1) {
                f.b("PebbleLockerAppDataModel", "deleteFromCloudAndWatch failed: uuid = " + uuid + " res = " + update);
            }
            new com.getpebble.android.framework.install.a.a(context).d();
            aw.a(context.getContentResolver(), uuid);
            if (update == 1) {
                return true;
            }
            return false;
        }

        public ContentProviderOperation m() {
            return a(String.valueOf(this.C));
        }

        private ContentProviderOperation a(String str) {
            String str2 = "uuid = ?";
            String[] strArr = new String[]{this.b.toString()};
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("cloud_sync_hashcode", str);
            return ContentProviderOperation.newUpdate(am.a).withSelection("uuid = ?", strArr).withValues(contentValues).build();
        }

        public ContentProviderOperation n() {
            ArrayList arrayList = new ArrayList();
            String str = "uuid = ?";
            String[] strArr = new String[]{this.b.toString()};
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("record_hashcode", "removed");
            contentValues.put("cloud_sync_hashcode", "removed");
            return ContentProviderOperation.newUpdate(am.a).withValues(contentValues).withSelection("uuid = ?", strArr).build();
        }

        public String toString() {
            return "Record{id='" + this.a + '\'' + ", uuid=" + this.b + ", title='" + this.c + '\'' + ", type=" + this.d + ", releaseId='" + this.e + '\'' + ", pbwUrl='" + this.f + '\'' + ", href='" + this.g + '\'' + ", shareUrl='" + this.h + '\'' + ", developerName='" + this.i + '\'' + ", developerId='" + this.j + '\'' + ", developerEmail='" + this.k + '\'' + ", version=" + this.l + ", companionId='" + this.m + '\'' + ", companionName='" + this.n + '\'' + ", companionIconUrl='" + this.o + '\'' + ", companionUrl='" + this.p + '\'' + ", companionRequired='" + this.q + '\'' + ", userToken='" + this.r + '\'' + ", hearts=" + this.s + ", hasDataSource=" + this.t + ", storeCategory='" + this.w + '\'' + ", isConfigurable='" + this.x + '\'' + ", dataSourcePinsEnabled=" + this.u + ", dataSourceRemindersNotificationsEnabled=" + this.v + ", platformDependentData=" + this.H + ", pebbleSyncHashcode=" + this.B + ", cloudSyncHashcode=" + this.A + ", recordHashcode=" + this.C + ", isActiveWatchface=" + this.y + ", isSideloaded=" + this.z + ", order=" + this.D + ", iconResourceId=" + this.E + ", isSystemApp=" + this.F + ", hasBeenConfigured=" + this.G + ", isReorderable=" + this.I + '}';
        }
    }

    public enum d {
        SETTINGS(UUID.fromString("07e0d9cb-8957-4bf7-9d42-35bf47caadfe"), 0, false, false, R.string.my_pebble_settings_app, R.string.my_pebble_system_app_dev, Integer.valueOf(R.drawable.settings), true, e.APP, false),
        CALENDAR(aw.b, 1, true, true, R.string.my_pebble_calendar, R.string.my_pebble_system_app_dev, Integer.valueOf(R.drawable.calendar), false, e.APP, false),
        WEATHER(aw.c, 2, true, true, R.string.weather, R.string.my_pebble_system_app_dev, Integer.valueOf(R.drawable.weather), true, e.APP, false),
        HEALTH(am.c, 3, true, false, R.string.my_pebble_health, R.string.my_pebble_system_app_dev, Integer.valueOf(R.drawable.health_app), true, e.APP, false),
        MUSIC(UUID.fromString("1f03293d-47af-4f28-b960-f2b02a6dd757"), 4, false, false, R.string.my_pebble_music, R.string.my_pebble_system_app_dev, Integer.valueOf(R.drawable.music), true, e.APP, false),
        NOTIFICATIONS(UUID.fromString("b2cae818-10f8-46df-ad2b-98ad2254a3c1"), 5, false, false, R.string.my_pebble_notifications, R.string.my_pebble_system_app_dev, Integer.valueOf(R.drawable.notifications), true, e.APP, false),
        ALARMS(UUID.fromString("67a32d95-ef69-46d4-a0b9-854cc62f97f9"), 6, false, false, R.string.my_pebble_alarms, R.string.my_pebble_system_app_dev, Integer.valueOf(R.drawable.alarms), true, e.APP, false),
        SMS(am.d, 7, true, false, R.string.sms_app_name, R.string.my_pebble_system_app_dev, Integer.valueOf(R.drawable.ic_send_text), true, e.APP, false),
        REMINDERS(aw.f, 8, true, true, R.string.my_pebble_reminders, R.string.my_pebble_system_app_dev, Integer.valueOf(R.drawable.ic_reminders), true, e.APP, false),
        WORKOUT(am.e, 9, false, false, R.string.my_pebble_workout, R.string.my_pebble_system_app_dev, Integer.valueOf(R.drawable.ic_workout), true, e.APP, false),
        WATCHFACES(UUID.fromString("18e443ce-38fd-47c8-84d5-6d0c775fbe55"), 10, false, false, R.string.my_pebble_app_watchfaces, R.string.my_pebble_system_app_dev, Integer.valueOf(R.drawable.watchfaces), true, e.APP, false),
        ARCHIVE_HEADER_APPS(e.APP.mArchiveHeaderUuid, 11, false, false, R.string.app_archive_title, R.string.my_pebble_system_app_dev, Integer.valueOf(0), true, e.APP, true),
        ARCHIVE_HEADER_WATCHFACES(e.WATCHFACE.mArchiveHeaderUuid, 0, false, false, R.string.app_archive_title, R.string.my_pebble_system_app_dev, Integer.valueOf(0), true, e.WATCHFACE, true),
        NOT_SUPPORTED_HEADER_APPS(e.APP.mNotSupportedHeaderUuid, 12, false, false, R.string.app_not_supported_apps_title, R.string.my_pebble_system_app_dev, Integer.valueOf(0), true, e.APP, true),
        NOT_SUPPORTED_HEADER_WATCHFACES(e.WATCHFACE.mNotSupportedHeaderUuid, 0, false, false, R.string.app_not_supported_watchfaces_title, R.string.my_pebble_system_app_dev, Integer.valueOf(0), true, e.WATCHFACE, true),
        TICTOC(UUID.fromString("8f3c8686-31a1-4f5f-91f5-01600c9bdc59"), 0, false, false, R.string.my_pebble_tictoc, R.string.my_pebble_system_app_dev, null, true, e.WATCHFACE, false),
        KICKSTART(UUID.fromString("3af858c3-16cb-4561-91e7-f1ad2df8725f"), 0, false, false, R.string.my_pebble_kickstart, R.string.my_pebble_system_app_dev, null, true, e.WATCHFACE, false),
        MISSED_CALLS(UUID.fromString("af760190-bfc0-11e4-bb52-0800200c9a66"), 0, false, true, R.string.my_pebble_calls, R.string.my_pebble_system_app_dev, Integer.valueOf(0), false, null, false);
        
        public static final UUID SYSTEM_APP_GOLF = null;
        public static final UUID SYSTEM_APP_SPORTS = null;
        private final int mAuthor;
        private final boolean mHasDataSource;
        private final boolean mHasSettings;
        private final Integer mIcon;
        private final boolean mIsHeader;
        private final boolean mIsReorderable;
        private final int mOrder;
        private final int mTitle;
        private final e mType;
        private final UUID mUuid;

        static {
            SYSTEM_APP_GOLF = UUID.fromString("cf1e816a-9db0-4511-bbb8-f60c48ca8fac");
            SYSTEM_APP_SPORTS = UUID.fromString("4dab81a6-d2fc-458a-992c-7a1f3b96a970");
        }

        private d(UUID uuid, int i, boolean z, boolean z2, int i2, int i3, Integer num, boolean z3, e eVar, boolean z4) {
            this.mUuid = uuid;
            this.mOrder = i;
            this.mHasSettings = z;
            this.mHasDataSource = z2;
            this.mTitle = i2;
            this.mAuthor = i3;
            this.mIcon = num;
            this.mIsReorderable = z3;
            this.mType = eVar;
            this.mIsHeader = z4;
        }

        public int getIcon(ah ahVar) {
            if (e.WATCHFACE.equals(this.mType)) {
                return ahVar.getIconForWatchface(this);
            }
            return this.mIcon.intValue();
        }

        e getType() {
            return this.mType;
        }

        boolean isHeader() {
            return this.mIsHeader;
        }

        public UUID getUuid() {
            return this.mUuid;
        }

        public ContentValues toContentValues(Resources resources) {
            ContentValues g = new c(this, resources).g();
            g.put("pebble_sync_hashcode", "removed");
            g.put("cloud_sync_hashcode", "removed");
            return g;
        }

        public static d fromRecord(c cVar) {
            for (d dVar : values()) {
                if (dVar.mUuid.equals(cVar.b)) {
                    return dVar;
                }
            }
            return null;
        }

        public static int getNumberOfSystemApps() {
            return getCountForType(e.APP);
        }

        public static int getNumberOfSystemWatchFaces() {
            return getCountForType(e.WATCHFACE);
        }

        public static int getCountForType(e eVar) {
            int i = 0;
            for (d dVar : values()) {
                if (!dVar.isHeader() && dVar.getType() == eVar) {
                    i++;
                }
            }
            return i;
        }
    }

    public enum e {
        APP("watchapp", UUID.fromString("46255a00-ee3b-4232-9c3c-9e4d402d103d"), UUID.fromString("66f6670a-f208-4442-a3de-ad3a62254526"), 50, true),
        WATCHFACE("watchface", UUID.fromString("819ecb1f-14d3-4bf8-bc3d-8840ece89e4c"), UUID.fromString("6e2f2730-475a-4e8d-a768-009a5c1e4075"), 50, false);
        
        private final UUID mArchiveHeaderUuid;
        private final String mCode;
        private final boolean mIncludeSystemEntriesInMax;
        private final int mMaxNumToSync;
        private final UUID mNotSupportedHeaderUuid;

        private e(String str, UUID uuid, UUID uuid2, int i, boolean z) {
            this.mCode = str;
            this.mArchiveHeaderUuid = uuid;
            this.mNotSupportedHeaderUuid = uuid2;
            this.mMaxNumToSync = i;
            this.mIncludeSystemEntriesInMax = z;
        }

        public String getCode() {
            return this.mCode;
        }

        public int getMaxNumToSync() {
            return (this.mIncludeSystemEntriesInMax ? d.getCountForType(this) : 0) + this.mMaxNumToSync;
        }

        public UUID getArchiveHeaderUuid() {
            return this.mArchiveHeaderUuid;
        }

        public UUID getNotSupportedHeaderUuid() {
            return this.mNotSupportedHeaderUuid;
        }

        public static e fromString(String str) {
            for (e eVar : values()) {
                if (eVar.getCode().equals(str)) {
                    return eVar;
                }
            }
            return null;
        }
    }

    public static com.getpebble.android.common.model.am.c b(android.database.Cursor r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = 0;
        r0 = r4.moveToFirst();	 Catch:{ IllegalArgumentException -> 0x0010, all -> 0x001d }
        if (r0 == 0) goto L_0x0022;	 Catch:{ IllegalArgumentException -> 0x0010, all -> 0x001d }
    L_0x0007:
        r0 = new com.getpebble.android.common.model.am$c;	 Catch:{ IllegalArgumentException -> 0x0010, all -> 0x001d }
        r0.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0010, all -> 0x001d }
    L_0x000c:
        r4.close();
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = move-exception;
        r2 = "PebbleLockerAppDataModel";	 Catch:{ IllegalArgumentException -> 0x0010, all -> 0x001d }
        r3 = "getLockerAppFromCursor() error";	 Catch:{ IllegalArgumentException -> 0x0010, all -> 0x001d }
        com.getpebble.android.common.b.a.f.b(r2, r3, r0);	 Catch:{ IllegalArgumentException -> 0x0010, all -> 0x001d }
        r4.close();
        r0 = r1;
        goto L_0x000f;
    L_0x001d:
        r0 = move-exception;
        r4.close();
        throw r0;
    L_0x0022:
        r0 = r1;
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.common.model.am.b(android.database.Cursor):com.getpebble.android.common.model.am$c");
    }

    public am() {
        super("locker_apps");
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "app_id"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "release_id"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, an.TITLE));
        com.getpebble.android.common.model.ai.a aVar = new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "uuid");
        aVar.a(true);
        addColumn(aVar);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "share"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "developer_name"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "type"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "pbw_file"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "href"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "developer_email"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "companion_required"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "developer_id"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "version"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "companion_id"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "companion_name"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "companion_icon"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "companion_url"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "user_token"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "hearts"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "has_data_source"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "data_source_pins_enabled"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "data_source_reminders_notifications_enabled"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "store_category"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "is_configurable"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "cloud_sync_hashcode"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "pebble_sync_hashcode"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "is_active_watchface"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "is_sideloaded"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "record_hashcode"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "locker_order"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "platform_dependent_data"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "icon_resource_id"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "is_system_app"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "has_been_configured"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "is_reorderable"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "resource_map_json"));
    }

    public static List<c> a(Context context, com.getpebble.android.common.model.ak.a aVar) {
        ah ahVar = aVar.color;
        List<c> arrayList = new ArrayList(2);
        arrayList.add(new c(aVar.color.primaryWatchface.watchface, context.getResources()));
        if (ahVar.secondaryWatchface != null) {
            arrayList.add(new c(ahVar.secondaryWatchface.watchface, context.getResources()));
        }
        return arrayList;
    }

    private static void a(ContentResolver contentResolver, String str, String[] strArr) {
        f.d("PebbleLockerAppDataModel", "deleteAppsFromJsAppManager:");
        com.getpebble.android.framework.d x = PebbleApplication.x();
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, new String[]{"uuid"}, str, strArr, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    x.b(UUID.fromString(query.getString(query.getColumnIndex("uuid"))));
                } finally {
                    query.close();
                }
            }
        }
    }

    public static boolean a(ContentResolver contentResolver) {
        boolean z = true;
        String str = "record_hashcode = ? AND cloud_sync_hashcode = ? AND pebble_sync_hashcode = ?";
        String[] strArr = new String[]{"removed", "removed", "removed"};
        a(contentResolver, str, strArr);
        if (contentResolver.delete(a, str, strArr) <= 0) {
            z = false;
        }
        if (z) {
            a(contentResolver, e.APP);
            a(contentResolver, e.WATCHFACE);
        }
        return z;
    }

    public static CursorLoader a(Context context, e eVar) {
        String[] strArr = new String[]{eVar.getCode(), "removed"};
        return new com.getpebble.android.main.sections.mypebble.a.d(context, a, null, "type = ? AND record_hashcode != ? AND locker_order IS NOT NULL", strArr, "locker_order ASC , title ASC");
    }

    public static CursorLoader a(Context context) {
        String[] strArr = new String[]{"removed"};
        String[] strArr2 = new String[]{"uuid"};
        return new CursorLoader(context, a, strArr2, "record_hashcode != ?", strArr, null);
    }

    public static Set<String> a(Cursor cursor) {
        Set hashSet = new HashSet(cursor.getCount());
        if (cursor.moveToFirst()) {
            do {
                CharSequence string = cursor.getString(cursor.getColumnIndex("uuid"));
                if (!TextUtils.isEmpty(string)) {
                    hashSet.add(string);
                }
            } while (cursor.moveToNext());
        }
        return hashSet;
    }

    public static CursorLoader a(Context context, String str) {
        String[] strArr = new String[]{"removed", str, str, e.WATCHFACE.getArchiveHeaderUuid().toString(), e.WATCHFACE.getNotSupportedHeaderUuid().toString(), e.APP.getArchiveHeaderUuid().toString(), e.APP.getNotSupportedHeaderUuid().toString()};
        return new CursorLoader(context, a, null, "record_hashcode != ? AND (title LIKE ? OR developer_name LIKE ? OR UUID = ? OR UUID = ? OR UUID = ? OR UUID = ?)", strArr, "locker_order ASC , title ASC");
    }

    public static c a(UUID uuid, ContentResolver contentResolver, boolean z) {
        String str = "uuid = ?";
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, null, "uuid = ?", new String[]{uuid.toString()}, null);
        if (query == null) {
            f.b("PebbleLockerAppDataModel", "cursor is null");
            return null;
        } else if (query.moveToFirst()) {
            c cVar;
            try {
                cVar = new c(query);
                return cVar;
            } catch (IllegalArgumentException e) {
                cVar = e;
                f.b("PebbleLockerAppDataModel", "Error getting locker app", cVar);
                return null;
            } finally {
                query.close();
            }
        } else {
            if (z) {
                f.b("PebbleLockerAppDataModel", "app was not found with UUID " + uuid);
            }
            query.close();
            return null;
        }
    }

    public static CursorLoader a(UUID uuid, Context context) {
        String str = "uuid = ?";
        return new CursorLoader(context, a, null, "uuid = ?", new String[]{uuid.toString()}, null);
    }

    public static AppLayoutsMapper a(ContentResolver contentResolver, UUID uuid) {
        AppLayoutsMapper appLayoutsMapper = null;
        c a = a(uuid, contentResolver, false);
        if (a != null) {
            try {
                appLayoutsMapper = AppLayoutsMapper.from(a.J);
            } catch (IllegalArgumentException e) {
            }
        }
        return appLayoutsMapper;
    }

    public static boolean a(ContentResolver contentResolver, UUID uuid, String str) {
        String b = x.b(ad.a((Object) "uuid"));
        String[] strArr = new String[]{uuid.toString()};
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("resource_map_json", str);
        if (contentResolver.update(a, contentValues, b, strArr) > 0) {
            return true;
        }
        return false;
    }

    public static void a(ContentResolver contentResolver, PrintStream printStream) {
        i.a(contentResolver, printStream, a, "title ASC");
    }

    private static List<c> a(ContentResolver contentResolver, String str, String[] strArr, String str2) {
        Cursor query = contentResolver.query(a, null, str, strArr, str2);
        List arrayList = new ArrayList();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    arrayList.add(new c(query));
                } catch (IllegalArgumentException e) {
                    f.b("PebbleLockerAppDataModel", "Error loading app record");
                } catch (Throwable th) {
                    query.close();
                }
            }
            query.close();
        }
        return arrayList;
    }

    public static List<c> b(ContentResolver contentResolver) {
        String str = "cloud_sync_hashcode = ? AND record_hashcode != ? AND is_sideloaded = ? AND is_system_app = ?";
        return a(contentResolver, "cloud_sync_hashcode = ? AND record_hashcode != ? AND is_sideloaded = ? AND is_system_app = ?", new String[]{"removed", "removed", "0", "0"}, null);
    }

    public static List<c> c(ContentResolver contentResolver) {
        String str = "cloud_sync_hashcode != ? AND record_hashcode = ? AND is_sideloaded = ?";
        return a(contentResolver, "cloud_sync_hashcode != ? AND record_hashcode = ? AND is_sideloaded = ?", new String[]{"removed", "removed", "0"}, null);
    }

    public static List<c> d(ContentResolver contentResolver) {
        String str = "cloud_sync_hashcode != ? OR record_hashcode = ? AND is_sideloaded = ? AND is_system_app = ?";
        return a(contentResolver, "cloud_sync_hashcode != ? OR record_hashcode = ? AND is_sideloaded = ? AND is_system_app = ?", new String[]{"removed", "removed", "0", "0"}, null);
    }

    public static ContentProviderOperation a(ContentResolver contentResolver, Application application) {
        ContentProviderOperation contentProviderOperation = null;
        try {
            c cVar = new c(application);
            ContentValues g = cVar.g();
            g.put("cloud_sync_hashcode", String.valueOf(cVar.C));
            c a = a(cVar.b, contentResolver, false);
            if (a == null) {
                g.put("pebble_sync_hashcode", "removed");
                g.put("data_source_pins_enabled", Integer.valueOf(1));
                g.put("data_source_reminders_notifications_enabled", Integer.valueOf(1));
                return ContentProviderOperation.newInsert(a).withValues(g).build();
            } else if (a.a(cVar)) {
                return contentProviderOperation;
            } else {
                if (!a.z || new i(application.version).a(a.l) > 0) {
                    String str = "app_id = ?";
                    String[] strArr = new String[]{cVar.a};
                    g.remove("data_source_pins_enabled");
                    g.remove("data_source_reminders_notifications_enabled");
                    g.remove("is_active_watchface");
                    g.remove("has_been_configured");
                    f.d("PebbleLockerAppDataModel", "Updating existing locker app from cloud: " + application.uuid + " / " + application.title);
                    return ContentProviderOperation.newUpdate(a).withSelection("app_id = ?", strArr).withValues(g).build();
                }
                f.d("PebbleLockerAppDataModel", "Not overwriting " + application.title + " / " + application.uuid + " from locker (not higher version than existing sideloaded app)");
                return contentProviderOperation;
            }
        } catch (Throwable e) {
            f.b("PebbleLockerAppDataModel", "Error adding app from cloud locker json", e);
            return contentProviderOperation;
        } catch (Throwable e2) {
            f.b("PebbleLockerAppDataModel", "Error adding app from cloud locker json", e2);
            return contentProviderOperation;
        }
    }

    public static boolean a(ContentResolver contentResolver, c cVar) {
        if (a(cVar.b, contentResolver, false) != null) {
            return false;
        }
        ContentValues g = cVar.g();
        g.put("pebble_sync_hashcode", "removed");
        g.put("locker_order", Integer.valueOf(d.getCountForType(cVar.d)));
        boolean z = contentResolver.insert(a, g) != null;
        if (!z) {
            return false;
        }
        PebbleApplication.v().b();
        a(contentResolver, cVar.d);
        aw.a(contentResolver, cVar.b);
        return z;
    }

    public static boolean a(ContentResolver contentResolver, h hVar) {
        boolean z = true;
        UUID fromString = UUID.fromString(hVar.getUUID());
        if (a(fromString, contentResolver, false) != null) {
            f.d("PebbleLockerAppDataModel", "Not adding to locker from store - already added");
            return false;
        }
        a(fromString);
        ContentValues contentValues = new ContentValues();
        contentValues.put("pebble_sync_hashcode", "removed");
        contentValues.put("cloud_sync_hashcode", "removed");
        contentValues.put("record_hashcode", "0");
        contentValues.put("uuid", hVar.getUUID());
        contentValues.put("app_id", hVar.getId());
        contentValues.put(an.TITLE, hVar.getTitle());
        e fromString2 = e.fromString(hVar.getType());
        if (e.WATCHFACE.equals(fromString2)) {
            contentValues.put("locker_order", Integer.valueOf(0));
        } else {
            contentValues.put("locker_order", Integer.valueOf(fromString2.getMaxNumToSync() - 1));
        }
        contentValues.put("type", fromString2.getCode());
        contentValues.put("is_sideloaded", Integer.valueOf(0));
        contentValues.put("is_system_app", Integer.valueOf(0));
        contentValues.put("is_reorderable", Integer.valueOf(1));
        contentValues.put("data_source_pins_enabled", Integer.valueOf(1));
        contentValues.put("data_source_reminders_notifications_enabled", Integer.valueOf(1));
        if (contentResolver.insert(a, contentValues) == null) {
            z = false;
        }
        return z;
    }

    public static boolean a(ContentResolver contentResolver, com.getpebble.android.common.framework.install.app.b bVar) {
        boolean z = true;
        c a = a(bVar.i().getUuid(), contentResolver, false);
        if (a != null) {
            f.d("PebbleLockerAppDataModel", "insertFromSideloadBundle: existing; deleting then inserting");
            contentResolver.delete(a, "uuid = ?", new String[]{bVar.i().getUuid().toString()});
        }
        a(bVar.i().getUuid());
        c cVar = new c(bVar);
        ContentValues g = cVar.g();
        g.put("cloud_sync_hashcode", "removed");
        if (a != null) {
            String str;
            if (a.B == null) {
                str = "removed";
            } else {
                str = String.valueOf(a.B.intValue() == 1 ? 2 : 1);
            }
            g.put("pebble_sync_hashcode", str);
        } else {
            g.put("pebble_sync_hashcode", "removed");
        }
        if (contentResolver.insert(a, g) == null) {
            z = false;
        }
        a(contentResolver, cVar.d);
        aw.a(contentResolver, bVar.i().getUuid());
        return z;
    }

    public static void a(UUID uuid) {
        if (PebbleApplication.E().equals(com.getpebble.android.common.b.b.d.a.UI)) {
            com.getpebble.android.framework.d x = PebbleApplication.x();
            if (x != null) {
                x.c(uuid);
                return;
            }
            return;
        }
        PebbleDevice n = PebbleApplication.n();
        if (n == null) {
            f.a("PebbleLockerAppDataModel", "Could not send delayed start request, connected device was null!");
            return;
        }
        com.getpebble.android.framework.b.a c = com.getpebble.android.framework.b.a.c(n);
        Bundle bundle = new Bundle();
        bundle.putString(com.getpebble.android.framework.g.k.b.UUID.toString(), uuid.toString());
        c.a(new k(com.getpebble.android.bluetooth.g.a.BLOBDB_V1, com.getpebble.android.framework.g.k.a.START_APP_AFTER_COMMIT_TO_DB, bundle), null);
    }

    public static Set<com.getpebble.android.framework.g.e.b> e(ContentResolver contentResolver) {
        String str = "is_system_app = ? AND ((type = ? AND pebble_sync_hashcode != ? AND locker_order IS NOT NULL AND locker_order >= ?) OR (type = ? AND record_hashcode != ?  AND locker_order IS NOT NULL AND locker_order < ? AND pebble_sync_hashcode != record_hashcode) OR (type = ? AND pebble_sync_hashcode != ? AND locker_order IS NOT NULL AND locker_order >= ?) OR (type = ? AND record_hashcode != ?  AND locker_order IS NOT NULL AND locker_order < ? AND pebble_sync_hashcode != record_hashcode) OR (pebble_sync_hashcode != ? AND record_hashcode = ?))";
        int a = a(e.APP, contentResolver);
        int a2 = a(e.WATCHFACE, contentResolver);
        List<c> a3 = a(contentResolver, "is_system_app = ? AND ((type = ? AND pebble_sync_hashcode != ? AND locker_order IS NOT NULL AND locker_order >= ?) OR (type = ? AND record_hashcode != ?  AND locker_order IS NOT NULL AND locker_order < ? AND pebble_sync_hashcode != record_hashcode) OR (type = ? AND pebble_sync_hashcode != ? AND locker_order IS NOT NULL AND locker_order >= ?) OR (type = ? AND record_hashcode != ?  AND locker_order IS NOT NULL AND locker_order < ? AND pebble_sync_hashcode != record_hashcode) OR (pebble_sync_hashcode != ? AND record_hashcode = ?))", new String[]{"0", e.APP.getCode(), "removed", String.valueOf(a), e.APP.getCode(), "removed", String.valueOf(a), e.WATCHFACE.getCode(), "removed", String.valueOf(a2), e.WATCHFACE.getCode(), "removed", String.valueOf(a2), "removed", "removed"}, null);
        Set<com.getpebble.android.framework.g.e.b> hashSet = new HashSet();
        for (c cVar : a3) {
            if (cVar.l.c()) {
                hashSet.add(cVar);
            } else {
                f.d("PebbleLockerAppDataModel", "Invalid version for app " + cVar.c + " / " + cVar.b + " = " + cVar.l.d() + "; not sending to BlobDb");
            }
        }
        return hashSet;
    }

    public static boolean a(ContentResolver contentResolver, UUID uuid, a aVar, boolean z, boolean z2, boolean z3) {
        int i;
        boolean z4 = false;
        boolean z5 = aVar.equals(a.PINS) ? z : z2;
        f.d("PebbleLockerAppDataModel", "Updating " + uuid.toString() + " " + aVar.toString() + " isEnabled? " + z5);
        ContentValues contentValues = new ContentValues(1);
        String str = aVar.targetColumn;
        if (z5) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str, Integer.valueOf(i));
        String str2 = "uuid = ?";
        if (contentResolver.update(a, contentValues, "uuid = ?", new String[]{uuid.toString()}) > 0) {
            z4 = true;
        }
        if (z4) {
            com.getpebble.android.common.b.a.a.b.a aVar2;
            if (!z) {
                aVar2 = com.getpebble.android.common.b.a.a.b.a.PIN_INACTIVE;
            } else if (z2) {
                aVar2 = com.getpebble.android.common.b.a.a.b.a.PIN_ACTIVE_NOTIFICATION_UNMUTED;
            } else {
                aVar2 = com.getpebble.android.common.b.a.a.b.a.PIN_ACTIVE_NOTIFICATION_MUTED;
            }
            com.getpebble.android.common.b.a.a.c.a(aVar2, uuid.toString(), z3 ? "watch" : "phone");
            switch (aVar) {
                case REMINDERS_AND_NOTIFICATIONS:
                    aw.a(contentResolver, uuid, com.getpebble.android.common.model.aw.b.REMINDER);
                    aw.a(contentResolver, uuid, com.getpebble.android.common.model.aw.b.NOTIFICATION);
                    break;
                case PINS:
                    break;
            }
            aw.a(contentResolver, uuid, com.getpebble.android.common.model.aw.b.PIN);
            return z4;
        }
        f.a("PebbleLockerAppDataModel", "Updating data source failed: no records were updated");
        return z4;
    }

    public void updateLocalizedInfos() {
        Throwable e;
        f.d("PebbleLockerAppDataModel", "updateLocalizedInfos:");
        ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
        ArrayList arrayList = new ArrayList();
        for (d access$000 : d.values()) {
            arrayList.add(ContentProviderOperation.newUpdate(a).withValue(an.TITLE, com.getpebble.android.common.a.K().getString(access$000.mTitle)).withSelection("uuid=?", new String[]{r4[r0].mUuid.toString()}).build());
        }
        try {
            contentResolver.applyBatch("com.getpebble.android.basalt.internal.provider", arrayList);
            return;
        } catch (OperationApplicationException e2) {
            e = e2;
        } catch (RemoteException e3) {
            e = e3;
        }
        f.a("PebbleLockerAppDataModel", "updateLocalizedInfos: error ", e);
    }

    public static boolean a(UUID uuid, ContentResolver contentResolver) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("is_active_watchface", Integer.valueOf(1));
        String str = "uuid = ? AND type = ? AND ((is_active_watchface != ?) OR (is_active_watchface IS NULL))";
        if (contentResolver.update(a, contentValues, "uuid = ? AND type = ? AND ((is_active_watchface != ?) OR (is_active_watchface IS NULL))", new String[]{uuid.toString(), e.WATCHFACE.getCode(), String.valueOf(1)}) <= 0) {
            return false;
        }
        contentValues = new ContentValues(1);
        contentValues.put("is_active_watchface", Integer.valueOf(0));
        String[] strArr = new String[]{uuid.toString(), e.WATCHFACE.getCode(), String.valueOf(1)};
        String str2 = "uuid != ? AND type = ? AND is_active_watchface = ?";
        com.getpebble.android.common.b.a.a.c.e(uuid.toString());
        if (contentResolver.update(a, contentValues, "uuid != ? AND type = ? AND is_active_watchface = ?", strArr) > 0) {
            return true;
        }
        return false;
    }

    public static boolean a(UUID uuid, int i, ContentResolver contentResolver) {
        f.d("PebbleLockerAppDataModel", "updatePosition() app = " + uuid + " newPosition = " + i);
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("is_active_watchface", Integer.valueOf(1));
        contentValues.put("locker_order", Integer.valueOf(i));
        String str = "uuid = ?";
        if (contentResolver.update(a, contentValues, "uuid = ?", new String[]{uuid.toString()}) > 0) {
            return true;
        }
        return false;
    }

    public static int f(ContentResolver contentResolver) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("pebble_sync_hashcode", "removed");
        return contentResolver.update(a, contentValues, null, null);
    }

    public static Set<com.getpebble.android.framework.install.a.a.a> a(ContentResolver contentResolver, boolean z) {
        String str = "record_hashcode != ? AND is_system_app = ?";
        List<c> a = a(contentResolver, "record_hashcode != ? AND is_system_app = ?", new String[]{"removed", "0"}, null);
        Set<com.getpebble.android.framework.install.a.a.a> hashSet = new HashSet();
        for (c cVar : a) {
            if ((z || !cVar.z) && cVar.o()) {
                hashSet.add(new com.getpebble.android.framework.install.a.a.a(cVar.b, cVar.l));
            }
        }
        return hashSet;
    }

    public static CursorLoader b(Context context) {
        String str = "record_hashcode != ? AND is_system_app = ?";
        String[] strArr = new String[]{"removed", "0"};
        return new CursorLoader(context, a, null, "record_hashcode != ? AND is_system_app = ?", strArr, "locker_order ASC , title ASC");
    }

    public static ArrayList<UUID> c(Cursor cursor) {
        ArrayList<UUID> arrayList = new ArrayList();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            arrayList.add(new c(cursor).b);
        }
        return arrayList;
    }

    public static void a(c cVar, int i, int i2, List<c> list, e eVar, ContentResolver contentResolver) {
        int i3 = 0;
        while (i3 < list.size()) {
            if (((c) list.get(i3)).i()) {
                break;
            }
            i3++;
        }
        i3 = 0;
        a((List) list, eVar, contentResolver);
        UUID uuid = null;
        if (i < i3 && i2 > i3) {
            uuid = ((c) list.get(i3 - 1)).b;
        } else if (i > i3 && i2 < i3) {
            uuid = ((c) list.get(i3 + 1)).b;
        }
        if (uuid != null) {
            aw.a(com.getpebble.android.common.a.K().getContentResolver(), uuid);
            aw.a(com.getpebble.android.common.a.K().getContentResolver(), cVar.b);
        }
    }

    public static boolean a(List<c> list, e eVar, ContentResolver contentResolver) {
        ArrayList arrayList = new ArrayList();
        ContentValues contentValues = new ContentValues(1);
        contentValues.putNull("locker_order");
        arrayList.add(ContentProviderOperation.newUpdate(a).withSelection("type = ? AND uuid != ? AND uuid != ?", new String[]{eVar.getCode(), eVar.getArchiveHeaderUuid().toString(), eVar.getNotSupportedHeaderUuid().toString()}).withValues(contentValues).build());
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(ContentProviderOperation.newUpdate(a).withSelection("uuid = ?", new String[]{((c) list.get(i)).b.toString()}).withValue("locker_order", String.valueOf(i)).build());
        }
        try {
            contentResolver.applyBatch("com.getpebble.android.basalt.internal.provider", arrayList);
            return true;
        } catch (RemoteException e) {
            f.b("PebbleLockerAppDataModel", "writeAppOrder() Error doing batch update");
            return false;
        } catch (OperationApplicationException e2) {
            f.b("PebbleLockerAppDataModel", "writeAppOrder() Error doing batch update");
            return false;
        }
    }

    public static void a(ContentResolver contentResolver, e eVar) {
        com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
        if (p == null) {
            f.a("PebbleLockerAppDataModel", "maintainAppOrder: lastConnectedDeviceRecord was null.");
        } else {
            a(contentResolver, eVar, p.hwPlatform.getPlatformCode());
        }
    }

    public static void a(ContentResolver contentResolver, e eVar, com.getpebble.android.common.framework.install.app.b.a aVar) {
        List b = b(eVar, contentResolver);
        a(b, eVar, aVar);
        a(b, eVar, contentResolver);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.util.List<com.getpebble.android.common.model.am.c> r9, com.getpebble.android.common.model.am.e r10, com.getpebble.android.common.framework.install.app.b.a r11) {
        /*
        r1 = 0;
        r6 = new java.util.LinkedList;
        r6.<init>();
        r0 = r9.size();
        r0 = r0 + -1;
        r3 = r0;
        r2 = r1;
    L_0x000e:
        if (r3 < 0) goto L_0x0061;
    L_0x0010:
        r0 = r9.get(r3);
        r0 = (com.getpebble.android.common.model.am.c) r0;
        r0 = r0.i();
        if (r0 == 0) goto L_0x002b;
    L_0x001c:
        r0 = r9.remove(r3);
        r0 = (com.getpebble.android.common.model.am.c) r0;
        r8 = r1;
        r1 = r0;
        r0 = r8;
    L_0x0025:
        r2 = r3 + -1;
        r3 = r2;
        r2 = r1;
        r1 = r0;
        goto L_0x000e;
    L_0x002b:
        r0 = r9.get(r3);
        r0 = (com.getpebble.android.common.model.am.c) r0;
        r0 = r0.j();
        if (r0 == 0) goto L_0x003f;
    L_0x0037:
        r0 = r9.remove(r3);
        r0 = (com.getpebble.android.common.model.am.c) r0;
        r1 = r2;
        goto L_0x0025;
    L_0x003f:
        r0 = r9.get(r3);
        r0 = (com.getpebble.android.common.model.am.c) r0;
        r0 = r0.F;
        if (r0 != 0) goto L_0x005e;
    L_0x0049:
        r0 = r9.get(r3);
        r0 = (com.getpebble.android.common.model.am.c) r0;
        r0 = r0.H;
        r0 = r0.b(r11);
        if (r0 != 0) goto L_0x005e;
    L_0x0057:
        r0 = r9.remove(r3);
        r6.addFirst(r0);
    L_0x005e:
        r0 = r1;
        r1 = r2;
        goto L_0x0025;
    L_0x0061:
        r0 = r9.size();
        r3 = r10.getMaxNumToSync();
        if (r0 <= r3) goto L_0x0108;
    L_0x006b:
        r0 = r10.getMaxNumToSync();
        r3 = r0 + -1;
        r0 = r10.getMaxNumToSync();
        r4 = r3;
        r3 = r0;
    L_0x0077:
        r0 = r9.size();
        if (r3 >= r0) goto L_0x00c7;
    L_0x007d:
        r0 = r9.get(r3);
        r0 = (com.getpebble.android.common.model.am.c) r0;
        r5 = r0.F;
        if (r5 != 0) goto L_0x008f;
    L_0x0087:
        r5 = r0.H;
        r5 = r5.b(r11);
        if (r5 == 0) goto L_0x00be;
    L_0x008f:
        r5 = 1;
    L_0x0090:
        r7 = r0.I;
        if (r7 == 0) goto L_0x0098;
    L_0x0094:
        r7 = r0.F;
        if (r7 == 0) goto L_0x00ba;
    L_0x0098:
        r0 = r0.j();
        if (r0 != 0) goto L_0x00ba;
    L_0x009e:
        if (r5 == 0) goto L_0x00ba;
    L_0x00a0:
        r0 = r9.get(r4);
        r0 = (com.getpebble.android.common.model.am.c) r0;
    L_0x00a6:
        r5 = r0.I;
        if (r5 == 0) goto L_0x00ae;
    L_0x00aa:
        r0 = r0.F;
        if (r0 == 0) goto L_0x00b3;
    L_0x00ae:
        r4 = r4 + -1;
        if (r4 >= 0) goto L_0x00c0;
    L_0x00b2:
        r4 = r3;
    L_0x00b3:
        if (r4 < 0) goto L_0x00ba;
    L_0x00b5:
        if (r4 == r3) goto L_0x00ba;
    L_0x00b7:
        java.util.Collections.swap(r9, r3, r4);
    L_0x00ba:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0077;
    L_0x00be:
        r5 = 0;
        goto L_0x0090;
    L_0x00c0:
        r0 = r9.get(r4);
        r0 = (com.getpebble.android.common.model.am.c) r0;
        goto L_0x00a6;
    L_0x00c7:
        r0 = r10.getMaxNumToSync();
        r3 = r0;
    L_0x00cc:
        if (r2 != 0) goto L_0x00e5;
    L_0x00ce:
        r0 = com.getpebble.android.common.model.am.e.WATCHFACE;
        r0 = r10.equals(r0);
        if (r0 == 0) goto L_0x010e;
    L_0x00d6:
        r0 = com.getpebble.android.common.model.am.d.ARCHIVE_HEADER_WATCHFACES;
    L_0x00d8:
        r2 = new com.getpebble.android.common.model.am$c;
        r4 = com.getpebble.android.common.a.K();
        r4 = r4.getResources();
        r2.<init>(r0, r4);
    L_0x00e5:
        if (r1 != 0) goto L_0x00fe;
    L_0x00e7:
        r0 = com.getpebble.android.common.model.am.e.WATCHFACE;
        r0 = r10.equals(r0);
        if (r0 == 0) goto L_0x0111;
    L_0x00ef:
        r0 = com.getpebble.android.common.model.am.d.NOT_SUPPORTED_HEADER_WATCHFACES;
    L_0x00f1:
        r1 = new com.getpebble.android.common.model.am$c;
        r4 = com.getpebble.android.common.a.K();
        r4 = r4.getResources();
        r1.<init>(r0, r4);
    L_0x00fe:
        r9.add(r3, r2);
        r9.add(r1);
        r9.addAll(r6);
        return;
    L_0x0108:
        r0 = r9.size();
        r3 = r0;
        goto L_0x00cc;
    L_0x010e:
        r0 = com.getpebble.android.common.model.am.d.ARCHIVE_HEADER_APPS;
        goto L_0x00d8;
    L_0x0111:
        r0 = com.getpebble.android.common.model.am.d.NOT_SUPPORTED_HEADER_APPS;
        goto L_0x00f1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.common.model.am.a(java.util.List, com.getpebble.android.common.model.am$e, com.getpebble.android.common.framework.install.app.b$a):void");
    }

    public static int a(e eVar, ContentResolver contentResolver) {
        c a = a(eVar.getArchiveHeaderUuid(), contentResolver, false);
        if (a == null) {
            f.b("PebbleLockerAppDataModel", "getCurrentSyncLimit() Missing archive header record, defaulting to max");
            return eVar.getMaxNumToSync();
        } else if (a.D != null) {
            return a.D.intValue();
        } else {
            f.b("PebbleLockerAppDataModel", "getCurrentSyncLimit() header order is null, defaulting to max");
            return eVar.getMaxNumToSync();
        }
    }

    public static List<c> b(e eVar, ContentResolver contentResolver) {
        return a(contentResolver, "type = ? AND record_hashcode != ?", new String[]{eVar.getCode(), "removed"}, "is_reorderable ASC, locker_order IS NULL ASC, " + "CASE WHEN locker_order IS NULL THEN hearts END DESC, " + "locker_order" + " ASC, " + ai.COLUMN_DATE_CREATED + " DESC, " + an.TITLE + " ASC");
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, d dVar, Resources resources) {
        String str = "uuid = ?";
        String[] strArr = new String[]{dVar.getUuid().toString()};
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(an.TITLE, resources.getString(dVar.mTitle));
        if (sQLiteDatabase.update("locker_apps", contentValues, "uuid = ?", strArr) > 0) {
            return true;
        }
        return false;
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, Resources resources) {
        String str = "is_system_app = ?";
        String[] strArr = new String[]{String.valueOf(1)};
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("developer_name", resources.getString(R.string.my_pebble_system_app_dev));
        if (sQLiteDatabase.update("locker_apps", contentValues, "is_system_app = ?", strArr) > 0) {
            return true;
        }
        return false;
    }

    public static void a(SQLiteDatabase sQLiteDatabase, Context context) {
        sQLiteDatabase.insert("locker_apps", null, d.NOT_SUPPORTED_HEADER_APPS.toContentValues(context.getResources()));
        sQLiteDatabase.insert("locker_apps", null, d.NOT_SUPPORTED_HEADER_WATCHFACES.toContentValues(context.getResources()));
    }

    public static void b(SQLiteDatabase sQLiteDatabase, Context context) {
        String str = "uuid = ?";
        String[] strArr = new String[]{d.NOT_SUPPORTED_HEADER_APPS.getUuid().toString()};
        sQLiteDatabase.update("locker_apps", d.NOT_SUPPORTED_HEADER_APPS.toContentValues(context.getResources()), "uuid = ?", strArr);
        strArr[0] = d.NOT_SUPPORTED_HEADER_WATCHFACES.getUuid().toString();
        sQLiteDatabase.update("locker_apps", d.NOT_SUPPORTED_HEADER_WATCHFACES.toContentValues(context.getResources()), "uuid = ?", strArr);
    }

    public static List<c> d(Cursor cursor) {
        List<c> arrayList = new ArrayList();
        cursor.moveToPosition(-1);
        boolean isHealthSupported = com.getpebble.android.framework.o.b.isHealthSupported();
        boolean isSendTextAppSupported = com.getpebble.android.framework.o.b.a.isSendTextAppSupported();
        boolean isRemindersAppSupported = com.getpebble.android.framework.o.b.a.isRemindersAppSupported();
        boolean isWorkoutAppSupported = com.getpebble.android.framework.o.b.a.isWorkoutAppSupported();
        boolean B = PebbleApplication.w().B();
        while (cursor.moveToNext()) {
            c cVar = new c(cursor);
            if ((isSendTextAppSupported || !cVar.b.equals(d)) && ((isHealthSupported || !cVar.b.equals(c)) && ((isHealthSupported || !cVar.b.equals(d.KICKSTART.getUuid())) && ((isRemindersAppSupported || !cVar.b.equals(d.REMINDERS.getUuid())) && ((isWorkoutAppSupported || !cVar.b.equals(d.WORKOUT.getUuid())) && (B || !cVar.b.equals(d.WEATHER.getUuid()))))))) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public static boolean a(ContentResolver contentResolver, UUID uuid, boolean z) {
        int i;
        f.d("PebbleLockerAppDataModel", "setAppHasBeenConfigured uuid = " + uuid + " hasBeenConfigured = " + z);
        ContentValues contentValues = new ContentValues(1);
        String str = "has_been_configured";
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str, Integer.valueOf(i));
        String str2 = "uuid = ?";
        if (contentResolver.update(a, contentValues, "uuid = ?", new String[]{uuid.toString()}) > 0) {
            return true;
        }
        return false;
    }

    public static c g(ContentResolver contentResolver) {
        List a = a(contentResolver, "type = ? AND is_active_watchface = ?", new String[]{e.WATCHFACE.getCode(), String.valueOf(1)}, null);
        if (a.isEmpty()) {
            return null;
        }
        return (c) a.get(0);
    }

    public static boolean b(ContentResolver contentResolver, UUID uuid, String str) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("user_token", str);
        String str2 = "uuid = ?";
        if (contentResolver.update(a, contentValues, "uuid = ?", new String[]{uuid.toString()}) > 0) {
            return true;
        }
        return false;
    }

    public static a a(c cVar) {
        return a(cVar.H);
    }

    public static a a(b bVar) {
        a a = bVar.a(com.getpebble.android.common.framework.install.app.b.a.CHALK);
        if (a == null || !a.h) {
            a = bVar.a(com.getpebble.android.common.framework.install.app.b.a.BASALT);
        }
        if (a == null || !a.h) {
            a = bVar.a(com.getpebble.android.common.framework.install.app.b.a.DIORITE);
        }
        if (a == null || !a.h) {
            return bVar.a(com.getpebble.android.common.framework.install.app.b.a.APLITE);
        }
        return a;
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("UPDATE locker_apps SET is_reorderable = 1 WHERE uuid = '" + d.WEATHER.getUuid() + "'");
    }
}
