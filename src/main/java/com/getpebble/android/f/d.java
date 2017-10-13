package com.getpebble.android.f;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaController.Callback;
import android.media.session.MediaSessionManager;
import android.media.session.MediaSessionManager.OnActiveSessionsChangedListener;
import android.media.session.PlaybackState;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.common.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.notifications.b.b;
import com.getpebble.android.notifications.b.c;
import java.util.ArrayList;
import java.util.List;

@TargetApi(21)
public class d implements OnActiveSessionsChangedListener {
    private static d a = null;
    private List<MediaController> b = new ArrayList();
    private final MediaSessionManager c;
    private final Handler d;

    private d() {
        Context K = a.K();
        this.c = (MediaSessionManager) K.getApplicationContext().getSystemService("media_session");
        ComponentName componentName = new ComponentName(K.getPackageName(), "com.getpebble.android.notifications.PblNotificationService");
        this.d = new Handler(Looper.getMainLooper());
        this.b = this.c.getActiveSessions(componentName);
        d();
        this.c.addOnActiveSessionsChangedListener(this, componentName, this.d);
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            f.e("PostLollipopMusicManager", "getInstance()");
            if (a == null) {
                f.d("PostLollipopMusicManager", "sInstance was null -- creating new PostLollipopMusicManager...");
                try {
                    a = new d();
                } catch (Throwable e) {
                    f.b("PostLollipopMusicManager", "SecurityException while getting instance", e);
                }
            }
            dVar = a;
        }
        return dVar;
    }

    public void onActiveSessionsChanged(List<MediaController> list) {
        boolean z = false;
        String a = c.a();
        if (a != null) {
            boolean z2;
            for (MediaController packageName : this.b) {
                if (packageName.getPackageName().equals(a)) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
            for (MediaController packageName2 : list) {
                if (packageName2.getPackageName().equals(a)) {
                    z = true;
                    break;
                }
            }
            if (z2 && !r3) {
                f.d("PostLollipopMusicManager", "onActiveSessionsChanged: active app controller (" + a + ") was removed - setting playback state to unknown");
                com.getpebble.android.notifications.b.c.d dVar = new com.getpebble.android.notifications.b.c.d();
                dVar.a = c.c.UNKNOWN;
                dVar.f = c.a.BROADCAST_RECEIVER;
                b.a(dVar, null, true);
            }
        }
        this.b = list;
        f.e("PostLollipopMusicManager", "onActiveSessionsChanged() size = " + this.b.size());
        d();
    }

    private void d() {
        for (final MediaController mediaController : this.b) {
            if (b.e.contains(mediaController.getPackageName())) {
                f.c("PostLollipopMusicManager", "registerSessionCallbacks: not registering for broken controller " + mediaController.getPackageName());
            } else {
                f.e("PostLollipopMusicManager", "registerSessionCallbacks() controller for " + mediaController.getPackageName());
                mediaController.registerCallback(new Callback(this) {
                    final /* synthetic */ d b;

                    public void onMetadataChanged(MediaMetadata mediaMetadata) {
                        this.b.a(mediaMetadata, mediaController);
                    }

                    public void onPlaybackStateChanged(PlaybackState playbackState) {
                        this.b.a(playbackState, mediaController);
                        if (a.a().h.equals(c.a.UNKNOWN)) {
                            f.d("PostLollipopMusicManager", "Could not find cached music metadata -- updating cache from controller.");
                            onMetadataChanged(mediaController.getMetadata());
                        }
                    }
                }, this.d);
                PlaybackState playbackState = mediaController.getPlaybackState();
                if (playbackState != null && playbackState.getState() == 3) {
                    a(mediaController.getMetadata(), mediaController);
                }
            }
        }
    }

    private void a(MediaMetadata mediaMetadata, MediaController mediaController) {
        if (mediaMetadata == null) {
            f.d("PostLollipopMusicManager", "Failed to update metadata -- metadata was null.");
            return;
        }
        try {
            String string = mediaMetadata.getString("android.media.metadata.ARTIST");
            String string2 = mediaMetadata.getString("android.media.metadata.ALBUM");
            String string3 = mediaMetadata.getString("android.media.metadata.TITLE");
            Long valueOf = Long.valueOf(mediaMetadata.getLong("android.media.metadata.DURATION"));
            c.b bVar = new c.b();
            bVar.b = string2;
            bVar.a = string;
            bVar.c = string3;
            bVar.h = c.a.MEDIACONTROLLER;
            bVar.d = valueOf.longValue();
            a.a(bVar);
        } catch (Throwable e) {
            f.a("PostLollipopMusicManager", "Something went wrong when trying to retrieve metadata.", e);
        }
        c.d(mediaController.getPackageName());
    }

    private void a(PlaybackState playbackState, MediaController mediaController) {
        com.getpebble.android.notifications.b.c.d dVar = new com.getpebble.android.notifications.b.c.d();
        if (playbackState.getState() == 3) {
            dVar.a = c.c.PLAYING;
            c.d(mediaController.getPackageName());
        } else if (playbackState.getState() == 2) {
            if (c.c(mediaController.getPackageName())) {
                dVar.a = c.c.PAUSED;
            } else {
                return;
            }
        } else if (playbackState.getState() == 5) {
            c.d(mediaController.getPackageName());
            dVar.a = c.c.REWINDING;
        } else if (playbackState.getState() == 4) {
            c.d(mediaController.getPackageName());
            dVar.a = c.c.FORWARDING;
        } else if (c.c(mediaController.getPackageName())) {
            f.d("PostLollipopMusicManager", "Music is in unhandled state: " + playbackState.toString() + " / " + mediaController.getPackageName());
            dVar.a = c.c.UNKNOWN;
        } else {
            return;
        }
        dVar.b = playbackState.getPosition();
        dVar.c = (int) (playbackState.getPlaybackSpeed() * 100.0f);
        dVar.f = c.a.MEDIACONTROLLER;
        dVar.g = System.currentTimeMillis();
        b.a(dVar, mediaController.getPackageName());
    }

    public void b() {
        f.d("PostLollipopMusicManager", "refreshPlayState size = " + this.b.size());
        for (MediaController mediaController : this.b) {
            PlaybackState playbackState = mediaController.getPlaybackState();
            if (playbackState != null && playbackState.getState() == 3) {
                a(mediaController.getPlaybackState(), mediaController);
            }
        }
    }

    public List<MediaController> c() {
        return this.b;
    }
}
