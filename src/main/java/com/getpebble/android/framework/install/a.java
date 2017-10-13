package com.getpebble.android.framework.install;

import android.content.Context;
import com.b.a.c.n;
import com.b.b.h;
import com.b.b.j;
import com.b.b.x;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.g;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class a extends b {
    private final Context c;
    private final String d;

    public a(Context context, String str) {
        super("FileDownloadManager", context, str);
        this.c = context;
        this.d = str;
        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
    }

    private static boolean f(String str) {
        return str.startsWith("file:///android_asset/");
    }

    public File a(String str, File file) {
        f.d("FileDownloadManager", "downloadFile() " + str);
        byte[] b = b(str);
        if (b != null) {
            if (file == null) {
                file = e(str);
            }
            return a(file, b);
        }
        f.a("FileDownloadManager", "downloadFile: fileBytes was null.");
        return null;
    }

    public byte[] b(String str) {
        boolean f = f(str);
        try {
            g.a("FileDownloadManager", "fetchFile");
            x xVar = (x) ((com.b.b.b.c.a.a) j.a(this.c).d(str)).c().n().get(60000, TimeUnit.MILLISECONDS);
            if (xVar == null) {
                f.b("FileDownloadManager", "response is null");
                return null;
            }
            h hVar = f ? new h(200, "Success", new n()) : xVar.d();
            if (hVar == null) {
                f.b("FileDownloadManager", "response getHeaders() is null");
                f.d("FileDownloadManager", "response result = " + xVar.b());
                return null;
            }
            int b = hVar.b();
            if (b <= 599 && b >= 500 && this.d.equals("firmware")) {
                c.d();
            }
            if (b == 200) {
                return (byte[]) xVar.b();
            }
            f.a("FileDownloadManager", "Unexpected response code: " + xVar.d().b());
            return null;
        } catch (Throwable e) {
            f.a("FileDownloadManager", "Interrupted while fetching file.", e);
            return null;
        } catch (Throwable e2) {
            f.a("FileDownloadManager", "Exception while fetching file.", e2);
            return null;
        } catch (Throwable e22) {
            f.a("FileDownloadManager", "Exception while fetching file.", e22);
            return null;
        }
    }

    public File a(File file, byte[] bArr) {
        File file2 = null;
        try {
            file2 = super.a(file, bArr);
        } catch (Throwable e) {
            f.a("FileDownloadManager", "Unable to write to file.", e);
        } catch (Throwable e2) {
            f.a("FileDownloadManager", "Unable to write bytes.", e2);
        }
        return file2;
    }
}
