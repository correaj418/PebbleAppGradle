package com.getpebble.android.main.sections.mypebble.a;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.h.w;
import java.util.Set;
import java.util.TreeSet;

public class i extends CursorAdapter {
    private a a;
    private TreeSet<String> b = new TreeSet(new w());

    public interface a {
        void a(int i, long j, boolean z);
    }

    private static class b {
        TextView a;
        TextView b;
        CheckBox c;
        long d = -1;

        public b(View view) {
            this.a = (TextView) view.findViewById(R.id.sms_phone_number);
            this.b = (TextView) view.findViewById(R.id.sms_phone_type);
            this.c = (CheckBox) view.findViewById(R.id.sms_phone_checkbox);
        }
    }

    public i(Context context, a aVar) {
        super(context, null, 0);
        this.a = aVar;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_contact_phone, viewGroup, false);
        inflate.setTag(new b(inflate));
        return inflate;
    }

    public void a(Set<String> set) {
        this.b.clear();
        this.b.addAll(set);
        notifyDataSetChanged();
    }

    public void bindView(View view, Context context, Cursor cursor) {
        boolean z = true;
        b bVar = (b) view.getTag();
        final int position = cursor.getPosition();
        final long itemId = getItemId(position);
        CharSequence string = cursor.getString(cursor.getColumnIndex("data1"));
        int typeLabelResource = Phone.getTypeLabelResource(cursor.getInt(cursor.getColumnIndex("data2")));
        boolean contains = this.b.contains(string);
        if (bVar.d != itemId || contains) {
            bVar.d = itemId;
            bVar.a.setText(string);
            bVar.b.setText(typeLabelResource);
            bVar.c.setOnCheckedChangeListener(null);
            bVar.c.setEnabled(!contains);
            bVar.c.setChecked(contains);
            bVar.c.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
                final /* synthetic */ i c;

                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.c.a.a(position, itemId, z);
                }
            });
            if (getCount() == 1) {
                a aVar = this.a;
                if (contains) {
                    z = false;
                }
                aVar.a(position, itemId, z);
                bVar.c.setVisibility(8);
                return;
            }
            bVar.c.setVisibility(0);
        }
    }
}
