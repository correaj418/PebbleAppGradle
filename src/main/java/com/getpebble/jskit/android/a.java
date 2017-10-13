package com.getpebble.jskit.android;

import java.util.Map;
import java.util.UUID;

public class a {
    Map<a, Integer> a;
    Map<a, Integer> b;
    private UUID c;
    private b d;

    public enum a {
        RUNNING_TIME,
        HTTP_REQUEST,
        OPEN_URL,
        LOCAL_STORAGE,
        GEOLOCATION_REQUEST,
        WEB_SOCKET,
        PERFORMANCE,
        PEBBLE_ACCOUNT_TOKEN,
        PEBBLE_WATCH_TOKEN,
        PEBBLE_APP_MESSAGE,
        PEBBLE_EVENT_LISTENER,
        PEBBLE_TIMELINE,
        PEBBLE_WATCH_INFO,
        PEBBLE_CONFIGURATION
    }

    public interface b {
        void a(a aVar, a aVar2);
    }

    public UUID a() {
        return this.c;
    }

    public int a(a aVar) {
        return this.a.containsKey(aVar) ? ((Integer) this.a.get(aVar)).intValue() : -1;
    }

    private void a(Map<a, Integer> map, a aVar, int i) {
        if (this.a.containsKey(aVar)) {
            map.put(aVar, Integer.valueOf(i));
        }
    }

    public void b(a aVar) {
        com.getpebble.jskit.android.a.a.a(2, null, "JsWatchdog", "Received event " + aVar);
        if (this.a.containsKey(aVar)) {
            int intValue;
            if (this.b.containsKey(aVar)) {
                intValue = ((Integer) this.b.get(aVar)).intValue();
            } else {
                intValue = 0;
            }
            intValue++;
            a(this.b, aVar, intValue);
            if (intValue >= a(aVar) && this.d != null) {
                com.getpebble.jskit.android.a.a.a(5, null, "JsWatchdog", "Threshold met for " + aVar + ". Calling listener");
                this.d.a(this, aVar);
                return;
            }
            return;
        }
        com.getpebble.jskit.android.a.a.a(2, null, "JsWatchdog", "No threshold configured for event " + aVar + ", ignoring");
    }
}
