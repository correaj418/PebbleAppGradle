package me.grantland.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class a {
    private TextView a;
    private TextPaint b;
    private float c;
    private int d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private ArrayList<c> j;
    private TextWatcher k = new b();
    private OnLayoutChangeListener l = new a();

    public interface c {
        void a(float f, float f2);
    }

    private class a implements OnLayoutChangeListener {
        final /* synthetic */ a a;

        private a(a aVar) {
            this.a = aVar;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.a.d();
        }
    }

    private class b implements TextWatcher {
        final /* synthetic */ a a;

        private b(a aVar) {
            this.a = aVar;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.d();
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    public static a a(TextView textView, AttributeSet attributeSet, int i) {
        a aVar = new a(textView);
        boolean z = true;
        if (attributeSet != null) {
            Context context = textView.getContext();
            int b = (int) aVar.b();
            float a = aVar.a();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, me.grantland.widget.b.a.AutofitTextView, i, 0);
            z = obtainStyledAttributes.getBoolean(me.grantland.widget.b.a.AutofitTextView_sizeToFit, true);
            b = obtainStyledAttributes.getDimensionPixelSize(me.grantland.widget.b.a.AutofitTextView_minTextSize, b);
            a = obtainStyledAttributes.getFloat(me.grantland.widget.b.a.AutofitTextView_precision, a);
            obtainStyledAttributes.recycle();
            aVar.a(0, (float) b).a(a);
        }
        aVar.a(z);
        return aVar;
    }

    private static void a(TextView textView, TextPaint textPaint, float f, float f2, int i, float f3) {
        if (i > 0 && i != Integer.MAX_VALUE) {
            int width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
            if (width > 0) {
                float f4;
                CharSequence text = textView.getText();
                TransformationMethod transformationMethod = textView.getTransformationMethod();
                if (transformationMethod != null) {
                    text = transformationMethod.getTransformation(text, textView);
                }
                Context context = textView.getContext();
                Resources system = Resources.getSystem();
                if (context != null) {
                    system = context.getResources();
                }
                DisplayMetrics displayMetrics = system.getDisplayMetrics();
                textPaint.set(textView.getPaint());
                textPaint.setTextSize(f2);
                if ((i != 1 || textPaint.measureText(text, 0, text.length()) <= ((float) width)) && a(text, textPaint, f2, (float) width, displayMetrics) <= i) {
                    f4 = f2;
                } else {
                    f4 = a(text, textPaint, (float) width, i, 0.0f, f2, f3, displayMetrics);
                }
                if (f4 >= f) {
                    f = f4;
                }
                textView.setTextSize(0, f);
            }
        }
    }

    private static float a(CharSequence charSequence, TextPaint textPaint, float f, int i, float f2, float f3, float f4, DisplayMetrics displayMetrics) {
        StaticLayout staticLayout;
        int lineCount;
        float f5 = (f2 + f3) / 2.0f;
        textPaint.setTextSize(TypedValue.applyDimension(0, f5, displayMetrics));
        if (i != 1) {
            StaticLayout staticLayout2 = new StaticLayout(charSequence, textPaint, (int) f, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            staticLayout = staticLayout2;
            lineCount = staticLayout2.getLineCount();
        } else {
            staticLayout = null;
            lineCount = 1;
        }
        if (lineCount > i) {
            if (f3 - f2 < f4) {
                return f2;
            }
            return a(charSequence, textPaint, f, i, f2, f5, f4, displayMetrics);
        } else if (lineCount < i) {
            return a(charSequence, textPaint, f, i, f5, f3, f4, displayMetrics);
        } else {
            float measureText;
            if (i == 1) {
                measureText = textPaint.measureText(charSequence, 0, charSequence.length());
            } else {
                measureText = 0.0f;
                for (int i2 = 0; i2 < lineCount; i2++) {
                    if (staticLayout.getLineWidth(i2) > measureText) {
                        measureText = staticLayout.getLineWidth(i2);
                    }
                }
            }
            if (f3 - f2 < f4) {
                return f2;
            }
            if (measureText > f) {
                return a(charSequence, textPaint, f, i, f2, f5, f4, displayMetrics);
            }
            return measureText < f ? a(charSequence, textPaint, f, i, f5, f3, f4, displayMetrics) : f5;
        }
    }

    private static int a(CharSequence charSequence, TextPaint textPaint, float f, float f2, DisplayMetrics displayMetrics) {
        textPaint.setTextSize(TypedValue.applyDimension(0, f, displayMetrics));
        return new StaticLayout(charSequence, textPaint, (int) f2, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
    }

    private static int a(TextView textView) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null && (transformationMethod instanceof SingleLineTransformationMethod)) {
            return 1;
        }
        if (VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        return -1;
    }

    private a(TextView textView) {
        float f = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.a = textView;
        this.b = new TextPaint();
        e(textView.getTextSize());
        this.d = a(textView);
        this.e = f * 8.0f;
        this.f = this.c;
        this.g = 0.5f;
    }

    public a a(c cVar) {
        if (this.j == null) {
            this.j = new ArrayList();
        }
        this.j.add(cVar);
        return this;
    }

    public float a() {
        return this.g;
    }

    public a a(float f) {
        if (this.g != f) {
            this.g = f;
            d();
        }
        return this;
    }

    public float b() {
        return this.e;
    }

    public a a(int i, float f) {
        Context context = this.a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        c(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    private void c(float f) {
        if (f != this.e) {
            this.e = f;
            d();
        }
    }

    public float c() {
        return this.f;
    }

    public a b(float f) {
        return b(2, f);
    }

    public a b(int i, float f) {
        Context context = this.a.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        d(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    private void d(float f) {
        if (f != this.f) {
            this.f = f;
            d();
        }
    }

    public a a(int i) {
        if (this.d != i) {
            this.d = i;
            d();
        }
        return this;
    }

    public a a(boolean z) {
        if (this.h != z) {
            this.h = z;
            if (z) {
                this.a.addTextChangedListener(this.k);
                this.a.addOnLayoutChangeListener(this.l);
                d();
            } else {
                this.a.removeTextChangedListener(this.k);
                this.a.removeOnLayoutChangeListener(this.l);
                this.a.setTextSize(0, this.c);
            }
        }
        return this;
    }

    public void c(int i, float f) {
        if (!this.i) {
            Context context = this.a.getContext();
            Resources system = Resources.getSystem();
            if (context != null) {
                system = context.getResources();
            }
            e(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        }
    }

    private void e(float f) {
        if (this.c != f) {
            this.c = f;
        }
    }

    private void d() {
        float textSize = this.a.getTextSize();
        this.i = true;
        a(this.a, this.b, this.e, this.f, this.d, this.g);
        this.i = false;
        float textSize2 = this.a.getTextSize();
        if (textSize2 != textSize) {
            a(textSize2, textSize);
        }
    }

    private void a(float f, float f2) {
        if (this.j != null) {
            Iterator it = this.j.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(f, f2);
            }
        }
    }
}
