package com.getpebble.android.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.model.ah;
import com.getpebble.android.common.model.ak.a;

public class b extends LinearLayout {
    private a a;
    private TextView b = ((TextView) findViewById(R.id.pbl_name));
    private TextView c = ((TextView) findViewById(R.id.pbl_connection_status));
    private TextView d = ((TextView) findViewById(R.id.pbl_info));
    private ImageView e = ((ImageView) findViewById(R.id.pbl_connection_img));
    private TextView f = ((TextView) findViewById(R.id.tap_to_disconnect_cancel));

    public b(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_pebble_device, this, true);
    }

    public void a(a aVar, boolean z) {
        this.a = aVar;
        if (this.a == null) {
            f.d("PebbleDeviceView", "Cannot update() with no model");
            return;
        }
        this.b.setText(this.a.pebbleDevice.getName());
        Drawable a = a(getContext(), this.a.color, this.a.hwPlatform.getPlatformCode());
        if (a != null) {
            this.e.setImageDrawable(a);
        }
        if (z) {
            this.d.setVisibility(8);
            this.f.setVisibility(8);
        }
        if (!z) {
            CharSequence string;
            if ((this.a.lastConnectedTimeMillis == 0 ? 1 : 0) != 0) {
                string = getResources().getString(R.string.connection_manager_new_pebble);
            } else {
                string = String.format(getResources().getString(R.string.connection_manager_watch_version), new Object[]{this.a.getFwVersion()});
            }
            this.d.setText(string);
        }
        this.c.setText(getContext().getString(a(this.a)));
        this.c.setTextColor(getResources().getColor(b(this.a)));
        switch (this.a.connectionStatus) {
            case CONNECTED:
                this.e.setAlpha(1.0f);
                if (z) {
                    this.c.setVisibility(0);
                    return;
                }
                this.b.setTextColor(getResources().getColor(R.color.white));
                this.f.setVisibility(0);
                this.f.setText(R.string.pbl_view_tap_to_disconnect);
                return;
            case CONNECTING:
                this.e.setAlpha(1.0f);
                if (z) {
                    this.c.setVisibility(0);
                    return;
                }
                this.b.setTextColor(getResources().getColor(R.color.white));
                if (this.a.connectionGoal.equals(com.getpebble.android.b.a.DISCONNECT)) {
                    this.f.setVisibility(8);
                    return;
                }
                this.f.setVisibility(0);
                this.f.setText(R.string.pbl_view_text_tap_to_cancel);
                return;
            case UNKNOWN:
            case DISCONNECTED:
                this.e.setAlpha(0.4f);
                if (z) {
                    this.c.setVisibility(8);
                    return;
                }
                this.b.setTextColor(getResources().getColor(R.color.default_orange_color));
                this.f.setVisibility(8);
                return;
            default:
                f.a("PebbleDeviceView", "Unsupported status");
                return;
        }
    }

    public static Drawable a(Context context, ah ahVar, com.getpebble.android.common.framework.install.app.b.a aVar) {
        int i = R.drawable.drawer_pebble2_black;
        if (context == null) {
            f.b("PebbleDeviceView", "getConnectionDrawableForColor: context is null");
            return null;
        }
        switch (ahVar) {
            case COLOR_BLACK:
                i = R.drawable.pebble_model_black_connection;
                break;
            case COLOR_WHITE:
                i = R.drawable.pebble_model_white_connection;
                break;
            case COLOR_RED:
                i = R.drawable.pebble_model_red_connection;
                break;
            case COLOR_ORANGE:
                i = R.drawable.pebble_model_orange_connection;
                break;
            case COLOR_GRAY:
                i = R.drawable.pebble_model_gray_connection;
                break;
            case COLOR_BIANCA_SILVER:
                i = R.drawable.pebble_model_steel_brushed_connection;
                break;
            case COLOR_BIANCA_BLACK:
                i = R.drawable.pebble_model_steel_matte_connection;
                break;
            case COLOR_TINTIN_BLUE:
                i = R.drawable.pebble_model_blue_connection;
                break;
            case COLOR_TINTIN_GREEN:
                i = R.drawable.pebble_model_green_connection;
                break;
            case COLOR_TINTIN_PINK:
                i = R.drawable.pebble_model_pink_connection;
                break;
            case COLOR_SNOWY_WHITE:
                i = R.drawable.pebble_time_white_connection;
                break;
            case COLOR_SNOWY_BLACK:
                i = R.drawable.pebble_time_black_connection;
                break;
            case COLOR_SNOWY_RED:
                i = R.drawable.pebble_time_red_connection;
                break;
            case COLOR_BOBBY_BLACK:
                i = R.drawable.pebble_time_steel_dark_connection;
                break;
            case COLOR_BOBBY_SILVER:
                i = R.drawable.pebble_time_steel_light_connection;
                break;
            case COLOR_BOBBY_GOLD:
                i = R.drawable.pebble_time_steel_gold_connection;
                break;
            case COLOR_SPALDING_SILVER_14:
                i = R.drawable.pebble_time_round_silver_14_connection;
                break;
            case COLOR_SPALDING_BLACK_14:
                i = R.drawable.pebble_time_round_black_14_connection;
                break;
            case COLOR_SPALDING_SILVER_20:
                i = R.drawable.pebble_time_round_silver_20_connection;
                break;
            case COLOR_SPALDING_BLACK_20:
                i = R.drawable.pebble_time_round_black_20_connection;
                break;
            case COLOR_SPALDING_ROSE_GOLD_14:
                i = R.drawable.pebble_time_round_rose_gold_14_connection;
                break;
            case COLOR_SPALDING_SILVER_RAINBOW_14:
                i = R.drawable.pebble_time_round_silver_rainbow_14_connection;
                break;
            case COLOR_SPALDING_BLACK_RAINBOW_20:
                i = R.drawable.pebble_time_round_black_rainbow_20_connection;
                break;
            case COLOR_SPALDING_POLISHED_GOLD_20:
                i = R.drawable.drawer_pebble_round_goldblack;
                break;
            case COLOR_SPALDING_POLISHED_SILVER_20:
                i = R.drawable.drawer_pebble_round_silverblack;
                break;
            case COLOR_SILK_SE_BLACK:
            case COLOR_SILK_HR_BLACK:
                break;
            case COLOR_SILK_SE_WHITE:
                i = R.drawable.drawer_pebble2_white;
                break;
            case COLOR_SILK_HR_GREEN:
                i = R.drawable.drawer_pebble2_blacklime;
                break;
            case COLOR_SILK_HR_RED:
                i = R.drawable.drawer_pebble2_blackred;
                break;
            case COLOR_SILK_HR_WHITE:
                i = R.drawable.drawer_pebble2_white;
                break;
            case COLOR_SILK_HR_TURQOISE:
                i = R.drawable.drawer_pebble2_whiteteal;
                break;
            case COLOR_ROBERT_BLACK:
            case COLOR_ROBERT_SILVER:
            case COLOR_ROBERT_GOLD:
                i = R.drawable.pebble_2;
                break;
            default:
                i = aVar.getDefaultConnectionResource();
                break;
        }
        return context.getResources().getDrawable(i);
    }

    public static int a(a aVar) {
        switch (aVar.connectionStatus) {
            case CONNECTED:
                if (aVar.connectionGoal.equals(com.getpebble.android.b.a.DISCONNECT)) {
                    return R.string.connection_manager_disconnecting;
                }
                if (aVar.isRunningRecoveryFw) {
                    return R.string.connection_manager_connected_prf;
                }
                if (aVar.recoveryFwVersion == null) {
                    return R.string.connection_manager_connected_no_prf;
                }
                if (com.getpebble.android.framework.firmware.b.a()) {
                    return R.string.connection_manager_connected_2x;
                }
                return R.string.connection_manager_connected;
            case CONNECTING:
                if (aVar.connectionGoal.equals(com.getpebble.android.b.a.DISCONNECT)) {
                    return R.string.connection_manager_disconnecting;
                }
                return R.string.connection_manager_connecting;
            default:
                return R.string.connection_manager_disconnected;
        }
    }

    public static int b(a aVar) {
        switch (aVar.connectionStatus) {
            case CONNECTED:
                if (aVar.connectionGoal.equals(com.getpebble.android.b.a.DISCONNECT)) {
                    return R.color.white;
                }
                return aVar.isRunningRecoveryFw ? R.color.menu_item_phone_status_color_red : aVar.recoveryFwVersion == null ? R.color.menu_item_phone_status_color_red : R.color.menu_item_phone_status_color_green;
            case CONNECTING:
                return !aVar.connectionGoal.equals(com.getpebble.android.b.a.DISCONNECT) ? R.color.menu_item_phone_status_color_green : R.color.white;
            default:
                return R.color.white;
        }
    }
}
