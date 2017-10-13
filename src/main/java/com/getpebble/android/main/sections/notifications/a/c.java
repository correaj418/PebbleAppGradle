package com.getpebble.android.main.sections.notifications.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.framework.widget.AsyncImageView;
import com.getpebble.android.common.model.af;
import com.getpebble.android.common.model.af.a;
import com.getpebble.android.common.model.af.b;

public class c implements OnCheckedChangeListener {
    protected b a;
    protected Context b;

    public c(b bVar, Context context) {
        this.a = bVar;
        this.b = context;
    }

    public Context a() {
        return this.b;
    }

    public void a(TextView textView) {
        textView.setText(this.a.b);
        textView.setAlpha(this.a.e ? 1.0f : 0.35f);
    }

    public void a(CompoundButton compoundButton) {
        compoundButton.setChecked(this.a.d);
        compoundButton.setEnabled(this.a.e);
        compoundButton.setOnCheckedChangeListener(this);
    }

    public void a(View view) {
        view.setEnabled(this.a.e);
        view.setAlpha(this.a.e ? 1.0f : 0.35f);
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.b();
            }
        });
    }

    public void b(TextView textView) {
        if (this.a.i != a.NEVER) {
            textView.setVisibility(0);
            textView.setText(this.a.i.getString());
            return;
        }
        textView.setVisibility(8);
    }

    public void a(AsyncImageView asyncImageView) {
        if (this.a.h) {
            asyncImageView.setImageResource(R.drawable.ic_launcher);
        } else {
            asyncImageView.a(this.a.a, null);
        }
        asyncImageView.setAlpha(this.a.e ? 1.0f : 0.35f);
    }

    private void b() {
        com.cocosw.bottomsheet.c a = new com.cocosw.bottomsheet.c.a((Activity) a()).a((int) R.menu.app_muting_menu).a(new DialogInterface.OnClickListener(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == R.id.mute_always) {
                    c.b(this.a.a.a, false);
                } else {
                    c.b(this.a.a.a, a.fromMenu(i));
                }
            }
        }).a();
        if (this.a.i == a.WEEKDAYS) {
            a.a().removeItem(R.id.mute_weekdays);
        } else if (this.a.i == a.WEEKENDS) {
            a.a().removeItem(R.id.mute_weekends);
        } else if (!this.a.d) {
            a.a().removeItem(R.id.mute_always);
        }
        a.show();
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z != this.a.d) {
            com.getpebble.android.common.b.a.a.c.a(this.a, z);
            b(this.a.a, z);
        }
    }

    private static void b(final String str, final a aVar) {
        new f() {
            public boolean doInBackground() {
                com.getpebble.android.common.b.a.f.d(f.TAG, "Setting muted on to " + aVar.getString() + " for " + str);
                af.a(str, aVar, com.getpebble.android.common.a.K().getContentResolver());
                af.a(str, System.currentTimeMillis(), com.getpebble.android.common.a.K().getContentResolver());
                return false;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    private static void b(final String str, final boolean z) {
        new f() {
            public boolean doInBackground() {
                com.getpebble.android.common.b.a.f.d(f.TAG, "Setting chosen to " + z + " for " + str);
                af.a(str, z, com.getpebble.android.common.a.K().getContentResolver());
                if (!z) {
                    af.a(str, a.NEVER, com.getpebble.android.common.a.K().getContentResolver());
                }
                af.a(str, System.currentTimeMillis(), com.getpebble.android.common.a.K().getContentResolver());
                return false;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }
}
