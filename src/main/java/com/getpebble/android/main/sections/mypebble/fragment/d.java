package com.getpebble.android.main.sections.mypebble.fragment;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.framework.b.n;
import com.getpebble.android.common.framework.widget.AsyncImageView;
import com.getpebble.android.common.model.af;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.am.c;
import com.getpebble.android.common.model.am.e;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.h.m;
import com.getpebble.android.main.activity.MainActivity;
import com.getpebble.android.main.fragment.a.b;
import com.getpebble.android.main.sections.mypebble.a.h;
import com.getpebble.android.main.sections.mypebble.activity.CalendarSettingsActivity;
import com.getpebble.android.main.sections.mypebble.activity.HealthSettingsActivity;
import com.getpebble.android.main.sections.mypebble.activity.RemindersSettingsActivity;
import com.getpebble.android.main.sections.mypebble.activity.SmsSettingsActivity;
import com.getpebble.android.main.sections.mypebble.activity.WeatherSettingsActivity;
import java.util.UUID;

public class d extends b {
    private boolean A;
    private c w;
    private boolean x;
    private boolean y;
    private boolean z;

    private class a extends f {
        final UUID a;
        final com.getpebble.android.common.model.am.a b;
        final boolean c;
        final boolean d;
        final /* synthetic */ d e;

        private a(d dVar, UUID uuid, com.getpebble.android.common.model.am.a aVar, boolean z, boolean z2) {
            this.e = dVar;
            this.a = uuid;
            this.b = aVar;
            this.c = z;
            this.d = z2;
        }

        public boolean doInBackground() {
            Context activity = this.e.getActivity();
            if (activity == null) {
                com.getpebble.android.common.b.a.f.b("DashboardDialogFragment", "Failed to update data source " + this.a.toString() + "; null context");
                return false;
            }
            am.a(activity.getContentResolver(), this.a, this.b, this.c, this.d, false);
            return true;
        }

        public void onTaskSuccess() {
        }

        public void onTaskFailed() {
        }
    }

