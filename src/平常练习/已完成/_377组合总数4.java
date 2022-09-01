package 平常练习.已完成;

public class _377组合总数4 {
    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1,2,3}, 4));
    }

    /*
     * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
     * 
     * 题目数据保证答案符合 32 位整数范围。
     * 
     */
    public static int combinationSum4(int[] nums, int target) {
        //dp[i] 代表目标金额为 i 的组合个数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 目标金额从 1...target 
        for (int currN = 1; currN <= target; currN++) {
            for (int N : nums) {
                int leftN = currN - N;
                if (leftN < 0)
                    continue;
                // 如果 leftN 不小于 0 dp[currN] 就等于 dp[leftN] 的总和
                dp[currN] += dp[leftN];
            }
        }
        return dp[target];
    }
}
