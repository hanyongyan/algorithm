package 平常练习.已完成;

public class _134加油站 {
    public static void main(String[] args) {
        int res = canCompleteCircuit(new int[]{1,4,3,4,5}, new int[]{3,1,5,1,7});
        System.out.println(res);
    }

    /*
     * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int cursum = 0;                  //cursum表示当前油箱的剩余量
        int sum = 0;                     //sum代表最后油箱的剩余量   
        int start = 0;
        for(int i = 0; i < gas.length; i++) {
            cursum += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            //当 cursum < 0 时代表从start位置出发到当前位置时油是不够的，所以是不可行的，所以重置cursum和start
            if(cursum < 0) {
                start = i+1;
                cursum = 0;
            }
        }
        //sum代表了油箱的剩余量，如果sum>=0，说明可以一圈行驶完
        if(sum < 0) return -1;
        return start;

    }
}