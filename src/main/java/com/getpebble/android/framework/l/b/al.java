package com.getpebble.android.framework.l.b;

import android.text.TextUtils;
import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.framework.install.app.b.a;
import com.getpebble.android.common.model.p;
import com.getpebble.android.framework.timeline.e.c;
import com.getpebble.android.framework.timeline.f;
import com.getpebble.android.framework.timeline.h;
import com.google.a.f.d;
import com.google.a.f.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class al {
    private ByteBuffer a;
    private final h b;
    private final a c;
    private final p.a d;

    public al(p.a aVar, h hVar, a aVar2) {
        this.d = aVar;
        this.b = hVar;
        this.c = aVar2;
    }

    private void a(ByteBuffer byteBuffer, List<CharSequence> list, h hVar, a aVar) {
        byteBuffer.put(b.c(e.a(0)));
        byteBuffer.put(d.a(0));
        byteBuffer.put(d.a(1));
        new f().add(c.CANNED_RESPONSE.getSerializedName(), (List) list);
        com.getpebble.android.framework.timeline.c cVar = new com.getpebble.android.framework.timeline.c(com.getpebble.android.framework.timeline.c.b.RESPONSE, new com.getpebble.android.framework.timeline.e[]{(com.getpebble.android.framework.timeline.e) r0.getAttributes().get(0)}, 0);
        new ap().serializeActions(byteBuffer, new com.getpebble.android.framework.timeline.c[]{cVar}, hVar, aVar);
    }

    public byte[] a() {
        this.a = ByteBuffer.allocate(j.b());
        this.a.order(ByteOrder.LITTLE_ENDIAN);
        List arrayList = new ArrayList();
        for (Integer num : a(this.d.a.keySet())) {
            if (!TextUtils.isEmpty((CharSequence) this.d.a.get(num))) {
                arrayList.add(this.d.a.get(num));
            }
        }
        a(this.a, arrayList, this.b, this.c);
        byte[] copyOf = Arrays.copyOf(this.a.array(), this.a.position());
        com.getpebble.android.common.b.a.f.e("CannedResponsesModel", "SerializedCannedResponse: choices: " + arrayList.toString());
        com.getpebble.android.common.b.a.f.e("CannedResponsesModel", "SerializedCannedResponse: bytes: " + Arrays.toString(copyOf));
        return copyOf;
    }

    static <T extends Comparable<? super T>> List<T> a(Set<T> set) {
        List<T> arrayList = new ArrayList(set);
        Collections.sort(arrayList);
        return arrayList;
    }
}
