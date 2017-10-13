package c.a.a.a;

import c.a.a.a.b.a;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class e {
    public static final char a = File.separatorChar;
    public static final String b;

    static {
        Writer aVar = new a(4);
        PrintWriter printWriter = new PrintWriter(aVar);
        printWriter.println();
        b = aVar.toString();
        printWriter.close();
    }

    public static void a(Reader reader) {
        a((Closeable) reader);
    }

    public static void a(InputStream inputStream) {
        a((Closeable) inputStream);
    }

    public static void a(OutputStream outputStream) {
        a((Closeable) outputStream);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void a(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable a : closeableArr) {
                a(a);
            }
        }
    }

    @Deprecated
    public static String b(InputStream inputStream) {
        return a(inputStream, Charset.defaultCharset());
    }

    public static String a(InputStream inputStream, Charset charset) {
        Writer aVar = new a();
        a(inputStream, aVar, charset);
        return aVar.toString();
    }

    public static String b(Reader reader) {
        Writer aVar = new a();
        a(reader, aVar);
        return aVar.toString();
    }

    public static int a(InputStream inputStream, OutputStream outputStream) {
        long b = b(inputStream, outputStream);
        if (b > 2147483647L) {
            return -1;
        }
        return (int) b;
    }

    public static long a(InputStream inputStream, OutputStream outputStream, int i) {
        return a(inputStream, outputStream, new byte[i]);
    }

    public static long b(InputStream inputStream, OutputStream outputStream) {
        return a(inputStream, outputStream, 4096);
    }

    public static long a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public static void a(InputStream inputStream, Writer writer, Charset charset) {
        a(new InputStreamReader(inputStream, a.a(charset)), writer);
    }

    public static int a(Reader reader, Writer writer) {
        long b = b(reader, writer);
        if (b > 2147483647L) {
            return -1;
        }
        return (int) b;
    }

    public static long b(Reader reader, Writer writer) {
        return a(reader, writer, new char[4096]);
    }

    public static long a(Reader reader, Writer writer, char[] cArr) {
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += (long) read;
        }
    }
}
