package 平常练习.已完成;

import java.util.Arrays;

public class _260只出现一次的数字3 {
    public static void main(String[] args) {
        int[] a = singleNumber(new int[] { -1, 0 });
        System.out.println(a[0] + "  " + a[1]);
    }

    /*
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
     */
    public static int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int index = 0;
        Arrays.sort(nums);
        // 如果最后一个与倒数第二个不相等，那么最后一个肯定只出现了一次
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            res[1] = nums[nums.length - 1];

        }
        for (int i = 0; i < nums.length - 1; i++) {
            // 如果当前的与下一个相等，i一次就加二
            if (nums[i] == nums[i + 1]) {
                i++;
            }
            // 不相等的情况i只加一个，并且说明当前元素只有一个，添加进去
            else {
                res[index] = nums[i];
                index++;
            }
        }
        return res;
    }
}
