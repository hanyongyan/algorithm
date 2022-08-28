package 平常练习.已完成;

public class _162寻找峰值 {
    public static void main(String[] args) {
System.out.println(findPeakElement(new int[]{1}));
    }

    /*
     * 峰值元素是指其值严格大于左右相邻值的元素。
     * 
     * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     * 
     * 你可以假设 nums[-1] = nums[n] = -∞ 。
     * 
     * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
     */



    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            //由于我们是找到的第一个当前位置大于下一个位置的所以可以直接返回
            //前面的情况必然是 nums[i - 1] < nums[i]
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        //执行到此步说明整个数组是升序排列，所以返回最后一个的值
        return len - 1;
    }
}
