package a.a.a;

import android.content.Context;
import android.util.Log;
import com.google.b.f;
import com.google.b.o;

public class b {
    public a a = a.detectSpeechStop;
    private String b;
    private a c;
    private o d = new o();
    private Context e;

    public enum a {
        disabled,
        detectSpeechStop,
        full
    }

    public b(String str, a aVar) {
        this.b = str;
        this.c = aVar;
    }

    public void a(String str) {
        if (str == null) {
            this.c.a(null, null, new Error("Input Text null"));
        }
        c cVar = new c(this.d, this.e);
        new d(this, this.b, this.d, this.c) {
            final /* synthetic */ b a;

            protected /* synthetic */ void onPostExecute(Object obj) {
                a((String) obj);
            }

            protected void a(String str) {
                this.a.b(str);
            }
        }.execute(new String[]{str});
    }

    private void b(String str) {
        a.a.a.a.b bVar;
        Error error;
        Exception exception;
        Log.d("Wit", "Wit : Response " + str);
        try {
            f fVar = new f();
            a.a.a.a.b bVar2 = (a.a.a.a.b) fVar.a(str, a.a.a.a.b.class);
            try {
                Log.d("Wit", "Gson : Response " + fVar.b((Object) bVar2));
                bVar = bVar2;
                error = null;
            } catch (Exception e) {
                Exception exception2 = e;
                bVar = bVar2;
                exception = exception2;
                Log.e("Wit", "Wit : Error " + exception.getMessage());
                error = new Error(exception.getMessage());
                if (error == null) {
                    this.c.a(null, null, error);
                } else if (bVar != null) {
                    this.c.a(null, null, new Error("Response null"));
                } else if (bVar.b().size() == 0) {
                    Log.d("Wit", "Wit did grasp " + bVar.b().size() + " outcome(s)");
                    this.c.a(bVar.b(), bVar.a(), null);
                } else {
                    this.c.a(null, null, new Error("No outcome"));
                }
            }
        } catch (Exception e2) {
            exception = e2;
            bVar = null;
            Log.e("Wit", "Wit : Error " + exception.getMessage());
            error = new Error(exception.getMessage());
            if (error == null) {
                this.c.a(null, null, error);
            } else if (bVar != null) {
                this.c.a(null, null, new Error("Response null"));
            } else if (bVar.b().size() == 0) {
                this.c.a(null, null, new Error("No outcome"));
            } else {
                Log.d("Wit", "Wit did grasp " + bVar.b().size() + " outcome(s)");
                this.c.a(bVar.b(), bVar.a(), null);
            }
        }
        if (error == null) {
            this.c.a(null, null, error);
        } else if (bVar != null) {
            this.c.a(null, null, new Error("Response null"));
        } else if (bVar.b().size() == 0) {
            this.c.a(null, null, new Error("No outcome"));
        } else {
            Log.d("Wit", "Wit did grasp " + bVar.b().size() + " outcome(s)");
            this.c.a(bVar.b(), bVar.a(), null);
        }
    }

    public void a(Context context) {
        this.e = context;
    }
}
