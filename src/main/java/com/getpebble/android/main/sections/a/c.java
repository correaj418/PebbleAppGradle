package com.getpebble.android.main.sections.a;

import android.app.DialogFragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.q;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.model.af;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.g;
import com.getpebble.android.common.model.h;
import com.getpebble.android.h.m;
import com.getpebble.android.main.activity.MainActivity;
import com.getpebble.android.widget.WrapContentLayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class c extends com.getpebble.android.common.framework.a.b implements LoaderCallbacks<Cursor> {
    private Set<String> a;
    private Set<String> b;
    private LayoutInflater c;
    private Handler d;
    private c e;
    private int f;
    private ArrayAdapter<String> g;
    private b h;
    private e i;
    private d j;
    private RecyclerView k;
    private RecyclerView l;
    private RecyclerView m;
    private ListView n;
    private MenuItem o;
    private SearchView p;
    private View q;
    private View r;
    private View s;
    private View t;
    private View u;
    private View v;
    private com.getpebble.android.main.sections.a.a.a.a w = new com.getpebble.android.main.sections.a.a.a.a(this) {
        final /* synthetic */ c a;

        {
            this.a = r1;
        }

        public void a(com.getpebble.android.main.sections.a.a.a aVar, g gVar) {
            DialogFragment a = com.getpebble.android.main.sections.mypebble.fragment.c.a(gVar);
            a.setTargetFragment(this.a, 0);
            a.show(this.a.getActivity().getFragmentManager(), "app_dialog");
        }

        public void b(com.getpebble.android.main.sections.a.a.a aVar, g gVar) {
            new a(this.a, aVar, gVar).submit();
        }

        public void c(com.getpebble.android.main.sections.a.a.a aVar, g gVar) {
            m.a(this.a.getActivity(), gVar.f());
        }
    };

    private static abstract class c<T> implements com.google.a.h.a.a<T> {
        private boolean a = false;

        protected boolean a() {
            return this.a;
        }

        public void b() {
            this.a = true;
        }
    }

    private class a extends f {
        final /* synthetic */ c a;
        private com.getpebble.android.main.sections.a.a.a b;
        private h c;

        public a(c cVar, com.getpebble.android.main.sections.a.a.a aVar, h hVar) {
            this.a = cVar;
            this.b = aVar;
            this.c = hVar;
        }

        public boolean doInBackground() {
            com.getpebble.android.common.b.a.a.c.c(this.c.getTitle(), this.c.getUUID());
            try {
                return am.a(this.a.getActivity().getContentResolver(), this.c);
            } catch (Throwable e) {
                com.getpebble.android.common.b.a.f.d(f.TAG, "AddToLockerTask: doInBackground: could not add to locker", e);
                return false;
            }
        }

        public void onTaskSuccess() {
            PebbleApplication.v().b();
        }

        public void onTaskFailed() {
        }

        protected void onPostExecute(Boolean bool) {
            if (!bool.booleanValue() && this.a.getActivity() != null) {
                Toast.makeText(this.a.getActivity(), R.string.something_went_wrong_message, 0).show();
            }
        }
    }

    private class b extends b {
        final /* synthetic */ c a;

        public b(c cVar) {
            this.a = cVar;
            super(cVar.r, 5);
        }

        public u a(ViewGroup viewGroup, int i) {
            return new com.getpebble.android.main.sections.a.b.a(this.a.c, viewGroup);
        }
    }

    private class d extends b {
        final /* synthetic */ c a;

        public d(c cVar) {
            this.a = cVar;
            super(cVar.s);
        }

        public u a(ViewGroup viewGroup, int i) {
            return new com.getpebble.android.main.sections.a.b.b(this.a.c, viewGroup);
        }
    }

    private class e extends b {
        final /* synthetic */ c a;

        public e(c cVar) {
            this.a = cVar;
            super(cVar.q, 5);
        }

        public u a(ViewGroup viewGroup, int i) {
            return new com.getpebble.android.main.sections.a.b.c(this.a.c, viewGroup);
        }
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    public int c() {
        return R.layout.fragment_universal_search;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        PebbleApplication.v().h();
        a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.getpebble.android.common.b.a.f.d("UniversalSearchFragment", "onCreate()");
        setHasOptionsMenu(true);
        this.c = getActivity().getLayoutInflater();
        this.d = new Handler();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView.g aVar = new com.getpebble.android.ui.a(getActivity(), R.color.dark_gray_2, R.dimen.developer_divider_height);
        this.g = new ArrayAdapter(getActivity(), R.layout.view_trending_search, R.id.search_term);
        this.n = (ListView) view.findViewById(R.id.search_trending_lv);
        this.n.setAdapter(this.g);
        this.n.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.a.b((String) this.a.g.getItem(i));
            }
        });
        this.v = view.findViewById(R.id.search_no_results);
        this.t = view.findViewById(R.id.search_watchfaces_see_all);
        this.q = view.findViewById(R.id.search_watchfaces);
        this.i = new e(this);
        this.k = (RecyclerView) view.findViewById(R.id.search_watchfaces_rv);
        this.k.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.k.setAdapter(this.i);
        this.s = view.findViewById(R.id.search_notifications);
        this.j = new d(this);
        this.l = (RecyclerView) view.findViewById(R.id.search_notifications_rv);
        this.l.setLayoutManager(new WrapContentLayoutManager(getActivity(), R.dimen.search_result_height));
        this.l.a(aVar);
        this.l.setAdapter(this.j);
        this.u = view.findViewById(R.id.search_apps_see_all);
        this.r = view.findViewById(R.id.search_apps);
        this.h = new b(this);
        this.m = (RecyclerView) view.findViewById(R.id.search_apps_rv);
        this.m.setLayoutManager(new WrapContentLayoutManager(getActivity(), R.dimen.search_result_height));
        this.m.a(aVar);
        this.m.setAdapter(this.h);
    }

    public void onResume() {
        com.getpebble.android.common.b.a.f.d("UniversalSearchFragment", "onResume()");
        super.onResume();
        Collection a = PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.TRENDING_SEARCHES, new HashSet());
        this.g.clear();
        this.g.addAll(a);
    }

    public void onPause() {
        com.getpebble.android.common.b.a.f.d("UniversalSearchFragment", "onPause()");
        super.onPause();
    }

    public void onStop() {
        com.getpebble.android.common.b.a.f.d("UniversalSearchFragment", "onStop()");
        d();
        super.onStop();
    }

    public void onDestroy() {
        com.getpebble.android.common.b.a.f.d("UniversalSearchFragment", "onDestroy()");
        if (!(getActivity() == null || getActivity().getLoaderManager() == null)) {
            LoaderManager loaderManager = getActivity().getLoaderManager();
            loaderManager.destroyLoader(163);
            loaderManager.destroyLoader(161);
            loaderManager.destroyLoader(162);
            loaderManager.destroyLoader(164);
        }
        super.onDestroy();
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        com.getpebble.android.common.b.a.f.d("UniversalSearchFragment", "onPrepareOptionsMenu");
        this.o = menu.findItem(R.id.my_pbl_search);
        if (this.o != null) {
            this.p = (SearchView) q.a(this.o);
            this.p.setOnQueryTextListener(new OnQueryTextListener(this) {
                final /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public boolean onQueryTextSubmit(String str) {
                    this.a.p.clearFocus();
                    return false;
                }

                public boolean onQueryTextChange(String str) {
                    this.a.a(str);
                    return false;
                }
            });
        }
    }

    private void b(String str) {
        this.p.setQuery(str, true);
    }

    private void a() {
        LoaderManager loaderManager = getActivity().getLoaderManager();
        loaderManager.restartLoader(163, null, this);
        loaderManager.restartLoader(164, null, this);
    }

    public void a(final String str) {
        Runnable anonymousClass4 = new Runnable(this) {
            final /* synthetic */ c b;

            public void run() {
                this.b.c(str);
            }
        };
        d();
        this.d.postDelayed(anonymousClass4, 200);
    }

    private void c(String str) {
        com.getpebble.android.common.b.a.f.d("UniversalSearchFragment", "doInternalSearch: " + str);
        if (str.length() < 2) {
            this.i.f();
            this.j.f();
            this.h.f();
            this.n.setVisibility(0);
            this.v.setVisibility(8);
            return;
        }
        this.f = 0;
        this.n.setVisibility(8);
        this.i.e();
        this.j.e();
        this.h.e();
        Bundle bundle = new Bundle();
        bundle.putString("search_term", "%" + str + "%");
        LoaderManager loaderManager = getActivity().getLoaderManager();
        loaderManager.restartLoader(161, bundle, this);
        loaderManager.restartLoader(162, bundle, this);
        d(str);
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String string = bundle == null ? null : bundle.getString("search_term");
        com.getpebble.android.common.b.a.f.d("UniversalSearchFragment", "onCreateLoader: " + i + ", search = " + string);
        switch (i) {
            case 161:
                return am.a(getActivity(), string);
            case 162:
                return af.a(getActivity(), string);
            case 163:
                return af.b(getActivity());
            case 164:
                return am.a(getActivity());
            default:
                return null;
        }
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        com.getpebble.android.common.b.a.f.d("UniversalSearchFragment", "onLoadFinished: " + loader.getId());
        Object b;
        Set hashSet;
        switch (loader.getId()) {
            case 161:
                final List d = am.d(cursor);
                this.d.postDelayed(new Runnable(this) {
                    final /* synthetic */ c b;

                    public void run() {
                        this.b.f = this.b.f + 1;
                        this.b.a(d, com.getpebble.android.common.model.am.e.WATCHFACE);
                        this.b.a(d, com.getpebble.android.common.model.am.e.APP);
                    }
                }, 200);
                getActivity().getLoaderManager().destroyLoader(161);
                return;
            case 162:
                this.f++;
                a(cursor);
                return;
            case 163:
                b = af.b(cursor);
                if (this.b != null && b.size() > this.b.size()) {
                    hashSet = new HashSet(b);
                    hashSet.removeAll(this.b);
                    this.h.a(hashSet);
                }
                this.b = b;
                return;
            case 164:
                b = am.a(cursor);
                if (this.a != null && b.size() < this.a.size()) {
                    hashSet = this.a;
                    hashSet.removeAll(b);
                    this.i.a(hashSet);
                    this.h.a(hashSet);
                }
                this.a = b;
                return;
            default:
                return;
        }
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        com.getpebble.android.common.b.a.f.d("UniversalSearchFragment", "onLoaderReset: " + loader.getId());
    }

    private void a(Cursor cursor) {
        cursor.moveToPosition(-1);
        List arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(new com.getpebble.android.main.sections.a.a.c(af.a(cursor)));
        }
        this.j.e();
        a(this.j, arrayList);
    }

    private void a(List<com.getpebble.android.common.model.am.c> list, com.getpebble.android.common.model.am.e eVar) {
        List arrayList = new ArrayList();
        a((List) list, eVar, arrayList);
        if (eVar == com.getpebble.android.common.model.am.e.WATCHFACE) {
            a(this.i, arrayList);
        } else {
            a(this.h, arrayList);
        }
    }

    private void d(final String str) {
        a a = a.a(PebbleApplication.w());
        com.getpebble.android.main.sections.a.a.a c = new com.getpebble.android.main.sections.a.a.a.a("universal-search").a().b().c();
        this.e = new c<g[]>(this) {
            final /* synthetic */ c b;

            public void a(g[] gVarArr) {
                if (!a()) {
                    this.b.f = this.b.f + 1;
                    this.b.a(gVarArr, str);
                }
            }

            public void a(Throwable th) {
                com.getpebble.android.common.b.a.f.b("UniversalSearchFragment", "searchAppStore: onFailure: ", th);
                a(new g[0]);
            }
        };
        a.a(str, 10, c, this.e);
    }

    private void a(g[] gVarArr, final String str) {
        this.t.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c b;

            public void onClick(View view) {
                this.b.a(str, com.getpebble.android.main.sections.appstore.a.a.a.WATCH_FACES);
            }
        });
        this.u.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c b;

            public void onClick(View view) {
                this.b.a(str, com.getpebble.android.main.sections.appstore.a.a.a.WATCH_APPS);
            }
        });
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (g gVar : gVarArr) {
            if (!b(gVar)) {
                if (gVar.h()) {
                    arrayList.add(new com.getpebble.android.main.sections.a.a.a(gVar, this.w, getActivity()));
                } else {
                    arrayList2.add(new com.getpebble.android.main.sections.a.a.a(gVar, this.w, getActivity()));
                }
            }
        }
        com.getpebble.android.common.b.a.f.d("UniversalSearchFragment", "onAppStoreSearchFinished: watchapps = " + arrayList2.size() + ", watchfaces = " + arrayList.size());
        this.i.b(arrayList);
        this.h.b(arrayList2);
        b();
    }

    private void a(String str, com.getpebble.android.main.sections.appstore.a.a.a aVar) {
        MainActivity mainActivity = (MainActivity) getActivity();
        Bundle bundle = new Bundle();
        bundle.putInt("extra_store_type", aVar.ordinal());
        bundle.putString("extra_query", str);
        mainActivity.a(com.getpebble.android.main.fragment.a.b.APP_STORE_SEARCH, bundle);
    }

    private boolean b(g gVar) {
        if ("companion-app".equals(gVar.getType())) {
            if (this.b != null && this.b.contains(gVar.f())) {
                return true;
            }
        } else if (this.a != null && this.a.contains(gVar.getUUID())) {
            return true;
        }
        return false;
    }

    public void a(g gVar) {
        if (!this.i.a(gVar)) {
            this.h.a(gVar);
        }
    }

    private void a(List<com.getpebble.android.common.model.am.c> list, com.getpebble.android.common.model.am.e eVar, List<com.getpebble.android.main.sections.a.a.d> list2) {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < list.size(); i++) {
            com.getpebble.android.common.model.am.c cVar = (com.getpebble.android.common.model.am.c) list.get(i);
            if (eVar.equals(cVar.d)) {
                if (cVar.j()) {
                    z = false;
                    z2 = true;
                } else if (cVar.i()) {
                    z = true;
                    z2 = false;
                } else {
                    com.getpebble.android.main.sections.a.a.b bVar = new com.getpebble.android.main.sections.a.a.b(cVar, true, getActivity());
                    if (!(z2 || r3)) {
                        list2.add(bVar);
                        if (list2.size() >= 5) {
                            return;
                        }
                    }
                }
            }
        }
    }

    private void a(b bVar, List<com.getpebble.android.main.sections.a.a.d> list) {
        com.getpebble.android.common.b.a.f.d("UniversalSearchFragment", "updateSearchAdapter: data = " + list);
        bVar.a((List) list);
        b();
    }

    private void b() {
        int i = 0;
        if (this.f == 3) {
            int i2;
            if (this.i.a() > 0 || this.j.a() > 0 || this.h.a() > 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            View view = this.v;
            if (i2 != 0) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    private void d() {
        this.d.removeCallbacksAndMessages(null);
        if (this.e != null) {
            this.e.b();
        }
    }
}
