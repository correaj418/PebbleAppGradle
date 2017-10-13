package com.getpebble.android.a;

import android.content.Context;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ar;
import com.getpebble.android.common.model.ar.c;
import com.getpebble.android.h.ab;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class g extends f<c> {
    public static final long a = TimeUnit.HOURS.toSeconds(12);
    public static final long b = TimeUnit.HOURS.toSeconds(1);
    private static final long c = TimeUnit.DAYS.toSeconds(15);
    private final Context d;

    public g(Context context) {
        super("PipelineUploader");
        this.d = context;
    }

    protected int a() {
        int a = ar.a(this.d.getContentResolver(), 5, ((long) ab.a()) - c);
        int a2 = ar.a(this.d);
        if (a2 > 0) {
            f.a("PipelineUploader", "purgeStaleRecords: orphaned files is non-zero: " + a2);
        }
        return a;
    }

    protected List<c> b() {
        return ar.a(this.d.getContentResolver(), 1000);
    }

    public boolean a(List<c> list) {
        c.a(this.d, (List) list);
        return true;
    }
}
