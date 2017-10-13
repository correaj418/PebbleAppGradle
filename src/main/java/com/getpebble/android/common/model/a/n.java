package com.getpebble.android.common.model.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.d;

public class n {
    private final SharedPreferences a;
    private final Context b;

    public enum a {
        HW_API_LAST_SYNCED_MLS_ROW("hw_api_last_synced_mls_row_id");
        
        private final String preferenceKey;

        private a(String str) {
            this.preferenceKey = str;
        }
    }

    public n(Context context) {
        if (!com.getpebble.android.common.b.b.d.a.FRAMEWORK.equals(d.a(context))) {
            f.f("HealthDatabasePreferences", "init in non-Framework process");
        }
        this.b = context;
        this.a = context.getSharedPreferences("com.getpebble.android.healthdb.prefs", 0);
    }

    public void a(long j) {
        if (!com.getpebble.android.common.b.b.d.a.FRAMEWORK.equals(d.a(this.b))) {
            f.f("HealthDatabasePreferences", "setHWAPILastSyncedMLSRow in non-Framework process");
        }
        this.a.edit().putLong(a.HW_API_LAST_SYNCED_MLS_ROW.preferenceKey, j).apply();
    }

    public long a() {
        if (!com.getpebble.android.common.b.b.d.a.FRAMEWORK.equals(d.a(this.b))) {
            f.f("HealthDatabasePreferences", "getHWPILastSyncedMLSRow in non-Framework process");
        }
        return this.a.getLong(a.HW_API_LAST_SYNCED_MLS_ROW.preferenceKey, 0);
    }
}
