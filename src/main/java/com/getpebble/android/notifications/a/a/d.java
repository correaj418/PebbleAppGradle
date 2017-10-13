package com.getpebble.android.notifications.a.a;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.notifications.a.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d extends g {
    public static final List<String> a = new ArrayList(Arrays.asList(new String[]{"com.google.android.talk", "com.pansi.msg", "com.android.mms"}));

    public i b(b bVar) {
        i b = super.b(bVar);
        String j = bVar.j();
        String g = bVar.g();
        if (!(j == null || b.b() == null || ((g == null || !g.equals("com.android.mms")) && j.contains(b.b())))) {
            String[] split = bVar.j().split(": ");
            if (split.length > 1) {
                f.d("MergedMessagesNotificationContentExtrator", "Found Merged Messaging Notification: Building notification with Ticket Text");
                b.a(split[0]);
                b.b(bVar.j().substring(b.b().length() + 2));
            }
        }
        return b;
    }
}
