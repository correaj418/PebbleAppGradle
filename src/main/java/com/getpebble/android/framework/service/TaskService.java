package com.getpebble.android.framework.service;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.getpebble.android.a.g;
import com.getpebble.android.common.model.a.j;
import com.getpebble.android.common.model.a.k;
import com.getpebble.android.common.model.a.n;
import com.getpebble.android.common.model.a.r;
import com.getpebble.android.common.model.a.v;
import com.getpebble.android.common.model.a.x;
import com.getpebble.android.common.model.a.y;
import com.getpebble.android.common.model.u;
import com.getpebble.android.core.sync.b;
import com.getpebble.android.framework.health.HeartRateCalculationService;
import com.google.android.gms.gcm.Task;
import com.google.android.gms.gcm.d;
import com.google.android.gms.gcm.f;

public class TaskService extends d {

    private static class a extends Exception {
        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    public void a() {
        super.a();
    }

    public int a(f fVar) {
        if (fVar == null) {
            com.getpebble.android.common.b.a.f.a("TaskService", "onRunTask: failed to resolve task parameters");
            return 2;
        }
        String a = fVar.a();
        if (TextUtils.isEmpty(a)) {
            com.getpebble.android.common.b.a.f.a("TaskService", "onRunTask: failed to resolve tag");
            return 2;
        }
        int i = -1;
        switch (a.hashCode()) {
            case -2110430427:
                if (a.equals("health-update-movementData-single-once")) {
                    i = 5;
                    break;
                }
                break;
            case -1358190668:
                if (a.equals("health-upload-unmetered")) {
                    i = 1;
                    break;
                }
                break;
            case -1345945171:
                if (a.equals("health-upload-metered")) {
                    i = 0;
                    break;
                }
                break;
            case -1268381711:
                if (a.equals("health-update-typical-once")) {
                    i = 7;
                    break;
                }
                break;
            case -1224309593:
                if (a.equals("pipeline-upload-metered")) {
                    i = 2;
                    break;
                }
                break;
            case -430517202:
                if (a.equals("pipeline-upload-unmetered")) {
                    i = 3;
                    break;
                }
                break;
            case -273497514:
                if (a.equals("health-update-averageDailySteps-once")) {
                    i = 9;
                    break;
                }
                break;
            case -111471097:
                if (a.equals("health-update-heartRateInfo-periodic")) {
                    i = 14;
                    break;
                }
                break;
            case 485493313:
                if (a.equals("health-update-typical-sleep-periodic")) {
                    i = 12;
                    break;
                }
                break;
            case 520865776:
                if (a.equals("health-update-averageDailySteps-periodic")) {
                    i = 8;
                    break;
                }
                break;
            case 656197643:
                if (a.equals("health-update-typical-periodic")) {
                    i = 6;
                    break;
                }
                break;
            case 982930381:
                if (a.equals("health-update-averageSleepDuration-once")) {
                    i = 11;
                    break;
                }
                break;
            case 1112262119:
                if (a.equals("health-update-averageSleepDuration-periodic")) {
                    i = 10;
                    break;
                }
                break;
            case 1158853613:
                if (a.equals("health-update-heartRateInfo-once")) {
                    i = 15;
                    break;
                }
                break;
            case 1312474892:
                if (a.equals("health-update-sleepSummary-once")) {
                    i = 13;
                    break;
                }
                break;
            case 1348839758:
                if (a.equals("health-update-movementData-all-once")) {
                    i = 4;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
            case 1:
                return b();
            case 2:
            case 3:
                return i();
            case 4:
                return c();
            case 5:
                return a(fVar.b());
            case 6:
            case 7:
                return d();
            case 8:
            case 9:
                return e();
            case 10:
            case 11:
                return f();
            case 12:
                return g();
            case 13:
                return b(fVar.b());
            case 14:
            case 15:
                return h();
            default:
                com.getpebble.android.common.b.a.f.a("TaskService", "onRunTask: unknown tag: " + a);
                return 2;
        }
    }

    private int b() {
        new b(this, new n(com.getpebble.android.common.a.K())).a().b();
        return 0;
    }

    private int c() {
        return a(u.values());
    }

    private int a(Bundle bundle) {
        return a(new u[]{u.from(bundle.getInt("dayOfWeek"))});
    }

    private int a(u[] uVarArr) {
        com.getpebble.android.framework.health.e.a aVar = new com.getpebble.android.framework.health.e.a(this);
        aVar.a(new r.d(v.class), uVarArr);
        aVar.a();
        return 0;
    }

    private int d() {
        com.getpebble.android.framework.health.e.a aVar = new com.getpebble.android.framework.health.e.a(this);
        aVar.a(new r.d(y.class));
        aVar.a();
        return 0;
    }

    private int e() {
        com.getpebble.android.framework.health.e.a aVar = new com.getpebble.android.framework.health.e.a(this);
        aVar.b(new r.d(j.class));
        aVar.a();
        return 0;
    }

    private int f() {
        com.getpebble.android.framework.health.f.a aVar = new com.getpebble.android.framework.health.f.a(this);
        aVar.a(new r.d(k.class));
        aVar.a();
        return 0;
    }

    private int g() {
        com.getpebble.android.framework.health.f.a aVar = new com.getpebble.android.framework.health.f.a(this);
        aVar.a(r.a(x.class), new r.d(x.class));
        aVar.a();
        return 0;
    }

    private int b(Bundle bundle) {
        if (bundle == null) {
            com.getpebble.android.common.b.a.f.b("TaskService", "updateSleepSummary: failed, null extras");
            return 2;
        }
        int i = bundle.getInt("dayOfWeek");
        com.getpebble.android.framework.health.f.a aVar = new com.getpebble.android.framework.health.f.a(this);
        u from = u.from(i);
        aVar.a(r.a(x.class), new r.d(x.class), new u[]{from});
        aVar.a();
        return 0;
    }

    private int h() {
        Intent intent = new Intent("HeartRateCalculationService.updateAll");
        intent.setClass(this, HeartRateCalculationService.class);
        startService(intent);
        return 0;
    }

    private int i() {
        new g(this).c();
        return 0;
    }

    public static void a(Task task) {
        com.google.android.gms.gcm.b a = com.google.android.gms.gcm.b.a(com.getpebble.android.common.a.K());
        if (a == null) {
            com.getpebble.android.common.b.a.f.a("TaskService", "gcmNetworkManager is null: failed to schedule periodic tasks");
            return;
        }
        try {
            a.a(task);
        } catch (Throwable e) {
            int a2 = com.google.android.gms.common.b.a().a(com.getpebble.android.common.a.K());
            com.getpebble.android.common.a.b(new a("PBL-38300 Failed to schedule tasks; GCM code: " + a2 + "; version: " + com.getpebble.android.notifications.b.g.b("com.google.android.gms"), e));
        }
    }
}
