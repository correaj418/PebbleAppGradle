package com.getpebble.android.main.sections.mypebble.c;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.TextUtils;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.model.g;

public class b extends AlertDialog {
    final g a;
    final a b;

    public interface a {
        void a(g gVar);
    }

    public b(Context context, g gVar, a aVar) {
        super(context);
        this.a = gVar;
        this.b = aVar;
    }

    protected void onCreate(Bundle bundle) {
        OnClickListener anonymousClass1 = new OnClickListener(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case -2:
                        dialogInterface.dismiss();
                        return;
                    case -1:
                        dialogInterface.dismiss();
                        this.a.b.a(this.a.a);
                        return;
                    default:
                        return;
                }
            }
        };
        String title = TextUtils.isEmpty(this.a.getTitle()) ? "This app" : this.a.getTitle();
        CharSequence format = String.format(getContext().getString(R.string.health_capability_prompt_install), new Object[]{title});
        CharSequence string = getContext().getString(R.string.install);
        CharSequence string2 = getContext().getString(R.string.cancel);
        setMessage(format);
        setButton(-1, string, anonymousClass1);
        setButton(-2, string2, anonymousClass1);
        super.onCreate(bundle);
    }
}
