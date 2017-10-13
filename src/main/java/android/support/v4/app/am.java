package android.support.v4.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;

public abstract class am extends Service {

    private class a extends android.support.v4.app.u.a {
        final /* synthetic */ am a;

        private a(am amVar) {
            this.a = amVar;
        }

        public void a(String str, int i, String str2, Notification notification) {
            this.a.a(getCallingUid(), str);
            long clearCallingIdentity = clearCallingIdentity();
            try {
                this.a.a(str, i, str2, notification);
            } finally {
                restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public void a(String str, int i, String str2) {
            this.a.a(getCallingUid(), str);
            long clearCallingIdentity = clearCallingIdentity();
            try {
                this.a.a(str, i, str2);
            } finally {
                restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public void a(String str) {
            this.a.a(getCallingUid(), str);
            long clearCallingIdentity = clearCallingIdentity();
            try {
                this.a.a(str);
            } finally {
                restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public abstract void a(String str);

    public abstract void a(String str, int i, String str2);

    public abstract void a(String str, int i, String str2, Notification notification);

    public IBinder onBind(Intent intent) {
        if (!intent.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL") || VERSION.SDK_INT > 19) {
            return null;
        }
        return new a();
    }

    private void a(int i, String str) {
        String[] packagesForUid = getPackageManager().getPackagesForUid(i);
        int length = packagesForUid.length;
        int i2 = 0;
        while (i2 < length) {
            if (!packagesForUid[i2].equals(str)) {
                i2++;
            } else {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + i + " is not authorized for package " + str);
    }
}
