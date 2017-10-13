package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.e.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@TargetApi(11)
public final class ae extends Fragment implements ad {
    private static WeakHashMap<Activity, WeakReference<ae>> a = new WeakHashMap();
    private Map<String, ac> b = new a();
    private int c = 0;
    private Bundle d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.b.ae a(android.app.Activity r3) {
        /*
        r0 = a;
        r0 = r0.get(r3);
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r0.get();
        r0 = (com.google.android.gms.b.ae) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r3.getFragmentManager();	 Catch:{ ClassCastException -> 0x0048 }
        r1 = "LifecycleFragmentImpl";
        r0 = r0.findFragmentByTag(r1);	 Catch:{ ClassCastException -> 0x0048 }
        r0 = (com.google.android.gms.b.ae) r0;	 Catch:{ ClassCastException -> 0x0048 }
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r1 = r0.isRemoving();
        if (r1 == 0) goto L_0x003d;
    L_0x0027:
        r0 = new com.google.android.gms.b.ae;
        r0.<init>();
        r1 = r3.getFragmentManager();
        r1 = r1.beginTransaction();
        r2 = "LifecycleFragmentImpl";
        r1 = r1.add(r0, r2);
        r1.commitAllowingStateLoss();
    L_0x003d:
        r1 = a;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r0);
        r1.put(r3, r2);
        goto L_0x0012;
    L_0x0048:
        r0 = move-exception;
        r1 = new java.lang.IllegalStateException;
        r2 = "Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.ae.a(android.app.Activity):com.google.android.gms.b.ae");
    }

    private void b(final String str, final ac acVar) {
        if (this.c > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ ae c;

                public void run() {
                    if (this.c.c >= 1) {
                        acVar.a(this.c.d != null ? this.c.d.getBundle(str) : null);
                    }
                    if (this.c.c >= 2) {
                        acVar.a();
                    }
                    if (this.c.c >= 3) {
                        acVar.b();
                    }
                }
            });
        }
    }

    public Activity a() {
        return getActivity();
    }

    public <T extends ac> T a(String str, Class<T> cls) {
        return (ac) cls.cast(this.b.get(str));
    }

    public void a(String str, ac acVar) {
        if (this.b.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.b.put(str, acVar);
        b(str, acVar);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (ac a : this.b.values()) {
            a.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (ac a : this.b.values()) {
            a.a(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = 1;
        this.d = bundle;
        for (Entry entry : this.b.entrySet()) {
            ((ac) entry.getValue()).a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((ac) entry.getValue()).b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStop();
        this.c = 2;
        for (ac a : this.b.values()) {
            a.a();
        }
    }

    public void onStop() {
        super.onStop();
        this.c = 3;
        for (ac b : this.b.values()) {
            b.b();
        }
    }
}
