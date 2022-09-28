package 平常练习.已完成;

import java.sql.Time;

public class _167两数之和2 {
    public static void main(String[] args) {

    }

    // 暴力解法
    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int[] res = new int[2];
        // 数组中的每一个数当作一个基数，然后从后面的数字中看是否能够找到一个值相加等于 target
        for (int i = 0; i < len - 1; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (numbers[i] + numbers[mid] == target) {
                    res[0] = i + 1;
                    res[1] = mid + 1;
                    return res;
                } else if (numbers[i] + numbers[mid] > target) {
                    right = mid - 1;
                } else if (numbers[i] + numbers[mid] < target) {
                    left = mid + 1;
                }

            }
        }
        return res;
    }

    // 使用双指针
    public static int[] ways2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum > target){
                right -- ;
            }else if (sum < target){
                left++;
            }
        }
        return new int[]{-1,-1};
    }
}
