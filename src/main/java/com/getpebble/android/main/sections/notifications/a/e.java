package com.getpebble.android.main.sections.notifications.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ae;
import com.getpebble.android.common.model.ae.a;
import com.getpebble.android.widget.PebbleTextView;

public class e extends RelativeLayout {
    private PebbleTextView a;
    private PebbleTextView b;
    private Button c;
    private Button d;
    private a e;

    public e(final Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_mobile_alerts, this, true);
        this.a = (PebbleTextView) inflate.findViewById(R.id.title);
        this.b = (PebbleTextView) inflate.findViewById(R.id.description);
        this.c = (Button) inflate.findViewById(R.id.positive_button);
        this.c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e b;

            public void onClick(View view) {
                c.a(this.b.e.b);
                this.b.e.b.enable(context);
                ae.a(this.b.e.b, com.getpebble.android.common.a.K().getContentResolver());
            }
        });
        this.d = (Button) inflate.findViewById(R.id.negative_button);
        this.d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e b;

            public void onClick(View view) {
                this.b.e.b.disable(context);
                ae.a(this.b.e.b, com.getpebble.android.common.a.K().getContentResolver());
            }
        });
    }

    public void setModel(a aVar) {
        this.e = aVar;
        try {
            Context context = getContext();
            this.a.setText(context.getString(aVar.b.titleResId));
            this.b.setText(context.getString(aVar.b.descriptionResId));
            setText(aVar.b);
        } catch (Throwable e) {
            f.a("MobileAlertView", "error ", e);
        }
    }

    private void setText(com.getpebble.android.common.model.a aVar) {
        if (aVar.hasNegativeAction()) {
            this.d.setVisibility(0);
            this.d.setText(aVar.getActionIdNegative());
        } else {
            this.d.setVisibility(8);
        }
        this.c.setText(aVar.getActionIdPositive());
    }
}
