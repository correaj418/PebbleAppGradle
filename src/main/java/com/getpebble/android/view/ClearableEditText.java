package com.getpebble.android.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import com.getpebble.android.basalt.R;

public class ClearableEditText extends EditText {
    private Drawable a;
    private int b;

    public ClearableEditText(Context context) {
        super(context);
        a();
    }

    public ClearableEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ClearableEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.b = getContext().getResources().getDimensionPixelSize(R.dimen.clear_text_button_size);
        this.a = a.a(getContext(), (int) R.drawable.ic_close_circle_grey600_36dp);
        this.a.setBounds(0, 0, this.b, this.b);
        setClearIconVisible(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getCompoundDrawables()[2] != null) {
            if (motionEvent.getX() > ((float) ((getWidth() - getPaddingRight()) - this.b))) {
                if (motionEvent.getAction() != 1) {
                    return true;
                }
                setText(null);
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        setClearIconVisible(!TextUtils.isEmpty(charSequence));
    }

    protected void setClearIconVisible(boolean z) {
        if (z != (getCompoundDrawables()[2] != null)) {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.a : null, getCompoundDrawables()[3]);
        }
    }
}
