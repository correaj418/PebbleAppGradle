package com.getpebble.android.main.sections.mypebble.c;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.getpebble.android.basalt.R;

abstract class a extends AlertDialog {

    protected final class a extends ArrayAdapter<com.getpebble.android.framework.health.g.a> {
        final /* synthetic */ a a;

        a(a aVar, Context context, com.getpebble.android.framework.health.g.a[] aVarArr) {
            this.a = aVar;
            super(context, 0, aVarArr);
        }

        @SuppressLint({"ViewHolder"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            return a(i, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return a(i, viewGroup);
        }

        private View a(int i, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(getContext()).inflate(17367049, viewGroup, false);
            ((TextView) inflate).setText(getContext().getString(((com.getpebble.android.framework.health.g.a) getItem(i)).nameResourceId()));
            return inflate;
        }
    }

    protected abstract String a();

    protected abstract void b();

    protected a(Context context) {
        super(context);
    }

    protected void onCreate(Bundle bundle) {
        OnClickListener anonymousClass1 = new OnClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case -2:
                        dialogInterface.dismiss();
                        return;
                    case -1:
                        CharSequence a = this.a.a();
                        if (a.equals("valid_input")) {
                            this.a.b();
                            return;
                        } else {
                            Toast.makeText(this.a.getContext(), a, 1).show();
                            return;
                        }
                    default:
                        return;
                }
            }
        };
        setButton(-1, getContext().getString(R.string.height_weight_dialog_button_positive), anonymousClass1);
        setButton(-2, getContext().getString(R.string.height_weight_dialog_button_negative), anonymousClass1);
        super.onCreate(bundle);
    }

    protected static int a(EditText editText) {
        return Integer.valueOf(editText.getText().toString()).intValue();
    }
}
