package android.support.v4.content;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.TypedValue;

public class a {
    private static final Object a = new Object();
    private static TypedValue b;

    public static final Drawable a(Context context, int i) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 21) {
            return b.a(context, i);
        }
        if (i2 >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (a) {
            if (b == null) {
                b = new TypedValue();
            }
            context.getResources().getValue(i, b, true);
            i2 = b.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static final ColorStateList b(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return c.a(context, i);
        }
        return context.getResources().getColorStateList(i);
    }

    public static int a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }
}
