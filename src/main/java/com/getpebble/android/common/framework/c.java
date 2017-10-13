package com.getpebble.android.common.framework;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.common.model.as;
import com.getpebble.android.common.model.as.b;
import com.google.a.b.af;
import com.google.a.b.am;
import com.google.a.b.ay;
import com.google.a.b.bt;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class c extends ContentObserver {
    private static final String[] a = new String[]{ai.COLUMN_ID, "key", "name", "type", "value"};
    private final ContentResolver b;
    private final Map<OnSharedPreferenceChangeListener, b> c = new ConcurrentHashMap();
    private Map<String, ContentValues> d = new ConcurrentHashMap();
    private final Runnable e = new Runnable(this) {
        final /* synthetic */ c a;

        {
            this.a = r1;
        }

        public void run() {
            Cursor c = this.a.b();
            if (c == null) {
                f.a("PreferenceCache", "mLoadCursorRunnable onTaskFailed");
            } else {
                this.a.a(c);
            }
        }
    };

    private abstract class a {
        final /* synthetic */ c b;

        abstract void a(String str, String str2);

        private a(c cVar) {
            this.b = cVar;
        }
    }

    public c(ContentResolver contentResolver) {
        super(null);
        this.b = contentResolver;
        this.b.registerContentObserver(as.a, true, this);
    }

    public synchronized Map<String, ?> a(String str) {
        Map<String, ?> a;
        if (this.d.containsKey(str)) {
            a = a((ContentValues) this.d.get(str));
        } else {
            a = af.e();
        }
        return a;
    }

    public synchronized String a(String str, String str2, String str3) {
        if (this.d.containsKey(str)) {
            String asString = ((ContentValues) this.d.get(str)).getAsString(str2);
            if (asString != null) {
                str3 = asString;
            }
        }
        return str3;
    }

    public synchronized Set<String> a(String str, String str2, Set<String> set) {
        if (this.d.containsKey(str)) {
            String asString = ((ContentValues) this.d.get(str)).getAsString(str2);
            if (asString != null) {
                try {
                    set = bt.a((String[]) new com.google.b.f().a(asString, String[].class));
                } catch (Throwable e) {
                    f.d("PreferenceCache", "getStringSet()", e);
                }
            }
        }
        return set;
    }

    public synchronized int a(String str, String str2, int i) {
        if (this.d.containsKey(str)) {
            Integer asInteger = ((ContentValues) this.d.get(str)).getAsInteger(str2);
            if (asInteger != null) {
                i = asInteger.intValue();
            }
        }
        return i;
    }

    public synchronized long a(String str, String str2, long j) {
        if (this.d.containsKey(str)) {
            Long asLong = ((ContentValues) this.d.get(str)).getAsLong(str2);
            if (asLong != null) {
                j = asLong.longValue();
            }
        }
        return j;
    }

    public synchronized float a(String str, String str2, float f) {
        if (this.d.containsKey(str)) {
            Float asFloat = ((ContentValues) this.d.get(str)).getAsFloat(str2);
            if (asFloat != null) {
                f = asFloat.floatValue();
            }
        }
        return f;
    }

    public synchronized boolean a(String str, String str2, boolean z) {
        if (this.d.containsKey(str)) {
            Boolean asBoolean = ((ContentValues) this.d.get(str)).getAsBoolean(str2);
            if (asBoolean != null) {
                z = asBoolean.booleanValue();
            }
        }
        return z;
    }

    public synchronized boolean a(String str, String str2) {
        boolean z;
        z = this.d.containsKey(str) && ((ContentValues) this.d.get(str)).containsKey(str2);
        return z;
    }

    public synchronized void a(String str, ContentValues contentValues, Set<String> set, Boolean bool) {
        final ContentValues contentValues2;
        final Set<String> a;
        f.d("PreferenceCache", "commit(" + str + ")");
        contentValues2 = new ContentValues(contentValues);
        a = am.a((Collection) set);
        synchronized (this) {
            if (this.d.containsKey(str)) {
                if (bool.booleanValue()) {
                    for (String b : ((ContentValues) this.d.get(str)).keySet()) {
                        b(this.c, str, b);
                    }
                    this.d.remove(str);
                } else {
                    ContentValues contentValues3 = (ContentValues) this.d.get(str);
                    for (String str2 : a) {
                        contentValues3.remove(str2);
                        b(this.c, str, str2);
                    }
                }
            }
            if (contentValues2.size() > 0) {
                if (this.d.containsKey(str)) {
                    ((ContentValues) this.d.get(str)).putAll(contentValues2);
                } else {
                    this.d.put(str, new ContentValues(contentValues2));
                }
                for (String b2 : contentValues2.keySet()) {
                    b(this.c, str, b2);
                }
            }
        }
        final String str3 = str;
        final Boolean bool2 = bool;
        a.a(new Runnable(this) {
            final /* synthetic */ c e;

            public void run() {
                f.e("PreferenceCache", "commit(" + str3 + ")::run() (updating PreferenceModel in background)");
                if (bool2.booleanValue()) {
                    as.a(this.e.b, str3);
                    a.clear();
                }
                for (String b : a) {
                    as.b(this.e.b, str3, b);
                }
                for (Entry entry : contentValues2.valueSet()) {
                    b bVar;
                    String str;
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        bVar = b.STRING;
                        str = (String) value;
                    } else if (value instanceof Integer) {
                        bVar = b.INT;
                        str = String.valueOf(value);
                    } else if (value instanceof Long) {
                        bVar = b.LONG;
                        str = String.valueOf(value);
                    } else if (value instanceof Float) {
                        bVar = b.FLOAT;
                        str = String.valueOf(value);
                    } else if (value instanceof Boolean) {
                        bVar = b.BOOLEAN;
                        str = String.valueOf(value);
                    } else {
                        f.a("PreferenceCache", "Unsupported type, something went wrong; Key: " + ((String) entry.getKey()) + " has class: " + (value == null ? "null" : value.getClass()));
                    }
                    f.e("PreferenceCache", "Writing key = " + ((String) entry.getKey()) + " value = " + str);
                    as.a(this.e.b, str3, new com.getpebble.android.common.model.as.a((String) entry.getKey(), bVar, str));
                }
            }
        });
    }

    public void a(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener, b bVar) {
        f.d("PreferenceCache", "addListener()");
        if (this.c.containsKey(onSharedPreferenceChangeListener)) {
            f.b("PreferenceCache", "Attempted to add duplicate listener");
        } else {
            this.c.put(onSharedPreferenceChangeListener, bVar);
        }
    }

    public void a(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        f.d("PreferenceCache", "removeListener()");
        this.c.remove(onSharedPreferenceChangeListener);
    }

    private static void b(Map<OnSharedPreferenceChangeListener, b> map, String str, String str2) {
        for (Entry entry : map.entrySet()) {
            if (((b) entry.getValue()).a().equals(str)) {
                a((OnSharedPreferenceChangeListener) entry.getKey(), (SharedPreferences) entry.getValue(), str2);
            }
        }
    }

    private static void a(final OnSharedPreferenceChangeListener onSharedPreferenceChangeListener, final SharedPreferences sharedPreferences, final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(sharedPreferences, str);
                } catch (Throwable e) {
                    f.a("PreferenceCache", "notifyOnMainThread", e);
                }
            }
        });
    }

    private static Map<String, ContentValues> b(Cursor cursor) {
        Map<String, ContentValues> concurrentHashMap = new ConcurrentHashMap();
        if (cursor == null) {
            f.a("PreferenceCache", "Error creating cache, cursor is null");
            return concurrentHashMap;
        }
        long j = 0;
        while (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("name"));
            if (string == null) {
                f.b("PreferenceCache", "Skipping current iteration, file was null.");
            } else {
                long length;
                try {
                    length = ((long) ((string.length() + cursor.getString(cursor.getColumnIndex("key")).length()) + cursor.getString(cursor.getColumnIndex("value")).length())) + j;
                } catch (Exception e) {
                    f.d("PreferenceCache", "Error getting pref cache cursor size");
                    length = j;
                }
                ContentValues a = as.a(cursor);
                if ((a.size() <= 0 ? 1 : null) != null) {
                    j = length;
                } else {
                    if (concurrentHashMap.containsKey(string)) {
                        ((ContentValues) concurrentHashMap.get(string)).putAll(a);
                    } else {
                        concurrentHashMap.put(string, a);
                    }
                    j = length;
                }
            }
        }
        f.d("PreferenceCache", "Size estimate from cursor: " + j);
        return concurrentHashMap;
    }

    private static void a(Map<String, ContentValues> map, Map<String, ContentValues> map2, a aVar) {
        for (Entry entry : ay.a((Map) map, (Map) map2).d().entrySet()) {
            ContentValues contentValues = (ContentValues) ((com.google.a.b.ax.a) entry.getValue()).a();
            ContentValues contentValues2 = (ContentValues) ((com.google.a.b.ax.a) entry.getValue()).b();
            if (contentValues == null) {
                for (String a : contentValues2.keySet()) {
                    aVar.a((String) entry.getKey(), a);
                }
            } else if (contentValues2 == null) {
                for (String a2 : contentValues.keySet()) {
                    aVar.a((String) entry.getKey(), a2);
                }
            } else {
                for (Entry key : ay.a(a(contentValues), a(contentValues2)).d().entrySet()) {
                    aVar.a((String) entry.getKey(), (String) key.getKey());
                }
            }
        }
    }

    public void a(Cursor cursor) {
        try {
            Map b = b(cursor);
            synchronized (this) {
                Map map = this.d;
                this.d = b;
                if (!this.c.isEmpty()) {
                    a(map, b, new a(this) {
                        final /* synthetic */ c a;

                        {
                            this.a = r2;
                        }

                        void a(String str, String str2) {
                            c.b(this.a.c, str, str2);
                        }
                    });
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void onChange(boolean z) {
        onChange(z, null);
    }

    public void onChange(boolean z, Uri uri) {
        a.a(this.e);
    }

    private Cursor b() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            Cursor query = this.b.query(as.a, a, null, null, "_id ASC");
            if (query == null) {
                f.a("PreferenceCache", "Got null cursor from query!");
                return null;
            }
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return query;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public void a() {
        f.d("PreferenceCache", "init()");
        a(b());
    }

    private static Map<String, Object> a(ContentValues contentValues) {
        Set<Entry> valueSet = contentValues.valueSet();
        Map<String, Object> hashMap = new HashMap(valueSet.size());
        for (Entry entry : valueSet) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return hashMap;
    }
}
