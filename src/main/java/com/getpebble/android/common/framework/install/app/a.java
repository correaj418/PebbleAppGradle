package com.getpebble.android.common.framework.install.app;

import com.getpebble.android.bluetooth.b.b;
import com.getpebble.android.common.b.a.f;
import com.google.a.f.e;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a {
    private final e a;
    private final e b;

    a(b bVar, com.getpebble.android.common.framework.install.app.b.a aVar) {
        InputStream inputStream = null;
        try {
            AppManifest e = bVar.e(aVar);
            if (e == null || e.getAppInfo() == null) {
                throw new IllegalArgumentException("Manifest or appInfo is null");
            }
            inputStream = bVar.a(e.getAppInfo().getName(), aVar);
            byte[] bArr = new byte[100];
            inputStream.read(bArr);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            wrap.position(88);
            this.b = b.c(wrap);
            wrap.position(96);
            this.a = b.c(wrap);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    f.d("AppBinaryInfo", "Error closing stream");
                }
            }
        } catch (Throwable e3) {
            f.a("AppBinaryInfo", "Failed to open app bundle", e3);
            throw new IllegalArgumentException("Invalid bundle - unable to parse binary");
        } catch (Throwable e32) {
            f.a("AppBinaryInfo", "Failed to open app bundle", e32);
            throw new IllegalArgumentException("Invalid bundle - unable to parse binary");
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    f.d("AppBinaryInfo", "Error closing stream");
                }
            }
        }
    }

    public e a() {
        return this.a;
    }

    public e b() {
        return this.b;
    }
}
