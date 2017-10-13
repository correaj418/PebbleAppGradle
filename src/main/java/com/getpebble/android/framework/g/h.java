package com.getpebble.android.framework.g;

import android.graphics.Bitmap;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.g.k.b;
import com.getpebble.android.framework.l.b.d;
import com.getpebble.android.framework.l.b.d.a;
import com.google.a.b.am;
import java.util.Set;

public class h extends ac {
    private p a;

    public h(p pVar) {
        this.a = pVar;
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        boolean z = false;
        f.d("CustomizeAppEndpoint", "onRequest: Got request: " + kVar.b());
        switch (kVar.b()) {
            case CUSTOMIZE_APP:
                f.d("CustomizeAppEndpoint", "onRequest: Sending customize app messages");
                int intValue = kVar.a(b.APP_TYPE).intValue();
                a fromByte = a.fromByte((byte) intValue);
                if (!a.UNKNOWN.equals(fromByte)) {
                    String b = kVar.b(b.APP_TITLE);
                    Bitmap bitmap = (Bitmap) kVar.c(b.BITMAP);
                    if (b != null) {
                        this.a.a(d.a(fromByte, b));
                    }
                    if (bitmap != null) {
                        this.a.a(d.a(fromByte, bitmap));
                    }
                    z = true;
                    break;
                }
                f.b("CustomizeAppEndpoint", "onRequest: CUSTOMIZE_APP message received with invalid AppType (" + intValue + ")");
                return true;
            default:
                f.d("CustomizeAppEndpoint", "onRequest: No matching request found in CustomizeAppEndpoint, not handling.");
                break;
        }
        return z;
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return am.b(com.getpebble.android.bluetooth.g.a.APP_CUSTOMIZE);
    }

    boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        return true;
    }

    void b() {
    }
}
