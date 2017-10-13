package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public final class d {
    private static final a a;

    interface a {
        Intent a(ComponentName componentName);
    }

    static class b implements a {
        b() {
        }

        public Intent a(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    static class c extends b {
        c() {
        }

        public Intent a(ComponentName componentName) {
            return e.a(componentName);
        }
    }

    static class d extends c {
        d() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            a = new d();
        } else if (i >= 11) {
            a = new c();
        } else {
            a = new b();
        }
    }

    public static Intent a(ComponentName componentName) {
        return a.a(componentName);
    }
}
