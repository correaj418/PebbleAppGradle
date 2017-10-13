package com.google.android.gms.b;

import android.content.Context;
import com.google.firebase.a;
import java.util.concurrent.atomic.AtomicReference;

public class b {
    private static final AtomicReference<b> a = new AtomicReference();

    b(Context context) {
    }

    public static b a(Context context) {
        a.compareAndSet(null, new b(context));
        return (b) a.get();
    }

    public void a(a aVar) {
    }
}
