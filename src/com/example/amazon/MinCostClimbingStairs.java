//On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
//
//Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor,
// and you can either start from the step with index 0, or the step with index 1.
//
//Example 1:
//Input: cost = [10, 15, 20]
//Output: 15
//Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
//Example 2:
//Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//Output: 6
//Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
//Note:
//cost will have a length in the range [2, 1000].
//Every cost[i] will be an integer in the range [0, 999].

package com.example.amazon;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        System.out.println(findCost(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public static int findCost(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        if (input.length == 1) {
            return input[0];
        }
        if (input.length == 2) {
            return Math.min(input[0], input[1]);
        }

        int[] dp = new int[input.length];
        dp[0] = input[0];
        dp[1] = input[1];

        for (int i = 2; i < input.length; i++) {
            dp[i] = Math.min(dp[i - 1] + input[i], dp[i - 2] + input[i]);
        }
        return Math.min(dp[input.length - 1], dp[input.length - 2]);
    }
}
