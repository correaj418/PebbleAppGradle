package com.getpebble.android.main.sections.mypebble.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.f;
import android.support.v4.view.ac;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;

public class SlidingTabLayout extends HorizontalScrollView {
    private int a;
    private int b;
    private int c;
    private boolean d;
    private b e;
    private ViewPager f;
    private ArrayList<String> g;
    private f h;
    private final b i;

    public interface b {
        void a(int i);
    }

    private class a implements f {
        final /* synthetic */ SlidingTabLayout a;
        private int b;

        private a(SlidingTabLayout slidingTabLayout) {
            this.a = slidingTabLayout;
        }

        public void a(int i, float f, int i2) {
            int childCount = this.a.i.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                this.a.i.a(i, f);
                View childAt = this.a.i.getChildAt(i);
                this.a.b(i, childAt != null ? (int) (((float) childAt.getWidth()) * f) : 0);
                if (this.a.h != null) {
                    this.a.h.a(i, f, i2);
                }
            }
        }

        public void b(int i) {
            this.b = i;
            if (this.a.h != null) {
                this.a.h.b(i);
            }
        }

        public void a(int i) {
            if (this.b == 0) {
                this.a.i.a(i, 0.0f);
                this.a.b(i, 0);
            }
            for (int i2 = 0; i2 < this.a.i.getChildCount(); i2++) {
                boolean z;
                View childAt = this.a.i.getChildAt(i2);
                if (i == i2) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
            if (this.a.h != null) {
                this.a.h.a(i);
            }
        }
    }

    private class c implements OnClickListener {
        final /* synthetic */ SlidingTabLayout a;

        private c(SlidingTabLayout slidingTabLayout) {
            this.a = slidingTabLayout;
        }

        public void onClick(View view) {
            for (int i = 0; i < this.a.i.getChildCount(); i++) {
                if (view == this.a.i.getChildAt(i)) {
                    if (this.a.e != null) {
                        this.a.e.a(i);
                    }
                    this.a.f.setCurrentItem(i);
                    return;
                }
            }
        }
    }

    public interface d {
        int a(int i);
    }

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.a = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.i = new b(context);
        addView(this.i, -1, -2);
    }

    public void setCustomTabColorizer(d dVar) {
        this.i.a(dVar);
    }

    public void setDistributeEvenly(boolean z) {
        this.d = z;
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.i.a(iArr);
    }

    public void setOnPageChangeListener(f fVar) {
        this.h = fVar;
    }

    public void a(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    public void setViewPager(ViewPager viewPager) {
        this.i.removeAllViews();
        this.f = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            b();
        }
    }

    protected TextView a(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(-1);
        textView.setLayoutParams(new LayoutParams(-2, -2));
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(16843534, typedValue, true);
        textView.setBackgroundResource(typedValue.resourceId);
        textView.setAllCaps(true);
        int i = (int) (16.0f * getResources().getDisplayMetrics().density);
        textView.setPadding(i, i, i, i);
        return textView;
    }

    private void b() {
        ac adapter = this.f.getAdapter();
        OnClickListener cVar = new c();
        for (int i = 0; i < adapter.a(); i++) {
            View inflate;
            TextView textView;
            TextView textView2;
            if (this.b != 0) {
                inflate = LayoutInflater.from(getContext()).inflate(this.b, this.i, false);
                textView = (TextView) inflate.findViewById(this.c);
            } else {
                textView = null;
                inflate = null;
            }
            if (inflate == null) {
                inflate = a(getContext());
            }
            if (textView == null && TextView.class.isInstance(inflate)) {
                textView2 = (TextView) inflate;
            } else {
                textView2 = textView;
            }
            if (this.d) {
                LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            }
            textView2.setText(adapter.a(i));
            inflate.setOnClickListener(cVar);
            inflate.setContentDescription((CharSequence) this.g.get(i));
            this.i.addView(inflate);
            if (i == this.f.getCurrentItem()) {
                inflate.setSelected(true);
            }
        }
    }

    public void a() {
        ac adapter = this.f.getAdapter();
        for (int i = 0; i < adapter.a(); i++) {
            Object obj;
            TextView textView;
            TextView textView2;
            if (this.b != 0) {
                View inflate = LayoutInflater.from(getContext()).inflate(this.b, this.i, false);
                obj = inflate;
                textView = (TextView) inflate.findViewById(this.c);
            } else {
                textView = null;
                obj = null;
            }
            if (obj == null) {
                obj = a(getContext());
            }
            if (textView == null && TextView.class.isInstance(obj)) {
                textView2 = (TextView) obj;
            } else {
                textView2 = textView;
            }
            textView2.setText(adapter.a(i));
        }
    }

    public void setContentDescriptions(ArrayList<String> arrayList) {
        this.g = arrayList;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f != null) {
            b(this.f.getCurrentItem(), 0);
        }
    }

    private void b(int i, int i2) {
        int childCount = this.i.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount) {
            View childAt = this.i.getChildAt(i);
            if (childAt != null) {
                childCount = childAt.getLeft() + i2;
                if (i > 0 || i2 > 0) {
                    childCount -= this.a;
                }
                scrollTo(childCount, 0);
            }
        }
    }

    public void setOnTabStripClickedListener(b bVar) {
        this.e = bVar;
    }
}
