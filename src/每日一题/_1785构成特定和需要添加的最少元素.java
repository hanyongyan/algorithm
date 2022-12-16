package 每日一题;

public class _1785构成特定和需要添加的最少元素 {
    public static void main(String[] args) {
        System.out.println(minElements(new int[] { 1, -10, 9, 1 }, 100, 0));
    }

    public static int minElements(int[] nums, int limit, int goal) {
        // 先求出数组的和
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        long res = 0;
        // 此处的 res 代表能够完整的使用 limit 多少次
        res = Math.abs(sum - goal) / limit;
        // 如果两者之差对limit的求余不等于0，说明还需要再用一个数
        if ((sum - goal) % limit != 0) {
            res++;
        }
        return (int) res;
    }
}
