package com.getpebble.android.main.sections.mypebble.fragment;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.framework.install.app.b.a;
import com.getpebble.android.common.framework.widget.AsyncImageView;
import com.getpebble.android.common.model.ah;
import com.getpebble.android.widget.PebbleTextView;

public abstract class b extends DialogFragment {
    protected TextView a;
    protected TextView b;
    protected TextView c;
    protected View d;
    protected View e;
    protected View f;
    protected LinearLayout g;
    protected AsyncImageView h;
    protected AsyncImageView i;
    protected ImageView j;
    protected Button k;
    protected Button l;
    protected TextView m;
    protected TextView n;
    protected TextView o;
    protected LinearLayout p;
    protected LinearLayout q;
    protected LinearLayout r;
    protected LinearLayout s;
    protected LinearLayout t;
    protected LinearLayout u;
    protected LinearLayout v;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_dashboard_dialog, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.a = (PebbleTextView) view.findViewById(R.id.dashboard_app_name);
        this.b = (PebbleTextView) view.findViewById(R.id.dashboard_developer_name);
        this.h = (AsyncImageView) view.findViewById(R.id.dashboard_app_icon);
        this.c = (PebbleTextView) view.findViewById(R.id.num_hearts);
        this.f = view.findViewById(R.id.share);
        this.g = (LinearLayout) view.findViewById(R.id.buttons_layout);
        this.i = (AsyncImageView) view.findViewById(R.id.mask_screenshot);
        this.j = (ImageView) view.findViewById(R.id.mask_pebble);
        this.d = view.findViewById(R.id.about_this_app_text_view);
        this.e = view.findViewById(R.id.contact_developer_text_view);
        this.k = (Button) view.findViewById(R.id.get_companion_app_button);
        this.m = (PebbleTextView) view.findViewById(R.id.show_pins_text_view);
        this.n = (PebbleTextView) view.findViewById(R.id.show_reminders_notifications_text_view);
        this.o = (PebbleTextView) view.findViewById(R.id.system_app_text);
        this.p = (LinearLayout) view.findViewById(R.id.show_pins_group);
        this.q = (LinearLayout) view.findViewById(R.id.show_reminders_notifications_group);
        this.r = (LinearLayout) view.findViewById(R.id.system_app_group);
        this.s = (LinearLayout) view.findViewById(R.id.about_this_app_group);
        this.t = (LinearLayout) view.findViewById(R.id.contact_developer_group);
        this.u = (LinearLayout) view.findViewById(R.id.buttons_layout_group);
        this.v = (LinearLayout) view.findViewById(R.id.set_as_active_watchface_group);
        this.l = (Button) view.findViewById(R.id.set_as_active_watchface);
    }

    public void show(FragmentManager fragmentManager, String str) {
        if (fragmentManager.findFragmentByTag(str) == null) {
            super.show(fragmentManager, str);
        } else {
            f.d("AbstractDashboardFragment", "Not showing dialog: Another dialog is already visible with the same tag (" + str + ").");
        }
    }

    protected View a(ViewGroup viewGroup, int i, int i2, OnClickListener onClickListener) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_dashboard_image_button, viewGroup, false);
        PebbleTextView pebbleTextView = (PebbleTextView) inflate.findViewById(R.id.settings_button_text);
        pebbleTextView.setText(i2);
        pebbleTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        inflate.setOnClickListener(onClickListener);
        viewGroup.addView(inflate);
        return inflate;
    }

    protected View a(ViewGroup viewGroup, int i, OnClickListener onClickListener) {
        return a(viewGroup, 0, i, onClickListener);
    }

    protected int a(ah ahVar, a aVar) {
        switch (ahVar) {
            case COLOR_BLACK:
                return R.drawable.popup_pebble_original_black;
            case COLOR_WHITE:
                return R.drawable.popup_pebble_original_white;
            case COLOR_RED:
                return R.drawable.popup_pebble_original_red;
            case COLOR_ORANGE:
                return R.drawable.popup_pebble_original_orange;
            case COLOR_GRAY:
                return R.drawable.popup_pebble_original_gray;
            case COLOR_BIANCA_SILVER:
                return R.drawable.popup_pebble_steel_light;
            case COLOR_BIANCA_BLACK:
                return R.drawable.popup_pebble_steel_dark;
            case COLOR_TINTIN_BLUE:
                return R.drawable.popup_pebble_original_blue;
            case COLOR_TINTIN_GREEN:
                return R.drawable.popup_pebble_original_green;
            case COLOR_TINTIN_PINK:
                return R.drawable.popup_pebble_original_pink;
            case COLOR_SNOWY_WHITE:
                return R.drawable.pebble_time_white_details;
            case COLOR_SNOWY_BLACK:
                return R.drawable.popup_pebble_time_black;
            case COLOR_SNOWY_RED:
                return R.drawable.popup_pebble_time_red;
            case COLOR_BOBBY_BLACK:
                return R.drawable.popup_pebble_timesteel_dark;
            case COLOR_BOBBY_SILVER:
                return R.drawable.pebble_time_steel_light_details;
            case COLOR_BOBBY_GOLD:
                return R.drawable.pebble_time_steel_gold_details;
            case COLOR_SPALDING_SILVER_14:
                return R.drawable.popup_pebble_round_white14mm;
            case COLOR_SPALDING_BLACK_14:
                return R.drawable.popup_pebble_round_black14mm;
            case COLOR_SPALDING_SILVER_20:
                return R.drawable.popup_pebble_round_white;
            case COLOR_SPALDING_BLACK_20:
                return R.drawable.popup_pebble_round_black;
            case COLOR_SPALDING_ROSE_GOLD_14:
                return R.drawable.popup_pebble_round_gold;
            case COLOR_SPALDING_SILVER_RAINBOW_14:
                return R.drawable.popup_pebble_round_whiterainbow;
            case COLOR_SPALDING_BLACK_RAINBOW_20:
                return R.drawable.popup_pebble_round_blackrainbow;
            case COLOR_SPALDING_POLISHED_GOLD_20:
                return R.drawable.popup_pebble_round_goldblack;
            case COLOR_SPALDING_POLISHED_SILVER_20:
                return R.drawable.popup_pebble_round_silverblack;
            case COLOR_SILK_SE_BLACK:
            case COLOR_SILK_HR_BLACK:
                return R.drawable.popup_pebble2_black;
            case COLOR_SILK_SE_WHITE:
                return R.drawable.popup_pebble2_white;
            case COLOR_SILK_HR_GREEN:
                return R.drawable.popup_pebble2_blacklime;
            case COLOR_SILK_HR_RED:
                return R.drawable.popup_pebble2_blackred;
            case COLOR_SILK_HR_WHITE:
                return R.drawable.popup_pebble2_white;
            case COLOR_SILK_HR_TURQOISE:
                return R.drawable.popup_pebble2_whiteteal;
            case COLOR_ROBERT_BLACK:
            case COLOR_ROBERT_SILVER:
            case COLOR_ROBERT_GOLD:
                return R.drawable.pebble_2;
            default:
                return aVar.getDefaultMyPebbleResource();
        }
    }
}
