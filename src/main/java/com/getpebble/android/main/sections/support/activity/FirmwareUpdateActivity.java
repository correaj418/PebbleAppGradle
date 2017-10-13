package com.getpebble.android.main.sections.support.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.x;
import android.view.MenuItem;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.core.a;
import com.getpebble.android.main.activity.MainActivity;
import com.getpebble.android.onboarding.fragment.e;

public class FirmwareUpdateActivity extends a {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(e.a((Activity) this));
    }

    public void onBackPressed() {
        if (!e()) {
            a();
        }
    }

    public void onNewIntent(Intent intent) {
        f.d("FirmwareUpdateActivity", "onNewIntent called for existing instance");
        if (e()) {
            f.b("FirmwareUpdateActivity", "onNewIntent: ignore this intent because firmware is updating ....");
            return;
        }
        setIntent(intent);
        b(e.a((Activity) this));
    }

    private void a() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (!e()) {
            x.a(this);
        }
        return true;
    }

    private boolean e() {
        Fragment c = c();
        return (c instanceof e) && ((e) c).b();
    }
}
