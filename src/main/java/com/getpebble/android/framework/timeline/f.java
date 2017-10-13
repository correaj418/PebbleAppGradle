package com.getpebble.android.framework.timeline;

import android.text.TextUtils;
import com.getpebble.android.framework.timeline.e.b;
import com.getpebble.android.framework.timeline.e.c;
import com.getpebble.android.h.p;
import com.google.b.i;
import com.google.b.l;
import com.google.b.o;
import com.google.b.r;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class f {
    private static final String TAG = "TimelineAttributes";
    private List<e> mAttributeList = new LinkedList();

    public f add(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            com.getpebble.android.common.b.a.f.d(TAG, "Not adding zero-length attribute: " + str);
        } else {
            this.mAttributeList.add(new e(str, new r(str2)));
        }
        return this;
    }

    public f add(c cVar, String str) {
        add(cVar.getSerializedName(), str);
        return this;
    }

    public f add(String str, int i) {
        this.mAttributeList.add(new e(str, new r(Integer.valueOf(i))));
        return this;
    }

    public f add(c cVar, int i) {
        add(cVar.getSerializedName(), i);
        return this;
    }

    public f add(c cVar, b bVar) {
        this.mAttributeList.add(new e(cVar.getSerializedName(), new r(bVar.getSerializedName())));
        return this;
    }

    public f add(c cVar, List<CharSequence> list) {
        add(cVar.getSerializedName(), (List) list);
        return this;
    }

    public f add(String str, List<CharSequence> list) {
        l iVar = new i();
        for (CharSequence charSequence : list) {
            iVar.a(new r(charSequence.toString()));
        }
        this.mAttributeList.add(new e(str, iVar));
        return this;
    }

    public static f from(o oVar) {
        f fVar = new f();
        if (oVar == null) {
            return fVar;
        }
        for (Entry entry : oVar.a()) {
            fVar.mAttributeList.add(new e((String) entry.getKey(), (l) entry.getValue()));
        }
        return fVar;
    }

    public e[] toArray() {
        return (e[]) this.mAttributeList.toArray(new e[this.mAttributeList.size()]);
    }

    String toJson() {
        return p.a(toArray());
    }

    public String toString() {
        return toJson();
    }

    public List<e> getAttributes() {
        return this.mAttributeList;
    }
}
