package com.getpebble.android.g.a;

import a.a.a.a;
import a.a.a.b;
import android.content.Context;
import android.util.Base64;
import com.google.b.f;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class c extends a {
    private static c d;
    private static final long i = TimeUnit.SECONDS.toMillis(35);
    private b b;
    private f c;
    private short e;
    private PipedInputStream f;
    private PipedOutputStream g;
    private a h;
    private final Runnable j;

    public static c a(Context context, f fVar) {
        if (d == null) {
            d = new c(context, fVar);
        }
        return d;
    }

    private c(Context context, f fVar) {
        this.h = new a(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void a(ArrayList<a.a.a.a.a> arrayList, String str, Error error) {
                a.a.a.a.a aVar = null;
                this.a.a().removeCallbacks(this.a.j);
                a.b b = this.a.b();
                if (b != a.b.WAITING_RESULT) {
                    com.getpebble.android.common.b.a.f.b(this.a.a, "witDidGraspIntent: not expecting a result because state " + b);
                } else if (error != null) {
                    com.getpebble.android.common.b.a.f.b(this.a.a, "witDidGraspIntent: error = " + error.getMessage());
                    this.a.a(this.a.e, a.a.INVALID_RESULT, error.getMessage());
                } else if (arrayList.size() == 0) {
                    com.getpebble.android.common.b.a.f.b(this.a.a, "witDidGraspIntent: no WitOutcome");
                    this.a.a(this.a.e, a.a.SERVER_ERROR, null);
                } else {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a.a.a.a.a aVar2 = (a.a.a.a.a) it.next();
                        if (aVar != null && aVar2.a() <= aVar.a()) {
                            aVar2 = aVar;
                        }
                        aVar = aVar2;
                    }
                    this.a.a(this.a.e, new b(aVar, this.a.c));
                }
            }

            public String a() {
                return UUID.randomUUID().toString();
            }
        };
        this.j = new Runnable(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void run() {
                com.getpebble.android.common.b.a.f.a(this.a.a, "WAITING_RESULT_TIMEOUT_RUNNABLE: session timeout");
                this.a.a(this.a.e, a.a.TIMEOUT, null);
            }
        };
        this.a = "WitManager";
        this.b = new b(new String(Base64.decode("VUJQRkZHSUFGVzVZV0JZN0lNNTQyVktPS09LQ0U0REo=", 0)), this.h);
        this.b.a(context);
        this.c = fVar;
    }

    public boolean a(short s, final String str) {
        a.b b = b();
        if (b != a.b.IDLE) {
            a(s, a.a.BUSY, null);
            com.getpebble.android.common.b.a.f.b(this.a, "startAudioProcessing: manager is in state " + b);
            return false;
        }
        a(a.b.PROCESSING);
        this.e = s;
        a().post(new Runnable(this) {
            final /* synthetic */ c b;

            public void run() {
                this.b.b.a(str);
                this.b.a(a.b.WAITING_RESULT);
                this.b.a().postDelayed(this.b.j, c.i);
            }
        });
        return true;
    }

    protected void a(a.b bVar) {
        super.a(bVar);
        if (bVar == a.b.IDLE) {
            try {
                if (this.g != null) {
                    this.g.close();
                }
            } catch (Throwable e) {
                com.getpebble.android.common.b.a.f.a(this.a, "error", e);
            }
            try {
                if (this.f != null) {
                    this.f.close();
                }
            } catch (Throwable e2) {
                com.getpebble.android.common.b.a.f.a(this.a, "error", e2);
            }
            this.e = (short) -1;
        }
    }
}
