package android.support.v4.app;

import android.content.Intent;
import android.content.IntentSender;

abstract class f extends e {
    boolean a;

    f() {
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!(this.a || i == -1)) {
            a(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    void a() {
        super.onBackPressed();
    }

    static void a(int i) {
        if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }
}
