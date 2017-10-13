package com.google.android.gms.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class ai {
    private static final ExecutorService a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ap("GAC_Transform"));

    public static ExecutorService a() {
        return a;
    }
}
