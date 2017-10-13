package net.hockeyapp.android;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.hockeyapp.android.c.a;
import net.hockeyapp.android.e.d;
import net.hockeyapp.android.e.h;

public class b {
    private static String a = null;
    private static String b = null;
    private static boolean c = false;

    public static void a(Context context, String str, c cVar) {
        a(context, "https://sdk.hockeyapp.net/", str, cVar);
    }

    public static void a(Context context, String str, String str2, c cVar) {
        a(context, str, str2, cVar, false);
        a(context, cVar);
    }

    public static void a(Context context, c cVar) {
        boolean z = true;
        boolean z2 = cVar != null && cVar.e();
        Boolean valueOf = Boolean.valueOf(z2);
        WeakReference weakReference = new WeakReference(context);
        int a = a(weakReference);
        if (a == 1) {
            if (context instanceof Activity) {
                z = false;
            }
            Boolean valueOf2 = Boolean.valueOf(Boolean.valueOf(z).booleanValue() | PreferenceManager.getDefaultSharedPreferences(context).getBoolean("always_send_crash_reports", false));
            if (cVar != null) {
                valueOf2 = Boolean.valueOf(Boolean.valueOf(valueOf2.booleanValue() | cVar.a()).booleanValue() | cVar.i());
                cVar.j();
            }
            if (valueOf2.booleanValue()) {
                b(weakReference, cVar, valueOf.booleanValue());
            } else {
                a(weakReference, cVar, valueOf.booleanValue());
            }
        } else if (a == 2) {
            if (cVar != null) {
                cVar.k();
            }
            b(weakReference, cVar, valueOf.booleanValue());
        } else {
            c(weakReference, cVar, valueOf.booleanValue());
        }
    }

    public static int a(WeakReference<Context> weakReference) {
        int i = 0;
        String[] b = b();
        List list = null;
        if (b == null || b.length <= 0) {
            return 0;
        }
        List asList;
        int length;
        if (weakReference != null) {
            try {
                Context context = (Context) weakReference.get();
                if (context != null) {
                    asList = Arrays.asList(context.getSharedPreferences("HockeySDK", 0).getString("ConfirmedFilenames", "").split("\\|"));
                    list = asList;
                    if (list != null) {
                        return 1;
                    }
                    length = b.length;
                    while (i < length) {
                        if (!list.contains(b[i])) {
                            return 1;
                        }
                        i++;
                    }
                    return 2;
                }
            } catch (Exception e) {
            }
        }
        asList = null;
        list = asList;
        if (list != null) {
            return 1;
        }
        length = b.length;
        while (i < length) {
            if (!list.contains(b[i])) {
                return 1;
            }
            i++;
        }
        return 2;
    }

