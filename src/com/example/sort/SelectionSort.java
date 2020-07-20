/**
 * Selection sort is best understood by imagining that you have two lists, A and B.
 * Initially, we have list A, containing all the unsorted elements, and list B is empty.
 * The idea is to use B to store the sorted elements. The algorithm would work by finding the smallest element from A and
 * moving it to the end of B. We keep on doing this until A is empty and B is full. Instead of using two separate lists,
 * we can just use the same input array, but keeping a pointer to divide the array in two.
 *
 * In real life, this can be explained by picturing how you would sort a deck of cards.
 * Using a shuffled deck, you can go through the cards one by one until you find the lowest card.
 * You set this aside as a new, second pile. You then look for the next-lowest card and once found,
 * you put it at the bottom of the second pile. You repeat this until the first pile is empty.
 *
 * One way to arrive at the solution is to first write the pseudocode that uses two arrays
 * (A and B, in the preceding description). Then, adopt the pseudocode to store the sorted list (array B) in the same
 * input array by using the swapping method.
 *
 * Selection sorting is a combination of both searching and sorting.
 * The algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
 * from the unsorted part and putting it at a proper position in the array.
 *
 * the number of times the sort passes through the array is one less than the number of items in the array.
 * The inner loop finds the next smallest value and the outer loop places that value into its proper location.
 * Selection sort never makes more than O(n) swaps and can be useful when the memory write is a costly operation.
 * Time Complexity: O(n 2) as there are two nested loops.
 *
 * Auxiliary Space: O(1).
 */
package com.example.sort;

import com.example.Util;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] data = Util.getUnSortedData();
        sort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPtr = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minPtr]) minPtr = j;
            }
            Util.swap(array, minPtr, i);
        }
    }
}
