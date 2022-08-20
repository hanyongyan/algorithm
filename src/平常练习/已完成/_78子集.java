package 平常练习.已完成;

import java.util.ArrayList;
import java.util.List;

public class _78子集 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[] { 1, 2, 3 }));
    }

    /*
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     */

    public static List<List<Integer>> res = new ArrayList<>();
    public static List<Integer> tempList = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        process(nums, 0);
        return res;
    }

    public static void process(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        //只有两种状态，当前位置要，当前位置不要
        //当前位置要
        tempList.add(nums[index]);
        process(nums, index+1);
        //去除当前位置的元素，不要此位置的数据
        tempList.remove(tempList.size()-1);
        process(nums, index+1);
    }
}
