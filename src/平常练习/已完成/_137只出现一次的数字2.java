package 平常练习.已完成;

import java.util.Arrays;

public class _137只出现一次的数字2 {
    public static void main(String[] args) {

    }

    /*
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     */
    public static int singleNumber(int[] nums) {

        int len = nums.length;
        if (len == 1)
            return nums[0];
        Arrays.sort(nums);
        //最后一个与前一个不等肯定是只出现了一次的元素
        if (nums[len - 1] != nums[len - 2]) {
            return nums[nums.length - 1];
        }
        for (int i = 0; i < len - 3; i++) {
            //如果三个数相等，就去查找下一个三个数
            if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
                i += 2;
            } else
                return nums[i];
        }
        return -1;
    }
}
