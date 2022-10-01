package 平常练习.已完成;

public class _1351统计有序矩阵中的负数 {
    public static void main(String[] args) {
        
    }

    public static int countNegatives(int[][] grid) {
        int res = 0;
        for (int[] is : grid) {
            for (int is2 : is) {
                if(is2<0){
                    res++;
                }
            }
        }
        return res;
    }
}
