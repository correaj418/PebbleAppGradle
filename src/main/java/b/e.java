package b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

public final class e {
    static final Logger a = Logger.getLogger(e.class.getName());

    private e() {
    }

    public static c a(l lVar) {
        if (lVar != null) {
            return new g(lVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static b a(k kVar) {
        if (kVar != null) {
            return new f(kVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static k a(OutputStream outputStream) {
        return a(outputStream, new m());
    }

    private static k a(final OutputStream outputStream, final m mVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (mVar != null) {
            return new k() {
                public void a(a aVar, long j) {
                    n.a(aVar.b, 0, j);
                    while (j > 0) {
                        mVar.a();
                        h hVar = aVar.a;
                        int min = (int) Math.min(j, (long) (hVar.c - hVar.b));
                        outputStream.write(hVar.a, hVar.b, min);
                        hVar.b += min;
                        j -= (long) min;
                        aVar.b -= (long) min;
                        if (hVar.b == hVar.c) {
                            aVar.a = hVar.a();
                            i.a(hVar);
                        }
                    }
                }

                public void flush() {
                    outputStream.flush();
                }

                public void close() {
                    outputStream.close();
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static l a(InputStream inputStream) {
        return a(inputStream, new m());
    }

    private static l a(final InputStream inputStream, final m mVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (mVar != null) {
            return new l() {
                public long b(a aVar, long j) {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (j == 0) {
                        return 0;
                    } else {
                        try {
                            mVar.a();
                            h d = aVar.d(1);
                            int read = inputStream.read(d.a, d.c, (int) Math.min(j, (long) (8192 - d.c)));
                            if (read == -1) {
                                return -1;
                            }
                            d.c += read;
                            aVar.b += (long) read;
                            return (long) read;
                        } catch (AssertionError e) {
                            if (e.a(e)) {
                                throw new IOException(e);
                            }
                            throw e;
                        }
                    }
                }

                public void close() {
                    inputStream.close();
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static k a(File file) {
        if (file != null) {
            return a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
