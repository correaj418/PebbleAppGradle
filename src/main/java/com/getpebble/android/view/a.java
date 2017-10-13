package com.getpebble.android.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.getpebble.android.basalt.R;

public class a extends LinearLayout {
    boolean a = false;
    private TextView b;
    private ImageView c;

    public a(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_language_pack, this, true);
        this.b = (TextView) findViewById(R.id.language_name);
        this.c = (ImageView) findViewById(R.id.language_checkmark);
    }

    public void setLanguageName(String str) {
        this.b.setText(str);
    }

    public void setInstalled(boolean z) {
        if (this.a != z) {
            int i;
            if (z) {
                i = R.drawable.checked;
            } else {
                i = R.drawable.grid_checkmark_off;
            }
            this.c.setImageDrawable(getResources().getDrawable(i));
            this.a = z;
        }
    }
}
