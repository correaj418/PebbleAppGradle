package com.getpebble.android.main.sections.developer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.b.a;
import com.getpebble.android.framework.d;
import com.getpebble.android.widget.PebbleTextView;

public class DeveloperFragment extends b implements a {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private PebbleTextView e;
    private Switch f;
    private d g;

    public int c() {
        return R.layout.fragment_developer;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = PebbleApplication.x();
        this.a = (TextView) viewGroup.findViewById(R.id.connection_status);
        this.b = (TextView) viewGroup.findViewById(R.id.server_ip_addr);
        this.c = (TextView) viewGroup.findViewById(R.id.conn_mgr_status);
        this.e = (PebbleTextView) viewGroup.findViewById(R.id.connection_status_text);
        this.f = (Switch) viewGroup.findViewById(R.id.connection_switch);
        this.d = (TextView) viewGroup.findViewById(R.id.proxy_status);
        f.d("DeveloperFragment", "init()");
        this.f.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ DeveloperFragment a;

            {
                this.a = r1;
            }

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    f.d("DeveloperFragment", "User clicked start developer connection");
                    this.a.e.setText(this.a.getString(R.string.developer_connected));
                    c.b();
                    this.a.g.d();
                    return;
                }
                f.d("DeveloperFragment", "User clicked stop developer connection");
                this.a.e.setText(this.a.getString(R.string.developer_disconnected));
                c.c();
                this.a.g.e();
            }
        });
    }

    public void onResume() {
        super.onResume();
        f.d("DeveloperFragment", "onResume()");
        com.getpebble.android.framework.b.a((a) this);
        a(com.getpebble.android.framework.b.b());
        if (this.g != null) {
            this.g.f();
        }
    }

    public void onPause() {
        f.d("DeveloperFragment", "onPause()");
        com.getpebble.android.framework.b.b(this);
        super.onPause();
    }

    public void onFrameworkStateChanged(FrameworkState frameworkState) {
        if (frameworkState == null) {
            f.d("DeveloperFragment", "onFrameworkStateChanged() state is null");
            return;
        }
        FrameworkState.a a = frameworkState.a();
        if (a == null) {
            f.a("DeveloperFragment", "onFrameworkStateChanged: Last event was null. Not updating UI");
        } else if (a.equals(FrameworkState.a.DEVELOPER_CONNECTION_CHANGED)) {
            a(frameworkState);
        }
    }

    private void a(FrameworkState frameworkState) {
        f.d("DeveloperFragment", "updateUI()");
        if (frameworkState == null) {
            f.b("DeveloperFragment", "updateUI(): frameworkState is null.");
            return;
        }
        if (frameworkState.r() != null) {
            this.b.setText(frameworkState.r());
            this.a.setText(String.format(getString(R.string.developer_listening), new Object[]{frameworkState.r()}));
            this.f.setChecked(true);
        } else {
            this.a.setText(R.string.developer_server_stopped);
            this.f.setChecked(false);
        }
        if (frameworkState.s()) {
            this.c.setText(R.string.developer_connected);
        } else {
            this.c.setText(R.string.developer_disconnected);
        }
        if (frameworkState.t()) {
            this.d.setText(R.string.developer_connected);
        } else {
            this.d.setText(R.string.developer_disconnected);
        }
    }
}
