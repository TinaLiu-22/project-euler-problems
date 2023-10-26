package com.projecteuler.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Utils {

    public static boolean isPalindrome(String str) {
        return Objects.equals(str, new StringBuffer(str).reverse().toString());
    }

    public static String convertIntToBase(int n, int base) {
        return Integer.toString(n, base);
    }

    public static List<String> convertLiteralStrToListObjStr(String s) {

        char[] chars = s.toCharArray();

        List<String> characters = new ArrayList<>();

        for(char c : chars) {
            characters.add(new String(String.valueOf(c)));
        }

        return characters;
    }

    public static void main(String[] args) {
        List<String> chars = convertLiteralStrToListObjStr("9722");
        System.out.println(chars.get(2) == chars.get(3));
    }
}
