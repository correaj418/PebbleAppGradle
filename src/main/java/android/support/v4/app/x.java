package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v4.content.d;
import android.util.Log;

public final class x {
    private static final a a;

    interface a {
        Intent a(Activity activity);

        String a(Context context, ActivityInfo activityInfo);

        void a(Activity activity, Intent intent);
    }

    static class b implements a {
        b() {
        }

        public Intent a(Activity activity) {
            String c = x.c(activity);
            if (c == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, c);
            try {
                if (x.a((Context) activity, componentName) == null) {
                    return d.a(componentName);
                }
                return new Intent().setComponent(componentName);
            } catch (NameNotFoundException e) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + c + "' in manifest");
                return null;
            }
        }

        public void a(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }

        public String a(Context context, ActivityInfo activityInfo) {
            if (activityInfo.metaData == null) {
                return null;
            }
            String string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
            if (string == null) {
                return null;
            }
            if (string.charAt(0) == '.') {
                return context.getPackageName() + string;
            }
            return string;
        }
    }

    static class c extends b {
        c() {
        }

        public Intent a(Activity activity) {
            Intent a = y.a(activity);
            if (a == null) {
                return b(activity);
            }
            return a;
        }

        Intent b(Activity activity) {
            return super.a(activity);
        }

        public void a(Activity activity, Intent intent) {
            y.a(activity, intent);
        }

        public String a(Context context, ActivityInfo activityInfo) {
            String a = y.a(activityInfo);
            if (a == null) {
                return super.a(context, activityInfo);
            }
            return a;
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new c();
        } else {
            a = new b();
        }
    }

    public static void a(Activity activity) {
        Intent b = b(activity);
        if (b == null) {
            throw new IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified." + " (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> " + " element in your manifest?)");
        }
        a(activity, b);
    }

    public static void a(Activity activity, Intent intent) {
        a.a(activity, intent);
    }

    public static Intent b(Activity activity) {
        return a.a(activity);
    }

    public static String c(Activity activity) {
        try {
            return a((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String a(Context context, ComponentName componentName) {
        return a.a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }
}
