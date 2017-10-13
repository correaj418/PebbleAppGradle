package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class h {
    private static final a a;
    private final Object b;

    interface a {
        Object a(h hVar);
    }

    static class d implements a {
        d() {
        }

        public Object a(h hVar) {
            return null;
        }
    }

    private static class b extends d {
        private b() {
        }

        public Object a(final h hVar) {
            return i.a(new a(this) {
                final /* synthetic */ b b;

                public boolean a(int i, int i2, Bundle bundle) {
                    return hVar.a(i, i2, bundle);
                }

                public List<Object> a(String str, int i) {
                    List a = hVar.a(str, i);
                    if (a == null) {
                        return null;
                    }
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((c) a.get(i2)).a());
                    }
                    return arrayList;
                }

                public Object a(int i) {
                    c a = hVar.a(i);
                    if (a == null) {
                        return null;
                    }
                    return a.a();
                }
            });
        }
    }

    private static class c extends d {
        private c() {
        }

        public Object a(final h hVar) {
            return j.a(new a(this) {
                final /* synthetic */ c b;

                public boolean a(int i, int i2, Bundle bundle) {
                    return hVar.a(i, i2, bundle);
                }

                public List<Object> a(String str, int i) {
                    List a = hVar.a(str, i);
                    if (a == null) {
                        return null;
                    }
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((c) a.get(i2)).a());
                    }
                    return arrayList;
                }

                public Object a(int i) {
                    c a = hVar.a(i);
                    if (a == null) {
                        return null;
                    }
                    return a.a();
                }

                public Object b(int i) {
                    c b = hVar.b(i);
                    if (b == null) {
                        return null;
                    }
                    return b.a();
                }
            });
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new c();
        } else if (VERSION.SDK_INT >= 16) {
            a = new b();
        } else {
            a = new d();
        }
    }

    public h() {
        this.b = a.a(this);
    }

    public h(Object obj) {
        this.b = obj;
    }

    public Object a() {
        return this.b;
    }

    public c a(int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public List<c> a(String str, int i) {
        return null;
    }

    public c b(int i) {
        return null;
    }
}
