package com.getpebble.android.onboarding.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.getpebble.android.PebbleApplication;
import com.getpebble.android.basalt.R;
import com.getpebble.android.common.b.a.f;
import com.getpebble.android.common.b.b.c;
import com.getpebble.android.common.framework.a.b;
import com.getpebble.android.config.JsonConfigHolder.Voice.Language;
import com.getpebble.android.h.q;
import com.getpebble.android.main.sections.a;
import com.getpebble.android.onboarding.activity.OnboardingActivity;
import com.getpebble.android.widget.PebbleButton;
import com.google.a.b.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class ChooseVoiceLanguageFragment extends b {
    private Spinner a;
    private HashMap<String, String> b = new HashMap();
    private String c = "";

    public int c() {
        return R.layout.choose_language_layout;
    }

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int position;
        TextView textView = (TextView) viewGroup.findViewById(R.id.onboarding_banner_voice);
        if (d()) {
            a.a((RelativeLayout) viewGroup);
        } else {
            textView.setVisibility(8);
        }
        this.a = (Spinner) viewGroup.findViewById(R.id.language_spinner);
        final v a = a();
        List<String> arrayList = new ArrayList(a.b());
        List arrayList2 = new ArrayList();
        String string = getString(R.string.onboarding_default_language_name);
        String a2 = q.a();
        Object obj = string;
        for (String string2 : arrayList) {
            Locale a3 = q.a(string2);
            String displayName = a3.getDisplayName(a3);
            if (string2.equals(a2)) {
                obj = displayName;
            }
            arrayList2.add(displayName);
            this.b.put(displayName, string2);
        }
        Collections.sort(arrayList2);
        com.getpebble.android.onboarding.a.b bVar = new com.getpebble.android.onboarding.a.b(getActivity(), R.layout.spinner_dropdown_item, R.id.dropdown_item_text, arrayList2);
        this.a.setAdapter(bVar);
        if (d()) {
            position = bVar.getPosition(obj);
        } else {
            string2 = PebbleApplication.y().a(c.a.VOICE_LANGUAGE, getString(R.string.onboarding_default_language_code));
            Locale a4 = q.a(a.containsKey(string2) ? (String) a.get(string2) : getString(R.string.onboarding_default_android_language_code));
            position = bVar.getPosition(a4.getDisplayName(a4));
        }
        this.a.setSelection(position);
        this.a.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            final /* synthetic */ ChooseVoiceLanguageFragment b;

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                f.d("ChooseVoiceLanguageFragment", "onItemSelected");
                this.b.c = (String) a.d().get((String) this.b.b.get((String) this.b.a.getItemAtPosition(i)));
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        ((PebbleButton) viewGroup.findViewById(R.id.continue_language_button)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ChooseVoiceLanguageFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.b();
            }
        });
    }

    private void b() {
        Activity activity = getActivity();
        PebbleApplication.y().b(c.a.VOICE_LANGUAGE, this.c.equals("") ? getString(R.string.onboarding_default_language_code) : this.c);
        f.d("ChooseVoiceLanguageFragment", "Selected code = " + this.c);
        if (activity instanceof OnboardingActivity) {
            ((OnboardingActivity) activity).i();
        } else {
            activity.finish();
        }
    }

    private boolean d() {
        return getActivity() instanceof OnboardingActivity;
    }

    public static v<String, String> a() {
        v<String, String> a = v.a();
        for (Language language : PebbleApplication.w().P()) {
            a.put(language.sixCharLocale, language.fourCharLocale);
        }
        return a;
    }
}
