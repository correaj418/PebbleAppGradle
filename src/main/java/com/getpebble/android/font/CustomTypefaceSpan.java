package com.getpebble.android.font;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class CustomTypefaceSpan extends TypefaceSpan {
    private final Typeface a;

    public CustomTypefaceSpan(Typeface typeface) {
        super("sans-serif");
        this.a = typeface;
    }

    public void updateDrawState(TextPaint textPaint) {
        a(textPaint, this.a);
    }

    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint, this.a);
    }

    private static void a(Paint paint, Typeface typeface) {
        paint.setTypeface(typeface);
    }
}
