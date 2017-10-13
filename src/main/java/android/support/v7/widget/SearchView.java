package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.view.AbsSavedState;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends ad implements android.support.v7.view.b {
    static final a a = new a();
    private static final boolean b;
    private boolean A;
    private boolean B;
    private android.support.v4.widget.b C;
    private boolean D;
    private CharSequence E;
    private boolean F;
    private boolean G;
    private int H;
    private boolean I;
    private CharSequence J;
    private boolean K;
    private int L;
    private SearchableInfo M;
    private Bundle N;
    private Runnable O;
    private final Runnable P;
    private Runnable Q;
    private final WeakHashMap<String, ConstantState> R;
    private final SearchAutoComplete c;
    private final View d;
    private final View e;
    private final ImageView f;
    private final ImageView g;
    private final ImageView h;
    private final ImageView i;
    private e j;
    private Rect k;
    private Rect l;
    private int[] m;
    private int[] n;
    private final ImageView o;
    private final Drawable p;
    private final int q;
    private final int r;
    private final Intent s;
    private final Intent t;
    private final CharSequence u;
    private c v;
    private b w;
    private OnFocusChangeListener x;
    private d y;
    private OnClickListener z;

    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = android.support.v4.d.d.a(new android.support.v4.d.e<SavedState>() {
            public /* synthetic */ Object a(Parcel parcel, ClassLoader classLoader) {
                return b(parcel, classLoader);
            }

            public /* synthetic */ Object[] a(int i) {
                return b(i);
            }

            public SavedState b(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] b(int i) {
                return new SavedState[i];
            }
        });
        boolean b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.b));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.b + "}";
        }
    }

    public static class SearchAutoComplete extends g {
        private int a;
        private SearchView b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, android.support.v7.b.a.a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.a = getThreshold();
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.a = i;
        }

        protected void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.a(getContext())) {
                    SearchView.a.a(this, true);
                }
            }
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.b.d();
        }

        public boolean enoughToFilter() {
            return this.a <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.b.clearFocus();
                        this.b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int b = android.support.v4.content.a.a.b(getResources());
            int a = android.support.v4.content.a.a.a(getResources());
            if (b >= 960 && a >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (b >= 600 || (b >= 640 && a >= 480)) {
                return 192;
            }
            return 160;
        }
    }

    private static class a {
        private Method a;
        private Method b;
        private Method c;
        private Method d;

        a() {
            try {
                this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.d.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            if (this.a != null) {
                try {
                    this.a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            if (this.b != null) {
                try {
                    this.b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.c != null) {
                try {
                    this.c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception e) {
                }
            }
        }
    }

    public interface b {
        boolean a();
    }

    public interface c {
        boolean a(String str);
    }

    public interface d {
    }

    private static class e extends TouchDelegate {
        private final View a;
        private final Rect b = new Rect();
        private final Rect c = new Rect();
        private final Rect d = new Rect();
        private final int e;
        private boolean f;

        public e(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.b.set(rect);
            this.d.set(rect);
            this.d.inset(-this.e, -this.e);
            this.c.set(rect2);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
            r6 = this;
            r1 = 1;
            r0 = 0;
            r2 = r7.getX();
            r3 = (int) r2;
            r2 = r7.getY();
            r4 = (int) r2;
            r2 = r7.getAction();
            switch(r2) {
                case 0: goto L_0x003c;
                case 1: goto L_0x0048;
                case 2: goto L_0x0048;
                case 3: goto L_0x0056;
                default: goto L_0x0013;
            };
        L_0x0013:
            r2 = r0;
        L_0x0014:
            if (r2 == 0) goto L_0x003b;
        L_0x0016:
            if (r1 == 0) goto L_0x005b;
        L_0x0018:
            r0 = r6.c;
            r0 = r0.contains(r3, r4);
            if (r0 != 0) goto L_0x005b;
        L_0x0020:
            r0 = r6.a;
            r0 = r0.getWidth();
            r0 = r0 / 2;
            r0 = (float) r0;
            r1 = r6.a;
            r1 = r1.getHeight();
            r1 = r1 / 2;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
        L_0x0035:
            r0 = r6.a;
            r0 = r0.dispatchTouchEvent(r7);
        L_0x003b:
            return r0;
        L_0x003c:
            r2 = r6.b;
            r2 = r2.contains(r3, r4);
            if (r2 == 0) goto L_0x0013;
        L_0x0044:
            r6.f = r1;
            r2 = r1;
            goto L_0x0014;
        L_0x0048:
            r2 = r6.f;
            if (r2 == 0) goto L_0x0014;
        L_0x004c:
            r5 = r6.d;
            r5 = r5.contains(r3, r4);
            if (r5 != 0) goto L_0x0014;
        L_0x0054:
            r1 = r0;
            goto L_0x0014;
        L_0x0056:
            r2 = r6.f;
            r6.f = r0;
            goto L_0x0014;
        L_0x005b:
            r0 = r6.c;
            r0 = r0.left;
            r0 = r3 - r0;
            r0 = (float) r0;
            r1 = r6.c;
            r1 = r1.top;
            r1 = r4 - r1;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
            goto L_0x0035;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.e.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 8) {
            z = true;
        } else {
            z = false;
        }
        b = z;
    }

    int getSuggestionRowLayout() {
        return this.q;
    }

    int getSuggestionCommitIconResId() {
        return this.r;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.M = searchableInfo;
        if (this.M != null) {
            if (b) {
                l();
            }
            k();
        }
        boolean z = b && e();
        this.I = z;
        if (this.I) {
            this.c.setPrivateImeOptions("nm");
        }
        a(c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.N = bundle;
    }

    public void setImeOptions(int i) {
        this.c.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.c.getImeOptions();
    }

    public void setInputType(int i) {
        this.c.setInputType(i);
    }

    public int getInputType() {
        return this.c.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.G || !isFocusable()) {
            return false;
        }
        if (c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.c.requestFocus(i, rect);
        if (requestFocus) {
            a(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.G = true;
        setImeVisibility(false);
        super.clearFocus();
        this.c.clearFocus();
        this.G = false;
    }

    public void setOnQueryTextListener(c cVar) {
        this.v = cVar;
    }

    public void setOnCloseListener(b bVar) {
        this.w = bVar;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.x = onFocusChangeListener;
    }

    public void setOnSuggestionListener(d dVar) {
        this.y = dVar;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.z = onClickListener;
    }

    public CharSequence getQuery() {
        return this.c.getText();
    }

    public void a(CharSequence charSequence, boolean z) {
        this.c.setText(charSequence);
        if (charSequence != null) {
            this.c.setSelection(this.c.length());
            this.J = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.E = charSequence;
        k();
    }

    public CharSequence getQueryHint() {
        if (this.E != null) {
            return this.E;
        }
        if (!b || this.M == null || this.M.getHintId() == 0) {
            return this.u;
        }
        return getContext().getText(this.M.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.A != z) {
            this.A = z;
            a(z);
            k();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            o();
        } else {
            p();
        }
    }

    public boolean c() {
        return this.B;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.D = z;
        a(c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.F = z;
        if (this.C instanceof at) {
            ((at) this.C).a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(android.support.v4.widget.b bVar) {
        this.C = bVar;
        this.c.setAdapter(this.C);
    }

    public android.support.v4.widget.b getSuggestionsAdapter() {
        return this.C;
    }

    public void setMaxWidth(int i) {
        this.H = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.H;
    }

    protected void onMeasure(int i, int i2) {
        if (c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.H <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.H, size);
                    break;
                }
            case 0:
                if (this.H <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.H;
                    break;
                }
            case 1073741824:
                if (this.H > 0) {
                    size = Math.min(this.H, size);
                    break;
                }
                break;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        switch (mode2) {
            case Integer.MIN_VALUE:
            case 0:
                mode = Math.min(getPreferredHeight(), mode);
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(mode, 1073741824));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            a(this.c, this.k);
            this.l.set(this.k.left, 0, this.k.right, i4 - i2);
            if (this.j == null) {
                this.j = new e(this.l, this.k, this.c);
                setTouchDelegate(this.j);
                return;
            }
            this.j.a(this.l, this.k);
        }
    }

    private void a(View view, Rect rect) {
        view.getLocationInWindow(this.m);
        getLocationInWindow(this.n);
        int i = this.m[1] - this.n[1];
        int i2 = this.m[0] - this.n[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(android.support.v7.b.a.d.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(android.support.v7.b.a.d.abc_search_view_preferred_height);
    }

    private void a(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.B = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.c.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f.setVisibility(i2);
        b(z2);
        View view = this.d;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        if (!(this.o.getDrawable() == null || this.A)) {
            i = 0;
        }
        this.o.setVisibility(i);
        i();
        if (z2) {
            z3 = false;
        }
        c(z3);
        h();
    }

    @TargetApi(8)
    private boolean e() {
        if (this.M == null || !this.M.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.M.getVoiceSearchLaunchWebSearch()) {
            intent = this.s;
        } else if (this.M.getVoiceSearchLaunchRecognizer()) {
            intent = this.t;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    private boolean f() {
        return (this.D || this.I) && !c();
    }

    private void b(boolean z) {
        int i = 8;
        if (this.D && f() && hasFocus() && (z || !this.I)) {
            i = 0;
        }
        this.g.setVisibility(i);
    }

    private void h() {
        int i = 8;
        if (f() && (this.g.getVisibility() == 0 || this.i.getVisibility() == 0)) {
            i = 0;
        }
        this.e.setVisibility(i);
    }

    private void i() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.c.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.A || this.K)) {
            i = 0;
        }
        ImageView imageView = this.h;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.h.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void j() {
        post(this.P);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.P);
        post(this.Q);
        super.onDetachedFromWindow();
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.O);
            return;
        }
        removeCallbacks(this.O);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    void a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    private CharSequence b(CharSequence charSequence) {
        if (!this.A || this.p == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.c.getTextSize()) * 1.25d);
        this.p.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.p), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void k() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.c;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(b(queryHint));
    }

    @TargetApi(8)
    private void l() {
        int i = 1;
        this.c.setThreshold(this.M.getSuggestThreshold());
        this.c.setImeOptions(this.M.getImeOptions());
        int inputType = this.M.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.M.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.c.setInputType(inputType);
        if (this.C != null) {
            this.C.a(null);
        }
        if (this.M.getSuggestAuthority() != null) {
            this.C = new at(getContext(), this, this.M, this.R);
            this.c.setAdapter(this.C);
            at atVar = (at) this.C;
            if (this.F) {
                i = 2;
            }
            atVar.a(i);
        }
    }

    private void c(boolean z) {
        int i;
        if (this.I && !c() && z) {
            i = 0;
            this.g.setVisibility(8);
        } else {
            i = 8;
        }
        this.i.setVisibility(i);
    }

    private void m() {
        CharSequence text = this.c.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.v == null || !this.v.a(text.toString())) {
                if (this.M != null) {
                    a(0, null, text.toString());
                }
                setImeVisibility(false);
                n();
            }
        }
    }

    private void n() {
        this.c.dismissDropDown();
    }

    private void o() {
        if (!TextUtils.isEmpty(this.c.getText())) {
            this.c.setText("");
            this.c.requestFocus();
            setImeVisibility(true);
        } else if (!this.A) {
        } else {
            if (this.w == null || !this.w.a()) {
                clearFocus();
                a(true);
            }
        }
    }

    private void p() {
        a(false);
        this.c.requestFocus();
        setImeVisibility(true);
        if (this.z != null) {
            this.z.onClick(this);
        }
    }

    void d() {
        a(c());
        j();
        if (this.c.hasFocus()) {
            q();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        j();
    }

    public void b() {
        a((CharSequence) "", false);
        clearFocus();
        a(true);
        this.c.setImeOptions(this.L);
        this.K = false;
    }

    public void a() {
        if (!this.K) {
            this.K = true;
            this.L = this.c.getImeOptions();
            this.c.setImeOptions(this.L | 33554432);
            this.c.setText("");
            setIconified(false);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.b = c();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.a());
            a(savedState.b);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void setQuery(CharSequence charSequence) {
        this.c.setText(charSequence);
        this.c.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private void a(int i, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.J);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.N != null) {
            intent.putExtra("app_data", this.N);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (b) {
            intent.setComponent(this.M.getSearchActivity());
        }
        return intent;
    }

    private void q() {
        a.a(this.c);
        a.b(this.c);
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
