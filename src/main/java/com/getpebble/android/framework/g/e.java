package com.getpebble.android.framework.g;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.a.r;
import com.getpebble.android.common.model.a.x;
import com.getpebble.android.common.model.a.y;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.aq;
import com.getpebble.android.common.model.av;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.common.model.az;
import com.getpebble.android.common.model.ba;
import com.getpebble.android.common.model.bc;
import com.getpebble.android.common.model.d;
import com.getpebble.android.common.model.k;
import com.getpebble.android.common.model.p;
import com.getpebble.android.common.model.s;
import com.getpebble.android.common.model.v;
import com.getpebble.android.common.model.z;
import com.getpebble.android.core.provider.PebbleContentProvider;
import com.getpebble.android.framework.l.b.ao;
import com.getpebble.android.framework.l.b.j;
import com.getpebble.android.framework.l.c;
import com.getpebble.android.framework.service.TaskService;
import com.getpebble.android.framework.timeline.h;
import com.google.a.b.af;
import com.google.a.b.bt;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

public class e extends ac implements a, b {
    public static final Map<com.getpebble.android.common.model.aw.b, com.getpebble.android.framework.l.b.j.b> a = af.a(com.getpebble.android.common.model.aw.b.NOTIFICATION, com.getpebble.android.framework.l.b.j.b.NOTIFICATIONS, com.getpebble.android.common.model.aw.b.PIN, com.getpebble.android.framework.l.b.j.b.PINS, com.getpebble.android.common.model.aw.b.REMINDER, com.getpebble.android.framework.l.b.j.b.REMINDERS);
    private static final Uri[] m = new Uri[]{aw.a, am.a, av.a, bc.a, ba.c, p.a, s.a, aq.a, az.a, r.c, d.a};
    private final ContentObserver b;
    private final Context c;
    private final p d;
    private final com.getpebble.android.common.framework.install.app.b.a e;
    private final com.getpebble.android.common.model.ak.a f;
    private final v g;
    private final z h;
    private boolean i = false;
    private final a j = new a(this);
    private final g k = new g(this, this, new c());
    private Handler l;
    private boolean n;
    private Queue<com.getpebble.android.framework.l.b.j.b> o;
    private boolean p = false;
    private final Queue<b> q = new LinkedBlockingQueue();
    private final Set<UUID> r = new HashSet();
    private final Set<com.getpebble.android.framework.l.b.j.b> s = new HashSet();
    private final Set<com.getpebble.android.framework.l.b.j.b> t = new HashSet();
    private Pair<byte[], b> u = null;
    private Map<ByteBuffer, Integer> v = new HashMap();
    private boolean w;
    private int x = 0;
    private final Runnable y = new Runnable(this) {
        final /* synthetic */ e a;

        {
            this.a = r1;
        }

        public void run() {
            if (e.n(this.a) >= 3) {
                f.d("BlobDbEndpoint", "Timeout: retry count hit " + this.a.x + "; clearing head");
                this.a.a(false);
            } else {
                f.a("BlobDbEndpoint", "Timeout: message send failed; no ACK or NACK received. Re-trying");
                this.a.u = null;
            }
            this.a.B();
        }
    };

    public interface b {
        boolean a(ContentResolver contentResolver, boolean z, com.getpebble.android.common.framework.install.app.b.a aVar);

        boolean a(com.getpebble.android.common.framework.install.app.b.a aVar);

        byte[] a(com.getpebble.android.common.framework.install.app.b.a aVar, v vVar, z zVar);

        boolean b(com.getpebble.android.common.framework.install.app.b.a aVar);

        byte[] c();

        Integer d();

        com.getpebble.android.framework.l.b.j.b e();
    }

    class a implements f {
        final /* synthetic */ e a;

