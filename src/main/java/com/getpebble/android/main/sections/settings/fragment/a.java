package com.getpebble.android.main.sections.settings.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.framework.d;
import com.getpebble.android.main.sections.settings.activity.LanguageSelectionActivity;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import java.io.File;

public class a extends b implements com.getpebble.android.common.framework.a.a {
    private boolean a = false;
    private String b;
    private String c;
    private String d;
    private int e;
    private Uri f;
    private com.getpebble.android.framework.install.a g;
    private ProgressBar h;
    private f i;
    private d j = null;
    private boolean k = false;
    private boolean l = false;
    private com.getpebble.android.framework.b.a m = new com.getpebble.android.framework.b.a(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public void onFrameworkStateChanged(FrameworkState frameworkState) {
            if (frameworkState != null && frameworkState.a() != null) {
                Activity activity = this.a.getActivity();
                if (activity == null) {
                    com.getpebble.android.common.b.a.f.d("LanguageInstallFragment", "Activity is null, dropping event");
                    return;
                }
                switch (frameworkState.a()) {
                    case FILE_INSTALL_COMPLETE:
                        if (this.a.f.equals(frameworkState.j())) {
                            this.a.g.c(this.a.f.toString());
                            this.a.f = null;
                            com.getpebble.android.framework.g.q.a fromValue = com.getpebble.android.framework.g.q.a.fromValue(frameworkState.i());
                            if (fromValue != com.getpebble.android.framework.g.q.a.SUCCESS) {
                                com.getpebble.android.common.b.a.f.a("LanguageInstallFragment", "Error installing file: " + fromValue.toString());
                                Toast.makeText(activity, R.string.language_selection_error_message, 1).show();
                                this.a.a(activity);
                                return;
                            } else if (this.a.isResumed()) {
                                this.a.b(activity);
                                return;
                            } else {
                                com.getpebble.android.common.b.a.f.d("LanguageInstallFragment", "Successfully finished install but fragment is not resumed; caching success");
                                this.a.k = true;
                                return;
                            }
                        }
                        return;
                    case FILE_INSTALL_PROGRESS_CHANGED:
                        com.getpebble.android.common.b.a.f.d("LanguageInstallFragment", "Got file install progress changed");
                        if (this.a.isResumed()) {
                            this.a.h.setProgress(frameworkState.k());
                            return;
                        }
                        return;
                    default:
                        com.getpebble.android.common.b.a.f.c("LanguageInstallFragment", "Dropping event: " + frameworkState.a());
                        return;
                }
            }
        }
    };

    public int c() {
        return R.layout.fragment_language_installing;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context activity = getActivity();
        if (activity == null) {
            com.getpebble.android.common.b.a.f.b("LanguageInstallFragment", "init() activity is null, not initializing");
            return;
        }
        this.a = activity instanceof OnboardingActivity;
        if (!this.a) {
            viewGroup.findViewById(R.id.onboarding_banner).setVisibility(8);
        }
        this.g = new com.getpebble.android.framework.install.a(activity, "languages");
        this.h = (ProgressBar) viewGroup.findViewById(R.id.language_install_progress);
        this.h.setVisibility(4);
        this.j = d();
        a(this.m);
    }

