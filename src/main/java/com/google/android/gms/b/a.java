package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class a implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final a a = new a();
    private final AtomicBoolean b = new AtomicBoolean();
    private boolean c;

    private a() {
    }

    public static void a(Application application) {
        application.registerActivityLifecycleCallbacks(a);
        application.registerComponentCallbacks(a);
        a.c = true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.b.compareAndSet(true, false)) {
            com.google.firebase.a.a(false);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (this.b.compareAndSet(true, false)) {
            com.google.firebase.a.a(false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i == 20 && this.b.compareAndSet(false, true)) {
            com.google.firebase.a.a(true);
        }
    }
}
