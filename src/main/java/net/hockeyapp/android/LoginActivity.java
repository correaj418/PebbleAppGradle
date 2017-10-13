package net.hockeyapp.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import net.hockeyapp.android.d.f;
import net.hockeyapp.android.e.a;
import net.hockeyapp.android.e.h;
import net.hockeyapp.android.i.b;
import net.hockeyapp.android.i.c;
import net.hockeyapp.android.i.d;

public class LoginActivity extends Activity {
    private String a;
    private String b;
    private int c;
    private f d;
    private Handler e;
    private Button f;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.activity_login);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.a = extras.getString("url");
            this.b = extras.getString("secret");
            this.c = extras.getInt("mode");
        }
        a();
        b();
        Object lastNonConfigurationInstance = getLastNonConfigurationInstance();
        if (lastNonConfigurationInstance != null) {
            this.d = (f) lastNonConfigurationInstance;
            this.d.a((Context) this, this.e);
        }
    }

    public Object onRetainNonConfigurationInstance() {
        if (this.d != null) {
            this.d.a();
        }
        return this.d;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (g.b != null) {
                g.b.b();
            } else {
                Intent intent = new Intent(this, g.a);
                intent.setFlags(67108864);
                intent.putExtra("net.hockeyapp.android.EXIT", true);
                startActivity(intent);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void a() {
        if (this.c == 1) {
            ((EditText) findViewById(b.input_password)).setVisibility(4);
        }
        this.f = (Button) findViewById(b.button_login);
        this.f.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.c();
            }
        });
    }

    private void b() {
        this.e = new Handler(this) {
            final /* synthetic */ LoginActivity a;

            {
                this.a = r1;
            }

            public void handleMessage(Message message) {
                if (message.getData().getBoolean("success")) {
                    this.a.finish();
                    if (g.b != null) {
                        g.b.a();
                        return;
                    }
                    return;
                }
                Toast.makeText(this.a, "Login failed. Check your credentials.", 1).show();
            }
        };
    }

    private void c() {
        int i = 0;
        if (h.a((Context) this)) {
            CharSequence obj = ((EditText) findViewById(b.input_email)).getText().toString();
            CharSequence obj2 = ((EditText) findViewById(b.input_password)).getText().toString();
            Map hashMap = new HashMap();
            if (this.c == 1) {
                int i2 = !TextUtils.isEmpty(obj) ? 1 : 0;
                hashMap.put("email", obj);
                hashMap.put("authcode", a(this.b + obj));
                i = i2;
            } else if (this.c == 2) {
                if (!(TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2))) {
                    i = 1;
                }
                hashMap.put("email", obj);
                hashMap.put("password", obj2);
            }
            if (i != 0) {
                this.d = new f(this, this.e, this.a, this.c, hashMap);
                a.a(this.d);
                return;
            }
            Toast.makeText(this, getString(d.hockeyapp_login_missing_credentials_toast), 1).show();
            return;
        }
        Toast.makeText(this, d.hockeyapp_error_no_network_message, 1).show();
    }

    public String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & 255);
                while (toHexString.length() < 2) {
                    toHexString = "0" + toHexString;
                }
                stringBuilder.append(toHexString);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
