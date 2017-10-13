package com.getpebble.android.notifications.a.a;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.ac;
import android.text.TextUtils;
import com.getpebble.android.h.aa;
import com.getpebble.android.notifications.a.b;

public class g implements a {
    public i b(b bVar) {
        i iVar = new i();
        Notification n = bVar.n();
        iVar.a(bVar.f());
        iVar.c(null);
        Bundle a = ac.a(n);
        if (a != null) {
            iVar.a(aa.a(a, "android.title", bVar.f()));
            iVar.c(aa.a(a, "android.summaryText", aa.a(a, "android.subText", null)));
            CharSequence charSequence = a.getCharSequence("android.bigText");
            CharSequence charSequence2 = a.getCharSequence("android.text");
            if (charSequence != null && !"com.google.android.talk".equals(bVar.g())) {
                iVar.b(charSequence.toString());
            } else if (charSequence2 != null) {
                iVar.b(charSequence2.toString());
            }
            if (TextUtils.isEmpty(iVar.c())) {
                CharSequence[] charSequenceArray = a.getCharSequenceArray("android.textLines");
                if (charSequenceArray != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Object obj = 1;
                    for (CharSequence append : charSequenceArray) {
                        if (obj != null) {
                            obj = null;
                        } else {
                            stringBuffer.append("\n");
                        }
                        stringBuffer.append(append);
                    }
                    iVar.b(stringBuffer.toString());
                }
            }
            if (TextUtils.isEmpty(iVar.c())) {
                charSequence = a.getCharSequence("android.infoText");
                if (charSequence != null) {
                    iVar.b(charSequence.toString());
                }
            }
        }
        if (TextUtils.isEmpty(iVar.c())) {
            iVar.b(bVar.j());
        }
        return iVar;
    }

    public i a(b bVar) {
        return b(bVar);
    }
}
