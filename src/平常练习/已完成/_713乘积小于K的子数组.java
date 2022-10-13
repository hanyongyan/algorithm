package 平常练习.已完成;

public class _713乘积小于K的子数组 {
    public static void main(String[] args) {

    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        int index = 0;
        int res = 0;
        int pro = 1;
        for (int i = 0; i < len; i++) {
            pro *= nums[i];
            while (pro >= k && index < i) {
                pro /= nums[index];
                index++;
            }
            res += i - index + 1;
        }
        return res;
    }
}