    public static d a(c cVar, boolean z, boolean z2) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_last_watchface", z);
        bundle.putBoolean("is_in_sync_limit", z2);
        bundle.putParcelable("locker_record", cVar.f());
        dVar.setArguments(bundle);
        dVar.setStyle(1, 0);
        return dVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.x = getArguments().getBoolean("is_last_watchface");
            this.y = getArguments().getBoolean("is_in_sync_limit");
            this.w = new c(getArguments().getParcelable("locker_record"));
        }
    }

    private void a(Button button) {
        if (this.w.a()) {
            String b = this.w.b();
            com.getpebble.android.common.b.a.f.d("DashboardDialogFragment", "Companion app package name: " + b);
            if (af.a(b, getActivity().getContentResolver()) == null) {
                button.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ d a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        try {
                            this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.a.w.p)));
                        } catch (ActivityNotFoundException e) {
                            Toast.makeText(this.a.getActivity(), R.string.my_pebble_cannot_connect_to_google_store, 1).show();
                        }
                    }
                });
                return;
            } else {
                button.setVisibility(8);
                return;
            }
        }
        button.setVisibility(8);
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i = 1;
        super.onViewCreated(view, bundle);
        if (this.w == null) {
            com.getpebble.android.common.b.a.f.b("DashboardDialogFragment", "mLockerApp is null; possible lifecycle issue");
            dismiss();
            return;
        }
        boolean z;
        com.getpebble.android.common.framework.install.app.b.a platformCode = PebbleApplication.p().hwPlatform.getPlatformCode();
        com.getpebble.android.common.model.am.b.a a = this.w.H.a(platformCode);
        final boolean equals = this.w.d.equals(e.WATCHFACE);
        getResources();
        this.f.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!m.a(this.a.getActivity(), this.a.w.c, this.a.w.h)) {
                    Toast.makeText(view.getContext(), this.a.getString(R.string.something_went_wrong_message), 0).show();
                }
            }
        });
        this.a.setText(this.w.c);
        this.b.setText(this.w.i);
        this.b.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                com.getpebble.android.common.b.a.a.c.e("app_by_developer", "MyPebblePopup");
                Activity activity = this.a.getActivity();
                if (this.a.w.j != null && (activity instanceof MainActivity)) {
                    this.a.dismiss();
                    MainActivity mainActivity = (MainActivity) activity;
                    Bundle bundle = new Bundle();
                    bundle.putInt("extra_store_type", com.getpebble.android.main.sections.appstore.a.a.a.DEVELOPER_APPS.ordinal());
                    bundle.putString("extra_page_id", this.a.w.j);
                    mainActivity.a(b.APP_STORE_DEVELOPER, bundle);
                }
            }
        });
        if (!this.w.F) {
            this.r.setVisibility(8);
        }
        if (this.w.F || this.w.z) {
            this.s.setVisibility(8);
            this.t.setVisibility(8);
        } else {
            this.o.setVisibility(8);
            this.d.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ d a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    Activity activity = this.a.getActivity();
                    if (this.a.w.a != null && (activity instanceof MainActivity)) {
                        this.a.dismiss();
                        MainActivity mainActivity = (MainActivity) activity;
                        Bundle bundle = new Bundle();
                        bundle.putInt("extra_store_type", com.getpebble.android.main.sections.appstore.a.a.a.APPLICATION.ordinal());
                        bundle.putString("extra_page_id", this.a.w.a);
                        mainActivity.a(b.APP_STORE_APPLICATION, bundle);
                    }
                }
            });
            this.e.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ d a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    if (!m.b(this.a.getActivity(), this.a.w.k, this.a.w.c)) {
                        this.a.getActivity().runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass7 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                com.getpebble.android.widget.a.a(this.a.a.getActivity(), this.a.a.getResources().getString(R.string.contact_developer_preparing_email_failed), 1);
                            }
                        });
                    }
                }
            });
        }
        if (equals) {
            this.o.setText(com.getpebble.android.common.a.K().getResources().getString(R.string.my_pebble_system_watchface));
        }
        int i2 = (this.w.F && this.w.d.equals(e.WATCHFACE) && !this.w.y) ? 1 : 0;
        boolean equals2 = this.w.b.equals(com.getpebble.android.common.model.am.d.CALENDAR.getUuid());
        boolean equals3 = this.w.b.equals(com.getpebble.android.common.model.am.d.WEATHER.getUuid());
        if (i2 != 0 || equals2 || equals3) {
            this.r.setVisibility(8);
        }
        this.c.setText(String.valueOf(this.w.s));
        View findViewById = view.findViewById(R.id.line);
        a(this.k);
        com.getpebble.android.common.framework.install.app.b.b shape = platformCode.getShape();
        if (this.w.F || this.w.z) {
            this.j.setVisibility(8);
            this.i.setVisibility(8);
            findViewById.setVisibility(8);
            this.c.setVisibility(8);
            this.f.setVisibility(8);
        } else {
            LayoutParams layoutParams;
            com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
            if (p.hwPlatform.getPlatformCode().equals(com.getpebble.android.common.framework.install.app.b.a.CHALK)) {
                layoutParams = (LayoutParams) this.i.getLayoutParams();
                layoutParams.width = com.getpebble.android.common.a.K().getResources().getDimensionPixelSize(R.dimen.my_pebble_dashboard_screenshot_width_chalk);
                this.i.setLayoutParams(layoutParams);
            }
            if (p.hwPlatform.getPlatformCode().equals(com.getpebble.android.common.framework.install.app.b.a.DIORITE)) {
                layoutParams = (LayoutParams) this.j.getLayoutParams();
                layoutParams.width = com.getpebble.android.common.a.K().getResources().getDimensionPixelSize(R.dimen.my_pebble_dashboard_mask_width_diorite);
                this.j.setLayoutParams(layoutParams);
            }
            this.j.setImageResource(a(p.color, p.hwPlatform.getPlatformCode()));
            if (a == null || TextUtils.isEmpty(a.g)) {
                if (a == null || !a.h) {
                    z = false;
                } else {
                    z = true;
                }
                this.i.a((int) R.drawable.watchface_placeholder_icon, n.a(shape, z, 20));
            } else {
                this.i.a(a.g, n.a(shape, a.h, 10), a);
            }
        }
        if (!(a == null || a.h)) {
            this.j.setVisibility(8);
            this.i.setVisibility(8);
            findViewById.setVisibility(8);
            this.c.setVisibility(8);
            this.f.setVisibility(8);
            this.s.setVisibility(8);
        }
        if (equals) {
            if (this.w.F || this.w.z || a == null || !a.h) {
                a(this.w, this.h, a);
            } else {
                this.h.setVisibility(8);
            }
            if (this.w.z) {
                if (a == null || !a.h) {
                    z = false;
                } else {
                    z = true;
                }
                this.h.a((int) R.drawable.watchface_placeholder_icon, n.a(shape, z, 15));
            }
            if (this.w.h()) {
                this.v.setVisibility(0);
            }
            this.p.setVisibility(8);
            this.q.setVisibility(8);
        } else {
            if (this.w.t) {
                this.z = this.w.u;
                a();
                this.m.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ d a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        boolean z;
                        d dVar = this.a;
                        if (this.a.z) {
                            z = false;
                        } else {
                            z = true;
                        }
                        dVar.z = z;
                        this.a.a();
                        new a(this.a.w.b, com.getpebble.android.common.model.am.a.PINS, this.a.z, this.a.A).execute(new Void[0]);
                    }
                });
                this.A = this.w.v;
                b();
                this.n.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ d a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        boolean z;
                        d dVar = this.a;
                        if (this.a.A) {
                            z = false;
                        } else {
                            z = true;
                        }
                        dVar.A = z;
                        this.a.b();
                        new a(this.a.w.b, com.getpebble.android.common.model.am.a.REMINDERS_AND_NOTIFICATIONS, this.a.z, this.a.A).execute(new Void[0]);
                    }
                });
            } else {
                this.p.setVisibility(8);
                this.q.setVisibility(8);
            }
            a(this.w, this.h, a);
        }
        if (this.x || this.w.F) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        int i3;
        if (this.w.F || this.w.H.b(PebbleApplication.p().hwPlatform.getPlatformCode())) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (!(this.w.x && this.y && r3 != 0 && this.w.h())) {
            i = 0;
        }
        if (!this.y) {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
        }
        if (i == 0 && i2 == 0) {
            this.u.setVisibility(8);
        } else {
            if (i != 0) {
                a(this.g, R.drawable.popup_settings_icon, R.string.my_pebble_settings, new OnClickListener(this) {
                    final /* synthetic */ d a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.dismiss();
                        d.a(this.a.getActivity(), this.a.w);
                    }
                });
            }
            if (i2 != 0) {
                a(this.g, R.drawable.popup_delete_icon, R.string.my_pebble_delete, new OnClickListener(this) {
                    final /* synthetic */ d b;

                    public void onClick(View view) {
                        com.getpebble.android.common.b.a.f.d("DashboardDialogFragment", "Deleting " + this.b.w.c + " (" + this.b.w.b + ") invoking sync");
                        new f(this) {
                            final /* synthetic */ AnonymousClass11 a;

                            {
                                this.a = r1;
                            }

                            public boolean doInBackground() {
                                this.a.b.w.a(com.getpebble.android.common.a.K());
                                PebbleApplication.v().b();
                                return true;
                            }

                            public void onTaskSuccess() {
                            }

                            public void onTaskFailed() {
                            }
                        }.submit();
                        if (equals) {
                            Toast.makeText(this.b.getActivity(), String.format(this.b.getString(R.string.my_pebble_deleted_watchface), new Object[]{this.b.w.c}), 0).show();
                        } else {
                            Toast.makeText(this.b.getActivity(), String.format(this.b.getString(R.string.my_pebble_deleted_watchapp), new Object[]{this.b.w.c}), 0).show();
                        }
                        this.b.dismiss();
                    }
                });
            }
        }
        if (!equals || r3 == 0 || !this.w.h() || this.w.y) {
            this.v.setVisibility(8);
        } else {
            this.l.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ d a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    boolean z;
                    c a = this.a.w;
                    ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
                    if (this.a.y) {
                        z = false;
                    } else {
                        z = true;
                    }
                    h.a(a, contentResolver, false, z);
                    this.a.getDialog().dismiss();
                }
            });
        }
    }

    public static void a(Activity activity, c cVar) {
        if (activity == null) {
            com.getpebble.android.common.b.a.f.a("DashboardDialogFragment", "settings clicked: activity is null");
        } else if (cVar.b.equals(aw.b)) {
            activity.startActivity(new Intent(activity, CalendarSettingsActivity.class));
        } else if (cVar.b.equals(aw.c)) {
            activity.startActivity(new Intent(activity, WeatherSettingsActivity.class));
        } else if (cVar.b.equals(am.c)) {
            activity.startActivity(new Intent(activity, HealthSettingsActivity.class));
        } else if (cVar.b.equals(com.getpebble.android.common.model.am.d.REMINDERS.getUuid())) {
            activity.startActivity(new Intent(activity, RemindersSettingsActivity.class));
        } else if (cVar.b.equals(com.getpebble.android.common.model.am.d.SMS.getUuid())) {
            activity.startActivity(new Intent(activity, SmsSettingsActivity.class));
        } else {
            com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
            if (r == null) {
                new Builder(activity).setTitle(R.string.my_pebble_not_connected_title).setMessage(R.string.my_pebble_not_connected_body).setPositiveButton(activity.getString(R.string.my_pebble_ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).show();
                return;
            }
            if (!cVar.b.equals(r.currentRunningApp)) {
                g.a(activity.getFragmentManager());
            }
            com.getpebble.android.common.b.a.f.d("DashboardDialogFragment", "Settings request: calling JsKit");
            PebbleApplication.x().d(cVar.b);
            if (!new com.getpebble.android.framework.install.a.a(com.getpebble.android.common.a.K()).a(cVar)) {
                com.getpebble.android.common.b.a.f.d("DashboardDialogFragment", "Settings request: app is NOT cached, starting app");
                PebbleApplication.x().a(cVar.b);
            }
        }
    }

    private void a() {
        if (this.z) {
            this.m.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.popup_pin_switch_on, 0);
            this.q.setVisibility(0);
            return;
        }
        this.m.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.popup_pin_switch_off, 0);
        this.q.setVisibility(8);
    }

    private void b() {
        if (this.A) {
            this.n.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.popup_pin_switch_on, 0);
        } else {
            this.n.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.popup_pin_switch_off, 0);
        }
    }

    private void a(c cVar, AsyncImageView asyncImageView, com.getpebble.android.common.model.am.b.a aVar) {
        int i;
        Object obj;
        int i2 = R.drawable.watchface_placeholder_icon_square;
        Object obj2 = null;
        if (cVar.F) {
            com.getpebble.android.common.model.am.d fromRecord = com.getpebble.android.common.model.am.d.fromRecord(cVar);
            if (fromRecord == null) {
                com.getpebble.android.common.b.a.f.b("DashboardDialogFragment", "SystemApp is null for " + cVar.b);
            } else {
                com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
                if (p != null) {
                    i2 = fromRecord.getIcon(p.color);
                }
            }
            i = i2;
            obj = null;
        } else {
            if (aVar == null || !aVar.h) {
                aVar = am.a(cVar);
            }
            if (aVar != null) {
                Object a = aVar.a();
                if (!TextUtils.isEmpty(a)) {
                    obj2 = 1;
                    asyncImageView.a(a, new n.c(20), aVar);
                }
            }
            Object obj3 = obj2;
            i = R.drawable.watchface_placeholder_icon_square;
            obj = obj3;
        }
        if (obj == null) {
            asyncImageView.a(i, new n.c(20));
        }
    }
}
