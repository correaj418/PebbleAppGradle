package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ae;
import android.support.v4.view.ah;
import android.support.v7.b.a.h;
import android.support.v7.b.a.k;
import android.support.v7.view.c;
import android.support.v7.view.menu.q;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class m extends Spinner implements ae {
    private static final boolean a;
    private static final boolean b;
    private static final int[] c = new int[]{16843505};
    private i d;
    private h e;
    private Context f;
    private ab g;
    private SpinnerAdapter h;
    private boolean i;
    private b j;
    private int k;
    private final Rect l;

    private static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter a;
        private ListAdapter b;

        public a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (m.a && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof av) {
                av avVar = (av) spinnerAdapter;
                if (avVar.a() == null) {
                    avVar.a(theme);
                }
            }
        }

        public int getCount() {
            return this.a == null ? 0 : this.a.getCount();
        }

        public Object getItem(int i) {
            return this.a == null ? null : this.a.getItem(i);
        }

        public long getItemId(int i) {
            return this.a == null ? -1 : this.a.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.a == null) {
                return null;
            }
            return this.a.getDropDownView(i, view, viewGroup);
        }

        public boolean hasStableIds() {
            return this.a != null && this.a.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    private class b extends af {
        final /* synthetic */ m a;
        private CharSequence d;
        private ListAdapter e;
        private final Rect f = new Rect();

        public b(final m mVar, Context context, AttributeSet attributeSet, int i) {
            this.a = mVar;
            super(context, attributeSet, i);
            a((View) mVar);
            a(true);
            a(0);
            a(new OnItemClickListener(this) {
                final /* synthetic */ b b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.b.a.setSelection(i);
                    if (this.b.a.getOnItemClickListener() != null) {
                        this.b.a.performItemClick(view, i, this.b.e.getItemId(i));
                    }
                    this.b.c();
                }
            });
        }

        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.e = listAdapter;
        }

        public CharSequence b() {
            return this.d;
        }

        public void a(CharSequence charSequence) {
            this.d = charSequence;
        }

        void f() {
            int i;
            int i2;
            Drawable h = h();
            if (h != null) {
                h.getPadding(this.a.l);
                if (bd.a(this.a)) {
                    i = this.a.l.right;
                } else {
                    i = -this.a.l.left;
                }
                i2 = i;
            } else {
                Rect b = this.a.l;
                this.a.l.right = 0;
                b.left = 0;
                i2 = 0;
            }
            int paddingLeft = this.a.getPaddingLeft();
            int paddingRight = this.a.getPaddingRight();
            int width = this.a.getWidth();
            if (this.a.k == -2) {
                int a = this.a.a((SpinnerAdapter) this.e, h());
                i = (this.a.getContext().getResources().getDisplayMetrics().widthPixels - this.a.l.left) - this.a.l.right;
                if (a <= i) {
                    i = a;
                }
                g(Math.max(i, (width - paddingLeft) - paddingRight));
            } else if (this.a.k == -1) {
                g((width - paddingLeft) - paddingRight);
            } else {
                g(this.a.k);
            }
            if (bd.a(this.a)) {
                i = ((width - paddingRight) - l()) + i2;
            } else {
                i = i2 + paddingLeft;
            }
            c(i);
        }

        public void a() {
            boolean d = d();
            f();
            h(2);
            super.a();
            e().setChoiceMode(1);
            i(this.a.getSelectedItemPosition());
            if (!d) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener anonymousClass2 = new OnGlobalLayoutListener(this) {
                        final /* synthetic */ b a;

                        {
                            this.a = r1;
                        }

                        public void onGlobalLayout() {
                            if (this.a.b(this.a.a)) {
                                this.a.f();
                                super.a();
                                return;
                            }
                            this.a.c();
                        }
                    };
                    viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
                    a(new OnDismissListener(this) {
                        final /* synthetic */ b b;

                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = this.b.a.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(anonymousClass2);
                            }
                        }
                    });
                }
            }
        }

        private boolean b(View view) {
            return ah.y(view) && view.getGlobalVisibleRect(this.f);
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        a = z;
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        b = z;
    }

    public m(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public m(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public m(Context context, AttributeSet attributeSet, int i, int i2, Theme theme) {
        Throwable e;
        final b bVar;
        az a;
        CharSequence[] e2;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.l = new Rect();
        az a2 = az.a(context, attributeSet, k.Spinner, i, 0);
        this.d = i.a();
        this.e = new h(this, this.d);
        if (theme != null) {
            this.f = new c(context, theme);
        } else {
            int g = a2.g(k.Spinner_popupTheme, 0);
            if (g != 0) {
                this.f = new c(context, g);
            } else {
                this.f = !a ? context : null;
            }
        }
        if (this.f != null) {
            if (i2 == -1) {
                if (VERSION.SDK_INT >= 11) {
                    TypedArray obtainStyledAttributes;
                    try {
                        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c, i, 0);
                        try {
                            if (obtainStyledAttributes.hasValue(0)) {
                                i2 = obtainStyledAttributes.getInt(0, 0);
                            }
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                if (i2 == 1) {
                                    bVar = new b(this, this.f, attributeSet, i);
                                    a = az.a(this.f, attributeSet, k.Spinner, i, 0);
                                    this.k = a.f(k.Spinner_android_dropDownWidth, -2);
                                    bVar.a(a.a(k.Spinner_android_popupBackground));
                                    bVar.a(a2.c(k.Spinner_android_prompt));
                                    a.a();
                                    this.j = bVar;
                                    this.g = new ab(this, this) {
                                        final /* synthetic */ m b;

                                        public q a() {
                                            return bVar;
                                        }

                                        public boolean b() {
                                            if (!this.b.j.d()) {
                                                this.b.j.a();
                                            }
                                            return true;
                                        }
                                    };
                                }
                                e2 = a2.e(k.Spinner_android_entries);
                                if (e2 != null) {
                                    arrayAdapter = new ArrayAdapter(context, 17367048, e2);
                                    arrayAdapter.setDropDownViewResource(h.support_simple_spinner_dropdown_item);
                                    setAdapter(arrayAdapter);
                                }
                                a2.a();
                                this.i = true;
                                if (this.h != null) {
                                    setAdapter(this.h);
                                    this.h = null;
                                }
                                this.e.a(attributeSet, i);
                            } catch (Throwable th) {
                                e = th;
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        obtainStyledAttributes = null;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            bVar = new b(this, this.f, attributeSet, i);
                            a = az.a(this.f, attributeSet, k.Spinner, i, 0);
                            this.k = a.f(k.Spinner_android_dropDownWidth, -2);
                            bVar.a(a.a(k.Spinner_android_popupBackground));
                            bVar.a(a2.c(k.Spinner_android_prompt));
                            a.a();
                            this.j = bVar;
                            this.g = /* anonymous class already generated */;
                        }
                        e2 = a2.e(k.Spinner_android_entries);
                        if (e2 != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, e2);
                            arrayAdapter.setDropDownViewResource(h.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a2.a();
                        this.i = true;
                        if (this.h != null) {
                            setAdapter(this.h);
                            this.h = null;
                        }
                        this.e.a(attributeSet, i);
                    } catch (Throwable th2) {
                        e = th2;
                        obtainStyledAttributes = null;
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        throw e;
                    }
                }
                i2 = 1;
            }
            if (i2 == 1) {
                bVar = new b(this, this.f, attributeSet, i);
                a = az.a(this.f, attributeSet, k.Spinner, i, 0);
                this.k = a.f(k.Spinner_android_dropDownWidth, -2);
                bVar.a(a.a(k.Spinner_android_popupBackground));
                bVar.a(a2.c(k.Spinner_android_prompt));
                a.a();
                this.j = bVar;
                this.g = /* anonymous class already generated */;
            }
        }
        e2 = a2.e(k.Spinner_android_entries);
        if (e2 != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, e2);
            arrayAdapter.setDropDownViewResource(h.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a2.a();
        this.i = true;
        if (this.h != null) {
            setAdapter(this.h);
            this.h = null;
        }
        this.e.a(attributeSet, i);
    }

    public Context getPopupContext() {
        if (this.j != null) {
            return this.f;
        }
        if (a) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.j != null) {
            this.j.a(drawable);
        } else if (b) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(android.support.v4.content.a.a(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.j != null) {
            return this.j.h();
        }
        if (b) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.j != null) {
            this.j.d(i);
        } else if (b) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.j != null) {
            return this.j.k();
        }
        if (b) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.j != null) {
            this.j.c(i);
        } else if (b) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.j != null) {
            return this.j.j();
        }
        if (b) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.j != null) {
            this.k = i;
        } else if (b) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.j != null) {
            return this.k;
        }
        if (b) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.i) {
            super.setAdapter(spinnerAdapter);
            if (this.j != null) {
                this.j.a(new a(spinnerAdapter, (this.f == null ? getContext() : this.f).getTheme()));
                return;
            }
            return;
        }
        this.h = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.j != null && this.j.d()) {
            this.j.c();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.g == null || !this.g.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.j != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.j == null) {
            return super.performClick();
        }
        if (!this.j.d()) {
            this.j.a();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.j != null) {
            this.j.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.j != null ? this.j.b() : super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.e != null) {
            this.e.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.e != null) {
            this.e.a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.e != null) {
            this.e.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.e != null ? this.e.a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.e != null) {
            this.e.a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.e != null ? this.e.b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.e != null) {
            this.e.c();
        }
    }

    private int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.l);
        return (this.l.left + this.l.right) + i;
    }
}
