package com.getpebble.android.framework.health.g;

import com.getpebble.android.basalt.R;
import com.getpebble.android.h.ac;

public interface a {

    public enum a implements a {
        INCHES {
            public int nameResourceId() {
                return R.string.height_unit_feet_inches;
            }

            public int stringFormatterResourceId() {
                return R.string.feet_inches_format;
            }

            public int fromMillimeters(int i) {
                return ac.f(i);
            }

            public int toMillimeters(int i) {
                return ac.a(i);
            }

            public int preferenceId() {
                return 0;
            }
        },
        CENTIMETERS {
            public int nameResourceId() {
                return R.string.height_unit_centimeters;
            }

            public int stringFormatterResourceId() {
                return R.string.centimeter_format;
            }

            public int fromMillimeters(int i) {
                return ac.b(i);
            }

            public int toMillimeters(int i) {
                return ac.d((double) i);
            }

            public int preferenceId() {
                return 1;
            }
        };

        public abstract int fromMillimeters(int i);

        public abstract int toMillimeters(int i);
    }

    public enum b implements a {
        POUNDS {
            public int nameResourceId() {
                return R.string.weight_unit_pounds;
            }

            public int stringFormatterResourceId() {
                return R.string.pounds_format;
            }

            public int fromDecagrams(int i) {
                return ac.e(i);
            }

            public int toDecagrams(int i) {
                return ac.a((double) i);
            }

            public int preferenceId() {
                return 0;
            }
        },
        KILOGRAMS {
            public int nameResourceId() {
                return R.string.weight_unit_kilograms;
            }

            public int stringFormatterResourceId() {
                return R.string.kilogram_format;
            }

            public int fromDecagrams(int i) {
                return ac.d(i);
            }

            public int toDecagrams(int i) {
                return ac.c((double) i);
            }

            public int preferenceId() {
                return 1;
            }
        };

        public abstract int fromDecagrams(int i);

        public abstract int toDecagrams(int i);
    }

    int nameResourceId();

    int preferenceId();

    int stringFormatterResourceId();
}
