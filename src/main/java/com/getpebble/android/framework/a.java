package com.getpebble.android.framework;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;

public class a {
    private Messenger a;

    a() {
    }

    public void a(FrameworkState frameworkState) {
        if (frameworkState == null) {
            f.b("EventSender", "state null");
            return;
        }
        Message obtain = Message.obtain(null, 1);
        Bundle bundle = new Bundle();
        bundle.putParcelable("state_extra", frameworkState);
        obtain.setData(bundle);
        a(obtain);
    }

    void a(Messenger messenger) {
        this.a = messenger;
    }

    private void a(Message message) {
        if (this.a == null) {
            f.a("EventSender", "Failed to send message: null receiver");
            return;
        }
        try {
            this.a.send(message);
        } catch (DeadObjectException e) {
            f.c("EventSender", "Failed to send message (DeadObjectException)");
        } catch (Throwable e2) {
            f.a("EventSender", "Failed to send message.", e2);
        }
    }
}
