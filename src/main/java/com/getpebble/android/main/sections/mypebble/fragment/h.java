package com.getpebble.android.main.sections.mypebble.fragment;

import android.os.Bundle;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.model.p;
import com.getpebble.android.common.model.p.b;
import com.getpebble.android.main.sections.notifications.a;
import java.util.HashMap;
import java.util.Map;

public class h extends a {
    protected String d() {
        return getString(R.string.sms_canned_responses_header);
    }

    protected c.a e() {
        return c.a.SEND_TEXT;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActivity().setTitle(getString(R.string.sms_templates_title).toUpperCase());
    }

    protected String[] f() {
        return getResources().getStringArray(b.SendText.defaultsArrayId);
    }

    protected void a(final a.a aVar) {
        new f(this) {
            HashMap<Integer, CharSequence> a = new HashMap();
            final /* synthetic */ h c;

            public boolean doInBackground() {
                p.a a = p.a(b.SendText, com.getpebble.android.common.a.K().getContentResolver());
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
        p.a(new p.a(b.SendText, hashMap), com.getpebble.android.common.a.K().getContentResolver());
    }
}
