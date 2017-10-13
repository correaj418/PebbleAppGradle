package com.getpebble.android.framework.health;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.getpebble.android.basalt.R;
import com.getpebble.android.framework.health.g.a.b;
import com.getpebble.android.main.sections.mypebble.c.c;
import com.getpebble.android.main.sections.mypebble.c.d;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

public class a {
    private final String[] a;
    private final Map<Integer, String> b;
    private final a c;
    private final WeakReference<Context> d;

    public interface a {
        void a(com.getpebble.android.common.model.ap.a aVar);

        void a(com.getpebble.android.framework.health.g.a.a aVar, short s);

        void a(b bVar, short s);

        void a(String str, int i);
    }

    public a(final Context context, a aVar) {
        this.a = context.getResources().getStringArray(R.array.genders);
        this.c = aVar;
        this.d = new WeakReference(context);
        this.b = new LinkedHashMap<Integer, String>(this, 47) {
            final /* synthetic */ a b;
        };
    }

    public void a() {
        a((Context) this.d.get(), R.string.onboarding_health_profile_sex_default, this.a, new OnClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.c.a(com.getpebble.android.common.model.ap.a.fromValue((byte) i));
            }
        });
    }

    public void b() {
        a((Context) this.d.get(), R.string.onboarding_health_profile_age_default, (String[]) this.b.values().toArray(new String[this.b.size()]), new OnClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.c.a((String) this.a.b.get(Integer.valueOf(i + 18)), i + 18);
            }
        });
    }

    public void a(int i, com.getpebble.android.framework.health.g.a.a aVar) {
        new c((Context) this.d.get(), (short) i, aVar, new com.getpebble.android.main.sections.mypebble.c.c.a(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void a(com.getpebble.android.framework.health.g.a.a aVar, short s) {
                this.a.c.a(aVar, s);
            }
        }).show();
    }

    public void a(int i, b bVar) {
        new d((Context) this.d.get(), (short) i, bVar, new com.getpebble.android.main.sections.mypebble.c.d.a(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void a(b bVar, short s) {
                this.a.c.a(bVar, s);
            }
        }).show();
    }

    private static void a(Context context, int i, String[] strArr, OnClickListener onClickListener) {
        new Builder(context).setTitle(i).setItems(strArr, onClickListener).setNegativeButton(R.string.action_cancel, null).create().show();
    }

    public String a(int i) {
        return (String) this.b.get(Integer.valueOf(i));
    }
}
