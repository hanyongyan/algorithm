package 平常练习.已完成;

import java.util.HashMap;
import java.util.Map;

public class _1两数之和 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < res.length; i++) {
            int temp = target - nums[i];
            // 如果 map 中含有 temp，说明找到了
            if(map.containsKey(temp)){
                res[0] = i;
                res[1] = map.get(temp);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
