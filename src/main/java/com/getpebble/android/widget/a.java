package com.getpebble.android.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.getpebble.android.basalt.R;

public class a {
    public static void a(Context context, String str, String str2, String str3, int i) {
        if (!TextUtils.isEmpty(str)) {
            View inflate = View.inflate(context, R.layout.custom_toast, null);
            TextView textView = (TextView) inflate.findViewById(R.id.txt_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.txt_description);
            CharSequence spannableString = new SpannableString(str);
            spannableString.setSpan(new StyleSpan(1), 0, str.length(), 33);
            if (TextUtils.isEmpty(str2)) {
                textView.setText(spannableString);
            } else {
                textView.setText(new SpannableStringBuilder(spannableString).append(" ").append(str2));
            }
            if (TextUtils.isEmpty(str3)) {
                textView2.setVisibility(8);
            } else {
                textView2.setTextColor(i);
                textView2.setText(str3);
            }
            Toast toast = new Toast(context);
            toast.setDuration(1);
            toast.setView(inflate);
            toast.show();
        }
    }

    public static void a(Context context, String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            View inflate = View.inflate(context, R.layout.custom_toast, null);
            TextView textView = (TextView) inflate.findViewById(R.id.txt_title);
            ((TextView) inflate.findViewById(R.id.txt_description)).setVisibility(8);
            textView.setTextColor(i);
            textView.setText(str);
            Toast toast = new Toast(context);
            toast.setDuration(1);
            toast.setView(inflate);
            toast.show();
        }
    }
}
