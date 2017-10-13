package com.getpebble.android.main.sections.settings.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.ab;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.ak.a;
import com.getpebble.android.main.sections.settings.activity.LanguageSelectionActivity;
import com.getpebble.android.onboarding.activity.OnboardingActivity;

public class c extends b implements LoaderCallbacks<Cursor> {
    private CursorAdapter a = null;
    private CursorLoader b = null;
    private ListView c;

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    public int c() {
        return R.layout.fragment_language_pack_manager;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.d("LanguagePackManagerFragment", "init()");
        this.c = (ListView) viewGroup.findViewById(R.id.lv_item_list);
        if (!(getActivity() instanceof OnboardingActivity)) {
            viewGroup.findViewById(R.id.onboarding_banner).setVisibility(8);
        }
        this.c.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.a.getActivity() == null) {
                    f.d("LanguagePackManagerFragment", "Handling click event but activity is null; dropping click");
                    return;
                }
                Fragment dVar;
                a r = PebbleApplication.r();
                Cursor cursor = (Cursor) this.a.a.getItem(i);
                String string = cursor.getString(cursor.getColumnIndex("local_language_name"));
                String string2 = cursor.getString(cursor.getColumnIndex("file_url"));
                String string3 = cursor.getString(cursor.getColumnIndex(ak.ISO_LOCALE));
                Bundle a = e.a(string2, string, string3, cursor.getInt(cursor.getColumnIndex(ak.LANGUAGE_VERSION)));
                Object obj = (r == null || !com.getpebble.android.common.b.b.a.a(r.isoLocale, string3)) ? null : 1;
                if (obj != null) {
                    dVar = new d();
                    dVar.setArguments(a);
                } else {
                    dVar = new a();
                    dVar.setArguments(a);
                }
                this.a.a(dVar);
            }
        });
    }

    private void a(Fragment fragment) {
        Activity activity = getActivity();
        if (activity instanceof LanguageSelectionActivity) {
            ((LanguageSelectionActivity) activity).a(fragment);
        } else if (activity instanceof OnboardingActivity) {
            ((OnboardingActivity) activity).a(fragment);
        } else {
            f.a("LanguagePackManagerFragment", "Unknown activity type; cannot switch fragment; finishing activity");
            activity.finish();
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        a r = PebbleApplication.r();
        if (r == null) {
            f.b("LanguagePackManagerFragment", "onCreateLoader: no connected device record");
            return null;
        }
        switch (i) {
            case -1412611295:
                this.b = ab.a(r.hwPlatform, com.getpebble.android.common.a.K());
                break;
        }
        return this.b;
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        Context activity = getActivity();
        if (activity == null) {
            f.d("LanguagePackManagerFragment", "Activity is null; ignoring onLoadFinished");
            return;
        }
        a r = PebbleApplication.r();
        if (this.a == null) {
            this.a = new com.getpebble.android.main.sections.settings.a.a(activity, cursor, r == null ? null : r.isoLocale);
            this.c.setAdapter(this.a);
        } else {
            this.a.changeCursor(cursor);
        }
        if (this.a.isEmpty()) {
            f.a("LanguagePackManagerFragment", "No language packs found, cursor is empty. Exiting language selection");
            if (r != null) {
                f.a("LanguagePackManagerFragment", "> HW platform: " + r.hwPlatform.getName() + " FW version: " + r.getFwVersion());
            }
            if (activity instanceof OnboardingActivity) {
                new Handler(activity.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        Fragment dVar = new d();
                        dVar.setArguments(e.a());
                        this.a.a(dVar);
                    }
                });
                return;
            } else if (activity instanceof LanguageSelectionActivity) {
                Toast.makeText(activity, R.string.language_selection_error_message, 1).show();
                activity.finish();
                return;
            } else {
                f.a("LanguagePackManagerFragment", "Unsupported activity: " + activity.getClass().getSimpleName());
            }
        }
        f.d("LanguagePackManagerFragment", "Loaded cursor of size: " + this.a.getCount());
        com.getpebble.android.common.b.a.a.c.b(this.a.getCount());
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        if (loader == this.b) {
            Cursor cursor = this.a.getCursor();
            if (cursor != null) {
                cursor.close();
            }
            this.a = null;
        }
    }

    public void onAttach(Activity activity) {
        f.d("LanguagePackManagerFragment", "onAttach()");
        super.onAttach(activity);
        activity.runOnUiThread(new Runnable(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.a();
            }
        });
    }

    private void a() {
        f.d("LanguagePackManagerFragment", "initialize()");
        if (getActivity() == null) {
            f.d("LanguagePackManagerFragment", "initialize(); activity is null");
            return;
        }
        LoaderManager loaderManager = getLoaderManager();
        if (loaderManager != null) {
            loaderManager.initLoader(-1412611295, new Bundle(), this);
        }
    }
}
