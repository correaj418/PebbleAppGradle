package com.google.android.gms.b;

import android.os.Process;

class aq implements Runnable {
    private final Runnable a;
    private final int b;

    public aq(Runnable runnable, int i) {
        this.a = runnable;
        this.b = i;
    }

    public void run() {
        Process.setThreadPriority(this.b);
        this.a.run();
    }
}
