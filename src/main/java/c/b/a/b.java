package c.b.a;

import c.b.a.a.d;
import c.b.a.e.j;
import java.io.Serializable;
import org.joda.convert.FromString;

public final class b extends d implements q, Serializable {
    public static b a() {
        return new b();
    }

    @FromString
    public static b a(String str) {
        return a(str, j.a().d());
    }

    public static b a(String str, c.b.a.e.b bVar) {
        return bVar.b(str);
    }

    public b(f fVar) {
        super(fVar);
    }

    public b(long j) {
        super(j);
    }

    public b(long j, f fVar) {
        super(j, fVar);
    }

    public b(long j, a aVar) {
        super(j, aVar);
    }

    public b(Object obj, f fVar) {
        super(obj, fVar);
    }

    public b(int i, int i2, int i3, int i4, int i5, int i6, int i7, a aVar) {
        super(i, i2, i3, i4, i5, i6, i7, aVar);
    }

    public b b() {
        return this;
    }

    public b a(f fVar) {
        f a = e.a(fVar);
        return n() == a ? this : super.a(a);
    }

    public b a_(long j) {
        return j == c() ? this : new b(j, d());
    }

    public b a_(a aVar) {
        a a = e.a(aVar);
        return a == d() ? this : new b(c(), a);
    }

    public b b(f fVar) {
        return a_(d().a(fVar));
    }

    public b c(f fVar) {
        f a = e.a(fVar);
        f a2 = e.a(n());
        return a == a2 ? this : new b(a2.a(a, c()), d().a(a));
    }

    public b a(int i, int i2, int i3) {
        a d = d();
        return a_(d.a().a(d.b().a(i, i2, i3, l()), false, c()));
    }

    public b a(m mVar) {
        return a(mVar.d(), mVar.e(), mVar.f());
    }

    public b a(int i, int i2, int i3, int i4) {
        a d = d();
        return a_(d.a().a(d.b().a(f(), h(), j(), i, i2, i3, i4), false, c()));
    }

    public b p_() {
        return q_().a(n());
    }

    public b a(int i) {
        return i == 0 ? this : a_(d().s().a(c(), i));
    }

    public b b(int i) {
        return i == 0 ? this : a_(d().i().a(c(), i));
    }

    public b c(int i) {
        return i == 0 ? this : a_(d().s().b(c(), i));
    }

    public m q_() {
        return new m(c(), d());
    }

    public b d(int i) {
        return a_(d().m().b(c(), i));
    }
}
