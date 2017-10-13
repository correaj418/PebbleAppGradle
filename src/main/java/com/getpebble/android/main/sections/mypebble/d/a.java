package com.getpebble.android.main.sections.mypebble.d;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.main.sections.mypebble.d.b.c;
import java.util.Locale;

public abstract class a implements com.getpebble.android.main.sections.mypebble.d.i.a {
    private final g a;
    public final c b;
    protected WebView c;
    protected b d;
    protected TextView e;
    protected i f;
    final com.getpebble.android.main.sections.mypebble.d.b.a g = new com.getpebble.android.main.sections.mypebble.d.b.a(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public void a() {
            f.d("HealthCard", this.a.b + ": chart ready");
            this.a.d.b();
        }

        public void a(String str) {
            this.a.a.a(this.a.b, this.a.f.c, str);
        }

        public void b() {
            this.a.h.a();
        }

        public void c() {
            this.a.h.b();
        }
    };
    private final a h;
    private boolean i = false;

    public interface a {
        void a();

        void b();
    }

    public abstract void a(Activity activity, View view);

    public a(c cVar, g gVar, a aVar) {
        this.b = cVar;
        this.a = gVar;
        this.h = aVar;
    }

    public void a() {
        this.d.a(this.f.c, this.g);
    }

    void b() {
        a("showNoData");
        this.c.setVisibility(8);
        this.f.a();
        this.e.setVisibility(0);
    }

    void c() {
        a("showChart");
        this.c.setVisibility(0);
        this.f.b();
        this.e.setVisibility(8);
    }

    public void d() {
        if (this.d != null) {
            this.d.d();
        }
        this.f.c();
    }

    public void e() {
        if (this.d != null) {
            this.d.c();
        }
    }

    public void a(c cVar) {
        if (this.c == null) {
            a("load: no web view");
            return;
        }
        if ((this.c.getVisibility() == 8 ? 1 : null) != null) {
            f.e("HealthCard", "load: isChartGone");
            if (cVar == null) {
                a("load: chart == GONE, data == null, not showing");
            } else if (cVar.a()) {
                c();
                this.d.b();
            } else {
                a("load: chart == GONE, !data.isDataAvailable, not showing");
            }
        } else if (cVar == null) {
        } else {
            if (cVar.a()) {
                a("load: chart != GONE, data.isDataAvailable == true, loading data");
                this.d.a(cVar);
                return;
            }
            a("load: chart != GONE, data.isDataAvailable == false, showing no data");
            b();
        }
    }

    public void f() {
        f.e("HealthCard", "createChart()");
        this.d = new b(this.c, this.b).a().a(this.f.c, this.g);
    }

    public void g() {
        if (this.d != null) {
            this.d.e();
            this.d = null;
        }
        this.c = null;
        this.e = null;
        this.f = null;
    }

    public void a(boolean z) {
        if (z != this.i) {
            if (this.c == null) {
                f.e("HealthCard", "wrapContent: webview is null");
                return;
            }
            LayoutParams layoutParams = this.c.getLayoutParams();
            if (layoutParams == null) {
                f.e("HealthCard", "wrapContent: layout params are null");
                return;
            }
            Resources resources = this.c.getContext().getResources();
            if (resources == null) {
                f.e("HealthCard", "wrapContent: null resources");
                return;
            }
            if (z) {
                layoutParams.height = -2;
            } else {
                layoutParams.height = resources.getDimensionPixelSize(R.dimen.health_tab_webview_height);
            }
            this.c.setLayoutParams(layoutParams);
            this.i = z;
        }
    }

    private void a(String str) {
        f.d("HealthCard", String.format(Locale.US, "[%s] %s", new Object[]{this.b.key, str}));
    }
}
