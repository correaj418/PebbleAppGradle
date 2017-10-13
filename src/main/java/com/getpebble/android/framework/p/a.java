package com.getpebble.android.framework.p;

import com.getpebble.android.common.b.a.f;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public abstract class a {
    public HttpsURLConnection a(URL url) {
        f.c("BaseHttpsConnectionFactory", "Opening connection to: " + url.toString());
        return (HttpsURLConnection) url.openConnection();
    }
}
