package com.getpebble.android.common.model;

import com.getpebble.android.basalt.R;
import com.getpebble.android.common.model.am.d;

public enum m {
    SIMPLICITY(d.TICTOC, R.drawable.tictoc_screenshot_tintin),
    TICTOC_COLOR(d.TICTOC, R.drawable.tictoc_screenshot),
    TICTOC_COLOR_LARGE(d.TICTOC, R.drawable.red_warning_icon),
    TICTOC_ROUND_WHITE_BG(d.TICTOC, R.drawable.tictoc_screenshot_silver_14),
    TICTOC_ROUND_BLACK_14(d.TICTOC, R.drawable.tictoc_screenshot_black_14),
    TICTOC_ROUND_SILVER_20(d.TICTOC, R.drawable.tictoc_screenshot_silver_20),
    TICTOC_ROUND_BLACK_20(d.TICTOC, R.drawable.tictoc_screenshot_black_20),
    TICTOC_ROUND_ROSE_GOLD_14(d.TICTOC, R.drawable.tictoc_screenshot_rose_gold_14),
    KICKSTART_SQUARE_COLOR(d.KICKSTART, R.drawable.kickstart_clr),
    KICKSTART_ROUND_COLOR(d.KICKSTART, R.drawable.kickstart_clr_round),
    KICKSTART_SQUARE_BW(d.KICKSTART, R.drawable.kickstart_bw_nohr),
    KICKSTART_SQUARE_HR_BW(d.KICKSTART, R.drawable.kickstart_bw_hr),
    KICKSTART_LRG_SQUARE_HR_COLOR(d.KICKSTART, R.drawable.kickstart_clr_large);
    
    public final int iconResId;
    public final d watchface;

    private m(d dVar, int i) {
        this.watchface = dVar;
        this.iconResId = i;
    }
}