        a(e eVar) {
            this.a = eVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(com.getpebble.android.bluetooth.g.b r8) {
            /*
            r7 = this;
            r3 = 1;
            r2 = 0;
            r0 = new com.getpebble.android.framework.l.a.i;
            r0.<init>(r8);
            r1 = r0.d();
            r4 = r0.c();
            r0 = "BlobDbEndpoint";
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r6 = "handleResponseAsync: Response %s for token %s isClearing = ";
            r5 = r5.append(r6);
            r6 = r7.a;
            r6 = r6.n;
            r5 = r5.append(r6);
            r5 = r5.toString();
            r6 = 2;
            r6 = new java.lang.Object[r6];
            r6[r2] = r4;
            r1 = com.getpebble.android.bluetooth.b.b.d(r1);
            r6[r3] = r1;
            r1 = java.lang.String.format(r5, r6);
            com.getpebble.android.common.b.a.f.d(r0, r1);
            r0 = r7.a;
            r0 = r0.n;
            if (r0 == 0) goto L_0x004b;
        L_0x0044:
            r0 = r7.a;
            r0.i();
            r0 = r2;
        L_0x004a:
            return r0;
        L_0x004b:
            r0 = r7.a;
            r0 = r0.u;
            if (r0 != 0) goto L_0x005c;
        L_0x0053:
            r0 = "BlobDbEndpoint";
            r1 = "handleResponseAsync: Unexpected response received from BlobDb (mInFlightRecord is null) - ignoring";
            com.getpebble.android.common.b.a.f.b(r0, r1);
            r0 = r2;
            goto L_0x004a;
        L_0x005c:
            r0 = r7.a;
            r0 = r0.u;
            r0 = r0.second;
            r0 = (com.getpebble.android.framework.g.e.b) r0;
            r1 = com.getpebble.android.framework.g.e.AnonymousClass7.c;
            r5 = r4.ordinal();
            r1 = r1[r5];
            switch(r1) {
                case 1: goto L_0x008e;
                case 2: goto L_0x0110;
                case 3: goto L_0x014c;
                case 4: goto L_0x0164;
                case 5: goto L_0x017e;
                case 6: goto L_0x017e;
                case 7: goto L_0x01b5;
                case 8: goto L_0x01fa;
                default: goto L_0x0071;
            };
        L_0x0071:
            r1 = r7.a;
            r1.a(r2);
            r1 = r0 instanceof com.getpebble.android.common.model.am.c;
            if (r1 == 0) goto L_0x0087;
        L_0x007a:
            r0 = (com.getpebble.android.common.model.am.c) r0;
            r1 = r7.a;
            r1 = r1.r;
            r0 = r0.b;
            r1.remove(r0);
        L_0x0087:
            r0 = r7.a;
            r0.B();
            r0 = r3;
            goto L_0x004a;
        L_0x008e:
            r1 = r7.a;
            r1.a(r3);
            r1 = r7.a;
            r1 = r1.e;
            r1 = r0.b(r1);
            if (r1 == 0) goto L_0x00bc;
        L_0x009f:
            r1 = r7.a;
            r1 = r1.s;
            r2 = r0.e();
            r1 = r1.contains(r2);
            if (r1 == 0) goto L_0x00bc;
        L_0x00af:
            r1 = r7.a;
            r1 = r1.s;
            r2 = r0.e();
            r1.remove(r2);
        L_0x00bc:
            r1 = r7.a;
            r1 = r1.e;
            r1 = r0.a(r1);
            if (r1 == 0) goto L_0x0087;
        L_0x00c8:
            r1 = r0 instanceof com.getpebble.android.common.model.am.c;
            if (r1 == 0) goto L_0x0087;
        L_0x00cc:
            r0 = (com.getpebble.android.common.model.am.c) r0;
            r1 = r0.y;
            if (r1 == 0) goto L_0x00ec;
        L_0x00d2:
            r2 = "BlobDbEndpoint";
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r5 = "handleResponseAsync: Running start command because inserted app is marked as active: ";
            r4 = r4.append(r5);
            r5 = r0.b;
            r4 = r4.append(r5);
            r4 = r4.toString();
            com.getpebble.android.common.b.a.f.d(r2, r4);
        L_0x00ec:
            r2 = r7.a;
            r2 = r2.r;
            r4 = r0.b;
            r2 = r2.contains(r4);
            if (r2 != 0) goto L_0x00fc;
        L_0x00fa:
            if (r1 == 0) goto L_0x0087;
        L_0x00fc:
            r1 = r7.a;
            r2 = r0.b;
            r1.a(r2);
            r1 = r7.a;
            r1 = r1.r;
            r0 = r0.b;
            r1.remove(r0);
            goto L_0x0087;
        L_0x0110:
            r0 = r7.a;
            r0 = com.getpebble.android.framework.g.e.n(r0);
            r1 = 3;
            if (r0 < r1) goto L_0x0144;
        L_0x0119:
            r0 = "BlobDbEndpoint";
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r4 = "handleResponseAsync: Retry count hit ";
            r1 = r1.append(r4);
            r4 = r7.a;
            r4 = r4.x;
            r1 = r1.append(r4);
            r4 = "; clearing head";
            r1 = r1.append(r4);
            r1 = r1.toString();
            com.getpebble.android.common.b.a.f.d(r0, r1);
            r0 = r7.a;
            r0.a(r2);
            goto L_0x0087;
        L_0x0144:
            r0 = r7.a;
            r1 = 0;
            r0.u = r1;
            goto L_0x0087;
        L_0x014c:
            r1 = r7.a;
            r1.a(r3);
            r1 = r0 instanceof com.getpebble.android.common.model.am.c;
            if (r1 == 0) goto L_0x0087;
        L_0x0155:
            r0 = (com.getpebble.android.common.model.am.c) r0;
            r1 = r7.a;
            r1 = r1.r;
            r0 = r0.b;
            r1.remove(r0);
            goto L_0x0087;
        L_0x0164:
            r1 = com.getpebble.android.common.model.au.a.BLOB_DB_FULL;
            r5 = com.getpebble.android.common.a.K();
            r5 = r5.getContentResolver();
            com.getpebble.android.common.model.au.a(r1, r5);
            r1 = r7.a;
            r1 = r1.s;
            r5 = r0.e();
            r1.add(r5);
        L_0x017e:
            r1 = com.getpebble.android.framework.l.a.INVALID_DB_ID;
            r1 = r1.equals(r4);
            if (r1 == 0) goto L_0x01b5;
        L_0x0186:
            r1 = r7.a;
            r1 = r1.t;
            r5 = r0.e();
            r1.add(r5);
            r1 = "BlobDbEndpoint";
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r6 = "handleResponseAsync: Adding to invalid databases (";
            r5 = r5.append(r6);
            r6 = r0.e();
            r5 = r5.append(r6);
            r6 = ")";
            r5 = r5.append(r6);
            r5 = r5.toString();
            com.getpebble.android.common.b.a.f.d(r1, r5);
        L_0x01b5:
            r1 = com.getpebble.android.framework.l.a.INVALID_DATA;
            r1 = r1.equals(r4);
            if (r1 == 0) goto L_0x01fa;
        L_0x01bd:
            r1 = r7.a;
            r1 = r1.v;
            r5 = r0.c();
            r5 = java.nio.ByteBuffer.wrap(r5);
            r6 = r0.d();
            r1.put(r5, r6);
            r1 = "BlobDbEndpoint";
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r6 = "handleResponseAsync: Adding to known bad hashcodes (new size = ";
            r5 = r5.append(r6);
            r6 = r7.a;
            r6 = r6.v;
            r6 = r6.size();
            r5 = r5.append(r6);
            r6 = ")";
            r5 = r5.append(r6);
            r5 = r5.toString();
            com.getpebble.android.common.b.a.f.d(r1, r5);
        L_0x01fa:
            r1 = com.getpebble.android.framework.l.a.KEY_DOES_NOT_EXIST;
            r1 = r1.equals(r4);
            if (r1 == 0) goto L_0x0071;
        L_0x0202:
            r1 = r7.a;
            r1 = r1.e;
            r1 = r0.b(r1);
            if (r1 == 0) goto L_0x0071;
        L_0x020e:
            r1 = r7.a;
            r1.a(r3);
            r1 = r0 instanceof com.getpebble.android.common.model.am.c;
            if (r1 == 0) goto L_0x0071;
        L_0x0217:
            r1 = r0;
            r1 = (com.getpebble.android.common.model.am.c) r1;
            r4 = r7.a;
            r4 = r4.r;
            r1 = r1.b;
            r4.remove(r1);
            goto L_0x0071;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.framework.g.e.a.a(com.getpebble.android.bluetooth.g.b):boolean");
        }

        public void a() {
        }
    }

    static /* synthetic */ int n(e eVar) {
        int i = eVar.x + 1;
        eVar.x = i;
        return i;
    }

    public e(final Context context, p pVar) {
        if (context == null) {
            throw new IllegalArgumentException("'context' cannot be null!");
        } else if (pVar == null) {
            throw new IllegalArgumentException("'messageSender' cannot be null!");
        } else {
            this.c = context;
            this.d = pVar;
            this.l = new Handler(com.getpebble.android.framework.e.b().getLooper());
            this.f = ak.getPebbleDeviceRecord(context.getContentResolver(), this.d.e());
            if (this.f == null) {
                throw new IllegalStateException("connectedDevice cannot be null (for device " + this.d.e() + ")");
            }
            this.e = this.f.hwPlatform.getPlatformCode();
            this.g = this.f.getFwVersion();
            this.h = this.f.hwPlatform;
            f.d("BlobDbEndpoint", "mConnectedDevicePlatform = " + this.e);
            this.b = new ContentObserver(this, this.l) {
                final /* synthetic */ e a;

                public void onChange(boolean z) {
                    onChange(z, null);
                }

                public void onChange(boolean z, Uri uri) {
                    if (this.a.l == null) {
                        f.a("BlobDbEndpoint", "onChange: mHandler is null!!");
                    } else {
                        this.a.a(uri);
                    }
                }
            };
            this.l.post(new Runnable(this) {
                final /* synthetic */ e b;

                public void run() {
                    av.a(context.getContentResolver(), this.b.h, this.b.g);
                    aw.a(this.b.c(), System.currentTimeMillis());
                    bc.c(this.b.c());
                    bc.b(this.b.c());
                    d.a(this.b.c());
                    p.b(this.b.c());
                    new com.getpebble.android.framework.install.a.a(this.b.c).d();
                    String a = new com.getpebble.android.common.b.b.c(this.b.c).a(com.getpebble.android.common.b.b.c.a.BLOB_DB_LAST_SYNC_ADDRESS, null);
                    if (a == null || !a.equals(this.b.d.e().getAddress())) {
                        f.c("BlobDbEndpoint", "Different from last sync; wiping all BlobDb tables and marking all data as dirty for watch... (last = " + a + " current = " + this.b.d.e().getAddress() + ")");
                        PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.BLOB_DB_LAST_SYNC_ADDRESS, "");
                        if (a == null) {
                            com.getpebble.android.common.b.a.a.c.a(com.getpebble.android.common.b.a.a.a.c.a.WATCH_UNFAITHFUL);
                        } else {
                            com.getpebble.android.common.b.a.a.c.a(com.getpebble.android.common.b.a.a.a.c.a.PHONE_UNFAITHFUL);
                        }
                        this.b.h();
                        return;
                    }
                    this.b.j();
                }
            });
        }
    }

    private void h() {
        f.d("BlobDbEndpoint", "resetBlobDbForConnectedWatch()");
        this.d.a(com.getpebble.android.bluetooth.e.a.e.MIN);
        l();
        E();
        am.a(k().getContentResolver(), com.getpebble.android.common.model.am.e.APP, this.e);
        am.a(k().getContentResolver(), com.getpebble.android.common.model.am.e.WATCHFACE, this.e);
        this.n = true;
        this.p = true;
        this.o = new LinkedList();
        this.s.clear();
        for (Object add : com.getpebble.android.framework.l.b.j.b.values()) {
            this.o.add(add);
        }
        i();
    }

    private void i() {
        com.getpebble.android.framework.l.b.j.b bVar = (com.getpebble.android.framework.l.b.j.b) this.o.poll();
        if (bVar != null) {
            f.d("BlobDbEndpoint", "clearNextDatabase: clearing db: " + bVar);
            this.d.a(j.a(com.getpebble.android.bluetooth.b.b.b(), bVar));
            return;
        }
        int f = am.f(this.c.getContentResolver());
        int a = aw.a(this.c.getContentResolver());
        int d = bc.d(this.c.getContentResolver());
        int a2 = k.a(this.c.getContentResolver(), ba.c);
        int a3 = k.a(this.c.getContentResolver(), r.c);
        int b = s.b(this.c.getContentResolver());
        int a4 = az.a(this.c.getContentResolver());
        int b2 = d.b(this.c.getContentResolver());
        f.d("BlobDbEndpoint", String.format(Locale.US, "clearNextDatabase: marked items as dirty; locker=%d,timeline=%d,weatherApp=%d,watchSettings=%d,healthStats=%d,contacts=%d,watchApps=%d,appGlances=%d", new Object[]{Integer.valueOf(f), Integer.valueOf(a), Integer.valueOf(d), Integer.valueOf(a2), Integer.valueOf(a3), Integer.valueOf(b), Integer.valueOf(a4), Integer.valueOf(b2)}));
        j();
        f.d("BlobDbEndpoint", "clearNextDatabase: Clear complete; marking this device as last sync device: " + this.d.e());
        PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.BLOB_DB_LAST_SYNC_ADDRESS, this.d.e().getAddress());
        this.d.a(com.getpebble.android.bluetooth.e.a.e.MAX);
    }

