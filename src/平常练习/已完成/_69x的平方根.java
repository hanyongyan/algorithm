package 平常练习.已完成;

public class _69x的平方根 {
    public static void main(String[] args) {

    }

    /*
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * 
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     */
    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        int mid = 0;
        int ans = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            // 本题的题解主要是找到一个数的平方小于等于 x 且 最接近 x 的一个数
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

}
