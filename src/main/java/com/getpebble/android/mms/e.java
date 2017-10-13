package com.getpebble.android.mms;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.a;
import com.getpebble.android.framework.m.j;
import com.getpebble.android.framework.o.c;
import com.google.a.a.f;
import java.util.ArrayList;
import java.util.List;

public class e {
    private final String a;

    public e(String str) {
        if (str == null) {
            this.a = "";
        } else {
            this.a = str;
        }
    }

    private String a(Mms mms) {
        StringBuilder stringBuilder = new StringBuilder();
        if (d(mms)) {
            Object obj;
            List arrayList = new ArrayList();
            arrayList.add(a.K().getString(R.string.you));
            for (String str : mms.k) {
                if (!PhoneNumberUtils.compare(str, this.a)) {
                    arrayList.add(str);
                }
            }
            Iterable a = a(arrayList);
            if (a.size() > 3) {
                obj = 1;
                a.subList(3, a.size()).clear();
            } else {
                obj = null;
            }
            stringBuilder.append(f.a(com.getpebble.android.framework.timeline.e.ATTRIBUTE_ARRAY_VALUE_SEPARATOR).a(a));
            if (obj != null) {
                stringBuilder.append("...");
            }
        } else {
            stringBuilder.append(j.a(a.K(), mms.i));
        }
        return stringBuilder.toString();
    }

    private List<String> a(List<String> list) {
        List<String> arrayList = new ArrayList(list.size());
        for (String str : list) {
            String a = j.a(a.K(), str);
            if (c.a(str).contains(a)) {
                arrayList.add(a);
            } else {
                arrayList.add(a(a));
            }
        }
        return arrayList;
    }

    private String a(String str) {
        return TextUtils.isEmpty(str) ? str : str.split(" ", 2)[0];
    }

    private String b(Mms mms) {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder();
        Object b = b(mms, a.K());
        if (!TextUtils.isEmpty(b)) {
            stringBuilder.append(b);
            obj = 1;
        }
        if (mms.j.size() > 0) {
            String a = f.a('\n').a(mms.j);
            if (obj != null) {
                stringBuilder.append("\n");
                stringBuilder.append("\"");
                stringBuilder.append(a);
                stringBuilder.append("\"");
            } else {
                stringBuilder.append(a);
            }
        }
        return stringBuilder.toString();
    }

    private String c(Mms mms) {
        if (d(mms)) {
            return j.a(a.K(), mms.i);
        }
        return null;
    }

    private boolean d(Mms mms) {
        if (mms.k.size() > 1) {
            return true;
        }
        if (mms.k.size() == 1 && ((String) mms.k.get(0)).contains(this.a)) {
            return false;
        }
        return true;
    }

    private String b(Mms mms, Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        if (TextUtils.isEmpty(mms.i)) {
            com.getpebble.android.common.b.a.f.f("MmsNotificationGenerator", "Sender should never be empty here.");
        }
        if (g.a(mms) > 1) {
            stringBuilder.append(context.getString(R.string.sent_you_a_multimedia_message)).append("󾔺");
        } else if (mms.c > 0) {
            String string;
            StringBuilder append = stringBuilder.append(context.getString(R.string.sent_you));
            if (mms.c == 1) {
                string = context.getString(R.string.an_image);
            } else {
                string = mms.c + context.getString(R.string.images);
            }
            append.append(string).append("📷");
        } else if (mms.g) {
            stringBuilder.append(context.getString(R.string.sent_you_a_video)).append("🎥");
        } else if (mms.e) {
            stringBuilder.append(context.getString(R.string.sent_you_a_voice_message)).append("🎤");
        }
        return stringBuilder.toString();
    }

    public d a(Mms mms, Context context) {
        com.getpebble.android.common.b.a.f.e("MmsNotificationGenerator", "generate(mms) mms:" + mms.toString());
        d dVar = new d();
        dVar.a = b(mms);
        dVar.c = c(mms);
        dVar.b = a(mms);
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(dVar.c)) {
            stringBuilder.append(dVar.c).append('\n');
        }
        stringBuilder.append(dVar.a);
        dVar.d = stringBuilder.toString();
        com.getpebble.android.common.b.a.f.e("MmsNotificationGenerator", "generate(mms) pblnote:" + com.getpebble.android.common.b.b.a.a(dVar.b) + " body: " + com.getpebble.android.common.b.b.a.a(dVar.d) + " subtitle: " + com.getpebble.android.common.b.b.a.a(dVar.c));
        return dVar;
    }
}
