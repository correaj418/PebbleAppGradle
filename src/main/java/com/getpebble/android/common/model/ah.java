package com.getpebble.android.common.model;

import android.content.Context;
import android.util.SparseArray;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.am.d;
import java.util.EnumSet;

public enum ah {
    COLOR_UNKNOWN(0, R.string.unknown, m.SIMPLICITY),
    COLOR_BLACK(1, R.string.black, m.SIMPLICITY),
    COLOR_WHITE(2, R.string.white, m.SIMPLICITY),
    COLOR_RED(3, R.string.red, m.SIMPLICITY),
    COLOR_ORANGE(4, R.string.orange, m.SIMPLICITY),
    COLOR_GRAY(5, R.string.gray, m.SIMPLICITY),
    COLOR_BIANCA_SILVER(6, R.string.silver, m.SIMPLICITY),
    COLOR_BIANCA_BLACK(7, R.string.black, m.SIMPLICITY),
    COLOR_TINTIN_BLUE(8, R.string.blue, m.SIMPLICITY),
    COLOR_TINTIN_GREEN(9, R.string.green, m.SIMPLICITY),
    COLOR_TINTIN_PINK(10, R.string.pink, m.SIMPLICITY),
    COLOR_SNOWY_WHITE(11, R.string.white, m.TICTOC_COLOR, m.KICKSTART_SQUARE_COLOR),
    COLOR_SNOWY_BLACK(12, R.string.black, m.TICTOC_COLOR, m.KICKSTART_SQUARE_COLOR),
    COLOR_SNOWY_RED(13, R.string.red, m.TICTOC_COLOR, m.KICKSTART_SQUARE_COLOR),
    COLOR_BOBBY_SILVER(14, R.string.silver, m.TICTOC_COLOR, m.KICKSTART_SQUARE_COLOR),
    COLOR_BOBBY_BLACK(15, R.string.black, m.TICTOC_COLOR, m.KICKSTART_SQUARE_COLOR),
    COLOR_BOBBY_GOLD(16, R.string.gold, m.TICTOC_COLOR, m.KICKSTART_SQUARE_COLOR),
    COLOR_SPALDING_SILVER_14((String) 17, (int) R.string.silver, (int) R.string.size_14mm, (int) m.TICTOC_ROUND_WHITE_BG, (int) m.KICKSTART_ROUND_COLOR),
    COLOR_SPALDING_BLACK_14((String) 18, (int) R.string.black, (int) R.string.size_14mm, (int) m.TICTOC_ROUND_BLACK_14, (int) m.KICKSTART_ROUND_COLOR),
    COLOR_SPALDING_SILVER_20((String) 19, (int) R.string.silver, (int) R.string.size_20mm, (int) m.TICTOC_ROUND_SILVER_20, (int) m.KICKSTART_ROUND_COLOR),
    COLOR_SPALDING_BLACK_20((String) 20, (int) R.string.black, (int) R.string.size_20mm, (int) m.TICTOC_ROUND_BLACK_20, (int) m.KICKSTART_ROUND_COLOR),
    COLOR_SPALDING_ROSE_GOLD_14((String) 21, (int) R.string.rose_gold, (int) R.string.size_14mm, (int) m.TICTOC_ROUND_ROSE_GOLD_14, (int) m.KICKSTART_ROUND_COLOR),
    COLOR_SPALDING_SILVER_RAINBOW_14((String) 22, (int) R.string.silver_rainbow, (int) R.string.size_14mm, (int) m.TICTOC_ROUND_WHITE_BG, (int) m.KICKSTART_ROUND_COLOR),
    COLOR_SPALDING_BLACK_RAINBOW_20((String) 23, (int) R.string.black_rainbow, (int) R.string.size_20mm, (int) m.TICTOC_ROUND_BLACK_20, (int) m.KICKSTART_ROUND_COLOR),
    COLOR_SPALDING_POLISHED_SILVER_20((String) 34, (int) R.string.polished_silver, (int) R.string.size_20mm, (int) m.TICTOC_ROUND_WHITE_BG, (int) m.KICKSTART_ROUND_COLOR),
    COLOR_SPALDING_POLISHED_GOLD_20((String) 35, (int) R.string.polished_gold, (int) R.string.size_20mm, (int) m.TICTOC_ROUND_WHITE_BG, (int) m.KICKSTART_ROUND_COLOR),
    COLOR_SILK_SE_BLACK(24, R.string.black_charcoal, m.KICKSTART_SQUARE_BW, m.SIMPLICITY),
    COLOR_SILK_HR_BLACK((String) 25, (int) R.string.black_charcoal, (int) m.KICKSTART_SQUARE_HR_BW, (int) m.SIMPLICITY, (m) EnumSet.of(y.HEART_RATE_MONITORING)),
    COLOR_SILK_SE_WHITE(26, R.string.white_gray, m.KICKSTART_SQUARE_BW, m.SIMPLICITY),
    COLOR_SILK_HR_GREEN((String) 27, (int) R.string.charcoal_sorbet_green, (int) m.KICKSTART_SQUARE_HR_BW, (int) m.SIMPLICITY, (m) EnumSet.of(y.HEART_RATE_MONITORING)),
    COLOR_SILK_HR_RED((String) 28, (int) R.string.charcoal_red, (int) m.KICKSTART_SQUARE_HR_BW, (int) m.SIMPLICITY, (m) EnumSet.of(y.HEART_RATE_MONITORING)),
    COLOR_SILK_HR_WHITE((String) 29, (int) R.string.white_gray, (int) m.KICKSTART_SQUARE_HR_BW, (int) m.SIMPLICITY, (m) EnumSet.of(y.HEART_RATE_MONITORING)),
    COLOR_SILK_HR_TURQOISE((String) 30, (int) R.string.white_turqoise, (int) m.KICKSTART_SQUARE_HR_BW, (int) m.SIMPLICITY, (m) EnumSet.of(y.HEART_RATE_MONITORING)),
    COLOR_ROBERT_BLACK((String) 31, (int) R.string.black, (int) m.KICKSTART_LRG_SQUARE_HR_COLOR, (int) m.TICTOC_COLOR_LARGE, (m) EnumSet.of(y.HEART_RATE_MONITORING)),
    COLOR_ROBERT_SILVER((String) 32, (int) R.string.silver, (int) m.KICKSTART_LRG_SQUARE_HR_COLOR, (int) m.TICTOC_COLOR_LARGE, (m) EnumSet.of(y.HEART_RATE_MONITORING)),
    COLOR_ROBERT_GOLD((String) 33, (int) R.string.gold, (int) m.KICKSTART_LRG_SQUARE_HR_COLOR, (int) m.TICTOC_COLOR_LARGE, (m) EnumSet.of(y.HEART_RATE_MONITORING));
    