    public void onResume() {
        int i = 1;
        super.onResume();
        final Activity activity = getActivity();
        if (activity == null) {
            com.getpebble.android.common.b.a.f.a("LanguageInstallFragment", "Activity is null; short-circuiting onResume");
        } else if (g()) {
            com.getpebble.android.common.b.a.f.d("LanguageInstallFragment", String.format("Set up language install fragment; language=<%s>, url=<%s>", new Object[]{this.c, this.b}));
            if (this.k) {
                com.getpebble.android.common.b.a.f.d("LanguageInstallFragment", "Fragment resumed in isComplete state; going to next fragment");
                b(activity);
            } else if (this.l) {
                com.getpebble.android.common.b.a.f.d("LanguageInstallFragment", "Language installation is in progress but not yet complete; not downloading file");
            } else {
                int i2;
                if (this.f != null) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 != 0) {
                    com.getpebble.android.common.b.a.f.d("LanguageInstallFragment", "File already downloaded but the install was not completed and is not in progress");
                    f();
                    return;
                }
                if (this.i == null) {
                    i = 0;
                }
                if (i != 0) {
                    com.getpebble.android.common.b.a.f.d("LanguageInstallFragment", "Currently downloading; fragment will be updated when download completes");
                    return;
                }
                this.i = new f(this) {
                    final /* synthetic */ a b;

                    public boolean doInBackground() {
                        com.getpebble.android.common.b.a.f.d("LanguageInstallFragment", "Starting file download...");
                        File a = this.b.g.a(this.b.b, null);
                        if (a == null) {
                            com.getpebble.android.common.b.a.f.a(f.TAG, "mDownloadTask: file is null");
                            return false;
                        }
                        this.b.f = Uri.fromFile(a);
                        com.getpebble.android.common.b.a.f.d("LanguageInstallFragment", "Finished file download successfully; got URI: " + this.b.f);
                        return true;
                    }

                    public void onTaskSuccess() {
                        new Handler(activity.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                if (this.a.b.isResumed()) {
                                    this.a.b.f();
                                } else {
                                    com.getpebble.android.common.b.a.f.c(f.TAG, "Finished downloading file but fragment is not resumed; not starting install");
                                }
                            }
                        });
                        this.b.i = null;
                    }

                    public void onTaskFailed() {
                        this.b.i = null;
                        com.getpebble.android.common.b.a.f.a(f.TAG, "Failed to download language pack");
                        new Handler(activity.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                Toast.makeText(activity, R.string.language_selection_error_message, 1).show();
                            }
                        });
                        this.b.a(activity);
                    }
                };
                this.i.submit();
            }
        } else {
            com.getpebble.android.common.b.a.f.a("LanguageInstallFragment", "Failed to set up fragment; finishing fragment");
            a(activity);
        }
    }

    private void f() {
        com.getpebble.android.common.b.a.f.d("LanguageInstallFragment", "startInstall()");
        this.l = true;
        this.h.setVisibility(0);
        PebbleDevice e = e();
        if (e == null) {
            com.getpebble.android.common.b.a.f.d("LanguageInstallFragment", "Device disconnected; waiting for activity to clean up the fragment");
        } else {
            this.j.a(e, this.f, "lang", this.d, this.e);
        }
    }

    public void onDestroy() {
        b(this.m);
        if (this.i != null) {
            this.i.cancel();
            this.i = null;
        }
        super.onDestroy();
    }

    private boolean g() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            com.getpebble.android.common.b.a.f.a("LanguageInstallFragment", "Cannot install language; no arguments provided to fragment");
            return false;
        } else if (arguments.containsKey("extra_install_language_url")) {
            this.b = arguments.getString("extra_install_language_url");
            if (arguments.containsKey("extra_install_language_name")) {
                this.c = arguments.getString("extra_install_language_name");
                if (arguments.containsKey("extra_install_language_locale")) {
                    this.d = arguments.getString("extra_install_language_locale");
                    if (arguments.containsKey("extra_install_language_version")) {
                        this.e = arguments.getInt("extra_install_language_version");
                        return true;
                    }
                    com.getpebble.android.common.b.a.f.a("LanguageInstallFragment", "Cannot install language; no language version provided");
                    return false;
                }
                com.getpebble.android.common.b.a.f.a("LanguageInstallFragment", "Cannot install language; no locale provided");
                return false;
            }
            com.getpebble.android.common.b.a.f.a("LanguageInstallFragment", "Cannot install language; no user-facing language name provided");
            return false;
        } else {
            com.getpebble.android.common.b.a.f.a("LanguageInstallFragment", "Cannot install language; no URL provided");
            return false;
        }
    }

    void a(com.getpebble.android.framework.b.a aVar) {
        com.getpebble.android.framework.b.a(aVar);
    }

    void b(com.getpebble.android.framework.b.a aVar) {
        com.getpebble.android.framework.b.b(aVar);
    }

    d d() {
        return PebbleApplication.x();
    }

    PebbleDevice e() {
        return PebbleApplication.n();
    }

    private void a(Activity activity) {
        if (this.a) {
            ((OnboardingActivity) activity).i();
            return;
        }
        com.getpebble.android.common.b.a.f.a("LanguageInstallFragment", "Finishing activity");
        activity.finish();
    }

    private void b(Activity activity) {
        Fragment dVar = new d();
        dVar.setArguments(getArguments());
        if (this.a) {
            ((OnboardingActivity) activity).a(dVar);
        } else if (activity instanceof LanguageSelectionActivity) {
            ((LanguageSelectionActivity) activity).a(dVar);
        } else {
            com.getpebble.android.common.b.a.f.a("LanguageInstallFragment", "Finished scene but don't know where to transition; finishing activity");
            activity.finish();
        }
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return this.l || this.i != null;
    }
}
