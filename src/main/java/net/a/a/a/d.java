package net.a.a.a;

import android.content.Context;
import c.b.a.f.b;
import c.b.a.f.f;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import net.a.a.a.b.a;

public class d implements f {
    private Context a;
    private final Map<String, Object> b;

    public d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        this.a = context.getApplicationContext();
        this.b = a(b("ZoneInfoMap"));
    }

    public c.b.a.f a(String str) {
        if (str == null) {
            return null;
        }
        Object obj = this.b.get(str);
        if (obj == null) {
            return null;
        }
        if (str.equals(obj)) {
            return c(str);
        }
        if (!(obj instanceof SoftReference)) {
            return a((String) obj);
        }
        c.b.a.f fVar = (c.b.a.f) ((SoftReference) obj).get();
        if (fVar == null) {
            return c(str);
        }
        return fVar;
    }

    public Set<String> a() {
        return new TreeSet(this.b.keySet());
    }

    protected void a(Exception exception) {
        exception.printStackTrace();
    }

    private InputStream b(String str) {
        if (this.a == null) {
            throw new RuntimeException("Need to call JodaTimeAndroid.init() before using joda-time-android");
        }
        String a = c.a(str);
        int a2 = c.a(a.class, a);
        if (a2 != 0) {
            return this.a.getResources().openRawResource(a2);
        }
        throw new IOException("Resource not found: \"" + str + "\" (resName: \"" + a + "\")");
    }

    private c.b.a.f c(String str) {
        Exception e;
        Throwable th;
        InputStream b;
        try {
            b = b(str);
            try {
                c.b.a.f a = b.a(b, str);
                this.b.put(str, new SoftReference(a));
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
                    this.b.remove(str);
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
            this.b.remove(str);
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
            concurrentHashMap.put("UTC", new SoftReference(c.b.a.f.a));
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
