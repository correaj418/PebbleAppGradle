package com.getpebble.android.framework.health;

import android.app.IntentService;
import android.content.Intent;
import b.d;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.b.m.e;
import com.getpebble.android.common.framework.b.m.h;
import com.getpebble.android.common.model.ap;
import com.getpebble.android.common.model.ar;
import com.getpebble.android.framework.health.b.a;
import com.getpebble.pipeline.Measurement;
import com.getpebble.pipeline.MeasurementSet;
import com.getpebble.pipeline.MeasurementSet.Type;
import com.getpebble.pipeline.Payload;
import com.getpebble.pipeline.Payload.Builder;
import com.getpebble.pipeline.Tier;
import com.google.a.b.ad;
import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

public class HeartRateCalculationService extends IntentService {
    private a a;

    public HeartRateCalculationService() {
        super("HeartRateCalculationService");
    }

    public void onCreate() {
        super.onCreate();
        this.a = new a(this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.a.a();
    }

    protected void onHandleIntent(Intent intent) {
        if ("HeartRateCalculationService.updateAll".equals(intent.getAction())) {
            a();
        } else if ("HeartRateCalculationService.updateHrInfo".equals(intent.getAction())) {
            a((Integer) intent.getSerializableExtra("restingHeartRate"));
        }
    }

    private void a(Integer num) {
        this.a.a(ap.load(getContentResolver()), num);
    }

    private void a() {
        this.a.a(ap.load(getContentResolver()), new a.a(this) {
            final /* synthetic */ HeartRateCalculationService b;

            public void a(ap apVar, e eVar) {
                h b = eVar.b();
                if (b != null) {
                    this.b.a(eVar.a().intValue(), b);
                }
                Intent intent = new Intent("HeartRateCalculationService.updateHrInfo");
                intent.putExtra("restingHeartRate", eVar.a());
                intent.setClass(this, HeartRateCalculationService.class);
                this.startService(intent);
            }

            public void a(ap apVar) {
                Intent intent = new Intent("HeartRateCalculationService.updateHrInfo");
                intent.putExtra("restingHeartRate", (Serializable) null);
                intent.setClass(this, HeartRateCalculationService.class);
                this.startService(intent);
            }
        });
    }

    private void a(int i, h hVar) {
        try {
            ar.a(getApplicationContext(), new Builder().sender(new Tier.Builder().type("").id("").build()).send_time_utc(Payload.DEFAULT_SEND_TIME_UTC).measurement_sets(ad.a(new MeasurementSet.Builder().uuid(d.a(UUID.randomUUID().toString())).utc_to_local(Integer.valueOf(0)).time_utc(Integer.valueOf(hVar.a())).time_end_utc(Integer.valueOf(hVar.b())).types(ad.a(Type.RestingHR)).measurements(ad.a(new Measurement.Builder().offset_sec(Integer.valueOf(0)).data(Arrays.asList(new Integer[]{Integer.valueOf(i)})).build())).build())).build());
        } catch (Throwable e) {
            f.b("HeartRateCalculationService", "updateAll:onSuccess: failed to save Resting HR payload for PAPI upload", e);
        }
    }
}
