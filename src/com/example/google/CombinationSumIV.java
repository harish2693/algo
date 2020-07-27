// Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that
// add up to a positive integer target.

// Example:

// nums = [1, 2, 3]
// target = 4

// The possible combination ways are:
// (1, 1, 1, 1)
// (1, 1, 2)
// (1, 2, 1)
// (1, 3)
// (2, 1, 1)
// (2, 2)
// (3, 1)

// Note that different sequences are counted as different combinations.

// Therefore the output is 7.

// Follow up:
// What if negative numbers are allowed in the given array?
// How does it change the problem?
// What limitation we need to add to the question to allow negative numbers?
package com.example.google;

import java.util.*;

public class CombinationSumIV {

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
    }

    /**
     *         0  1  2
     * nums = [1, 2, 3]
     * target = 4
     *
     * dp = [1, 0, 0, 0, 0]
     *
     * i = 1
     *
     * j = 0
     *
     * 1 - 0 >= 0 true
     *
     * dp[i] += dp[i - nums[j]]
     * dp[1] = 0 + 1
     *
     * j = 1
     *
     * 1 - 2 >= 0 false
     *
     * j = 2
     *
     * 1 - 3 >= 0 false
     *
     * dp = [1, 1, 0, 0, 0]
     *
     * i = 2
     *
     * j = 0
     *
     * 2 - 1 >= 0 true
     *
     * dp[i] += dp[i - nums[j]]
     * dp[2] = 0 + 1
     *
     * j = 1
     *
     * 2 - 2 >= 0 true
     * dp[i] += dp[i - nums[j]]
     * dp[2] = 1 + 1
     *
     * j = 2
     *
     * 2 - 2 >= 0 false
     *
     * dp[i] += dp[i - nums[j]]
     * dp[2] = 0 + 1
     *
     * dp = [1, 1, 0, 0, 0]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
