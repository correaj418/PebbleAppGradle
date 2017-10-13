package com.getpebble.android.main.sections.appstore.fragment;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.q;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.SearchView.OnSuggestionListener;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.e;
import com.getpebble.android.common.model.f;
import com.getpebble.android.h.h;
import com.getpebble.android.h.m;
import com.getpebble.android.main.activity.MainActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class a extends b implements com.getpebble.android.common.framework.a.a {
    private WebView a;
    private MenuItem b;
    private String c;
    private String d;
    private boolean e = false;
    private Handler f;
    private Runnable g;
    private MenuItem h;
    private SearchView i;
    private List<f> j = new ArrayList();
    private String k;
    private String l;
    private com.getpebble.android.main.sections.appstore.a.a.a m = com.getpebble.android.main.sections.appstore.a.a.a.UNSUPPORTED;

    private class a extends com.getpebble.android.e.b {
        final /* synthetic */ a a;

        private a(a aVar) {
            this.a = aVar;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        protected void a(String str, JSONObject jSONObject) {
            if ("addToLocker".equals(str)) {
                this.a.a(jSONObject, true);
            } else if ("loadAppToDeviceAndLocker".equals(str)) {
                this.a.a(jSONObject);
            } else if ("setNavBarTitle".equals(str)) {
                this.a.e = com.getpebble.android.e.a.b(jSONObject);
                a(jSONObject, this.a.a, this.a);
                this.a.g();
            } else if ("openURL".equals(str)) {
                b(jSONObject, this.a.a, this.a);
            } else if ("closeScreen".equals(str)) {
                this.a.b(jSONObject);
            } else if ("setVisibleApp".equals(str)) {
                this.a.d = com.getpebble.android.e.a.a(jSONObject);
                this.a.c = com.getpebble.android.e.a.c(jSONObject);
            } else {
                com.getpebble.android.common.b.a.f.b("JsBridgeWebClient", "Got unhandled JsBridge method: " + str);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public int c() {
        return R.layout.fragment_webview;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c.d("AppStore");
        this.a = (WebView) viewGroup.findViewById(R.id.webView);
        File dir = getActivity().getDir("appstore", 0);
        if (!(dir.exists() || dir.mkdirs())) {
            com.getpebble.android.common.b.a.f.a("AppStoreFragment", "Could not create AppStore appcache directory");
        }
        this.a.getSettings().setDomStorageEnabled(true);
        this.a.getSettings().setAllowFileAccess(true);
        this.a.getSettings().setAppCachePath(dir.getPath());
        this.a.getSettings().setAppCacheEnabled(true);
        this.a.getSettings().setCacheMode(-1);
        viewGroup.findViewById(R.id.progressbar).setVisibility(8);
        this.f = new Handler();
    }

    public void onStart() {
        super.onStart();
        a(getArguments());
        i();
        j();
    }

    public void onResume() {
        super.onResume();
        Activity activity = getActivity();
        if (activity != null && (activity instanceof MainActivity)) {
            ActionBar actionBar = activity.getActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setSubtitle(null);
        }
        if (this.a != null) {
            this.a.resumeTimers();
        }
        e();
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.a != null) {
            com.getpebble.android.common.b.a.f.d("AppStoreFragment", "Low Memory: Switching To Software Layer Type");
            this.a.setLayerType(1, null);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        d();
        Activity activity = getActivity();
        if (activity != null && (activity instanceof MainActivity)) {
            ((MainActivity) activity).a(null);
        }
        g();
    }

    private void d() {
        if (this.a != null) {
            this.a.stopLoading();
            this.a.clearAnimation();
            this.a.freeMemory();
            this.a.destroy();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.a != null) {
            this.a.pauseTimers();
        }
    }

    private void e() {
        Context activity = getActivity();
        if (activity == null) {
            com.getpebble.android.common.b.a.f.a("AppStoreFragment", "updateFragmentForConnectionStatus(): Activity was null");
        } else if (!h.a(activity) && (activity instanceof MainActivity)) {
            ((MainActivity) activity).a(new NoConnectivityFragment(), false, false, true);
        }
    }

    public void onStop() {
        super.onStop();
        f();
    }

    private void f() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getApplicationContext().getSystemService("input_method");
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    private void g() {
        com.getpebble.android.common.b.a.f.d("AppStoreFragment", "Has Share Button = " + this.e);
        if (this.b != null) {
            this.b.setVisible(this.e);
        }
    }

    private void a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("callbackId", 0);
            jSONObject.put("methodName", "search");
            jSONObject.put("query", str);
            jSONObject.put("data", new JSONObject());
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.a("AppStoreFragment", "openSearchPage - JSONException:", e);
        }
        String format = String.format("javascript:PebbleBridge.handleRequest(%s);", new Object[]{jSONObject.toString()});
        if (VERSION.SDK_INT >= 19) {
            this.a.evaluateJavascript(format, null);
        } else {
            this.a.loadUrl(format);
        }
    }

    private void a(f fVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("callbackId", 0);
            jSONObject.put("methodName", "navigate");
            jSONObject.put("url", com.getpebble.android.main.sections.appstore.a.a.a(com.getpebble.android.main.sections.appstore.a.a.a.APPLICATION, fVar.getId()));
            jSONObject.put("via", "native-search");
            jSONObject.put("data", new JSONObject());
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.a("AppStoreFragment", "openSearchPage - JSONException:", e);
        }
        String format = String.format("javascript:PebbleBridge.handleRequest(%s);", new Object[]{jSONObject.toString()});
        if (VERSION.SDK_INT >= 19) {
            this.a.evaluateJavascript(format, null);
        } else {
            this.a.loadUrl(format);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.app_store_menu, menu);
        this.h = menu.findItem(R.id.menu_search);
        this.i = (SearchView) q.a(this.h);
        this.b = menu.findItem(R.id.menu_share);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    private void h() {
        if (this.h != null && this.i != null) {
            this.h.setOnActionExpandListener(new OnActionExpandListener(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public boolean onMenuItemActionExpand(MenuItem menuItem) {
                    c.l();
                    return true;
                }

                public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                    if (this.a.g != null) {
                        this.a.f.removeCallbacks(this.a.g);
                    }
                    this.a.j.clear();
                    return true;
                }
            });
            this.i.setOnQueryTextListener(new OnQueryTextListener(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public boolean onQueryTextSubmit(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    this.a.i.clearFocus();
                    this.a.a(str);
                    return true;
                }

                public boolean onQueryTextChange(final String str) {
                    if (!TextUtils.isEmpty(str)) {
                        if (this.a.g != null) {
                            this.a.f.removeCallbacks(this.a.g);
                        }
                        this.a.g = new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 b;

                            public void run() {
                                this.b.a.b(str);
                            }
                        };
                        this.a.f.postDelayed(this.a.g, 150);
                    }
                    return false;
                }
            });
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        this.h = menu.findItem(R.id.menu_search);
        this.b = menu.findItem(R.id.menu_share);
        if (this.i != null) {
            this.i.setQueryHint(getResources().getString(R.string.my_pebble_search_hint));
            this.i.setOnSuggestionListener(new OnSuggestionListener(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public boolean onSuggestionSelect(int i) {
                    return false;
                }

                public boolean onSuggestionClick(int i) {
                    if (this.a.j.get(i) != null) {
                        this.a.a((f) this.a.j.get(i));
                        this.a.i.clearFocus();
                    } else {
                        Toast.makeText(this.a.getActivity(), R.string.something_went_wrong_message, 0).show();
                    }
                    return true;
                }
            });
            this.i.setSuggestionsAdapter(l());
            ((LinearLayout) this.i.findViewById(this.i.getContext().getResources().getIdentifier("android:id/search_bar", null, null))).setLayoutTransition(new LayoutTransition());
            View findViewById = this.i.findViewById(this.i.getContext().getResources().getIdentifier("android:id/search_plate", null, null));
            if (findViewById != null) {
                findViewById.setBackgroundResource(R.drawable.rounded_rectangle);
                TextView textView = (TextView) findViewById.findViewById(findViewById.getContext().getResources().getIdentifier("android:id/search_src_text", null, null));
                if (textView != null) {
                    textView.setTextColor(getResources().getColor(R.color.white));
                    textView.setHintTextColor(getResources().getColor(R.color.white));
                }
            }
        }
        super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_share:
                m.a(getActivity(), this.d, this.c);
                break;
            case R.id.menu_search:
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.m = com.getpebble.android.main.sections.appstore.a.a.a.values()[bundle.getInt("extra_store_type", com.getpebble.android.main.sections.appstore.a.a.a.UNSUPPORTED.ordinal())];
            this.k = bundle.getString("extra_page_id");
            this.l = bundle.getString("extra_query");
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void i() {
        if (this.a == null) {
            com.getpebble.android.common.b.a.f.a("AppStoreFragment", "configureWebView: Web View was null");
            return;
        }
        this.a.setWebChromeClient(new WebChromeClient());
        this.a.setWebViewClient(new a());
        this.a.getSettings().setJavaScriptEnabled(true);
        this.a.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 1:
                        if (!view.hasFocus()) {
                            view.requestFocus();
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        com.getpebble.android.i.a.a(this.a);
    }

    private void j() {
        if (this.a != null && this.a.getTag() == null) {
            String b;
            final boolean z = !TextUtils.isEmpty(this.l);
            if (z) {
                b = com.getpebble.android.main.sections.appstore.a.a.b(this.m, this.l);
            } else {
                b = com.getpebble.android.main.sections.appstore.a.a.a(this.m, this.k);
            }
            this.f.post(new Runnable(this) {
                final /* synthetic */ a b;

                public void run() {
                    if (!(!z || this.b.i == null || this.b.h == null)) {
                        this.b.h.expandActionView();
                        this.b.i.setQuery(this.b.l, false);
                        this.b.i.clearFocus();
                    }
                    this.b.h();
                }
            });
            this.a.setTag(b);
            this.a.loadUrl(b);
        }
    }

    public boolean a() {
        return this.a != null && this.a.canGoBack();
    }

    public boolean b() {
        if (this.a != null) {
            this.a.goBack();
        }
        return true;
    }

    private e a(JSONObject jSONObject, boolean z) {
        com.getpebble.android.common.model.h d = com.getpebble.android.e.a.d(jSONObject);
        if (d == null) {
            com.getpebble.android.common.b.a.f.a("AppStoreFragment", "Unable to add to locker; bad data.");
            if (z) {
                com.getpebble.android.widget.a.a(getActivity(), getString(R.string.app_store_add_locker_failed), getResources().getColor(R.color.default_err_descr_color));
                com.getpebble.android.e.a.a(jSONObject, "added_to_locker", Boolean.valueOf(false));
                com.getpebble.android.e.a.a(this.a, false, jSONObject);
            }
            return null;
        }
        boolean a;
        c.a((e) d);
        try {
            a = am.a(com.getpebble.android.common.a.K().getContentResolver(), d);
        } catch (Throwable e) {
            com.getpebble.android.common.b.a.f.b("AppStoreFragment", "Error loading app from app store json", e);
            a = false;
        }
        com.getpebble.android.e.a.a(jSONObject, "application_id", d.id);
        PebbleApplication.v().b();
        if (z) {
            if (a) {
                com.getpebble.android.widget.a.a(getActivity(), d.title.toUpperCase(Locale.getDefault()), "", getString(R.string.app_store_add_locker_success), getResources().getColor(R.color.default_orange_color));
                com.getpebble.android.e.a.a(jSONObject, "added_to_locker", Boolean.valueOf(true));
                com.getpebble.android.e.a.a(this.a, true, jSONObject);
            } else {
                com.getpebble.android.widget.a.a(getActivity(), getString(R.string.app_store_add_locker_failed), getResources().getColor(R.color.default_err_descr_color));
                com.getpebble.android.e.a.a(jSONObject, "added_to_locker", Boolean.valueOf(false));
                com.getpebble.android.e.a.a(this.a, false, jSONObject);
            }
        }
        return d;
    }

    private void a(JSONObject jSONObject) {
        if (a(jSONObject, false) != null) {
            a(jSONObject, true, true);
        } else {
            a(jSONObject, false, false);
        }
    }

    private void a(JSONObject jSONObject, boolean z, boolean z2) {
        com.getpebble.android.e.a.a(jSONObject, "added_to_locker", Boolean.valueOf(z));
        com.getpebble.android.e.a.a(jSONObject, "loaded_on_device", Boolean.valueOf(z2));
        com.getpebble.android.e.a.a(this.a, true, jSONObject);
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.getpebble.android.common.b.a.f.d("AppStoreFragment", "handleCloseScreen - methodArgs:" + jSONObject);
            if (a()) {
                b();
            }
            com.getpebble.android.e.a.a(jSONObject, "closed_screen", Boolean.valueOf(true));
            com.getpebble.android.e.a.a(this.a, true, jSONObject);
        }
    }

    private void k() {
        Cursor matrixCursor = new MatrixCursor(new String[]{ai.COLUMN_ID, "app_name", "dev_name", "app_id"});
        String[] strArr = new String[4];
        for (int i = 0; i < this.j.size(); i++) {
            strArr[0] = Integer.toString(i);
            strArr[1] = ((f) this.j.get(i)).getTitle();
            strArr[2] = ((f) this.j.get(i)).a();
            strArr[3] = ((f) this.j.get(i)).getId();
            matrixCursor.addRow(strArr);
        }
        this.i.getSuggestionsAdapter().changeCursor(matrixCursor);
    }

    private SimpleCursorAdapter l() {
        return new SimpleCursorAdapter(getActivity(), R.layout.simple_list_item, null, new String[]{"app_name", "dev_name"}, new int[]{R.id.app_name, R.id.developer_name}, 0);
    }

    private void b(String str) {
        com.getpebble.android.main.sections.a.a.a(PebbleApplication.w()).b(str, 5, new com.getpebble.android.main.sections.a.a.a.a("appstore-search").a().b().a(this.m).c(), new com.google.a.h.a.a<f[]>(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void a(f[] fVarArr) {
                this.a.j.clear();
                this.a.j.addAll(Arrays.asList(fVarArr));
                this.a.k();
            }

            public void a(Throwable th) {
                com.getpebble.android.common.b.a.f.b("AppStoreFragment", "doSearchRequest: onFailure: ", th);
            }
        });
    }
}
