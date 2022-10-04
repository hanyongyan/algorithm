package 平常练习.已完成;

public class _1351统计有序矩阵中的负数 {
    public static void main(String[] args) {

    }

    public static int countNegatives(int[][] grid) {
        int res = 0;
        for (int[] is : grid) {
            for (int is2 : is) {
                if (is2 < 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static int process(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int count = 0;
        // 从右上角开始遍历
        for (int i = 0, j = n - 1; i < m && j >= 0;) {
            // 如果当前位置大于0 那么跳过这一行，如果后面的是负数肯定会由前面的循环来进行了计数
            if (grid[i][j] >= 0) {
                i++;
            }
            // 如果当前位置小于0 当前位置的下面肯定都是小于 0 的 来进行计数
             else {
                count += m - i;
                j--;
            }
        }

        return count;
    }
}
