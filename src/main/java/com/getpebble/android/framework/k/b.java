package com.getpebble.android.framework.k;

import android.text.TextUtils;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.g.ag.a;
import com.getpebble.android.framework.l.a.w;
import com.getpebble.android.framework.m.j;
import com.getpebble.android.framework.m.j.e;
import com.getpebble.android.framework.timeline.e.c;
import java.util.Map;
import java.util.UUID;

public class b {
    public static final UUID a = UUID.fromString("0f71aaba-5814-4b5c-96e2-c9828c9734cb");

    public static void a(w wVar, final a aVar) {
        Map e = wVar.e();
        if (e == null) {
            f.b("SendTextAction", "processAction() attributes is null");
            aVar.a(false, null, null);
            return;
        }
        final String str = (String) e.get(c.TITLE_KEY.getSerializedName());
        if (str == null) {
            f.b("SendTextAction", "processAction() reply is null");
            aVar.a(false, null, null);
            return;
        }
        String str2 = (String) e.get(c.SENDER.getSerializedName());
        if (TextUtils.isEmpty(str2)) {
            f.b("SendTextAction", "processAction() phone number is null");
            aVar.a(false, null, null);
            return;
        }
        if (str2.contains("❤")) {
            str2 = str2.replace("❤", "");
        }
        j.a(str, str2, new e() {
            public void b() {
                com.getpebble.android.common.b.a.a.c.a(true, str.length());
                com.getpebble.android.framework.timeline.f fVar = new com.getpebble.android.framework.timeline.f();
                fVar.add(c.SUBTITLE_KEY, com.getpebble.android.common.a.K().getString(R.string.action_sent));
                fVar.add(c.LARGE_ICON, com.getpebble.android.framework.timeline.e.b.ACTION_RESULT_SENT);
                aVar.a(true, fVar, null);
            }

            public void a() {
                com.getpebble.android.common.b.a.a.c.a(false, str.length());
                aVar.a(false, null, null);
            }
        });
    }
}
