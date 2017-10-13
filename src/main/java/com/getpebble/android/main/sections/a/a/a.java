package com.getpebble.android.main.sections.a.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.u;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.b.n;
import com.getpebble.android.common.framework.widget.AsyncImageView;
import com.getpebble.android.common.model.g;
import com.getpebble.android.main.sections.a.b.c;
import com.getpebble.android.main.sections.mypebble.c.b;
import java.util.UUID;

public class a implements d {
    private g a;
    private a b;
    private long c;
    private boolean d = false;
    private Context e;

    public interface a {
        void a(a aVar, g gVar);

        void b(a aVar, g gVar);

        void c(a aVar, g gVar);
    }

    public a(g gVar, a aVar, Context context) {
        this.a = gVar;
        this.b = aVar;
        this.c = a(gVar);
        this.e = context;
    }

    private static long a(g gVar) {
        if (TextUtils.isEmpty(gVar.getUUID())) {
            return (long) gVar.getId().hashCode();
        }
        return (long) UUID.fromString(gVar.getUUID()).hashCode();
    }

    public void a(u uVar) {
        if (this.a.h()) {
            a((c) uVar);
        } else {
            a((com.getpebble.android.main.sections.a.b.a) uVar);
        }
        uVar.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.b.a(this.a, this.a.a);
            }
        });
    }

    private void a(c cVar) {
        if (cVar != null) {
            com.getpebble.android.common.framework.install.app.b.a platformCode = PebbleApplication.p().hwPlatform.getPlatformCode();
            cVar.l.setAlpha(1.0f);
            String[] e = this.a.e();
            if (e == null || e.length <= 0) {
                f.c("AppStoreSearchResult", "bindAsWatchface: no screenshot; defaulting");
                cVar.l.setImageResource(AsyncImageView.a(platformCode.getShape()));
            } else {
                cVar.l.a(e[0], n.a(platformCode.getShape(), true, 10), null);
            }
            if (this.d) {
                c(cVar.m);
            } else {
                a(cVar.m);
            }
        }
    }

    private void a(com.getpebble.android.main.sections.a.b.a aVar) {
        if (aVar != null) {
            aVar.m.setText(this.a.getTitle());
            aVar.n.setText(this.a.a());
            aVar.l.setAlpha(1.0f);
            aVar.l.a(this.a.d(), new n.c(10), null);
            if (this.d) {
                c(aVar.o);
            } else {
                a(aVar.o);
            }
        }
    }

    private void a(final TextView textView) {
        textView.setEnabled(true);
        textView.setBackgroundResource(R.drawable.btn_orange_support);
        if (this.a.g()) {
            textView.setText(R.string.app_store_get);
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a b;

                public void onClick(View view) {
                    com.getpebble.android.common.b.a.a.c.e("SearchAdd", "MyPebble");
                    textView.setEnabled(false);
                    this.b.b.c(this.b, this.b.a);
                }
            });
            return;
        }
        textView.setText(R.string.onboarding_grab_apps_add_btn);
        textView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a b;

            public void onClick(View view) {
                com.getpebble.android.common.b.a.a.c.e("SearchAdd", "MyPebble");
                if (this.b.a.i()) {
                    new b(this.b.e, this.b.a, new com.getpebble.android.main.sections.mypebble.c.b.a(this) {
                        final /* synthetic */ AnonymousClass3 a;

                        {
                            this.a = r1;
                        }

                        public void a(g gVar) {
                            this.a.b.b(textView);
                        }
                    }).show();
                } else {
                    this.b.b(textView);
                }
            }
        });
    }

    private void b(TextView textView) {
        this.d = true;
        c(textView);
        this.b.b(this, this.a);
    }

    private void c(TextView textView) {
        textView.setEnabled(false);
        textView.setOnClickListener(null);
        textView.setOnClickListener(null);
        textView.setText(R.string.onboarding_grab_apps_added_btn);
        textView.setBackgroundResource(R.drawable.btn_green_selected);
    }

    public String a() {
        return this.a.getUUID() != null ? UUID.fromString(this.a.getUUID()).toString() : this.a.f();
    }

    public void b() {
        this.d = true;
    }

    public g c() {
        return this.a;
    }

    public long d() {
        return this.c;
    }
}
