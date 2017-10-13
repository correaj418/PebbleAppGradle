package com.getpebble.android.framework.jskit.a.a;

import com.getpebble.android.framework.appmessage.AppMessage;
import com.google.b.l;
import com.google.b.o;
import com.google.b.s;
import com.google.b.t;
import java.lang.reflect.Type;

public class a implements t<AppMessage> {
    public l a(AppMessage appMessage, Type type, s sVar) {
        l oVar = new o();
        oVar.a("transactionId", Integer.valueOf(appMessage.d()));
        return oVar;
    }
}
