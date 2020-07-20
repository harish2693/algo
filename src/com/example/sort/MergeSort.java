/**
 *
 * Although the quicksort on average is pretty fast, it still has the theoretical worst time complexity of O(n²).
 * In this section, we shall examine another sorting algorithm, called merge sort, in which the worst time complexity is O(n log n).
 * Similar to quick sort, merge sort belongs to the divide and conquer class of algorithms.
 *
 * Merge sort can be summarized in three simple steps as follows:
 *
 * 1) Split the array in the middle
 * 2) Recursively sort each part separately
 * 3) Merge the two sorted parts together
 *
 * Although merge sort is theoretically faster than quick sort, in practice, some implementations of quick sort can be more
 * efficient than merge sort. Additionally, the merge sort uses about O(n) memory as opposed to quick sort, which is O(log n).
 *
 * The merge sort algorithm is a divide and conquers algorithm. In the divide and conquer paradigm, a problem is broken
 * into smaller problems where each small problem still retains all the properties of the larger problem -- except its size.
 * To solve the original problem, each piece is solved individually; then the pieces are merged back together.
 * Time Complexity of the mergesort algorithm is the same in the best, average and worst-case and it's equal to O(n*log(n))
 *
 * quicksort is unstable but merge sort is a stable sorting algorithm
 *
 * The merge sort algorithm is from the same class of algorithms as quick sort; however, its runtime and space complexity
 * are different. Instead of dividing the array from the pivot's position, the merge sort always partitions the array at the midpoint.
 * This is a similar process to binary search and results in log2 n array divisions.
 *
 * Merge sort is theoretically one of the fastest sorting algorithms. The drawback of its speed is that it consumes a
 * bit more memory, although some implementations exist that perform the merge step in place to save memory.
 *
 * Mergesort is a fast, recursive, stable sort algorithm which also works by the divide and conquer principle. Similar to
 * quicksort, merge sort divides the list of elements into two lists. These lists are sorted independently and then combined.
 * During the combination of the lists, the elements are inserted (or merged) at the right place in the list.
 *
 * The algorithm has a complexity of O(n log (n)) and has a wide range of applications.
 */

package com.example.sort;

import com.example.Util;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] data = Util.getUnSortedData();
        mergeSort(data);
        System.out.println(Arrays.toString(data));
    }

    private static void merge(int[] array, int start, int middle, int end) {
        int i = start;
        int j = middle + 1;
        int[] arrayTemp = new int[end - start + 1];
        for (int k = 0; k < arrayTemp.length; k++) {
            if (i <= middle && (j > end || array[i] <= array[j])) {
                arrayTemp[k] = array[i];
                i++;
            } else {
                arrayTemp[k] = array[j];
                j++;
            }
        }
        System.arraycopy(arrayTemp, 0, array, start, arrayTemp.length);
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (end - start) / 2 + start;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }
}
