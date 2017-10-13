package com.getpebble.android.framework.g;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.install.PebbleManifest.ResourceInfo;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.v;
import com.getpebble.android.common.model.z;
import com.getpebble.android.framework.install.firmware.FirmwareManifest;
import com.getpebble.android.framework.install.firmware.FirmwareManifest.FirmwareType;
import com.getpebble.android.framework.l.b.ac;
import com.getpebble.android.framework.l.b.ai;
import com.google.a.f.e;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;

public class r extends l {
    private static int a = 1;
    private static int b = a;
    private static final v k = new v("v3.6.0", 0);
    private com.getpebble.android.framework.install.firmware.a c;
    private c d;
    private ae e;
    private e f;
    private final z g;
    private b h = b.NOT_STARTED;
    private int i = 0;
    private ContentResolver j;
    private boolean l = false;
    private boolean m = true;
    private Handler n;
    private Runnable o = new Runnable(this) {
        final /* synthetic */ r a;

        {
            this.a = r1;
        }

        public void run() {
            synchronized (this.a) {
                if (this.a.y() && b.WAITING_FOR_SYSTEM_MESSAGE.equals(this.a.h)) {
                    if (this.a.l) {
                        f.b("InstallFirmwareEndpointSet", "Failed twice trying to initialise FW update from 3.6.0: sending watch to PRF");
                        this.a.a(new ac(com.getpebble.android.framework.l.b.ac.a.RESET_INTO_PRF));
                    } else {
                        f.b("InstallFirmwareEndpointSet", "Timed out waiting for system message response with 3.6.0 work-around; trying again");
                        this.a.r();
                        this.a.l = true;
                        return;
                    }
                }
                this.a.h = b.FAILED;
                this.a.a(a.TIMEOUT);
            }
        }
    };
    private final b p = new b(this) {
        final /* synthetic */ r a;

        {
            this.a = r1;
        }

        public void a(e eVar, e eVar2, e eVar3) {
            int j;
            FirmwareType type = this.a.c.h().getFirmware().getType();
            boolean z = FirmwareType.RECOVERY.equals(type) || FirmwareType.SAFE.equals(type);
            if (com.getpebble.android.framework.o.b.a.isSmoothFwInstallProgressSupported()) {
                this.a.i = this.a.i + eVar.intValue();
                j = (this.a.i * 100) / this.a.c.k();
            } else {
                j = this.a.a(this.a.h, eVar2, eVar3, z);
            }
            if (this.a.m && eVar.intValue() >= r.b) {
                this.a.m = false;
            }
            c l = this.a.k();
            if (l != null) {
                l.a(j);
            }
        }

        public void a(e eVar) {
            switch (this.a.h) {
                case SENDING_RESOURCES:
                    this.a.f = eVar;
                    this.a.t();
                    return;
                case SENDING_FIRMWARE:
                    this.a.h = b.INSTALLING_FIRMWARE;
                    if (eVar == null) {
                        this.a.h = b.FAILED;
                        this.a.a(a.FIRMWARE_LOAD_FAILED);
                        return;
                    }
                    this.a.g.c(eVar);
                    return;
                default:
                    return;
            }
        }

        public void a(com.getpebble.android.framework.g.z.a aVar) {
            a aVar2;
            switch (this.a.h) {
                case SENDING_RESOURCES:
                    aVar2 = a.RESOURCE_LOAD_FAILED;
                    if (aVar.equals(com.getpebble.android.framework.g.z.a.INVALID_CRC)) {
                        aVar2 = a.INVALID_RESOURCE_CRC;
                    } else if (aVar.equals(com.getpebble.android.framework.g.z.a.TIMEOUT)) {
                        aVar2 = a.TIMEOUT;
                    }
                    this.a.h = b.FAILED;
                    this.a.a(aVar2);
                    return;
                case SENDING_FIRMWARE:
                    aVar2 = a.FIRMWARE_LOAD_FAILED;
                    if (aVar.equals(com.getpebble.android.framework.g.z.a.INVALID_CRC)) {
                        aVar2 = a.INVALID_FIRMWARE_CRC;
                    }
                    this.a.h = b.FAILED;
                    this.a.a(aVar2);
                    return;
                default:
                    return;
            }
        }

        public void b(e eVar) {
            switch (this.a.h) {
                case INSTALLING_FIRMWARE:
                    if (this.a.c.d()) {
                        this.a.h = b.INSTALLING_RESOURCES;
                        this.a.g.c(this.a.f);
                        return;
                    }
                    break;
                case INSTALLING_RESOURCES:
                    break;
                default:
                    return;
            }
            this.a.u();
            this.a.h = b.COMPLETE;
            this.a.a(a.OK);
        }

        public void b(com.getpebble.android.framework.g.z.a aVar) {
            this.a.h = b.FAILED;
            this.a.v();
            switch (this.a.h) {
                case INSTALLING_FIRMWARE:
                    this.a.a(a.FIRMWARE_LOAD_FAILED);
                    return;
                case INSTALLING_RESOURCES:
                    this.a.a(a.RESOURCE_LOAD_FAILED);
                    return;
                default:
                    return;
            }
        }
    };

