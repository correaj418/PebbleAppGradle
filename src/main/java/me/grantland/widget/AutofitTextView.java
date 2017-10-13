package me.grantland.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import me.grantland.widget.a.c;

public class AutofitTextView extends TextView implements c {
    private a a;

    public AutofitTextView(Context context) {
        super(context);
        a(context, null, 0);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.a = a.a(this, attributeSet, i).a((c) this);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        if (this.a != null) {
            this.a.c(i, f);
        }
    }

    public void setLines(int i) {
        super.setLines(i);
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public a getAutofitHelper() {
        return this.a;
    }

    public void setSizeToFit(boolean z) {
        this.a.a(z);
    }

    public float getMaxTextSize() {
        return this.a.c();
    }

    public void setMaxTextSize(float f) {
        this.a.b(f);
    }

    public float getMinTextSize() {
        return this.a.b();
    }

    public void setMinTextSize(int i) {
        this.a.a(2, (float) i);
    }

    public float getPrecision() {
        return this.a.a();
    }

    public void setPrecision(float f) {
        this.a.a(f);
    }

    public void a(float f, float f2) {
    }
}
