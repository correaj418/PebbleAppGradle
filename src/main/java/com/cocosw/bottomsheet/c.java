package com.cocosw.bottomsheet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.cocosw.bottomsheet.e.b;
import com.cocosw.bottomsheet.e.d;
import com.cocosw.bottomsheet.e.e;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class c extends Dialog implements DialogInterface {
    private final SparseIntArray a = new SparseIntArray();
    private g b;
    private String c;
    private Drawable d;
    private Drawable e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private GridView j;
    private f k;
    private a l;
    private ImageView m;
    private int n = -1;
    private boolean o = true;
    private boolean p = true;
    private a q;
    private a r;
    private a s;
    private OnDismissListener t;
    private OnShowListener u;

    public static class a {
        private final Context a;
        private final a b;
        private int c;
        private CharSequence d;
        private boolean e;
        private OnClickListener f;
        private OnDismissListener g;
        private Drawable h;
        private int i;
        private OnMenuItemClickListener j;

        public a(Activity activity) {
            this(activity, d.BottomSheet_Dialog);
            TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{com.cocosw.bottomsheet.e.a.bs_bottomSheetStyle});
            try {
                this.c = obtainStyledAttributes.getResourceId(0, d.BottomSheet_Dialog);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public a(Context context, int i) {
            this.i = -1;
            this.a = context;
            this.c = i;
            this.b = new a(context);
        }

        public a a(int i) {
            new MenuInflater(this.a).inflate(i, this.b);
            return this;
        }

        public a a(OnClickListener onClickListener) {
            this.f = onClickListener;
            return this;
        }

        @SuppressLint({"Override"})
        public c a() {
            c cVar = new c(this.a, this.c);
            cVar.l = this;
            return cVar;
        }

        public a a(CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }
    }

    c(Context context, int i) {
        super(context, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, e.BottomSheet, com.cocosw.bottomsheet.e.a.bs_bottomSheetStyle, 0);
        try {
            this.e = obtainStyledAttributes.getDrawable(e.BottomSheet_bs_moreDrawable);
            this.d = obtainStyledAttributes.getDrawable(e.BottomSheet_bs_closeDrawable);
            this.c = obtainStyledAttributes.getString(e.BottomSheet_bs_moreText);
            this.i = obtainStyledAttributes.getBoolean(e.BottomSheet_bs_collapseListIcons, true);
            this.f = obtainStyledAttributes.getResourceId(e.BottomSheet_bs_headerLayout, com.cocosw.bottomsheet.e.c.bs_header);
            this.g = obtainStyledAttributes.getResourceId(e.BottomSheet_bs_listItemLayout, com.cocosw.bottomsheet.e.c.bs_list_entry);
            this.h = obtainStyledAttributes.getResourceId(e.BottomSheet_bs_gridItemLayout, com.cocosw.bottomsheet.e.c.bs_grid_entry);
            if (VERSION.SDK_INT >= 19) {
                this.b = new g(this, context);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private int b() {
        int i = 1;
        try {
            Field declaredField = GridView.class.getDeclaredField("mRequestedNumColumns");
            declaredField.setAccessible(true);
            i = declaredField.getInt(this.j);
        } catch (Exception e) {
        }
        return i;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        this.o = z;
    }

    public void setOnShowListener(OnShowListener onShowListener) {
        this.u = onShowListener;
    }

    private void a(Context context) {
        int a;
        setCanceledOnTouchOutside(this.o);
        final ClosableSlidingLayout closableSlidingLayout = (ClosableSlidingLayout) View.inflate(context, com.cocosw.bottomsheet.e.c.bottom_sheet_dialog, null);
        ((LinearLayout) closableSlidingLayout.findViewById(b.bs_main)).addView(View.inflate(context, this.f, null), 0);
        setContentView(closableSlidingLayout);
        if (!this.p) {
            closableSlidingLayout.b = this.p;
        }
        closableSlidingLayout.a(new a(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void a() {
                this.a.dismiss();
            }

            public void b() {
                this.a.d();
            }
        });
        super.setOnShowListener(new OnShowListener(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void onShow(DialogInterface dialogInterface) {
                if (this.a.u != null) {
                    this.a.u.onShow(dialogInterface);
                }
                this.a.j.setAdapter(this.a.k);
                this.a.j.startLayoutAnimation();
                if (this.a.l.h == null) {
                    this.a.m.setVisibility(8);
                    return;
                }
                this.a.m.setVisibility(0);
                this.a.m.setImageDrawable(this.a.l.h);
            }
        });
        int[] iArr = new int[2];
        closableSlidingLayout.getLocationOnScreen(iArr);
        if (VERSION.SDK_INT >= 19) {
            closableSlidingLayout.setPadding(0, iArr[0] == 0 ? this.b.b : 0, 0, 0);
            View childAt = closableSlidingLayout.getChildAt(0);
            if (this.b.a) {
                a = this.b.a(getContext()) + closableSlidingLayout.getPaddingBottom();
            } else {
                a = 0;
            }
            childAt.setPadding(0, 0, 0, a);
        }
        TextView textView = (TextView) closableSlidingLayout.findViewById(b.bottom_sheet_title);
        if (this.l.d != null) {
            textView.setVisibility(0);
            textView.setText(this.l.d);
        }
        this.m = (ImageView) closableSlidingLayout.findViewById(b.bottom_sheet_title_image);
        this.j = (GridView) closableSlidingLayout.findViewById(b.bottom_sheet_gridview);
        closableSlidingLayout.a = this.j;
        if (!this.l.e) {
            this.j.setNumColumns(1);
        }
        if (this.l.e) {
            for (a = 0; a < a().size(); a++) {
                if (a().getItem(a).getIcon() == null) {
                    throw new IllegalArgumentException("You must set icon for each items in grid style");
                }
            }
        }
        if (this.l.i > 0) {
            this.n = this.l.i * b();
        } else {
            this.n = Integer.MAX_VALUE;
        }
        closableSlidingLayout.a(false);
        this.s = this.l.b;
        this.r = this.s;
        if (a().size() > this.n) {
            this.q = this.l.b;
            this.r = this.l.b.a(this.n - 1);
            b bVar = new b(context, 0, b.bs_more, 0, this.n - 1, this.c);
            bVar.setIcon(this.e);
            this.r.a(bVar);
            this.s = this.r;
            closableSlidingLayout.a(true);
        }
        this.k = new f(context, new BaseAdapter(this) {
            final /* synthetic */ c a;

            class a {
                final /* synthetic */ AnonymousClass3 a;
                private TextView b;
                private ImageView c;

                a(AnonymousClass3 anonymousClass3) {
                    this.a = anonymousClass3;
                }
            }

            {
                this.a = r1;
            }

            public /* synthetic */ Object getItem(int i) {
                return a(i);
            }

            public int getCount() {
                return this.a.s.size() - this.a.a.size();
            }

            public MenuItem a(int i) {
                return this.a.s.getItem(i);
            }

            public long getItemId(int i) {
                return (long) i;
            }

            public int getViewTypeCount() {
                return 1;
            }

            public boolean isEnabled(int i) {
                return a(i).isEnabled();
            }

            public boolean areAllItemsEnabled() {
                return false;
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                View inflate;
                a aVar;
                if (view == null) {
                    LayoutInflater layoutInflater = (LayoutInflater) this.a.getContext().getSystemService("layout_inflater");
                    if (this.a.l.e) {
                        inflate = layoutInflater.inflate(this.a.h, viewGroup, false);
                    } else {
                        inflate = layoutInflater.inflate(this.a.g, viewGroup, false);
                    }
                    a aVar2 = new a(this);
                    aVar2.b = (TextView) inflate.findViewById(b.bs_list_title);
                    aVar2.c = (ImageView) inflate.findViewById(b.bs_list_image);
                    inflate.setTag(aVar2);
                    aVar = aVar2;
                } else {
                    aVar = (a) view.getTag();
                    inflate = view;
                }
                for (int i2 = 0; i2 < this.a.a.size(); i2++) {
                    if (this.a.a.valueAt(i2) <= i) {
                        i++;
                    }
                }
                MenuItem a = a(i);
                aVar.b.setText(a.getTitle());
                if (a.getIcon() == null) {
                    aVar.c.setVisibility(this.a.i ? 8 : 4);
                } else {
                    aVar.c.setVisibility(0);
                    aVar.c.setImageDrawable(a.getIcon());
                }
                aVar.c.setEnabled(a.isEnabled());
                aVar.b.setEnabled(a.isEnabled());
                return inflate;
            }
        }, com.cocosw.bottomsheet.e.c.bs_list_divider, b.headerlayout, b.header);
        this.j.setAdapter(this.k);
        this.k.a(this.j);
        this.j.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ c b;

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (((MenuItem) this.b.k.getItem(i)).getItemId() == b.bs_more) {
                    this.b.d();
                    closableSlidingLayout.a(false);
                    return;
                }
                if (!((b) this.b.k.getItem(i)).b()) {
                    if (this.b.l.j != null) {
                        this.b.l.j.onMenuItemClick((MenuItem) this.b.k.getItem(i));
                    } else if (this.b.l.f != null) {
                        this.b.l.f.onClick(this.b, ((MenuItem) this.b.k.getItem(i)).getItemId());
                    }
                }
                this.b.dismiss();
            }
        });
        if (this.l.g != null) {
            setOnDismissListener(this.l.g);
        }
        g();
    }

    private void c() {
        int i = 0;
        this.s.b();
        if (!this.l.e && this.s.size() > 0) {
            int groupId = this.s.getItem(0).getGroupId();
            ArrayList arrayList = new ArrayList();
            while (i < this.s.size()) {
                if (this.s.getItem(i).getGroupId() != groupId) {
                    groupId = this.s.getItem(i).getGroupId();
                    arrayList.add(new com.cocosw.bottomsheet.f.a(i, null));
                }
                i++;
            }
            if (arrayList.size() > 0) {
                com.cocosw.bottomsheet.f.a[] aVarArr = new com.cocosw.bottomsheet.f.a[arrayList.size()];
                arrayList.toArray(aVarArr);
                this.k.a(aVarArr);
                return;
            }
            this.k.a.clear();
        }
    }

    private void d() {
        if (VERSION.SDK_INT >= 19) {
            Transition changeBounds = new ChangeBounds();
            changeBounds.setDuration(300);
            TransitionManager.beginDelayedTransition(this.j, changeBounds);
        }
        this.s = this.q;
        c();
        this.k.notifyDataSetChanged();
        this.j.setLayoutParams(new LayoutParams(-1, -1));
        this.m.setVisibility(0);
        this.m.setImageDrawable(this.d);
        this.m.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.e();
            }
        });
        g();
    }

    private void e() {
        this.s = this.r;
        c();
        this.k.notifyDataSetChanged();
        g();
        if (this.l.h == null) {
            this.m.setVisibility(8);
            return;
        }
        this.m.setVisibility(0);
        this.m.setImageDrawable(this.l.h);
    }

    protected void onStart() {
        super.onStart();
        e();
    }

    private boolean f() {
        return this.k.a.size() > 0;
    }

    private void g() {
        if (f()) {
            this.j.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public void onGlobalLayout() {
                    if (VERSION.SDK_INT < 16) {
                        this.a.j.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        this.a.j.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    View childAt = this.a.j.getChildAt(this.a.j.getChildCount() - 1);
                    if (childAt != null) {
                        this.a.j.setLayoutParams(new LayoutParams(-1, (childAt.getPaddingBottom() + childAt.getBottom()) + this.a.j.getPaddingBottom()));
                    }
                }
            });
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.height = -2;
        attributes.gravity = 80;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16842996});
        try {
            attributes.width = obtainStyledAttributes.getLayoutDimension(0, -1);
            super.setOnDismissListener(new OnDismissListener(this) {
                final /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public void onDismiss(DialogInterface dialogInterface) {
                    if (this.a.t != null) {
                        this.a.t.onDismiss(dialogInterface);
                    }
                    if (this.a.n != Integer.MAX_VALUE) {
                        this.a.e();
                    }
                }
            });
            getWindow().setAttributes(attributes);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public Menu a() {
        return this.l.b;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.t = onDismissListener;
    }
}
