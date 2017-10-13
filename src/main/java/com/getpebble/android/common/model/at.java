package com.getpebble.android.common.model;

import android.content.ContentResolver;
import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.h.p;
import com.google.b.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class at implements ay {
    @c(a = "contacts")
    public final List<a> a;

    public static class a {
        @c(a = "contactUUID")
        public String a;
        @c(a = "phoneNumberUUID")
        public String b;
        @c(a = "type")
        public int c;

        public a(String str, String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a.equals(aVar.a) && this.b.equals(aVar.b) && this.c == aVar.c) {
                return true;
            }
            return false;
        }
    }

    public at(List<a> list) {
        this.a = list;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof at)) {
            return false;
        }
        return this.a.equals(((at) obj).a);
    }

    public byte[] toBytes() {
        byte size = (byte) this.a.size();
        ByteBuffer allocate = ByteBuffer.allocate(331);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(size);
        for (byte b = (byte) 0; b < size; b++) {
            a aVar = (a) this.a.get(b);
            allocate.put(b.a(UUID.fromString(aVar.a)));
            allocate.put(b.a(UUID.fromString(aVar.b)));
            allocate.put((byte) aVar.c);
        }
        return allocate.array();
    }

    public String toJson() {
        return p.a(this);
    }

    public int hashCode() {
        return toJson().hashCode();
    }

    public String getKey() {
        return "sendTextApp";
    }

    public static synchronized void a() {
        synchronized (at.class) {
            if (com.getpebble.android.framework.o.b.a.isSendTextAppSupported()) {
                ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
                Object arrayList = new ArrayList();
                for (com.getpebble.android.common.model.aq.a aVar : aq.a(contentResolver)) {
                    if (aVar.a != null) {
                        a aVar2 = new a(aVar.a.c.toString(), aVar.b.toString(), aVar.e == null ? 0 : 1);
                        f.e("SendTextAppEntry", "sync: contact = " + aVar.a.c.toString() + ", phone number = " + aVar.b.toString());
                        arrayList.add(aVar2);
                    } else {
                        aq.b(contentResolver, aVar.d);
                        f.b("SendTextAppEntry", "sync: the phone number " + com.getpebble.android.common.b.b.a.a(aVar.d) + " does not have a contact info.");
                    }
                }
                f.d("SendTextAppEntry", "sync: contactList=" + com.getpebble.android.common.b.b.a.a(arrayList));
                az.a(new at(arrayList), contentResolver);
            } else {
                f.c("SendTextAppEntry", "sync: Watch does not support sendTextApp - not syncing sendTextApp");
            }
        }
    }
}
