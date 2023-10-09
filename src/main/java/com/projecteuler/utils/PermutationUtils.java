package com.projecteuler.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationUtils {

    public static <T> List<List<T>> permute(List<T> objectList) {
        return permutations(new ArrayList<>(), new ArrayList<>(), objectList);
    }

    private static <T> List<List<T>> permutations(List<List<T>> permutationList, List<T> currentPermutation, List<T> objectList) {

        if (currentPermutation.size() == objectList.size()) {
            permutationList.add(List.copyOf(currentPermutation));
            return permutationList;
        }

        objectList.forEach(o -> {
            if (!currentPermutation.contains(o)) {
                currentPermutation.add(o);
                permutations(permutationList, currentPermutation, objectList);
                currentPermutation.remove(o);
            }
        });

        return permutationList;
    }

    public static void main(String[] args) {
        List<Integer> a = List.of(1, 2, 3);
        System.out.println(permute(a));

        List<String> b = List.of("A", "B", "C", "D");
        System.out.println(permute(b));
        System.out.println(MathUtils.factorial(b.size()));

        List<Character> c = List.of('1', '2', '3');
        StringBuilder s = new StringBuilder();
        permute(c).forEach(cs -> s.append(StringUtils.joinCharacters(cs)).append(", "));
        System.out.println(s);
    }
}
