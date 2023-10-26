package com.projecteuler.utils;

import java.util.List;

public class StringUtils {

    public static String joinCharacters(List<Character> chars) {
        StringBuilder builder = new StringBuilder();
        chars.forEach(c -> builder.append(c.charValue()));
        return builder.toString();
    }

    public static String joinStrCharacters(List<String> chars) {
        StringBuilder builder = new StringBuilder();
        chars.forEach(builder::append);
        return builder.toString();
    }
}
