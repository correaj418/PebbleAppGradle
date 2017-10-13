package com.getpebble.android.main.sections.mypebble.a;

import android.app.Activity;
import android.content.ContentResolver;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.framework.widget.AsyncImageView;
import com.getpebble.android.common.model.am;
import com.getpebble.android.widget.PebbleTextView;
import java.util.ArrayList;
import java.util.List;

public class c extends android.support.v7.widget.RecyclerView.a<b> {
    private final String a = "AppsAdapter";
    private final boolean b;
    private List<com.getpebble.android.common.model.am.c> c = new ArrayList();
    private Activity d;
    private com.getpebble.android.common.model.am.c e;
    private int f;
    private int g;
    private d h;
    private final int i;
    private final com.getpebble.android.common.model.am.e j;
    private int k;
    private int l;
    private int m = -1;
    private int n;
    private RecyclerView o;
    private android.support.v7.widget.a.a p = new android.support.v7.widget.a.a(new android.support.v7.widget.a.a.a(this) {
        final /* synthetic */ c a;

        {
            this.a = r1;
        }

        public int a(RecyclerView recyclerView, u uVar) {
            int i = 3;
            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                i = 15;
            }
            return android.support.v7.widget.a.a.a.b(i, 0);
        }

        public boolean b() {
            return false;
        }

        public boolean a() {
            return false;
        }

        public boolean b(RecyclerView recyclerView, u uVar, u uVar2) {
            int e = uVar.e();
            int e2 = uVar2.e();
            com.getpebble.android.common.b.a.f.e("AppsAdapter", "onMove: fromPosition = " + e + ", toPosition = " + e2);
            if (e < 0 || e2 < 0) {
                return false;
            }
            if (e2 >= this.a.c.size()) {
                com.getpebble.android.common.b.a.f.a("AppsAdapter", "move: Failed to move item from " + e + " to " + e2 + ". List size is " + this.a.c.size() + ".");
                return false;
            } else if (e2 >= this.a.n) {
                com.getpebble.android.common.b.a.f.a("AppsAdapter", "Not moving item from " + e + " to " + e2 + ". Cannot move item below mNotSupportedHeaderPosition " + this.a.n + ".");
                return false;
            } else if (!((com.getpebble.android.common.model.am.c) this.a.c.get(e2)).I) {
                com.getpebble.android.common.b.a.f.d("AppsAdapter", "move: to record is not reorderable");
                if (e > this.a.l) {
                    this.a.b(e, this.a.l);
                    this.a.a(e, this.a.l);
                }
                return false;
            } else if (((com.getpebble.android.common.model.am.c) this.a.c.get(e)).F && e2 >= this.a.k) {
                com.getpebble.android.common.b.a.f.d("AppsAdapter", "move: System app must be within sync/archive limit");
                return false;
            } else if (e2 < this.a.k || this.a.n > this.a.j.getMaxNumToSync()) {
                this.a.b(e, e2);
                this.a.a(e, e2);
                return true;
            } else {
                com.getpebble.android.common.b.a.f.d("AppsAdapter", "move: Cannot move app below archive limit, size of list (" + this.a.n + ") is smaller than " + this.a.j.getMaxNumToSync());
                return false;
            }
        }

        public void a(u uVar, int i) {
        }

        public void c(RecyclerView recyclerView, u uVar) {
            super.c(recyclerView, uVar);
            this.a.g();
        }
    });

    public abstract class b extends u {
        final /* synthetic */ c q;

        abstract void c(int i);

        abstract void y();

        public b(c cVar, View view) {
            this.q = cVar;
            super(view);
        }
    }

    private abstract class a extends b {
        protected final AsyncImageView l;
        protected final RelativeLayout m;
        protected final ImageView n;
        protected final ImageView o;
        final /* synthetic */ c p;
        private final PebbleTextView r;
        private final PebbleTextView s;

        protected abstract void a(com.getpebble.android.common.model.am.c cVar, boolean z, boolean z2, int i, h hVar);

        public a(c cVar, View view) {
            this.p = cVar;
            super(cVar, view);
            this.m = (RelativeLayout) view;
            this.r = (PebbleTextView) view.findViewById(R.id.txt_watchapp_title);
            this.s = (PebbleTextView) view.findViewById(R.id.developer_name);
            this.l = (AsyncImageView) view.findViewById(R.id.watchapp_app_icon);
            this.n = (ImageView) view.findViewById(R.id.reorder_icon);
            this.o = (ImageView) view.findViewById(R.id.settings_icon);
        }

        final void c(final int i) {
            boolean z = false;
            final com.getpebble.android.common.model.am.c cVar = (com.getpebble.android.common.model.am.c) this.p.c.get(i);
            final boolean z2 = i < this.p.k;
            h hVar = new h(cVar, z2);
            com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
            if (p == null) {
                com.getpebble.android.common.b.a.f.a("AppsAdapter", "AbstractAppFaceHolder: bind: Failed to bind -- lastConnectedDeviceRecord was null.");
                return;
            }
            com.getpebble.android.common.framework.install.app.b.a platformCode = p.hwPlatform.getPlatformCode();
            if (cVar.F || cVar.H.b(platformCode)) {
                z = true;
            }
            hVar.a(this.r);
            hVar.b(this.s);
            hVar.a(this.l);
            hVar.a(this.o, this.p.d);
            this.o.setImageResource(R.drawable.grid_gear);
            if (this.p.b) {
                this.o.setVisibility(4);
            }
            this.m.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a d;

                public void onClick(View view) {
                    if (this.d.p.b) {
                        h.a(cVar, com.getpebble.android.common.a.K().getContentResolver(), !cVar.F, false);
                        this.d.p.m = i;
                        this.d.p.d();
                        return;
                    }
                    com.getpebble.android.main.sections.mypebble.fragment.d.a(cVar, this.d.p.f(), z2).show(this.d.p.d.getFragmentManager(), "app_dialog");
                }
            });
            this.m.setContentDescription(this.r.getText() + " Pebble app");
            if (this.p.b || !cVar.I || i >= this.p.n) {
                this.m.setOnLongClickListener(null);
            } else {
                this.m.setOnLongClickListener(new OnLongClickListener(this) {
                    final /* synthetic */ a c;

                    public boolean onLongClick(View view) {
                        this.c.p.p.a(this.c);
                        this.c.p.e = cVar;
                        this.c.p.f = i;
                        this.c.p.i();
                        return true;
                    }
                });
            }
            a(cVar, z, z2, i, hVar);
        }

        void y() {
            com.getpebble.android.common.b.a.f.e("AppsAdapter", "AbstractAppFaceHolder: unbind: old postion = " + f() + ", new position = " + e());
            this.o.setOnClickListener(null);
            this.m.setOnClickListener(null);
            this.l.a();
        }
    }

    private class c extends a {
        final /* synthetic */ c r;
        private final ImageView s;
        private final PebbleTextView t;
        private final PebbleTextView u;

        private c(c cVar, View view) {
            this.r = cVar;
            super(cVar, view);
            this.s = (ImageView) view.findViewById(R.id.exclamation_icon);
            this.t = (PebbleTextView) view.findViewById(R.id.txt_watchapp_title);
            this.u = (PebbleTextView) view.findViewById(R.id.developer_name);
        }

        protected void a(com.getpebble.android.common.model.am.c cVar, boolean z, boolean z2, int i, h hVar) {
            hVar.a(this.s);
            if (z2) {
                this.m.setBackgroundResource(R.drawable.apps_list_row_states);
            } else {
                this.m.setBackgroundResource(R.drawable.apps_list_row_over_limit_states);
            }
            if (cVar.I) {
                this.n.setImageResource(R.drawable.list_reorder_lines);
            } else {
                this.n.setImageResource(R.drawable.list_reorder_locked);
            }
            if (this.r.b || i <= this.r.n) {
                this.t.setTextColor(com.getpebble.android.common.a.K().getResources().getColor(R.color.white));
                this.u.setTextColor(com.getpebble.android.common.a.K().getResources().getColor(R.color.locker_item_text_color));
                return;
            }
            this.n.setImageResource(R.drawable.grid_over_limit);
            this.t.setTextColor(com.getpebble.android.common.a.K().getResources().getColor(R.color.dark_gray_1));
            this.u.setTextColor(com.getpebble.android.common.a.K().getResources().getColor(R.color.dark_gray_3));
        }
    }

    public interface d {
        void a(com.getpebble.android.common.model.am.c cVar, int i, int i2, List<com.getpebble.android.common.model.am.c> list);
    }

    private class e extends a {
        final /* synthetic */ c r;
        private final ImageView s;
        private final PebbleTextView t;
        private final PebbleTextView u;

        private e(c cVar, View view) {
            this.r = cVar;
            super(cVar, view);
            this.s = (ImageView) view.findViewById(R.id.green_checkmark);
            this.t = (PebbleTextView) view.findViewById(R.id.txt_watchapp_title);
            this.u = (PebbleTextView) view.findViewById(R.id.developer_name);
        }

        protected void a(final com.getpebble.android.common.model.am.c cVar, boolean z, final boolean z2, int i, h hVar) {
            if (this.r.b) {
                if (this.r.m == i) {
                    this.s.setImageResource(R.drawable.grid_checkmark_on);
                } else {
                    this.s.setImageResource(R.drawable.grid_checkmark_off);
                }
                this.s.setOnClickListener(null);
                this.s.setClickable(false);
            } else if (!z || !cVar.h()) {
                this.s.setImageResource(R.drawable.grid_over_limit);
                this.s.setOnClickListener(null);
            } else if (cVar.y) {
                this.s.setImageResource(R.drawable.grid_checkmark_on);
                this.s.setOnClickListener(null);
            } else {
                this.s.setImageResource(R.drawable.grid_checkmark_off);
                this.s.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ e c;

                    public void onClick(View view) {
                        boolean z;
                        com.getpebble.android.common.model.am.c cVar = cVar;
                        ContentResolver contentResolver = com.getpebble.android.common.a.K().getContentResolver();
                        if (z2) {
                            z = false;
                        } else {
                            z = true;
                        }
                        h.a(cVar, contentResolver, false, z);
                    }
                });
            }
            if (z2 || this.r.b) {
                if (i % 2 == 0) {
                    this.m.setBackgroundResource(R.drawable.grid_item_states_left);
                } else {
                    this.m.setBackgroundResource(R.drawable.grid_item_states_right);
                }
            } else if ((this.r.k % 2 != 0 || i % 2 == 0) && ((this.r.n % 2 == 0 || i % 2 != 0) && (this.r.n % 2 != 0 || i % 2 == 0))) {
                this.m.setBackgroundResource(R.drawable.grid_item_states_right_over_limit);
            } else {
                this.m.setBackgroundResource(R.drawable.grid_item_states_left_over_limit);
            }
            if (this.r.b || i <= this.r.n) {
                this.t.setTextColor(com.getpebble.android.common.a.K().getResources().getColor(R.color.white));
                this.u.setTextColor(com.getpebble.android.common.a.K().getResources().getColor(R.color.locker_item_text_color));
                return;
            }
            this.t.setTextColor(com.getpebble.android.common.a.K().getResources().getColor(R.color.dark_gray_1));
            this.u.setTextColor(com.getpebble.android.common.a.K().getResources().getColor(R.color.dark_gray_3));
        }
    }

    private class f extends b {
        final /* synthetic */ c l;
        private LinearLayout m;
        private PebbleTextView n;

        public f(c cVar, View view) {
            this.l = cVar;
            super(cVar, view);
            this.m = (LinearLayout) view.findViewById(R.id.header_layout);
            this.n = (PebbleTextView) view.findViewById(R.id.watch_app_header_container);
        }

        void c(int i) {
            com.getpebble.android.common.model.am.c cVar = (com.getpebble.android.common.model.am.c) this.l.c.get(i);
            if (cVar.i()) {
                this.n.setText(R.string.app_archive_title);
                com.getpebble.android.common.b.a.f.d("AppsAdapter", "HeaderViewHolder: <constructor> ArchiveHeaderRecord position = " + i + " max = " + (this.l.n - 1));
                if (i < this.l.n - 1) {
                    this.m.setVisibility(0);
                } else {
                    this.m.setVisibility(8);
                }
            } else if (cVar.j()) {
                com.getpebble.android.common.b.a.f.d("AppsAdapter", "HeaderViewHolder: <constructor> NotSupportedHeaderRecord position = " + i + " max = " + (this.l.c.size() - 1));
                if (cVar.d == com.getpebble.android.common.model.am.e.APP) {
                    this.n.setText(R.string.app_not_supported_apps_title);
                } else {
                    this.n.setText(R.string.app_not_supported_watchfaces_title);
                }
                if (i < this.l.c.size() - 1) {
                    this.m.setVisibility(0);
                } else {
                    this.m.setVisibility(8);
                }
            }
        }

        void y() {
        }
    }

    public /* synthetic */ u a(ViewGroup viewGroup, int i) {
        return c(viewGroup, i);
    }

    public c(Activity activity, List<com.getpebble.android.common.model.am.c> list, boolean z, RecyclerView recyclerView, d dVar, h hVar, int i, com.getpebble.android.common.model.am.e eVar) {
        this.o = recyclerView;
        this.p.a(this.o);
        this.b = z;
        a((List) list);
        this.d = activity;
        this.h = dVar;
        this.i = i;
        this.j = eVar;
        a(true);
        if (hVar instanceof GridLayoutManager) {
            ((GridLayoutManager) hVar).a(new android.support.v7.widget.GridLayoutManager.c(this) {
                final /* synthetic */ c b;

                {
                    this.b = r1;
                }

                public int a(int i) {
                    if (i < this.b.c.size()) {
                        return (((com.getpebble.android.common.model.am.c) this.b.c.get(i)).i() || ((com.getpebble.android.common.model.am.c) this.b.c.get(i)).j()) ? this.b.i : 1;
                    } else {
                        com.getpebble.android.common.b.a.f.b("AppsAdapter", "<constructor> getSpanSize() position = " + i + " >= size = " + this.b.c.size());
                        return 1;
                    }
                }
            });
        }
    }

    public void e() {
        this.c.clear();
        this.c = null;
        this.d = null;
        this.e = null;
        this.h = null;
        this.o = null;
        this.p.a(null);
        this.p = null;
    }

    private void b(int i, int i2) {
        this.c.add(i2, (com.getpebble.android.common.model.am.c) this.c.remove(i));
        this.g = i2;
    }

    public long b(int i) {
        return (long) ((com.getpebble.android.common.model.am.c) this.c.get(i)).b.hashCode();
    }

    private void g() {
        if (this.c == null) {
            com.getpebble.android.common.b.a.f.c("AppsAdapter", "reorderLockerModel: mList is null");
            return;
        }
        com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
        if (p == null) {
            com.getpebble.android.common.b.a.f.a("AppsAdapter", "reorderLockerModel: Failed to bind -- lastConnectedDeviceRecord was null.");
            return;
        }
        am.a(this.c, this.j, p.hwPlatform.getPlatformCode());
        if (this.h != null) {
            this.h.a(this.e, this.f, this.g, this.c);
        }
        this.o.post(new Runnable(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.d();
            }
        });
    }

    public b c(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new f(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_collection_grid_header, viewGroup, false));
        }
        if (i == 2) {
            return new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_collection_grid, viewGroup, false));
        }
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_collection_app, viewGroup, false));
    }

    public void a(b bVar, int i) {
        bVar.y();
        bVar.c(i);
    }

    public int a(int i) {
        if (((com.getpebble.android.common.model.am.c) this.c.get(i)).i() || ((com.getpebble.android.common.model.am.c) this.c.get(i)).j()) {
            return 0;
        }
        if (this.j.equals(com.getpebble.android.common.model.am.e.WATCHFACE)) {
            return 2;
        }
        return 1;
    }

    public int a() {
        return this.c.size();
    }

    public boolean f() {
        return this.n == 1;
    }

    public void a(List<com.getpebble.android.common.model.am.c> list) {
        this.c.clear();
        this.c.addAll(list);
        h();
        i();
        j();
        d();
    }

    private void h() {
        for (int i = 0; i < this.c.size(); i++) {
            if (((com.getpebble.android.common.model.am.c) this.c.get(i)).I) {
                this.l = i;
                return;
            }
        }
    }

    private void i() {
        for (int i = 0; i < this.c.size(); i++) {
            if (((com.getpebble.android.common.model.am.c) this.c.get(i)).i()) {
                this.k = i;
            }
        }
    }

    private void j() {
        for (int i = 0; i < this.c.size(); i++) {
            if (((com.getpebble.android.common.model.am.c) this.c.get(i)).j()) {
                this.n = i;
            }
        }
    }
}
