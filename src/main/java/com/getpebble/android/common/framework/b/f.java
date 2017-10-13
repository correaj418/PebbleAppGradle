package com.getpebble.android.common.framework.b;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipInputStream;

public class f {
    public static InputStream a(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("'context' may not be null!");
        } else if (str != null && str.length() >= 1) {
            return context.getAssets().open(str);
        } else {
            throw new IllegalArgumentException("'fileName' may not be null or empty!");
        }
    }

    public static String a(Context context, String str, boolean z) {
        Throwable e;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream zipInputStream;
            InputStream a = a(context, str);
            if (z) {
                zipInputStream = new ZipInputStream(a);
                zipInputStream.getNextEntry();
            } else {
                zipInputStream = a;
            }
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(zipInputStream));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine);
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                } catch (Throwable th) {
                    e = th;
                    bufferedReader = bufferedReader2;
                }
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable e3) {
                    com.getpebble.android.common.b.a.f.a("AssetUtil", "Unable to close buffered stream!", e3);
                }
            }
        } catch (IOException e4) {
            e3 = e4;
            try {
                com.getpebble.android.common.b.a.f.a("AssetUtil", "Unable to read buffered data!", e3);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e32) {
                        com.getpebble.android.common.b.a.f.a("AssetUtil", "Unable to close buffered stream!", e32);
                    }
                }
                return stringBuilder.toString();
            } catch (Throwable th2) {
                e32 = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e5) {
                        com.getpebble.android.common.b.a.f.a("AssetUtil", "Unable to close buffered stream!", e5);
                    }
                }
                throw e32;
            }
        }
        return stringBuilder.toString();
    }
}
