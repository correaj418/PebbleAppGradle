package net.hockeyapp.android.e;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build.VERSION;

public class a {
    @SuppressLint({"InlinedApi"})
    public static void a(AsyncTask<Void, ?, ?> asyncTask) {
        if (VERSION.SDK_INT <= 12) {
            asyncTask.execute(new Void[0]);
        } else {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }
}
