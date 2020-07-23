package com.example;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubSequence("abcfd", "abcd"));
    }

    /**
     * a = "abcfd" b = "abcd"
     *      0  a(1) b(2) c(3) f(4) d(5)
     * 0    0   0    0    0    0    0
     * a(1) 0   0    0    0    0    0
     * b(2) 0   0    0    0    0    0
     * c(3) 0   0    0    0    0    0
     * d(4) 0   0    0    0    0    0
     *
     * i = 1
     *
     * j = 1
     *
     * input1.charAt(i - 1) == input2.charAt(j - 1)
     * input1.charAt(0) == input2.charAt(0)
     * a == a true
     * dp[i][j] = dp[i - 1][j - 1] + 1;
     * dp[1][1] = dp[0][0] + 1;
     *
     *      0  a(1) b(2) c(3) f(4) d(5)
     * 0    0   0    0    0    0    0
     * a(1) 0   1    0    0    0    0
     * b(2) 0   0    0    0    0    0
     * c(3) 0   0    0    0    0    0
     * d(4) 0   0    0    0    0    0
     *
     * j = 2
     *
     * input1.charAt(i - 1) == input2.charAt(j - 1)
     * input1.charAt(0) == input2.charAt(1)
     * a == b false
     * dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
     * dp[1][2] = max(dp[0][2], dp[1][1])
     * dp[1][2] = max(0, 1) = 1
     *
     *      0  a(1) b(2) c(3) f(4) d(5)
     * 0    0   0    0    0    0    0
     * a(1) 0   1    1    0    0    0
     * b(2) 0   0    0    0    0    0
     * c(3) 0   0    0    0    0    0
     * d(4) 0   0    0    0    0    0
     *
     * j = 3
     *
     * input1.charAt(i - 1) == input2.charAt(j - 1)
     * input1.charAt(0) == input2.charAt(2)
     * a == c false
     * dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
     * dp[1][2] = max(dp[0][2], dp[1][1])
     * dp[1][2] = max(0, 1) = 1
     *
     *      0  a(1) b(2) c(3) f(4) d(5)
     * 0    0   0    0    0    0    0
     * a(1) 0   1    1    0    0    0
     * b(2) 0   0    0    0    0    0
     * c(3) 0   0    0    0    0    0
     * d(4) 0   0    0    0    0    0
     *
     * j = 4
     *
     * i = 2
     *
     * j = 1
     *
     * j = 2
     *
     * j = 3
     *
     * j = 4
     *
     * i = 3
     *
     * j = 1
     *
     * j = 2
     *
     * j = 3
     *
     * j = 4
     *
     * i = 4
     *
     * j = 1
     *
     * j = 2
     *
     * j = 3
     *
     * j = 4
     *
     * i = 5
     *
     * j = 1
     *
     * j = 2
     *
     * j = 3
     *
     * j = 4
     *
     * @param input1
     * @param input2
     * @return
     */
    private static String longestCommonSubSequence(String input1, String input2) {
        int[][] dp = new int[input1.length() + 1][input2.length() + 1];

        for (int i = 1; i <= input1.length(); i++) {
            for (int j = 1; j <= input2.length(); j++) {
                if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = 0;
        int j = 0;

        StringBuilder builder = new StringBuilder();
        while (i < input1.length() && j < input2.length()) {
            if (input1.charAt(i) == input2.charAt(j)) {
                builder.append(input1.charAt(i));
                i++;
                j++;
            } else if (dp[i+1][j] >= dp[i][j+1]) {
                i++;
            } else {
                j++;
            }
        }
        return builder.toString();
    }
}
