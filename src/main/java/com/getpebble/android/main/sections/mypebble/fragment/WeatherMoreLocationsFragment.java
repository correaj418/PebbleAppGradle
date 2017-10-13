package com.getpebble.android.main.sections.mypebble.fragment;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel.Record;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel.Record.Builder;
import com.getpebble.android.framework.location.PebbleLocationService;
import com.getpebble.android.h.x;
import com.getpebble.android.main.sections.mypebble.a.g;
import com.google.a.b.ad;
import java.util.ArrayList;
import java.util.List;

public class WeatherMoreLocationsFragment extends b {
    private final int a = 1;
    private Location b;
    private g c;
    private a d;
    private ListView e;
    private ActionBar f;
    private ImageView g;
    private SQLiteDatabase h;

    public class a extends AsyncTask<String, Void, List<com.getpebble.android.main.sections.mypebble.e.a>> {
        final /* synthetic */ WeatherMoreLocationsFragment a;

        public a(WeatherMoreLocationsFragment weatherMoreLocationsFragment) {
            this.a = weatherMoreLocationsFragment;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            a((List) obj);
        }

        protected List<com.getpebble.android.main.sections.mypebble.e.a> a(String... strArr) {
            if (isCancelled()) {
                return null;
            }
            String str = strArr[0];
            if (str.equals("")) {
                return new ArrayList();
            }
            str = com.getpebble.android.main.sections.mypebble.b.a.a(str, this.a.b);
            if (this.a.h == null) {
                f.d("WeatherMoreLocationsFragment", "Geo database is null.");
                return null;
            }
            Cursor rawQuery = this.a.h.rawQuery(str, new String[0]);
            List<com.getpebble.android.main.sections.mypebble.e.a> arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                try {
                    com.getpebble.android.main.sections.mypebble.e.a aVar = new com.getpebble.android.main.sections.mypebble.e.a(rawQuery);
                    if (TextUtils.isEmpty(aVar.toString())) {
                        f.a("WeatherMoreLocationsFragment", "Empty geomodel display name: " + aVar.a());
                    } else {
                        arrayList.add(aVar);
                    }
                } finally {
                    rawQuery.close();
                }
            }
            if (rawQuery.getCount() == 0) {
                f.d("WeatherMoreLocationsFragment", "onTextChanged() cursor is empty");
                return null;
            }
            rawQuery.close();
            return arrayList;
        }

