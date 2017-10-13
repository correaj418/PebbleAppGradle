package com.getpebble.android.main.sections.support.fragment;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.b.b.j;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.b.a.a.g;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.h.h;
import com.getpebble.android.main.activity.NoConnectivityActivity;
import com.getpebble.android.main.sections.support.activity.FirmwareUpdateActivity;
import com.getpebble.android.main.sections.support.activity.NotificationDemoActivity;
import com.getpebble.android.main.sections.support.activity.SupportHelpdeskActivity;
import com.getpebble.android.main.sections.support.d;
import java.util.ArrayList;
import java.util.List;

public class SupportFragment extends com.getpebble.android.common.framework.a.b implements OnItemClickListener {
    private ListView a;
    private a b;
    private TextView c;
    private int d;

    private static class a extends ArrayAdapter<b> {
        private Context a;

        public a(Context context, List<b> list) {
            super(context, R.layout.support_list_item, list);
            this.a = context;
        }

        public int a(int i) {
            return ((b) getItem(i)).a;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(R.layout.support_list_item, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.item_summary);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_icon);
            b bVar = (b) getItem(i);
            ((TextView) view.findViewById(R.id.item_title)).setText(bVar.a);
            textView.setText(bVar.b);
            imageView.setImageResource(bVar.c);
            return view;
        }
    }

    private static class b {
        public int a;
        public int b;
        public int c;

        public b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    static /* synthetic */ int a(SupportFragment supportFragment) {
        int i = supportFragment.d + 1;
        supportFragment.d = i;
        return i;
    }

    public int c() {
        return R.layout.fragment_support;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c.d("Support");
        this.a = (ListView) viewGroup.findViewById(16908298);
        this.b = new a(getActivity(), f());
        this.a.setAdapter(this.b);
        this.a.setOnItemClickListener(this);
        this.c = (TextView) viewGroup.findViewById(R.id.version_text);
        ((Button) viewGroup.findViewById(R.id.btn_check_updates)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SupportFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                c.e("startUpdate", "Support");
                Context activity = this.a.getActivity();
                if (activity == null) {
                    f.a("SupportFragment", "OnClick CheckUpdateButton: activity was null");
                } else if (h.a(activity.getApplicationContext())) {
                    this.a.startActivity(new Intent(activity, FirmwareUpdateActivity.class));
                } else if (activity instanceof com.getpebble.android.core.a) {
                    this.a.startActivity(new Intent(activity, NoConnectivityActivity.class));
                } else {
                    Toast.makeText(activity, this.a.getString(R.string.no_internet_connection_subtext), 1).show();
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        a();
        b();
    }

    private void a() {
        this.c.setText(String.format(getString(R.string.support_version_format), new Object[]{d(), e()}));
        this.d = 0;
        this.c.setClickable(true);
        this.c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SupportFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (SupportFragment.a(this.a) >= 7) {
                    f.d("SupportFragment", "egg!");
                    Builder builder = new Builder(this.a.getActivity());
                    ImageView imageView = new ImageView(this.a.getActivity());
                    j.a(imageView).b("https://s3-us-west-2.amazonaws.com/assets.coderag.prd/wp-content/uploads/2016/05/coderag_endframe_gavin.jpg");
                    this.a.d = 0;
                    builder.setView(imageView);
                    builder.show();
                }
            }
        });
    }

    private void b() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("support_email_request") && arguments.getBoolean("support_email_request")) {
            boolean z = arguments.getBoolean("include_logs");
            f.d("SupportFragment", "Starting support email from arguments");
            new com.getpebble.android.main.sections.support.c(this).startSupportEmailTasks(z);
            getArguments().remove("support_email_request");
            getArguments().remove("include_logs");
        }
    }

    private String d() {
        return "4.4.1-1404-01abd2f76-endframe" + ("prod".equals("dev") ? "-DEV" : "");
    }

    private String e() {
        com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
        if (r == null) {
            return getString(R.string.support_version_not_connected);
        }
        if (r.getFwVersion() == null) {
            return getString(R.string.support_version_unknown);
        }
        return r.getFwVersion().getVersionTag();
    }

    private List<b> f() {
        List<b> arrayList = new ArrayList();
        arrayList.add(new b(R.string.support_getting_started_label, R.string.support_getting_started_summary, R.drawable.support_icon_getting_started));
        arrayList.add(new b(R.string.support_faq_label, R.string.support_faq_summary, R.drawable.support_icon_faq));
        arrayList.add(new b(R.string.support_community_label, R.string.support_community_summary, R.drawable.support_icon_community));
        arrayList.add(new b(R.string.pref_title_notification_help, R.string.pref_summary_notification_help, R.drawable.support_icon_getting_started));
        arrayList.add(new b(R.string.support_diag_label, R.string.support_diag_summary, R.drawable.support_icon_helpdesk));
        arrayList.add(new b(R.string.support_test_notifications_label, R.string.support_test_notifications_summary, R.drawable.exclamation_icon));
        return arrayList;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (this.b.a(i)) {
            case R.string.pref_title_notification_help:
                getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(PebbleApplication.w().m())));
                return;
            case R.string.support_community_label:
                a(PebbleApplication.w().n());
                g.a();
                return;
            case R.string.support_diag_label:
                f.d("SupportFragment", "Starting support email from menu item click");
                a(getActivity());
                return;
            case R.string.support_faq_label:
                a(PebbleApplication.w().k());
                g.c();
                return;
            case R.string.support_getting_started_label:
                a(PebbleApplication.w().o());
                g.d();
                return;
            case R.string.support_suggest_label:
                a(PebbleApplication.w().l());
                g.e();
                return;
            case R.string.support_test_notifications_label:
                startActivity(new Intent(getActivity(), NotificationDemoActivity.class));
                g.f();
                return;
            default:
                return;
        }
    }

    public static void a(final Activity activity) {
        g.b();
        com.cocosw.bottomsheet.c a = new com.cocosw.bottomsheet.c.a(activity).a((int) R.menu.support_menu).a(new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == R.id.help_link) {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(activity.getString(R.string.helpdesk_url))));
                    return;
                }
                d from = d.from(i);
                Intent intent = new Intent(activity, SupportHelpdeskActivity.class);
                intent.putExtra("extra_support_target", from.getTitle(activity));
                activity.startActivity(intent);
            }
        }).a(activity.getString(R.string.choose_your_issue_category)).a();
        if (!com.getpebble.android.framework.o.b.isHealthSupported()) {
            a.a().removeItem(R.id.pebble_health);
        }
        a.show();
    }

    private void a(String str) {
        getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
