/**
 * 1) Select a pivot
 * 2) Partition the list so that elements on the left of the pivot are less than the value of the pivot and the ones on
 * the right are greater
 * 3) Repeat steps 1 and 2 on the left and right parts separately
 *
 * Partitioning is the process by which we reorder our array so that elements with a value less than our pivot are moved
 * to the left of the pivot and those with a larger value are moved to the right. There are numerous manners in which we can do this.
 * Here, we will describe an easy-to-understand scheme known as Lomuto Partitioning.
 *
 * Many other schemes exist. The Lomuto scheme has the drawback that it is not very performant when it is used on already-sorted lists.
 * The original Hoare partition scheme performs better and works by having the array processed from both ends.The original Hoare
 * scheme performs better as it does fewer swaps, although it also suffers from slow performance when a sorted list is used as input.
 * Both the Lomuto and Hoare schemes result in non-stable sorting. A stable sort means that if two or more elements have the same key
 * value, they will appear in the same input order as the sorted output. There are other schemes that can be used to make quick sort
 * stable, but they utilize more memory.
 *
 * 1) Pick the right most element of the array as the pivot.
 * 2) Start from the left and find the next element that is larger than the pivot.
 * 3) Swap this element with the next, which is smaller than pivot element.
 * 4) Repeat steps 2 and 3 until no more swapping is possible.
 * 5) Swap the first item which is larger than the pivot's value with the pivot itself.
 *
 * To perform efficient partitioning using the steps mentioned, we can make use of two pointers, one pointing to the first
 * item larger than the pivot value and the other used to search for the value that is smaller than pivot value.
 *
 * The algorithm starts by choosing the pivot as the last item on the input array. It then processes the array from left
 * to right in a single pass using the variable i. If the element currently being processed at i is smaller than the pivot,
 * x is incremented and swapped. Using this technique, variable x is either pointing to a value larger than the pivot or the value
 * of x is the same as i, in which case swapping will not modify the array. Once the loop exits, we perform the final step of
 * swapping the first item that is larger than the pivot's value with the pivot.
 *
 * The quick sort is from a class of algorithms called divide and conquer. It's important to know that divide and conquer
 * algorithms keep on splitting the problem into smaller ones until the problem is small enough that it becomes trivial to solve.
 * This splitting can be easily implemented using recursion.
 *
 * In quick sorting, we keep on recursively partitioning the array in this manner until the problem is small enough
 * that we can easily solve it. When the array has only one element, the solution is simple: the array stays exactly as it is,
 * as there is nothing to sort. This is the stopping condition of our recursive algorithm. When the array is larger than one element,
 * we can keep dividing our array and use the partitioning method we developed in the previous section.
 *
 * There is also a non-recursive quick sort algorithm which makes use of a stack data structure, although it is a bit more complex to write.
 *
 * The trick to understanding how quick sort works is to realize that once we perform the partition call on the array,
 * the element at the returned position (the pivot) doesn't need to move within the array anymore. This is because all the
 * elements on its right are larger and the ones on the left are smaller, so the pivot is in the correct final position.
 *
 * Quicksort algorithm is a fast, recursive, non-stable sort algorithm which works by the divide and conquers principle.
 * It picks an element as pivot and partitions the given array around that picked pivot.
 *
 * 1) Pick a suitable “pivot point”.
 * 2) Divide the lists into two lists based on this pivot element. Every element which is smaller than the pivot element
 * is placed in the left list and every element which is larger is placed in the right list. If an element is equal to the
 * pivot element then it can go in any list. This is called the partition operation.
 * 3) Recursively sort each of the smaller lists.
 *
 * The complexity of quicksort in the average case is Θ(n log(n)) and in the worst case is Θ(n2).
 */

package com.example.sort;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] numbers) {
        sort(numbers, 0, numbers.length - 1);
    }

    private void sort(int[] numbers, int start, int end) {
        if (start < end) {
            int p = partition(numbers, start, end);
            sort(numbers, start, p - 1);
            sort(numbers, p + 1, end);
        }
    }

    private int partition(int[] numbers, int start, int end) {
        int pivot = numbers[end];
        int x = start - 1;
        for (int i = start; i < end; i++) {
            if (numbers[i] < pivot) {
                x++;
                swap(numbers, x, i);
            }
        }
        swap(numbers, x + 1, end);
        return x + 1;
    }

    private void swap(int[] numbers, int j, int k) {
        int temp = numbers[j];
        numbers[j] = numbers[k];
        numbers[k] = temp;
    }


    public static void main(String args[]) {
        QuickSort quickSort = new QuickSort();
        int[] numbers = new int[]{2, 5, 7, 2, 4, 2, 8, 1, 0, 9, 3, 6};
        quickSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
