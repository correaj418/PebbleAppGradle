package com.getpebble.android.framework.g;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.media.session.MediaController;
import android.media.session.MediaController.TransportControls;
import android.media.session.PlaybackState;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.f.d;
import com.getpebble.android.framework.l.a.p;
import com.getpebble.android.framework.l.b.s;
import com.getpebble.android.framework.l.b.u;
import com.getpebble.android.framework.l.b.v;
import com.getpebble.android.notifications.b.c.b;
import com.google.a.b.am;
import java.util.List;
import java.util.Set;

public class t extends ac {
    private final c a;
    private final AudioManager b;
    private final p c;
    private final boolean d;
    private ResolveInfo e = null;

    public t(c cVar, Context context, p pVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("Preferences cannot be null");
        } else if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        } else if (pVar == null) {
            throw new IllegalArgumentException("messageSender cannot be null");
        } else {
            this.b = (AudioManager) context.getApplicationContext().getSystemService("audio");
            this.a = cVar;
            this.c = pVar;
            if (this.c != null) {
                this.d = a(this.c.e());
            } else {
                this.d = false;
            }
            if (VERSION.SDK_INT >= 21) {
                d a = d.a();
                if (a != null) {
                    a.b();
                }
            }
            i();
        }
    }

    private Context c() {
        return a.K();
    }

    public static boolean a(PebbleDevice pebbleDevice) {
        try {
            ak.a pebbleDeviceRecord = ak.getPebbleDeviceRecord(a.K().getContentResolver(), pebbleDevice);
            if (pebbleDeviceRecord != null) {
                boolean z = pebbleDeviceRecord.capabilities.supportsExtendedMusicProtocol;
                f.d("MusicControlEndpoint", "doesDeviceSupportExtendedMusic: Provided device supports extended music? = " + z);
                return z;
            }
            f.d("MusicControlEndpoint", "doesDeviceSupportExtendedMusic: Provided device was null. Failed to determine if current device has extended music.");
            return false;
        } catch (Throwable e) {
            f.a("MusicControlEndpoint", "doesDeviceSupportExtendedMusic: Something went wrong when trying to determine if provided device has extended music.", e);
            return false;
        }
    }

    private void d() {
        b a = com.getpebble.android.f.a.a();
        if (a == null) {
            f.b("MusicControlEndpoint", "sendMusicInfo: musicInfo is null");
            return;
        }
        this.c.a(new s(a.a, a.b, a.c, a.d, a.f, a.e, this.d));
    }

    private void e() {
        com.getpebble.android.notifications.b.c.d a = com.getpebble.android.f.b.a();
        if (a == null) {
            f.b("MusicControlEndpoint", "sendPlaystateInfo: playStateInfo is null");
            return;
        }
        this.c.a(new u(a.a, (long) ((int) a.b), a.c, a.d, a.e));
    }

    private void f() {
        this.c.a(new v(com.getpebble.android.framework.j.a.a()));
    }

    private void h() {
        this.c.a(new com.getpebble.android.framework.l.b.t(PebbleApplication.y().a(c.a.MUSIC_TARGET_PKG, ""), PebbleApplication.y().a(c.a.MUSIC_TARGET_NAME, "")));
    }

    public void a(p pVar) {
        if (pVar == null) {
            f.a("MusicControlEndpoint", "onMessageReceived: Received null message, dropping");
            return;
        }
        p.a c = pVar.c();
        Context c2 = c();
        if (c2 == null) {
            f.b("MusicControlEndpoint", "onMessageReceived: Dropping music message; context is null");
            return;
        }
        try {
            a(c2, com.getpebble.android.notifications.b.c.a(c2, this.a), c);
        } catch (Throwable e) {
            f.a("MusicControlEndpoint", "onMessageReceived: Failed to execute command " + c.toString(), e);
        }
    }

    private boolean a(p.a aVar) {
        return aVar.equals(p.a.GET_ALL_INFORMATION);
    }

    private void a(Context context, ResolveInfo resolveInfo, p.a aVar) {
        f.d("MusicControlEndpoint", "handleCommand: Received Command: " + aVar.toString());
        if (resolveInfo == null || resolveInfo.activityInfo == null || resolveInfo.activityInfo.packageName == null) {
            f.d("MusicControlEndpoint", "handleCommand: invalid targetInfo, dropping command");
        } else if (a(aVar)) {
            b(aVar);
        } else if (com.getpebble.android.notifications.b.b.e.contains(resolveInfo.activityInfo.packageName) || VERSION.SDK_INT < 21) {
            b(context, resolveInfo, aVar);
        } else {
            a(resolveInfo, aVar);
        }
    }

    @TargetApi(21)
    private void a(ResolveInfo resolveInfo, p.a aVar) {
        d a = d.a();
        if (a == null) {
            f.d("MusicControlEndpoint", "postLollipopMusicControl: Post-Lollipop music session manager was null -- falling back to pre-lollipop controls");
            b(a.K(), resolveInfo, aVar);
            return;
        }
        List<MediaController> c = a.c();
        if (resolveInfo == null) {
            f.b("MusicControlEndpoint", "postLollipopMusicControl: Failed to perform music control. TargetInfo was null.");
        } else if (c.size() == 0) {
            f.d("MusicControlEndpoint", "postLollipopMusicControl: No media controllers found, falling back to pre-lollipop controls. [pkg = " + resolveInfo.activityInfo.packageName + "]");
            b(a.K(), resolveInfo, aVar);
        } else {
            for (MediaController mediaController : c) {
                if (resolveInfo.activityInfo.packageName.equals(mediaController.getPackageName())) {
                    String str;
                    PlaybackState playbackState = mediaController.getPlaybackState();
                    String str2 = "MusicControlEndpoint";
                    StringBuilder append = new StringBuilder().append("postLollipopMusicControl: Found controller for ").append(mediaController.getPackageName());
                    if (playbackState == null) {
                        str = " state = null";
                    } else {
                        str = " state = " + playbackState.getState() + " actions = " + playbackState.getActions();
                    }
                    f.d(str2, append.append(str).toString());
                }
            }
            for (MediaController mediaController2 : c) {
                PlaybackState playbackState2 = mediaController2.getPlaybackState();
                if (resolveInfo.activityInfo.packageName.equals(mediaController2.getPackageName())) {
                    TransportControls transportControls = mediaController2.getTransportControls();
                    switch (aVar) {
                        case VOLUME_UP:
                            mediaController2.adjustVolume(1, 9);
                            return;
                        case VOLUME_DOWN:
                            mediaController2.adjustVolume(-1, 9);
                            return;
                        case PLAY_PAUSE:
                            if (playbackState2 == null) {
                                break;
                            } else if (playbackState2.getState() == 3) {
                                transportControls.pause();
                                return;
                            } else {
                                transportControls.play();
                                return;
                            }
                        case NEXT_TRACK:
                            transportControls.skipToNext();
                            return;
                        case PREVIOUS_TRACK:
                            transportControls.skipToPrevious();
                            return;
                        default:
                            f.a("MusicControlEndpoint", "postLollipopMusicControl: Received unsupported music control command: " + aVar);
                            return;
                    }
                }
            }
            f.d("MusicControlEndpoint", "postLollipopMusicControl: Failed to find controller for " + resolveInfo.activityInfo.packageName + ", falling back to pre-lollipop controls.");
            b(a.K(), resolveInfo, aVar);
        }
    }

    private void b(Context context, ResolveInfo resolveInfo, p.a aVar) {
        switch (aVar) {
            case VOLUME_UP:
                this.b.adjustStreamVolume(3, 1, 9);
                return;
            case VOLUME_DOWN:
                this.b.adjustStreamVolume(3, -1, 9);
                return;
            case PLAY_PAUSE:
                a(context, resolveInfo, 85);
                return;
            case NEXT_TRACK:
                a(context, resolveInfo, 87);
                return;
            case PREVIOUS_TRACK:
                a(context, resolveInfo, 88);
                return;
            default:
                f.a("MusicControlEndpoint", "preLollipopMusicControl: Received unsupported music control command: " + aVar);
                return;
        }
    }

    private void b(p.a aVar) {
        switch (aVar) {
            case GET_ALL_INFORMATION:
                i();
                return;
            default:
                f.a("MusicControlEndpoint", "genericMusicControl: Received unsupported music control command: " + aVar);
                return;
        }
    }

    private void i() {
        d();
        if (this.d) {
            f.d("MusicControlEndpoint", "sendAllInformationToWatch: Sending all information to the watch...");
            e();
            f();
            h();
            return;
        }
        f.d("MusicControlEndpoint", "sendAllInformationToWatch: Connected device does not have extended music - only sending metadata.");
    }

    private void a(Context context, ResolveInfo resolveInfo, int i) {
        if (resolveInfo == null) {
            a(context, i);
        } else {
            b(context, resolveInfo, i);
        }
    }

    private static void a(Context context, int i) {
        long uptimeMillis = SystemClock.uptimeMillis();
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", null);
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(uptimeMillis, uptimeMillis, 0, i, 0));
        context.sendOrderedBroadcast(intent, null);
        intent = new Intent("android.intent.action.MEDIA_BUTTON", null);
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(uptimeMillis, uptimeMillis, 1, i, 0));
        context.sendOrderedBroadcast(intent, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.content.Context r7, android.content.pm.ResolveInfo r8, int r9) {
        /*
        r6 = this;
        r3 = 1;
        r0 = 0;
        r1 = r6.e;
        if (r1 != 0) goto L_0x0021;
    L_0x0006:
        r6.e = r8;
    L_0x0008:
        r2 = new android.content.ComponentName;
        r0 = r6.e;
        r0 = r0.activityInfo;
        r0 = r0.packageName;
        r1 = r6.e;
        r1 = r1.activityInfo;
        r1 = r1.name;
        r2.<init>(r0, r1);
        r5 = 0;
        r0 = r6;
        r1 = r7;
        r4 = r9;
        r0.a(r1, r2, r3, r4, r5);
        return;
    L_0x0021:
        r1 = r8.activityInfo;
        r1 = r1.packageName;
        r2 = r6.e;
        r2 = r2.activityInfo;
        r2 = r2.packageName;
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x003b;
    L_0x0031:
        r6.e = r8;
        r1 = r6.b;
        r1 = r1.isMusicActive();
        if (r1 == 0) goto L_0x0008;
    L_0x003b:
        r3 = r0;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getpebble.android.framework.g.t.b(android.content.Context, android.content.pm.ResolveInfo, int):void");
    }

    private void a(Context context, ComponentName componentName, boolean z, int i, BroadcastReceiver broadcastReceiver) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        Parcelable keyEvent = new KeyEvent(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, i, 0);
        intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
        Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
        Parcelable keyEvent2 = new KeyEvent(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, i, 0);
        intent2.putExtra("android.intent.extra.KEY_EVENT", keyEvent2);
        intent.setComponent(componentName);
        intent2.setComponent(componentName);
        f.d("MusicControlEndpoint", "forwardKeyCodeToComponent: Forwarding Down and Up intent events to " + componentName + " Down Intent: " + intent + " Down key:" + keyEvent + " Up Intent: " + intent2 + " Up key:" + keyEvent2);
        if (z) {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(componentName.getPackageName());
                if (launchIntentForPackage != null) {
                    context.startActivity(launchIntentForPackage);
                }
            } catch (Throwable e) {
                f.b("MusicControlEndpoint", "forwardKeyCodeToComponent: error getting launchIntent", e);
                return;
            }
        }
        context.sendOrderedBroadcast(intent, null, broadcastReceiver, null, -1, null, null);
        context.sendOrderedBroadcast(intent2, null, broadcastReceiver, null, -1, null, null);
    }

    public void b() {
    }

    Set<com.getpebble.android.bluetooth.g.a> a() {
        return am.b(com.getpebble.android.bluetooth.g.a.MUSIC_CONTROL);
    }

    boolean a(com.getpebble.android.bluetooth.g.b bVar) {
        a(new p(bVar));
        return true;
    }

    boolean a(k kVar, FrameworkState frameworkState) {
        switch (kVar.b()) {
            case UPDATE_MUSIC_NOW_PLAYING:
                f.d("MusicControlEndpoint", "onRequest: Sending now playing info");
                d();
                break;
            case UPDATE_MUSIC_PLAYSTATE:
                if (!this.d) {
                    f.d("MusicControlEndpoint", "onRequest: Got request to send play state info, but connected device does not support extended music.");
                    break;
                }
                e();
                f.d("MusicControlEndpoint", "onRequest: Sending play state info");
                break;
            case UPDATE_MUSIC_VOLUME_LEVEL:
                if (!this.d) {
                    f.d("MusicControlEndpoint", "onRequest: Got request to send volume info, but connected device does not support extended music.");
                    break;
                }
                f();
                f.d("MusicControlEndpoint", "onRequest: Sending music volume info");
                break;
            case UPDATE_MUSIC_PLAYER_INFO:
                if (!this.d) {
                    f.d("MusicControlEndpoint", "onRequest: Got request to send music player info, but connected device does not support extended music.");
                    break;
                }
                h();
                f.d("MusicControlEndpoint", "onRequest: Sending music player info");
                break;
            default:
                f.d("MusicControlEndpoint", "onRequest: No matching request found in MusicControlEndpoint, not handling.");
                return false;
        }
        return true;
    }
}
