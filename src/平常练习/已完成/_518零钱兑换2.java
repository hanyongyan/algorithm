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
//当固定元素的时候，遍历背包的时候，dp 记录的是当前元素及以前的排列，不包含后面元素的排列，
        //例如在固定元素为 1 时，遍历结束背包容量的时候，dp 记录的是只有元素 1 的时候，
        //背包从空到满的排列方式。当元素为 2 的时候，dp[i-v] 如果成立， 实际上是先排列了 1 元素， 然后再排列了2。
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];

        //上面是组合
        //下面是排列


        // 下面这种方法会有重复计算
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
