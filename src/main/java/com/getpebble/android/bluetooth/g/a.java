package com.getpebble.android.bluetooth.g;

import java.util.HashMap;
import java.util.Map;

public enum a {
    TIME(11),
    VERSIONS(16),
    PHONE_VERSION(17),
    SYSTEM_MESSAGE(18),
    MUSIC_CONTROL(32),
    PHONE_CONTROL(33),
    APP_MESSAGE(48),
    APP_CUSTOMIZE(50),
    APP_RUN_STATE(52),
    LOGS(2000),
    PING(2001),
    LOG_DUMP(2002),
    RESET(2003),
    APP_LOGS(2006),
    SYS_REG(5000),
    FCT_REG(5001),
    APP_FETCH(6001),
    PUT_BYTES(48879),
    DATA_LOG(6778),
    SCREENSHOT(8000),
    FILE_INSTALL_MANAGER(8181),
    GET_BYTES(9000),
    AUDIO_STREAMING(10000),
    APP_REORDER(43981),
    BLOBDB_V1(45531),
    BLOBDB_V2(45787),
    TIMELINE_ACTIONS(11440),
    VOICE_CONTROL(11000),
    HEALTH_SYNC(911),
    MAX_ENDPOINT(65535),
    INVALID_ENDPOINT(-1);
    
    private static final Map<Integer, a> intToTypeMap = null;
    private final int code;

    static {
        intToTypeMap = new HashMap();
        a[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            a aVar = values[i];
            intToTypeMap.put(Integer.valueOf(aVar.code), aVar);
            i++;
        }
    }

    private a(int i) {
        this.code = i;
    }

    public static a fromCode(short s) {
        a aVar = (a) intToTypeMap.get(Integer.valueOf(65535 & s));
        if (aVar == null) {
            return INVALID_ENDPOINT;
        }
        return aVar;
    }

    public static a fromCode(int i) {
        a aVar = (a) intToTypeMap.get(Integer.valueOf(i));
        if (aVar == null) {
            return INVALID_ENDPOINT;
        }
        return aVar;
    }

    public short getCode() {
        return (short) (this.code & 65535);
    }
}
