package com.getpebble.android.onboarding.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.b.n;
import com.getpebble.android.common.framework.widget.AsyncImageView;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.am.c;
import com.getpebble.android.onboarding.a.a;
import com.getpebble.android.widget.PebbleButton;
import com.getpebble.android.widget.PebbleTextView;

@SuppressLint({"ViewConstructor"})
public class b extends a {
    AsyncImageView b;
    PebbleTextView c;
    PebbleTextView d;
    PebbleTextView e;
    PebbleButton f;

    public b(Context context, a aVar) {
        super(context, aVar);
        View inflate = LayoutInflater.from(context).inflate(R.layout.app_card_layout, this, true);
        this.a = aVar;
        this.b = (AsyncImageView) inflate.findViewById(R.id.app_screenshot);
        this.c = (PebbleTextView) inflate.findViewById(R.id.app_title);
        this.d = (PebbleTextView) inflate.findViewById(R.id.app_category);
        this.e = (PebbleTextView) inflate.findViewById(R.id.app_description);
        this.f = (PebbleButton) inflate.findViewById(R.id.app_add_button);
    }

    public void a(c cVar, boolean z) {
        if (cVar == null) {
            f.b("AppCardView", "Record is null");
            return;
        }
        com.getpebble.android.common.model.am.b.a a;
        ak.a r = PebbleApplication.r();
        com.getpebble.android.common.framework.install.app.b.a aVar = com.getpebble.android.common.framework.install.app.b.a.BASALT;
        if (r != null) {
            aVar = r.hwPlatform.getPlatformCode();
            a = cVar.H.a(aVar);
        } else {
            a = null;
        }
        com.getpebble.android.common.framework.install.app.b.b shape = aVar.getShape();
        if (a == null || TextUtils.isEmpty(a.g)) {
            this.b.setBackgroundResource(R.drawable.watchface_placeholder_icon);
        } else {
            this.b.a(a.g, n.a(shape, a.h, 10), a);
        }
        this.c.setText(cVar.c);
        this.d.setText(cVar.w);
        if (a == null || TextUtils.isEmpty(a.d)) {
            this.e.setText(null);
        } else {
            this.e.setText(a.d);
        }
        b(cVar, z);
    }

    protected void b(final c cVar, boolean z) {
        int i;
        int i2;
        OnClickListener onClickListener = null;
        if (z) {
            i = R.string.onboarding_grab_apps_added_btn;
            i2 = R.drawable.btn_green_selected;
        } else {
            i = R.string.onboarding_grab_apps_add_btn;
            i2 = R.drawable.btn_orange_support;
            onClickListener = new OnClickListener(this) {
                final /* synthetic */ b b;

                public void onClick(View view) {
                    this.b.a(cVar);
                    this.b.b(cVar, true);
                }
            };
        }
        this.f.setOnClickListener(onClickListener);
        this.f.setBackgroundResource(i2);
        this.f.setText(i);
    }
}