    public enum a {
        OK(0, false, true),
        WRONG_HW_VERSION(-2, false, true),
        BUNDLE_NOT_FOUND(-3, false),
        FIRMWARE_START_FAILED(-4, true),
        RESOURCE_LOAD_FAILED(-5, true),
        FIRMWARE_LOAD_FAILED(-6, true),
        INVALID_RESOURCE_CRC(-7, true),
        INVALID_FIRMWARE_CRC(-8, true),
        TIMEOUT(-9, false, true),
        UNKNOWN_ERROR(-10, true),
        ENDPOINT_NOT_ACTIVE(-11, true),
        NO_DEVICE_CONNECTED(-13, false, true),
        IN_PROGRESS(-14, false),
        OLD_SIDELOAD_REQUEST(-15, false, true),
        NO_FIRMWARE_FOR_3X_MIGRATION(-16, false, true),
        INTERRUPTED(-17, false, false);
        
        public final boolean isPrfResetRequired;
        public final boolean isSuccess;
        private final int mCode;

        private a(int i, boolean z) {
            this(r7, r8, i, z, false);
        }

        private a(int i, boolean z, boolean z2) {
            this.mCode = i;
            this.isSuccess = z2;
            this.isPrfResetRequired = z;
        }

        public int getCode() {
            return this.mCode;
        }

        public static a fromCode(int i) {
            for (a aVar : values()) {
                if (aVar.getCode() == i) {
                    return aVar;
                }
            }
            return UNKNOWN_ERROR;
        }
    }

    enum b {
        NOT_STARTED,
        WAITING_FOR_SYSTEM_MESSAGE,
        SENDING_RESOURCES,
        SENDING_FIRMWARE,
        INSTALLING_RESOURCES,
        INSTALLING_FIRMWARE,
        COMPLETE,
        FAILED
    }

    public interface c {
        void a(int i);

        void a(a aVar);

        void b(a aVar);
    }

    public r(com.getpebble.android.framework.b.a aVar, com.getpebble.android.framework.install.firmware.a aVar2, c cVar, ContentResolver contentResolver) {
        super(aVar);
        if (aVar2 == null) {
            throw new IllegalArgumentException("'FirmwareBundle' must not be null!");
        } else if (contentResolver == null) {
            throw new IllegalArgumentException("'resolver' must not be null!");
        } else {
            this.c = aVar2;
            this.d = cVar;
            this.n = new Handler(Looper.getMainLooper());
            this.j = contentResolver;
            this.g = new z(this);
            this.g.a(this.p);
        }
    }

    protected void f() {
    }

    private c k() {
        return this.d;
    }

    private p l() {
        return this;
    }

    private ae m() {
        if (this.e == null) {
            this.e = new ae(l());
        }
        return this.e;
    }

    private void n() {
        this.n.postDelayed(this.o, 15000);
    }

    private void o() {
        this.n.removeCallbacks(this.o);
    }

    private void a(a aVar) {
        f.d("InstallFirmwareEndpointSet", "sendResult: result = " + aVar);
        o();
        c k = k();
        if (k == null) {
            f.a("InstallFirmwareEndpointSet", "sendResult: Listener is null!");
            return;
        }
        com.getpebble.android.common.b.b.c y = PebbleApplication.y();
        if (aVar.equals(a.OK)) {
            f.d("InstallFirmwareEndpointSet", "sendResult: FW update finished successfully. Enabling resumable FW updates");
            y.b(com.getpebble.android.common.b.b.c.a.DISABLE_RESUMED_UPDATES_ERROR, false);
            k.b(aVar);
        } else {
            f.c("InstallFirmwareEndpointSet", "sendResult: resumed FW update failed. Disable the feature? " + this.m);
            y.b(com.getpebble.android.common.b.b.c.a.DISABLE_RESUMED_UPDATES_ERROR, this.m);
            k.a(aVar);
        }
        if (this.c != null) {
            this.c.e();
        }
    }

