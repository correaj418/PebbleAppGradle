package com.getpebble.android.main.fragment;

import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.getpebble.android.basalt.R;
import com.getpebble.android.widget.PebbleButton;

public class b extends DialogFragment {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.kill_switch_dialog_fragment, viewGroup);
        ((PebbleButton) inflate.findViewById(R.id.kill_switch_button)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.getpebble.android&hl=en"));
                this.a.startActivity(intent);
            }
        });
        return inflate;
    }
}
