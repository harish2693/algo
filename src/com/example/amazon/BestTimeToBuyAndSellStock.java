// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design
// an algorithm to find the maximum profit.

// Example 1:
// Input: [7, 1, 5, 3, 6, 4]
// Output: 5

// max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
// Example 2:
// Input: [7, 6, 4, 3, 1]
// Output: 0

// In this case, no transaction is done, i.e. max profit = 0.

package com.example.amazon;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        //int[] input = {7, 6, 4, 3, 1};

        int profit = 0;
        if (input.length > 0) {
            int max = 0;
            int min = input[0];

            for (int i = 1; i < input.length; i++) {
                if (input[i] > min) {
                    max = Math.max(max, input[i] - min);
                } else {
                    min = input[i];
                }
            }

            profit = max;
        }
        System.out.println(profit);
    }
}
