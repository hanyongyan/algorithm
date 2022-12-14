package 每日一题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 字符串轮转 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[] { 1,5,2,4,1 }));
    }

    public static int minOperations(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] <= nums[i - 1]) {
                sum += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return sum;
    }
}
