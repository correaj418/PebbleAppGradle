package com.google.c.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public final class i {

    public static class a implements Externalizable {
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private List<String> e = new ArrayList();
        private boolean f;
        private String g = "";
        private boolean h;
        private boolean i = false;
        private boolean j;
        private String k = "";

        public String a() {
            return this.b;
        }

        public a a(String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        public String b() {
            return this.d;
        }

        public a b(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        public int c() {
            return this.e.size();
        }

        public String a(int i) {
            return (String) this.e.get(i);
        }

        public String d() {
            return this.g;
        }

        public a c(String str) {
            this.f = true;
            this.g = str;
            return this;
        }

        public a a(boolean z) {
            this.h = true;
            this.i = z;
            return this;
        }

        public String e() {
            return this.k;
        }

        public a d(String str) {
            this.j = true;
            this.k = str;
            return this;
        }

        public void writeExternal(ObjectOutput objectOutput) {
            objectOutput.writeUTF(this.b);
            objectOutput.writeUTF(this.d);
            int c = c();
            objectOutput.writeInt(c);
            for (int i = 0; i < c; i++) {
                objectOutput.writeUTF((String) this.e.get(i));
            }
            objectOutput.writeBoolean(this.f);
            if (this.f) {
                objectOutput.writeUTF(this.g);
            }
            objectOutput.writeBoolean(this.j);
            if (this.j) {
                objectOutput.writeUTF(this.k);
            }
            objectOutput.writeBoolean(this.i);
        }

        public void readExternal(ObjectInput objectInput) {
            a(objectInput.readUTF());
            b(objectInput.readUTF());
            int readInt = objectInput.readInt();
            for (int i = 0; i < readInt; i++) {
                this.e.add(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                c(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                d(objectInput.readUTF());
            }
            a(objectInput.readBoolean());
        }
    }

    public static class b implements Externalizable {
        private boolean A;
        private d B = null;
        private boolean C;
        private d D = null;
        private boolean E;
        private d F = null;
        private boolean G;
        private String H = "";
        private boolean I;
        private int J = 0;
        private boolean K;
        private String L = "";
        private boolean M;
        private String N = "";
        private boolean O;
        private String P = "";
        private boolean Q;
        private String R = "";
        private boolean S;
        private String T = "";
        private boolean U;
        private String V = "";
        private boolean W;
        private boolean X = false;
        private List<a> Y = new ArrayList();
        private List<a> Z = new ArrayList();
        private boolean a;
        private boolean aa;
        private boolean ab = false;
        private boolean ac;
        private String ad = "";
        private boolean ae;
        private boolean af = false;
        private boolean ag;
        private boolean ah = false;
        private d b = null;
        private boolean c;
        private d d = null;
        private boolean e;
        private d f = null;
        private boolean g;
        private d h = null;
        private boolean i;
        private d j = null;
        private boolean k;
        private d l = null;
        private boolean m;
        private d n = null;
        private boolean o;
        private d p = null;
        private boolean q;
        private d r = null;
        private boolean s;
        private d t = null;
        private boolean u;
        private d v = null;
        private boolean w;
        private d x = null;
        private boolean y;
        private d z = null;

        public d a() {
            return this.b;
        }

        public b a(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.a = true;
            this.b = dVar;
            return this;
        }

        public b b(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.c = true;
            this.d = dVar;
            return this;
        }

        public b c(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.e = true;
            this.f = dVar;
            return this;
        }

        public b d(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.g = true;
            this.h = dVar;
            return this;
        }

        public b e(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.i = true;
            this.j = dVar;
            return this;
        }

        public b f(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.k = true;
            this.l = dVar;
            return this;
        }

        public b g(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.m = true;
            this.n = dVar;
            return this;
        }

        public b h(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.o = true;
            this.p = dVar;
            return this;
        }

        public b i(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.q = true;
            this.r = dVar;
            return this;
        }

        public b j(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.s = true;
            this.t = dVar;
            return this;
        }

        public b k(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.u = true;
            this.v = dVar;
            return this;
        }

        public b l(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.w = true;
            this.x = dVar;
            return this;
        }

        public b m(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.y = true;
            this.z = dVar;
            return this;
        }

        public b n(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.A = true;
            this.B = dVar;
            return this;
        }

        public b o(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.C = true;
            this.D = dVar;
            return this;
        }

        public b p(d dVar) {
            if (dVar == null) {
                throw new NullPointerException();
            }
            this.E = true;
            this.F = dVar;
            return this;
        }

        public b a(String str) {
            this.G = true;
            this.H = str;
            return this;
        }

        public int b() {
            return this.J;
        }

        public b a(int i) {
            this.I = true;
            this.J = i;
            return this;
        }

        public String c() {
            return this.L;
        }

        public b b(String str) {
            this.K = true;
            this.L = str;
            return this;
        }

        public b c(String str) {
            this.M = true;
            this.N = str;
            return this;
        }

        public b d(String str) {
            this.O = true;
            this.P = str;
            return this;
        }

        public boolean d() {
            return this.Q;
        }

        public String e() {
            return this.R;
        }

        public b e(String str) {
            this.Q = true;
            this.R = str;
            return this;
        }

        public String f() {
            return this.T;
        }

        public b f(String str) {
            this.S = true;
            this.T = str;
            return this;
        }

        public String g() {
            return this.V;
        }

        public b g(String str) {
            this.U = true;
            this.V = str;
            return this;
        }

        public b a(boolean z) {
            this.W = true;
            this.X = z;
            return this;
        }

        public List<a> h() {
            return this.Y;
        }

        public int i() {
            return this.Y.size();
        }

        public List<a> j() {
            return this.Z;
        }

        public int k() {
            return this.Z.size();
        }

        public b b(boolean z) {
            this.aa = true;
            this.ab = z;
            return this;
        }

        public b h(String str) {
            this.ac = true;
            this.ad = str;
            return this;
        }

        public b c(boolean z) {
            this.ae = true;
            this.af = z;
            return this;
        }

        public b d(boolean z) {
            this.ag = true;
            this.ah = z;
            return this;
        }

        public void writeExternal(ObjectOutput objectOutput) {
            int i;
            int i2 = 0;
            objectOutput.writeBoolean(this.a);
            if (this.a) {
                this.b.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.c);
            if (this.c) {
                this.d.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.e);
            if (this.e) {
                this.f.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.g);
            if (this.g) {
                this.h.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.i);
            if (this.i) {
                this.j.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.k);
            if (this.k) {
                this.l.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.m);
            if (this.m) {
                this.n.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.o);
            if (this.o) {
                this.p.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.q);
            if (this.q) {
                this.r.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.s);
            if (this.s) {
                this.t.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.u);
            if (this.u) {
                this.v.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.w);
            if (this.w) {
                this.x.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.y);
            if (this.y) {
                this.z.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.A);
            if (this.A) {
                this.B.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.C);
            if (this.C) {
                this.D.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.E);
            if (this.E) {
                this.F.writeExternal(objectOutput);
            }
            objectOutput.writeUTF(this.H);
            objectOutput.writeInt(this.J);
            objectOutput.writeUTF(this.L);
            objectOutput.writeBoolean(this.M);
            if (this.M) {
                objectOutput.writeUTF(this.N);
            }
            objectOutput.writeBoolean(this.O);
            if (this.O) {
                objectOutput.writeUTF(this.P);
            }
            objectOutput.writeBoolean(this.Q);
            if (this.Q) {
                objectOutput.writeUTF(this.R);
            }
            objectOutput.writeBoolean(this.S);
            if (this.S) {
                objectOutput.writeUTF(this.T);
            }
            objectOutput.writeBoolean(this.U);
            if (this.U) {
                objectOutput.writeUTF(this.V);
            }
            objectOutput.writeBoolean(this.X);
            int i3 = i();
            objectOutput.writeInt(i3);
            for (i = 0; i < i3; i++) {
                ((a) this.Y.get(i)).writeExternal(objectOutput);
            }
            i = k();
            objectOutput.writeInt(i);
            while (i2 < i) {
                ((a) this.Z.get(i2)).writeExternal(objectOutput);
                i2++;
            }
            objectOutput.writeBoolean(this.ab);
            objectOutput.writeBoolean(this.ac);
            if (this.ac) {
                objectOutput.writeUTF(this.ad);
            }
            objectOutput.writeBoolean(this.af);
            objectOutput.writeBoolean(this.ah);
        }

        public void readExternal(ObjectInput objectInput) {
            int i;
            int i2 = 0;
            if (objectInput.readBoolean()) {
                d dVar = new d();
                dVar.readExternal(objectInput);
                a(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                b(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                c(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                d(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                e(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                f(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                g(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                h(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                i(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                j(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                k(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                l(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                m(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                n(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                o(dVar);
            }
            if (objectInput.readBoolean()) {
                dVar = new d();
                dVar.readExternal(objectInput);
                p(dVar);
            }
            a(objectInput.readUTF());
            a(objectInput.readInt());
            b(objectInput.readUTF());
            if (objectInput.readBoolean()) {
                c(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                d(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                e(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                f(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                g(objectInput.readUTF());
            }
            a(objectInput.readBoolean());
            int readInt = objectInput.readInt();
            for (i = 0; i < readInt; i++) {
                a aVar = new a();
                aVar.readExternal(objectInput);
                this.Y.add(aVar);
            }
            i = objectInput.readInt();
            while (i2 < i) {
                a aVar2 = new a();
                aVar2.readExternal(objectInput);
                this.Z.add(aVar2);
                i2++;
            }
            b(objectInput.readBoolean());
            if (objectInput.readBoolean()) {
                h(objectInput.readUTF());
            }
            c(objectInput.readBoolean());
            d(objectInput.readBoolean());
        }
    }

    public static class c implements Externalizable {
        private List<b> a = new ArrayList();

        public List<b> a() {
            return this.a;
        }

        public int b() {
            return this.a.size();
        }

        public void writeExternal(ObjectOutput objectOutput) {
            int b = b();
            objectOutput.writeInt(b);
            for (int i = 0; i < b; i++) {
                ((b) this.a.get(i)).writeExternal(objectOutput);
            }
        }

        public void readExternal(ObjectInput objectInput) {
            int readInt = objectInput.readInt();
            for (int i = 0; i < readInt; i++) {
                b bVar = new b();
                bVar.readExternal(objectInput);
                this.a.add(bVar);
            }
        }
    }

    public static class d implements Externalizable {
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private List<Integer> e = new ArrayList();
        private List<Integer> f = new ArrayList();
        private boolean g;
        private String h = "";

        public String a() {
            return this.b;
        }

        public d a(String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        public String b() {
            return this.d;
        }

        public d b(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        public int c() {
            return this.e.size();
        }

        public int d() {
            return this.f.size();
        }

        public d c(String str) {
            this.g = true;
            this.h = str;
            return this;
        }

        public void writeExternal(ObjectOutput objectOutput) {
            int i;
            int i2 = 0;
            objectOutput.writeBoolean(this.a);
            if (this.a) {
                objectOutput.writeUTF(this.b);
            }
            objectOutput.writeBoolean(this.c);
            if (this.c) {
                objectOutput.writeUTF(this.d);
            }
            int c = c();
            objectOutput.writeInt(c);
            for (i = 0; i < c; i++) {
                objectOutput.writeInt(((Integer) this.e.get(i)).intValue());
            }
            i = d();
            objectOutput.writeInt(i);
            while (i2 < i) {
                objectOutput.writeInt(((Integer) this.f.get(i2)).intValue());
                i2++;
            }
            objectOutput.writeBoolean(this.g);
            if (this.g) {
                objectOutput.writeUTF(this.h);
            }
        }

        public void readExternal(ObjectInput objectInput) {
            int i;
            int i2 = 0;
            if (objectInput.readBoolean()) {
                a(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                b(objectInput.readUTF());
            }
            int readInt = objectInput.readInt();
            for (i = 0; i < readInt; i++) {
                this.e.add(Integer.valueOf(objectInput.readInt()));
            }
            i = objectInput.readInt();
            while (i2 < i) {
                this.f.add(Integer.valueOf(objectInput.readInt()));
                i2++;
            }
            if (objectInput.readBoolean()) {
                c(objectInput.readUTF());
            }
        }
    }
}
