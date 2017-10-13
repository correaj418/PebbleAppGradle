package com.getpebble.android.framework.jskit.a.a;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.appmessage.AppMessage;
import com.getpebble.android.framework.appmessage.a;
import com.getpebble.android.framework.appmessage.c;
import com.getpebble.jskit.android.impl.runtime.model.JsApplicationInfo;
import com.google.a.f.d;
import com.google.a.f.e;
import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.n;
import com.google.b.o;
import com.google.b.r;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.UUID;

public class b implements k<AppMessage> {
    private static String a = "AppMessageDeserializer";
    private JsApplicationInfo b;

    public /* synthetic */ Object deserialize(l lVar, Type type, j jVar) {
        return a(lVar, type, jVar);
    }

    public b(JsApplicationInfo jsApplicationInfo) {
        this.b = jsApplicationInfo;
    }

    private e a(String str) {
        e eVar = null;
        if (!(this.b == null || this.b.j() == null)) {
            eVar = (e) this.b.j().get(str);
        }
        if (eVar == null) {
            return e.a(str);
        }
        return eVar;
    }

    private byte[] a(i iVar) {
        int i = 0;
        if (iVar.a() < 1) {
            return new byte[0];
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = iVar.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            if (lVar.j()) {
                r n = lVar.n();
                if (n.n().p()) {
                    try {
                        arrayList.add(Byte.valueOf(d.a(n.e())));
                    } catch (Throwable e) {
                        f.a(a, "convertJsonArrayToByteArray: could not convert to byte ", e);
                        return new byte[0];
                    }
                } else if (n.q()) {
                    try {
                        for (byte valueOf : n.c().getBytes("UTF-8")) {
                            arrayList.add(Byte.valueOf(valueOf));
                        }
                    } catch (Throwable e2) {
                        f.a(a, "convertJsonArrayToByteArray: Could not serialize string " + n.c(), e2);
                    }
                }
            } else {
                f.a(a, "convertJsonArrayToByteArray: unsupported type " + lVar);
                return new byte[0];
            }
        }
        byte[] bArr = new byte[arrayList.size()];
        while (i < arrayList.size()) {
            bArr[i] = ((Byte) arrayList.get(i)).byteValue();
            i++;
        }
        return bArr;
    }

    public AppMessage a(l lVar, Type type, j jVar) {
        c aVar = new a();
        if (lVar != null) {
            for (Entry entry : lVar.l().a()) {
                e a = a((String) entry.getKey());
                l lVar2 = (l) entry.getValue();
                if (lVar2 instanceof o) {
                    f.b(a, "AppMessageDeserializer: deserialize: " + lVar2 + " should not be a JsonObject");
                } else if (lVar2 instanceof i) {
                    f.d(a, "AppMessageDeserializer: instanceof JsonArray");
                    aVar.a(a, a(lVar2.m()));
                } else if (lVar2 instanceof r) {
                    r n = lVar2.n();
                    if (n.a()) {
                        aVar.a(a, n.g() ? (short) 1 : (short) 0);
                    } else if (n.p()) {
                        aVar.a(a, n.b().intValue());
                    } else {
                        aVar.a(a, n.c());
                    }
                } else if (lVar2 instanceof n) {
                    f.b(a, "AppMessageDeserializer: deserialize: " + lVar2 + " should not be a JsonNull");
                }
            }
        }
        UUID fromString = UUID.fromString(this.b.a());
        return new AppMessage(AppMessage.a(fromString), fromString, AppMessage.a.PUSH, aVar);
    }
}
