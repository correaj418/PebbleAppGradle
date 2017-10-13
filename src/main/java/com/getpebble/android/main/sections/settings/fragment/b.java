package com.getpebble.android.main.sections.settings.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.t;
import com.getpebble.android.main.sections.settings.activity.LanguageSelectionActivity;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import java.util.concurrent.TimeUnit;

public class b extends com.getpebble.android.common.framework.a.b {
    private static final long a = TimeUnit.SECONDS.toMillis(10);
    private static final long b = TimeUnit.SECONDS.toMillis(60);
    private Handler c;
    private a d;
    private ContentObserver e;
    private boolean f;
    private Runnable g = new Runnable(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public void run() {
            f.b("LanguagePackLoadingFragment", "Running onLanguagePackSyncComplete after timeout");
            this.a.a(false);
        }
    };

    private class a extends AsyncTask<Void, Void, Long> {
        final /* synthetic */ b a;

        private a(b bVar) {
            this.a = bVar;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            a((Long) obj);
        }

        protected Long a(Void... voidArr) {
            if (this.a.getActivity() == null) {
                return null;
            }
            String str = "pebble_language_packs";
            return Long.valueOf(t.b(this.a.getActivity().getContentResolver(), "pebble_language_packs"));
        }

        protected final void a(Long l) {
            if (isCancelled() || l == null) {
                f.d("LanguagePackLoadingFragment", "onPostExecute failed: cancelled = " + isCancelled() + ", time = " + l);
                return;
            }
            f.d("LanguagePackLoadingFragment", "onPostExecute succeeded: " + l);
            this.a.a(l.longValue());
        }
    }

    public int c() {
        return R.layout.fragment_language_loading;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Activity activity = getActivity();
        if (activity == null) {
            f.b("LanguagePackLoadingFragment", "init() activity is null, not initializing");
            return;
        }
        viewGroup.findViewById(R.id.onboarding_banner).setVisibility(activity instanceof OnboardingActivity ? 0 : 8);
        this.c = new Handler(Looper.getMainLooper());
        this.f = false;
        this.e = new ContentObserver(this, this.c) {
            final /* synthetic */ b a;

            public void onChange(boolean z) {
                onChange(z, null);
            }

            public void onChange(boolean z, Uri uri) {
                f.d("LanguagePackLoadingFragment", "DatabaseSyncModel changed");
                this.a.a();
            }
        };
    }

    public void onResume() {
        super.onResume();
        a();
        getActivity().getContentResolver().registerContentObserver(t.a, true, this.e);
        this.c.postDelayed(this.g, a);
    }

    public void onPause() {
        super.onPause();
        this.d.cancel(false);
        getActivity().getContentResolver().unregisterContentObserver(this.e);
        this.c.removeCallbacks(this.g);
    }

    private void a(Fragment fragment) {
        f.d("LanguagePackLoadingFragment", "Going to fragment: " + fragment.getClass().getName());
        Activity activity = getActivity();
        if (activity instanceof LanguageSelectionActivity) {
            ((LanguageSelectionActivity) activity).a(fragment);
        } else if (activity instanceof OnboardingActivity) {
            ((OnboardingActivity) activity).a(fragment);
        }
    }

    private void a(long j) {
        com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
        if (j > (p == null ? 0 : p.lastConnectedTimeMillis) - b) {
            a(true);
        } else if (!this.f) {
            f.d("LanguagePackLoadingFragment", "Syncing languages");
            PebbleApplication.v().e();
            this.f = true;
        }
    }

    private void a(boolean z) {
        Fragment cVar;
        f.d("LanguagePackLoadingFragment", "onLanguagePackSyncComplete success: " + z);
        getActivity().getContentResolver().unregisterContentObserver(this.e);
        this.c.removeCallbacks(this.g);
        this.d.cancel(false);
        if (z) {
            cVar = new c();
            cVar.setArguments(getArguments());
        } else {
            cVar = new d();
            cVar.setArguments(e.a());
        }
        a(cVar);
    }

    private void a() {
        if (this.d != null) {
            f.d("LanguagePackLoadingFragment", "Cancelling current query");
            this.d.cancel(false);
        }
        f.d("LanguagePackLoadingFragment", "Executing new LanguageRefreshQueryTask");
        this.d = new a();
        this.d.execute(new Void[0]);
    }
}
