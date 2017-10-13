package com.getpebble.android.bluetooth.e;

import android.os.Build;
import android.os.Build.VERSION;
import com.getpebble.android.common.b.a.f;
import com.google.a.b.am;
import java.util.Set;

public class h {
    private static final c f = new c(16, 24, 10, 6000);
    private static final c g = new c(25, 26, 10, 6000);
    private final String a = Build.MANUFACTURER;
    private final String b = Build.MODEL;
    private final int c = VERSION.SDK_INT;
    private final String d = VERSION.RELEASE;
    private final a e = a.from(this.a, this.b);

    enum a {
        NEXUS_5("LGE", false, "Nexus 5"),
        NEXUS_5X("LGE", false, "Nexus 5X"),
        NEXUS_6P("Huawei", false, "Nexus 6P"),
        NEXTBIT_ROBIN("Nextbit", false, "Robin"),
        ONEPLUS_ONE("OnePlus", false, "ONE A2003", "A0001"),
        ONEPLUS_TWO("OnePlus", false, "ONE A2005"),
        MOTO_X("motorola", false, "XT1575"),
        MOTOROLA_DROID_TURBO_2_OR_X_FORCE("motorola", false, "XT1585", "XT1580", "XT1581"),
        GALAXY_S7("samsung", true, "SM-G935", "SM-G930"),
        XIAOMI_REDMI_NOTE_3("Xiaomi", false, "Redmi Note 3"),
        XIAOMI_REDMI_NOTE_2("Xiaomi", false, "Redmi Note 2"),
        HTC_DESIRE_628("HTC", false, "Desire 628"),
        ZTE_A2016("ZTE", false, "ZTE A2016"),
        OTHER("", false, "");
        
        private final String mManufacturer;
        private final Set<String> mModels;
        private final boolean modelIsWWildcard;

        private a(String str, boolean z, String... strArr) {
            this.mManufacturer = str;
            this.mModels = am.a((Object[]) strArr);
            this.modelIsWWildcard = z;
        }

        static a from(String str, String str2) {
            for (a aVar : values()) {
                if (aVar.mManufacturer.equals(str)) {
                    if (aVar.modelIsWWildcard) {
                        for (String startsWith : aVar.mModels) {
                            if (str2.startsWith(startsWith)) {
                                return aVar;
                            }
                        }
                        continue;
                    } else if (aVar.mModels.contains(str2)) {
                        return aVar;
                    }
                }
            }
            return OTHER;
        }
    }

    public static class b {
        public final c a;
        public final int b;

        b(c cVar, int i) {
            this.a = cVar;
            this.b = i;
        }

        b(c cVar) {
            this(cVar, 0);
        }
    }

    public enum c {
        NORMAL,
        LOW_MTU,
        DO_NOT_NEGOTIATE
    }

    public h() {
        f.d("LeDeviceHacks", "LeDeviceHacks: manufacturer = " + this.a + " model = " + this.b + " osVersion = " + this.c + " device = " + this.e);
    }

    boolean a() {
        return false;
    }

    b b() {
        switch (this.e) {
            case NEXTBIT_ROBIN:
            case ONEPLUS_TWO:
            case MOTO_X:
            case ONEPLUS_ONE:
            case XIAOMI_REDMI_NOTE_3:
            case MOTOROLA_DROID_TURBO_2_OR_X_FORCE:
            case ZTE_A2016:
            case HTC_DESIRE_628:
                return new b(c.DO_NOT_NEGOTIATE);
            default:
                if ("Xiaomi".equals(this.a)) {
                    return new b(c.DO_NOT_NEGOTIATE);
                }
                if ("Letv".equals(this.a)) {
                    return new b(c.DO_NOT_NEGOTIATE);
                }
                return new b(c.NORMAL);
        }
    }

    boolean c() {
        return false;
    }

    d d() {
        if (k()) {
            return new d(g, g, g);
        }
        if (j()) {
            return new d(f, f, f);
        }
        switch (this.e) {
            case NEXUS_5:
                return new d(a.d, a.e, new c(6, 9, a.f.c, a.f.d));
            default:
                return null;
        }
    }

    private boolean j() {
        if (VERSION.SDK_INT > 19) {
            return false;
        }
        if (VERSION.SDK_INT < 19) {
            return true;
        }
        if (VERSION.RELEASE.equals("4.4.3") || VERSION.RELEASE.equals("4.4.4")) {
            return false;
        }
        return true;
    }

    int e() {
        return 25;
    }

    int f() {
        if (this.c < 21) {
            return 4;
        }
        return 25;
    }

    boolean g() {
        switch (this.e) {
        }
        return false;
    }

    boolean h() {
        return this.c < 21;
    }

    public boolean i() {
        if (this.e.equals(a.XIAOMI_REDMI_NOTE_3) || this.e.equals(a.XIAOMI_REDMI_NOTE_2) || this.e.equals(a.HTC_DESIRE_628) || k() || l()) {
            return true;
        }
        return false;
    }

    private boolean k() {
        return "samsung".equals(this.a) && this.c < 21;
    }

    private boolean l() {
        return "Huawei".equals(this.a) && this.c < 21;
    }
}
