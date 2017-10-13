package com.google.android.gms.b;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.m;
import java.util.Iterator;

public class p extends l {
    protected void a(ConnectionResult connectionResult, int i) {
        x xVar = null;
        xVar.b(connectionResult, i);
    }

    public void b() {
        Object obj = null;
        super.b();
        Iterator it = obj.iterator();
        while (it.hasNext()) {
            ((m) it.next()).a();
        }
        obj.clear();
        obj.a(this);
    }

    protected void c() {
        x xVar = null;
        xVar.b();
    }
}
