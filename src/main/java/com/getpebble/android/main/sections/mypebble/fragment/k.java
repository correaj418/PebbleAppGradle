package com.getpebble.android.main.sections.mypebble.fragment;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.aq;
import com.getpebble.android.common.model.aq.a;
import com.getpebble.android.common.model.at;
import com.getpebble.android.h.v;
import com.getpebble.android.main.sections.mypebble.a.f.f;
import java.util.List;

public class k extends b implements LoaderCallbacks<Cursor>, f {
    private RecyclerView a;
    private com.getpebble.android.main.sections.mypebble.a.f b;
    private String[] c;

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    public int c() {
        return R.layout.fragment_sms_settings;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.getpebble.android.common.b.a.f.d("SmsSettingsFragment", "init()");
        getActivity().setTitle(R.string.sms_settings_title);
        this.a = (RecyclerView) viewGroup.findViewById(R.id.sms_faves_rv);
        this.a.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.b = new com.getpebble.android.main.sections.mypebble.a.f(this, this.a);
        this.a.setAdapter(this.b);
        getLoaderManager().initLoader(0, null, this);
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        com.getpebble.android.common.b.a.f.d("SmsSettingsFragment", "onCreateLoader() id=" + i);
        return aq.a(getActivity());
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        com.getpebble.android.common.b.a.f.d("SmsSettingsFragment", "onLoadFinished() id = " + loader.getId());
        List a = aq.a(cursor);
        this.b.a(a);
        this.c = new String[a.size()];
        for (int i = 0; i < a.size(); i++) {
            this.c[i] = ((a) a.get(i)).a.d;
        }
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        com.getpebble.android.common.b.a.f.d("SmsSettingsFragment", "onLoaderReset() id = " + loader.getId());
    }

    public void a() {
        ((com.getpebble.android.core.a) getActivity()).a(new h(), false, false, true);
    }

    public void a(int i) {
        if (v.a(v.a.CONTACTS)) {
            ((com.getpebble.android.core.a) getActivity()).a(i.a(i, this.c), false, false, true);
            return;
        }
        v.a("SmsSettingsFragment", v.a.CONTACTS, "onAddContactClicked");
        Toast.makeText(getActivity(), "Read contacts permission not granted", 0).show();
    }

    public void a(List<a> list) {
        com.getpebble.android.common.b.a.f.d("SmsSettingsFragment", "onFaveReorder()");
        b(list);
    }

    public void a(a aVar, List<a> list) {
        com.getpebble.android.common.b.a.f.d("SmsSettingsFragment", "onFaveRemoval() uuid=" + aVar.b.toString());
        c.o();
        b(aVar, list);
    }

    private static void b(final List<a> list) {
        new com.getpebble.android.bluetooth.b.f() {
            public boolean doInBackground() {
                aq.a(com.getpebble.android.common.a.K().getContentResolver(), list);
                at.a();
                return true;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    private static void b(final a aVar, final List<a> list) {
        new com.getpebble.android.bluetooth.b.f() {
            public boolean doInBackground() {
                aq.b(com.getpebble.android.common.a.K().getContentResolver(), aVar);
                aq.a(com.getpebble.android.common.a.K().getContentResolver(), list);
                at.a();
                return true;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }
}
