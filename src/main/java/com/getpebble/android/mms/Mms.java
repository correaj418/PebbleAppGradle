package com.getpebble.android.mms;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class Mms implements Parcelable {
    public static final Creator<Mms> CREATOR = new Creator<Mms>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public Mms a(Parcel parcel) {
            return new Mms(parcel);
        }

        public Mms[] a(int i) {
            return new Mms[i];
        }
    };
    public final int a;
    public final boolean b;
    public final int c;
    public final String d;
    public final boolean e;
    public final long f;
    public final boolean g;
    public final long h;
    public final String i;
    public final List<String> j;
    public final List<String> k;

    public static class a {
        private int a;
        private boolean b = false;
        private int c = 0;
        private boolean d = false;
        private long e = 0;
        private boolean f = false;
        private long g = 0;
        private String h = "";
        private List<String> i = new ArrayList();
        private List<String> j = new ArrayList();
        private String k;

        public Mms a() {
            return new Mms(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
        }

        public a a(int i) {
            this.c = i;
            return this;
        }

        public a a(boolean z) {
            this.d = z;
            return this;
        }

        public a b(boolean z) {
            this.f = z;
            return this;
        }

        public a b(int i) {
            this.a = i;
            return this;
        }

        public a c(boolean z) {
            this.b = z;
            return this;
        }

        public a a(String str) {
            this.h = str;
            return this;
        }

        public a a(List<String> list) {
            this.i = list;
            return this;
        }

        public a b(List<String> list) {
            this.j = list;
            return this;
        }

        public a b(String str) {
            this.k = str;
            return this;
        }
    }

    private Mms(int i, boolean z, int i2, boolean z2, long j, boolean z3, long j2, String str, List<String> list, List<String> list2, String str2) {
        this.a = i;
        this.b = z;
        this.c = i2;
        this.e = z2;
        this.f = j;
        this.g = z3;
        this.h = j2;
        this.d = str;
        this.j = list;
        this.k = list2;
        this.i = str2;
    }

    protected Mms(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.a = parcel.readInt();
        this.b = parcel.readInt() > 0;
        this.c = parcel.readInt();
        if (parcel.readInt() > 0) {
            z = true;
        } else {
            z = false;
        }
        this.e = z;
        this.f = parcel.readLong();
        if (parcel.readInt() <= 0) {
            z2 = false;
        }
        this.g = z2;
        this.h = parcel.readLong();
        this.d = parcel.readString();
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        this.i = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.a);
        parcel.writeInt(this.b ? 1 : 0);
        parcel.writeInt(this.c);
        if (this.e) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeLong(this.f);
        if (!this.g) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeLong(this.h);
        parcel.writeString(this.d);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
        parcel.writeString(this.i);
    }

    public boolean a() {
        return this.c > 0 || this.e || this.g;
    }

    public String toString() {
        return "Mms{mId=" + this.a + ", mIsIncoming=" + this.b + ", mImageCount=" + this.c + ", mSubject='" + this.d + '\'' + ", mHasAudio=" + this.e + ", mAudioDuration=" + this.f + ", mHasVideo=" + this.g + ", mVideoDuration=" + this.h + ", mMessages size=" + this.j.size() + ", mAddresses size=" + this.k.size() + ", mSender='" + com.getpebble.android.common.b.b.a.a(this.i) + '\'' + '}';
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r0 = 1;
        r1 = 0;
        if (r6 != r7) goto L_0x0006;
    L_0x0004:
        r1 = r0;
    L_0x0005:
        return r1;
    L_0x0006:
        if (r7 == 0) goto L_0x0005;
    L_0x0008:
        r2 = r6.getClass();
        r3 = r7.getClass();
        if (r2 != r3) goto L_0x0005;
    L_0x0012:
        r7 = (com.getpebble.android.mms.Mms) r7;
        r2 = r6.a;
        r3 = r7.a;
        if (r2 != r3) goto L_0x0005;
    L_0x001a:
        r2 = r6.b;
        r3 = r7.b;
        if (r2 != r3) goto L_0x0005;
    L_0x0020:
        r2 = r6.c;
        r3 = r7.c;
        if (r2 != r3) goto L_0x0005;
    L_0x0026:
        r2 = r6.e;
        r3 = r7.e;
        if (r2 != r3) goto L_0x0005;
    L_0x002c:
        r2 = r6.f;
        r4 = r7.f;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0005;
    L_0x0034:
        r2 = r6.g;
        r3 = r7.g;
        if (r2 != r3) goto L_0x0005;
    L_0x003a:
        r2 = r6.h;
        r4 = r7.h;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0005;
    L_0x0042:
        r2 = r6.d;
        if (r2 == 0) goto L_0x007d;
    L_0x0046:
        r2 = r6.d;
        r3 = r7.d;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x0050:
        r2 = r6.i;
        if (r2 == 0) goto L_0x0082;
    L_0x0054:
        r2 = r6.i;
        r3 = r7.i;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x005e:
        r2 = r6.j;
        if (r2 == 0) goto L_0x0088;
    L_0x0062:
        r2 = r6.j;
        r3 = r7.j;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x006c:
        r2 = r6.k;
        if (r2 == 0) goto L_0x008e;
    L_0x0070:
        r2 = r6.k;
        r3 = r7.k;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x007b;
    L_0x007a:
        r0 = r1;
    L_0x007b:
        r1 = r0;
        goto L_0x0005;
    L_0x007d:
        r2 = r7.d;
        if (r2 == 0) goto L_0x0050;
    L_0x0081:
        goto L_0x0005;
    L_0x0082:
        r2 = r7.i;
        if (r2 == 0) goto L_0x005e;
    L_0x0086:
        goto L_0x0005;
    L_0x0088:
        r2 = r7.j;
        if (r2 == 0) goto L_0x006c;
    L_0x008c:
        goto L_0x0005;
    L_0x008e:
        r2 = r7.k;
        if (r2 != 0) goto L_0x007a;
    L_0x0092:
        goto L_0x007b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.mms.Mms.equals(java.lang.Object):boolean");
    }
}