        protected void a(List<com.getpebble.android.main.sections.mypebble.e.a> list) {
            if (list != null) {
                this.a.c.a((ArrayList) list);
                this.a.e();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = PebbleApplication.A();
        this.b = WeatherLocationsModel.getCurrentLocation(getActivity().getContentResolver());
        this.d = new a(this);
        this.f = getActivity().getActionBar();
        a(getResources().getColor(R.color.orange_statusbar_color));
        b(getResources().getColor(R.color.orange_actionbar_color));
        View inflate = layoutInflater.inflate(R.layout.fragment_more_locations, viewGroup, false);
        a(layoutInflater, viewGroup);
        this.e = (ListView) inflate.findViewById(R.id.add_more_locations_list);
        View inflate2 = layoutInflater.inflate(R.layout.current_location_header, viewGroup, false);
        this.e.addHeaderView(inflate2);
        this.g = (ImageView) inflate2.findViewById(R.id.location_disabled_warning_icon);
        if (!PebbleLocationService.a(com.getpebble.android.framework.location.PebbleLocationService.a.LOCATION_ENABLED)) {
            this.g.setVisibility(0);
            this.g.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WeatherMoreLocationsFragment a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    this.a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1);
                }
            });
        }
        this.e.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WeatherMoreLocationsFragment a;

            {
                this.a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if ((i == 0 ? 1 : null) == null) {
                    com.getpebble.android.main.sections.mypebble.e.a aVar = (com.getpebble.android.main.sections.mypebble.e.a) adapterView.getItemAtPosition(i);
                    Cursor query = WeatherLocationsModel.query(this.a.getActivity().getContentResolver(), x.b(ad.a(WeatherLocationsModel.LOCATION_NAME)), new String[]{aVar.toString()}, null);
                    try {
                        Builder a;
                        if (query.getCount() == 0) {
                            a = this.a.a(aVar.b, aVar.c, false, false, aVar.toString(), false);
                            a.setUpdatedTimestamp(0);
                            WeatherLocationsModel.insert(this.a.getActivity().getContentResolver(), a);
                            PebbleApplication.v().f();
                        } else {
                            a = null;
                        }
                        query.close();
                        this.a.a(a);
                    } catch (Throwable th) {
                        query.close();
                    }
                } else if (!PebbleLocationService.a(com.getpebble.android.framework.location.PebbleLocationService.a.LOCATION_ENABLED)) {
                    FragmentTransaction beginTransaction = this.a.getFragmentManager().beginTransaction();
                    Fragment findFragmentByTag = this.a.getFragmentManager().findFragmentByTag("Permissions Dialog Tag");
                    if (findFragmentByTag != null) {
                        beginTransaction.remove(findFragmentByTag);
                    }
                    beginTransaction.addToBackStack(null);
                    e eVar = new e();
                    eVar.setStyle(1, 0);
                    eVar.show(beginTransaction, "Permissions Dialog Tag");
                } else if (this.a.b == null) {
                    PebbleLocationService.b();
                    this.a.d();
                } else {
                    this.a.d();
                }
            }
        });
        this.c = new g(getActivity(), R.layout.locations_list_item, R.id.location_text, new ArrayList(), this);
        this.e.setAdapter(this.c);
        EditText editText = (EditText) this.f.getCustomView().findViewById(R.id.autocomplete_edittext);
        editText.requestFocus();
        editText.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ WeatherMoreLocationsFragment a;

            {
                this.a = r1;
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (this.a.d == null) {
                    this.a.d = new a(this.a);
                } else if (!this.a.d.isCancelled()) {
                    this.a.d.cancel(true);
                    this.a.d = new a(this.a);
                }
                this.a.d.execute(new String[]{charSequence.toString().trim()});
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        return inflate;
    }

    private void d() {
        new com.getpebble.android.bluetooth.b.f(this) {
            final /* synthetic */ WeatherMoreLocationsFragment a;

            {
                this.a = r1;
            }

            public boolean doInBackground() {
                Builder builder;
                boolean z = WeatherLocationsModel.getDynamicLocationRecord(this.a.getActivity().getContentResolver()).addedByUser;
                WeatherLocationsModel.updateDynamicAddedByUser(this.a.getActivity().getContentResolver(), true);
                PebbleLocationService.b();
                if (z) {
                    builder = null;
                } else {
                    builder = Builder.from(WeatherLocationsModel.getDynamicLocationRecord(this.a.getActivity().getContentResolver()));
                }
                this.a.getActivity().runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 b;

                    public void run() {
                        this.b.a.a(builder);
                    }
                });
                return false;
            }

            public void onTaskSuccess() {
            }

            public void onTaskFailed() {
            }
        }.submit();
    }

    private void a(Builder builder) {
        Intent intent = new Intent();
        if (builder != null) {
            if (builder.isDynamic && !builder.addedByUser) {
                builder.setAddedByUser(true);
            }
            intent.putExtra(getString(R.string.weather_content_values_extra_key), new Record(builder.updateTimestampMs, builder.latitude, builder.longitude, builder.locationName, builder.isDynamic, builder.isTimelineSource, builder.locationUuid, builder.addedByUser).toContentValues());
            getActivity().setResult(-1, intent);
        } else {
            getActivity().setResult(0);
        }
        getActivity().finish();
    }

    private void a(int i) {
        if (VERSION.SDK_INT >= 21) {
            Window window = getActivity().getWindow();
            if (window != null) {
                window.setStatusBarColor(i);
            }
        }
    }

    private void b(int i) {
        if (this.f != null) {
            this.f.setBackgroundDrawable(new ColorDrawable(i));
        }
    }

    private void a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.f == null) {
            f.d("WeatherMoreLocationsFragment", "Action Bar is null");
            return;
        }
        this.f.setDisplayHomeAsUpEnabled(true);
        this.f.setDisplayShowCustomEnabled(true);
        this.f.setDisplayShowTitleEnabled(false);
        this.f.setCustomView(layoutInflater.inflate(R.layout.weather_settings_action_bar, viewGroup));
    }

    public int c() {
        return 0;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.d("WeatherMoreLocationsFragment", "Initializing WeatherSettingsFragment");
    }

    private Builder a(double d, double d2, boolean z, boolean z2, String str, boolean z3) {
        return new Builder().setIsTimelineSource(z).setIsDynamic(z2).setLatitude(d).setLongitude(d2).setLocationName(str).setUpdatedTimestamp(System.currentTimeMillis()).setAddedByUser(z3);
    }

    public void a() {
        if (PebbleLocationService.a(com.getpebble.android.framework.location.PebbleLocationService.a.LOCATION_ENABLED)) {
            this.g.setVisibility(4);
            PebbleLocationService.b();
        }
    }

    private void e() {
        this.d = null;
    }

    public void b() {
        this.e.post(new Runnable(this) {
            final /* synthetic */ WeatherMoreLocationsFragment a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.c.notifyDataSetChanged();
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (PebbleLocationService.a(com.getpebble.android.framework.location.PebbleLocationService.a.LOCATION_ENABLED)) {
            this.g.setVisibility(4);
            c.b(true);
            return;
        }
        this.g.setVisibility(0);
    }
}
