package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.k;
import android.util.Log;
import com.google.android.gms.b.ad;

public abstract class n implements OnClickListener {

    class AnonymousClass1 extends n {
        final /* synthetic */ Activity a;
        final /* synthetic */ Intent b;
        final /* synthetic */ int c;

        AnonymousClass1(Activity activity, Intent intent, int i) {
            this.a = activity;
            this.b = intent;
            this.c = i;
        }

        public void a() {
            this.a.startActivityForResult(this.b, this.c);
        }
    }

    class AnonymousClass2 extends n {
        final /* synthetic */ k a;
        final /* synthetic */ Intent b;
        final /* synthetic */ int c;

        AnonymousClass2(k kVar, Intent intent, int i) {
            this.a = kVar;
            this.b = intent;
            this.c = i;
        }

        public void a() {
            this.a.startActivityForResult(this.b, this.c);
        }
    }

    class AnonymousClass3 extends n {
        final /* synthetic */ ad a;
        final /* synthetic */ Intent b;
        final /* synthetic */ int c;

        AnonymousClass3(ad adVar, Intent intent, int i) {
            this.a = adVar;
            this.b = intent;
            this.c = i;
        }

        @TargetApi(11)
        public void a() {
            this.a.startActivityForResult(this.b, this.c);
        }
    }

    public static n a(Activity activity, Intent intent, int i) {
        return new AnonymousClass1(activity, intent, i);
    }

    public static n a(k kVar, Intent intent, int i) {
        return new AnonymousClass2(kVar, intent, i);
    }

    public static n a(ad adVar, Intent intent, int i) {
        return new AnonymousClass3(adVar, intent, i);
    }

    public abstract void a();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            a();
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
