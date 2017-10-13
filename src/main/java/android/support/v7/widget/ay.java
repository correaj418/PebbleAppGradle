package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class ay extends am {
    private final WeakReference<Context> a;

    public ay(Context context, Resources resources) {
        super(resources);
        this.a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.a.get();
        if (!(drawable == null || context == null)) {
            i.a();
            i.a(context, i, drawable);
        }
        return drawable;
    }
}
