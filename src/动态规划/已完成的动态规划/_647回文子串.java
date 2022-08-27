package 动态规划.已完成的动态规划;

import java.util.List;

public class _647回文子串 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }

    /*
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     * 
     * 回文字符串 是正着读和倒过来读一样的字符串。
     * 
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     * 
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。、
     */
    public static int countSubstrings(String s) {
        int n = s.length();
        int res = n;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < dp.length - 1; i++) {
            //i...i肯定是回文串
            dp[i][i] = true;
            //i...i + 1需要判断两者是否相等
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) {
                res++;
            }
        }
        dp[n - 1][n - 1] = true;
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < dp.length; j++) {
                //i...j是不是回文串需要这样判断
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                if (dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }

}
