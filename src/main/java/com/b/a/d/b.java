package com.b.a.d;

import com.b.a.a.a;
import com.b.a.a.d;
import com.b.a.b.e;
import com.b.a.b.i;
import com.b.a.k;
import com.b.a.m;
import java.lang.reflect.Type;

public class b implements a<k> {
    public e<k> a(final m mVar) {
        final k kVar = new k();
        final e anonymousClass1 = new i<k>(this) {
            final /* synthetic */ b b;

            protected void a() {
                mVar.d();
            }
        };
        mVar.a(new d(this) {
            final /* synthetic */ b b;

            public void a(m mVar, k kVar) {
                kVar.a(kVar);
            }
        });
        mVar.b(new a(this) {
            final /* synthetic */ b c;

            public void a(Exception exception) {
                if (exception != null) {
                    anonymousClass1.a(exception);
                    return;
                }
                try {
                    anonymousClass1.b(kVar);
                } catch (Exception e) {
                    anonymousClass1.a(e);
                }
            }
        });
        return anonymousClass1;
    }

    public Type a() {
        return k.class;
    }
}
