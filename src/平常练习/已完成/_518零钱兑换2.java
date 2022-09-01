package 平常练习.已完成;

import java.util.Arrays;

public class _518零钱兑换2 {
    public static void main(String[] args) {
        System.out.println(change(5, new int[] { 1, 2, 5 }));
    }

    /*
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     * 
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     * 
     * 假设每一种面额的硬币有无限个。 
     * 
     * 题目数据保证结果符合 32 位带符号整数。
     */
    public static int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 第一次循环只使用第一个硬币 查看能否组成 i 金额
        // 第二次循环使用第一个和第二个硬币 查看是否能够组成 i 金额
        // ...
        // 如看不懂 debug 一次
        for (int coin : coins) {
        for (int i = coin; i <= amount; i++) {
        dp[i] += dp[i - coin];
        }
        }
        return dp[amount];

        // int[] dp = new int[amount + 1];
        // dp[0] = 1;
        // // currAmount代表当前的金额，
        // for (int currAmount = 1; currAmount <= amount; currAmount++) {
        //     for (int coin : coins) {
        //         // 说明从 leftAmount 金额选择 coin 就能够到达 currAmount 金额
        //         int leftAmount = currAmount - coin;
        //         if (leftAmount < 0 || leftAmount == Integer.MAX_VALUE)
        //             continue;
        //         dp[currAmount] += dp[leftAmount];
        //     }
        // }
        // return dp[amount];
    }
}
