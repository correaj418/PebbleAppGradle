package com.getpebble.android.main.sections.fontpack;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.bluetooth.b.f;
import com.getpebble.android.common.b.a.a.c;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.common.model.x;
import com.google.b.o;
import java.util.concurrent.TimeUnit;

public class AdditionalFontPackFragment extends b implements com.getpebble.android.common.framework.a.a {
    private ProgressBar a;
    private RecyclerView b;
    private com.getpebble.android.main.sections.fontpack.a.a c;

    private class a extends f {
        final /* synthetic */ AdditionalFontPackFragment a;
        private x b;

        private a(AdditionalFontPackFragment additionalFontPackFragment) {
            this.a = additionalFontPackFragment;
        }

        public boolean doInBackground() {
            a();
            return true;
        }

        public void onTaskSuccess() {
            this.a.a.setVisibility(8);
            if (this.b != null) {
                this.a.c.a(this.b.a);
            }
        }

        public void onTaskFailed() {
        }

        private void a() {
            String str = null;
            com.getpebble.android.common.b.a.f.d(f.TAG, "syncFontPack()");
            try {
                String str2;
                com.getpebble.android.common.model.ak.a p = PebbleApplication.p();
                Context K = com.getpebble.android.common.a.K();
                if (p == null) {
                    str2 = null;
                } else {
                    str2 = p.hwPlatform.getName();
                }
                if (p != null) {
                    str = p.getFwVersion().getNumberOnlyVersionTag();
                }
                com.b.b.x a = com.getpebble.android.d.a.a(K, str2, str, TimeUnit.SECONDS.toMillis(30));
                if (a == null) {
                    try {
                        com.getpebble.android.common.b.a.f.b(f.TAG, "jsonObjectResponse is null");
                    } catch (Throwable e) {
                        com.getpebble.android.common.b.a.f.b(f.TAG, "syncFontPack: Failed to marshall language pack manifest; not updating languages", e);
                    }
                } else if (a.b() == null) {
                    com.getpebble.android.common.b.a.f.b(f.TAG, "jsonObjectResponse.getResult() is null");
                } else {
                    x a2 = x.a(((o) a.b()).toString());
                    int length = a2.a == null ? -1 : a2.a.length;
                    com.getpebble.android.common.b.a.f.d(f.TAG, "syncFontPack: received a language pack response of length: " + length);
                    c.a(length);
                    this.b = a2;
                }
            } catch (Throwable e2) {
                com.getpebble.android.common.b.a.f.a(f.TAG, "Error fetching language pack manifest", e2);
            }
        }
    }

    public int c() {
        return R.layout.fragment_additional_font_pack;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = (ProgressBar) viewGroup.findViewById(R.id.progress_bar);
        this.b = (RecyclerView) viewGroup.findViewById(R.id.my_recycler_view);
        this.b.a(new com.getpebble.android.ui.a(getActivity(), R.color.my_pebble_light_gray, R.dimen.developer_divider_height));
        this.c = new com.getpebble.android.main.sections.fontpack.a.a(null);
        this.b.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.b.setAdapter(this.c);
        new a().submit();
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return false;
    }
}
