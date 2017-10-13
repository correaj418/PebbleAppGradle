package net.hockeyapp.android.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
    private ArrayList<JSONObject> a;
    private JSONObject b;
    private net.hockeyapp.android.j c;
    private int d;

    public j(Context context, String str, net.hockeyapp.android.j jVar) {
        this.c = jVar;
        a(context, str);
        d();
    }

    private void a(Context context, String str) {
        this.b = new JSONObject();
        this.a = new ArrayList();
        this.d = this.c.a();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int a = this.c.a();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.getInt("version") > a) {
                    obj = 1;
                } else {
                    obj = null;
                }
                Object obj2;
                if (jSONObject.getInt("version") == a && a(context, jSONObject.getLong("timestamp"))) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (!(obj == null && r1 == null)) {
                    this.b = jSONObject;
                    a = jSONObject.getInt("version");
                }
                this.a.add(jSONObject);
            }
        } catch (JSONException e) {
        } catch (NullPointerException e2) {
        }
    }

    private void d() {
        Collections.sort(this.a, new Comparator<JSONObject>(this) {
            final /* synthetic */ j a;

            {
                this.a = r1;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return a((JSONObject) obj, (JSONObject) obj2);
            }

            public int a(JSONObject jSONObject, JSONObject jSONObject2) {
                try {
                    return jSONObject.getInt("version") > jSONObject2.getInt("version") ? 0 : 0;
                } catch (JSONException e) {
                } catch (NullPointerException e2) {
                }
            }
        });
    }

    public String a() {
        return a(this.b, "shortversion", "") + " (" + a(this.b, "version", "") + ")";
    }

    @SuppressLint({"SimpleDateFormat"})
    public String b() {
        return new SimpleDateFormat("dd.MM.yyyy").format(new Date(a(this.b, "timestamp", 0) * 1000));
    }

    public long c() {
        boolean booleanValue = Boolean.valueOf(a(this.b, "external", "false")).booleanValue();
        long a = a(this.b, "appsize", 0);
        return (booleanValue && a == 0) ? -1 : a;
    }

    private static String a(JSONObject jSONObject, String str, String str2) {
        try {
            str2 = jSONObject.getString(str);
        } catch (JSONException e) {
        }
        return str2;
    }

    private static long a(JSONObject jSONObject, String str, long j) {
        try {
            j = jSONObject.getLong(str);
        } catch (JSONException e) {
        }
        return j;
    }

    public String a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<body style='padding: 0px 0px 20px 0px'>");
        Iterator it = this.a.iterator();
        int i = 0;
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            if (i > 0) {
                stringBuilder.append(e());
                if (z) {
                    stringBuilder.append(a(i, jSONObject));
                }
            }
            stringBuilder.append(b(i, jSONObject));
            stringBuilder.append(c(i, jSONObject));
            i++;
        }
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    private Object e() {
        return "<hr style='border-top: 1px solid #c8c8c8; border-bottom: 0px; margin: 40px 10px 0px 10px;' />";
    }

    private String a(int i, JSONObject jSONObject) {
        StringBuilder stringBuilder = new StringBuilder();
        String a = a(jSONObject);
        if (a.length() > 0) {
            stringBuilder.append("<a href='restore:" + a + "'  style='background: #c8c8c8; color: #000; display: block; float: right; padding: 7px; margin: 0px 10px 10px; text-decoration: none;'>Restore</a>");
        }
        return stringBuilder.toString();
    }

    private String a(JSONObject jSONObject) {
        String str = "";
        try {
            str = jSONObject.getString("id");
        } catch (JSONException e) {
        }
        return str;
    }

    private String b(int i, JSONObject jSONObject) {
        StringBuilder stringBuilder = new StringBuilder();
        int b = b(this.b);
        int b2 = b(jSONObject);
        String c = c(jSONObject);
        stringBuilder.append("<div style='padding: 20px 10px 10px;'><strong>");
        if (i == 0) {
            stringBuilder.append("Newest version:");
        } else {
            stringBuilder.append("Version " + c + " (" + b2 + "): ");
            if (b2 != b && b2 == this.d) {
                this.d = -1;
                stringBuilder.append("[INSTALLED]");
            }
        }
        stringBuilder.append("</strong></div>");
        return stringBuilder.toString();
    }

    private int b(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.getInt("version");
        } catch (JSONException e) {
        }
        return i;
    }

    private String c(JSONObject jSONObject) {
        String str = "";
        try {
            str = jSONObject.getString("shortversion");
        } catch (JSONException e) {
        }
        return str;
    }

    private String c(int i, JSONObject jSONObject) {
        StringBuilder stringBuilder = new StringBuilder();
        String a = a(jSONObject, "notes", "");
        stringBuilder.append("<div style='padding: 0px 10px;'>");
        if (a.trim().length() == 0) {
            stringBuilder.append("<em>No information.</em>");
        } else {
            stringBuilder.append(a);
        }
        stringBuilder.append("</div>");
        return stringBuilder.toString();
    }

    public static int a(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        try {
            Scanner scanner = new Scanner(str.replaceAll("\\-.*", ""));
            Scanner scanner2 = new Scanner(str2.replaceAll("\\-.*", ""));
            scanner.useDelimiter("\\.");
            scanner2.useDelimiter("\\.");
            while (scanner.hasNextInt() && scanner2.hasNextInt()) {
                int nextInt = scanner.nextInt();
                int nextInt2 = scanner2.nextInt();
                if (nextInt < nextInt2) {
                    return -1;
                }
                if (nextInt > nextInt2) {
                    return 1;
                }
            }
            if (scanner.hasNextInt()) {
                return 1;
            }
            if (scanner2.hasNextInt()) {
                return -1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public static boolean a(Context context, long j) {
        if (context == null) {
            return false;
        }
        try {
            if (j > (new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir).lastModified() / 1000) + 1800) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String a(String str) {
        if (str == null || str.equalsIgnoreCase("L")) {
            return "5.0";
        }
        if (str.equalsIgnoreCase("M")) {
            return "6.0";
        }
        if (Pattern.matches("^[a-zA-Z]+", str)) {
            return "99.0";
        }
        return str;
    }
}
