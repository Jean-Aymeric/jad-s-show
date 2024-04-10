package com.jad.show;

import java.util.Optional;

public final class Helper {

    private Helper() {}

    public static String getFieldValueByName(String input, String field) {
        int fieldNameIndex = input.indexOf(field + "=");
        if (fieldNameIndex == -1) {
            return null;
        }

        return Optional.of(input.substring(fieldNameIndex + field.length() + 1))
                       .map(value -> value.split("[;\"]")[0].trim())
                       .orElse(null);
    }

    public static boolean isShowType(ShowType showType, String showDescription) {
        return showDescription.contains(showType.name());
    }

    public static String getDirector(String showDescription) {
        return getFieldValueByName(showDescription, "director");
    }
}
