package net.hockeyapp.android.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import net.hockeyapp.android.c.e;
import net.hockeyapp.android.c.f;
import net.hockeyapp.android.d.a;
import net.hockeyapp.android.i;
import net.hockeyapp.android.i.c;

public class b extends LinearLayout {
    @SuppressLint({"SimpleDateFormat"})
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    @SuppressLint({"SimpleDateFormat"})
    private static final SimpleDateFormat b = new SimpleDateFormat("d MMM h:mm a");
    private TextView c = ((TextView) findViewById(net.hockeyapp.android.i.b.label_author));
    private TextView d = ((TextView) findViewById(net.hockeyapp.android.i.b.label_date));
    private TextView e = ((TextView) findViewById(net.hockeyapp.android.i.b.label_text));
    private AttachmentListView f = ((AttachmentListView) findViewById(net.hockeyapp.android.i.b.list_attachments));
    private f g;
    private final Context h;

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = context;
        LayoutInflater.from(context).inflate(c.view_feedback_message, this);
    }

    public void setFeedbackMessage(f fVar) {
        this.g = fVar;
        try {
            this.d.setText(b.format(a.parse(this.g.b())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.c.setText(this.g.d());
        this.e.setText(this.g.a());
        this.f.removeAllViews();
        for (e eVar : this.g.e()) {
            a aVar = new a(this.h, this.f, eVar, false);
            a.a().a(eVar, aVar);
            this.f.addView(aVar);
        }
    }

    public void setIndex(int i) {
        if (i % 2 == 0) {
            setBackgroundColor(getResources().getColor(i.a.background_light));
            this.c.setTextColor(getResources().getColor(i.a.text_white));
            this.d.setTextColor(getResources().getColor(i.a.text_white));
        } else {
            setBackgroundColor(getResources().getColor(i.a.background_white));
            this.c.setTextColor(getResources().getColor(i.a.text_light));
            this.d.setTextColor(getResources().getColor(i.a.text_light));
        }
        this.e.setTextColor(getResources().getColor(i.a.text_black));
    }
}
