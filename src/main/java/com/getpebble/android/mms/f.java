package com.getpebble.android.mms;

import android.database.ContentObserver;
import com.getpebble.android.mms.b.b;
import com.getpebble.android.mms.b.c;
import java.util.ArrayList;
import java.util.List;

class f extends ContentObserver {
    private final b a;
    private final com.getpebble.android.mms.b.a b;
    private final c c;

    static class a {
        private List<Mms> a = new ArrayList();
        private List<Mms> b = new ArrayList();
        private List<Mms> c = new ArrayList();

        a() {
        }

        public List<Mms> a() {
            return this.c;
        }

        public List<Mms> b() {
            return this.a;
        }

        public List<Mms> c() {
            return this.b;
        }

        public void a(Mms mms) {
            this.c.add(mms);
        }

        public void b(Mms mms) {
            this.b.add(mms);
        }

        public void c(Mms mms) {
            this.a.add(mms);
        }
    }

    public f(com.getpebble.android.mms.b.a aVar, b bVar, c cVar) {
        super(null);
        this.a = bVar;
        this.b = aVar;
        this.c = cVar;
    }

    protected List<Integer> a() {
        List<Integer> arrayList = new ArrayList();
        for (Mms mms : this.a.c()) {
            arrayList.add(Integer.valueOf(mms.a));
        }
        return arrayList;
    }

    public void onChange(boolean z) {
        super.onChange(z);
        int a = this.a.a();
        int a2 = this.b.a();
        com.getpebble.android.common.b.a.f.c("MmsObserver", "onChange(): Pebble's last processed id: " + a + " Android's last entered id: " + a2 + " / hasIncompleteMessages = " + this.a.b());
        if (a2 > a || this.a.b()) {
            List a3 = this.b.a(a);
            a3.addAll(this.b.a(a()));
            com.getpebble.android.common.b.a.f.c("MmsObserver", "onChange(): mmsList's length: " + a3.size());
            this.a.a(this.c.a(a3));
        } else if (this.b.a() < a) {
            com.getpebble.android.common.b.a.f.f("MmsObserver", "PebbleMms's id should always be equal to or greater than Android's");
        }
    }
}
