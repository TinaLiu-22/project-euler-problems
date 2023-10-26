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

    public static int getNbOfDigits(int number) {
        if (number < 100000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> chars = convertLiteralStrToListObjStr("9722");
        System.out.println(chars.get(2) == chars.get(3));

        int i = 9722;
        System.out.println(i / (int) Math.pow(10, getNbOfDigits(i) - 1));
    }
}
