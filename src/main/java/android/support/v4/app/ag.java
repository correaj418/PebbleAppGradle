package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;

public class ag {

    public static abstract class a {

        public interface a {
            a a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, android.support.v4.app.at.a[] aVarArr, boolean z);

            a[] b(int i);
        }

        public abstract int a();

        public abstract CharSequence b();

        public abstract PendingIntent c();

        public abstract Bundle d();

        public abstract boolean e();

        public abstract android.support.v4.app.at.a[] g();
    }

    public static Notification a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        return notification;
    }
}
