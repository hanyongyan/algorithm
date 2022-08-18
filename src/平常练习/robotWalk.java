package 平常练习;

public class robotWalk {
    public static void main(String[] args) {

    }

    public static int ways(int N, int cur, int rest, int p) {
        int[][] dp = new int[N + 1][p + 1];
        return process(N, cur, rest, p, dp);
    }

    //i代表当前转换到的位置
    public static int process(int N, int cur, int rest, int p, int[][] dp) {
        if (rest == 0) {
            dp[cur][rest] = cur == p ? 1 : 0;
            return dp[cur][rest];
        }

        if (cur == 1) {
            dp[cur][rest] =  process(N, 2, rest - 1, p, dp);
            return dp[cur][rest];
        }
        if (cur == N) {
            dp[cur][rest] = process(N, N - 1, rest - 1, p, dp);
            return dp[cur][rest];
        }
       dp[cur][rest] = process(N, cur - 1, rest - 1, p, dp)+process(N, cur + 1, rest - 1, p, dp);
        return  dp[cur][rest];
    }
}
