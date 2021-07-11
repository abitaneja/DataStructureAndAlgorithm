package com.sort;

import java.util.Arrays;


/**
 * Check each cell of the array from left to right to determine which value is least
 * we determine the index of least value starting from index 0 and then replace with least value
 * Time complexity O(N square)
 *
 * -----------------------------------------------------
 * |N elements|Max # steps in Bubble Sort|Max # of steps in Selection sort|
 * |5|20 (10 comparison + 10 swaps)|14 (10 comparison + 4 swaps)|
 * |10|90 (45 comparison + 45 swaps)|54 (45 comparison + 9 swaps)|
 * |20|380 (190 comparison + 190 swaps)|209 (190 comparison+19 swaps)|
 * |40|1560( 780 comparison + 780 swaps)|819 (780 comparisons+39 swaps)|
 *
 * from this comparison, it's clear that Selection sort takes about half the number of steps Bubble sort does,
 * indicating that Selection Sort is twice as fast;
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] input_array = {4,2,7,1,3};
        //int[] input_array = {10, 14, 27, 33, 35, 19, 42, 44};
        sortBag(input_array);
    }

    private static void sortBag(int[] array) {
        int comparisons=0;
        for (int i = 0; i < array.length - 1; i++) {
            int lowestNumberIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                comparisons+=1;
                if (array[j] < array[lowestNumberIndex]) {
                    lowestNumberIndex = j;
                }
            }
            if (i != lowestNumberIndex) {
                swap(i, lowestNumberIndex, array);
            }
            printArray(i,array);
        }
        System.out.println("Total comparisons="+comparisons);
        return;
    }

    private static void printArray(int pass_through, int[] input_array) {
        System.out.print("At pass-through=" + pass_through + "->" +
                "");
        Arrays.stream(input_array).forEach(val -> {
            System.out.print(val + " ");
        });
        System.out.println();
    }

    private static void swap(int i, int nextLowest, int[] input_array) {
        int temp = input_array[i];
        input_array[i] = input_array[nextLowest];
        input_array[nextLowest] = temp;
    }

}
