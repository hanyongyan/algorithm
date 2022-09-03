package 动态规划.已完成的动态规划;

import java.util.Arrays;

public class _279完全平方数 {
    public static void main(String[] args) {
        System.out.println(numSquares(9));
    }
    /*
     * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
     * 
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是
     */

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        int min;
        for (int i = 1; i < n + 1; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
