package com.getpebble.android.main.sections.mypebble.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.framework.b.n;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.g;
import com.getpebble.android.h.m;
import com.getpebble.android.h.p;
import com.getpebble.android.main.activity.MainActivity;
import com.getpebble.android.main.fragment.a.b;
import com.getpebble.android.main.sections.appstore.a.a;
import java.util.UUID;

public class c extends b implements LoaderCallbacks<Cursor> {
    private View w;
    private View x;
    private g y;
    private f z = new f(this) {
        final /* synthetic */ c a;

        {
            this.a = r1;
        }

        public boolean doInBackground() {
            com.getpebble.android.common.b.a.a.c.c(this.a.y.getTitle(), this.a.y.getUUID());
            try {
                return am.a(this.a.getActivity().getContentResolver(), this.a.y);
            } catch (Throwable e) {
                com.getpebble.android.common.b.a.f.d("AppStoreDashboardFragment", "AddToLockerTask: doInBackground: could not add to locker", e);
                return false;
            }
        }

        public void onTaskSuccess() {
            PebbleApplication.v().b();
        }

        public void onTaskFailed() {
        }

        protected void onPostExecute(Boolean bool) {
            this.a.dismiss();
            if (!bool.booleanValue()) {
                Toast.makeText(this.a.getActivity(), R.string.something_went_wrong_message, 0).show();
            }
        }
    };

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    public static c a(g gVar) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putString("app_store_result", p.a(gVar));
        cVar.setArguments(bundle);
        cVar.setStyle(1, 0);
        return cVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.y = (g) p.a(getArguments().getString("app_store_result"), g.class);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.y == null) {
            com.getpebble.android.common.b.a.f.b("AppStoreDashboardFragment", "mAppStoreResult is null; possible lifecycle issue");
            dismiss();
            return;
        }
        if (!TextUtils.isEmpty(this.y.getUUID())) {
            getLoaderManager().initLoader(0, null, this);
        }
        this.f.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!m.a(this.a.getActivity(), this.a.y.getTitle(), a.a(this.a.y.getId()))) {
                    Toast.makeText(view.getContext(), this.a.getString(R.string.something_went_wrong_message), 0).show();
                }
            }
        });
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        this.r.setVisibility(8);
        this.v.setVisibility(8);
        this.k.setVisibility(8);
        this.a.setText(this.y.getTitle());
        this.b.setText(this.y.a());
        this.d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                Activity activity = this.a.getActivity();
                if (this.a.y.getId() != null && (activity instanceof MainActivity)) {
                    this.a.dismiss();
                    MainActivity mainActivity = (MainActivity) activity;
                    Bundle bundle = new Bundle();
                    bundle.putInt("extra_store_type", a.a.APPLICATION.ordinal());
                    bundle.putString("extra_page_id", this.a.y.getId());
                    mainActivity.a(b.APP_STORE_APPLICATION, bundle);
                }
            }
        });
        this.e.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!m.b(this.a.getActivity(), this.a.y.b(), this.a.y.getTitle())) {
                    com.getpebble.android.widget.a.a(this.a.getActivity(), this.a.getResources().getString(R.string.contact_developer_preparing_email_failed), 1);
                }
            }
        });
        if (this.y.g()) {
            a(this.g, R.string.app_store_get, new OnClickListener(this) {
                final /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    com.getpebble.android.common.b.a.a.c.e("SearchDetailsAdd", "MyPebble");
                    this.a.dismiss();
                    this.a.c();
                }
            });
        } else {
            this.w = a(this.g, R.string.onboarding_grab_apps_add_btn, new OnClickListener(this) {
                final /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    if (this.a.y.i()) {
                        new com.getpebble.android.main.sections.mypebble.c.b(this.a.getActivity(), this.a.y, new com.getpebble.android.main.sections.mypebble.c.b.a(this) {
                            final /* synthetic */ AnonymousClass5 a;

                            {
                                this.a = r1;
                            }

                            public void a(g gVar) {
                                this.a.a.a();
                            }
                        }).show();
                    } else {
                        this.a.a();
                    }
                }
            });
            a(false);
            this.x = a(this.g, R.drawable.popup_delete_icon, R.string.my_pebble_delete, null);
            this.x.setVisibility(8);
        }
        this.c.setText(String.valueOf(this.y.c()));
        ak.a p = PebbleApplication.p();
        if (p.hwPlatform.getPlatformCode().equals(com.getpebble.android.common.framework.install.app.b.a.CHALK)) {
            LayoutParams layoutParams = (LayoutParams) this.i.getLayoutParams();
            layoutParams.width = com.getpebble.android.common.a.K().getResources().getDimensionPixelSize(R.dimen.my_pebble_dashboard_screenshot_width_chalk);
            this.i.setLayoutParams(layoutParams);
        }
        com.getpebble.android.common.framework.install.app.b.b shape = p.hwPlatform.getPlatformCode().getShape();
        this.j.setImageResource(a(p.color, p.hwPlatform.getPlatformCode()));
        if (this.y.e() == null || this.y.e().length <= 0) {
            this.i.a((int) R.drawable.watchface_placeholder_icon, n.a(shape, true, 20));
        } else {
            this.i.a(this.y.e()[0], n.a(shape, true, 10), null);
        }
        if (this.y.h()) {
            this.h.setVisibility(8);
            return;
        }
        this.h.setVisibility(0);
        this.h.a(this.y.d(), null, null);
    }

    private void a() {
        b();
        com.getpebble.android.common.b.a.a.c.e("SearchDetailsAdd", "MyPebble");
        this.z.submit();
    }

    private void a(boolean z) {
        this.w.setEnabled(z);
        this.w.setAlpha(z ? 1.0f : 0.5f);
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return am.a(UUID.fromString(this.y.getUUID()), getActivity());
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        final com.getpebble.android.common.model.am.c b = am.b(cursor);
        getActivity().getLoaderManager().destroyLoader(0);
        if (this.w != null) {
            com.getpebble.android.common.b.a.f.d("AppStoreDashboardFragment", "onLoadFinished() app = " + b);
            if (b == null) {
                a(true);
            } else if (b.C != null && b.C.equals(b.B)) {
                this.w.setVisibility(8);
                this.x.setVisibility(0);
                this.x.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ c b;

                    public void onClick(View view) {
                        c.b(b);
                        Toast.makeText(this.b.getActivity(), this.b.getString(this.b.y.h() ? R.string.my_pebble_deleted_watchface : R.string.my_pebble_deleted_watchapp, new Object[]{b.c}), 0).show();
                        this.b.dismiss();
                    }
                });
            }
        }
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }

    private void b() {
        Fragment targetFragment = getTargetFragment();
        if (targetFragment instanceof com.getpebble.android.main.sections.a.c) {
            ((com.getpebble.android.main.sections.a.c) targetFragment).a(this.y);
        }
    }

    private void c() {
        com.getpebble.android.common.b.a.a.c.d(this.y.getTitle(), this.y.getId());
        m.a(getActivity(), this.y.f());
    }

    private static void b(final com.getpebble.android.common.model.am.c cVar) {
        new f() {
            public boolean doInBackground() {
                com.getpebble.android.common.b.a.f.d(f.TAG, "deletePebbleApp(): Deleting " + cVar.c + " (" + cVar.b + ") invoking sync");
                cVar.a(com.getpebble.android.common.a.K());
                PebbleApplication.v().b();
                return true;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }
}
