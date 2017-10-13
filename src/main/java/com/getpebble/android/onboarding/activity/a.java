package com.getpebble.android.onboarding.activity;

import com.getpebble.android.bluetooth.PebbleDevice;
import java.util.Arrays;

public class a {

    public enum a {
        ZERO(0, b.DEVICE_SPECIFIC_V1, new b()),
        ONE(1, b.DEVICE_SPECIFIC_V2),
        UNKNOWN(-1, b.DEVICE_SPECIFIC_UNKNOWN);
        
        public static final a LATEST = null;
        public final a callbacks;
        public final b migrationSequence;
        public final int serializedValue;

        private interface a {
            void a(PebbleDevice pebbleDevice);
        }

        private static class b implements a {
            private b() {
            }

            public void a(PebbleDevice pebbleDevice) {
                com.getpebble.android.onboarding.a.a(pebbleDevice, a.ONE);
            }
        }

        static {
            LATEST = ONE;
        }

        private a(int i, b bVar) {
            this(r7, r8, i, bVar, null);
        }

        private a(int i, b bVar, a aVar) {
            this.serializedValue = i;
            this.migrationSequence = bVar;
            this.callbacks = aVar;
        }

        public boolean hasMigrationPath() {
            return this.migrationSequence.steps.length > 0;
        }

        public void migrationConcluded(PebbleDevice pebbleDevice) {
            if (this.callbacks != null) {
                this.callbacks.a(pebbleDevice);
            }
        }

        public static a from(int i) {
            for (a aVar : values()) {
                if (aVar.serializedValue == i) {
                    return aVar;
                }
            }
            return UNKNOWN;
        }
    }

    public enum b {
        UP_TO_DATE(new c[0]),
        NEW_USER(new c[]{c.SPLASH_PAGE, c.LOGIN, c.VOICE_LANGUAGE, c.FIRMWARE, c.HEART_RATE_MONITORING, c.PEBBLE_LANGUAGE, c.NOTIFICATIONS, c.HEALTH, c.WATCHFACE_SELECTION}),
        PRF(new c[]{c.FIRMWARE, c.PEBBLE_LANGUAGE}),
        LOGIN_ONLY(new c[]{c.LOGIN}),
        PEBBLE_LANGUAGE_SELECTION(new c[]{c.PEBBLE_LANGUAGE}),
        HEALTH_ONLY(new c[]{c.HEALTH}),
        DEVICE_SPECIFIC_V1(new c[]{c.HEART_RATE_MONITORING}),
        DEVICE_SPECIFIC_V2(new c[0]),
        DEVICE_SPECIFIC_UNKNOWN(new c[0]);
        
        final c[] steps;

        private b(c[] cVarArr) {
            this.steps = cVarArr;
        }

        public String toString() {
            return String.format("%s: [%s]", new Object[]{name(), Arrays.toString(this.steps)});
        }
    }

    public enum c {
        UNKNOWN,
        LOGIN,
        FIRMWARE,
        VOICE_LANGUAGE,
        NOTIFICATIONS,
        PEBBLE_LANGUAGE,
        HEALTH,
        SPLASH_PAGE,
        WATCHFACE_SELECTION,
        HEART_RATE_MONITORING
    }
}
