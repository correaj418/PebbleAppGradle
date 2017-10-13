package com.getpebble.android.h;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.a.g;
import com.getpebble.android.common.b.a.e;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.b.b.c.a;
import com.getpebble.android.framework.timeline.TimelineWebSyncService;
import com.getpebble.android.main.fragment.a.b;
import java.util.List;

public class j {
    private Intent a;
    private Context b;
    private Uri c;
    private String d;
    private Bundle e;
    private b f;
    private boolean g;

    public j(Intent intent, Context context) {
        this.a = intent;
        this.b = context;
        g();
        f.d("DeepLink", "DeepLink() mDeepLinkType = " + this.d);
    }

    private void g() {
        if (this.a != null) {
            this.c = this.a.getData();
            if (this.c != null && "pebble".equals(this.c.getScheme())) {
                this.d = this.c.getHost();
                if (this.c.getHost().equals("support-email") || this.c.getHost().equals("support-email-nologs") || this.c.getHost().equals("skip-onboarding")) {
                    this.g = true;
                }
            }
        }
    }

    public void a() {
        if (b() && !c()) {
            String replaceFirst;
            if (this.d.equals("custom-boot-config-url")) {
                replaceFirst = this.c.getPath().replaceFirst("/", "");
                if ("offline".equalsIgnoreCase(replaceFirst)) {
                    f.b("DeepLink", "Using offline bootconfig!");
                    replaceFirst = "offline_boot_config.json";
                } else if ("default".equalsIgnoreCase(replaceFirst)) {
                    f.b("DeepLink", "Using default bootconfig!");
                    replaceFirst = "https://boot.getpebble.com/api/config";
                }
                f.b("DeepLink", "Setting BootConfig url to " + replaceFirst);
                PebbleApplication.u().e();
                PebbleApplication.y().b(a.BOOT_CONFIG_BASE_URL, replaceFirst);
                com.getpebble.android.config.b.a(this.b, new Runnable(this) {
                    final /* synthetic */ j b;

                    public void run() {
                        TimelineWebSyncService.a(this.b.b);
                        new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                Toast.makeText(this.a.b.b, "New boot URL: " + replaceFirst, 1).show();
                            }
                        });
                    }
                }, true);
            } else if (this.d.equals("enable-verbose-logging")) {
                e.a(true);
            } else if (!this.d.equals("skip-onboarding")) {
                if (this.d.equals("hex-dump")) {
                    replaceFirst = this.c.getPath();
                    c cVar = new c(com.getpebble.android.common.a.K());
                    if ("/on".equals(replaceFirst)) {
                        f.b("DeepLink", "Setting hex-dump to enabled");
                        cVar.b(a.HEX_DUMP, true);
                    } else if ("/off".equals(replaceFirst)) {
                        f.b("DeepLink", "Setting hex-dump to disabled");
                        cVar.b(a.HEX_DUMP, false);
                    } else {
                        f.b("DeepLink", "Unknown param for HEX_DUMP: '" + replaceFirst + "'");
                    }
                } else if (!this.d.equals("webview-debug")) {
                }
            }
        }
    }

    public boolean b() {
        return this.d != null;
    }

    public boolean c() {
        if (!b()) {
            return false;
        }
        if (this.d.equals("appstore") || this.d.equals("support-email") || this.d.equals("support-email-nologs")) {
            return true;
        }
        return false;
    }

    public b d() {
        if (this.f == null) {
            h();
        }
        return this.f;
    }

    public Bundle e() {
        if (this.e == null) {
            h();
        }
        return this.e;
    }

    private void h() {
        if (c()) {
            if (this.d.equals("appstore")) {
                List pathSegments = this.c.getPathSegments();
                if (pathSegments.size() < 1) {
                    f.b("DeepLink", "No appstore app_id found.");
                    return;
                }
                String str = (String) pathSegments.get(0);
                this.e = new Bundle();
                this.e.putInt("extra_store_type", com.getpebble.android.main.sections.appstore.a.a.a.APPLICATION.ordinal());
                this.e.putString("extra_page_id", str);
                this.f = b.APP_STORE_APPLICATION;
                com.getpebble.android.common.b.a.a.e.a(str);
            }
            if (this.d.equals("support-email") || this.d.equals("support-email-nologs")) {
                boolean equals = this.d.equals("support-email");
                this.e = new Bundle();
                this.e.putBoolean("support_email_request", true);
                this.e.putBoolean("include_logs", equals);
                this.f = b.SUPPORT;
                if (equals) {
                    g.g();
                } else {
                    g.h();
                }
            }
        }
    }

    public boolean f() {
        return this.g;
    }
}
