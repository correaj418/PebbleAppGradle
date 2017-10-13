package com.b.b;

import android.graphics.Bitmap;
import com.b.a.b.f;
import com.b.b.a.b;
import com.b.b.a.g;
import com.b.b.a.j;
import java.util.ArrayList;
import java.util.Iterator;

class aa extends a implements f<b> {
    ArrayList<j> d;
    ArrayList<g> e;
    String f;

    public /* synthetic */ void a(Exception exception, Object obj) {
        b(exception, (b) obj);
    }

    public aa(j jVar, String str, String str2, ArrayList<j> arrayList, ArrayList<g> arrayList2) {
        super(jVar, str, true);
        this.d = arrayList;
        this.f = str2;
        this.e = arrayList2;
    }

    public void b(Exception exception, final b bVar) {
        if (exception != null) {
            a(exception, null);
        } else if (this.b.x.a(this.a) == this) {
            j.a().execute(new Runnable(this) {
                final /* synthetic */ aa b;

                public void run() {
                    if (this.b.b.x.a(this.b.a) == this.b) {
                        try {
                            Bitmap bitmap = bVar.f;
                            Iterator it = this.b.d.iterator();
                            Bitmap bitmap2 = bitmap;
                            while (it.hasNext()) {
                                bitmap = ((j) it.next()).a(bitmap2);
                                if (bitmap == null) {
                                    throw new Exception("failed to transform bitmap");
                                }
                                bitmap2 = bitmap;
                            }
                            b bVar = new b(this.b.a, bVar.k, bitmap2, bVar.a);
                            bVar.e = bVar.e;
                            if (this.b.e != null) {
                                Iterator it2 = this.b.e.iterator();
                                while (it2.hasNext()) {
                                    ((g) it2.next()).a(bVar);
                                }
                            }
                            this.b.a(null, bVar);
                        } catch (Throwable e) {
                            this.b.a(new Exception(e), null);
                        } catch (Exception e2) {
                            this.b.a(e2, null);
                        }
                    }
                }
            });
        }
    }
}
