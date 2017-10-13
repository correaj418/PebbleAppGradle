package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.e.i;
import android.support.v4.e.j;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class l extends h {
    final Handler c = new Handler(this) {
        final /* synthetic */ l a;

        {
            this.a = r1;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.a.g) {
                        this.a.a(false);
                        return;
                    }
                    return;
                case 2:
                    this.a.b();
                    this.a.d.n();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };
    final n d = n.a(new a(this));
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    int k;
    j<String> l;

    class a extends o<l> {
        final /* synthetic */ l a;

        public a(l lVar) {
            this.a = lVar;
            super(lVar);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            this.a.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean a(k kVar) {
            return !this.a.isFinishing();
        }

        public LayoutInflater b() {
            return this.a.getLayoutInflater().cloneInContext(this.a);
        }

        public void c() {
            this.a.d();
        }

        public void a(k kVar, Intent intent, int i, Bundle bundle) {
            this.a.a(kVar, intent, i, bundle);
        }

        public boolean d() {
            return this.a.getWindow() != null;
        }

        public int e() {
            Window window = this.a.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }

        public void b(k kVar) {
            this.a.a(kVar);
        }

        public View a(int i) {
            return this.a.findViewById(i);
        }

        public boolean a() {
            Window window = this.a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    static final class b {
        Object a;
        r b;
        i<String, v> c;

        b() {
        }
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.d.b();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.l.a(i4);
            this.l.c(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            k a = this.d.a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.d.a().b()) {
            a();
        }
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.d.a(z);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.d.b(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.d.a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.d.a(null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            this.d.a(bVar.c);
        }
        if (bundle != null) {
            this.d.a(bundle.getParcelable("android:support:fragments"), bVar != null ? bVar.b : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.k = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.l = new j(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.l.b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.l == null) {
            this.l = new j();
            this.k = 0;
        }
        this.d.e();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.d.a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.d.a(view, str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        a(false);
        this.d.l();
        this.d.p();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.d.m();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.d.a(menuItem);
            case 6:
                return this.d.b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.d.b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f = false;
        if (this.c.hasMessages(2)) {
            this.c.removeMessages(2);
            b();
        }
        this.d.i();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.d.b();
    }

    public void onStateNotSaved() {
        this.d.b();
    }

    protected void onResume() {
        super.onResume();
        this.c.sendEmptyMessage(2);
        this.f = true;
        this.d.n();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.c.removeMessages(2);
        b();
        this.d.n();
    }

    protected void b() {
        this.d.h();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.j) {
            this.j = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return a(view, menu) | this.d.a(menu);
    }

    protected boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.g) {
            a(true);
        }
        Object c = c();
        r d = this.d.d();
        i r = this.d.r();
        if (d == null && r == null && c == null) {
            return null;
        }
        Object bVar = new b();
        bVar.a = c;
        bVar.b = d;
        bVar.c = r;
        return bVar;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable c = this.d.c();
        if (c != null) {
            bundle.putParcelable("android:support:fragments", c);
        }
        if (this.l.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.k);
            int[] iArr = new int[this.l.b()];
            String[] strArr = new String[this.l.b()];
            for (int i = 0; i < this.l.b(); i++) {
                iArr[i] = this.l.d(i);
                strArr[i] = (String) this.l.e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.g = false;
        this.h = false;
        this.c.removeMessages(1);
        if (!this.e) {
            this.e = true;
            this.d.f();
        }
        this.d.b();
        this.d.n();
        this.d.o();
        this.d.g();
        this.d.q();
    }

    protected void onStop() {
        super.onStop();
        this.g = true;
        this.c.sendEmptyMessage(1);
        this.d.j();
    }

    public Object c() {
        return null;
    }

    public void d() {
        if (VERSION.SDK_INT >= 11) {
            b.a(this);
        } else {
            this.j = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.e);
            printWriter.print("mResumed=");
            printWriter.print(this.f);
            printWriter.print(" mStopped=");
            printWriter.print(this.g);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.h);
            this.d.a(str2, fileDescriptor, printWriter, strArr);
            this.d.a().a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            a(str + "  ", printWriter, getWindow().getDecorView());
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.e);
            printWriter.print("mResumed=");
            printWriter.print(this.f);
            printWriter.print(" mStopped=");
            printWriter.print(this.g);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.h);
            this.d.a(str2, fileDescriptor, printWriter, strArr);
            this.d.a().a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            a(str + "  ", printWriter, getWindow().getDecorView());
        }
    }

    private static String a(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    void a(boolean z) {
        if (!this.h) {
            this.h = true;
            this.i = z;
            this.c.removeMessages(1);
            e();
        } else if (z) {
            this.d.o();
            this.d.c(true);
        }
    }

    void e() {
        this.d.c(this.i);
        this.d.k();
    }

    public void a(k kVar) {
    }

    public p f() {
        return this.d.a();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!(this.b || i == -1)) {
            f.a(i);
        }
        super.startActivityForResult(intent, i);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.l.a(i3);
            this.l.c(i3);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            k a = this.d.a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
            } else {
                a.a(i & 65535, strArr, iArr);
            }
        }
    }

    public void a(k kVar, Intent intent, int i, Bundle bundle) {
        this.b = true;
        if (i == -1) {
            try {
                a.a(this, intent, -1, bundle);
            } finally {
                this.b = false;
            }
        } else {
            f.a(i);
            a.a(this, intent, ((b(kVar) + 1) << 16) + (65535 & i), bundle);
            this.b = false;
        }
    }

    private int b(k kVar) {
        if (this.l.b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.l.f(this.k) >= 0) {
            this.k = (this.k + 1) % 65534;
        }
        int i = this.k;
        this.l.b(i, kVar.q);
        this.k = (this.k + 1) % 65534;
        return i;
    }
}
