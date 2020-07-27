// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets
// in the array which gives the sum of zero.

// Note: The solution set must not contain duplicate triplets.

// For example, given array S = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

package com.example.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -1};
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int total = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[j] + nums[k] == total) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k - 1]) {
                        k++;
                    }
                } else if (nums[j] + nums[k] > total) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        System.out.println(result);
    }
}
