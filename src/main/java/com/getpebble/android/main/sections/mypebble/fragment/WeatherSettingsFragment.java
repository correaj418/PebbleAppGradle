package com.getpebble.android.main.sections.mypebble.fragment;

import android.app.ActionBar;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.model.am;
import com.getpebble.android.common.model.aw;
import com.getpebble.android.common.model.bb;
import com.getpebble.android.common.model.bc;
import com.getpebble.android.common.model.bd;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel.Record;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel.Record.Builder;
import com.getpebble.android.common.model.timeline.weatherchannel.WeatherLocationsModel.UuidJsonObject;
import com.getpebble.android.framework.location.PebbleLocationService;
import com.getpebble.android.h.x;
import com.getpebble.android.main.sections.mypebble.activity.WeatherMoreLocationsActivity;
import com.getpebble.android.widget.PebbleButton;
import com.getpebble.android.widget.PebbleTextView;
import com.google.a.b.ad;
import com.google.b.f;
import com.google.b.o;
import com.google.b.q;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WeatherSettingsFragment extends com.getpebble.android.common.framework.a.b implements LoaderCallbacks<Cursor> {
    private final int a = 0;
    private final int b = 1;
    private final int c = 0;
    private final int d = 32;
    private final String e = "…";
    private LinearLayout f;
    private ScrollView g;
    private int h = 0;
    private LayoutInflater i;
    private ViewGroup j;
    private final int k = 6;
    private final int l = 10;
    private final int m = 2;
    private RadioButton n;
    private RadioButton o;
    private RadioButton p;
    private PebbleButton q;
    private PebbleButton r;
    private List<Record> s = new ArrayList();

    private static class a extends AsyncTask<ContentResolver, Void, Void> {
        private a() {
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((ContentResolver[]) objArr);
        }

        protected Void a(ContentResolver... contentResolverArr) {
            if (contentResolverArr.length != 0) {
                ContentResolver contentResolver = contentResolverArr[0];
                UuidJsonObject uuidJsonObject = (UuidJsonObject) new f().a((o) new q().a(WeatherLocationsModel.getTimelineJsonUuids()), UuidJsonObject.class);
                if (uuidJsonObject.today_day != null) {
                    aw.c(contentResolver, UUID.fromString(uuidJsonObject.today_day));
                }
                if (uuidJsonObject.today_night != null) {
                    aw.c(contentResolver, UUID.fromString(uuidJsonObject.today_night));
                }
                if (uuidJsonObject.tomorrow_day != null) {
                    aw.c(contentResolver, UUID.fromString(uuidJsonObject.tomorrow_day));
                }
                if (uuidJsonObject.tomorrow_night != null) {
                    aw.c(contentResolver, UUID.fromString(uuidJsonObject.tomorrow_night));
                }
                if (uuidJsonObject.day_after_tomorrow_day != null) {
                    aw.c(contentResolver, UUID.fromString(uuidJsonObject.day_after_tomorrow_day));
                }
                if (uuidJsonObject.day_after_tomorrow_night != null) {
                    aw.c(contentResolver, UUID.fromString(uuidJsonObject.day_after_tomorrow_night));
                }
            }
            return null;
        }
    }

    private class b extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ WeatherSettingsFragment a;

        private b(WeatherSettingsFragment weatherSettingsFragment) {
            this.a = weatherSettingsFragment;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a(objArr);
        }

        protected Void a(Object... objArr) {
            if (objArr.length < 2) {
                return null;
            }
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            String str = (String) objArr[1];
            Cursor query = WeatherLocationsModel.query(this.a.getActivity().getContentResolver(), x.b(ad.a(WeatherLocationsModel.LOCATION_UUID)), new String[]{str}, null);
            if (query.moveToNext()) {
                try {
                    Record from = Record.from(query);
                    if (from.isTimelineSource == booleanValue) {
                        return null;
                    }
                    Builder from2 = Builder.from(from);
                    from2.setIsTimelineSource(booleanValue);
                    from2.setUpdatedTimestamp(0);
                    WeatherLocationsModel.update(this.a.getActivity().getContentResolver(), from2);
                    if (booleanValue) {
                        com.getpebble.android.common.b.a.a.c.a(new Record(0, from.latitude, from.longitude, from.locationName, from.isDynamic, true, from.locationUuid, from.addedByUser), -1, false, true);
                    }
                    PebbleApplication.v().f();
                    return null;
                } finally {
                    query.close();
                }
            } else {
                com.getpebble.android.common.b.a.f.b("WeatherSettingsFragment", "UpdateIsTimelineSourceTask cursor is empty");
                query.close();
                return null;
            }
        }
    }

    private class c extends AsyncTask<com.getpebble.android.common.model.timeline.weatherchannel.a.a, Void, Void> {
        final /* synthetic */ WeatherSettingsFragment a;

        private c(WeatherSettingsFragment weatherSettingsFragment) {
            this.a = weatherSettingsFragment;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((com.getpebble.android.common.model.timeline.weatherchannel.a.a[]) objArr);
        }

        protected Void a(com.getpebble.android.common.model.timeline.weatherchannel.a.a... aVarArr) {
            com.getpebble.android.common.model.timeline.weatherchannel.a.a aVar = aVarArr[0];
            com.getpebble.android.common.model.timeline.weatherchannel.a.a aVar2 = aVarArr[1];
            ContentResolver contentResolver = this.a.getActivity().getContentResolver();
            bc.a(contentResolver, aVar, aVar2);
            bd.a(contentResolver, aVar, aVar2);
            WeatherLocationsModel.updateWeatherTimelineItems(com.getpebble.android.common.a.K().getContentResolver());
            return null;
        }
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        a(loader, (Cursor) obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.i = layoutInflater;
        this.j = viewGroup;
        am.a(getActivity().getContentResolver(), aw.c, true);
        a(getResources().getColor(R.color.orange_statusbar_color));
        b(getResources().getColor(R.color.orange_actionbar_color));
        this.g = (ScrollView) layoutInflater.inflate(R.layout.fragment_weather_settings, viewGroup, false);
        this.f = (LinearLayout) this.g.findViewById(R.id.weather_settings);
        this.q = (PebbleButton) this.f.findViewById(R.id.weather_location_disabled_button);
        if (!PebbleLocationService.a(com.getpebble.android.framework.location.PebbleLocationService.a.LOCATION_ENABLED)) {
            this.q.setText(R.string.weather_location_disabled_warning);
            this.q.setTag(Integer.valueOf(1));
            am.a(getActivity().getContentResolver(), aw.c, false);
            this.q.setVisibility(0);
        }
        this.q.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WeatherSettingsFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (((Integer) view.getTag()).intValue() == 1) {
                    this.a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1);
                    return;
                }
                this.a.startActivityForResult(new Intent(this.a.getActivity(), WeatherMoreLocationsActivity.class), 0);
            }
        });
        am.a(getActivity().getContentResolver(), aw.c, true);
        this.r = (PebbleButton) this.f.findViewById(R.id.add_more_locations);
        this.r.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WeatherSettingsFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.startActivityForResult(new Intent(this.a.getActivity(), WeatherMoreLocationsActivity.class), 0);
            }
        });
        getLoaderManager().initLoader(0, null, this);
        a(PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.WEATHER_UNITS, com.getpebble.android.h.q.c().unitsTypeName));
        RadioGroup radioGroup = (RadioGroup) this.f.findViewById(R.id.units_group);
        this.n = (RadioButton) radioGroup.findViewById(R.id.units_celsius);
        this.n.setText(R.string.weather_units_celsius);
        this.o = (RadioButton) radioGroup.findViewById(R.id.units_fahrenheit);
        this.o.setText(R.string.weather_units_fahrenheit);
        this.p = (RadioButton) radioGroup.findViewById(R.id.units_mixed);
        this.p.setText(R.string.weather_units_mixed);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ WeatherSettingsFragment a;

            {
                this.a = r1;
            }

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                com.getpebble.android.common.model.timeline.weatherchannel.a.a aVar;
                com.getpebble.android.common.model.timeline.weatherchannel.a.a from = com.getpebble.android.common.model.timeline.weatherchannel.a.a.from(PebbleApplication.y().a(com.getpebble.android.common.b.b.c.a.WEATHER_UNITS, com.getpebble.android.h.q.c().unitsTypeName));
                switch (i) {
                    case R.id.units_celsius:
                        aVar = com.getpebble.android.common.model.timeline.weatherchannel.a.a.METRIC;
                        this.a.a(com.getpebble.android.common.model.timeline.weatherchannel.a.a.METRIC.unitsTypeName, true, false, false);
                        break;
                    case R.id.units_fahrenheit:
                        aVar = com.getpebble.android.common.model.timeline.weatherchannel.a.a.IMPERIAL;
                        this.a.a(com.getpebble.android.common.model.timeline.weatherchannel.a.a.IMPERIAL.unitsTypeName, false, true, false);
                        break;
                    case R.id.units_mixed:
                        aVar = com.getpebble.android.common.model.timeline.weatherchannel.a.a.HYBRID;
                        this.a.a(com.getpebble.android.common.model.timeline.weatherchannel.a.a.HYBRID.unitsTypeName, false, false, true);
                        break;
                    default:
                        aVar = null;
                        break;
                }
                new c().execute(new com.getpebble.android.common.model.timeline.weatherchannel.a.a[]{from, aVar});
            }
        });
        return this.g;
    }

    private void a(String str, boolean z, boolean z2, boolean z3) {
        int i = R.drawable.btn_radio_checked_custom;
        PebbleApplication.y().b(com.getpebble.android.common.b.b.c.a.WEATHER_UNITS, str);
        this.n.setCompoundDrawablesWithIntrinsicBounds(0, 0, z ? R.drawable.btn_radio_checked_custom : R.drawable.btn_radio_unchecked_custom, 0);
        this.o.setCompoundDrawablesWithIntrinsicBounds(0, 0, z2 ? R.drawable.btn_radio_checked_custom : R.drawable.btn_radio_unchecked_custom, 0);
        RadioButton radioButton = this.p;
        if (!z3) {
            i = R.drawable.btn_radio_unchecked_custom;
        }
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
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
        ActionBar actionBar = getActivity().getActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(i));
        }
    }

    public int c() {
        return 0;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.getpebble.android.common.b.a.f.d("WeatherSettingsFragment", "Initializing WeatherSettingsFragment");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        boolean z2;
        PebbleTextView pebbleTextView = (PebbleTextView) this.f.findViewById(R.id.other_locations);
        boolean z3 = pebbleTextView.getVisibility() == 8;
        if (i != 0 || i2 != -1) {
            z = z3;
        } else if (intent == null) {
            com.getpebble.android.common.b.a.f.b("WeatherSettingsFragment", "onActivityResult data was null");
            return;
        } else {
            int i3;
            Record fromContentValues = WeatherLocationsModel.fromContentValues((ContentValues) intent.getParcelableExtra(getString(R.string.weather_content_values_extra_key)));
            if (z3) {
                pebbleTextView.setVisibility(0);
                this.f.findViewById(R.id.line_under_other_locations).setVisibility(0);
                a(this.i, this.j, fromContentValues, true);
            } else {
                a(this.i, this.j, fromContentValues, false);
            }
            this.s.add(fromContentValues);
            if (z3) {
                i3 = 1;
            } else {
                i3 = (this.h / 2) + 1;
            }
            com.getpebble.android.common.b.a.a.c.a(fromContentValues, i3, true, false);
            z = false;
        }
        if (PebbleLocationService.a(com.getpebble.android.framework.location.PebbleLocationService.a.LOCATION_ENABLED)) {
            PebbleLocationService.b();
            if (i2 == 1) {
                com.getpebble.android.common.b.a.a.c.b(true);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (z) {
            this.q.setVisibility(0);
            am.a(getActivity().getContentResolver(), aw.c, false);
            this.q.setText(getResources().getString(R.string.weather_no_locations_selected));
            this.q.setTag(Integer.valueOf(-1));
        } else if (z2) {
            this.q.setVisibility(0);
            am.a(getActivity().getContentResolver(), aw.c, false);
            this.q.setText(getResources().getString(R.string.weather_location_disabled_warning));
            this.q.setTag(Integer.valueOf(1));
        } else {
            this.q.setVisibility(8);
            am.a(getActivity().getContentResolver(), aw.c, true);
        }
        a();
    }

    private void a(LayoutInflater layoutInflater, ViewGroup viewGroup, final Record record, boolean z) {
        if (!record.isDynamic || record.addedByUser) {
            String string;
            Object obj;
            final ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.weather_location_list_item, viewGroup, false);
            viewGroup2.setTag(record.locationUuid.toString());
            ((PebbleButton) viewGroup2.findViewById(R.id.delete_weather_location)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WeatherSettingsFragment c;

                public void onClick(View view) {
                    this.c.s.remove(record);
                    bd.a(this.c.getActivity().getContentResolver(), record.locationUuid);
                    bc.a(this.c.getActivity().getContentResolver(), record.locationUuid);
                    int indexOfChild = this.c.f.indexOfChild(viewGroup2);
                    boolean z = indexOfChild == 6 && this.c.h == 0;
                    if (z) {
                        ((PebbleTextView) this.c.f.findViewById(R.id.other_locations)).setVisibility(8);
                        this.c.f.findViewById(R.id.line_under_other_locations).setVisibility(8);
                        this.c.q.setTag(Integer.valueOf(-1));
                        this.c.q.setText(this.c.getResources().getString(R.string.weather_no_locations_selected));
                        am.a(this.c.getActivity().getContentResolver(), aw.c, false);
                        this.c.q.setVisibility(0);
                        new a().execute(new ContentResolver[]{this.c.getActivity().getContentResolver()});
                    }
                    this.c.f.removeViewAt(indexOfChild + 1);
                    this.c.f.removeViewAt(indexOfChild);
                    if (indexOfChild != 6) {
                        this.c.h = this.c.h - 2;
                    } else if (this.c.h != 0) {
                        new a().execute(new ContentResolver[]{this.c.getActivity().getContentResolver()});
                        ViewGroup viewGroup = (ViewGroup) this.c.f.getChildAt(8);
                        View childAt = this.c.f.getChildAt(9);
                        this.c.f.removeView(viewGroup);
                        this.c.f.removeView(childAt);
                        this.c.f.addView(viewGroup, 6);
                        this.c.f.addView(childAt, 7);
                        this.c.h = this.c.h - 2;
                        String str = (String) viewGroup.getTag();
                        new b().execute(new Object[]{Boolean.valueOf(true), str});
                    }
                    if (record.isDynamic) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(WeatherLocationsModel.ADDED_BY_USER, Boolean.valueOf(false));
                        contentValues.put(WeatherLocationsModel.IS_TIMELINE_SOURCE, Boolean.valueOf(false));
                        WeatherLocationsModel.updateDynamicLocation(this.c.getActivity().getContentResolver(), contentValues);
                    } else {
                        WeatherLocationsModel.delete(this.c.getActivity().getContentResolver(), record.locationUuid);
                        PebbleApplication.v().f();
                    }
                    this.c.a();
                    com.getpebble.android.common.b.a.a.c.a(record, z ? 0 : (this.c.h / 2) + 1, false, false);
                }
            });
            String str = record.locationName;
            final UUID uuid = record.locationUuid;
            if (record.locationName.equals(WeatherLocationsModel.USER_LOCATION)) {
                string = getResources().getString(R.string.weather_current_location);
                ((PebbleTextView) viewGroup2.findViewById(R.id.location_name)).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.location_icon, 0);
                str = string;
            }
            if (str.length() >= 32) {
                obj = str.substring(0, 32) + "…";
            } else {
                string = str;
            }
            ((PebbleTextView) viewGroup2.findViewById(R.id.location_name)).setText(obj);
            viewGroup2.setOnDragListener(new OnDragListener(this) {
                final /* synthetic */ WeatherSettingsFragment b;

                public boolean onDrag(View view, DragEvent dragEvent) {
                    switch (dragEvent.getAction()) {
                        case 2:
                            int top = view.getTop();
                            int bottom = view.getBottom();
                            int scrollY = this.b.g.getScrollY();
                            if (bottom > (this.b.g.getHeight() + scrollY) - 350) {
                                this.b.g.smoothScrollBy(0, 30);
                            }
                            if (top < scrollY + 350) {
                                this.b.g.smoothScrollBy(0, -30);
                                break;
                            }
                            break;
                        case 3:
                            ViewGroup viewGroup = (ViewGroup) dragEvent.getLocalState();
                            String charSequence = dragEvent.getClipData().getItemAt(1).getText().toString();
                            ViewGroup viewGroup2 = (ViewGroup) view;
                            String uuid = uuid.toString();
                            int indexOfChild = this.b.f.indexOfChild(viewGroup);
                            int indexOfChild2 = this.b.f.indexOfChild(viewGroup2);
                            if (indexOfChild != indexOfChild2) {
                                this.b.f.removeView(viewGroup2);
                                this.b.f.removeView(viewGroup);
                                if (indexOfChild == 6) {
                                    new b().execute(new Object[]{Boolean.valueOf(true), uuid});
                                    new b().execute(new Object[]{Boolean.valueOf(false), charSequence});
                                    new a().execute(new ContentResolver[]{this.b.getActivity().getContentResolver()});
                                } else if (indexOfChild2 == 6) {
                                    new b().execute(new Object[]{Boolean.valueOf(false), uuid});
                                    new b().execute(new Object[]{Boolean.valueOf(true), charSequence});
                                    new a().execute(new ContentResolver[]{this.b.getActivity().getContentResolver()});
                                }
                                PebbleApplication.v().f();
                                if (indexOfChild <= indexOfChild2) {
                                    if (indexOfChild < indexOfChild2) {
                                        this.b.f.addView(viewGroup2, indexOfChild);
                                        this.b.f.addView(viewGroup, indexOfChild2);
                                        break;
                                    }
                                }
                                this.b.f.addView(viewGroup, indexOfChild2);
                                this.b.f.addView(viewGroup2, indexOfChild);
                                break;
                            }
                            break;
                    }
                    return true;
                }
            });
            viewGroup2.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ WeatherSettingsFragment c;

                public boolean onLongClick(View view) {
                    ClipDescription clipDescription = new ClipDescription(obj, new String[]{"text/plain"});
                    Item item = new Item(obj);
                    Item item2 = new Item(uuid.toString());
                    ClipData clipData = new ClipData(clipDescription, item);
                    clipData.addItem(item2);
                    view.startDrag(clipData, new DragShadowBuilder(view), view, 0);
                    return true;
                }
            });
            if (z) {
                this.f.addView(viewGroup2, 6);
                this.f.addView(b(), 7);
                new b().execute(new Object[]{Boolean.valueOf(true), uuid.toString()});
                return;
            }
            this.f.addView(viewGroup2, this.h + 10);
            this.f.addView(b(), this.h + 11);
            this.h += 2;
        }
    }

    private View b() {
        View view = new View(getActivity());
        view.setLayoutParams(new LayoutParams(-1, a(1, getResources().getDisplayMetrics().densityDpi)));
        view.setBackgroundColor(getResources().getColor(R.color.holo_gray));
        return view;
    }

    private int a(int i, int i2) {
        return (i2 / 160) * i;
    }

    public void a(String str) {
        RadioGroup radioGroup = (RadioGroup) this.f.findViewById(R.id.units_group);
        if (radioGroup == null) {
            com.getpebble.android.common.b.a.f.d("WeatherSettingsFragment", "RadioGroup is null");
            return;
        }
        RadioButton radioButton;
        switch (com.getpebble.android.common.model.timeline.weatherchannel.a.a.from(str)) {
            case METRIC:
                radioButton = (RadioButton) radioGroup.findViewById(R.id.units_celsius);
                radioButton.setChecked(true);
                radioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.btn_radio_checked_custom, 0);
                return;
            case IMPERIAL:
                radioButton = (RadioButton) radioGroup.findViewById(R.id.units_fahrenheit);
                radioButton.setChecked(true);
                radioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.btn_radio_checked_custom, 0);
                return;
            case HYBRID:
                radioButton = (RadioButton) radioGroup.findViewById(R.id.units_mixed);
                radioButton.setChecked(true);
                radioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.btn_radio_checked_custom, 0);
                return;
            default:
                return;
        }
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        switch (i) {
            case 0:
                String[] strArr = new String[]{"-1"};
                return new CursorLoader(getActivity(), WeatherLocationsModel.TABLE_URI, WeatherLocationsModel.ALL_COLUMNS, "_id != ?", strArr, null);
            default:
                return null;
        }
    }

    public void a(Loader<Cursor> loader, Cursor cursor) {
        List<Record> arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            Record from = Record.from(cursor);
            if (!from.isDynamic || from.addedByUser) {
                arrayList.add(from);
                this.s.add(from);
            }
        }
        cursor.close();
        if (arrayList.size() == 0) {
            ((PebbleTextView) this.f.findViewById(R.id.other_locations)).setVisibility(8);
            this.f.findViewById(R.id.line_under_other_locations).setVisibility(8);
            this.q.setTag(Integer.valueOf(-1));
            this.q.setText(getResources().getString(R.string.weather_no_locations_selected));
            am.a(getActivity().getContentResolver(), aw.c, false);
            this.q.setVisibility(0);
            return;
        }
        Record record = null;
        Record record2 = null;
        for (Record from2 : arrayList) {
            if (from2.isTimelineSource) {
                Record record3 = record;
                record = from2;
                from2 = record3;
            } else if (from2.isDynamic) {
                record = record2;
            } else {
                from2 = record;
                record = record2;
            }
            record2 = record;
            record = from2;
        }
        if (!(PebbleLocationService.a(com.getpebble.android.framework.location.PebbleLocationService.a.LOCATION_ENABLED) || record == null)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(WeatherLocationsModel.ADDED_BY_USER, Boolean.valueOf(false));
            contentValues.put(WeatherLocationsModel.IS_TIMELINE_SOURCE, Boolean.valueOf(false));
            WeatherLocationsModel.updateDynamicLocation(getActivity().getContentResolver(), contentValues);
            arrayList.remove(record);
            record = null;
        }
        if (record2 != null) {
            a(this.i, this.j, record2, true);
            arrayList.remove(record2);
        } else if (record != null) {
            a(this.i, this.j, record, true);
            arrayList.remove(record);
        } else {
            a(this.i, this.j, (Record) arrayList.get(0), true);
            arrayList.remove(0);
        }
        for (Record from22 : arrayList) {
            a(this.i, this.j, from22, false);
        }
        a();
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }

    public void a() {
        if ((this.h + 2) / 2 >= 6) {
            this.r.setTextColor(getResources().getColor(R.color.gray));
            this.r.setClickable(false);
            return;
        }
        this.r.setTextColor(getResources().getColor(R.color.orange_actionbar_color));
        this.r.setClickable(true);
    }

    private void d() {
        List arrayList = new ArrayList();
        for (Record record : this.s) {
            Log.d("WeatherSettingsFragment", "Adding record: " + record + " (uuid:" + record.locationUuid + ")");
            if (record.locationUuid != null) {
                arrayList.add(record.locationUuid);
            }
        }
        bb.a(arrayList);
    }

    public void onStop() {
        d();
        super.onStop();
    }
}
