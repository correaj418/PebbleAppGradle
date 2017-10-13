package com.google.android.gms.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class w {
    private static final ExecutorService a = Executors.newFixedThreadPool(2, new ap("GAC_Executor"));

    public static ExecutorService a() {
        return a;
    }
}
