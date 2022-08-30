package 平常练习.已完成;

public class _263丑数 {
    public static void main(String[] args) {

    }

    /*
     * 丑数 就是只包含质因数 2、3 和 5 的正整数。
     * 
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     */
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = { 2, 3, 5 };
        for (int factor : factors) {
            //相当于一直进行除以2，3，5
            while (n % factor == 0) {
                n /= factor;
            }
        }
        //如果最后的结果为1就说明是丑数
        return n == 1;
    }
}
