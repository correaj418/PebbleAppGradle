package com.getpebble.android.main.sections.mypebble.d;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import java.util.EnumSet;

public class i {
    protected final ImageView a;
    protected final a b;
    protected com.getpebble.android.main.sections.mypebble.d.b.b c;
    private final EnumSet<com.getpebble.android.main.sections.mypebble.d.b.b> d;

    public interface a {
        void a();
    }

    private enum b {
        DWM_DAY(EnumSet.of(com.getpebble.android.main.sections.mypebble.d.b.b.DAY, com.getpebble.android.main.sections.mypebble.d.b.b.WEEK, com.getpebble.android.main.sections.mypebble.d.b.b.MONTH), com.getpebble.android.main.sections.mypebble.d.b.b.DAY, R.drawable.tab_day),
        DWM_WEEK(EnumSet.of(com.getpebble.android.main.sections.mypebble.d.b.b.DAY, com.getpebble.android.main.sections.mypebble.d.b.b.WEEK, com.getpebble.android.main.sections.mypebble.d.b.b.MONTH), com.getpebble.android.main.sections.mypebble.d.b.b.WEEK, R.drawable.tab_week),
        DWM_MONTH(EnumSet.of(com.getpebble.android.main.sections.mypebble.d.b.b.DAY, com.getpebble.android.main.sections.mypebble.d.b.b.WEEK, com.getpebble.android.main.sections.mypebble.d.b.b.MONTH), com.getpebble.android.main.sections.mypebble.d.b.b.MONTH, R.drawable.tab_month),
        DW_DAY(EnumSet.of(com.getpebble.android.main.sections.mypebble.d.b.b.DAY, com.getpebble.android.main.sections.mypebble.d.b.b.WEEK), com.getpebble.android.main.sections.mypebble.d.b.b.DAY, R.drawable.tab_nomonth_day),
        DW_WEEK(EnumSet.of(com.getpebble.android.main.sections.mypebble.d.b.b.DAY, com.getpebble.android.main.sections.mypebble.d.b.b.WEEK), com.getpebble.android.main.sections.mypebble.d.b.b.WEEK, R.drawable.tab_nomonth_week);
        
        private final com.getpebble.android.main.sections.mypebble.d.b.b activeResolution;
        private final EnumSet<com.getpebble.android.main.sections.mypebble.d.b.b> enabledResolutions;
        private final int resId;

        private b(EnumSet<com.getpebble.android.main.sections.mypebble.d.b.b> enumSet, com.getpebble.android.main.sections.mypebble.d.b.b bVar, int i) {
            this.enabledResolutions = enumSet;
            this.activeResolution = bVar;
            this.resId = i;
        }

        private static b from(EnumSet<com.getpebble.android.main.sections.mypebble.d.b.b> enumSet, com.getpebble.android.main.sections.mypebble.d.b.b bVar) {
            for (b bVar2 : values()) {
                if (bVar2.enabledResolutions.equals(enumSet) && bVar2.activeResolution.equals(bVar)) {
                    return bVar2;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public i(ImageView imageView, a aVar) {
        this(imageView, aVar, EnumSet.allOf(com.getpebble.android.main.sections.mypebble.d.b.b.class));
    }

    public i(ImageView imageView, a aVar, EnumSet<com.getpebble.android.main.sections.mypebble.d.b.b> enumSet) {
        this.c = com.getpebble.android.main.sections.mypebble.d.b.b.DAY;
        this.a = imageView;
        this.b = aVar;
        this.d = enumSet;
        imageView.setImageDrawable(imageView.getResources().getDrawable(b.from(enumSet, this.c).resId));
    }

    public void a() {
        this.a.setVisibility(8);
    }

    public void b() {
        this.a.setVisibility(0);
    }

    public void c() {
        this.a.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ i a;

            {
                this.a = r1;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 2) {
                    int width = view.getWidth();
                    int size = width / this.a.d.size();
                    int round = Math.round(motionEvent.getX());
                    com.getpebble.android.main.sections.mypebble.d.b.b fromIndex = com.getpebble.android.main.sections.mypebble.d.b.b.fromIndex(round / size);
                    if (fromIndex == null) {
                        f.a("TimeWidget", "onTouch: newResolution is null. width=" + width + "; touchPositionX:" + round);
                    } else if (this.a.d.contains(fromIndex) && !this.a.c.equals(fromIndex)) {
                        this.a.c = fromIndex;
                        if (this.a.b != null) {
                            this.a.b.a();
                        }
                        ((ImageView) view).setImageDrawable(view.getResources().getDrawable(b.from(this.a.d, this.a.c).resId));
                    }
                }
                return true;
            }
        });
    }
}
