package com.getpebble.android.framework.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BadParcelableException;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.notifications.b.c.a;
import com.getpebble.android.notifications.b.c.b;

public class d extends BroadcastReceiver {
    public d(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.amazon.mp3.metachanged");
        intentFilter.addAction("com.andrew.apollo.metachanged");
        intentFilter.addAction("com.android.music.metachanged");
        intentFilter.addAction("com.htc.music.metachanged");
        intentFilter.addAction("com.miui.player.metachanged");
        intentFilter.addAction("com.rdio.android.metachanged");
        intentFilter.addAction("com.real.IMP.metachanged");
        intentFilter.addAction("com.samsung.sec.android.MusicPlayer.metachanged");
        intentFilter.addAction("com.sec.android.app.music.metachanged");
        intentFilter.addAction("com.sonyericsson.music.metachanged");
        intentFilter.addAction("fm.last.android.metachanged");
        intentFilter.addAction("com.nullsoft.winamp.metachanged");
        intentFilter.addAction("com.getpebble.action.NOW_PLAYING");
        intentFilter.addAction("com.spotify.music.metadatachanged");
        intentFilter.addAction("com.doubleTwist.androidPlayer.metachanged");
        intentFilter.addAction("com.jrstudio.AnotherMusicPlayer.metachanged");
        intentFilter.addAction("com.rhapsody.metachanged");
        intentFilter.addAction("com.e8tracks.metachanged");
        intentFilter.addAction("com.soundcloud.android.metachanged");
        context.registerReceiver(this, intentFilter);
    }

    public void onReceive(Context context, Intent intent) {
        String str = null;
        try {
            String stringExtra;
            String stringExtra2;
            if (intent.hasExtra("artist")) {
                stringExtra = intent.getStringExtra("artist");
            } else if (intent.hasExtra("ARTIST_NAME")) {
                stringExtra = intent.getStringExtra("ARTIST_NAME");
            } else if (intent.hasExtra("com.amazon.mp3.artist")) {
                stringExtra = intent.getStringExtra("com.amazon.mp3.artist");
            } else {
                stringExtra = null;
            }
            if (intent.hasExtra("track")) {
                stringExtra2 = intent.getStringExtra("track");
            } else if (intent.hasExtra("TRACK_NAME")) {
                stringExtra2 = intent.getStringExtra("TRACK_NAME");
            } else if (intent.hasExtra("com.amazon.mp3.track")) {
                stringExtra2 = intent.getStringExtra("com.amazon.mp3.track");
            } else {
                stringExtra2 = null;
            }
            if (intent.hasExtra("album")) {
                str = intent.getStringExtra("album");
            } else if (intent.hasExtra("ALBUM_NAME")) {
                str = intent.getStringExtra("ALBUM_NAME");
            } else if (intent.hasExtra("com.amazon.mp3.album")) {
                str = intent.getStringExtra("com.amazon.mp3.album");
            }
            if (stringExtra == null) {
                stringExtra = "";
            }
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            if (str == null) {
                str = "";
            }
            b bVar = new b();
            bVar.a = stringExtra;
            bVar.b = str;
            bVar.c = stringExtra2;
            bVar.h = a.BROADCAST_RECEIVER;
            com.getpebble.android.f.a.a(bVar);
        } catch (BadParcelableException e) {
            f.b("MusicMetadataReceiver", "Error receiving music broadcast");
        }
    }
}
