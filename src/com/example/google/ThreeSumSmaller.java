// Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that
// satisfy the condition nums[i] + nums[j] + nums[k] < target.

// For example, given nums = [-2, 0, 1, 3], and target = 2.

// Return 2. Because there are two triplets which sums are less than 2:

// [-2, 0, 1]
// [-2, 0, 3]

// Follow up:
// Could you solve it in O(n2) runtime?

package com.example.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSmaller {

    public static void main(String[] args) {
        System.out.println(threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }

    public static int threeSumSmaller(int[] input, int target) {
        int count = 0;

        Arrays.sort(input);

        for (int i = 0; i < input.length - 2; i++) {

            int j = i + 1;
            int k = input.length - 1;

            int outerValue = input[i];

            while (j < k) {
                // if the 3 indices add to less than the target increment count
                if (input[j] + input[k] + outerValue < target) {
                    //increment the count by the distance between left and right because the array is sorted
                    count += k - j;
                    j++;
                } else {
                    //if they sum to a value greater than target...
                    //decrement right pointer
                    k--;
                }
            }
        }

        return count;
    }
}
