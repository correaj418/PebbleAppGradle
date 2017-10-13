package com.getpebble.android.main.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Looper;
import com.getpebble.android.basalt.R;
import com.getpebble.android.main.sections.appstore.fragment.NoConnectivityFragment;
import com.getpebble.android.main.sections.mypebble.fragment.f;
import java.util.HashMap;

public class a {
    private static HashMap<b, a> a;

    public static class a {
        private b a;
        private int b;
        private int c;
        private Bundle d;
        private boolean e;

        public a(b bVar, int i, int i2, boolean z) {
            this.a = bVar;
            this.b = i;
            this.c = i2;
            this.e = z;
        }

        public void a(Bundle bundle) {
            this.d = bundle;
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public boolean c() {
            return this.e;
        }

        public Fragment b(Bundle bundle) {
            Fragment fVar;
            Bundle bundle2;
            switch (this.a) {
                case MY_PEBBLE:
                    fVar = new f();
                    break;
                case APP_STORE_FACES:
                    fVar = new com.getpebble.android.main.sections.appstore.fragment.a();
                    break;
                case APP_STORE_APPS:
                    fVar = new com.getpebble.android.main.sections.appstore.fragment.a();
                    break;
                case APP_STORE_SEARCH:
                    fVar = new com.getpebble.android.main.sections.appstore.fragment.a();
                    break;
                case APP_STORE_APPLICATION:
                    fVar = new com.getpebble.android.main.sections.appstore.fragment.a();
                    break;
                case APP_STORE_DEVELOPER:
                    fVar = new com.getpebble.android.main.sections.appstore.fragment.a();
                    break;
                case NO_NETWORK_CONNECTION:
                    fVar = new NoConnectivityFragment();
                    break;
                default:
                    throw new IllegalStateException("Unable to create a fragment for type: " + this.a);
            }
            if (bundle == null) {
                bundle2 = this.d;
            } else {
                bundle2 = bundle;
            }
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putInt("extra_fragment_type", this.a.ordinal());
            fVar.setArguments(bundle2);
            return fVar;
        }
    }

    public enum b {
        MY_PEBBLE,
        APP_STORE_FACES,
        APP_STORE_APPS,
        APP_STORE_SEARCH,
        DEVELOPER,
        SETTINGS,
        SUPPORT,
        APP_STORE_APPLICATION,
        APP_STORE_DEVELOPER,
        CONNECTION_MANAGER,
        NO_NETWORK_CONNECTION
    }

    public static a a(b bVar) {
        b();
        if (a == null) {
            a();
        }
        return (a) a.get(bVar);
    }

    private static void a() {
        a = new HashMap();
        a.put(b.MY_PEBBLE, new a(b.MY_PEBBLE, R.color.actionbar_bg, R.color.statusbar_bg, false));
        a aVar = new a(b.APP_STORE_FACES, R.color.orange_actionbar_color, R.color.orange_statusbar_color, true);
        Bundle bundle = new Bundle();
        bundle.putInt("extra_store_type", com.getpebble.android.main.sections.appstore.a.a.a.WATCH_FACES.ordinal());
        aVar.a(bundle);
        a.put(b.APP_STORE_FACES, aVar);
        aVar = new a(b.APP_STORE_APPS, R.color.orange_actionbar_color, R.color.orange_statusbar_color, true);
        bundle = new Bundle();
        bundle.putInt("extra_store_type", com.getpebble.android.main.sections.appstore.a.a.a.WATCH_APPS.ordinal());
        aVar.a(bundle);
        a.put(b.APP_STORE_APPS, aVar);
        a.put(b.APP_STORE_SEARCH, new a(b.APP_STORE_SEARCH, R.color.orange_actionbar_color, R.color.orange_statusbar_color, true));
        a.put(b.APP_STORE_APPLICATION, new a(b.APP_STORE_APPLICATION, R.color.orange_actionbar_color, R.color.orange_statusbar_color, true));
        a.put(b.APP_STORE_DEVELOPER, new a(b.APP_STORE_DEVELOPER, R.color.orange_actionbar_color, R.color.orange_statusbar_color, true));
        a.put(b.CONNECTION_MANAGER, new a(b.CONNECTION_MANAGER, R.color.actionbar_bg, R.color.statusbar_bg, false));
        a.put(b.NO_NETWORK_CONNECTION, new a(b.NO_NETWORK_CONNECTION, R.color.actionbar_bg, R.color.statusbar_bg, false));
    }

    public static b a(Fragment fragment) {
        if (fragment == null) {
            return null;
        }
        Bundle arguments = fragment.getArguments();
        if (arguments == null || !arguments.containsKey("extra_fragment_type")) {
            return null;
        }
        return b.values()[arguments.getInt("extra_fragment_type")];
    }

    private static void b() {
        if (!Looper.myLooper().equals(Looper.getMainLooper())) {
            throw new IllegalStateException("Cannot call FragmentMetaData from a non-UI thread.");
        }
    }
}
