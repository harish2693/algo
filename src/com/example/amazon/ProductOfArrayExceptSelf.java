// Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of
// all the elements of nums except nums[i].

// Solve it without division and in O(n).

// For example, given [1,2,3,4], return [24,12,8,6].

// Follow up:
// Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the
// purpose of space complexity analysis.)

package com.example.amazon;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    /**
     * [1, 2, 3, 4]
     *
     * n = 4
     * result = []
     * left = 1
     * right = 1
     *
     * left loop:-
     *
     * i=0
     * left = 1
     * result = [1]
     *
     * i=1
     * left = 1
     * result = [1, 1]
     *
     * i=2
     * left = 2
     * result = [1, 1, 2]
     *
     * i=3
     * left = 6
     * result = [1, 1, 2, 6]
     *
     * right loop:-
     *
     * i=3
     * right = 1
     * result = [1, 1, 2, 6]
     *
     * i=2
     * right = 4
     * result = [1, 1, 8, 6]
     *
     * i=1
     * right = 12
     * result = [1, 12, 8, 6]
     *
     * i=0
     * right = 24
     * result = [24, 12, 8, 6]
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 1;

        for(int i = 0; i < nums.length; i++) {
            if(i > 0) {
                left *= nums[i - 1];
            }

            result[i] = left;
        }

        int right = 1;

        for(int i = n - 1; i >= 0; i--) {
            if(i < n - 1) {
                right *= nums[i + 1];
            }

            result[i] *= right;
        }

        return result;
    }
}
