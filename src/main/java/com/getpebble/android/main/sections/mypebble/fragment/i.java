package com.getpebble.android.main.sections.mypebble.fragment;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract.Contacts;
import android.support.v4.view.q;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.core.a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class i extends b implements LoaderCallbacks<Cursor>, OnQueryTextListener {
    private static final long a = TimeUnit.MILLISECONDS.toMillis(250);
    private com.getpebble.android.main.sections.mypebble.a.b b;
    private ListView c;
    private View d;
    private Handler e;

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    public static i a(int i, String[] strArr) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putInt("extra_num_faves_added", i);
        bundle.putStringArray("extra_fave_lookup_keys", strArr);
        iVar.setArguments(bundle);
        return iVar;
    }

    public int c() {
        return R.layout.fragment_sms_contacts;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = new Handler();
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.search_menu, menu);
        ((SearchView) q.a(menu.findItem(R.id.search_item))).setOnQueryTextListener(this);
    }

    public boolean onQueryTextSubmit(String str) {
        this.e.removeCallbacksAndMessages(null);
        a(str);
        return true;
    }

    public boolean onQueryTextChange(final String str) {
        this.e.removeCallbacksAndMessages(null);
        this.e.postDelayed(new Runnable(this) {
            final /* synthetic */ i b;

            public void run() {
                this.b.a(str);
            }
        }, a);
        return true;
    }

    private void a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("search_arg", str);
        getLoaderManager().restartLoader(0, bundle, this);
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getActivity().setTitle(R.string.sms_contacts_title);
        this.d = viewGroup.findViewById(R.id.sms_contacts_no_results);
        this.d.setVisibility(8);
        this.b = new com.getpebble.android.main.sections.mypebble.a.b(getActivity(), a());
        this.c = (ListView) viewGroup.findViewById(R.id.sms_contacts_lv);
        this.c.setAdapter(this.b);
        this.c.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ i a;

            {
                this.a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!this.a.b.a(i) && i != -99) {
                    this.a.a(j, this.a.b.b(i));
                }
            }
        });
        getLoaderManager().initLoader(0, null, this);
    }

    private void a(long j, int i) {
        a aVar = (a) getActivity();
        Cursor a = this.b.a();
        if (a.moveToPosition(i)) {
            String string = a.getString(a.getColumnIndex("lookup"));
            String string2 = a.getString(a.getColumnIndex("display_name"));
            int i2 = getArguments().getInt("extra_num_faves_added");
            if (aVar != null) {
                aVar.a(j.a(j, string, string2, i2), false, false, true);
                return;
            }
            return;
        }
        Toast.makeText(aVar, R.string.something_went_wrong_message, 0).show();
    }

    private Set<String> a() {
        Set<String> hashSet = new HashSet();
        String[] stringArray = getArguments().getStringArray("extra_fave_lookup_keys");
        if (stringArray != null) {
            hashSet.addAll(Arrays.asList(stringArray));
        }
        return hashSet;
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] strArr;
        f.d("SmsChooseContactFragment", "onCreateLoader(): id = " + i);
        String[] strArr2 = new String[]{ai.COLUMN_ID, "display_name", "lookup"};
        String str = "has_phone_number != 0";
        String str2 = "display_name COLLATE LOCALIZED ASC";
        if (TextUtils.isEmpty(bundle == null ? null : bundle.getString("search_arg"))) {
            strArr = null;
        } else {
            str = str + " AND display_name LIKE ?";
            strArr = new String[]{"%" + r0 + "%"};
        }
        return new CursorLoader(getActivity(), Contacts.CONTENT_URI, strArr2, str, strArr, str2);
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        int i;
        int i2;
        int i3 = 0;
        f.d("SmsChooseContactFragment", "onLoadFinished() id = " + loader.getId());
        this.b.a(cursor);
        if (cursor.getCount() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        ListView listView = this.c;
        if (i != 0) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        listView.setVisibility(i2);
        View view = this.d;
        if (i == 0) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        f.d("SmsChooseContactFragment", "onLoaderReset() id = " + loader.getId());
        this.b.b(null);
        this.e.removeCallbacksAndMessages(null);
    }
}
