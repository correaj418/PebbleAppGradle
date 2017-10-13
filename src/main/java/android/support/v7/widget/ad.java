package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ah;
import android.support.v4.view.f;
import android.support.v7.b.a.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class ad extends ViewGroup {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    public static class a extends MarginLayoutParams {
        public float g;
        public int h;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.LinearLayoutCompat_Layout);
            this.g = obtainStyledAttributes.getFloat(k.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.h = obtainStyledAttributes.getInt(k.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public a(int i, int i2) {
            super(i, i2);
            this.h = -1;
            this.g = 0.0f;
        }

        public a(LayoutParams layoutParams) {
            super(layoutParams);
            this.h = -1;
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return g();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return b(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return b(layoutParams);
    }

    public ad(Context context) {
        this(context, null);
    }

    public ad(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ad(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.e = 8388659;
        az a = az.a(context, attributeSet, k.LinearLayoutCompat, i, 0);
        int a2 = a.a(k.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.a(k.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.a(k.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.g = a.a(k.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = a.a(k.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = a.a(k.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.a(k.LinearLayoutCompat_divider));
        this.n = a.a(k.LinearLayoutCompat_showDividers, 0);
        this.o = a.e(k.LinearLayoutCompat_dividerPadding, 0);
        a.a();
    }

    public void setShowDividers(int i) {
        if (i != this.n) {
            requestLayout();
        }
        this.n = i;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.n;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.k) {
            this.k = drawable;
            if (drawable != null) {
                this.l = drawable.getIntrinsicWidth();
                this.m = drawable.getIntrinsicHeight();
            } else {
                this.l = 0;
                this.m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.o = i;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    protected void onDraw(Canvas canvas) {
        if (this.k != null) {
            if (this.d == 1) {
                a(canvas);
            } else {
                b(canvas);
            }
        }
    }

    void a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = b(i);
            if (!(b == null || b.getVisibility() == 8 || !c(i))) {
                a(canvas, (b.getTop() - ((a) b.getLayoutParams()).topMargin) - this.m);
            }
            i++;
        }
        if (c(virtualChildCount)) {
            int height;
            View b2 = b(virtualChildCount - 1);
            if (b2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.m;
            } else {
                a aVar = (a) b2.getLayoutParams();
                height = aVar.bottomMargin + b2.getBottom();
            }
            a(canvas, height);
        }
    }

    void b(Canvas canvas) {
        a aVar;
        int right;
        int virtualChildCount = getVirtualChildCount();
        boolean a = bd.a(this);
        int i = 0;
        while (i < virtualChildCount) {
            View b = b(i);
            if (!(b == null || b.getVisibility() == 8 || !c(i))) {
                aVar = (a) b.getLayoutParams();
                if (a) {
                    right = aVar.rightMargin + b.getRight();
                } else {
                    right = (b.getLeft() - aVar.leftMargin) - this.l;
                }
                b(canvas, right);
            }
            i++;
        }
        if (c(virtualChildCount)) {
            View b2 = b(virtualChildCount - 1);
            if (b2 != null) {
                aVar = (a) b2.getLayoutParams();
                if (a) {
                    right = (b2.getLeft() - aVar.leftMargin) - this.l;
                } else {
                    right = aVar.rightMargin + b2.getRight();
                }
            } else if (a) {
                right = getPaddingLeft();
            } else {
                right = (getWidth() - getPaddingRight()) - this.l;
            }
            b(canvas, right);
        }
    }

    void a(Canvas canvas, int i) {
        this.k.setBounds(getPaddingLeft() + this.o, i, (getWidth() - getPaddingRight()) - this.o, this.m + i);
        this.k.draw(canvas);
    }

    void b(Canvas canvas, int i) {
        this.k.setBounds(i, getPaddingTop() + this.o, this.l + i, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    public int getBaseline() {
        if (this.b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.c;
            if (this.d == 1) {
                i = this.e & 112;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f;
                            break;
                    }
                }
            }
            i = i2;
            return (((a) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.b = i;
    }

    View b(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    protected void onMeasure(int i, int i2) {
        if (this.d == 1) {
            a(i, i2);
        } else {
            b(i, i2);
        }
    }

    protected boolean c(int i) {
        if (i == 0) {
            if ((this.n & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.n & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.n & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    void a(int i, int i2) {
        int i3;
        int i4;
        View b;
        this.f = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Object obj = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj2 = null;
        Object obj3 = null;
        int i9 = this.b;
        boolean z = this.h;
        int i10 = Integer.MIN_VALUE;
        int i11 = 0;
        while (i11 < virtualChildCount) {
            Object obj4;
            Object obj5;
            int i12;
            int i13;
            View b2 = b(i11);
            if (b2 == null) {
                this.f += d(i11);
                i3 = i10;
                obj4 = obj3;
                obj5 = obj;
                i12 = i6;
                i13 = i5;
            } else if (b2.getVisibility() == 8) {
                i11 += a(b2, i11);
                i3 = i10;
                obj4 = obj3;
                obj5 = obj;
                i12 = i6;
                i13 = i5;
            } else {
                if (c(i11)) {
                    this.f += this.m;
                }
                a aVar = (a) b2.getLayoutParams();
                float f2 = f + aVar.g;
                if (mode2 == 1073741824 && aVar.height == 0 && aVar.g > 0.0f) {
                    i3 = this.f;
                    this.f = Math.max(i3, (aVar.topMargin + i3) + aVar.bottomMargin);
                    obj3 = 1;
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (aVar.height == 0 && aVar.g > 0.0f) {
                        i3 = 0;
                        aVar.height = -2;
                    }
                    int i14 = i3;
                    a(b2, i11, i, 0, i2, f2 == 0.0f ? this.f : 0);
                    if (i14 != Integer.MIN_VALUE) {
                        aVar.height = i14;
                    }
                    i3 = b2.getMeasuredHeight();
                    int i15 = this.f;
                    this.f = Math.max(i15, (((i15 + i3) + aVar.topMargin) + aVar.bottomMargin) + b(b2));
                    if (z) {
                        i10 = Math.max(i3, i10);
                    }
                }
                if (i9 >= 0 && i9 == i11 + 1) {
                    this.c = this.f;
                }
                if (i11 >= i9 || aVar.g <= 0.0f) {
                    Object obj6;
                    Object obj7 = null;
                    if (mode == 1073741824 || aVar.width != -1) {
                        obj6 = obj2;
                    } else {
                        obj6 = 1;
                        obj7 = 1;
                    }
                    i12 = aVar.rightMargin + aVar.leftMargin;
                    i13 = b2.getMeasuredWidth() + i12;
                    i5 = Math.max(i5, i13);
                    int a = bd.a(i6, ah.j(b2));
                    obj5 = (obj == null || aVar.width != -1) ? null : 1;
                    if (aVar.g > 0.0f) {
                        if (obj7 != null) {
                            i3 = i12;
                        } else {
                            i3 = i13;
                        }
                        i3 = Math.max(i8, i3);
                        i12 = i7;
                    } else {
                        if (obj7 == null) {
                            i12 = i13;
                        }
                        i12 = Math.max(i7, i12);
                        i3 = i8;
                    }
                    i11 += a(b2, i11);
                    obj4 = obj3;
                    i8 = i3;
                    i7 = i12;
                    i13 = i5;
                    i3 = i10;
                    i12 = a;
                    obj2 = obj6;
                    f = f2;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i11++;
            i10 = i3;
            obj3 = obj4;
            obj = obj5;
            i6 = i12;
            i5 = i13;
        }
        if (this.f > 0 && c(virtualChildCount)) {
            this.f += this.m;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f = 0;
            i4 = 0;
            while (i4 < virtualChildCount) {
                b = b(i4);
                if (b == null) {
                    this.f += d(i4);
                    i3 = i4;
                } else if (b.getVisibility() == 8) {
                    i3 = a(b, i4) + i4;
                } else {
                    a aVar2 = (a) b.getLayoutParams();
                    int i16 = this.f;
                    this.f = Math.max(i16, (aVar2.bottomMargin + ((i16 + i10) + aVar2.topMargin)) + b(b));
                    i3 = i4;
                }
                i4 = i3 + 1;
            }
        }
        this.f += getPaddingTop() + getPaddingBottom();
        int a2 = ah.a(Math.max(this.f, getSuggestedMinimumHeight()), i2, 0);
        i4 = (16777215 & a2) - this.f;
        int i17;
        if (obj3 != null || (i4 != 0 && f > 0.0f)) {
            if (this.g > 0.0f) {
                f = this.g;
            }
            this.f = 0;
            i10 = 0;
            float f3 = f;
            Object obj8 = obj;
            i17 = i7;
            i16 = i6;
            i8 = i5;
            i15 = i4;
            while (i10 < virtualChildCount) {
                View b3 = b(i10);
                if (b3.getVisibility() == 8) {
                    i3 = i17;
                    i4 = i16;
                    i12 = i8;
                    obj5 = obj8;
                } else {
                    float f4;
                    float f5;
                    aVar2 = (a) b3.getLayoutParams();
                    float f6 = aVar2.g;
                    if (f6 > 0.0f) {
                        i4 = (int) ((((float) i15) * f6) / f3);
                        f3 -= f6;
                        i15 -= i4;
                        i12 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + aVar2.leftMargin) + aVar2.rightMargin, aVar2.width);
                        if (aVar2.height == 0 && mode2 == 1073741824) {
                            if (i4 <= 0) {
                                i4 = 0;
                            }
                            b3.measure(i12, MeasureSpec.makeMeasureSpec(i4, 1073741824));
                        } else {
                            i4 += b3.getMeasuredHeight();
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            b3.measure(i12, MeasureSpec.makeMeasureSpec(i4, 1073741824));
                        }
                        f4 = f3;
                        i11 = i15;
                        i15 = bd.a(i16, ah.j(b3) & -256);
                        f5 = f4;
                    } else {
                        f5 = f3;
                        i11 = i15;
                        i15 = i16;
                    }
                    i16 = aVar2.leftMargin + aVar2.rightMargin;
                    i12 = b3.getMeasuredWidth() + i16;
                    i8 = Math.max(i8, i12);
                    Object obj9 = (mode == 1073741824 || aVar2.width != -1) ? null : 1;
                    if (obj9 == null) {
                        i16 = i12;
                    }
                    i12 = Math.max(i17, i16);
                    obj5 = (obj8 == null || aVar2.width != -1) ? null : 1;
                    i13 = this.f;
                    this.f = Math.max(i13, (aVar2.bottomMargin + ((b3.getMeasuredHeight() + i13) + aVar2.topMargin)) + b(b3));
                    i3 = i12;
                    i12 = i8;
                    f4 = f5;
                    i4 = i15;
                    i15 = i11;
                    f3 = f4;
                }
                i10++;
                i17 = i3;
                i8 = i12;
                obj8 = obj5;
                i16 = i4;
            }
            this.f += getPaddingTop() + getPaddingBottom();
            obj = obj8;
            i3 = i17;
            i6 = i16;
            i4 = i8;
        } else {
            i17 = Math.max(i7, i8);
            if (z && mode2 != 1073741824) {
                for (i4 = 0; i4 < virtualChildCount; i4++) {
                    b = b(i4);
                    if (!(b == null || b.getVisibility() == 8 || ((a) b.getLayoutParams()).g <= 0.0f)) {
                        b.measure(MeasureSpec.makeMeasureSpec(b.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i10, 1073741824));
                    }
                }
            }
            i3 = i17;
            i4 = i5;
        }
        if (obj != null || mode == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension(ah.a(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i6), a2);
        if (obj2 != null) {
            c(virtualChildCount, i2);
        }
    }

    private void c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                a aVar = (a) b.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    void b(int i, int i2) {
        Object obj;
        int i3;
        int i4;
        a aVar;
        this.f = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        if (this.i == null || this.j == null) {
            this.i = new int[4];
            this.j = new int[4];
        }
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.a;
        boolean z2 = this.h;
        if (mode == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int i9 = Integer.MIN_VALUE;
        int i10 = 0;
        while (i10 < virtualChildCount) {
            Object obj5;
            Object obj6;
            int i11;
            int i12;
            View b = b(i10);
            if (b == null) {
                this.f += d(i10);
                i3 = i9;
                obj5 = obj4;
                obj6 = obj2;
                i11 = i6;
                i12 = i5;
            } else if (b.getVisibility() == 8) {
                i10 += a(b, i10);
                i3 = i9;
                obj5 = obj4;
                obj6 = obj2;
                i11 = i6;
                i12 = i5;
            } else {
                Object obj7;
                if (c(i10)) {
                    this.f += this.l;
                }
                a aVar2 = (a) b.getLayoutParams();
                float f2 = f + aVar2.g;
                if (mode == 1073741824 && aVar2.width == 0 && aVar2.g > 0.0f) {
                    if (obj != null) {
                        this.f += aVar2.leftMargin + aVar2.rightMargin;
                    } else {
                        i3 = this.f;
                        this.f = Math.max(i3, (aVar2.leftMargin + i3) + aVar2.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(i3, i3);
                    } else {
                        obj4 = 1;
                    }
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (aVar2.width == 0 && aVar2.g > 0.0f) {
                        i3 = 0;
                        aVar2.width = -2;
                    }
                    int i13 = i3;
                    a(b, i10, i, f2 == 0.0f ? this.f : 0, i2, 0);
                    if (i13 != Integer.MIN_VALUE) {
                        aVar2.width = i13;
                    }
                    i3 = b.getMeasuredWidth();
                    if (obj != null) {
                        this.f += ((aVar2.leftMargin + i3) + aVar2.rightMargin) + b(b);
                    } else {
                        int i14 = this.f;
                        this.f = Math.max(i14, (((i14 + i3) + aVar2.leftMargin) + aVar2.rightMargin) + b(b));
                    }
                    if (z2) {
                        i9 = Math.max(i3, i9);
                    }
                }
                Object obj8 = null;
                if (mode2 == 1073741824 || aVar2.height != -1) {
                    obj7 = obj3;
                } else {
                    obj7 = 1;
                    obj8 = 1;
                }
                i11 = aVar2.bottomMargin + aVar2.topMargin;
                i12 = b.getMeasuredHeight() + i11;
                int a = bd.a(i6, ah.j(b));
                if (z) {
                    i6 = b.getBaseline();
                    if (i6 != -1) {
                        int i15 = ((((aVar2.h < 0 ? this.e : aVar2.h) & 112) >> 4) & -2) >> 1;
                        iArr[i15] = Math.max(iArr[i15], i6);
                        iArr2[i15] = Math.max(iArr2[i15], i12 - i6);
                    }
                }
                i6 = Math.max(i5, i12);
                obj6 = (obj2 == null || aVar2.height != -1) ? null : 1;
                if (aVar2.g > 0.0f) {
                    if (obj8 != null) {
                        i3 = i11;
                    } else {
                        i3 = i12;
                    }
                    i3 = Math.max(i8, i3);
                    i11 = i7;
                } else {
                    if (obj8 == null) {
                        i11 = i12;
                    }
                    i11 = Math.max(i7, i11);
                    i3 = i8;
                }
                i10 += a(b, i10);
                obj5 = obj4;
                i8 = i3;
                i7 = i11;
                i12 = i6;
                i3 = i9;
                i11 = a;
                obj3 = obj7;
                f = f2;
            }
            i10++;
            i9 = i3;
            obj4 = obj5;
            obj2 = obj6;
            i6 = i11;
            i5 = i12;
        }
        if (this.f > 0 && c(virtualChildCount)) {
            this.f += this.l;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i10 = i5;
        } else {
            i10 = Math.max(i5, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f = 0;
            i4 = 0;
            while (i4 < virtualChildCount) {
                View b2 = b(i4);
                if (b2 == null) {
                    this.f += d(i4);
                    i3 = i4;
                } else if (b2.getVisibility() == 8) {
                    i3 = a(b2, i4) + i4;
                } else {
                    aVar = (a) b2.getLayoutParams();
                    if (obj != null) {
                        this.f = ((aVar.rightMargin + (aVar.leftMargin + i9)) + b(b2)) + this.f;
                        i3 = i4;
                    } else {
                        i11 = this.f;
                        this.f = Math.max(i11, (aVar.rightMargin + ((i11 + i9) + aVar.leftMargin)) + b(b2));
                        i3 = i4;
                    }
                }
                i4 = i3 + 1;
            }
        }
        this.f += getPaddingLeft() + getPaddingRight();
        int a2 = ah.a(Math.max(this.f, getSuggestedMinimumWidth()), i, 0);
        i4 = (16777215 & a2) - this.f;
        int i16;
        if (obj4 != null || (i4 != 0 && f > 0.0f)) {
            if (this.g > 0.0f) {
                f = this.g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f = 0;
            i9 = 0;
            float f3 = f;
            Object obj9 = obj2;
            i16 = i7;
            i15 = i6;
            i14 = i4;
            i7 = -1;
            while (i9 < virtualChildCount) {
                float f4;
                Object obj10;
                View b3 = b(i9);
                if (b3 == null) {
                    f4 = f3;
                    i4 = i14;
                    i11 = i7;
                    i14 = i16;
                    obj10 = obj9;
                } else if (b3.getVisibility() == 8) {
                    f4 = f3;
                    i4 = i14;
                    i11 = i7;
                    i14 = i16;
                    obj10 = obj9;
                } else {
                    float f5;
                    aVar = (a) b3.getLayoutParams();
                    float f6 = aVar.g;
                    if (f6 > 0.0f) {
                        i4 = (int) ((((float) i14) * f6) / f3);
                        f3 -= f6;
                        i11 = i14 - i4;
                        i14 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + aVar.topMargin) + aVar.bottomMargin, aVar.height);
                        if (aVar.width == 0 && mode == 1073741824) {
                            if (i4 <= 0) {
                                i4 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i14);
                        } else {
                            i4 += b3.getMeasuredWidth();
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i14);
                        }
                        i8 = bd.a(i15, ah.j(b3) & -16777216);
                        f5 = f3;
                    } else {
                        i11 = i14;
                        i8 = i15;
                        f5 = f3;
                    }
                    if (obj != null) {
                        this.f += ((b3.getMeasuredWidth() + aVar.leftMargin) + aVar.rightMargin) + b(b3);
                    } else {
                        i4 = this.f;
                        this.f = Math.max(i4, (((b3.getMeasuredWidth() + i4) + aVar.leftMargin) + aVar.rightMargin) + b(b3));
                    }
                    obj5 = (mode2 == 1073741824 || aVar.height != -1) ? null : 1;
                    i10 = aVar.topMargin + aVar.bottomMargin;
                    i14 = b3.getMeasuredHeight() + i10;
                    i7 = Math.max(i7, i14);
                    if (obj5 != null) {
                        i4 = i10;
                    } else {
                        i4 = i14;
                    }
                    i10 = Math.max(i16, i4);
                    obj5 = (obj9 == null || aVar.height != -1) ? null : 1;
                    if (z) {
                        i12 = b3.getBaseline();
                        if (i12 != -1) {
                            i3 = ((((aVar.h < 0 ? this.e : aVar.h) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i12);
                            iArr2[i3] = Math.max(iArr2[i3], i14 - i12);
                        }
                    }
                    f4 = f5;
                    i14 = i10;
                    obj10 = obj5;
                    i15 = i8;
                    i4 = i11;
                    i11 = i7;
                }
                i9++;
                i16 = i14;
                i7 = i11;
                obj9 = obj10;
                i14 = i4;
                f3 = f4;
            }
            this.f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i7 = Math.max(i7, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj2 = obj9;
            i3 = i16;
            i6 = i15;
            i4 = i7;
        } else {
            i16 = Math.max(i7, i8);
            if (z2 && mode != 1073741824) {
                for (i4 = 0; i4 < virtualChildCount; i4++) {
                    View b4 = b(i4);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((a) b4.getLayoutParams()).g <= 0.0f)) {
                        b4.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = i16;
            i4 = i10;
        }
        if (obj2 != null || mode2 == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension((-16777216 & i6) | a2, ah.a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i6 << 16));
        if (obj3 != null) {
            d(virtualChildCount, i);
        }
    }

    private void d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                a aVar = (a) b.getLayoutParams();
                if (aVar.height == -1) {
                    int i4 = aVar.width;
                    aVar.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    aVar.width = i4;
                }
            }
        }
    }

    int a(View view, int i) {
        return 0;
    }

    int d(int i) {
        return 0;
    }

    void a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int a(View view) {
        return 0;
    }

    int b(View view) {
        return 0;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.d == 1) {
            a(i, i2, i3, i4);
        } else {
            b(i, i2, i3, i4);
        }
    }

    void a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.e & 8388615;
        switch (this.e & 112) {
            case 16:
                i5 = getPaddingTop() + (((i4 - i2) - this.f) / 2);
                break;
            case 80:
                i5 = ((getPaddingTop() + i4) - i2) - this.f;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View b = b(i7);
            if (b == null) {
                i8 += d(i7);
                i5 = i7;
            } else if (b.getVisibility() != 8) {
                int i9;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                a aVar = (a) b.getLayoutParams();
                i5 = aVar.h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (f.a(i5, ah.h(this)) & 7) {
                    case 1:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + aVar.leftMargin) - aVar.rightMargin;
                        break;
                    case 5:
                        i9 = (paddingRight - measuredWidth) - aVar.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + aVar.leftMargin;
                        break;
                }
                if (c(i7)) {
                    i5 = this.m + i8;
                } else {
                    i5 = i8;
                }
                int i10 = i5 + aVar.topMargin;
                a(b, i9, i10 + a(b), measuredWidth, measuredHeight);
                i8 = i10 + ((aVar.bottomMargin + measuredHeight) + b(b));
                i5 = a(b, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + 1;
        }
    }

    void b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = bd.a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.e & 8388615;
        int i8 = this.e & 112;
        boolean z = this.a;
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        switch (f.a(i7, ah.h(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View b = b(i10);
            if (b == null) {
                paddingLeft += d(i10);
                i7 = i9;
            } else if (b.getVisibility() != 8) {
                int i11;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                a aVar = (a) b.getLayoutParams();
                if (!z || aVar.height == -1) {
                    i7 = -1;
                } else {
                    i7 = b.getBaseline();
                }
                int i12 = aVar.h;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & 112) {
                    case 16:
                        i11 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + aVar.topMargin) - aVar.bottomMargin;
                        break;
                    case 48:
                        i11 = paddingTop + aVar.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[1] - i7;
                            break;
                        }
                        break;
                    case 80:
                        i11 = (paddingBottom - measuredHeight) - aVar.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[2] - (b.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                if (c(i10)) {
                    i7 = this.l + paddingLeft;
                } else {
                    i7 = paddingLeft;
                }
                paddingLeft = i7 + aVar.leftMargin;
                a(b, paddingLeft + a(b), i11, measuredWidth, measuredHeight);
                paddingLeft += (aVar.rightMargin + measuredWidth) + b(b);
                i7 = a(b, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.d;
    }

    public void setGravity(int i) {
        if (this.e != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.e & 8388615) != i2) {
            this.e = i2 | (this.e & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.e & 112) != i2) {
            this.e = i2 | (this.e & -113);
            requestLayout();
        }
    }

    public a b(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    protected a g() {
        if (this.d == 0) {
            return new a(-2, -2);
        }
        if (this.d == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    protected a b(LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ad.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ad.class.getName());
        }
    }
}
