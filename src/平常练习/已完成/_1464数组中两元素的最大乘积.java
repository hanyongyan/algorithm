package 平常练习.已完成;

import java.util.Arrays;

public class _1464数组中两元素的最大乘积 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{4,6,2,6,9,2,6,77,99}));
        System.out.println(ways2(new int[]{4,6,2,6,9,2,6,77,99}));
    }

    /*
     * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
     * 
     * 请你计算并返回该式的最大值。
     */

    // 本题即是找出最大值和次大值
    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int secMax = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if(nums[i]>max){
                secMax = max;
                max = nums[i];
            } else if(nums[i]>secMax){
                secMax = nums[i];
            }
        }
        return (max - 1) * (secMax - 1);
    }

    public static int ways2(int[] nums){
        Arrays.sort(nums);
        return (nums[nums.length -1]-1) * (nums[nums.length-2] -1);
    }
}
