package 平常练习.已完成;

public class _238除自身以外数组的乘积 {
    public static void main(String[] args) {
        int[] res = productExceptSelf(new int[] { 1, 2, 3, 4 });
        for (int i : res) {
            System.out.print(i + " ");
        }

    }

    /*
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * 
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * 
     * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     */
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        // L[i] 代表当前位置的左侧的所有乘积
        int[] L = new int[len];
        // R[i] 代表当前位置的右侧的所有乘积
        int[] R = new int[len];
        L[0] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        R[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = R[i] * L[i];
        }
        return res;
    }

}