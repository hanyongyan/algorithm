package 平常练习.已完成;

public class _74搜索二维矩阵 {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] { { 1 }, { 3 }, { 5 } }, 5));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = matrix[i][0];
        }
        int row = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (target >= a[i] && target < a[i + 1]) {
                row = i;
                break;
            }
        }
        if (target >= matrix[len - 1][0] && target <= matrix[len - 1][matrix[0].length - 1]) {
            row = len - 1;
        }
        for (int i = 0; i < matrix[row].length; i++) {
            if (target == matrix[row][i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean process(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[matrix.length - 1].length;
        // 过滤条件
        if (target > matrix[m - 1][n - 1] || target < matrix[0][0])
            return false;
        int i = 0;
        // 如果大于当前行的最大值 就去找下一行
        while (i < m && target > matrix[i][n - 1]) {
            i++;
        }
        for (int j = 0; j < n; j++) {
            if (target == matrix[i][j])
                return true;
        }
        return false;
    }

    public static boolean process2(int[][] matrix, int target) {
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        for (int i = 0; i < len1; i++) {
            // 如果大于当前行的最后一个就去下一行找
            if (target > matrix[i][len2 - 1]) {
                continue;
            }
            // 如果不大于当前行的最后一个，说明肯定在当前行 
            else {
                for (int j = 0; j < len2; j++) {
                    // 如果在当前行找到了目标值就返回 true
                    if(target == matrix[i][j]){
                        return true;
                    }
                }
                // 当前行内没有目标值 后面的也不会有目标值
                return false;
            }
        }
        return false;
    }
}