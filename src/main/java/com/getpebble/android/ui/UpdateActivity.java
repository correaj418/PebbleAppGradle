package com.getpebble.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.main.activity.MainActivity;

public class UpdateActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            f.d("UpdateActivity", "intent is null");
            a();
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            f.d("UpdateActivity", "data is null");
            a();
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            f.d("UpdateActivity", "action is null");
            a();
        } else if (action.equals("android.intent.action.VIEW")) {
            action = data.getScheme();
            if (action == null) {
                f.d("UpdateActivity", "scheme is null");
                a();
            } else if (action.equals("http") || action.equals("https")) {
                f.d("UpdateActivity", "Forwarding http sideloading intent to MainActivity: " + data);
                a(intent);
            } else if (action.equals("file")) {
                f.d("UpdateActivity", "Forwarding file sideloading intent to MainActivity: " + data);
                a(intent);
            } else {
                f.d("UpdateActivity", "Unsupported scheme for backwards compatible sideloading: " + action + " (" + data + ")");
                a();
            }
        } else {
            f.d("UpdateActivity", "invalid action: " + action);
            a();
        }
    }

    private void a() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void a(Intent intent) {
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