    public synchronized void i() {
        f.d("InstallFirmwareEndpointSet", "startInstall()");
        if (h()) {
            a w = w();
            if (w != a.OK) {
                this.h = b.FAILED;
                a(w);
            } else if (z()) {
                r();
            } else if (this.c.d()) {
                s();
            } else {
                t();
            }
        } else {
            this.h = b.FAILED;
            a(a.ENDPOINT_NOT_ACTIVE);
        }
    }

    private void p() {
        v l = this.c.l();
        FirmwareManifest h = this.c.h();
        if (l != null && h != null) {
            com.getpebble.android.common.b.a.a.c.f(l.getVersionTag(), h.getFirmware().getType().mTypeName);
        }
    }

    private void q() {
        if (com.getpebble.android.framework.o.b.a.isSmoothFwInstallProgressSupported()) {
            int k = this.c.k();
            int f = this.c.f() + this.c.g();
            int i = k - f;
            f.d("InstallFirmwareEndpointSet", "smooth FW install starting " + f + " / " + k);
            this.i = f;
            m().a(f, i);
            return;
        }
        f.d("InstallFirmwareEndpointSet", "smooth FW install not supported, using legacy mode");
        m().c();
    }

    private synchronized void r() {
        f.d("InstallFirmwareEndpointSet", "sendFirmwareStartMessage()");
        p();
        this.h = b.WAITING_FOR_SYSTEM_MESSAGE;
        m().a(new com.getpebble.android.framework.g.ae.a(this) {
            final /* synthetic */ r a;

            {
                this.a = r1;
            }

            public void a(com.getpebble.android.framework.l.a.v vVar) {
                switch (vVar.c()) {
                    case FIRMWARE_UPDATE_STATUS_RESPONSE:
                        ByteBuffer wrap = ByteBuffer.wrap(vVar.d());
                        wrap.order(ByteOrder.LITTLE_ENDIAN);
                        com.getpebble.android.bluetooth.b.b.b(wrap);
                        int intValue = com.getpebble.android.bluetooth.b.b.c(wrap).intValue();
                        e c = com.getpebble.android.bluetooth.b.b.c(wrap);
                        int intValue2 = com.getpebble.android.bluetooth.b.b.c(wrap).intValue();
                        e c2 = com.getpebble.android.bluetooth.b.b.c(wrap);
                        f.c("InstallFirmwareEndpointSet", "Received status message: " + String.format("resource_offset=%d ", new Object[]{Integer.valueOf(intValue)}) + String.format("resource_crc=0x%x ", new Object[]{Integer.valueOf(c.intValue())}) + String.format("fw_offset=%d ", new Object[]{Integer.valueOf(intValue2)}) + String.format("fw_crc=c0x%x ", new Object[]{Integer.valueOf(c2.intValue())}));
                        if (new com.getpebble.android.framework.install.e(this) {
                            final /* synthetic */ AnonymousClass2 a;

                            {
                                this.a = r1;
                            }

                            public InputStream a() {
                                return this.a.a.c.a(this.a.a.c.h().getFirmware().getName());
                            }
                        }.a(c2, intValue2)) {
                            this.a.c.a(intValue2);
                        } else {
                            f.d("InstallFirmwareEndpointSet", "FW CRC does not match, starting over");
                            this.a.c.a(0);
                        }
                        if (new com.getpebble.android.framework.install.e(this) {
                            final /* synthetic */ AnonymousClass2 a;

                            {
                                this.a = r1;
                            }

                            public InputStream a() {
                                return this.a.a.c.a(this.a.a.c.h().getResourceInfo().getName());
                            }
                        }.a(c, intValue)) {
                            this.a.c.b(intValue);
                        } else {
                            f.d("InstallFirmwareEndpointSet", "Resource CRC does not match, starting over");
                            this.a.c.b(0);
                        }
                        this.a.q();
                        return;
                    case FIRMWARE_UPDATE_START_ACK:
                        try {
                            com.getpebble.android.framework.l.a.a from = com.getpebble.android.framework.l.a.a.from(vVar);
                            this.a.o();
                            if (!from.equals(com.getpebble.android.framework.l.a.a.FIRMWARE_UPDATE_RUNNING)) {
                                f.b("InstallFirmwareEndpointSet", "unpexpected response: " + from);
                                this.a.h = b.FAILED;
                                this.a.a(a.FIRMWARE_START_FAILED);
                                return;
                            } else if (this.a.c.d()) {
                                this.a.s();
                                return;
                            } else {
                                this.a.t();
                                return;
                            }
                        } catch (Throwable e) {
                            f.b("InstallFirmwareEndpointSet", "sendFirmwareStartMessage: Invalid firmware update response", e);
                            return;
                        }
                    default:
                        f.c("InstallFirmwareEndpointSet", "sendFirmwareStartMessage: Dropping system message of type: " + vVar.c().toString());
                        return;
                }
            }
        });
        if (y()) {
            f.c("InstallFirmwareEndpointSet", "sendFirmwareStartMessage: Sending set time message to allow FW updates on 3.6.0");
            a(new ai());
        }
        com.getpebble.android.common.b.b.c y = PebbleApplication.y();
        boolean a = y.a(com.getpebble.android.common.b.b.c.a.DISABLE_RESUMED_UPDATES_ERROR, false);
        boolean a2 = y.a(com.getpebble.android.common.b.b.c.a.DISABLE_RESUMED_UPDATES_USER, false);
        boolean A = A();
        if (a || a2 || !A) {
            f.d("InstallFirmwareEndpointSet", "sendFirmwareStartMessage: not attempting to resume update(supported=" + A + " disabled by user=" + a2 + " disabled due to last update failing=" + a + ")");
            q();
        } else {
            y.b(com.getpebble.android.common.b.b.c.a.DISABLE_RESUMED_UPDATES_ERROR, true);
            m().a(com.getpebble.android.framework.l.b.ad.a.FIRMWARE_STATUS);
        }
        n();
    }

