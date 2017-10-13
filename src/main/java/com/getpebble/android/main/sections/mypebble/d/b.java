package com.getpebble.android.main.sections.mypebble.d;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.format.DateFormat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.h.q;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class b {
    private Handler a;
    private c.b.a.b b = null;
    private final WebView c;
    private final c d;
    private a e = null;

    public interface a {
        void a();

        void a(String str);

        void b();

        void c();
    }

    public enum b {
        DAY("day", 0),
        WEEK("week", 1),
        MONTH("month", 2);
        
        public final int index;
        public final String key;

        private b(String str, int i) {
            this.key = str;
            this.index = i;
        }

        public static b fromIndex(int i) {
            for (b bVar : values()) {
                if (bVar.index == i || bVar.index == i) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public enum c {
        SLEEP("sleep", "sleep-chart-data.json", R.color.health_sleep_header),
        ACTIVITY("activity", "activity-chart-data.json", R.color.health_activity_header),
        HEART_RATE("heartRate", "heart-chart-data.json", R.color.health_heart_rate_header);
        
        public final String debugJsonDumpFilePath;
        public final String key;
        private final int webviewBackgroundColorResId;

        private c(String str, String str2, int i) {
            this.key = str;
            this.debugJsonDumpFilePath = str2;
            this.webviewBackgroundColorResId = i;
        }
    }

    public b(WebView webView, c cVar) {
        this.c = webView;
        this.d = cVar;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public b a() {
        this.c.setWebViewClient(new WebViewClient(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                f.e("HealthChart", "shouldOverrideUrlLoading(" + str + ")");
                if (a(str)) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            private boolean a(String str) {
                Uri parse = Uri.parse(str);
                if ("bridge".equals(parse.getScheme())) {
                    f.e("HealthChart", "Got callback from JS: " + str);
                    if ("ready".equals(parse.getAuthority())) {
                        if (this.a.e != null) {
                            this.a.e.a();
                        }
                        return true;
                    } else if ("query".equals(parse.getAuthority())) {
                        String str2 = "";
                        try {
                            str2 = parse.getQueryParameter("query");
                        } catch (Throwable e) {
                            f.d("HealthChart", "Failed to decode query", e);
                        }
                        f.e("HealthChart", "Got query signal: " + str2);
                        if (this.a.e != null) {
                            this.a.e.a(str2);
                        }
                        return true;
                    } else {
                        f.d("HealthChart", "Unknown authority: " + parse.getAuthority());
                    }
                }
                return false;
            }
        });
        this.a = new Handler(Looper.getMainLooper());
        this.c.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        if (this.a.e != null) {
                            this.a.e.b();
                        }
                        this.a.a.removeCallbacksAndMessages(null);
                        this.a.a.postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                ViewParent parent = this.a.a.c.getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }, 200);
                        break;
                    case 1:
                    case 3:
                        if (this.a.e != null) {
                            this.a.e.c();
                        }
                        this.a.a.removeCallbacksAndMessages(null);
                        this.a.a.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                ViewParent parent = this.a.a.c.getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(false);
                                }
                            }
                        });
                        break;
                }
                return false;
            }
        });
        this.c.getSettings().setJavaScriptEnabled(true);
        this.c.setBackgroundColor(this.c.getResources().getColor(this.d.webviewBackgroundColorResId));
        return this;
    }

    public b a(b bVar, a aVar) {
        this.e = aVar;
        boolean a = PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.DISTANCE_UNIT, false);
        Locale b = q.b();
        char decimalSeparator = new DecimalFormatSymbols(b).getDecimalSeparator();
        String str = f() + "kind=" + this.d.key + "&range=" + bVar.key + "&locale=" + q.b().getLanguage() + "&measurementSystem=" + (a ? "imperial" : "metric") + "&decimalDelimeter=" + decimalSeparator + "&firstWeekday=" + (Calendar.getInstance(b).getFirstDayOfWeek() - 1) + "&hourFormat=" + (DateFormat.is24HourFormat(com.getpebble.android.common.a.K()) ? "24" : "12");
        f.d("HealthChart", "Loading Chart: " + str);
        this.c.loadUrl(str);
        return this;
    }

    private String f() {
        return h();
    }

    private String g() {
        return com.getpebble.android.common.a.K().getString(R.string.master_charts_url);
    }

    private String h() {
        return "file:///android_asset/chart.html?";
    }

    private void a(String str) {
        if ((VERSION.SDK_INT <= 18 ? 1 : null) != null) {
            str = b(str);
        }
        this.c.loadUrl("javascript:(" + str + ");");
    }

    private String b(String str) {
        return "setTimeout(function() {" + str + "}, 1)";
    }

    public void a(c cVar) {
        String b = cVar.b();
        c("loadData: " + cVar.a() + ", length: " + b.length());
        b(cVar);
        a("Chart.draw(" + b + ")");
        this.b = c.b.a.b.a();
    }

    private void b(c cVar) {
    }

    public void b() {
        a("Chart.seek()");
    }

    public void c() {
        try {
            this.c.pauseTimers();
        } catch (Throwable e) {
            f.b("HealthChart", "Exception when attempting to pause WV timers", e);
        }
    }

    public void d() {
        try {
            this.c.resumeTimers();
        } catch (Throwable e) {
            f.b("HealthChart", "Exception when attempting to resume WV timers", e);
        }
        int i = c.b.a.b.a().i();
        if ((this.b == null ? i : this.b.i()) != i) {
            b();
        }
    }

    public void e() {
        f.e("HealthChart", "destroy()");
        this.a.removeCallbacksAndMessages(null);
        this.c.stopLoading();
        this.c.clearAnimation();
        this.c.destroy();
        this.c.setWebViewClient(null);
        this.e = null;
    }

    private void c(String str) {
        f.d("HealthChart", String.format(Locale.US, "[%s] %s", new Object[]{this.d.key, str}));
    }
}
