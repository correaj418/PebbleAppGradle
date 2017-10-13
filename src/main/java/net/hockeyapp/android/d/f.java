package net.hockeyapp.android.d;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.Map;
import net.hockeyapp.android.a;
import net.hockeyapp.android.e.d;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends c<Void, Void, Boolean> {
    private Context a;
    private Handler b;
    private ProgressDialog c;
    private boolean d = true;
    private final int e;
    private final String f;
    private final Map<String, String> g;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Boolean) obj);
    }

    public f(Context context, Handler handler, String str, int i, Map<String, String> map) {
        this.a = context;
        this.b = handler;
        this.f = str;
        this.e = i;
        this.g = map;
        if (context != null) {
            a.a(context);
        }
    }

    public void a(Context context, Handler handler) {
        this.a = context;
        this.b = handler;
    }

    public void a() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    protected void onPreExecute() {
        if ((this.c == null || !this.c.isShowing()) && this.d) {
            this.c = ProgressDialog.show(this.a, "", "Please wait...", true, false);
        }
    }

    protected Boolean a(Void... voidArr) {
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = a(this.e, this.g);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                String a = c.a(httpURLConnection);
                if (!TextUtils.isEmpty(a)) {
                    Boolean valueOf = Boolean.valueOf(a(a));
                    if (httpURLConnection == null) {
                        return valueOf;
                    }
                    httpURLConnection.disconnect();
                    return valueOf;
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return Boolean.valueOf(false);
    }

    protected void a(Boolean bool) {
        if (this.c != null) {
            try {
                this.c.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.b != null) {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putBoolean("success", bool.booleanValue());
            message.setData(bundle);
            this.b.sendMessage(message);
        }
    }

    private HttpURLConnection a(int i, Map<String, String> map) {
        if (i == 1) {
            return new d(this.f).a("POST").a((Map) map).a();
        }
        if (i == 2) {
            return new d(this.f).a("POST").b((String) map.get("email"), (String) map.get("password")).a();
        }
        if (i == 3) {
            return new d(this.f + "?" + ((String) map.get("type")) + "=" + ((String) map.get("id"))).a();
        }
        throw new IllegalArgumentException("Login mode " + i + " not supported.");
    }

    private boolean a(String str) {
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("net.hockeyapp.android.login", 0);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("status");
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            Object string2;
            if (this.e == 1) {
                if (!string.equals("identified")) {
                    return false;
                }
                string2 = jSONObject.getString("iuid");
                if (TextUtils.isEmpty(string2)) {
                    return false;
                }
                sharedPreferences.edit().putString("iuid", string2).apply();
                return true;
            } else if (this.e == 2) {
                if (!string.equals("authorized")) {
                    return false;
                }
                string2 = jSONObject.getString("auid");
                if (TextUtils.isEmpty(string2)) {
                    return false;
                }
                sharedPreferences.edit().putString("auid", string2).apply();
                return true;
            } else if (this.e != 3) {
                throw new IllegalArgumentException("Login mode " + this.e + " not supported.");
            } else if (string.equals("validated")) {
                return true;
            } else {
                sharedPreferences.edit().remove("iuid").remove("auid").apply();
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
