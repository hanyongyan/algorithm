package 平常练习.已完成;

import javax.xml.transform.Templates;

public class _33搜索旋转排序数组 {
    public static void main(String[] args) {
        System.out.println(process(new int[] { 3, 1 }, 1));
    }

    /*
     * 将数组一分为二，其中一个一定是有序的，另一个可能是有序，也可能是部分有序
     * 此时有序部分用二分法查找，无需部分再一分为二，其中一个一定有序，另一个可能有序，可能无序，就这样循环
     */

    public static int search(int[] nums, int target) {
        int n = nums.length;

        // 简单情况
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        // left左边界，right右边界
        int left = 0, right = n - 1;
        while (left <= right) {
            // 二分查找
            int mid = (left + right) / 2;
            // 终止条件
            if (nums[mid] == target) {
                return mid;
            }
            // 说明是一个有序空间
            if (nums[0] <= nums[mid]) {
                // 判断是否在有序空间内，如果有继续在有序空间内查找
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                // 不在有序空间内，去无序中去查找
                else {
                    left = mid + 1;
                }
            }
            // 同if的判断
            else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int process(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 如果 0...mid 是一个有序的
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 如果 0...mid 不是有序的 则 mid...后面肯定是有序的
            else {
                if (target > nums[mid] && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int process2(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1, mid = 0;
        
        return -1;
    }
}