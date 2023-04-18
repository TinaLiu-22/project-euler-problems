package com.tina.projecteuler.utils;

import java.util.Objects;

public class Utils {

    public static boolean isPalindrome(String str) {
        return Objects.equals(str, new StringBuffer(str).reverse().toString());
    }

    public static String convertIntToBase(int n, int base) {
        return Integer.toString(n, base);
    }
}
