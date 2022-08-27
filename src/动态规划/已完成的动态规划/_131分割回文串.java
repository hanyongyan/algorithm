package 动态规划.已完成的动态规划;

import java.util.ArrayList;
import java.util.List;

public class _131分割回文串 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    /*
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     * 
     * 回文串 是正着读和反着读都一样的字符串。
     */
    public static List<List<String>> res = new ArrayList<>();
    public static List<String> tempList = new ArrayList<>();
    public static boolean[][] dp;

    // i...j是否为回文串 s.charAt(i) == s.charAt(j) && dp[i+1][j-1]
    public static List<List<String>> partition(String s) {

        int len = s.length();
        dp = new boolean[len][len];
        // 对角线都是回文串
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        // 对角线上面的一列，由s.charAt(i) == s.charAt(j) && dp[i+1][j-1] 而得出这一列必须设置
        for (int i = 0; i < dp.length - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }

        // 把所有的回文串找到
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        dfs(s, 0);
        return res;
    }

    public static void dfs(String s, int i) {
        if (i == s.length()) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int j = i; j < dp.length; j++) {
            if (dp[i][j]) {
                tempList.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
