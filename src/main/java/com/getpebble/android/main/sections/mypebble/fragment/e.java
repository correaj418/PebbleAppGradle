package com.getpebble.android.main.sections.mypebble.fragment;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.framework.location.PebbleLocationService;
import com.getpebble.android.framework.location.PebbleLocationService.a;
import com.getpebble.android.main.sections.mypebble.activity.WeatherMoreLocationsActivity;
import com.getpebble.android.widget.PebbleButton;
import com.getpebble.android.widget.PebbleTextView;

public class e extends DialogFragment {
    private final int a = 0;
    private View b;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.location_permissions_dialog, viewGroup, false);
        PebbleButton pebbleButton = (PebbleButton) this.b.findViewById(R.id.permissions_buttons_layout).findViewById(R.id.fix_now_button);
        if (PebbleLocationService.a(a.SENSORS_ONLY)) {
            a();
        }
        pebbleButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 0);
            }
        });
        ((PebbleButton) this.b.findViewById(R.id.permissions_buttons_layout).findViewById(R.id.dismiss_button)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.getDialog().dismiss();
            }
        });
        return this.b;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (PebbleLocationService.a(a.LOCATION_ENABLED)) {
            PebbleLocationService.b();
            getDialog().dismiss();
            c.b(true);
        } else if (PebbleLocationService.a(a.SENSORS_ONLY)) {
            a();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        WeatherMoreLocationsActivity weatherMoreLocationsActivity = (WeatherMoreLocationsActivity) getActivity();
        if (weatherMoreLocationsActivity != null) {
            weatherMoreLocationsActivity.onDismiss(dialogInterface);
        }
    }

    private void a() {
        ((PebbleTextView) this.b.findViewById(R.id.grant_permissions_explanation)).setText(R.string.weather_location_device_only_mode);
    }
}
