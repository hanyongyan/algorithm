package 平常练习.已完成;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90子集2 {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] { 1, 2, 2, 3 }));
    }

    /*
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * 
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     */

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        process(nums, 0, res, tempList);
        return res;
    }

    public static void process(int[] nums, int index, List<List<Integer>> res, List<Integer> tempList) {
        if (index == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        // 要当前的数
        tempList.add(nums[index]);
        process(nums, index + 1, res, tempList);
        tempList.remove(tempList.size() - 1);
        //去重操作
        while(index<nums.length-1&&nums[index]==nums[index+1]){
            index++;
        }
        // 不要当前的数
        process(nums, index + 1, res, tempList);
    }
}
