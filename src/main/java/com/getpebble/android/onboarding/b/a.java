package com.getpebble.android.onboarding.b;

import android.content.ContentResolver;
import android.content.Context;
import android.widget.FrameLayout;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.am.c;

public abstract class a extends FrameLayout {
    protected com.getpebble.android.onboarding.a.a a;

    public abstract void a(c cVar, boolean z);

    public a(Context context, com.getpebble.android.onboarding.a.a aVar) {
        super(context);
        this.a = aVar;
    }

    public static void a(final c cVar, final ContentResolver contentResolver) {
        new f() {
            public boolean doInBackground() {
                am.a(contentResolver, cVar);
                am.a(cVar.b, contentResolver);
                return false;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    protected void a(c cVar) {
        this.a.a(cVar.b);
        a(cVar, com.getpebble.android.common.a.K().getContentResolver());
    }
}
