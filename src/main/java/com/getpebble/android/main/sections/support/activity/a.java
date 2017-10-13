package com.getpebble.android.main.sections.support.activity;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.x;
import android.view.MenuItem;
import android.view.Window;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.main.activity.b;

public abstract class a extends b {
    public abstract int a();

    public abstract int e();

    public void onCreate(Bundle bundle) {
        f.d("SingleFragmentActivity", "onCreate");
        requestWindowFeature(8);
        super.onCreate(bundle);
        setContentView(a());
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            f.d("SingleFragmentActivity", "Setting up action bar");
            actionBar.setTitle(getString(e()));
            actionBar.setIcon(f());
            actionBar.show();
            return;
        }
        f.d("SingleFragmentActivity", "No action bar");
    }

    public int f() {
        return R.drawable.ic_drawer_mypebble;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        x.a(this);
        return true;
    }

    public void onStart() {
        super.onStart();
        PebbleApplication.C();
    }

    public void onStop() {
        super.onStop();
        PebbleApplication.D();
    }

    public void h() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange_actionbar_color)));
        }
        Window window = getWindow();
        if (VERSION.SDK_INT >= 21 && window != null) {
            window.setStatusBarColor(getResources().getColor(R.color.orange_statusbar_color));
        }
    }
}
