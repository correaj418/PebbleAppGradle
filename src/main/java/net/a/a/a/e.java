package net.a.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import c.b.a.f;
import java.util.TimeZone;

public class e extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("time-zone");
        try {
            f.a(f.a(TimeZone.getDefault()));
            Log.d("joda-time-android", "TIMEZONE_CHANGED received, changed default timezone to \"" + stringExtra + "\"");
        } catch (Throwable e) {
            Log.e("joda-time-android", "Could not recognize timezone id \"" + stringExtra + "\"", e);
        }
    }
}
