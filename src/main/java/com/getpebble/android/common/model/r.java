package com.getpebble.android.common.model;

import com.getpebble.android.common.framework.install.app.b.a;
import com.google.a.f.e;

public enum r implements z {
    UNKNOWN(0, "unknown", a.BASALT),
    PEBBLE_ONE_EV1(1, "ev1", a.APLITE),
    PEBBLE_ONE_EV2(2, "ev2", a.APLITE),
    PEBBLE_ONE_EV2_3(3, "ev2_3", a.APLITE),
    PEBBLE_ONE_EV2_4(4, "ev2_4", a.APLITE),
    PEBBLE_ONE_POINT_FIVE(5, "v1_5", a.APLITE),
    PEBBLE_TWO_POINT_ZERO(6, "v2_0", a.APLITE),
    PEBBLE_SNOWY_EVT2(7, "snowy_evt2", a.BASALT),
    PEBBLE_SNOWY_DVT(8, "snowy_dvt", a.BASALT),
    PEBBLE_BOBBY_SMILES(10, "snowy_s3", a.BASALT),
    PEBBLE_ONE_BIGBOARD_2(254, "bb2", true, a.APLITE),
    PEBBLE_ONE_BIGBOARD(255, "bigboard", true, a.APLITE),
    PEBBLE_SNOWY_BIGBOARD(253, "snowy_bb", true, a.BASALT),
    PEBBLE_SNOWY_BIGBOARD_2(252, "snowy_bb2", true, a.BASALT),
    PEBBLE_SPALDING_EVT(9, "spalding_evt", a.CHALK),
    PEBBLE_SPALDING_PVT(11, "spalding", a.CHALK),
    PEBBLE_SPALDING_BIGBOARD(251, "spalding_bb2", true, a.CHALK),
    PEBBLE_SILK_EVT(12, "silk_evt", a.DIORITE),
    PEBBLE_SILK(14, "silk", a.DIORITE),
    PEBBLE_SILK_BIGBOARD(250, "silk_bb", true, a.DIORITE),
    PEBBLE_SILK_BIGBOARD_2_PLUS(248, "silk_bb2", true, a.DIORITE),
    PEBBLE_ROBERT_EVT(13, "robert_evt", true, a.EMERY),
    PEBBLE_ROBERT_BIGBOARD(249, "robert_bb", true, a.EMERY),
    PEBBLE_ROBERT_BIGBOARD_2(247, "robert_bb2", true, a.EMERY);
    
    private final int mId;
    private final boolean mIsDevBoard;
    private final String mName;
    private final a mPlatform;

    private r(int i, String str, a aVar) {
        this(r8, r9, i, str, false, aVar);
    }

    private r(int i, String str, boolean z, a aVar) {
        this.mId = i;
        this.mName = str;
        this.mIsDevBoard = z;
        this.mPlatform = aVar;
    }

    public String getName() {
        return this.mName;
    }

    public int getId() {
        return this.mId;
    }

    static z fromInt(e eVar) {
        for (z zVar : values()) {
            if (zVar.getId() == eVar.intValue()) {
                return zVar;
            }
        }
        return UNKNOWN;
    }

    static z fromString(String str) {
        for (z zVar : values()) {
            if (zVar.getName().equalsIgnoreCase(str)) {
                return zVar;
            }
        }
        return UNKNOWN;
    }

    public a getPlatformCode() {
        return this.mPlatform;
    }

    public boolean isDevBoard() {
        return this.mIsDevBoard;
    }
}
