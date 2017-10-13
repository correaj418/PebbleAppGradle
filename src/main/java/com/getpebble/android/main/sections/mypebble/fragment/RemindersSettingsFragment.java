package com.getpebble.android.main.sections.mypebble.fragment;

import com.getpebble.android.common.model.am.d;
import com.getpebble.android.common.model.o;
import com.getpebble.android.framework.n.b;
import com.getpebble.android.main.sections.mypebble.a.a;
import com.getpebble.android.main.sections.mypebble.a.j;
import java.util.List;
import java.util.UUID;

public class RemindersSettingsFragment extends a<j> {
    protected /* synthetic */ a a(List list) {
        return b(list);
    }

    protected UUID b() {
        return d.REMINDERS.getUuid();
    }

    protected j b(List<o.a> list) {
        return new j(getActivity(), list, new b(com.getpebble.android.common.a.K().getContentResolver(), new b.a()));
    }

    protected boolean a(o.a aVar) {
        return aVar.g >= 500;
    }
}
