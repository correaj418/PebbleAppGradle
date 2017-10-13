package android.support.v4.a;

import android.os.Build.VERSION;
import android.view.View;

public final class a {
    private static final c a;

    static {
        if (VERSION.SDK_INT >= 12) {
            a = new f();
        } else {
            a = new e();
        }
    }

    public static g a() {
        return a.a();
    }

    public static void a(View view) {
        a.a(view);
    }
}
