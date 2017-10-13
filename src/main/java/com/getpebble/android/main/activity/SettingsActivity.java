package com.getpebble.android.main.activity;

import android.os.Bundle;
import com.getpebble.android.basalt.R;
import com.getpebble.android.main.sections.support.activity.a;

public class SettingsActivity extends a {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h();
    }

    public int a() {
        return R.layout.activity_settings;
    }

    public int e() {
        return R.string.settings_activity_title;
    }
}
