package com.getpebble.android.framework.a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.CalendarContract.Attendees;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Instances;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.text.TextUtils;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.common.model.an;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.common.model.n;
import com.getpebble.android.common.model.n.b;
import com.getpebble.android.common.model.n.c;
import com.getpebble.android.common.model.n.d;
import com.getpebble.android.common.model.o;
import com.getpebble.android.h.v;
import com.getpebble.android.h.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class e {
    public static final String[] a = new String[]{"calendar_id", ai.COLUMN_ID, an.TITLE, "description", "eventLocation", "allDay", "begin", "end", "event_id", "selfAttendeeStatus", "calendar_displayName", "original_id", "original_sync_id", "rrule", "rdate", "organizer", "ownerAccount", "calendar_access_level", "customAppUri"};
    public static final String[] b = new String[]{"calendar_id", ai.COLUMN_ID, an.TITLE, "description", "eventLocation", "allDay", "begin", "end", "event_id", "selfAttendeeStatus", "calendar_displayName", "ownerAccount", "original_id", "pin_uuid", "organizer_name", "num_attending", "is_recurring", "is_organizer", "customAppUri"};

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static Map<Long, b> a(ContentResolver contentResolver) {
        try {
            a("getSelectedSystemCalendarEvents");
            Map<Long, b> hashMap = new HashMap();
            Cursor c = c(contentResolver);
            if (c == null) {
                f.b("SystemCalendarAdapter", "getSystemCalendarEvents: cursor is null");
                return hashMap;
            }
            while (c.moveToNext()) {
                try {
                    b a = a(contentResolver, c);
                    hashMap.put(Long.valueOf(a.a.b), a);
                } finally {
                    c.close();
                }
            }
            return hashMap;
        } catch (a e) {
            return new HashMap();
        }
    }

    private static b a(ContentResolver contentResolver, Cursor cursor) {
        String[] strArr = new String[]{ai.COLUMN_ID};
        int i = new String[]{Long.toString(cursor.getLong(cursor.getColumnIndex("event_id"))), Long.toString(3), "%@resource.calendar.google.com"};
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(Attendees.CONTENT_URI, strArr, "event_id=? AND attendeeType!=? AND attendeeEmail NOT LIKE ?", i, null);
        if (query != null) {
            try {
                i = query.getCount();
            } finally {
                query.close();
            }
        } else {
            i = 0;
        }
        boolean b = b(cursor);
        com.getpebble.android.common.model.n.e eVar = new com.getpebble.android.common.model.n.e(cursor, a(contentResolver, r8), a(cursor), i, com.getpebble.android.framework.timeline.e.a.from(b));
        return new b(eVar, d.a(contentResolver, eVar));
    }

    public static boolean a(long j) {
        ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eventStatus", Integer.valueOf(2));
        if (contentResolver.update(ContentUris.withAppendedId(Events.CONTENT_URI, j), contentValues, null, null) != 0) {
            return true;
        }
        f.a("SystemCalendarAdapter", "Couldn't cancel even with id: " + j);
        return false;
    }

    public static boolean a(long j, long j2) {
        Uri withAppendedId = ContentUris.withAppendedId(Events.CONTENT_EXCEPTION_URI, j);
        ContentValues contentValues = new ContentValues();
        contentValues.put("originalInstanceTime", Long.valueOf(j2));
        contentValues.put("eventStatus", Integer.valueOf(2));
        return com.getpebble.android.common.a.K().getContentResolver().insert(withAppendedId, contentValues) != null;
    }

    public static boolean a(long j, int i, String str) {
        ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("attendeeStatus", Integer.valueOf(i));
        String[] strArr = new String[]{String.valueOf(j), str};
        if (contentResolver.update(Attendees.CONTENT_URI, contentValues, "event_id = ? AND attendeeEmail = ?", strArr) != 0) {
            return true;
        }
        f.a("SystemCalendarAdapter", "Couldn't update event with id: " + j + " to have new attendeeStatus " + i);
        return false;
    }

    public static long a(ContentResolver contentResolver, long j, UUID uuid, String str, long j2) {
        a("insertPebbleReminder");
        d dVar = new d(uuid, aw.f);
        ContentValues contentValues = new ContentValues();
        contentValues.put(an.TITLE, str);
        contentValues.put("calendar_id", Long.valueOf(j));
        contentValues.put("dtstart", Long.valueOf(j2));
        contentValues.put("dtend", Long.valueOf(new c.b.a.b(j2).b(30).c()));
        contentValues.put("eventTimezone", c.b.a.f.a().e());
        contentValues.put("customAppUri", dVar.a().toString());
        Uri insert = contentResolver.insert(Events.CONTENT_URI, contentValues);
        if (insert != null) {
            return Long.parseLong(insert.getLastPathSegment());
        }
        throw new a("Failed to insert into Android System Calendar.");
    }

    public static boolean a(ContentResolver contentResolver, UUID uuid) {
        boolean z = true;
        String str = "removePebbleReminder";
        a("removePebbleReminder");
        b a = a(contentResolver, aw.f, uuid);
        if (a == null) {
            f.a("SystemCalendarAdapter", "No Reminder calendar event found for pin " + uuid);
            return false;
        }
        int delete = contentResolver.delete(ContentUris.withAppendedId(Events.CONTENT_URI, a.a.c), null, null);
        if (delete != 1) {
            f.b("SystemCalendarAdapter", "removePebbleReminder: Expected one row to be deleted, but instead we deleted " + delete);
        }
        if (delete <= 0) {
            z = false;
        }
        return z;
    }

    public static boolean a(ContentResolver contentResolver, UUID uuid, String str) {
        String str2 = "updatePebbleReminderTitle";
        a("updatePebbleReminderTitle");
        ContentValues contentValues = new ContentValues();
        contentValues.put(an.TITLE, str);
        return a(uuid, contentValues, contentResolver, "updatePebbleReminderTitle");
    }

    public static boolean a(ContentResolver contentResolver, UUID uuid, long j) {
        String str = "updatePebbleReminderTime";
        a("updatePebbleReminderTime");
        ContentValues contentValues = new ContentValues();
        contentValues.put("dtstart", Long.valueOf(j));
        contentValues.put("dtend", Long.valueOf(new c.b.a.b(j).b(30).c()));
        return a(uuid, contentValues, contentResolver, "updatePebbleReminderTime");
    }

    static boolean a(UUID uuid, ContentValues contentValues, ContentResolver contentResolver, String str) {
        boolean z = true;
        b a = a(contentResolver, aw.f, uuid);
        if (a == null) {
            f.a("SystemCalendarAdapter", "No Reminder calendar event found for pin " + uuid);
            return false;
        }
        int update = contentResolver.update(ContentUris.withAppendedId(Events.CONTENT_URI, a.a.c), contentValues, null, null);
        if (update != 1) {
            f.b("SystemCalendarAdapter", str + ": Expected one row to be updated, but instead we updated " + update);
        }
        if (update <= 0) {
            z = false;
        }
        return z;
    }

    static void a(String str) {
        if (!v.a(com.getpebble.android.h.v.a.CALENDAR)) {
            v.a("SystemCalendarAdapter", com.getpebble.android.h.v.a.CALENDAR, str);
            throw new a("Permissions check failed.");
        }
    }

    public static String b(long j) {
        String[] strArr = new String[]{"attendeeName", "attendeeEmail"};
        String[] strArr2 = new String[]{String.valueOf(j), String.valueOf(2), String.valueOf(2)};
        Cursor query = com.getpebble.android.common.a.K().getContentResolver().query(Attendees.CONTENT_URI, strArr, "event_id = ? AND IFNULL(attendeeStatus, 0) != ? AND attendeeRelationship != ?", strArr2, null);
        if (query == null) {
            f.a("SystemCalendarAdapter", "Cursor was null when trying to get random guest name for event with id: " + j);
            return null;
        }
        try {
            if (!query.moveToFirst()) {
                return null;
            }
            CharSequence string = query.getString(query.getColumnIndex("attendeeName"));
            String string2 = query.getString(query.getColumnIndex("attendeeEmail"));
            query.close();
            if (TextUtils.isEmpty(string)) {
                string = b(string2);
            }
            return string;
        } finally {
            query.close();
        }
    }

    private static Cursor c(ContentResolver contentResolver) {
        Map c = o.c(contentResolver);
        if (c.isEmpty()) {
            return null;
        }
        List a = com.google.a.b.aw.a(new ArrayList(c.keySet()), 900);
        Cursor[] cursorArr = new Cursor[a.size()];
        for (int i = 0; i < a.size(); i++) {
            cursorArr[0] = a(contentResolver, (List) a.get(i));
        }
        return new MergeCursor(cursorArr);
    }

    private static Cursor a(ContentResolver contentResolver, List<Long> list) {
        String str = "calendar_id" + x.a(list.size()) + " AND IFNULL(" + "eventStatus" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + 0 + ") != " + 2 + " AND IFNULL(" + "selfAttendeeStatus" + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + 0 + ") != " + 2;
        String[] a = x.a((Collection) list);
        return contentResolver.query(a(), a, str, a, null);
    }

    private static Uri a() {
        long currentTimeMillis = System.currentTimeMillis();
        long windowStartUtcMs = aw.b.PIN.getWindowStartUtcMs(currentTimeMillis);
        currentTimeMillis = aw.b.PIN.getWindowEndUtcMs(currentTimeMillis) + TimeUnit.DAYS.toMillis(2);
        Builder buildUpon = Instances.CONTENT_URI.buildUpon();
        ContentUris.appendId(buildUpon, windowStartUtcMs);
        ContentUris.appendId(buildUpon, currentTimeMillis);
        return buildUpon.build();
    }

    private static String a(ContentResolver contentResolver, long j) {
        String[] strArr = new String[]{"attendeeName", "attendeeEmail"};
        String[] strArr2 = new String[]{String.valueOf(j), String.valueOf(2)};
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(Attendees.CONTENT_URI, strArr, "event_id = ? AND attendeeRelationship = ?", strArr2, null);
        if (query == null) {
            f.f("SystemCalendarAdapter", "getOrganizerName cursor is NULL for event with id: " + j);
            return null;
        }
        try {
            if (!query.moveToFirst()) {
                return null;
            }
            String string = query.getString(query.getColumnIndex("attendeeName"));
            String string2 = query.getString(query.getColumnIndex("attendeeEmail"));
            query.close();
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            if (!TextUtils.isEmpty(string2)) {
                return b(string2);
            }
            f.f("SystemCalendarAdapter", "Failed to get organiser name for " + j + " organizerName = " + string + " email = " + string2);
            return null;
        } finally {
            query.close();
        }
    }

    public static String b(String str) {
        if (!v.a(com.getpebble.android.h.v.a.CONTACTS)) {
            v.a("SystemCalendarAdapter", com.getpebble.android.h.v.a.CONTACTS, "getContactNameForEmail");
            return str;
        } else if (str == null) {
            return null;
        } else {
            Cursor query = com.getpebble.android.common.a.K().getContentResolver().query(Email.CONTENT_URI, new String[]{"data4"}, "data1 = ?", new String[]{str}, null);
            if (query == null) {
                f.a("SystemCalendarAdapter", "Cursor was null when trying to grab ");
                return null;
            }
            try {
                if (!query.moveToFirst()) {
                    return str;
                }
                CharSequence string = query.getString(query.getColumnIndex("data4"));
                query.close();
                return !TextUtils.isEmpty(string) ? string : str;
            } finally {
                query.close();
            }
        }
    }

    public static Map<Long, b> b(ContentResolver contentResolver) {
        Cursor query = contentResolver.query(n.a, b, null, null, null);
        Map<Long, b> hashMap = new HashMap();
        if (query == null) {
            f.b("SystemCalendarAdapter", "getLocalCalendarEvents: cursor is null");
        } else {
            while (query.moveToNext()) {
                try {
                    com.getpebble.android.common.model.n.e cVar = new c(query);
                    hashMap.put(Long.valueOf(cVar.b), new b(cVar, n.f.a(contentResolver, cVar.a)));
                } finally {
                    query.close();
                }
            }
        }
        return hashMap;
    }

    public static b a(ContentResolver contentResolver, UUID uuid, UUID uuid2) {
        b bVar = null;
        String[] strArr = new String[]{new d(uuid2, uuid).a().toString()};
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(n.a, b, "customAppUri = ?", strArr, null);
        if (query == null) {
            f.a("SystemCalendarAdapter", "getLocalCalendarEvent: cursor is null");
        } else {
            try {
                if (query.moveToFirst()) {
                    bVar = new b(new c(query), Collections.emptySet());
                    query.close();
                } else {
                    f.a("SystemCalendarAdapter", "getLocalCalendarEvent: cursor is empty");
                }
            } finally {
                query.close();
            }
        }
        return bVar;
    }

    private static boolean a(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("organizer"));
        String string2 = cursor.getString(cursor.getColumnIndex("ownerAccount"));
        if (string == null || string2 == null) {
            return false;
        }
        return string.equals(string2);
    }

    private static boolean b(Cursor cursor) {
        return (TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("rrule"))) && TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("rdate"))) && TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("original_id"))) && TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("original_sync_id")))) ? false : true;
    }
}
