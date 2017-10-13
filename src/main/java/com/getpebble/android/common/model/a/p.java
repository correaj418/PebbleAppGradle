package com.getpebble.android.common.model.a;

import com.getpebble.android.common.model.u;

public enum p {
    MONDAY_TYPICAL_STEPS((String) u.MONDAY, (int) a.TYPICAL_STEPS),
    TUESDAY_TYPICAL_STEPS((String) u.TUESDAY, (int) a.TYPICAL_STEPS),
    WEDNESDAY_TYPICAL_STEPS((String) u.WEDNESDAY, (int) a.TYPICAL_STEPS),
    THURSDAY_TYPICAL_STEPS((String) u.THURSDAY, (int) a.TYPICAL_STEPS),
    FRIDAY_TYPICAL_STEPS((String) u.FRIDAY, (int) a.TYPICAL_STEPS),
    SATURDAY_TYPICAL_STEPS((String) u.SATURDAY, (int) a.TYPICAL_STEPS),
    SUNDAY_TYPICAL_STEPS((String) u.SUNDAY, (int) a.TYPICAL_STEPS),
    MONDAY_MOVEMENT_DATA((String) u.MONDAY, (int) a.MOVEMENT_DATA),
    TUESDAY_MOVEMENT_DATA((String) u.TUESDAY, (int) a.MOVEMENT_DATA),
    WEDNESDAY_MOVEMENT_DATA((String) u.WEDNESDAY, (int) a.MOVEMENT_DATA),
    THURSDAY_MOVEMENT_DATA((String) u.THURSDAY, (int) a.MOVEMENT_DATA),
    FRIDAY_MOVEMENT_DATA((String) u.FRIDAY, (int) a.MOVEMENT_DATA),
    SATURDAY_MOVEMENT_DATA((String) u.SATURDAY, (int) a.MOVEMENT_DATA),
    SUNDAY_MOVEMENT_DATA((String) u.SUNDAY, (int) a.MOVEMENT_DATA),
    MONDAY_SLEEP_DATA((String) u.MONDAY, (int) a.SLEEP_DATA),
    TUESDAY_SLEEP_DATA((String) u.TUESDAY, (int) a.SLEEP_DATA),
    WEDNESDAY_SLEEP_DATA((String) u.WEDNESDAY, (int) a.SLEEP_DATA),
    THURSDAY_SLEEP_DATA((String) u.THURSDAY, (int) a.SLEEP_DATA),
    FRIDAY_SLEEP_DATA((String) u.FRIDAY, (int) a.SLEEP_DATA),
    SATURDAY_SLEEP_DATA((String) u.SATURDAY, (int) a.SLEEP_DATA),
    SUNDAY_SLEEP_DATA((String) u.SUNDAY, (int) a.SLEEP_DATA),
    AVERAGE_SLEEP_DURATION("average", (int) a.SLEEP_DURATION),
    AVERAGE_DAILY_STEPS("average", (int) a.DAILY_STEPS);
    
    private static final String BLOB_KEY_FORMAT = "%s_%s";
    final a activityType;
    public final String blobDbKey;
    final String timeDescriptor;

    public enum a {
        private static final /* synthetic */ a[] $VALUES = null;
        public static final a DAILY_STEPS = null;
        public static final a MOVEMENT_DATA = null;
        public static final a SLEEP_DATA = null;
        public static final a SLEEP_DURATION = null;
        public static final a TYPICAL_STEPS = null;
        private final String descriptor;

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) $VALUES.clone();
        }

        static {
            TYPICAL_STEPS = new a("TYPICAL_STEPS", 0, "steps");
            MOVEMENT_DATA = new a("MOVEMENT_DATA", 1, "movementData");
            SLEEP_DATA = new a("SLEEP_DATA", 2, "sleepData");
            SLEEP_DURATION = new a("SLEEP_DURATION", 3, "sleepDuration");
            DAILY_STEPS = new a("DAILY_STEPS", 4, "dailySteps");
            $VALUES = new a[]{TYPICAL_STEPS, MOVEMENT_DATA, SLEEP_DATA, SLEEP_DURATION, DAILY_STEPS};
        }

        private a(String str, int i, String str2) {
            this.descriptor = str2;
        }
    }

    private p(String str, a aVar) {
        this.timeDescriptor = str;
        this.activityType = aVar;
        this.blobDbKey = String.format(BLOB_KEY_FORMAT, new Object[]{str, aVar.descriptor});
    }

    private p(u uVar, a aVar) {
        this(r2, r3, uVar.blobDbKeyName, aVar);
    }

    public static p from(String str, a aVar) {
        for (p pVar : values()) {
            if (pVar.timeDescriptor.equals(str) && pVar.activityType == aVar) {
                return pVar;
            }
        }
        return null;
    }
}
