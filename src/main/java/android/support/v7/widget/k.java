package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ae;
import android.util.AttributeSet;
import android.widget.ImageView;

public class k extends ImageView implements ae {
    private h a;
    private j b;

    public k(Context context, AttributeSet attributeSet, int i) {
        super(aw.a(context), attributeSet, i);
        i a = i.a();
        this.a = new h(this, a);
        this.a.a(attributeSet, i);
        this.b = new j(this, a);
        this.b.a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.b.a(i);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.a != null) {
            this.a.a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            this.a.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.a != null ? this.a.a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.a != null) {
            this.a.a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.a != null ? this.a.b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a != null) {
            this.a.c();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.b.a() && super.hasOverlappingRendering();
    }
}
