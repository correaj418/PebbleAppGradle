package com.getpebble.android.framework.o;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.PhoneLookup;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Patterns;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.framework.m.j;
import com.getpebble.android.h.v;
import com.getpebble.android.h.v.a;
import com.google.a.a.k;
import com.google.c.a.g;
import com.google.c.a.h;
import java.lang.reflect.Method;
import java.util.Locale;

public class c {
    public static String a(Context context, String str) {
        Cursor query;
        String string;
        Throwable e;
        Cursor cursor = null;
        String c = c(str);
        if (context == null) {
            f.c("PhoneUtil", "context is null, using phone number");
            return c;
        } else if (v.a(a.CONTACTS)) {
            try {
                Uri withAppendedPath = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str));
                query = context.getContentResolver().query(withAppendedPath, new String[]{"display_name"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            string = query.getString(query.getColumnIndexOrThrow("display_name"));
                            if (query != null) {
                                query.close();
                            }
                            return string;
                        }
                    } catch (IllegalArgumentException e2) {
                        e = e2;
                        try {
                            f.b("PhoneUtil", "Failed to retrieve contact info", e);
                            if (query != null) {
                                query.close();
                                string = c;
                                return string;
                            }
                            string = c;
                            return string;
                        } catch (Throwable th) {
                            e = th;
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw e;
                        }
                    } catch (RuntimeException e3) {
                        e = e3;
                        cursor = query;
                        try {
                            f.b("PhoneUtil", "Failed to retrieve contact info", e);
                            if (cursor != null) {
                                cursor.close();
                                string = c;
                                return string;
                            }
                            string = c;
                            return string;
                        } catch (Throwable th2) {
                            e = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw e;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        cursor = query;
                        f.b("PhoneUtil", "Failed to retrieve contact info", e);
                        if (cursor != null) {
                            cursor.close();
                            string = c;
                            return string;
                        }
                        string = c;
                        return string;
                    }
                }
                string = c;
                if (query != null) {
                    query.close();
                }
            } catch (IllegalArgumentException e5) {
                e = e5;
                query = null;
                f.b("PhoneUtil", "Failed to retrieve contact info", e);
                if (query != null) {
                    query.close();
                    string = c;
                    return string;
                }
                string = c;
                return string;
            } catch (RuntimeException e6) {
                e = e6;
                f.b("PhoneUtil", "Failed to retrieve contact info", e);
                if (cursor != null) {
                    cursor.close();
                    string = c;
                    return string;
                }
                string = c;
                return string;
            } catch (Exception e7) {
                e = e7;
                f.b("PhoneUtil", "Failed to retrieve contact info", e);
                if (cursor != null) {
                    cursor.close();
                    string = c;
                    return string;
                }
                string = c;
                return string;
            }
            return string;
        } else {
            v.a("PhoneUtil", a.CONTACTS, "getContactName");
            return c;
        }
    }

    private static String c(String str) {
        if (k.a(str)) {
            return "";
        }
        try {
            h a = h.a();
            return a.a(a.a(str, "US"), h.a.NATIONAL);
        } catch (g e) {
            f.b("PhoneUtil", "Failed to parse phone number");
            return str;
        }
    }

    public static boolean a(Context context) {
        return b(context, "endCall");
    }

    private static boolean b(Context context, String str) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            Method declaredMethod = Class.forName(telephonyManager.getClass().getName()).getDeclaredMethod("getITelephony", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(telephonyManager, new Object[0]);
            Class.forName(invoke.getClass().getName()).getDeclaredMethod(str, new Class[0]).invoke(invoke, new Object[0]);
            return true;
        } catch (Throwable e) {
            f.d("PhoneUtil", "Error calling ITelephony method: " + str, e);
            return false;
        }
    }

    public static String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperatorName();
    }

    public static Pair<String, String> a(String str, String str2, Resources resources) {
        if (TextUtils.isEmpty(str) || com.google.a.f.a.a(str) != null) {
            str = j.a(com.getpebble.android.common.a.K(), str2);
            if (TextUtils.isEmpty(str)) {
                str = resources.getString(R.string.timeline_missed_call_unknown);
            }
        }
        if (TextUtils.isEmpty(str2) || !Patterns.PHONE.matcher(str2).matches()) {
            str2 = resources.getString(R.string.timeline_missed_call_unknown);
        }
        return Pair.create(str, str2);
    }

    public static String a(String str) {
        if (k.a(str)) {
            return "";
        }
        try {
            h a = h.a();
            return a.a(a.a(str, Locale.getDefault().getCountry()), h.a.NATIONAL);
        } catch (g e) {
            f.d("PhoneUtil", "Failed to parse phone number");
            return str;
        } catch (IllegalStateException e2) {
            f.d("PhoneUtil", "Failed to parse phone number");
            return str;
        }
    }

    public static String b(String str) {
        return str.toString().replace('‐', '-').replace('-', '-').replace('­', '-').replace('־', '-').replace('᠆', '-').replace('‑', '-').replace('‒', '-').replace('–', '-').replace('—', '-').replace('―', '-').replace('⁻', '-').replace('₋', '-').replace('−', '-').replace('﹣', '-').replace('－', '-');
    }
}
