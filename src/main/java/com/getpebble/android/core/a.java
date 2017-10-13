package com.getpebble.android.core;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.timeline.e;

public abstract class a extends Activity {
    private String a;
    private ActionBar b = null;
    private FragmentManager c = null;
    private boolean d = false;
    private boolean e = false;

    public void onCreate(Bundle bundle) {
        this.a = getClass().getSimpleName();
        f.d(this.a, "onCreate(" + bundle + ")");
        this.b = getActionBar();
        this.c = getFragmentManager();
        super.onCreate(bundle);
        setContentView(R.layout.activity_pebble_base);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            if (VERSION.SDK_INT >= 21) {
                actionBar.setElevation(0.0f);
            }
        }
    }

    protected void a(int i) {
        if (this.b != null) {
            this.b.setIcon(i);
        }
    }

    protected void b() {
        if (this.b != null) {
            this.b.hide();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                onBackPressed();
                break;
            default:
                f.d(this.a, "Unhandled options item selected");
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void a(Fragment fragment) {
        b(fragment);
    }

    protected final int b(Fragment fragment) {
        f.d(this.a, "switchFragment(" + fragment + ")");
        return a(fragment, false, false, false);
    }

    public final int a(Fragment fragment, boolean z, boolean z2, boolean z3) {
        int i = -1;
        f.d(this.a, "switchFragment(" + fragment + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + z + e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR + z3 + ")");
        if (this.e) {
            f.c(this.a, "Cannot switch, onSaveInstanceState already called");
        } else {
            Fragment c = c();
            if (z || c == null || !c.getClass().getName().equals(fragment.getClass().getName())) {
                FragmentTransaction beginTransaction = this.c.beginTransaction();
                beginTransaction.replace(R.id.grp_fragment_container, fragment);
                if (z3 && beginTransaction.isAddToBackStackAllowed()) {
                    beginTransaction.addToBackStack(fragment.getClass().getName());
                }
                i = beginTransaction.commit();
                if (z2) {
                    this.c.executePendingTransactions();
                }
            } else {
                f.c(this.a, "Cannot switch, same fragment and 'allowSameFragment' is false!");
            }
        }
        return i;
    }

    protected final Fragment c() {
        return this.c != null ? this.c.findFragmentById(R.id.grp_fragment_container) : null;
    }

    public void onStart() {
        f.d(this.a, "onStart()");
        super.onStart();
    }

    public void onResume() {
        f.d(this.a, "onResume()");
        this.e = false;
        super.onResume();
    }

    public void onPause() {
        f.d(this.a, "onPause()");
        super.onPause();
    }

    public void onStop() {
        f.d(this.a, "onStop()");
        super.onStop();
    }

    public void onDestroy() {
        f.d(this.a, "onDestroy()");
        this.b = null;
        this.c = null;
        super.onDestroy();
        this.d = true;
    }

    protected boolean d() {
        return this.d;
    }

    public void onSaveInstanceState(Bundle bundle) {
        f.d(this.a, "onSaveInstanceState(" + bundle + ")");
        this.e = true;
        super.onSaveInstanceState(bundle);
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
    }

    public void onBackPressed() {
        Fragment c = c();
        if (!(c instanceof com.getpebble.android.common.framework.a.a) || !((com.getpebble.android.common.framework.a.a) c).a()) {
            super.onBackPressed();
        } else if (!((com.getpebble.android.common.framework.a.a) c).b()) {
            super.onBackPressed();
        }
    }

    public SharedPreferences getSharedPreferences(String str, int i) {
        return getApplicationContext().getSharedPreferences(str, i);
    }
}
