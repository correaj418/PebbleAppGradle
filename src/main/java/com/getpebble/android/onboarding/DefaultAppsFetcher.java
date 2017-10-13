package com.getpebble.android.onboarding;

import android.content.ContentResolver;
import com.b.b.x;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.a;
import com.getpebble.android.common.model.LockerAppJson.Application;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.am.c;
import com.getpebble.android.h.p;
import com.google.b.o;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DefaultAppsFetcher {
    private static final long GET_CONNECTED_DEVICE_RETRY_MS = 100;
    private static final long GET_CONNECTED_DEVICE_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(1);
    private static final long HTTP_REQUEST_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(30);
    private static final String PLACEHOLDER_HARDWARE_ID = "$$hardware$$";
    private static final String TAG = "DefaultAppsFetcher";
    private List<c> mOnboardingApps;
    private List<c> mOnboardingFaces;
    private List<c> mOnboardingTimelineApps;

    private static class DefaultAppsJson {
        Application[] default_locker_items;
        Application[] onboarding_grab_some_apps;
        Application[] onboarding_timeline;
        Application[] onboarding_watchfaces;

        private DefaultAppsJson() {
        }
    }

    public List<c> getOnboardingFaces() {
        return this.mOnboardingFaces;
    }

    public List<c> getOnboardingApps() {
        return this.mOnboardingApps;
    }

    public List<c> getOnboardingTimelineApps() {
        return this.mOnboardingTimelineApps;
    }

    public void fetchAppsFromCloudAsync() {
        new f() {
            public boolean doInBackground() {
                DefaultAppsFetcher.this.fetchAppsFromCloudBlocking();
                return false;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    private void fetchAppsFromCloudBlocking() {
        ContentResolver contentResolver = a.K().getContentResolver();
        try {
            ak.a r = PebbleApplication.r();
            long currentTimeMillis = System.currentTimeMillis() + GET_CONNECTED_DEVICE_TIMEOUT_MS;
            while (r == null && System.currentTimeMillis() < currentTimeMillis) {
                try {
                    com.getpebble.android.common.b.a.f.d(TAG, "fetchAppsFromCloudBlocking: returned null; Sleeping for 100 before checking again...");
                    Thread.sleep(GET_CONNECTED_DEVICE_RETRY_MS);
                } catch (Throwable e) {
                    com.getpebble.android.common.b.a.f.b(TAG, "fetchAppsFromCloudBlocking: Interrupted during sleep in fetchAppsFromCloudBlocking()", e);
                }
                r = PebbleApplication.r();
            }
            if (r == null) {
                com.getpebble.android.common.b.a.f.b(TAG, "fetchAppsFromCloudBlocking: No connected device found after timeout");
                return;
            }
            CharSequence code = r.hwPlatform.getPlatformCode().getCode();
            com.getpebble.android.common.b.a.f.d(TAG, "fetchAppsFromCloudBlocking: Fetching onboarding apps for hardware platform: " + code);
            String R = PebbleApplication.w().R();
            if (code != null) {
                R = R.replace(PLACEHOLDER_HARDWARE_ID, code);
            }
            com.getpebble.android.common.b.a.f.d(TAG, "fetchAppsFromCloudBlocking: URL: " + R);
            x a = com.getpebble.android.d.a.a(a.K(), R, HTTP_REQUEST_TIMEOUT_MS, o.class);
            if (com.getpebble.android.d.a.a(a)) {
                DefaultAppsJson defaultAppsJson = (DefaultAppsJson) p.a((o) a.b(), DefaultAppsJson.class);
                List arrayList = new ArrayList();
                try {
                    for (Application cVar : defaultAppsJson.onboarding_watchfaces) {
                        arrayList.add(new c(cVar));
                    }
                    com.getpebble.android.common.b.a.f.d(TAG, "fetchAppsFromCloudBlocking: Found " + arrayList.size() + " onboarding watchfaces");
                } catch (Throwable e2) {
                    com.getpebble.android.common.b.a.f.a(TAG, "fetchAppsFromCloudBlocking: Onboarding URL did not contain onboarding_watchfaces field.", e2);
                }
                this.mOnboardingFaces = arrayList;
                arrayList = new ArrayList();
                try {
                    for (Application cVar2 : defaultAppsJson.onboarding_grab_some_apps) {
                        arrayList.add(new c(cVar2));
                    }
                    com.getpebble.android.common.b.a.f.d(TAG, "fetchAppsFromCloudBlocking: Found " + arrayList.size() + " onboarding apps");
                } catch (NullPointerException e3) {
                    com.getpebble.android.common.b.a.f.a(TAG, "fetchAppsFromCloudBlocking: Onboarding URL did not contain onboarding_grab_some_apps field.");
                }
                this.mOnboardingApps = arrayList;
                arrayList = new ArrayList();
                try {
                    for (Application cVar22 : defaultAppsJson.onboarding_timeline) {
                        arrayList.add(new c(cVar22));
                    }
                    com.getpebble.android.common.b.a.f.d(TAG, "fetchAppsFromCloudBlocking: Found " + arrayList.size() + " onboarding timeline apps");
                } catch (NullPointerException e4) {
                    com.getpebble.android.common.b.a.f.a(TAG, "fetchAppsFromCloudBlocking: Onboarding URL did not contain onboarding_timeline field.");
                }
                this.mOnboardingTimelineApps = arrayList;
                if (!PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.DEFAULT_APPS_ADDED, false)) {
                    try {
                        com.getpebble.android.common.b.a.f.d(TAG, "fetchAppsFromCloudBlocking: Found " + defaultAppsJson.default_locker_items.length + " default apps");
                        for (Application cVar3 : defaultAppsJson.default_locker_items) {
                            try {
                                am.a(contentResolver, new c(cVar3));
                            } catch (Throwable e5) {
                                com.getpebble.android.common.b.a.f.a(TAG, "fetchAppsFromCloudBlocking: error ", e5);
                            }
                        }
                    } catch (NullPointerException e6) {
                        com.getpebble.android.common.b.a.f.a(TAG, "fetchAppsFromCloudBlocking: Onboarding URL did not contain default_locker_items field.");
                    }
                    new com.getpebble.android.framework.install.a.a(a.K()).f();
                    PebbleApplication.v().b();
                    PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.DEFAULT_APPS_ADDED, true);
                    return;
                }
                return;
            }
            com.getpebble.android.common.b.a.f.a(TAG, "fetchAppsFromCloudBlocking: Error getting default watchapps for onboarding");
        } catch (Throwable e52) {
            com.getpebble.android.common.b.a.f.a(TAG, "fetchAppsFromCloudBlocking: Error getting default watchfaces/apps for onboarding", e52);
        } catch (Throwable e522) {
            com.getpebble.android.common.b.a.f.a(TAG, "fetchAppsFromCloudBlocking: Error deserialising json", e522);
        }
    }
}
