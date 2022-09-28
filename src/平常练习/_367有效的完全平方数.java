package 平常练习;

public class _367有效的完全平方数 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(1));
    }

    /*
     * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
     * 
     * 进阶：不要 使用任何内置的库函数，如  sqrt 。
     */
    public static boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num ;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid * mid < num) {
                left = mid + 1;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else if(mid * mid == num){
                return true;
            }
        }
        return false;
    }
}
