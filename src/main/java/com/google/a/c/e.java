package com.google.a.c;

import com.google.a.a.h;
import com.google.a.b.cd;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class e {
    private static final cd<File> a = new cd<File>() {
        public String toString() {
            return "Files.fileTreeTraverser()";
        }
    };

    static class AnonymousClass1 {
    }

    private static final class a extends a {
        private final File a;

        public /* synthetic */ InputStream a() {
            return c();
        }

        private a(File file) {
            this.a = (File) h.a((Object) file);
        }

        public FileInputStream c() {
            return new FileInputStream(this.a);
        }

        public byte[] b() {
            d a = d.a();
            try {
                FileInputStream fileInputStream = (FileInputStream) a.a(c());
                byte[] a2 = e.a(fileInputStream, fileInputStream.getChannel().size());
                a.close();
                return a2;
            } catch (Throwable th) {
                a.close();
            }
        }

        public String toString() {
            return "Files.asByteSource(" + this.a + ")";
        }
    }

    public static a a(File file) {
        return new a(file);
    }

    static byte[] a(InputStream inputStream, long j) {
        if (j <= 2147483647L) {
            return j == 0 ? b.a(inputStream) : b.a(inputStream, (int) j);
        } else {
            throw new OutOfMemoryError("file is too large to fit in a byte array: " + j + " bytes");
        }
    }

    public static byte[] b(File file) {
        return a(file).b();
    }
}
