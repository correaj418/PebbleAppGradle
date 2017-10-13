package android.support.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
public class b extends e implements Animatable {
    private a b;
    private Context c;
    private ArgbEvaluator d;
    private final Callback e;

    private static class a extends ConstantState {
        int a;
        f b;
        ArrayList<Animator> c;
        android.support.v4.e.a<Animator, String> d;

        public a(Context context, a aVar, Callback callback, Resources resources) {
            int i = 0;
            if (aVar != null) {
                this.a = aVar.a;
                if (aVar.b != null) {
                    ConstantState constantState = aVar.b.getConstantState();
                    if (resources != null) {
                        this.b = (f) constantState.newDrawable(resources);
                    } else {
                        this.b = (f) constantState.newDrawable();
                    }
                    this.b = (f) this.b.mutate();
                    this.b.setCallback(callback);
                    this.b.setBounds(aVar.b.getBounds());
                    this.b.a(false);
                }
                if (aVar.c != null) {
                    int size = aVar.c.size();
                    this.c = new ArrayList(size);
                    this.d = new android.support.v4.e.a(size);
                    while (i < size) {
                        Animator animator = (Animator) aVar.c.get(i);
                        Animator clone = animator.clone();
                        String str = (String) aVar.d.get(animator);
                        clone.setTarget(this.b.a(str));
                        this.c.add(clone);
                        this.d.put(clone, str);
                        i++;
                    }
                }
            }
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public int getChangingConfigurations() {
            return this.a;
        }
    }

    private static class b extends ConstantState {
        private final ConstantState a;

        public b(ConstantState constantState) {
            this.a = constantState;
        }

        public Drawable newDrawable() {
            b bVar = new b();
            bVar.a = this.a.newDrawable();
            bVar.a.setCallback(bVar.e);
            return bVar;
        }

        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            bVar.a = this.a.newDrawable(resources);
            bVar.a.setCallback(bVar.e);
            return bVar;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            b bVar = new b();
            bVar.a = this.a.newDrawable(resources, theme);
            bVar.a.setCallback(bVar.e);
            return bVar;
        }

        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private b() {
        this(null, null, null);
    }

    private b(Context context) {
        this(context, null, null);
    }

    private b(Context context, a aVar, Resources resources) {
        this.d = null;
        this.e = new Callback(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void invalidateDrawable(Drawable drawable) {
                this.a.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                this.a.scheduleSelf(runnable, j);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                this.a.unscheduleSelf(runnable);
            }
        };
        this.c = context;
        if (aVar != null) {
            this.b = aVar;
        } else {
            this.b = new a(context, aVar, this.e, resources);
        }
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    public ConstantState getConstantState() {
        if (this.a != null) {
            return new b(this.a.getConstantState());
        }
        return null;
    }

    public int getChangingConfigurations() {
        if (this.a != null) {
            return this.a.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.b.a;
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        this.b.b.draw(canvas);
        if (a()) {
            invalidateSelf();
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        } else {
            this.b.b.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        return this.b.b.setState(iArr);
    }

    protected boolean onLevelChange(int i) {
        if (this.a != null) {
            return this.a.setLevel(i);
        }
        return this.b.b.setLevel(i);
    }

    public int getAlpha() {
        if (this.a != null) {
            return android.support.v4.b.a.a.c(this.a);
        }
        return this.b.b.getAlpha();
    }

    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        } else {
            this.b.b.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
        } else {
            this.b.b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i) {
        if (this.a != null) {
            android.support.v4.b.a.a.a(this.a, i);
        } else {
            this.b.b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            android.support.v4.b.a.a.a(this.a, colorStateList);
        } else {
            this.b.b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.a != null) {
            android.support.v4.b.a.a.a(this.a, mode);
        } else {
            this.b.b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.a != null) {
            return this.a.setVisible(z, z2);
        }
        this.b.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public boolean isStateful() {
        if (this.a != null) {
            return this.a.isStateful();
        }
        return this.b.b.isStateful();
    }

    public int getOpacity() {
        if (this.a != null) {
            return this.a.getOpacity();
        }
        return this.b.b.getOpacity();
    }

    public int getIntrinsicWidth() {
        if (this.a != null) {
            return this.a.getIntrinsicWidth();
        }
        return this.b.b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.a != null) {
            return this.a.getIntrinsicHeight();
        }
        return this.b.b.getIntrinsicHeight();
    }

    static TypedArray a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.a != null) {
            android.support.v4.b.a.a.a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray a;
                if ("animated-vector".equals(name)) {
                    a = a(resources, theme, attributeSet, a.e);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        f a2 = f.a(resources, resourceId, theme);
                        a2.a(false);
                        a2.setCallback(this.e);
                        if (this.b.b != null) {
                            this.b.b.setCallback(null);
                        }
                        this.b.b = a2;
                    }
                    a.recycle();
                } else if ("target".equals(name)) {
                    a = resources.obtainAttributes(attributeSet, a.f);
                    String string = a.getString(0);
                    int resourceId2 = a.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.c != null) {
                            a(string, AnimatorInflater.loadAnimator(this.c, resourceId2));
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void applyTheme(Theme theme) {
        if (this.a != null) {
            android.support.v4.b.a.a.a(this.a, theme);
        }
    }

    public boolean canApplyTheme() {
        if (this.a != null) {
            return android.support.v4.b.a.a.d(this.a);
        }
        return false;
    }

    private void a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.d == null) {
                    this.d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.d);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.b.b.a(str));
        if (VERSION.SDK_INT < 21) {
            a(animator);
        }
        if (this.b.c == null) {
            this.b.c = new ArrayList();
            this.b.d = new android.support.v4.e.a();
        }
        this.b.c.add(animator);
        this.b.d.put(animator, str);
    }

    public boolean isRunning() {
        if (this.a != null) {
            return ((AnimatedVectorDrawable) this.a).isRunning();
        }
        ArrayList arrayList = this.b.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private boolean a() {
        ArrayList arrayList = this.b.c;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).start();
        } else if (!a()) {
            ArrayList arrayList = this.b.c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).stop();
            return;
        }
        ArrayList arrayList = this.b.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
