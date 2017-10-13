package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.c.a.b;
import android.support.v4.c.a.c;
import android.view.MenuItem;
import android.view.SubMenu;

public final class o {
    public static MenuItem a(Context context, b bVar) {
        if (VERSION.SDK_INT >= 16) {
            return new j(context, bVar);
        }
        if (VERSION.SDK_INT >= 14) {
            return new i(context, bVar);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu a(Context context, c cVar) {
        if (VERSION.SDK_INT >= 14) {
            return new t(context, cVar);
        }
        throw new UnsupportedOperationException();
    }
}
