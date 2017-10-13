package net.hockeyapp.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import net.hockeyapp.android.e.h;
import net.hockeyapp.android.i.b;
import net.hockeyapp.android.i.c;
import net.hockeyapp.android.i.d;

public class ExpiryInfoActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getString(d.hockeyapp_expiry_info_title));
        setContentView(c.activity_expiry_info);
        String b = h.b((Context) this);
        ((TextView) findViewById(b.label_message)).setText(String.format(getString(d.hockeyapp_expiry_info_text), new Object[]{b}));
    }
}
