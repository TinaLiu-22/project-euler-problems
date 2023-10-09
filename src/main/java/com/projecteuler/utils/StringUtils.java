package com.projecteuler.utils;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    public static String joinCharacters(List<Character> chars) {
        return chars.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
    }
}
