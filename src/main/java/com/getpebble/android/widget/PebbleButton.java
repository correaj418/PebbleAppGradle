package com.getpebble.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import com.getpebble.android.d.a;

public class PebbleButton extends Button {
    public PebbleButton(Context context) {
        super(context);
    }

    public PebbleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public PebbleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.PebbleButton, 0, 0);
        try {
            setTypeface(com.getpebble.android.font.a.a(context, Integer.valueOf(obtainStyledAttributes.getInteger(0, com.getpebble.android.font.a.a.intValue()))));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
