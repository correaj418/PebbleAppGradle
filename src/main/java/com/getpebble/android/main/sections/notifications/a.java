package com.getpebble.android.main.sections.notifications;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.main.sections.notifications.a.d;
import java.util.HashMap;
import java.util.Map;

public abstract class a extends b implements OnClickListener, com.getpebble.android.common.framework.a.a {
    private Handler a = new Handler(Looper.getMainLooper());
    private d b;
    private RecyclerView c;
    private Map<Integer, String> d;

    public interface a {
        void a(Map<Integer, String> map);
    }

    protected abstract void a(a aVar);

    protected abstract void a(Map<Integer, String> map);

    protected abstract String d();

    protected abstract com.getpebble.android.common.b.a.a.c.a e();

    protected abstract String[] f();

    public int c() {
        return R.layout.fragment_canned_responses;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        viewGroup.findViewById(R.id.btn_reset).setOnClickListener(this);
        this.c = (RecyclerView) viewGroup.findViewById(R.id.my_recycler_view);
        this.b = new d(this.c, null);
        this.c.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.c.setAdapter(this.b);
        TextView textView = (TextView) viewGroup.findViewById(R.id.header);
        CharSequence d = d();
        if (!TextUtils.isEmpty(d)) {
            textView.setText(d);
        }
        a(new a(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void a(final Map<Integer, String> map) {
                this.a.a.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 b;

                    public void run() {
                        this.b.a.d = map == null ? new HashMap() : new HashMap(map);
                        this.b.a.b.a(this.b.a.d);
                    }
                });
            }
        });
    }

    public void onPause() {
        super.onPause();
        View view = getView();
        if (view != null) {
            ((InputMethodManager) getActivity().getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            view.clearFocus();
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.canned_responses_menu, menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                h();
                return true;
            case R.id.menu_add:
                if (!this.b.e()) {
                    return true;
                }
                this.a.postDelayed(new Runnable(this) {
                    final /* synthetic */ a a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        this.a.c.a(this.a.b.a() - 1);
                    }
                }, 100);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_reset:
                String[] f = f();
                Map hashMap = new HashMap();
                for (int i = 0; i < f.length; i++) {
                    hashMap.put(Integer.valueOf(i), f[i]);
                }
                this.b.a(hashMap);
                g();
                return;
            default:
                return;
        }
    }

    private void g() {
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            IBinder windowToken = currentFocus.getWindowToken();
            if (windowToken != null) {
                ((InputMethodManager) getActivity().getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(windowToken, 0);
            }
        }
    }

    private void h() {
        f.d("AbsCannedResponsesFragment", "saveCannedResponses");
        com.getpebble.android.common.model.ak.a r = PebbleApplication.r();
        String str = null;
        if (r != null) {
            str = r.getFwVersion().getVersionTag();
        }
        Map f = this.b.f();
        int max = Math.max(f.size(), this.d.size());
        b bVar = new b(str, max, e());
        int i = 0;
        while (i < max) {
            boolean z;
            str = (String) f.get(Integer.valueOf(i));
            CharSequence charSequence = (String) this.d.get(Integer.valueOf(i));
            if (com.getpebble.android.common.b.b.a.a(charSequence, str)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                f.e("AbsCannedResponsesFragment", "Canned response " + i + " old = '" + charSequence + "' new = '" + str + "'");
                charSequence = str;
            }
            bVar.a(z, charSequence);
            if (TextUtils.isEmpty(str)) {
                String[] f2 = f();
                if (f2 == null || i > f2.length - 1 || f.containsValue(f2[i])) {
                    f.put(Integer.valueOf(i), str);
                } else {
                    f.put(Integer.valueOf(i), f2[i]);
                }
            } else {
                f.put(Integer.valueOf(i), str);
            }
            i++;
        }
        a(f);
        bVar.a();
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        h();
        return false;
    }
}
