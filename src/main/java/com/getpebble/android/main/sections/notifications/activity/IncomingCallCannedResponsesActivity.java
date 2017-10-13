package com.getpebble.android.main.sections.notifications.activity;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import com.getpebble.android.basalt.R;
import com.getpebble.android.main.sections.support.activity.a;

public class IncomingCallCannedResponsesActivity extends a {
    @TargetApi(21)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange_actionbar_color)));
        }
        Window window = getWindow();
        if (VERSION.SDK_INT >= 21 && window != null) {
            window.setStatusBarColor(getResources().getColor(R.color.orange_statusbar_color));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public int a() {
        return R.layout.activity_incoming_call_canned_responses;
    }

    public int e() {
        return R.string.incoming_call_responses;
    }
}
