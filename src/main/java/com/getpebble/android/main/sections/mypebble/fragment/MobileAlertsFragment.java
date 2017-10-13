package com.getpebble.android.main.sections.mypebble.fragment;

import android.app.Activity;
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
import com.getpebble.android.common.a;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.ae;
import com.getpebble.android.main.sections.notifications.a.f;

public class MobileAlertsFragment extends b implements LoaderCallbacks<Cursor> {
    private ListView a;
    private f b;
    private LoaderManager c;

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.c = getLoaderManager();
        if (this.c != null) {
            this.c.initLoader(0, new Bundle(), this);
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        switch (i) {
            case 0:
                return ae.a(a.K());
            default:
                return null;
        }
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        if (this.b == null) {
            this.b = new f(getActivity(), cursor, false);
            this.a.setAdapter(this.b);
        } else {
            this.b.changeCursor(cursor);
        }
        if (!cursor.moveToFirst() || cursor.getCount() == 0) {
            Activity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }

    public int c() {
        return 0;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_mobile_alerts, viewGroup, false);
        this.a = (ListView) inflate.findViewById(R.id.mobile_alerts_list);
        return inflate;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.getpebble.android.common.b.a.f.d("MobileAlertsFragment", "Initializing MobileAlertsFragment");
    }
}
