package com.determine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsArraySubset {
    public static void main(String[] args) {
        String[] arr1 = {"a", "b", "c", "d", "e", "f"};
        String[] arr2 = {"b", "d", "f","h"};

        Boolean result = isSubset(arr1, arr2);
        System.out.printf("one array is subset of other=" + result);
        System.out.print("\n");
    }

    private static boolean isSubset(String[] arr1, String[] arr2) {
        String[] biggerArray;
        String[] smallerArray;
        Map<String, Boolean> store = new HashMap();
        if (arr1.length > arr2.length) {
            biggerArray = arr1;
            smallerArray = arr2;
        } else {
            biggerArray = arr2;
            smallerArray = arr1;
        }

        Arrays.stream(biggerArray).forEach(value -> {
            store.putIfAbsent(value, true);
        });
        return Arrays.stream(smallerArray).allMatch(store::containsKey);
    }
}
