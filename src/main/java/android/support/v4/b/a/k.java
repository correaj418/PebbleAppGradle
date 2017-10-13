package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

class k extends j {

    private static class a extends a {
        a(a aVar, Resources resources) {
            super(aVar, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new k(this, resources);
        }
    }

    k(Drawable drawable) {
        super(drawable);
    }

    k(a aVar, Resources resources) {
        super(aVar, resources);
    }

    a b() {
        return new a(this.b, null);
    }

    protected Drawable a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }
}
