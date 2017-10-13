package com.getpebble.android.main.sections.mypebble.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.getpebble.android.basalt.R;
import com.getpebble.android.main.sections.mypebble.fragment.WeatherMoreLocationsFragment;
import com.getpebble.android.main.sections.support.activity.a;

public class WeatherMoreLocationsActivity extends a implements OnDismissListener {
    public int a() {
        return R.layout.activity_more_locations;
    }

    public int e() {
        return R.string.weather;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        ((WeatherMoreLocationsFragment) getFragmentManager().findFragmentById(R.id.fragment_more_locations)).a();
    }
}
