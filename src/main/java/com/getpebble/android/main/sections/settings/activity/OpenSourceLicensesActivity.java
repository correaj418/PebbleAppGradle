package com.getpebble.android.main.sections.settings.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.x;
import android.view.MenuItem;
import android.webkit.WebView;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.main.activity.b;

public class OpenSourceLicensesActivity extends b {
    public void onCreate(Bundle bundle) {
        requestWindowFeature(8);
        super.onCreate(bundle);
        setContentView(R.layout.activity_os_licenses);
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setTextZoom(75);
        webView.loadUrl("file:///android_asset/opensource.html");
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.os_licenses_title));
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.show();
        }
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
}
