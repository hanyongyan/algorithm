package 动态规划;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class _646最长数对链 {
    public static void main(String[] args) {
        System.out.println(findLongestChain(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } }));
    }
    /*
     * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
     * 
     * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
     * 
     * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
     */

    public static int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        // dp[i] 代表 0...i 的最长数对链
        int[] dp = new int[len];
        // dp[i] 的默认情况就是他自己即为1
        Arrays.fill(dp, 1);
        // 查看pairs数组中i位置前面最长数对链
        for (int i = 1; i < dp.length; i++) {
            // 遍历 i 前面的数对链
            for (int j = 0; j < i; j++) {
                //找到了数对链
                if (pairs[i][0] > pairs[j][1]) {
                    
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }
}
