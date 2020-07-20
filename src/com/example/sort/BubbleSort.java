/**
 * All sorting algorithms accept a list of elements and return them ordered. The main difference between each algorithm
 * is the manner in which the sorting is done. Bubble sorting works by swapping adjacent elements. This pushes the sorted
 * elements toward the end of the list.
 *
 * Snippet 2.1 shows the pseudocode for bubble sort. The algorithm involves three simple tasks, which involves repeatedly
 * stepping through the list to sort, comparing adjacent elements, and swapping them around if the first element is bigger
 * than the second.
 *
 * How many passes do we need to perform on the array until our list is sorted? It turns out that to guarantee that our
 * list is sorted, we need to do (n - 1) passes on the list, n being the length of our array. We will show why (n - 1)
 * passes are needed in the next section, but this is the main reason why bubble sort has a runtime complexity of O(n2),
 * since we're processing n elements for n - 1 times.
 *
 * Worst and Average Case Time Complexity:
 *
 * O(n*n). The worst-case occurs when an array is reverse sorted.
 *
 * Best Case Time Complexity:
 *
 * O(n). Best case occurs when an array is already sorted.
 *
 * Also called sinking sort
 */
package com.example.sort;

import com.example.Util;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] data = Util.getSortedData();
        sortImprovement2(data);
        System.out.println(Arrays.toString(data));
    }

    public static void sort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    Util.swap(numbers, j, j+1);
                }
            }
        }
    }

    public static void sortImprovement(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    Util.swap(numbers, j, j+1);
                }
            }
        }
    }

    public static void sortImprovement2(int[] numbers) {
        int i = 0;
        boolean swapOccurred = true;
        while (swapOccurred) {
            swapOccurred = false;
            i++;
            for (int j = 0; j < numbers.length - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    Util.swap(numbers, j, j + 1);
                    swapOccurred = true;
                }
            }
        }
    }

}
