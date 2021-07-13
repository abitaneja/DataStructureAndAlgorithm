package com.sort;

import java.util.Stack;

/**
 * Break statement is short circuit the inner loop once match found.
 * time complexity:- between N - N square
 */
public class IntersectionArraysOptimized {
    public static void main(String[] args) {
        int[] firstArray = {3, 1, 4, 2};
        int[] secondArray = {4, 5, 3, 6};
        Stack<Integer> result = intersection(firstArray, secondArray);
        result.stream().forEach(i -> {
            System.out.print(i + " ");
        });
    }

    private static Stack<Integer> intersection(int[] firstArray, int[] secondArray) {
        Stack<Integer> result = new Stack<>();
        int comparison = 0;
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < secondArray.length; j++) {
                comparison += 1;
                if (firstArray[i] == secondArray[j]) {
                    result.push(firstArray[i]);
                    break;
                }
            }
        }
        System.out.println("Total comparisons=" + comparison);
        return result;
    }
}