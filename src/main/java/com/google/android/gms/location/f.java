package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import java.util.List;

public interface f {
    d<Status> a(c cVar, PendingIntent pendingIntent);

    @Deprecated
    d<Status> a(c cVar, List<d> list, PendingIntent pendingIntent);
}
