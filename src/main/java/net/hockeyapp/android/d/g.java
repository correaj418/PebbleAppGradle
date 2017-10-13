package net.hockeyapp.android.d;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import net.hockeyapp.android.FeedbackActivity;
import net.hockeyapp.android.c.f;
import net.hockeyapp.android.e;
import net.hockeyapp.android.e.c;
import net.hockeyapp.android.e.h;

public class g extends AsyncTask<Void, Void, net.hockeyapp.android.c.g> {
    private Context a;
    private String b;
    private Handler c;
    private String d;
    private String e = null;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((net.hockeyapp.android.c.g) obj);
    }

    public g(Context context, String str, Handler handler, String str2) {
        this.a = context;
        this.b = str;
        this.c = handler;
        this.d = str2;
    }

    protected net.hockeyapp.android.c.g a(Void... voidArr) {
        if (this.a == null || this.b == null) {
            return null;
        }
        net.hockeyapp.android.c.g a = c.a().a(this.b);
        if (a == null || a.b() == null) {
            return a;
        }
        ArrayList a2 = a.b().a();
        if (a2 == null || a2.isEmpty()) {
            return a;
        }
        a(a2);
        return a;
    }

    protected void a(net.hockeyapp.android.c.g gVar) {
        if (gVar != null && this.c != null) {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putSerializable("parse_feedback_response", gVar);
            message.setData(bundle);
            this.c.sendMessage(message);
        }
    }

    private void a(ArrayList<f> arrayList) {
        f fVar = (f) arrayList.get(arrayList.size() - 1);
        int c = fVar.c();
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("net.hockeyapp.android.feedback", 0);
        if (this.d.equals("send")) {
            sharedPreferences.edit().putInt("idLastMessageSend", c).putInt("idLastMessageProcessed", c).apply();
        } else if (this.d.equals("fetch")) {
            int i = sharedPreferences.getInt("idLastMessageSend", -1);
            int i2 = sharedPreferences.getInt("idLastMessageProcessed", -1);
            if (c != i && c != i2) {
                boolean a;
                sharedPreferences.edit().putInt("idLastMessageProcessed", c).apply();
                net.hockeyapp.android.f a2 = e.a();
                if (a2 != null) {
                    a = a2.a(fVar);
                } else {
                    a = false;
                }
                if (!a) {
                    a(this.a);
                }
            }
        }
    }

    private void a(Context context) {
        if (this.e != null) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            int identifier = context.getResources().getIdentifier("ic_menu_refresh", "drawable", "android");
            Class cls = null;
            if (e.a() != null) {
                cls = e.a().a();
            }
            if (cls == null) {
                cls = FeedbackActivity.class;
            }
            Intent intent = new Intent();
            intent.setFlags(805306368);
            intent.setClass(context, cls);
            intent.putExtra("url", this.e);
            Notification a = h.a(context, PendingIntent.getActivity(context, 0, intent, 1073741824), "HockeyApp Feedback", "A new answer to your feedback is available.", identifier);
            if (a != null) {
                notificationManager.notify(2, a);
            }
        }
    }
}
