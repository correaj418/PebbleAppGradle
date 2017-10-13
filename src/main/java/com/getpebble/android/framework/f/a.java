package com.getpebble.android.framework.f;

import android.content.ContentResolver;
import android.content.Context;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.d.b;
import com.getpebble.android.bluetooth.h.e;
import com.getpebble.android.bluetooth.h.f;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.framework.c;
import java.util.List;

public class a implements f {
    private final e a;
    private final c b;

    public a(Context context, e eVar, c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("context null");
        } else if (eVar == null) {
            throw new IllegalArgumentException("deviceFetcher null");
        } else {
            this.a = eVar;
            this.b = cVar;
            ak.purgeUnknownDevices(context.getContentResolver());
            c();
            this.a.a(this);
        }
    }

    private Context d() {
        return com.getpebble.android.common.a.K();
    }

    public void c() {
        Context d = d();
        if (d == null) {
            com.getpebble.android.common.b.a.f.f("DiscoveryManager", "getBondedDevices(): context is null");
            return;
        }
        List<PebbleDevice> f = this.a.f();
        ContentResolver contentResolver = d.getContentResolver();
        for (PebbleDevice updateOrInsertDeviceWithLeLogic : f) {
            ak.updateOrInsertDeviceWithLeLogic(contentResolver, updateOrInsertDeviceWithLeLogic, null);
        }
    }

    public void a(b bVar) {
        Context d = d();
        if (d == null) {
            throw new IllegalArgumentException("context null");
        }
        ak.updateOrInsertDeviceWithLeLogic(d.getContentResolver(), bVar.a, bVar.b);
    }

    public void a() {
        this.b.a().a(true);
    }

    public void b() {
        this.b.a().a(false);
    }
}
