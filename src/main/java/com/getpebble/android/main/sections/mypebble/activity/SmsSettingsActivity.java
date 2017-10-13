package com.getpebble.android.main.sections.mypebble.activity;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.Window;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.am.d;
import com.getpebble.android.font.CustomTypefaceSpan;
import com.getpebble.android.font.a;
import com.getpebble.android.main.activity.b;
import com.getpebble.android.main.sections.mypebble.fragment.k;

public class SmsSettingsActivity extends b {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sms_settings);
        a();
        am.a(getContentResolver(), d.SMS.getUuid(), true);
        b(new k());
    }

    public void a() {
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

    public void setTitle(int i) {
        a(getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        a(charSequence.toString());
    }

    protected void a(String str) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            CharSequence spannableString = new SpannableString(str);
            spannableString.setSpan(new CustomTypefaceSpan(a.a(this)), 0, str.length(), 17);
            actionBar.setTitle(spannableString);
        }
    }

    public void onStart() {
        super.onStart();
        PebbleApplication.a(false);
    }

    public void onStop() {
        super.onStop();
        PebbleApplication.D();
    }
}
