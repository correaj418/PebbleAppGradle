package com.getpebble.android.main.sections.notifications.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Switch;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.framework.widget.AsyncImageView;
import com.getpebble.android.widget.PebbleTextView;

public class b extends FrameLayout {
    private AsyncImageView a;
    private PebbleTextView b;
    private PebbleTextView c;
    private Switch d;
    private ImageButton e;

    public b(Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_android_app, this, true);
        this.a = (AsyncImageView) inflate.findViewById(R.id.icon);
        this.b = (PebbleTextView) inflate.findViewById(R.id.name);
        this.c = (PebbleTextView) inflate.findViewById(R.id.subtext);
        this.d = (Switch) inflate.findViewById(R.id.app_switch);
        this.e = (ImageButton) inflate.findViewById(R.id.actions);
    }

    public void setModel(c cVar) {
        a();
        cVar.a(this.b);
        cVar.b(this.c);
        cVar.a(this.a);
        cVar.a(this.e);
        cVar.a(this.d);
    }

    public void a() {
        this.a.a();
        this.d.setOnCheckedChangeListener(null);
        this.e.setOnClickListener(null);
    }
}
