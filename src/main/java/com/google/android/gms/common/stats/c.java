package com.google.android.gms.common.stats;

import com.google.android.gms.b.ao;

public final class c {
    public static ao<Integer> a = ao.a("gms:common:stats:max_num_of_events", Integer.valueOf(100));
    public static ao<Integer> b = ao.a("gms:common:stats:max_chunk_size", Integer.valueOf(100));

    public static final class a {
        public static ao<Integer> a = ao.a("gms:common:stats:connections:level", Integer.valueOf(d.b));
        public static ao<String> b = ao.a("gms:common:stats:connections:ignored_calling_processes", "");
        public static ao<String> c = ao.a("gms:common:stats:connections:ignored_calling_services", "");
        public static ao<String> d = ao.a("gms:common:stats:connections:ignored_target_processes", "");
        public static ao<String> e = ao.a("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static ao<Long> f = ao.a("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
    }
}
