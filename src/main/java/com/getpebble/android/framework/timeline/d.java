package com.getpebble.android.framework.timeline;

import android.content.res.Resources;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.framework.timeline.e.c;
import com.getpebble.android.h.p;
import com.getpebble.android.notifications.a.a;
import com.getpebble.android.notifications.a.a.f;
import com.getpebble.android.notifications.a.a.g;
import com.getpebble.android.notifications.a.a.h;
import com.getpebble.android.notifications.a.b;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class d {
    private static final String TAG = "TimelineActions";
    private List<c> mTimelineActions = new LinkedList();

    public static d from(b bVar) {
        d dVar = new d();
        com.getpebble.android.notifications.a.a.d A = bVar.A();
        if (A != null) {
            dVar.addWithTitle(c.b.DISMISS, A.a(), A.b().toString());
        }
        for (h hVar : bVar.y()) {
            String charSequence = hVar.b().toString();
            List d = hVar.d();
            f add = new f().add(c.TITLE_KEY, charSequence);
            if (!d.isEmpty()) {
                add.add(c.CANNED_RESPONSE.getSerializedName(), d);
            }
            dVar.add(c.b.RESPONSE, hVar.a(), add);
        }
        for (a.b bVar2 : bVar.D()) {
            dVar.addWithTitle(c.b.GENERIC, bVar2.a(), bVar2.b().toString());
        }
        g z = bVar.z();
        if (z != null) {
            dVar.addWithTitle(c.b.OPEN_ON_PHONE, z.a(), z.b().toString());
        }
        f B = bVar.B();
        if (B != null) {
            dVar.addWithTitle(c.b.MUTE, B.a(), B.b().toString());
        }
        return dVar;
    }

    public static d getSystemPinActions() {
        return getPinActions(null, null);
    }

    public static d getPinActions(d dVar, UUID uuid) {
        int i;
        if (dVar == null) {
            dVar = new d();
            i = 0;
        } else {
            i = dVar.mTimelineActions.size();
        }
        if (aw.e.equals(uuid)) {
            return dVar;
        }
        return dVar.addWithTitle(c.b.REMOVE, i, (int) R.string.timeline_action_title_remove).addWithTitle(c.b.MUTE, i + 1, (int) R.string.timeline_action_title_mute);
    }

    public static d getWebNotificationActions(String str, UUID uuid) {
        d addWithTitle = new d().addWithTitle(c.b.DISMISS, 0, (int) R.string.timeline_action_title_dismiss).addWithTitle(c.b.OPEN_PIN, 1, (int) R.string.timeline_action_title_more);
        return aw.e.equals(uuid) ? addWithTitle : addWithTitle.addWithTitle(c.b.MUTE, 2, getResources().getString(R.string.timeline_action_title_mute) + " " + str);
    }

    public static d getMissedCallPinActions() {
        return new d().addWithTitle(c.b.CALL, 0, (int) R.string.timeline_action_title_call).addWithTitle(c.b.RESPONSE, 1, (int) R.string.reply_with_text).addWithTitle(c.b.REMOVE, 2, (int) R.string.timeline_action_title_remove);
    }

    public static d getMissedCallNotificationActions() {
        return new d().addWithTitle(c.b.CALL, 0, (int) R.string.timeline_action_title_call).addWithTitle(c.b.RESPONSE, 1, (int) R.string.reply_with_text).addWithTitle(c.b.DISMISS, 2, (int) R.string.timeline_action_title_dismiss);
    }

    public static d getCalendarPinActions(int i, boolean z) {
        d dVar = new d();
        dVar.addCalendarEventActions(i, z);
        return getPinActions(dVar, null);
    }

    public static d getCalendarReminderActions(int i, boolean z) {
        d dVar = new d();
        dVar.addWithTitle(c.b.DISMISS, 0, (int) R.string.timeline_action_title_dismiss);
        dVar.addCalendarEventActions(i, z);
        int size = dVar.mTimelineActions.size();
        return dVar.addWithTitle(c.b.OPEN_PIN, size, (int) R.string.timeline_action_title_more).addWithTitle(c.b.MUTE, size + 1, (int) R.string.timeline_action_title_mute);
    }

    public static d getCalendarInviteActions(int i, boolean z) {
        d dVar = new d();
        dVar.addCalendarEventActions(i, z);
        return dVar.addWithTitle(c.b.MUTE, dVar.mTimelineActions.size(), (int) R.string.timeline_action_title_mute);
    }

    public static d getReminderActions(UUID uuid) {
        d addWithTitle = new d().addWithTitle(c.b.DISMISS, 0, (int) R.string.timeline_action_title_dismiss).addWithTitle(c.b.OPEN_PIN, 1, (int) R.string.timeline_action_title_more);
        return aw.e.equals(uuid) ? addWithTitle : addWithTitle.addWithTitle(c.b.MUTE, 2, (int) R.string.timeline_action_title_mute);
    }

    public static d getWeatherActions() {
        int i;
        Resources resources = getResources();
        d dVar = new d();
        ak.a p = PebbleApplication.p();
        if (p == null || !p.capabilities.supportsWeatherApp) {
            i = 0;
        } else {
            i = 1;
            dVar.add(c.b.OPEN_WATCH_APP, 0, new f().add(c.TITLE_KEY, resources.getString(R.string.timeline_action_title_open_app)));
        }
        return dVar.add(c.b.REMOVE, i, new f().add(c.TITLE_KEY, resources.getString(R.string.timeline_action_title_remove))).add(c.b.MUTE, i + 1, new f().add(c.TITLE_KEY, resources.getString(R.string.timeline_action_title_mute)));
    }

    private static Resources getResources() {
        return com.getpebble.android.common.a.K().getResources();
    }

    public d add(c.b bVar, int i, f fVar) {
        this.mTimelineActions.add(new c(bVar, fVar.toArray(), i));
        return this;
    }

    public d add(c.b bVar, c.a aVar, int i, f fVar) {
        this.mTimelineActions.add(new c(bVar, aVar, fVar.toArray(), i));
        return this;
    }

    public d add(d dVar) {
        this.mTimelineActions.addAll(dVar.getActions());
        return this;
    }

    public String toJson() {
        return p.a(toArray());
    }

    public c[] toArray() {
        return (c[]) this.mTimelineActions.toArray(new c[this.mTimelineActions.size()]);
    }

    private d addWithTitle(c.b bVar, int i, String str) {
        add(bVar, i, new f().add(c.TITLE_KEY, str));
        return this;
    }

    private d addWithTitle(c.b bVar, int i, int i2) {
        addWithTitle(bVar, i, getResources().getString(i2));
        return this;
    }

    private d addWithTitle(c.b bVar, c.a aVar, int i, String str) {
        add(bVar, aVar, i, new f().add(c.TITLE_KEY, str));
        return this;
    }

    private d addWithTitle(c.b bVar, c.a aVar, int i, int i2) {
        addWithTitle(bVar, aVar, i, getResources().getString(i2));
        return this;
    }

    public List<c> getActions() {
        return this.mTimelineActions;
    }

    private d addCalendarEventActions(int i, boolean z) {
        int size = this.mTimelineActions.size();
        if (z) {
            addWithTitle(c.b.GENERIC, c.a.CALENDAR_CANCEL, size, (int) R.string.timeline_action_title_cancel);
        } else {
            int i2;
            if (i == 3) {
                int i3 = size + 1;
                addWithTitle(c.b.GENERIC, c.a.CALENDAR_ACCEPT, size, (int) R.string.timeline_action_title_accept);
                i2 = i3 + 1;
                addWithTitle(c.b.GENERIC, c.a.CALENDAR_MAYBE, i3, (int) R.string.timeline_action_title_maybe);
            } else if (i == 4) {
                i2 = size + 1;
                addWithTitle(c.b.GENERIC, c.a.CALENDAR_ACCEPT, size, (int) R.string.timeline_action_title_accept);
            } else {
                if (i != 1) {
                    com.getpebble.android.common.b.a.f.a(TAG, "Unrecognized attendee status type: " + i);
                }
                i2 = size;
            }
            addWithTitle(c.b.GENERIC, c.a.CALENDAR_DECLINE, i2, (int) R.string.timeline_action_title_decline);
        }
        return this;
    }
}
