package com.getpebble.android.main.sections.mypebble.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import java.util.concurrent.TimeUnit;

public class g extends DialogFragment {
    private static final long a = TimeUnit.SECONDS.toMillis(13);
    private Handler b = new Handler(Looper.getMainLooper());
    private Runnable c = new Runnable(this) {
        final /* synthetic */ g a;

        {
            this.a = r1;
        }

        public void run() {
            f.d("ProgressDialogFragment", "mTimeoutRunnable running");
            Context activity = this.a.getActivity();
            if (activity == null || activity.isFinishing()) {
                f.c("ProgressDialogFragment", "mTimeoutRunnable; activity is null");
                return;
            }
            this.a.dismiss();
            Toast.makeText(activity, R.string.app_install_unsuccessful, 1).show();
        }
    };

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog progressDialog = new ProgressDialog(getActivity(), getTheme());
        progressDialog.setMessage(getString(R.string.loading_settings));
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(0);
        progressDialog.getWindow().setGravity(17);
        setCancelable(true);
        this.b.postDelayed(this.c, a);
        return progressDialog;
    }

    public void onDestroyView() {
        super.onDestroyView();
        f.d("ProgressDialogFragment", "onDestroyView()");
        this.b.removeCallbacks(this.c);
    }

    public static void a(FragmentManager fragmentManager) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.addToBackStack(null);
        new g().show(beginTransaction, "progress_dialog");
    }

    public static void b(FragmentManager fragmentManager) {
        f.d("ProgressDialogFragment", "dismiss()");
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag("progress_dialog");
        if (findFragmentByTag != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.remove(findFragmentByTag);
            beginTransaction.commitAllowingStateLoss();
        }
    }
}
