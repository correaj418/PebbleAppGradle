package com.getpebble.android.framework.a;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Instances;
import com.getpebble.android.b.b.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.au;
import com.getpebble.android.common.model.o;
import com.getpebble.android.h.v;

public class c {
    final a a;
    private final ContentObserver b;
    private final ContentResolver c;
    private final b d;
    private boolean e = false;
    private boolean f = false;

    public c(ContentResolver contentResolver, a aVar) {
        this.c = contentResolver;
        this.a = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.d = new a(contentResolver);
        this.b = new ContentObserver(this, handler) {
            final /* synthetic */ c a;

            public boolean deliverSelfNotifications() {
                return super.deliverSelfNotifications();
            }

            public void onChange(boolean z) {
                onChange(z, null);
            }

            public void onChange(boolean z, Uri uri) {
                f.d("CalendarSync", "onChange() uri = " + uri);
                this.a.a();
                this.a.a.b(false);
                f.d("CalendarSync", "onChange() finished");
            }
        };
        this.c.registerContentObserver(Instances.CONTENT_URI, false, this.b);
        this.c.registerContentObserver(o.a, false, this.b);
        this.c.registerContentObserver(Calendars.CONTENT_URI, false, this.b);
        a();
    }

    private synchronized void a() {
        if (this.e) {
            this.f = true;
        } else {
            b();
        }
    }

    private synchronized void b() {
        this.e = true;
        this.f = false;
        new com.getpebble.android.bluetooth.b.f(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public boolean doInBackground() {
                if (v.a(v.a.CALENDAR)) {
                    this.a.d();
                    this.a.e();
                    this.a.c();
                    return true;
                }
                v.a("CalendarSync", v.a.CALENDAR, "startSync");
                this.a.c();
                return false;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    private synchronized void c() {
        this.e = false;
        if (this.f) {
            b();
        }
    }

    private void d() {
        f.d("CalendarSync", "processEvents()");
        long currentTimeMillis = System.currentTimeMillis();
        this.d.a(e.a(this.c), e.b(this.c));
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        au.a(au.a.CALENDAR_SYNC, this.c, currentTimeMillis);
        f.d("CalendarSync", "processEvents completed: " + currentTimeMillis + " ms");
    }

    private void e() {
        f.d("CalendarSync", "processCalendars()");
        long currentTimeMillis = System.currentTimeMillis();
        com.getpebble.android.h.f.a(this.c);
        this.d.b(o.a(this.c), o.b(this.c));
        com.getpebble.android.h.f.a(this.c);
        f.d("CalendarSync", "processCalendars completed: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
