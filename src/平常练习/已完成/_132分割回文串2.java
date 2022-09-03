package 平常练习.已完成;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _132分割回文串2 {
    public static void main(String[] args) {
        System.out.println(minCut("leet"));
    }

    /*
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
     * 
     * 返回符合要求的 最少分割次数 。
     */
    public static int minCut(String s) {
        int len = s.length();
        // dp[i][j] 代表 i...j 是否为回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        // f[i] 代表前i个字符串最小的分割次数
        int[] f = new int[len];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < len; ++i) {
            // 满足回文 不需要分割
            if (dp[0][i]) {
                f[i] = 0;
            }
            // 不满足回文 需要分割
            // 当 0...i 不是回文串时 0...i-1 肯定是回文串，所以下面 f[i] 进行赋值
            else {
                for (int j = 0; j < i; ++j) {
                    // 要想得出 f[i] 的值，我们可以考虑枚举 s[0..i] 分割出的最后一个回文串
                    // 因为已知 0...i 不是回文 所以先判断 1...i 是不是回文
                    // 当dp[j+1][i]是回文时，有两种情况
                    // dp[0][j]是回文 此时的情况就是0+1
                    // dp[0][j]不是回文 此时的情况就是 f[j]+1 f[j]代表f[j]的分割次数所以直接加一即可
                    if (dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[len - 1];
    }
}
