package net.hockeyapp.android.c;

import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import net.hockeyapp.android.a;

public class e implements Serializable {
    private int a;
    private int b;
    private String c;
    private String d;
    private String e;
    private String f;

    public void a(int i) {
        this.a = i;
    }

    public void b(int i) {
        this.b = i;
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public void c(String str) {
        this.e = str;
    }

    public void d(String str) {
        this.f = str;
    }

    public String c() {
        return "" + this.b + this.a;
    }

    public boolean d() {
        File a = a.a();
        if (!a.exists() || !a.isDirectory()) {
            return false;
        }
        File[] listFiles = a.listFiles(new FilenameFilter(this) {
            final /* synthetic */ e a;

            {
                this.a = r1;
            }

            public boolean accept(File file, String str) {
                return str.equals(this.a.c());
            }
        });
        if (listFiles == null || listFiles.length != 1) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "\n" + e.class.getSimpleName() + "\n" + "id         " + this.a + "\n" + "message id " + this.b + "\n" + "filename   " + this.c + "\n" + "url        " + this.d + "\n" + "createdAt  " + this.e + "\n" + "updatedAt  " + this.f;
    }
}
