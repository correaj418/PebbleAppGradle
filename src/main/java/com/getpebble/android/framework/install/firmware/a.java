package com.getpebble.android.framework.install.firmware;

import android.text.TextUtils;
import c.a.a.a.e;
import com.getpebble.android.common.framework.install.PebbleManifest;
import com.getpebble.android.common.model.v;
import com.getpebble.android.framework.install.firmware.FirmwareManifest.FirmwareInfo;
import com.getpebble.android.framework.install.firmware.FirmwareManifest.FirmwareType;
import com.getpebble.android.framework.timeline.h;
import java.io.IOException;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class a extends com.getpebble.android.common.framework.install.a<FirmwareManifest> {
    private final FirmwareManifest a = ((FirmwareManifest) a(FirmwareManifest.class));
    private final h b;
    private v c;
    private int d = 0;
    private int e = 0;

    public /* synthetic */ PebbleManifest c() {
        return h();
    }

    public int f() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public int g() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public a(ZipFile zipFile, Map<String, ZipEntry> map) {
        super(zipFile, map);
        if (this.a == null) {
            throw new IllegalStateException("'Manifest' cannot be null!");
        }
        this.b = a((Map) map);
        FirmwareInfo firmware = this.a.getFirmware();
        if (firmware != null && !TextUtils.isEmpty(firmware.getVersionTag())) {
            try {
                this.c = new v(this.a.getFirmware().getVersionTag(), this.a.getFirmware().getTimestamp());
            } catch (IllegalArgumentException e) {
                this.c = null;
            }
        }
    }

    public FirmwareManifest h() {
        return this.a;
    }

    public h i() {
        return this.b;
    }

    private h a(Map<String, ZipEntry> map) {
        h hVar = null;
        if (map.containsKey("layouts.json.auto")) {
            try {
                hVar = h.from(e.b(a("layouts.json.auto")));
            } catch (IOException e) {
            }
        }
        return hVar;
    }

    public boolean j() {
        if (h().getFirmware() == null || h().getFirmware().getType() == null) {
            return false;
        }
        if (h().getFirmware().getType().equals(FirmwareType.RECOVERY) || h().getFirmware().getType().equals(FirmwareType.SAFE)) {
            return true;
        }
        return false;
    }

    public int k() {
        int size = h().getFirmware().getSize();
        if (d()) {
            return size + h().getResourceInfo().getSize();
        }
        return size;
    }

    public v l() {
        return this.c;
    }
}
