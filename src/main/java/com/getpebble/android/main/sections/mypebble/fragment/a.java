package com.getpebble.android.main.sections.mypebble.fragment;

import android.app.ActionBar;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public abstract class a<Adapter extends com.getpebble.android.main.sections.mypebble.a.a> extends b implements LoaderCallbacks<Cursor> {
    private View a;
    private ListView b;
    private Adapter c;

    protected abstract Adapter a(List<com.getpebble.android.common.model.o.a> list);

    protected abstract boolean a(com.getpebble.android.common.model.o.a aVar);

    protected abstract UUID b();

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
    }

    public int c() {
        return 0;
    }

    protected Adapter a() {
        return this.c;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.d("AbstractCalendarsFragment", "Initializing...");
        this.a = layoutInflater.inflate(R.layout.fragment_abstract_calendars, viewGroup, false);
        ActionBar actionBar = getActivity().getActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(getActivity().getResources().getDrawable(R.color.orange_actionbar_color));
        }
        a(getResources().getColor(R.color.orange_statusbar_color));
        return this.a;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        LoaderManager loaderManager = getLoaderManager();
        if (loaderManager != null) {
            loaderManager.initLoader(22, new Bundle(), this);
        }
        am.a(getActivity().getContentResolver(), b(), true);
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        switch (i) {
            case 22:
                return o.a(getActivity());
            default:
                return null;
        }
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        Collection arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        while (cursor.moveToNext()) {
            com.getpebble.android.common.model.o.a a = o.a(cursor, o.b.LOCAL);
            if (a(a)) {
                if (Pattern.matches("[a-zA-Z0-9_\\.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-\\.]+", a.c)) {
                    arrayList.add(a);
                } else {
                    arrayList2.add(a);
                }
            }
        }
        List arrayList3 = new ArrayList(arrayList);
        arrayList3.addAll(arrayList2);
        if (this.c == null) {
            this.c = a(arrayList3);
            this.b = (ListView) this.a.findViewById(R.id.calendar_settings_list);
            a(this.b);
            return;
        }
        this.c.a(arrayList3);
    }

    protected void a(ListView listView) {
        listView.setAdapter(this.c);
        listView.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!this.a.a().d(i)) {
                    this.a.a().a(view);
                }
            }
        });
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }

    private void a(int i) {
        if (VERSION.SDK_INT >= 21) {
            Window window = getActivity().getWindow();
            if (window != null) {
                window.setStatusBarColor(i);
            }
        }
    }
}
