package com.getpebble.android.common.b.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.getpebble.android.common.b.a.f;
import java.util.List;

public class d {
    private static a a;

    public enum a {
        UI(":ui") {
            public boolean isFramework() {
                return false;
            }
        },
        FRAMEWORK(":framework") {
            public boolean isFramework() {
                return true;
            }
        },
        UNKNOWN("unknown") {
            public boolean isFramework() {
                return false;
            }
        };
        
        final String processName;

        public abstract boolean isFramework();

        private a(String str) {
            this.processName = str;
        }

        public static a from(String str) {
            for (a aVar : values()) {
                if (str.endsWith(aVar.processName)) {
                    return aVar;
                }
            }
            return UNKNOWN;
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (d.class) {
            if (a != null) {
                aVar = a;
            } else {
                int myPid = Process.myPid();
                List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
                String str = null;
                if (runningAppProcesses == null) {
                    throw new IllegalStateException("Running App Process Info Was Null");
                }
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (myPid == runningAppProcessInfo.pid) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                }
                f.d("ProcessUtil", "processName = '" + str + "'");
                if (str == null) {
                    throw new IllegalStateException("Could not get process name");
                }
                aVar = a.from(str);
                switch (aVar) {
                    case UI:
                    case FRAMEWORK:
                        a = aVar;
                        break;
                    default:
                        throw new IllegalStateException("Unknown process: '" + str + "'");
                }
            }
        }
        return aVar;
    }

    public static void a(a aVar) {
        if (!aVar.equals(a)) {
            f.f("ProcessUtil", "assertProcess: wanted " + aVar + " but is " + a + "!!!");
        }
    }
}
