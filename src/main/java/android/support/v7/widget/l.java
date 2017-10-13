package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.b.a.k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

class l extends PopupWindow {
    private static final boolean a = (VERSION.SDK_INT < 21);
    private boolean b;

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i, 0);
    }

    @TargetApi(11)
    public l(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        az a = az.a(context, attributeSet, k.PopupWindow, i, i2);
        if (a.f(k.PopupWindow_overlapAnchor)) {
            a(a.a(k.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.a(k.PopupWindow_android_popupBackground));
        int i3 = VERSION.SDK_INT;
        if (i2 != 0 && i3 < 11 && i3 >= 9 && a.f(k.PopupWindow_android_popupAnimationStyle)) {
            setAnimationStyle(a.g(k.PopupWindow_android_popupAnimationStyle, -1));
        }
        a.a();
        if (VERSION.SDK_INT < 14) {
            a((PopupWindow) this);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (a && this.b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (a && this.b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height;
        if (a && this.b) {
            height = i2 - view.getHeight();
        } else {
            height = i2;
        }
        super.update(view, i, height, i3, i4);
    }

    private static void a(final PopupWindow popupWindow) {
        try {
            final Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            final OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) declaredField2.get(popupWindow);
            declaredField2.set(popupWindow, new OnScrollChangedListener() {
                public void onScrollChanged() {
                    try {
                        WeakReference weakReference = (WeakReference) declaredField.get(popupWindow);
                        if (weakReference != null && weakReference.get() != null) {
                            onScrollChangedListener.onScrollChanged();
                        }
                    } catch (IllegalAccessException e) {
                    }
                }
            });
        } catch (Throwable e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    public void a(boolean z) {
        if (a) {
            this.b = z;
        } else {
            android.support.v4.widget.k.a((PopupWindow) this, z);
        }
    }
}
