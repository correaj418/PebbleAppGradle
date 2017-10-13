package com.getpebble.android.framework;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.FrameworkState;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class b {
    public static final String a = b.class.getSimpleName();
    private static List<a> c = new CopyOnWriteArrayList();
    private static FrameworkState d;
    private Messenger b = new Messenger(new b(this, Looper.getMainLooper()));

    public interface a {
        void onFrameworkStateChanged(FrameworkState frameworkState);
    }

    private class b extends Handler {
        final /* synthetic */ b a;

        public b(b bVar, Looper looper) {
            this.a = bVar;
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                a(message);
            } catch (Throwable e) {
                f.a(b.a, "Exception while handling message.", e);
            }
        }

        private void a(Message message) {
            switch (message.what) {
                case 1:
                    Bundle data = message.getData();
                    data.setClassLoader(FrameworkState.class.getClassLoader());
                    FrameworkState frameworkState = (FrameworkState) data.getParcelable("state_extra");
                    f.d(b.a, "Event: " + frameworkState.a() + " Number of listeners: " + b.c.size());
                    synchronized (b.class) {
                        b.d = frameworkState;
                        for (a onFrameworkStateChanged : b.c) {
                            onFrameworkStateChanged.onFrameworkStateChanged(frameworkState);
                        }
                    }
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    b() {
    }

    Messenger a() {
        return this.b;
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (aVar == null) {
                throw new IllegalArgumentException("ConnectionEventListener cannot be null!");
            }
            c.add(aVar);
        }
    }

    public static synchronized void b(a aVar) {
        synchronized (b.class) {
            c.remove(aVar);
        }
    }

    public static synchronized FrameworkState b() {
        FrameworkState frameworkState;
        synchronized (b.class) {
            frameworkState = d;
        }
        return frameworkState;
    }
}
