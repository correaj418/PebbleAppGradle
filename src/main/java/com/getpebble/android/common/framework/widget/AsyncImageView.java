package com.getpebble.android.common.framework.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.b.a.b.e;
import com.b.b.a.j;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.b.n;
import com.getpebble.android.common.framework.b.n.b;

public class AsyncImageView extends ImageView {
    private String a = null;
    private b b;
    private e<ImageView> c = null;

    private static class a implements j {
        private final b a;

        public a(b bVar) {
            this.a = bVar;
        }

        public Bitmap a(Bitmap bitmap) {
            if (this.a != null) {
                return n.a(bitmap, this.a);
            }
            return bitmap;
        }

        public String a() {
            return null;
        }
    }

    public AsyncImageView(Context context) {
        super(context);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageResource(int i) {
        this.a = null;
        this.b = null;
        super.setImageResource(i);
    }

    public void a(String str, b bVar, com.getpebble.android.common.model.am.b.a aVar) {
        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
        if (str == null || str.length() < 1) {
            f.a("AsyncImageView", "'url' cannot be null!");
        } else if (!str.equals(this.a) || !com.getpebble.android.common.b.b.a.a(bVar, this.b)) {
            int a = a(aVar);
            this.a = str;
            this.b = bVar;
            a();
            f.e("AsyncImageView", "fetch: Ion request: " + str);
            this.c = ((com.b.b.b.c.b.a) ((com.b.b.b.c.b.a) ((com.b.b.b.c.b.a) ((com.b.b.b.c.b.a) com.b.b.j.a((ImageView) this).e(17301579)).d(R.anim.fade_in_short)).b(new a(bVar))).f(a)).b(str);
        }
    }

    public void a(String str, b bVar) {
        b("package://" + str, bVar);
    }

    public void a(int i, b bVar) {
        String str = "android.resource://" + getContext().getPackageName() + "/" + i;
        if (!str.equals(this.a) || !com.getpebble.android.common.b.b.a.a(bVar, this.b)) {
            this.a = str;
            this.b = bVar;
            if (this.b != null) {
                setImageBitmap(n.a(BitmapFactory.decodeResource(getResources(), i), bVar));
            } else {
                setImageResource(i);
            }
        }
    }

    private void b(String str, b bVar) {
        f.e("AsyncImageView", "fetchUri() Ion request: " + str);
        if (!str.equals(this.a) || !com.getpebble.android.common.b.b.a.a(bVar, this.b)) {
            this.a = str;
            this.b = bVar;
            a();
            this.c = ((com.b.b.b.c.b.a) ((com.b.b.b.c.b.a) ((com.b.b.b.c.b.a) ((com.b.b.b.c.b.a) com.b.b.j.a((ImageView) this).e(17301579)).d(R.anim.fade_in_short)).f()).b(new a(bVar))).b(str);
        }
    }

    public void a() {
        if (this.c != null) {
            this.c.cancel(true);
            this.c = null;
        }
        this.a = null;
        this.b = null;
    }

    public static int a(com.getpebble.android.common.model.am.b.a aVar) {
        f.e("AsyncImageView", "getWatchPlaceHolderIcon: targetPlatformPdd = " + aVar);
        if (aVar != null) {
            return a(aVar.a.getShape());
        }
        f.b("AsyncImageView", "getWatchPlaceHolderIcon: PlatformDependentData.Item should not be null.");
        return R.drawable.watchface_placeholder_icon;
    }

    public static int a(com.getpebble.android.common.framework.install.app.b.b bVar) {
        if (bVar == com.getpebble.android.common.framework.install.app.b.b.ROUND_RECT) {
            return R.drawable.watchface_placeholder_icon_square;
        }
        if (bVar == com.getpebble.android.common.framework.install.app.b.b.CIRCLE) {
            return R.drawable.watchface_placeholder_icon_round;
        }
        return R.drawable.watchface_placeholder_icon;
    }
}
