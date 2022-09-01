package 平常练习.已完成;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.IntegerSyntax;

public class _397整数替换 {
    public static void main(String[] args) {
        System.out.println(process(21474838,0));    }

    /*
     * 给定一个正整数 n ，你可以做如下操作：
     * 
     * 如果 n 是偶数，则用 n / 2替换 n 。
     * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
     * 返回 n 变为 1 所需的 最小替换次数 。
     * 
     */
    public static int integerReplacement(int n) {
        //当n==Integer.MAX_VALUE n+1会溢出
        if(n==Integer.MAX_VALUE){
            return process(n-1, 0);
        }
        return process(n, 0);

    }

    public static int process(int n, int step) {
        if (n == 1) {
            return step;
        }

        int res = 0;
        //如果是偶数依赖 n/2
        if (n % 2 == 0) {
            res += process(n / 2, step + 1);
        } 
        //如果是奇数依赖 Math.min(n+1)
        else {
            res += Math.min(process(n + 1, step + 1), process(n - 1, step + 1));
        }
        return res;
    }

}
