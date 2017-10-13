package com.getpebble.android.framework.health.a;

import com.getpebble.android.bluetooth.b.f;
import com.google.android.gms.common.api.c;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.concurrent.TimeUnit;

public class d extends f {
    private final c a;
    private final DataReadRequest b;
    private final a c;
    private DataReadResult d;

    public interface a {
        void a(DataReadResult dataReadResult);
    }

    public d(c cVar, DataReadRequest dataReadRequest, a aVar) {
        this.a = cVar;
        this.b = dataReadRequest;
        this.c = aVar;
    }

    public boolean doInBackground() {
        this.d = (DataReadResult) com.google.android.gms.fitness.c.p.a(this.a, this.b).a(30, TimeUnit.SECONDS);
        return true;
    }

    public void onTaskSuccess() {
        this.c.a(this.d);
    }

    public void onTaskFailed() {
    }
}
