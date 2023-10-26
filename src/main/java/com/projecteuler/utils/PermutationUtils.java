package com.projecteuler.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PermutationUtils {

    public static <T> List<List<T>> permute(List<T> objectList) {
        return permutations(new ArrayList<>(), new ArrayList<>(), objectList, new boolean[objectList.size()]);
    }

    private static <T> List<List<T>> permutations(List<List<T>> permutationList, List<T> currentPermutation,
                                                  List<T> objectList, boolean[] isUsed) {

        if (currentPermutation.size() == objectList.size()) {
            permutationList.add(List.copyOf(currentPermutation));
            return permutationList;
        }

        AtomicInteger i = new AtomicInteger();
        objectList.forEach(o -> {
            if (!isUsed[i.get()]) {
                currentPermutation.add(o);
                isUsed[i.get()] = true;
                permutations(permutationList, currentPermutation, objectList, isUsed);
                currentPermutation.remove(o);
                isUsed[i.get()] = false;
            }
            i.getAndIncrement();
        });

        return permutationList;
    }

    public static List<Integer> digitPermutations(Integer i) {
        return permute(Utils.convertLiteralStrToListObjStr(i.toString()))
                .stream()
                .map(chars -> Integer.valueOf(StringUtils.joinStrCharacters(chars)))
                .toList();
    }

    public static List<Integer> getDigitCircularPermutations(int number) {

        List<Integer> permutations = new ArrayList<>();

        int nbOfDigits = Utils.getNbOfDigits(number);
        int dividor = (int) Math.pow(10, nbOfDigits - 1);

        int currentPermutation = number;
        for (int i = 0; i < nbOfDigits; i++) {
            permutations.add(currentPermutation);

            int firstDigit = currentPermutation / dividor;
            currentPermutation = currentPermutation % dividor * 10 + firstDigit;
        }

        return permutations;
    }

    public static void main(String[] args) {
//        List<Integer> a = List.of(1, 2, 3);
//        System.out.println(permute(a));
//
        List<String> b = List.of("A", "A", "C");
        System.out.println(permute(b));
        System.out.println(MathUtils.factorial(b.size()));

        System.out.println(digitPermutations(11));
//
//        List<Character> chars = new ArrayList<>();
//        chars.add('1');
//        chars.add('1');
//        List<Character> c = List.of('1', '1');
//        StringBuilder s = new StringBuilder();
//        permute(chars).forEach(cs -> s.append(StringUtils.joinCharacters(cs)).append(", "));
//        System.out.println(s);
    }
}
