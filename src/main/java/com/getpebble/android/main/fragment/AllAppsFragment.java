package com.getpebble.android.main.fragment;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.af;
import com.getpebble.android.main.sections.notifications.a.a;

public class AllAppsFragment extends b implements LoaderCallbacks<Cursor> {
    private LoaderManager a;
    private ListView b;
    private a c;

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    public int c() {
        return R.layout.fragment_all_apps;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = (ListView) viewGroup.findViewById(R.id.all_apps_listview);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.a = getLoaderManager();
        if (this.a != null) {
            this.a.initLoader(0, new Bundle(), this);
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        switch (i) {
            case 0:
                return af.a(com.getpebble.android.common.a.K());
            default:
                return null;
        }
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        if (this.c == null) {
            this.c = new a(getActivity(), cursor);
            this.b.setAdapter(this.c);
            return;
        }
        this.c.changeCursor(cursor);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
