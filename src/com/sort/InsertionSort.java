package com.sort;

import java.util.Arrays;

/**
 * Both Bubble sort and Selection sort have O(N square) complexity,
 * but Selection sort is twice fast than bubble sort.
 * Time complexity:-
 *  comparison=(N square)/2 + shifts=(N square)/2 + insertion=N-1 + deletion=N-1
 * <b>Worst case</b>:- when data is in descending order {4,3,2,1} then
 *      (Comparison=6)+(shift=6)+(insert=3)+(delete=3)=18 steps
 * <b>Best case</b>:- when data is in ascending order {1,2,3,4} then
 *      (Comparison=3)+(shift=0)+(insert=3)+(delete=3)=9 steps
 * <b>Average case</b>:- when data is {1,3,4,2} then
 *       (Comparison=5)+(shift=2)+(insert=3)+(delete=3)=13 steps
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {1,3,4,2}; //normal or Average case
        //int[] array = {4,3,2,1}; //worst case scenario coma
        //int[] array = {1, 2, 3, 4}; //base case scenario
        sortBag(array);
    }

    private static void sortBag(int[] array) {
        int comparisons = 0;
        int shifts = 0;

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int emptySpot = i;
            for (int j = i - 1; j >= 0; j--) {
                comparisons += 1;
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                    emptySpot = j;
                    shifts += 1;
                } else {
                    break;
                }
            }
            array[emptySpot] = temp;
            printArray(i, array);
        }
        System.out.println("Total comparisons=" + comparisons);
        System.out.println("Total Shifts=" + shifts);
        return;
    }

    private static void printArray(int pass_through, int[] input_array) {
        System.out.print("Insertion Sort pass-through=" + pass_through + "->" +
                "");
        Arrays.stream(input_array).forEach(val -> {
            System.out.print(val + " ");
        });
        System.out.println();
    }

}
