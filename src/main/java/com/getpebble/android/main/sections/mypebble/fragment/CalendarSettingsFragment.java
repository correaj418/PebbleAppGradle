package com.getpebble.android.main.sections.mypebble.fragment;

import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.common.model.o;
import com.getpebble.android.main.sections.mypebble.a.a;
import com.getpebble.android.main.sections.mypebble.a.e;
import com.getpebble.android.main.sections.mypebble.a.e.b;
import com.getpebble.android.main.sections.mypebble.a.e.c;
import com.getpebble.android.widget.PebbleButton;
import java.util.List;
import java.util.UUID;

public class CalendarSettingsFragment extends a<e> implements c {
    private PebbleButton a;
    private LinearLayout b;
    private boolean c;

    protected /* synthetic */ a a(List list) {
        return b(list);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        f.d("CalendarSettingsFragment", "Initializing...");
        this.b = (LinearLayout) layoutInflater.inflate(R.layout.disable_enable_all_calendars_button, viewGroup, false);
        this.a = (PebbleButton) this.b.findViewById(R.id.calendar_settings_footer_button);
        this.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CalendarSettingsFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                boolean z = false;
                new b(this.a.c).execute(new Void[0]);
                CalendarSettingsFragment calendarSettingsFragment = this.a;
                if (!this.a.c) {
                    z = true;
                }
                calendarSettingsFragment.c = z;
                this.a.d();
            }
        });
        return onCreateView;
    }

    private void d() {
        this.a.setText(this.c ? R.string.calendar_enable_all : R.string.calendar_disable_all);
    }

    public void a(int i) {
        this.c = i == 0;
        d();
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        super.a(loader, cursor);
        this.c = ((e) a()).b() == 0;
        d();
    }

    protected UUID b() {
        return aw.b;
    }

    protected e b(List<o.a> list) {
        return new e(getActivity(), list, this);
    }

    protected void a(ListView listView) {
        listView.addFooterView(this.b);
        super.a(listView);
    }

    protected boolean a(o.a aVar) {
        return true;
    }
}