    private void j() {
        int i = 0;
        f.d("BlobDbEndpoint", "registerObserverAndSync()");
        this.n = false;
        Uri[] uriArr = m;
        int length = uriArr.length;
        while (i < length) {
            this.c.getContentResolver().registerContentObserver(uriArr[i], true, this.b);
            i++;
        }
        a(null);
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return com.google.a.b.am.a(com.getpebble.android.bluetooth.g.a.BLOBDB_V1, com.getpebble.android.bluetooth.g.a.BLOBDB_V2);
    }

    private Context k() {
        return this.c;
    }

    ContentResolver c() {
        return k().getContentResolver();
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        if (kVar.b().equals(com.getpebble.android.framework.g.k.a.CLEAR_BLOB_DB)) {
            a(new Runnable(this) {
                final /* synthetic */ e a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.h();
                }
            });
            return true;
        } else if (!kVar.b().equals(com.getpebble.android.framework.g.k.a.START_APP_AFTER_COMMIT_TO_DB)) {
            return false;
        } else {
            this.r.add(UUID.fromString(kVar.b(com.getpebble.android.framework.g.k.b.UUID)));
            return true;
        }
    }

    boolean a(final com.getpebble.android.bluetooth.g.b bVar) {
        d();
        a(new Runnable(this) {
            final /* synthetic */ e b;

            public void run() {
                f e;
                com.getpebble.android.bluetooth.g.a fromCode = com.getpebble.android.bluetooth.g.a.fromCode(bVar.a());
                switch (fromCode) {
                    case BLOBDB_V1:
                        e = this.b.e();
                        break;
                    case BLOBDB_V2:
                        e = this.b.f();
                        break;
                    default:
                        f.f("BlobDbEndpoint", "Received message from unsupported endpoint: " + fromCode);
                        e = null;
                        break;
                }
                if (e != null) {
                    e.a(bVar);
                }
            }
        });
        return true;
    }

