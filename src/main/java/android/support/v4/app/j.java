package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class j extends k implements OnCancelListener, OnDismissListener {
    int a = 0;
    int b = 0;
    boolean c = true;
    boolean d = true;
    int e = -1;
    Dialog f;
    boolean g;
    boolean h;
    boolean i;

    public void a(p pVar, String str) {
        this.h = false;
        this.i = true;
        s a = pVar.a();
        a.a(this, str);
        a.a();
    }

    void a(boolean z) {
        if (!this.h) {
            this.h = true;
            this.i = false;
            if (this.f != null) {
                this.f.dismiss();
                this.f = null;
            }
            this.g = true;
            if (this.e >= 0) {
                i().a(this.e, 1);
                this.e = -1;
                return;
            }
            s a = i().a();
            a.a(this);
            if (z) {
                a.b();
            } else {
                a.a();
            }
        }
    }

    public int a() {
        return this.b;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public void a(Context context) {
        super.a(context);
        if (!this.i) {
            this.h = false;
        }
    }

    public void b() {
        super.b();
        if (!this.i && !this.h) {
            this.h = true;
        }
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        this.d = this.H == 0;
        if (bundle != null) {
            this.a = bundle.getInt("android:style", 0);
            this.b = bundle.getInt("android:theme", 0);
            this.c = bundle.getBoolean("android:cancelable", true);
            this.d = bundle.getBoolean("android:showsDialog", this.d);
            this.e = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater b(Bundle bundle) {
        if (!this.d) {
            return super.b(bundle);
        }
        this.f = c(bundle);
        if (this.f == null) {
            return (LayoutInflater) this.C.g().getSystemService("layout_inflater");
        }
        a(this.f, this.a);
        return (LayoutInflater) this.f.getContext().getSystemService("layout_inflater");
    }

    public void a(Dialog dialog, int i) {
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public Dialog c(Bundle bundle) {
        return new Dialog(g(), a());
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.g) {
            a(true);
        }
    }

    public void d(Bundle bundle) {
        super.d(bundle);
        if (this.d) {
            View n = n();
            if (n != null) {
                if (n.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f.setContentView(n);
            }
            Activity g = g();
            if (g != null) {
                this.f.setOwnerActivity(g);
            }
            this.f.setCancelable(this.c);
            this.f.setOnCancelListener(this);
            this.f.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void c() {
        super.c();
        if (this.f != null) {
            this.g = false;
            this.f.show();
        }
    }

    public void e(Bundle bundle) {
        super.e(bundle);
        if (this.f != null) {
            Bundle onSaveInstanceState = this.f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.a != 0) {
            bundle.putInt("android:style", this.a);
        }
        if (this.b != 0) {
            bundle.putInt("android:theme", this.b);
        }
        if (!this.c) {
            bundle.putBoolean("android:cancelable", this.c);
        }
        if (!this.d) {
            bundle.putBoolean("android:showsDialog", this.d);
        }
        if (this.e != -1) {
            bundle.putInt("android:backStackId", this.e);
        }
    }

    public void d() {
        super.d();
        if (this.f != null) {
            this.f.hide();
        }
    }

    public void e() {
        super.e();
        if (this.f != null) {
            this.g = true;
            this.f.dismiss();
            this.f = null;
        }
    }
}
