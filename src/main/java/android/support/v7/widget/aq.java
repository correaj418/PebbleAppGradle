package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.r;
import android.view.View;

class aq {
    static int a(r rVar, ak akVar, View view, View view2, h hVar, boolean z, boolean z2) {
        if (hVar.t() == 0 || rVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max;
        int min = Math.min(hVar.d(view), hVar.d(view2));
        int max2 = Math.max(hVar.d(view), hVar.d(view2));
        if (z2) {
            max = Math.max(0, (rVar.e() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(akVar.b(view2) - akVar.a(view))) / ((float) (Math.abs(hVar.d(view) - hVar.d(view2)) + 1)))) + ((float) (akVar.c() - akVar.a(view))));
    }

    static int a(r rVar, ak akVar, View view, View view2, h hVar, boolean z) {
        if (hVar.t() == 0 || rVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(hVar.d(view) - hVar.d(view2)) + 1;
        }
        return Math.min(akVar.f(), akVar.b(view2) - akVar.a(view));
    }

    static int b(r rVar, ak akVar, View view, View view2, h hVar, boolean z) {
        if (hVar.t() == 0 || rVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return rVar.e();
        }
        return (int) ((((float) (akVar.b(view2) - akVar.a(view))) / ((float) (Math.abs(hVar.d(view) - hVar.d(view2)) + 1))) * ((float) rVar.e()));
    }
}
