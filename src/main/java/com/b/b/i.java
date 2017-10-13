package com.b.b;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.b.a.b.f;
import com.b.a.b.j;
import com.b.b.a.b;
import com.b.b.e.a;

class i extends j<ImageView, l> implements a {
    public static final i a = new i() {
        {
            a(new NullPointerException("uri"));
        }

        protected /* bridge */ /* synthetic */ void a(Object obj) {
            super.a((l) obj);
        }
    };
    private z b;
    private Animation c;
    private int m;
    private b n;

    i() {
    }

    public static i a(b bVar, l lVar) {
        f fVar;
        if (lVar.a() instanceof i) {
            fVar = (i) lVar.a();
        } else {
            fVar = new i();
        }
        lVar.a(fVar);
        fVar.n = bVar;
        return fVar;
    }

    protected void a(l lVar) {
        ImageView imageView = (ImageView) this.n.get();
        if (this.n.a() != null || imageView == null) {
            c();
        } else if (imageView.getDrawable() != lVar) {
            c();
        } else {
            b c = lVar.c();
            if (c != null && c.g == null) {
                a(imageView, this.b);
            }
            k.a(imageView, this.c, this.m);
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(lVar);
            b((Object) imageView);
        }
    }

    public i a(Animation animation, int i) {
        this.c = animation;
        this.m = i;
        return this;
    }

    public i a(z zVar) {
        this.b = zVar;
        return this;
    }

    public static void a(ImageView imageView, z zVar) {
        if (zVar != null) {
            switch (zVar) {
                case CenterCrop:
                    imageView.setScaleType(ScaleType.CENTER_CROP);
                    return;
                case FitCenter:
                    imageView.setScaleType(ScaleType.FIT_CENTER);
                    return;
                case CenterInside:
                    imageView.setScaleType(ScaleType.CENTER_INSIDE);
                    return;
                case FitXY:
                    imageView.setScaleType(ScaleType.FIT_XY);
                    return;
                default:
                    return;
            }
        }
    }
}
