package net.hockeyapp.android.d;

import android.content.Context;
import java.io.IOException;
import java.net.URL;
import net.hockeyapp.android.b.a;

public class e extends d {
    private long g;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Long) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        a((Integer[]) objArr);
    }

    public e(Context context, String str, a aVar) {
        super(context, str, aVar);
    }

    protected Long a(Void... voidArr) {
        try {
            return Long.valueOf((long) a(new URL(b()), 6).getContentLength());
        } catch (IOException e) {
            e.printStackTrace();
            return Long.valueOf(0);
        }
    }

    protected void a(Integer... numArr) {
    }

    protected void a(Long l) {
        this.g = l.longValue();
        if (this.g > 0) {
            this.b.a(this);
        } else {
            this.b.a(this, Boolean.valueOf(false));
        }
    }

    public long c() {
        return this.g;
    }
}
