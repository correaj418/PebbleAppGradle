package com.getpebble.android.framework.m;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.ContactsContract.PhoneLookup;
import android.provider.Telephony.Sms;
import android.provider.Telephony.Sms.Intents;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.af;
import com.getpebble.android.common.model.ak;
import com.getpebble.android.common.model.an;
import com.getpebble.android.common.model.aq;
import com.getpebble.android.h.v;
import com.google.a.a.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class j extends BroadcastReceiver {

    public interface e {
        void a();

        void b();
    }

    private enum a {
        NOTIFICATION,
        SMS
    }

    public static class b {
        private static boolean b() {
            Set<String> b = af.b(com.getpebble.android.common.a.K().getContentResolver());
            List<c> arrayList = new ArrayList();
            for (String str : b) {
                c smsAppByPackageName = c.getSmsAppByPackageName(str);
                if (j.a(str)) {
                    arrayList.add(smsAppByPackageName);
                }
            }
            for (c cVar : arrayList) {
                if (cVar.notificationMethod == a.SMS) {
                    f.d("SMSReceiver", "Using SMSReceiver for sms client: " + cVar.name());
                    return true;
                }
            }
            return false;
        }

        public static boolean a() {
            if (PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.DISABLE_BUILT_IN_SMS, false)) {
                f.d("SMSReceiver", "shouldSMSReceiverHandleTask: SMS override activated - not using receiver");
                return false;
            } else if (VERSION.SDK_INT < 19) {
                return b();
            } else {
                String a = j.a(com.getpebble.android.common.a.K());
                if (j.a(a) && c.getSmsAppByPackageName(a).notificationMethod == a.SMS) {
                    return true;
                }
                return false;
            }
        }

        public static boolean a(com.getpebble.android.common.model.af.b bVar) {
            if (bVar == null || !bVar.j) {
                return true;
            }
            if (!PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.DISABLE_BUILT_IN_SMS, false)) {
                return c.getSmsAppByPackageName(bVar.a).notificationMethod.equals(a.NOTIFICATION);
            }
            f.d("SMSReceiver", "shouldPebbleNotificationProcessorHandleTask: SMS override activated - not using receiver");
            return true;
        }
    }

    private enum c {
        CHOMP_SMS("com.p1.chompsms", a.NOTIFICATION),
        EVOLVE_SMS("com.klinker.android.evolve_sms", a.SMS),
        GO_SMS_PRO("com.jb.gosms", a.SMS),
        GOOGLE_MESSENGER("com.google.android.apps.messaging", a.NOTIFICATION),
        HANGOUTS("com.google.android.talk", a.NOTIFICATION),
        HELLO_SMS("com.hellotext.hello", a.SMS),
        TEXTRA("com.textra", a.NOTIFICATION),
        TEXTSECURE("org.thoughtcrime.securesms", a.NOTIFICATION),
        FACEBOOK_MESSENGER("com.facebook.orca", a.NOTIFICATION),
        SONY("com.sonyericsson.conversations", a.SMS),
        DISA("com.disa", a.NOTIFICATION),
        UNKNOWN("", a.SMS);
        
        a notificationMethod;
        String packageName;

        private c(String str, a aVar) {
            this.packageName = str;
            this.notificationMethod = aVar;
        }

        public static c getSmsAppByPackageName(String str) {
            if (TextUtils.isEmpty(str)) {
                return UNKNOWN;
            }
            for (c cVar : values()) {
                if (cVar.packageName.matches(str)) {
                    return cVar;
                }
            }
            return UNKNOWN;
        }
    }

    public static class d extends com.getpebble.android.notifications.a.b.a {
        public String a;
    }

    @SuppressLint({"InlinedApi"})
    public j(Context context) {
        context.registerReceiver(this, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
    }

    public static String a(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return Sms.getDefaultSmsPackage(context);
        }
        return "";
    }

    public void onReceive(Context context, Intent intent) {
        Throwable e;
        int i = 0;
        if (context == null) {
            f.a("SMSReceiver", "onReceive() Context was null -- not processing SMS notification.");
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            f.a("SMSReceiver", "onReceive() Bundle was null -- not processing SMS notification.");
            return;
        }
        f.d("SMSReceiver", "onReceive() Parsing incoming SMS...");
        Object[] objArr = (Object[]) extras.get("pdus");
        if (objArr == null) {
            f.b("SMSReceiver", "onReceive: bundlePDUs is null");
            return;
        }
        SmsMessage[] smsMessageArr;
        if (VERSION.SDK_INT < 19) {
            SmsMessage[] smsMessageArr2 = new SmsMessage[objArr.length];
            for (int i2 = 0; i2 < smsMessageArr2.length; i2++) {
                smsMessageArr2[i2] = SmsMessage.createFromPdu((byte[]) objArr[i2]);
            }
            smsMessageArr = smsMessageArr2;
        } else {
            try {
                smsMessageArr = Intents.getMessagesFromIntent(intent);
            } catch (NullPointerException e2) {
                e = e2;
                f.b("SMSReceiver", "onReceive: error extracting messages from Intent", e);
                return;
            } catch (ArrayIndexOutOfBoundsException e3) {
                e = e3;
                f.b("SMSReceiver", "onReceive: error extracting messages from Intent", e);
                return;
            }
        }
        if (smsMessageArr.length > 0 && smsMessageArr[0] != null) {
            SmsMessage smsMessage = smsMessageArr[0];
            aq.a(context.getContentResolver(), smsMessage.getOriginatingAddress(), smsMessage.getTimestampMillis());
        }
        if (!b.a()) {
            f.d("SMSReceiver", "onReceive() SMS message should be handled by " + a(com.getpebble.android.common.a.K()) + "'s notification.");
        } else if (b(context)) {
            f.d("SMSReceiver", "onReceive() Hangouts is SMS receiver, so this is a duplicate message -- not processing SMS notification.");
        } else {
            f.d("SMSReceiver", "onReceive() Processing SMS Notification...");
            while (i < smsMessageArr.length) {
                if (smsMessageArr[i] != null) {
                    String str;
                    String originatingAddress = smsMessageArr[i].getOriginatingAddress();
                    String a = a(context, originatingAddress);
                    if (k.a(smsMessageArr[i].getMessageBody())) {
                        str = "";
                    } else {
                        str = smsMessageArr[i].getMessageBody().toString();
                    }
                    a(a, str, originatingAddress);
                }
                i++;
            }
        }
    }

    private boolean b(Context context) {
        boolean equals;
        if (VERSION.SDK_INT >= 19) {
            equals = "com.google.android.talk".equals(Sms.getDefaultSmsPackage(context));
        } else {
            equals = false;
        }
        com.getpebble.android.common.model.af.b a = af.a("com.google.android.talk", context.getContentResolver());
        boolean z;
        if (a != null) {
            z = a.d;
        } else {
            z = false;
        }
        if (equals && r2) {
            return true;
        }
        return false;
    }

    public static String a(Context context, String str) {
        Cursor query;
        Throwable e;
        Cursor cursor = null;
        if (!v.a(com.getpebble.android.h.v.a.CONTACTS)) {
            v.a("SMSReceiver", com.getpebble.android.h.v.a.CONTACTS, "getContactName");
        } else if (context == null) {
            f.a("SMSReceiver", "Failed to get contact information -- context was null!");
        } else {
            try {
                Uri withAppendedPath = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str));
                query = context.getContentResolver().query(withAppendedPath, new String[]{"display_name"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            str = query.getString(query.getColumnIndexOrThrow("display_name"));
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            f.a("SMSReceiver", "Failed to retrieve contact info", e);
                            if (query != null) {
                                query.close();
                            }
                            return str;
                        } catch (Throwable th) {
                            e = th;
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw e;
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                query = null;
                f.a("SMSReceiver", "Failed to retrieve contact info", e);
                if (query != null) {
                    query.close();
                }
                return str;
            } catch (Throwable th2) {
                e = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw e;
            }
        }
        return str;
    }

    private void a(String str, String str2, String str3) {
        com.getpebble.android.notifications.a.b.a dVar = new d();
        dVar.b = str;
        dVar.d = str2;
        dVar.a = str3;
        com.getpebble.android.framework.i.b.a(com.getpebble.android.notifications.a.b.a(dVar, com.getpebble.android.notifications.a.b.c.SMS, System.currentTimeMillis()));
    }

    protected static boolean a(String str) {
        com.getpebble.android.common.model.af.b a = af.a(str, com.getpebble.android.common.a.K().getContentResolver());
        return a != null && a.d;
    }

    private static void a(final e eVar, final int i, String str) {
        com.getpebble.android.common.a.K().registerReceiver(new BroadcastReceiver() {
            private boolean c = false;
            private int d = 0;

            public synchronized void onReceive(Context context, Intent intent) {
                if (!this.c) {
                    f.d("SMSReceiver", "SMS sent callback: onReceive() resultCode = " + getResultCode());
                    switch (getResultCode()) {
                        case -1:
                            int i = this.d + 1;
                            this.d = i;
                            if (i == i) {
                                eVar.b();
                                context.unregisterReceiver(this);
                                break;
                            }
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            this.c = true;
                            eVar.a();
                            context.unregisterReceiver(this);
                            break;
                        default:
                            break;
                    }
                }
            }
        }, new IntentFilter(str));
    }

    public static void a(String str, String str2, e eVar) {
        if (v.a(com.getpebble.android.h.v.a.SMS)) {
            SmsManager smsManager = SmsManager.getDefault();
            try {
                String str3 = "sms_sent_result" + UUID.randomUUID();
                ArrayList divideMessage = smsManager.divideMessage(str);
                ArrayList arrayList = new ArrayList();
                Intent intent = new Intent(str3);
                for (int i = 0; i < divideMessage.size(); i++) {
                    arrayList.add(PendingIntent.getBroadcast(com.getpebble.android.common.a.K(), 0, intent, 134217728));
                }
                a(eVar, divideMessage.size(), str3);
                f.d("SMSReceiver", "Sending SMS reply in " + divideMessage.size() + " part(s)");
                smsManager.sendMultipartTextMessage(str2, null, divideMessage, arrayList, null);
                if (VERSION.SDK_INT < 19) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(ak.ADDRESS, str2);
                        contentValues.put(an.BODY, str);
                        com.getpebble.android.common.a.K().getContentResolver().insert(Uri.parse("content://sms/sent"), contentValues);
                        return;
                    } catch (Throwable e) {
                        f.c("SMSReceiver", "Error writing sent message to ContentProvider", e);
                        return;
                    }
                }
                return;
            } catch (Throwable e2) {
                f.a("SMSReceiver", "Failed to send SMS message reply.", e2);
                eVar.a();
                return;
            }
        }
        v.a("SMSReceiver", com.getpebble.android.h.v.a.SMS, "sendSmsReply");
        eVar.a();
    }
}
