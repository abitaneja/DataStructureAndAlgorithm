package com.find;

/**
 * This algorithm is not efficient as well as not correct.
 * why because if greatest element occurred more
 * than one time then it will fail to find the 2nd greatest
 * which I tried to attain here.
 *
 * Time complexity :- O(N) but it is running twice the loop => 2N traversal
 */

public class FindGreatestLinear2N {
    public static void main(String[] args) {
        int[] input_array = {22,1, 5, 3, 9, 21, 4,22};
        findGreatest(input_array);
        System.out.printf("1st Greatest is=%d", input_array[input_array.length-1]);
        System.out.print("\n");
        System.out.printf("2nd Greatest is=%d", input_array[input_array.length-2]);
    }

    private static void findGreatest(int[] input_array) {
        int pass = 1;
        int count=0;
        while (pass <= 2) {
            for (int i = 0; i < input_array.length - pass; i++) {
                count+=1;
                if (input_array[i] > input_array[i + 1]) {
                    swap(i, i + 1, input_array);
                }
            }
            pass += 1;
        }
        System.out.println("counter="+count);
        return;
    }

    private static void swap(int i, int i1, int[] input_array) {
        int temp = input_array[i];
        input_array[i] = input_array[i1];
        input_array[i1] = temp;
    }
}
