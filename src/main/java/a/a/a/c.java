package a.a.a;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel;
import com.google.b.l;
import com.google.b.o;
import java.text.SimpleDateFormat;
import java.util.Date;

public class c {
    private static String a = "reference_time";
    private static String b = "location";
    private Context c;

    public c(o oVar, Context context) {
        this.c = context;
        a(oVar);
        b(oVar);
    }

    protected void a(o oVar) {
        oVar.a(a, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'").format(new Date()));
    }

    protected void b(o oVar) {
        if (this.c != null) {
            Location a = a();
            if (a != null) {
                l oVar2 = new o();
                oVar2.a(WeatherLocationsModel.LATITUDE, Double.valueOf(a.getLatitude()));
                oVar2.a(WeatherLocationsModel.LONGITUDE, Double.valueOf(a.getLongitude()));
                oVar.a(b, oVar2);
            }
        }
    }

    protected Location a() {
        LocationManager locationManager = (LocationManager) this.c.getSystemService("location");
        Criteria criteria = new Criteria();
        criteria.setAccuracy(2);
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (bestProvider == null) {
            return null;
        }
        return locationManager.getLastKnownLocation(bestProvider);
    }
}
