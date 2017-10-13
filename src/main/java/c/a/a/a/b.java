package c.a.a.a;

import c.a.a.a.a.c;
import c.a.a.a.a.d;
import c.a.a.a.a.e;
import c.a.a.a.a.f;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Collection;
import java.util.LinkedList;

public class b {
    public static final BigInteger a = BigInteger.valueOf(1024);
    public static final BigInteger b = a.multiply(a);
    public static final BigInteger c = a.multiply(b);
    public static final BigInteger d = a.multiply(c);
    public static final BigInteger e = a.multiply(d);
    public static final BigInteger f = a.multiply(e);
    public static final BigInteger g = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(1152921504606846976L));
    public static final BigInteger h = a.multiply(g);
    public static final File[] i = new File[0];

    private static void a(Collection<File> collection, File file, f fVar, boolean z) {
        File[] listFiles = file.listFiles(fVar);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    if (z) {
                        collection.add(file2);
                    }
                    a(collection, file2, fVar, z);
                } else {
                    collection.add(file2);
                }
            }
        }
    }

    public static Collection<File> a(File file, f fVar, f fVar2) {
        a(file, fVar);
        f a = a(fVar);
        f b = b(fVar2);
        Collection<File> linkedList = new LinkedList();
        a(linkedList, file, e.b(a, b), false);
        return linkedList;
    }

    private static void a(File file, f fVar) {
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Parameter 'directory' is not a directory: " + file);
        } else if (fVar == null) {
            throw new NullPointerException("Parameter 'fileFilter' is null");
        }
    }

    private static f a(f fVar) {
        return e.a(fVar, e.a(c.b));
    }

    private static f b(f fVar) {
        if (fVar == null) {
            return d.b;
        }
        return e.a(fVar, c.b);
    }

    public static void a(File file, File file2) {
        a(file, file2, true);
    }

    public static void a(File file, File file2, boolean z) {
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file2.exists() || file2.isDirectory()) {
            b(file, new File(file2, file.getName()), z);
        } else {
            throw new IllegalArgumentException("Destination '" + file2 + "' is not a directory");
        }
    }

    public static void b(File file, File file2) {
        b(file, file2, true);
    }

    public static void b(File file, File file2, boolean z) {
        c(file, file2);
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        } else {
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Destination '" + parentFile + "' directory cannot be created");
            } else if (!file2.exists() || file2.canWrite()) {
                c(file, file2, z);
            } else {
                throw new IOException("Destination '" + file2 + "' exists but is read-only");
            }
        }
    }

    public static long a(File file, OutputStream outputStream) {
        InputStream fileInputStream = new FileInputStream(file);
        try {
            long b = e.b(fileInputStream, outputStream);
            return b;
        } finally {
            fileInputStream.close();
        }
    }

    private static void c(File file, File file2, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        Object obj;
        Closeable closeable;
        Object obj2;
        Object obj3;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        Closeable closeable2 = null;
        Closeable closeable3 = null;
        Closeable closeable4 = null;
        try {
            ReadableByteChannel channel;
            FileChannel channel2;
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th2) {
                th = th2;
                obj = fileInputStream;
                Closeable closeable5 = closeable4;
                closeable4 = null;
                closeable = closeable5;
                e.a(closeable4, closeable3, closeable, closeable2);
                throw th;
            }
            try {
                channel = fileInputStream.getChannel();
                try {
                    channel2 = fileOutputStream.getChannel();
                } catch (Throwable th3) {
                    th = th3;
                    obj2 = fileOutputStream;
                    obj = fileInputStream;
                    obj3 = channel;
                    closeable4 = null;
                    e.a(closeable4, closeable3, closeable, closeable2);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                obj2 = fileOutputStream;
                obj = fileInputStream;
                closeable = closeable4;
                closeable4 = null;
                e.a(closeable4, closeable3, closeable, closeable2);
                throw th;
            }
            try {
                long size = channel.size();
                long j = 0;
                while (j < size) {
                    long j2 = size - j;
                    if (j2 > 31457280) {
                        j2 = 31457280;
                    }
                    j2 = channel2.transferFrom(channel, j, j2);
                    if (j2 == 0) {
                        break;
                    }
                    j += j2;
                }
                e.a(channel2, fileOutputStream, channel, fileInputStream);
                long length = file.length();
                j = file2.length();
                if (length != j) {
                    throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + j);
                } else if (z) {
                    file2.setLastModified(file.lastModified());
                }
            } catch (Throwable th5) {
                obj2 = fileOutputStream;
                obj = fileInputStream;
                ReadableByteChannel readableByteChannel = channel;
                Object obj4 = channel2;
                th = th5;
                obj3 = readableByteChannel;
                e.a(closeable4, closeable3, closeable, closeable2);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable = closeable4;
            closeable4 = null;
            e.a(closeable4, closeable3, closeable, closeable2);
            throw th;
        }
    }

    private static void c(File file, File file2) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
    }

    public static void a(File file) {
        if (file.exists()) {
            if (!e(file)) {
                c(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    public static boolean b(File file) {
        boolean z = false;
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    c(file);
                }
            } catch (Exception e) {
            }
            try {
                z = file.delete();
            } catch (Exception e2) {
            }
        }
        return z;
    }

    public static void c(File file) {
        IOException iOException = null;
        for (File d : f(file)) {
            try {
                d(d);
            } catch (IOException e) {
                iOException = e;
            }
        }
        if (iOException != null) {
            throw iOException;
        }
    }

    private static File[] f(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                return listFiles;
            }
            throw new IOException("Failed to list contents of " + file);
        } else {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }

    public static void d(File file) {
        if (file.isDirectory()) {
            a(file);
            return;
        }
        boolean exists = file.exists();
        if (!file.delete()) {
            if (exists) {
                throw new IOException("Unable to delete file: " + file);
            }
            throw new FileNotFoundException("File does not exist: " + file);
        }
    }

    public static boolean e(File file) {
        if (f.a()) {
            return f.a(file);
        }
        if (file == null) {
            throw new NullPointerException("File must not be null");
        } else if (c.a()) {
            return false;
        } else {
            File file2;
            if (file.getParent() == null) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile().getCanonicalFile(), file.getName());
            }
            if (file2.getCanonicalFile().equals(file2.getAbsoluteFile())) {
                return g(file);
            }
            return true;
        }
    }

    private static boolean g(File file) {
        if (file.exists()) {
            return false;
        }
        final File canonicalFile = file.getCanonicalFile();
        File parentFile = canonicalFile.getParentFile();
        if (parentFile == null || !parentFile.exists()) {
            return false;
        }
        File[] listFiles = parentFile.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.equals(canonicalFile);
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            return false;
        }
        return true;
    }
}
