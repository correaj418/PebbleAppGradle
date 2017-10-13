package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.b.as;

public class aa {
    private static Object a = new Object();
    private static boolean b;
    private static String c;
    private static int d;

    public static int a(Context context) {
        b(context);
        return d;
    }

    private static void b(Context context) {
        synchronized (a) {
            if (b) {
                return;
            }
            b = true;
            try {
                Bundle bundle = as.b(context).a(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                }
                c = bundle.getString("com.google.app.id");
                d = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }
}
