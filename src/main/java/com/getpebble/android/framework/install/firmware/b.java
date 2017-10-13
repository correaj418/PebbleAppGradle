package com.getpebble.android.framework.install.firmware;

import android.content.Context;
import com.getpebble.android.common.framework.install.a;
import com.getpebble.android.common.model.av;
import com.getpebble.android.common.model.v;
import com.getpebble.android.framework.install.c;
import com.getpebble.android.framework.timeline.h;
import com.getpebble.android.h.p;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.zip.ZipFile;

public class b extends c<a> {
    private Context b;

    public /* synthetic */ a a(File file) {
        return b(file);
    }

    public b(Context context) {
        super(context);
        this.b = context;
    }

    public String a() {
        return "firmware";
    }

    public a b(File file) {
        if (file.exists()) {
            ZipFile zipFile = new ZipFile(file);
            return new a(zipFile, a(zipFile));
        }
        throw new FileNotFoundException("Could not find " + file);
    }

    protected void a(a aVar) {
        h i = aVar.i();
        if (i != null) {
            v l = aVar.l();
            if (l != null) {
                av.a(this.b.getContentResolver(), av.a.a(l, aVar.h().getFirmware().getHardwareRevision(), p.a(i)));
            }
        }
    }
}
