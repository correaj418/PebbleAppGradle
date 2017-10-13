package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class l extends j {

    private static class a extends a {
        a(a aVar, Resources resources) {
            super(aVar, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new l(this, resources);
        }
    }

    l(Drawable drawable) {
        super(drawable);
    }

    l(a aVar, Resources resources) {
        super(aVar, resources);
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }

    a b() {
        return new a(this.b, null);
    }
}
