package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Creator<DataHolder> CREATOR = new a();
    private static final a l = new AnonymousClass1(new String[0], null);
    Bundle a;
    int[] b;
    int c;
    boolean d = false;
    private final int e;
    private final String[] f;
    private final CursorWindow[] g;
    private final int h;
    private final Bundle i;
    private Object j;
    private boolean k = true;

    public static class a {
        private final String[] a;
        private final ArrayList<HashMap<String, Object>> b;
        private final String c;
        private final HashMap<Object, Integer> d;
        private boolean e;
        private String f;

        private a(String[] strArr, String str) {
            this.a = (String[]) b.a((Object) strArr);
            this.b = new ArrayList();
            this.c = str;
            this.d = new HashMap();
            this.e = false;
            this.f = null;
        }
    }

    class AnonymousClass1 extends a {
        AnonymousClass1(String[] strArr, String str) {
            super(strArr, str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.e = i;
        this.f = strArr;
        this.g = cursorWindowArr;
        this.h = i2;
        this.i = bundle;
    }

    public void a() {
        int i;
        int i2 = 0;
        this.a = new Bundle();
        for (i = 0; i < this.f.length; i++) {
            this.a.putInt(this.f[i], i);
        }
        this.b = new int[this.g.length];
        i = 0;
        while (i2 < this.g.length) {
            this.b[i2] = i;
            i += this.g[i2].getNumRows() - (i - this.g[i2].getStartPosition());
            i2++;
        }
        this.c = i;
    }

    int b() {
        return this.e;
    }

    String[] c() {
        return this.f;
    }

    public void close() {
        synchronized (this) {
            if (!this.d) {
                this.d = true;
                for (CursorWindow close : this.g) {
                    close.close();
                }
            }
        }
    }

    CursorWindow[] d() {
        return this.g;
    }

    public int e() {
        return this.h;
    }

    public Bundle f() {
        return this.i;
    }

    protected void finalize() {
        try {
            if (this.k && this.g.length > 0 && !g()) {
                String valueOf;
                if (this.j == null) {
                    String str = "internal object: ";
                    valueOf = String.valueOf(toString());
                    valueOf = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
                } else {
                    valueOf = this.j.toString();
                }
                Log.e("DataBuffer", new StringBuilder(String.valueOf(valueOf).length() + 161).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (").append(valueOf).append(")").toString());
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public boolean g() {
        boolean z;
        synchronized (this) {
            z = this.d;
        }
        return z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
