package com.getpebble.android.core.sync;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SyncResult;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import com.b.b.x;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.a;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.b.l;
import com.getpebble.android.common.framework.install.app.b;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.a.d;
import com.getpebble.android.common.model.a.o;
import com.getpebble.android.common.model.ab;
import com.getpebble.android.common.model.ac;
import com.getpebble.android.common.model.ad;
import com.getpebble.android.common.model.ae;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.au;
import com.getpebble.android.common.model.av;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.common.model.aw.e;
import com.getpebble.android.common.model.ax;
import com.getpebble.android.common.model.az;
import com.getpebble.android.common.model.bb;
import com.getpebble.android.common.model.bc;
import com.getpebble.android.common.model.bd;
import com.getpebble.android.common.model.t;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherChannelDataModels;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherChannelDataModels.AggregateReport;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherChannelDataModels.CurrentConditions;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherChannelDataModels.DailyForecast;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel.Record;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel.Record.Builder;
import com.getpebble.android.common.model.z;
import com.getpebble.android.framework.firmware.FirmwareManifestBundle;
import com.getpebble.android.framework.gcm.RegistrationIntentService;
import com.getpebble.android.framework.location.PebbleLocationService;
import com.getpebble.android.framework.timeline.TimelineWebSyncService;
import com.getpebble.android.h.h;
import com.getpebble.android.h.n;
import com.getpebble.android.h.s;
import com.google.b.q;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class c extends AbstractThreadedSyncAdapter {
    private static final long a = TimeUnit.SECONDS.toMillis(30);

    public c(Context context, boolean z) {
        super(context, z);
    }

    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        int i = bundle.getInt("sync_target", -1);
        if (h.a(a.K())) {
            f.d("PebbleSyncAdapter", "onPerformSync: target = " + i);
            switch (i) {
                case 0:
                    b();
                    return;
                case 1:
                    d();
                    return;
                case 3:
                    g();
                    s();
                    return;
                case 4:
                    f();
                    return;
                case 5:
                    e();
                    return;
                case 6:
                    j();
                    return;
                case 7:
                    k();
                    return;
                case 8:
                    l();
                    return;
                case 9:
                    m();
                    return;
                case 10:
                    n();
                    return;
                case 11:
                    h();
                    return;
                case 12:
                    o();
                    return;
                case 13:
                    p();
                    return;
                case 14:
                    s();
                    return;
                case 15:
                    t();
                    return;
                default:
                    return;
            }
        }
        f.a("PebbleSyncAdapter", "Failed to sync target: " + i + " [No Network Connection]");
    }

    private void b() {
        f();
        k();
        t();
        r();
        d();
        g();
        s();
        j();
        e();
        l();
        m();
        h();
        n();
        o();
        p();
        au.a(getContext().getContentResolver());
        c();
        PebbleLocationService.b();
    }

    private void c() {
        o.a(getContext().getContentResolver(), System.currentTimeMillis());
        d.a(getContext().getContentResolver(), System.currentTimeMillis());
    }

    private void d() {
        f.d("PebbleSyncAdapter", "syncLockerApps start");
        long currentTimeMillis = System.currentTimeMillis();
        com.getpebble.android.framework.h.a.a(getContext());
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        au.a(au.a.LOCKER_SYNC, getContext().getContentResolver(), currentTimeMillis);
        f.d("PebbleSyncAdapter", "syncLockerApps stop elapsed = " + currentTimeMillis);
    }

    private void e() {
        f.d("PebbleSyncAdapter", "syncTimeline()");
        TimelineWebSyncService.a(getContext(), null);
    }

    private com.google.b.o a(z zVar, Context context) {
        f.d("PebbleSyncAdapter", "loadLpJsonFromAssets()");
        String str = "lp/" + zVar.getName() + ".json";
        try {
            String a = com.getpebble.android.common.framework.b.f.a(context, str, false);
            f.d("PebbleSyncAdapter", "loadBundleJsonFromAssets: file = " + str + " content = '" + a + "'");
            return new q().a(a).l();
        } catch (IOException e) {
            f.c("PebbleSyncAdapter", "loadBundleJsonFromAssets: no bundled manifest found for " + zVar.getName());
            return null;
        } catch (IllegalStateException e2) {
            f.c("PebbleSyncAdapter", "loadBundleJsonFromAssets: no bundled manifest found for " + zVar.getName());
            return null;
        }
    }

    private void f() {
        f.d("PebbleSyncAdapter", "syncLanguages()");
        long currentTimeMillis = System.currentTimeMillis();
        ak.a p = PebbleApplication.p();
        com.google.b.o oVar;
        try {
            String str;
            String str2;
            Context context = getContext();
            if (p == null) {
                str = null;
            } else {
                str = p.hwPlatform.getName();
            }
            if (p == null) {
                str2 = null;
            } else {
                str2 = p.getFwVersion().getNumberOnlyVersionTag();
            }
            x a = com.getpebble.android.d.a.a(context, str, str2, 30000);
            if (a == null) {
                f.b("PebbleSyncAdapter", "jsonObjectResponse is null");
                return;
            }
            oVar = (com.google.b.o) a.b();
            if (oVar == null && p != null) {
                oVar = a(p.hwPlatform, getContext());
            }
            if (oVar == null) {
                f.b("PebbleSyncAdapter", "jsonResponse is null");
                return;
            }
            try {
                a(getContext().getContentResolver(), p, oVar.toString());
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                au.a(au.a.LANGAUAGE_PACKS_SYNC, getContext().getContentResolver(), currentTimeMillis2);
                f.d("PebbleSyncAdapter", "Updating languages complete. elapsed = " + currentTimeMillis2);
                t.a(getContext().getContentResolver(), "pebble_language_packs", System.currentTimeMillis());
            } catch (Throwable e) {
                f.b("PebbleSyncAdapter", "Failed to marshall language pack manifest; not updating languages", e);
            }
        } catch (Throwable e2) {
            f.a("PebbleSyncAdapter", "Error fetching language pack manifest", e2);
            oVar = null;
        } catch (Throwable e22) {
            f.b("PebbleSyncAdapter", "Exception thrown while attempting to get language pack jsonObjectResponse.getResult()", e22);
        }
    }

    public static void a(ContentResolver contentResolver, ak.a aVar, String str) {
        int i;
        f.e("PebbleSyncAdapter", "updateLanguagePacks()");
        ac a = ac.a(str);
        if (a.a == null) {
            i = -1;
        } else {
            i = a.a.length;
        }
        f.d("PebbleSyncAdapter", "Received a language pack response of length: " + i);
        ab.a(contentResolver);
        ArrayList a2 = a(contentResolver, a);
        if (a2.isEmpty()) {
            f.b("PebbleSyncAdapter", "No language packs available");
            t.a(contentResolver, "pebble_language_packs", System.currentTimeMillis());
            return;
        }
        try {
            contentResolver.applyBatch("com.getpebble.android.basalt.internal.provider", a2);
            f.d("PebbleSyncAdapter", String.format("Performed %d operations", new Object[]{Integer.valueOf(a2.size())}));
        } catch (Throwable e) {
            f.a("PebbleSyncAdapter", "Failed to update local languages.", e);
        } catch (Throwable e2) {
            f.a("PebbleSyncAdapter", "Failed to update local languages.", e2);
        }
        ad adVar = new ad(a.K(), aVar);
        if (adVar.a()) {
            f.d("PebbleSyncAdapter", "Triggering language pack update");
            adVar.b();
            return;
        }
        f.e("PebbleSyncAdapter", "No language pack update required");
    }

    static ArrayList<ContentProviderOperation> a(ContentResolver contentResolver, ac acVar) {
        Set hashSet = new HashSet();
        List<ContentValues> a = acVar.a();
        ArrayList<ContentProviderOperation> arrayList = new ArrayList();
        for (ContentValues contentValues : a) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String asString : ab.b()) {
                stringBuilder.append(contentValues.getAsString(asString));
            }
            if (hashSet.contains(stringBuilder.toString())) {
                f.b("PebbleSyncAdapter", "Duplicate: " + stringBuilder.toString());
            } else {
                hashSet.add(stringBuilder.toString());
                ContentProviderOperation a2 = a(contentResolver, "pebble_language_packs", ab.b(), contentValues);
                if (a2 != null) {
                    f.e("PebbleSyncAdapter", "LanguagePackUpdateOperation: " + a2.toString());
                    arrayList.add(a2);
                } else {
                    f.a("PebbleSyncAdapter", String.format("Operation for %s was null; unique columns: %s", new Object[]{contentValues.toString(), Arrays.toString(ab.b())}));
                }
            }
        }
        return arrayList;
    }

    private void g() {
        f.d("PebbleSyncAdapter", "syncFirmwareManifest start");
        long currentTimeMillis = System.currentTimeMillis();
        new com.getpebble.android.framework.firmware.a(getContext()).a();
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        au.a(au.a.FW_MANIFEST_SYNC, getContext().getContentResolver(), currentTimeMillis);
        f.d("PebbleSyncAdapter", "syncFirmwareManifest stop elapsed = " + currentTimeMillis);
        a();
    }

    void a() {
        PebbleDevice n = PebbleApplication.n();
        if (n != null) {
            ak.a r = PebbleApplication.r();
            if (r != null && r.getFwVersion() != null) {
                l lVar = new l(n, r.getFwVersion());
                if (lVar.a()) {
                    lVar.b();
                }
            }
        }
    }

    private void h() {
        f.d("PebbleSyncAdapter", "syncTrendingSearches start");
        ak.a p = PebbleApplication.p();
        b.a aVar = b.a.APLITE;
        if (p != null) {
            aVar = p.hwPlatform.getPlatformCode();
        }
        String a = ax.a(aVar);
        if (a != null) {
            try {
                x a2 = com.getpebble.android.d.a.a(getContext(), a, a, ax.class);
                if (com.getpebble.android.d.a.a(a2)) {
                    ax axVar = (ax) a2.b();
                    if (axVar != null && axVar.a() != null) {
                        PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.TRENDING_SEARCHES, new HashSet(Arrays.asList(axVar.a())));
                        return;
                    }
                    return;
                }
                f.d("PebbleSyncAdapter", "syncTrendingSearches: Unsuccessful GET: " + a2.d().c());
            } catch (Throwable e) {
                f.a("PebbleSyncAdapter", "syncTrendingSearches: Error fetching trending searches ", e);
            }
        }
    }

    private void i() {
        ContentResolver contentResolver = getContext().getContentResolver();
        if (((bb) az.a("weatherApp", contentResolver)) == null) {
            f.c("PebbleSyncAdapter", "No Weather app location ordering detected. Creating now");
            List weatherLocationsList = WeatherLocationsModel.getWeatherLocationsList(contentResolver);
            if (weatherLocationsList == null) {
                weatherLocationsList = new ArrayList();
            }
            bb.a(weatherLocationsList);
        }
    }

    private void j() {
        f.d("PebbleSyncAdapter", "syncWeather start");
        long currentTimeMillis = System.currentTimeMillis();
        ContentResolver contentResolver = getContext().getContentResolver();
        bd.a(contentResolver);
        bd.b(contentResolver);
        if (PebbleApplication.w().B()) {
            String[] strArr = new String[]{(System.currentTimeMillis() - TimeUnit.HOURS.toMillis(1)) + ""};
            Cursor query = contentResolver.query(WeatherLocationsModel.TABLE_URI, WeatherLocationsModel.ALL_COLUMNS, "updated_timestamp < ?", strArr, "is_timeline_source ASC");
            if (query == null) {
                f.d("PebbleSyncAdapter", "Bad cursor value - returning.");
                return;
            }
            if (!PebbleLocationService.a(PebbleLocationService.a.LOCATION_ENABLED)) {
                am.a(a.K().getContentResolver(), aw.c, false);
            }
            com.getpebble.android.framework.q.a aVar = new com.getpebble.android.framework.q.a(getContext());
            while (query.moveToNext()) {
                Record from = Record.from(query);
                if (!(from.latitude == WeatherLocationsModel.LATITUDE_INVALID || from.longitude == WeatherLocationsModel.LONGITUDE_INVALID)) {
                    Location location = new Location("SyncWeather");
                    location.setLatitude(from.latitude);
                    location.setLongitude(from.longitude);
                    AggregateReport a = aVar.a(location);
                    if (a == null) {
                        f.c("PebbleSyncAdapter", "aggReport is null");
                    } else {
                        try {
                            if (a.currentConditions == null) {
                                f.c("PebbleSyncAdapter", "currentConditions is null");
                            } else if (a.dailyForecasts == null) {
                                f.c("PebbleSyncAdapter", "dailyForecasts is null");
                            } else {
                                a(contentResolver, from, a.dailyForecasts, a.currentConditions);
                                a(contentResolver, from, a.dailyForecasts);
                            }
                        } finally {
                            query.close();
                        }
                    }
                }
            }
            i();
            long currentTimeMillis2 = (System.currentTimeMillis() - currentTimeMillis) / 1000;
            au.a(au.a.WEATHER_SYNC, getContext().getContentResolver(), currentTimeMillis2);
            f.d("PebbleSyncAdapter", "syncWeather stop elapsed = " + currentTimeMillis2 + " seconds");
            return;
        }
        f.d("PebbleSyncAdapter", "syncWeather: not syncing weather because disabled in boot");
        aw.a(getContext().getContentResolver(), e.WEATHER);
    }

    private void a(ContentResolver contentResolver, Record record, DailyForecast[] dailyForecastArr, CurrentConditions currentConditions) {
        bc.a.a aVar = new bc.a.a();
        c.b.a.b d = c.b.a.b.a().c(c.b.a.f.a).p_().d(0);
        c.b.a.b a = d.a(1);
        for (DailyForecast dailyForecast : dailyForecastArr) {
            if (dailyForecast != null) {
                long c = bd.a(dailyForecast.fcst_valid_local).c();
                bd.a(contentResolver, new bd.a(c, record.locationUuid, WeatherChannelDataModels.dateStringToUtcOffsetMinutes(dailyForecast.fcst_valid_local), dailyForecast.max_temp != null ? Integer.valueOf(Integer.parseInt(dailyForecast.max_temp)) : null, dailyForecast.min_temp != null ? Integer.valueOf(Integer.parseInt(dailyForecast.min_temp)) : null, System.currentTimeMillis(), dailyForecast.day != null ? dailyForecast.day.phrase_22char : dailyForecast.night.phrase_22char));
                aVar.a(record.locationUuid);
                if (c == d.c()) {
                    Short sh;
                    aVar.b(dailyForecast.max_temp == null ? null : Short.valueOf(Short.parseShort(dailyForecast.max_temp)));
                    if (dailyForecast.min_temp == null) {
                        sh = null;
                    } else {
                        sh = Short.valueOf(Short.parseShort(dailyForecast.min_temp));
                    }
                    aVar.c(sh);
                } else if (c == a.c()) {
                    com.getpebble.android.framework.timeline.e.d weatherType;
                    aVar.d(dailyForecast.max_temp == null ? null : Short.valueOf(Short.parseShort(dailyForecast.max_temp)));
                    aVar.e(dailyForecast.min_temp == null ? null : Short.valueOf(Short.parseShort(dailyForecast.min_temp)));
                    if (dailyForecast.day != null) {
                        weatherType = dailyForecast.day.getWeatherType();
                    } else if (dailyForecast.night != null) {
                        weatherType = dailyForecast.night.getWeatherType();
                    } else {
                        weatherType = com.getpebble.android.framework.timeline.e.d.UNKNOWN;
                    }
                    aVar.b(weatherType);
                }
            }
        }
        aVar.a(currentConditions.getTemp());
        aVar.a(currentConditions.getWeatherType());
        aVar.a(currentConditions.phrase_12char);
        if ((record.isDynamic && record.addedByUser) || !record.isDynamic) {
            bc.a(contentResolver, aVar.a());
        }
    }

    private void a(ContentResolver contentResolver, Record record, DailyForecast[] dailyForecastArr) {
        DailyForecast dailyForecast;
        DailyForecast dailyForecast2;
        DailyForecast dailyForecast3 = null;
        if (dailyForecastArr.length >= 3) {
            dailyForecast = dailyForecastArr[0];
            dailyForecast2 = dailyForecastArr[1];
            dailyForecast3 = dailyForecastArr[2];
        } else {
            dailyForecast2 = null;
            dailyForecast = null;
        }
        if (record.isTimelineSource) {
            WeatherChannelDataModels.updateOrInsertWeatherByDay(record, dailyForecast, com.getpebble.android.framework.q.a.a.TODAY);
            WeatherChannelDataModels.updateOrInsertWeatherByDay(record, dailyForecast2, com.getpebble.android.framework.q.a.a.TOMORROW);
            WeatherChannelDataModels.updateOrInsertWeatherByDay(record, dailyForecast3, com.getpebble.android.framework.q.a.a.DAY_AFTER_TOMORROW);
        }
        Builder from = Builder.from(record);
        from.setUpdatedTimestamp(!record.isTimelineSource ? System.currentTimeMillis() : 0);
        WeatherLocationsModel.update(contentResolver, from);
    }

    private void k() {
        Context K = a.K();
        if (K != null) {
            RegistrationIntentService.a(K);
        }
    }

    private void l() {
        f.d("PebbleSyncAdapter", "syncTimelineMappers()");
        try {
            for (av.a aVar : av.a(getContext().getContentResolver())) {
                try {
                    com.google.b.o oVar = (com.google.b.o) new com.getpebble.android.d.e(getContext()).a(aVar.a(), a, com.google.b.o.class);
                    if (oVar == null) {
                        f.d("PebbleSyncAdapter", "Empty result for " + aVar.a());
                    } else {
                        try {
                            av.a(getContext().getContentResolver(), av.a.a(aVar.a, aVar.b, oVar.toString()));
                        } catch (Throwable e) {
                            f.a("PebbleSyncAdapter", "Failed to insert or update timeline mapper record", e);
                        }
                    }
                } catch (Throwable e2) {
                    f.a("PebbleSyncAdapter", "Exception thrown while fetching " + aVar.a(), e2);
                }
            }
        } catch (Throwable e3) {
            f.a("PebbleSyncAdapter", "Failed to sync timeline mappers.", e3);
        }
    }

    private void m() {
        f.d("PebbleSyncAdapter", "syncAnalyticsEvents()");
        long currentTimeMillis = System.currentTimeMillis();
        new com.getpebble.android.a.d().c();
        au.a(au.a.PHONE_ANALYTICS_EVENTS_SYNC, getContext().getContentResolver(), System.currentTimeMillis() - currentTimeMillis);
    }

    private void n() {
        q();
        b(a.K());
        a(a.K());
    }

    private void a(Context context) {
        if (com.getpebble.android.notifications.b.f.a(context)) {
            ae.a(com.getpebble.android.common.model.a.NOTIFICATION_LISTENER, context.getContentResolver());
        }
    }

    private void o() {
        ak.a r = PebbleApplication.r();
        if (r != null) {
            if (r.capabilities.supportsHealthInsights) {
                final Context K = a.K();
                final com.getpebble.android.framework.health.c.b b = new com.getpebble.android.framework.health.c.a(K, r.hwPlatform).b();
                if (b == null) {
                    f.d("PebbleSyncAdapter", "syncHealthInsights: Insights response is null");
                    return;
                }
                final PebbleDevice pebbleDevice = r.pebbleDevice;
                if (b.b > r.healthInsightsVersion) {
                    String str = "insights";
                    File a = new com.getpebble.android.framework.install.a(K, "insights").a(b.a, null);
                    if (a == null) {
                        f.d("PebbleSyncAdapter", "syncHealthInsights: Downloaded file is null");
                        return;
                    }
                    final Uri fromFile = Uri.fromFile(a);
                    com.getpebble.android.framework.b.a(new com.getpebble.android.framework.b.a(this) {
                        final /* synthetic */ c e;

                        public void onFrameworkStateChanged(FrameworkState frameworkState) {
                            if (frameworkState.a() == FrameworkState.a.FILE_INSTALL_COMPLETE) {
                                f.d("PebbleSyncAdapter", "syncHealthInsights: onFrameworkStateChanged: File install complete");
                                com.getpebble.android.framework.g.q.a fromValue = com.getpebble.android.framework.g.q.a.fromValue(frameworkState.i());
                                if (fromFile.equals(frameworkState.j())) {
                                    if (fromValue == com.getpebble.android.framework.g.q.a.SUCCESS) {
                                        ak.updateHealthInsightsVersion(K.getContentResolver(), pebbleDevice, b.b);
                                    } else {
                                        f.a("PebbleSyncAdapter", "Error installing health insights file: " + fromValue.toString());
                                    }
                                }
                                com.getpebble.android.framework.b.b(this);
                            }
                        }
                    });
                    com.getpebble.android.framework.d x = PebbleApplication.x();
                    f.d("PebbleSyncAdapter", "syncHealthInsights: Installing health insights file");
                    x.a(pebbleDevice, fromFile, "insights");
                    return;
                }
                f.d("PebbleSyncAdapter", "syncHealthInsights: Watch insights file is up to date - not installing");
                return;
            }
            f.c("PebbleSyncAdapter", "syncHealthInsights: Connected device not support health - not syncing insights");
        }
    }

    private void p() {
        f.d("PebbleSyncAdapter", "syncAutoCoreDumps()");
        com.getpebble.android.main.sections.support.a.b(getContext());
    }

    private void q() {
        ak.a r = PebbleApplication.r();
        if (r == null) {
            f.e("PebbleSyncAdapter", "checkFwUpdates(): No connected device.");
        } else {
            new com.getpebble.android.c.a(getContext(), r.pebbleDevice, r.getFwVersion(), new com.getpebble.android.c.a.a(this) {
                final /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public void a(PebbleDevice pebbleDevice, FirmwareManifestBundle firmwareManifestBundle) {
                    if (firmwareManifestBundle == null) {
                        ae.a(com.getpebble.android.common.model.a.FW_UPDATE, a.K().getContentResolver());
                    } else {
                        ae.a(new ae.a(System.currentTimeMillis(), com.getpebble.android.common.model.a.FW_UPDATE), a.K().getContentResolver());
                    }
                }

                public void a(PebbleDevice pebbleDevice) {
                    ae.a(com.getpebble.android.common.model.a.FW_UPDATE, a.K().getContentResolver());
                }

                public void a() {
                }

                public void b() {
                }
            }).submit();
        }
    }

    private void b(Context context) {
        if (new com.getpebble.android.common.b.b.c(context).a(com.getpebble.android.common.b.b.c.a.ANDROID_WEAR_OPTOUT, false)) {
            ae.a(com.getpebble.android.common.model.a.ANDROID_WEAR, a.K().getContentResolver());
        } else if (com.getpebble.android.notifications.b.f.b()) {
            ae.a(com.getpebble.android.common.model.a.ANDROID_WEAR, a.K().getContentResolver());
        } else {
            ae.a(new ae.a(System.currentTimeMillis(), com.getpebble.android.common.model.a.ANDROID_WEAR), a.K().getContentResolver());
        }
    }

    private static ContentProviderOperation a(ContentResolver contentResolver, String str, String[] strArr, ContentValues contentValues) {
        String b = com.getpebble.android.h.x.b(Arrays.asList(strArr));
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = contentValues.getAsString(strArr[i]);
        }
        Cursor query = contentResolver.query(com.getpebble.android.common.b.b.b.a(str), null, b, strArr2, null);
        if (query != null) {
            try {
                ContentProviderOperation build;
                if (query.getCount() <= 0 || !query.moveToFirst()) {
                    build = ContentProviderOperation.newInsert(com.getpebble.android.common.b.b.b.a(str)).withValues(contentValues).build();
                } else {
                    build = ContentProviderOperation.newUpdate(com.getpebble.android.common.b.b.b.a(str)).withSelection(b, strArr2).withValues(contentValues).build();
                }
                query.close();
                return build;
            } catch (Throwable th) {
                query.close();
            }
        } else {
            f.d("PebbleSyncAdapter", "Cursor was null; selection: " + b + " selection args: " + Arrays.toString(strArr2));
            return null;
        }
    }

    private void r() {
        f.d("PebbleSyncAdapter", "checkHockeyApp()");
        n.a(getContext());
    }

    private void s() {
        f.d("PebbleSyncAdapter", "syncHockeyAppReleases()");
        s.a(a.K());
    }

    private void t() {
        f.d("PebbleSyncAdapter", "syncCohorts()");
        ak.a p = PebbleApplication.p();
        if (p == null) {
            f.d("PebbleSyncAdapter", "syncCohorts failed: deviceRecord is null");
            return;
        }
        com.getpebble.android.framework.health.c.a aVar = new com.getpebble.android.framework.health.c.a(a.K(), p.hwPlatform);
        x a = aVar.a();
        if (a == null) {
            f.d("PebbleSyncAdapter", "syncCohorts() failed, null response");
            return;
        }
        com.google.b.o oVar = (com.google.b.o) a.b();
        if (oVar == null) {
            f.d("PebbleSyncAdapter", "syncCohorts() failed, null response object");
            return;
        }
        String oVar2 = oVar.toString();
        try {
            com.getpebble.android.common.model.q.a(getContext().getContentResolver(), aVar.b(oVar2));
        } catch (Throwable e) {
            f.a("PebbleSyncAdapter", "syncCohorts: Failed to marshall response: " + oVar2, e);
        }
    }
}
