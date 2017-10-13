package com.getpebble.android.h;

import android.content.AsyncTaskLoader;
import android.content.Context;

public abstract class c<D> extends AsyncTaskLoader<D> {
    private D a;

    public c(Context context) {
        super(context);
    }

    public void deliverResult(D d) {
        if (!isReset()) {
            this.a = d;
            super.deliverResult(d);
        }
    }

    protected void onStartLoading() {
        if (this.a != null) {
            deliverResult(this.a);
        }
        if (takeContentChanged() || this.a == null) {
            forceLoad();
        }
    }

    protected void onStopLoading() {
        cancelLoad();
    }

    protected void onReset() {
        super.onReset();
        onStopLoading();
        this.a = null;
    }
}
