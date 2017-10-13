package com.getpebble.android.main.sections.mypebble.activity;

import android.content.Intent;
import com.getpebble.android.basalt.R;
import com.getpebble.android.main.sections.support.activity.a;

public class HealthSettingsActivity extends a {
    public int a() {
        return R.layout.activity_health_settings;
    }

    public int e() {
        return R.string.health_settings_title;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        getFragmentManager().findFragmentById(R.id.fragment).onActivityResult(i, i2, intent);
    }
}
