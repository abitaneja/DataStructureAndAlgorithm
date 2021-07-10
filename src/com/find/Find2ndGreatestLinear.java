package com.find;
/**
 Find the second greatest in a array
 -  time complexity O(N)
 -  gives correct result with duplicate values
 */

public class Find2ndGreatestLinear {
    public static void main(String[] args) {
        int[] input_array = {22,22, 1, 5, 3, 9, 21, 4, 22};
        int secondGreatest = find2ndGreatest(input_array);
        System.out.printf("2nd Greatest is=%d",secondGreatest );
        System.out.print("\n");

    }

    private static int find2ndGreatest(int[] input_array) {
        int first, second;
        first = second = Integer.MIN_VALUE;
        for (int i = 0; i < input_array.length - 1; i++) {
            int current = input_array[i];
            if (current > first) {
                second = first;
                first = current;
            } else if (current != first && current > second) {
                second = current;
            }
        }
        return second;
    }
}
