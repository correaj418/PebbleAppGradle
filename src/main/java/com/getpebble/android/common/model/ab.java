package com.getpebble.android.common.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.b;
import com.getpebble.android.common.model.ai.a;
import com.getpebble.android.h.i;
import com.getpebble.android.h.x;
import com.google.a.b.ad;
import java.io.PrintStream;
import java.util.Arrays;

public class ab extends ai {
    public static final Uri a = b.a("pebble_language_packs");
    private static final String[] b = new String[]{ak.ISO_LOCALE, ak.HW_PLATFORM, ak.FW_VERSION, ak.LANGUAGE_VERSION};
    private static final String[] c = new String[]{ai.COLUMN_ID, "file_url", "local_language_name", ak.ISO_LOCALE, ak.LANGUAGE_VERSION, "hw_platform parent_hw_platform", "language_name parent_language_name", "numeric_fw_version parent_numeric_fw_version"};

    public ab() {
        super("pebble_language_packs");
        addColumn(new a(a.a.STRING, "file_url"));
        addColumn(new a(a.a.STRING, "language_name"));
        addColumn(new a(a.a.STRING, "local_language_name"));
        addColumn(new a(a.a.STRING, ak.ISO_LOCALE));
        addColumn(new a(a.a.STRING, ak.HW_PLATFORM));
        addColumn(new a(a.a.STRING, ak.FW_VERSION));
        addColumn(new a(a.a.STRING, ak.LANGUAGE_VERSION));
        addColumn(new a(a.a.STRING, "language_uid"));
        addColumn(new a(a.a.INTEGER, "numeric_fw_version"));
    }

    public static CursorLoader a(z zVar, Context context) {
        return new CursorLoader(context, a, c, "hw_platform = ? AND numeric_fw_version = ( SELECT MAX(t2.numeric_fw_version) FROM pebble_language_packs t2 WHERE t2.language_name = parent_language_name AND t2.hw_platform = parent_hw_platform) AND language_version = ( SELECT MAX(t3.language_version) FROM pebble_language_packs t3 WHERE t3.hw_platform = parent_hw_platform AND t3.numeric_fw_version = parent_numeric_fw_version AND t3.language_name = parent_language_name)", new String[]{zVar.getName()}, null);
    }

    public static Cursor a(z zVar, ContentResolver contentResolver) {
        return contentResolver.query(a, c, "hw_platform = ? AND numeric_fw_version = ( SELECT MAX(t2.numeric_fw_version) FROM pebble_language_packs t2 WHERE t2.language_name = parent_language_name AND t2.hw_platform = parent_hw_platform) AND language_version = ( SELECT MAX(t3.language_version) FROM pebble_language_packs t3 WHERE t3.hw_platform = parent_hw_platform AND t3.numeric_fw_version = parent_numeric_fw_version AND t3.language_name = parent_language_name)", new String[]{zVar.getName()}, null);
    }

    public int a() {
        return getColumnSet().size();
    }

    public String getCreateTableCommand() {
        return x.a(super.getCreateTableCommand(), ad.a(Arrays.asList(b())));
    }

    public static String[] b() {
        return b;
    }

    public static int a(ContentResolver contentResolver, v vVar, z zVar) {
        int i = 0;
        if (!(vVar == null || zVar == null)) {
            Cursor a = a(zVar, contentResolver);
            try {
                if (a.moveToFirst()) {
                    i = a.getCount();
                    a.close();
                }
            } finally {
                a.close();
            }
        }
        return i;
    }

    public static int a(v vVar) {
        return ((vVar.getMajor() * 10000) + (vVar.getMinor() * 100)) + vVar.getPoint();
    }

    public static void a(ContentResolver contentResolver) {
        f.d("LanguagePackModel", String.format("Removed %d entries", new Object[]{Integer.valueOf(contentResolver.delete(a, null, null))}));
    }

    public static void a(ContentResolver contentResolver, PrintStream printStream) {
        i.a(contentResolver, printStream, a, "hw_platform ASC");
    }
}
