package com.projecteuler.utils;

import java.util.ArrayList;
import java.util.List;

public class PermutationUtils {

    public static <T> List<List<T>> permute(List<T> objectList) {
        return permutations(new ArrayList<>(), new ArrayList<>(), objectList);
    }

    /*
    This does not support String.class because of the java string pool
     */
    private static <T> List<List<T>> permutations(List<List<T>> permutationList, List<T> currentPermutation, List<T> objectList) {

        if (currentPermutation.size() == objectList.size()) {
            permutationList.add(List.copyOf(currentPermutation));
            return permutationList;
        }

        objectList.forEach(o -> {
            if (currentPermutation.stream().noneMatch(po -> po == o)) {
                currentPermutation.add(o);
                permutations(permutationList, currentPermutation, objectList);
                currentPermutation.remove(o);
            }
        });

        return permutationList;
    }

    public static List<Integer> digitPermutations(Integer i) {
        return permute(Utils.convertLiteralStrToListObjStr(i.toString()))
                .stream()
                .map(chars -> Integer.valueOf(StringUtils.joinStrCharacters(chars)))
                .toList();
    }

    public static void main(String[] args) {
//        List<Integer> a = List.of(1, 2, 3);
//        System.out.println(permute(a));
//
//        List<String> b = List.of("A", "B", "C", "D");
//        System.out.println(permute(b));
//        System.out.println(MathUtils.factorial(b.size()));
//
//        List<Character> chars = new ArrayList<>();
//        chars.add('1');
//        chars.add('1');
//        List<Character> c = List.of('1', '1');
//        StringBuilder s = new StringBuilder();
//        permute(chars).forEach(cs -> s.append(StringUtils.joinCharacters(cs)).append(", "));
//        System.out.println(s);

        System.out.println(permute(List.of(new String("9"), new String("7"), new String("2"),
                new String("2"))).size());
    }
}
