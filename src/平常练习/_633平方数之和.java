package 平常练习;

public class _633平方数之和 {
    public static void main(String[] args) {
        
    }
    public static boolean judgeSquareSum(int c) {
        long left = 0;
        // right 的 平方 等于 c 
        // 可知 两个数的平方和等于 c 时 两个数 肯定都小于(long) Math.sqrt(c);
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
