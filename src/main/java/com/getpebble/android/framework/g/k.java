package com.getpebble.android.framework.g;

import android.os.Bundle;
import android.os.Parcelable;

public class k {
    private com.getpebble.android.bluetooth.g.a a;
    private a b;
    private Bundle c;

    public enum a {
        SEND_PHONE_INCOMING_CALL_NOTIFICATION,
        SEND_PHONE_RING_NOTIFICATION,
        SEND_PHONE_START_NOTIFICATION,
        SEND_PHONE_END_NOTIFICATION,
        UPDATE_MUSIC_NOW_PLAYING,
        UPDATE_MUSIC_PLAYSTATE,
        UPDATE_MUSIC_VOLUME_LEVEL,
        UPDATE_MUSIC_PLAYER_INFO,
        SEND_SET_TIME_MESSAGE,
        REQUEST_GET_BYTES,
        SEND_DATALOGGING_ACK,
        SEND_DATALOGGING_NACK,
        SEND_DATALOGGING_REPORT_OPEN_SESSIONS,
        REQUEST_LOG_DUMP,
        PUSH_APP_MESSAGE,
        REQUEST_RUNNING_APP,
        START_APP,
        STOP_APP,
        CUSTOMIZE_APP,
        ADD_FILE,
        SEND_EXTENSIBLE_NOTIFICATION,
        REMOVE_EXTENSIBLE_NOTIFICATION,
        CLEAR_BLOB_DB,
        START_APP_AFTER_COMMIT_TO_DB,
        VOICE_RESPONSE,
        SEND_APP_ORDER,
        FORCE_CORE_DUMP,
        RESET_INTO_PRF,
        SYNC_HEALTH
    }

    public enum b {
        UUID,
        URI,
        PHONE_NAME,
        PHONE_NUMBER,
        PHONE_COOKIE,
        DATALOGGING_SESSION,
        DATALOGGING_SESSIONS,
        APP_MESSAGE,
        APP_TITLE,
        BITMAP,
        APP_TYPE,
        FILE_NAME,
        ISO_LOCALE,
        LANGUAGE_VERSION
    }

    public k(com.getpebble.android.bluetooth.g.a aVar, a aVar2, Bundle bundle) {
        if (aVar == null) {
            throw new IllegalArgumentException("'endpointId' cannot be null!");
        } else if (aVar2 == null) {
            throw new IllegalArgumentException("'action' cannot be null!");
        } else {
            this.a = aVar;
            this.b = aVar2;
            if (bundle == null) {
                this.c = new Bundle();
            } else {
                this.c = bundle;
            }
        }
    }

    public k(com.getpebble.android.bluetooth.g.a aVar, a aVar2) {
        this(aVar, aVar2, null);
    }

    public com.getpebble.android.bluetooth.g.a a() {
        return this.a;
    }

    public a b() {
        return this.b;
    }

    private Bundle c() {
        return this.c;
    }

    public Integer a(b bVar) {
        return Integer.valueOf(this.c.getInt(bVar.toString()));
    }

    public String b(b bVar) {
        return this.c.getString(bVar.toString());
    }

    public Parcelable c(b bVar) {
        return this.c.getParcelable(bVar.toString());
    }

    public byte[] d(b bVar) {
        return this.c.getByteArray(bVar.toString());
    }

    public int[] e(b bVar) {
        return this.c.getIntArray(bVar.toString());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (!(com.getpebble.android.common.b.b.a.a(b(), kVar.b()) && com.getpebble.android.common.b.b.a.a(a(), kVar.a()) && com.getpebble.android.common.b.b.a.a(c(), kVar.c()))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 5;
        if (b() != null) {
            i = b().hashCode() + 355;
        }
        if (a() != null) {
            i = (i * 71) + a().hashCode();
        }
        if (c() != null) {
            return (i * 71) + c().hashCode();
        }
        return i;
    }
}
