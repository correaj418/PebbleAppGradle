package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.h.x;
import com.google.b.o;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class q extends ai {
    public static final Uri a = com.getpebble.android.common.b.b.b.a("cohorts_config");
    private static final com.getpebble.android.h.i.a<Map<String, String>> b = new com.getpebble.android.h.i.a<Map<String, String>>() {
        public void a(Map<String, String> map, Cursor cursor) {
            map.put(cursor.getString(cursor.getColumnIndex("selection")), cursor.getString(cursor.getColumnIndex("value")));
        }
    };

    public enum a {
        FIRMWARE("fw", true),
        LANGUAGE_PACK("lp", true),
        HEALTH_INSIGHTS("health-insights", true),
        LINKED_SERVICES("linked-services", false),
        PIPELINE("pipeline-api", false);
        
        private final boolean isLegacy;
        public final String key;

        private a(String str, boolean z) {
            this.key = str;
            this.isLegacy = z;
        }

        public ContentValues toContentValues(String str) {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("selection", this.key);
            contentValues.put("value", str);
            return contentValues;
        }

        public String toString() {
            return this.key;
        }

        public static List<a> selections() {
            List<a> linkedList = new LinkedList();
            for (a aVar : values()) {
                if (!aVar.isLegacy) {
                    linkedList.add(aVar);
                }
            }
            return linkedList;
        }
    }

    public static class b extends LinkedHashMap<String, o> {
    }

    public q() {
        super("cohorts_config", false, false);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "selection").a(true));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "value"));
    }

    public static void a(ContentResolver contentResolver, b bVar) {
        for (a aVar : a.selections()) {
            if (bVar.containsKey(aVar.key)) {
                ContentValues toContentValues = aVar.toContentValues(((o) bVar.get(aVar.key)).toString());
                Uri a = x.a(a, 5);
                f.e("CohortsConfigModel", "Updating: " + aVar.key);
                contentResolver.insert(a, toContentValues);
            } else {
                f.b("CohortsConfigModel", "Response does not contain selection: " + aVar.key);
            }
        }
    }
}
