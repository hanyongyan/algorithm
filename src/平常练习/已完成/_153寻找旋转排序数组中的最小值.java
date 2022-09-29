package 平常练习.已完成;

public class _153寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }

    // 使用二分解法
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        // 这是没有旋转的情况
        if (nums[left] < nums[right]) {
            return nums[0];
        }
        // 下面是旋转后的情况
        while (left < right) {
            mid = (left + right) / 2;

            // 当 nums[mid] > nums[left] 此时 left 值 是过小的，因为 最小值在 mid 后面
            if (nums[mid] > nums[left]) {
                left = mid ;
            }
            // 当 nums[mid] < nums[right] 此时 right 值 是过大的，因为最小值 在 mid 前面
             else if (nums[mid] < nums[right]) {
                right = mid ;
            } 
            // 运行到 此步时 会有两种情况 left == right 或者 left == right - 1
            // 由题意知我们应该返回 nums[right]
            else return nums[right];
        }

        // 防止数组的长度为 1 的情况
        return nums[left];
    }

    // 最简单的解法
    public static int process(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }
}