    private synchronized void s() {
        f.d("InstallFirmwareEndpointSet", "sendResources()");
        this.h = b.SENDING_RESOURCES;
        try {
            InputStream a = this.c.a(this.c.h().getResourceInfo().getName());
            int g = this.c.g();
            int size = this.c.h().getResourceInfo().getSize();
            this.g.a(com.getpebble.android.common.framework.install.b.SYS_RESOURCES).a(a).a(null).a(size - g).a(this.c.h().getResourceInfo().getCrc()).b(0).a(A());
            this.g.c(g);
        } catch (Throwable e) {
            f.a("InstallFirmwareEndpointSet", "sendResources: Failed to set up put bytes endpoint when transferring resources", e);
            this.h = b.FAILED;
            a(a.RESOURCE_LOAD_FAILED);
        }
    }

    private synchronized void t() {
        this.h = b.SENDING_FIRMWARE;
        try {
            InputStream a = this.c.a(this.c.h().getFirmware().getName());
            int f = this.c.f();
            int size = this.c.h().getFirmware().getSize();
            e crc = this.c.h().getFirmware().getCrc();
            int i = this.c.d() ? 2 : 1;
            f.d("InstallFirmwareEndpointSet", "sendFirmware: isRecoveryBundle = " + this.c.j());
            this.g.a(this.c.j() ? com.getpebble.android.common.framework.install.b.RECOVERY : com.getpebble.android.common.framework.install.b.FIRMWARE).a(a).a(null).a(size - f).a(crc).b(i).a(A());
            this.g.c(f);
        } catch (Throwable e) {
            f.a("InstallFirmwareEndpointSet", "sendFirmware: Failed to get firmware from bundle.", e);
            this.h = b.FAILED;
            a(a.FIRMWARE_LOAD_FAILED);
        }
    }

    private void u() {
        f.d("InstallFirmwareEndpointSet", "sendInstallComplete()");
        m().a(com.getpebble.android.framework.l.b.ad.a.FIRMWARE_COMPLETE);
    }

    private void v() {
        f.d("InstallFirmwareEndpointSet", "sendInstallFailed()");
        m().a(com.getpebble.android.framework.l.b.ad.a.FIRMWARE_FAIL);
    }

    private a w() {
        if (!x()) {
            return a.UNKNOWN_ERROR;
        }
        if (!B()) {
            return a.WRONG_HW_VERSION;
        }
        if (C()) {
            return a.OK;
        }
        return a.UNKNOWN_ERROR;
    }

    private boolean x() {
        if (this.c.h().getFirmware() == null || !a(this.c.h().getFirmware()) || this.c.h().getFirmware().getHardwareRevision() == null) {
            return false;
        }
        if (!this.c.d() || a(this.c.h().getResourceInfo())) {
            return true;
        }
        return false;
    }

    private boolean a(ResourceInfo resourceInfo) {
        if (resourceInfo.getCrc() == null || resourceInfo.getSize() <= 0 || resourceInfo.getName() == null) {
            return false;
        }
        return true;
    }

    private boolean y() {
        com.getpebble.android.common.model.ak.a pebbleDeviceRecord = ak.getPebbleDeviceRecord(this.j, e());
        if (pebbleDeviceRecord == null || pebbleDeviceRecord.getFwVersion() == null) {
            return false;
        }
        return a(pebbleDeviceRecord.getFwVersion());
    }

