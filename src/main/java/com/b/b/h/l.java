package com.b.b.h;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Build.VERSION;
import com.b.a.b.e;
import com.b.a.b.i;
import com.b.b.a.b;
import com.b.b.h.g.a;
import com.b.b.j;
import com.b.b.y;
import java.io.File;
import java.net.URI;

public class l extends j {
    @TargetApi(10)
    public static Bitmap a(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        try {
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
            return frameAtTime;
        } finally {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e) {
            }
        }
    }

    static boolean a() {
        return Build.MANUFACTURER.toLowerCase().contains("samsung");
    }

    public e<b> a(Context context, j jVar, String str, String str2, int i, int i2, boolean z) {
        if (!str2.startsWith("file")) {
            return null;
        }
        final a a = g.a(str2);
        if (a == null || !g.a(a.a)) {
            return null;
        }
        final e<b> iVar = new i();
        final String str3 = str2;
        final int i3 = i;
        final int i4 = i2;
        final String str4 = str;
        j.a().execute(new Runnable(this) {
            final /* synthetic */ l g;

            public void run() {
                File file = new File(URI.create(str3));
                if (!iVar.isCancelled()) {
                    try {
                        Bitmap createVideoThumbnail;
                        if (l.a() || VERSION.SDK_INT < 10) {
                            createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(file.getAbsolutePath(), 1);
                        } else {
                            createVideoThumbnail = l.a(file.getAbsolutePath());
                        }
                        if (createVideoThumbnail == null) {
                            throw new Exception("video bitmap failed to load");
                        }
                        Point point = new Point(createVideoThumbnail.getWidth(), createVideoThumbnail.getHeight());
                        if (createVideoThumbnail.getWidth() > i3 * 2 && createVideoThumbnail.getHeight() > i4 * 2) {
                            float min = Math.min(((float) i3) / ((float) createVideoThumbnail.getWidth()), ((float) i4) / ((float) createVideoThumbnail.getHeight()));
                            if (min != 0.0f) {
                                createVideoThumbnail = Bitmap.createScaledBitmap(createVideoThumbnail, (int) (((float) createVideoThumbnail.getWidth()) * min), (int) (min * ((float) createVideoThumbnail.getHeight())), true);
                            }
                        }
                        Object bVar = new b(str4, a.b, createVideoThumbnail, point);
                        bVar.e = y.LOADED_FROM_CACHE;
                        iVar.b(bVar);
                    } catch (Throwable e) {
                        iVar.a(new Exception(e));
                    } catch (Exception e2) {
                        iVar.a(e2);
                    }
                }
            }
        });
        return iVar;
    }
}
