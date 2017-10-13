package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class m extends l {

    private static class a extends a {
        a(a aVar, Resources resources) {
            super(aVar, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new m(this, resources);
        }
    }

    m(Drawable drawable) {
        super(drawable);
    }

    m(a aVar, Resources resources) {
        super(aVar, resources);
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    a b() {
        return new a(this.b, null);
    }
}
