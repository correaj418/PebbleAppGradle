package android.support.a.a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.a;
import android.support.v4.b.a.o;
import android.util.AttributeSet;

@TargetApi(21)
abstract class e extends Drawable implements o {
    Drawable a;

    e() {
    }

    static TypedArray b(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.a != null) {
            this.a.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.a != null) {
            return a.e(this.a);
        }
        return null;
    }

    protected boolean onLevelChange(int i) {
        if (this.a != null) {
            return this.a.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.a != null) {
            a.a(this.a, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.a != null) {
            a.a(this.a, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.a != null) {
            this.a.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.a != null) {
            a.a(this.a);
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.a != null) {
            a.a(this.a, z);
        }
    }

    public boolean isAutoMirrored() {
        if (this.a != null) {
            a.b(this.a);
        }
        return false;
    }

    public void applyTheme(Theme theme) {
        if (this.a != null) {
            a.a(this.a, theme);
        }
    }

    public int getLayoutDirection() {
        if (this.a != null) {
            a.g(this.a);
        }
        return 0;
    }

    public void clearColorFilter() {
        if (this.a != null) {
            this.a.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.a != null) {
            return this.a.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.a != null) {
            return this.a.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.a != null) {
            return this.a.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.a != null) {
            return this.a.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.a != null) {
            return this.a.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.a != null) {
            return this.a.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.a != null) {
            this.a.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        return super.setState(iArr);
    }
}
