package com.b.a.c.a;

import com.b.a.c.j;
import com.b.a.c.t;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class b extends f {
    File a;

    class AnonymousClass1 extends ArrayList<t> {
        final /* synthetic */ File a;

        AnonymousClass1(File file) {
            this.a = file;
            add(new j("filename", this.a.getName()));
        }
    }

    public b(String str, File file) {
        super(str, (long) ((int) file.length()), new AnonymousClass1(file));
        this.a = file;
    }

    protected InputStream a() {
        return new FileInputStream(this.a);
    }
}
