package c.b.a.f;

import c.b.a.f;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class h implements f {
    private final File a;
    private final String b;
    private final ClassLoader c;
    private final Map<String, Object> d;
    private final Set<String> e;

    public h(File file) {
        if (file == null) {
            throw new IllegalArgumentException("No file directory provided");
        } else if (!file.exists()) {
            throw new IOException("File directory doesn't exist: " + file);
        } else if (file.isDirectory()) {
            this.a = file;
            this.b = null;
            this.c = null;
            this.d = a(b("ZoneInfoMap"));
            this.e = Collections.unmodifiableSortedSet(new TreeSet(this.d.keySet()));
        } else {
            throw new IOException("File doesn't refer to a directory: " + file);
        }
    }

    public h(String str) {
        this(str, null, false);
    }

    private h(String str, ClassLoader classLoader, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("No resource path provided");
        }
        if (!str.endsWith("/")) {
            str = str + '/';
        }
        this.a = null;
        this.b = str;
        if (classLoader == null && !z) {
            classLoader = getClass().getClassLoader();
        }
        this.c = classLoader;
        this.d = a(b("ZoneInfoMap"));
        this.e = Collections.unmodifiableSortedSet(new TreeSet(this.d.keySet()));
    }

    public f a(String str) {
        if (str == null) {
            return null;
        }
        Object obj = this.d.get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof SoftReference) {
            f fVar = (f) ((SoftReference) obj).get();
            if (fVar == null) {
                return c(str);
            }
            return fVar;
        } else if (str.equals(obj)) {
            return c(str);
        } else {
            return a((String) obj);
        }
    }

    public Set<String> a() {
        return this.e;
    }

    protected void a(Exception exception) {
        exception.printStackTrace();
    }

    private InputStream b(String str) {
        if (this.a != null) {
            return new FileInputStream(new File(this.a, str));
        }
        final String concat = this.b.concat(str);
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>(this) {
            final /* synthetic */ h b;

            public /* synthetic */ Object run() {
                return a();
            }

            public InputStream a() {
                if (this.b.c != null) {
                    return this.b.c.getResourceAsStream(concat);
                }
                return ClassLoader.getSystemResourceAsStream(concat);
            }
        });
        if (inputStream != null) {
            return inputStream;
        }
        throw new IOException("Resource not found: \"" + concat + "\" ClassLoader: " + (this.c != null ? this.c.toString() : "system"));
    }

    private f c(String str) {
        Exception e;
        Throwable th;
        InputStream b;
        try {
            b = b(str);
            try {
                f a = b.a(b, str);
                this.d.put(str, new SoftReference(a));
                if (b == null) {
                    return a;
                }
                try {
                    b.close();
                    return a;
                } catch (IOException e2) {
                    return a;
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    a(e);
                    this.d.remove(str);
                    if (b != null) {
                        try {
                            b.close();
                        } catch (IOException e4) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (b != null) {
                        try {
                            b.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            b = null;
            a(e);
            this.d.remove(str);
            if (b != null) {
                b.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            throw th;
        }
    }

    private static Map<String, Object> a(InputStream inputStream) {
        Map<String, Object> concurrentHashMap = new ConcurrentHashMap();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        try {
            a(dataInputStream, concurrentHashMap);
            concurrentHashMap.put("UTC", new SoftReference(f.a));
            return concurrentHashMap;
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException e) {
            }
        }
    }

    private static void a(DataInputStream dataInputStream, Map<String, Object> map) {
        int i;
        int i2 = 0;
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        String[] strArr = new String[readUnsignedShort];
        for (i = 0; i < readUnsignedShort; i++) {
            strArr[i] = dataInputStream.readUTF().intern();
        }
        i = dataInputStream.readUnsignedShort();
        while (i2 < i) {
            try {
                map.put(strArr[dataInputStream.readUnsignedShort()], strArr[dataInputStream.readUnsignedShort()]);
                i2++;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IOException("Corrupt zone info map");
            }
        }
    }
}
