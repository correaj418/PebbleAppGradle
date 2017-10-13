package com.getpebble.android.main.sections.settings.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.framework.e.f;
import com.getpebble.android.main.sections.support.activity.a;

public class LanguageSelectionActivity extends a implements f.a {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PebbleApplication.a((f.a) this);
    }

    public void onDestroy() {
        PebbleApplication.b(this);
        super.onDestroy();
    }

    public int a() {
        return R.layout.activity_language_selection;
    }

    public int e() {
        return R.string.languages_banner;
    }

    public int f() {
        return R.drawable.ic_drawer_settings;
    }

    public void a(Fragment fragment) {
        super.b(fragment);
    }

    public void e_() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ LanguageSelectionActivity a;

            {
                this.a = r1;
            }

            public void run() {
                if (!PebbleApplication.o()) {
                    Toast.makeText(this.a, R.string.language_selection_pebble_disconnected_toast, 1).show();
                    this.a.finish();
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        c.a();
    }
}
