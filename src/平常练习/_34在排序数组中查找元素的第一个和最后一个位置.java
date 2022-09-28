package 平常练习;

public class _34在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {

    }

    /*
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * 
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] res = { -1, -1 };
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            // 当 nums[mid] == target 时，去依次判断最左边的位置 和 最右边的位置
            if (nums[mid] == target) {
                int tempMid = mid;
                while (tempMid >= 0) {
                    if (nums[tempMid] == target) {
                        tempMid--;
                    } else
                        break;
                }
                while (mid <= len - 1) {
                    if (nums[mid] == target) {
                        mid++;
                    } else
                        break;
                }
                res[0] = tempMid+1;
                res[1] = mid-1;
                return res;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
                
            }
        }
        return res;
    }

}
// 5 7 8 8 8 9