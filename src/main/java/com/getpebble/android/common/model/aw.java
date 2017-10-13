package com.getpebble.android.common.model;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel;
import com.getpebble.android.framework.l.a.w;
import com.getpebble.android.framework.l.b.ao;
import com.getpebble.android.framework.l.b.ap;
import com.getpebble.android.framework.timeline.h;
import com.getpebble.android.h.ab;
import com.getpebble.android.h.i;
import com.getpebble.android.h.p;
import com.getpebble.android.h.x;
import com.google.a.b.ad;
import com.google.a.b.am;
import com.google.b.l;
import com.google.b.r;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class aw extends ai {
    public static final Uri a = com.getpebble.android.common.b.b.b.a("timeline_items");
    public static final UUID b = UUID.fromString("6c6c6fc2-1912-4d25-8396-3547d1dfac5b");
    public static final UUID c = UUID.fromString("61b22bc8-1e29-460d-a236-3fe409a439ff");
    public static final UUID d = UUID.fromString("ed429c16-f674-4220-95da-454f303f15e2");
    public static final UUID e = UUID.fromString("68010669-4b38-4751-ad04-067f1d8d2ab5");
    public static final UUID f = UUID.fromString("42a07217-5491-4267-904a-d02a156752b6");
    static final Comparator<d> g = new Comparator<d>() {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((d) obj, (d) obj2);
        }

        public int a(d dVar, d dVar2) {
            long j = dVar.b.e;
            long j2 = dVar2.b.e;
            if (j == j2) {
                return 0;
            }
            return j > j2 ? 1 : -1;
        }
    };
    static final Comparator<d> h = new Comparator<d>() {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((d) obj, (d) obj2);
        }

        public int a(d dVar, d dVar2) {
            long j = dVar.b.e;
            long j2 = dVar2.b.e;
            if (j == j2) {
                return 0;
            }
            return j > j2 ? -1 : 1;
        }
    };
    private static final Set<UUID> i = am.a(d, e);
    private static final long j = TimeUnit.DAYS.toMillis(1);
    private static final String[] k = new String[]{"layout_json"};
    private static final String[] l = new String[]{"timestamp", "created_timestamp", WeatherLocationsModel.UPDATED_TIMESTAMP};
    private static final Map<String, com.getpebble.android.common.model.ai.a.a> m = new com.google.a.b.af.a().a("item_id", com.getpebble.android.common.model.ai.a.a.STRING).a("parent_id", com.getpebble.android.common.model.ai.a.a.STRING).a("data_source_uuid", com.getpebble.android.common.model.ai.a.a.STRING).a("type", com.getpebble.android.common.model.ai.a.a.INTEGER).a("timestamp", com.getpebble.android.common.model.ai.a.a.INTEGER).a("created_timestamp", com.getpebble.android.common.model.ai.a.a.INTEGER).a(WeatherLocationsModel.UPDATED_TIMESTAMP, com.getpebble.android.common.model.ai.a.a.INTEGER).a("duration", com.getpebble.android.common.model.ai.a.a.INTEGER).a("layout_json", com.getpebble.android.common.model.ai.a.a.STRING).a("actions_json", com.getpebble.android.common.model.ai.a.a.STRING).a("is_sandboxed", com.getpebble.android.common.model.ai.a.a.INTEGER).a("is_visible", com.getpebble.android.common.model.ai.a.a.INTEGER).a("is_floating", com.getpebble.android.common.model.ai.a.a.INTEGER).a("is_all_day", com.getpebble.android.common.model.ai.a.a.INTEGER).a("persist_quick_view", com.getpebble.android.common.model.ai.a.a.INTEGER).a("pebble_sync_hashcode", com.getpebble.android.common.model.ai.a.a.STRING).a("record_hashcode", com.getpebble.android.common.model.ai.a.a.STRING).a("item_source", com.getpebble.android.common.model.ai.a.a.INTEGER).a("is_removed_by_user", com.getpebble.android.common.model.ai.a.a.INTEGER).a("status", com.getpebble.android.common.model.ai.a.a.STRING).a();

    public static class a {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final String e;

        public String toString() {
            return "[AppRecord: dataSourcePinsEnabled = " + this.a + ", dataSourceRemindersNotificationsEnabled = " + this.b + ", isDataSourceSideloaded = " + this.c + ", dataSourceTitle = " + this.e + "]";
        }

        public a(boolean z, boolean z2, boolean z3, boolean z4, String str) {
            this.a = z;
            this.b = z2;
            this.c = z3;
            this.e = str;
            this.d = z4;
        }

        public int hashCode() {
            int i;
            int i2 = 1;
            if (this.a) {
                i = 1;
            } else {
                i = 0;
            }
            int i3 = i * 31;
            if (this.b) {
                i = 1;
            } else {
                i = 0;
            }
            i3 = (i + i3) * 31;
            if (this.c) {
                i = 1;
            } else {
                i = 0;
            }
            i = (i + i3) * 31;
            if (!this.d) {
                i2 = 0;
            }
            return i + i2;
        }

        static a a(Cursor cursor) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4 = true;
            String string = cursor.getString(cursor.getColumnIndex("pins_enabled"));
            if (string == null) {
                z = false;
            } else if (string.equals("1")) {
                z = true;
            } else if (string.equals("0")) {
                z = false;
            } else {
                z = false;
            }
            String string2 = cursor.getString(cursor.getColumnIndex("reminders_notifications_enabled"));
            if (string2 == null) {
                z2 = false;
            } else if (string2.equals("1")) {
                z2 = true;
            } else if (string2.equals("0")) {
                z2 = false;
            } else {
                z2 = false;
            }
            Object string3 = cursor.getString(cursor.getColumnIndex("is_sideloaded"));
            if (TextUtils.isEmpty(string3) || !string3.equals("1")) {
                z3 = false;
            } else {
                z3 = true;
            }
            Object string4 = cursor.getString(cursor.getColumnIndex("archived"));
            if (TextUtils.isEmpty(string4) || !string4.equals("1")) {
                z4 = false;
            }
            return new a(z, z2, z3, z4, cursor.getString(cursor.getColumnIndex("data_source_title")));
        }

        static a a() {
            return new a(false, false, false, false, "");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a != aVar.a) {
                return false;
            }
            if (this.b != aVar.b) {
                return false;
            }
            if (this.c != aVar.c) {
                return false;
            }
            if (this.d != aVar.d) {
                return false;
            }
            return true;
        }
    }

    public enum b {
        UNKNOWN(0, "unknown", null),
        NOTIFICATION(1, "notification", com.getpebble.android.framework.l.b.j.b.NOTIFICATIONS),
        PIN(2, "pin", com.getpebble.android.framework.l.b.j.b.PINS),
        REMINDER(3, "reminder", com.getpebble.android.framework.l.b.j.b.REMINDERS),
        OUT_OF_RANGE(4, "out_of_range", null);
        
        private final String analyticsName;
        private final com.getpebble.android.framework.l.b.j.b blobId;
        private final int id;

        private b(int i, String str, com.getpebble.android.framework.l.b.j.b bVar) {
            this.id = i;
            this.analyticsName = str;
            this.blobId = bVar;
        }

        public int id() {
            return this.id;
        }

        public static b from(int i) {
            for (b bVar : values()) {
                if (bVar.id == i) {
                    return bVar;
                }
            }
            return UNKNOWN;
        }

        public static b from(com.getpebble.android.framework.l.b.j.b bVar) {
            for (b bVar2 : values()) {
                if (bVar2.blobId != null && bVar2.blobId.equals(bVar)) {
                    return bVar2;
                }
            }
            return UNKNOWN;
        }

        public byte toByte() {
            return com.google.a.f.d.a((long) this.id);
        }

        public long getWindowStartUtcMs(long j) {
            switch (this) {
                case NOTIFICATION:
                    return j - TimeUnit.HOURS.toMillis(1);
                case REMINDER:
                    return j - TimeUnit.MINUTES.toMillis(15);
                default:
                    return new c.b.a.b(j, c.b.a.f.a).a(c.b.a.f.a()).p_().c(1).a(c.b.a.f.a).c();
            }
        }

        public long getWindowEndUtcMs(long j) {
            switch (this) {
                case NOTIFICATION:
                    throw new IllegalArgumentException("notificiations have no window upper bound");
                default:
                    return new c.b.a.b(j, c.b.a.f.a).a(c.b.a.f.a()).p_().a(3).c();
            }
        }

        public boolean hasUpperBound() {
            switch (this) {
                case NOTIFICATION:
                    return false;
                default:
                    return true;
            }
        }

        public String getAnalyticsName() {
            return this.analyticsName;
        }
    }

    public static class c implements com.getpebble.android.common.model.ai.b {
        public final UUID a;
        public final UUID b;
        public final b c;
        public final int d;
        public final long e;
        public final String f;
        public final String g;
        public final boolean h;
        public final boolean i;
        public final boolean j;
        public final boolean k;
        public final boolean l;
        public final a m;

        public enum a {
            EMPTY(-1),
            READ(4);
            
            final byte bit;
            final int leftShift;

            static a from(String str) {
                if (TextUtils.isEmpty(str)) {
                    return EMPTY;
                }
                for (a aVar : values()) {
                    if (aVar.name().matches(str)) {
                        return aVar;
                    }
                }
                return EMPTY;
            }

            public int getLeftShift() {
                return this.leftShift;
            }

            private a(int i) {
                this.leftShift = i;
                this.bit = (byte) (1 << i);
            }

            public static a from(byte b) {
                for (a aVar : values()) {
                    if (aVar.bit == b) {
                        return aVar;
                    }
                }
                return EMPTY;
            }
        }

        public com.getpebble.android.framework.timeline.e a(com.getpebble.android.framework.timeline.e.c cVar) {
            try {
                JSONArray jSONArray = new JSONObject(this.f).getJSONArray("attributes");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String serializedName = cVar.getSerializedName();
                    if (serializedName.equals(jSONObject.getString("attribute_name"))) {
                        l rVar;
                        Object obj = jSONObject.get("attribute_value");
                        if (obj instanceof String) {
                            rVar = new r((String) obj);
                        } else if (obj instanceof Boolean) {
                            rVar = new r((Boolean) obj);
                        } else if (obj instanceof Number) {
                            rVar = new r((Number) obj);
                        } else {
                            rVar = (l) obj;
                        }
                        return new com.getpebble.android.framework.timeline.e(serializedName, rVar);
                    }
                }
            } catch (Throwable e) {
                com.getpebble.android.common.b.a.f.a("TimelineModel", "Failed to parse layoutJson in getAttribute(type)", e);
            }
            return null;
        }

        public c(UUID uuid, UUID uuid2, b bVar, int i, long j, String str, String str2) {
            this(uuid, uuid2, bVar, i, j, str, str2, false, true, false, false, false, a.EMPTY);
        }

        public c(UUID uuid, UUID uuid2, b bVar, int i, long j, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, a aVar) {
            this.a = uuid;
            this.b = uuid2;
            this.c = bVar;
            this.d = i;
            this.e = j;
            this.f = str;
            this.g = str2;
            this.h = z;
            this.i = z2;
            this.j = z3;
            this.k = z4;
            this.l = z5;
            this.m = aVar;
        }

        public ContentValues a() {
            ContentValues contentValues = new ContentValues(aw.b(false).length);
            contentValues.put("item_id", this.a.toString());
            contentValues.put("parent_id", this.b == null ? null : this.b.toString());
            contentValues.put("type", Integer.valueOf(this.c.id()));
            contentValues.put("duration", Integer.valueOf(this.d));
            contentValues.put("timestamp", Long.valueOf(this.e));
            contentValues.put("layout_json", this.f);
            contentValues.put("actions_json", this.g);
            contentValues.put("is_sandboxed", Boolean.valueOf(this.h));
            contentValues.put("is_visible", Boolean.valueOf(this.i));
            contentValues.put("is_floating", Boolean.valueOf(this.j));
            contentValues.put("is_all_day", Boolean.valueOf(this.k));
            contentValues.put("persist_quick_view", Boolean.valueOf(this.l));
            contentValues.put("status", this.m.name());
            return contentValues;
        }

        public static c a(ContentValues contentValues) {
            UUID fromString = UUID.fromString(contentValues.getAsString("item_id"));
            String asString = contentValues.getAsString("parent_id");
            return new c(fromString, asString == null ? null : UUID.fromString(asString), b.from(contentValues.getAsInteger("type").intValue()), contentValues.getAsInteger("duration").intValue(), contentValues.getAsLong("timestamp").longValue(), contentValues.getAsString("layout_json"), contentValues.getAsString("actions_json"), contentValues.getAsBoolean("is_sandboxed").booleanValue(), contentValues.getAsBoolean("is_visible").booleanValue(), contentValues.getAsBoolean("is_floating").booleanValue(), contentValues.getAsBoolean("is_all_day").booleanValue(), contentValues.getAsBoolean("persist_quick_view").booleanValue(), a.from(contentValues.getAsString("status")));
        }

        public static c a(Cursor cursor) {
            UUID fromString = UUID.fromString(cursor.getString(cursor.getColumnIndex("item_id")));
            String string = cursor.getString(cursor.getColumnIndex("parent_id"));
            return new c(fromString, string == null ? null : UUID.fromString(string), b.from(cursor.getInt(cursor.getColumnIndex("type"))), cursor.getInt(cursor.getColumnIndex("duration")), cursor.getLong(cursor.getColumnIndex("timestamp")), cursor.getString(cursor.getColumnIndex("layout_json")), cursor.getString(cursor.getColumnIndex("actions_json")), cursor.getInt(cursor.getColumnIndex("is_sandboxed")) > 0, cursor.getInt(cursor.getColumnIndex("is_visible")) > 0, cursor.getInt(cursor.getColumnIndex("is_floating")) > 0, cursor.getInt(cursor.getColumnIndex("is_all_day")) > 0, cursor.getInt(cursor.getColumnIndex("persist_quick_view")) > 0, a.from(cursor.getString(cursor.getColumnIndex("status"))));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.d != cVar.d) {
                return false;
            }
            if (this.k != cVar.k) {
                return false;
            }
            if (this.j != cVar.j) {
                return false;
            }
            if (this.h != cVar.h) {
                return false;
            }
            if (this.i != cVar.i) {
                return false;
            }
            if (this.l != cVar.l) {
                return false;
            }
            if (this.e != cVar.e) {
                return false;
            }
            if (this.g == null ? cVar.g != null : !this.g.equals(cVar.g)) {
                return false;
            }
            if (this.a == null ? cVar.a != null : !this.a.equals(cVar.a)) {
                return false;
            }
            if (this.f == null ? cVar.f != null : !this.f.equals(cVar.f)) {
                return false;
            }
            if (this.b == null ? cVar.b != null : !this.b.equals(cVar.b)) {
                return false;
            }
            if (this.c != cVar.c) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode;
            int i = 1;
            int hashCode2 = (this.a != null ? this.a.hashCode() : 0) * 31;
            if (this.b != null) {
                hashCode = this.b.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode2 = (hashCode + hashCode2) * 31;
            if (this.c != null) {
                hashCode = this.c.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode2 = (((((hashCode + hashCode2) * 31) + this.d) * 31) + ((int) (this.e ^ (this.e >>> 32)))) * 31;
            if (this.f != null) {
                hashCode = this.f.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode2 = (hashCode + hashCode2) * 31;
            if (this.g != null) {
                hashCode = this.g.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode2 = (hashCode + hashCode2) * 31;
            if (this.h) {
                hashCode = 1;
            } else {
                hashCode = 0;
            }
            hashCode2 = (hashCode + hashCode2) * 31;
            if (this.i) {
                hashCode = 1;
            } else {
                hashCode = 0;
            }
            hashCode2 = (hashCode + hashCode2) * 31;
            if (this.j) {
                hashCode = 1;
            } else {
                hashCode = 0;
            }
            hashCode2 = (hashCode + hashCode2) * 31;
            if (this.k) {
                hashCode = 1;
            } else {
                hashCode = 0;
            }
            hashCode = (hashCode + hashCode2) * 31;
            if (!this.l) {
                i = 0;
            }
            return hashCode + i;
        }

        public String toString() {
            return "[PebbleRecord: type = " + this.c + " / uuid = " + this.a + " durationMins = " + this.d + " timestamp = " + this.e + " layoutJson = " + com.getpebble.android.common.b.b.a.a(this.f) + "]";
        }
    }

    public static class d implements com.getpebble.android.common.model.ai.b, com.getpebble.android.framework.g.e.b {
        public final a a;
        public final c b;
        public final long c;
        public final long d;
        final Integer e;
        final Integer f;
        public final UUID g;
        public final e h;
        public final boolean i;
        public final a j;
        private boolean k;
        private boolean l;

        public d(c cVar, long j, long j2, e eVar, UUID uuid) {
            this(a.a(), cVar, j, j2, null, Integer.valueOf(cVar.hashCode()), eVar, uuid, false, a.EMPTY);
        }

        public d(a aVar, c cVar, long j, long j2, Integer num, Integer num2, e eVar, UUID uuid, boolean z, a aVar2) {
            this.a = aVar;
            this.b = cVar;
            this.c = j;
            this.d = j2;
            this.e = num;
            this.f = num2;
            this.h = eVar;
            this.g = uuid;
            this.i = z;
            this.j = aVar2;
        }

        public int b() {
            int hashCode = (this.i ? 1 : 0) + (((this.b.hashCode() * 31) + this.a.hashCode()) * 31);
            com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
            if (p == null || !p.capabilities.supportsTwoWayDismissal) {
                return hashCode;
            }
            return (hashCode * 31) + this.j.hashCode();
        }

        public ContentValues a() {
            int i;
            ContentValues contentValues = new ContentValues(aw.b(false).length);
            contentValues.putAll(this.b.a());
            contentValues.put("created_timestamp", Long.valueOf(this.c));
            contentValues.put(WeatherLocationsModel.UPDATED_TIMESTAMP, Long.valueOf(this.d));
            contentValues.put("record_hashcode", this.f == null ? "removed" : String.valueOf(this.f));
            contentValues.put("item_source", Integer.valueOf(this.h.id()));
            contentValues.put("data_source_uuid", this.g == null ? "" : this.g.toString());
            String str = "is_removed_by_user";
            if (this.i) {
                i = 1;
            } else {
                i = 0;
            }
            contentValues.put(str, Integer.valueOf(i));
            return contentValues;
        }

        private static d b(Cursor cursor) {
            Integer num;
            Integer num2;
            c a = c.a(cursor);
            a a2 = a.a(cursor);
            long j = cursor.getLong(cursor.getColumnIndex(WeatherLocationsModel.UPDATED_TIMESTAMP));
            long j2 = cursor.getLong(cursor.getColumnIndex("created_timestamp"));
            String string = cursor.getString(cursor.getColumnIndex("record_hashcode"));
            if (string == null || string.equals("removed")) {
                num = null;
            } else {
                num = Integer.decode(string);
            }
            string = cursor.getString(cursor.getColumnIndex("pebble_sync_hashcode"));
            if (string == null || string.equals("removed")) {
                num2 = null;
            } else {
                num2 = Integer.decode(string);
            }
            e from = e.from(cursor.getInt(cursor.getColumnIndex("item_source")));
            Object string2 = cursor.getString(cursor.getColumnIndex("data_source_uuid"));
            return new d(a2, a, j2, j, num2, num, from, TextUtils.isEmpty(string2) ? null : UUID.fromString(string2), cursor.getInt(cursor.getColumnIndex("is_removed_by_user")) > 0, a.from(cursor.getString(cursor.getColumnIndex("status"))));
        }

        public boolean a(ContentResolver contentResolver, boolean z, com.getpebble.android.common.framework.install.app.b.a aVar) {
            if (aw.d.equals(this.g) && !z) {
                com.getpebble.android.framework.i.b.a(this.b.a);
            }
            if (!z || !a(contentResolver, this)) {
                return false;
            }
            if (this.f == null) {
                aw.b(contentResolver, this, System.currentTimeMillis());
            }
            return true;
        }

        private boolean a(ContentResolver contentResolver, d dVar) {
            ContentValues contentValues = new ContentValues(1);
            String valueOf = (dVar.f == null ? 1 : 0) != 0 ? "removed" : String.valueOf(dVar.f);
            if (this.l) {
                valueOf = "removed";
            }
            contentValues.put("pebble_sync_hashcode", valueOf);
            if (contentResolver.update(aw.a, contentValues, x.b(ad.a((Object) "item_id")), new String[]{dVar.b.a.toString()}) > 0) {
                return true;
            }
            return false;
        }

        @Deprecated
        boolean a(long j) {
            if (aw.a((com.getpebble.android.framework.g.e.b) this, j)) {
                return false;
            }
            if (!this.b.c.hasUpperBound() || this.b.e <= this.b.c.getWindowEndUtcMs(j)) {
                return true;
            }
            if (this.b.c.equals(b.PIN)) {
                return aw.l(com.getpebble.android.common.a.K().getContentResolver(), this.b.a);
            }
            return false;
        }

        private boolean g() {
            if (aw.i.contains(this.g)) {
                return true;
            }
            if (this.a.c != this.b.h) {
                return false;
            }
            if (!this.a.a) {
                return false;
            }
            switch (this.b.c) {
                case NOTIFICATION:
                case REMINDER:
                    return this.a.b;
                case PIN:
                    return true;
                default:
                    return false;
            }
        }

        public boolean a(com.getpebble.android.common.framework.install.app.b.a aVar) {
            if (this.k != h()) {
                com.getpebble.android.common.b.a.f.a("TimelineModel", "needsAdd = " + this.k + " / legacyNeedsAdd() = " + h());
            }
            return this.k;
        }

        @Deprecated
        private boolean h() {
            boolean z = true;
            if (this.f == null) {
                return false;
            }
            boolean z2;
            if (this.f.equals(this.e)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!(z2 && a(System.currentTimeMillis()) && g() && !this.a.d)) {
                z = false;
            }
            return z;
        }

        public boolean b(com.getpebble.android.common.framework.install.app.b.a aVar) {
            if (this.l != i()) {
                com.getpebble.android.common.b.a.f.a("TimelineModel", "needsRemove = " + this.l + " / legacyNeedsRemove() = " + i());
            }
            return this.l;
        }

        @Deprecated
        private boolean i() {
            if (this.e == null) {
                return false;
            }
            boolean z;
            if (this.f == null) {
                z = true;
            } else {
                z = false;
            }
            if (this.i || r0 || !a(System.currentTimeMillis()) || !g() || this.a.d) {
                return true;
            }
            return false;
        }

        public byte[] c() {
            return com.getpebble.android.bluetooth.b.b.a(this.b.a);
        }

        public Integer d() {
            return this.f;
        }

        public byte[] a(com.getpebble.android.common.framework.install.app.b.a aVar, v vVar, z zVar) {
            Context K = com.getpebble.android.common.a.K();
            h mapper = h.getMapper(K, vVar, zVar);
            if (mapper == null) {
                throw new IllegalArgumentException("Failed to find a mapper");
            }
            if (this.g != null) {
                mapper.setAppLayouts(am.a(K.getContentResolver(), this.g));
            }
            return new ap().serialize(this, mapper, aVar);
        }

        public com.getpebble.android.framework.l.b.j.b e() {
            return (com.getpebble.android.framework.l.b.j.b) com.getpebble.android.framework.g.e.a.get(this.b.c);
        }

        public boolean a(w wVar, Context context, final com.getpebble.android.framework.g.ag.a aVar) {
            try {
                for (com.getpebble.android.framework.timeline.c cVar : (com.getpebble.android.framework.timeline.c[]) p.a(this.b.g, com.getpebble.android.framework.timeline.c[].class)) {
                    if (cVar.getNotificationProcessorId() == wVar.d()) {
                        final com.getpebble.android.framework.timeline.f fVar = new com.getpebble.android.framework.timeline.f();
                        boolean d;
                        com.getpebble.android.framework.a.f fVar2;
                        ContentResolver contentResolver;
                        switch (cVar.getActionType()) {
                            case GENERIC:
                                if (!com.getpebble.android.common.model.am.d.CALENDAR.getUuid().equals(this.g)) {
                                    return false;
                                }
                                n.a(cVar, fVar, this.b, aVar);
                                return true;
                            case REMOVE:
                                com.getpebble.android.common.b.a.f.d("TimelineModel", "Marking item for deletion from action: " + this.b.a);
                                d = aw.d(context.getContentResolver(), this.b.a);
                                fVar.add(com.getpebble.android.framework.timeline.e.c.SUBTITLE_KEY, com.getpebble.android.common.a.K().getString(R.string.action_removed));
                                fVar.add(com.getpebble.android.framework.timeline.e.c.LARGE_ICON, com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_REMOVED);
                                aVar.a(d, fVar, null);
                                return true;
                            case MUTE:
                                boolean z;
                                com.getpebble.android.framework.timeline.e.b bVar;
                                if (this.b.c.equals(b.PIN)) {
                                    z = !this.a.b;
                                } else {
                                    z = false;
                                }
                                com.getpebble.android.common.b.a.f.d("TimelineModel", "Marking reminders/notifications as muted from action; data source: " + this.g);
                                boolean a = am.a(context.getContentResolver(), this.g, com.getpebble.android.common.model.am.a.REMINDERS_AND_NOTIFICATIONS, this.a.a, z, true);
                                fVar.add(com.getpebble.android.framework.timeline.e.c.SUBTITLE_KEY, this.a.e + " " + com.getpebble.android.common.a.K().getString(z ? R.string.action_unmuted : R.string.action_muted));
                                if (z) {
                                    bVar = com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_UNMUTE;
                                } else {
                                    bVar = com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_MUTE;
                                }
                                fVar.add(com.getpebble.android.framework.timeline.e.c.LARGE_ICON, bVar);
                                aVar.a(a, fVar, null);
                                return true;
                            case RESPONSE:
                                if (!com.getpebble.android.common.model.am.d.MISSED_CALLS.getUuid().equals(this.g)) {
                                    return true;
                                }
                                com.getpebble.android.framework.k.a.a(wVar, this.b, context.getContentResolver(), aVar);
                                return true;
                            case HTTP:
                                com.getpebble.android.common.model.timeline.b a2 = com.getpebble.android.common.model.timeline.b.a(cVar, this.g, context.getString(R.string.http_action_success), context.getString(R.string.http_action_failed));
                                fVar.add(com.getpebble.android.framework.timeline.e.c.SUBTITLE_KEY, a2.f());
                                fVar.add(com.getpebble.android.framework.timeline.e.c.LARGE_ICON, a2.g());
                                final com.getpebble.android.framework.timeline.f fVar3 = new com.getpebble.android.framework.timeline.f();
                                fVar3.add(com.getpebble.android.framework.timeline.e.c.SUBTITLE_KEY, a2.h());
                                fVar3.add(com.getpebble.android.framework.timeline.e.c.LARGE_ICON, a2.i());
                                com.getpebble.android.d.a.a(context, a2, new com.getpebble.android.d.a.b(this) {
                                    final /* synthetic */ d d;

                                    public void run() {
                                        aVar.a(a() == 2, fVar, fVar3);
                                    }
                                }, 5500);
                                return true;
                            case CALL:
                                d = com.getpebble.android.framework.k.a.a(this.b, context, aVar);
                                fVar.add(com.getpebble.android.framework.timeline.e.c.SUBTITLE_KEY, context.getString(R.string.timeline_action_result_call_forwarded));
                                fVar.add(com.getpebble.android.framework.timeline.e.c.LARGE_ICON, com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_OPENED_ON_PHONE);
                                aVar.a(d, fVar, null);
                                return true;
                            case POSTPONE:
                                if (this.h != e.REMINDERS) {
                                    com.getpebble.android.common.b.a.f.a("TimelineModel", "POSTPONE action invoked on " + this.b.c.name() + " with UUID " + this.b.a + " from source " + this.h.name() + ", which is not supported.");
                                    return false;
                                }
                                String str = (String) wVar.e().get(com.getpebble.android.framework.timeline.e.c.TIMESTAMP.getSerializedName());
                                if (str == null) {
                                    com.getpebble.android.common.b.a.f.a("TimelineModel", "Postpone action invoked with no timestamp.");
                                    return false;
                                }
                                try {
                                    long b = ab.b(str);
                                    fVar2 = new com.getpebble.android.framework.a.f(context.getContentResolver());
                                    ContentResolver contentResolver2 = context.getContentResolver();
                                    com.getpebble.android.common.b.a.a.c.a(this.b.c, this.b.e, b);
                                    for (d a3 : a(contentResolver2)) {
                                        a3.a(b, fVar2, contentResolver2);
                                    }
                                    fVar.add(com.getpebble.android.framework.timeline.e.c.SUBTITLE_KEY, com.getpebble.android.common.a.K().getString(R.string.action_postponed));
                                    fVar.add(com.getpebble.android.framework.timeline.e.c.LARGE_ICON, com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_DONE);
                                    aVar.a(true, fVar, null);
                                    return true;
                                } catch (Throwable e) {
                                    com.getpebble.android.common.b.a.f.a("TimelineModel", "Postpone action included unparseable timestamp: " + str, e);
                                    return false;
                                }
                            case COMPLETE:
                                if (this.h != e.REMINDERS) {
                                    com.getpebble.android.common.b.a.f.a("TimelineModel", "COMPLETE action invoked on " + this.b.c.name() + " with UUID " + this.b.a + " from source " + this.h.name() + ", which is not supported.");
                                    return false;
                                }
                                fVar2 = new com.getpebble.android.framework.a.f(context.getContentResolver());
                                contentResolver = context.getContentResolver();
                                com.getpebble.android.common.b.a.a.c.b(this.b.c, this.b.e);
                                for (d a32 : a(contentResolver)) {
                                    a32.b(fVar2, contentResolver);
                                }
                                fVar.add(com.getpebble.android.framework.timeline.e.c.SUBTITLE_KEY, com.getpebble.android.common.a.K().getString(R.string.action_completed));
                                fVar.add(com.getpebble.android.framework.timeline.e.c.LARGE_ICON, com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_DONE);
                                aVar.a(true, fVar, null);
                                return true;
                            case REMOTE_REMOVE:
                                if (this.h != e.REMINDERS) {
                                    com.getpebble.android.common.b.a.f.a("TimelineModel", "REMOTE_REMOVE action invoked on " + this.b.c.name() + " with UUID " + this.b.a + " from source " + this.h.name() + ", which is not supported.");
                                    return false;
                                }
                                fVar2 = new com.getpebble.android.framework.a.f(context.getContentResolver());
                                contentResolver = context.getContentResolver();
                                com.getpebble.android.common.b.a.a.c.a(this.b.c, this.b.e);
                                for (d a322 : a(contentResolver)) {
                                    a322.a(fVar2, contentResolver);
                                }
                                fVar.add(com.getpebble.android.framework.timeline.e.c.SUBTITLE_KEY, com.getpebble.android.common.a.K().getString(R.string.action_removed));
                                fVar.add(com.getpebble.android.framework.timeline.e.c.LARGE_ICON, com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_REMOVED);
                                aVar.a(true, fVar, null);
                                return true;
                            default:
                                break;
                        }
                    }
                }
            } catch (Throwable e2) {
                com.getpebble.android.common.b.a.f.b("TimelineModel", "Error deserialising timeline item action", e2);
            } catch (Throwable e22) {
                com.getpebble.android.common.b.a.f.a("TimelineModel", "Error handling timeline action", e22);
            }
            return false;
        }

        private boolean a(com.getpebble.android.framework.a.f fVar, ContentResolver contentResolver) {
            aw.d(contentResolver, this.b.a);
            return fVar.a(this, false);
        }

        private boolean b(com.getpebble.android.framework.a.f fVar, ContentResolver contentResolver) {
            aw.d(contentResolver, this.b.a);
            return fVar.a(this, true);
        }

        private d a(long j, com.getpebble.android.framework.a.f fVar, ContentResolver contentResolver) {
            ContentValues a = this.b.a();
            a.put("timestamp", Long.valueOf(1000 * j));
            d dVar = new d(c.a(a), this.c, System.currentTimeMillis(), this.h, this.g);
            aw.b(contentResolver, dVar);
            fVar.d(dVar);
            return dVar;
        }

        List<d> a(ContentResolver contentResolver) {
            if (this.h != e.REMINDERS) {
                throw new IllegalStateException("PebbleReminders-specific method called on non-PebbleReminders record.");
            }
            List<d> arrayList = new ArrayList();
            if (this.b.c == b.PIN) {
                arrayList.addAll(aw.j(contentResolver, this.b.a));
            } else if (this.b.c == b.REMINDER) {
                arrayList.add(aw.h(contentResolver, this.b.b));
            }
            if (arrayList.size() == 0) {
                com.getpebble.android.common.b.a.f.b("TimelineModel", "Retrieving all related records for Pebble Reminder on record of type " + this.b.c.name() + " but no related records found.");
            }
            arrayList.add(this);
            return arrayList;
        }

        public com.getpebble.android.framework.timeline.c[] f() {
            com.getpebble.android.framework.timeline.c[] cVarArr = (com.getpebble.android.framework.timeline.c[]) p.a(this.b.g, com.getpebble.android.framework.timeline.c[].class);
            if (!aw.d.equals(this.g)) {
                for (com.getpebble.android.framework.timeline.c cVar : cVarArr) {
                    if (cVar.getActionType().equals(com.getpebble.android.framework.timeline.c.b.MUTE)) {
                        for (com.getpebble.android.framework.timeline.e eVar : cVar.getAttributes()) {
                            if (eVar.getName().equals(com.getpebble.android.framework.timeline.e.c.TITLE_KEY.getSerializedName())) {
                                String str;
                                int i = R.string.timeline_action_title_mute;
                                if (!this.a.b) {
                                    i = R.string.timeline_action_title_unmute;
                                }
                                StringBuilder append = new StringBuilder().append(com.getpebble.android.common.a.K().getResources().getString(i)).append(" ");
                                if (TextUtils.isEmpty(this.a.e)) {
                                    str = "";
                                } else {
                                    str = this.a.e;
                                }
                                eVar.setValue(append.append(str).toString());
                            }
                        }
                    }
                }
            }
            return cVarArr;
        }

        public String toString() {
            return "Record[ pebbleRecord = " + this.b + ", appRecord = " + this.a + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.c != dVar.c) {
                return false;
            }
            if (this.d != dVar.d) {
                return false;
            }
            if (!this.a.equals(dVar.a)) {
                return false;
            }
            if (this.h != dVar.h) {
                return false;
            }
            if (!this.b.equals(dVar.b)) {
                return false;
            }
            if (this.e == null ? dVar.e != null : !this.e.equals(dVar.e)) {
                return false;
            }
            if (this.f != null) {
                if (this.f.equals(dVar.f)) {
                    return true;
                }
            } else if (dVar.f == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int i = 0;
            int hashCode2 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + ((int) (this.c ^ (this.c >>> 32)))) * 31) + ((int) (this.d ^ (this.d >>> 32)))) * 31;
            if (this.e != null) {
                hashCode = this.e.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode = (hashCode + hashCode2) * 31;
            if (this.f != null) {
                i = this.f.hashCode();
            }
            return ((hashCode + i) * 31) + this.h.hashCode();
        }
    }

    public enum e {
        UNKNOWN(0),
        WEB(1),
        ANDROID_NOTIFICATION(2),
        CALENDAR(3),
        WEATHER(4),
        PHONE_CALL(5),
        REMINDERS(6);
        
        private final int id;

        private e(int i) {
            this.id = i;
        }

        public static e from(int i) {
            for (e eVar : values()) {
                if (eVar.id == i) {
                    return eVar;
                }
            }
            return UNKNOWN;
        }

        public int id() {
            return this.id;
        }
    }

    public interface f {
        boolean a(d dVar);

        boolean b(d dVar);
    }

    public static void a(ContentResolver contentResolver, UUID uuid) {
        a(contentResolver, uuid, b.NOTIFICATION);
        a(contentResolver, uuid, b.REMINDER);
        a(contentResolver, uuid, b.PIN);
    }

    public aw() {
        super("timeline_items");
        for (Entry entry : m.entrySet()) {
            addColumn(new com.getpebble.android.common.model.ai.a((com.getpebble.android.common.model.ai.a.a) entry.getValue(), (String) entry.getKey()));
        }
    }

    public static boolean a(ContentResolver contentResolver, d dVar) {
        return a(contentResolver, dVar, true);
    }

    private static boolean a(ContentResolver contentResolver, d dVar, boolean z) {
        com.getpebble.android.common.b.a.f.d("TimelineModel", "Inserting timeline record: " + dVar.toString());
        ContentValues a = dVar.a();
        if (z) {
            a.put("pebble_sync_hashcode", "removed");
        } else {
            a.put("pebble_sync_hashcode", String.valueOf(dVar.f));
        }
        return contentResolver.insert(a, a) != null;
    }

    public static boolean b(ContentResolver contentResolver, d dVar) {
        return b(contentResolver, dVar, true);
    }

    private static boolean b(ContentResolver contentResolver, d dVar, boolean z) {
        boolean z2 = true;
        com.getpebble.android.common.b.a.f.d("TimelineModel", "Updating timeline record: " + dVar.toString());
        ContentValues a = dVar.a();
        d h = h(contentResolver, dVar.b.a);
        if (h == null) {
            com.getpebble.android.common.b.a.f.b("TimelineModel", "update() existingRecord is null");
            return false;
        }
        if (h.i) {
            a.put("record_hashcode", "removed");
            a.put("is_removed_by_user", Integer.valueOf(1));
        }
        if (!z) {
            a.put("pebble_sync_hashcode", dVar.d());
        }
        if (contentResolver.update(a, a, x.b(ad.a((Object) "item_id")), new String[]{dVar.b.a.toString()}) <= 0) {
            z2 = false;
        }
        return z2;
    }

    private static boolean l(ContentResolver contentResolver, UUID uuid) {
        String str = "parent_id = ? AND pebble_sync_hashcode = record_hashcode AND type IN (?, ?)";
        if (d(contentResolver, "parent_id = ? AND pebble_sync_hashcode = record_hashcode AND type IN (?, ?)", new String[]{uuid.toString(), String.valueOf(b.NOTIFICATION.id()), String.valueOf(b.REMINDER.id())}) != null) {
            return true;
        }
        return false;
    }

    public static boolean b(ContentResolver contentResolver, UUID uuid) {
        String b = x.b(ad.a((Object) "item_id"));
        String[] strArr = new String[]{uuid.toString()};
        com.getpebble.android.common.b.a.f.d("TimelineModel", "Marking timeline record for dismissal: " + uuid);
        if (b(contentResolver, b, strArr) > 0) {
            return true;
        }
        return false;
    }

    public static boolean c(ContentResolver contentResolver, UUID uuid) {
        String b = x.b(ad.a((Object) "item_id"));
        String[] strArr = new String[]{uuid.toString()};
        d(contentResolver, b, strArr);
        com.getpebble.android.common.b.a.f.d("TimelineModel", "Marking timeline record for deletion: " + uuid);
        if (c(contentResolver, b, strArr) > 0) {
            return true;
        }
        return false;
    }

    public static boolean d(ContentResolver contentResolver, UUID uuid) {
        String b = x.b(ad.a((Object) "item_id"));
        String[] strArr = new String[]{uuid.toString()};
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("is_removed_by_user", Integer.valueOf(1));
        contentValues.put("record_hashcode", "removed");
        if (contentResolver.update(a, contentValues, b, strArr) > 0) {
            return true;
        }
        return false;
    }

    public static boolean e(ContentResolver contentResolver, UUID uuid) {
        if (c(contentResolver, x.b(ad.a((Object) "parent_id")), new String[]{uuid.toString()}) > 0) {
            return true;
        }
        return false;
    }

    public static void a(ContentResolver contentResolver, long j) {
        d(contentResolver, j);
        c(contentResolver, j);
        b(contentResolver, j);
    }

    private static final int b(ContentResolver contentResolver, long j) {
        return contentResolver.delete(a, "type = " + b.NOTIFICATION.id() + " AND " + "timestamp" + " < ?", new String[]{String.valueOf(j - j)});
    }

    public static boolean a(ContentResolver contentResolver, e eVar) {
        if (c(contentResolver, x.b(ad.a((Object) "item_source")), new String[]{String.valueOf(eVar.id())}) > 0) {
            return true;
        }
        return false;
    }

    private static void a(StringBuilder stringBuilder, List<String> list, long j) {
        for (b bVar : ad.a(b.PIN, b.REMINDER)) {
            stringBuilder.append(" OR (type = ? AND (timestamp < ?");
            list.add(String.valueOf(bVar.id));
            list.add(String.valueOf(bVar.getWindowStartUtcMs(j)));
            if (bVar.hasUpperBound()) {
                stringBuilder.append(" OR timestamp > ?");
                list.add(String.valueOf(bVar.getWindowEndUtcMs(j)));
            }
            if (bVar.equals(b.REMINDER) || bVar.equals(b.NOTIFICATION)) {
                stringBuilder.append(" OR (reminders_notifications_enabled = 0 AND source_always_enabled = 0)");
            }
            stringBuilder.append(")");
            if (bVar.equals(b.PIN)) {
                stringBuilder.append(" AND NOT EXISTS (SELECT s.item_id FROM timeline_items s WHERE s.parent_id = main_clause_item_id AND s.pebble_sync_hashcode = s.record_hashcode)");
            }
            stringBuilder.append(")");
        }
    }

    private static List<com.getpebble.android.framework.g.e.b> a(ContentResolver contentResolver, StringBuilder stringBuilder, List<String> list, int i) {
        String stringBuilder2 = stringBuilder.toString();
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        Collection<d> a = a(contentResolver, stringBuilder2, strArr, "type_order DESC LIMIT " + i, false);
        com.getpebble.android.common.b.a.f.e("TimelineModel", "getDirtyRecordsForRemoval() selection: '" + stringBuilder2 + "' size = " + a.size());
        for (d a2 : a) {
            a2.l = true;
        }
        List<com.getpebble.android.framework.g.e.b> arrayList = new ArrayList();
        arrayList.addAll(a);
        return arrayList;
    }

    public static List<com.getpebble.android.framework.g.e.b> a(ContentResolver contentResolver, com.getpebble.android.common.framework.install.app.b.a aVar, long j, int i) {
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder("pebble_sync_hashcode != 'removed' AND (is_removed_by_user = 1 OR record_hashcode = 'removed' OR (pins_enabled = 0 AND source_always_enabled = 0)");
        a(stringBuilder, arrayList, j);
        stringBuilder.append(" OR IFNULL(is_sideloaded, 0) != IFNULL(is_sandboxed, 0)");
        stringBuilder.append(" OR archived = 1");
        stringBuilder.append(")");
        return a(contentResolver, stringBuilder, arrayList, i);
    }

    private static void b(StringBuilder stringBuilder, List<String> list, long j) {
        stringBuilder.append(" AND (");
        Object obj = 1;
        for (int id = b.NOTIFICATION.id(); id <= b.REMINDER.id(); id++) {
            b bVar = b.values()[id];
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(" OR ");
            }
            stringBuilder.append("(type = ? AND ((timestamp >= ?");
            list.add(String.valueOf(bVar.id));
            list.add(String.valueOf(bVar.getWindowStartUtcMs(j)));
            if (bVar.hasUpperBound()) {
                stringBuilder.append(" AND timestamp <= ?");
                list.add(String.valueOf(bVar.getWindowEndUtcMs(j)));
            }
            stringBuilder.append(")");
            if (bVar.equals(b.PIN)) {
                stringBuilder.append(" OR EXISTS (SELECT s.item_id FROM timeline_items s WHERE s.parent_id = main_clause_item_id AND s.pebble_sync_hashcode = s.record_hashcode)");
            }
            stringBuilder.append(")");
            if (bVar.equals(b.REMINDER) || bVar.equals(b.NOTIFICATION)) {
                stringBuilder.append(" AND (reminders_notifications_enabled != 0 OR source_always_enabled = 1)");
            }
            stringBuilder.append(")");
        }
        stringBuilder.append(")");
    }

    private static List<com.getpebble.android.framework.g.e.b> a(ContentResolver contentResolver, StringBuilder stringBuilder, List<String> list, long j, int i) {
        String stringBuilder2 = stringBuilder.toString();
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        Collection<d> a = a(contentResolver, stringBuilder2, strArr, "type_order ASC, insert_date_order ASC, CASE WHEN timestamp > " + j + " THEN " + "timestamp" + " ELSE -" + "timestamp" + " END ASC LIMIT " + i, true);
        com.getpebble.android.common.b.a.f.e("TimelineModel", "getDirtyRecordsForAdd() selection: '" + stringBuilder2 + "' size = " + a.size());
        for (d b : a) {
            b.k = true;
        }
        List<com.getpebble.android.framework.g.e.b> arrayList = new ArrayList();
        arrayList.addAll(a);
        return arrayList;
    }

    public static List<com.getpebble.android.framework.g.e.b> a(ContentResolver contentResolver, com.getpebble.android.common.framework.install.app.b.a aVar, long j, Set<com.getpebble.android.framework.l.b.j.b> set, int i) {
        List arrayList = new ArrayList();
        a(arrayList, j);
        StringBuilder stringBuilder = new StringBuilder("pebble_sync_hashcode != record_hashcode AND record_hashcode != 'removed' AND IFNULL(is_sideloaded, 0) = IFNULL(is_sandboxed, 0) AND IFNULL(archived, 0) = 0 AND (pins_enabled = 1 OR source_always_enabled = 1)");
        b(stringBuilder, arrayList, j);
        for (com.getpebble.android.framework.l.b.j.b from : set) {
            b from2 = b.from(from);
            if (!from2.equals(b.UNKNOWN)) {
                stringBuilder.append(" AND type != ?");
                arrayList.add(String.valueOf(from2.id));
            }
        }
        return a(contentResolver, stringBuilder, arrayList, j, i);
    }

    public static List<d> f(ContentResolver contentResolver, UUID uuid) {
        return a(contentResolver, x.b(ad.a((Object) "parent_id", (Object) "type")), new String[]{uuid.toString(), String.valueOf(b.REMINDER.id())}, null, false);
    }

    public static d g(ContentResolver contentResolver, UUID uuid) {
        return d(contentResolver, x.b(ad.a((Object) "item_id", (Object) "type")), new String[]{uuid.toString(), String.valueOf(b.PIN.id())});
    }

    public static d h(ContentResolver contentResolver, UUID uuid) {
        return d(contentResolver, x.b(ad.a((Object) "item_id")), new String[]{uuid.toString()});
    }

    protected static List<d> a(ContentResolver contentResolver, String str, String[] strArr, String str2, boolean z) {
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, b(z), str, strArr, str2);
        if (query == null) {
            return Collections.EMPTY_LIST;
        }
        List<d> arrayList = new ArrayList(query.getCount());
        while (query.moveToNext()) {
            try {
                arrayList.add(d.b(query));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    public static List<d> a(ContentResolver contentResolver, UUID uuid, long j) {
        String str = "parent_id = ? AND timestamp = ?";
        return a(contentResolver, "parent_id = ? AND timestamp = ?", new String[]{uuid.toString(), String.valueOf(j)}, null, false);
    }

    public static List<d> i(ContentResolver contentResolver, UUID uuid) {
        return a(contentResolver, x.b(ad.a((Object) "parent_id", (Object) "type")) + " AND record_hashcode != ?", new String[]{uuid.toString(), String.valueOf(b.NOTIFICATION.id()), "removed"}, null, false);
    }

    public static List<d> j(ContentResolver contentResolver, UUID uuid) {
        return a(contentResolver, x.b(ad.a((Object) "parent_id", (Object) "type")) + " AND record_hashcode != ?", new String[]{uuid.toString(), String.valueOf(b.REMINDER.id()), "removed"}, null, false);
    }

    private static d d(ContentResolver contentResolver, String str, String[] strArr) {
        d dVar = null;
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, b(false), str, strArr, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    dVar = d.b(query);
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        return dVar;
    }

    private static boolean b(ContentResolver contentResolver, d dVar, long j) {
        String[] strArr = new String[]{dVar.b.a.toString(), "removed", String.valueOf(dVar.b.c.getWindowStartUtcMs(j))};
        if (contentResolver.delete(a, "item_id = ? AND record_hashcode = ? AND timestamp < ?", strArr) > 0) {
            return true;
        }
        return false;
    }

    public static int a(ContentResolver contentResolver) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("pebble_sync_hashcode", "removed");
        String[] strArr = new String[]{String.valueOf(b.NOTIFICATION)};
        return contentResolver.update(a, contentValues, "type != ?", strArr);
    }

    private static void a(List<String> list, long j) {
        c.b.a.b p_ = new c.b.a.b(j, c.b.a.f.a).a(c.b.a.f.a()).p_();
        list.add(String.valueOf(p_.a(2).c()));
        list.add(String.valueOf(p_.a(1).c()));
        list.add(String.valueOf(j));
        list.add(String.valueOf(p_.c(1).c()));
        list.add(String.valueOf(p_.c()));
    }

    private static String[] b(boolean z) {
        String str;
        ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
        String str2 = "(select " + ("case when locker_apps.locker_order < " + ("case when locker_apps.type = '" + com.getpebble.android.common.model.am.e.APP.getCode() + "' then " + am.a(com.getpebble.android.common.model.am.e.APP, contentResolver) + " else " + am.a(com.getpebble.android.common.model.am.e.WATCHFACE, contentResolver) + " end") + " then 0 else 1 end") + " from " + "locker_apps" + " where " + "uuid" + " = " + "data_source_uuid" + ") " + "archived";
        String str3 = "CASE WHEN type = " + b.NOTIFICATION.id() + " THEN  CASE WHEN " + "data_source_uuid" + " = '" + d.toString() + "' THEN 0 ELSE 2 END  WHEN " + "type" + " = " + b.PIN.id() + " THEN 1  WHEN " + "type" + " = " + b.REMINDER.id() + " THEN 3  ELSE 4  END as " + "type_order";
        if (z) {
            str = "CASE WHEN timestamp > ? THEN 4 WHEN timestamp > ? THEN 2 WHEN timestamp > ? THEN 0 WHEN timestamp < ? THEN 5 WHEN timestamp < ? THEN 3 ELSE 1 END as insert_date_order";
        } else {
            str = "0 as insert_date_order";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (UUID uuid : i) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR);
            }
            stringBuilder.append("'" + uuid.toString() + "'");
        }
        String str4 = "data_source_uuid IN (" + stringBuilder + ") as " + "source_always_enabled";
        String[] strArr = (String[]) m.keySet().toArray(new String[(m.values().size() + 9)]);
        strArr[m.values().size()] = "(select data_source_pins_enabled from locker_apps where uuid = data_source_uuid AND locker_apps.record_hashcode != 'removed') pins_enabled";
        strArr[m.values().size() + 1] = "(select data_source_reminders_notifications_enabled from locker_apps where uuid = data_source_uuid AND locker_apps.record_hashcode != 'removed') reminders_notifications_enabled";
        strArr[m.values().size() + 2] = "(select is_sideloaded from locker_apps where uuid = data_source_uuid AND locker_apps.record_hashcode != 'removed') is_sideloaded";
        strArr[m.values().size() + 3] = "(select title from locker_apps where uuid = data_source_uuid AND locker_apps.record_hashcode != 'removed') data_source_title";
        strArr[m.values().size() + 4] = str2;
        strArr[m.values().size() + 5] = str3;
        strArr[m.values().size() + 6] = str4;
        strArr[m.values().size() + 7] = "item_id as main_clause_item_id";
        strArr[m.values().size() + 8] = str;
        return strArr;
    }

    private static void c(ContentResolver contentResolver, long j) {
        com.getpebble.android.common.b.a.f.d("TimelineModel", "deleteStaleRecords(): Deleting stale records that are removed from Pebble.");
        String str = x.b(ad.a((Object) "record_hashcode", (Object) "pebble_sync_hashcode")) + " AND timestamp < ? AND type = ?";
        int i = 0;
        for (b bVar : b.values()) {
            i += contentResolver.delete(a, str, new String[]{"removed", "removed", String.valueOf(bVar.getWindowStartUtcMs(j)), String.valueOf(bVar.id())});
        }
        com.getpebble.android.common.b.a.f.d("TimelineModel", String.format("deleteStaleRecords(): deleted %d records from the TimelineModel", new Object[]{Integer.valueOf(i)}));
    }

    private static void d(ContentResolver contentResolver, long j) {
        com.getpebble.android.common.b.a.f.d("TimelineModel", "Marking old records removed");
        for (b bVar : ad.a(b.PIN, b.REMINDER)) {
            c(contentResolver, "timestamp < ? AND type = ?", new String[]{String.valueOf(bVar.getWindowStartUtcMs(j)), String.valueOf(bVar.id())});
        }
    }

    static int a(ContentResolver contentResolver, String str, String[] strArr) {
        Cursor query = contentResolver.query(a, null, str, strArr, null);
        if (query == null || !query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            return 0;
        }
        boolean z = false;
        try {
            z = false;
            for (d dVar : a(contentResolver, str, strArr, null, false)) {
                if (dVar == null) {
                    return z;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("record_hashcode", String.valueOf(dVar.b()));
                z += contentResolver.update(a, contentValues, str, strArr);
            }
            query.close();
            return z;
        } finally {
            query.close();
        }
    }

    static int b(ContentResolver contentResolver, String str, String[] strArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", a.READ.name());
        contentResolver.update(a, contentValues, str, strArr);
        return a(contentResolver, str, strArr);
    }

    static int c(ContentResolver contentResolver, String str, String[] strArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("record_hashcode", "removed");
        com.getpebble.android.common.b.a.f.d("TimelineModel", String.format("Marked %d records removed", new Object[]{Integer.valueOf(contentResolver.update(a, contentValues, str, strArr))}));
        return contentResolver.update(a, contentValues, str, strArr);
    }

    public static void a(ContentResolver contentResolver, UUID uuid, b bVar) {
        List<d> a = a(contentResolver, x.b(ad.a((Object) "data_source_uuid", (Object) "type")), new String[]{uuid.toString(), String.valueOf(bVar.id())}, null, false);
        ArrayList arrayList = new ArrayList();
        for (d dVar : a) {
            if (dVar.f != null) {
                String b = x.b(ad.a((Object) "item_id"));
                String[] strArr = new String[]{dVar.b.a.toString()};
                ContentValues contentValues = new ContentValues(1);
                contentValues.put("record_hashcode", String.valueOf(dVar.b()));
                arrayList.add(ContentProviderOperation.newUpdate(a).withSelection(b, strArr).withValues(contentValues).build());
            }
        }
        try {
            contentResolver.applyBatch(a.getAuthority(), arrayList);
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.a("TimelineModel", "Error doing batch update in updateRecordHashcodes", e);
        }
    }

    public static boolean a(ContentResolver contentResolver, String str, d dVar) {
        String[] strArr = new String[]{str};
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(a, null, x.b(ad.a((Object) "item_id")), strArr, null);
        if (query.moveToFirst()) {
            query.close();
            return b(contentResolver, dVar);
        }
        query.close();
        return a(contentResolver, dVar);
    }

    @Deprecated
    public static boolean a(com.getpebble.android.framework.g.e.b bVar, long j) {
        if (!(bVar instanceof d)) {
            return false;
        }
        d dVar = (d) bVar;
        if (dVar.b.c.getWindowStartUtcMs(j) > dVar.b.e) {
            return true;
        }
        return false;
    }

    public static void a(ContentResolver contentResolver, PrintStream printStream) {
        i.a(contentResolver, printStream, a, "timestamp ASC", k, l);
    }

    public static com.getpebble.android.framework.l.b.c a(ContentResolver contentResolver, com.getpebble.android.framework.l.a.b bVar, ao aoVar, f fVar, com.getpebble.android.common.framework.install.app.b.a aVar) {
        c a = aoVar.a(bVar.d(), aVar);
        if (a == null) {
            com.getpebble.android.common.b.a.f.b("TimelineModel", "Failed to parse inbound Write message data. Database: " + bVar.c());
            return bVar.a(com.getpebble.android.framework.l.a.INVALID_DATA);
        }
        d h = h(contentResolver, a.a);
        if (h == null) {
            return bVar.a(a(contentResolver, a, null, fVar) ? com.getpebble.android.framework.l.a.SUCCESS : com.getpebble.android.framework.l.a.FAILURE);
        }
        Object obj = (h.d() == null || !h.d().equals(h.e)) ? 1 : null;
        if (obj == null) {
            return bVar.a(a(contentResolver, a, h, fVar) ? com.getpebble.android.framework.l.a.SUCCESS : com.getpebble.android.framework.l.a.FAILURE);
        }
        com.getpebble.android.common.b.a.f.c("TimelineModel", "Write received from watch, but the local record has been changed and those changes haven't been synced to the watch. Discarding watch changes.");
        return bVar.a(com.getpebble.android.framework.l.a.SUCCESS);
    }

    private static boolean a(ContentResolver contentResolver, c cVar, d dVar, f fVar) {
        d g;
        UUID uuid = null;
        switch (cVar.c) {
            case NOTIFICATION:
            case REMINDER:
                g = g(contentResolver, cVar.b);
                if (g == null) {
                    com.getpebble.android.common.b.a.f.b("TimelineModel", "Upserting a timeline record of type " + cVar.c.name() + " and could not find the respective pin (" + cVar.b + ")");
                    break;
                }
                uuid = g.b.b;
                break;
            case PIN:
                uuid = cVar.b;
                break;
        }
        e a = a(uuid);
        long currentTimeMillis = System.currentTimeMillis();
        if (dVar == null) {
            g = new d(cVar, currentTimeMillis, currentTimeMillis, a, uuid);
            if (fVar == null || fVar.a(g)) {
                return a(contentResolver, g, false);
            }
            return false;
        }
        d dVar2 = new d(cVar, dVar.c, currentTimeMillis, a, uuid);
        if (fVar == null || fVar.b(dVar2)) {
            return b(contentResolver, dVar2, false);
        }
        return false;
    }

    private static e a(UUID uuid) {
        if (f.equals(uuid)) {
            return e.REMINDERS;
        }
        if (b.equals(uuid)) {
            return e.CALENDAR;
        }
        if (c.equals(uuid)) {
            return e.WEATHER;
        }
        return e.UNKNOWN;
    }
}
