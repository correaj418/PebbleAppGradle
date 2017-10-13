package android.support.v7.widget.a;

import android.graphics.Canvas;
import android.support.v4.view.ah;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class c {

    static class a implements b {
        a() {
        }

        private void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2) {
            canvas.save();
            canvas.translate(f, f2);
            recyclerView.drawChild(canvas, view, 0);
            canvas.restore();
        }

        public void a(View view) {
            view.setVisibility(0);
        }

        public void b(View view) {
            view.setVisibility(4);
        }

        public void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (i != 2) {
                a(canvas, recyclerView, view, f, f2);
            }
        }

        public void b(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (i == 2) {
                a(canvas, recyclerView, view, f, f2);
            }
        }
    }

    static class b implements b {
        b() {
        }

        public void a(View view) {
            ah.a(view, 0.0f);
            ah.b(view, 0.0f);
        }

        public void b(View view) {
        }

        public void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            ah.a(view, f);
            ah.b(view, f2);
        }

        public void b(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        }
    }

    static class c extends b {
        c() {
        }

        public void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (z && view.getTag(android.support.v7.f.a.b.item_touch_helper_previous_elevation) == null) {
                Float valueOf = Float.valueOf(ah.q(view));
                ah.d(view, 1.0f + a(recyclerView, view));
                view.setTag(android.support.v7.f.a.b.item_touch_helper_previous_elevation, valueOf);
            }
            super.a(canvas, recyclerView, view, f, f2, i, z);
        }

        private float a(RecyclerView recyclerView, View view) {
            int childCount = recyclerView.getChildCount();
            float f = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != view) {
                    float q = ah.q(childAt);
                    if (q > f) {
                        f = q;
                    }
                }
            }
            return f;
        }

        public void a(View view) {
            Object tag = view.getTag(android.support.v7.f.a.b.item_touch_helper_previous_elevation);
            if (tag != null && (tag instanceof Float)) {
                ah.d(view, ((Float) tag).floatValue());
            }
            view.setTag(android.support.v7.f.a.b.item_touch_helper_previous_elevation, null);
            super.a(view);
        }
    }
}
