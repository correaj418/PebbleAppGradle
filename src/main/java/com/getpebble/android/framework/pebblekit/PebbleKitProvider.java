package com.getpebble.android.framework.pebblekit;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.b.d;
import com.getpebble.android.common.b.a.f;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PebbleKitProvider extends ContentProvider {
    private static final Queue<a> a = new LinkedList();
    private static Handler b = new Handler(Looper.getMainLooper());
    private static final String[] c = new String[]{"isConnected", "supportsAppMessages", "supportsDataLogging", "versionMajor", "versionMinor", "versionPoint", "versionTag"};
    private static final UriMatcher d = new UriMatcher(-1);

    private static class a {
        private final String a;
        private final SoftReference<Cursor> b;
        private final CursorWindow c;

        a(String str, Cursor cursor, CursorWindow cursorWindow) {
            this.a = str;
            this.b = new SoftReference(cursor);
            this.c = cursorWindow;
        }

        void a() {
            Cursor cursor = (Cursor) this.b.get();
            if (!(cursor == null || cursor.isClosed())) {
                f.d("PebbleKitProvider", "Closing cursor " + cursor + " for pkg " + this.a);
                cursor.close();
            }
            if (this.c != null) {
                this.c.clear();
                this.c.close();
            }
        }
    }

    private static class b extends MatrixCursor {
        private CursorWindow a;

        public b(String[] strArr, int i) {
            super(strArr, i);
        }

        CursorWindow a() {
            this.a = new CursorWindow("PebbleKitWindow");
            fillWindow(0, this.a);
            return this.a;
        }

        public CursorWindow getWindow() {
            CursorWindow cursorWindow = this.a;
            this.a = null;
            return cursorWindow;
        }

        public void fillWindow(int i, CursorWindow cursorWindow) {
            super.fillWindow(i, cursorWindow);
        }
    }

    static {
        d.addURI("com.getpebble.android.provider.basalt", "state", 1);
    }

    public boolean onCreate() {
        return true;
    }

    protected com.getpebble.android.common.model.ak.a a() {
        return PebbleApplication.p();
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i = 0;
        switch (d.match(uri)) {
            case 1:
                boolean equals;
                int major;
                int minor;
                int point;
                String callingPackage;
                f.d("PebbleKitProvider", "3rd-party querying state");
                Cursor bVar = new b(c, c.length);
                Object obj = "";
                com.getpebble.android.common.model.ak.a a = a();
                if (a != null) {
                    equals = d.CONNECTED.equals(a.connectionStatus);
                    if (a.getFwVersion() != null) {
                        major = a.getFwVersion().getMajor();
                        minor = a.getFwVersion().getMinor();
                        point = a.getFwVersion().getPoint();
                        obj = a.getFwVersion().getVersionTag();
                    } else {
                        point = 0;
                        minor = 0;
                        major = 0;
                    }
                } else {
                    point = 0;
                    minor = 0;
                    major = 0;
                    equals = false;
                }
                RowBuilder newRow = bVar.newRow();
                if (equals) {
                    i = 1;
                }
                newRow.add(Integer.valueOf(i)).add(Integer.valueOf(1)).add(Integer.valueOf(1)).add(Integer.valueOf(major)).add(Integer.valueOf(minor)).add(Integer.valueOf(point)).add(obj);
                CursorWindow a2 = bVar.a();
                if (VERSION.SDK_INT >= 19) {
                    callingPackage = getCallingPackage();
                } else {
                    callingPackage = null;
                }
                a aVar = new a(callingPackage, bVar, a2);
                synchronized (a) {
                    if (a.size() > 50) {
                        ((a) a.poll()).a();
                    }
                    a.add(aVar);
                    b.removeCallbacksAndMessages(null);
                    b.postDelayed(new Runnable(this) {
                        final /* synthetic */ PebbleKitProvider a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            synchronized (PebbleKitProvider.a) {
                                Iterator it = PebbleKitProvider.a.iterator();
                                while (it.hasNext()) {
                                    ((a) it.next()).a();
                                    it.remove();
                                }
                            }
                        }
                    }, 120000);
                }
                return bVar;
            default:
                f.b("PebbleKitProvider", "Unknown Uri: " + uri);
                return null;
        }
    }

    public String getType(Uri uri) {
        switch (d.match(uri)) {
            case 1:
                return "vnd.android.cursor.item/vnd.com.getpebble.android.provider.basalt.state";
            default:
                return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