    public com.getpebble.android.framework.l.b.c a(com.getpebble.android.framework.l.a.b bVar) {
        com.getpebble.android.framework.l.b.j.b c = bVar.c();
        switch (c) {
            case PINS:
            case REMINDERS:
            case NOTIFICATIONS:
                h mapper = h.getMapper(k(), this.g, this.h);
                ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
                return aw.a(contentResolver, bVar, new ao(mapper), new com.getpebble.android.framework.a.f(contentResolver), this.e);
            default:
                f.f("BlobDbEndpoint", "handleBlobSyncMessageAsync: BlobSync does not support " + c + " yet");
                return bVar.a(com.getpebble.android.framework.l.a.DB_NOT_SUPPORTED);
        }
    }

    public void a(com.getpebble.android.framework.l.b.k kVar) {
        this.d.a((com.getpebble.android.framework.l.b.r) kVar);
    }

    private void a(UUID uuid) {
        f.d("BlobDbEndpoint", "sendStartAppCommand: Sending start command for " + uuid);
        Bundle bundle = new Bundle();
        bundle.putString(com.getpebble.android.framework.g.k.b.UUID.toString(), uuid.toString());
        a(new k(com.getpebble.android.bluetooth.g.a.APP_RUN_STATE, com.getpebble.android.framework.g.k.a.START_APP, bundle));
    }