    static boolean a(v vVar) {
        return k.equalsMajorMinorPoint(vVar);
    }

    private boolean z() {
        com.getpebble.android.common.model.ak.a pebbleDeviceRecord = ak.getPebbleDeviceRecord(this.j, e());
        if (pebbleDeviceRecord == null || pebbleDeviceRecord.getFwVersion() == null || !com.getpebble.android.framework.o.b.remoteSendsFirmwareUpdateAck(pebbleDeviceRecord.getFwVersion())) {
            return false;
        }
        return true;
    }

    private boolean A() {
        com.getpebble.android.common.model.ak.a pebbleDeviceRecord = ak.getPebbleDeviceRecord(this.j, e());
        return (pebbleDeviceRecord == null || pebbleDeviceRecord.capabilities == null || !pebbleDeviceRecord.capabilities.supportsFwUpdateAcrossDisconnection) ? false : true;
    }

    private boolean B() {
        if (this.c == null) {
            f.b("InstallFirmwareEndpointSet", "isFirmwareCompatible: null mFirmwareBundle");
            return false;
        }
        com.getpebble.android.common.model.ak.a pebbleDeviceRecord = ak.getPebbleDeviceRecord(this.j, e());
        if (pebbleDeviceRecord == null) {
            f.b("InstallFirmwareEndpointSet", "isFirmwareCompatible: Device record is null; assuming incompatible firmware");
            return false;
        }
        try {
            if (a(pebbleDeviceRecord.hwRevision, pebbleDeviceRecord.hwPlatform)) {
                f.c("InstallFirmwareEndpointSet", "isFirmwareCompatible: PBL-21542: Special Pebble Time Steel upgrade!");
                return true;
            }
            boolean equals = this.c.h().getFirmware().getHardwareRevision().equals(pebbleDeviceRecord.hwPlatform);
            if (!equals) {
                f.c("InstallFirmwareEndpointSet", "isFirmwareCompatible: pbz (" + this.c.h().getFirmware().getHardwareRevision() + ") not compatible with watch (" + pebbleDeviceRecord.hwPlatform + ")");
            }
            return equals;
        } catch (Throwable e) {
            f.b("InstallFirmwareEndpointSet", "isFirmwareCompatible: isFirmwareCompatible NPE", e);
            return false;
        }
    }

    private boolean a(String str, z zVar) {
        boolean z = true;
        boolean z2 = zVar.equals(com.getpebble.android.common.model.r.PEBBLE_SNOWY_DVT) || zVar.equals(com.getpebble.android.common.model.r.PEBBLE_SNOWY_EVT2);
        if (!z2 || !this.c.h().getFirmware().getHardwareRevision().equals(com.getpebble.android.common.model.r.PEBBLE_BOBBY_SMILES)) {
            return false;
        }
        if (str == null || !str.toLowerCase(Locale.US).contains("smiles")) {
            z = false;
        }
        return z;
    }

    private boolean C() {
        return true;
    }

    public synchronized boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        boolean a;
        com.getpebble.android.bluetooth.g.a fromCode = com.getpebble.android.bluetooth.g.a.fromCode(bVar.a());
        switch (fromCode) {
            case SYSTEM_MESSAGE:
                a = m().a(bVar);
                break;
            case PUT_BYTES:
                a = this.g.a(bVar);
                break;
            default:
                f.d("InstallFirmwareEndpointSet", "handleMessage: Ignoring message for endpoint: " + fromCode);
                a = false;
                break;
        }
        return a;
    }

    public void b() {
    }

    public void a() {
        f.a("InstallFirmwareEndpointSet", "onMessageSendFailed: Message send failed.");
        a(a.UNKNOWN_ERROR);
    }

    protected synchronized void d() {
        if (!(this.h == b.COMPLETE || this.h == b.FAILED || this.h == b.NOT_STARTED)) {
            f.d("InstallFirmwareEndpointSet", "onDestroy: interrupted (at state " + this.h + ")");
            this.h = b.FAILED;
            a(a.INTERRUPTED);
            this.c.e();
        }
    }

    int a(b bVar, e eVar, e eVar2, boolean z) {
        int i = 0;
        int intValue = eVar.c(e.a(100)).d(eVar2).intValue();
        switch (bVar) {
            case SENDING_RESOURCES:
                break;
            case SENDING_FIRMWARE:
                i = intValue;
                intValue = 100;
                break;
            default:
                f.b("InstallFirmwareEndpointSet", "progressUpdated: Got progress updated callback while in state: " + this.h + "; dropping");
                intValue = 0;
                break;
        }
        if (z) {
            return i;
        }
        return (i + intValue) / 2;
    }
}
