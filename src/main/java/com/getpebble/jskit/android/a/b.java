package com.getpebble.jskit.android.a;

import android.content.Context;
import android.content.Intent;
import android.net.MailTo;
import com.getpebble.jskit.android.impl.runtime.model.JsApplicationInfo;
import java.net.URI;

public class b {
    public static boolean a(JsApplicationInfo jsApplicationInfo, String str) {
        boolean z;
        if (jsApplicationInfo.l() != null) {
            for (String equals : jsApplicationInfo.l()) {
                if (equals.equals(str)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            a.a(3, null, "JsUtil", "hasCapability: capability = ", str, ", result = ", Boolean.valueOf(z), ", jsApplicationInfo = ", jsApplicationInfo);
        } else {
            a.a(5, null, "JsUtil", "hasCapability: this app does not have the capability " + str + ", jsApplicationInfo = " + jsApplicationInfo);
        }
        return z;
    }

    public static boolean a(Context context, URI uri) {
        try {
            MailTo parse = MailTo.parse(uri.toString());
            if (parse == null) {
                return false;
            }
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{parse.getTo()});
                intent.putExtra("android.intent.extra.CC", parse.getCc());
                intent.putExtra("android.intent.extra.SUBJECT", parse.getSubject());
                intent.putExtra("android.intent.extra.TEXT", parse.getBody());
                intent.setType("message/rfc822");
                intent.setFlags(268435456);
                context.startActivity(intent);
                return true;
            } catch (Throwable e) {
                a.a(5, e, "JsUtil", "unable to start mail activity from request");
                return false;
            }
        } catch (Throwable e2) {
            a.a(5, e2, "JsUtil", "viewed page has an incorrect mailto link");
            return false;
        } catch (Throwable e22) {
            a.a(5, e22, "JsUtil", "unexpected problem parsing mailto link");
            return false;
        }
    }
}
