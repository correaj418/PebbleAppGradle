package com.b.a.f;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class c {
    static MessageDigest a;
    private static String j = "MD5";
    boolean b;
    Random c = new Random();
    long d = 4096;
    b e;
    File f;
    long g;
    Comparator<File> h = new Comparator<File>(this) {
        final /* synthetic */ c a;

        {
            this.a = r1;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((File) obj, (File) obj2);
        }

        public int a(File file, File file2) {
            long lastModified = file.lastModified();
            long lastModified2 = file2.lastModified();
            if (lastModified < lastModified2) {
                return -1;
            }
            if (lastModified2 > lastModified) {
                return 1;
            }
            return 0;
        }
    };
    boolean i;

    class a {
        final long a;
        final /* synthetic */ c b;

        public a(c cVar, File file) {
            this.b = cVar;
            this.a = file.length();
        }
    }

    class b extends f<String, a> {
        final /* synthetic */ c a;

        public b(c cVar) {
            this.a = cVar;
            super(cVar.g);
        }

        protected long a(String str, a aVar) {
            return Math.max(this.a.d, aVar.a);
        }

        protected void a(boolean z, String str, a aVar, a aVar2) {
            super.a(z, str, aVar, aVar2);
            if (aVar2 == null && !this.a.i) {
                new File(this.a.f, str).delete();
            }
        }
    }

    static {
        try {
            a = MessageDigest.getInstance(j);
        } catch (Throwable e) {
            a = c();
            if (a == null) {
                throw new RuntimeException(e);
            }
        }
        try {
            a = (MessageDigest) a.clone();
        } catch (CloneNotSupportedException e2) {
        }
    }

    private static MessageDigest c() {
        if ("MD5".equals(j)) {
            for (Provider services : Security.getProviders()) {
                for (Service algorithm : services.getServices()) {
                    j = algorithm.getAlgorithm();
                    try {
                        MessageDigest instance = MessageDigest.getInstance(j);
                        if (instance != null) {
                            return instance;
                        }
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
            }
        }
        return null;
    }

    public static synchronized String a(Object... objArr) {
        synchronized (c.class) {
            a.reset();
            for (Object obj : objArr) {
                a.update(obj.toString().getBytes());
            }
        }
        return new BigInteger(1, a.digest()).toString(16);
    }

    public File a() {
        File file;
        do {
            file = new File(this.f, new BigInteger(128, this.c).toString(16));
        } while (file.exists());
        return file;
    }

    public File[] a(int i) {
        File[] fileArr = new File[i];
        for (int i2 = 0; i2 < i; i2++) {
            fileArr[i2] = a();
        }
        return fileArr;
    }

    public static void a(File... fileArr) {
        if (fileArr != null) {
            for (File delete : fileArr) {
                delete.delete();
            }
        }
    }

    public void a(String str) {
        for (int i = 0; this.e.b((Object) b(str, i)) != null; i++) {
        }
        e(str);
    }

    public boolean b(String str) {
        return c(str, 0).exists();
    }

    public File a(File file) {
        this.e.a((Object) file.getName());
        file.setLastModified(System.currentTimeMillis());
        return file;
    }

    public FileInputStream c(String str) {
        return new FileInputStream(a(c(str, 0)));
    }

    public File d(String str) {
        return a(c(str, 0));
    }

    public FileInputStream[] a(String str, int i) {
        FileInputStream[] fileInputStreamArr = new FileInputStream[i];
        int i2 = 0;
        while (i2 < i) {
            try {
                fileInputStreamArr[i2] = new FileInputStream(a(c(str, i2)));
                i2++;
            } catch (IOException e) {
                int length = fileInputStreamArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    g.a(fileInputStreamArr[i3]);
                }
                a(str);
                throw e;
            }
        }
        return fileInputStreamArr;
    }

    String b(String str, int i) {
        return str + "." + i;
    }

    public void a(String str, File... fileArr) {
        e(str);
        int i = 0;
        while (i < fileArr.length) {
            File file = fileArr[i];
            File c = c(str, i);
            if (file.renameTo(c)) {
                a(file.getName());
                this.e.b(b(str, i), new a(this, c));
                i++;
            } else {
                a(fileArr);
                a(str);
                return;
            }
        }
    }

    void e(String str) {
        int i = 0;
        while (true) {
            File c = c(str, i);
            if (c.exists()) {
                c.delete();
                i++;
            } else {
                return;
            }
        }
    }

    File c(String str, int i) {
        return new File(this.f, b(str, i));
    }

    void b() {
        this.i = true;
        try {
            File[] listFiles = this.f.listFiles();
            if (listFiles != null) {
                ArrayList arrayList = new ArrayList();
                Collections.addAll(arrayList, listFiles);
                Collections.sort(arrayList, this.h);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file = (File) it.next();
                    String name = file.getName();
                    this.e.b(name, new a(this, file));
                    this.e.a((Object) name);
                }
                this.i = false;
            }
        } finally {
            this.i = false;
        }
    }

    private void d() {
        if (this.b) {
            new Thread(this) {
                final /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.b();
                }
            }.start();
        } else {
            b();
        }
    }

    public c(File file, long j, boolean z) {
        this.f = file;
        this.g = j;
        this.b = z;
        this.e = new b(this);
        file.mkdirs();
        d();
    }
}
