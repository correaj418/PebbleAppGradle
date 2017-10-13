package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.b;
import java.lang.ref.WeakReference;

public class bb extends Resources {
    private final WeakReference<Context> a;

    public static boolean a() {
        return b.a() && VERSION.SDK_INT <= 20;
    }

    public bb(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.a.get();
        if (context != null) {
            return i.a().a(context, this, i);
        }
        return super.getDrawable(i);
    }

    final Drawable a(int i) {
        return super.getDrawable(i);
    }
}