    private void a(k kVar) {
        com.getpebble.android.framework.b.a c = com.getpebble.android.framework.b.a.c(this.d.e());
        if (c == null) {
            f.c("BlobDbEndpoint", "sendStartAppCommand: Can't send message to watch: router is null");
        } else {
            c.a(kVar, null);
        }
    }

    void b() {
        f.d("BlobDbEndpoint", "deinit()");
        l();
        if (this.l != null) {
            this.l.removeCallbacksAndMessages(null);
            this.l = null;
        }
        this.q.clear();
        this.n = false;
        this.u = null;
        this.j.a();
        this.k.a();
    }

    private void l() {
        c().unregisterContentObserver(this.b);
    }

    private void a(Uri uri) {
        if (this.q.isEmpty()) {
            this.w = false;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            if ((uri == null ? 1 : null) != null) {
                i = o();
                i2 = p();
                i3 = q();
                i4 = r();
                i5 = n();
                i6 = t();
                i7 = s();
                i8 = u();
                i9 = v();
                i10 = w();
                i11 = y();
                i12 = x();
                i13 = z();
            } else {
                try {
                    String b = PebbleContentProvider.b(uri);
                    Object obj = -1;
                    switch (b.hashCode()) {
                        case -1803017095:
                            if (b.equals("phone_numbers")) {
                                obj = 6;
                                break;
                            }
                            break;
                        case -1144974559:
                            if (b.equals("app_glances")) {
                                obj = 9;
                                break;
                            }
                            break;
                        case -567451565:
                            if (b.equals("contacts")) {
                                obj = 5;
                                break;
                            }
                            break;
                        case 124526995:
                            if (b.equals("watch_settings")) {
                                obj = 3;
                                break;
                            }
                            break;
                        case 379524292:
                            if (b.equals("weather_app_forecast")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case 437640679:
                            if (b.equals("watch_apps_data")) {
                                obj = 7;
                                break;
                            }
                            break;
                        case 615415609:
                            if (b.equals("locker_apps")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 860878076:
                            if (b.equals("health_stats")) {
                                obj = 8;
                                break;
                            }
                            break;
                        case 905838160:
                            if (b.equals("canned_responses")) {
                                obj = 4;
                                break;
                            }
                            break;
                        case 970533442:
                            if (b.equals("timeline_items")) {
                                obj = null;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            i2 = p();
                            break;
                        case 1:
                            i = o();
                            i13 = z();
                            break;
                        case 2:
                            i3 = q();
                            break;
                        case 3:
                            i4 = r();
                            break;
                        case 4:
                            i5 = n();
                            break;
                        case 5:
                        case 6:
                            i6 = t();
                            break;
                        case 7:
                            i7 = s();
                            break;
                        case 8:
                            i11 = y();
                            i8 = u();
                            i9 = v();
                            i10 = w();
                            i12 = x();
                            break;
                        case 9:
                            i13 = z();
                            break;
                        default:
                            break;
                    }
                } catch (Throwable e) {
                    f.a("BlobDbEndpoint", "handleContentObserverChange: Unsupported URI", e);
                    return;
                }
            }
            f.d("BlobDbEndpoint", String.format(Locale.US, "handleContentObserverChange: uri=%s, enqueued records; locker=%d,timeline=%d,weatherApp=%d,watchSettings=%d,cannedResponses=%d,contacts=%d,watchApps=%d,movementData=%d,sleepData=%d,averageDailySteps=%d,typicalSteps=%d,averageSleepDuration=%d,appGlances=%d,", new Object[]{uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)}));
            A();
            return;
        }
        this.w = true;
        f.e("BlobDbEndpoint", "handleContentObserverChange: not enqueueing more records while send queue is non-empty (uri=" + uri + ")");
    }

    private void m() {
        if (this.w) {
            a(null);
        }
    }

    private int n() {
        Collection a = p.a(c());
        a(a);
        return a.size();
    }

    private int o() {
        Collection e = am.e(c());
        a(e);
        return e.size();
    }

    private int p() {
        Collection a;
        long currentTimeMillis = System.currentTimeMillis();
        Collection a2 = aw.a(c(), this.e, currentTimeMillis, 40);
        Set a3 = bt.a(this.s, this.t);
        int size = 40 - a2.size();
        if (size > 0) {
            a = aw.a(c(), this.e, currentTimeMillis, a3, size);
        } else {
            f.d("BlobDbEndpoint", "enqueueDirtyTimelineRecords: Not querying for timeline records to add, because limit used up by records to remove");
            a = new ArrayList();
        }
        a(a2);
        a(a);
        return a.size() + a2.size();
    }

    private int q() {
        if (this.t.contains(com.getpebble.android.framework.l.b.j.b.WEATHER_APP)) {
            return 0;
        }
        Collection a = bc.a(c());
        a(a);
        return a.size();
    }

    private int r() {
        Collection a = ba.a(c());
        a(a);
        return a.size();
    }

    private int s() {
        Collection b = az.b(c());
        a(b);
        return b.size();
    }

    private int t() {
        Collection a = s.a(c());
        a(a);
        return a.size();
    }

    private int u() {
        Collection a = r.a(c(), com.getpebble.android.common.model.a.v.class, this.f);
        a(a);
        return a.size();
    }

    private int v() {
        Collection a = r.a(c(), x.class, this.f);
        a(a);
        return a.size();
    }

    private int w() {
        Collection a = r.a(c(), com.getpebble.android.common.model.a.j.class, this.f);
        a(a);
        return a.size();
    }

    private int x() {
        Collection a = r.a(c(), com.getpebble.android.common.model.a.k.class, this.f);
        a(a);
        return a.size();
    }

    private int y() {
        Collection a = r.a(c(), y.class, this.f);
        a(a);
        return a.size();
    }

    private int z() {
        Collection c = d.c(c());
        a(c);
        return c.size();
    }

    private void A() {
        a(new Runnable(this) {
            final /* synthetic */ e a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.B();
            }
        });
    }

    private void B() {
        Throwable e;
        if (D()) {
            f.d("BlobDbEndpoint", "send: A record is already in-flight; not about to send another one.");
            return;
        }
        b bVar = (b) this.q.peek();
        if (bVar == null) {
            C();
            m();
            return;
        }
        boolean b = bVar.b(this.e);
        if (this.s.contains(bVar.e()) && !b) {
            f.d("BlobDbEndpoint", "send: Not sending record " + com.getpebble.android.bluetooth.b.b.c(bVar.c()) + " because the database is full on the watch");
            a(false);
            A();
        } else if (this.t.contains(bVar.e())) {
            f.d("BlobDbEndpoint", "send: Not sending record " + com.getpebble.android.bluetooth.b.b.c(bVar.c()) + " because the database is invalid on the watch");
            a(false);
            A();
        } else {
            boolean a = bVar.a(this.e);
            if (a || b) {
                byte[] b2 = com.getpebble.android.bluetooth.b.b.b();
                byte[] c = bVar.c();
                com.getpebble.android.framework.l.b.j.b e2 = bVar.e();
                if (e2 == null) {
                    f.a("BlobDbEndpoint", "send: Null item type");
                    a(false);
                    A();
                    return;
                }
                com.getpebble.android.framework.l.b.r rVar = null;
                if (a) {
                    f.d("BlobDbEndpoint", "send: Sending insert for " + com.getpebble.android.bluetooth.b.b.c(bVar.c()) + " / " + bVar.getClass().getSimpleName() + " with record ID " + bVar.e() + " token = " + com.getpebble.android.bluetooth.b.b.d(b2));
                    try {
                        rVar = j.a(b2, e2, c, bVar.a(this.e, this.g, this.h));
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        f.a("BlobDbEndpoint", "send: Failed to serialize: " + bVar.toString(), e);
                        a(false);
                        A();
                        return;
                    } catch (NullPointerException e4) {
                        e = e4;
                        f.a("BlobDbEndpoint", "send: Failed to serialize: " + bVar.toString(), e);
                        a(false);
                        A();
                        return;
                    }
                } else if (b) {
                    f.d("BlobDbEndpoint", "send: Sending delete for " + com.getpebble.android.bluetooth.b.b.c(bVar.c()) + " / " + bVar.getClass().getSimpleName() + " with record ID " + bVar.e() + " token = " + com.getpebble.android.bluetooth.b.b.d(b2));
                    rVar = j.a(b2, e2, c);
                }
                if (this.d.a(rVar)) {
                    this.u = new Pair(b2, bVar);
                    this.l.postDelayed(this.y, 25000);
                    return;
                }
                f.a("BlobDbEndpoint", "send: Failed to send message");
                this.q.clear();
                return;
            }
            f.d("BlobDbEndpoint", "send: Record needs neither add nor delete: " + com.getpebble.android.bluetooth.b.b.c(bVar.c()));
            a(false);
            A();
        }
    }

    void d() {
        this.l.removeCallbacks(this.y);
    }

    private void a(boolean z) {
        f.e("BlobDbEndpoint", "clearHead()");
        Pair pair = this.u;
        this.u = null;
        this.x = 0;
        if (!this.q.isEmpty()) {
            b bVar = (b) this.q.peek();
            int i = (pair == null || !Arrays.equals(bVar.c(), ((b) pair.second).c())) ? 0 : 1;
            if (i == 0) {
                f.d("BlobDbEndpoint", "clearHead: Head of queue does not match in flight record.");
            }
            this.q.poll();
            f.e("BlobDbEndpoint", "clearHead: Removed enqueued record; size is now " + this.q.size());
            if (!bVar.a(c(), z, this.e)) {
                f.a("BlobDbEndpoint", "clearHead: Record was not updated in database. Record may have been modified during sync process.");
            }
        }
    }

    private void C() {
        if (this.p) {
            this.p = false;
            f.d("BlobDbEndpoint", "sendOrderIfRequired: Initial sync to device complete; sending app order");
            a(new k(com.getpebble.android.bluetooth.g.a.APP_REORDER, com.getpebble.android.framework.g.k.a.SEND_APP_ORDER));
            am.c g = am.g(this.c.getContentResolver());
            if (g == null) {
                f.d("BlobDbEndpoint", "sendOrderIfRequired: No default watchface; not setting");
            } else {
                a(g.b);
            }
        }
    }

    private boolean D() {
        return this.u != null;
    }

    void a(Runnable runnable) {
        if (this.l == null) {
            f.b("BlobDbEndpoint", "runOnHandler() handler is null");
        } else {
            this.l.post(runnable);
        }
    }

    private void a(Collection<b> collection) {
        for (Object obj : collection) {
            if (this.s.contains(obj.e()) && !obj.b(this.e)) {
                f.c("BlobDbEndpoint", "enqueue: Not enqueuing record for full db: " + com.getpebble.android.bluetooth.b.b.c(obj.c()));
            } else if (this.t.contains(obj.e())) {
                f.c("BlobDbEndpoint", "enqueue: Not enqueuing record for invalid db: " + com.getpebble.android.bluetooth.b.b.c(obj.c()));
            } else {
                if (this.v.containsKey(ByteBuffer.wrap(obj.c()))) {
                    Integer num = (Integer) this.v.get(ByteBuffer.wrap(obj.c()));
                    if (num != null) {
                        if (num.equals(obj.d())) {
                            f.c("BlobDbEndpoint", "enqueue: Not enqueuing record with known bad data UUID: " + com.getpebble.android.bluetooth.b.b.c(obj.c()));
                        } else {
                            this.v.remove(ByteBuffer.wrap(obj.c()));
                        }
                    }
                }
                Iterator it = this.q.iterator();
                int i = 1;
                while (it.hasNext()) {
                    int i2;
                    b bVar = (b) it.next();
                    if (!Arrays.equals(bVar.c(), obj.c())) {
                        i2 = i;
                    } else if (com.getpebble.android.common.b.b.a.a(bVar.d(), obj.d())) {
                        i2 = 0;
                    } else {
                        byte[] bArr = null;
                        if (this.u != null) {
                            bArr = ((b) this.u.second).c();
                        }
                        if (!Arrays.equals(bVar.c(), bArr)) {
                            f.d("BlobDbEndpoint", "enqueue: Removing stale hashcode record from queue with uuid " + com.getpebble.android.bluetooth.b.b.c(bVar.c()));
                            it.remove();
                        }
                        i2 = i;
                    }
                    i = i2;
                }
                if (i != 0 && this.q.add(obj)) {
                    f.e("BlobDbEndpoint", String.format("enqueue: Enqueued record (%s); queue size now %d; record uuid=%s", new Object[]{com.getpebble.android.common.b.b.a.a(obj), Integer.valueOf(this.q.size()), com.getpebble.android.bluetooth.b.b.c(obj.c())}));
                }
            }
        }
    }

    a e() {
        return this.j;
    }

    g f() {
        return this.k;
    }

    private void E() {
        f.e("BlobDbEndpoint", "updateHealthMovementDataStatsAsync()");
        TaskService.a(new com.google.android.gms.gcm.OneoffTask.a().a(TaskService.class).a("health-update-movementData-all-once").a(0, 30).a(2).b());
    }
}
