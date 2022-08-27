package 平常练习.已完成;

import java.util.Arrays;

public class _268丢失的数字 {
    public static void main(String[] args) {

    }

    /*
     * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     */
    public static int missingNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = nums[0];
        if (nums[len - 1] != len) {
            return len;
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] != res + 1) {
                return res + 1;
            }
            res++;
        }
        return 0;
    }
}
