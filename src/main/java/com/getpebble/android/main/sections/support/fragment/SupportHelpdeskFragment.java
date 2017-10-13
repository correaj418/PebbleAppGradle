package com.getpebble.android.main.sections.support.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.main.sections.support.c;
import com.getpebble.android.main.sections.support.d;

public class SupportHelpdeskFragment extends b {
    private EditText a;
    private boolean b = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public int c() {
        return R.layout.fragment_support_helpdesk;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final d from = d.from(getActivity(), getActivity().getIntent().getExtras().getString("extra_support_target"));
        this.a = (EditText) viewGroup.findViewById(R.id.email_body);
        this.a.requestFocus();
        b();
        viewGroup.findViewById(R.id.ok).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SupportHelpdeskFragment b;

            public void onClick(View view) {
                new c(this.b).startSupportEmailTasks(true, from, this.b.a.getText() != null ? this.b.a.getText().toString() : "");
                this.b.b = true;
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (this.b) {
            getActivity().finish();
        }
    }

    public void onPause() {
        super.onPause();
        a();
    }

    private void a() {
        ((InputMethodManager) getActivity().getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
    }

    private void b() {
        ((InputMethodManager) getActivity().getApplicationContext().getSystemService("input_method")).toggleSoftInput(2, 1);
    }
}
