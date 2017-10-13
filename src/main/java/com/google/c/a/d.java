package com.google.c.a;

import com.google.c.a.i.b;
import com.google.c.a.i.c;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

final class d {
    private static final Logger a = Logger.getLogger(d.class.getName());
    private static final Map<Integer, b> b = Collections.synchronizedMap(new HashMap());
    private static final Map<String, b> c = Collections.synchronizedMap(new HashMap());
    private static final Set<Integer> d = a.a();
    private static final Set<String> e = l.a();

    private d() {
    }

    static c a(InputStream inputStream) {
        ObjectInputStream objectInputStream;
        Throwable e;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            try {
                c cVar = new c();
                cVar.readExternal(objectInputStream);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Throwable e2) {
                        a.log(Level.WARNING, "error closing input stream (ignored)", e2);
                    }
                } else {
                    inputStream.close();
                }
                return cVar;
            } catch (Throwable e22) {
                throw new RuntimeException("cannot load/parse metadata", e22);
            } catch (Throwable th) {
                e22 = th;
                if (objectInputStream == null) {
                    inputStream.close();
                } else {
                    try {
                        objectInputStream.close();
                    } catch (Throwable e3) {
                        a.log(Level.WARNING, "error closing input stream (ignored)", e3);
                    }
                }
                throw e22;
            }
        } catch (Throwable e222) {
            throw new RuntimeException("cannot load/parse metadata", e222);
        } catch (Throwable th2) {
            e222 = th2;
            objectInputStream = null;
            if (objectInputStream == null) {
                objectInputStream.close();
            } else {
                inputStream.close();
            }
            throw e222;
        }
    }
}
