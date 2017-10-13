package com.getpebble.android.core.auth.a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.b.a.b.f;
import com.b.b.x;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.b.e;
import com.getpebble.android.common.b.a.a.d;
import com.getpebble.android.main.sections.appstore.fragment.NoConnectivityFragment;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import com.google.b.o;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class a extends com.getpebble.android.common.framework.a.b implements OnAccountsUpdateListener, f<x<o>>, com.getpebble.android.common.framework.a.a {
    private static final long a = TimeUnit.SECONDS.toMillis(2);
    private WebView b;
    private ProgressBar c;
    private RelativeLayout d;
    private TextView e;
    private ImageButton f;
    private String g = null;
    private String h = null;
    private String i = null;
    private boolean j;
    private View k;
    private Button l;

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    private static class b implements Runnable {
        private b() {
        }

        public void run() {
            com.getpebble.android.common.b.a.f.d("LoginWebViewFragment", "Doing delayed sync registration after account creation");
            PebbleApplication.v().j();
            PebbleApplication.v().a();
        }
    }

    private class c extends com.getpebble.android.e.b {
        final /* synthetic */ a a;
        private final Context b;

        c(a aVar, Context context) {
            this.a = aVar;
            this.b = context.getApplicationContext();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            final String a = a.a(str, "access_token");
            Object a2 = a.a(str, "refresh_token");
            if (TextUtils.isEmpty(a) || TextUtils.isEmpty(a2)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            com.getpebble.android.common.b.a.f.d("LoginWebViewClient", "Found access token; requesting auth data");
            this.a.g = a;
            this.a.h = a2;
            try {
                com.getpebble.android.d.a.a(this.b, true, a, new f<x<o>>(this) {
                    final /* synthetic */ c b;

                    public void a(Exception exception, x<o> xVar) {
                        int i = 0;
                        if (!(xVar == null || xVar.d() == null)) {
                            i = xVar.d().b();
                        }
                        if (exception == null && i == 200) {
                            o oVar = (o) xVar.b();
                            if (oVar == null) {
                                this.b.a.a(-5);
                                com.getpebble.android.common.b.a.f.a("LoginWebViewClient", "onCompleted: result was null");
                                return;
                            }
                            this.b.a.i = oVar.b("email").c();
                            try {
                                com.getpebble.android.d.a.a(this.b.b, false, a, this.b.a, 30000);
                                return;
                            } catch (Throwable e) {
                                com.getpebble.android.common.b.a.f.a("LoginWebViewClient", "Failed to get user data. Re-loading webview.", e);
                                return;
                            }
                        }
                        com.getpebble.android.common.b.a.f.a("LoginWebViewClient", "Failed to get email: " + i, exception);
                        this.b.a.a(-4);
                    }
                }, 30000);
                return true;
            } catch (Throwable e) {
                com.getpebble.android.common.b.a.f.a("LoginWebViewClient", "Error fetching ME data; got access token but no ME data", e);
                this.a.a(-6);
                return true;
            }
        }

        protected void a(String str, JSONObject jSONObject) {
            com.getpebble.android.common.b.a.f.d("LoginWebViewClient", "handleJSBridgeMethods() " + str + " args = " + jSONObject);
            if ("setNavBarTitle".equals(str)) {
                a(jSONObject, this.a.b, this.a);
            } else if ("openURL".equals(str)) {
                b(jSONObject, this.a.b, this.a);
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.a.c.setVisibility(8);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (e.b) {
                this.a.k.setVisibility(0);
                return;
            }
            Activity activity = this.a.getActivity();
            if (activity instanceof OnboardingActivity) {
                Fragment noConnectivityFragment = new NoConnectivityFragment();
                noConnectivityFragment.a(new com.getpebble.android.main.sections.appstore.fragment.NoConnectivityFragment.a(this) {
                    final /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public void a() {
                        this.a.a.b(PebbleApplication.w().f());
                    }
                });
                ((OnboardingActivity) activity).a(noConnectivityFragment, false, false, true);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(false);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public int c() {
        return R.layout.fragment_webview;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (com.getpebble.android.onboarding.activity.b.j()) {
            com.getpebble.android.common.b.a.f.b("LoginWebViewFragment", "init: this screen should not be shown because the user has already logged in. this will failed the automation test");
            f();
        }
        this.d = (RelativeLayout) viewGroup.findViewById(R.id.webview_onboarding_banner);
        this.e = (TextView) this.d.findViewById(R.id.onboarding_banner_text);
        if (getActivity() instanceof OnboardingActivity) {
            this.d.setVisibility(0);
        }
        this.f = (ImageButton) this.d.findViewById(R.id.webview_back_button);
        this.f.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.b();
            }
        });
        this.b = (WebView) viewGroup.findViewById(R.id.webView);
        this.b.getSettings().setDomStorageEnabled(true);
        this.c = (ProgressBar) viewGroup.findViewById(R.id.progressbar);
        this.k = viewGroup.findViewById(R.id.skip_login_banner);
        this.l = (Button) viewGroup.findViewById(R.id.skip_login_button);
        this.l.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                new Builder(this.a.getActivity()).setTitle(this.a.getString(R.string.skip_login)).setMessage(this.a.getString(R.string.skip_login_message)).setPositiveButton(this.a.getString(R.string.skip_login), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 a;

                    {
                        this.a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.getpebble.android.common.b.a.f.c("LoginWebViewFragment", "Skipping login!");
                        this.a.a.e();
                        this.a.a.f();
                    }
                }).setNegativeButton(this.a.getString(R.string.cancel), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 a;

                    {
                        this.a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).setCancelable(false).show();
            }
        });
        b(PebbleApplication.w().f());
    }

    private void e() {
        this.j = false;
        PebbleApplication.u().c();
        d();
        f();
    }

    public static void d() {
        new Handler(Looper.getMainLooper()).postDelayed(new b(), a);
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onAccountsUpdated(Account[] accountArr) {
        com.getpebble.android.common.b.a.f.d("LoginWebViewFragment", "onAccountsUpdated()");
        if (this.j) {
            AccountManager accountManager = AccountManager.get(getActivity().getApplicationContext());
            if (accountManager != null) {
                Account[] accountsByType = accountManager.getAccountsByType("com.getpebble.android.basalt");
                if (accountsByType != null && accountsByType.length > 0) {
                    com.getpebble.android.common.b.a.f.d("LoginWebViewFragment", "Detected login! Go to next fragment");
                    f();
                }
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b(String str) {
        CookieManager.getInstance().removeAllCookie();
        WebSettings settings = this.b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        this.b.setWebViewClient(new c(this, getActivity().getApplicationContext()));
        this.b.setLayerType(1, null);
        com.getpebble.android.i.a.a(this.b);
        this.b.setBackgroundColor(getResources().getColor(R.color.black));
        this.b.loadUrl(str);
    }

    private void a(int i) {
        d.a();
        Context activity = getActivity();
        if (activity == null) {
            com.getpebble.android.common.b.a.f.a("LoginWebViewFragment", "Activity is null; failed to display toast");
            return;
        }
        Toast.makeText(activity, getString(R.string.onboarding_login_failed_message) + " " + i, 1).show();
        this.b.reload();
    }

    public void a(Exception exception, x<o> xVar) {
        if (exception != null) {
            com.getpebble.android.common.b.a.f.a("LoginWebViewFragment", "Error getting account info", exception);
            a(-2);
        } else if (TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.h)) {
            com.getpebble.android.common.b.a.f.a("LoginWebViewFragment", "Failed to retrieve access token");
            a(-1);
        } else {
            o a = com.getpebble.android.common.a.a.a((x) xVar);
            if (a == null) {
                com.getpebble.android.common.b.a.f.a("LoginWebViewFragment", "Failed to login: user was null. Response string: " + xVar);
                a(-3);
                return;
            }
            Object c = a.b("id").c();
            if (TextUtils.isEmpty(c)) {
                com.getpebble.android.common.b.a.f.a("LoginWebViewFragment", "Failed to login: id was null. Response string: " + xVar);
                a(-7);
                return;
            }
            Object c2 = a.b("uid").c();
            if (TextUtils.isEmpty(c2)) {
                com.getpebble.android.common.b.a.f.a("LoginWebViewFragment", "Failed to login: userId was null. Response string: " + xVar);
                a(-8);
                return;
            }
            d.a(this.g);
            this.j = false;
            PebbleApplication.u().a(this.i, "mockpass", this.g, c, c2, this.h);
            d();
            PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.PRIVACY_POLICY_ACCEPTED, true);
            f();
        }
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        if (this.b == null || !this.b.canGoBack()) {
            Activity activity = getActivity();
            if (activity instanceof OnboardingActivity) {
                ((InputMethodManager) activity.getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus() == null ? null : activity.getCurrentFocus().getWindowToken(), 2);
                ((OnboardingActivity) activity).h();
            }
        } else {
            com.getpebble.android.common.b.a.f.d("LoginWebViewFragment", "WebView handleBackPress()");
            this.b.goBack();
        }
        return true;
    }

    private void f() {
        Activity activity = getActivity();
        if (activity instanceof OnboardingActivity) {
            ((OnboardingActivity) activity).i();
        } else {
            com.getpebble.android.common.b.a.f.b("LoginWebViewFragment", "goToNextFragment: activity = " + activity);
        }
    }

    public void a(String str) {
        this.e.setText(str.toUpperCase(Locale.getDefault()));
    }

    static String a(String str, String str2) {
        String str3 = null;
        if (str.startsWith("pebble://login#")) {
            for (String str4 : str.replaceFirst("pebble://login#", "").split("&")) {
                if (str4.startsWith(str2)) {
                    str3 = str4.split("=")[1];
                }
            }
            if (str3 == null) {
                d.a();
                throw new a("Found redirect URI without access_token");
            }
        }
        return str3;
    }
}
