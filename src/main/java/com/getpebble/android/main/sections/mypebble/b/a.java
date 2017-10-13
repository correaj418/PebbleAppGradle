package com.getpebble.android.main.sections.mypebble.b;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;
import c.a.a.a.e;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.h.u;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class a extends SQLiteOpenHelper {
    private static final List<String> a = new ArrayList();

    static {
        a.add("en");
        a.add(u.SPANISH_LANGUAGE_CODE);
        a.add("fr");
        a.add("de");
        a.add(u.DUTCH_LANGUAGE_CODE);
        a.add("zh");
    }

    public a(Context context) {
        super(context, "geodata", null, 1);
        a(context);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private void b(Context context) {
        InputStream zipInputStream;
        Throwable th;
        InputStream inputStream;
        OutputStream outputStream = null;
        try {
            OutputStream fileOutputStream;
            InputStream open = com.getpebble.android.common.a.K().getAssets().open("geodata.sqlite.zip");
            try {
                zipInputStream = new ZipInputStream(open);
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
                zipInputStream = open;
                e.a(outputStream);
                e.a(inputStream);
                e.a(zipInputStream);
                throw th;
            }
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                SQLiteDatabase readableDatabase = getReadableDatabase();
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                File databasePath = context.getDatabasePath("geodata");
                f.d("GeoDatabaseHelper", "Unzipping " + nextEntry.getName() + " to " + databasePath);
                fileOutputStream = new FileOutputStream(databasePath);
            } catch (Throwable th3) {
                th = th3;
                inputStream = zipInputStream;
                zipInputStream = open;
                e.a(outputStream);
                e.a(inputStream);
                e.a(zipInputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[2056];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        zipInputStream.closeEntry();
                        fileOutputStream.flush();
                        e.a(fileOutputStream);
                        e.a(zipInputStream);
                        e.a(open);
                        return;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                outputStream = fileOutputStream;
                inputStream = zipInputStream;
                zipInputStream = open;
                e.a(outputStream);
                e.a(inputStream);
                e.a(zipInputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            zipInputStream = null;
            e.a(outputStream);
            e.a(inputStream);
            e.a(zipInputStream);
            throw th;
        }
    }

    public void a(Context context) {
        boolean c = c(context);
        int a = PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.GEO_DATABASE_VERSION, 1);
        if (!c || a < 1) {
            f.d("GeoDatabaseHelper", "Database being created/updated.");
            try {
                b(context);
                PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.GEO_DATABASE_VERSION, 1);
            } catch (IOException e) {
                throw new Error("Error copying geo database: " + e.getMessage());
            }
        }
    }

    private boolean c(Context context) {
        return context.getDatabasePath("geodata").exists();
    }

    public static String a(String str, Location location) {
        String str2 = "name";
        if (location != null) {
            str2 = String.format(Locale.US, "((longitude - %f) * (longitude - %f) + (latitude - %f) * (latitude - %f))", new Object[]{Double.valueOf(location.getLongitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLatitude())});
        }
        String language = Locale.getDefault().getLanguage();
        String str3 = "cities_";
        if (a.contains(language)) {
            language = str3 + language;
        } else {
            language = str3 + "en";
        }
        return String.format("SELECT name, latitude, longitude, state, country FROM %s INNER JOIN name_strings ON %s.name_string_id = name_strings.id INNER JOIN placemarks ON %s.placemark_id = placemarks.id INNER JOIN states ON placemarks.state_id = states.id WHERE name LIKE %s ORDER BY %s LIMIT 10", new Object[]{language, language, language, DatabaseUtils.sqlEscapeString(str + "%"), str2});
    }
}
