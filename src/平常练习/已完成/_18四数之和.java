package 平常练习.已完成;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18四数之和 {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = fourSum(nums, 0);
        System.out.println(lists);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return list;
        }
        //从小到大对数组进行排序
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            //防止重复计算
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                return list;
            }
            for (int j = i + 1; j < len - 2; j++) {
                //防止重复计算
                if (nums[j] == nums[j + 1]) {
                    continue;
                }

                int left = j + 1;
                int right = len - 1;

                while (left < right) {
                    if ((long) nums[i] + nums[j] + nums[left] + nums[left + 1] > target) {
                        return list;
                    }
                    if ((long) nums[i] + nums[j] + nums[right] + nums[right - 1] < target) {
                        return list;
                    }
                    if (nums[left] == nums[left + 1]) {
                        left++;
                    }
                    if (nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //找到就添加
                    if ((long) nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        list.add(new ArrayList<>(List.of(nums[i], nums[j], nums[left], nums[right])));
                        left++;
                        right--;
                    }
                    if ((long) nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    }
                    if ((long) nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    }
                }
            }
        }


        return list;
    }

}
