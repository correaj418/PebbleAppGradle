package net.hockeyapp.android.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import net.hockeyapp.android.c.f;
import net.hockeyapp.android.views.b;

public class a extends BaseAdapter {
    private Context a;
    private ArrayList<f> b;

    public a(Context context, ArrayList<f> arrayList) {
        this.a = context;
        this.b = arrayList;
    }

    public int getCount() {
        return this.b.size();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        f fVar = (f) this.b.get(i);
        if (view == null) {
            view = new b(this.a, null);
        } else {
            b bVar = (b) view;
        }
        if (fVar != null) {
            view.setFeedbackMessage(fVar);
        }
        view.setIndex(i);
        return view;
    }

    public Object getItem(int i) {
        return this.b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void a() {
        if (this.b != null) {
            this.b.clear();
        }
    }

    public void a(f fVar) {
        if (fVar != null && this.b != null) {
            this.b.add(fVar);
        }
    }
}
