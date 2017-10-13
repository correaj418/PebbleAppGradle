package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.ListView;

public final class h {
    public static void a(ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            j.a(listView, i);
        } else {
            i.a(listView, i);
        }
    }
}
