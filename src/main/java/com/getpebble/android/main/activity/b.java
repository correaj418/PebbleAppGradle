package com.getpebble.android.main.activity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.connection.ConnectionManagerFragment;
import com.getpebble.android.framework.e.f.a;

public abstract class b extends a {
    private LinearLayout a;
    private Handler b = new Handler(Looper.getMainLooper());
    private OnClickListener c = new OnClickListener(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public void onClick(View view) {
            this.a.startActivity(new Intent(this.a, ConnectionManagerActivity.class));
        }
    };
    private a d = new a(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public void e_() {
            this.a.b.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.a.g();
                }
            });
        }
    };

    protected void g() {
        int i;
        Fragment c = c();
        if ((c == null || !c.getClass().equals(ConnectionManagerFragment.class)) && PebbleApplication.r() == null) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.a == null) {
            return;
        }
        if (i != 0) {
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.a == null) {
            this.a = (LinearLayout) findViewById(R.id.tap_to_connect_bottom_bar);
            if (VERSION.SDK_INT >= 21) {
                this.a.setElevation(getResources().getDimension(R.dimen.tap_to_connect_elevation));
            }
            this.a.setOnClickListener(this.c);
        }
        g();
        PebbleApplication.a(this.d);
    }

    public void onPause() {
        super.onPause();
        PebbleApplication.b(this.d);
    }

    public void onDestroy() {
        if (this.a != null) {
            this.a.removeAllViews();
            this.a.setOnClickListener(null);
            this.a = null;
        }
        this.c = null;
        this.d = null;
        super.onDestroy();
    }
}
