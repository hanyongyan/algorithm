package 平常练习.已完成;

public class _97交错字符串 {
    public static void main(String[] args) {

    }

    /*
     * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
     * 
     * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
     */
    // 使用动态规划，
    public static boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();
        if (n + m != k) {
            return false;
        }
        //dp[i][j] 代表s1的前i个元素和s2的前j个元素是否能交错组成s3的前i+j个元素。
        //如果s1的第i个元素和s3的i+j个元素相等，
        //那么s1的前i个元素和s2的前j个元素能否交错组成s3的前i+j个元素取决于s1的前i-1个元素和s2的前j个元素能否交错成s3的前i+j-1个元素，
        //即dp[i][j]取决于dp[i-1][j]和dp[i][j-1]
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return dp[n][m];
    }
}
