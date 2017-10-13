package com.getpebble.android.framework.a;

import android.content.ContentResolver;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.a;
import com.getpebble.android.common.model.aw.b;
import com.getpebble.android.common.model.aw.d;
import com.getpebble.android.common.model.aw.e;
import com.getpebble.android.common.model.o;
import com.getpebble.android.framework.timeline.e.c;
import java.util.UUID;

public class f implements com.getpebble.android.common.model.aw.f {
    private final ContentResolver a;

    public f(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    public boolean c(d dVar) {
        if (e(dVar)) {
            return f(dVar);
        }
        return false;
    }

    public boolean d(d dVar) {
        if (e(dVar)) {
            return g(dVar);
        }
        return false;
    }

    public boolean a(d dVar, boolean z) {
        if (!e(dVar)) {
            return false;
        }
        if (z) {
            return h(dVar);
        }
        return i(dVar);
    }

    public boolean a(d dVar) {
        return c(dVar);
    }

    public boolean b(d dVar) {
        com.getpebble.android.common.b.a.f.f("TimelineCalendarSync", "Handling watch record updates is not yet supported.");
        return false;
    }

    boolean e(d dVar) {
        return dVar.b.c == b.PIN && dVar.h == e.REMINDERS;
    }

    private boolean f(d dVar) {
        long a = o.a();
        if (a == -1) {
            com.getpebble.android.common.b.a.f.c("TimelineCalendarSync", "No default calendar set for Reminders.");
            return false;
        }
        UUID uuid = dVar.b.a;
        com.getpebble.android.framework.timeline.e a2 = dVar.b.a(c.TITLE_KEY);
        if (a2 == null) {
            com.getpebble.android.common.b.a.f.a("TimelineCalendarSync", "No title found for new Reminder (Pin UUID " + uuid + ").");
            return false;
        }
        try {
            if (e.a(this.a, a, uuid, a2.getValue().c(), dVar.b.e) > 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.b("TimelineCalendarSync", "Unable to insert new Reminder into system calendar", e);
            return false;
        }
    }

    private boolean g(d dVar) {
        try {
            return e.a(this.a, dVar.b.a, dVar.b.e);
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.b("TimelineCalendarSync", "Unable to update Reminder in system calendar", e);
            return false;
        }
    }

    private boolean h(d dVar) {
        boolean z = false;
        UUID uuid = dVar.b.a;
        if (dVar.b.a(c.TITLE_KEY) == null) {
            throw new IllegalStateException("No title attribute found for record with UUID " + uuid);
        }
        try {
            z = e.a(this.a, uuid, String.format("%s %s", new Object[]{a.K().getString(R.string.complete_reminder_title_prefix), dVar.b.a(c.TITLE_KEY).getValue()}));
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.b("TimelineCalendarSync", "Unable to update Reminder in system calendar", e);
        }
        return z;
    }

    private boolean i(d dVar) {
        try {
            return e.a(this.a, dVar.b.a);
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.b("TimelineCalendarSync", "Unable to update Reminder in system calendar", e);
            return false;
        }
    }
}
