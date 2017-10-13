package com.getpebble.android.common.model.timeline;

import com.google.b.a.c;
import com.google.b.o;
import java.util.UUID;

public class a extends f {
    @c(a = "createTime")
    public String a;
    @c(a = "dataSource")
    public UUID b;
    @c(a = "slices")
    public a[] c;

    public static class a {
        @c(a = "layout")
        public o a;
        @c(a = "expirationTime")
        public String b;
    }
}
