package com.getpebble.android.connection;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.bluetooth.Transport;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.model.FrameworkState;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.framework.b;
import com.getpebble.android.framework.b.a;
import com.getpebble.android.h.d;
import com.getpebble.android.onboarding.activity.OnboardingActivity;

public class ConnectionManagerFragment extends Fragment implements LoaderCallbacks<Cursor>, OnClickListener, OnItemClickListener, a {
    protected TextView a;
    protected Button b;
    protected ak.a c;
    protected final Handler d = new Handler(Looper.getMainLooper());
    protected boolean e = false;
    private ProgressBar f;
    private ListView g;
    private boolean h;
    private boolean i = false;
    private CursorAdapter j;

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    private void h() {
        LoaderManager loaderManager = getLoaderManager();
        if (loaderManager != null) {
            loaderManager.initLoader(42, new Bundle(), this);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 98765) {
            Transport from = Transport.from(i2);
            f.e("ConnectionManagerFragment", "onActivityResult requestCode = " + i + " resultCode = " + i2 + " transport = " + from);
            PebbleApplication.x().a(from);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_connection_manager, viewGroup, false);
        this.f = (ProgressBar) inflate.findViewById(R.id.discovery_progress_bar_normal);
        this.b = (Button) inflate.findViewById(R.id.btn_discover);
        this.b.setOnClickListener(this);
        this.a = (TextView) inflate.findViewById(R.id.connect_to_another_pebble);
        this.g = (ListView) inflate.findViewById(R.id.list);
        this.g.setOnItemClickListener(this);
        this.g.setDivider(new ColorDrawable(getResources().getColor(R.color.connection_manager_bg)));
        this.g.setDividerHeight(1);
        this.g.setFastScrollEnabled(true);
        this.h = false;
        i();
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.j = null;
    }

    public void onResume() {
        super.onResume();
        h();
        b.a((a) this);
        f.d("ConnectionManagerFragment", "onResume()");
        j();
        if ((this.j != null ? 1 : null) != null && this.j.isEmpty() && !b.b().b()) {
            f.d("ConnectionManagerFragment", "Done loading adapter, no devices, and not discovering; starting discovery");
            k();
        }
    }

    private void i() {
        if (PebbleApplication.n() == null && !d.a(getActivity().getApplication())) {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
        }
    }

