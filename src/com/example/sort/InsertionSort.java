/**
 * Insertion Sort is a simple sorting algorithm which iterates through the list by consuming one input element at a time
 * and builds the final sorted array. It is very simple and more effective on smaller data sets.
 * It is stable and in-place sorting technique.
 * <p>
 * Insertion sort is a simple sorting algorithm that allows for efficient, in-place sorting of the array, one element at a time.
 * By in-place sorting, we mean that the original array is modified and no temporary structures are needed.
 * <p>
 * Best Case: The best case is when input is an array that is already sorted.
 * In this case insertion sort has a linear running time (i.e., Θ(n)).
 * <p>
 * Worst Case: The simplest worst case input is an array sorted in reverse order O(n2).
 * https://www.educative.io/edpresso/what-is-insertion-sort-in-java
 *
 * 1) The first step is to create a method that takes in input the array to be sorted.
 *
 * 2) The second step is to create an outer for loop which will iterate over each element of the array.
 *
 * 3) The third step is to create a separate iterator, j which will check for the ascending order of elements in the list.
 *
 * 4) The fourth step is the inner while loop:
 *
 *    a) The while loop must satisfy two conditions: the value of j must be greater than 0, and the value at index j-1,
 *    must be greater than the value at index j.
 *    b) If this condition holds true then, the key is set to the value at index j.
 *    c) Then the values at j and j-1 are swapped.
 *    d) The value of j is reduced by 1 and the loop continues till one of the conditions breaks.
 *
 * 5)This continues for every iteration of the outer for loop till that also breaks.
 */

package com.example.sort;

import com.example.Util;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] data = Util.getUnSortedData();
        sort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void sort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }
    }
}
