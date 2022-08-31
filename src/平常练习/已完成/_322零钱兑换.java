package 平常练习.已完成;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _322零钱兑换 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[] { 2, 1, 5 }, 11));
    }

    /*
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * 
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * 
     * 你可以认为每种硬币的数量是无限的。
     */
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        // dp[i] i代表当前的金额，因为有0的存在所以数组大小为 amount+1
        // dp[i] 的值就代表构成i金额需要的最少的金币
        int[] dp = new int[amount + 1];
        // 对1到amount位置赋值为Integer.MAX_VALUE
        Arrays.fill(dp, 1, amount + 1, Integer.MAX_VALUE);
        for (int currAmount = 1; currAmount <= amount; currAmount++) {
            for (int coin : coins) {
                // dp[i]的最小值依赖前面的最小值
                int left = currAmount - coin;
                // 如果 left < 0，说明从left金额加上coin不能够到达currAmount金额
                // 如果 dp[left] == Integer.MAX_VALUE 说明left金额没有组成的方法
                if (left < 0 || dp[left] == Integer.MAX_VALUE) {
                    continue;
                }
                // 由于left + coin = currAmount ，故其取值就是 Math.min(dp[left] + 1, dp[currAmoun])；
                // 因为会重复计算，所以会有dp[currAmount],
                // 使用 dp[left] + 1 是因为dp[i]代表的就是构成i金额的最少的金币，且 left + coin 就是当前currAmount，故直接加1即可
                dp[currAmount] = Math.min(dp[left] + 1, dp[currAmount]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
