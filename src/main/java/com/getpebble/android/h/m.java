package com.getpebble.android.h;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.b.a.f;

public class m {
    public static boolean a(Context context, String str, String str2) {
        if (context instanceof Activity) {
            c.m();
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", context.getString(R.string.my_pebble_share_description, new Object[]{str}));
            intent.putExtra("android.intent.extra.TEXT", str2);
            context.startActivity(Intent.createChooser(intent, context.getString(R.string.my_pebble_share_text) + " " + str));
            return true;
        }
        f.a("ExternalIntentUtil", "openShareIntent: Failed to open");
        return false;
    }

    public static boolean b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || context == null) {
            f.a("ExternalIntentUtil", "openEmailIntent: Failed to open");
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
            intent.setType("plain/text");
            intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
            intent.putExtra("android.intent.extra.SUBJECT", str2);
            context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.support_select_an_email_client)));
            return true;
        } catch (Throwable e) {
            f.a("ExternalIntentUtil", "openEmailIntent: error launching email", e);
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            f.a("ExternalIntentUtil", "openMarketIntent: Failed to open");
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (Throwable e) {
            f.d("ExternalIntentUtil", "openMarketIntent: error loading play store; showing web store", e);
            intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
        return true;
    }
}
