package 平常练习;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1636按照频率将数组升序排序 {
    public static void main(String[] args) {

    }

    /*
     * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
     * 
     * 请你返回排序后的数组。
     */
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        // 先对出现的频率进行计数
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer num : nums) {
            list.add(num);
        }
        // 对list进行排序
        // 当两者的频率不同时 谁的频率大谁放在前面
        // 当两者的频率相等时 谁的值大谁放在前面
        Collections.sort(list, (a, b) -> {
            int num1 = map.get(a);
            int num2 = map.get(b);
            return num1 != num2 ? num1 - num2 : b - a;
        });
        int len = nums.length;
        for(int i= 0;i<len ;i++){
            nums[i]= list.get(i);
        }
        return nums;
    }
}
