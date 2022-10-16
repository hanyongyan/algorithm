package 平常练习.已完成;

import java.util.Arrays;

public class _611有效的三角形的个数 {
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[] { 2, 2, 3, 4 }));
    }

    public static int triangleNumber(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        // 完成一个升序排序
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int left = j + 1, right = len - 1, k = j;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    // i and j 代表前两个边 如果这两个边之和大于 第三遍 说明是符合规则的
                    if (nums[i] + nums[j] > nums[mid]) {
                        // 记录下当前符合规则的位置
                        k = mid;
                        left = mid + 1;
                    } else {
                        // 说明当前并不复合三角形 两边之和大于第三边的规则
                        // 此时的 mid 取值过大 所以 right 减小
                        right = mid - 1;
                    }
                }
                res += k - j;
            }
        }
        return res;
    }
}