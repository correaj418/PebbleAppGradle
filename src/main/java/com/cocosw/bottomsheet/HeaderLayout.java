package com.cocosw.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

class HeaderLayout extends FrameLayout {
    private int a = 1;

    public HeaderLayout(Context context) {
        super(context);
    }

    public HeaderLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(int i) {
        this.a = i;
    }

    protected void onMeasure(int i, int i2) {
        if (this.a != 1) {
            i = MeasureSpec.makeMeasureSpec(this.a, MeasureSpec.getMode(i));
        }
        super.onMeasure(i, i2);
    }
}
