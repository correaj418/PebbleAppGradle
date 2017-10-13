package com.getpebble.android.framework.location;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel;
import com.getpebble.android.h.v;
import com.google.a.b.ad;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.g;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.e;
import com.google.android.gms.location.i;
import com.google.android.gms.location.k;
import java.util.concurrent.TimeUnit;

public class PebbleLocationService extends IntentService {
    private static Location a;
    private static PendingIntent b;
    private static c c;
    private static final long d = TimeUnit.MINUTES.toMillis(30);
    private static final long e = TimeUnit.MINUTES.toMillis(1);
    private static final long f = TimeUnit.SECONDS.toMillis(20);
    private static final b g = new b() {
        public void a(Bundle bundle) {
            f.d("PebbleLocationService", "onConnected()");
            PebbleLocationService.e();
        }

        public void a(int i) {
            f.d("PebbleLocationService", "onConnectionSuspended()");
        }
    };
    private static final c.c h = new c.c() {
        public void a(ConnectionResult connectionResult) {
            f.a("PebbleLocationService", "onConnectionFailed()");
        }
    };
    private static final i i = new i() {
        public void a(Location location) {
            f.d("PebbleLocationService", "onLocationChanged()");
            PebbleLocationService.g();
            PebbleLocationService.b(location);
        }
    };

    public enum a {
        LOCATION_ENABLED,
        SENSORS_ONLY
    }

    public PebbleLocationService() {
        super("Location");
    }

    public static synchronized void a() {
        synchronized (PebbleLocationService.class) {
            if (!PebbleApplication.w().B()) {
                f.d("PebbleLocationService", "init: not initing because weather is disabled");
            } else if (c == null) {
                b = PendingIntent.getService(com.getpebble.android.common.a.K(), 0, new Intent(com.getpebble.android.common.a.K(), PebbleLocationService.class), 134217728);
                c = new com.google.android.gms.common.api.c.a(com.getpebble.android.common.a.K()).a(g).a(h).a(k.a).b();
                c.b();
            }
        }
    }

    public static void b() {
        f.d("PebbleLocationService", "triggerGetLocation()");
        Intent intent = new Intent(com.getpebble.android.common.a.K(), PebbleLocationService.class);
        intent.setAction("com.getpebble.android.trigger_location_update");
        com.getpebble.android.common.a.K().startService(intent);
    }

    private static void e() {
        if (v.a(com.getpebble.android.h.v.a.LOCATION)) {
            f.d("PebbleLocationService", "getCachedLocation()");
            a = k.b.a(c);
            if (a != null) {
                b(a);
                return;
            }
            f.d("PebbleLocationService", "getCachedLocation: getLastLocation is null");
            if (c.e()) {
                f.d("PebbleLocationService", "getCachedLocation: Google API client is connected. Requesting location updates.");
                f();
                return;
            }
            f.d("PebbleLocationService", "getCachedLocation: Google API client is not connected. Attempting to connect...");
            c.b();
            return;
        }
        v.a("PebbleLocationService", com.getpebble.android.h.v.a.LOCATION, "getCachedLocation");
    }

    private static void f() {
        if (v.a(com.getpebble.android.h.v.a.LOCATION)) {
            f.d("PebbleLocationService", "Starting Location Updates");
            LocationRequest locationRequest = new LocationRequest();
            locationRequest.a(e);
            locationRequest.b(f);
            locationRequest.c(d);
            locationRequest.a(102);
            if (c != null && c.e()) {
                try {
                    k.b.a(c, locationRequest, i, Looper.getMainLooper());
                    return;
                } catch (Throwable e) {
                    f.b("PebbleLocationService", "startLocationUpdates: Permission error", e);
                    return;
                }
            }
            return;
        }
        v.a("PebbleLocationService", com.getpebble.android.h.v.a.LOCATION, "startLocationUpdates");
    }

    private static void g() {
        f.d("PebbleLocationService", "stopLocationUpdates()");
        if (c.e()) {
            k.b.a(c, i);
        }
    }

    private static void b(Location location) {
        f.d("PebbleLocationService", "handleLocationChanged: " + i());
        if (location == null) {
            f.b("PebbleLocationService", "onLocationChanged: location is null");
            return;
        }
        a = location;
        WeatherLocationsModel.updateDynamicLocation(com.getpebble.android.common.a.K().getContentResolver(), location);
        h();
    }

    private static void h() {
        f.d("PebbleLocationService", "setupGeofence()");
        k.c.a(c, b);
        if (a == null) {
            f.b("PebbleLocationService", "setupGeofence: sCurrentLocation is null");
            return;
        }
        k.c.a(c, ad.a(new com.google.android.gms.location.d.a().a(a.getLatitude(), a.getLongitude(), 5000.0f).a(-1).a(2).a("GEOFENCE_ID").a()), b).a(new g<Status>() {
            public void a(Status status) {
                if (status.f()) {
                    f.d("PebbleLocationService", "Successfully registered Geofence.");
                } else if (!status.e()) {
                    f.b("PebbleLocationService", "Unable to register Geofence.");
                }
            }
        });
    }

    protected void onHandleIntent(Intent intent) {
        if ("com.getpebble.android.trigger_location_update".equals(intent.getAction())) {
            f.d("PebbleLocationService", "ACTION_TRIGGER_LOCATION_UPDATE");
            a();
            if (c != null) {
                if (c.e()) {
                    e();
                    return;
                } else {
                    c.b();
                    return;
                }
            }
            return;
        }
        com.google.android.gms.location.g a = com.google.android.gms.location.g.a(intent);
        if (a.a()) {
            f.b("PebbleLocationService", "onHandleIntent: geofence error: " + e.b(a.b()));
        } else if (a.c() != 2) {
            f.c("PebbleLocationService", "onHandleIntent: unexpected transition = " + a.c());
        } else {
            f.d("PebbleLocationService", "onHandleIntent: exited geofence");
            a();
            if (c == null) {
                return;
            }
            if (c.e()) {
                e();
                return;
            }
            f.d("PebbleLocationService", "onHandleIntent: sGoogleClient is not connected; connecting");
            c.b();
        }
    }

    public static boolean a(a aVar) {
        boolean z = true;
        if (VERSION.SDK_INT >= 19) {
            int i;
            try {
                i = Secure.getInt(com.getpebble.android.common.a.K().getContentResolver(), "location_mode");
            } catch (Throwable e) {
                f.a("PebbleLocationService", "Error determining location mode.", e);
                i = 0;
            }
            switch (aVar) {
                case LOCATION_ENABLED:
                    if (i == 0 || i == 1) {
                        return false;
                    }
                    return true;
                case SENSORS_ONLY:
                    if (i != 1) {
                        z = false;
                    }
                    return z;
                default:
                    return false;
            }
        }
        switch (aVar) {
            case LOCATION_ENABLED:
                if (TextUtils.isEmpty(Secure.getString(com.getpebble.android.common.a.K().getContentResolver(), "location_providers_allowed"))) {
                    z = false;
                }
                return z;
            default:
                return false;
        }
    }

    private static String i() {
        return "";
    }
}
