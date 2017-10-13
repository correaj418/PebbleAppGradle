package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ar extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator j = new DecelerateInterpolator();
    Runnable a;
    int b;
    int c;
    private b d;
    private ad e;
    private Spinner f;
    private boolean g;
    private int h;
    private int i;

    private class a extends BaseAdapter {
        final /* synthetic */ ar a;

        private a(ar arVar) {
            this.a = arVar;
        }

        public int getCount() {
            return this.a.e.getChildCount();
        }

        public Object getItem(int i) {
            return ((c) this.a.e.getChildAt(i)).b();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return this.a.a((android.support.v7.a.a.b) getItem(i), true);
            }
            ((c) view).a((android.support.v7.a.a.b) getItem(i));
            return view;
        }
    }

    private class b implements OnClickListener {
        final /* synthetic */ ar a;

        private b(ar arVar) {
            this.a = arVar;
        }

        public void onClick(View view) {
            ((c) view).b().d();
            int childCount = this.a.e.getChildCount();
            for (int i = 0; i < childCount; i++) {
                boolean z;
                View childAt = this.a.e.getChildAt(i);
                if (childAt == view) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    private class c extends ad implements OnLongClickListener {
        final /* synthetic */ ar a;
        private final int[] b = new int[]{16842964};
        private android.support.v7.a.a.b c;
        private TextView d;
        private ImageView e;
        private View f;

        public c(ar arVar, Context context, android.support.v7.a.a.b bVar, boolean z) {
            this.a = arVar;
            super(context, null, android.support.v7.b.a.a.actionBarTabStyle);
            this.c = bVar;
            az a = az.a(context, null, this.b, android.support.v7.b.a.a.actionBarTabStyle, 0);
            if (a.f(0)) {
                setBackgroundDrawable(a.a(0));
            }
            a.a();
            if (z) {
                setGravity(8388627);
            }
            a();
        }

        public void a(android.support.v7.a.a.b bVar) {
            this.c = bVar;
            a();
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.a.a.b.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(android.support.v7.a.a.b.class.getName());
            }
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.a.b > 0 && getMeasuredWidth() > this.a.b) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.a.b, 1073741824), i2);
            }
        }

        public void a() {
            android.support.v7.a.a.b bVar = this.c;
            View c = bVar.c();
            if (c != null) {
                c parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(c);
                    }
                    addView(c);
                }
                this.f = c;
                if (this.d != null) {
                    this.d.setVisibility(8);
                }
                if (this.e != null) {
                    this.e.setVisibility(8);
                    this.e.setImageDrawable(null);
                    return;
                }
                return;
            }
            boolean z;
            if (this.f != null) {
                removeView(this.f);
                this.f = null;
            }
            Drawable a = bVar.a();
            CharSequence b = bVar.b();
            if (a != null) {
                if (this.e == null) {
                    View imageView = new ImageView(getContext());
                    LayoutParams aVar = new android.support.v7.widget.ad.a(-2, -2);
                    aVar.h = 16;
                    imageView.setLayoutParams(aVar);
                    addView(imageView, 0);
                    this.e = imageView;
                }
                this.e.setImageDrawable(a);
                this.e.setVisibility(0);
            } else if (this.e != null) {
                this.e.setVisibility(8);
                this.e.setImageDrawable(null);
            }
            if (TextUtils.isEmpty(b)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (this.d == null) {
                    imageView = new p(getContext(), null, android.support.v7.b.a.a.actionBarTabTextStyle);
                    imageView.setEllipsize(TruncateAt.END);
                    aVar = new android.support.v7.widget.ad.a(-2, -2);
                    aVar.h = 16;
                    imageView.setLayoutParams(aVar);
                    addView(imageView);
                    this.d = imageView;
                }
                this.d.setText(b);
                this.d.setVisibility(0);
            } else if (this.d != null) {
                this.d.setVisibility(8);
                this.d.setText(null);
            }
            if (this.e != null) {
                this.e.setContentDescription(bVar.e());
            }
            if (z || TextUtils.isEmpty(bVar.e())) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.c.e(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        public android.support.v7.a.a.b b() {
            return this.c;
        }
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.b = -1;
        } else {
            if (childCount > 2) {
                this.b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.b = MeasureSpec.getSize(i) / 2;
            }
            this.b = Math.min(this.b, this.c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (z || !this.g) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.e.measure(0, mode);
            if (this.e.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                b();
            } else {
                c();
            }
        } else {
            c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.i);
        }
    }

    private boolean a() {
        return this.f != null && this.f.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.g = z;
    }

    private void b() {
        if (!a()) {
            if (this.f == null) {
                this.f = d();
            }
            removeView(this.e);
            addView(this.f, new LayoutParams(-2, -1));
            if (this.f.getAdapter() == null) {
                this.f.setAdapter(new a());
            }
            if (this.a != null) {
                removeCallbacks(this.a);
                this.a = null;
            }
            this.f.setSelection(this.i);
        }
    }

    private boolean c() {
        if (a()) {
            removeView(this.f);
            addView(this.e, new LayoutParams(-2, -1));
            setTabSelected(this.f.getSelectedItemPosition());
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.i = i;
        int childCount = this.e.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.e.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
        }
        if (this.f != null && i >= 0) {
            this.f.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.h = i;
        requestLayout();
    }

    private Spinner d() {
        Spinner mVar = new m(getContext(), null, android.support.v7.b.a.a.actionDropDownStyle);
        mVar.setLayoutParams(new android.support.v7.widget.ad.a(-2, -1));
        mVar.setOnItemSelectedListener(this);
        return mVar;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        android.support.v7.view.a a = android.support.v7.view.a.a(getContext());
        setContentHeight(a.e());
        this.c = a.f();
    }

    public void a(int i) {
        final View childAt = this.e.getChildAt(i);
        if (this.a != null) {
            removeCallbacks(this.a);
        }
        this.a = new Runnable(this) {
            final /* synthetic */ ar b;

            public void run() {
                this.b.smoothScrollTo(childAt.getLeft() - ((this.b.getWidth() - childAt.getWidth()) / 2), 0);
                this.b.a = null;
            }
        };
        post(this.a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            post(this.a);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            removeCallbacks(this.a);
        }
    }

    private c a(android.support.v7.a.a.b bVar, boolean z) {
        c cVar = new c(this, getContext(), bVar, z);
        if (z) {
            cVar.setBackgroundDrawable(null);
            cVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.h));
        } else {
            cVar.setFocusable(true);
            if (this.d == null) {
                this.d = new b();
            }
            cVar.setOnClickListener(this.d);
        }
        return cVar;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((c) view).b().d();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
