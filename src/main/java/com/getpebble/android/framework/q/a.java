package com.getpebble.android.framework.q;

import android.content.Context;
import android.location.Location;
import com.b.b.j;
import com.b.b.x;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherChannelDataModels.AggregateReport;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherChannelDataModels.CurrentConditions;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherChannelDataModels.DailyForecast;
import com.getpebble.android.h.p;
import com.getpebble.android.h.q;
import com.google.b.i;
import com.google.b.o;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class a {
    private static final long a = TimeUnit.HOURS.toMillis(1);

    public enum a {
        TODAY(0),
        TOMORROW(1),
        DAY_AFTER_TOMORROW(2);
        
        final int dayIndex;

        private a(int i) {
            this.dayIndex = i;
        }

        public static a from(int i) {
            for (a aVar : values()) {
                if (aVar.dayIndex == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public a(Context context) {
        f.e("WeatherChannelManager", "WeatherChannelManager constructor");
    }

    public AggregateReport a(Location location) {
        String a = com.getpebble.android.common.model.timeline.weatherchannel.a.a(location, com.getpebble.android.common.model.timeline.weatherchannel.a.a.from(PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.WEATHER_UNITS, q.c().unitsTypeName)), "en_US");
        if (a == null) {
            f.c("WeatherChannelManager", "url is null");
            return null;
        }
        o a2 = a(a);
        if (a2 == null) {
            f.c("WeatherChannelManager", "json is null");
            return null;
        }
        AggregateReport a3 = a(a2);
        if (a3 != null) {
            return a3;
        }
        f.c("WeatherChannelManager", "aggReport is null");
        return null;
    }

    private o a(String str) {
        try {
            x xVar = (x) ((com.b.b.b.c.a.a) ((com.b.b.b.c.a.a) j.a(com.getpebble.android.common.a.K()).d(str)).b(30000)).a().n().get((long) 30000, TimeUnit.MILLISECONDS);
            if (xVar.d().b() == 200) {
                return (o) xVar.b();
            }
            f.c("WeatherChannelManager", "Error getting weather json. Response code = " + xVar.d().b());
            return null;
        } catch (Throwable e) {
            f.b("WeatherChannelManager", "Unable to get Json from The Weather Channel API", e);
        }
    }

    static AggregateReport a(o oVar) {
        DailyForecast[] b = b(oVar);
        CurrentConditions c = c(oVar);
        if (b == null || c == null) {
            return null;
        }
        return new AggregateReport(c, b);
    }

    private static DailyForecast[] b(o oVar) {
        o d = oVar.d("fcstdaily7");
        if (d == null) {
            f.c("WeatherChannelManager", "daily7 is null");
            return null;
        }
        d = d.d("data");
        if (d == null) {
            f.c("WeatherChannelManager", "daily7 data is null");
            return null;
        }
        i c = d.c("forecasts");
        if (c == null) {
            f.c("WeatherChannelManager", "daily7 forecasts is null");
            return null;
        } else if (c.a() == 0) {
            f.c("WeatherChannelManager", "daily7 has no members");
            return null;
        } else {
            int min = Math.min(c.a(), 7);
            List arrayList = new ArrayList();
            for (int i = 0; i < min; i++) {
                DailyForecast dailyForecast = (DailyForecast) p.a(c.a(i).l(), DailyForecast.class);
                if (dailyForecast != null) {
                    arrayList.add(dailyForecast);
                }
            }
            DailyForecast[] dailyForecastArr = new DailyForecast[arrayList.size()];
            arrayList.toArray(dailyForecastArr);
            return dailyForecastArr;
        }
    }

    private static CurrentConditions c(o oVar) {
        o d = oVar.d("conditions");
        if (d == null) {
            f.c("WeatherChannelManager", "conditions is null");
            return null;
        }
        d = d.d("data");
        if (d == null) {
            f.c("WeatherChannelManager", "daily7 data is null");
            return null;
        }
        d = d.d("observation");
        if (d != null) {
            return (CurrentConditions) p.a(d, CurrentConditions.class);
        }
        f.c("WeatherChannelManager", "observation is null");
        return null;
    }

    public static long a() {
        return a;
    }
}
