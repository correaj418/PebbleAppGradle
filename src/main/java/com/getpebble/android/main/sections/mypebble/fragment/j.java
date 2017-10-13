package com.getpebble.android.main.sections.mypebble.fragment;

import android.app.FragmentManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.ai;
import com.getpebble.android.common.model.aq;
import com.getpebble.android.common.model.at;
import com.getpebble.android.common.model.s;
import com.getpebble.android.h.w;
import com.getpebble.android.main.sections.mypebble.a.i;
import java.util.TreeSet;

public class j extends b implements LoaderCallbacks<Cursor>, com.getpebble.android.main.sections.mypebble.a.i.a {
    private ListView a;
    private i b;
    private View c;
    private long d;
    private String e;
    private String f;
    private int g;

    private class a extends f {
        final /* synthetic */ j a;
        private Cursor b;

        public a(j jVar, Cursor cursor) {
            this.a = jVar;
            this.b = j.c(cursor);
        }

        public boolean doInBackground() {
            SparseBooleanArray checkedItemPositions = this.a.a.getCheckedItemPositions();
            if (this.b == null || this.b.isClosed() || checkedItemPositions == null) {
                com.getpebble.android.common.b.a.f.b(f.TAG, "AddFavesAsyncTask: doInBackground() error, cursor=" + this.b + ", checkedPositions=" + checkedItemPositions);
                return false;
            }
            int i = 0;
            int c = this.a.g;
            for (int i2 = 0; i2 < this.b.getCount(); i2++) {
                if (checkedItemPositions.get(i2)) {
                    if (!this.b.moveToPosition(i2)) {
                        return false;
                    }
                    String string = this.b.getString(this.b.getColumnIndex("data1"));
                    s.a(this.a.f, this.a.e, this.b.getInt(this.b.getColumnIndex("data2")), string, c);
                    c++;
                    i++;
                }
            }
            c.c(i);
            at.a();
            return true;
        }

        public void onTaskSuccess() {
        }

        public void onTaskFailed() {
        }

        protected void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                Toast.makeText(com.getpebble.android.common.a.K(), R.string.something_went_wrong_message, 0).show();
            } else if (this.a.getActivity() != null) {
                FragmentManager fragmentManager = this.a.getActivity().getFragmentManager();
                fragmentManager.popBackStack();
                fragmentManager.popBackStack();
                fragmentManager.executePendingTransactions();
            }
        }
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    public static j a(long j, String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putLong("extra_contact_id", j);
        bundle.putString("extra_contact_lookup_key", str);
        bundle.putString("extra_contact_name", str2);
        bundle.putInt("extra_num_faves_added", i);
        j jVar = new j();
        jVar.setArguments(bundle);
        return jVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = getArguments().getLong("extra_contact_id");
        this.g = getArguments().getInt("extra_num_faves_added");
        this.e = getArguments().getString("extra_contact_name");
        this.f = getArguments().getString("extra_contact_lookup_key");
        getActivity().setTitle(this.e.toUpperCase());
    }

    public int c() {
        return R.layout.fragment_sms_numbers;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = (ListView) viewGroup.findViewById(R.id.sms_phone_numbers_lv);
        this.b = new i(getActivity(), this);
        this.a.setChoiceMode(2);
        this.a.setAdapter(this.b);
        this.c = viewGroup.findViewById(R.id.sms_add_to_faves_btn);
        this.c.setEnabled(false);
        this.c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ j a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.a();
            }
        });
        getLoaderManager().initLoader(0, null, this);
        getLoaderManager().initLoader(1, null, this);
    }

    private void a() {
        int i = 5 - this.g;
        if (this.a.getCheckedItemCount() > i) {
            Toast.makeText(getActivity(), getResources().getQuantityString(R.plurals.sms_max_faves, i, new Object[]{Integer.valueOf(i)}), 0).show();
            return;
        }
        new a(this, this.b.getCursor()).submit();
    }

    public void a(int i, long j, boolean z) {
        this.a.setItemChecked(i, z);
        this.c.setEnabled(this.a.getCheckedItemCount() > 0);
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        com.getpebble.android.common.b.a.f.d("SmsChoosePhoneNumberFragment", "onCreateLoader() id = " + i);
        if (i == 1) {
            return aq.b(getActivity());
        }
        String[] strArr = new String[]{ai.COLUMN_ID, "data1", "data2"};
        String[] strArr2 = new String[]{String.valueOf(this.d)};
        return new CursorLoader(getActivity(), Phone.CONTENT_URI, strArr, "contact_id = ?", strArr2, null);
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        com.getpebble.android.common.b.a.f.d("SmsChoosePhoneNumberFragment", "onLoadFinished(): id = " + loader.getId());
        if (loader.getId() == 1) {
            this.b.a(aq.b(cursor));
            getLoaderManager().destroyLoader(1);
        } else if (loader.getId() == 0) {
            this.b.changeCursor(b(cursor));
        }
    }

    private Cursor b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            TreeSet treeSet = new TreeSet(new w());
            Cursor matrixCursor = new MatrixCursor(cursor.getColumnNames());
            while (cursor.moveToNext()) {
                if (treeSet.add(cursor.getString(cursor.getColumnIndex("data1")))) {
                    matrixCursor.addRow(new Object[]{Long.valueOf(cursor.getLong(cursor.getColumnIndex(ai.COLUMN_ID))), cursor.getString(cursor.getColumnIndex("data1")), Integer.valueOf(cursor.getInt(cursor.getColumnIndex("data2")))});
                }
            }
            return matrixCursor;
        } finally {
            cursor.close();
        }
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        com.getpebble.android.common.b.a.f.d("SmsChoosePhoneNumberFragment", "onLoaderReset(): " + loader.getId());
        if (loader.getId() == 0) {
            this.b.swapCursor(null);
        }
    }

    private static Cursor c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        Cursor matrixCursor = new MatrixCursor(new String[]{"data1", "data2"}, cursor.getCount());
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            matrixCursor.addRow(new Object[]{cursor.getString(cursor.getColumnIndex("data1")), Integer.valueOf(cursor.getInt(cursor.getColumnIndex("data2")))});
        }
        return matrixCursor;
    }
}
