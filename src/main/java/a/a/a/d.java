package a.a.a;

import android.os.AsyncTask;
import android.util.Log;
import com.google.b.o;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class d extends AsyncTask<String, String, String> {
    private final String a = "Authorization";
    private final String b = "Accept";
    private final String c = "Bearer %s";
    private final String d = ("application/vnd.wit." + e.c);
    private String e;
    private o f;
    private a g;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }

    public d(String str, o oVar, a aVar) {
        this.e = str;
        this.f = oVar;
        this.g = aVar;
    }

    public static String a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                stringBuilder.append(readLine);
            } else {
                inputStream.close();
                return stringBuilder.toString();
            }
        }
    }

    protected String a(String... strArr) {
        String str;
        Throwable th;
        Throwable th2;
        String str2 = null;
        try {
            str = strArr[0];
            e eVar = new e(this.g, this.f);
            Log.d("Wit", "Requesting ...." + strArr[0]);
            str = eVar.a("message").appendQueryParameter("q", str).build().toString();
            Log.d(getClass().getName(), "URL IS: " + str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.addRequestProperty("Authorization", String.format("Bearer %s", new Object[]{this.e}));
            httpURLConnection.addRequestProperty("Accept", this.d);
            try {
                InputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                String a = a(bufferedInputStream);
                try {
                    bufferedInputStream.close();
                    try {
                        httpURLConnection.disconnect();
                        return a;
                    } catch (Throwable e) {
                        th = e;
                        str = a;
                        th2 = th;
                        Log.e("Wit", "An error occurred during the request, did you set your token correctly?", th2);
                        return str;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str2 = a;
                    th2 = th;
                    try {
                        httpURLConnection.disconnect();
                        throw th2;
                    } catch (Throwable e2) {
                        th2 = e2;
                        str = str2;
                        Log.e("Wit", "An error occurred during the request, did you set your token correctly?", th2);
                        return str;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                httpURLConnection.disconnect();
                throw th2;
            }
        } catch (Throwable e22) {
            th2 = e22;
            str = null;
            Log.e("Wit", "An error occurred during the request, did you set your token correctly?", th2);
            return str;
        }
    }

    protected void a(String str) {
    }
}
