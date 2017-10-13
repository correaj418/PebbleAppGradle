package com.getpebble.android.framework.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.f.b;
import com.getpebble.android.notifications.b.c.a;
import com.getpebble.android.notifications.b.c.c;
import com.getpebble.android.notifications.b.c.d;

public class e extends BroadcastReceiver {
    public e(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.amazon.mp3.playstatechanged");
        intentFilter.addAction("com.andrew.apollo.playstatechanged");
        intentFilter.addAction("com.android.music.playbackcomplete");
        intentFilter.addAction("com.android.music.playstatechanged");
        intentFilter.addAction("com.htc.music.playstatechanged");
        intentFilter.addAction("com.htc.music.playbackcomplete");
        intentFilter.addAction("com.miui.player.playstatechanged");
        intentFilter.addAction("com.rdio.android.playstatechanged");
        intentFilter.addAction("com.real.IMP.playstatechanged");
        intentFilter.addAction("com.samsung.sec.android.MusicPlayer.playstatechanged");
        intentFilter.addAction("com.sec.android.app.music.playstatechanged");
        intentFilter.addAction("com.sonyericsson.music.playstatechanged");
        intentFilter.addAction("fm.last.android.playstatechanged");
        intentFilter.addAction("com.nullsoft.winamp.playstatechanged");
        intentFilter.addAction("com.spotify.music.playbackstatechanged");
        intentFilter.addAction("com.doubleTwist.androidPlayer.playstatechanged");
        intentFilter.addAction("com.jrstudio.AnotherMusicPlayer.playstatechanged");
        intentFilter.addAction("com.rhapsody.playstatechanged");
        intentFilter.addAction("com.e8tracks.playstatechanged");
        intentFilter.addAction("com.soundcloud.android.playstatechanged");
        context.registerReceiver(this, intentFilter);
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            f.d("MusicPlaystateReceiver", "Intent did not contain any extras");
            return;
        }
        boolean z = extras.getBoolean("playing", false);
        d dVar = new d();
        dVar.a = z ? c.PLAYING : c.PAUSED;
        dVar.f = a.BROADCAST_RECEIVER;
        b.a(dVar, null);
    }
}
