package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class e extends DataSetObservable {
    private static final String a = e.class.getSimpleName();
    private static final Object b = new Object();
    private static final Map<String, e> c = new HashMap();
    private final Object d;
    private final List<a> e;
    private final List<c> f;
    private final Context g;
    private final String h;
    private Intent i;
    private b j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private d p;

    public final class a implements Comparable<a> {
        public final ResolveInfo a;
        public float b;
        final /* synthetic */ e c;

        public /* synthetic */ int compareTo(Object obj) {
            return a((a) obj);
        }

        public a(e eVar, ResolveInfo resolveInfo) {
            this.c = eVar;
            this.a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(this.b) != Float.floatToIntBits(((a) obj).b)) {
                return false;
            }
            return true;
        }

        public int a(a aVar) {
            return Float.floatToIntBits(aVar.b) - Float.floatToIntBits(this.b);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.a.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface b {
        void a(Intent intent, List<a> list, List<c> list2);
    }

    public static final class c {
        public final ComponentName a;
        public final long b;
        public final float c;

        public c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public c(ComponentName componentName, long j, float f) {
            this.a = componentName;
            this.b = j;
            this.c = f;
        }

        public int hashCode() {
            return (((((this.a == null ? 0 : this.a.hashCode()) + 31) * 31) + ((int) (this.b ^ (this.b >>> 32)))) * 31) + Float.floatToIntBits(this.c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.a == null) {
                if (cVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(cVar.a)) {
                return false;
            }
            if (this.b != cVar.b) {
                return false;
            }
            if (Float.floatToIntBits(this.c) != Float.floatToIntBits(cVar.c)) {
                return false;
            }
            return true;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.a);
            stringBuilder.append("; time:").append(this.b);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.c));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface d {
        boolean a(e eVar, Intent intent);
    }

    private final class e extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ e a;

        private e(e eVar) {
            this.a = eVar;
        }

        public /* synthetic */ Object doInBackground(Object[] objArr) {
            return a(objArr);
        }

        public Void a(Object... objArr) {
            int i = 0;
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                OutputStream openFileOutput = this.a.g.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        c cVar = (c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", cVar.a.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(cVar.b));
                        newSerializer.attribute(null, "weight", String.valueOf(cVar.c));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    this.a.l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable e2) {
                    Log.e(e.a, "Error writing historical recrod file: " + this.a.h, e2);
                    this.a.l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable e22) {
                    Log.e(e.a, "Error writing historical recrod file: " + this.a.h, e22);
                    this.a.l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable e222) {
                    Log.e(e.a, "Error writing historical recrod file: " + this.a.h, e222);
                    this.a.l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    this.a.l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (Throwable e2222) {
                Log.e(e.a, "Error writing historical recrod file: " + str, e2222);
            }
            return null;
        }
    }

    public int a() {
        int size;
        synchronized (this.d) {
            e();
            size = this.e.size();
        }
        return size;
    }

    public ResolveInfo a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.d) {
            e();
            resolveInfo = ((a) this.e.get(i)).a;
        }
        return resolveInfo;
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.d) {
            e();
            List list = this.e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((a) list.get(i)).a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Intent b(int i) {
        synchronized (this.d) {
            if (this.i == null) {
                return null;
            }
            e();
            a aVar = (a) this.e.get(i);
            ComponentName componentName = new ComponentName(aVar.a.activityInfo.packageName, aVar.a.activityInfo.name);
            Intent intent = new Intent(this.i);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo b() {
        synchronized (this.d) {
            e();
            if (this.e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((a) this.e.get(0)).a;
            return resolveInfo;
        }
    }

    public void c(int i) {
        synchronized (this.d) {
            float f;
            e();
            a aVar = (a) this.e.get(i);
            a aVar2 = (a) this.e.get(0);
            if (aVar2 != null) {
                f = (aVar2.b - aVar.b) + 5.0f;
            } else {
                f = 1.0f;
            }
            a(new c(new ComponentName(aVar.a.activityInfo.packageName, aVar.a.activityInfo.name), System.currentTimeMillis(), f));
        }
    }

    private void d() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.n) {
            this.n = false;
            if (!TextUtils.isEmpty(this.h)) {
                android.support.v4.d.a.a(new e(), new ArrayList(this.f), this.h);
            }
        }
    }

    private void e() {
        int g = g() | h();
        i();
        if (g != 0) {
            f();
            notifyChanged();
        }
    }

    private boolean f() {
        if (this.j == null || this.i == null || this.e.isEmpty() || this.f.isEmpty()) {
            return false;
        }
        this.j.a(this.i, this.e, Collections.unmodifiableList(this.f));
        return true;
    }

    private boolean g() {
        if (!this.o || this.i == null) {
            return false;
        }
        this.o = false;
        this.e.clear();
        List queryIntentActivities = this.g.getPackageManager().queryIntentActivities(this.i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.e.add(new a(this, (ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean h() {
        if (!this.l || !this.n || TextUtils.isEmpty(this.h)) {
            return false;
        }
        this.l = false;
        this.m = true;
        j();
        return true;
    }

    private boolean a(c cVar) {
        boolean add = this.f.add(cVar);
        if (add) {
            this.n = true;
            i();
            d();
            f();
            notifyChanged();
        }
        return add;
    }

    private void i() {
        int size = this.f.size() - this.k;
        if (size > 0) {
            this.n = true;
            for (int i = 0; i < size; i++) {
                c cVar = (c) this.f.remove(0);
            }
        }
    }

    private void j() {
        try {
            InputStream openFileInput = this.g.openFileInput(this.h);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.f;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (Throwable e2) {
                Log.e(a, "Error reading historical recrod file: " + this.h, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(a, "Error reading historical recrod file: " + this.h, e22);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            }
        } catch (FileNotFoundException e6) {
        }
    }
}
