package com.getpebble.android.common.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.bluetooth.PebbleDevice;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ak.a;
import com.getpebble.android.framework.d;
import com.getpebble.android.framework.o.b;
import java.io.File;

public class ad {
    private final a a;
    private final Context b;
    private String c;
    private int d;
    private String e;

    public ad(Context context, a aVar) {
        this.b = context;
        this.a = aVar;
    }

    public boolean a() {
        if (this.a == null || this.a.getHwPlatform() == null || this.a.getIsoLocale() == null) {
            return false;
        }
        if (b.isPebbleLanguageFactoryDefault(this.a.getIsoLocale(), this.a.getLanguageVersion())) {
            f.d("LanguageUpgradeEvaluator", "Not upgrading default language pack; locale=<" + this.a.getIsoLocale() + "> version=<" + this.a.getLanguageVersion() + ">");
            return false;
        }
        Integer a = a(this.a.getIsoLocale(), this.a.getHwPlatform());
        if (a == null) {
            f.e("LanguageUpgradeEvaluator", "Server language pack version is null");
            return false;
        }
        f.e("LanguageUpgradeEvaluator", "Server language pack version: " + a + " device version: " + this.a.getLanguageVersion());
        if (a.intValue() > this.a.getLanguageVersion()) {
            return true;
        }
        return false;
    }

    Integer a(String str, z zVar) {
        Integer num = null;
        Cursor a = ab.a(zVar, this.b.getContentResolver());
        if (a != null) {
            while (a.moveToNext()) {
                try {
                    String string = a.getString(a.getColumnIndex(ak.ISO_LOCALE));
                    if (str.equalsIgnoreCase(string)) {
                        f.e("LanguageUpgradeEvaluator", "Found locale: " + str);
                        this.e = string;
                        this.c = a.getString(a.getColumnIndex("file_url"));
                        this.d = a.getInt(a.getColumnIndex(ak.LANGUAGE_VERSION));
                        num = Integer.valueOf(this.d);
                        break;
                    }
                    f.e("LanguageUpgradeEvaluator", "Locale: " + str + " not equal to :" + string);
                } finally {
                    a.close();
                }
            }
            a.close();
            f.d("LanguageUpgradeEvaluator", "Failed to find locale: " + str);
        }
        return num;
    }

    public void b() {
        f.d("LanguageUpgradeEvaluator", "Starting file download...");
        new com.getpebble.android.bluetooth.b.f(this) {
            final /* synthetic */ ad a;

            {
                this.a = r1;
            }

            public boolean doInBackground() {
                File a = new com.getpebble.android.framework.install.a(this.a.b, null).a(this.a.c, null);
                if (a == null) {
                    f.a(com.getpebble.android.bluetooth.b.f.TAG, "updateAsync: file is null");
                } else {
                    Uri fromFile = Uri.fromFile(a);
                    f.d(com.getpebble.android.bluetooth.b.f.TAG, "Finished file download successfully; got URI: " + fromFile);
                    d x = PebbleApplication.x();
                    if (x == null) {
                        f.d(com.getpebble.android.bluetooth.b.f.TAG, "Not installing LP; could not get framework interface");
                    } else {
                        PebbleDevice n = PebbleApplication.n();
                        if (n == null) {
                            f.d(com.getpebble.android.bluetooth.b.f.TAG, "Not installing LP; could not get connected device");
                        } else {
                            x.a(n, fromFile, "lang", this.a.e, this.a.d);
                        }
                    }
                }
                return false;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }
}
