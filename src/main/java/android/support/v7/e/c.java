package android.support.v7.e;

public final class c {
    public static final c a = new c();
    public static final c b = new c();
    public static final c c = new c();
    public static final c d = new c();
    public static final c e = new c();
    public static final c f = new c();
    private final float[] g = new float[3];
    private final float[] h = new float[3];
    private final float[] i = new float[3];
    private boolean j = true;

    static {
        c(a);
        d(a);
        b(b);
        d(b);
        a(c);
        d(c);
        c(d);
        e(d);
        b(e);
        e(e);
        a(f);
        e(f);
    }

    private c() {
        a(this.g);
        a(this.h);
        l();
    }

    public float a() {
        return this.g[0];
    }

    public float b() {
        return this.g[1];
    }

    public float c() {
        return this.g[2];
    }

    public float d() {
        return this.h[0];
    }

    public float e() {
        return this.h[1];
    }

    public float f() {
        return this.h[2];
    }

    public float g() {
        return this.i[0];
    }

    public float h() {
        return this.i[1];
    }

    public float i() {
        return this.i[2];
    }

    public boolean j() {
        return this.j;
    }

    private static void a(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    private void l() {
        this.i[0] = 0.24f;
        this.i[1] = 0.52f;
        this.i[2] = 0.24f;
    }

    void k() {
        int length;
        int i = 0;
        float f = 0.0f;
        for (float f2 : this.i) {
            if (f2 > 0.0f) {
                f += f2;
            }
        }
        if (f != 0.0f) {
            length = this.i.length;
            while (i < length) {
                if (this.i[i] > 0.0f) {
                    float[] fArr = this.i;
                    fArr[i] = fArr[i] / f;
                }
                i++;
            }
        }
    }

    private static void a(c cVar) {
        cVar.h[1] = 0.26f;
        cVar.h[2] = 0.45f;
    }

    private static void b(c cVar) {
        cVar.h[0] = 0.3f;
        cVar.h[1] = 0.5f;
        cVar.h[2] = 0.7f;
    }

    private static void c(c cVar) {
        cVar.h[0] = 0.55f;
        cVar.h[1] = 0.74f;
    }

    private static void d(c cVar) {
        cVar.g[0] = 0.35f;
        cVar.g[1] = 1.0f;
    }

    private static void e(c cVar) {
        cVar.g[1] = 0.3f;
        cVar.g[2] = 0.4f;
    }
}
