package 贪心.已完成;

import java.util.Arrays;

public class _561数组拆分 {
    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{6,2,6,5,1,2}));
    }

    /*
     * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn)
     * ，使得从 1 到 n 的 min(ai, bi) 总和最大。
     * 
     * 返回该 最大总和 。
     * 
     */
    public static int arrayPairSum(int[] nums) {
        int len =nums.length;
        Arrays.sort(nums);
        int res= 0;
        for (int i = 0; i < len; i+=2) {
            res+=nums[i];
        }
        return res;
    }
}
