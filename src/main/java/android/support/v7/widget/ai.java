package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.g;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class ai extends af implements ah {
    private static Method a;
    private ah d;

    public static class a extends z {
        final int g;
        final int h;
        private ah i;
        private MenuItem j;

        public /* bridge */ /* synthetic */ boolean a(MotionEvent motionEvent, int i) {
            return super.a(motionEvent, i);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.g = 22;
                this.h = 21;
                return;
            }
            this.g = 21;
            this.h = 22;
        }

        public void setHoverListener(ah ahVar) {
            this.i = ahVar;
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.g) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.h) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((f) getAdapter()).a().a(false);
                return true;
            }
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            if (this.i != null) {
                int headersCount;
                f fVar;
                MenuItem a;
                MenuItem menuItem;
                g a2;
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    fVar = (f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    fVar = (f) adapter;
                }
                if (motionEvent.getAction() != 10) {
                    int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition != -1) {
                        headersCount = pointToPosition - headersCount;
                        if (headersCount >= 0 && headersCount < fVar.getCount()) {
                            a = fVar.a(headersCount);
                            menuItem = this.j;
                            if (menuItem != a) {
                                a2 = fVar.a();
                                if (menuItem != null) {
                                    this.i.a(a2, menuItem);
                                }
                                this.j = a;
                                if (a != null) {
                                    this.i.b(a2, a);
                                }
                            }
                        }
                    }
                }
                a = null;
                menuItem = this.j;
                if (menuItem != a) {
                    a2 = fVar.a();
                    if (menuItem != null) {
                        this.i.a(a2, menuItem);
                    }
                    this.j = a;
                    if (a != null) {
                        this.i.b(a2, a);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }

    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public ai(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    z a(Context context, boolean z) {
        z aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    public void a(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.c.setEnterTransition((Transition) obj);
        }
    }

    public void b(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.c.setExitTransition((Transition) obj);
        }
    }

    public void a(ah ahVar) {
        this.d = ahVar;
    }

    public void b(boolean z) {
        if (a != null) {
            try {
                a.invoke(this.c, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    public void b(g gVar, MenuItem menuItem) {
        if (this.d != null) {
            this.d.b(gVar, menuItem);
        }
    }

    public void a(g gVar, MenuItem menuItem) {
        if (this.d != null) {
            this.d.a(gVar, menuItem);
        }
    }
}
