package com.getpebble.android.bluetooth.b;

import android.os.AsyncTask;

public abstract class f extends AsyncTask<Void, Void, Boolean> {
    public static final String TAG = "PebbleAsyncTask";

    public abstract boolean doInBackground();

    public abstract void onTaskFailed();

    public abstract void onTaskSuccess();

    public void submit() {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[]{(Void) null});
    }

    public void cancel() {
        cancel(true);
    }

    protected Boolean doInBackground(Void[] voidArr) {
        boolean doInBackground = doInBackground();
        if (doInBackground) {
            onTaskSuccess();
        } else {
            onTaskFailed();
        }
        return Boolean.valueOf(doInBackground);
    }

    protected void onPostExecute(Boolean bool) {
    }
}
