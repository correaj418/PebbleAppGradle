package com.getpebble.android.config.a;

import com.getpebble.android.common.model.ai;

public class a extends ai {
    private String a = null;
    private String b = null;

    public a() {
        super("boot_config");
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "config_url"));
        addColumn(new com.getpebble.android.common.model.ai.a(com.getpebble.android.common.model.ai.a.a.STRING, "config_json"));
    }
}
