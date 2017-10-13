package android.support.v7.g;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public class a implements TransformationMethod {
    private Locale a;

    public a(Context context) {
        this.a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return charSequence != null ? charSequence.toString().toUpperCase(this.a) : null;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
