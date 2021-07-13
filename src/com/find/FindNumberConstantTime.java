package com.find;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindNumberConstantTime {
    public static void main(String[] args) {
        int toFind = 38;
        int[] input_array = {61, 30, 91, 11, 54, 38, 72};
        Map<Integer, Boolean> store = new HashMap<>();
        boolean isFound = findNumber(toFind, input_array, store);
        System.out.printf("Number found="+isFound+" by O(1)");
        System.out.print("\n");

    }

    private static boolean findNumber(int number, int[] input_array, Map<Integer, Boolean> store) {
        if (store.isEmpty() || store.size() != input_array.length) {
            Arrays.stream(input_array).forEach(value -> {
                store.putIfAbsent(value, true);
            });
        }
        return store.get(number) == null ? false : true;
    }
}
