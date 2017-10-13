package com.getpebble.android.onboarding.fragment;

import android.app.Fragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.am.c;
import java.util.List;

public abstract class a extends Fragment implements LoaderCallbacks<Cursor> {
    protected ListView a;
    protected com.getpebble.android.onboarding.a.a b;
    protected LoaderManager c;
    protected List<c> d;

    protected abstract void a();

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.d == null || this.d.size() == 0) {
            f.b("AbstractGrabAppsFragment", "No Onboarding Apps Were Found. Skipping to Next Fragment...");
            a();
            return;
        }
        this.a = (ListView) view.findViewById(R.id.apps_list_view);
        ((ImageButton) view.findViewById(R.id.continue_arrow)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.a();
            }
        });
        this.c = getLoaderManager();
        if (this.c != null) {
            this.c.initLoader(0, new Bundle(), this);
        } else {
            a();
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        switch (i) {
            case 0:
                return am.b(com.getpebble.android.common.a.K());
            default:
                return null;
        }
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        List c = am.c(cursor);
        f.d("AbstractGrabAppsFragment", "onLoadFinished: adding locker UUIDs to adpater (size = " + c.size() + ")");
        this.b.a(c);
        this.b.notifyDataSetChanged();
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }

    public void onDestroy() {
        super.onDestroy();
        PebbleApplication.a((Object) this);
    }
}
