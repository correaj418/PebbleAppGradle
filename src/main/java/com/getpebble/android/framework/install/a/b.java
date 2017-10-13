package com.getpebble.android.framework.install.a;

import android.content.ContentResolver;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.am.d;
import com.getpebble.android.common.model.i;
import com.getpebble.android.framework.g.k;
import com.getpebble.android.framework.jskit.c;
import java.io.File;

public class b {

    public interface a {
        void a(boolean z);
    }

    public static void a(final Uri uri, final ContentResolver contentResolver, final a aVar) {
        f.d("AppSideloading", "sideloadApp() uri = " + uri);
        new com.getpebble.android.bluetooth.b.f() {
            private final String d = "AppSideloading";

            public boolean doInBackground() {
                a aVar = new a(com.getpebble.android.common.a.K());
                File b = aVar.b(uri);
                if (b == null) {
                    f.b("AppSideloading", "pbwFile is null");
                    return false;
                }
                com.getpebble.android.common.framework.install.app.b c = aVar.c(b);
                if (c == null) {
                    f.b("AppSideloading", "bundle is null");
                    return false;
                }
                for (d uuid : d.values()) {
                    if (uuid.getUuid().equals(c.i().getUuid())) {
                        f.b("AppSideloading", "Cannot sideload with the same UUID as a system app: " + c.i().getUuid());
                        return false;
                    }
                }
                com.getpebble.android.framework.install.a.a.a aVar2 = new com.getpebble.android.framework.install.a.a.a(c.i().getUuid(), new i(c.i().getVersionLabel()));
                aVar.a(aVar2, false);
                c.a(com.getpebble.android.common.a.K()).a(c);
                f.d("AppSideloading", "cached = " + aVar.a(aVar2, b));
                try {
                    am.a(contentResolver, c);
                    com.getpebble.android.framework.b.a.a(new k(com.getpebble.android.bluetooth.g.a.APP_REORDER, com.getpebble.android.framework.g.k.a.SEND_APP_ORDER));
                    com.getpebble.android.framework.timeline.i.a(c.i().getUuid());
                } catch (Throwable e) {
                    f.a("AppSideloading", "Error sideloading pbw", e);
                } catch (Throwable e2) {
                    f.a("AppSideloading", "Error sideloading pbw", e2);
                } finally {
                    c.e();
                }
                return true;
            }

            public void onTaskSuccess() {
                if (aVar != null) {
                    aVar.a(true);
                }
            }

            public void onTaskFailed() {
                if (aVar != null) {
                    aVar.a(false);
                }
            }
        }.submit();
    }
}
