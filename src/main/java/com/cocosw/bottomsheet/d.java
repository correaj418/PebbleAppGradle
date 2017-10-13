package com.cocosw.bottomsheet;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

class d extends LinearLayout {
    private View a;

    public d(Context context) {
        super(context);
    }

    public void a(View view) {
        this.a = view;
    }

    protected void onMeasure(int i, int i2) {
        if (this.a != null) {
            i2 = MeasureSpec.makeMeasureSpec(this.a.getMeasuredHeight(), 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
