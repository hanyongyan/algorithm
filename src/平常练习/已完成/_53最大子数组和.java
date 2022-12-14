package 平常练习.已完成;

public class _53最大子数组和 {
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

	public static int maxSubArray(int[] nums) {
		int len = nums.length;
		// dp[i] 代表 i 位置的最大子数组和
		int[] dp = new int[len];
		// 最终结果
		int res = nums[0];
		dp[0] = nums[0];
		for (int i = 1; i < len; i++) {
			// 如果 dp[i - 1] 是负数，那么当前位置的最大子数组和肯定就是自身的和
			if (dp[i - 1] < 0) {
				dp[i] = nums[i];
			}
			// dp[i-1] 是正数，当前位置的最大和就继续相加
			else {
				dp[i] = dp[i - 1] + nums[i];
			}
			// 判断 res 是否进行更新
			res = res > dp[i] ? res : dp[i];
		}
		return res;
	}
}
