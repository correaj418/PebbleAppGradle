package android.support.v4.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

class e implements c {

    private static class a implements g {
        List<b> a = new ArrayList();
        List<d> b = new ArrayList();
        View c;
        private long d;
        private long e = 200;
        private float f = 0.0f;
        private boolean g = false;
        private boolean h = false;
        private Runnable i = new Runnable(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void run() {
                float a = (((float) (this.a.e() - this.a.d)) * 1.0f) / ((float) this.a.e);
                if (a > 1.0f || this.a.c.getParent() == null) {
                    a = 1.0f;
                }
                this.a.f = a;
                this.a.d();
                if (this.a.f >= 1.0f) {
                    this.a.g();
                } else {
                    this.a.c.postDelayed(this.a.i, 16);
                }
            }
        };

        private void d() {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                ((d) this.b.get(size)).a(this);
            }
        }

        public void a(View view) {
            this.c = view;
        }

        public void a(b bVar) {
            this.a.add(bVar);
        }

        public void a(long j) {
            if (!this.g) {
                this.e = j;
            }
        }

        public void a() {
            if (!this.g) {
                this.g = true;
                f();
                this.f = 0.0f;
                this.d = e();
                this.c.postDelayed(this.i, 16);
            }
        }

        private long e() {
            return this.c.getDrawingTime();
        }

        private void f() {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                ((b) this.a.get(size)).a(this);
            }
        }

        private void g() {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                ((b) this.a.get(size)).b(this);
            }
        }

        private void h() {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                ((b) this.a.get(size)).c(this);
            }
        }

        public void b() {
            if (!this.h) {
                this.h = true;
                if (this.g) {
                    h();
                }
                g();
            }
        }

        public void a(d dVar) {
            this.b.add(dVar);
        }

        public float c() {
            return this.f;
        }
    }

    e() {
    }

    public g a() {
        return new a();
    }

    public void a(View view) {
    }
}
