package com.getpebble.android.common.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FrameworkState implements Parcelable {
    public static final Creator<FrameworkState> CREATOR = new Creator<FrameworkState>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public FrameworkState a(Parcel parcel) {
            return new FrameworkState(parcel);
        }

        public FrameworkState[] a(int i) {
            return new FrameworkState[i];
        }
    };
    int a;
    private a b;
    private boolean c;
    private boolean d;
    private int e;
    private FirmwareInstallData f;
    private com.getpebble.android.framework.g.r.a g;
    private boolean h;
    private boolean i;
    private AppInfo j;
    private String k;
    private int l;
    private int m;
    private String n;
    private String o;
    private int p;
    private String q;
    private String r;
    private boolean s;
    private boolean t;
    private double u;
    private double v;
    private b w;

    public static class FirmwareInstallData implements Parcelable {
        public static final Creator<FirmwareInstallData> CREATOR = new Creator<FirmwareInstallData>() {
            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return a(i);
            }

            public FirmwareInstallData a(Parcel parcel) {
                return new FirmwareInstallData(parcel);
            }

            public FirmwareInstallData[] a(int i) {
                return new FirmwareInstallData[i];
            }
        };
        private String a;
        private String b;

        public String toString() {
            return "[FirmwareInstallData: mVersionTag = " + this.a + ", mFirmwareType = " + this.b + "]";
        }

        public FirmwareInstallData(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        private FirmwareInstallData(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readString();
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a);
            parcel.writeString(this.b);
        }
    }

    public enum a {
        DISCOVERY_STATE_CHANGED,
        BLUETOOTH_STATE_CHANGED,
        FIRMWARE_INSTALL_PROGRESS_CHANGED,
        FIRMWARE_INSTALL_STATE_CHANGED,
        NOTIFICATION_DEMO_COMPLETE,
        APP_INSTALL_COMPLETE,
        APP_INFO_AVAILABLE,
        FILE_INSTALL_COMPLETE,
        FILE_INSTALL_PROGRESS_CHANGED,
        GET_BYTES_STATE_CHANGED,
        LOG_DUMP_COMPLETE,
        LOG_CORE_DUMP_PING,
        DEVELOPER_CONNECTION_CHANGED
    }

    public interface b {
        void a();
    }

    public String toString() {
        return "[ FrameworkState: mLastEvent = " + this.b + ", mFirmwareInstallResult = " + this.g + ", mFirmwareInstallData = " + this.f + "]";
    }

    public FrameworkState(boolean z, boolean z2, b bVar) {
        this.g = com.getpebble.android.framework.g.r.a.OK;
        this.i = false;
        this.j = null;
        this.a = -1;
        this.k = null;
        this.l = 0;
        this.m = -10;
        this.n = null;
        this.o = null;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = false;
        this.t = false;
        this.u = 0.0d;
        this.v = 0.0d;
        this.c = z;
        this.d = z2;
        this.w = bVar;
    }

    public FrameworkState(FrameworkState frameworkState) {
        this.g = com.getpebble.android.framework.g.r.a.OK;
        this.i = false;
        this.j = null;
        this.a = -1;
        this.k = null;
        this.l = 0;
        this.m = -10;
        this.n = null;
        this.o = null;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = false;
        this.t = false;
        this.u = 0.0d;
        this.v = 0.0d;
        this.w = null;
        this.b = frameworkState.b;
        this.c = frameworkState.c;
        this.d = frameworkState.d;
        this.e = frameworkState.e;
        this.g = frameworkState.g;
        this.f = frameworkState.f;
        this.h = frameworkState.h;
        this.i = frameworkState.i;
        this.j = frameworkState.j;
        this.a = frameworkState.a;
        this.k = frameworkState.k;
        this.l = frameworkState.l;
        this.n = frameworkState.n;
        this.o = frameworkState.o;
        this.m = frameworkState.m;
        this.q = frameworkState.q;
        this.p = frameworkState.p;
        this.r = frameworkState.r;
        this.s = frameworkState.s;
        this.t = frameworkState.t;
    }

    public a a() {
        return this.b;
    }

    public void a(b bVar) {
        this.w = bVar;
    }

    public synchronized boolean b() {
        return this.c;
    }

    public synchronized void a(boolean z) {
        if (this.c != z) {
            this.c = z;
            this.b = a.DISCOVERY_STATE_CHANGED;
            v();
        }
    }

    public synchronized boolean c() {
        return this.d;
    }

    public synchronized void b(boolean z) {
        if (this.d != z) {
            this.d = z;
            this.b = a.BLUETOOTH_STATE_CHANGED;
            v();
        }
    }

    public synchronized int d() {
        return this.e;
    }

    public synchronized void a(int i) {
        this.e = i;
        this.b = a.FIRMWARE_INSTALL_PROGRESS_CHANGED;
        v();
    }

    public synchronized com.getpebble.android.framework.g.r.a e() {
        return this.g;
    }

    public synchronized void a(com.getpebble.android.framework.g.r.a aVar) {
        this.g = aVar;
        this.b = a.FIRMWARE_INSTALL_STATE_CHANGED;
        v();
    }

    public synchronized boolean f() {
        return this.h;
    }

    public synchronized void c(boolean z) {
        this.h = z;
        this.b = a.NOTIFICATION_DEMO_COMPLETE;
        v();
    }

    public synchronized boolean g() {
        return this.i;
    }

    public synchronized void d(boolean z) {
        this.i = z;
        this.b = a.APP_INSTALL_COMPLETE;
        v();
    }

    public synchronized AppInfo h() {
        return this.j;
    }

    public synchronized void a(AppInfo appInfo) {
        this.j = appInfo;
        this.b = a.APP_INFO_AVAILABLE;
        v();
    }

    public synchronized int i() {
        return this.a;
    }

    public synchronized Uri j() {
        return this.k == null ? null : Uri.parse(this.k);
    }

    public synchronized void a(int i, Uri uri) {
        this.a = i;
        this.k = uri == null ? null : uri.toString();
        this.b = a.FILE_INSTALL_COMPLETE;
        v();
    }

    public synchronized int k() {
        return this.l;
    }

    public synchronized void b(int i) {
        this.b = a.FILE_INSTALL_PROGRESS_CHANGED;
        this.l = i;
        v();
    }

    public synchronized int l() {
        return this.m;
    }

    public synchronized String m() {
        return this.n;
    }

    public synchronized String n() {
        return this.o;
    }

    public synchronized void a(int i, String str, String str2) {
        this.m = i;
        this.n = str;
        this.o = str2;
        this.b = a.GET_BYTES_STATE_CHANGED;
        v();
    }

    public synchronized int o() {
        return this.p;
    }

    public synchronized String p() {
        return this.q;
    }

    public synchronized void a(int i, String str) {
        this.p = i;
        this.q = str;
        this.b = a.LOG_DUMP_COMPLETE;
        v();
    }

    public synchronized void q() {
        this.b = a.LOG_CORE_DUMP_PING;
        v();
    }

    public synchronized String r() {
        return this.r;
    }

    public synchronized void a(String str) {
        this.r = str;
        this.b = a.DEVELOPER_CONNECTION_CHANGED;
        v();
    }

    public synchronized boolean s() {
        return this.s;
    }

    public synchronized void e(boolean z) {
        this.s = z;
        this.b = a.DEVELOPER_CONNECTION_CHANGED;
        v();
    }

    public synchronized boolean t() {
        return this.t;
    }

    public synchronized void f(boolean z) {
        this.t = z;
        this.b = a.DEVELOPER_CONNECTION_CHANGED;
        v();
    }

    private void v() {
        if (this.w != null) {
            this.w.a();
        }
    }

    public synchronized FirmwareInstallData u() {
        return this.f;
    }

    public synchronized void a(FirmwareInstallData firmwareInstallData) {
        this.f = firmwareInstallData;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeSerializable(this.b);
        parcel.writeByte((byte) (this.c ? 1 : 0));
        if (this.d) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.e);
        parcel.writeInt(this.g.getCode());
        parcel.writeParcelable(this.f, 0);
        if (this.h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.i) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeParcelable(this.j, 0);
        parcel.writeInt(this.a);
        parcel.writeString(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeInt(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeByte((byte) (this.s ? 1 : 0));
        if (!this.t) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeDouble(this.v);
        parcel.writeDouble(this.u);
    }

    private FrameworkState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.g = com.getpebble.android.framework.g.r.a.OK;
        this.i = false;
        this.j = null;
        this.a = -1;
        this.k = null;
        this.l = 0;
        this.m = -10;
        this.n = null;
        this.o = null;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = false;
        this.t = false;
        this.u = 0.0d;
        this.v = 0.0d;
        this.b = (a) parcel.readSerializable();
        this.c = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.d = z;
        this.e = parcel.readInt();
        this.g = com.getpebble.android.framework.g.r.a.fromCode(parcel.readInt());
        this.f = (FirmwareInstallData) parcel.readParcelable(FirmwareInstallData.class.getClassLoader());
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.h = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.i = z;
        this.j = (AppInfo) parcel.readParcelable(AppInfo.class.getClassLoader());
        this.a = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readInt();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.t = z2;
        this.v = parcel.readDouble();
        this.u = parcel.readDouble();
        this.w = null;
    }
}
