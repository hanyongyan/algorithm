package 平常练习.已完成;

public class _209长度最小的子数组 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(15, new int[] { 2, 14 }));
    }

    /*
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组
     * ，并返回其长度。如果不存在符合条件的子数组，返回 0 。\
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int res = len;
        int pre = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (sum >= target) {
                while (sum >= target) {
                    sum -= nums[pre];
                    pre++;
                }
                res = Math.min(res, i - pre + 2);
            }
        }
        // 防止出现所有的数加起来以后小于 target
        if (res == len && pre == 0) {
            return 0;
        }
        // 防止出现所有的数相加大于 target 减去第一个数又小于 target 的情况
        // 比如 target = 15，nums[2, 14]
        if (res == len && sum == target - nums[0]) {
            return res;
        }
        return res;
    }
}
