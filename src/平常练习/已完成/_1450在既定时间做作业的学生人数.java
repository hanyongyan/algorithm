package 平常练习.已完成;

public class _1450在既定时间做作业的学生人数 {
    public static void main(String[] args) {
        System.out.println(busyStudent(new int[] { 3 }, new int[] { 4 }, 4));
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        int len = startTime.length;
        for (int i = 0; i < len; i++) {
            // 开始的时间必须小于指定查询时间，结束时间必须大于指定查询时间
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                ans++;
            }
        }
        return ans;
    }
}