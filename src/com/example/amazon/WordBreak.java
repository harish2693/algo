// Given a non-empty string s and a dictionary word Dict containing a list of non-empty words, determine if s can be
// segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not
// contain duplicate words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".

package com.example.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        String input = "leetcode";
        Set<String> dict = new HashSet<>(Arrays.asList("leet", "code"));
        System.out.println(wordBreak(input, dict));
    }

    /**
     * input = leetcode
     * dict = [leet, code]
     * dp
     * 0 1 2 3 4 5 6 7 8
     * t f f f f f f f f
     *
     * i = 1
     *
     * j = 0
     * dp[0] = true
     * s.substring(0, 1) = l
     * 0 1 2 3 4 5 6 7 8
     * t
     *
     * i = 2
     *
     * 0 1 2 3 4 5 6 7 8
     * t f f f f f f f f
     *
     * j = 0
     * dp[0] = true
     * s.substring(0, 2) = le
     *
     * j = 1
     * dp[1] = false
     *
     * i = 3
     *
     * 0 1 2 3 4 5 6 7 8
     * t f f f f f f f f
     *
     * j = 0
     * dp[0] = true
     * s.substring(0, 3) = lee
     *
     * j = 1
     * dp[1] = false
     *
     * j = 2
     * dp[2] = false
     *
     * i = 4
     *
     * 0 1 2 3 4 5 6 7 8
     * t f f f f f f f f
     *
     * j = 0
     * dp[0] = true
     * s.substring(0, 4) = leet
     * dict.contains(leet) = true
     * dp[4] = true
     *
     * 0 1 2 3 4 5 6 7 8
     * t f f f t f f f f
     *
     * break
     *
     * j = 1
     * break
     *
     * j = 2
     * break
     *
     * j = 3
     * break
     *
     * i = 5
     *
     * 0 1 2 3 4 5 6 7 8
     * t f f f t f f f f
     *
     * j = 0
     * dp[0] = true
     * s.substring(0, 5) = leetc
     * dict.contains(leetc) = false
     *
     * j = 1
     * dp[1] = false
     *
     * j = 2
     * dp[2] = false
     *
     * j = 3
     * dp[3] = false
     *
     * j = 4
     * dp[4] = true
     * s.substring(4, 5) = c
     * dict.contains = false
     *
     *
     * i = 6
     *
     * 0 1 2 3 4 5 6 7 8
     * t f f f t f f f f
     *
     * j = 0
     * dp[0] = true
     * s.substring(0, 6) = leetco
     * dict.contains = false
     *
     * j = 1
     * dp[1] = false
     * s.substring(1, 6) = eetco
     * dict.contains = false
     *
     * j = 2
     * dp[2] = false
     * s.substring(2, 6) = etco
     * dict.contains = false
     *
     * j = 3
     * dp[3] = false
     * s.substring(3, 6) = tco
     * dict.contains = false
     *
     * j = 4
     * dp[4] = true
     * s.substring(4, 6) = co
     * dict.contains = false
     *
     * j = 5
     * dp[5] = false
     * s.substring(5, 6) = o
     * dict.contains = false
     *
     * i = 7
     *
     * 0 1 2 3 4 5 6 7 8
     * t f f f t f f f f
     *
     * j = 0
     *
     * dp[0] = true
     * s.substring(0, 7) = leetcod
     * dict.contains = false
     *
     * j = 1
     *
     * dp[1] = false
     * s.substring(1, 7) = eetcod
     * dict.contains = false
     *
     * j = 2
     *
     * dp[2] = false
     * s.substring(2, 7) = etcod
     * dict.contains = false
     *
     * j = 3
     *
     * dp[3] = false
     * s.substring(3, 7) = tcod
     * dict.contains = false
     *
     * j = 4
     *
     * dp[4] = true
     * s.substring(4, 7) = cod
     * dict.contains = false
     *
     * j = 5
     *
     * dp[5] = false
     * s.substring(5, 7) = od
     * dict.contains = false
     *
     * j = 6
     *
     * dp[6] = false
     * s.substring(6, 7) = d
     * dict.contains = false
     *
     * i = 8
     *
     * 0 1 2 3 4 5 6 7 8
     * t f f f t f f f f
     *
     * j = 0
     *
     * dp[0] = true
     * s.substring(0, 8) = leetcode
     * dict.contains = false
     *
     * j = 1
     *
     * dp[1] = false
     * s.substring(1, 8) = eetcode
     * dict.contains = false
     *
     * j = 2
     *
     * dp[2] = false
     * s.substring(2, 8) = etcode
     * dict.contains = false
     *
     * j = 3
     *
     * dp[3] = false
     * s.substring(3, 8) = tcode
     * dict.contains = false
     *
     * j = 4
     *
     * dp[4] = true
     * s.substring(4, 8) = code
     * dict.contains = true
     * 0 1 2 3 4 5 6 7 8
     * t f f f t f f f t
     * break
     *
     * j = 5
     *
     * dp[5] = false
     * break
     *
     * j = 6
     *
     * dp[6] = false
     * break
     *
     * j = 7
     *
     * dp[7] = false
     * break
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