    public void onPause() {
        b.b(this);
        super.onPause();
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String str = "connection_status DESC, last_connected_time DESC, rssi DESC, friendly_name ASC";
        switch (i) {
            case 42:
                return new CursorLoader(getActivity(), ak.TABLE_URI, ak.ALL_FIELDS_PROJECTION, null, null, "connection_status DESC, last_connected_time DESC, rssi DESC, friendly_name ASC");
            default:
                return null;
        }
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        Context activity = getActivity();
        if (activity == null) {
            f.d("ConnectionManagerFragment", "Activity is null, ignoring onLoadFinished");
            return;
        }
        f.d("ConnectionManagerFragment", "onLoadFinished() size = " + cursor.getCount() + " mCursorAdapter = " + this.j);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                ak.a pebbleDeviceRecordFromCursor = ak.getPebbleDeviceRecordFromCursor(cursor);
                if (pebbleDeviceRecordFromCursor.connectionStatus == com.getpebble.android.b.d.CONNECTED) {
                    f.e("ConnectionManagerFragment", "onLoadFinished() connected device found : " + pebbleDeviceRecordFromCursor.pebbleDevice);
                    this.c = pebbleDeviceRecordFromCursor;
                    m();
                    a();
                }
            }
            cursor.move(-1);
        }
        if (this.j == null) {
            this.j = new b(activity, cursor, activity instanceof OnboardingActivity);
            this.g.setAdapter(this.j);
            if (this.j.isEmpty()) {
                FrameworkState b = b.b();
                if (b == null ? false : b.b()) {
                    f.d("ConnectionManagerFragment", "onLoadFinished: cursor is empty, but discovery is already in progress");
                } else {
                    f.d("ConnectionManagerFragment", "Empty adapter and not discovering; starting discovery");
                    k();
                }
            }
        } else {
            this.j.changeCursor(cursor);
        }
        j();
    }

    protected void a() {
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }

    public void onClick(View view) {
        if (view != this.b) {
            return;
        }
        if (d.a(getActivity().getApplication())) {
            k();
        } else {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
        }
    }

    protected ProgressBar b() {
        return this.f;
    }

    private void j() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            f.a("ConnectionManagerFragment", "Cannot update UI!");
            return;
        }
        FrameworkState b = b.b();
        if (b == null || !b.b()) {
            d();
        } else {
            c();
        }
        m();
    }

    protected void c() {
        b().setVisibility(0);
        this.b.setText(getString(R.string.connection_manager_stop_searching));
    }

    protected void d() {
        b().setVisibility(8);
        this.b.setText(getString(R.string.connection_manager_find_a_new_pebble));
    }

    private void k() {
        FrameworkState b = b.b();
        com.getpebble.android.framework.d x = PebbleApplication.x();
        if (b == null || x == null) {
            f.a("ConnectionManagerFragment", "FrameworkState or FrameworkInterface was null -- failed to toggle discovery");
            Toast.makeText(com.getpebble.android.common.a.K(), getString(R.string.something_went_wrong_message), 0).show();
        } else if (b.b()) {
            x.c();
        } else {
            e();
        }
    }

    protected void e() {
        this.d.post(new Runnable(this) {
            final /* synthetic */ ConnectionManagerFragment a;

            {
                this.a = r1;
            }

            public void run() {
                if (this.a.isResumed()) {
                    c a = c.a();
                    a.setTargetFragment(this.a, 98765);
                    a.show(this.a.getFragmentManager(), "selector");
                    return;
                }
                f.b("ConnectionManagerFragment", "Cannot show watch selector, fragment is no longer resumed");
            }
        });
    }

    public void onFrameworkStateChanged(FrameworkState frameworkState) {
        if (frameworkState != null) {
            FrameworkState.a a = frameworkState.a();
            if (a != null) {
                switch (a) {
                    case DISCOVERY_STATE_CHANGED:
                        this.d.post(new Runnable(this) {
                            final /* synthetic */ ConnectionManagerFragment a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                this.a.j();
                            }
                        });
                        return;
                    case BLUETOOTH_STATE_CHANGED:
                        if (!frameworkState.c()) {
                            l();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void l() {
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.j == null) {
            f.b("ConnectionManagerFragment", "Null cursor adapter; dropping click");
        } else if (d.a(getActivity().getApplication())) {
            Cursor cursor = (Cursor) this.j.getItem(i);
            if (cursor == null) {
                f.b("ConnectionManagerFragment", "Null cursor at position " + i + "; dropping click");
                return;
            }
            ak.a pebbleDeviceRecordFromCursor = ak.getPebbleDeviceRecordFromCursor(cursor);
            switch (pebbleDeviceRecordFromCursor.connectionStatus) {
                case CONNECTED:
                    if (g()) {
                        f.d("ConnectionManagerFragment", "Device is connected; disconnect");
                        c(pebbleDeviceRecordFromCursor.pebbleDevice, pebbleDeviceRecordFromCursor.connectionStatus);
                        return;
                    }
                    return;
                case CONNECTING:
                    if (!pebbleDeviceRecordFromCursor.connectionGoal.equals(com.getpebble.android.b.a.DISCONNECT) && g()) {
                        f.d("ConnectionManagerFragment", "Device is connecting; cancel by disconnecting");
                        c(pebbleDeviceRecordFromCursor.pebbleDevice, pebbleDeviceRecordFromCursor.connectionStatus);
                        return;
                    }
                    return;
                case DISCONNECTED:
                    f.d("ConnectionManagerFragment", "Device is disconnected; connecting");
                    a(pebbleDeviceRecordFromCursor.pebbleDevice, pebbleDeviceRecordFromCursor.connectionStatus);
                    return;
                default:
                    f.c("ConnectionManagerFragment", "Unknown connection status; requesting connection");
                    a(pebbleDeviceRecordFromCursor.pebbleDevice, pebbleDeviceRecordFromCursor.connectionStatus);
                    return;
            }
        } else {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
        }
    }

    protected boolean f() {
        return true;
    }

    protected boolean g() {
        return true;
    }

    private void a(PebbleDevice pebbleDevice, com.getpebble.android.b.d dVar) {
        boolean a = new c(com.getpebble.android.common.a.K()).a(c.a.NAGGED_ABOUT_CONNECT_IS_DISCONNECT, false);
        boolean z = PebbleApplication.n() != null;
        if (a || !z || !f()) {
            this.g.setSelection(0);
            a(pebbleDevice);
            PebbleApplication.x().a(pebbleDevice);
        } else if (!this.i) {
            b(pebbleDevice, dVar);
        }
    }

    private void b(final PebbleDevice pebbleDevice, com.getpebble.android.b.d dVar) {
        int i;
        int i2;
        this.i = true;
        f.d("ConnectionManagerFragment", "showConnectIsDisconnectConfirmationDialog");
        if (dVar == com.getpebble.android.b.d.CONNECTING) {
            i = R.string.connection_manager_dialog_nag_connect_will_cancel_title;
            i2 = R.string.connection_manager_dialog_nag_connect_will_cancel_text;
        } else {
            i = R.string.connection_manager_dialog_nag_connect_will_disconnect_title;
            i2 = R.string.connection_manager_dialog_nag_connect_will_disconnect_text;
        }
        Context activity = getActivity();
        if (activity != null) {
            final c cVar = new c(activity.getApplicationContext());
            new Builder(activity).setTitle(i).setMessage(i2).setPositiveButton(getString(R.string.connection_manager_dialog_text_connect), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ ConnectionManagerFragment c;

                public void onClick(DialogInterface dialogInterface, int i) {
                    cVar.b(c.a.NAGGED_ABOUT_CONNECT_IS_DISCONNECT, true);
                    this.c.a(pebbleDevice);
                    PebbleApplication.x().a(pebbleDevice);
                    this.c.i = false;
                }
            }).setNegativeButton(getResources().getString(R.string.connection_manager_dialog_text_back), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ ConnectionManagerFragment a;

                {
                    this.a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.a.i = false;
                }
            }).setCancelable(false).show();
        }
    }

    private void a(PebbleDevice pebbleDevice) {
        this.e = d.a(pebbleDevice);
    }

    private void c(PebbleDevice pebbleDevice, com.getpebble.android.b.d dVar) {
        Activity activity = getActivity();
        if (activity == null) {
            f.a("ConnectionManagerFragment", "Received request to disconnect but activity is null; dropping");
        } else if (new c(activity.getApplicationContext()).a(c.a.NAGGED_ABOUT_DISCONNECT, false)) {
            PebbleApplication.x().b(pebbleDevice);
        } else if (!this.i) {
            d(pebbleDevice, dVar);
        }
    }

    private void d(final PebbleDevice pebbleDevice, com.getpebble.android.b.d dVar) {
        int i;
        int i2;
        this.i = true;
        f.d("ConnectionManagerFragment", "showDisconnectConfirmationDialog");
        if (dVar == com.getpebble.android.b.d.CONNECTING) {
            i = R.string.connection_manager_dialog_nag_cancel_connect_title;
            i2 = R.string.connection_manager_dialog_nag_cancel_connect_text;
        } else {
            i = R.string.connection_manager_dialog_nag_disconnect_title;
            i2 = R.string.connection_manager_dialog_nag_disconnect_text;
        }
        Context activity = getActivity();
        if (activity != null) {
            final c cVar = new c(activity.getApplicationContext());
            new Builder(activity).setTitle(i).setMessage(i2).setPositiveButton(getString(R.string.connection_manager_dialog_text_disconnect), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ ConnectionManagerFragment c;

                public void onClick(DialogInterface dialogInterface, int i) {
                    cVar.b(c.a.NAGGED_ABOUT_DISCONNECT, true);
                    PebbleApplication.x().b(pebbleDevice);
                    this.c.i = false;
                }
            }).setNegativeButton(getResources().getString(R.string.disconnect_confirmation_dialog_negative_button), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ ConnectionManagerFragment a;

                {
                    this.a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.a.i = false;
                }
            }).setCancelable(false).show();
        }
    }

    private void m() {
        if (this.j != null) {
            if (this.j.isEmpty()) {
                FrameworkState b = b.b();
                if (b == null || !b.b()) {
                    this.a.setText(R.string.connection_manager_no_pebbles_found);
                } else {
                    this.a.setText(R.string.connection_manager_searching_for_nearby_pebbles);
                }
            } else if (this.c != null) {
                this.a.setText(R.string.connection_manager_connect_different);
            } else {
                this.a.setText(R.string.connection_manager_connect_new);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        PebbleApplication.a((Object) this);
    }
}
