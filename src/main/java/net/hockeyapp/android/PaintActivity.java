package net.hockeyapp.android;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import net.hockeyapp.android.i.d;
import net.hockeyapp.android.views.c;

public class PaintActivity extends Activity {
    private c a;
    private String b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Uri uri = (Uri) getIntent().getExtras().getParcelable("imageUri");
        this.b = a(uri, uri.getLastPathSegment());
        int i = getResources().getDisplayMetrics().widthPixels;
        int i2 = getResources().getDisplayMetrics().heightPixels;
        int i3 = i > i2 ? 0 : 1;
        int a = c.a(getContentResolver(), uri);
        setRequestedOrientation(a);
        if (i3 != a) {
            Log.d("HockeyApp", "Image loading skipped because activity will be destroyed for orientation change.");
            return;
        }
        this.a = new c(this, uri, i, i2);
        View linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        View linearLayout2 = new LinearLayout(this);
        linearLayout2.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2);
        linearLayout2.addView(this.a);
        setContentView(linearLayout);
        Toast.makeText(this, getString(d.hockeyapp_paint_indicator_toast), 1).show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, getString(d.hockeyapp_paint_menu_save));
        menu.add(0, 2, 0, getString(d.hockeyapp_paint_menu_undo));
        menu.add(0, 3, 0, getString(d.hockeyapp_paint_menu_clear));
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                a();
                return true;
            case 2:
                this.a.b();
                return true;
            case 3:
                this.a.a();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.a.c()) {
            return super.onKeyDown(i, keyEvent);
        }
        OnClickListener anonymousClass1 = new OnClickListener(this) {
            final /* synthetic */ PaintActivity a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case -2:
                        this.a.finish();
                        return;
                    case -1:
                        this.a.a();
                        return;
                    default:
                        return;
                }
            }
        };
        new Builder(this).setMessage(d.hockeyapp_paint_dialog_message).setPositiveButton(d.hockeyapp_paint_dialog_positive_button, anonymousClass1).setNegativeButton(d.hockeyapp_paint_dialog_negative_button, anonymousClass1).setNeutralButton(d.hockeyapp_paint_dialog_neutral_button, anonymousClass1).show();
        return true;
    }

    private void a() {
        File file = new File(getCacheDir(), "HockeyApp");
        file.mkdir();
        File file2 = new File(file, this.b + ".jpg");
        int i = 1;
        while (file2.exists()) {
            file2 = new File(file, this.b + "_" + i + ".jpg");
            i++;
        }
        this.a.setDrawingCacheEnabled(true);
        final Bitmap drawingCache = this.a.getDrawingCache();
        new AsyncTask<File, Void, Void>(this) {
            final /* synthetic */ PaintActivity b;

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return a((File[]) objArr);
            }

            protected Void a(File... fileArr) {
                try {
                    OutputStream fileOutputStream = new FileOutputStream(fileArr[0]);
                    drawingCache.compress(CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                } catch (Throwable e) {
                    e.printStackTrace();
                    Log.e("HockeyApp", "Could not save image.", e);
                }
                return null;
            }
        }.execute(new File[]{file2});
        Intent intent = new Intent();
        intent.putExtra("imageUri", Uri.fromFile(file2));
        if (getParent() == null) {
            setResult(-1, intent);
        } else {
            getParent().setResult(-1, intent);
        }
        finish();
    }

    private String a(Uri uri, String str) {
        String str2 = null;
        Cursor query = getApplicationContext().getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    str2 = query.getString(0);
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        return str2 == null ? str : new File(str2).getName();
    }
}
