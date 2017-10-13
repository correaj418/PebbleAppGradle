package com.getpebble.android.config;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.b.b.x;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.b.b.c;
import com.google.b.o;

public class b {

    private static class a extends f {
        private Context a;
        private Runnable b;

        private a(Context context, Runnable runnable) {
            this.a = context;
            this.b = runnable;
        }

        public boolean doInBackground() {
            return b.a(this.a);
        }

        public void onTaskSuccess() {
            if (this.b != null) {
                this.b.run();
            }
        }

        public void onTaskFailed() {
        }
    }

    public static synchronized boolean a(Context context) {
        boolean z;
        synchronized (b.class) {
            String a;
            int b;
            com.getpebble.android.common.b.a.f.d("SyncBootConfig", "syncBootConfig()");
            String u = PebbleApplication.w().u();
            if ("offline_boot_config.json".equals(u)) {
                com.getpebble.android.common.b.a.f.d("SyncBootConfig", "Loading boot config from asset");
                try {
                    a = com.getpebble.android.common.framework.b.f.a(context, u, false);
                } catch (Throwable e) {
                    com.getpebble.android.common.b.a.f.a("SyncBootConfig", "Error loading boot config from asset!", e);
                    z = false;
                } catch (Throwable th) {
                    r0.close();
                }
            } else {
                try {
                    x a2 = com.getpebble.android.d.a.a(context, 30000, u);
                    com.getpebble.android.common.b.a.f.d("SyncBootConfig", "bootconfig response");
                    b = a2.d().b();
                    if (b != 200) {
                        com.getpebble.android.common.b.a.f.a("SyncBootConfig", "Error fetching bootconfig data, response code: " + b);
                        z = false;
                    } else {
                        o oVar = (o) a2.b();
                        if (oVar == null) {
                            com.getpebble.android.common.b.a.f.a("SyncBootConfig", "Failed to sync boot config: response.getResult() is null");
                            z = false;
                        } else {
                            a = oVar.toString();
                        }
                    }
                } catch (Throwable e2) {
                    com.getpebble.android.common.b.a.f.a("SyncBootConfig", "syncBootConfig: error fetching boot config - " + e2.getMessage(), e2);
                    z = false;
                }
            }
            Cursor query = context.getContentResolver().query(com.getpebble.android.common.b.b.b.a("boot_config"), null, null, null, null);
            if (query != null) {
                b = query.getCount();
                query.close();
                ContentValues contentValues = new ContentValues();
                contentValues.put("config_json", a);
                com.getpebble.android.common.b.a.f.d("SyncBootConfig", "bootconfig cursor getcount = " + b);
                if (b == 0) {
                    context.getContentResolver().insert(com.getpebble.android.common.b.b.b.a("boot_config"), contentValues);
                } else {
                    context.getContentResolver().update(com.getpebble.android.common.b.b.b.a("boot_config"), contentValues, null, null);
                }
                com.getpebble.android.common.b.a.f.d("SyncBootConfig", "Done bootconfig sync");
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public static void a(Context context, Runnable runnable, boolean z) {
        a(context, runnable, z, false);
    }

    public static void a(Context context, Runnable runnable, boolean z, boolean z2) {
        c cVar = new c(context);
        Object obj = System.currentTimeMillis() - cVar.a(com.getpebble.android.common.b.b.c.a.LAST_BOOTCONFIG_SYNC_MILLIS, -1) >= 43200000 ? 1 : null;
        if (z || obj != null) {
            cVar.b(com.getpebble.android.common.b.b.c.a.LAST_BOOTCONFIG_SYNC_MILLIS, System.currentTimeMillis());
            if (z2) {
                a(context);
                return;
            } else {
                new a(context, runnable).submit();
                return;
            }
        }
        com.getpebble.android.common.b.a.f.d("SyncBootConfig", "Not syncing BootConfig - too soon since last sync");
    }
}
