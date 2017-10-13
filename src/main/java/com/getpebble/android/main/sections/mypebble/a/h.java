package com.getpebble.android.main.sections.mypebble.a;

import android.app.Activity;
import android.content.ContentResolver;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.b.n;
import com.getpebble.android.common.framework.install.app.b.a;
import com.getpebble.android.common.framework.widget.AsyncImageView;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.am.b;
import com.getpebble.android.common.model.am.c;
import com.getpebble.android.common.model.am.e;
import com.getpebble.android.main.sections.mypebble.fragment.d;

public class h {
    protected c a;
    protected boolean b;
    protected boolean c;

    public h(c cVar, boolean z) {
        boolean z2 = false;
        this.a = cVar;
        this.b = z;
        a a = a();
        if (a == null) {
            this.c = false;
            return;
        }
        if (this.a.F || this.a.H.b(a)) {
            z2 = true;
        }
        this.c = z2;
    }

    private a a() {
        ak.a p = PebbleApplication.p();
        if (p == null) {
            return null;
        }
        return p.hwPlatform.getPlatformCode();
    }

    public void a(TextView textView) {
        textView.setText(this.a.c);
    }

    public void b(TextView textView) {
        textView.setText(this.a.i);
    }

    public void a(View view, final Activity activity) {
        int i = (this.a.x && this.b && (this.a.F || this.c)) ? 1 : 0;
        if (i != 0) {
            view.setVisibility(0);
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ h b;

                public void onClick(View view) {
                    this.b.a(activity);
                }
            });
            return;
        }
        view.setVisibility(4);
    }

    protected void a(Activity activity) {
        d.a(activity, this.a);
    }

    public void a(View view) {
        if (this.a.x && this.c && this.b && this.a.h() && !this.a.G) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void a(AsyncImageView asyncImageView) {
        Object obj;
        b.a aVar = null;
        a a = a();
        if (!(this.a.F || a == null)) {
            aVar = this.a.H.a(a);
        }
        int i = R.drawable.watchface_placeholder_icon_square;
        if (this.a.F) {
            int i2;
            am.d fromRecord = am.d.fromRecord(this.a);
            if (fromRecord == null) {
                f.b("LockerAppViewBinder", "AppViewHolder: bindType: SystemApp is null for " + this.a.b);
                i2 = R.drawable.watchface_placeholder_icon_square;
            } else {
                ak.a p = PebbleApplication.p();
                i2 = p != null ? fromRecord.getIcon(p.color) : R.drawable.watchface_placeholder_icon_square;
            }
            i = i2;
            obj = null;
        } else {
            b.a a2;
            if (aVar == null || !this.c) {
                a2 = am.a(this.a);
            } else {
                a2 = aVar;
            }
            if (a2 != null) {
                Object a3 = a(a2);
                if (!TextUtils.isEmpty(a3)) {
                    obj = 1;
                    asyncImageView.a(a3, a(a, 10), a2);
                    if (this.c) {
                        asyncImageView.setAlpha(1.0f);
                    } else {
                        asyncImageView.setAlpha(0.4f);
                    }
                }
            }
            obj = null;
        }
        if (obj == null) {
            asyncImageView.a(i, a(a, 15));
            asyncImageView.setAlpha(1.0f);
        }
    }

    protected String a(b.a aVar) {
        if (this.a.d == e.WATCHFACE) {
            return aVar.g;
        }
        return aVar.a();
    }

    protected n.b a(a aVar, int i) {
        if (this.a.d != e.WATCHFACE || aVar == null) {
            return new n.c(i);
        }
        return n.a(aVar.getShape(), this.c, i);
    }

    public static void a(final c cVar, final ContentResolver contentResolver, final boolean z, final boolean z2) {
        new com.getpebble.android.bluetooth.b.f() {
            private final String e = "AppsAdapter";

            public boolean doInBackground() {
                boolean a;
                if (z) {
                    a = am.a(com.getpebble.android.common.a.K().getContentResolver(), cVar);
                } else {
                    a = false;
                }
                am.a(cVar.b, contentResolver);
                if (a || z2) {
                    f.d("AppsAdapter", "setActiveWatchfaceAsync() Doing delayed start after blob sync for " + cVar.b);
                    PebbleApplication.x().a(cVar.b);
                    am.a(cVar.b, 0, com.getpebble.android.common.a.K().getContentResolver());
                    am.a(contentResolver, cVar.d);
                    PebbleApplication.x().c(cVar.b);
                } else {
                    f.d("AppsAdapter", "setActiveWatchfaceAsync() Sending start request for " + cVar.b);
                    PebbleApplication.x().a(cVar.b);
                }
                return false;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }
}
