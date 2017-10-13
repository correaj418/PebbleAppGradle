package com.getpebble.android.main.sections.notifications;

import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.b.a.a.c.a;
import com.getpebble.android.common.model.p;
import com.getpebble.android.common.model.p.b;
import java.util.HashMap;
import java.util.Map;

public class IncomingCallCannedResponsesFragment extends a {
    protected String d() {
        return getString(R.string.incoming_call_canned_responses_header);
    }

    protected a e() {
        return a.INCOMING_CALL;
    }

    protected String[] f() {
        return getResources().getStringArray(b.IncomingCall.defaultsArrayId);
    }

    protected void a(final a.a aVar) {
        new f(this) {
            HashMap<Integer, CharSequence> a = new HashMap();
            final /* synthetic */ IncomingCallCannedResponsesFragment c;

            public boolean doInBackground() {
                p.a a = p.a(b.IncomingCall, com.getpebble.android.common.a.K().getContentResolver());
                if (a != null) {
                    this.a = a.a;
                }
                return true;
            }

            public void onTaskSuccess() {
                Map hashMap = new HashMap();
                for (Integer num : this.a.keySet()) {
                    hashMap.put(num, ((CharSequence) this.a.get(num)).toString());
                }
                aVar.a(hashMap);
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    protected void a(Map<Integer, String> map) {
        HashMap hashMap = new HashMap();
        for (Integer num : map.keySet()) {
            hashMap.put(num, map.get(num));
        }
        p.a(new p.a(b.IncomingCall, hashMap), com.getpebble.android.common.a.K().getContentResolver());
    }
}
