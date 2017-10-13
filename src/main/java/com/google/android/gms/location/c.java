package com.google.android.gms.location;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;

public interface c {
    Location a(com.google.android.gms.common.api.c cVar);

    d<Status> a(com.google.android.gms.common.api.c cVar, LocationRequest locationRequest, i iVar, Looper looper);

    d<Status> a(com.google.android.gms.common.api.c cVar, i iVar);
}
