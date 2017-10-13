package com.getpebble.android.main.sections.mypebble.activity;

import android.view.MenuItem;
import com.getpebble.android.basalt.R;
import com.getpebble.android.main.sections.support.activity.a;

public class RemindersSettingsActivity extends a {
    public int a() {
        return R.layout.activity_reminders_settings;
    }

    public int e() {
        return R.string.my_pebble_reminders;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
