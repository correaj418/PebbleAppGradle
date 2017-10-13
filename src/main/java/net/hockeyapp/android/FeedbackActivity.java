package net.hockeyapp.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import net.hockeyapp.android.a.a;
import net.hockeyapp.android.c.c;
import net.hockeyapp.android.c.f;
import net.hockeyapp.android.d.g;
import net.hockeyapp.android.d.h;
import net.hockeyapp.android.i.b;
import net.hockeyapp.android.i.d;
import net.hockeyapp.android.views.AttachmentListView;

public class FeedbackActivity extends Activity implements OnClickListener {
    private String A;
    private String a;
    private String b;
    private Context c;
    private TextView d;
    private EditText e;
    private EditText f;
    private EditText g;
    private EditText h;
    private Button i;
    private Button j;
    private Button k;
    private Button l;
    private ScrollView m;
    private LinearLayout n;
    private ListView o;
    private h p;
    private Handler q;
    private g r;
    private Handler s;
    private List<Uri> t;
    private String u;
    private c v;
    private a w;
    private ArrayList<f> x;
    private boolean y;
    private boolean z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.c.activity_feedback);
        setTitle(getString(d.hockeyapp_feedback_title));
        this.c = this;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.u = extras.getString("url");
            this.a = extras.getString("initialUserName");
            this.b = extras.getString("initialUserEmail");
            Parcelable[] parcelableArray = extras.getParcelableArray("initialAttachments");
            if (parcelableArray != null) {
                this.t = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    this.t.add((Uri) parcelable);
                }
            }
        }
        if (bundle != null) {
            this.z = bundle.getBoolean("feedbackViewInitialized");
            this.y = bundle.getBoolean("inSendFeedback");
        } else {
            this.y = false;
            this.z = false;
        }
        ((NotificationManager) getSystemService("notification")).cancel(2);
        c();
        d();
        a();
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            ViewGroup viewGroup = (ViewGroup) findViewById(b.wrapper_attachments);
            Iterator it = bundle.getParcelableArrayList("attachments").iterator();
            while (it.hasNext()) {
                viewGroup.addView(new net.hockeyapp.android.views.a((Context) this, viewGroup, (Uri) it.next(), true));
            }
            this.z = bundle.getBoolean("feedbackViewInitialized");
        }
        super.onRestoreInstanceState(bundle);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelableArrayList("attachments", ((AttachmentListView) findViewById(b.wrapper_attachments)).getAttachments());
        bundle.putBoolean("feedbackViewInitialized", this.z);
        bundle.putBoolean("inSendFeedback", this.y);
        super.onSaveInstanceState(bundle);
    }

    protected void onStop() {
        super.onStop();
        if (this.p != null) {
            this.p.a();
        }
    }

    public Object onRetainNonConfigurationInstance() {
        if (this.p != null) {
            this.p.a();
        }
        return this.p;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.y) {
            this.y = false;
            a();
        } else {
            finish();
        }
        return true;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == b.button_send) {
            f();
        } else if (id == b.button_attachment) {
            if (((ViewGroup) findViewById(b.wrapper_attachments)).getChildCount() >= 3) {
                Toast.makeText(this, String.valueOf(3), 0).show();
            } else {
                openContextMenu(view);
            }
        } else if (id == b.button_add_response) {
            b(false);
            this.y = true;
        } else if (id == b.button_refresh) {
            a(this.u, null, null, null, null, null, net.hockeyapp.android.e.f.a().a(this.c), this.q, true);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 2, 0, getString(d.hockeyapp_feedback_attach_file));
        contextMenu.add(0, 1, 0, getString(d.hockeyapp_feedback_attach_picture));
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
            case 2:
                return a(menuItem.getItemId());
            default:
                return super.onContextItemSelected(menuItem);
        }
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                return new Builder(this).setMessage(getString(d.hockeyapp_dialog_error_message)).setCancelable(false).setTitle(getString(d.hockeyapp_dialog_error_title)).setIcon(17301543).setPositiveButton(getString(d.hockeyapp_dialog_positive_button), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ FeedbackActivity a;

                    {
                        this.a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.a.v = null;
                        dialogInterface.cancel();
                    }
                }).create();
            default:
                return null;
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        switch (i) {
            case 0:
                AlertDialog alertDialog = (AlertDialog) dialog;
                if (this.v != null) {
                    alertDialog.setMessage(this.v.a());
                    return;
                } else {
                    alertDialog.setMessage(getString(d.hockeyapp_feedback_generic_error));
                    return;
                }
            default:
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 2) {
                Uri data = intent.getData();
                if (data != null) {
                    ViewGroup viewGroup = (ViewGroup) findViewById(b.wrapper_attachments);
                    viewGroup.addView(new net.hockeyapp.android.views.a((Context) this, viewGroup, data, true));
                }
            } else if (i == 1) {
                Parcelable data2 = intent.getData();
                if (data2 != null) {
                    try {
                        Intent intent2 = new Intent(this, PaintActivity.class);
                        intent2.putExtra("imageUri", data2);
                        startActivityForResult(intent2, 3);
                    } catch (Throwable e) {
                        Log.e("HockeyApp", "Paint activity not declared!", e);
                    }
                }
            } else if (i == 3) {
                Uri uri = (Uri) intent.getParcelableExtra("imageUri");
                if (uri != null) {
                    ViewGroup viewGroup2 = (ViewGroup) findViewById(b.wrapper_attachments);
                    viewGroup2.addView(new net.hockeyapp.android.views.a((Context) this, viewGroup2, uri, true));
                }
            }
        }
    }

    public void a(boolean z) {
        if (this.i != null) {
            this.i.setEnabled(z);
        }
    }

    protected void b(boolean z) {
        this.m = (ScrollView) findViewById(b.wrapper_feedback_scroll);
        this.n = (LinearLayout) findViewById(b.wrapper_messages);
        this.o = (ListView) findViewById(b.list_feedback_messages);
        if (z) {
            this.n.setVisibility(0);
            this.m.setVisibility(8);
            this.d = (TextView) findViewById(b.label_last_updated);
            this.k = (Button) findViewById(b.button_add_response);
            this.k.setOnClickListener(this);
            this.l = (Button) findViewById(b.button_refresh);
            this.l.setOnClickListener(this);
            return;
        }
        this.n.setVisibility(8);
        this.m.setVisibility(0);
        this.e = (EditText) findViewById(b.input_name);
        this.f = (EditText) findViewById(b.input_email);
        this.g = (EditText) findViewById(b.input_subject);
        this.h = (EditText) findViewById(b.input_message);
        if (!this.z) {
            String b = net.hockeyapp.android.e.f.a().b(this.c);
            if (b != null) {
                String[] split = b.split("\\|");
                if (split != null && split.length >= 2) {
                    this.e.setText(split[0]);
                    this.f.setText(split[1]);
                    if (split.length >= 3) {
                        this.g.setText(split[2]);
                        this.h.requestFocus();
                    } else {
                        this.g.requestFocus();
                    }
                }
            } else {
                this.e.setText(this.a);
                this.f.setText(this.b);
                this.g.setText("");
                if (TextUtils.isEmpty(this.a)) {
                    this.e.requestFocus();
                } else if (TextUtils.isEmpty(this.b)) {
                    this.f.requestFocus();
                } else {
                    this.g.requestFocus();
                }
            }
            this.z = true;
        }
        this.h.setText("");
        if (net.hockeyapp.android.e.f.a().a(this.c) != null) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(b.wrapper_attachments);
        viewGroup.removeAllViews();
        if (this.t != null) {
            for (Uri aVar : this.t) {
                viewGroup.addView(new net.hockeyapp.android.views.a((Context) this, viewGroup, aVar, true));
            }
        }
        this.j = (Button) findViewById(b.button_attachment);
        this.j.setOnClickListener(this);
        registerForContextMenu(this.j);
        this.i = (Button) findViewById(b.button_send);
        this.i.setOnClickListener(this);
    }

    protected void c(boolean z) {
    }

    private boolean a(int i) {
        Intent intent;
        if (i == 2) {
            intent = new Intent();
            intent.setType("*/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            startActivityForResult(Intent.createChooser(intent, getString(d.hockeyapp_feedback_select_file)), 2);
            return true;
        } else if (i != 1) {
            return false;
        } else {
            intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            startActivityForResult(Intent.createChooser(intent, getString(d.hockeyapp_feedback_select_picture)), 1);
            return true;
        }
    }

    private void a() {
        this.A = net.hockeyapp.android.e.f.a().a(this);
        if (this.A == null || this.y) {
            b(false);
            return;
        }
        b(true);
        a(this.u, null, null, null, null, null, this.A, this.q, true);
    }

    private void a(String str, String str2) {
        this.r = new g(this, str, this.s, str2);
    }

    private void b() {
        if (this.h != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.h.getWindowToken(), 0);
        }
    }

    private void c() {
        this.q = new Handler(this) {
            final /* synthetic */ FeedbackActivity a;

            {
                this.a = r1;
            }

            public void handleMessage(Message message) {
                boolean z = false;
                this.a.v = new c();
                if (message == null || message.getData() == null) {
                    this.a.v.a(this.a.getString(d.hockeyapp_feedback_send_generic_error));
                } else {
                    Bundle data = message.getData();
                    String string = data.getString("feedback_response");
                    String string2 = data.getString("feedback_status");
                    String string3 = data.getString("request_type");
                    if (string3.equals("send") && (string == null || Integer.parseInt(string2) != 201)) {
                        this.a.v.a(this.a.getString(d.hockeyapp_feedback_send_generic_error));
                    } else if (string3.equals("fetch") && string2 != null && (Integer.parseInt(string2) == 404 || Integer.parseInt(string2) == 422)) {
                        this.a.e();
                        z = true;
                    } else if (string != null) {
                        this.a.b(string, string3);
                        z = true;
                    } else {
                        this.a.v.a(this.a.getString(d.hockeyapp_feedback_send_network_error));
                    }
                }
                if (!z) {
                    this.a.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            this.a.a.a(true);
                            this.a.a.showDialog(0);
                        }
                    });
                }
                this.a.c(z);
            }
        };
    }

    private void d() {
        this.s = new Handler(this) {
            final /* synthetic */ FeedbackActivity a;

            {
                this.a = r1;
            }

            public void handleMessage(Message message) {
                boolean z;
                this.a.v = new c();
                if (!(message == null || message.getData() == null)) {
                    net.hockeyapp.android.c.g gVar = (net.hockeyapp.android.c.g) message.getData().getSerializable("parse_feedback_response");
                    if (gVar != null) {
                        if (!gVar.a().equalsIgnoreCase("success")) {
                            z = false;
                        } else if (gVar.c() != null) {
                            net.hockeyapp.android.e.f.a().a(this.a.c, gVar.c());
                            this.a.a(gVar);
                            this.a.y = false;
                            z = true;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            this.a.runOnUiThread(new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 a;

                                {
                                    this.a = r1;
                                }

                                public void run() {
                                    this.a.a.showDialog(0);
                                }
                            });
                        }
                        this.a.a(true);
                    }
                }
                z = false;
                if (z) {
                    this.a.runOnUiThread(/* anonymous class already generated */);
                }
                this.a.a(true);
            }
        };
    }

    @SuppressLint({"SimpleDateFormat"})
    private void a(final net.hockeyapp.android.c.g gVar) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ FeedbackActivity b;

            public void run() {
                this.b.b(true);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("d MMM h:mm a");
                if (gVar != null && gVar.b() != null && gVar.b().a() != null && gVar.b().a().size() > 0) {
                    this.b.x = gVar.b().a();
                    Collections.reverse(this.b.x);
                    try {
                        Date parse = simpleDateFormat.parse(((f) this.b.x.get(0)).b());
                        this.b.d.setText(String.format(this.b.getString(d.hockeyapp_feedback_last_updated_text) + " %s", new Object[]{simpleDateFormat2.format(parse)}));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (this.b.w == null) {
                        this.b.w = new a(this.b.c, this.b.x);
                    } else {
                        this.b.w.a();
                        Iterator it = this.b.x.iterator();
                        while (it.hasNext()) {
                            this.b.w.a((f) it.next());
                        }
                        this.b.w.notifyDataSetChanged();
                    }
                    this.b.o.setAdapter(this.b.w);
                }
            }
        });
    }

    private void e() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ FeedbackActivity a;

            {
                this.a = r1;
            }

            public void run() {
                net.hockeyapp.android.e.f.a().a(this.a, null);
                this.a.getSharedPreferences("net.hockeyapp.android.feedback", 0).edit().remove("idLastMessageSend").remove("idLastMessageProcessed").apply();
                this.a.b(false);
            }
        });
    }

    private void f() {
        if (net.hockeyapp.android.e.h.a((Context) this)) {
            a(false);
            b();
            String a = net.hockeyapp.android.e.f.a().a(this.c);
            String trim = this.e.getText().toString().trim();
            String trim2 = this.f.getText().toString().trim();
            String trim3 = this.g.getText().toString().trim();
            Object trim4 = this.h.getText().toString().trim();
            if (TextUtils.isEmpty(trim3)) {
                this.g.setVisibility(0);
                a(this.g, d.hockeyapp_feedback_validate_subject_error);
                return;
            } else if (e.b() == net.hockeyapp.android.c.h.REQUIRED && TextUtils.isEmpty(trim)) {
                a(this.e, d.hockeyapp_feedback_validate_name_error);
                return;
            } else if (e.c() == net.hockeyapp.android.c.h.REQUIRED && TextUtils.isEmpty(trim2)) {
                a(this.f, d.hockeyapp_feedback_validate_email_empty);
                return;
            } else if (TextUtils.isEmpty(trim4)) {
                a(this.h, d.hockeyapp_feedback_validate_text_error);
                return;
            } else if (e.c() != net.hockeyapp.android.c.h.REQUIRED || net.hockeyapp.android.e.h.b(trim2)) {
                net.hockeyapp.android.e.f.a().a(this.c, trim, trim2, trim3);
                a(this.u, trim, trim2, trim3, trim4, ((AttachmentListView) findViewById(b.wrapper_attachments)).getAttachments(), a, this.q, false);
                return;
            } else {
                a(this.f, d.hockeyapp_feedback_validate_email_error);
                return;
            }
        }
        Toast.makeText(this, d.hockeyapp_error_no_network_message, 1).show();
    }

    private void a(EditText editText, int i) {
        editText.setError(getString(i));
        a(true);
    }

    private void a(String str, String str2, String str3, String str4, String str5, List<Uri> list, String str6, Handler handler, boolean z) {
        this.p = new h(this.c, str, str2, str3, str4, str5, list, str6, handler, z);
        net.hockeyapp.android.e.a.a(this.p);
    }

    private void b(String str, String str2) {
        a(str, str2);
        net.hockeyapp.android.e.a.a(this.r);
    }
}
