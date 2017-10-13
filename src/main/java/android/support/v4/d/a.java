package android.support.v4.d;

import android.os.AsyncTask;
import android.os.Build.VERSION;

public final class a {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            b.a(asyncTask, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
        return asyncTask;
    }
}
