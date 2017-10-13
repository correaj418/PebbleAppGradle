package com.getpebble.android.common.framework;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.google.b.f;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class b implements SharedPreferences {
    private static c c;
    private final String a;
    private final Editor b = new a(this);

    class a implements Editor {
        final /* synthetic */ b a;
        private boolean b = false;
        private final ContentValues c = new ContentValues();
        private final Set<String> d = new HashSet();

        a(b bVar) {
            this.a = bVar;
        }

        public Editor putString(String str, String str2) {
            synchronized (this) {
                this.c.put(str, str2);
            }
            return this;
        }

        public Editor putStringSet(String str, Set<String> set) {
            synchronized (this) {
                this.c.put(str, new f().b((Object) set));
            }
            return this;
        }

        public Editor putInt(String str, int i) {
            synchronized (this) {
                this.c.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public Editor putLong(String str, long j) {
            synchronized (this) {
                this.c.put(str, Long.valueOf(j));
            }
            return this;
        }

        public Editor putFloat(String str, float f) {
            synchronized (this) {
                this.c.put(str, Float.valueOf(f));
            }
            return this;
        }

        public Editor putBoolean(String str, boolean z) {
            synchronized (this) {
                this.c.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        public Editor remove(String str) {
            synchronized (this) {
                if (this.c.containsKey(str)) {
                    this.c.remove(str);
                }
                this.d.add(str);
            }
            return this;
        }

        public Editor clear() {
            synchronized (this) {
                this.c.clear();
                this.d.clear();
                this.b = true;
            }
            return this;
        }

        public boolean commit() {
            apply();
            return true;
        }

        public void apply() {
            synchronized (this) {
                com.getpebble.android.common.b.a.f.e("MultiProcPreferences", "Applying pref edits commit(" + this.a.a + ")");
                b.c.a(this.a.a, this.c, this.d, Boolean.valueOf(this.b));
                this.c.clear();
                this.d.clear();
                this.b = false;
            }
        }
    }

    public b(Context context, String str) {
        c = b(context);
        this.a = str;
    }

    public Map<String, ?> getAll() {
        return c.a(this.a);
    }

    public String getString(String str, String str2) {
        return c.a(this.a, str, str2);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return c.a(this.a, str, (Set) set);
    }

    public int getInt(String str, int i) {
        return c.a(this.a, str, i);
    }

    public long getLong(String str, long j) {
        return c.a(this.a, str, j);
    }

    public float getFloat(String str, float f) {
        return c.a(this.a, str, f);
    }

    public boolean getBoolean(String str, boolean z) {
        return c.a(this.a, str, z);
    }

    public boolean contains(String str) {
        return c.a(this.a, str);
    }

    public Editor edit() {
        return this.b;
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        c.a(onSharedPreferenceChangeListener, this);
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        c.a(onSharedPreferenceChangeListener);
    }

    private static synchronized c b(Context context) {
        c cVar;
        synchronized (b.class) {
            if (c == null) {
                c = new c(context.getContentResolver());
                long currentTimeMillis = System.currentTimeMillis();
                com.getpebble.android.common.b.a.f.d("MultiProcPreferences", "Initializing preference cache");
                c.a();
                com.getpebble.android.common.b.a.f.d("MultiProcPreferences", String.format("Done initializing prefs; took <%d> ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
            }
            cVar = c;
        }
        return cVar;
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            b(context);
        }
    }

    String a() {
        return this.a;
    }
}
