package com.getpebble.android.main.sections.mypebble.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class f extends android.support.v7.widget.RecyclerView.a<a> {
    private f a;
    private List<com.getpebble.android.common.model.aq.a> b = new ArrayList();
    private android.support.v7.widget.a.a c = new android.support.v7.widget.a.a(new e(this));

    public abstract class a extends u {
        final /* synthetic */ f l;

        public abstract void c(int i);

        public a(f fVar, int i, ViewGroup viewGroup) {
            this.l = fVar;
            super(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false));
        }
    }

    private class b extends a {
        final /* synthetic */ f m;
        private TextView n = ((TextView) this.a.findViewById(R.id.sms_fave_name_tv));
        private TextView o = ((TextView) this.a.findViewById(R.id.sms_fave_number_tv));
        private View p = this.a.findViewById(R.id.sms_fave_remove_btn);

        public b(final f fVar, ViewGroup viewGroup) {
            this.m = fVar;
            super(fVar, R.layout.view_sms_fave, viewGroup);
            this.a.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ b b;

                public boolean onLongClick(View view) {
                    this.b.m.c.a(this.b);
                    return true;
                }
            });
        }

        public void c(int i) {
            final com.getpebble.android.common.model.aq.a aVar = (com.getpebble.android.common.model.aq.a) this.m.b.get(this.m.f(i));
            this.n.setText(aVar.a.e);
            this.o.setText(aVar.d);
            this.p.setEnabled(true);
            this.p.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b b;

                public void onClick(View view) {
                    this.b.p.setEnabled(false);
                    this.b.m.g(this.b.m.a(f.b(aVar)));
                }
            });
        }
    }

    private class c extends a {
        final /* synthetic */ f m;
        private View n;
        private TextView o = ((TextView) this.a.findViewById(R.id.sms_max_contacts_added));
        private View p;

        public c(final f fVar, ViewGroup viewGroup) {
            this.m = fVar;
            super(fVar, R.layout.view_sms_footer, viewGroup);
            this.o.setText(viewGroup.getContext().getString(R.string.sms_max_contacts, new Object[]{Integer.valueOf(5)}));
            this.p = this.a.findViewById(R.id.sms_no_contacts_added);
            this.n = this.a.findViewById(R.id.sms_add_contact_btn);
            this.n.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ c b;

                public void onClick(View view) {
                    this.b.m.a.a(this.b.m.b.size());
                }
            });
        }

        public void c(int i) {
            int i2;
            int i3;
            int i4 = 0;
            if (this.m.b.size() >= 5) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            TextView textView = this.o;
            if (i2 != 0) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
            View view = this.n;
            if (i2 != 0) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            view.setVisibility(i2);
            View view2 = this.p;
            if (!this.m.b.isEmpty()) {
                i4 = 8;
            }
            view2.setVisibility(i4);
        }
    }

    private class d extends a {
        View m = this.a.findViewById(R.id.sms_templates_btn);
        final /* synthetic */ f n;

        public d(final f fVar, ViewGroup viewGroup) {
            this.n = fVar;
            super(fVar, R.layout.view_sms_header, viewGroup);
            this.m.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ d b;

                public void onClick(View view) {
                    this.b.n.a.a();
                }
            });
        }

        public void c(int i) {
        }
    }

    public class e extends android.support.v7.widget.a.a.a {
        final /* synthetic */ f a;

        public e(f fVar) {
            this.a = fVar;
        }

        public int a(RecyclerView recyclerView, u uVar) {
            return android.support.v7.widget.a.a.a.b(3, 0);
        }

        public boolean b(RecyclerView recyclerView, u uVar, u uVar2) {
            int e = uVar.e();
            int e2 = uVar2.e();
            if (this.a.a(e2) != 1) {
                return false;
            }
            Collections.swap(this.a.b, this.a.f(e), this.a.f(e2));
            this.a.a(e, e2);
            return true;
        }

        public void a(u uVar, int i) {
        }

        public boolean b() {
            return false;
        }

        public boolean a() {
            return false;
        }

        public void c(RecyclerView recyclerView, u uVar) {
            super.c(recyclerView, uVar);
            this.a.a.a(this.a.b);
        }
    }

    public interface f {
        void a();

        void a(int i);

        void a(com.getpebble.android.common.model.aq.a aVar, List<com.getpebble.android.common.model.aq.a> list);

        void a(List<com.getpebble.android.common.model.aq.a> list);
    }

    public /* synthetic */ u a(ViewGroup viewGroup, int i) {
        return c(viewGroup, i);
    }

    public f(f fVar, RecyclerView recyclerView) {
        this.a = fVar;
        this.c.a(recyclerView);
        a(true);
    }

    public int a(long j) {
        for (int i = 0; i < a(); i++) {
            if (b(i) == j) {
                return i;
            }
        }
        throw new IllegalArgumentException("id " + j + " not found");
    }

    private int f(int i) {
        return i - 1;
    }

    public long b(int i) {
        if (i == 0) {
            return 0;
        }
        if (i <= this.b.size()) {
            return b((com.getpebble.android.common.model.aq.a) this.b.get(f(i)));
        }
        return 2;
    }

    private void g(int i) {
        this.a.a((com.getpebble.android.common.model.aq.a) this.b.remove(f(i)), this.b);
        e(i);
        c(a() - 1);
    }

    public void a(List<com.getpebble.android.common.model.aq.a> list) {
        this.b = list;
        d();
    }

    public a c(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return new d(this, viewGroup);
            case 1:
                return new b(this, viewGroup);
            case 2:
                return new c(this, viewGroup);
            default:
                throw new IllegalArgumentException("Invalid viewType = " + i);
        }
    }

    public void a(a aVar, int i) {
        aVar.c(i);
    }

    public int a() {
        return this.b.size() + 2;
    }

    public int a(int i) {
        if (i == 0) {
            return 0;
        }
        if (i <= this.b.size()) {
            return 1;
        }
        return 2;
    }

    private static long b(com.getpebble.android.common.model.aq.a aVar) {
        return (long) aVar.b.hashCode();
    }
}
