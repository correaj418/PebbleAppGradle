package com.getpebble.android.bluetooth.h;

import android.content.ContentResolver;

public class e {

    public enum a {
        NO_BT_ADAPTER_ON_START,
        PAIRING_FAIL,
        DODGY_PAIRING,
        DODGY_PAIRING_UNPAIRING,
        BT_MESSAGE_RECEIVE,
        BT_MESSAGE_SEND
    }

    public static void a(a aVar, ContentResolver contentResolver) {
        d.a().a(aVar, contentResolver);
    }
}
