package com.getpebble.android.notifications.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.getpebble.android.common.a;
import java.util.concurrent.TimeUnit;

public class d {
    private static final long a = TimeUnit.MINUTES.toMillis(2);
    private final Handler b = new Handler();
    private final Intent c;
    private boolean d = false;
    private final Runnable e = new Runnable(this) {
        final /* synthetic */ d a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.b();
        }
    };
    private final Runnable f = new Runnable(this) {
        final /* synthetic */ d a;

        {
            this.a = r1;
        }

        public void run() {
            if (f.a(a.K())) {
                this.a.b();
                this.a.c();
                return;
            }
            this.a.b.postDelayed(this.a.f, 200);
        }
    };

    public d(Class<? extends Activity> cls) {
        this.c = new Intent(a.K(), cls);
        this.c.setFlags(335675392);
    }

    public void a() {
        this.b.postDelayed(this.e, a);
        this.b.post(this.f);
        this.d = true;
    }

    public void b() {
        if (this.d) {
            this.b.removeCallbacksAndMessages(null);
            this.d = false;
        }
    }

    private void c() {
        a.K().startActivity(this.c);
    }
}
