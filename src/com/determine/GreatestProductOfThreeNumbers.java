package com.determine;

import java.util.Arrays;

/**
 * I have used <b>Bubble sort</b> to find the the k greatest numbers by using pass_through
 * if k=3 then the loop will run 3 times => O(3N+ k times)=> O(N)
 * <p>
 * please add the corner cases like N > k etc.
 * <p>
 * NOTE:- <b>Selection sort<b/> also can be used here to save the swaps of elements
 * and it will be 2 times faster than bubble sort
 */

public class GreatestProductOfThreeNumbers {
    public static void main(String[] args) {
        int[] input_bubble = {100, 5, 2, 1, 6, 3};
        int[] input_selection = {200, 10, 4, 2, 12, 6};
        int pass_through = 2;
        System.out.println("\n--------------- By Bubble Sort----------------------");
        int productByBubbleSort = findGreatestProductOfThreeNumbers(sortUsingBubbleSort(input_bubble, pass_through), pass_through);
        System.out.printf("Product by Bubble Sort is =%d", productByBubbleSort);
        System.out.println("\n--------------- By Selection Sort----------------------");
        int productBySelectionSort = findGreatestProductOfThreeNumbers(sortUsingSelectionSort(input_selection, pass_through), pass_through);
        System.out.printf("Product by Selection Sort is =%d", productBySelectionSort);

    }

    private static int findGreatestProductOfThreeNumbers(int[] input, int pass_through) {
        int product = 1;
        int i = 1;
        while (i <= pass_through) {
            product = product * input[input.length - i];
            i++;
        }
        return product;
    }

    private static int[] sortUsingBubbleSort(int[] input, int pass_through) {
        int count = 0;
        int total_iterations = 0;
        while (count < pass_through) {
            for (int i = 0; i < input.length - 1; i++) {
                int j = i + 1;
                if (input[i] > input[j]) {
                    total_iterations += 1;
                    swap(input, i, j);
                }
            }
            Arrays.stream(input).forEach(i -> {
                System.out.print(" " + i);
            });
            System.out.println();
            count++;
        }
        System.out.println("Total iterations=" + total_iterations);
        return input;
    }

    private static int[] sortUsingSelectionSort(int[] input, int pass_through) {
        int count = 0;
        int total_iterations = 0;
        int biggest = count;
        while (count < pass_through) {
            for (int i = count; i < input.length - 1; i++) {
                if (input[i] > input[biggest]) {
                    total_iterations += 1;
                    biggest = i;
                }
            }
            count++;
            swap(input, input.length - count, biggest);
            Arrays.stream(input).forEach(i -> {
                System.out.print(" " + i);
            });
            System.out.println();

        }
        System.out.println("Total iterations=" + total_iterations);
        return input;
    }

    private static void swap(int[] input, int a, int b) {
        System.out.println("Swapping=" + input[a] + " -> " + input[b]);
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
        return;
    }

}
