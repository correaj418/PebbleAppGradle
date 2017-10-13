package com.getpebble.android.framework.g;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.l.a.j;
import com.getpebble.android.framework.l.b.k;
import com.getpebble.android.framework.l.c;

class g implements f {
    private b a;
    private a b;
    private c c;

    interface a {
        void a(k kVar);
    }

    interface b {
        com.getpebble.android.framework.l.b.c a(com.getpebble.android.framework.l.a.b bVar);
    }

    public g(b bVar, a aVar, c cVar) {
        this.a = bVar;
        this.c = cVar;
        this.b = aVar;
    }

    public boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        j a = this.c.a(bVar);
        if (a == null) {
            f.b("BlobDbEndpoint", "handleBlobSyncMessageAsync: BlobSync does not support message: " + bVar.toString());
            return false;
        }
        switch (a.f()) {
            case WRITE:
                this.b.a(this.a.a((com.getpebble.android.framework.l.a.b) a));
                return true;
            case WRITEBACK:
            case DATABASE_UNLOCKED:
            case START_SYNC_RESPONSE:
            case DIRTY_DATABASES_RESPONSE:
            case UNKNOWN:
                return false;
            default:
                return false;
        }
    }

    public void a() {
        this.a = null;
        this.c = null;
        this.b = null;
    }
}
