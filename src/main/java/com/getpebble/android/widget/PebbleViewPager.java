package com.getpebble.android.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.getpebble.android.common.b.a.f;

public class PebbleViewPager extends ViewPager {
    private boolean a = true;

    public PebbleViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.a && super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.a && super.onInterceptTouchEvent(motionEvent);
    }

    public void setPagingEnabled(boolean z) {
        f.e("PebbleViewPager", "setPagingEnabled: " + z);
        this.a = z;
    }
}
