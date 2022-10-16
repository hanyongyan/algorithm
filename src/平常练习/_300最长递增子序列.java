package 平常练习;

import java.util.Arrays;

public class _300最长递增子序列 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < len; i++) {
     
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] =Math.max(dp[i], dp[j] + 1) ;
                    }
                }
            
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
