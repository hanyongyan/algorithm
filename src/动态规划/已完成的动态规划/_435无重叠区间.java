package 动态规划.已完成的动态规划;

import java.util.Arrays;

public class _435无重叠区间 {
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } ,{1,3}}));
    }

    /*
     * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回
     * 需要移除区间的最小数量，使剩余区间互不重叠 。
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        // 对二维数组进行排序,按照 intervals[i][0] 进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // dp[i] 代表 0...i 的最长数对链
        int[] dp = new int[len];
        // dp[i] 的默认情况就是他自己即为1
        Arrays.fill(dp, 1);
        // 查看intervals数组中i位置前面最长数对链
        for (int i = 1; i < dp.length; i++) {
            // 遍历 i 前面的数对链
            for (int j = 0; j < i; j++) {
                // 找到了数对链
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 结果就是数组的长度减去最长数对链
        return len - dp[len - 1];
    }
}
