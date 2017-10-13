package com.b.a.e;

import com.b.a.g;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class b extends d {
    File a;

    public b(g gVar, File file) {
        super(gVar);
        this.a = file;
    }

    public OutputStream b() {
        OutputStream b = super.b();
        if (b != null) {
            return b;
        }
        b = new FileOutputStream(this.a);
        a(b);
        return b;
    }
}
