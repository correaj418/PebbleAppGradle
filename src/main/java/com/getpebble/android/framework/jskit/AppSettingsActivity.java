package com.getpebble.android.framework.jskit;

import com.getpebble.android.common.model.am;
import com.getpebble.android.framework.PebbleFrameworkService;
import com.getpebble.jskit.android.impl.a;
import java.util.UUID;

public class AppSettingsActivity extends a {
    public void a(String str, String str2) {
        PebbleFrameworkService.a().c(str, str2);
    }

    public void a(String str, com.getpebble.jskit.android.impl.c.a aVar) {
        d a = PebbleFrameworkService.a();
        a.a(aVar);
        a.b(str);
    }

    public void b(String str, com.getpebble.jskit.android.impl.c.a aVar) {
        d a = PebbleFrameworkService.a();
        a.c(str);
        a.b(aVar);
    }

    public void a(String str) {
        am.a(getContentResolver(), UUID.fromString(str), true);
    }
}
