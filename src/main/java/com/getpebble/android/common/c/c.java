package com.getpebble.android.common.c;

import android.content.Context;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.main.sections.support.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

public class c {
    private static final long a = TimeUnit.DAYS.toMillis(30);

    public static abstract class a {
        public abstract void directoryFound(File file);

        public abstract void fileFound(File file);
    }

    public static void a(File file, a aVar) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            f.b("FileUtil", "null list to walk: " + file);
            return;
        }
        for (File file2 : listFiles) {
            if (file2 != null) {
                if (file2.isDirectory()) {
                    aVar.directoryFound(file2);
                    a(file2, aVar);
                } else {
                    aVar.fileFound(file2);
                }
            }
        }
    }

    public static void a(Context context) {
        if (context == null) {
            f.c("FileUtil", "purgeTemporaryFiles: context is null");
            return;
        }
        try {
            a(context.getExternalFilesDir(null), true);
        } catch (NullPointerException e) {
            f.b("FileUtil", "NPE getting attempting to purge files from external files dir");
        } catch (Throwable e2) {
            f.b("FileUtil", "ArrayOutOfBounds attempting to purge files from external dir", e2);
        }
        a(b.getFileProviderDir(context), true);
        a(context.getFilesDir(), false);
        a(context.getCacheDir(), false);
        a(context.getDir("apps", 0), false);
        a(context.getDir("languages", 0), false);
        a(context.getDir("firmware", 0), false);
        a(context.getDir("logs", 0), false);
        a(com.getpebble.android.main.sections.support.a.a(context), true, com.getpebble.android.main.sections.support.a.a);
    }

    private static void a(File file, boolean z) {
        a(file, z, -1);
    }

    private static void a(File file, final boolean z, final long j) {
        if (file == null) {
            f.b("FileUtil", "null dir to purge");
            return;
        }
        System.currentTimeMillis();
        f.d("FileUtil", "walking.. " + file.toString());
        try {
            a(file, new a() {
                public void directoryFound(File file) {
                }

                public void fileFound(File file) {
                    Object obj = (z || file.getAbsoluteFile().toString().contains("keen") || file.getName().endsWith(".pbw") || file.getName().endsWith(".pbz") || file.getName().endsWith(".pbl") || file.getName().endsWith(".log") || file.getName().endsWith(".gz") || file.getName().endsWith(".bin")) ? 1 : null;
                    if (obj != null) {
                        if (j != -1) {
                            if (file.lastModified() > System.currentTimeMillis() - j) {
                                f.e("FileUtil", "Not deleting " + file + " (not old enough for cutoff yet)");
                                return;
                            }
                        }
                        f.d("FileUtil", "purgeFilesRecursively: deleting... " + file.getPath());
                        if (!file.delete()) {
                            f.b("FileUtil", "purgeFilesRecursively: error deleting " + file + "!");
                        }
                    }
                }
            });
        } catch (Throwable e) {
            f.a("FileUtil", "purgeFilesRecursively()", e);
        }
    }

    public static boolean a(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            return false;
        }
    }

    public static void a(File file, File file2) {
        FileChannel channel;
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream;
        FileChannel fileChannel = null;
        if (!file2.exists()) {
            file2.createNewFile();
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                channel = fileInputStream2.getChannel();
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = null;
                    fileInputStream = fileInputStream2;
                    fileChannel = channel;
                    channel = null;
                    if (fileChannel != null) {
                        fileChannel.close();
                    } else if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (channel != null) {
                        channel.close();
                    } else if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j = 0;
                        while (j < size) {
                            long transferFrom = channel2.transferFrom(channel, 0, channel.size()) + j;
                            channel2.position(transferFrom);
                            j = transferFrom;
                        }
                        if (channel != null) {
                            channel.close();
                        } else if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (channel2 != null) {
                            channel2.close();
                        } else if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th3) {
                        fileOutputStream2 = fileOutputStream;
                        fileInputStream = fileInputStream2;
                        FileChannel fileChannel2 = channel;
                        channel = channel2;
                        th = th3;
                        fileChannel = fileChannel2;
                        if (fileChannel != null) {
                            fileChannel.close();
                        } else if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (channel != null) {
                            channel.close();
                        } else if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream2 = fileOutputStream;
                    fileInputStream = fileInputStream2;
                    fileChannel = channel;
                    channel = null;
                    if (fileChannel != null) {
                        fileChannel.close();
                    } else if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (channel != null) {
                        channel.close();
                    } else if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                channel = null;
                fileOutputStream2 = null;
                fileInputStream = fileInputStream2;
                if (fileChannel != null) {
                    fileChannel.close();
                } else if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (channel != null) {
                    channel.close();
                } else if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            channel = null;
            fileOutputStream2 = null;
            fileInputStream = null;
            if (fileChannel != null) {
                fileChannel.close();
            } else if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (channel != null) {
                channel.close();
            } else if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public static File a(String str, String str2) {
        return new File(com.getpebble.android.bluetooth.h.b.a().getDir(str, 0), str2);
    }
}
