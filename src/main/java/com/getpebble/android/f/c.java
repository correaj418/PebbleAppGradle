package com.getpebble.android.f;

import android.app.Notification;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.notifications.a.b;
import com.getpebble.android.notifications.b.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class c {
    public static void a(b bVar) {
        f.e("NotificationMetadataExtractor", "Attempting to update music metadata from notification...");
        com.getpebble.android.notifications.b.c.b a = a(bVar.g(), a(bVar.n()));
        if (a != null) {
            a.a(a);
        }
    }

    private static ArrayList<String> a(Notification notification) {
        Object obj = notification.bigContentView;
        if (obj == null) {
            obj = notification.contentView;
        }
        if (obj != null) {
            ArrayList<String> arrayList = new ArrayList();
            try {
                Field declaredField = obj.getClass().getDeclaredField("mActions");
                declaredField.setAccessible(true);
                Iterator it = ((ArrayList) declaredField.get(obj)).iterator();
                while (it.hasNext()) {
                    Parcelable parcelable = (Parcelable) it.next();
                    Parcel obtain = Parcel.obtain();
                    parcelable.writeToParcel(obtain, 0);
                    obtain.setDataPosition(0);
                    if (obtain.readInt() == 2) {
                        obtain.readInt();
                        String readString = obtain.readString();
                        if (readString == null) {
                            continue;
                        } else {
                            if (readString.equals("setText")) {
                                obtain.readInt();
                                CharSequence charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(obtain);
                                if (charSequence == null) {
                                    f.d("NotificationMetadataExtractor", "CharSequence was null");
                                } else {
                                    arrayList.add(charSequence.toString());
                                }
                            }
                            obtain.recycle();
                        }
                    }
                }
                return arrayList;
            } catch (Exception e) {
                f.a("NotificationMetadataExtractor", "Failed to get music data from notification view.");
            }
        }
        return null;
    }

    private static com.getpebble.android.notifications.b.c.b a(String str, ArrayList<String> arrayList) {
        if (arrayList == null) {
            return null;
        }
        com.getpebble.android.notifications.b.c.b bVar = new com.getpebble.android.notifications.b.c.b();
        try {
            String str2;
            String str3;
            String str4;
            if (str.equals("com.ad60.songza")) {
                str2 = (String) arrayList.get(1);
                str3 = (String) arrayList.get(0);
                str4 = (String) arrayList.get(0);
            } else if (str.equals("com.beatsmusic.android.client")) {
                str2 = (String) arrayList.get(2);
                str3 = (String) arrayList.get(0);
                str4 = (String) arrayList.get(1);
            } else if (str.equals("com.pandora.android")) {
                str2 = (String) arrayList.get(1);
                str3 = (String) arrayList.get(0);
                str4 = (String) arrayList.get(0);
            } else if (str.equals("tunein.player")) {
                str2 = (String) arrayList.get(0);
                str3 = (String) arrayList.get(1);
                str4 = (String) arrayList.get(1);
            } else if (str.equals("com.slacker.radio")) {
                str2 = (String) arrayList.get(1);
                str3 = (String) arrayList.get(0);
                str4 = (String) arrayList.get(0);
            } else if (str.equals("com.clearchannel.iheartradio.controller")) {
                str2 = (String) arrayList.get(2);
                str3 = (String) arrayList.get(1);
                str4 = (String) arrayList.get(0);
            } else if (str.equals("com.jrtstudio.AnotherMusicPlayer")) {
                str4 = (String) arrayList.get(0);
                r7 = (String) arrayList.get(1);
                str3 = (String) arrayList.get(0);
                str2 = r7;
            } else if (str.equals("com.spotify.music")) {
                r7 = (String) arrayList.get(1);
                str3 = (String) arrayList.get(0);
                str2 = (String) arrayList.get(2);
                str4 = r7;
            } else {
                f.d("NotificationMetadataExtractor", "Unhandled package: " + str);
                return null;
            }
            f.d("NotificationMetadataExtractor", "Found Meta-data. Artist: " + str2 + ", Title: " + str3 + ", Album Name: " + str4);
            bVar.a = str2;
            bVar.b = str4;
            bVar.c = str3;
            bVar.g = str;
            bVar.h = a.NOTIFICATION_PARSE;
            return bVar;
        } catch (Exception e) {
            f.d("NotificationMetadataExtractor", "Unable to fetch strings from notification for " + str);
            return null;
        }
    }
}
