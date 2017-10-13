package com.getpebble.android.onboarding.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.widget.AsyncImageView;
import com.getpebble.android.common.model.am.b;
import com.getpebble.android.onboarding.a.a;
import com.getpebble.android.widget.PebbleButton;
import com.getpebble.android.widget.PebbleTextView;

public class c extends a {
    AsyncImageView b;
    PebbleTextView c;
    PebbleTextView d;
    PebbleTextView e;
    PebbleButton f;

    public c(Context context, a aVar) {
        super(context, aVar);
        View inflate = LayoutInflater.from(context).inflate(R.layout.timeline_app_card_view, this, true);
        this.a = aVar;
        this.b = (AsyncImageView) inflate.findViewById(R.id.app_icon);
        this.c = (PebbleTextView) inflate.findViewById(R.id.app_title);
        this.d = (PebbleTextView) inflate.findViewById(R.id.app_developer_name);
        this.e = (PebbleTextView) inflate.findViewById(R.id.app_description);
        this.f = (PebbleButton) inflate.findViewById(R.id.app_add_button);
    }

    public void a(com.getpebble.android.common.model.am.c cVar, boolean z) {
        if (cVar == null) {
            f.b("TimelineAppCardView", "Record is null");
            return;
        }
        b.a a = cVar.H.a(PebbleApplication.p().hwPlatform.getPlatformCode());
        if (a == null || TextUtils.isEmpty(a.e)) {
            this.b.setBackgroundResource(R.drawable.watchface_placeholder_icon_square);
        } else {
            this.b.a(a.e, new com.getpebble.android.common.framework.b.n.c(5), a);
        }
        this.c.setText(cVar.c);
        this.d.setText(cVar.i);
        if (a == null || TextUtils.isEmpty(a.d)) {
            this.e.setText(null);
        } else {
            this.e.setText(a.d);
        }
        b(cVar, z);
    }

    protected void b(final com.getpebble.android.common.model.am.c cVar, boolean z) {
        int i;
        int i2;
        OnClickListener onClickListener = null;
        if (z) {
            i = R.drawable.btn_green_selected;
            i2 = R.string.onboarding_grab_timeline_apps_setup_ok;
        } else {
            i = R.drawable.btn_orange_support;
            i2 = R.string.onboarding_grab_timeline_apps_setup;
            onClickListener = new OnClickListener(this) {
                final /* synthetic */ c b;

                public void onClick(View view) {
                    this.b.a(cVar);
                    this.b.b(cVar, true);
                }
            };
        }
        this.f.setBackgroundResource(i);
        this.f.setText(i2);
        this.f.setOnClickListener(onClickListener);
    }
}
