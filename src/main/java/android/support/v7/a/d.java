package android.support.v7.a;

import android.app.Notification.MediaStyle;
import android.media.session.MediaSession.Token;
import android.support.v4.app.ab;

class d {
    public static void a(ab abVar, int[] iArr, Object obj) {
        MediaStyle mediaStyle = new MediaStyle(abVar.a());
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        if (obj != null) {
            mediaStyle.setMediaSession((Token) obj);
        }
    }
}
