package com.getpebble.android.common.model.timeline;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import java.lang.reflect.Type;
import java.util.Map.Entry;

public class c extends f {
    @com.google.b.a.c(a = "guid")
    public String a;
    @com.google.b.a.c(a = "persistQuickView")
    public boolean b;
    @com.google.b.a.c(a = "createTime")
    public String c;
    @com.google.b.a.c(a = "updateTime")
    public String d;
    @com.google.b.a.c(a = "dataSource")
    public String e;
    @com.google.b.a.c(a = "time")
    public String f;
    @com.google.b.a.c(a = "duration")
    public int g;
    @com.google.b.a.c(a = "floating")
    public boolean h;
    @com.google.b.a.c(a = "layout")
    public a i;
    @com.google.b.a.c(a = "actions")
    public a[] j;
    @com.google.b.a.c(a = "reminders")
    public c[] k;
    @com.google.b.a.c(a = "createNotification")
    public b l;
    @com.google.b.a.c(a = "updateNotification")
    public b m;

    public static class a implements k<a> {
        public String a;
        public o b = new o();

        public /* synthetic */ Object deserialize(l lVar, Type type, j jVar) {
            return a(lVar, type, jVar);
        }

        public a a(l lVar, Type type, j jVar) {
            o l = lVar.l();
            a aVar = new a();
            for (Entry entry : l.a()) {
                if (com.getpebble.android.common.b.b.a.a("type", entry.getKey())) {
                    aVar.a = l.b("type").c();
                } else {
                    aVar.b.a((String) entry.getKey(), (l) entry.getValue());
                }
            }
            return aVar;
        }
    }

    public static class b {
        @com.google.b.a.c(a = "layout")
        public a a;
        @com.google.b.a.c(a = "time")
        public String b;
    }

    public static class c {
        @com.google.b.a.c(a = "time")
        public String a;
        @com.google.b.a.c(a = "layout")
        public a b;
    }
}
