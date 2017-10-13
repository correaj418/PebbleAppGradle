package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ac {
    private static final i a;

    public static class a extends android.support.v4.app.ag.a {
        public static final android.support.v4.app.ag.a.a d = new android.support.v4.app.ag.a.a() {
            public /* synthetic */ android.support.v4.app.ag.a[] b(int i) {
                return a(i);
            }

            public android.support.v4.app.ag.a a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, android.support.v4.app.at.a[] aVarArr, boolean z) {
                return new a(i, charSequence, pendingIntent, bundle, (ar[]) aVarArr, z);
            }

            public a[] a(int i) {
                return new a[i];
            }
        };
        public int a;
        public CharSequence b;
        public PendingIntent c;
        private final Bundle e;
        private final ar[] f;
        private boolean g;

        public static final class a {
            private final int a;
            private final CharSequence b;
            private final PendingIntent c;
            private boolean d;
            private final Bundle e;
            private ArrayList<ar> f;

            public a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new Bundle());
            }

            private a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
                this.a = i;
                this.b = d.d(charSequence);
                this.c = pendingIntent;
                this.e = bundle;
            }

            public a a() {
                ar[] arVarArr;
                if (this.f != null) {
                    arVarArr = (ar[]) this.f.toArray(new ar[this.f.size()]);
                } else {
                    arVarArr = null;
                }
                return new a(this.a, this.b, this.c, this.e, arVarArr, this.d);
            }
        }

        public /* synthetic */ android.support.v4.app.at.a[] g() {
            return f();
        }

        private a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, ar[] arVarArr, boolean z) {
            this.g = false;
            this.a = i;
            this.b = d.d(charSequence);
            this.c = pendingIntent;
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.e = bundle;
            this.f = arVarArr;
            this.g = z;
        }

        public int a() {
            return this.a;
        }

        public CharSequence b() {
            return this.b;
        }

        public PendingIntent c() {
            return this.c;
        }

        public Bundle d() {
            return this.e;
        }

        public boolean e() {
            return this.g;
        }

        public ar[] f() {
            return this.f;
        }
    }

    public static abstract class s {
        CharSequence d;
        CharSequence e;
        boolean f = false;

        public void a(Bundle bundle) {
        }
    }

    public static class b extends s {
        Bitmap a;
        Bitmap b;
        boolean c;
    }

    public static class c extends s {
        CharSequence a;
    }

    public static class d {
        int A = 0;
        Notification B;
        RemoteViews C;
        RemoteViews D;
        RemoteViews E;
        public Notification F = new Notification();
        public ArrayList<String> G;
        public Context a;
        public CharSequence b;
        public CharSequence c;
        PendingIntent d;
        PendingIntent e;
        RemoteViews f;
        public Bitmap g;
        public CharSequence h;
        public int i;
        int j;
        boolean k = true;
        public boolean l;
        public s m;
        public CharSequence n;
        public CharSequence[] o;
        int p;
        int q;
        boolean r;
        String s;
        boolean t;
        String u;
        public ArrayList<a> v = new ArrayList();
        boolean w = false;
        String x;
        Bundle y;
        int z = 0;

        public d(Context context) {
            this.a = context;
            this.F.when = System.currentTimeMillis();
            this.F.audioStreamType = -1;
            this.j = 0;
            this.G = new ArrayList();
        }

        public d a(long j) {
            this.F.when = j;
            return this;
        }

        public d a(int i) {
            this.F.icon = i;
            return this;
        }

        public d a(CharSequence charSequence) {
            this.b = d(charSequence);
            return this;
        }

        public d b(CharSequence charSequence) {
            this.c = d(charSequence);
            return this;
        }

        public d a(PendingIntent pendingIntent) {
            this.d = pendingIntent;
            return this;
        }

        public d c(CharSequence charSequence) {
            this.F.tickerText = d(charSequence);
            return this;
        }

        public d a(Uri uri) {
            this.F.sound = uri;
            this.F.audioStreamType = -1;
            return this;
        }

        public d a(boolean z) {
            a(2, z);
            return this;
        }

        public d b(boolean z) {
            a(8, z);
            return this;
        }

        public d c(boolean z) {
            a(16, z);
            return this;
        }

        private void a(int i, boolean z) {
            if (z) {
                Notification notification = this.F;
                notification.flags |= i;
                return;
            }
            notification = this.F;
            notification.flags &= i ^ -1;
        }

        public Bundle a() {
            if (this.y == null) {
                this.y = new Bundle();
            }
            return this.y;
        }

        public d b(int i) {
            this.z = i;
            return this;
        }

        public d a(f fVar) {
            fVar.a(this);
            return this;
        }

        public Notification b() {
            return ac.a.a(this, c());
        }

        protected e c() {
            return new e();
        }

        protected static CharSequence d(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    protected static class e {
        protected e() {
        }

        public Notification a(d dVar, ab abVar) {
            return abVar.b();
        }
    }

    public interface f {
        d a(d dVar);
    }

    public static class g extends s {
        ArrayList<CharSequence> a = new ArrayList();
    }

    public static class h extends s {
        CharSequence a;
        CharSequence b;
        List<a> c = new ArrayList();

        public static final class a {
            private final CharSequence a;
            private final long b;
            private final CharSequence c;
            private String d;
            private Uri e;

            public CharSequence a() {
                return this.a;
            }

            public long b() {
                return this.b;
            }

            public CharSequence c() {
                return this.c;
            }

            public String d() {
                return this.d;
            }

            public Uri e() {
                return this.e;
            }

            private Bundle f() {
                Bundle bundle = new Bundle();
                if (this.a != null) {
                    bundle.putCharSequence("text", this.a);
                }
                bundle.putLong("time", this.b);
                if (this.c != null) {
                    bundle.putCharSequence("sender", this.c);
                }
                if (this.d != null) {
                    bundle.putString("type", this.d);
                }
                if (this.e != null) {
                    bundle.putParcelable("uri", this.e);
                }
                return bundle;
            }

            static Bundle[] a(List<a> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = ((a) list.get(i)).f();
                }
                return bundleArr;
            }
        }

        h() {
        }

        public void a(Bundle bundle) {
            super.a(bundle);
            if (this.a != null) {
                bundle.putCharSequence("android.selfDisplayName", this.a);
            }
            if (this.b != null) {
                bundle.putCharSequence("android.conversationTitle", this.b);
            }
            if (!this.c.isEmpty()) {
                bundle.putParcelableArray("android.messages", a.a(this.c));
            }
        }
    }

    interface i {
        Notification a(d dVar, e eVar);

        Bundle a(Notification notification);

        a a(Notification notification, int i);

        ArrayList<Parcelable> a(a[] aVarArr);

        a[] a(ArrayList<Parcelable> arrayList);

        int b(Notification notification);

        String c(Notification notification);

        boolean d(Notification notification);
    }

    static class m implements i {
        m() {
        }

        public Notification a(d dVar, e eVar) {
            Notification a = ag.a(dVar.F, dVar.a, dVar.b, dVar.c, dVar.d);
            if (dVar.j > 0) {
                a.flags |= 128;
            }
            if (dVar.C != null) {
                a.contentView = dVar.C;
            }
            return a;
        }

        public Bundle a(Notification notification) {
            return null;
        }

        public int b(Notification notification) {
            return 0;
        }

        public a a(Notification notification, int i) {
            return null;
        }

        public a[] a(ArrayList<Parcelable> arrayList) {
            return null;
        }

        public ArrayList<Parcelable> a(a[] aVarArr) {
            return null;
        }

        public String c(Notification notification) {
            return null;
        }

        public boolean d(Notification notification) {
            return false;
        }
    }

    static class q extends m {
        q() {
        }

        public Notification a(d dVar, e eVar) {
            ab aVar = new android.support.v4.app.ak.a(dVar.a, dVar.F, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.p, dVar.q, dVar.r, dVar.l, dVar.j, dVar.n, dVar.w, dVar.y, dVar.s, dVar.t, dVar.u, dVar.C, dVar.D);
            ac.b((aa) aVar, dVar.v);
            ac.c(aVar, dVar.m);
            Notification a = eVar.a(dVar, aVar);
            if (dVar.m != null) {
                dVar.m.a(a(a));
            }
            return a;
        }

        public Bundle a(Notification notification) {
            return ak.a(notification);
        }

        public int b(Notification notification) {
            return ak.b(notification);
        }

        public a a(Notification notification, int i) {
            return (a) ak.a(notification, i, a.d, ar.a);
        }

        public a[] a(ArrayList<Parcelable> arrayList) {
            return (a[]) ak.a((ArrayList) arrayList, a.d, ar.a);
        }

        public ArrayList<Parcelable> a(a[] aVarArr) {
            return ak.a((android.support.v4.app.ag.a[]) aVarArr);
        }

        public String c(Notification notification) {
            return ak.c(notification);
        }

        public boolean d(Notification notification) {
            return ak.d(notification);
        }
    }

    static class r extends q {
        r() {
        }

        public Notification a(d dVar, e eVar) {
            ab aVar = new android.support.v4.app.al.a(dVar.a, dVar.F, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.p, dVar.q, dVar.r, dVar.k, dVar.l, dVar.j, dVar.n, dVar.w, dVar.G, dVar.y, dVar.s, dVar.t, dVar.u, dVar.C, dVar.D);
            ac.b((aa) aVar, dVar.v);
            ac.c(aVar, dVar.m);
            return eVar.a(dVar, aVar);
        }

        public Bundle a(Notification notification) {
            return al.a(notification);
        }

        public int b(Notification notification) {
            return al.b(notification);
        }

        public a a(Notification notification, int i) {
            return (a) al.a(notification, i, a.d, ar.a);
        }

        public String c(Notification notification) {
            return al.c(notification);
        }

        public boolean d(Notification notification) {
            return al.d(notification);
        }
    }

    static class j extends r {
        j() {
        }

        public Notification a(d dVar, e eVar) {
            ab aVar = new android.support.v4.app.ad.a(dVar.a, dVar.F, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.p, dVar.q, dVar.r, dVar.k, dVar.l, dVar.j, dVar.n, dVar.w, dVar.G, dVar.y, dVar.s, dVar.t, dVar.u, dVar.C, dVar.D);
            ac.b((aa) aVar, dVar.v);
            ac.c(aVar, dVar.m);
            Notification a = eVar.a(dVar, aVar);
            if (dVar.m != null) {
                dVar.m.a(a(a));
            }
            return a;
        }

        public a a(Notification notification, int i) {
            return (a) ad.a(notification, i, a.d, ar.a);
        }

        public a[] a(ArrayList<Parcelable> arrayList) {
            return (a[]) ad.a((ArrayList) arrayList, a.d, ar.a);
        }

        public ArrayList<Parcelable> a(a[] aVarArr) {
            return ad.a((android.support.v4.app.ag.a[]) aVarArr);
        }

        public String c(Notification notification) {
            return ad.a(notification);
        }

        public boolean d(Notification notification) {
            return ad.b(notification);
        }
    }

    static class k extends j {
        k() {
        }

        public Notification a(d dVar, e eVar) {
            ab aVar = new android.support.v4.app.ae.a(dVar.a, dVar.F, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.p, dVar.q, dVar.r, dVar.k, dVar.l, dVar.j, dVar.n, dVar.w, dVar.x, dVar.G, dVar.y, dVar.z, dVar.A, dVar.B, dVar.s, dVar.t, dVar.u, dVar.C, dVar.D, dVar.E);
            ac.b((aa) aVar, dVar.v);
            ac.c(aVar, dVar.m);
            Notification a = eVar.a(dVar, aVar);
            if (dVar.m != null) {
                dVar.m.a(a(a));
            }
            return a;
        }
    }

    static class l extends k {
        l() {
        }

        public Notification a(d dVar, e eVar) {
            ab aVar = new android.support.v4.app.af.a(dVar.a, dVar.F, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.p, dVar.q, dVar.r, dVar.k, dVar.l, dVar.j, dVar.n, dVar.w, dVar.x, dVar.G, dVar.y, dVar.z, dVar.A, dVar.B, dVar.s, dVar.t, dVar.u, dVar.o, dVar.C, dVar.D, dVar.E);
            ac.b((aa) aVar, dVar.v);
            ac.d(aVar, dVar.m);
            Notification a = eVar.a(dVar, aVar);
            if (dVar.m != null) {
                dVar.m.a(a(a));
            }
            return a;
        }
    }

    static class n extends m {
        n() {
        }

        public Notification a(d dVar, e eVar) {
            Notification a = ah.a(dVar.F, dVar.a, dVar.b, dVar.c, dVar.d, dVar.e);
            if (dVar.j > 0) {
                a.flags |= 128;
            }
            if (dVar.C != null) {
                a.contentView = dVar.C;
            }
            return a;
        }
    }

    static class o extends m {
        o() {
        }

        public Notification a(d dVar, e eVar) {
            Notification a = ai.a(dVar.a, dVar.F, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g);
            if (dVar.C != null) {
                a.contentView = dVar.C;
            }
            return a;
        }
    }

    static class p extends m {
        p() {
        }

        public Notification a(d dVar, e eVar) {
            Notification a = eVar.a(dVar, new android.support.v4.app.aj.a(dVar.a, dVar.F, dVar.b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.p, dVar.q, dVar.r));
            if (dVar.C != null) {
                a.contentView = dVar.C;
            }
            return a;
        }
    }

    public static final class t implements f {
        private ArrayList<a> a = new ArrayList();
        private int b = 1;
        private PendingIntent c;
        private ArrayList<Notification> d = new ArrayList();
        private Bitmap e;
        private int f;
        private int g = 8388613;
        private int h = -1;
        private int i = 0;
        private int j;
        private int k = 80;
        private int l;
        private String m;

        public /* synthetic */ Object clone() {
            return a();
        }

        public t(Notification notification) {
            Bundle a = ac.a(notification);
            Bundle bundle = a != null ? a.getBundle("android.wearable.EXTENSIONS") : null;
            if (bundle != null) {
                a[] a2 = ac.a.a(bundle.getParcelableArrayList("actions"));
                if (a2 != null) {
                    Collections.addAll(this.a, a2);
                }
                this.b = bundle.getInt("flags", 1);
                this.c = (PendingIntent) bundle.getParcelable("displayIntent");
                Notification[] a3 = ac.b(bundle, "pages");
                if (a3 != null) {
                    Collections.addAll(this.d, a3);
                }
                this.e = (Bitmap) bundle.getParcelable("background");
                this.f = bundle.getInt("contentIcon");
                this.g = bundle.getInt("contentIconGravity", 8388613);
                this.h = bundle.getInt("contentActionIndex", -1);
                this.i = bundle.getInt("customSizePreset", 0);
                this.j = bundle.getInt("customContentHeight");
                this.k = bundle.getInt("gravity", 80);
                this.l = bundle.getInt("hintScreenTimeout");
                this.m = bundle.getString("dismissalId");
            }
        }

        public d a(d dVar) {
            Bundle bundle = new Bundle();
            if (!this.a.isEmpty()) {
                bundle.putParcelableArrayList("actions", ac.a.a((a[]) this.a.toArray(new a[this.a.size()])));
            }
            if (this.b != 1) {
                bundle.putInt("flags", this.b);
            }
            if (this.c != null) {
                bundle.putParcelable("displayIntent", this.c);
            }
            if (!this.d.isEmpty()) {
                bundle.putParcelableArray("pages", (Parcelable[]) this.d.toArray(new Notification[this.d.size()]));
            }
            if (this.e != null) {
                bundle.putParcelable("background", this.e);
            }
            if (this.f != 0) {
                bundle.putInt("contentIcon", this.f);
            }
            if (this.g != 8388613) {
                bundle.putInt("contentIconGravity", this.g);
            }
            if (this.h != -1) {
                bundle.putInt("contentActionIndex", this.h);
            }
            if (this.i != 0) {
                bundle.putInt("customSizePreset", this.i);
            }
            if (this.j != 0) {
                bundle.putInt("customContentHeight", this.j);
            }
            if (this.k != 80) {
                bundle.putInt("gravity", this.k);
            }
            if (this.l != 0) {
                bundle.putInt("hintScreenTimeout", this.l);
            }
            if (this.m != null) {
                bundle.putString("dismissalId", this.m);
            }
            dVar.a().putBundle("android.wearable.EXTENSIONS", bundle);
            return dVar;
        }

        public t a() {
            t tVar = new t();
            tVar.a = new ArrayList(this.a);
            tVar.b = this.b;
            tVar.c = this.c;
            tVar.d = new ArrayList(this.d);
            tVar.e = this.e;
            tVar.f = this.f;
            tVar.g = this.g;
            tVar.h = this.h;
            tVar.i = this.i;
            tVar.j = this.j;
            tVar.k = this.k;
            tVar.l = this.l;
            tVar.m = this.m;
            return tVar;
        }

        public t a(a aVar) {
            this.a.add(aVar);
            return this;
        }

        public List<a> b() {
            return this.a;
        }

        public List<Notification> c() {
            return this.d;
        }

        public int d() {
            return this.h;
        }
    }

    private static void b(aa aaVar, ArrayList<a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aaVar.a((a) it.next());
        }
    }

    private static void c(ab abVar, s sVar) {
        if (sVar == null) {
            return;
        }
        if (sVar instanceof c) {
            c cVar = (c) sVar;
            ak.a(abVar, cVar.d, cVar.f, cVar.e, cVar.a);
        } else if (sVar instanceof g) {
            g gVar = (g) sVar;
            ak.a(abVar, gVar.d, gVar.f, gVar.e, gVar.a);
        } else if (sVar instanceof b) {
            b bVar = (b) sVar;
            ak.a(abVar, bVar.d, bVar.f, bVar.e, bVar.a, bVar.b, bVar.c);
        } else if (!(sVar instanceof h)) {
        }
    }

    private static void d(ab abVar, s sVar) {
        if (sVar == null) {
            return;
        }
        if (sVar instanceof h) {
            h hVar = (h) sVar;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            List arrayList3 = new ArrayList();
            List arrayList4 = new ArrayList();
            List arrayList5 = new ArrayList();
            for (a aVar : hVar.c) {
                arrayList.add(aVar.a());
                arrayList2.add(Long.valueOf(aVar.b()));
                arrayList3.add(aVar.c());
                arrayList4.add(aVar.d());
                arrayList5.add(aVar.e());
            }
            af.a(abVar, hVar.a, hVar.b, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
            return;
        }
        c(abVar, sVar);
    }

    static {
        if (android.support.v4.d.c.a()) {
            a = new l();
        } else if (VERSION.SDK_INT >= 21) {
            a = new k();
        } else if (VERSION.SDK_INT >= 20) {
            a = new j();
        } else if (VERSION.SDK_INT >= 19) {
            a = new r();
        } else if (VERSION.SDK_INT >= 16) {
            a = new q();
        } else if (VERSION.SDK_INT >= 14) {
            a = new p();
        } else if (VERSION.SDK_INT >= 11) {
            a = new o();
        } else if (VERSION.SDK_INT >= 9) {
            a = new n();
        } else {
            a = new m();
        }
    }

    private static Notification[] b(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Parcelable[] parcelableArr = new Notification[parcelableArray.length];
        for (int i = 0; i < parcelableArray.length; i++) {
            parcelableArr[i] = (Notification) parcelableArray[i];
        }
        bundle.putParcelableArray(str, parcelableArr);
        return parcelableArr;
    }

    public static Bundle a(Notification notification) {
        return a.a(notification);
    }

    public static int b(Notification notification) {
        return a.b(notification);
    }

    public static a a(Notification notification, int i) {
        return a.a(notification, i);
    }

    public static String c(Notification notification) {
        return a.c(notification);
    }

    public static boolean d(Notification notification) {
        return a.d(notification);
    }
}
