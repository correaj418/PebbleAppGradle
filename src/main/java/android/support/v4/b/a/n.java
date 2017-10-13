package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;

class n extends m {

    private static class a extends a {
        a(a aVar, Resources resources) {
            super(aVar, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new n(this, resources);
        }
    }

    n(Drawable drawable) {
        super(drawable);
    }

    n(a aVar, Resources resources) {
        super(aVar, resources);
    }

    public void setHotspot(float f, float f2) {
        this.c.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.c.setHotspotBounds(i, i2, i3, i4);
    }

    public void getOutline(Outline outline) {
        this.c.getOutline(outline);
    }

    public Rect getDirtyBounds() {
        return this.c.getDirtyBounds();
    }

    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.c.setTintList(colorStateList);
        }
    }

    public void setTint(int i) {
        if (c()) {
            super.setTint(i);
        } else {
            this.c.setTint(i);
        }
    }

    public void setTintMode(Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.c.setTintMode(mode);
        }
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    protected boolean c() {
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.c;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable)) {
            return true;
        }
        return false;
    }

    a b() {
        return new a(this.b, null);
    }
}
