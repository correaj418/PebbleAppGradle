package com.getpebble.android.main.sections.notifications;

import android.annotation.SuppressLint;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c.a;
import com.getpebble.android.common.b.b.c;
import java.util.HashMap;
import java.util.Map;

public class CannedResponsesFragment extends a {
    protected String d() {
        return getString(R.string.canned_responses_header);
    }

    protected a e() {
        return a.CANNED_RESPONSES;
    }

    protected String[] f() {
        return new String[5];
    }

    public Map<Integer, String> g() {
        Map hashMap = new HashMap();
        for (int i = 0; i < 5; i++) {
            hashMap.put(Integer.valueOf(i), null);
        }
        return hashMap;
    }

    protected void a(a.a aVar) {
        Map b = c.b();
        if (b == null || b.isEmpty()) {
            b = g();
        }
        for (int size = b.size(); size < 5; size++) {
            b.put(Integer.valueOf(size), null);
        }
        aVar.a(b);
    }

    @SuppressLint({"CommitPrefEdits"})
    protected void a(Map<Integer, String> map) {
        c.a((Map) map);
    }
}
