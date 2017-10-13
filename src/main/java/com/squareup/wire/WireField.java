package com.squareup.wire;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WireField {

    public enum Label {
        REQUIRED,
        OPTIONAL,
        REPEATED,
        ONE_OF,
        PACKED;

        boolean isRepeated() {
            return this == REPEATED || this == PACKED;
        }

        boolean isPacked() {
            return this == PACKED;
        }

        boolean isOneOf() {
            return this == ONE_OF;
        }
    }

    String adapter();

    String keyAdapter() default "";

    Label label() default Label.OPTIONAL;

    boolean redacted() default false;

    int tag();
}
