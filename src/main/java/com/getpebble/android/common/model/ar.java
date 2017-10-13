package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.h.i;
import com.getpebble.android.h.x;
import com.getpebble.pipeline.Payload;
import com.google.a.b.aw;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ar extends ai {
    public static final Uri a = com.getpebble.android.common.b.b.b.a("pipeline");
    private static final com.getpebble.android.h.i.a<Collection<c>> b = new com.getpebble.android.h.i.a<Collection<c>>() {
        public void a(Collection<c> collection, Cursor cursor) {
            collection.add(c.a(cursor));
        }
    };
    private static final com.getpebble.android.h.i.a<Set<UUID>> c = new com.getpebble.android.h.i.a<Set<UUID>>() {
        public void a(Set<UUID> set, Cursor cursor) {
            set.add(UUID.fromString(cursor.getString(cursor.getColumnIndex("uuid"))));
        }
    };

    public static class a extends com.getpebble.android.framework.install.b {
        public a(Context context) {
            super("PipelineFileManager", context, "pipeline");
        }

        public File a(String str) {
            return new File(b(String.valueOf(str.charAt(0))), str);
        }

        String[] a() {
            return b().list();
        }

        File b(String str) {
            File file = new File(b(), str);
            if (!file.exists()) {
                file.mkdir();
            }
            return file;
        }

        List<List<String>> a(String str, int i) {
            String[] list = b(str).list();
            Object obj = (list == null || list.length == 0) ? 1 : null;
            if (obj != null) {
                return null;
            }
            return aw.a(Arrays.asList(list), i);
        }
    }

    private static abstract class b extends com.getpebble.android.h.x.a<UUID> {
        protected b(ContentResolver contentResolver) {
            super(contentResolver);
        }

        protected String a(Collection<UUID> collection) {
            return "uuid" + x.a(collection.size());
        }
    }

    public static class c {
        public final UUID a;
        public final int b;
        public final long c;

        public c(UUID uuid, int i, long j) {
            this.a = uuid;
            this.b = i;
            this.c = j;
        }

        public static c a(Cursor cursor) {
            return new c(UUID.fromString(cursor.getString(cursor.getColumnIndex("uuid"))), cursor.getInt(cursor.getColumnIndex("num_failed_upload_attempts")), cursor.getLong(cursor.getColumnIndex("unix_time")));
        }

        public String toString() {
            return "Record{uuid=" + this.a + ", numFailedUploadAttempts=" + this.b + ", unixTimeSeconds=" + this.c + '}';
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.b != cVar.b || this.c != cVar.c) {
                return false;
            }
            if (this.a != null) {
                z = this.a.equals(cVar.a);
            } else if (cVar.a != null) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return ((((this.a != null ? this.a.hashCode() : 0) * 31) + this.b) * 31) + ((int) (this.c ^ (this.c >>> 32)));
        }

        public static void a(Context context, List<c> list) {
            Collection a = a((List) list);
            a(context, a);
            new b(context.getContentResolver()) {
                protected void a(ContentResolver contentResolver, String[] strArr, String str) {
                    contentResolver.delete(ar.a, str, strArr);
                }
            }.a((List) a);
        }

        static void a(Context context, Collection<UUID> collection) {
            a aVar = new a(context);
            for (UUID uuid : collection) {
                aVar.d(uuid.toString());
            }
        }

        private static List<UUID> a(List<c> list) {
            List<UUID> linkedList = new LinkedList();
            for (c cVar : list) {
                linkedList.add(cVar.a);
            }
            return linkedList;
        }
    }

    public ar() {
        super("pipeline", false, false);
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "uuid").a(true).d());
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "num_failed_upload_attempts").a(String.valueOf(0)));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.INTEGER, "unix_time").d().a("CURRENT_TIMESTAMP"));
    }

    public static UUID a(Context context, Payload payload) {
        b.a aVar = new b.a();
        Payload.ADAPTER.encode((b.b) aVar, (Object) payload);
        return a(context, aVar);
    }

    public static UUID a(Context context, b.a aVar) {
        return a(context, aVar, new a(context));
    }

    static UUID a(Context context, b.a aVar, com.getpebble.android.framework.install.b bVar) {
        return UUID.randomUUID();
    }

    public static List<c> a(ContentResolver contentResolver, int i) {
        String str = "unix_time ASC LIMIT " + i;
        List linkedList = new LinkedList();
        i.a(contentResolver, linkedList, b, a, null, null, null, str);
        return linkedList;
    }

    public static int a(ContentResolver contentResolver, int i, long j) {
        int delete = contentResolver.delete(a, "num_failed_upload_attempts > " + i, null);
        int delete2 = contentResolver.delete(a, "unix_time < " + j, null);
        f.d("PipelineDataModel", "purgeStaleRecords: numMaxUploadRecordsDeleted: " + delete + " numStaleRecordsDeleted:" + delete2);
        return delete + delete2;
    }

    public static int a(Context context) {
        int i = 0;
        a aVar = new a(context);
        for (String a : aVar.a()) {
            List<Iterable> a2 = aVar.a(a, 20);
            if (a2 != null) {
                int i2 = i;
                for (Iterable a3 : a2) {
                    Collection a4 = a(context.getContentResolver(), a3);
                    c.a(context, a4);
                    i2 = a4.size() + i2;
                }
                i = i2;
            }
        }
        return i;
    }

    static Set<UUID> a(ContentResolver contentResolver, Iterable<String> iterable) {
        Set linkedHashSet = new LinkedHashSet();
        int i = (iterable == null || !iterable.iterator().hasNext()) ? 1 : 0;
        if (i == 0) {
            String str = x.a((Iterable) iterable, "uuid") + " EXCEPT SELECT uuid";
            i.a(contentResolver, linkedHashSet, c, a, new String[]{str}, null, null, null);
        }
        return linkedHashSet;
    }
}
