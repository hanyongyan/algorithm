package 平常练习.已完成;

import java.util.Arrays;

public class _220存在重复元素3 {
    public static void main(String[] args) {
        System.out.println(Math.abs((long)-2147483648-2147483647));
        // System.out.println(containsNearbyAlmostDuplicate(new int[] { -2147483648, 2147483647}, 1, 1));
    }

    /*
     * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <=
     * t ，同时又满足 abs(i - j) <= k 。
     * 
     * 如果存在则返回 true，不存在返回 false。
     * 
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(nums[i] - nums[j]) <= t && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
