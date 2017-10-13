package com.getpebble.android.onboarding.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.am.c;
import com.getpebble.android.onboarding.b.b;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class a extends ArrayAdapter<c> {
    private final Context a;
    private final a b;
    private List<UUID> c = new ArrayList();

    public enum a {
        GRAB_APPS,
        GRAB_TIMELINE_APPS
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public a(Context context, List<c> list, a aVar, List<UUID> list2) {
        super(context, R.layout.app_card_layout, list);
        this.a = context;
        this.b = aVar;
        this.c = list2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        c a = a(i);
        if (a == null) {
            return null;
        }
        view = (com.getpebble.android.onboarding.b.a) view;
        switch (this.b) {
            case GRAB_APPS:
                if (view == null) {
                    view = new b(this.a, this);
                    break;
                }
                break;
            case GRAB_TIMELINE_APPS:
                if (view == null) {
                    view = new com.getpebble.android.onboarding.b.c(this.a, this);
                    break;
                }
                break;
            default:
                f.a("AppCardAdapter", "Unhandled card type!");
                return null;
        }
        view.a(a, this.c.contains(a.b));
        return view;
    }

    public void a(UUID uuid) {
        if (!this.c.contains(uuid)) {
            this.c.add(uuid);
        }
    }

    public void a(List<UUID> list) {
        this.c = list;
    }

    public c a(int i) {
        return (c) super.getItem(i);
    }
}
