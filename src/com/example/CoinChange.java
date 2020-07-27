//You are given coins of different denominations and a total amount of money amount. Write a function to compute the
// fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
// combination of the coins, return -1.

//Example 1:
//coins = [1, 2, 5], amount = 11
//return 3 (11 = 5 + 5 + 1)

//Example 2:
//coins = [2], amount = 3
//return -1.

//Note:
//You may assume that you have an infinite number of each kind of coin.

package com.example;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChangeAlternative(new int[]{1, 2, 5}, 11));
    }

    /**
     * coins = [1, 2, 5]
     * amount = 11
     *
     *       0   1   2   3   4  5   6   7   8   9   10  11
     * dp = [0, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]
     *
     * i = 0
     *
     * j = 0
     *
     * coins[j] <= i
     * dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]])
     *
     * coins[0] <= 0
     * 1 <= 0 false
     * break
     *
     * j = 1
     * break
     *
     * j = 2
     * break;
     *
     * i = 1
     *
     * j = 0
     *
     * 1 <= 1 true
     * dp[i - coins[j]] => dp[0]
     * dp[1] = min(12, 1) = 1
     *
     *       0   1   2   3   4  5   6   7   8   9   10  11
     * dp = [0,  1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]
     *
     * j = 1
     *
     * 2 <= 1 false
     * break
     *
     * j = 2
     * break
     *
     * i = 2
     *
     * j = 0
     *
     * 1 <= 2 true
     * dp[2 - 1] => dp[1] = 1
     * dp[2] = min(12, 1 + 1) = 2
     *
     *       0  1  2   3   4  5   6   7   8   9   10  11
     * dp = [0, 1, 2, 12, 12, 12, 12, 12, 12, 12, 12, 12]
     *
     * j = 1
     *
     * 2 <= 2 true
     * dp[0] = 0
     * dp[2] = min(2, 1) = 1
     *
     *       0  1  2   3   4  5   6   7   8   9   10  11
     * dp = [0, 1, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12]
     *
     *
     * j = 2
     *
     * 5 <= 2 break
     *
     * i = 3
     *
     * j = 0
     *
     * 1 <= 3 true
     * dp[2] = 1
     * dp[3] = min(12, 2) = 2
     *
     *       0  1  2  3   4  5   6   7   8   9   10  11
     * dp = [0, 1, 1, 2, 12, 12, 12, 12, 12, 12, 12, 12]
     *
     * j = 1
     *
     * 2 <= 3 true
     * dp[1] = 1
     * dp[3] = min(2, 2) = 2
     *
     * j = 2
     *
     * 5 <= 3 false break
     *
     * i = 4
     *
     * j = 0
     *
     * 1 <= 4 true
     * dp[3] = 2
     * dp[4] = min(12, 1+2) = 2
     *
     *       0  1  2  3  4  5   6   7   8   9   10  11
     * dp = [0, 1, 1, 2, 2, 12, 12, 12, 12, 12, 12, 12]
     *
     * j = 1
     *
     * 2 <= 4 true
     *
     * j = 2
     *
     * 5 <= 4 false break
     *
     * i = 5
     *
     * j = 0
     *
     * 1 <= 5 true
     *
     * j = 1
     *
     * 2 <= 5 true
     *
     * j = 2
     *
     * 5 <= 5 true
     *
     * i = 6
     *
     * j = 0
     *
     * 1 <= 6 true
     *
     * j = 1
     *
     * 2 <= 6 true
     *
     * j = 2
     *
     * 5 <= 6 true
     *
     * i = 7
     *
     * j = 0
     *
     * 1 <= 7 true
     *
     * j = 1
     *
     * 2 <= 7 true
     *
     * j = 2
     *
     * 5 <= 7 true
     *
     * i = 8
     *
     * j = 0
     *
     * 1 <= 8 true
     *
     * j = 1
     *
     * 2 <= 8 true
     *
     * j = 2
     *
     * 5 <= 8 true
     *
     * i = 9
     *
     * j = 0
     *
     * 1 <= 9 true
     *
     * j = 1
     *
     * 2 <= 9 true
     *
     * j = 2
     *
     * 5 <= 9 true
     *
     * i = 10
     *
     * j = 0
     *
     * 1 <= 10 true
     *
     * j = 1
     *
     * 2 <= 10 true
     *
     * j = 2
     *
     * 5 <= 10 true
     *
     * i = 11
     *
     * j = 0
     *
     * 1 <= 11 true
     *
     * j = 1
     *
     * 2 <= 11 true
     *
     * j = 2
     *
     * 5 <= 11 true
     *
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int count(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                } else {
                    break;
                }
            }
        }

        return dp[amount] > amount ? - 1 : dp[amount];
    }

    public static int coinChangeAlternative(int[] coins, int amount) {
        if(amount < 1) {
            return 0;
        }

        return coinChangeRecursive(coins, amount, new int[amount]);
    }

    public static int coinChangeRecursive(int[] coins, int amount, int[] dp) {
        if(amount < 0) {
            return -1;
        }
        if(amount == 0) {
            return 0;
        }
        if(dp[amount - 1] != 0) {
            return dp[amount - 1];
        }

        int min = Integer.MAX_VALUE;
        for(int coin: coins) {
            int result = coinChangeRecursive(coins, amount - coin, dp);
            if(result >= 0 && result < min) {
                min = 1 + result;
            }
        }

        dp[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[amount - 1];
    }
}
