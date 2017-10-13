package a.a.a;

import android.net.Uri.Builder;
import com.google.b.f;
import com.google.b.o;

public class e {
    public static String a = "https";
    public static String b = "api.wit.ai";
    public static String c = "20141022";
    private String d = null;
    private a e;
    private o f;

    public e(a aVar, o oVar) {
        this.e = aVar;
        this.f = oVar;
    }

    public Builder a() {
        Builder builder = new Builder();
        builder.scheme(a).authority(b).appendQueryParameter("v", c);
        if (this.d != null) {
            builder.appendQueryParameter("msg_id", this.d);
        }
        return builder;
    }

    protected Builder a(String str) {
        String a = this.e.a();
        Builder a2 = a();
        a2.appendPath(str);
        if (this.f != null) {
            a2.appendQueryParameter("context", new f().a(this.f));
        }
        if (a != null) {
            a2.appendQueryParameter("msg_id", a);
        }
        return a2;
    }
}
