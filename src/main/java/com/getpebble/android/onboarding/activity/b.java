package com.getpebble.android.onboarding.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ak.a;
import com.getpebble.android.common.model.v;
import com.getpebble.android.onboarding.fragment.e;
import com.getpebble.android.onboarding.fragment.j;

public class b {
    static com.getpebble.android.onboarding.activity.a.b a() {
        return com.getpebble.android.onboarding.activity.a.b.NEW_USER;
    }

    static com.getpebble.android.onboarding.activity.a.b b() {
        return com.getpebble.android.onboarding.activity.a.b.PRF;
    }

    static com.getpebble.android.onboarding.activity.a.b c() {
        return com.getpebble.android.onboarding.activity.a.b.LOGIN_ONLY;
    }

    static com.getpebble.android.onboarding.activity.a.b d() {
        return com.getpebble.android.onboarding.activity.a.b.PEBBLE_LANGUAGE_SELECTION;
    }

    static com.getpebble.android.onboarding.activity.a.b e() {
        return com.getpebble.android.onboarding.activity.a.b.HEALTH_ONLY;
    }

    static com.getpebble.android.onboarding.activity.a.b a(int i, boolean z, a aVar, v vVar, int i2, int i3, a.a aVar2, boolean z2, boolean z3) {
        Object obj = 1;
        if ((i < 1 ? 1 : null) != null) {
            f.d("OnboardingUtil", "getOnboardingSequence: Application not previously onboarded; must show onboarding");
            return a();
        } else if (z2) {
            Object obj2;
            if (aVar == null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                f.d("OnboardingUtil", "getOnboardingSequence: Device is disconnected but application has been onboarded: don't show onboarding");
                return null;
            } else if ((!z && !com.getpebble.android.framework.firmware.b.a()) || e.a(PebbleApplication.n()) || com.getpebble.android.framework.firmware.b.b()) {
                if (i2 != 3) {
                    f.e("OnboardingUtil", "getOnboardingSequence: Language packs still need to be configured for this device; showing onboarding only if LP onboarding is required.");
                    if (com.getpebble.android.framework.o.b.a.isLanguageOnboardingRequired()) {
                        if (com.getpebble.android.framework.o.b.a.getSupportedLanguagesCount() <= 0) {
                            obj = null;
                        }
                        if (obj != null) {
                            f.d("OnboardingUtil", "getOnboardingSequence: Languages available");
                            return d();
                        }
                        f.c("OnboardingUtil", "getOnboardingSequence: No languages available");
                    }
                }
                if (aVar2.hasMigrationPath()) {
                    f.d("OnboardingUtil", "getOnboardingSequence: Device needs device-specific onboarding, preparing to show " + aVar2.migrationSequence.toString());
                    if (j.a(aVar)) {
                        return aVar2.migrationSequence;
                    }
                    f.e("OnboardingUtil", "getOnboardingSequence: Onboarding a Pebble with no HRM, so migration isn't applicable. Skipping the migration, but marking it as concluded");
                    aVar2.migrationConcluded(aVar.pebbleDevice);
                    return null;
                } else if (!z3 || i3 >= 3) {
                    f.d("OnboardingUtil", "getOnboardingSequence: Device has been fully onboarded to latest onboarding version: does not need onboarding");
                    return null;
                } else {
                    f.d("OnboardingUtil", "getOnboardingSequence: Device has not been health onboarded: showing health onboarding");
                    return e();
                }
            } else {
                f.d("OnboardingUtil", "getOnboardingSequence: Device is running recovery firmware: needs onboarding");
                return b();
            }
        } else {
            f.d("OnboardingUtil", "getOnboardingSequence: User is not logged in but has completed onboarding before");
            return c();
        }
    }

    public static com.getpebble.android.onboarding.activity.a.b f() {
        v vVar;
        a.a aVar;
        int i;
        boolean z = true;
        boolean z2 = false;
        int i2 = -1;
        PebbleApplication.u().h();
        a r = PebbleApplication.r();
        int a = com.getpebble.android.onboarding.a.a();
        boolean z3 = PebbleApplication.u().g() != null;
        if (r == null) {
            vVar = null;
            aVar = a.a.UNKNOWN;
            i = -1;
        } else {
            z = r.isRunningRecoveryFw;
            vVar = r.getFwVersion();
            i = com.getpebble.android.onboarding.a.a(r.pebbleDevice);
            i2 = com.getpebble.android.onboarding.a.b(r.pebbleDevice);
            aVar = com.getpebble.android.onboarding.a.c(r.pebbleDevice);
            z2 = r.capabilities.supportsHealthInsights;
        }
        f.d("OnboardingUtil", "getOnboardingSequence: getOnboardingSequence(" + a + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + z + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + r + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + vVar + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + i + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + z3 + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + i2 + com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + aVar.name() + ")");
        return a(a, z, r, vVar, i, i2, aVar, z3, z2);
    }

    public static boolean g() {
        return a("com.getpebble.android");
    }

    public static boolean a(String str) {
        try {
            com.getpebble.android.common.a.K().getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        } catch (Throwable e2) {
            f.b("OnboardingUtil", "isPackageInstalled (" + str + "): error", e2);
            return false;
        }
    }

    public static void h() {
        Context K = com.getpebble.android.common.a.K();
        try {
            Intent launchIntentForPackage = K.getPackageManager().getLaunchIntentForPackage("com.getpebble.android");
            if (launchIntentForPackage == null) {
                f.b("OnboardingUtil", "Could not open Pebble app - redirecting to play store");
                i();
                return;
            }
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            K.startActivity(launchIntentForPackage);
        } catch (Throwable e) {
            f.b("OnboardingUtil", "openPebbleApp: error getting launch Intent", e);
            i();
        }
    }

    public static void i() {
        Context K = com.getpebble.android.common.a.K();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.getpebble.android"));
        intent.setFlags(268435456);
        try {
            K.startActivity(intent);
        } catch (Throwable e) {
            f.d("OnboardingUtil", "Error loading play store for Pebble; showing web store", e);
            K.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.getpebble.android")));
        }
    }

    public static boolean j() {
        return PebbleApplication.u().h() != null;
    }
}
