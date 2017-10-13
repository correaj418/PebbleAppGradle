package com.google.android.gms.fitness;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;

public interface e {
    d<Status> a(c cVar, DataSet dataSet);

    d<DataReadResult> a(c cVar, DataReadRequest dataReadRequest);
}
