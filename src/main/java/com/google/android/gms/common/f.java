package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.j;
import android.support.v4.app.p;
import com.google.android.gms.common.internal.b;

public class f extends j {
    private Dialog aj = null;
    private OnCancelListener ak = null;

    public static f a(Dialog dialog, OnCancelListener onCancelListener) {
        f fVar = new f();
        Dialog dialog2 = (Dialog) b.a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        fVar.aj = dialog2;
        if (onCancelListener != null) {
            fVar.ak = onCancelListener;
        }
        return fVar;
    }

    public void a(p pVar, String str) {
        super.a(pVar, str);
    }

    public Dialog c(Bundle bundle) {
        if (this.aj == null) {
            b(false);
        }
        return this.aj;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.ak != null) {
            this.ak.onCancel(dialogInterface);
        }
    }
}
