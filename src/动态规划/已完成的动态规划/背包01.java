package 动态规划.已完成的动态规划;

public class 背包01 {
    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7};
        int[] values = {5, 6, 3, 19};
        int bag = 11;
        System.out.println(way(weights,values,bag));
        System.out.println(dp(weights,values,bag));
    }

    //w重量数组，v价值数组，bag背包容量
    public static int way(int[] w,int[] v,int bag){
        return process(w, v, bag, 0);
    }

    //w重量数组，v价值数组，rest背包剩余容量，index当前货物所在位置
    public static int process(int[] w,int[] v,int rest, int index){
        if (index == w.length) {
            return 0;
        }

        //当前货物不要的情况
        int p1 = process(w, v, rest, index + 1);
        //要当前货物的情况
        int p2=0;
        //查看背包是否还有容量
        if (rest - w[index]>0) {
            p2 = v[index] + process(w, v, rest - w[index], index + 1);
        }

        return Math.max(p1, p2);
    }
    //对应动态规划版本
    //这个动态规划相当于是从第一个货物开始取后面的值，由最后一行的值已知所以从后往前
    public static int dp(int[] w,int[] v,int bag){
        int N = w.length;
        //由暴力递推可知，可以造成一个二维表，行代表当前货物，列代表剩余容量
        int[][] dp = new int[N + 1][bag + 1];
        //由暴力递推易知当前货物的状态等由上一个货物的来
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                //当前货物不要
                int p1 = dp[index + 1][rest];
                //当前货物要,判断是否有剩余空间，如果没有赋值为-1，
                int p2 = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]] + v[index];
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }
}
