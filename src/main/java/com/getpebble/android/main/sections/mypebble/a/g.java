package com.getpebble.android.main.sections.mypebble.a;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.getpebble.android.main.sections.mypebble.e.a;
import com.getpebble.android.main.sections.mypebble.fragment.WeatherMoreLocationsFragment;
import java.util.ArrayList;

public class g extends ArrayAdapter<a> {
    private ArrayList<a> a;
    private WeatherMoreLocationsFragment b;

    public g(Context context, int i, int i2, ArrayList<a> arrayList, WeatherMoreLocationsFragment weatherMoreLocationsFragment) {
        super(context, i, i2, arrayList);
        this.a = arrayList;
        this.b = weatherMoreLocationsFragment;
    }

    public void a(ArrayList<a> arrayList) {
        this.a.clear();
        this.a.addAll(arrayList);
        this.b.b();
    }
}
