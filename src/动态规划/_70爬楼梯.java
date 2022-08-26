package 动态规划;

public class _70爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs(8));
        System.out.println(ways1(8));
    }

    /*
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     */
    //动态规划
    public static int climbStairs(int n) {
        //dp[i] 代表到n阶台阶有多少种走法
        int[] dp =new int[n];
        dp[0]=1;
        dp[1]=2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    //暴力破解
    public static int ways1(int n) {
        if (n == 2)
            return 2;
        if (n == 1)
            return 1;
        return process1(n, 0);
    }

    public static int process1(int n, int index) {
        if (index >= n-1) {
            return 1;
        }
        return process1(n, index + 1) + process1(n, index + 2);
    }
}