    public static void a(WeakReference<Context> weakReference, c cVar, net.hockeyapp.android.c.b bVar) {
        String[] b = b();
        Boolean valueOf = Boolean.valueOf(false);
        if (b != null && b.length > 0) {
            Log.d("HockeyApp", "Found " + b.length + " stacktrace(s).");
            for (int i = 0; i < b.length; i++) {
                HttpURLConnection httpURLConnection = null;
                try {
                    String str = b[i];
                    String b2 = b(weakReference, str);
                    if (b2.length() > 0) {
                        Object c;
                        Log.d("HockeyApp", "Transmitting crash data: \n" + b2);
                        String b3 = b(weakReference, str.replace(".stacktrace", ".user"));
                        Object b4 = b(weakReference, str.replace(".stacktrace", ".contact"));
                        String str2;
                        if (bVar != null) {
                            c = bVar.c();
                            if (c == null || c.length() <= 0) {
                                str2 = b3;
                            }
                            b3 = bVar.b();
                            if (b3 != null && b3.length() > 0) {
                                b4 = b3;
                            }
                        } else {
                            str2 = b3;
                        }
                        str = b(weakReference, str.replace(".stacktrace", ".description"));
                        Object a = bVar != null ? bVar.a() : "";
                        if (str != null && str.length() > 0) {
                            a = (a == null || a.length() <= 0) ? String.format("Log:\n%s", new Object[]{str}) : String.format("%s\n\nLog:\n%s", new Object[]{a, str});
                        }
                        Map hashMap = new HashMap();
                        hashMap.put("raw", b2);
                        hashMap.put("userID", c);
                        hashMap.put("contact", b4);
                        hashMap.put("description", a);
                        hashMap.put("sdk", "HockeySDK");
                        hashMap.put("sdk_version", "3.7.0");
                        httpURLConnection = new d(a()).a("POST").a(hashMap).a();
                        int responseCode = httpURLConnection.getResponseCode();
                        boolean z = responseCode == 202 || responseCode == 201;
                        valueOf = Boolean.valueOf(z);
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (valueOf.booleanValue()) {
                        Log.d("HockeyApp", "Transmission succeeded");
                        a((WeakReference) weakReference, b[i]);
                        if (cVar != null) {
                            cVar.l();
                            b((WeakReference) weakReference, b[i], cVar.o());
                        }
                    } else {
                        Log.d("HockeyApp", "Transmission failed, will retry on next register() call");
                        if (cVar != null) {
                            cVar.m();
                            a((WeakReference) weakReference, b[i], cVar.o());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (valueOf.booleanValue()) {
                        Log.d("HockeyApp", "Transmission succeeded");
                        a((WeakReference) weakReference, b[i]);
                        if (cVar != null) {
                            cVar.l();
                            b((WeakReference) weakReference, b[i], cVar.o());
                        }
                    } else {
                        Log.d("HockeyApp", "Transmission failed, will retry on next register() call");
                        if (cVar != null) {
                            cVar.m();
                            a((WeakReference) weakReference, b[i], cVar.o());
                        }
                    }
                } catch (Throwable th) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (valueOf.booleanValue()) {
                        Log.d("HockeyApp", "Transmission succeeded");
                        a((WeakReference) weakReference, b[i]);
                        if (cVar != null) {
                            cVar.l();
                            b((WeakReference) weakReference, b[i], cVar.o());
                        }
                    } else {
                        Log.d("HockeyApp", "Transmission failed, will retry on next register() call");
                        if (cVar != null) {
                            cVar.m();
                            a((WeakReference) weakReference, b[i], cVar.o());
                        }
                    }
                }
            }
        }
    }

    public static void b(WeakReference<Context> weakReference) {
        String[] b = b();
        if (b != null && b.length > 0) {
            Log.d("HockeyApp", "Found " + b.length + " stacktrace(s).");
            for (int i = 0; i < b.length; i++) {
                if (weakReference != null) {
                    try {
                        Log.d("HockeyApp", "Delete stacktrace " + b[i] + ".");
                        a((WeakReference) weakReference, b[i]);
                        Context context = (Context) weakReference.get();
                        if (context != null) {
                            context.deleteFile(b[i]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static boolean a(a aVar, net.hockeyapp.android.c.b bVar, c cVar, WeakReference<Context> weakReference, boolean z) {
        switch (aVar) {
            case CrashManagerUserInputDontSend:
                if (cVar != null) {
                    cVar.n();
                }
                b(weakReference);
                c(weakReference, cVar, z);
                return true;
            case CrashManagerUserInputAlwaysSend:
                Context context = null;
                if (weakReference != null) {
                    context = (Context) weakReference.get();
                }
                if (context == null) {
                    return false;
                }
                PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("always_send_crash_reports", true).apply();
                a((WeakReference) weakReference, cVar, z, bVar);
                return true;
            case CrashManagerUserInputSend:
                a((WeakReference) weakReference, cVar, z, bVar);
                return true;
            default:
                return false;
        }
    }

    private static void a(Context context, String str, String str2, c cVar, boolean z) {
        if (context != null) {
            b = str;
            a = h.c(str2);
            a.a(context);
            if (a == null) {
                a = a.d;
            }
            if (z) {
                boolean z2 = cVar != null && cVar.e();
                c(new WeakReference(context), cVar, Boolean.valueOf(z2).booleanValue());
            }
        }
    }

    private static void a(final WeakReference<Context> weakReference, final c cVar, final boolean z) {
        Context context = null;
        if (weakReference != null) {
            context = (Context) weakReference.get();
        }
        if (context != null) {
            if (cVar == null || !cVar.p()) {
                Builder builder = new Builder(context);
                builder.setTitle(a(context));
                builder.setMessage(i.d.hockeyapp_crash_dialog_message);
                builder.setNegativeButton(i.d.hockeyapp_crash_dialog_negative_button, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        b.a(a.CrashManagerUserInputDontSend, null, cVar, weakReference, z);
                    }
                });
                builder.setNeutralButton(i.d.hockeyapp_crash_dialog_neutral_button, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        b.a(a.CrashManagerUserInputAlwaysSend, null, cVar, weakReference, z);
                    }
                });
                builder.setPositiveButton(i.d.hockeyapp_dialog_positive_button, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        b.a(a.CrashManagerUserInputSend, null, cVar, weakReference, z);
                    }
                });
                builder.create().show();
            }
        }
    }

    private static String a(Context context) {
        String b = h.b(context);
        return String.format(context.getString(i.d.hockeyapp_crash_dialog_title), new Object[]{b});
    }

    private static void b(WeakReference<Context> weakReference, c cVar, boolean z) {
        a((WeakReference) weakReference, cVar, z, null);
    }

    private static void a(final WeakReference<Context> weakReference, final c cVar, boolean z, final net.hockeyapp.android.c.b bVar) {
        c(weakReference);
        c(weakReference, cVar, z);
        Context context = (Context) weakReference.get();
        if ((context == null || h.a(context)) && !c) {
            c = true;
            new Thread() {
                public void run() {
                    b.a(weakReference, cVar, bVar);
                    b.c = false;
                }
            }.start();
        }
    }

    private static void c(WeakReference<Context> weakReference, c cVar, boolean z) {
        if (a.b == null || a.d == null) {
            Log.d("HockeyApp", "Exception handler not set because version or package is null.");
            return;
        }
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            Log.d("HockeyApp", "Current handler class = " + defaultUncaughtExceptionHandler.getClass().getName());
        }
        if (defaultUncaughtExceptionHandler instanceof d) {
            ((d) defaultUncaughtExceptionHandler).a(cVar);
        } else {
            Thread.setDefaultUncaughtExceptionHandler(new d(defaultUncaughtExceptionHandler, cVar, z));
        }
    }

    private static String a() {
        return b + "api/2/apps/" + a + "/crashes/";
    }

    private static void a(WeakReference<Context> weakReference, String str, int i) {
        if (i != -1 && weakReference != null) {
            Context context = (Context) weakReference.get();
            if (context != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("HockeySDK", 0);
                Editor edit = sharedPreferences.edit();
                int i2 = sharedPreferences.getInt("RETRY_COUNT: " + str, 0);
                if (i2 >= i) {
                    a((WeakReference) weakReference, str);
                    b((WeakReference) weakReference, str, i);
                    return;
                }
                edit.putInt("RETRY_COUNT: " + str, i2 + 1);
                edit.apply();
            }
        }
    }

    private static void b(WeakReference<Context> weakReference, String str, int i) {
        if (weakReference != null) {
            Context context = (Context) weakReference.get();
            if (context != null) {
                Editor edit = context.getSharedPreferences("HockeySDK", 0).edit();
                edit.remove("RETRY_COUNT: " + str);
                edit.apply();
            }
        }
    }

    private static void a(WeakReference<Context> weakReference, String str) {
        if (weakReference != null) {
            Context context = (Context) weakReference.get();
            if (context != null) {
                context.deleteFile(str);
                context.deleteFile(str.replace(".stacktrace", ".user"));
                context.deleteFile(str.replace(".stacktrace", ".contact"));
                context.deleteFile(str.replace(".stacktrace", ".description"));
            }
        }
    }

    private static String b(WeakReference<Context> weakReference, String str) {
        IOException e;
        Throwable th;
        BufferedReader bufferedReader = null;
        if (weakReference != null) {
            Context context = (Context) weakReference.get();
            if (context != null) {
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader bufferedReader2;
                try {
                    bufferedReader2 = new BufferedReader(new InputStreamReader(context.openFileInput(str)));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuilder.append(readLine);
                            stringBuilder.append(System.getProperty("line.separator"));
                        } catch (FileNotFoundException e2) {
                            bufferedReader = bufferedReader2;
                        } catch (IOException e3) {
                            e = e3;
                        }
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (FileNotFoundException e5) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                        }
                    }
                    return stringBuilder.toString();
                } catch (IOException e7) {
                    e = e7;
                    bufferedReader2 = null;
                    try {
                        e.printStackTrace();
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e8) {
                            }
                        }
                        return stringBuilder.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e9) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader2 = null;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    throw th;
                }
                return stringBuilder.toString();
            }
        }
        return null;
    }

    private static void c(WeakReference<Context> weakReference) {
        if (weakReference != null) {
            Context context = (Context) weakReference.get();
            if (context != null) {
                try {
                    String[] b = b();
                    Editor edit = context.getSharedPreferences("HockeySDK", 0).edit();
                    edit.putString("ConfirmedFilenames", a(b, "|"));
                    edit.apply();
                } catch (Exception e) {
                }
            }
        }
    }

    private static String a(String[] strArr, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            stringBuffer.append(strArr[i]);
            if (i < strArr.length - 1) {
                stringBuffer.append(str);
            }
        }
        return stringBuffer.toString();
    }

    private static String[] b() {
        if (a.a != null) {
            Log.d("HockeyApp", "Looking for exceptions in: " + a.a);
            File file = new File(a.a + "/");
            if (file.mkdir() || file.exists()) {
                return file.list(new FilenameFilter() {
                    public boolean accept(File file, String str) {
                        return str.endsWith(".stacktrace");
                    }
                });
            }
            return new String[0];
        }
        Log.d("HockeyApp", "Can't search for exception as file path is null.");
        return null;
    }
}
