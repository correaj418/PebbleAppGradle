package com.getpebble.android.framework.timeline;

import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.l.b.aj;

public class c {
    @com.google.b.a.c(a = "action_type")
    private String actionType;
    @com.google.b.a.c(a = "attributes")
    private e[] attributes;
    @com.google.b.a.c(a = "internal_action_type")
    private String internalActionType;
    @com.google.b.a.c(a = "processor_id")
    private int notificationProcessorId;

    public enum a {
        CALENDAR_ACCEPT("calendar_accept"),
        CALENDAR_MAYBE("calendar_maybe"),
        CALENDAR_DECLINE("calendar_decline"),
        CALENDAR_CANCEL("calendar_cancel"),
        UNKNOWN("unknown");
        
        String mSerializedName;

        private a(String str) {
            this.mSerializedName = str;
        }

        public static a from(String str) {
            for (a aVar : values()) {
                if (aVar.getSerializedName().equals(str)) {
                    return aVar;
                }
            }
            return UNKNOWN;
        }

        public String getSerializedName() {
            return this.mSerializedName;
        }
    }

    public enum b {
        GENERIC("generic", aj.GENERIC),
        RESPONSE("response", aj.RESPONSE),
        DISMISS("dismiss", aj.DISMISS),
        HTTP("http", aj.GENERIC),
        SNOOZE("snooze", aj.SNOOZE),
        OPEN_WATCH_APP("openWatchApp", aj.OPEN_WATCH_APP),
        OPEN_ON_PHONE("openOnPhone", aj.GENERIC),
        REMOVE("remove", aj.REMOVE),
        OPEN_PIN("openPin", aj.OPEN_PIN),
        MUTE("mute", aj.GENERIC),
        CALL("call", aj.GENERIC),
        POSTPONE("postpone", aj.POSTPONE),
        COMPLETE("complete", aj.COMPLETE),
        REMOTE_REMOVE("remote_remove", aj.REMOTE_REMOVE),
        UNKNOWN("unknown", aj.UNKNOWN);
        
        private static final String TAG = "MobileActionType";
        final aj protocolActionType;
        final String serializedName;

        private b(String str, aj ajVar) {
            this.protocolActionType = ajVar;
            this.serializedName = str;
        }

        public static b from(String str) {
            for (b bVar : values()) {
                if (bVar.serializedName.equals(str)) {
                    return bVar;
                }
            }
            return UNKNOWN;
        }

        public static b from(aj ajVar) {
            b bVar = UNKNOWN;
            b[] values = values();
            int length = values.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3;
                b bVar2 = values[i];
                if (bVar2.protocolActionType.equals(ajVar)) {
                    i3 = i2 + 1;
                } else {
                    bVar2 = bVar;
                    i3 = i2;
                }
                i++;
                i2 = i3;
                bVar = bVar2;
            }
            if (i2 <= 1) {
                return bVar;
            }
            f.a(TAG, i2 + " mobile action types found for protocol action type " + ajVar + ", returning UNKNOWN due to inability to accurately pick one.");
            return UNKNOWN;
        }

        public String getSerializedName() {
            return this.serializedName;
        }

        public aj getProtocolActionType() {
            return this.protocolActionType;
        }
    }

    public c(b bVar, e[] eVarArr, int i) {
        this(bVar, null, eVarArr, i);
    }

    public c(b bVar, a aVar, e[] eVarArr, int i) {
        this.actionType = bVar.getSerializedName();
        this.internalActionType = aVar == null ? null : aVar.getSerializedName();
        this.attributes = eVarArr;
        this.notificationProcessorId = i;
    }

    public b getActionType() {
        return b.from(this.actionType);
    }

    public a getInternalActionType() {
        return a.from(this.internalActionType);
    }

    public e[] getAttributes() {
        return this.attributes;
    }

    public int getNotificationProcessorId() {
        return this.notificationProcessorId;
    }
}
