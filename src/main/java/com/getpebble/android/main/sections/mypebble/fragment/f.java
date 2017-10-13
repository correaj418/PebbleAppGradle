package com.getpebble.android.main.sections.mypebble.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ac;
import android.support.v4.view.q;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.format.DateUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.model.AppInfo;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.a.o;
import com.getpebble.android.common.model.ae;
import com.getpebble.android.common.model.af;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.ap;
import com.getpebble.android.core.provider.PebbleContentProvider;
import com.getpebble.android.font.CustomTypefaceSpan;
import com.getpebble.android.main.activity.AllAppsActivity;
import com.getpebble.android.main.activity.ConnectionManagerActivity;
import com.getpebble.android.main.activity.DeveloperConnectionActivity;
import com.getpebble.android.main.activity.MainActivity;
import com.getpebble.android.main.activity.SettingsActivity;
import com.getpebble.android.main.activity.SupportActivity;
import com.getpebble.android.main.sections.mypebble.activity.HealthSettingsActivity;
import com.getpebble.android.main.sections.mypebble.activity.MobileAlertsActivity;
import com.getpebble.android.main.sections.mypebble.view.SlidingTabLayout;
import com.getpebble.android.widget.PebbleViewPager;
import com.melnykov.fab.FloatingActionButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class f extends com.getpebble.android.common.framework.a.b implements LoaderCallbacks<Cursor> {
    private static final Handler M = new Handler(Looper.getMainLooper());
    private static final Uri[] N = new Uri[]{o.a, com.getpebble.android.common.model.a.d.b};
    private static final long a = TimeUnit.SECONDS.toMillis(5);
    private static final long b = TimeUnit.MINUTES.toMillis(2);
    private static final long c = TimeUnit.MINUTES.toMillis(60);
    private static final Interpolator d = new AccelerateDecelerateInterpolator();
    private static final NavigableSet<Float> e = new TreeSet(Arrays.asList(new Float[]{Float.valueOf(0.0f), Float.valueOf(90.0f), Float.valueOf(180.0f), Float.valueOf(270.0f), Float.valueOf(360.0f)}));
    private MenuItem A = null;
    private MenuItem B = null;
    private MenuItem C = null;
    private boolean D = false;
    private com.getpebble.android.main.sections.mypebble.d.a E;
    private com.getpebble.android.main.sections.mypebble.d.a F;
    private com.getpebble.android.main.sections.mypebble.d.f G;
    private LoaderCallbacks<com.getpebble.android.main.sections.mypebble.d.c> H;
    private LoaderCallbacks<com.getpebble.android.main.sections.mypebble.d.c> I;
    private LoaderCallbacks<com.getpebble.android.main.sections.mypebble.d.c> J;
    private com.getpebble.android.main.sections.mypebble.d.e K;
    private ContentObserver L;
    private final Runnable O = new Runnable(this) {
        final /* synthetic */ f a;

        {
            this.a = r1;
        }

        public void run() {
            Activity activity = this.a.getActivity();
            if (activity != null) {
                this.a.a(activity);
                f.M.postDelayed(this.a.O, f.a);
            }
        }
    };
    private AnimatorListenerAdapter P = new AnimatorListenerAdapter(this) {
        final /* synthetic */ f a;

        {
            this.a = r1;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            float abs = Math.abs(this.a.u.getRotation()) % 360.0f;
            if (!f.e.contains(Float.valueOf(abs))) {
                float floatValue = ((Float) f.e.higher(Float.valueOf(abs))).floatValue();
                float f = floatValue - abs;
                abs -= ((Float) f.e.lower(Float.valueOf(abs))).floatValue();
                f fVar = this.a;
                if (f >= abs) {
                    f = abs;
                }
                fVar.a(f);
            }
        }
    };
    private RecyclerView[] f = new RecyclerView[g.size()];
    private com.getpebble.android.main.sections.mypebble.a.c[] g = new com.getpebble.android.main.sections.mypebble.a.c[g.size()];
    private List<com.getpebble.android.common.model.am.c>[] h = new ArrayList[g.size()];
    private android.support.v7.widget.RecyclerView.h[] i = new android.support.v7.widget.RecyclerView.h[g.size()];
    private LoaderManager j = null;
    private com.getpebble.android.framework.d k;
    private int l = 0;
    private final List<f> m = new LinkedList();
    private com.getpebble.android.common.framework.install.app.b.a n = com.getpebble.android.common.framework.install.app.b.a.BASALT;
    private com.getpebble.android.main.sections.notifications.a.a o;
    private ListView p;
    private ScrollView q;
    private SlidingTabLayout r;
    private PebbleViewPager s;
    private i t;
    private FloatingActionButton u;
    private boolean v;
    private ViewPropertyAnimator w;
    private SearchView x = null;
    private LinearLayout y;
    private MenuItem z = null;

    class a implements LoaderCallbacks<com.getpebble.android.main.sections.mypebble.d.c> {
        protected final com.getpebble.android.main.sections.mypebble.d.a a;
        final /* synthetic */ f b;

        public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
            a(loader, (com.getpebble.android.main.sections.mypebble.d.c) obj);
        }

        public a(f fVar, com.getpebble.android.main.sections.mypebble.d.a aVar) {
            this.b = fVar;
            this.a = aVar;
        }

        public Loader<com.getpebble.android.main.sections.mypebble.d.c> onCreateLoader(int i, Bundle bundle) {
            return new com.getpebble.android.main.sections.mypebble.d.d(com.getpebble.android.common.a.K(), this.b.a(i));
        }

        public void a(Loader<com.getpebble.android.main.sections.mypebble.d.c> loader, com.getpebble.android.main.sections.mypebble.d.c cVar) {
            com.getpebble.android.common.b.a.f.d("HealthChartDataLoaderCallback", "onLoadFinished() [" + this.a.b.key + "]");
            this.a.a(cVar);
        }

        public void onLoaderReset(Loader<com.getpebble.android.main.sections.mypebble.d.c> loader) {
            com.getpebble.android.common.b.a.f.d("HealthChartDataLoaderCallback", "onLoadReset()");
            this.a.a(null);
        }
    }

    private class b extends ContentObserver {
        final /* synthetic */ f a;

        public b(f fVar, Activity activity) {
            this.a = fVar;
            super(new Handler(activity.getMainLooper()));
        }

        public void onChange(boolean z) {
            onChange(z, null);
        }

        public void onChange(boolean z, Uri uri) {
            com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "health data onChange: " + uri);
            f.M.removeCallbacks(this.a.O);
            f.M.post(this.a.O);
            if (uri == null) {
                this.a.j.restartLoader(200, null, this.a.H);
                this.a.j.restartLoader(201, null, this.a.I);
                this.a.j.restartLoader(202, null, this.a.J);
                return;
            }
            try {
                String b = PebbleContentProvider.b(uri);
                this.a.j.restartLoader(200, null, this.a.H);
                if ("minute_samples".equals(b)) {
                    this.a.j.restartLoader(202, null, this.a.J);
                } else if (com.getpebble.android.common.model.a.d.a.equals(b)) {
                    this.a.j.restartLoader(201, null, this.a.I);
                }
            } catch (Throwable e) {
                com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "handleContentObserverChange: Unsupported URI", e);
            }
        }
    }

    private static class c implements Runnable {
        private c() {
        }

        public void run() {
            com.getpebble.android.framework.d x = PebbleApplication.x();
            if (x != null) {
                com.getpebble.android.common.b.a.f.e("MyPebbleFragment", "Requesting health sync");
                x.j();
                f.M.postDelayed(this, f.b);
            }
        }
    }

    class d extends a {
        final /* synthetic */ f c;

        public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
            a(loader, (com.getpebble.android.main.sections.mypebble.d.c) obj);
        }

        public void a(Loader<com.getpebble.android.main.sections.mypebble.d.c> loader, com.getpebble.android.main.sections.mypebble.d.c cVar) {
            com.getpebble.android.main.sections.mypebble.d.f fVar = (com.getpebble.android.main.sections.mypebble.d.f) this.a;
            boolean z = cVar != null && cVar.a();
            com.getpebble.android.common.b.a.f.d("HeartRateChartDataLoaderCallback", String.format(Locale.US, "onLoadFinished: visible: %b, isDataAvailable: %b", new Object[]{Boolean.valueOf(fVar.k()), Boolean.valueOf(z)}));
            if (!z) {
                fVar.j();
            } else if (r4) {
                super.a(loader, cVar);
            } else {
                fVar.i();
                fVar.h();
            }
        }

        public d(f fVar, com.getpebble.android.main.sections.mypebble.d.f fVar2) {
            this.c = fVar;
            super(fVar, fVar2);
        }
    }

    private enum e {
        FACES(204),
        APPS(205),
        NOTIFICATIONS(206);
        
        private final int loaderId;

        private e(int i) {
            this.loaderId = i;
        }

        static e from(int i) {
            for (e eVar : values()) {
                if (i == eVar.loaderId) {
                    return eVar;
                }
            }
            throw new IllegalStateException("Invalid loader id: " + i);
        }
    }

    private enum f {
        FACES(true),
        APPS(true),
        NOTIFICATIONS(false),
        HEALTH(false);
        
        private final boolean showFab;

        private f(boolean z) {
            this.showFab = z;
        }
    }

    private enum g {
        FACES(0),
        APPS(1);
        
        private final int index;

        private g(int i) {
            this.index = i;
        }

        int index() {
            return this.index;
        }

        static int size() {
            return values().length;
        }
    }

    private static class h extends com.getpebble.android.bluetooth.b.f {
        private final com.getpebble.android.common.model.am.c a;
        private final int b;
        private final int c;
        private final List<com.getpebble.android.common.model.am.c> d;
        private final com.getpebble.android.common.model.am.e e;

        h(com.getpebble.android.common.model.am.c cVar, int i, int i2, List<com.getpebble.android.common.model.am.c> list, com.getpebble.android.common.model.am.e eVar) {
            this.a = cVar;
            this.b = i;
            this.c = i2;
            this.d = list;
            this.e = eVar;
        }

        public boolean doInBackground() {
            am.a(this.a, this.b, this.c, this.d, this.e, com.getpebble.android.common.a.K().getContentResolver());
            f.n();
            return true;
        }

        public void onTaskSuccess() {
        }

        public void onTaskFailed() {
        }
    }

    public class i extends ac {
        final /* synthetic */ f a;
        private ArrayList<View> b;
        private ArrayList<Integer> c;
        private ArrayList<SpannableString> d;
        private int[] e = new int[this.b.size()];

        public i(f fVar, ArrayList<View> arrayList, ArrayList<SpannableString> arrayList2, ArrayList<Integer> arrayList3) {
            this.a = fVar;
            this.b = arrayList;
            this.c = arrayList3;
            this.d = arrayList2;
        }

        public CharSequence a(int i) {
            Drawable drawable = this.a.getResources().getDrawable(((Integer) this.c.get(i)).intValue());
            if (i != this.a.l) {
                drawable.setAlpha(150);
            } else {
                drawable.setAlpha(255);
            }
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            CharSequence spannableString = new SpannableString(" ");
            spannableString.setSpan(new ImageSpan(drawable, 0), 0, 1, 33);
            return spannableString;
        }

        public int a(Object obj) {
            return this.b.indexOf(obj);
        }

        public int a() {
            return this.c.size();
        }

        public Object a(ViewGroup viewGroup, int i) {
            View view = (View) this.b.get(i);
            viewGroup.addView(view, 0);
            return view;
        }

        public void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public boolean a(View view, Object obj) {
            return view.equals(obj);
        }

        public SpannableString c(int i) {
            if (i < 0 || i > this.d.size() - 1) {
                return null;
            }
            return (SpannableString) this.d.get(i);
        }

        void c() {
            this.b.clear();
        }
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    private com.getpebble.android.main.sections.mypebble.d.d.h a(int i) {
        switch (i) {
            case 200:
                return this.K.a();
            case 201:
                return this.K.b();
            case 202:
                return this.K.c();
            default:
                return null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.getpebble.android.common.b.a.f.e("MyPebbleFragment", "onCreate");
        setHasOptionsMenu(true);
    }

    private void g() {
        this.j = getLoaderManager();
        if (this.j == null) {
            com.getpebble.android.common.b.a.f.b("MyPebbleFragment", "initialize: mLoaderManager is null");
            return;
        }
        for (e access$100 : e.values()) {
            a(access$100.loaderId, (LoaderCallbacks) this);
        }
    }

    private void a(int i, LoaderCallbacks loaderCallbacks) {
        Loader loader = this.j.getLoader(i);
        if (loader == null || !loader.isReset()) {
            this.j.initLoader(i, null, loaderCallbacks);
            return;
        }
        com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "initLoader: restarting instead of initing for " + i);
        this.j.restartLoader(i, null, loaderCallbacks);
    }

    private void h() {
        this.r.animate().translationY((float) (-this.r.getMeasuredHeight()));
        this.s.animate().translationY((float) this.s.getRootView().getMeasuredHeight());
        this.u.setVisibility(8);
    }

    private void i() {
        this.r.animate().translationY(0.0f);
        this.s.animate().translationY(0.0f);
        this.u.setVisibility(0);
        if (m()) {
            a(true);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.my_pebble_menu, menu);
        MenuItem findItem = menu.findItem(R.id.my_pbl_alerts);
        if (ae.a(com.getpebble.android.common.a.K().getContentResolver()) == 0) {
            findItem.setVisible(false);
        }
        findItem.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                com.getpebble.android.common.b.a.a.c.j();
                this.a.startActivity(new Intent(this.a.getActivity(), MobileAlertsActivity.class));
                return false;
            }
        });
        this.z = menu.findItem(R.id.my_pbl_search);
        this.x = (SearchView) q.a(this.z);
        this.z.setOnActionExpandListener(new OnActionExpandListener(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                com.getpebble.android.common.b.a.a.c.k();
                this.a.h();
                String name = com.getpebble.android.main.sections.a.c.class.getName();
                if (this.a.getFragmentManager().findFragmentByTag(name) == null) {
                    Fragment cVar = new com.getpebble.android.main.sections.a.c();
                    FragmentTransaction beginTransaction = this.a.getFragmentManager().beginTransaction();
                    beginTransaction.replace(R.id.child_fragment, cVar, name);
                    beginTransaction.commit();
                }
                return true;
            }

            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                this.a.i();
                this.a.getFragmentManager().beginTransaction().remove(this.a.getFragmentManager().findFragmentByTag(com.getpebble.android.main.sections.a.c.class.getName())).setTransition(8194).commitAllowingStateLoss();
                return true;
            }
        });
        this.A = menu.findItem(R.id.my_pbl_support);
        this.A.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                com.getpebble.android.common.b.a.a.g.b();
                this.a.startActivity(new Intent(this.a.getActivity(), SupportActivity.class));
                return false;
            }
        });
        this.B = menu.findItem(R.id.my_pbl_settings);
        this.B.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                com.getpebble.android.common.b.a.a.c.n();
                this.a.startActivity(new Intent(this.a.getActivity(), SettingsActivity.class));
                return false;
            }
        });
        this.C = menu.findItem(R.id.my_pbl_cmf);
        this.C.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.a.startActivity(new Intent(this.a.getActivity(), ConnectionManagerActivity.class));
                return false;
            }
        });
        if (new com.getpebble.android.common.b.b.c(com.getpebble.android.common.a.K()).a(com.getpebble.android.common.b.b.c.a.DEVELOPER_MODE, false)) {
            findItem = menu.findItem(R.id.developer_connection);
            findItem.setVisible(true);
            findItem.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ f a;

                {
                    this.a = r1;
                }

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.a.startActivity(new Intent(this.a.getActivity(), DeveloperConnectionActivity.class));
                    return false;
                }
            });
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        if (this.x != null) {
            this.x.setQueryHint(getResources().getString(R.string.my_pebble_search_hint));
            this.y = (LinearLayout) this.x.findViewById(this.x.getContext().getResources().getIdentifier("android:id/search_bar", null, null));
            this.y.setLayoutTransition(new LayoutTransition());
            View findViewById = this.x.findViewById(this.x.getContext().getResources().getIdentifier("android:id/search_plate", null, null));
            if (findViewById != null) {
                findViewById.setBackgroundResource(R.drawable.rounded_rectangle);
                TextView textView = (TextView) findViewById.findViewById(findViewById.getContext().getResources().getIdentifier("android:id/search_src_text", null, null));
                if (textView != null) {
                    textView.setTextColor(-1);
                    textView.setHintTextColor(-3355444);
                }
            }
        }
        super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.my_pbl_search:
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "init: Initializing MyPebbleFragment");
    }

    public int c() {
        return 0;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.getpebble.android.common.b.a.f.e("MyPebbleFragment", "onCreateView");
        com.getpebble.android.common.b.a.a.c.d("MyPebble");
        return (RelativeLayout) layoutInflater.inflate(R.layout.fragment_my_pebble, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.getpebble.android.common.b.a.f.e("MyPebbleFragment", "onViewCreated");
        g();
        final Context activity = getActivity();
        if (activity == null) {
            com.getpebble.android.common.b.a.f.b("MyPebbleFragment", "onViewCreated: activity was null");
        }
        this.k = PebbleApplication.x();
        this.s = (PebbleViewPager) view.findViewById(R.id.my_view_pager);
        this.f[g.FACES.index()] = new RecyclerView(activity);
        this.i[g.FACES.index()] = new GridLayoutManager(activity, 2);
        this.f[g.FACES.index()].setLayoutManager(this.i[g.FACES.index()]);
        this.f[g.FACES.index()].setBackgroundColor(getResources().getColor(R.color.very_dark_gray_1));
        this.f[g.APPS.index()] = new RecyclerView(activity);
        this.i[g.APPS.index()] = new LinearLayoutManager(activity);
        this.f[g.APPS.index()].setLayoutManager(this.i[g.APPS.index()]);
        this.f[g.APPS.index()].setBackgroundColor(getResources().getColor(R.color.very_dark_gray_1));
        this.p = new ListView(activity);
        this.p.setDivider(new ColorDrawable(getResources().getColor(R.color.dark_gray_2)));
        this.p.setDividerHeight(1);
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(R.layout.notification_listview_footer, this.p, false);
        viewGroup.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ f b;

            public void onClick(View view) {
                this.b.startActivity(new Intent(activity, AllAppsActivity.class));
            }
        });
        this.p.addFooterView(viewGroup, null, false);
        this.p.setBackgroundColor(getResources().getColor(R.color.my_pebble_background_gray));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (p()) {
            arrayList.add(a(getResources().getString(R.string.my_pebble_health_tab_title)));
            this.q = new ScrollView(activity);
            View inflate = layoutInflater.inflate(R.layout.my_pebble_heath_tab, this.q);
            this.q.setBackgroundColor(getResources().getColor(R.color.my_pebble_background_gray));
            this.K = new com.getpebble.android.main.sections.mypebble.d.e(this) {
                final /* synthetic */ f a;

                {
                    this.a = r1;
                }

                public void a(com.getpebble.android.main.sections.mypebble.d.b.c cVar) {
                    switch (cVar) {
                        case ACTIVITY:
                            this.a.j.restartLoader(200, null, this.a.H);
                            return;
                        case SLEEP:
                            this.a.j.restartLoader(201, null, this.a.I);
                            return;
                        case HEART_RATE:
                            this.a.j.restartLoader(202, null, this.a.J);
                            return;
                        default:
                            return;
                    }
                }
            };
            Drawable a = com.getpebble.android.main.sections.mypebble.view.a.a(activity);
            Drawable a2 = com.getpebble.android.main.sections.mypebble.view.a.a(activity);
            Drawable a3 = com.getpebble.android.main.sections.mypebble.view.a.a(activity);
            inflate.findViewById(R.id.health_activity_rounded_frame).setBackgroundDrawable(a);
            inflate.findViewById(R.id.health_sleep_rounded_frame).setBackgroundDrawable(a2);
            inflate.findViewById(R.id.health_heart_rate_rounded_frame).setBackgroundDrawable(a3);
            com.getpebble.android.main.sections.mypebble.d.a.a anonymousClass28 = new com.getpebble.android.main.sections.mypebble.d.a.a(this) {
                final /* synthetic */ f a;

                {
                    this.a = r1;
                }

                public void a() {
                    this.a.s.setPagingEnabled(false);
                }

                public void b() {
                    this.a.s.setPagingEnabled(true);
                }
            };
            this.E = new com.getpebble.android.main.sections.mypebble.d.a(this, com.getpebble.android.main.sections.mypebble.d.b.c.ACTIVITY, this.K, anonymousClass28) {
                final /* synthetic */ f a;

                public void a(Activity activity, View view) {
                    this.e = (TextView) view.findViewById(R.id.health_activity_no_data_textview);
                    this.f = new com.getpebble.android.main.sections.mypebble.d.i((ImageView) view.findViewById(R.id.health_activity_time_widget), this);
                    this.c = (WebView) view.findViewById(R.id.health_activity_webview);
                    f();
                }

                public void a() {
                    super.a();
                    this.a.j.restartLoader(200, null, this.a.H);
                }
            };
            this.F = new com.getpebble.android.main.sections.mypebble.d.a(this, com.getpebble.android.main.sections.mypebble.d.b.c.SLEEP, this.K, anonymousClass28) {
                final /* synthetic */ f a;

                public void a(Activity activity, View view) {
                    this.e = (TextView) view.findViewById(R.id.health_sleep_no_data_textview);
                    this.f = new com.getpebble.android.main.sections.mypebble.d.i((ImageView) view.findViewById(R.id.health_sleep_time_widget), this);
                    this.c = (WebView) view.findViewById(R.id.health_sleep_webview);
                    f();
                }

                public void a() {
                    super.a();
                    this.a.j.restartLoader(201, null, this.a.I);
                }
            };
            this.G = new com.getpebble.android.main.sections.mypebble.d.f(this, com.getpebble.android.main.sections.mypebble.d.b.c.HEART_RATE, this.K, anonymousClass28) {
                final /* synthetic */ f a;

                public void a(Activity activity, View view) {
                    this.f = new com.getpebble.android.main.sections.mypebble.d.i((ImageView) view.findViewById(R.id.health_heart_rate_time_widget), this, EnumSet.of(com.getpebble.android.main.sections.mypebble.d.b.b.DAY, com.getpebble.android.main.sections.mypebble.d.b.b.WEEK));
                    this.h = view.findViewById(R.id.health_heart_rate_card);
                    this.e = (TextView) view.findViewById(R.id.health_heart_rate_no_data_textview);
                    this.c = (WebView) view.findViewById(R.id.health_heart_rate_webview);
                    f();
                }

                public void a() {
                    super.a();
                    this.a.j.restartLoader(202, null, this.a.J);
                }
            };
            this.H = new a(this, this.E);
            this.I = new a(this, this.F);
            this.J = new d(this, this.G);
            this.E.a(activity, inflate);
            this.F.a(activity, inflate);
            this.G.a(activity, inflate);
            this.G.j();
            a(200, this.H);
            a(201, this.I);
            a(202, this.J);
            arrayList2.add(this.q);
            arrayList3.add(Integer.valueOf(R.drawable.health_tab));
            arrayList4.add(getResources().getString(R.string.my_pebble_content_desc_health_tab));
            this.m.add(f.HEALTH);
            this.q.setSmoothScrollingEnabled(true);
            ((ViewGroup) inflate.findViewById(R.id.health_tab_settings_button)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ f b;

                public void onClick(View view) {
                    activity.startActivity(new Intent(activity, HealthSettingsActivity.class));
                }
            });
            this.L = new b(this, activity);
        }
        this.m.add(f.FACES);
        this.m.add(f.APPS);
        this.m.add(f.NOTIFICATIONS);
        arrayList.add(a(getResources().getString(R.string.my_pebble_watchfaces)));
        arrayList.add(a(getResources().getString(R.string.my_pebble_apps_timeline)));
        arrayList.add(a(getResources().getString(R.string.my_pebble_notifications_tab_title)));
        arrayList2.add(this.f[g.FACES.index()]);
        arrayList2.add(this.f[g.APPS.index()]);
        arrayList2.add(this.p);
        arrayList3.add(Integer.valueOf(R.drawable.watchfaces_tab));
        arrayList3.add(Integer.valueOf(R.drawable.apps_tab));
        arrayList3.add(Integer.valueOf(R.drawable.notifications_tab));
        arrayList4.add(getResources().getString(R.string.my_pebble_content_desc_faces_tab));
        arrayList4.add(getResources().getString(R.string.my_pebble_content_desc_apps_tab));
        arrayList4.add(getResources().getString(R.string.my_pebble_content_desc_notifications_tab));
        this.t = new i(this, arrayList2, arrayList, arrayList3);
        this.s.setAdapter(this.t);
        this.r = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        this.r.setContentDescriptions(arrayList4);
        if (VERSION.SDK_INT >= 21) {
            this.r.setElevation(getResources().getDimension(R.dimen.my_pebble_sliding_tab_elevation));
        }
        this.r.setSelectedIndicatorColors(getResources().getColor(R.color.my_pebble_selected_indicator_color));
        this.r.setBackgroundColor(getResources().getColor(R.color.my_pebble_tab_color));
        this.r.setDistributeEvenly(true);
        this.r.a(R.layout.tab_view, R.id.tab_title);
        this.r.setViewPager(this.s);
        this.r.setOnPageChangeListener(new android.support.v4.view.ViewPager.f(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public void a(int i, float f, int i2) {
            }

            public void a(int i) {
                boolean z = i < this.a.l;
                this.a.l = i;
                this.a.a(this.a.getActivity());
                this.a.r.a();
                if (!this.a.m()) {
                    this.a.a(false);
                } else if (!this.a.v) {
                    this.a.a(true);
                }
                this.a.a(z ? -180.0f : 180.0f);
            }

            public void b(int i) {
            }
        });
        this.r.setOnTabStripClickedListener(new com.getpebble.android.main.sections.mypebble.view.SlidingTabLayout.b(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public void a(int i) {
                if ((i == this.a.l ? 1 : 0) != 0) {
                    switch ((f) this.a.m.get(i)) {
                        case FACES:
                            this.a.f[g.FACES.index()].b(0);
                            return;
                        case APPS:
                            this.a.f[g.APPS.index()].b(0);
                            return;
                        case NOTIFICATIONS:
                            this.a.p.smoothScrollToPosition(0);
                            return;
                        case HEALTH:
                            this.a.q.smoothScrollTo(0, 0);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        this.u = (FloatingActionButton) view.findViewById(R.id.floating_action_button);
        this.u.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) this.a.getActivity();
                if (mainActivity == null) {
                    Toast.makeText(this.a.getActivity(), R.string.something_went_wrong_message, 0).show();
                    return;
                }
                switch ((f) this.a.m.get(this.a.l)) {
                    case FACES:
                        mainActivity.a(com.getpebble.android.main.fragment.a.b.APP_STORE_FACES, null);
                        return;
                    case APPS:
                        mainActivity.a(com.getpebble.android.main.fragment.a.b.APP_STORE_APPS, null);
                        return;
                    default:
                        this.a.a(false);
                        com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "onClick: Unhandled Tab Position for FAB.");
                        return;
                }
            }
        });
        a(m(), false);
    }

    private void a(Activity activity) {
        if (activity == null || this.t == null) {
            com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "updateActionBarTitleForPage: Failed to update actionbar title -- activity or pager adapter were null.");
            return;
        }
        ActionBar actionBar = activity.getActionBar();
        if (actionBar == null) {
            com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "updateActionBarTitleForPage: Failed to update actionbar title text -- activity was null");
            return;
        }
        actionBar.setTitle(this.t.c(this.l));
        if (((f) this.m.get(this.l)).equals(f.HEALTH)) {
            String str;
            long q = q();
            if (q < 0) {
                str = "";
            } else {
                int i;
                if (TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - q) < 1) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    str = activity.getResources().getString(R.string.my_pebble_health_updated_just_now);
                } else {
                    str = DateUtils.getRelativeTimeSpanString(q, System.currentTimeMillis(), 60000, 524288).toString().toLowerCase(com.getpebble.android.h.q.b());
                    str = String.format(activity.getResources().getString(R.string.my_pebble_health_updated_at), new Object[]{str});
                }
            }
            actionBar.setSubtitle(a(str));
            return;
        }
        actionBar.setSubtitle("");
    }

    private SpannableString a(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new CustomTypefaceSpan(com.getpebble.android.font.a.a(getActivity())), 0, str.length(), 33);
        return spannableString;
    }

    public void onResume() {
        super.onResume();
        com.getpebble.android.common.b.a.f.e("MyPebbleFragment", "onResume");
        j();
        com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
        if (!(p == null || p.hwPlatform.getPlatformCode().equals(this.n))) {
            this.n = p.hwPlatform.getPlatformCode();
            g();
        }
        Activity activity = getActivity();
        a(activity);
        if (activity != null) {
            ActionBar actionBar = activity.getActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(false);
            }
            activity.invalidateOptionsMenu();
        }
        l();
        a(getArguments());
        if (System.currentTimeMillis() - PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.LAST_LOCKER_SYNC_ATTEMPT_MILLIS, 0) > c) {
            PebbleApplication.v().b();
        } else {
            boolean a = PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.COMPLETED_FIRST_LOCKER_CLOUD_SYNC, false);
            boolean a2 = PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.CLOUD_SYNC_IN_PROGRESS, false);
            if (!(a || a2)) {
                new Builder(getActivity()).setTitle(R.string.my_pebble_problem_fetching_your_apps_title).setMessage(R.string.my_pebble_problem_fetching_your_apps_body).setPositiveButton(getString(R.string.my_pebble_problem_fetching_your_apps_retry), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ f a;

                    {
                        this.a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "onClick: User requested retry locker sync");
                        PebbleApplication.v().b();
                    }
                }).setNegativeButton(getResources().getString(R.string.my_pebble_problem_fetching_your_apps_dont_import), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ f a;

                    {
                        this.a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).setCancelable(false).show();
            }
        }
        if (this.E != null) {
            this.E.d();
            this.E.a(com.getpebble.android.common.framework.b.o.a(getActivity()));
            this.j.restartLoader(200, null, this.H);
        }
        if (this.F != null) {
            this.F.d();
            this.F.a(com.getpebble.android.common.framework.b.o.a(getActivity()));
            this.j.restartLoader(201, null, this.I);
        }
        if (this.G != null) {
            this.G.d();
            this.G.a(com.getpebble.android.common.framework.b.o.a(getActivity()));
            this.j.restartLoader(202, null, this.J);
        }
        M.postDelayed(this.O, a);
        new c().run();
    }

    private void j() {
        if (this.L == null) {
            if (p()) {
                com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "registerHealthContentObserver: health enabled, but no observer. Creating it and continuing");
                this.L = new b(this, getActivity());
            } else {
                com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "registerHealthContentObserver: health disabled, no observer, exiting");
                return;
            }
        }
        if (p()) {
            for (Uri uri : N) {
                com.getpebble.android.common.b.a.f.e("MyPebbleFragment", "Registering observer for: " + uri);
                com.getpebble.android.common.a.K().getContentResolver().registerContentObserver(uri, true, this.L);
            }
            return;
        }
        com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "registerHealthContentObserver: health disabled, cleaning up existing observer and exiting");
        k();
        this.L = null;
    }

    private void k() {
        if (this.L != null) {
            com.getpebble.android.common.b.a.f.e("MyPebbleFragment", "Unregistering content observer");
            com.getpebble.android.common.a.K().getContentResolver().unregisterContentObserver(this.L);
        }
    }

    private void l() {
        com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
        if (r != null && r.recoveryFwVersion == null && !r.hwPlatform.isDevBoard()) {
            com.getpebble.android.common.b.a.f.c("MyPebbleFragment", "checkIfPrfInstalled: Showing 'no PRF' warning toast");
            Toast.makeText(getActivity(), R.string.my_pebble_toast_no_prf_installed, 1).show();
        }
    }

    public void onPause() {
        super.onPause();
        com.getpebble.android.common.b.a.f.e("MyPebbleFragment", "onPause: ");
        k();
        M.removeCallbacksAndMessages(null);
        g.b(getFragmentManager());
        if (this.E != null) {
            this.E.e();
        }
        if (this.F != null) {
            this.F.e();
        }
        if (this.G != null) {
            this.G.e();
        }
    }

    public void onDestroyView() {
        int i;
        int i2 = 0;
        com.getpebble.android.common.b.a.f.e("MyPebbleFragment", "onDestroyView");
        for (i = 0; i < this.h.length; i++) {
            this.h[i] = null;
        }
        for (i = 0; i < this.i.length; i++) {
            this.i[i] = null;
        }
        this.o = null;
        for (i = 0; i < this.f.length; i++) {
            if (this.f[i] == null) {
                com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "onDestroyView: mPebbleAppRecyclerView at " + i + " is null");
            } else {
                this.f[i].setAdapter(null);
                this.f[i].setLayoutManager(null);
                this.f[i] = null;
            }
        }
        while (i2 < this.g.length) {
            if (this.g[i2] == null) {
                com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "onDestroyView: mPebbleAppAdapters at " + i2 + " is null");
            } else {
                this.g[i2].e();
                this.g[i2] = null;
            }
            i2++;
        }
        this.q = null;
        if (this.E != null) {
            this.E.g();
            this.E = null;
        }
        if (this.F != null) {
            this.F.g();
            this.F = null;
        }
        if (this.G != null) {
            this.G.g();
            this.G = null;
        }
        this.p.setAdapter(null);
        this.p = null;
        this.r.setViewPager(null);
        this.r = null;
        this.s.setAdapter(null);
        this.s.removeAllViews();
        this.s = null;
        this.t.c();
        this.t = null;
        if (this.w != null) {
            this.w.setListener(null);
            this.w = null;
        }
        this.u = null;
        if (this.y != null) {
            this.y.setLayoutTransition(null);
            this.y = null;
        }
        this.x = null;
        if (this.z != null) {
            this.z.setOnActionExpandListener(null);
            this.z = null;
        }
        this.A = null;
        this.B = null;
        this.C = null;
        super.onDestroyView();
    }

    public void onStop() {
        com.getpebble.android.common.b.a.f.e("MyPebbleFragment", "onStop: ");
        if (this.z != null && this.z.isActionViewExpanded()) {
            this.z.collapseActionView();
        }
        super.onStop();
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "onCreateLoader: Creating loader for tab with id " + i + ".");
        switch (e.from(i)) {
            case FACES:
                return am.a(getActivity(), com.getpebble.android.common.model.am.e.WATCHFACE);
            case APPS:
                return am.a(getActivity(), com.getpebble.android.common.model.am.e.APP);
            case NOTIFICATIONS:
                return af.c(com.getpebble.android.common.a.K());
            default:
                return null;
        }
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        com.getpebble.android.common.model.am.e eVar;
        g gVar;
        com.getpebble.android.common.b.a.f.e("MyPebbleFragment", "onLoadFinished");
        switch (e.from(loader.getId())) {
            case FACES:
                eVar = com.getpebble.android.common.model.am.e.WATCHFACE;
                gVar = g.FACES;
                break;
            case APPS:
                eVar = com.getpebble.android.common.model.am.e.APP;
                gVar = g.APPS;
                break;
            case NOTIFICATIONS:
                if (this.o == null) {
                    this.o = new com.getpebble.android.main.sections.notifications.a.a(getActivity(), cursor);
                    this.p.setAdapter(this.o);
                    return;
                }
                this.o.changeCursor(cursor);
                return;
            default:
                return;
        }
        com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "onLoadFinished: type = " + eVar);
        final int index = gVar.index();
        List a = ((com.getpebble.android.main.sections.mypebble.a.d) loader).a();
        if (this.g[index] == null) {
            this.h[index] = a;
            this.g[index] = new com.getpebble.android.main.sections.mypebble.a.c(getActivity(), this.h[gVar.index()], false, this.f[index], new com.getpebble.android.main.sections.mypebble.a.c.d(this) {
                final /* synthetic */ f c;

                public void a(com.getpebble.android.common.model.am.c cVar, int i, int i2, List<com.getpebble.android.common.model.am.c> list) {
                    if (i != i2) {
                        this.c.h[index] = list;
                        com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "onLoadFinished: app reorder: " + cVar.c + " orig = " + i + " new = " + i2 + " type = " + eVar);
                        com.getpebble.android.common.b.a.a.c.a(cVar, i, i2);
                        new h(cVar, i, i2, this.c.h[index], eVar).submit();
                    }
                }
            }, this.i[index], 2, eVar);
            this.f[index].setAdapter(this.g[index]);
        } else if (a(this.h[index], a)) {
            this.h[index] = a;
            this.g[index].a(this.h[index]);
        } else {
            com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "onLoadFinished: List does not require refresh type = " + eVar);
        }
    }

    private boolean m() {
        return ((f) this.m.get(this.l)).showFab;
    }

    private void a(boolean z) {
        a(z, true);
    }

    private void a(boolean z, boolean z2) {
        float f = 1.0f;
        this.v = z;
        if (z2) {
            float f2;
            this.w = this.u.animate();
            ViewPropertyAnimator viewPropertyAnimator = this.w;
            if (z) {
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            ViewPropertyAnimator scaleX = viewPropertyAnimator.scaleX(f2);
            if (!z) {
                f = 0.0f;
            }
            scaleX.scaleY(f).setInterpolator(d).setDuration(250).setListener(this.P);
            return;
        }
        this.u.setScaleX(z ? 1.0f : 0.0f);
        FloatingActionButton floatingActionButton = this.u;
        if (!z) {
            f = 0.0f;
        }
        floatingActionButton.setScaleY(f);
    }

    private void a(float f) {
        this.w = this.u.animate();
        this.w.rotationBy(f).setInterpolator(d).setDuration(250).setListener(this.P);
    }

    private static boolean a(List<com.getpebble.android.common.model.am.c> list, List<com.getpebble.android.common.model.am.c> list2) {
        if (list.size() != list2.size()) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            com.getpebble.android.common.model.am.c cVar = (com.getpebble.android.common.model.am.c) list.get(i);
            com.getpebble.android.common.model.am.c cVar2 = (com.getpebble.android.common.model.am.c) list2.get(i);
            if (!cVar.b.equals(cVar2.b)) {
                return true;
            }
            if (cVar.y != cVar2.y) {
                return true;
            }
            if (cVar.G != cVar2.G) {
                return true;
            }
            if (cVar.v != cVar2.v) {
                return true;
            }
            if (cVar.u != cVar2.u) {
                return true;
            }
            if (!cVar.c.equals(cVar2.c)) {
                return true;
            }
        }
        return false;
    }

    private static void n() {
        com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "sendAppReorderRequestToWatch: Sending app reorder request");
        PebbleApplication.x().i();
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        com.getpebble.android.common.b.a.f.e("MyPebbleFragment", "onLoaderReset");
    }

    private void a(Bundle bundle) {
        final Context activity = getActivity();
        if (activity == null) {
            com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "handleArguments: Activity was null");
        } else if (bundle == null) {
            com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "handleArguments: arguments were null");
        } else {
            Uri uri = (Uri) bundle.getParcelable("extra_sideloading_uri");
            if (uri == null) {
                com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "handleArguments: sideLoadingUri was null");
                return;
            }
            com.getpebble.android.framework.o.d.a from = com.getpebble.android.framework.o.d.a.from(bundle.getInt("extra_sideloading_type", com.getpebble.android.framework.o.d.a.ERROR.code()));
            if (com.getpebble.android.framework.o.d.a.HEALTH_DB.equals(from)) {
                Toast.makeText(activity, R.string.health_db_sideload_fail, 1).show();
                com.getpebble.android.common.b.a.f.b("MyPebbleFragment", "Side-loading health DB in release builds is not supported");
                return;
            }
            PebbleDevice n = PebbleApplication.n();
            if (from == com.getpebble.android.framework.o.d.a.APP || from.equals(com.getpebble.android.framework.o.d.a.HEALTH_DB) || n != null) {
                final Uri a = com.getpebble.android.framework.o.d.a((Activity) activity, uri, from);
                String a2 = a(activity, uri);
                switch (from) {
                    case FIRMWARE:
                        com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "handleArguments: sideloading pbz: " + a);
                        ((com.getpebble.android.main.activity.a) activity).a(activity, a, uri.toString(), a2);
                        break;
                    case APP:
                        com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "handleArguments: sideloading pbw: " + a);
                        com.getpebble.android.framework.b.a(new com.getpebble.android.framework.b.a(this) {
                            final /* synthetic */ f c;

                            public void onFrameworkStateChanged(FrameworkState frameworkState) {
                                if (frameworkState == null || frameworkState.a() == null) {
                                    com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "handleArguments: onFrameworkStateChanged: newState or last event was null");
                                } else if (frameworkState.a().equals(com.getpebble.android.common.model.FrameworkState.a.APP_INFO_AVAILABLE)) {
                                    AppInfo h = frameworkState.h();
                                    if (h != null) {
                                        com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "handleArguments: onFrameworkStateChanged: Got app info for: " + h.getShortName());
                                        if (this.c.getFragmentManager() != null) {
                                            this.c.a(activity, a, h);
                                        } else {
                                            com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "handleArguments: onFrameworkStateChanged: Unable to display sideloading dialog: null fragment manager");
                                        }
                                    } else {
                                        com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "handleArguments: onFrameworkStateChanged: Got null appinfo");
                                        Toast.makeText(activity, R.string.fetch_app_info_failed, 1).show();
                                    }
                                    com.getpebble.android.framework.b.b(this);
                                }
                            }
                        });
                        this.k.b(a);
                        break;
                    case LANGUAGE:
                        if (!URLUtil.isNetworkUrl(a.toString())) {
                            com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "handleArguments: sideloading pbl: " + a);
                            a(n, a, a2);
                            break;
                        }
                        com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "handleArguments: not sideloading pbl from webpage: " + a);
                        Toast.makeText(activity, R.string.my_pebble_external_language_pack_not_installed, 1).show();
                        break;
                    case HEALTH_DB:
                        com.getpebble.android.framework.o.d.a(com.getpebble.android.common.a.K(), a, com.getpebble.android.framework.o.d.a.HEALTH_DB);
                        try {
                            com.getpebble.android.common.c.c.a(com.getpebble.android.framework.o.d.a(com.getpebble.android.common.a.K(), a, com.getpebble.android.framework.o.d.a.HEALTH_DB), com.getpebble.android.common.a.K().getDatabasePath("health"));
                            Toast.makeText(activity, R.string.health_db_sideload_success, 1).show();
                            break;
                        } catch (Throwable e) {
                            com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "Failed to copy sideloaded health DB", e);
                            Toast.makeText(activity, R.string.health_db_sideload_fail, 1).show();
                            break;
                        }
                    default:
                        Toast.makeText(activity, R.string.something_went_wrong_message, 1).show();
                        break;
                }
                o();
                return;
            }
            com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "handleArguments: Connected device was null");
            o();
            b((Activity) activity);
        }
    }

    private void o() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.remove("extra_sideloading_uri");
            arguments.remove("extra_sideloading_type");
        }
    }

    private void a(Context context, final Uri uri, AppInfo appInfo) {
        if (context == null) {
            com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "removeSideloadingArguments: Failed to show app sideloading dialog, context was null");
            return;
        }
        new Builder(context).setTitle(getString(R.string.my_pebble_load_external_app)).setMessage(String.format(getString(R.string.my_pebble_external_app_message_snowy), new Object[]{appInfo.getShortName()})).setPositiveButton(getString(R.string.my_pebble_external_app_positive_button), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ f b;

            public void onClick(DialogInterface dialogInterface, int i) {
                com.getpebble.android.framework.b.a(new com.getpebble.android.framework.b.a(this) {
                    final /* synthetic */ AnonymousClass17 a;

                    {
                        this.a = r1;
                    }

                    public void onFrameworkStateChanged(FrameworkState frameworkState) {
                        if (frameworkState == null || frameworkState.a() == null) {
                            com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "removeSideloadingArguments: onFrameworkStateChanged: newState or last event was null");
                        } else if (frameworkState.a().equals(com.getpebble.android.common.model.FrameworkState.a.APP_INSTALL_COMPLETE)) {
                            if (this.a.b.getActivity() != null) {
                                Toast.makeText(this.a.b.getActivity(), frameworkState.g() ? R.string.sideload_app_add_to_locker_success : R.string.sideload_app_add_to_locker_failed, 1).show();
                            }
                            com.getpebble.android.framework.b.b(this);
                        }
                    }
                });
                this.b.k.a(uri);
            }
        }).setNegativeButton(getString(R.string.my_pebble_external_app_negative_button), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).show();
    }

    private void a(PebbleDevice pebbleDevice, Uri uri, String str) {
        com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "displayLanguagePackSideloadingDialog: " + uri);
        final Context activity = getActivity();
        if (activity == null) {
            com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "displayLanguagePackSideloadingDialog: Not displaying dialog; activity is null");
            return;
        }
        final ProgressDialog progressDialog = new ProgressDialog(activity);
        final Uri uri2 = uri;
        final PebbleDevice pebbleDevice2 = pebbleDevice;
        new Builder(activity).setTitle(R.string.my_pebble_load_external_language).setMessage(String.format(getString(R.string.my_pebble_external_language_message), new Object[]{str})).setPositiveButton(R.string.my_pebble_external_app_positive_button, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ f e;

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                progressDialog.setMax(100);
                progressDialog.setMessage(this.e.getString(R.string.text_installing_firmware_version, new Object[]{""}));
                progressDialog.setProgress(0);
                progressDialog.setProgressStyle(1);
                progressDialog.setCancelable(false);
                progressDialog.show();
                Toast.makeText(activity, this.e.getString(R.string.text_installing), 1).show();
                com.getpebble.android.framework.b.a(new com.getpebble.android.framework.b.a(this) {
                    final /* synthetic */ AnonymousClass18 a;

                    {
                        this.a = r1;
                    }

                    public void onFrameworkStateChanged(FrameworkState frameworkState) {
                        if (frameworkState.a() != null) {
                            switch (frameworkState.a()) {
                                case FILE_INSTALL_COMPLETE:
                                    com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "displayLanguagePackSideloadingDialog: registerFrameworkStateEventListener: File install complete");
                                    com.getpebble.android.framework.g.q.a fromValue = com.getpebble.android.framework.g.q.a.fromValue(frameworkState.i());
                                    if (uri2.equals(frameworkState.j())) {
                                        if (fromValue == com.getpebble.android.framework.g.q.a.SUCCESS) {
                                            com.getpebble.android.common.b.a.a.c.a("");
                                            ak.updateLanguageInfo(this.a.e.getActivity().getContentResolver(), PebbleApplication.n(), "", 0);
                                        } else {
                                            com.getpebble.android.common.b.a.a.c.b("");
                                            com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "Error installing file: " + fromValue.toString());
                                            Toast.makeText(activity, R.string.language_selection_error_message, 1).show();
                                        }
                                    }
                                    com.getpebble.android.framework.b.b(this);
                                    progressDialog.dismiss();
                                    return;
                                case FILE_INSTALL_PROGRESS_CHANGED:
                                    com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "displayLanguagePackSideloadingDialog: registerFrameworkStateEventListener: File install progress changed; progress: " + frameworkState.k());
                                    progressDialog.setProgress(frameworkState.k());
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                });
                this.e.k.a(pebbleDevice2, uri2, "lang");
            }
        }).setNegativeButton(R.string.my_pebble_external_app_negative_button, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ f a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setCancelable(true).show();
    }

    private static String a(Context context, Uri uri) {
        if (uri.toString().endsWith(".pbz") || uri.toString().endsWith(".pbl")) {
            String[] split = uri.toString().split("/");
            return split[split.length - 1];
        } else if (com.getpebble.android.framework.o.d.a(uri)) {
            return com.getpebble.android.framework.o.d.a(context.getContentResolver(), uri);
        } else {
            com.getpebble.android.common.b.a.f.d("MyPebbleFragment", "getFileDisplayName: Unable to figure out filename for: " + uri);
            return null;
        }
    }

    private void b(Activity activity) {
        if (activity == null || (activity instanceof MainActivity)) {
            new Builder(activity).setTitle(R.string.my_pebble_no_device_connected).setMessage(R.string.my_pebble_cannot_load_while_disconnected).setPositiveButton(17039370, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ f a;

                {
                    this.a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.a.startActivity(new Intent(this.a.getActivity(), ConnectionManagerActivity.class));
                }
            }).setCancelable(true).show();
        } else {
            com.getpebble.android.common.b.a.f.a("MyPebbleFragment", "displayNoConnectedDeviceDialog: failed to display dialog.");
        }
    }

    private boolean p() {
        return ap.isHealthEnabled();
    }

    private long q() {
        return PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.HEALTH_LAST_SYNC_TIME_MS, -1);
    }
}
