package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.r;
import android.view.View;

class ac {
    boolean a = true;
    int b;
    int c;
    int d;
    int e;
    int f = 0;
    int g = 0;
    boolean h;
    boolean i;

    ac() {
    }

    boolean a(r rVar) {
        return this.c >= 0 && this.c < rVar.e();
    }

    View a(n nVar) {
        View c = nVar.c(this.c);
        this.c += this.d;
        return c;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
