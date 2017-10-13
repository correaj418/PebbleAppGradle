package com.google.android.gms.common;

import android.content.Intent;

public class g extends Exception {
    private final Intent a;

    public g(String str, Intent intent) {
        super(str);
        this.a = intent;
    }
}
