package com.google.android.gms.b;

import android.util.Log;
import com.google.android.gms.b.k.b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.e;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;

public class ce implements e {

    private static class a extends com.google.android.gms.b.bj.a {
        private final b<DataReadResult> a;
        private int b;
        private DataReadResult c;

        private a(b<DataReadResult> bVar) {
            this.b = 0;
            this.c = null;
            this.a = bVar;
        }

        public void a(DataReadResult dataReadResult) {
            synchronized (this) {
                if (Log.isLoggable("Fitness", 2)) {
                    Log.v("Fitness", "Received batch result " + this.b);
                }
                if (this.c == null) {
                    this.c = dataReadResult;
                } else {
                    this.c.a(dataReadResult);
                }
                this.b++;
                if (this.b == this.c.d()) {
                    this.a.a(this.c);
                }
            }
        }
    }

    private d<Status> a(c cVar, final DataSet dataSet, final boolean z) {
        com.google.android.gms.common.internal.b.a((Object) dataSet, (Object) "Must set the data set");
        com.google.android.gms.common.internal.b.a(!dataSet.d().isEmpty(), (Object) "Cannot use an empty data set");
        com.google.android.gms.common.internal.b.a(dataSet.b().d(), (Object) "Must set the app package name for the data source");
        return cVar.a(new c(this, cVar) {
            final /* synthetic */ ce f;

            protected void a(bd bdVar) {
                ((bo) bdVar.t()).a(new DataInsertRequest(dataSet, new cj(this), z));
            }

            protected /* synthetic */ void b(com.google.android.gms.common.api.a.c cVar) {
                a((bd) cVar);
            }
        });
    }

    public d<Status> a(c cVar, DataSet dataSet) {
        return a(cVar, dataSet, false);
    }

    public d<DataReadResult> a(c cVar, final DataReadRequest dataReadRequest) {
        return cVar.a(new a<DataReadResult>(this, cVar) {
            final /* synthetic */ ce e;

            protected void a(bd bdVar) {
                ((bo) bdVar.t()).a(new DataReadRequest(dataReadRequest, new a(this)));
            }

            protected /* synthetic */ f b(Status status) {
                return d(status);
            }

            protected /* synthetic */ void b(com.google.android.gms.common.api.a.c cVar) {
                a((bd) cVar);
            }

            protected DataReadResult d(Status status) {
                return DataReadResult.a(status, dataReadRequest);
            }
        });
    }
}
