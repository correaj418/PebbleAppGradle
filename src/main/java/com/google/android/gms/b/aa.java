package com.google.android.gms.b;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.api.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public interface aa {

    public interface a {
        void a(int i, boolean z);

        void a(Bundle bundle);

        void a(ConnectionResult connectionResult);
    }

    <A extends c, R extends f, T extends com.google.android.gms.b.k.a<R, A>> T a(T t);

    void a();

    void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    <A extends c, T extends com.google.android.gms.b.k.a<? extends f, A>> T b(T t);

    ConnectionResult b();

    void c();

    boolean d();

    void e();
}