    private static final String TAG = "PebbleColor";
    private static final SparseArray<ah> intToTypeMap = null;
    private final EnumSet<y> hardwareCapabilities;
    private final int mColorStringRes;
    private final int mSize;
    private final int mValue;
    public final m primaryWatchface;
    public final m secondaryWatchface;

    static {
        intToTypeMap = new SparseArray();
        for (ah ahVar : values()) {
            intToTypeMap.put(ahVar.mValue, ahVar);
        }
    }

    private ah(int i, int i2, m mVar) {
        this(r8, r9, i, i2, mVar, null);
    }

    public static ah fromInt(int i) {
        ah ahVar = (ah) intToTypeMap.get(Integer.valueOf(i).intValue());
        if (ahVar == null) {
            return COLOR_UNKNOWN;
        }
        return ahVar;
    }

    public int getIntValue() {
        return this.mValue;
    }

    public String getJsFriendlyName() {
        int i;
        Context K = a.K();
        String str = "";
        switch (this) {
            case COLOR_ROBERT_BLACK:
            case COLOR_ROBERT_SILVER:
            case COLOR_ROBERT_GOLD:
                i = R.string.pebble_time_2;
                break;
            case COLOR_SILK_SE_BLACK:
            case COLOR_SILK_SE_WHITE:
                i = R.string.pebble_2;
                break;
            case COLOR_SILK_HR_BLACK:
            case COLOR_SILK_HR_WHITE:
            case COLOR_SILK_HR_GREEN:
            case COLOR_SILK_HR_RED:
            case COLOR_SILK_HR_TURQOISE:
                i = R.string.pebble_2_hr;
                break;
            case COLOR_BIANCA_SILVER:
            case COLOR_BIANCA_BLACK:
                i = R.string.pebble_steel;
                break;
            case COLOR_SNOWY_WHITE:
            case COLOR_SNOWY_BLACK:
            case COLOR_SNOWY_RED:
                i = R.string.pebble_time_lower;
                break;
            case COLOR_BOBBY_SILVER:
            case COLOR_BOBBY_BLACK:
            case COLOR_BOBBY_GOLD:
                i = R.string.pebble_time_steel;
                break;
            case COLOR_SPALDING_SILVER_14:
            case COLOR_SPALDING_BLACK_14:
            case COLOR_SPALDING_SILVER_20:
            case COLOR_SPALDING_BLACK_20:
            case COLOR_SPALDING_ROSE_GOLD_14:
            case COLOR_SPALDING_SILVER_RAINBOW_14:
            case COLOR_SPALDING_BLACK_RAINBOW_20:
                i = R.string.pebble_time_round;
                break;
            default:
                i = R.string.pebble;
                break;
        }
        String str2 = K.getString(i) + "_" + K.getString(this.mColorStringRes);
        if (i == R.string.pebble_time_round) {
            return str2 + "_" + K.getString(this.mSize);
        }
        return str2;
    }

    private ah(int i, int i2, m mVar, m mVar2) {
        this(r9, r10, i, i2, mVar, mVar2, EnumSet.noneOf(y.class));
    }

    private ah(int i, int i2, m mVar, m mVar2, EnumSet<y> enumSet) {
        this(r10, r11, i, i2, 0, mVar, mVar2, enumSet);
    }

    private ah(int i, int i2, int i3, m mVar, m mVar2) {
        this(r10, r11, i, i2, i3, mVar, mVar2, EnumSet.noneOf(y.class));
    }

    private ah(int i, int i2, int i3, m mVar, m mVar2, EnumSet<y> enumSet) {
        this.mValue = i;
        this.mColorStringRes = i2;
        this.mSize = i3;
        this.primaryWatchface = mVar;
        this.secondaryWatchface = mVar2;
        this.hardwareCapabilities = enumSet;
    }

    public boolean hardwareSupports(y yVar) {
        return this.hardwareCapabilities.contains(yVar);
    }

    public int getIconForWatchface(d dVar) {
        if (dVar == this.primaryWatchface.watchface) {
            return this.primaryWatchface.iconResId;
        }
        if (this.secondaryWatchface != null && dVar == this.secondaryWatchface.watchface) {
            return this.secondaryWatchface.iconResId;
        }
        if (this != COLOR_UNKNOWN) {
            f.f(TAG, "getIconForWatchface: no icon found. watchface=" + dVar.name() + "; color=" + name());
        }
        return R.drawable.alert_circle_grey;
    }
}
