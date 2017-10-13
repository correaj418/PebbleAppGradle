package com.getpebble.android.main.sections.support;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;

public class c {
    private static final long SUPPORT_EMAIL_TIMEOUT_MS = 25000;
    private static final String TAG = "SupportEmailManager";
    private a mEmailTimeoutRunnable;
    private Fragment mFragment;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private ProgressDialog mProgressDialog;
    private d mTarget = d.OTHER;
    private String mUserMessage;

    private class a implements Runnable {
        private final b email;

        public a(b bVar) {
            this.email = bVar;
        }

        public void run() {
            if (c.this.mFragment.isAdded()) {
                f.d(c.TAG, "EmailTimeoutRunnable firing: isAdded; calling onEmailReady");
                c.this.onEmailReady(this.email);
                return;
            }
            synchronized (c.this.mFragment) {
                f.d(c.TAG, "EmailTimeoutRunnable firing: !isAdded; removing callbacks but not creating email");
                c.this.mHandler.removeCallbacks(c.this.mEmailTimeoutRunnable);
                c.this.mEmailTimeoutRunnable = null;
            }
        }
    }

    private class b extends ProgressDialog {
        public b(Context context, int i) {
            super(context, i);
        }

        public void onStart() {
            super.onStart();
            f.d(c.TAG, "setting FLAG_KEEP_SCREEN_ON");
            c.this.mFragment.getActivity().getWindow().addFlags(128);
        }

        public void onStop() {
            f.d(c.TAG, "clearing FLAG_KEEP_SCREEN_ON");
            c.this.mFragment.getActivity().getWindow().clearFlags(128);
            super.onStop();
        }
    }

    public c(Fragment fragment) {
        this.mFragment = fragment;
    }

    public synchronized void startSupportEmailTasks(boolean z) {
        startSupportEmailTasks(z, d.OTHER, "");
    }

    public synchronized void startSupportEmailTasks(boolean z, d dVar, String str) {
        f.d(TAG, "Starting support email tasks");
        this.mUserMessage = str;
        this.mTarget = dVar;
        if (this.mEmailTimeoutRunnable != null) {
            f.c(TAG, "Skipping support email request (operations pending)");
        } else if (this.mFragment == null) {
            f.d(TAG, "Fragment is null");
        } else {
            showProgressDialog(this.mFragment.getResources().getString(R.string.support_diagnostics));
            this.mEmailTimeoutRunnable = new a(new b(this.mFragment.getActivity(), z, dVar, new com.getpebble.android.main.sections.support.b.c() {
                public void onComplete(b bVar) {
                    if (c.this.mFragment.isAdded()) {
                        c.this.onEmailReady(bVar);
                    } else {
                        f.c(c.TAG, "E-mail ready, but fragment not added");
                    }
                }

                public void onPing() {
                    synchronized (c.this.mFragment) {
                        if (c.this.mEmailTimeoutRunnable == null) {
                            f.b(c.TAG, "onPing; mEmailTimeoutRunnable is null, not resetting timeout");
                            return;
                        }
                        f.d(c.TAG, "onPing; resetting timeout");
                        c.this.mHandler.removeCallbacks(c.this.mEmailTimeoutRunnable);
                        c.this.mHandler.postDelayed(c.this.mEmailTimeoutRunnable, c.SUPPORT_EMAIL_TIMEOUT_MS);
                    }
                }
            }));
            this.mHandler.postDelayed(this.mEmailTimeoutRunnable, SUPPORT_EMAIL_TIMEOUT_MS);
        }
    }

    private synchronized void onEmailReady(b bVar) {
        if (this.mEmailTimeoutRunnable == null) {
            f.d(TAG, "onEmailReady; already sent email for this task");
        } else {
            this.mHandler.removeCallbacks(this.mEmailTimeoutRunnable);
            this.mEmailTimeoutRunnable = null;
            final Activity activity = this.mFragment.getActivity();
            if (activity == null) {
                f.c(TAG, "Fragment not added, aborting");
            } else {
                try {
                    Intent generateIntent = bVar.generateIntent(this.mTarget, this.mUserMessage);
                    CharSequence string = this.mFragment.getResources().getString(R.string.support_select_an_email_client);
                    generateIntent.setFlags(1);
                    generateIntent = Intent.createChooser(generateIntent, string);
                    generateIntent.setFlags(1);
                    this.mFragment.startActivity(generateIntent);
                } catch (Throwable e) {
                    f.a(TAG, "Unable to launch e-mail for the user", e);
                    activity.runOnUiThread(new Runnable() {
                        public void run() {
                            com.getpebble.android.widget.a.a(activity, c.this.mFragment.getResources().getString(R.string.support_preparing_email_failed), 1);
                        }
                    });
                }
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        c.this.hideProgressDialog();
                    }
                });
            }
        }
    }

    private void showProgressDialog(String str) {
        if (this.mFragment.isAdded()) {
            if (this.mProgressDialog == null) {
                this.mProgressDialog = new b(this.mFragment.getActivity(), 0);
                this.mProgressDialog.setCancelable(false);
            }
            if (!TextUtils.isEmpty(str)) {
                this.mProgressDialog.setMessage(str);
                this.mProgressDialog.show();
            }
        }
    }

    private void hideProgressDialog() {
        if (this.mFragment.isAdded() && this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
        }
    }
}
