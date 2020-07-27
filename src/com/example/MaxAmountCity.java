package com.example;

public class MaxAmountCity {

    public static void main(String[] args) {
        int[] priceList = {10, 10, 10, 10, 10, 10};
        System.out.println(calculateAmount(priceList));
    }

    public static int calculateAmount(int[] priceList) {
        if (priceList.length == 0) {
            return 0;
        }
        if (priceList.length == 1) {
            return priceList[0];
        }
        if (priceList.length == 2) {
            return priceList[0] + priceList[1];
        }

        int[] dp = new int[priceList.length];
        dp[0] = priceList[0];
        dp[1] = priceList[1] + dp[0];

        for (int i = 2; i < priceList.length; i ++) {
            dp[i] = Math.max(dp[i-1] + priceList[i], dp[i-2] + priceList[i]);
        }

        return dp[priceList.length - 1];
    }
}
