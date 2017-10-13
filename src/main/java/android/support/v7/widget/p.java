package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ae;
import android.util.AttributeSet;
import android.widget.TextView;

public class p extends TextView implements ae {
    private i a;
    private h b;
    private n c;

    public p(Context context) {
        this(context, null);
    }

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public p(Context context, AttributeSet attributeSet, int i) {
        super(aw.a(context), attributeSet, i);
        this.a = i.a();
        this.b = new h(this, this.a);
        this.b.a(attributeSet, i);
        this.c = n.a((TextView) this);
        this.c.a(attributeSet, i);
        this.c.a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.b != null) {
            this.b.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.b != null) {
            this.b.a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            this.b.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.b != null ? this.b.a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.b != null) {
            this.b.a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.b != null ? this.b.b() : null;
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.c != null) {
            this.c.a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.c();
        }
        if (this.c != null) {
            this.c.a();
        }
    }
}
