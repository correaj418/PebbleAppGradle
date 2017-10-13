package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.CalendarContract.Reminders;
import android.text.TextUtils;
import com.getpebble.android.basalt.R;
import com.getpebble.android.framework.timeline.g;
import com.getpebble.android.h.aa;
import com.getpebble.android.h.ab;
import com.getpebble.android.h.v;
import com.getpebble.android.h.x;
import com.google.a.b.am;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class n extends ai {
    public static final Uri a = com.getpebble.android.common.b.b.b.a("calendar_events");
    private static final SimpleDateFormat b = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    private static final String[] c = new String[]{ai.COLUMN_ID, "method", "minutes"};

    public static abstract class a {
        final long a;

        public a(long j) {
            this.a = j;
        }

        public long a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            if (this.a != ((a) obj).a) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (int) (this.a ^ (this.a >>> 32));
        }
    }

    public static class b {
        public final e a;
        public final Set<a> b;

        public b(e eVar, Set<a> set) {
            this.a = eVar;
            this.b = set;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.a.equals(bVar.a)) {
                return false;
            }
            if (this.b.equals(bVar.b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }
    }

    public static class e {
        public final long b;
        public final long c;
        public final long d;
        public final String e;
        public final String f;
        public final String g;
        public final boolean h;
        public final long i;
        public final long j;
        public final String k;
        public final int l;
        public final String m;
        public final String n;
        public final int o;
        public final com.getpebble.android.framework.timeline.e.a p;
        public final boolean q;
        public final long r;
        public final boolean s;
        public final com.getpebble.android.framework.a.d t;

        protected e(e eVar) {
            this.b = eVar.b;
            this.c = eVar.c;
            this.d = eVar.d;
            this.e = eVar.e;
            this.f = eVar.f;
            this.g = eVar.g;
            this.h = eVar.h;
            this.i = eVar.i;
            this.j = eVar.j;
            this.k = eVar.k;
            this.l = eVar.l;
            this.m = eVar.m;
            this.n = eVar.n;
            this.o = eVar.o;
            this.p = eVar.p;
            this.q = eVar.q;
            this.r = eVar.r;
            this.s = eVar.s;
            this.t = eVar.t;
        }

        public e(Cursor cursor, String str, boolean z, int i, com.getpebble.android.framework.timeline.e.a aVar) {
            boolean z2 = true;
            this.b = cursor.getLong(cursor.getColumnIndex(ai.COLUMN_ID));
            this.c = cursor.getLong(cursor.getColumnIndex("event_id"));
            this.d = cursor.getLong(cursor.getColumnIndex("calendar_id"));
            this.e = cursor.getString(cursor.getColumnIndex(an.TITLE));
            this.f = cursor.getString(cursor.getColumnIndex("description"));
            this.g = cursor.getString(cursor.getColumnIndex("eventLocation"));
            this.h = cursor.getInt(cursor.getColumnIndex("allDay")) == 1;
            this.i = cursor.getLong(cursor.getColumnIndex("begin"));
            this.j = cursor.getLong(cursor.getColumnIndex("end"));
            this.k = cursor.getString(cursor.getColumnIndex("calendar_displayName"));
            this.l = cursor.getInt(cursor.getColumnIndex("selfAttendeeStatus"));
            this.m = cursor.getString(cursor.getColumnIndex("ownerAccount"));
            this.r = cursor.getLong(cursor.getColumnIndex("original_id"));
            this.t = a(cursor);
            this.n = str;
            this.o = i;
            this.p = aVar;
            this.q = z;
            if (cursor.getInt(cursor.getColumnIndex("calendar_access_level")) < 300) {
                z2 = false;
            }
            this.s = z2;
        }

        private com.getpebble.android.framework.a.d a(Cursor cursor) {
            int columnIndex = cursor.getColumnIndex("customAppUri");
            if (columnIndex == -1) {
                return null;
            }
            Object string = cursor.getString(columnIndex);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            com.getpebble.android.framework.a.d dVar;
            try {
                dVar = new com.getpebble.android.framework.a.d(Uri.parse(string));
            } catch (Throwable e) {
                com.getpebble.android.common.b.a.f.e("CalendarEventModel", "Found metadata from another app, skipping.", e);
                dVar = null;
            } catch (Throwable e2) {
                com.getpebble.android.common.b.a.f.a("CalendarEventModel", "Found metadata in bad state, skipping.", e2);
                dVar = null;
            }
            return dVar;
        }

        public e(Cursor cursor) {
            boolean z = true;
            this.b = cursor.getLong(cursor.getColumnIndex(ai.COLUMN_ID));
            this.c = cursor.getLong(cursor.getColumnIndex("event_id"));
            this.d = cursor.getLong(cursor.getColumnIndex("calendar_id"));
            this.e = cursor.getString(cursor.getColumnIndex(an.TITLE));
            this.f = cursor.getString(cursor.getColumnIndex("description"));
            this.g = cursor.getString(cursor.getColumnIndex("eventLocation"));
            this.h = cursor.getInt(cursor.getColumnIndex("allDay")) == 1;
            this.i = cursor.getLong(cursor.getColumnIndex("begin"));
            this.j = cursor.getLong(cursor.getColumnIndex("end"));
            this.k = cursor.getString(cursor.getColumnIndex("calendar_displayName"));
            this.l = cursor.getInt(cursor.getColumnIndex("selfAttendeeStatus"));
            this.m = cursor.getString(cursor.getColumnIndex("ownerAccount"));
            this.n = cursor.getString(cursor.getColumnIndex("organizer_name"));
            this.o = cursor.getInt(cursor.getColumnIndex("num_attending"));
            this.p = com.getpebble.android.framework.timeline.e.a.from(cursor.getInt(cursor.getColumnIndex("is_recurring")));
            if (cursor.getInt(cursor.getColumnIndex("is_organizer")) != 1) {
                z = false;
            }
            this.q = z;
            this.r = cursor.getLong(cursor.getColumnIndex("original_id"));
            this.t = a(cursor);
            this.s = false;
        }

        public long e() {
            return this.j - this.i;
        }

        protected ContentValues a() {
            int i = 1;
            ContentValues contentValues = new ContentValues();
            contentValues.put(ai.COLUMN_ID, Long.valueOf(this.b));
            contentValues.put("event_id", Long.valueOf(this.c));
            contentValues.put("calendar_id", Long.valueOf(this.d));
            contentValues.put(an.TITLE, this.e);
            contentValues.put("description", this.f);
            contentValues.put("eventLocation", this.g);
            contentValues.put("allDay", Integer.valueOf(this.h ? 1 : 0));
            contentValues.put("begin", Long.valueOf(this.i));
            contentValues.put("end", Long.valueOf(this.j));
            contentValues.put("calendar_displayName", this.k);
            contentValues.put("selfAttendeeStatus", Integer.valueOf(this.l));
            contentValues.put("ownerAccount", this.m);
            contentValues.put("organizer_name", this.n);
            String str = "is_organizer";
            if (!this.q) {
                i = 0;
            }
            contentValues.put(str, Integer.valueOf(i));
            contentValues.put("is_recurring", Integer.valueOf(this.p != null ? this.p.getIntValue() : com.getpebble.android.framework.timeline.e.a.NONE.getIntValue()));
            contentValues.put("num_attending", Integer.valueOf(this.o));
            return contentValues;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (this.c != eVar.c || this.b != eVar.b || this.d != eVar.d || this.h != eVar.h || this.i != eVar.i || this.j != eVar.j || this.l != eVar.l || this.o != eVar.o || this.q != eVar.q) {
                return false;
            }
            if (this.m != null) {
                if (!this.m.equals(eVar.m)) {
                    return false;
                }
            } else if (this.m != null) {
                return false;
            }
            if (this.e != null) {
                if (!this.e.equals(eVar.e)) {
                    return false;
                }
            } else if (eVar.e != null) {
                return false;
            }
            if (this.f != null) {
                if (!this.f.equals(eVar.f)) {
                    return false;
                }
            } else if (eVar.f != null) {
                return false;
            }
            if (this.g != null) {
                if (!this.g.equals(eVar.g)) {
                    return false;
                }
            } else if (eVar.g != null) {
                return false;
            }
            if (this.k != null) {
                if (!this.k.equals(eVar.k)) {
                    return false;
                }
            } else if (eVar.k != null) {
                return false;
            }
            if (this.n != null) {
                if (!this.n.equals(eVar.n)) {
                    return false;
                }
            } else if (eVar.n != null) {
                return false;
            }
            if (this.p != eVar.p) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            int hashCode;
            int i = 1;
            int hashCode2 = ((this.e != null ? this.e.hashCode() : 0) + (((((int) (this.c ^ (this.c >>> 32))) * 31) + ((int) (this.d ^ (this.d >>> 32)))) * 31)) * 31;
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
            hashCode2 = (((((hashCode + hashCode2) * 31) + ((int) (this.i ^ (this.i >>> 32)))) * 31) + ((int) (this.j ^ (this.j >>> 32)))) * 31;
            if (this.k != null) {
                hashCode = this.k.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode2 = (((hashCode + hashCode2) * 31) + this.l) * 31;
            if (this.m != null) {
                hashCode = this.m.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode2 = (hashCode + hashCode2) * 31;
            if (this.n != null) {
                hashCode = this.n.hashCode();
            } else {
                hashCode = 0;
            }
            hashCode = ((this.p != null ? this.p.hashCode() : com.getpebble.android.framework.timeline.e.a.NONE.getIntValue()) + ((((hashCode + hashCode2) * 31) + this.o) * 31)) * 31;
            if (!this.q) {
                i = 0;
            }
            return hashCode + i;
        }

        public String toString() {
            String str;
            StringBuilder append = new StringBuilder().append("SystemRecord{instanceId=").append(this.b).append(", eventId=").append(this.c).append(", calendarId=").append(this.d).append(", title='").append(com.getpebble.android.common.b.b.a.a(this.e)).append('\'').append(", description='").append(com.getpebble.android.common.b.b.a.a(this.f)).append('\'').append(", location='").append(com.getpebble.android.common.b.b.a.a(this.g)).append('\'').append(", allDay=").append(this.h).append(", begin=").append(n.b.format(new Date(this.i))).append(", endMillisUtc=").append(n.b.format(new Date(this.j))).append(", calendarName='").append(com.getpebble.android.common.b.b.a.a(this.k)).append('\'').append(", selfAttendeeStatus=").append(this.l).append(", ownerAccount='").append(com.getpebble.android.common.b.b.a.a(this.m)).append('\'').append(", organizerName='").append(com.getpebble.android.common.b.b.a.a(this.n)).append('\'').append(", numAttending=").append(this.o).append(", isRecurring=").append(this.p.getStringValue()).append(", isOrganizer=").append(this.q).append(", pebbleMetadata=");
            if (this.t == null) {
                str = "";
            } else {
                str = this.t.a().toString();
            }
            return append.append(str).append('}').toString();
        }
    }

    public static class c extends e {
        public final UUID a;

        public c(e eVar, UUID uuid) {
            super(eVar);
            this.a = uuid;
        }

        public c(Cursor cursor) {
            super(cursor);
            this.a = UUID.fromString(cursor.getString(cursor.getColumnIndex("pin_uuid")));
        }

        protected ContentValues a() {
            ContentValues a = super.a();
            a.put("pin_uuid", this.a.toString());
            return a;
        }

        public com.getpebble.android.common.model.aw.d b() {
            int toMinutes = (int) TimeUnit.MILLISECONDS.toMinutes(e());
            com.getpebble.android.common.model.aw.c cVar = new com.getpebble.android.common.model.aw.c(this.a, aw.b, com.getpebble.android.common.model.aw.b.PIN, toMinutes, this.i, new g(g.CALENDAR_PIN, d()).toJson(), com.getpebble.android.framework.timeline.d.getCalendarPinActions(this.l, this.q).toJson(), false, true, false, this.h, false, com.getpebble.android.common.model.aw.c.a.EMPTY);
            long currentTimeMillis = System.currentTimeMillis();
            return new com.getpebble.android.common.model.aw.d(cVar, currentTimeMillis, currentTimeMillis, com.getpebble.android.common.model.aw.e.CALENDAR, aw.b);
        }

        private String f() {
            StringBuilder stringBuilder = new StringBuilder();
            Date date = new Date(this.i);
            Date date2 = new Date(this.j);
            stringBuilder.append(DateFormat.getDateInstance(2).format(date));
            stringBuilder.append("\n");
            if (this.h) {
                stringBuilder.append(com.getpebble.android.common.a.K().getResources().getString(R.string.timeline_calendar_invite_allday));
                return stringBuilder.toString();
            }
            DateFormat timeInstance = SimpleDateFormat.getTimeInstance(3);
            if (android.text.format.DateFormat.is24HourFormat(com.getpebble.android.common.a.K())) {
                stringBuilder.append(timeInstance.format(date)).append(" - ").append(timeInstance.format(date2));
                return stringBuilder.toString();
            }
            DateFormat simpleDateFormat = new SimpleDateFormat("h a", com.getpebble.android.common.a.K().getResources().getConfiguration().locale);
            if (ab.d(this.i)) {
                stringBuilder.append(simpleDateFormat.format(date));
            } else {
                stringBuilder.append(timeInstance.format(date2));
            }
            stringBuilder.append(" - ");
            if (ab.d(this.j)) {
                stringBuilder.append(simpleDateFormat.format(date2));
            } else {
                stringBuilder.append(timeInstance.format(date2));
            }
            return stringBuilder.toString();
        }

        public com.getpebble.android.common.model.aw.d c() {
            String string;
            String string2;
            Resources resources = com.getpebble.android.common.a.K().getResources();
            if (TextUtils.isEmpty(this.n)) {
                string = resources.getString(R.string.timeline_calendar_invite_subtitle, new Object[]{this.e});
            } else {
                string = resources.getString(R.string.timeline_calendar_invite_subtitle_from_organizer, new Object[]{this.n, this.e});
            }
            if (TextUtils.isEmpty(this.f)) {
                string2 = resources.getString(R.string.timeline_calendar_invite_description_fallback);
            } else {
                string2 = this.f;
            }
            g gVar = new g(g.GENERIC_NOTIFICATION, new com.getpebble.android.framework.timeline.f().add(com.getpebble.android.framework.timeline.e.c.TITLE_KEY, f()).add(com.getpebble.android.framework.timeline.e.c.SUBTITLE_KEY, string).add(com.getpebble.android.framework.timeline.e.c.BODY_KEY, string2).add(com.getpebble.android.framework.timeline.e.c.TINY_ICON, com.getpebble.android.framework.timeline.e.b.CALENDAR_ICON));
            com.getpebble.android.framework.timeline.d calendarInviteActions = com.getpebble.android.framework.timeline.d.getCalendarInviteActions(this.l, this.q);
            int toMinutes = (int) TimeUnit.MILLISECONDS.toMinutes(e());
            long currentTimeMillis = System.currentTimeMillis();
            return new com.getpebble.android.common.model.aw.d(new com.getpebble.android.common.model.aw.c(UUID.randomUUID(), this.a, com.getpebble.android.common.model.aw.b.NOTIFICATION, toMinutes, currentTimeMillis, gVar.toJson(), calendarInviteActions.toJson(), false, true, false, false, false, com.getpebble.android.common.model.aw.c.a.EMPTY), currentTimeMillis, currentTimeMillis, com.getpebble.android.common.model.aw.e.CALENDAR, aw.b);
        }

        public String toString() {
            return "LocalRecord{" + super.toString() + " uuid=" + this.a + '}';
        }

        public com.getpebble.android.framework.timeline.f d() {
            Resources resources = com.getpebble.android.common.a.K().getResources();
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            if (!TextUtils.isEmpty(this.n)) {
                arrayList.add(resources.getString(R.string.timeline_calendar_organizer));
                arrayList2.add(this.n);
            }
            if (this.o > 0) {
                Object string;
                arrayList.add("");
                if (this.o == 1) {
                    string = resources.getString(R.string.timeline_calendar_guest);
                } else {
                    string = resources.getString(R.string.timeline_calendar_guests, new Object[]{Integer.valueOf(this.o)});
                }
                arrayList2.add(string);
            }
            if (!TextUtils.isEmpty(this.k)) {
                arrayList.add(resources.getString(R.string.timeline_calendar_calendar_name));
                arrayList2.add(this.k);
            }
            if (!TextUtils.isEmpty(this.f)) {
                arrayList.add(resources.getString(R.string.timeline_calendar_notes));
                arrayList2.add(aa.b(this.f));
            }
            return new com.getpebble.android.framework.timeline.f().add(com.getpebble.android.framework.timeline.e.c.TITLE_KEY, this.e).add(com.getpebble.android.framework.timeline.e.c.LOCATION_NAME, this.g).add(com.getpebble.android.framework.timeline.e.c.TINY_ICON, com.getpebble.android.framework.timeline.e.b.CALENDAR_ICON).add(com.getpebble.android.framework.timeline.e.c.HEADINGS, arrayList).add(com.getpebble.android.framework.timeline.e.c.PARAGRAPHS, arrayList2).add(com.getpebble.android.framework.timeline.e.c.DISPLAY_RECURRING, this.p.getStringValue());
        }
    }

    public static class d extends a {
        final long b;
        final int c;
        final int d;

        public d(long j, long j2, int i, int i2) {
            super(j);
            this.b = j2;
            this.c = i;
            this.d = i2;
        }

        public String toString() {
            return "id: " + this.b + " time: " + n.b.format(new Date(this.a)) + " method: " + this.c + " minutes before: " + this.d;
        }

        public static Set<a> a(ContentResolver contentResolver, e eVar) {
            String[] strArr = new String[]{Long.toString(eVar.c)};
            Uri uri = Reminders.CONTENT_URI;
            String[] b = n.c;
            ContentResolver contentResolver2 = contentResolver;
            Cursor query = contentResolver2.query(uri, b, "event_id=?", strArr, "minutes desc");
            if (query == null) {
                com.getpebble.android.common.b.a.f.b("CalendarEventModel", "populateReminders: cursor is null");
                return am.h();
            }
            Set<a> hashSet = new HashSet();
            long currentTimeMillis = System.currentTimeMillis();
            int i = 0;
            while (query.moveToNext()) {
                try {
                    long j = query.getLong(query.getColumnIndex(ai.COLUMN_ID));
                    int i2 = query.getInt(query.getColumnIndex("method"));
                    int i3 = query.getInt(query.getColumnIndex("minutes"));
                    long toMillis = eVar.i - TimeUnit.MINUTES.toMillis((long) i3);
                    if (toMillis >= com.getpebble.android.common.model.aw.b.REMINDER.getWindowStartUtcMs(currentTimeMillis)) {
                        d dVar = new d(toMillis, j, i2, i3);
                        if (hashSet.contains(dVar)) {
                            continue;
                        } else {
                            hashSet.add(dVar);
                            int i4 = i + 1;
                            if (i4 == 3) {
                                break;
                            }
                            i = i4;
                        }
                    }
                } catch (Throwable th) {
                    query.close();
                }
            }
            query.close();
            return hashSet;
        }
    }

    public static class f extends a {
        final UUID b;

        public f(long j, UUID uuid) {
            super(j);
            this.b = uuid;
        }

        public static f a(com.getpebble.android.common.model.aw.d dVar) {
            return new f(dVar.b.e, dVar.b.a);
        }

        public static Set<a> a(ContentResolver contentResolver, UUID uuid) {
            List<com.getpebble.android.common.model.aw.d> f = aw.f(contentResolver, uuid);
            Iterator it = f.iterator();
            while (it.hasNext()) {
                if (((com.getpebble.android.common.model.aw.d) it.next()).f == null) {
                    it.remove();
                }
            }
            Set<a> hashSet = new HashSet();
            for (com.getpebble.android.common.model.aw.d a : f) {
                hashSet.add(a(a));
            }
            return hashSet;
        }

        public UUID b() {
            return this.b;
        }

        private static com.getpebble.android.framework.timeline.f a(e eVar) {
            com.getpebble.android.framework.timeline.f add = new com.getpebble.android.framework.timeline.f().add(com.getpebble.android.framework.timeline.e.c.TITLE_KEY, eVar.e).add(com.getpebble.android.framework.timeline.e.c.LOCATION_NAME, eVar.g).add(com.getpebble.android.framework.timeline.e.c.TINY_ICON, com.getpebble.android.framework.timeline.e.b.NOTIFICATION_REMINDER);
            String a = n.b(eVar);
            if (!TextUtils.isEmpty(a)) {
                add.add(com.getpebble.android.framework.timeline.e.c.BODY_KEY, a);
            }
            return add;
        }

        public static com.getpebble.android.common.model.aw.d a(a aVar, c cVar) {
            return a(aVar, cVar, UUID.randomUUID());
        }

        public static com.getpebble.android.common.model.aw.d a(a aVar, c cVar, UUID uuid) {
            UUID uuid2 = uuid;
            com.getpebble.android.common.model.aw.c cVar2 = new com.getpebble.android.common.model.aw.c(uuid2, cVar.a, com.getpebble.android.common.model.aw.b.REMINDER, 0, aVar.a(), new g(g.GENERIC_REMINDER, a((e) cVar)).toJson(), com.getpebble.android.framework.timeline.d.getCalendarReminderActions(cVar.l, cVar.q).toJson(), false, true, false, cVar.h, false, com.getpebble.android.common.model.aw.c.a.EMPTY);
            long currentTimeMillis = System.currentTimeMillis();
            return new com.getpebble.android.common.model.aw.d(cVar2, currentTimeMillis, currentTimeMillis, com.getpebble.android.common.model.aw.e.CALENDAR, aw.b);
        }
    }

    public n() {
        super("calendar_events");
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "calendar_id"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "event_id"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, an.TITLE));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "description"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "eventLocation"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "allDay"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "begin"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "end"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "calendar_displayName"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "selfAttendeeStatus"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "ownerAccount"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "organizer_name"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "num_attending"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "is_recurring"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "is_organizer"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "pin_uuid"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "original_id"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "customAppUri"));
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(x.a("calendar_events", new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "calendar_displayName")));
        sQLiteDatabase.execSQL(x.a("calendar_events", new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "selfAttendeeStatus")));
        sQLiteDatabase.execSQL(x.a("calendar_events", new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "organizer_name")));
        sQLiteDatabase.execSQL(x.a("calendar_events", new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "num_attending")));
        sQLiteDatabase.execSQL(x.a("calendar_events", new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "is_recurring")));
        sQLiteDatabase.execSQL(x.a("calendar_events", new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "is_organizer")));
    }

    public static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(x.a("calendar_events", new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "original_id")));
    }

    private static String b(e eVar) {
        String b = (eVar.q || eVar.n == null) ? com.getpebble.android.framework.a.e.b(eVar.c) : eVar.n;
        int i = eVar.o - 1;
        Resources resources = com.getpebble.android.common.a.K().getResources();
        if (b == null) {
            return null;
        }
        if (i == 1) {
            return resources.getString(R.string.timeline_calendar_reminder_subtitle_one_guest, new Object[]{b});
        } else if (i == 2) {
            return resources.getString(R.string.timeline_calendar_reminder_subtitle_two_guests, new Object[]{b});
        } else if (i < 3) {
            return null;
        } else {
            return resources.getString(R.string.timeline_calendar_reminder_subtitle_three_or_more_guests, new Object[]{b, String.valueOf(i - 1)});
        }
    }

    public static void a(ContentResolver contentResolver, c cVar) {
        com.getpebble.android.common.b.a.f.d("CalendarEventModel", "Inserting calendar event record: " + cVar);
        contentResolver.insert(a, cVar.a());
    }

    public static int a(ContentResolver contentResolver, c cVar, long j, UUID uuid) {
        com.getpebble.android.common.b.a.f.d("CalendarEventModel", "Updating calendar event record: " + cVar);
        String str = "_id = ? AND pin_uuid = ?";
        return contentResolver.update(a, cVar.a(), "_id = ? AND pin_uuid = ?", new String[]{String.valueOf(j), uuid.toString()});
    }

    public static int b(ContentResolver contentResolver, c cVar) {
        com.getpebble.android.common.b.a.f.d("CalendarEventModel", "Deleting calendar event record: " + cVar);
        String str = "_id = ?";
        return contentResolver.delete(a, "_id = ?", new String[]{String.valueOf(cVar.b)});
    }

    public static void a(com.getpebble.android.framework.timeline.c cVar, com.getpebble.android.framework.timeline.f fVar, com.getpebble.android.common.model.aw.c cVar2, com.getpebble.android.framework.g.ag.a aVar) {
        UUID uuid = cVar2.c.equals(com.getpebble.android.common.model.aw.b.PIN) ? cVar2.a : cVar2.b;
        com.getpebble.android.framework.timeline.c.a internalActionType = cVar.getInternalActionType();
        boolean a = a(uuid, internalActionType);
        fVar.add(com.getpebble.android.framework.timeline.e.c.SUBTITLE_KEY, b(internalActionType));
        fVar.add(com.getpebble.android.framework.timeline.e.c.LARGE_ICON, com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_SENT);
        aVar.a(a, fVar, null);
    }

    public static boolean a(UUID uuid, com.getpebble.android.framework.timeline.c.a aVar) {
        if (v.a(com.getpebble.android.h.v.a.CALENDAR)) {
            String str = new String[]{"event_id", "ownerAccount", "begin", "is_recurring"};
            com.getpebble.android.framework.timeline.e.a aVar2 = "pin_uuid = ?";
            long j = new String[]{uuid.toString()};
            Cursor query = com.getpebble.android.common.a.K().getContentResolver().query(a, str, aVar2, j, null);
            if (query == null) {
                com.getpebble.android.common.b.a.f.a("CalendarEventModel", "Cursor for changing events was null!");
                return false;
            } else if (query.moveToFirst()) {
                try {
                    int i = query.getInt(query.getColumnIndex("event_id"));
                    str = query.getString(query.getColumnIndex("ownerAccount"));
                    j = query.getLong(query.getColumnIndex("begin"));
                    aVar2 = com.getpebble.android.framework.timeline.e.a.from(query.getInt(query.getColumnIndex("is_recurring")));
                    if (!aVar.equals(com.getpebble.android.framework.timeline.c.a.CALENDAR_CANCEL)) {
                        int a = a(aVar);
                        if (a == -1) {
                            return false;
                        }
                        return com.getpebble.android.framework.a.e.a((long) i, a, str);
                    } else if (aVar2.equals(com.getpebble.android.framework.timeline.e.a.RECURRING)) {
                        return com.getpebble.android.framework.a.e.a((long) i, j);
                    } else {
                        return com.getpebble.android.framework.a.e.a((long) i);
                    }
                } finally {
                    query.close();
                }
            } else {
                com.getpebble.android.common.b.a.f.a("CalendarEventModel", "Cursor for changing events was empty!");
                query.close();
                return false;
            }
        }
        v.a("CalendarEventModel", com.getpebble.android.h.v.a.CALENDAR, "changeEventStatus");
        return false;
    }

    private static int a(com.getpebble.android.framework.timeline.c.a aVar) {
        switch (aVar) {
            case CALENDAR_ACCEPT:
                return 1;
            case CALENDAR_MAYBE:
                return 4;
            case CALENDAR_DECLINE:
            case CALENDAR_CANCEL:
                return 2;
            default:
                com.getpebble.android.common.b.a.f.a("CalendarEventModel", "Received unknown internal action type: " + aVar.name());
                return -1;
        }
    }

    private static String b(com.getpebble.android.framework.timeline.c.a aVar) {
        Resources resources = com.getpebble.android.common.a.K().getResources();
        switch (aVar) {
            case CALENDAR_ACCEPT:
                return resources.getString(R.string.timeline_action_accepted);
            case CALENDAR_MAYBE:
                return resources.getString(R.string.timeline_action_maybe);
            case CALENDAR_DECLINE:
                return resources.getString(R.string.timeline_action_declined);
            case CALENDAR_CANCEL:
                return resources.getString(R.string.timeline_action_canceled);
            default:
                com.getpebble.android.common.b.a.f.a("CalendarEventModel", "Received unknown internal action type: " + aVar);
                return resources.getString(R.string.action_sent);
        }
    }
}
